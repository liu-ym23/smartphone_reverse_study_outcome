package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.f30;
import com.bytedance.android.livesdk.config.lh;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m3 implements f10.a {
    public static final /* synthetic */ int g = 0;
    public DataCenter a;
    public boolean b;
    public long c;
    public boolean d;
    public id2.c e;
    public com.bytedance.android.live.broadcastgame.api.model.u f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/m3$a;", "", "", "mergeBeats", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setMergeBeats", "(Ljava/lang/String;)V", "beatsTracker", "getBeatsTracker", "setBeatsTracker", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("beats_tracker")
        private String beatsTracker;

        @SerializedName("merged_beats")
        private String mergeBeats;

        public a() {
            this.mergeBeats = "";
            this.beatsTracker = "";
        }

        public final String a() {
            return this.mergeBeats;
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/m3$c;", "", "", "url", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("cover_hd")
        private String url;

        public c() {
            this.url = "";
        }

        public final String a() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/m3$d;", "", "Lcom/bytedance/android/live/core/resources/h$a;", "audioGraph", "Lcom/bytedance/android/live/core/resources/h$a;", "getAudioGraph", "()Lcom/bytedance/android/live/core/resources/h$a;", "setAudioGraph", "(Lcom/bytedance/android/live/core/resources/h$a;)V", "", "", "musicLib", "Ljava/util/List;", "a", "()Ljava/util/List;", "setMusicLib", "(Ljava/util/List;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("audio_graph")
        private com.bytedance.android.live.core.resources.h.a audioGraph;

        @SerializedName("music_lib")
        private List<String> musicLib;

        public d() {
            this.musicLib = new ArrayList();
        }

        public final List<String> a() {
            return this.musicLib;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ m3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public e(m3 r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            m3.d(this.a, this.b, com.bytedance.android.live.effect.api.d0.d, false, this.c, 16);
            this.a.f(this.b, "click", "confirm");
            r7.dismiss();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ m3 a;
        public final /* synthetic */ String b;

        public f(m3 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            this.a.f(this.b, "click", "cancel");
            r4.dismiss();
        }
    }

    public static final class g implements IFetchEffectListener {
        public final /* synthetic */ m3 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ id2.c d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public final void onStart(Effect r1) {
        }

        public final void onSuccess(Object r14) {
            Effect r2 = (Effect) r14;
            JSONObject r15 = new JSONObject();
            String r1 = null;
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j r3 = r0.getLiveStream();
            if (r3 == null) goto L7;
            com.bytedance.android.live.pushstream.d r4 = (com.bytedance.android.live.pushstream.d) r3.getValue();
        L8:
            Ref.ObjectRef r5 = new Ref.ObjectRef();
            r5.element = null;
            boolean r6 = true;
            boolean r7 = false;
            String r8 = "";
            if (this.b == true) goto L11;
        L118:
            if (r2 == null) goto L209;
            xs2.b r16 = xs2.b.a();
            String r9 = this.f;
            boolean r10 = this.c;
            n3 r11 = new n3(this, r2, r4);
            Bundle r12 = new Bundle();
            if (((Boolean) f30.a.getValue()).booleanValue() == false) goto L135;
            String r13 = this.a.f.extra;
            LiveSeiUtil.i.getClass();     // Catch: Exception -> L138
            JSONObject r17 = LiveSeiUtil.c(r13);     // Catch: Exception -> L138
            if (r17.optInt("version_type", -1) == 1) goto L145;
            r6 = false;
        L145:
            r1 = LiveSeiUtil.c(r17.optString("debug_button")).optString("schema");     // Catch: Exception -> L129
        L130:
            if (r1 == null) goto L133;
            r8 = r1;
        L133:
            Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L137
        L134:
            r7 = r6;
        L135:
            r12.putBoolean("extra_key_enable_debug_mode", r7);
            r12.putString("extra_key_debug_schema_url", r8);
            Unit r19 = Unit.INSTANCE;
            r16.post(new zg1.o(r9, r2, r10, r11, r12));
            return;
        L209:
            return;
        L11:
            if (this.c == false) goto L118;
            if (lh.a.getValue().booleanValue() == false) goto L118;
            Gson r20 = GsonHelper.get();
            if (r2 == null) goto L17;
            String r21 = r2.getSdk_extra();
        L18:
            d r22 = (d) GsonProtectorUtils.fromJson(r20, r21, d.class);
            r5.element = new i0();
            if (this.d == null) goto L118;
            if ((!r22.a().isEmpty()) == false) goto L118;
            JSONObject r23 = new JSONObject(this.d.b);     // Catch: Exception -> L24
        L25:
            Iterator<T> r24 = r22.a().iterator();
        L27:
            if (r24.hasNext() == false) goto L111;
            String r25 = (String) r24.next();
            switch(r25.hashCode()) {
                case -1992012396: goto L104;
                case -1406328437: goto L95;
                case -1361215066: goto L86;
                case -1087772684: goto L83;
                case 97759: goto L80;
                case 3154575: goto L77;
                case 3237446: goto L74;
                case 3351329: goto L71;
                case 92896879: goto L68;
                case 93610877: goto L54;
                case 94852023: goto L35;
                case 110371416: goto L32;
                default: goto L27;
            };
        L32:
            if (r25.equals(LiveEndPageData.TAG_TITLE) == false) goto L27;
        L97:
            if (r23.has(r25) == false) goto L99;
            String r110 = JSONObjectProtectorUtils.getString(r23, r25);
        L101:
            if (k81.c.b(r110) == false) goto L27;
            r15.put(r25, r110);
            goto L27
        L99:
            r110 = "";
            goto L101
        L35:
            if (r25.equals("cover") == false) goto L27;
            String r111 = this.d.h;     // Catch: Exception -> L66
            if (r111.length() != 0) goto L39;
            boolean r112 = true;
        L40:
            if (r112 == false) goto L47;
            Gson r113 = GsonHelper.get();     // Catch: Exception -> L66
            if (r23.has(r25) == false) goto L44;
            String r26 = JSONObjectProtectorUtils.getString(r23, r25);     // Catch: Exception -> L66
        L45:
            r111 = ((c) r113.fromJson(r26, c.class)).a();     // Catch: Exception -> L66
            goto L47
        L44:
            r26 = "";
        L47:
            if (r111.length() <= 0) goto L49;
            boolean r27 = true;
        L50:
            if (r27 == false) goto L27;
            ((i0) r5.element).a(new i0.c(r111));     // Catch: Exception -> L66
            goto L27
        L49:
            r27 = false;
            goto L50
        L39:
            r112 = false;
            goto L40
        L54:
            if (r25.equals("beats") == false) goto L27;
            Gson r114 = GsonHelper.get();     // Catch: Exception -> L66
            if (r23.has(r25) == false) goto L58;
            String r28 = JSONObjectProtectorUtils.getString(r23, r25);     // Catch: Exception -> L66
        L59:
            a r29 = (a) r114.fromJson(r28, a.class);     // Catch: Exception -> L66
            if (r29.a().length() <= 0) goto L62;
            boolean r115 = true;
        L63:
            if (r115 == false) goto L27;
            ((i0) r5.element).a(new i0.a(r29.a()));     // Catch: Exception -> L66
            goto L27
        L62:
            r115 = false;
            goto L63
        L58:
            r28 = "";
            goto L59
        L68:
            if (r25.equals("album") == false) goto L27;
        L71:
            if (r25.equals("midi") == false) goto L27;
            r15.put(r25, this.d.e);
            goto L27
        L74:
            if (r25.equals("inst") == false) goto L27;
            r15.put(r25, this.d.d);
            goto L27
        L77:
            if (r25.equals("full") == false) goto L27;
            r15.put(r25, this.d.c);
            goto L27
        L80:
            if (r25.equals("bpm") == false) goto L27;
        L106:
            if (r23.has(r25) == false) goto L108;
            int r116 = JSONObjectProtectorUtils.getInt(r23, r25);
        L109:
            if (r116 <= 0) goto L27;
            r15.put(r25, r116);
            goto L27
        L108:
            r116 = 0;
            goto L109
        L83:
            if (r25.equals("lyrics") == false) goto L27;
            id2.c r30 = this.d;
            ((i0) r5.element).a(new i0.e(r30.f, r30.g));
            goto L27
        L86:
            if (r25.equals("chorus") == false) goto L27;
            if (r23.has(r25) == false) goto L90;
            String r117 = JSONObjectProtectorUtils.getString(r23, r25);
        L92:
            if (k81.c.b(r117) == false) goto L27;
            r15.put(r25, new JSONObject(r117));
            goto L27
        L90:
            r117 = "";
            goto L92
        L95:
            if (r25.equals("author") == false) goto L27;
        L104:
            if (r25.equals("duration") == false) goto L27;
        L111:
            i0 r31 = (i0) r5.element;
            o3 r32 = new o3(this, r5, r15, r4);
            r31.getClass();
            Intrinsics.checkNotNullParameter(r32, "taskCallBack");
            if (((ArrayList) r31.c).isEmpty() == false) goto L114;
            r32.onFinish();
            goto L118
        L114:
            r31.b = r32;
            Iterator r118 = ((ArrayList) r31.c).iterator();
        L116:
            if (r118.hasNext() == false) goto L118;
            ((i0.d) r118.next()).a(r31.a);
        L24:
            r23 = new JSONObject();
            goto L25
        L17:
            r21 = null;
        L7:
            r4 = null;
            goto L8
        }

        public final void onFail(Effect r4, ExceptionResult r5) {
            Intrinsics.checkNotNullParameter(r5, "e");
            RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r6 == null) goto L7;
            com.bytedance.live.datacontext.n r7 = r6.getDownLoadingInteractEffectId();
            if (r7 == null) goto L7;
            r7.setValue(null);
        L7:
            this.a.e();
        }

        public g(m3 r1, boolean r2, boolean r3, id2.c r4, String r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class h implements BroadcastKtvEffectMusicWidget.b {
        public final /* synthetic */ m3 a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Ref.ObjectRef d;
        public final /* synthetic */ Ref.ObjectRef e;

        public final void a() {
            if (this.b.element == true) goto L13;
            int r0 = k81.c.a;
            String r4 = null;
            RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r1 == null) goto L10;
            com.bytedance.live.datacontext.n r2 = r1.getDownLoadingInteractEffectId();
            if (r2 == null) goto L10;
            r4 = (String) r2.getValue();
        L10:
            if (k81.c.b(r4) == true) goto L13;
            this.a.g((String) this.d.element, (String) this.e.element);
            return;
        L13:
            this.a.h(this.c.getContext());
        }

        public h(m3 r1, Ref.BooleanRef r2, View r3, Ref.ObjectRef r4, Ref.ObjectRef r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class i implements DialogInterface.OnClickListener {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void e() {
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(this.f.e(), ReloadPanelType.FROM_CAHCE, false, false, 12));
    }

    public m3(com.bytedance.android.live.broadcastgame.api.model.u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        this.f = r2;
    }

    public static final /* synthetic */ DataCenter a(m3 r1) {
        DataCenter r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r2;
    }

    public final void h(Context r7) {
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        if (((Boolean) et0.a.getValue()).booleanValue() == false) goto L5;
        String r0 = "特效下载中，请稍后";
    L6:
        com.bytedance.android.livesdk.chatroom.view.e r1 = new com.bytedance.android.livesdk.chatroom.view.e(r7, "请先退出当前特效/互动特效", r0);
        com.bytedance.android.livesdk.widget.z0.a().getClass();
        com.bytedance.android.livesdk.widget.x0.d r2 = new com.bytedance.android.livesdk.widget.x0.d();
        r2.b = r7;
        r2.a = 4;
        r2.l = false;
        r2.f = r1;
        i r8 = i.a;
        com.bytedance.android.livesdk.widget.x0.c[] r3 = r2.g;
        com.bytedance.android.livesdk.widget.x0.c r4 = r3[0];
        if (r4 != null) goto L9;
        r4 = new com.bytedance.android.livesdk.widget.x0.c();
        r3[0] = r4;
    L9:
        r4.a = "我知道了";
        r4.b = r8;
        com.bytedance.android.livesdk.widget.x0.c[] r9 = r2.g;
        com.bytedance.android.livesdk.widget.x0.c r5 = r9[0];
        if (r5 != null) goto L12;
        r5 = new com.bytedance.android.livesdk.widget.x0.c();
        r9[0] = r5;
    L12:
        r5.c = true;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r2.b, r2));
        return;
    L5:
        r0 = "最多可同时使用一种特效/互动特效";
        goto L6
    }

    public final void onClick(View r24) {
        Intrinsics.checkNotNullParameter(r24, "view");
        long r3 = System.currentTimeMillis();
        if ((r3 - this.c) <= 500) goto L5;
        boolean r5 = false;
    L6:
        this.c = r3;
        if (r5 == false) goto L9;
        return;
    L9:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = "";
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = false;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r6 = ILiveWrappedEffectSDKService.a.a();
        if (r6 == null) goto L13;
        String r7 = r6.getSdkVersion();
        if (r7 == null) goto L13;
    L14:
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = "";
        String r10 = this.f.extra;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L34
        JSONObject r11 = LiveSeiUtil.c(r10);     // Catch: Exception -> L34
        String r15 = r11.optString("button_schema_url");     // Catch: Exception -> L34
        int r16 = ln1.a.a.a;     // Catch: Exception -> L32
        JSONObject r14 = ln1.a.a.b(r11.optString("button_extra"));     // Catch: Exception -> L32
        r4.element = r11.optString("app_id");     // Catch: Exception -> L171
        String r12 = r11.optString("schema");     // Catch: Exception -> L171
        String r13 = r11.optString("plugin_type");     // Catch: Exception -> L30
        r9.element = r11.optString("music_info_requirement");     // Catch: Exception -> L170
        int r17 = r11.optInt("version_type", -1);     // Catch: Exception -> L170
        String r0 = LiveSeiUtil.c(r11.optString("debug_button")).optString("schema");     // Catch: Exception -> L23
    L24:
        if (r0 != null) goto L182;
        r0 = "";
    L182:
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L169
    L29:
        int r19 = r17;
        boolean r110 = false;
    L35:
        this.b = r110;
        List r111 = LiveEffectContext.h;
        List r20 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.d);
        Iterator r112 = r20.iterator();
    L37:
        if (r112.hasNext() == false) goto L45;
        long r113 = ((Sticker) r112.next()).getId();
        Iterator r21 = r112;
        Long r114 = StringsKt.toLongOrNull((String) r4.element);
        if (r114 == null) goto L44;
        if (r113 != r114.longValue()) goto L44;
        this.b = true;
        String r115 = "open";
    L46:
        List r116 = LiveEffectContext.h;
        String r117 = r12;
        String r118 = r0;
        this.d = !LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.c).isEmpty();
        if (((Boolean) et0.a.getValue()).booleanValue() == false) goto L50;
        r8.element = false;
    L56:
        RoomContext.a r1 = RoomContext.Companion;
        RoomContext r22 = RoomContext.a.c(r1, null, 0, 3);
        if (r22 == null) goto L62;
        com.bytedance.live.datacontext.n r23 = r22.getDownLoadingInteractEffectId();
        if (r23 == null) goto L62;
        String r25 = (String) r23.getValue();
        if (r25 == null) goto L62;
    L63:
        Map r26 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("interact_app_id", (String) r4.element), TuplesKt.to("status", r115), TuplesKt.to("interact_app_type", r13), TuplesKt.to("effect_sdk_version", r7), TuplesKt.to("downloading_id", r25), TuplesKt.to("extension_type_level2", "null")});
        if (r19 <= (-1)) goto L69;
        if (((Boolean) f30.a.getValue()).booleanValue() == false) goto L69;
        r26.put("version_type", String.valueOf(r19));
    L69:
        if (Intrinsics.areEqual(r24.getTag(), "button") == false) goto L142;
        if (r14 == null) goto L72;
        Object r2 = r14.get("entrance_type");
    L74:
        if (Intrinsics.areEqual(r2, "open_url") == false) goto L83;
        if (r15 == null) goto L83;
        if (r15.length() <= 0) goto L79;
        boolean r27 = true;
    L81:
        if (r27 != true) goto L83;
        dp1.a.a(r24, r15, r26, false);
    L165:
        boolean r119 = true;
    L166:
        if (r119 == false) goto L192;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(this.f.e(), ReloadPanelType.FROM_CAHCE, false, this.b, 4));
        return;
    L192:
        return;
    L79:
        r27 = false;
    L83:
        if (r14 == null) goto L85;
        Object r28 = r14.get("entrance_type");
    L87:
        if (Intrinsics.areEqual(r28, "open_effect") == true) goto L89;
    L110:
        if (r14 == null) goto L112;
        Object r29 = r14.get("entrance_type");
    L114:
        if (Intrinsics.areEqual(r29, "open_ktv_effect") == true) goto L116;
    L140:
        com.bytedance.android.live.core.utils.f2.c("互动工具打开失败", 0);
        goto L165
    L116:
        if (((String) r4.element).length() <= 0) goto L118;
        boolean r30 = true;
    L119:
        if (r30 == false) goto L140;
        String r31 = (String) r9.element;
        if (r8.element == true) goto L139;
        int r32 = k81.c.a;
        RoomContext r33 = RoomContext.a.c(r1, null, 0, 3);
        if (r33 == null) goto L127;
        com.bytedance.live.datacontext.n r34 = r33.getDownLoadingInteractEffectId();
        if (r34 == null) goto L127;
        String r120 = (String) r34.getValue();
    L129:
        if (k81.c.b(r120) == true) goto L139;
        if (this.b == false) goto L135;
        b((String) r4.element, r24.getContext(), true);
        goto L165
    L135:
        if (lh.a.getValue().booleanValue() == false) goto L137;
        g((String) r4.element, (String) r9.element);
        goto L165
    L137:
        d(this, (String) r4.element, com.bytedance.android.live.effect.api.d0.d, true, false, 24);
    L138:
        r119 = false;
    L127:
        r120 = null;
    L139:
        h(r24.getContext());
        goto L165
    L118:
        r30 = false;
        goto L119
    L112:
        r29 = null;
        goto L114
    L89:
        if (((String) r4.element).length() <= 0) goto L91;
        boolean r35 = true;
    L92:
        if (r35 == false) goto L110;
        if (r8.element == true) goto L108;
        int r36 = k81.c.a;
        RoomContext r37 = RoomContext.a.c(r1, null, 0, 3);
        if (r37 == null) goto L100;
        com.bytedance.live.datacontext.n r38 = r37.getDownLoadingInteractEffectId();
        if (r38 == null) goto L100;
        String r121 = (String) r38.getValue();
    L102:
        if (k81.c.b(r121) == true) goto L108;
        if (this.b == false) goto L107;
        b((String) r4.element, r24.getContext(), false);
        goto L165
    L107:
        d(this, (String) r4.element, com.bytedance.android.live.effect.api.d0.d, true, false, 24);
    L100:
        r121 = null;
    L108:
        h(r24.getContext());
        goto L165
    L91:
        r35 = false;
        goto L92
    L85:
        r28 = null;
        goto L87
    L72:
        r2 = null;
        goto L74
    L142:
        if (Intrinsics.areEqual(r24.getTag(), "debug_button") == false) goto L145;
        int r39 = dp1.a.a;
        dp1.a.a(r24, r118, MapsKt.emptyMap(), false);
        xs2.b.a().post(new d10.b(true));
        goto L165
    L145:
        if (r14 == null) goto L147;
        Object r40 = r14.get("entrance_type");
    L149:
        if (Intrinsics.areEqual(r40, "open_ktv_effect") == true) goto L151;
    L160:
        xs2.b.a().post(new BroadcastKtvEffectMusicWidget.d((String) r4.element, null));
    L162:
        if (r8.element == false) goto L164;
        r26.put("repel_status", "effect");
    L164:
        dp1.a.a(r24, r117, r26, false);
        goto L165
    L151:
        if (((String) r4.element).length() <= 0) goto L153;
        boolean r41 = true;
    L154:
        if (r41 == false) goto L160;
        if (this.b == true) goto L160;
        if (lh.a.getValue().booleanValue() == false) goto L160;
        xs2.b.a().post(new BroadcastKtvEffectMusicWidget.d((String) r4.element, new h(this, r8, r24, r4, r9)));
        goto L162
    L153:
        r41 = false;
        goto L154
    L147:
        r40 = null;
    L62:
        r25 = "";
        goto L63
    L50:
        if ((!r20.isEmpty()) == false) goto L54;
        if (this.b == true) goto L54;
    L55:
        r8.element = true;
    L54:
        if (this.d == false) goto L56;
    L44:
        r112 = r21;
        goto L37
    L45:
        r115 = "close";
    L23:
        r0 = null;
    L28:
        r0 = "";
    L31:
        r0 = "";
        r110 = false;
        r19 = -1;
    L30:
        r13 = "";
    L33:
        r0 = "";
        r13 = r0;
        r110 = false;
        r19 = -1;
        r12 = null;
    L32:
        r14 = null;
    L34:
        r0 = "";
        r13 = r0;
        r110 = false;
        r19 = -1;
        r12 = null;
        r14 = null;
        r15 = null;
    L13:
        r7 = "";
        goto L14
    L5:
        r5 = true;
        goto L6
    }

    public final void xg(com.bytedance.android.live.broadcastgame.api.model.u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void g(String r7, String r8) {
        RoomContext.a r0 = RoomContext.Companion;
        DataCenter r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        RoomContext r2 = RoomContext.a.c(r0, r1, 0, 2);
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L17;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L17;
        RoomSpecificSceneTypeInfo r5 = r4.getSceneTypeInfo();
        if (r5 == null) goto L17;
        if (r5.isLandscapeVertical() != true) goto L17;
        com.bytedance.android.live.core.utils.f2.c("横屏开播无法使用互动特效", 0);
        xs2.b r9 = xs2.b.a();
        String r6 = this.f.e();
        boolean r10 = this.b;
        r9.post(new com.bytedance.android.live.broadcastgame.api.model.f0(r6, ReloadPanelType.FROM_CAHCE, false, r10, 4));
        return;
    L17:
        IKtvService r11 = jc1.k.f(IKtvService.class);
        if (r11 != null) goto L20;
    L24:
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 == null) goto L30;
        r12.openEffectMusicSelect(r8, new p3(this, r7));
        return;
    L30:
        return;
    L20:
        if (r11.isKtvComponentOpen() != true) goto L24;
        com.bytedance.android.live.core.utils.f2.c("建议关闭k歌后再开启互动特效", 0);
        IKtvService r13 = jc1.k.f(IKtvService.class);
        if (r13 == null) goto L28;
        r13.openEffectMusicSelect(r8, new p3(this, r7));
        return;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }

    public final void b(String r5, Context r6, boolean r7) {
        f(r5, "show", "");
        View r0 = LayoutInflater.from(r6).inflate(2131567649, null);
        TextView r1 = (TextView) r0.findViewById(2131388772);
        TextView r2 = (TextView) r0.findViewById(2131387553);
        r1.setText("确认退出互动特效");
        UtilityKotlinExtentionsKt.z(r2, false);
        com.bytedance.android.livesdk.widget.z0.a().getClass();
        com.bytedance.android.livesdk.widget.x0.b r3 = new com.bytedance.android.livesdk.widget.x0.b(r6, 4);
        com.bytedance.android.livesdk.widget.x0.d r8 = r3.a;
        r8.l = false;
        r8.f = r0;
        r3.j(0, "确认", new e(this, r5, r7));
        r3.j(1, "取消", new f(this, r5));
        r3.k(0, true);
        r3.n();
    }

    public final void f(String r6, String r7, String r8) {
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("app_id", r6), TuplesKt.to("event_page", "interactive_extension_homepage"), TuplesKt.to("extension_name", this.f.name), TuplesKt.to("extension_type", "互动特效"), TuplesKt.to("click_btn_type", r8), TuplesKt.to("action_type", r7)});
        String r10 = this.f.extra;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L6
        JSONObject r11 = LiveSeiUtil.c(r10);     // Catch: Exception -> L6
        r9.put("plugin_type", r11.optString("plugin_type"));     // Catch: Exception -> L6
        r9.put("price", r11.optString("single_month_price"));     // Catch: Exception -> L6
        r9.put("app_type", r11.optString("plugin_type"));     // Catch: Exception -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L6
    L4:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_quit_popup", r9, new Object[]{IRoom.class});
    }

    public final void c(String r10, String r11, boolean r12, boolean r13, id2.c r14) {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        boolean r6 = false;
        if (r5 == null) goto L19;
        com.bytedance.live.datacontext.i r7 = r5.isAnchor();
        if (r7 == null) goto L19;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L19;
        RoomContext r8 = RoomContext.a.c(r0, null, 0, 3);
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.i r9 = r8.getLiveMode();
        if (r9 == null) goto L13;
        LiveMode r15 = (LiveMode) r9.getValue();
    L15:
        if (r15 == LiveMode.VIDEO) goto L19;
        com.bytedance.android.live.core.utils.f2.c("请在视频开播时使用特效", 0);
        e();
        return;
    L13:
        r15 = null;
    L19:
        if (r11.length() != 0) goto L21;
        boolean r16 = true;
    L22:
        if (r16 == false) goto L24;
    L34:
        e();
        return;
    L24:
        if (r10.length() != 0) goto L26;
        r6 = true;
    L26:
        if (r6 == true) goto L34;
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L33;
        com.bytedance.live.datacontext.n r2 = r1.getDownLoadingInteractEffectId();
        if (r2 == null) goto L33;
        r2.setValue(r10);
    L33:
        List r3 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).d().fetchEffect(r10, new g(this, r13, r12, r14, r10, r11));
        return;
    L21:
        r16 = false;
        goto L22
    }

    public static /* synthetic */ void d(m3 r6, String r7, String r8, boolean r9, boolean r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        boolean r4 = false;
    L6:
        r6.c(r7, r8, r9, r4, null);
        return;
    L5:
        r4 = r10;
        goto L6
    }
}
