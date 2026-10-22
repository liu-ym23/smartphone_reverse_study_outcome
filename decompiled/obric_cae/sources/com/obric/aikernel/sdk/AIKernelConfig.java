package com.obric.aikernel.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import he.i;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class AIKernelConfig {
    public static final a Companion = null;
    private static final String TAG = "AIKernelConfig";
    private boolean authBySign;
    private ExtraAppInfo extraBindInfo;
    private Long mAppId;
    private Context mContext;
    private String mPackageName;

    @Keep
    public static final class Builder {
        private Long appId;
        private boolean authBySign;
        private ExtraAppInfo extraBindInfo;
        private final Context mContext;
        private String packageName;

        public Builder(Context r8) {
            i.f(r8, "context");
            Context r10 = r8.getApplicationContext();
            i.e(r10, "context.applicationContext");
            this.mContext = r10;
            this.packageName = r8.getPackageName();
        }

        public final Builder appId(long r8) {
            this.appId = Long.valueOf(r8);
            return this;
        }

        public final Builder authBySign() {
            this.authBySign = true;
            return this;
        }

        public final AIKernelConfig build() {
            return new AIKernelConfig(this);
        }

        public final Builder extraBindInfo(ExtraAppInfo r8) {
            this.extraBindInfo = r8;
            return this;
        }

        public final Long getAppId$sdk_release() {
            return this.appId;
        }

        public final boolean getAuthBySign$sdk_release() {
            return this.authBySign;
        }

        public final ExtraAppInfo getExtraBindInfo$sdk_release() {
            return this.extraBindInfo;
        }

        public final Context getMContext$sdk_release() {
            return this.mContext;
        }

        public final String getPackageName$sdk_release() {
            return this.packageName;
        }

        public final Builder packageName(String r8) {
            i.f(r8, "packageName");
            this.packageName = r8;
            return this;
        }

        public final void setAppId$sdk_release(Long r8) {
            this.appId = r8;
        }

        public final void setAuthBySign$sdk_release(boolean r8) {
            this.authBySign = r8;
        }

        public final void setExtraBindInfo$sdk_release(ExtraAppInfo r8) {
            this.extraBindInfo = r8;
        }

        public final void setPackageName$sdk_release(String r8) {
            this.packageName = r8;
        }
    }

    public static final class a {
    }

    static {
        Companion = new a();
    }

    public AIKernelConfig(Builder r8) {
        i.f(r8, "builder");
        Context r10 = r8.getMContext$sdk_release();
        this.mContext = r10;
        if (r10 == null) goto L18;
        Long r11 = r8.getAppId$sdk_release();
        this.mAppId = r11;
        if (r11 == null) goto L16;
        String r12 = r8.getPackageName$sdk_release();
        this.mPackageName = r12;
        if (TextUtils.isEmpty(r12) == false) goto L13;
        Context r13 = this.mContext;
        if (r13 == null) goto L11;
        String r14 = r13.getPackageName();
    L12:
        this.mPackageName = r14;
        goto L13
    L11:
        r14 = null;
    L13:
        this.extraBindInfo = r8.getExtraBindInfo$sdk_release();
        this.authBySign = r8.getAuthBySign$sdk_release();
        AIKLog.INSTANCE.i(TAG, "AIKernel init config success");
        return;
    L16:
        throw new IllegalArgumentException("appId is required".toString());
    L18:
        throw new IllegalArgumentException("app context is required".toString());
    }

    public final long getAppId() {
        Long r8 = this.mAppId;
        i.c(r8);
        return r8.longValue();
    }

    public final boolean getAuthBySign() {
        return this.authBySign;
    }

    public final Context getContext() {
        Context r8 = this.mContext;
        i.c(r8);
        return r8;
    }

    public final ExtraAppInfo getExtraBindInfo() {
        return this.extraBindInfo;
    }

    public final String getPackageName() {
        String r8 = this.mPackageName;
        i.c(r8);
        return r8;
    }
}
