package com.obric.aivoice.sdk;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.aivoice.core.log.AIVoiceLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceConfig;", NameKeys.UnloadStrategy_No_Strategy, "builder", "Lcom/obric/aivoice/sdk/AIVoiceConfig$Builder;", "(Lcom/obric/aivoice/sdk/AIVoiceConfig$Builder;)V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "mAppId", NameKeys.UnloadStrategy_No_Strategy, "Ljava/lang/Long;", "mCtxGetter", "Lkotlin/Function0;", "Landroid/content/Context;", "mPackageName", "mProjectId", "getAppId", "getContext", "getContextGetter", "getPackageName", "getProjectId", "Builder", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceConfig {
    private final String TAG;
    private Long mAppId;
    private Function0<? extends Context> mCtxGetter;
    private String mPackageName;
    private Long mProjectId;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceConfig$Builder;", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appId", NameKeys.UnloadStrategy_No_Strategy, "getAppId$voicesdk_release", "()Ljava/lang/Long;", "setAppId$voicesdk_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mContext", "packageName", NameKeys.UnloadStrategy_No_Strategy, "getPackageName$voicesdk_release", "()Ljava/lang/String;", "setPackageName$voicesdk_release", "(Ljava/lang/String;)V", "projectId", "getProjectId$voicesdk_release", "setProjectId$voicesdk_release", "build", "Lcom/obric/aivoice/sdk/AIVoiceConfig;", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private Long appId;
        private final Context mContext;
        private String packageName;
        private Long projectId;

        public final AIVoiceConfig build() {
            final AIVoiceConfig r0 = new AIVoiceConfig(this);
            AIVoiceConfig.access$setMCtxGetter$p(r0, new AIVoiceConfig$Builder$build$1$1(r0, this));
            return r0;
        }

        public final Long getAppId$voicesdk_release() {
            return this.appId;
        }

        public final String getPackageName$voicesdk_release() {
            return this.packageName;
        }

        public final Long getProjectId$voicesdk_release() {
            return this.projectId;
        }

        public Builder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.mContext = r2.getApplicationContext();
        }

        public static final /* synthetic */ Context access$getMContext$p(Builder r0) {
            return r0.mContext;
        }

        public final Builder appId(long r1) {
            this.appId = Long.valueOf(r1);
            return this;
        }

        public final Builder packageName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "packageName");
            this.packageName = r2;
            return this;
        }

        public final Builder projectId(long r1) {
            this.projectId = Long.valueOf(r1);
            return this;
        }

        public final void setAppId$voicesdk_release(Long r1) {
            this.appId = r1;
        }

        public final void setPackageName$voicesdk_release(String r1) {
            this.packageName = r1;
        }

        public final void setProjectId$voicesdk_release(Long r1) {
            this.projectId = r1;
        }
    }

    public final long getAppId() {
        Long r0 = this.mAppId;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r0.longValue();
    L7:
        throw new IllegalArgumentException("appId is required".toString());
    }

    public final Context getContext() {
        return (Context) this.mCtxGetter.invoke();
    }

    public final String getPackageName() {
        String r0 = this.mPackageName;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        throw new IllegalArgumentException("packageName is required".toString());
    }

    public final long getProjectId() {
        Long r0 = this.mProjectId;
        if (r0 == null) goto L9;
        if (r0 != null) goto L10;
        return 0;
    L10:
        return r0.longValue();
    L9:
        throw new IllegalArgumentException("projectId is required".toString());
    }

    public final Function0<Context> getContextGetter() {
        return this.mCtxGetter;
    }

    public AIVoiceConfig(Builder r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.TAG = "AIVoiceConfig";
        this.mCtxGetter = AIVoiceConfig$mCtxGetter$1.INSTANCE;
        this.mAppId = r3.getAppId$voicesdk_release();
        this.mProjectId = r3.getProjectId$voicesdk_release();
        this.mPackageName = r3.getPackageName$voicesdk_release();
        if (this.mAppId == null) goto L7;
        AIVoiceLog.INSTANCE.i("AIVoiceConfig", "AIVoice init config success");
        return;
    L7:
        throw new IllegalArgumentException("appId is required".toString());
    }

    public static final /* synthetic */ String access$getMPackageName$p(AIVoiceConfig r0) {
        return r0.mPackageName;
    }

    public static final /* synthetic */ void access$setMCtxGetter$p(AIVoiceConfig r0, Function0 r1) {
        r0.mCtxGetter = r1;
    }
}
