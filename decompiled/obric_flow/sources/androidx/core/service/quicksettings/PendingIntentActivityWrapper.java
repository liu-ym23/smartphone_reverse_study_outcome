package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.PendingIntentCompat;

/* JADX INFO: loaded from: classes.dex */
public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;

    @NonNull
    private final Intent mIntent;
    private final boolean mIsMutable;

    @Nullable
    private final Bundle mOptions;

    @Nullable
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    public PendingIntentActivityWrapper(@NonNull Context r10, int r11, @NonNull Intent r12, int r13, boolean r14) {
        this(r10, r11, r12, r13, null, r14);
    }

    @Nullable
    private PendingIntent createPendingIntent() {
        Bundle r5 = this.mOptions;
        if (r5 != null) goto L7;
        return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, this.mIsMutable);
    L7:
        return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, r5, this.mIsMutable);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntent;
    }

    @NonNull
    public Bundle getOptions() {
        return this.mOptions;
    }

    @Nullable
    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }

    public PendingIntentActivityWrapper(@NonNull Context r5, int r10, @NonNull Intent r11, int r12, @Nullable Bundle r13, boolean r14) {
        this.mContext = r5;
        this.mRequestCode = r10;
        this.mIntent = r11;
        this.mFlags = r12;
        this.mOptions = r13;
        this.mIsMutable = r14;
        this.mPendingIntent = createPendingIntent();
    }
}
