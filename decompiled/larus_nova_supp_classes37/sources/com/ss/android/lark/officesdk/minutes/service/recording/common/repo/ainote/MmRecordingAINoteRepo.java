package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ainote.AINoteAction;
import com.ss.android.ainote.AINoteContext;
import com.ss.android.ainote.AINotes;
import com.ss.android.ainote.AINotesSession;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.p;
import com.ss.android.ainote.q;
import com.ss.android.ainote.q0;
import com.ss.android.ainote.r0;
import com.ss.android.ainote.s;
import com.ss.android.ainote.t;
import com.ss.android.ainote.u;
import com.ss.android.ainote.v;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAINoteRepo extends MviRepository<c, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a, j> {
    public static final /* synthetic */ int z = 0;
    public final MmRecordingSession j;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a k;
    public ViewGroup l;
    public f m;
    public long n;
    public long o;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.b p;
    public boolean q;
    public boolean r;
    public boolean s;
    public JSONObject t;
    public final ConcurrentHashMap<String, AINoteType> u;
    public i v;
    public final String w;
    public final Lazy x;
    public final b y;

    public static final class a {
    }

    public static final class b implements r0 {
        public final /* synthetic */ MmRecordingAINoteRepo a;

        public final com.ss.android.ainote.h c() {
            this.a.getClass();
            long r2 = System.currentTimeMillis();
            Long r0 = Long.valueOf(this.a.j.w.b);
            if (r0.longValue() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r0 = null;
        L9:
            if (r0 == null) goto L11;
            long r3 = r0.longValue();
        L13:
            if (r3 <= 0) goto L15;
            long r4 = RangesKt.coerceAtLeast(r2 - r3, 0);
        L17:
            return new com.ss.android.ainote.h(r2, r4, RangesKt.coerceAtLeast(this.a.D(), 0));
        L15:
            r4 = 0;
            goto L17
        L11:
            r3 = this.a.o;
            goto L13
        L5:
            r1 = false;
            goto L6
        }

        public b(MmRecordingAINoteRepo r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void d(AINoteAction r13) {
            Intrinsics.checkNotNullParameter(r13, "action");
            if ((r13 instanceof AINoteAction.b) == false) goto L29;
            f r0 = this.a.m;
            if (r0 == null) goto L7;
            r0.d();
        L7:
            f r1 = this.a.m;
            if (r1 == null) goto L67;
            AINoteAction.b r14 = (AINoteAction.b) r13;
            int r2 = r14.a;
            List r15 = r14.b;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r16 = r15.iterator();
        L11:
            if (r16.hasNext() == false) goto L27;
            q r4 = (q) r16.next();
            s r5 = r4.d;
            s r6 = r4.c;
            String r7 = r4.a;
            if (r5 != null) goto L15;
            s r8 = r6;
        L16:
            String r9 = "originSource";
            if (r5 == null) goto L19;
            String r11 = "originSource";
        L20:
            h r10 = MmRecordingAINoteRepo.p(r7, r8, r11);
            String r12 = r4.b;
            if (r6 == null) goto L24;
            r5 = r6;
        L24:
            if (r6 == null) goto L26;
            r9 = "thumbSource";
        L26:
            r3.add(new g(r10, MmRecordingAINoteRepo.p(r12, r5, r9)));
            goto L11
        L19:
            r11 = "thumbSource";
            goto L20
        L15:
            r8 = r5;
            goto L16
        L27:
            r1.c(r2, r3);
            return;
        L67:
            return;
        L29:
            if ((r13 instanceof AINoteAction.a) == false) goto L32;
            String r17 = this.a.w;
            StringBuilder r18 = new StringBuilder("[onAction] ignore deprecated go to subtitle, noteId=");
            AINoteAction.a r19 = (AINoteAction.a) r13;
            r18.append(r19.a);
            r18.append(", createRelAudioTimeMs=");
            r18.append(r19.d);
            lvb.a.e(r17, r18.toString());
            return;
        L32:
            if ((r13 instanceof AINoteAction.NoteEventNotify) == false) goto L62;
            String r20 = this.a.w;
            StringBuilder r21 = new StringBuilder("[onAction] note event type=");
            AINoteAction.NoteEventNotify r110 = (AINoteAction.NoteEventNotify) r13;
            r21.append(r110.getType());
            r21.append(" noteId=");
            r21.append(r110.b.a);
            r21.append(" noteType=");
            r21.append(r110.b.e);
            r21.append(" audioLocationTime=");
            r21.append(r110.b.k);
            r21.append(" createRelAudioTimeMs=");
            r21.append(r110.b.n);
            lvb.a.e(r20, r21.toString());
            if (r110.getType() != AINoteAction.NoteEventNotify.Type.CLICK) goto L70;
            p r22 = r110.b;
            long r23 = r22.k;
            MmRecordingAINoteRepo r24 = this.a;
            AINoteType r25 = r22.e;
            r24.getClass();
            boolean r26 = true;
            if (r25 != AINoteType.SUBTITLE) goto L38;
        L43:
            boolean r27 = true;
        L45:
            if (r27 == false) goto L52;
            this.a.getClass();
            if (r23 < 946684800000L) goto L49;
            boolean r28 = true;
        L50:
            if (r28 == false) goto L52;
            MmRecordingAINoteRepo r111 = this.a;
            MmRecordingAINoteRepo.z(r111.d(), new MmRecordingAINoteRepo$requestSubtitleNavigation$1(r111, new l.a(r23), null));
            return;
        L49:
            r28 = false;
        L52:
            MmRecordingAINoteRepo r29 = this.a;
            Long r112 = Long.valueOf(r110.b.n);
            if (r112.longValue() > 0) goto L56;
            r26 = false;
        L56:
            if (r26 == true) goto L59;
            r112 = null;
        L59:
            if (r112 == null) goto L61;
            r23 = r112.longValue();
        L61:
            MmRecordingAINoteRepo.z(r29.d(), new MmRecordingAINoteRepo$requestSubtitleNavigation$1(r29, new l.b(r23), null));
            return;
        L38:
            if (r25 == AINoteType.FISH_BONE_TEXT) goto L43;
            if (r25 == AINoteType.FISH_BONE_CHART) goto L43;
            r27 = false;
            goto L45
        L70:
            return;
        L62:
            lvb.a.e(this.a.w, "[onAction] " + r13);
        }

        public final void a(long r2, Interpolator r4) {
            f r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.a(r2, r4);
            return;
        }

        public final void onEvent(String r7, JSONObject r8) {
            Intrinsics.checkNotNullParameter(r7, "eventType");
            Intrinsics.checkNotNullParameter(r8, "payload");
            String r1 = this.a.j.e();
            if (StringsKt.isBlank(r1) == false) goto L6;
            lvb.a.h(this.a.w, "[onEvent] skip, sessionId empty, eventType=" + r7);
            return;
        L6:
            JSONObject r2 = new JSONObject(r8.toString());
            if (Intrinsics.areEqual(r7, "view") == false) goto L25;
            c r9 = this.a.h();
            if (r9.e == false) goto L11;
        L14:
            boolean r3 = true;
        L15:
            if (r3 == true) goto L21;
            MmRecordingAINoteRepo r4 = this.a;
            if (r4.q == true) goto L21;
            if (r4.p.a() == true) goto L21;
        L24:
            r2.put("save_notes_switch", this.a.G(r9, true));
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g r10 = this.a.k.N().a();
            r10.getClass();
            Intrinsics.checkNotNullParameter(r1, "sessionId");
            Intrinsics.checkNotNullParameter(r2, "payload");
            r10.a.g(r1, "vc_minutes_ai_notes_view", new JSONObject(r2.toString()));
            return;
        L21:
            if (r9.f == true) goto L24;
            MmRecordingAINoteRepo r11 = this.a;
            r11.t = r2;
            lvb.a.e(r11.w, "[onEvent] delay view event until save switch fetched " + this.a.r());
            return;
        L11:
            if (this.a.y() == true) goto L14;
            r3 = false;
            goto L15
        L25:
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g r12 = this.a.k.N().a();
            r12.getClass();
            Intrinsics.checkNotNullParameter(r1, "sessionId");
            Intrinsics.checkNotNullParameter(r2, "payload");
            r12.a.g(r1, "vc_minutes_ai_notes_click", new JSONObject(r2.toString()));
        }

        public final void b(boolean r2, int r3, int r4) {
            f r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.b(r2, r3, r4);
            return;
        }
    }

    static {
    }

    public final long D() {
        Long r0 = Long.valueOf(((Number) this.j.p.getValue()).longValue());
        if (r0.longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        return r0.longValue();
    L12:
        return F(0);
    L5:
        r1 = false;
        goto L6
    }

    public final AINoteScene E() {
        if (this.j.a != RecordingSessionType.HARDWARE_RECORDING) goto L6;
        return AINoteScene.Hardware;
    L6:
        return AINoteScene.Record;
    }

    public final void J() {
        i r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.ainote.d r1 = o();
        if (r1 == null) goto L18;
        q0 r2 = q0.a;
        AINoteScene r3 = E();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "bizIds");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r0, "observer");
        AINoteScene r6 = AINoteScene.UNKNOWN;
        if (r3 == r6) goto L18;
        AINoteContext r7 = q0.b();
        if (r7 == null) goto L18;
        Intrinsics.checkNotNullParameter(r1, "bizIds");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r0, "observer");
        if (r3 == r6) goto L18;
        AINotesSession r4 = r7.f(r1, r3);
        Intrinsics.checkNotNullParameter(r0, "observer");
        if (r4.m.remove(r0) == false) goto L18;
        int r5 = t.a;
        t.d("AINotesSession", "unregisterSubtitleFishBoneNotesObserver, observerCount=" + r4.m.size());
        r4.i0();
    L18:
        this.v = null;
        this.u.clear();
        lvb.a.e(this.w, "[unregisterFishBoneMarkSyncObserver] " + r());
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        return new c(0);
    }

    public final void m() {
        if (this.p.a() == true) goto L6;
        return;
    L6:
        if (this.r == true) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.b r0 = this.p;
        Function1<Boolean, Unit> r2 = new MmRecordingAINoteRepo$bindSaveSwitchIfNeeded$1(this);
        AINotes r1 = r0.a;
        if (r1 == null) goto L10;
        r1.G(r2);
    L10:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.b r3 = this.p;
        Function1<Boolean, Unit> r4 = new MmRecordingAINoteRepo$bindSaveSwitchIfNeeded$2(this);
        AINotes r5 = r3.a;
        if (r5 == null) goto L13;
        r5.F(r4);
    L13:
        this.r = true;
    L15:
        if (this.s == true) goto L22;
        this.s = true;
        iub.k r6 = this.j.f;
        if (r6 == null) goto L20;
        MmRecordingSource r7 = r6.a;
    L21:
        BuildersKt.launch$default(f(), null, null, new MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1(this, r7, null), 3, null);
        goto L22
    L20:
        r7 = null;
    L22:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.b r8 = this.p;
        Function1<Boolean, Unit> r9 = new MmRecordingAINoteRepo$bindSaveSwitchIfNeeded$3(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "onResult");
        AINotes r10 = r8.a;
        if (r10 == null) goto L25;
        r10.v(r9);
        return;
    L25:
        r9.invoke(null);
    }

    public final com.ss.android.ainote.d o() {
        String r0 = this.j.w.a;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L9;
        return null;
    L9:
        return n(r0);
    }

    public final boolean u() {
        if (this.p.a() == false) goto L6;
        lvb.a.e(this.w, "[ensureAINotesLoaded] hit loaded " + r());
        return true;
    L6:
        long r2 = System.currentTimeMillis();
        ViewGroup r0 = this.l;
        if (r0 != null) goto L10;
        lvb.a.h(this.w, "[ensureAINotesLoaded] failed, container null " + r());
        return false;
    L10:
        String r5 = this.j.w.a;
        if (StringsKt.isBlank(r5) == false) goto L15;
        lvb.a.b(this.w, "[ensureAINotesLoaded] meetingId is empty");
        return false;
    L15:
        if (this.j.a != RecordingSessionType.HARDWARE_RECORDING) goto L17;
        AINoteScene r6 = AINoteScene.Hardware;
    L18:
        com.ss.android.ainote.d r7 = n(r5);
        lvb.a.e(this.w, "[ensureAINotesLoaded] show start scene=" + r6 + " meetingId=" + r7.b + " bizId=" + r7.a + " uniqueId=" + r7.c + " container=" + q(r0) + ' ' + r());
        this.q = true;
        boolean r1 = this.p.b(r0, r7, r6, this.y);     // Catch: Throwable -> L25
        this.q = false;
        if (r1 == false) goto L23;
        m();
    L23:
        lvb.a.e(this.w, "[ensureAINotesLoaded] show end shown=" + r1 + " costMs=" + (System.currentTimeMillis() - r2) + ' ' + r());
        z(d(), new MmRecordingAINoteRepo$ensureAINotesLoaded$1(this, r1, null));
        return r1;
    L25:
        th = move-exception;
        this.q = false;
        throw th;
    L17:
        r6 = AINoteScene.Record;
        goto L18
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a x() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a) this.x.getValue();
    }

    public final boolean y() {
        String r0 = this.j.w.a;
        if (StringsKt.isBlank(r0) == false) goto L6;
        return false;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.b r1 = this.p;
        com.ss.android.ainote.d r2 = n(r0);
        AINoteScene r3 = E();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "bizIds");
        Intrinsics.checkNotNullParameter(r3, "scene");
        q0.a.getClass();
        return q0.f(r2, r3);
    }

    public final String r() {
        c r0 = h();
        return "recordingId=" + this.j.e() + " meetingId=" + this.j.w.a + " sessionType=" + this.j.a + " sessionState=" + ((Pair) this.j.t.getValue()).getSecond() + " sdkLoaded=" + this.p.a() + " sdkShowing=" + this.q + " entityLoaded=" + r0.a + " bizStarted=" + r0.d + " photoTarget=" + r0.c + " saveSwitchEnabled=" + r0.e + " saveSwitchFetched=" + r0.f + " saveSwitchState=" + r0.g + " saveSwitchUpdating=" + r0.h + " hasContent=" + r0.i + " tooltipGuideNeedShow=" + r0.j + " tooltipShowing=" + r0.l + " tooltipConsumed=" + r0.k + " tooltipShownInSession=" + r0.m + " panelExpanded=" + r0.n + " focused=" + r0.o + " keyboard=" + r0.p + " container=" + q(this.l) + " callback=" + q(this.m);
    }

    public final void t() {
        if (h().d == true) goto L6;
        lvb.a.e(this.w, "[endBizSessionIfNeeded] skip, not started " + r());
        return;
    L6:
        lvb.a.e(this.w, "[endBizSessionIfNeeded] start " + r());
        q0.a.getClass();
        AINoteContext r0 = q0.b();
        if (r0 != null) goto L9;
    L27:
        z(d(), new MmRecordingAINoteRepo$endBizSessionIfNeeded$1(this, null));
        return;
    L9:
        monitor-enter(r0);
        r0.d();     // Catch: Throwable -> L24
        r0.t = RangesKt.coerceAtLeast(r0.t - 1, 0);     // Catch: Throwable -> L24
        int r3 = t.a;     // Catch: Throwable -> L24
        t.d("AINoteContext", "bizSessionEnd, depth=" + r0.t);     // Catch: Throwable -> L24
        if (r0.t != 0) goto L22;
        r0.h = null;     // Catch: Throwable -> L24
        Iterator r2 = CollectionsKt.toList(r0.d.values()).iterator();     // Catch: Throwable -> L24
    L14:
        if (r2.hasNext() == false) goto L16;
        ((AINotesSession) r2.next()).k0();     // Catch: Throwable -> L24
        goto L14
    L16:
        r0.b("bizSessionEnd");     // Catch: Throwable -> L24
        if (r0.r == false) goto L20;
        AppLifecycle r4 = AppLifecycle.a.a;     // Catch: Throwable -> L24
        r4.h.remove(r0.n);     // Catch: Throwable -> L24
        r0.r = false;     // Catch: Throwable -> L24
        int r5 = t.a;     // Catch: Throwable -> L24
        t.d("AINoteContext", "unregister AppLifecycle observer, userId=" + r0.a);     // Catch: Throwable -> L24
    L20:
        if (r0.s == false) goto L22;
        LarkContext.getApplication().unregisterComponentCallbacks(r0.o);     // Catch: Throwable -> L24
        r0.s = false;     // Catch: Throwable -> L24
        int r6 = t.a;     // Catch: Throwable -> L24
        t.d("AINoteContext", "unregister ComponentCallbacks, userId=" + r0.a);     // Catch: Throwable -> L24
    L22:
        monitor-exit(r0);
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.w;
    }

    public static String q(Object r2) {
        if (r2 == null) goto L5;
        String r3 = r2.getClass().getSimpleName() + '@' + System.identityHashCode(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return "null";
    }

    public static long v(String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(Long.valueOf(new PolarisFileWrapper(r2).length()));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = -1L;
    L10:
        return ((Number) r3).longValue();
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void B(com.ss.android.ainote.d r8) {
        this.u.clear();
        q0 r0 = q0.a;
        AINoteScene r1 = E();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "bizIds");
        Intrinsics.checkNotNullParameter(r1, "scene");
        AINoteContext r3 = q0.b();
        if (r3 == null) goto L14;
        Intrinsics.checkNotNullParameter(r8, "bizIds");
        Intrinsics.checkNotNullParameter(r1, "scene");
        if (r1 != AINoteScene.UNKNOWN) goto L7;
        List r9 = CollectionsKt.emptyList();
    L15:
        if (r9 != null) goto L17;
        r9 = CollectionsKt.emptyList();
    L17:
        ArrayList r2 = new ArrayList();
        Iterator r10 = r9.iterator();
    L18:
        boolean r4 = true;
        if (r10.hasNext() == false) goto L34;
        Object r5 = r10.next();
        u r6 = (u) r5;
        if (r6.g == true) goto L31;
        AINoteType r7 = r6.d;
        if (r7 != AINoteType.FISH_BONE_TEXT) goto L25;
    L28:
        boolean r11 = true;
    L29:
        if (r11 == false) goto L31;
    L32:
        if (r4 == false) goto L18;
        r2.add(r5);
        goto L18
    L25:
        if (r7 == AINoteType.FISH_BONE_CHART) goto L28;
        r11 = false;
    L31:
        r4 = false;
        goto L32
    L34:
        Iterator r12 = r2.iterator();
    L36:
        if (r12.hasNext() == false) goto L46;
        u r13 = (u) r12.next();
        String r14 = r13.e;
        if (r14 == null) goto L36;
        if ((!StringsKt.isBlank(r14)) == true) goto L43;
        r14 = null;
    L43:
        if (r14 == null) goto L36;
        this.u.put(r14, r13.d);
        goto L36
    L46:
        return;
    L7:
        AINotesSession r15 = r3.f(r8, r1);
        List r16 = r15.N;
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L9:
        if (r18.hasNext() == false) goto L13;
        u r19 = v.a((xra.a) r18.next(), r15.b);
        if (r19 == null) goto L9;
        r17.add(r19);
        goto L9
    L13:
        r9 = r17;
        goto L15
    L14:
        r9 = null;
        goto L15
    }

    public final void C(String r5) {
        String r0 = this.j.e();
        if (StringsKt.isBlank(r0) == false) goto L6;
        lvb.a.h(this.w, "[reportAINoteClickEvent] skip, sessionId empty, click=".concat(r5));
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g r1 = this.k.N().a();
        JSONObject r2 = new JSONObject();
        r2.put(PickerReporterConstants.KEY.CLICK, r5);
        Unit r6 = Unit.INSTANCE;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        Intrinsics.checkNotNullParameter(r2, "payload");
        r1.a.g(r0, "vc_minutes_ai_notes_click", new JSONObject(r2.toString()));
    }

    public final long F(long r5) {
        if (r5 <= 0) goto L5;
        return r5;
    L5:
        Long r6 = Long.valueOf(((Number) this.j.p.getValue()).longValue());
        if (r6.longValue() <= 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L15;
        return r6.longValue();
    L15:
        return this.n;
    L8:
        r7 = false;
        goto L9
    }

    public final void H(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r7) {
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == true) goto L15;
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == true) goto L15;
        if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L10;
    L13:
        t();
        return;
    L10:
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L13;
        if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L13;
        return;
    L15:
        if (h().d == false) goto L17;
        lvb.a.e(this.w, "[startBizSessionIfNeeded] skip, already started " + r());
        return;
    L17:
        lvb.a.e(this.w, "[startBizSessionIfNeeded] start " + r());
        q0.a.getClass();
        AINoteContext r8 = q0.b();
        if (r8 != null) goto L20;
    L33:
        z(d(), new MmRecordingAINoteRepo$startBizSessionIfNeeded$1(this, null));
        return;
    L20:
        monitor-enter(r8);
        r8.d();     // Catch: Throwable -> L30
        if (r8.r == true) goto L25;
        AppLifecycle.a.a.c(r8.n);     // Catch: Throwable -> L30
        r8.r = true;     // Catch: Throwable -> L30
        int r3 = t.a;     // Catch: Throwable -> L30
        t.d("AINoteContext", "register AppLifecycle observer, userId=" + r8.a);     // Catch: Throwable -> L30
    L25:
        if (r8.s == true) goto L27;
        LarkContext.getApplication().registerComponentCallbacks(r8.o);     // Catch: Throwable -> L30
        r8.s = true;     // Catch: Throwable -> L30
        int r2 = t.a;     // Catch: Throwable -> L30
        t.d("AINoteContext", "register ComponentCallbacks, userId=" + r8.a);     // Catch: Throwable -> L30
    L27:
        r8.l("bizSessionStart");     // Catch: Throwable -> L30
        r8.t++;     // Catch: Throwable -> L30
        int r0 = t.a;     // Catch: Throwable -> L30
        t.d("AINoteContext", "bizSessionStart, depth=" + r8.t);     // Catch: Throwable -> L30
        monitor-exit(r8);
    L30:
        th = move-exception;
        throw th;
    }

    public final void I(String r4) {
        s(false, r4);
        z(d(), new MmRecordingAINoteRepo$unbindSaveSwitch$1(this, null));
        if (this.r == true) goto L5;
        return;
    L5:
        AINotes r5 = this.p.a;
        if (r5 == null) goto L8;
        r5.G(null);
    L8:
        AINotes r6 = this.p.a;
        if (r6 == null) goto L11;
        r6.F(null);
    L11:
        this.r = false;
    }

    public final void K(Long r4) {
        lvb.a.e(this.w, "[updatePhotoTargetNoteId] noteId=" + r4 + ' ' + r());
        z(d(), new MmRecordingAINoteRepo$updatePhotoTargetNoteId$1(this, r4, null));
    }

    public final com.ss.android.ainote.d n(String r4) {
        MmRecordingSession r0 = this.j;
        if (r0.a != RecordingSessionType.HARDWARE_RECORDING) goto L12;
        String r1 = r0.e();
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 != null) goto L13;
        r1 = r4;
    L13:
        return new com.ss.android.ainote.d(r1, r4, r1);
    L12:
        return new com.ss.android.ainote.d(r4, r4, 4);
    }

    public MmRecordingAINoteRepo(MmRecordingSession r7, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r8) {
        Intrinsics.checkNotNullParameter(r7, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r8, "mmUccApi");
        this.j = r7;
        this.k = r8;
        this.p = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.b();
        this.u = new ConcurrentHashMap();
        this.w = "MmRecordingAINoteRepo";
        BuildersKt.launch$default(r7.u, null, null, new MmRecordingAINoteRepo$observeSessionState$1(this, null), 3, null);
        com.ss.android.lark.image.i.a();
        q0.a.getClass();
        AINoteContext r9 = q0.b();
        if (r9 == null) goto L11;
        monitor-enter(r9);
        r9.d();     // Catch: Throwable -> L8
        r9.l("initSDK");     // Catch: Throwable -> L8
        t.d("AINoteContext", "initSDK");     // Catch: Throwable -> L8
        monitor-exit(r9);
    L8:
        th = move-exception;
        throw th;
    L11:
        H((com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) ((Pair) r7.t.getValue()).getSecond());
        this.x = LazyKt.lazy(new MmRecordingAINoteRepo$opt$2(this));
        this.y = new b(this);
    }

    public static void z(CoroutineScope r6, Function1 r7) {
        BuildersKt.launch$default(r6, null, null, new MmRecordingAINoteRepo$launchSafely$1(r7, null), 3, null);
    }

    public final Object A(String r27, Continuation<? super Unit> r28) {
        if ((r28 instanceof MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1) == false) goto L7;
        MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1 r2 = (MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L38:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r6 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L34:
        lvb.a.e(this.w, "[maybeShowSaveSwitchTooltip] reason=" + r6 + ' ' + r());
        j.f r7 = j.f.a;
        r2.L$0 = null;
        r2.label = 2;
        if (k(r7, r2) != r4) goto L38;
        return r4;
    L16:
        ResultKt.throwOnFailure(r1);
        c r8 = h();
        if (r8.e == false) goto L40;
        if (r8.g == true) goto L40;
        if (r8.i == false) goto L40;
        if (r8.j == false) goto L40;
        if (r8.l == true) goto L40;
        if (r8.k == true) goto L40;
        if (r8.n == false) goto L40;
        c r9 = c.a(r8, false, 0, null, false, false, false, false, false, false, false, false, true, true, false, false, false, 59391);
        r6 = r27;
        r2.L$0 = r6;
        r2.label = 1;
        if (b(r9, r2) != r4) goto L34;
        return r4;
    L40:
        return Unit.INSTANCE;
    L7:
        r2 = new MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1(this, r28);
        goto L8
    }

    public final String G(c r3, boolean r4) {
        if (r3.e == false) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return "none";
    L12:
        boolean r1 = r3.f;
        if (r1 == true) goto L16;
        if (r4 == false) goto L16;
        return "none";
    L16:
        if (r1 == true) goto L19;
        return "none";
    L19:
        if (r3.g == false) goto L21;
        return "true";
    L21:
        return "false";
    L5:
        if (y() == true) goto L8;
        r0 = false;
        goto L10
    }

    public final void s(boolean r4, String r5) {
        z(d(), new MmRecordingAINoteRepo$dismissSaveSwitchTooltip$1(this, r4, r5, null));
    }

    public final void w(String r6, boolean r7) {
        JSONObject r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = this.j.e();
        if (StringsKt.isBlank(r1) == false) goto L9;
        lvb.a.h(this.w, "[flushPendingViewEvent] skip, sessionId empty, reason=".concat(r6));
        return;
    L9:
        r0.put("save_notes_switch", G(h(), r7));
        this.t = null;
        lvb.a.e(this.w, "[flushPendingViewEvent] reason=" + r6 + " saveSwitch=" + r0.optString("save_notes_switch"));
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g r8 = this.k.N().a();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r0, "payload");
        r8.a.g(r1, "vc_minutes_ai_notes_view", new JSONObject(r0.toString()));
    }

    public static h p(String r11, s r12, String r13) {
        if (r11 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r2 = null;
        if (r1 == false) goto L14;
        if (r12 != null) goto L14;
        return null;
    L14:
        if (r12 == null) goto L16;
        String r5 = r12.a;
    L17:
        if (r12 == null) goto L19;
        r2 = r12.b;
    L19:
        String r6 = r2;
        if (r12 == null) goto L23;
        ByteString r3 = r12.c;
        if (r3 == null) goto L23;
    L24:
        ByteString r7 = r3;
        if (r12 == null) goto L27;
        int r8 = r12.e;
    L28:
        if (r12 == null) goto L30;
        int r9 = r12.f;
    L32:
        return new h(r11, r5, r6, r7, r8, r9, r13);
    L30:
        r9 = 0;
        goto L32
    L27:
        r8 = 0;
    L23:
        r3 = ByteString.EMPTY;
        goto L24
    L16:
        r5 = null;
        goto L17
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final Object l(MmRecordingAINoteRepo r5, c r6, String r7, Continuation r8) {
        r5.getClass();
        if ((r8 instanceof MmRecordingAINoteRepo$updateSaveSwitchEntity$1) == false) goto L7;
        MmRecordingAINoteRepo$updateSaveSwitchEntity$1 r0 = (MmRecordingAINoteRepo$updateSaveSwitchEntity$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L32:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (String) r0.L$1;
        r6 = (c) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L20:
        if (r6.e == true) goto L22;
    L30:
        r5.s(false, "entity_update:" + r7);
        return Unit.INSTANCE;
    L22:
        if (r6.g == true) goto L30;
        if (r6.i == false) goto L30;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r5.A(r7, r0) != r2) goto L32;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.label = 1;
        if (r5.b(r6, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new MmRecordingAINoteRepo$updateSaveSwitchEntity$1(r5, r8);
        goto L8
    }
}
