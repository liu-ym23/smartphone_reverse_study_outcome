package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import hg6.g;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SpeechRhythm {
    public kd2.b a;
    public final CompositeDisposable b;
    public boolean c;
    public final ConcurrentHashSet<String> d;
    public Boolean e;
    public final j1 f;
    public final DataCenter g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SpeechRhythm a;

        public a(SpeechRhythm r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = ((pv0.c) r2).a;
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            this.a.e(r3);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SpeechRhythm a;

        public b(SpeechRhythm r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            i r4 = (i) r3;
            if (r4.b != 27) goto L5;
            return;
        L5:
            if (this.a.c == false) goto L9;
            ALogger.i("SpeechRhythm", "switch scene: " + r4.a + ", uiLayout: " + r4.b);
            this.a.j("2d_avatar");
            return;
        }
    }

    public static final class c {
    }

    static {
    }

    public static String b() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L7;
        m<String> r1 = r0.getCurrentMvEmoTag();
        if (r1 == null) goto L7;
        return (String) r1.getValue();
    L7:
        return null;
    }

    public static Integer d() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        boolean r1 = true;
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.performance.a r2 = r0.getMultiLinkPerfAbilityManager(true);
        if (r2 == null) goto L7;
        r1 = r2.a("multilink_base_degrade");
    L7:
        if (r1 == false) goto L16;
        InteractiveSongContext r3 = InteractiveSongContext.Companion.getContext();
        if (r3 == null) goto L14;
        m<Integer> r4 = r3.getCurrentIsInSongRefrain();
        if (r4 == null) goto L14;
        return (Integer) r4.getValue();
    L14:
        return null;
    L16:
        return 0;
    }

    private final int getType() {
        boolean r0 = this.d.contains("2d_avatar");
        if (this.d.contains("ai_mv") == true) goto L5;
        return r0 ? 1 : 0;
    L5:
        return (r0 ? 1 : 0) | 2;
    }

    public final cg6.a c() {
        return this.f.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public static final /* synthetic */ int a(SpeechRhythm r0) {
        return r0.getType();
    }

    public final void e(String r12) {
        Intrinsics.checkNotNullParameter(r12, "sei");
        if (vm2.c.g() == true) goto L5;
        return;
    L5:
        LiveSeiUtil.i.getClass();
        JSONObject r13 = LiveSeiUtil.c(r12);
        if (r13.has("music_beat_result") == false) goto L39;
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r13, "music_beat_result");
        String r14 = r4.optString("uid");
        float r6 = (float) r4.optDouble("beat");
        int r7 = r4.optInt("aed");
        String r1 = r4.optString("sender_uid");
        boolean r5 = false;
        if (r4.has("type") == false) goto L10;
        int r8 = r4.optInt("type");
    L11:
        cg6.a r2 = c();
        if (r2 == null) goto L18;
        g r3 = r2.getRtcManager();
        if (r3 == null) goto L18;
        if (r3.A() != true) goto L18;
        r5 = true;
    L18:
        if (r5 == false) goto L37;
        String r9 = k.n(IMiddlewareUserService.class).user().n();
        if (Intrinsics.areEqual(r14, r1) == false) goto L23;
        g(this, r6, r7, r8, b(), d());
    L23:
        if (gh0.a.d() == true) goto L25;
        return;
    L25:
        if ((!Intrinsics.areEqual(r14, r9)) == false) goto L41;
        r4.put("sender_uid", r9);
        cg6.a r15 = c();
        if (r15 == null) goto L33;
        g r16 = r15.getRtcManager();
        if (r16 == null) goto L33;
        ec6.b r17 = r16.R();
        if (r17 == null) goto L33;
        com.bytedance.android.live.pushstream.d r18 = gc6.b.a(r17);
    L34:
        com.bytedance.android.live.pushstream.d r10 = r18;
        if (r10 == null) goto L42;
        r10.c1("music_beat_result", r4, 1, false, false);
        return;
    L42:
        return;
    L33:
        r18 = null;
        goto L34
    L41:
        return;
    L37:
        g(this, r6, r7, r8, b(), d());
        return;
    L10:
        r8 = 0;
        goto L11
    }

    public final void i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "business");
        StringBuilder r0 = new StringBuilder("startRhythmDetect, isRecognizing: ");
        r0.append(this.c);
        r0.append(", type:");
        com.bytedance.android.live.pushstream.d r3 = null;
        r0.append(((Number) vm2.c.h.getValue(null, vm2.c.a[6])).intValue());
        r0.append(", business=");
        r0.append(r5);
        ALogger.i("SpeechRhythm", r0.toString());
        if (this.d.contains(r5) == true) goto L6;
        this.d.add(r5);
    L6:
        if (this.c == false) goto L8;
        return;
    L8:
        this.c = true;
        this.a = new kd2.b(0, 0);
        cg6.a r1 = c();
        if (r1 == null) goto L15;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L15;
        ec6.b r4 = r2.R();
        if (r4 == null) goto L15;
        r3 = gc6.b.a(r4);
    L15:
        if (r3 == null) goto L19;
        d0 r6 = r3.getLiveCore();
        if (r6 == null) goto L19;
        r6.h();
    L19:
        if (r3 == null) goto L23;
        d0 r7 = r3.getLiveCore();
        if (r7 == null) goto L23;
        r7.h();
    L23:
        if (r3 == null) goto L27;
        d0 r8 = r3.getLiveCore();
        if (r8 == null) goto L27;
        r8.h();
    L27:
        IInteractService r9 = (IInteractService) k.f(IInteractService.class);
        if (r9 == null) goto L33;
        com.bytedance.android.live.liveinteract.plantform.performance.a r10 = r9.getMultiLinkPerfAbilityManager(true);
        if (r10 == null) goto L34;
        r10.b("multilink_base_degrade", new SpeechRhythm$startRhythmDetect$2(this));
        return;
    L34:
        return;
    }

    public final void j(String r15) {
        Intrinsics.checkNotNullParameter(r15, "business");
        ALogger.i("SpeechRhythm", "stopRhythmDetect");
        com.bytedance.android.live.pushstream.d r1 = null;
        if (Intrinsics.areEqual(r15, "ai_mv") == false) goto L15;
        boolean r4 = this.a.b();
        String r6 = b();
        Integer r7 = d();
        int r0 = getType();
        String r2 = k.n(IMiddlewareUserService.class).user().n();
        JSONObject r10 = new JSONObject();
        r10.put("uid", r2);
        r10.put("beat", Float.valueOf(0.0f));
        r10.put("aed", r4 ? 1 : 0);
        r10.put("sender_uid", r2);
        r10.put("type", r0);
        cg6.a r3 = c();
        if (r3 == null) goto L11;
        g r5 = r3.getRtcManager();
        if (r5 == null) goto L11;
        ec6.b r8 = r5.R();
        if (r8 == null) goto L11;
        com.bytedance.android.live.pushstream.b r9 = gc6.b.a(r8);
    L12:
        if (r9 == null) goto L14;
        r9.c1("music_beat_result", r10, 1, false, false);
    L14:
        g(this, 0.0f, r4 ? 1 : 0, getType(), r6, r7);
    L11:
        r9 = null;
    L15:
        this.d.remove(r15);
        if (this.d.isEmpty() == true) goto L18;
        return;
    L18:
        boolean r16 = false;
        this.c = false;
        cg6.a r11 = c();
        if (r11 == null) goto L25;
        g r12 = r11.getRtcManager();
        if (r12 == null) goto L25;
        ec6.b r13 = r12.R();
        if (r13 == null) goto L25;
        r1 = gc6.b.a(r13);
    L25:
        InteractiveSongContext r14 = InteractiveSongContext.Companion.getContext();
        if (r14 == null) goto L32;
        m<Boolean> r17 = r14.isAiLyricsSwitchOn();
        if (r17 == null) goto L32;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L32;
        r16 = r18.booleanValue();
    L32:
        if (r16 == true) goto L37;
        if (r1 == null) goto L37;
        d0 r19 = r1.getLiveCore();
        if (r19 == null) goto L37;
        r19.h();
    L37:
        if (r1 == null) goto L42;
        d0 r110 = r1.getLiveCore();
        if (r110 == null) goto L43;
        r110.h();
        return;
    L43:
        return;
    }

    public SpeechRhythm(j1 r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "outerScopeProvider");
        this.f = r2;
        this.g = r3;
        this.a = new kd2.b(0, 0);
        CompositeDisposable r4 = new CompositeDisposable();
        this.b = r4;
        this.d = new ConcurrentHashSet();
        r4.add(xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
        u r5 = o3.d();
        if (r5 == null) goto L12;
        j r6 = r5.s();
        if (r6 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L14;
        BehaviorSubject r8 = r7.a();
        if (r8 == null) goto L15;
        r8.subscribe(new b(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void h(float r3, int r4, int r5, String r6, Integer r7) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(r5));
        r0.addProperty("beat", Float.valueOf(r3));
        r0.addProperty("aed", Integer.valueOf(r4));
        Float r8 = null;
        if (r6 != null) goto L5;
    L13:
        if (r7 == null) goto L15;
        r0.addProperty("refrain", Integer.valueOf(r7.intValue()));
    L15:
        InteractiveSongContext.a r9 = InteractiveSongContext.Companion;
        InteractiveSongContext r10 = r9.getContext();
        if (r10 == null) goto L22;
        n<com.bytedance.android.livesdk.ktvapi.model.mv.c> r11 = r10.getAiMVPlayService();
        if (r11 == null) goto L22;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r12 = (com.bytedance.android.livesdk.ktvapi.model.mv.c) r11.getValue();
        if (r12 == null) goto L22;
        r8 = r12.m();
    L22:
        if (r8 == null) goto L24;
        r0.addProperty("light", Float.valueOf(r8.floatValue()));
    L24:
        InteractiveSongContext r13 = r9.getContext();
        if (r13 == null) goto L27;
        r13.setRecordeLastSpeechRhythmBeats(r0);
    L27:
        IInteractService r14 = (IInteractService) k.f(IInteractService.class);
        if (r14 == null) goto L33;
        ih0.b r15 = r14.dynamicService(this.g);
        if (r15 == null) goto L34;
        r15.Dk("audiochat_stage", "speech_effect", r0, false);
        return;
    L34:
        return;
    L33:
        return;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L13;
        r0.addProperty("emo", r6);
        goto L13
    L7:
        r16 = false;
        goto L8
    }

    public static /* synthetic */ void g(SpeechRhythm r7, float r8, int r9, int r10, String r11, Integer r12) {
        r7.f(r8, r9, r10, r11, r12, true);
    }

    public final void f(float r8, int r9, int r10, String r11, Integer r12, boolean r13) {
        ALogger.i("SpeechRhythm", "sendEventToJsb, beat: " + r8 + ", aedState: " + r9 + ", type: " + r10);
        if (r13 == false) goto L12;
        IInteractService r14 = (IInteractService) k.f(IInteractService.class);
        boolean r0 = true;
        if (r14 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r15 = r14.getMultiLinkPerfAbilityManager(true);
        if (r15 == null) goto L9;
        r0 = r15.a("multilink_base_degrade");
    L9:
        if (r0 == true) goto L12;
        h(0.0f, r9, r10, "", 0);
        return;
    L12:
        h(r8, r9, r10, r11, r12);
    }
}
