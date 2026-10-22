package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge;
import com.bytedance.android.livesdk.link.model.bridge.y1;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic.OpenGameInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b=\u0010>R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\r\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R$\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001c\u00104\u001a\n\u0018\u000100j\u0004\u0018\u0001`18VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u000fR\u0014\u00108\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u000fR4\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000209\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000209\u0018\u0001`:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\t¨\u0006?"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/OpenGameInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkerGameRole;", "_roleInfos", "Ljava/util/Map;", "get_roleInfos", "()Ljava/util/Map;", "set_roleInfos", "(Ljava/util/Map;)V", "_appId", "Ljava/lang/String;", "get_appId", "()Ljava/lang/String;", "set_appId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "_streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "get_streamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "set_streamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;)V", "", "gameId", "J", "getGameId", "()J", "setGameId", "(J)V", "gameType", "getGameType", "setGameType", "linkGameId", "getLinkGameId", "setLinkGameId", "_gameExtra", "get_gameExtra", "set_gameExtra", "_linkExtra", "get_linkExtra", "set_linkExtra", "value", "getAppId", "setAppId", "appId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKt;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "streamUrl", "getLinkExtra", "linkExtra", "getGameExtra", "gameExtra", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRoleInfos", "roleInfos", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameInfo extends FlexModelBase<y1> implements y1, vh7.h {

    @SerializedName("app_id")
    protected String _appId;

    @SerializedName("game_extra")
    protected String _gameExtra;

    @SerializedName("linker_extra")
    protected String _linkExtra;

    @SerializedName("anchor_open_game_role_infos")
    protected Map<String, AnchorLinkerGameRole> _roleInfos;

    @SerializedName("stream_url")
    protected StreamUrl _streamUrl;

    @SerializedName("game_id")
    protected long gameId;

    @SerializedName("game_type")
    protected long gameType;

    @SerializedName("link_game_id")
    protected long linkGameId;

    public OpenGameInfo() {
        super(y1.class);
        this._appId = "";
        this._gameExtra = "";
        this._linkExtra = "";
    }

    public Map<String, IAnchorGameRoleBridge> getRoleInfos() {
        return KotlinTypeUtilsKt.castElementType(this._roleInfos);
    }

    public String getAppId() {
        return this._appId;
    }

    public String getGameExtra() {
        return this._gameExtra;
    }

    public long getGameId() {
        return this.gameId;
    }

    public long getGameType() {
        return this.gameType;
    }

    public String getLinkExtra() {
        return this._linkExtra;
    }

    public long getLinkGameId() {
        return this.linkGameId;
    }

    public IBaseStreamUrl getStreamUrl() {
        return this._streamUrl;
    }

    public final String get_appId() {
        return this._appId;
    }

    public final String get_gameExtra() {
        return this._gameExtra;
    }

    public final String get_linkExtra() {
        return this._linkExtra;
    }

    public final Map<String, AnchorLinkerGameRole> get_roleInfos() {
        return this._roleInfos;
    }

    public final StreamUrl get_streamUrl() {
        return this._streamUrl;
    }

    public OpenGameInfo(am3.g r11) {
        super(y1.class);
        this._roleInfos = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L45;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L8;
        this._appId = am3.h.c(r11);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._streamUrl = new StreamUrl(r11);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.gameId = r11.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.linkGameId = r11.j();
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this._gameExtra = am3.h.c(r11);
        goto L3
    L16:
        if (r2 != 8) goto L18;
        this.gameType = r11.j();
        goto L3
    L18:
        if (r2 != 9) goto L20;
        this._linkExtra = am3.h.c(r11);
        goto L3
    L20:
        if (r2 != 11) goto L21;
        long r7 = r11.c();
        String r3 = null;
        AnchorLinkerGameRole r6 = null;
    L23:
        int r9 = r11.f();
        if (r9 == (-1)) goto L30;
        if (r9 != 1) goto L26;
        r3 = am3.h.c(r11);
        goto L23
    L26:
        if (r9 != 2) goto L27;
        r6 = new AnchorLinkerGameRole(r11);
        goto L23
    L27:
        am3.h.e(r11);
        goto L23
    L30:
        r11.d(r7);
        Map<String, AnchorLinkerGameRole> r4 = this._roleInfos;
        if (r3 == null) goto L37;
        if (r6 == null) goto L35;
        r4.put(r3, r6);
        goto L3
    L35:
        throw new IllegalStateException("Value must not be null");
    L37:
        throw new IllegalStateException("Key must not be null");
    L21:
        am3.h.d(r5, r11);
        goto L3
    L45:
        r11.d(r0);
        setThreadSafe(true);
        if (this._appId != null) goto L49;
        this._appId = "";
    L49:
        if (this._gameExtra != null) goto L52;
        this._gameExtra = "";
    L52:
        if (this._linkExtra != null) goto L93;
        this._linkExtra = "";
        return;
    }

    public void setAppId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._appId = r2;
    }

    public void setGameId(long r1) {
        this.gameId = r1;
    }

    public void setGameType(long r1) {
        this.gameType = r1;
    }

    public void setLinkGameId(long r1) {
        this.linkGameId = r1;
    }

    public final void set_appId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._appId = r2;
    }

    public final void set_gameExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._gameExtra = r2;
    }

    public final void set_linkExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._linkExtra = r2;
    }

    public final void set_roleInfos(Map<String, AnchorLinkerGameRole> r1) {
        this._roleInfos = r1;
    }

    public final void set_streamUrl(StreamUrl r1) {
        this._streamUrl = r1;
    }
}
