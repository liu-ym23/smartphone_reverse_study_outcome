package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioRecord;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SubtitleUpdateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.live.liveinteract.voicechat.radio.asr.MultiLinkAsrManager;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.live.multilink.impl.LinkMultiControlWidget;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.f0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import dq2.t;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.h1;
import zg1.z0;
import zh0.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\u0001\u000bJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/RadioStageContainerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljk0/c;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/widget/f0;", "Lcom/bytedance/android/livesdk/chatroom/widget/j1;", "Lzg1/h1;", "event", "", "onEvent", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RadioStageContainerWidget extends MiddlewareRoomWidget implements jk0.c, Observer<KVData>, f0, j1 {
    public d a;
    public m b;
    public k c;
    public MultiLinkAsrManager d;
    public final CompositeDisposable e;
    public int f;
    public int g;
    public IRoom h;
    public final JsonObject i;
    public bn0.b j;
    public final ViewGroup k;
    public final jk0.e l;
    public final ih0.b m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RadioStageContainerWidget a;

        public b(RadioStageContainerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r9;
            Intrinsics.checkNotNullParameter(r10, "switchSceneEvent");
            RadioStageContainerWidget r0 = this.a;
            if (r0.f == r10.a) goto L5;
        L7:
            ALogger.i("RadioStageContainerWidget", "onVoiceChatRoomSubSceneChange--scene:" + r0.f + "->" + r10.a + ", uilayout:" + r0.g + "->" + r10.b);
            int r1 = r10.a;
            if (r1 != 0) goto L10;
        L41:
            if (r1 == 0) goto L43;
        L45:
            r0.f = r10.a;
            r0.g = r10.b;
            return;
        L43:
            if (r0.f == 0) goto L45;
            r0.xq();
            goto L45
        L10:
            if (r0.f != 0) goto L41;
            if (e.b(Integer.valueOf(r10.b)) == false) goto L16;
            m r2 = r0.b;
            if (r2 == null) goto L45;
            r2.k();
            goto L45
        L16:
            d r3 = r0.a;
            if (r3 == null) goto L35;
            ALogger.i("RadioStageContainerWidget", "[RadioMessageComponent] stop--");
            vlc.d r4 = r3.b;
            if (r4 == null) goto L21;
            r4.removeMessageListener(r3);
        L21:
            jk0.b r5 = r3.a;
            if (r5 == null) goto L25;
            r5.onStop();
        L25:
            if (gh0.a.d() == true) goto L27;
        L34:
            r3.e = false;
            goto L35
        L27:
            if (r3.e == false) goto L34;
            LinkedHashMap r6 = new LinkedHashMap();
            TalkRoomLogUtils.B0(r6, null, null, 6);
            r6.put("duration", String.valueOf((int) ((System.currentTimeMillis() - r3.c) / ((long) 1000))));
            Long r7 = r3.d;
            if (r7 == null) goto L32;
            String r8 = String.valueOf(r7.longValue());
            if (r8 == null) goto L32;
        L33:
            r6.put("choose_gift_id", r8);
            j0.l().sendLog("livesdk_anchor_leave_message_on_wall_function_close", r6, new Object[]{IRoom.class});
        L32:
            r8 = "";
        L35:
            m r11 = r0.b;
            if (r11 == null) goto L38;
            r11.k();
        L38:
            k r12 = r0.c;
            if (r12 == null) goto L45;
            r12.d = false;
            r12.e = false;
            r12.i("destroy");
            goto L45
        L5:
            if (r0.g != r10.b) goto L7;
        }
    }

    public static final class c implements jk0.e {
        public final /* synthetic */ RadioStageContainerWidget a;

        @Override // jk0.e
        public final void onStop() {
            this.a.l.onStop();
            Integer r0 = je0.d.h();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.intValue() != 29) goto L11;
            JsonObject r1 = new JsonObject();
            r1.addProperty("state", Boolean.FALSE);
            ih0.b r2 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this.a).dataCenter);
            if (r2 == null) goto L12;
            r2.Dk("root", "radio_stage_state", r1, false);
            return;
        L12:
            return;
        }

        public c(RadioStageContainerWidget r1) {
            this.a = r1;
        }

        @Override // jk0.e
        public final void onStart(String r5) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.a.l.onStart(r5);
            Integer r6 = je0.d.h();
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.intValue() != 29) goto L11;
            JsonObject r7 = new JsonObject();
            r7.addProperty("state", Boolean.TRUE);
            ih0.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this.a).dataCenter);
            if (r0 == null) goto L12;
            r0.Dk("root", "radio_stage_state", r7, false);
            return;
        L12:
            return;
        }
    }

    static {
    }

    @Override // jk0.c
    public final void K9() {
        m r0 = this.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // jk0.c
    public final boolean Oj() {
        k r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e != true) goto L7;
        return true;
    }

    @Override // qd0.f
    public final boolean isRtcEngineOn() {
        m r0 = this.b;
        if (r0 == null) goto L22;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r1 = r0.b;
        if (r1 == null) goto L18;
        vb6.g r2 = r1.b;
        if (r2 == null) goto L15;
        yb6.e r3 = r2.j();
        if (r3 == null) goto L15;
        yb6.n r4 = r3.K();
        if (r4 == null) goto L15;
        if (r4.e != true) goto L15;
        boolean r5 = true;
    L16:
        if (r5 != true) goto L18;
        boolean r6 = true;
    L19:
        if (r6 != true) goto L23;
        return true;
    L23:
        return false;
    L15:
        r5 = false;
    L18:
        r6 = false;
        goto L19
    L22:
        return false;
    }

    @Override // jk0.c
    public final void p9() {
        m r0 = this.b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // jk0.c
    public final boolean qi() {
        k r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() != true) goto L7;
        return true;
    }

    public final boolean wq() {
        return v.a(((Integer) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue(), 4);
    }

    public final void xq() {
        d r0 = this.a;
        if (r0 == null) goto L10;
        ALogger.i("RadioStageContainerWidget", "[RadioMessageComponent] start--");
        vlc.d r1 = r0.b;
        if ((r1 instanceof xlc.a) == true) goto L7;
        r1 = null;
    L7:
        xlc.a r2 = (xlc.a) r1;
        if (r2 == null) goto L10;
        r2.D(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), r0, "MetaSubSyncKey");
    L10:
        m r3 = this.b;
        if (r3 == null) goto L14;
        m.j(r3);
        return;
    }

    @Override // qd0.f
    public final void cb() {
        ALogger.i("RadioStageContainerWidget", "interruptPkReset-- currentScene:" + je0.d.f() + " isRtcEngineOn:" + isRtcEngineOn() + " isInPk:" + wq());
        m r0 = this.b;
        if (r0 == null) goto L6;
        m.j(r0);
        return;
    }

    public final void onCreate() {
        super.onCreate();
        ALogger.i("RadioStageContainerWidget", "onCreate--");
        Pair r1 = com.bytedance.live.datacontext.d.a(RadioStageContainerWidget$initDataContext$pair$1.INSTANCE);
        RadioStageContext r2 = (RadioStageContext) r1.getFirst();
        r2.getService().d(this);
        com.bytedance.live.datacontext.b.a(r2, com.bytedance.android.live.liveinteract.voicechat.radio.context.a.class);
        this.e.add((Disposable) r1.getSecond());
        enableSubWidgetManager();
        d r3 = new d(((Widget) this).dataCenter);
        g r4 = new g(this);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r3.a = r4;
        Unit r5 = Unit.INSTANCE;
        this.a = r3;
        m r6 = new m(((Widget) this).context, ((Widget) this).subWidgetManager, this);
        h r7 = new h(this);
        Intrinsics.checkNotNullParameter(r7, "listener");
        r6.a = r7;
        this.b = r6;
        d r8 = this.a;
        Integer r9 = null;
        if (r8 == null) goto L9;
        ALogger.i("RadioStageContainerWidget", "[RadioMessageComponent] onCreate--");
        DataCenter r10 = r8.f;
        if (r10 == null) goto L7;
        vlc.d r11 = (vlc.d) r10.get("data_message_manager", null);
    L8:
        r8.b = r11;
        goto L9
    L7:
        r11 = null;
    L9:
        m r12 = this.b;
        if (r12 == null) goto L12;
        r12.e = false;
    L12:
        IRoom r13 = (IRoom) ((Widget) this).dataCenter.get("data_room");
        this.h = r13;
        k r14 = new k(((Widget) this).context, r13, ((Widget) this).dataCenter, this.k, null, 0, this.m, 96);
        this.c = r14;
        c r15 = new c(this);
        Intrinsics.checkNotNullParameter(r15, "stateChangeCallback");
        r14.a = r15;
        ((Widget) this).dataCenter.observeForever("cmd_pk_state_change", this);
        com.bytedance.live.datacontext.j r16 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r16 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r16.getValue();
        if (r17 == null) goto L17;
        this.e.add(r17.a().subscribe(new b(this)));
    L17:
        IRoom r18 = this.h;
        if (r18 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r19 = r18.getLinkInitResult();
    L21:
        if (r19 != null) goto L48;
        StringBuilder r20 = new StringBuilder("onCreate-linkInitResult-null--linkerDetailLayout：");
        IRoom r21 = this.h;
        if (r21 == null) goto L27;
        z5 r22 = r21.getLinkerDetail();
        if (r22 == null) goto L27;
        Integer r23 = Integer.valueOf(r22.getUiLayout());
    L28:
        r20.append(r23);
        ALogger.i("RadioStageContainerWidget", r20.toString());
        IRoom r24 = this.h;
        if (r24 == null) goto L31;
        z5 r25 = r24.getLinkerDetail();
    L32:
        if (r25 == null) goto L47;
        IRoom r26 = this.h;
        if (r26 == null) goto L39;
        z5 r27 = r26.getLinkerDetail();
        if (r27 == null) goto L39;
        if (r27.getUiLayout() == 0) goto L47;
    L39:
        IRoom r0 = this.h;
        if (r0 == null) goto L45;
        z5 r28 = r0.getLinkerDetail();
        if (r28 == null) goto L45;
        r9 = Integer.valueOf(r28.getUiLayout());
    L45:
        if (e.b(r9) == false) goto L60;
        xq();
        return;
    L60:
        return;
    L47:
        ALogger.i("RadioStageContainerWidget", "onCreate-linkInitResult-linkInitResult&linkerDetail is null in radio");
        xq();
        return;
    L31:
        r25 = null;
    L27:
        r23 = null;
        goto L28
    L48:
        IRoom r29 = this.h;
        if (r29 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r30 = r29.getLinkInitResult();
        if (r30 == null) goto L64;
        ALogger.i("RadioStageContainerWidget", "onCreate-linkInitResult-scene：" + r30.getScene() + ", uiLayout: " + r30.getUiLayout());
        if (r30.getScene() != 0) goto L57;
        if (r30.getUiLayout() != 0) goto L57;
    L58:
        xq();
        return;
    L57:
        if (e.b(Integer.valueOf(r30.getUiLayout())) == true) goto L58;
        return;
    L64:
        return;
    L63:
        return;
    L20:
        r19 = null;
        goto L21
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        ALogger.i("RadioStageContainerWidget", "onDestroy--");
        d r0 = this.a;
        if (r0 == null) goto L21;
        ALogger.i("RadioStageContainerWidget", "[RadioMessageComponent] stop--");
        vlc.d r5 = r0.b;
        if (r5 == null) goto L7;
        r5.removeMessageListener(r0);
    L7:
        jk0.b r6 = r0.a;
        if (r6 == null) goto L11;
        r6.onStop();
    L11:
        if (gh0.a.d() == true) goto L13;
    L20:
        r0.e = false;
        goto L21
    L13:
        if (r0.e == false) goto L20;
        LinkedHashMap r7 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r7, null, null, 6);
        r7.put("duration", String.valueOf((int) ((System.currentTimeMillis() - r0.c) / ((long) 1000))));
        Long r8 = r0.d;
        if (r8 == null) goto L18;
        String r9 = String.valueOf(r8.longValue());
        if (r9 == null) goto L18;
    L19:
        r7.put("choose_gift_id", r9);
        j0.l().sendLog("livesdk_anchor_leave_message_on_wall_function_close", r7, new Object[]{IRoom.class});
    L18:
        r9 = "";
    L21:
        m r1 = this.b;
        if (r1 == null) goto L24;
        r1.k();
    L24:
        k r2 = this.c;
        if (r2 == null) goto L28;
        r2.d = false;
        r2.e = false;
        r2.i("destroy");
    L28:
        if (this.a == null) goto L30;
        ALogger.i("RadioStageContainerWidget", "[RadioMessageComponent] onDestroy--");
    L30:
        m r3 = this.b;
        if (r3 == null) goto L33;
        r3.k();
        r3.d = 0;
        r3.e = true;
        r3.f = null;
    L33:
        this.e.dispose();
    }

    public final bn0.b getMultiLinkRoomScope() {
        return this.j;
    }

    @Override // qd0.f
    public final void Fh(t.a r3) {
        Intrinsics.checkNotNullParameter(r3, "handleInteractCallback");
        ALogger.i("RadioStageContainerWidget", "stopEngineNotFinish-- currentScene:" + je0.d.f() + " isRtcEngineOn:" + isRtcEngineOn() + " isInPk:" + wq());
        m r0 = this.b;
        if (r0 == null) goto L5;
        r0.k();
    L5:
        r3.onSuccess();
    }

    @Override // jk0.c
    public final JsonObject T(ih0.e r5) {
        Intrinsics.checkNotNullParameter(r5, "getStatusData");
        JsonObject r0 = r5.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        String r2 = r5.b;
        if (f.b[r5.getType().ordinal()] == 1) goto L8;
        return null;
    L8:
        JsonElement r6 = this.i.get(r2 + '_' + r0.get("key").getAsString());
        JsonObject r1 = new JsonObject();
        r1.add("value", r6);
        return r1;
    }

    @Override // jk0.c
    public final void Xn(LinkMultiControlWidget.f r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Context r0 = ((Widget) this).context;
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 4;
        r1.d = "切换其他房间模式留言将会清空，是否确认切换";
        i r2 = new i(r5);
        x0.c[] r6 = r1.g;
        x0.c r3 = r6[0];
        if (r3 != null) goto L5;
        r3 = new x0.c();
        r6[0] = r3;
    L5:
        r3.a = "是";
        r3.b = r2;
        j r4 = j.a;
        x0.c r7 = r6[1];
        if (r7 != null) goto L8;
        r7 = new x0.c();
        r6[1] = r7;
    L8:
        r7.a = "否";
        r7.b = r4;
        x0 r8 = new x0(r1.b, r1);
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
    }

    public final <T extends dn0.b> T getScopeServiceInMultiLinkRoom(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceType");
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        bn0.b r1 = this.j;
        Intrinsics.checkNotNull(r1);
        Object r4 = r0.d(r1, r3);
        Intrinsics.checkNotNull(r4);
        return (T) r4;
    }

    public final <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceType");
        bn0.b r0 = this.j;
        if (r0 == null) goto L6;
        com.bytedance.android.scope.m r1 = com.bytedance.android.scope.m.e;
        Intrinsics.checkNotNull(r0);
        return (T) r1.d(r0, r3);
    L6:
        return null;
    }

    @Override // jk0.c
    public final void il(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "extraObject");
        if (je0.d.r() == true) goto L11;
        int r1 = r4.get("type").getAsInt();
        k r2 = this.c;
        if (r2 == null) goto L11;
        if (r2.d == true) goto L11;
        if (r1 != SubtitleEventType.CONTENT.ordinal()) goto L11;
        p9();
    L11:
        k r3 = this.c;
        if (r3 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "extraObject");
        r3.f(r4);
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getKey()) == false) goto L7;
        return;
    L7:
        if (r5.getData() != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r5.getKey(), "cmd_pk_state_change") == false) goto L24;
        Object r6 = r5.getData();
        Intrinsics.checkNotNull(r6);
        int r7 = ((z0) r6).a;
        if (r7 != 0) goto L15;
        ALogger.i("RadioStageContainerWidget", "onPkStateChanged--to pk mode");
        return;
    L15:
        if (r7 != 1) goto L26;
        boolean r8 = wq();
        ALogger.i("RadioStageContainerWidget", "onPkStateChanged--to normal mode currentScene:" + je0.d.f() + " isRtcEngineOn:" + isRtcEngineOn() + " isInPk:" + r8);
        if (r8 == true) goto L27;
        m r9 = this.b;
        if (r9 == null) goto L28;
        m.j(r9);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        StringBuilder r0 = new StringBuilder("onConfigurationChanged isPadABon:");
        r0.append(PadConfigUtils.c());
        r0.append(", orientation:");
        if (r3 == null) goto L5;
        Integer r1 = Integer.valueOf(r3.orientation);
    L6:
        r0.append(r1);
        ALogger.i("RadioStageContainerWidget", r0.toString());
        if (PadConfigUtils.c() == true) goto L9;
        return;
    L9:
        if (qi() == false) goto L20;
        if (r3 == null) goto L14;
        boolean r2 = true;
        if (r3.orientation != 1) goto L14;
    L15:
        k r4 = this.c;
        if (r4 == null) goto L21;
        r4.a(r2);
        return;
    L21:
        return;
    L14:
        r2 = false;
        goto L15
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onEvent(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        int r3 = r2.a;
        if (r3 == 30) goto L13;
        if (r3 == 31) goto L8;
        return;
    L8:
        if (qi() == false) goto L18;
        k r4 = this.c;
        if (r4 == null) goto L19;
        r4.g();
        return;
    L19:
        return;
    L18:
        return;
    L13:
        if (qi() == false) goto L21;
        k r5 = this.c;
        if (r5 == null) goto L22;
        r5.c();
        return;
    L22:
        return;
    }

    public final void setMultiLinkRoomScope(bn0.b r1) {
        this.j = r1;
    }

    @Override // jk0.c
    public final void yk(ViewGroup r5) {
        k r0 = this.c;
        if (r0 == null) goto L38;
        ALogger.i("RadioStageContainerWidget", "changeRootContainer rootContainer:" + r5 + " isMainCardLoaded:" + r0.b());
        if (r0.b() == false) goto L39;
        int r1 = w0.a;
        View r2 = null;
        if (w0.d(r0.g) == false) goto L14;
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L13;
        ih0.b r4 = r3.dynamicService(r0.h);
        if (r4 == null) goto L13;
        ih0.c r6 = r4.oo();
    L15:
        if (r5 != null) goto L17;
        r5 = r0.i;
    L17:
        if (r6 == null) goto L19;
        View r7 = r6.S0();
    L20:
        if (r7 == null) goto L22;
        ViewParent r8 = r7.getParent();
    L23:
        if (r8 == null) goto L29;
        ViewParent r9 = r7.getParent();
        if (r9 == null) goto L28;
        ((FrameLayout) r9).removeView(r7);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L29:
        FrameLayout r10 = (FrameLayout) r5.findViewById(2131370477);
        if (r10 == null) goto L32;
        r10.setVisibility(0);
    L32:
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, -1);
        if (r10 == null) goto L40;
        if (r6 == null) goto L36;
        r2 = r6.S0();
    L36:
        r10.addView(r2, r11);
        return;
    L40:
        return;
    L22:
        r8 = null;
        goto L23
    L19:
        r7 = null;
    L13:
        r6 = null;
        goto L15
    L14:
        r6 = r0.b;
        goto L15
    L39:
        return;
    }

    @Override // jk0.c
    public final void A6(String r9, JsonObject r10) {
        Intrinsics.checkNotNullParameter("onLinkmicStatusChange", "name");
        Intrinsics.checkNotNullParameter(r9, "eventType");
        Intrinsics.checkNotNullParameter(r10, "data");
        if (qi() == false) goto L64;
        ALogger.i("RadioStageContainerWidget", "sendJsEvent-- eventType:" + r9);
        if (r9.hashCode() == (-1753865563)) goto L8;
    L52:
        k r11 = this.c;
        if (r11 == null) goto L65;
        Intrinsics.checkNotNullParameter("onLinkmicStatusChange", "name");
        Intrinsics.checkNotNullParameter(r10, "data");
        int r1 = w0.a;
        if (w0.d(r11.g) == true) goto L66;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r12 = r11.b;
        if (r12 == null) goto L67;
        r12.sendJsEvent("onLinkmicStatusChange", r10);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L8:
        if (r9.equals("guest_list") == false) goto L52;
        JsonObject r13 = r10.get("data");     // Catch: Exception -> L51
        JsonElement r5 = null;
        Object r6 = null;
        if (r13 == null) goto L12;
        JsonElement r14 = r13.get("guest_list");     // Catch: Exception -> L51
    L13:
        JsonArray r15 = (JsonArray) r14;     // Catch: Exception -> L51
        if (r15 == null) goto L38;
        Iterator r16 = r15.iterator();     // Catch: Exception -> L51
    L17:
        if (r16.hasNext() == false) goto L37;
        Object r3 = r16.next();     // Catch: Exception -> L51
        JsonElement r7 = ((JsonElement) r3).getAsJsonObject().get("user");     // Catch: Exception -> L51
        if (r7 == null) goto L25;
        JsonObject r8 = r7.getAsJsonObject();     // Catch: Exception -> L51
        if (r8 == null) goto L25;
        JsonElement r17 = r8.get("id_str");     // Catch: Exception -> L51
        if (r17 == null) goto L25;
        String r18 = r17.getAsString();     // Catch: Exception -> L51
    L26:
        com.bytedance.live.datacontext.m r19 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();     // Catch: Exception -> L51
        if (r19 == null) goto L33;
        IRoom r20 = (IRoom) r19.getValue();     // Catch: Exception -> L51
        if (r20 == null) goto L33;
        IBaseUser r21 = r20.getOwner();     // Catch: Exception -> L51
        if (r21 == null) goto L33;
        String r22 = r21.getUserId();     // Catch: Exception -> L51
    L35:
        if (Intrinsics.areEqual(r18, r22) == false) goto L17;
        r6 = r3;
    L33:
        r22 = null;
    L25:
        r18 = null;
    L37:
        r5 = (JsonElement) r6;     // Catch: Exception -> L51
    L38:
        if (r5 == null) goto L52;
        boolean r4 = true;
        if (r5.getAsJsonObject().get("is_afk").getAsBoolean() == true) goto L43;
        r4 = false;
    L43:
        if (r4 == false) goto L47;
        k r23 = this.c;     // Catch: Exception -> L51
        if (r23 == null) goto L52;
        r23.c();     // Catch: Exception -> L51
        goto L52
    L47:
        k r24 = this.c;     // Catch: Exception -> L51
        if (r24 == null) goto L52;
        r24.g();     // Catch: Exception -> L51
        goto L52
    L12:
        r14 = null;
    L51:
        ALogger.e("RadioStageContainerWidget", "EventType_Guest_List parse error");
        goto L52
    }

    public RadioStageContainerWidget(ViewGroup r2, k0 r3, ih0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r3, "stateChangeCallback");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.e = new CompositeDisposable();
        this.i = new JsonObject();
    }

    @Override // jk0.c
    public final void updateLinkMicStatus(ih0.f r17, ih0.h r18, IJsBridgeManager r19) {
        Intrinsics.checkNotNullParameter(r17, "updateStatus");
        Intrinsics.checkNotNullParameter(r18, "updateCallback");
        JsonObject r4 = r17.d;
        String r5 = r17.c;
        ALogger.i("RadioStageContainerWidget", "updateLinkMicStatus-- updateStatus:" + r17.getType() + " updateExtraInfo:" + r4);
        int r6 = f.a[r17.getType().ordinal()];
        String r8 = "";
        if (r6 == 1) goto L61;
        if (r6 == 2) goto L13;
        if (r6 != 3) goto L98;
        JsonObject r0 = r17.d;
        if (r0 == null) goto L87;
        this.i.add(r5 + '_' + r0.get("key").getAsString(), r0.get("data"));
        return;
    L87:
        return;
    L98:
        return;
    L13:
        if (this.d != null) goto L15;
        this.d = new MultiLinkAsrManager(((Widget) this).context, ((Widget) this).dataCenter);
    L15:
        MultiLinkAsrManager r1 = this.d;
        if (r1 == null) goto L89;
        Intrinsics.checkNotNullParameter(r18, "updateCallback");
        if (r4 != null) goto L20;
        ALogger.e("RadioStageContainerWidget", "[MultiLinkAsrManager] handleStartAudioAsr--extraInfo is null");
        r18.a(UpdateLinkmicStatusResultModel.Code.Failed, "error param", null);
        return;
    L20:
        int r7 = r4.get("type").getAsInt();
        if (r7 != 1) goto L41;
        MultiLinkAsrManager.a r9 = new MultiLinkAsrManager.a();
        r9.d(r4.get("appId").getAsString());
        r9.e(r4.get("appToken").getAsString());
        r9.f(r4.get("cluster").getAsString());
        if (NetworkUtils.f(r1.d) == true) goto L25;
        r18.a(UpdateLinkmicStatusResultModel.Code.Failed, "network unreachable", null);
        return;
    L25:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = "";
        com.bytedance.android.live.liveinteract.voicechat.radio.asr.j r11 = new com.bytedance.android.live.liveinteract.voicechat.radio.asr.j(r1, r19, r10);
        if (r1.b != null) goto L28;
        r1.b = new com.bytedance.android.live.liveinteract.voicechat.radio.asr.k(r9);
    L28:
        com.bytedance.android.live.liveinteract.voicechat.radio.asr.k r12 = r1.b;
        if (r12 == null) goto L32;
        Intrinsics.checkNotNullParameter(r11, "listener");
        r12.g = r11;
    L32:
        if (m60.c.b(r1.d, com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.m) == true) goto L39;
        Context r2 = r1.d;
        if ((r2 instanceof Activity) == false) goto L40;
        if (r2 == null) goto L38;
        SettingKey r13 = m60.i.a;
        new m60.i.b((Activity) r2).b(new com.bytedance.android.live.liveinteract.voicechat.radio.asr.d(), null, com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.n, new String[]{"android.permission.RECORD_AUDIO"});
        goto L40
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L40:
        r18.a(UpdateLinkmicStatusResultModel.Code.Success, "success", null);
        return;
    L39:
        ALogger.i("RadioStageContainerWidget", "[AsrRecord] initAsrAndStart--");
        MainThreadPostUtils.b((Runnable) r1.c.getValue());
        goto L40
    L41:
        if (r7 != 2) goto L93;
        ALogger.i("RadioStageContainerWidget", "[AsrRecord] stopAsr--");
        MainThreadPostUtils.d((Runnable) r1.c.getValue());
        com.bytedance.android.live.liveinteract.voicechat.radio.asr.k r14 = r1.b;
        if (r14 == null) goto L59;
        r14.f = true;
        com.bytedance.android.live.liveinteract.voicechat.radio.asr.b r3 = r14.a;
        if (r3 == null) goto L56;
        TokenCert r15 = com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.p;
        Intrinsics.checkNotNullParameter(r15, "cert");
        AudioRecord r16 = r3.c;     // Catch: BPEAException -> L52 IllegalStateException -> L54
        if (r16 == null) goto L50;
        g80.a.e(r16, r15);     // Catch: BPEAException -> L52 IllegalStateException -> L54
    L50:
        r3.f = 1;     // Catch: BPEAException -> L52 IllegalStateException -> L54
    L54:
        e = move-exception;
        f72.a.b("Stop Record Exception: " + e.getMessage());
    L52:
        e = move-exception;
        f72.a.b("Stop Record BPEAException: " + e.getMessage());
    L56:
        Handler r20 = r14.d;
        if (r20 == null) goto L59;
        r20.sendMessage(r20.obtainMessage(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER));
    L59:
        q60.a r110 = q60.a.d;
        Map r111 = MapsKt.mapOf(new Pair("type", "move_up"));
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r112 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r113 = new com.bytedance.android.live.core.privacy.av.api.a();
        r113.d();
        Unit r21 = Unit.INSTANCE;
        r110.c("community", "audio_comment", r111, r112, r113);
        r18.a(UpdateLinkmicStatusResultModel.Code.Success, "success", null);
        return;
    L93:
        return;
    L89:
        return;
    L61:
        if (je0.d.f() != 0) goto L95;
        JsonObject r22 = r17.d;
        if (r22 == null) goto L67;
        JsonElement r23 = r22.get("type");
        if (r23 == null) goto L67;
        int r24 = r23.getAsInt();
    L69:
        if (r24 == SubtitleUpdateType.OPEN_SUBTITLE_SETTING_PANEL.ordinal()) goto L71;
        return;
    L71:
        if (je0.d.r() == true) goto L73;
        return;
    L73:
        JsonObject r25 = r17.d;
        if (r25 == null) goto L81;
        JsonElement r26 = r25.get("request_page");
        if (r26 == null) goto L81;
        String r27 = r26.getAsString();
        if (r27 == null) goto L81;
        r8 = r27;
    L81:
        IAudioSubtitleContent r28 = (IAudioSubtitleContent) b6.p0.getValue();
        if (r28 == null) goto L97;
        ((IInteractService) jc1.k.n(IInteractService.class)).openLinkmicSubtitleSettingDialog(((Widget) this).context, r8, r28);
        return;
    L97:
        return;
    L67:
        r24 = SubtitleUpdateType.UNKNOWN.ordinal();
        goto L69
    }
}
