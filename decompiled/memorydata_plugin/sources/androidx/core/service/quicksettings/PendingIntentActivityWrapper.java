package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;
    private final Intent mIntent;
    private final boolean mIsMutable;
    private final Bundle mOptions;
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    public PendingIntentActivityWrapper(Context r3, int r4, Intent r5, int r6, Bundle r7, boolean r8) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mRequestCode = r4;
        this.mIntent = r5;
        this.mFlags = r6;
        this.mOptions = r7;
        this.mIsMutable = r8;
        this.mPendingIntent = createPendingIntent();
    }

    public PendingIntentActivityWrapper(Context r8, int r9, Intent r10, int r11, boolean r12) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), r9, r10, r11, null, r12);
    }

    private PendingIntent createPendingIntent() {
        Bundle r4 = this.mOptions;
        Context r0 = this.mContext;
        int r1 = this.mRequestCode;
        Intent r2 = this.mIntent;
        int r3 = this.mFlags;
        if (r4 != null) goto L7;
        return PendingIntentCompat.getActivity(r0, r1, r2, r3, this.mIsMutable);
    L7:
        return PendingIntentCompat.getActivity(r0, r1, r2, r3, r4, this.mIsMutable);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public Bundle getOptions() {
        return this.mOptions;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }
}
