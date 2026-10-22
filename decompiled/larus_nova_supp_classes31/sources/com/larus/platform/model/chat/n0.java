package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/larus/platform/model/chat/SendMsgPerfOptConfig;", "", "enableBuildParamsOpt", "", "enableTryInterruptOpt", "enableAsrDuplicateInterruptOpt", "enableAsyncStopTtsOpt", "enableMsgRenderDuration", "preloadCacheExpireTime", "", "enableInterruptMsgConvertOpt", "prepareMsgCacheExpireTime", "<init>", "(ZZZZZJZJ)V", "getEnableBuildParamsOpt", "()Z", "getEnableTryInterruptOpt", "getEnableAsrDuplicateInterruptOpt", "getEnableAsyncStopTtsOpt", "getEnableMsgRenderDuration", "getPreloadCacheExpireTime", "()J", "getEnableInterruptMsgConvertOpt", "getPrepareMsgCacheExpireTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class n0 {

    @SerializedName("enable_asr_duplicate_interrupt_opt")
    private final boolean enableAsrDuplicateInterruptOpt;

    @SerializedName("enable_async_stop_tts_opt")
    private final boolean enableAsyncStopTtsOpt;

    @SerializedName("enable_build_params_opt")
    private final boolean enableBuildParamsOpt;

    @SerializedName("enable_interrupt_msg_convert_opt")
    private final boolean enableInterruptMsgConvertOpt;

    @SerializedName("enable_msg_render_duration")
    private final boolean enableMsgRenderDuration;

    @SerializedName("enable_try_interrupt_opt")
    private final boolean enableTryInterruptOpt;

    @SerializedName("preload_cache_expire_time")
    private final long preloadCacheExpireTime;

    @SerializedName("prepare_msg_cache_expire_time")
    private final long prepareMsgCacheExpireTime;

    public n0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r9 = (n0) r8;
        if (this.enableBuildParamsOpt == r9.enableBuildParamsOpt) goto L12;
        return false;
    L12:
        if (this.enableTryInterruptOpt == r9.enableTryInterruptOpt) goto L15;
        return false;
    L15:
        if (this.enableAsrDuplicateInterruptOpt == r9.enableAsrDuplicateInterruptOpt) goto L18;
        return false;
    L18:
        if (this.enableAsyncStopTtsOpt == r9.enableAsyncStopTtsOpt) goto L21;
        return false;
    L21:
        if (this.enableMsgRenderDuration == r9.enableMsgRenderDuration) goto L24;
        return false;
    L24:
        if (this.preloadCacheExpireTime == r9.preloadCacheExpireTime) goto L27;
        return false;
    L27:
        if (this.enableInterruptMsgConvertOpt == r9.enableInterruptMsgConvertOpt) goto L30;
        return false;
    L30:
        if (this.prepareMsgCacheExpireTime == r9.prepareMsgCacheExpireTime) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableBuildParamsOpt == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableTryInterruptOpt == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableAsrDuplicateInterruptOpt == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.enableAsyncStopTtsOpt == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.enableMsgRenderDuration == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        long r11 = this.preloadCacheExpireTime;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        if (this.enableInterruptMsgConvertOpt == true) goto L26;
        r1 = 1237;
    L26:
        int r13 = (r12 + r1) * 31;
        long r14 = this.prepareMsgCacheExpireTime;
        return r13 + ((int) (r14 ^ (r14 >>> 32)));
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SendMsgPerfOptConfig(enableBuildParamsOpt=" + this.enableBuildParamsOpt + ", enableTryInterruptOpt=" + this.enableTryInterruptOpt + ", enableAsrDuplicateInterruptOpt=" + this.enableAsrDuplicateInterruptOpt + ", enableAsyncStopTtsOpt=" + this.enableAsyncStopTtsOpt + ", enableMsgRenderDuration=" + this.enableMsgRenderDuration + ", preloadCacheExpireTime=" + this.preloadCacheExpireTime + ", enableInterruptMsgConvertOpt=" + this.enableInterruptMsgConvertOpt + ", prepareMsgCacheExpireTime=" + this.prepareMsgCacheExpireTime + ')';
    }

    public final boolean a() {
        return this.enableAsrDuplicateInterruptOpt;
    }

    public final boolean b() {
        return this.enableAsyncStopTtsOpt;
    }

    public final boolean c() {
        return this.enableBuildParamsOpt;
    }

    public final boolean d() {
        return this.enableMsgRenderDuration;
    }

    public final boolean e() {
        return this.enableTryInterruptOpt;
    }

    public final long f() {
        return this.preloadCacheExpireTime;
    }

    public final long g() {
        return this.prepareMsgCacheExpireTime;
    }

    public n0(int r3) {
        this.enableBuildParamsOpt = false;
        this.enableTryInterruptOpt = false;
        this.enableAsrDuplicateInterruptOpt = false;
        this.enableAsyncStopTtsOpt = false;
        this.enableMsgRenderDuration = false;
        this.preloadCacheExpireTime = 1000;
        this.enableInterruptMsgConvertOpt = false;
        this.prepareMsgCacheExpireTime = 3000;
    }
}
