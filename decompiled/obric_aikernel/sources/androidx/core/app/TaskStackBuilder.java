package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static PendingIntent getActivities(Context r10, int r11, Intent[] r12, int r13, Bundle r14) {
            return PendingIntent.getActivities(r10, r11, r12, r13, r14);
        }
    }

    public interface SupportParentable {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context r10) {
        this.mIntents = new ArrayList();
        this.mSourceContext = r10;
    }

    @NonNull
    public static TaskStackBuilder create(@NonNull Context r10) {
        return new TaskStackBuilder(r10);
    }

    @Deprecated
    public static TaskStackBuilder from(Context r10) {
        return create(r10);
    }

    @NonNull
    public TaskStackBuilder addNextIntent(@NonNull Intent r10) {
        this.mIntents.add(r10);
        return this;
    }

    @NonNull
    public TaskStackBuilder addNextIntentWithParentStack(@NonNull Intent r10) {
        ComponentName r11 = r10.getComponent();
        if (r11 != null) goto L5;
        r11 = r10.resolveActivity(this.mSourceContext.getPackageManager());
    L5:
        if (r11 == null) goto L7;
        addParentStack(r11);
    L7:
        addNextIntent(r10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Activity r10) {
        if ((r10 instanceof SupportParentable) == false) goto L5;
        Intent r11 = ((SupportParentable) r10).getSupportParentActivityIntent();
    L6:
        if (r11 != null) goto L8;
        r11 = NavUtils.getParentActivityIntent(r10);
    L8:
        if (r11 == null) goto L13;
        ComponentName r12 = r11.getComponent();
        if (r12 != null) goto L12;
        r12 = r11.resolveActivity(this.mSourceContext.getPackageManager());
    L12:
        addParentStack(r12);
        addNextIntent(r11);
    L13:
        return this;
    L5:
        r11 = null;
        goto L6
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull ComponentName r10) {
        int r11 = this.mIntents.size();
        Context r12 = this.mSourceContext;     // Catch: PackageManager.NameNotFoundException -> L9
    L4:
        Intent r13 = NavUtils.getParentActivityIntent(r12, r10);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r13 == null) goto L8;
        this.mIntents.add(r11, r13);     // Catch: PackageManager.NameNotFoundException -> L9
        r12 = this.mSourceContext;     // Catch: PackageManager.NameNotFoundException -> L9
        r10 = r13.getComponent();     // Catch: PackageManager.NameNotFoundException -> L9
        goto L4
    L8:
        return this;
    L9:
        e = move-exception;
        Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Class<?> r10) {
        return addParentStack(new ComponentName(this.mSourceContext, r10));
    }

    @Nullable
    public Intent editIntentAt(int r10) {
        return this.mIntents.get(r10);
    }

    @Deprecated
    public Intent getIntent(int r10) {
        return editIntentAt(r10);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    @NonNull
    public Intent[] getIntents() {
        int r10 = this.mIntents.size();
        Intent[] r11 = new Intent[r10];
        if (r10 != 0) goto L5;
        return r11;
    L5:
        r11[0] = new Intent(this.mIntents.get(0)).addFlags(268484608);
        int r12 = 1;
    L6:
        if (r12 >= r10) goto L8;
        r11[r12] = new Intent(this.mIntents.get(r12));
        r12 = r12 + 1;
        goto L6
    L8:
        return r11;
    }

    @Nullable
    public PendingIntent getPendingIntent(int r10, int r11) {
        return getPendingIntent(r10, r11, null);
    }

    @Nullable
    public PendingIntent getPendingIntent(int r10, int r11, @Nullable Bundle r12) {
        if (this.mIntents.isEmpty() == true) goto L11;
        Intent[] r13 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r13[0] = new Intent(r13[0]).addFlags(268484608);
        int r14 = Build.VERSION.SDK_INT;
        Context r15 = this.mSourceContext;
        if (r14 < 16) goto L9;
        return Api16Impl.getActivities(r15, r10, r13, r11, r12);
    L9:
        return PendingIntent.getActivities(r15, r10, r13, r11);
    L11:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    @Override // java.lang.Iterable
    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(@Nullable Bundle r10) {
        if (this.mIntents.isEmpty() == true) goto L9;
        Intent[] r11 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r11[0] = new Intent(r11[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.mSourceContext, r11, r10) == true) goto L10;
        Intent r12 = new Intent(r11[r11.length - 1]);
        r12.addFlags(268435456);
        this.mSourceContext.startActivity(r12);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
