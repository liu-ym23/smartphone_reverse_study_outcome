package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.TeamfightRoomBattleContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0016R0\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\"\u0010%\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R$\u0010.\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR$\u00101\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0016\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001a¨\u00066"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/TeamfightRoomBattleContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/g;", "", "toString", "", "", "Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleRoomInfo;", "roomInfoMap", "Ljava/util/Map;", "getRoomInfoMap", "()Ljava/util/Map;", "setRoomInfoMap", "(Ljava/util/Map;)V", "", "inviteSource", "I", "getInviteSource", "()I", "setInviteSource", "(I)V", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/liveinteract/multiscene/c;", "roomBattleMode", "Lcom/bytedance/android/live/liveinteract/multiscene/c;", "getRoomBattleMode", "()Lcom/bytedance/android/live/liveinteract/multiscene/c;", "setRoomBattleMode", "(Lcom/bytedance/android/live/liveinteract/multiscene/c;)V", "ifThemeDefault", "getIfThemeDefault", "setIfThemeDefault", "themeChooserRoomId", "J", "getThemeChooserRoomId", "()J", "setThemeChooserRoomId", "(J)V", "ifPeakHour", "getIfPeakHour", "setIfPeakHour", "anchorRelationType", "getAnchorRelationType", "setAnchorRelationType", "beginType", "getBeginType", "setBeginType", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamfightRoomBattleContent extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("anchor_relation_type")
    protected String anchorRelationType;

    @SerializedName("begin_type")
    protected String beginType;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("if_peak_hour")
    protected long ifPeakHour;

    @SerializedName("if_theme_default")
    protected String ifThemeDefault;

    @SerializedName("invite_source")
    protected int inviteSource;

    @SerializedName("room_battle_mode")
    protected c roomBattleMode;

    @SerializedName("room_info_map")
    protected Map<Long, RoomBattleRoomInfo> roomInfoMap;

    @SerializedName("theme_chooser_room_id")
    protected long themeChooserRoomId;

    public TeamfightRoomBattleContent() {
        super(g.class);
        this.extra = "";
        this.anchorRelationType = "";
        this.beginType = "";
    }

    public String toString() {
        return "TeamfightRoomBattleContent(roomInfoMap=" + getRoomInfoMap() + ", inviteSource=" + getInviteSource() + ", extra=" + getExtra() + ", roomBattleMode=" + getRoomBattleMode() + ", ifThemeDefault=" + getIfThemeDefault() + ", themeChooserRoomId=" + getThemeChooserRoomId() + ", ifPeakHour=" + getIfPeakHour() + ", anchorRelationType=" + getAnchorRelationType() + ", beginType=" + getBeginType() + ')';
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public String getAnchorRelationType() {
        return this.anchorRelationType;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public String getBeginType() {
        return this.beginType;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public long getIfPeakHour() {
        return this.ifPeakHour;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public String getIfThemeDefault() {
        return this.ifThemeDefault;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public int getInviteSource() {
        return this.inviteSource;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public c getRoomBattleMode() {
        return this.roomBattleMode;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public Map<Long, RoomBattleRoomInfo> getRoomInfoMap() {
        return this.roomInfoMap;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.g
    public long getThemeChooserRoomId() {
        return this.themeChooserRoomId;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.liveinteract.multiscene.c, java.lang.Object] */
    public TeamfightRoomBattleContent(am3.g r11) {
        super(g.class);
        this.roomInfoMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L33;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this.beginType = am3.h.c(r11);
        goto L3
    L9:
        this.anchorRelationType = am3.h.c(r11);
        goto L3
    L10:
        this.ifPeakHour = r11.j();
        goto L3
    L11:
        this.themeChooserRoomId = r11.j();
        goto L3
    L12:
        this.ifThemeDefault = am3.h.c(r11);
        goto L3
    L13:
        this.roomBattleMode = vh7.f.a(r11, c.class);
        goto L3
    L14:
        this.extra = am3.h.c(r11);
        goto L3
    L15:
        this.inviteSource = r11.i();
        goto L3
    L16:
        long r6 = r11.c();
        Long r3 = null;
        RoomBattleRoomInfo r7 = null;
    L17:
        int r8 = r11.f();
        if (r8 == (-1)) goto L25;
        if (r8 != 1) goto L21;
        r3 = Long.valueOf(r11.j());
        goto L17
    L21:
        if (r8 != 2) goto L22;
        r7 = new RoomBattleRoomInfo(r11);
        goto L17
    L22:
        am3.h.e(r11);
        goto L17
    L25:
        r11.d(r6);
        Map<Long, RoomBattleRoomInfo> r4 = this.roomInfoMap;
        if (r3 == null) goto L32;
        if (r7 == null) goto L30;
        r4.put(r3, r7);
        goto L3
    L30:
        throw new IllegalStateException("Value must not be null");
    L32:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r11);
        goto L3
    L33:
        r11.d(r0);
        setThreadSafe(true);
        if (this.extra != null) goto L37;
        this.extra = "";
    L37:
        if (this.anchorRelationType != null) goto L40;
        this.anchorRelationType = "";
    L40:
        if (this.beginType != null) goto L76;
        this.beginType = "";
        return;
    }

    public void setAnchorRelationType(String r1) {
        this.anchorRelationType = r1;
    }

    public void setBeginType(String r1) {
        this.beginType = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setIfPeakHour(long r1) {
        this.ifPeakHour = r1;
    }

    public void setIfThemeDefault(String r1) {
        this.ifThemeDefault = r1;
    }

    public void setInviteSource(int r1) {
        this.inviteSource = r1;
    }

    public void setRoomBattleMode(c r1) {
        this.roomBattleMode = r1;
    }

    public void setRoomInfoMap(Map<Long, RoomBattleRoomInfo> r1) {
        this.roomInfoMap = r1;
    }

    public void setThemeChooserRoomId(long r1) {
        this.themeChooserRoomId = r1;
    }
}
