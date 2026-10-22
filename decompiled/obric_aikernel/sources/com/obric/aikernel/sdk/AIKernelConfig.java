package com.obric.aikernel.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class AIKernelConfig {
    public static final a Companion = null;
    public static final long DEFAULT_MAIN_SERVICE_IDLE_UNBIND_TIMEOUT_MS = 300000;
    private static final String TAG = "AIKernelConfig";
    private boolean authBySign;
    private boolean bindRemoteOnInit;
    private boolean childProcessImportantBindEnabled;
    private ExtraAppInfo extraBindInfo;
    private Function0<Integer> llmUsageMode;
    private Long mAppId;
    private Context mContext;
    private String mPackageName;
    private long mainServiceIdleUnbindTimeoutMs;
    private int staticLlmMode;

    @Keep
    public static final class Builder {
        private Long appId;
        private boolean authBySign;
        private boolean bindRemoteOnInit;
        private boolean childProcessImportantBindEnabled;
        private ExtraAppInfo extraBindInfo;
        private Integer llmUsageMode;
        private Function0<Integer> llmUsageModeGetter;
        private final Context mContext;
        private long mainServiceIdleUnbindTimeoutMs;
        private String packageName;

        public Builder(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Context r11 = r10.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(r11, "context.applicationContext");
            this.mContext = r11;
            this.bindRemoteOnInit = true;
            this.mainServiceIdleUnbindTimeoutMs = 300000;
            this.packageName = r10.getPackageName();
        }

        public static /* synthetic */ Builder bindRemoteOnInit$default(Builder r10, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r11 = true;
        L6:
            return r10.bindRemoteOnInit(r11);
        }

        public static /* synthetic */ Builder enableChildProcessImportantBind$default(Builder r10, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r11 = false;
        L6:
            return r10.enableChildProcessImportantBind(r11);
        }

        public final Builder appId(long r10) {
            this.appId = Long.valueOf(r10);
            return this;
        }

        public final Builder authBySign() {
            this.authBySign = true;
            return this;
        }

        public final Builder bindRemoteOnInit(boolean r10) {
            this.bindRemoteOnInit = r10;
            return this;
        }

        public final AIKernelConfig build() {
            return new AIKernelConfig(this);
        }

        public final Builder enableChildProcessImportantBind(boolean r10) {
            this.childProcessImportantBindEnabled = r10;
            return this;
        }

        public final Builder extraBindInfo(ExtraAppInfo r10) {
            this.extraBindInfo = r10;
            return this;
        }

        public final Long getAppId$sdk_release() {
            return this.appId;
        }

        public final boolean getAuthBySign$sdk_release() {
            return this.authBySign;
        }

        public final boolean getBindRemoteOnInit$sdk_release() {
            return this.bindRemoteOnInit;
        }

        public final boolean getChildProcessImportantBindEnabled$sdk_release() {
            return this.childProcessImportantBindEnabled;
        }

        public final ExtraAppInfo getExtraBindInfo$sdk_release() {
            return this.extraBindInfo;
        }

        public final Integer getLlmUsageMode$sdk_release() {
            return this.llmUsageMode;
        }

        public final Function0<Integer> getLlmUsageModeGetter$sdk_release() {
            return this.llmUsageModeGetter;
        }

        public final Context getMContext$sdk_release() {
            return this.mContext;
        }

        public final long getMainServiceIdleUnbindTimeoutMs$sdk_release() {
            return this.mainServiceIdleUnbindTimeoutMs;
        }

        public final String getPackageName$sdk_release() {
            return this.packageName;
        }

        public final Builder mainServiceIdleUnbindTimeoutMs(long r10) {
            this.mainServiceIdleUnbindTimeoutMs = r10;
            return this;
        }

        public final Builder packageName(String r10) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            this.packageName = r10;
            return this;
        }

        public final void setAppId$sdk_release(Long r10) {
            this.appId = r10;
        }

        public final void setAuthBySign$sdk_release(boolean r10) {
            this.authBySign = r10;
        }

        public final void setBindRemoteOnInit$sdk_release(boolean r10) {
            this.bindRemoteOnInit = r10;
        }

        public final void setChildProcessImportantBindEnabled$sdk_release(boolean r10) {
            this.childProcessImportantBindEnabled = r10;
        }

        public final void setExtraBindInfo$sdk_release(ExtraAppInfo r10) {
            this.extraBindInfo = r10;
        }

        public final Builder setLlmUsageMode(Function0<Integer> r10) {
            Intrinsics.checkNotNullParameter(r10, "getter");
            this.llmUsageModeGetter = r10;
            return this;
        }

        public final void setLlmUsageMode$sdk_release(Integer r10) {
            this.llmUsageMode = r10;
        }

        public final void setLlmUsageModeGetter$sdk_release(Function0<Integer> r10) {
            this.llmUsageModeGetter = r10;
        }

        public final void setMainServiceIdleUnbindTimeoutMs$sdk_release(long r10) {
            this.mainServiceIdleUnbindTimeoutMs = r10;
        }

        public final void setPackageName$sdk_release(String r10) {
            this.packageName = r10;
        }

        public final Builder useLlmInBackgroundOnDemand() {
            this.llmUsageMode = 1;
            return this;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AIKernelConfig(Builder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.bindRemoteOnInit = true;
        this.mainServiceIdleUnbindTimeoutMs = 300000;
        Context r11 = r10.getMContext$sdk_release();
        this.mContext = r11;
        if (r11 == null) goto L25;
        Long r12 = r10.getAppId$sdk_release();
        this.mAppId = r12;
        if (r12 == null) goto L23;
        String r13 = r10.getPackageName$sdk_release();
        this.mPackageName = r13;
        if (TextUtils.isEmpty(r13) == false) goto L13;
        Context r14 = this.mContext;
        if (r14 == null) goto L11;
        String r15 = r14.getPackageName();
    L12:
        this.mPackageName = r15;
        goto L13
    L11:
        r15 = null;
    L13:
        this.extraBindInfo = r10.getExtraBindInfo$sdk_release();
        this.authBySign = r10.getAuthBySign$sdk_release();
        this.bindRemoteOnInit = r10.getBindRemoteOnInit$sdk_release();
        this.mainServiceIdleUnbindTimeoutMs = r10.getMainServiceIdleUnbindTimeoutMs$sdk_release();
        this.childProcessImportantBindEnabled = r10.getChildProcessImportantBindEnabled$sdk_release();
        if (r10.getLlmUsageModeGetter$sdk_release() != null) goto L18;
        Integer r16 = r10.getLlmUsageMode$sdk_release();
        if (r16 == null) goto L20;
        this.staticLlmMode = r16.intValue();
        Function0<Integer> r17 = new AIKernelConfig$3$1(this);
    L19:
        this.llmUsageMode = r17;
    L20:
        AIKLog.INSTANCE.i(TAG, "AIKernel init config success");
        return;
    L18:
        r17 = r10.getLlmUsageModeGetter$sdk_release();
        goto L19
    L23:
        throw new IllegalArgumentException("appId is required".toString());
    L25:
        throw new IllegalArgumentException("app context is required".toString());
    }

    public static final /* synthetic */ int access$getStaticLlmMode$p(AIKernelConfig r10) {
        return r10.staticLlmMode;
    }

    public final long getAppId() {
        Long r10 = this.mAppId;
        Intrinsics.checkNotNull(r10);
        return r10.longValue();
    }

    public final boolean getAuthBySign() {
        return this.authBySign;
    }

    public final boolean getBindRemoteOnInit() {
        return this.bindRemoteOnInit;
    }

    public final boolean getChildProcessImportantBindEnabled() {
        return this.childProcessImportantBindEnabled;
    }

    public final Context getContext() {
        Context r10 = this.mContext;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final ExtraAppInfo getExtraBindInfo() {
        return this.extraBindInfo;
    }

    public final Function0<Integer> getLlmUsageMode() {
        return this.llmUsageMode;
    }

    public final long getMainServiceIdleUnbindTimeoutMs() {
        return this.mainServiceIdleUnbindTimeoutMs;
    }

    public final String getPackageName() {
        String r10 = this.mPackageName;
        Intrinsics.checkNotNull(r10);
        return r10;
    }
}
