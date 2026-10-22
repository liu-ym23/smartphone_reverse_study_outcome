package com.bytedance.android.live.network.response;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\t\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\r¨\u0006="}, d2 = {"Lcom/bytedance/android/live/network/response/EnterRoomInfoResult;", "", "", "convertLinkPlayerInfo", "", "toString", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "mAnchorLinkUser", "Ljava/util/List;", "getMAnchorLinkUser", "()Ljava/util/List;", "setMAnchorLinkUser", "(Ljava/util/List;)V", "", "scene", "I", "getScene", "()I", "setScene", "(I)V", "uiLayout", "getUiLayout", "setUiLayout", "playModes", "getPlayModes", "setPlayModes", "", "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", "Lcom/bytedance/android/live/network/response/PlayModeInfo;", "playModeInfo", "Lcom/bytedance/android/live/network/response/PlayModeInfo;", "getPlayModeInfo", "()Lcom/bytedance/android/live/network/response/PlayModeInfo;", "setPlayModeInfo", "(Lcom/bytedance/android/live/network/response/PlayModeInfo;)V", "Lcom/bytedance/android/livesdk/chatroom/model/interact/p2;", "linkmicPlayModeInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/p2;", "getLinkmicPlayModeInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/p2;", "setLinkmicPlayModeInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/p2;)V", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUIInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "mPlayerInfo", "getMPlayerInfo", "setMPlayerInfo", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EnterRoomInfoResult implements h {

    @SerializedName("client_ui_info")
    protected ClientUIInfo clientUIInfo;

    @SerializedName("play_mode_info_v2")
    protected p2 linkmicPlayModeInfo;

    @SerializedName("user")
    protected List<? extends k> mAnchorLinkUser;
    private List<? extends ILinkPlayerInfoBridge> mPlayerInfo;

    @SerializedName("playmode_info")
    protected PlayModeInfo playModeInfo;

    @SerializedName("play_modes")
    protected List<Integer> playModes;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("scene")
    protected int scene;

    @SerializedName("ui_layout")
    protected int uiLayout;

    public EnterRoomInfoResult() {
    }

    public final void convertLinkPlayerInfo() {
        List<? extends k> r0 = this.mAnchorLinkUser;
        if (r0 == null) goto L81;
        List<? extends k> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L82;
        k r4 = (k) r3.next();
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        Intrinsics.checkNotNullParameter(r5, "$this$updateByLinkUser");
        Intrinsics.checkNotNullParameter(r4, "linkUser");
        r5.setUser(r4.getUser());
        r5.setKSongUid(r4.getKSongUid());
        String r6 = r4.getLinkMicIdStr();
        String r7 = "";
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        r5.setInteractId(r6);
        String r8 = r4.getLinkMicUniqueIdStr();
        if (r8 == null) goto L14;
        r7 = r8;
    L14:
        r5.setLinkMicUniqueIdStr(r7);
        r5.setLinkStatus(r4.getStatus());
        long r9 = r4.getUserPosition();
        Intrinsics.checkNotNullParameter(r5, "$this$userPositionKt");
        r5.setUserPositionFlex((int) r9);
        r5.setSilenceStatus(r4.getSilenceStatus());
        r5.setModifyTime(r4.getModifyTime());
        r5.setRoleType(r4.getRoleType());
        r5.setLinkType(r4.getLinkType());
        r5.setMediaType(r4.getLinkType());
        boolean r10 = true;
        boolean r11 = false;
        if (r4.isBackground() != 1) goto L17;
        boolean r12 = true;
    L18:
        r5.setBackground(r12);
        l1 r13 = null;
        if (r4.getContent() == null) goto L32;
        k1 r14 = r4.getContent();
        if (r14 == null) goto L23;
        l1 r15 = r14.getLinkMicAudienceContent();
    L24:
        if (r15 == null) goto L32;
        k1 r16 = r4.getContent();
        if (r16 == null) goto L32;
        l1 r17 = r16.getLinkMicAudienceContent();
        if (r17 == null) goto L32;
        if (r17.isEnlarged() != true) goto L32;
    L33:
        r5.setEnlarged(r10);
        k1 r18 = r4.getContent();
        if (r18 == null) goto L38;
        l1 r19 = r18.getLinkMicAudienceContent();
        if (r19 == null) goto L38;
        Linkmic2DAvatar r20 = r19.getLinkmic2DAvatar();
    L39:
        r5.setLinkmic2DAvatar(r20);
        if (r4.getContent() == null) goto L80;
        k1 r21 = r4.getContent();
        if (r21 == null) goto L44;
        r13 = r21.getLinkMicAudienceContent();
    L44:
        if (r13 == null) goto L80;
        k1 r22 = r4.getContent();
        long r23 = 0;
        if (r22 == null) goto L50;
        l1 r24 = r22.getLinkMicAudienceContent();
        if (r24 == null) goto L50;
        long r25 = r24.getSelfDisciplineDurationTime();
    L51:
        r5.setSelfDisciplineDuration(r25);
        k1 r26 = r4.getContent();
        if (r26 == null) goto L56;
        l1 r27 = r26.getLinkMicAudienceContent();
        if (r27 == null) goto L56;
        long r28 = r27.getSelfDisciplineTargetDuration();
    L57:
        r5.setSelfDisciplineTargetDuration(r28);
        k1 r29 = r4.getContent();
        if (r29 == null) goto L62;
        l1 r30 = r29.getLinkMicAudienceContent();
        if (r30 == null) goto L62;
        int r31 = r30.getThemedCompetitionRole();
    L63:
        r5.setThemedCompetitionRole(r31);
        k1 r32 = r4.getContent();
        if (r32 == null) goto L68;
        l1 r33 = r32.getLinkMicAudienceContent();
        if (r33 == null) goto L68;
        r23 = r33.getChorusGuestStatus();
    L68:
        r5.setChorusGuestStatus(r23);
        k1 r34 = r4.getContent();
        if (r34 == null) goto L73;
        l1 r35 = r34.getLinkMicAudienceContent();
        if (r35 == null) goto L73;
        int r36 = r35.getAiGuestType();
    L74:
        r5.setAiGuestType(r36);
        k1 r37 = r4.getContent();
        if (r37 == null) goto L79;
        l1 r38 = r37.getLinkMicAudienceContent();
        if (r38 == null) goto L79;
        r11 = r38.isMicHidden();
    L79:
        r5.setMicHidden(r11);
    L73:
        r36 = 0;
    L62:
        r31 = 0;
    L56:
        r28 = 0;
    L50:
        r25 = 0;
    L80:
        r5.setMediaType(r5.getLinkType());
        r2.add(r5);
    L38:
        r20 = null;
        goto L39
    L23:
        r15 = null;
    L32:
        r10 = false;
        goto L33
    L17:
        r12 = false;
    L82:
        this.mPlayerInfo = r2;
        return;
    L81:
        r2 = new ArrayList();
        goto L82
    }

    public String toString() {
        return "EnterRoomInfoResult(mAnchorLinkUser=" + this.mAnchorLinkUser + ", scene=" + this.scene + ", uiLayout=" + this.uiLayout + ", playModes=" + this.playModes + ", roomId=" + this.roomId + ')';
    }

    public final ClientUIInfo getClientUIInfo() {
        return this.clientUIInfo;
    }

    public final p2 getLinkmicPlayModeInfo() {
        return this.linkmicPlayModeInfo;
    }

    public final List<k> getMAnchorLinkUser() {
        return this.mAnchorLinkUser;
    }

    public final List<ILinkPlayerInfoBridge> getMPlayerInfo() {
        return this.mPlayerInfo;
    }

    public final PlayModeInfo getPlayModeInfo() {
        return this.playModeInfo;
    }

    public final List<Integer> getPlayModes() {
        return this.playModes;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final int getScene() {
        return this.scene;
    }

    public final int getUiLayout() {
        return this.uiLayout;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.livesdk.chatroom.model.interact.p2, java.lang.Object] */
    public EnterRoomInfoResult(am3.g r5) {
        this.mAnchorLinkUser = new ArrayList();
        this.playModes = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L6;
            case 7: goto L9;
            case 8: goto L6;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.clientUIInfo = vh7.f.a(r5, ClientUIInfo.class);
        goto L3
    L8:
        this.linkmicPlayModeInfo = vh7.f.a(r5, p2.class);
        goto L3
    L9:
        this.playModeInfo = new PlayModeInfo(r5);
        goto L3
    L10:
        this.roomId = r5.j();
        goto L3
    L11:
        List r3 = this.playModes;
        Object r4 = Integer.valueOf(r5.i());
    L15:
        r3.add(r4);
        goto L3
    L12:
        this.uiLayout = r5.i();
        goto L3
    L13:
        this.scene = r5.i();
        goto L3
    L14:
        r3 = this.mAnchorLinkUser;
        r4 = vh7.f.a(r5, k.class);
        goto L15
    L6:
        am3.h.e(r5);
        goto L3
    L16:
        r5.d(r0);
    }

    public final void setClientUIInfo(ClientUIInfo r1) {
        this.clientUIInfo = r1;
    }

    public final void setLinkmicPlayModeInfo(p2 r1) {
        this.linkmicPlayModeInfo = r1;
    }

    public final void setMAnchorLinkUser(List<? extends k> r1) {
        this.mAnchorLinkUser = r1;
    }

    public final void setMPlayerInfo(List<? extends ILinkPlayerInfoBridge> r1) {
        this.mPlayerInfo = r1;
    }

    public final void setPlayModeInfo(PlayModeInfo r1) {
        this.playModeInfo = r1;
    }

    public final void setPlayModes(List<Integer> r1) {
        this.playModes = r1;
    }

    public final void setRoomId(long r1) {
        this.roomId = r1;
    }

    public final void setScene(int r1) {
        this.scene = r1;
    }

    public final void setUiLayout(int r1) {
        this.uiLayout = r1;
    }
}
