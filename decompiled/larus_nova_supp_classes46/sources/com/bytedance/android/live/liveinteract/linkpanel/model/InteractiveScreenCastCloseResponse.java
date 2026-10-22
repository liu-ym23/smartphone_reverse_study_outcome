package com.bytedance.android.live.liveinteract.linkpanel.model;

import am3.g;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.multilink.base.model.l;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/InteractiveScreenCastCloseResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/l;", "", "rtcExtInfo", "Ljava/lang/String;", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "liveCoreExtInfo", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "", "targetUiLayout", "J", "getTargetUiLayout", "()J", "setTargetUiLayout", "(J)V", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "castInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "getCastInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "setCastInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;)V", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveScreenCastCloseResponse extends FlexModelBase<l> implements l, h {

    @SerializedName("screen_cast_info")
    protected s0 castInfo;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    @SerializedName("target_ui_layout")
    protected long targetUiLayout;

    public InteractiveScreenCastCloseResponse() {
        super(l.class);
        this.rtcExtInfo = "";
        this.liveCoreExtInfo = "";
    }

    public s0 getCastInfo() {
        return this.castInfo;
    }

    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    public long getTargetUiLayout() {
        return this.targetUiLayout;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.chatroom.model.interact.s0, java.lang.Object] */
    public InteractiveScreenCastCloseResponse(g r6) {
        super(l.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.castInfo = f.a(r6, s0.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rtcExtInfo = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.liveCoreExtInfo = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.targetUiLayout = r6.j();
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this.rtcExtInfo != null) goto L22;
        this.rtcExtInfo = "";
    L22:
        if (this.liveCoreExtInfo != null) goto L40;
        this.liveCoreExtInfo = "";
        return;
    }

    public void setCastInfo(s0 r1) {
        this.castInfo = r1;
    }

    public void setLiveCoreExtInfo(String r1) {
        this.liveCoreExtInfo = r1;
    }

    public void setRtcExtInfo(String r1) {
        this.rtcExtInfo = r1;
    }

    public void setTargetUiLayout(long r1) {
        this.targetUiLayout = r1;
    }
}
