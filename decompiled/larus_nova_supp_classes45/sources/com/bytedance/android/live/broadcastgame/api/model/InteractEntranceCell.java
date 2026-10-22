package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.InteractEntranceCell")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002$%R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\tR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\tR\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\tR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0013R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0018\u0010#\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\t¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/f2$b;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/o2$b;", "Lcom/bytedance/android/live/broadcastgame/api/model/l;", "", "interactType", "I", "", "title", "Ljava/lang/String;", "desc", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "groupType", "J", "", "serverScenes", "Ljava/util/List;", "extra", "Lcom/bytedance/android/live/broadcastgame/api/model/v;", "labels", "Lcom/bytedance/android/live/broadcastgame/api/model/k0;", "rightButton", "Lcom/bytedance/android/live/broadcastgame/api/model/k0;", "gameCardExtra", "extendExtra", "iconLabel", "selectKeys", "titleLabel", "Lcom/bytedance/android/live/broadcastgame/api/model/t;", "highlightLabel", "Lcom/bytedance/android/live/broadcastgame/api/model/s;", "highlightDesc", "highlightIcon", "AppPrivilege", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractEntranceCell implements f2.b, o2.b, l, vh7.h {
    public boolean a;
    public r b;
    public List<y> c;
    public boolean d;

    @SerializedName("desc")
    public String desc;
    public int e;

    @SerializedName("extend_extra")
    public String extendExtra;

    @SerializedName("extra")
    public String extra;
    public final n f;

    @SerializedName("game_card_extra")
    public String gameCardExtra;

    @SerializedName("group_id")
    public long groupType;

    @SerializedName("highlight_desc")
    public List<s> highlightDesc;

    @SerializedName("highlight_icon")
    public String highlightIcon;

    @SerializedName("highlight_label")
    public List<t> highlightLabel;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("icon_label")
    public String iconLabel;

    @SerializedName("interact_type")
    public int interactType;

    @SerializedName("labels")
    public List<v> labels;

    @SerializedName("button")
    public k0 rightButton;

    @SerializedName("select_keys")
    public List<String> selectKeys;

    @SerializedName("call_server_scenes")
    public List<String> serverScenes;

    @SerializedName("title")
    public String title;

    @SerializedName("title_label")
    public String titleLabel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell$AppPrivilege;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BIND_SELF_MOUNT", "BIND_DCD", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AppPrivilege extends Enum<AppPrivilege> {
        public static final AppPrivilege BIND_DCD = null;
        public static final AppPrivilege BIND_SELF_MOUNT = null;
        public static final /* synthetic */ AppPrivilege[] a = null;
        private final String value;

        static {
            AppPrivilege r1 = new AppPrivilege("BIND_SELF_MOUNT", 0, "bind_self");
            BIND_SELF_MOUNT = r1;
            AppPrivilege r2 = new AppPrivilege("BIND_DCD", 1, "bind_dcd");
            BIND_DCD = r2;
            a = new AppPrivilege[]{r1, r2};
        }

        public static AppPrivilege valueOf(String r1) {
            return (AppPrivilege) r27.a.a(AppPrivilege.class, r1);
        }

        public static AppPrivilege[] values() {
            return (AppPrivilege[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public AppPrivilege(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "InteractEntranceCell(interactType=" + this.interactType + ", title=" + this.title + ", desc=" + this.desc + ", icon=" + this.icon + ", groupType=" + this.groupType + ", serverScenes=" + this.serverScenes + ", extra=" + this.extra + ", labels=" + this.labels + ", rightButton=" + this.rightButton + ", gameCardExtra=" + this.gameCardExtra + ", extendExtra=" + this.extendExtra + ", iconLabel=" + this.iconLabel + ", selectKeys=" + this.selectKeys + ", titleLabel=" + this.titleLabel + ", highlightLabel=" + this.highlightLabel + ", highlightDesc=" + this.highlightDesc + ", highlightIcon=" + this.highlightIcon + ")";
    }

    public final String c() {
        if (this.f.c == true) goto L6;
        return String.valueOf(this.interactType);
    L6:
        return h();
    }

    public final r e() {
        boolean r0 = this.a;
        if (r0 == true) goto L34;
        if (r0 == true) goto L34;
        String r1 = this.extra;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L35;
    L32:
        this.a = true;
        goto L34
    L35:
        JsonObject r3 = GsonHelper.parser().parse(this.extra).getAsJsonObject();     // Catch: Exception -> L30
        r3.addProperty("game_name", this.title);     // Catch: Exception -> L30
        r3.addProperty("anchor_live_version", Integer.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: Exception -> L30
        if (InteractID.OpenMicroGame.getValue() != this.interactType) goto L23;
        JsonObject r4 = r3.getAsJsonObject("micro_game_info");     // Catch: Exception -> L30
        if (r4 == null) goto L23;
        JsonElement r5 = r4.get("game_id");     // Catch: Exception -> L30
        if (r5 == null) goto L23;
        String r6 = r5.getAsString();     // Catch: Exception -> L30
        if (r6 == null) goto L23;
        r3.addProperty(OpenPlatformBaseDebugger.APP_ID, r6);     // Catch: Exception -> L30
    L23:
        r r7 = (r) GsonHelper.get().fromJson(r3, r.class);     // Catch: Exception -> L30
        this.b = r7;     // Catch: Exception -> L30
        if (r7 != null) goto L26;
    L28:
        r3.toString();     // Catch: Exception -> L30
        goto L32
    L26:
        if (this.interactType != InteractID.EffectGame.getValue()) goto L28;
        r3.addProperty("game_identifier", Long.valueOf(r7.l()));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
    L34:
        return this.b;
    }

    public final boolean f() {
        return Intrinsics.areEqual(new JSONObject(this.extendExtra).optString("app_privilege", ""), AppPrivilege.BIND_SELF_MOUNT.getValue());
    L4:
        return false;
    }

    public final String g() {
        return new JSONObject(this.extendExtra).optString("recommend_reason", "");
    L8:
        return "";
    }

    public final String h() {
        int r0 = w.a;
        return w.a.a(this.interactType, this.title, e(), this.extra);
    }

    public final int hashCode() {
        int r0 = this.title.hashCode() * 31;
        ImageModel r1 = this.icon;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.extra;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final u i() {
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = this.c.iterator();
    L3:
        String r4 = "";
        if (r2.hasNext() == false) goto L12;
        y r3 = (y) r2.next();
        if (r3 == null) goto L11;
        String r5 = r3.text;
        if (r5 == null) goto L11;
        r4 = r5;
    L11:
        r1.add(r4);
        goto L3
    L12:
        List<Long> r6 = null;
        if (this.interactType != InteractID.OpenGame.getValue()) goto L15;
    L77:
        String r7 = this.extra;
        if (r7 != null) goto L104;
    L82:
        JSONObject r8 = null;
    L83:
        int r9 = this.interactType;
        String r11 = this.title;
        if (r11 != null) goto L86;
        String r12 = "";
    L87:
        ImageModel r13 = this.icon;
        if (r13 == null) goto L91;
        List r14 = r13.mUrls;
        if (r14 == null) goto L91;
    L92:
        List r15 = r14;
        long r16 = this.groupType;
        r r17 = e();
        if (r17 == null) goto L95;
        r6 = r17.supportiveEntrance;
    L95:
        List<Long> r18 = r6;
        if (r8 == null) goto L101;
        String r19 = r8.toString();
        if (r19 == null) goto L101;
        String r110 = r19;
    L102:
        u r21 = new u(r9, r12, r15, 0, r16, r18, r110);
        n r22 = this.f;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.b = r22;
        r21.c = this.d;
        r21.g = this.e;
        String r23 = r1.toString();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r21.f = r23;
        return r21;
    L101:
        r110 = "";
    L91:
        r14 = new ArrayList();
        goto L92
    L86:
        r12 = r11;
        goto L87
    L104:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L81
        JSONObject r24 = LiveSeiUtil.c(r7);     // Catch: Exception -> L81
        r24.put("game_card_extra", this.gameCardExtra);     // Catch: Exception -> L81
        r8 = r24.put("desc", this.desc);     // Catch: Exception -> L81
    L15:
        if (this.interactType == InteractID.SonicMiniGame.getValue()) goto L77;
        if (this.interactType != InteractID.InteractLoki.getValue()) goto L20;
    L42:
        String r25 = this.extra;
        if (r25 != null) goto L106;
    L55:
        JSONObject r26 = null;
    L56:
        int r27 = this.interactType;
        String r28 = this.title;
        if (r28 != null) goto L59;
        String r29 = "";
    L60:
        ImageModel r31 = this.icon;
        if (r31 == null) goto L64;
        List r32 = r31.mUrls;
        if (r32 == null) goto L64;
    L65:
        List r111 = r32;
        long r112 = this.groupType;
        r r33 = e();
        if (r33 == null) goto L68;
        r6 = r33.supportiveEntrance;
    L68:
        List<Long> r113 = r6;
        if (r26 == null) goto L74;
        String r34 = r26.toString();
        if (r34 == null) goto L74;
        String r114 = r34;
    L75:
        u r35 = new u(r27, r29, r111, 0, r112, r113, r114);
        n r36 = this.f;
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r35.b = r36;
        r35.c = this.d;
        r35.g = this.e;
        String r37 = r1.toString();
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r35.f = r37;
        return r35;
    L74:
        r114 = "";
    L64:
        r32 = new ArrayList();
        goto L65
    L59:
        r29 = r28;
        goto L60
    L106:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L54
        JSONObject r38 = LiveSeiUtil.c(r25);     // Catch: Exception -> L54
        k0 r39 = this.rightButton;     // Catch: Exception -> L54
        if (r39 == null) goto L47;
        String r41 = r39.schemeUrl;     // Catch: Exception -> L54
    L48:
        r38.put("button_schema_url", r41);     // Catch: Exception -> L54
        k0 r42 = this.rightButton;     // Catch: Exception -> L54
        if (r42 == null) goto L51;
        String r43 = r42.extra;     // Catch: Exception -> L54
    L52:
        r26 = r38.put("button_extra", r43);     // Catch: Exception -> L54
    L51:
        r43 = null;
        goto L52
    L47:
        r41 = null;
        goto L48
    L20:
        if (this.interactType == InteractID.InteractGamePlus.getValue()) goto L42;
        if (this.interactType == InteractID.InteractMiniApp.getValue()) goto L42;
        int r44 = this.interactType;
        String r45 = this.title;
        if (r45 != null) goto L27;
        String r46 = "";
    L28:
        ImageModel r47 = this.icon;
        if (r47 == null) goto L32;
        List r48 = r47.mUrls;
        if (r48 == null) goto L32;
    L33:
        List r115 = r48;
        long r116 = this.groupType;
        r r49 = e();
        if (r49 == null) goto L36;
        r6 = r49.supportiveEntrance;
    L36:
        List<Long> r117 = r6;
        String r51 = this.extra;
        if (r51 != null) goto L39;
        String r118 = "";
    L40:
        u r52 = new u(r44, r46, r115, 0, r116, r117, r118);
        n r53 = this.f;
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r52.b = r53;
        r52.c = this.d;
        r52.g = this.e;
        String r54 = r1.toString();
        Intrinsics.checkNotNullParameter(r54, "<set-?>");
        r52.f = r54;
        r52.j = this.serverScenes;
        return r52;
    L39:
        r118 = r51;
    L32:
        r48 = new ArrayList();
        goto L33
    L27:
        r46 = r45;
        goto L28
    }

    public InteractEntranceCell() {
        this.c = new ArrayList();
        this.e = -1;
        this.f = new n(0);
        this.interactType = 0;
        this.title = "";
        this.desc = "";
        this.icon = null;
        this.groupType = 0;
        this.serverScenes = new ArrayList();
        this.extra = "";
        this.labels = new ArrayList();
        this.rightButton = null;
        this.gameCardExtra = "";
        this.extendExtra = "";
        this.iconLabel = null;
        this.selectKeys = new ArrayList();
        this.titleLabel = null;
        this.highlightLabel = new ArrayList();
        this.highlightDesc = new ArrayList();
        this.highlightIcon = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final List<Long> a() {
        r r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.supportiveEntrance;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final r d() {
        return e();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final int b() {
        return this.interactType;
    }

    public InteractEntranceCell(am3.g r8) {
        this.serverScenes = new ArrayList();
        this.labels = new ArrayList();
        this.selectKeys = new ArrayList();
        this.highlightLabel = new ArrayList();
        this.highlightDesc = new ArrayList();
        this.c = new ArrayList();
        this.e = -1;
        this.f = new n(0);
        long r3 = r8.c();
        int r1 = 0;
    L3:
        int r5 = r8.f();
        if (r5 == (-1)) goto L27;
        switch(r5) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            default: goto L6;
        };
    L8:
        this.highlightIcon = am3.h.c(r8);
        goto L3
    L9:
        List r6 = this.highlightLabel;
        vh7.h r7 = new t(r8);
    L18:
        r6.add(r7);
        goto L3
    L10:
        r6 = this.highlightDesc;
        r7 = new s(r8);
        goto L18
    L11:
        this.titleLabel = am3.h.c(r8);
        goto L3
    L12:
        r6 = this.selectKeys;
    L17:
        r7 = am3.h.c(r8);
        goto L18
    L13:
        this.iconLabel = am3.h.c(r8);
        goto L3
    L14:
        this.rightButton = new k0(r8);
        goto L3
    L15:
        r6 = this.labels;
        r7 = new v(r8);
        goto L18
    L16:
        r6 = this.serverScenes;
        goto L17
    L19:
        this.groupType = r8.j();
        r1 = r1 | 2;
        goto L3
    L20:
        this.icon = com.bytedance.android.live.base.model.x.a(r8);
        goto L3
    L21:
        this.desc = am3.h.c(r8);
        goto L3
    L22:
        this.title = am3.h.c(r8);
        goto L3
    L23:
        this.interactType = r8.i();
        r1 = r1 | 1;
        goto L3
    L6:
        switch(r5) {
            case 99: goto L26;
            case 100: goto L25;
            case 101: goto L24;
            default: goto L7;
        };
    L24:
        this.extendExtra = am3.h.c(r8);
        goto L3
    L25:
        this.gameCardExtra = am3.h.c(r8);
        goto L3
    L26:
        this.extra = am3.h.c(r8);
        goto L3
    L7:
        am3.h.e(r8);
        goto L3
    L27:
        r8.d(r3);
        if ((r1 & 1) != 0) goto L31;
        this.interactType = 0;
    L31:
        if (this.title != null) goto L34;
        this.title = "";
    L34:
        if (this.desc != null) goto L37;
        this.desc = "";
    L37:
        if (this.icon != null) goto L40;
        this.icon = null;
    L40:
        if ((r1 & 2) != 0) goto L43;
        this.groupType = 0;
    L43:
        if (this.serverScenes.isEmpty() == false) goto L46;
        this.serverScenes = new ArrayList();
    L46:
        if (this.extra != null) goto L49;
        this.extra = "";
    L49:
        if (this.labels.isEmpty() == false) goto L52;
        this.labels = new ArrayList();
    L52:
        if (this.rightButton != null) goto L55;
        this.rightButton = null;
    L55:
        if (this.gameCardExtra != null) goto L58;
        this.gameCardExtra = "";
    L58:
        if (this.extendExtra != null) goto L61;
        this.extendExtra = "";
    L61:
        if (this.iconLabel != null) goto L64;
        this.iconLabel = null;
    L64:
        if (this.selectKeys.isEmpty() == false) goto L67;
        this.selectKeys = new ArrayList();
    L67:
        if (this.titleLabel != null) goto L70;
        this.titleLabel = null;
    L70:
        if (this.highlightLabel.isEmpty() == false) goto L73;
        this.highlightLabel = new ArrayList();
    L73:
        if (this.highlightDesc.isEmpty() == false) goto L76;
        this.highlightDesc = new ArrayList();
    L76:
        if (this.highlightIcon != null) goto L114;
        this.highlightIcon = null;
        return;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        String r2 = null;
        if (r6 == null) goto L8;
        Class<?> r3 = r6.getClass();
    L10:
        if ((!Intrinsics.areEqual(InteractEntranceCell.class, r3)) == false) goto L13;
        return false;
    L13:
        if ((r6 instanceof InteractEntranceCell) == true) goto L15;
        return false;
    L15:
        InteractEntranceCell r7 = (InteractEntranceCell) r6;
        if ((!Intrinsics.areEqual(this.title, r7.title)) == false) goto L18;
        return false;
    L18:
        ImageModel r1 = this.icon;
        if (r1 == null) goto L21;
        String r4 = r1.mUri;
    L22:
        ImageModel r5 = r7.icon;
        if (r5 == null) goto L26;
        r2 = r5.mUri;
    L26:
        if ((!Intrinsics.areEqual(r4, r2)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(h(), r7.h())) == false) goto L31;
        return false;
    L31:
        return true;
    L21:
        r4 = null;
        goto L22
    L8:
        r3 = null;
        goto L10
    }

    public /* synthetic */ InteractEntranceCell(int r22, String r23, String r24, ImageModel r25, long r26, String r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r29 & 8) == 0) goto L17;
        ImageModel r1 = null;
    L19:
        if ((r29 & 16) == 0) goto L21;
        long r7 = 0;
    L23:
        if ((r29 & 32) == 0) goto L25;
        ArrayList r9 = new ArrayList();
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r29 & 128) == 0) goto L33;
        ArrayList r12 = new ArrayList();
    L35:
        if ((r29 & 512) == 0) goto L37;
        String r13 = "";
    L39:
        if ((r29 & RomUtils.SZ) == 0) goto L41;
        String r14 = "";
    L43:
        if ((r29 & 4096) == 0) goto L45;
        ArrayList r16 = new ArrayList();
    L47:
        if ((r29 & 16384) == 0) goto L49;
        ArrayList r18 = new ArrayList();
    L51:
        if ((r29 & 32768) == 0) goto L53;
        ArrayList r19 = new ArrayList();
    L54:
        this(r3, r4, r5, r1, r7, r9, r11, r12, null, r13, r14, null, r16, null, r18, r19, null);
        return;
    L53:
        r19 = null;
        goto L54
    L49:
        r18 = null;
        goto L51
    L45:
        r16 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = r28;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r1 = r25;
        goto L19
    L13:
        r5 = r24;
        goto L15
    L9:
        r4 = r23;
        goto L11
    L5:
        r3 = r22;
        goto L7
    }

    public InteractEntranceCell(int r4, String r5, String r6, ImageModel r7, long r8, List<String> r11, String r12, List<v> r13, k0 r14, String r15, String r16, String r17, List<String> r18, String r19, List<t> r110, List<s> r21, String r22) {
        Intrinsics.checkNotNullParameter(r5, "title");
        this.interactType = r4;
        this.title = r5;
        this.desc = r6;
        this.icon = r7;
        this.groupType = r8;
        this.serverScenes = r11;
        this.extra = r12;
        this.labels = r13;
        this.rightButton = r14;
        this.gameCardExtra = r15;
        this.extendExtra = r16;
        this.iconLabel = r17;
        this.selectKeys = r18;
        this.titleLabel = r19;
        this.highlightLabel = r110;
        this.highlightDesc = r21;
        this.highlightIcon = r22;
        this.c = new ArrayList();
        this.e = -1;
        this.f = new n(0);
    }
}
