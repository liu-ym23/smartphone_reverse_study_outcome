package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    public interface SupportParentable {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context r5) {
        this.mIntents = new ArrayList();
        this.mSourceContext = r5;
    }

    @NonNull
    public static TaskStackBuilder create(@NonNull Context r5) {
        return new TaskStackBuilder(r5);
    }

    @Deprecated
    public static TaskStackBuilder from(Context r5) {
        return create(r5);
    }

    @NonNull
    public TaskStackBuilder addNextIntent(@NonNull Intent r5) {
        this.mIntents.add(r5);
        return this;
    }

    @NonNull
    public TaskStackBuilder addNextIntentWithParentStack(@NonNull Intent r5) {
        ComponentName r10 = r5.getComponent();
        if (r10 != null) goto L5;
        r10 = r5.resolveActivity(this.mSourceContext.getPackageManager());
    L5:
        if (r10 == null) goto L7;
        addParentStack(r10);
    L7:
        addNextIntent(r5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Activity r5) {
        if ((r5 instanceof SupportParentable) == false) goto L5;
        Intent r10 = ((SupportParentable) r5).getSupportParentActivityIntent();
    L6:
        if (r10 != null) goto L8;
        r10 = NavUtils.getParentActivityIntent(r5);
    L8:
        if (r10 == null) goto L13;
        ComponentName r11 = r10.getComponent();
        if (r11 != null) goto L12;
        r11 = r10.resolveActivity(this.mSourceContext.getPackageManager());
    L12:
        addParentStack(r11);
        addNextIntent(r10);
    L13:
        return this;
    L5:
        r10 = null;
        goto L6
    }

    @Nullable
    public Intent editIntentAt(int r5) {
        return this.mIntents.get(r5);
    }

    @Deprecated
    public Intent getIntent(int r5) {
        return editIntentAt(r5);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    @NonNull
    public Intent[] getIntents() {
        int r5 = this.mIntents.size();
        Intent[] r10 = new Intent[r5];
        if (r5 != 0) goto L5;
        return r10;
    L5:
        r10[0] = new Intent(this.mIntents.get(0)).addFlags(268484608);
        int r11 = 1;
    L6:
        if (r11 >= r5) goto L8;
        r10[r11] = new Intent(this.mIntents.get(r11));
        r11 = r11 + 1;
        goto L6
    L8:
        return r10;
    }

    @Nullable
    public PendingIntent getPendingIntent(int r5, int r10) {
        return getPendingIntent(r5, r10, null);
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

    @Nullable
    public PendingIntent getPendingIntent(int r5, int r10, @Nullable Bundle r11) {
        if (this.mIntents.isEmpty() == true) goto L7;
        Intent[] r12 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r12[0] = new Intent(r12[0]).addFlags(268484608);
        return PendingIntent.getActivities(this.mSourceContext, r5, r12, r10, r11);
    L7:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public void startActivities(@Nullable Bundle r5) {
        if (this.mIntents.isEmpty() == true) goto L9;
        Intent[] r10 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r10[0] = new Intent(r10[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.mSourceContext, r10, r5) == true) goto L10;
        Intent r11 = new Intent(r10[r10.length - 1]);
        r11.addFlags(268435456);
        this.mSourceContext.startActivity(r11);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull Class<?> r5) {
        return addParentStack(new ComponentName(this.mSourceContext, r5));
    }

    @NonNull
    public TaskStackBuilder addParentStack(@NonNull ComponentName r5) {
        int r10 = this.mIntents.size();
        Intent r11 = NavUtils.getParentActivityIntent(this.mSourceContext, r5);     // Catch: PackageManager.NameNotFoundException -> L7
    L4:
        if (r11 == null) goto L9;
        this.mIntents.add(r10, r11);     // Catch: PackageManager.NameNotFoundException -> L7
        r11 = NavUtils.getParentActivityIntent(this.mSourceContext, r11.getComponent());     // Catch: PackageManager.NameNotFoundException -> L7
        goto L4
    L9:
        return this;
    L7:
        e = move-exception;
        Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }
}
