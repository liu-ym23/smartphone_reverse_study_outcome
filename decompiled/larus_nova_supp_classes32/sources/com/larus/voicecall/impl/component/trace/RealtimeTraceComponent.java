package com.larus.voicecall.impl.component.trace;

import android.content.Context;
import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.IAudioService;
import com.larus.audio.SoundsSource;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.bmhome.chat.screenshot.ScreenRecordManager;
import com.larus.bmhome.chat.screenshot.d;
import com.larus.bmhome.chat.screenshot.e;
import com.larus.bmhome.chat.screenshot.i;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.y0;
import com.larus.platform.api.r3;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.component.denoise.DenoiseStatusRes;
import com.larus.voicecall.impl.plugins.i1;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.subtitle.q0;
import com.larus.voicecall.impl.ui.RealtimeCallHelperKt;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n3a.f;
import n3a.g;
import org.json.JSONException;
import org.json.JSONObject;
import pf9.z;
import tx9.i3;
import tx9.j3;
import tx9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004*\u0003GJM\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020)H\u0016J\b\u0010.\u001a\u00020)H\u0016J\b\u0010/\u001a\u00020)H\u0016J\b\u00100\u001a\u00020)H\u0016J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020)H\u0016J\b\u0010:\u001a\u00020)H\u0016J\u0018\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010?\u001a\u00020)2\u0006\u0010<\u001a\u0002032\u0006\u0010@\u001a\u00020>H\u0016J\u0018\u0010A\u001a\u00020)2\u0006\u0010<\u001a\u0002032\u0006\u0010@\u001a\u00020>H\u0016J\b\u0010B\u001a\u00020)H\u0002J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020EH\u0016J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u0002030PH\u0002J\b\u0010Q\u001a\u00020)H\u0002J\b\u0010R\u001a\u00020)H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u0010\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0004\n\u0002\u0010KR\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010N¨\u0006T"}, d2 = {"Lcom/larus/voicecall/impl/component/trace/RealtimeTraceComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "<init>", "()V", "searchStartTime", NameKeys.UnloadStrategy_No_Strategy, "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "subtitleAbility", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "getSubtitleAbility", "()Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "subtitleAbility$delegate", "tickTask", "Lcom/larus/platform/api/ISdkTick$Task;", "onAppBackground", NameKeys.UnloadStrategy_No_Strategy, "onAppForeground", "onAttach", "onVContextReady", "onCreate", "onResume", "onPause", "onDestroy", "mobClickCallReconnect", "clickMethod", NameKeys.UnloadStrategy_No_Strategy, "mobMuteCall", "enterMethod", "mobInCallChangeToBackground", "isScreenLocked", NameKeys.UnloadStrategy_No_Strategy, "mobCallSceneBoardShow", "mobClickCallSceneEntrance", "mobShowSuggestPrompt", "showFrom", "totalSize", NameKeys.UnloadStrategy_No_Strategy, "mobShowSuggestPromptSingleQuestion", "position", "mobClickSuggestPrompt", "reportSearchStayTime", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "screenCaptureListener", "com/larus/voicecall/impl/component/trace/RealtimeTraceComponent$screenCaptureListener$1", "Lcom/larus/voicecall/impl/component/trace/RealtimeTraceComponent$screenCaptureListener$1;", "screenRecordChildAttachListener", "com/larus/voicecall/impl/component/trace/RealtimeTraceComponent$screenRecordChildAttachListener$1", "Lcom/larus/voicecall/impl/component/trace/RealtimeTraceComponent$screenRecordChildAttachListener$1;", "screenRecordSessionListener", "com/larus/voicecall/impl/component/trace/RealtimeTraceComponent$screenRecordSessionListener$1", "Lcom/larus/voicecall/impl/component/trace/RealtimeTraceComponent$screenRecordSessionListener$1;", "collectScreenRecordVisibleMessages", NameKeys.UnloadStrategy_No_Strategy, "registerScreenRecord", "unregisterScreenRecord", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeTraceComponent extends RealtimeComponent implements n3a.a {
    public static final /* synthetic */ int y = 0;
    public long n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public r3.b u;
    public final b v;
    public final RealtimeTraceComponent$screenRecordChildAttachListener$1 w;
    public final c x;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ RealtimeTraceComponent a;

        public final void a() {
            FLogger r0 = FLogger.a;
            r0.i("RealtimeTraceComponent", "Receive Screen Capture notification");
            if (s1a.a.c(this.a).isVisible() == true) goto L5;
        L27:
            r0.i("RealtimeTraceComponent", "Fragment is not showing, ignoring screenshot");
            return;
        L5:
            if (s1a.a.c(this.a).isResumed() == false) goto L27;
            RealtimeTraceComponent r2 = this.a;
            int r3 = RealtimeTraceComponent.y;
            g3a.a r4 = r2.z3();
            LinearLayoutManager r5 = null;
            if (r4 == null) goto L12;
            RealtimeCallSubtitleLayout r6 = r4.ol();
            if (r6 == null) goto L12;
            RecyclerView r7 = r6.getRecycler();
        L13:
            if (r7 == null) goto L15;
            RecyclerView.LayoutManager r8 = r7.getLayoutManager();
        L17:
            if ((r8 instanceof LinearLayoutManager) == false) goto L19;
            r5 = (LinearLayoutManager) r8;
        L19:
            if (r5 != null) goto L21;
        L25:
            r0.d("RealtimeTraceComponent", "Subtitle RecyclerView not visible or LayoutManager is null");
            return;
        L21:
            if (r7.getVisibility() != 0) goto L25;
            List<String> r9 = this.a.h3();
            j3.a(r9, new ArrayList());
            r0.i("RealtimeTraceComponent", "Screenshot processing completed msgIdListSize- " + ((ArrayList) r9).size());
            return;
        L15:
            r8 = null;
        L12:
            r7 = null;
            goto L13
        }

        public b(RealtimeTraceComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements e {
        public final /* synthetic */ RealtimeTraceComponent a;

        public c(RealtimeTraceComponent r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sessionId");
            Intrinsics.checkNotNullParameter("system", "reason");
            RealtimeTraceComponent r4 = this.a;
            int r0 = RealtimeTraceComponent.y;
            g3a.a r5 = r4.z3();
            if (r5 == null) goto L7;
            RealtimeCallSubtitleLayout r6 = r5.ol();
            if (r6 == null) goto L7;
            RecyclerView r7 = r6.getRecycler();
        L8:
            if (r7 != null) goto L10;
        L12:
            boolean r1 = false;
        L13:
            if (r1 == true) goto L15;
            return;
        L15:
            r7.removeOnChildAttachStateChangeListener(this.a.w);
            r7.addOnChildAttachStateChangeListener(this.a.w);
            FLogger.a.i("RealtimeTraceComponent", "Screen Recording session started in RTC page");
            return;
        L10:
            if (r7.getVisibility() != 0) goto L12;
            r1 = true;
        L7:
            r7 = null;
            goto L8
        }

        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter(r3, "reason");
            RealtimeTraceComponent r4 = this.a;
            int r5 = RealtimeTraceComponent.y;
            g3a.a r6 = r4.z3();
            if (r6 == null) goto L7;
            RealtimeCallSubtitleLayout r7 = r6.ol();
            if (r7 == null) goto L7;
            RecyclerView r8 = r7.getRecycler();
        L8:
            if (r8 == null) goto L10;
            r8.removeOnChildAttachStateChangeListener(this.a.w);
        L10:
            FLogger.a.i("RealtimeTraceComponent", "Screen Recording session ended in RTC page");
            return;
        L7:
            r8 = null;
            goto L8
        }
    }

    static {
    }

    @Override // n3a.a
    public final void YU(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterMethod");
    }

    public final void onDestroy() {
        RecyclerView r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        IAudioService r2 = (IAudioService) ServiceManager.get().getService(IAudioService.class);     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.f0(SoundsSource.REALTIME_CALL);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        FLogger.a.e("RealtimeTraceComponent", "SoundsMobHelper error, " + r5.getMessage());
    L15:
        ((RealtimeCallService) this.r.getValue()).u.y.F0();
        r3.b r6 = this.u;
        if (r6 == null) goto L18;
        r6.end();
    L18:
        o.a.d(false);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r7 == null) goto L55;
        com.larus.bmhome.chat.screenshot.c r8 = i.a;
        i.b(r7, this.v);
        CopyOnWriteArrayList r9 = ScreenRecordManager.a;
        if (ScreenRecordManager.f == false) goto L29;
        g3a.a r10 = z3();
        if (r10 == null) goto L27;
        RealtimeCallSubtitleLayout r11 = r10.ol();
        if (r11 == null) goto L27;
        r0 = r11.getRecycler();
    L27:
        if (r0 == null) goto L29;
        r0.removeOnChildAttachStateChangeListener(this.w);
    L29:
        c r12 = this.x;
        if (r12 == null) goto L46;
        CopyOnWriteArrayList r13 = ScreenRecordManager.a;
        Iterator r14 = r13.iterator();
    L34:
        if (r14.hasNext() == false) goto L45;
        Object r15 = r14.next();
        WeakReference r16 = (WeakReference) r15;
        Intrinsics.checkNotNullParameter(r16, "it");
        if (Intrinsics.areEqual(r16.get(), r12) == false) goto L38;
    L41:
        boolean r17 = true;
    L43:
        if (Boolean.valueOf(r17).booleanValue() == false) goto L34;
        r13.remove(r15);
        goto L34
    L38:
        if (r16.get() == null) goto L41;
        r17 = false;
        goto L43
    L45:
        FLogger.a.i("ScreenRecordManager", "removeScreenRecordSessionListener");
    L46:
        FLogger.a.i("RealtimeTraceComponent", "Unregister screen record Listeners");
        return;
    L55:
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final e3a.a m3() {
        return (e3a.a) this.o.getValue();
    }

    @Override // n3a.a
    public final void oO() {
        RealtimeCallUtil r0 = RealtimeCallUtil.a;
        r0.getClass();
        com.larus.voicecall.impl.scene.o r1 = RealtimeCallUtil.l;
        if (r1 == null) goto L8;
        SceneModel r2 = r1.a;
        if (r2 == null) goto L8;
        String r3 = r2.getKey();
        if (r3 == null) goto L8;
    L9:
        r0.getClass();
        Long r4 = Long.valueOf(z0.c(RealtimeCallUtil.z));
        String r5 = ((h88.a) m3()).k;
        JSONObject r6 = new JSONObject();
        String r7 = "0";
        if (p3().p.q == false) goto L12;
    L15:
        Object r8 = "1";
    L16:
        r6.put("is_continuous_speak", r8);
        if (p3().b == false) goto L19;
        r7 = "1";
    L19:
        r6.put("is_obric_continuous_talk", r7);
        Unit r9 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        r6.put("call_scene", r3);     // Catch: JSONException -> L26
        if (r4 == null) goto L23;
        r6.put("is_subtitles_mode", r4.longValue());     // Catch: JSONException -> L26
    L23:
        if (r5 == null) goto L28;
        r6.put("click_from", r5);     // Catch: JSONException -> L26
    L28:
        TrackParams r10 = new TrackParams().merge(r6);
        by7.a r11 = new by7.a("click_call_scene_entrance");
        r11.a.merge(r10);
        r11.b();
        return;
    L26:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickSceneEntrance " + e.getLocalizedMessage());
        goto L28
    L12:
        if (p3().a == true) goto L15;
        r8 = "0";
    L8:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L9
    }

    public final void onAppBackground() {
        o.a.d(true);
    }

    public final void onAppForeground() {
        o.a.d(false);
    }

    public final void onCreate() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r0 == null) goto L25;
        com.larus.bmhome.chat.screenshot.c r1 = i.a;
        i.a(r0, this.v);
        if (ScreenRecordManager.f == false) goto L24;
        g3a.a r2 = z3();
        LinearLayoutManager r3 = null;
        if (r2 == null) goto L11;
        RealtimeCallSubtitleLayout r4 = r2.ol();
        if (r4 == null) goto L11;
        RecyclerView r5 = r4.getRecycler();
    L12:
        if (r5 == null) goto L14;
        RecyclerView.LayoutManager r6 = r5.getLayoutManager();
    L16:
        if ((r6 instanceof LinearLayoutManager) == false) goto L18;
        r3 = (LinearLayoutManager) r6;
    L18:
        if (r3 == null) goto L20;
        ScreenRecordManager.c(h3(), CollectionsKt.emptyList());
    L20:
        if (r5 == null) goto L22;
        r5.removeOnChildAttachStateChangeListener(this.w);
    L22:
        if (r5 == null) goto L24;
        r5.addOnChildAttachStateChangeListener(this.w);
        goto L24
    L14:
        r6 = null;
    L11:
        r5 = null;
    L24:
        CopyOnWriteArrayList r7 = ScreenRecordManager.a;
        ScreenRecordManager.a(this.x);
        FLogger.a.i("RealtimeTraceComponent", "Registering screen record listeners");
    L25:
        String r8 = ((h88.a) m3()).d;
        String r9 = ((h88.a) m3()).f;
        String r10 = p3().e;
        String r11 = ((h88.a) m3()).k;
        String r12 = p3().o.d;
        JSONObject r13 = new JSONObject();
        r13.put("is_rtc", y0.e(p3().s));
        if (((h88.a) m3()).m == false) goto L28;
        String r14 = "video_call";
    L29:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.t != DenoiseStatusRes.FEATURE_ENABLED) goto L32;
        int r15 = 1;
    L33:
        r13.put("is_noise_free", r15);
        r13.put("modal_type", r14);
        r13.put("call_background_mode", r14);
        r13.put("av_session_type", p3().s.getType());
        Unit r16 = Unit.INSTANCE;
        RealtimeCallHelperKt.f(r8, r9, r10, "0", "1", r11, r12, r13, p3());
        r3.b r17 = r3.a.a("real_time_call");
        this.u = r17;
        if (r17 == null) goto L37;
        r17.start();
        return;
    L37:
        return;
    L32:
        r15 = 0;
        goto L33
    L28:
        r14 = LynxResourceModule.AUDIO_TYPE;
        goto L29
    }

    public final void onPause() {
        if (this.n != 0) goto L6;
        return;
    L6:
        if (p3().p.h == null) goto L35;
        long r1 = SystemClock.elapsedRealtime() - this.n;
        String r6 = ((h88.a) m3()).d;
        String r7 = p3().p.d;
        RealtimeCallParam.n r5 = p3().p.h;
        if (r5 == null) goto L11;
        String r9 = r5.a;
    L12:
        RealtimeCallParam.n r8 = p3().p.h;
        if (r8 == null) goto L15;
        String r10 = r8.b;
    L16:
        RealtimeCallParam.n r11 = p3().p.h;
        if (r11 == null) goto L19;
        String r12 = r11.c;
    L20:
        RealtimeCallParam.n r13 = p3().p.h;
        if (r13 == null) goto L23;
        String r14 = r13.d;
    L24:
        RealtimeCallParam.n r15 = p3().p.h;
        if (r15 == null) goto L27;
        String r16 = r15.e;
    L28:
        RealtimeCallParam.n r17 = p3().p.h;
        if (r17 == null) goto L31;
        String r18 = r17.f;
    L32:
        i3.h(r6, r7, Long.valueOf(r1), r9, r10, r18, r12, r14, r16, null, 3136);
        this.n = 0;
        return;
    L31:
        r18 = null;
        goto L32
    L27:
        r16 = null;
        goto L28
    L23:
        r14 = null;
        goto L24
    L19:
        r12 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    }

    public final RealtimeCallParam p3() {
        return (RealtimeCallParam) this.q.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, n3a.a.class);
    }

    public final g3a.a z3() {
        return (g3a.a) this.s.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.voicecall.impl.component.trace.RealtimeTraceComponent$screenRecordChildAttachListener$1] */
    public RealtimeTraceComponent() {
        this.o = LazyKt.lazy(new n3a.b(this));
        this.p = LazyKt.lazy(new n3a.c(this));
        this.q = LazyKt.lazy(new n3a.d(this));
        this.r = LazyKt.lazy(new n3a.e(this));
        this.s = LazyKt.lazy(new f(this));
        this.t = LazyKt.lazy(new g(this));
        this.v = new b(this);
        this.w = new RealtimeTraceComponent$screenRecordChildAttachListener$1(this);
        this.x = new c(this);
    }

    public final void A0() {
        m3();
        e3a.b r0 = (e3a.b) this.p.getValue();
        RealtimeCallService r1 = (RealtimeCallService) this.r.getValue();
    }

    @Override // n3a.a
    public final void Al() {
        t.a(((h88.a) m3()).f, ((h88.a) m3()).t, ((h88.a) m3()).d);
    }

    public final List<String> h3() {
        g3a.a r0 = z3();
        LinearLayoutManager r1 = null;
        if (r0 == null) goto L7;
        RealtimeCallSubtitleLayout r2 = r0.ol();
        if (r2 == null) goto L7;
        RecyclerView r3 = r2.getRecycler();
    L8:
        if (r3 == null) goto L10;
        RecyclerView.LayoutManager r4 = r3.getLayoutManager();
    L12:
        if ((r4 instanceof LinearLayoutManager) == false) goto L15;
        r1 = (LinearLayoutManager) r4;
    L15:
        if (r1 == null) goto L17;
        int r5 = r1.findFirstVisibleItemPosition();
    L18:
        if (r1 == null) goto L20;
        int r6 = r1.findLastVisibleItemPosition();
    L21:
        ArrayList r7 = new ArrayList();
        if (r5 == (-1)) goto L43;
        if (r6 == (-1)) goto L43;
        if (r5 > r6) goto L43;
        com.larus.voicecall.impl.component.subtitle.a r8 = (com.larus.voicecall.impl.component.subtitle.a) this.t.getValue();
        if (r8 == null) goto L42;
        q0 r9 = r8.G00();
        if (r9 == null) goto L42;
        ArrayList<com.larus.voicecall.impl.subtitle.c> r10 = r9.o;
        if (r10 == null) goto L42;
        if (r5 > r6) goto L41;
    L34:
        int r11 = r5 - 1;
        if (r11 >= 0) goto L37;
    L39:
        if (r5 == r6) goto L41;
        r5 = r5 + 1;
        goto L34
    L37:
        if (r11 >= r10.size()) goto L39;
        r7.add(((com.larus.voicecall.impl.subtitle.c) ListProtector.get(r10, r11)).j);
    L41:
        FLogger.a.i("RealtimeTraceComponent", "collectRecordVisibleMessage done, msgIdsize= " + r7.size());
    L42:
        return r7;
    L43:
        FLogger.a.d("RealtimeTraceComponent", "collectRecordVisibleMessage invalid RecyclerView positions, exiting");
        return r7;
    L20:
        r6 = -1;
        goto L21
    L17:
        r5 = -1;
        goto L18
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void onResume() {
        this.n = SystemClock.elapsedRealtime();
    }

    public final void D9(com.larus.im.service.audio.z0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof z) == false) goto L22;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.F == false) goto L23;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L13
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L11;
        i1 r7 = ((RealtimeCallService) this.r.getValue()).x();     // Catch: Throwable -> L13
        if (r7 == null) goto L11;
        r7.h1();     // Catch: Throwable -> L13
    L11:
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L13
        StringBuilder r3 = new StringBuilder("call syncClientInfo func. fragment=");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L13
        r3.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded());     // Catch: Throwable -> L13
        r8.i("RealtimeTraceComponent", r3.toString());     // Catch: Throwable -> L13
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L24;
        EnsureManager.ensureNotReachHere(r10, "RealtimeTraceComponent-syncClientInfo");
        FLogger.a.e("RealtimeTraceComponent", "syncClientInfo error, " + r10.getMessage());
        return;
    L24:
        return;
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        return;
    }

    @Override // n3a.a
    public final void u00(String r7) {
        Intrinsics.checkNotNullParameter(r7, "clickMethod");
        JSONObject r0 = new JSONObject();
        String r1 = p3().e;     // Catch: JSONException -> L17
        RealtimeCallUtil.a.getClass();     // Catch: JSONException -> L17
        com.larus.voicecall.impl.scene.o r2 = RealtimeCallUtil.l;     // Catch: JSONException -> L17
        if (r2 == null) goto L8;
        SceneModel r3 = r2.a;     // Catch: JSONException -> L17
        if (r3 == null) goto L8;
        String r4 = r3.getKey();     // Catch: JSONException -> L17
    L9:
        String r5 = ((h88.a) m3()).d;     // Catch: JSONException -> L17
        String r6 = ((h88.a) m3()).k;     // Catch: JSONException -> L17
        if (r1 == null) goto L12;
        r0.put("call_id", r1);     // Catch: JSONException -> L17
    L12:
        r0.put("room_id", p3().d);     // Catch: JSONException -> L17
        if (r4 == null) goto L15;
        r0.put("call_scene", r4);     // Catch: JSONException -> L17
    L15:
        r0.put("click_method", r7);     // Catch: JSONException -> L17
        r0.put("bot_id", r5);     // Catch: JSONException -> L17
        r0.put("enter_method", r6);     // Catch: JSONException -> L17
    L19:
        o.a.reportEvent("click_call_reconnect", r0);
        return;
    L8:
        r4 = null;
    L17:
        e = move-exception;
        FLogger.a.e("RealtimeTraceComponent", "error in RealtimeTraceComponent mobClickCallReconnect " + e.getLocalizedMessage());
        goto L19
    }

    @Override // n3a.a
    public final void zb(boolean r9) {
        InstanceCallState.a r0 = InstanceCallState.Companion;
        int r1 = ((h88.b) ((e3a.b) this.p.getValue())).k;
        r0.getClass();
        String r2 = InstanceCallState.a.a(r1);
        String r3 = p3().o.h;
        String r4 = p3().e;
        String r5 = p3().l.c;
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r6 = RealtimeCallUtil.l;
        if (r6 == null) goto L7;
        SceneModel r7 = r6.a;
        if (r7 == null) goto L7;
        String r8 = r7.getKey();
    L8:
        JSONObject r10 = new JSONObject();
        r10.put("room_id", p3().d);
        if (r9 == false) goto L11;
        String r11 = "lock_screen";
    L12:
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        r10.put("bot_from_status", r2);     // Catch: JSONException -> L30
        if (r3 == null) goto L16;
        r10.put("bot_id", r3);     // Catch: JSONException -> L30
    L16:
        if (r4 == null) goto L18;
        r10.put("call_id", r4);     // Catch: JSONException -> L30
    L18:
        if (r5 == null) goto L21;
        r10.put("conversation_id", r5);     // Catch: JSONException -> L30
    L21:
        if (r11.length() != 0) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == false) goto L26;
        r11 = "abnormal_exit";
    L26:
        r10.put("enter_method", r11);     // Catch: JSONException -> L30
        if (r8 == null) goto L32;
        r10.put("call_scene", r8);     // Catch: JSONException -> L30
    L32:
        TrackParams r13 = new TrackParams().merge(r10);
        by7.a r14 = new by7.a("in_call_change_to_background");
        r14.a.merge(r13);
        r14.b();
        return;
    L23:
        r12 = false;
    L30:
        e = move-exception;
        FLogger.a.e("RtcEventHelper", "error in mobInCallChangeToBackground in_call_change_to_background " + e.getLocalizedMessage());
        goto L32
    L11:
        r11 = "banner";
    L7:
        r8 = null;
        goto L8
    }

    @Override // n3a.a
    public final void k90(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "showFrom");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("show_from", r4);
        r1.put("current_page", ((h88.a) m3()).s);
        r1.put("bot_id", ((h88.a) m3()).d);
        r1.put("conversation_id", ((h88.a) m3()).f);
        r1.put("call_id", p3().e);
        r1.put("room_id", p3().d);
        r1.put("prompt_cnt", r5);
        r1.put("suggested_type", "call_suggest");
        r1.put("previous_page", ((h88.a) m3()).q);
        r1.put("call_enter_method", ((h88.a) m3()).k);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("show_suggested_prompt", r1);
    }

    @Override // n3a.a
    public final void oC(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "showFrom");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("show_from", r4);
        r1.put("current_page", ((h88.a) m3()).s);
        r1.put("bot_id", ((h88.a) m3()).d);
        r1.put("conversation_id", ((h88.a) m3()).f);
        r1.put("call_id", p3().e);
        r1.put("room_id", p3().d);
        r1.put("prompt_position", r5 + 1);
        r1.put("suggested_type", "call_suggest");
        r1.put("previous_page", ((h88.a) m3()).q);
        r1.put("call_enter_method", ((h88.a) m3()).k);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("show_suggested_prompt_single_question", r1);
    }

    @Override // n3a.a
    public final void zB(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "showFrom");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("show_from", r4);
        r1.put("current_page", ((h88.a) m3()).s);
        r1.put("bot_id", ((h88.a) m3()).d);
        r1.put("conversation_id", ((h88.a) m3()).f);
        r1.put("call_id", p3().e);
        r1.put("room_id", p3().d);
        r1.put("click_position", r5 + 1);
        r1.put("suggested_type", "call_suggest");
        r1.put("previous_page", ((h88.a) m3()).q);
        r1.put("call_enter_method", ((h88.a) m3()).k);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("click_suggested_prompt", r1);
    }
}
