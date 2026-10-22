package com.obric.aikernel.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u0019J\b\u0010\"\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010#\u001a\u00020\u001bR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelConfig;", "", "builder", "Lcom/obric/aikernel/sdk/AIKernelConfig$Builder;", "(Lcom/obric/aikernel/sdk/AIKernelConfig$Builder;)V", "<set-?>", "", "authBySign", "getAuthBySign", "()Z", "bindRemoteOnInit", "getBindRemoteOnInit", "childProcessImportantBindEnabled", "getChildProcessImportantBindEnabled", "extraBindInfo", "Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "Lkotlin/Function0;", "", "llmUsageMode", "getLlmUsageMode", "()Lkotlin/jvm/functions/Function0;", "mAppId", "", "Ljava/lang/Long;", "mContext", "Landroid/content/Context;", "mPackageName", "", "mainServiceIdleUnbindTimeoutMs", "getMainServiceIdleUnbindTimeoutMs", "()J", "staticLlmMode", "getAppId", "getContext", "getExtraBindInfo", "getPackageName", "Builder", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelConfig {
    public static final Companion Companion = null;
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

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0000J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u00109\u001a\u00020\rJ\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u00020\u00002\b\b\u0002\u00109\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0006J\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u0014\u0010>\u001a\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0&J\u0006\u0010@\u001a\u00020\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006A"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelConfig$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appId", "", "getAppId$sdk_release", "()Ljava/lang/Long;", "setAppId$sdk_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "authBySign", "", "getAuthBySign$sdk_release", "()Z", "setAuthBySign$sdk_release", "(Z)V", "bindRemoteOnInit", "getBindRemoteOnInit$sdk_release", "setBindRemoteOnInit$sdk_release", "childProcessImportantBindEnabled", "getChildProcessImportantBindEnabled$sdk_release", "setChildProcessImportantBindEnabled$sdk_release", "extraBindInfo", "Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "getExtraBindInfo$sdk_release", "()Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "setExtraBindInfo$sdk_release", "(Lcom/obric/aikernel/sdk/data/ExtraAppInfo;)V", "llmUsageMode", "", "getLlmUsageMode$sdk_release", "()Ljava/lang/Integer;", "setLlmUsageMode$sdk_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "llmUsageModeGetter", "Lkotlin/Function0;", "getLlmUsageModeGetter$sdk_release", "()Lkotlin/jvm/functions/Function0;", "setLlmUsageModeGetter$sdk_release", "(Lkotlin/jvm/functions/Function0;)V", "mContext", "getMContext$sdk_release", "()Landroid/content/Context;", "mainServiceIdleUnbindTimeoutMs", "getMainServiceIdleUnbindTimeoutMs$sdk_release", "()J", "setMainServiceIdleUnbindTimeoutMs$sdk_release", "(J)V", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "getPackageName$sdk_release", "()Ljava/lang/String;", "setPackageName$sdk_release", "(Ljava/lang/String;)V", "enable", "build", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "enableChildProcessImportantBind", "timeoutMs", "setLlmUsageMode", "getter", "useLlmInBackgroundOnDemand", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public Builder(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "context.applicationContext");
            this.mContext = ZeusTransformUtils.wrapperContext(r0, "com.obric.memorydata.plugin");
            this.bindRemoteOnInit = true;
            this.mainServiceIdleUnbindTimeoutMs = 300000;
            this.packageName = r5.getPackageName();
        }

        public static /* synthetic */ Builder bindRemoteOnInit$default(Builder r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = true;
        L6:
            return r0.bindRemoteOnInit(r1);
        }

        public static /* synthetic */ Builder enableChildProcessImportantBind$default(Builder r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = false;
        L6:
            return r0.enableChildProcessImportantBind(r1);
        }

        public final Builder appId(long r1) {
            this.appId = Long.valueOf(r1);
            return this;
        }

        public final Builder authBySign() {
            this.authBySign = true;
            return this;
        }

        public final Builder bindRemoteOnInit(boolean r1) {
            this.bindRemoteOnInit = r1;
            return this;
        }

        public final AIKernelConfig build() {
            return new AIKernelConfig(this);
        }

        public final Builder enableChildProcessImportantBind(boolean r1) {
            this.childProcessImportantBindEnabled = r1;
            return this;
        }

        public final Builder extraBindInfo(ExtraAppInfo r1) {
            this.extraBindInfo = r1;
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

        public final Builder mainServiceIdleUnbindTimeoutMs(long r1) {
            this.mainServiceIdleUnbindTimeoutMs = r1;
            return this;
        }

        public final Builder packageName(String r2) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            this.packageName = r2;
            return this;
        }

        public final void setAppId$sdk_release(Long r1) {
            this.appId = r1;
        }

        public final void setAuthBySign$sdk_release(boolean r1) {
            this.authBySign = r1;
        }

        public final void setBindRemoteOnInit$sdk_release(boolean r1) {
            this.bindRemoteOnInit = r1;
        }

        public final void setChildProcessImportantBindEnabled$sdk_release(boolean r1) {
            this.childProcessImportantBindEnabled = r1;
        }

        public final void setExtraBindInfo$sdk_release(ExtraAppInfo r1) {
            this.extraBindInfo = r1;
        }

        public final Builder setLlmUsageMode(Function0<Integer> r3) {
            Function0<Integer> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "getter");
            this.llmUsageModeGetter = r4;
            return this;
        }

        public final void setLlmUsageMode$sdk_release(Integer r1) {
            this.llmUsageMode = r1;
        }

        public final void setLlmUsageModeGetter$sdk_release(Function0<Integer> r3) {
            this.llmUsageModeGetter = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        public final void setMainServiceIdleUnbindTimeoutMs$sdk_release(long r1) {
            this.mainServiceIdleUnbindTimeoutMs = r1;
        }

        public final void setPackageName$sdk_release(String r1) {
            this.packageName = r1;
        }

        public final Builder useLlmInBackgroundOnDemand() {
            this.llmUsageMode = 1;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelConfig$Companion;", "", "()V", "DEFAULT_MAIN_SERVICE_IDLE_UNBIND_TIMEOUT_MS", "", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIKernelConfig(Builder r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.bindRemoteOnInit = true;
        this.mainServiceIdleUnbindTimeoutMs = 300000;
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getMContext$sdk_release(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r0;
        if (r0 == null) goto L25;
        Long r1 = r5.getAppId$sdk_release();
        this.mAppId = r1;
        if (r1 == null) goto L23;
        String r2 = r5.getPackageName$sdk_release();
        this.mPackageName = r2;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        Context r3 = this.mContext;
        if (r3 == null) goto L11;
        String r4 = r3.getPackageName();
    L12:
        this.mPackageName = r4;
        goto L13
    L11:
        r4 = null;
    L13:
        this.extraBindInfo = r5.getExtraBindInfo$sdk_release();
        this.authBySign = r5.getAuthBySign$sdk_release();
        this.bindRemoteOnInit = r5.getBindRemoteOnInit$sdk_release();
        this.mainServiceIdleUnbindTimeoutMs = r5.getMainServiceIdleUnbindTimeoutMs$sdk_release();
        this.childProcessImportantBindEnabled = r5.getChildProcessImportantBindEnabled$sdk_release();
        if (r5.getLlmUsageModeGetter$sdk_release() != null) goto L18;
        Integer r6 = r5.getLlmUsageMode$sdk_release();
        if (r6 == null) goto L20;
        this.staticLlmMode = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue();
        Function0<Integer> r7 = (Function0) ZeusTransformUtils.preCheckCast(new AIKernelConfig$3$1(this), Function0.class, "com.obric.memorydata.plugin");
    L19:
        this.llmUsageMode = r7;
    L20:
        AIKLog.INSTANCE.i(TAG, "AIKernel init config success");
        return;
    L18:
        r7 = r5.getLlmUsageModeGetter$sdk_release();
        goto L19
    L23:
        throw new IllegalArgumentException("appId is required".toString());
    L25:
        throw new IllegalArgumentException("app context is required".toString());
    }

    public static final /* synthetic */ int access$getStaticLlmMode$p(AIKernelConfig r0) {
        return r0.staticLlmMode;
    }

    public final long getAppId() {
        Long r2 = this.mAppId;
        Intrinsics.checkNotNull(r2);
        return r2.longValue();
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
        Context r0 = this.mContext;
        Intrinsics.checkNotNull(r0);
        return r0;
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
        String r0 = this.mPackageName;
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
