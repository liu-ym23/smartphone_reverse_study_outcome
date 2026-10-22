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
import androidx.core.content.ContextCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    static class Api16Impl {
        private Api16Impl() {
        }

        static PendingIntent getActivities(Context r2, int r3, Intent[] r4, int r5, Bundle r6) {
            return PendingIntent.getActivities((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mIntents = new ArrayList();
        this.mSourceContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    public static TaskStackBuilder create(Context r2) {
        return new TaskStackBuilder((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public static TaskStackBuilder from(Context r2) {
        return create((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public TaskStackBuilder addNextIntent(Intent r2) {
        this.mIntents.add(r2);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent r2) {
        ComponentName r0 = r2.getComponent();
        if (r0 != null) goto L5;
        r0 = r2.resolveActivity(this.mSourceContext.getPackageManager());
    L5:
        if (r0 == null) goto L7;
        addParentStack(r0);
    L7:
        addNextIntent(r2);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportParentable.class) == false) goto L5;
        Intent r0 = ((SupportParentable) ZeusTransformUtils.preCheckCast(r4, SupportParentable.class, "com.obric.memorydata.plugin")).getSupportParentActivityIntent();
    L6:
        if (r0 != null) goto L8;
        r0 = NavUtils.getParentActivityIntent(r4);
    L8:
        if (r0 == null) goto L13;
        ComponentName r5 = r0.getComponent();
        if (r5 != null) goto L12;
        r5 = r0.resolveActivity(this.mSourceContext.getPackageManager());
    L12:
        addParentStack(r5);
        addNextIntent(r0);
    L13:
        return this;
    L5:
        r0 = null;
        goto L6
    }

    public TaskStackBuilder addParentStack(ComponentName r3) {
        int r0 = this.mIntents.size();
        Context r1 = this.mSourceContext;     // Catch: PackageManager.NameNotFoundException -> L9
    L4:
        Intent r4 = NavUtils.getParentActivityIntent(r1, r3);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r4 == null) goto L8;
        this.mIntents.add(r0, r4);     // Catch: PackageManager.NameNotFoundException -> L9
        r1 = this.mSourceContext;     // Catch: PackageManager.NameNotFoundException -> L9
        r3 = r4.getComponent();     // Catch: PackageManager.NameNotFoundException -> L9
        goto L4
    L8:
        return this;
    L9:
        e = move-exception;
        Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }

    public TaskStackBuilder addParentStack(Class<?> r3) {
        return addParentStack(new ComponentName(this.mSourceContext, r3));
    }

    public Intent editIntentAt(int r2) {
        return (Intent) ZeusTransformUtils.preCheckCast(this.mIntents.get(r2), Intent.class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public Intent getIntent(int r1) {
        return editIntentAt(r1);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        int r0 = this.mIntents.size();
        Intent[] r1 = new Intent[r0];
        if (r0 != 0) goto L5;
        return r1;
    L5:
        r1[0] = new Intent((Intent) ZeusTransformUtils.preCheckCast(this.mIntents.get(0), Intent.class, "com.obric.memorydata.plugin")).addFlags(268484608);
        int r2 = 1;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = new Intent((Intent) ZeusTransformUtils.preCheckCast(this.mIntents.get(r2), Intent.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }

    public PendingIntent getPendingIntent(int r2, int r3) {
        return getPendingIntent(r2, r3, null);
    }

    public PendingIntent getPendingIntent(int r5, int r6, Bundle r7) {
        if (this.mIntents.isEmpty() == true) goto L11;
        Intent[] r0 = (Intent[]) ZeusTransformUtils.preCheckCast(this.mIntents.toArray(new Intent[0]), Intent[].class, "com.obric.memorydata.plugin");
        r0[0] = new Intent(r0[0]).addFlags(268484608);
        int r1 = Build.VERSION.SDK_INT;
        Context r4 = this.mSourceContext;
        if (r1 < 16) goto L9;
        return Api16Impl.getActivities(r4, r5, r0, r6, r7);
    L9:
        return PendingIntent.getActivities(r4, r5, r0, r6);
    L11:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle r6) {
        if (this.mIntents.isEmpty() == true) goto L9;
        Intent[] r0 = (Intent[]) ZeusTransformUtils.preCheckCast(this.mIntents.toArray(new Intent[0]), Intent[].class, "com.obric.memorydata.plugin");
        r0[0] = new Intent(r0[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.mSourceContext, r0, r6) == true) goto L10;
        Intent r7 = new Intent(r0[r0.length - 1]);
        r7.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ZeusTransformUtils.startActivity(this.mSourceContext, r7, "com.obric.memorydata.plugin");
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
