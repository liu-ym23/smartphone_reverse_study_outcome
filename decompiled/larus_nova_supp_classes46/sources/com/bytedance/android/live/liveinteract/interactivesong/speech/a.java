package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSDataContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonObject;
import fd2.t;
import fd2.v;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int m = 0;
    public boolean a;
    public kd2.b b;
    public final Map<String, kd2.b> c;
    public final CompositeDisposable d;
    public long e;
    public boolean f;
    public final Lazy g;
    public final IRoom h;
    public final boolean i;
    public final DataCenter j;
    public final j1 k;
    public final t l;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interactivesong.speech.a$a, reason: collision with other inner class name */
    public static final class C0035a {
    }

    public static final class b implements t {
        public final /* synthetic */ a a;

        public final void a() {
            a.a(this.a, false);
        }

        public final void c() {
            a.a(this.a, true);
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void d(boolean r2) {
            t r0 = this.a.l;
            if (r0 == null) goto L6;
            r0.d(r2);
            return;
        }

        public final void b(String r2, Integer r3) {
            t r0 = this.a.l;
            if (r0 == null) goto L6;
            r0.b(r2, r3);
            return;
        }
    }

    static {
    }

    public static String b() {
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L8;
        String r2 = r1.n();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public static boolean e() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L7;
        v r2 = (v) r1.getValue();
    L9:
        if (r2 != null) goto L11;
    L12:
        if (r2 != null) goto L14;
    L16:
        return false;
    L14:
        if (r2.c() != true) goto L16;
        return true;
    L11:
        if (r2.h() != true) goto L12;
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public final cg6.a c() {
        return this.k.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public final void h() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L7;
        v r2 = (v) r1.getValue();
    L9:
        if (this.a == false) goto L43;
        cg6.a r3 = c();
        if (r3 == null) goto L30;
        g r4 = r3.getRtcManager();
        if (r4 == null) goto L30;
        if (r4.A() != true) goto L30;
        if (this.i == true) goto L19;
    L20:
        int r5 = h.t().b();
        cg6.a r6 = c();
        if (r6 == null) goto L30;
        g r7 = r6.getRtcManager();
        if (r7 == null) goto L30;
        ei6.a r8 = r7.V0();
        if (r8 == null) goto L30;
        ri6.b r9 = r8.r();
        if (r9 == null) goto L30;
        r9.e(r5);
        goto L30
    L19:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L20;
    L30:
        if (this.i == false) goto L40;
        if (r2 == null) goto L33;
        r2.initEngine();
    L33:
        RTSDataContext r10 = RTSDataContext.Companion.getContext();
        if (r10 == null) goto L40;
        n<String> r11 = r10.getAedStateEvent();
        if (r11 == null) goto L40;
        String r12 = (String) r11.getValue();
        if (r12 == null) goto L40;
        d(r12);
    L40:
        if (r2 == null) goto L44;
        r2.m(new b(this));
        return;
    L44:
        return;
    L43:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void g() {
        long r0 = (System.currentTimeMillis() - this.e) / ((long) 1000);
        if (r0 <= h.t().c()) goto L10;
        HashMap r2 = new HashMap();
        if (this.f == false) goto L7;
        String r3 = "1";
    L8:
        r2.put("is_recognition_success", r3);
        r2.put("aed_duration", String.valueOf(r0));
        j0.l().sendLog("livesdk_anchor_ai_lyric_one_song_recognition", r2, new Object[]{IRoom.class});
        return;
    L7:
        r3 = "2";
        goto L8
    }

    public final void d(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
    L13:
        JSONObject r8 = new JSONObject(r7).optJSONObject("aed_report");
        if (r8 == null) goto L45;
        int r3 = r8.optInt("aed_state");
        String r4 = r8.optString("send_user_id");
        String r9 = r8.optString("send_interact_id");
        ALogger.i("SpeechRecognitionProxy", "handleGuestAedStateChanged, sendUserId: " + r4 + ", sendUserInteractId: " + r9 + ", AED state: " + r3);
        if (r9 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L51;
        kd2.b r6 = (kd2.b) ((LinkedHashMap) this.c).get(r9);
        if (r6 != null) goto L28;
        this.c.put(r9, new kd2.b(0, r3));
        return;
    L28:
        if (r6.a(r3) == true) goto L30;
        return;
    L30:
        if (r6.b() != true) goto L35;
        if (e() == true) goto L48;
        i(r9, false);
        return;
    L48:
        return;
    L35:
        if (f(r9) == true) goto L50;
        InteractiveSongContext r10 = InteractiveSongContext.Companion.getContext();
        if (r10 == null) goto L43;
        n<v> r11 = r10.getLyricsRecognizer();
        if (r11 == null) goto L43;
        v r12 = (v) r11.getValue();
        if (r12 == null) goto L43;
        r12.i();
    L43:
        g();
        return;
    L50:
        return;
    L51:
        return;
    L18:
        if (StringsKt.isBlank(r9) == true) goto L21;
        r5 = false;
        goto L22
    L45:
        return;
    L11:
        if (this.a == true) goto L13;
        return;
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean f(String r5) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r0.next();
        if ((!Intrinsics.areEqual((String) r1.getKey(), r5)) == false) goto L4;
        kd2.b r2 = (kd2.b) r1.getValue();
        if (r2 == null) goto L4;
        if (r2.b() != true) goto L4;
        return true;
    L12:
        return false;
    }

    public final void j(boolean r3) {
        cg6.a r0 = c();
        if (r0 == null) goto L11;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L11;
        ei6.a r2 = r1.V0();
        if (r2 == null) goto L11;
        ri6.b r4 = r2.r();
        if (r4 == null) goto L11;
        r4.x();
    L11:
        ((LinkedHashMap) this.c).clear();
        this.b = new kd2.b(0, 0);
        InteractiveSongContext r5 = InteractiveSongContext.Companion.getContext();
        if (r5 == null) goto L18;
        n<v> r6 = r5.getLyricsRecognizer();
        if (r6 == null) goto L18;
        v r7 = (v) r6.getValue();
        if (r7 == null) goto L18;
        r7.destroyEngine();
    L18:
        if (r3 == false) goto L21;
        this.d.clear();
        return;
    }

    public static final void a(a r5, boolean r6) {
        r5.getClass();
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(SubtitleEventType.SHOW_LYRICS.ordinal()));
        r0.addProperty("show_recognition_lyrics", Boolean.valueOf(r6));
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L7;
        ih0.b r2 = r1.dynamicService(r5.j);
        if (r2 == null) goto L7;
        r2.Dk("audiochat_stage", "subtitle", r0, false);
    L7:
        if (r6 == false) goto L10;
        r5.f = true;
        return;
    }

    public final void i(String r7, boolean r8) {
        IRoom r0 = this.h;
        boolean r2 = true;
        if (r0 == null) goto L11;
        Map r1 = r0.getAnchorABMap();
        if (r1 == null) goto L11;
        String r3 = (String) r1.get("linkmic_order_sing_ai_mv");
        if (r3 == null) goto L11;
        if (CastIntegerProtector.parseInt(r3) != 1) goto L11;
        boolean r4 = true;
    L13:
        if (TeamFightContext.Companion.h() == true) goto L64;
        IKtvService r5 = k.f(IKtvService.class);
        if (r5 != null) goto L17;
    L18:
        InteractiveSongContext.a r6 = InteractiveSongContext.Companion;
        if (r6.f() == false) goto L66;
        Integer r9 = je0.d.h();
        if (r9 != null) goto L24;
    L25:
        Integer r10 = je0.d.h();
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L33:
        if (r11 == true) goto L44;
        Integer r12 = je0.d.h();
        if (r12 != null) goto L38;
    L40:
        r2 = false;
    L41:
        if (r2 == false) goto L67;
        if (r4 == true) goto L44;
        return;
    L67:
        return;
    L38:
        if (r12.intValue() != 26) goto L40;
    L44:
        this.e = System.currentTimeMillis();
        this.f = false;
        cg6.a r13 = c();
        com.bytedance.android.live.pushstream.d r14 = null;
        if (r13 == null) goto L47;
        g r15 = r13.getRtcManager();
    L48:
        InteractiveSongContext r16 = r6.getContext();
        if (r16 == null) goto L53;
        n<v> r17 = r16.getLyricsRecognizer();
        if (r17 == null) goto L53;
        v r18 = (v) r17.getValue();
    L54:
        if (r18 == null) goto L68;
        if (r15 == null) goto L57;
        ei6.a r19 = r15.V0();
    L58:
        if (r15 == null) goto L62;
        ec6.b r20 = r15.R();
        if (r20 == null) goto L62;
        r14 = gc6.b.a(r20);
    L62:
        r18.j(r19, r14, new kd2.a(false, r8, r7, 6));
        return;
    L57:
        r19 = null;
        goto L58
    L68:
        return;
    L53:
        r18 = null;
        goto L54
    L47:
        r15 = null;
        goto L48
    L29:
        if (r10.intValue() != 30) goto L31;
    L32:
        r11 = true;
        goto L33
    L24:
        if (r9.intValue() == 27) goto L32;
    L66:
        return;
    L17:
        if (r5.isKtvIsSingingState() != true) goto L18;
        return;
    L64:
        return;
    L11:
        r4 = false;
        goto L13
    }

    public a(IRoom r2, boolean r3, DataCenter r4, j1 r5, InteractiveSongWidget.d r6) {
        Intrinsics.checkNotNullParameter(r5, "outerScopeProvider");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.b = new kd2.b(0, 0);
        this.c = new LinkedHashMap();
        this.d = new CompositeDisposable();
        this.g = LazyKt.lazy(SpeechRecognizerProxy$disableAnchorStream$2.INSTANCE);
    }
}
