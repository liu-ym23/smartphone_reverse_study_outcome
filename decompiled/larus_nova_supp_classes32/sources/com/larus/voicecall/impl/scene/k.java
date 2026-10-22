package com.larus.voicecall.impl.scene;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.MutableLiveData;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.z0;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;
import t19.s;
import tx9.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements b, a {
    public final l a;
    public final List<SceneModel> b;
    public final e3a.a c;
    public final e3a.b d;
    public final ArrayList<m> e;
    public final MutableLiveData<m> f;
    public final ArrayList<o> g;
    public final Handler h;
    public final String i;
    public boolean j;
    public long k;
    public boolean l;
    public boolean m;
    public boolean n;

    @Override // com.larus.voicecall.impl.scene.a
    public final void b() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void c() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void e(String r1, String r2) {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void g() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void k() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void m() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onInterrupt() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onRelease() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void d() {
        FLogger r0 = FLogger.a;
        r0.i(this.i, "[onSessionStartFailed] currentSceneHasSuccess : " + this.j);
        this.h.removeCallbacksAndMessages(null);
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l != null) goto L6;
        r0.i(this.i, "[onSessionStartFailed] not in scene mode");
        return;
    L6:
        this.l = true;
        if (this.j == false) goto L10;
        return;
    L10:
        if (this.n == false) goto L13;
        this.n = false;
        r0.i(this.i, "[onSessionStartFailed] fromDirectJump, skip exitScene");
        return;
    L13:
        h(true, "switch_scene_failed");
        s r1 = s.a;
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        r1.getClass();
        s.s(r2, 2131910235);
    }

    @Override // com.larus.voicecall.impl.scene.b
    public final void n() {
        this.a.k1();
    }

    @Override // com.larus.voicecall.impl.scene.b
    public final List<m> a() {
        return this.e;
    }

    @Override // com.larus.voicecall.impl.scene.b
    public final MutableLiveData getCurrentScene() {
        return this.f;
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void j(a78.a r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
    }

    @Override // com.larus.voicecall.impl.scene.b
    public final void R3(final m r13, final int r14) {
        Intrinsics.checkNotNullParameter(r13, "item");
        if (((h88.a) this.c).k0 == true) goto L5;
    L8:
        com.larus.voicecall.impl.degrade.h.a.getClass();
        if (com.larus.voicecall.impl.degrade.h.b("voice_call", "voice_button", true) == true) goto L12;
        FLogger.a.i(this.i, "[switchScene] quota limit item=" + r13.a.getKey());
        return;
    L12:
        FLogger r0 = FLogger.a;
        String r1 = this.i;
        StringBuilder r2 = new StringBuilder("[switchScene] item:");
        r2.append(r13);
        r2.append(", current:");
        RealtimeCallUtil.a.getClass();
        r2.append(RealtimeCallUtil.l);
        r0.i(r1, r2.toString());
        if (this.k != (-1)) goto L15;
        this.k = System.currentTimeMillis();
        long r3 = 0;
    L16:
        o r4 = RealtimeCallUtil.l;
        o r5 = null;
        if (r4 == null) goto L21;
        SceneModel r6 = r4.a;
        if (r6 == null) goto L21;
        String r7 = r6.getKey();
    L23:
        if (Intrinsics.areEqual(r7, r13.a.getKey()) == true) goto L45;
        o r8 = RealtimeCallUtil.l;
        if (r8 == null) goto L30;
        SceneModel r9 = r8.a;
        if (r9 == null) goto L30;
        String r10 = r9.getKey();
        if (r10 == null) goto L30;
    L31:
        String r11 = r10;
        String r12 = r13.a.getKey();
        long r15 = z0.c(RealtimeCallUtil.z);
        RealtimeCallParam r16 = this.a.i2();
        if (r16 == null) goto L36;
        RealtimeCallParam.p r17 = r16.o;
        if (r17 == null) goto L36;
        String r18 = r17.c;
    L37:
        JSONObject r19 = new JSONObject();
        if (this.d.a().p.q == false) goto L40;
    L43:
        String r20 = "1";
    L44:
        r19.put("is_continuous_speak", r20);
        r19.put("call_id", this.d.a().e);
        k3.a(Long.valueOf(r3), r11, r12, Long.valueOf(r15), r18, "call_scene_button", r19, 272);
        goto L45
    L40:
        if (this.d.a().a == true) goto L43;
        r20 = "0";
    L36:
        r18 = null;
    L30:
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L45:
        this.a.E0(false);
        Iterator<o> r21 = this.g.iterator();
    L47:
        if (r21.hasNext() == false) goto L54;
        o r22 = r21.next();
        if (r22.a.getId() != r13.a.getId()) goto L51;
        boolean r23 = true;
    L52:
        if (r23 == false) goto L47;
        r5 = r22;
        goto L54
    L51:
        r23 = false;
    L54:
        RealtimeCallUtil.l = r5;
        this.j = false;
        this.h.postDelayed(new j(this, r13, r14), 300);
        this.a.Z(r13.a, this.l, Integer.valueOf(r14));
        return;
    L21:
        r7 = null;
        goto L23
    L15:
        r3 = System.currentTimeMillis() - this.k;
        goto L16
    L5:
        if (this.m == false) goto L8;
        FLogger.a.w(this.i, "[switchScene] switch scene while exiting scene");
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionId");
        Intrinsics.checkNotNullParameter(r3, "queryRound");
    }

    @Override // com.larus.voicecall.impl.scene.b
    public final void h(boolean r17, String r18) {
        FLogger r3 = FLogger.a;
        String r4 = this.i;
        StringBuilder r5 = new StringBuilder("[exitScene] current:");
        RealtimeCallUtil.a.getClass();
        r5.append(RealtimeCallUtil.l);
        r3.i(r4, r5.toString());
        if (r17 == true) goto L98;
        o r6 = RealtimeCallUtil.l;
        if (r6 == null) goto L9;
        SceneModel r7 = r6.a;
        if (r7 == null) goto L9;
        String r8 = r7.getKey();
    L10:
        RealtimeCallParam r9 = this.a.i2();
        if (r9 == null) goto L15;
        RealtimeCallParam.p r10 = r9.o;
        if (r10 == null) goto L15;
        String r11 = r10.h;
    L16:
        RealtimeCallParam r12 = this.a.i2();
        if (r12 == null) goto L21;
        RealtimeCallParam.p r13 = r12.o;
        if (r13 == null) goto L21;
        String r14 = r13.c;
    L22:
        RealtimeCallParam r15 = this.a.i2();
        if (r15 == null) goto L25;
        String r16 = r15.e;
    L26:
        RealtimeCallParam r19 = this.a.i2();
        if (r19 == null) goto L31;
        RealtimeCallParam.k r110 = r19.p;
        if (r110 == null) goto L31;
        String r111 = r110.g;
    L33:
        if (RealtimeCallUtil.z == false) goto L35;
    L38:
        boolean r112 = true;
    L39:
        long r113 = z0.c(r112);
        RealtimeCallParam r114 = this.a.i2();
        if (r114 == null) goto L46;
        RealtimeCallParam.k r115 = r114.p;
        if (r115 == null) goto L46;
        RealtimeCallParam.c r116 = r115.o;
        if (r116 == null) goto L46;
        String r117 = r116.d;
    L47:
        RealtimeCallParam r118 = this.a.i2();
        if (r118 == null) goto L54;
        RealtimeCallParam.k r119 = r118.p;
        if (r119 == null) goto L54;
        RealtimeCallParam.c r120 = r119.o;
        if (r120 == null) goto L54;
        String r121 = r120.a;
    L55:
        RealtimeCallParam r122 = this.a.i2();
        if (r122 == null) goto L60;
        RealtimeCallParam.k r123 = r122.p;
        if (r123 == null) goto L60;
        String r124 = r123.i;
    L61:
        JSONObject r20 = new JSONObject();
        RealtimeCallParam r21 = this.a.i2();
        if (r21 == null) goto L64;
        String r22 = r21.d;
    L65:
        r20.put("room_id", r22);
        if (this.d.a().p.q == false) goto L68;
    L71:
        String r23 = "1";
    L72:
        r20.put("is_continuous_speak", r23);
        Long r24 = Long.valueOf(r113);
        Intrinsics.checkNotNullParameter(r20, LynxResourceModule.PARAMS_KEY);
        if (r8 != null) goto L109;
    L77:
        if (r18 == null) goto L79;
        r20.put("leave_method", r18);     // Catch: JSONException -> L75
    L79:
        if (r11 == null) goto L81;
        r20.put("bot_id", r11);     // Catch: JSONException -> L75
    L81:
        if (r16 == null) goto L83;
        r20.put("call_id", r16);     // Catch: JSONException -> L75
    L83:
        if (r14 == null) goto L85;
        r20.put("conversation_id", r14);     // Catch: JSONException -> L75
    L85:
        if (r111 == null) goto L87;
        r20.put("chat_type", r111);     // Catch: JSONException -> L75
    L87:
        if (r24 == null) goto L89;
        r20.put("is_subtitles_mode", r24.longValue());     // Catch: JSONException -> L75
    L89:
        if (r124 == null) goto L91;
        r20.put("call_enter_method", r124);     // Catch: JSONException -> L75
    L91:
        if (r121 == null) goto L93;
        r20.put("action_bar_item_id", r121);     // Catch: JSONException -> L75
    L93:
        if (r117 == null) goto L97;
        r20.put("action_bar_key", r117);     // Catch: JSONException -> L75
    L75:
        e = move-exception;
        FLogger.a.e("LeaveEventHelper", "error in LeaveEventHelper mobLeaveCallScene " + e.getLocalizedMessage());
    L97:
        TrackParams r0 = new TrackParams().merge(r20);
        by7.a r25 = new by7.a("leave_call_scene");
        r25.a.merge(r0);
        r25.b();
        goto L98
    L109:
        r20.put("from_call_scene", r8);     // Catch: JSONException -> L75
        goto L77
    L68:
        if (this.d.a().a == true) goto L71;
        r23 = "0";
        goto L72
    L64:
        r22 = null;
    L60:
        r124 = null;
    L54:
        r121 = null;
    L46:
        r117 = null;
        goto L47
    L35:
        if (((h88.b) this.d).u == RealtimePageMode.HALF_SCREEN) goto L38;
        r112 = false;
    L31:
        r111 = null;
        goto L33
    L25:
        r16 = null;
    L21:
        r14 = null;
    L15:
        r11 = null;
    L9:
        r8 = null;
    L98:
        this.k = -1;
        this.h.removeCallbacksAndMessages(null);
        this.j = false;
        if (((h88.a) this.c).k0 == true) goto L101;
        this.f.postValue(null);
    L101:
        this.m = true;
        Iterator<o> r1 = this.g.iterator();
    L103:
        if (r1.hasNext() == false) goto L107;
        o r26 = r1.next();
        if (r26.d == false) goto L103;
        t0.b.removeCallbacks(r26.c);
        r26.d = false;
        goto L103
    L107:
        this.a.E0(r17);
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.l = null;
        this.a.Z(null, this.l, null);
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void i(Integer r7, boolean r8) {
        FLogger r0 = FLogger.a;
        r0.i(this.i, "[onSessionStartSuccess], fromRetry:" + r8);
        boolean r1 = this.n;
        this.n = false;
        m r4 = null;
        this.h.removeCallbacksAndMessages(null);
        if (((h88.a) this.c).k0 == true) goto L5;
    L7:
        this.m = false;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l != null) goto L11;
        r0.i(this.i, "[onSessionStartSuccess] not in scene mode");
        return;
    L11:
        if (r8 == true) goto L13;
    L15:
        RealtimeCallParam r9 = this.a.i2();
        if (r9 == null) goto L20;
        RealtimeCallParam.k r10 = r9.p;
        if (r10 == null) goto L20;
        String r11 = r10.i;
    L22:
        if (Intrinsics.areEqual(r11, "chat_action_bar") == false) goto L25;
        if (r1 == false) goto L25;
        this.a.T1();
    L25:
        this.j = true;
        this.l = false;
        Iterator<m> r2 = this.e.iterator();
    L27:
        if (r2.hasNext() == false) goto L38;
        m r3 = r2.next();
        m r5 = r3;
        RealtimeCallUtil.a.getClass();
        o r6 = RealtimeCallUtil.l;
        if (r6 == null) goto L35;
        SceneModel r12 = r6.a;
        if (r12 == null) goto L35;
        if (r5.a.getId() != r12.getId()) goto L35;
        boolean r13 = true;
    L36:
        if (r13 == false) goto L27;
        r4 = r3;
    L35:
        r13 = false;
    L38:
        m r14 = r4;
        if (r14 != null) goto L41;
        return;
    L41:
        this.f.postValue(m.a(r14, 2, r7, 25));
        return;
    L20:
        r11 = null;
        goto L22
    L13:
        if (this.j == true) goto L15;
        this.a.G1();
        goto L15
    L5:
        if (this.m == false) goto L7;
        this.f.postValue(null);
        goto L7
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void l(boolean r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "asrTaskId");
    }

    public k(com.larus.voicecall.impl.plugins.n r9, List r10, LifecycleCoroutineScope r11, e3a.a r12, e3a.b r13) {
        Intrinsics.checkNotNullParameter(r9, "impl");
        Intrinsics.checkNotNullParameter(r10, "list");
        Intrinsics.checkNotNullParameter(r11, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r12, "argumentData");
        Intrinsics.checkNotNullParameter(r13, "runtimeData");
        this.a = r9;
        this.b = r10;
        this.c = r12;
        this.d = r13;
        ArrayList<m> r14 = new ArrayList();
        this.e = r14;
        this.f = new MutableLiveData(null);
        ArrayList<o> r15 = new ArrayList();
        this.g = r15;
        this.h = new Handler(Looper.getMainLooper());
        this.i = "RealtimeCallSceneManager";
        this.k = -1;
        BuildersKt.launch$default(r11, null, null, new RealtimeCallSceneManager$1(this, null), 3, null);
        r14.clear();
        r15.clear();
        Iterator r16 = r10.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        SceneModel r1 = (SceneModel) r16.next();
        e3a.a r17 = this.c;
        boolean r5 = ((h88.a) r17).P;
        m r18 = new m(r1, 0, null, ((h88.a) r17).Q, r5);
        this.e.add(r18);
        this.g.add(new o(r18.a, this.a));
        goto L4
    }
}
