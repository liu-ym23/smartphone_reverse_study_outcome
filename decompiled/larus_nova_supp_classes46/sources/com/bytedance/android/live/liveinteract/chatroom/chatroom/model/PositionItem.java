package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001b¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/PositionItem;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/c0;", "", "used", "Z", "getUsed", "()Z", "setUsed", "(Z)V", "locked", "getLocked", "setLocked", "enable", "getEnable", "setEnable", "isEnlarged", "setEnlarged", "", "_userId", "J", "get_userId", "()J", "", "_openId", "Ljava/lang/String;", "get_openId", "()Ljava/lang/String;", "getUserId", "userId", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PositionItem extends FlexModelBase<c0> implements c0, h {

    @SerializedName("open_id")
    protected String _openId;

    @SerializedName("user_id")
    protected long _userId;

    @SerializedName("enable")
    protected boolean enable;

    @SerializedName("is_enlarged")
    protected boolean isEnlarged;

    @SerializedName("locked")
    protected boolean locked;

    @SerializedName("used")
    protected boolean used;

    public PositionItem() {
        super(c0.class);
        this._openId = "";
    }

    public String getUserId() {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(this._userId);
        String r2 = this._openId;
        r0.getClass();
        return o0.a.g(r1, r2);
    }

    public boolean getEnable() {
        return this.enable;
    }

    public boolean getLocked() {
        return this.locked;
    }

    public boolean getUsed() {
        return this.used;
    }

    public final String get_openId() {
        return this._openId;
    }

    public final long get_userId() {
        return this._userId;
    }

    public boolean isEnlarged() {
        return this.isEnlarged;
    }

    public PositionItem(g r6) {
        super(c0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L24;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.used = am3.h.a(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.locked = am3.h.a(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._userId = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.enable = am3.h.a(r6);
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.isEnlarged = am3.h.a(r6);
        goto L3
    L16:
        if (r2 != 5000) goto L17;
        this._openId = am3.h.c(r6);
        goto L3
    L17:
        am3.h.d(r3, r6);
        goto L3
    L24:
        r6.d(r0);
        setThreadSafe(true);
        if (this._openId != null) goto L49;
        this._openId = "";
        return;
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setEnlarged(boolean r1) {
        this.isEnlarged = r1;
    }

    public void setLocked(boolean r1) {
        this.locked = r1;
    }

    public void setUsed(boolean r1) {
        this.used = r1;
    }
}
