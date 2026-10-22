package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.link.model.bridge.x1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.OpenGameConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010!\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/OpenGameConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/x1;", "Lcom/bytedance/android/live/base/model/ImageModel;", "_iconImage", "", "setIconImage", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_iconImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_iconImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "appExtra", "getAppExtra", "setAppExtra", "gameTitle", "getGameTitle", "setGameTitle", "getGameAppId", "gameAppId", "getGameExtra", "gameExtra", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIconImage", "()Lpy/k;", "iconImage", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameConfig extends FlexModelBase<x1> implements x1, vh7.h {

    @SerializedName("icon_image")
    protected ImageModel _iconImage;

    @SerializedName("app_extra")
    protected String appExtra;

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("game_title")
    protected String gameTitle;

    public OpenGameConfig() {
        super(x1.class);
    }

    public OpenGameConfig(am3.g r6) {
        super(x1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.appId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.appExtra = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._iconImage = x.a(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.gameTitle = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    public final String getAppExtra() {
        return this.appExtra;
    }

    public final String getAppId() {
        return this.appId;
    }

    public String getGameAppId() {
        return this.appId;
    }

    public String getGameExtra() {
        return this.appExtra;
    }

    public String getGameTitle() {
        return this.gameTitle;
    }

    public py.k getIconImage() {
        return this._iconImage;
    }

    public final ImageModel get_iconImage() {
        return this._iconImage;
    }

    public final void setAppExtra(String r1) {
        this.appExtra = r1;
    }

    public final void setAppId(String r1) {
        this.appId = r1;
    }

    public void setGameTitle(String r1) {
        this.gameTitle = r1;
    }

    public final void setIconImage(ImageModel r1) {
        this._iconImage = r1;
    }

    public final void set_iconImage(ImageModel r1) {
        this._iconImage = r1;
    }
}
