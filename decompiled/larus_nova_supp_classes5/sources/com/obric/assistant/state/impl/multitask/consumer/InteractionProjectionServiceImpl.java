package com.obric.assistant.state.impl.multitask.consumer;

import aha.a0;
import aha.d;
import aha.e0;
import aha.h0;
import aha.j;
import aha.l;
import aha.t;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.IObricInteractionProjectionService;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import jha.f;
import jha.h;
import jha.o;
import jha.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;
import zga.b;
import zga.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\b\u0007\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u001a\u001a\u00020\u00162\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\tH\u0002J.\u0010!\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010$\u001a\u00020\tH\u0002J&\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010'\u001a\u00020\n2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010+\u001a\u00020)2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u001a\u00102\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u0014\u001a\u00020\tH\u0002J \u00105\u001a\u0002012\b\u00106\u001a\u0004\u0018\u0001042\f\u00107\u001a\b\u0012\u0004\u0012\u00020 08H\u0002J\u0012\u00109\u001a\u0004\u0018\u0001012\u0006\u0010:\u001a\u00020/H\u0002J\u0012\u0010;\u001a\u0004\u0018\u0001012\u0006\u0010:\u001a\u00020/H\u0002J\u0018\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0002J\"\u0010?\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010A\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020-H\u0002R\"\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/InteractionProjectionServiceImpl;", "Lcom/obric/assistant/state/api/multitask/IObricInteractionProjectionService;", "<init>", "()V", "currentStates", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;", "latestProjections", "", "Lcom/obric/assistant/state/api/multitask/InteractionProjection;", "pendingRounds", "", "Lcom/obric/assistant/state/impl/multitask/consumer/InteractionProjectionServiceImpl$PendingRound;", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/assistant/state/impl/multitask/consumer/InteractionProjectionServiceImpl$ObserverRegistration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "snapshot", "botId", "observe", "", "observer", "Lcom/obric/assistant/state/api/multitask/InteractionProjectionObserver;", "removeObserver", "consumeTaskFlowEvent", "id", "event", "resolveCompletionPhase", "Lcom/obric/assistant/state/impl/multitask/consumer/InteractionProjectionServiceImpl$PhaseOverride;", "taskState", "", "commitProjection", "phaseOverride", "triggerEvent", "trigger", "stabilizeProjection", "previous", "candidate", "hasPendingVoiceInput", "", "sessionId", "isExplicitRoundStart", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "phaseOrder", "", "phase", "Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "buildProjection", "currentModeState", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionModeState;", "foregroundPhase", "modeState", "states", "", "realtimePhase", "state", "voiceCapturePhase", "hasActiveTts", "conversationId", "messageId", "pendingKey", "findPendingBotId", "defaultProjection", "modePriority", EffectConfiguration.KEY_TYPE, "Companion", "PendingRound", "PhaseOverride", "ObserverRegistration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionProjectionServiceImpl implements IObricInteractionProjectionService {
    public static final /* synthetic */ int f = 0;
    public final ConcurrentHashMap<jha.g<?>, q<?>> a;
    public final ConcurrentHashMap<String, b> b;
    public final Map<String, c> c;
    public final CopyOnWriteArraySet<b> d;
    public final CoroutineScope e;

    /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.consumer.InteractionProjectionServiceImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.state.impl.multitask.consumer.InteractionProjectionServiceImpl$1", f = "InteractionProjectionServiceImpl.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InteractionProjectionServiceImpl this$0;

        /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.consumer.InteractionProjectionServiceImpl$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InteractionProjectionServiceImpl a;

            public a(InteractionProjectionServiceImpl r1) {
                this.a = r1;
            }

            public final Object emit(Object r24, Continuation r25) {
                Pair r0 = (Pair) r24;
                jha.g<?> r1 = (jha.g) r0.component1();
                q<?> r2 = (q) r0.component2();
                InteractionProjectionServiceImpl r3 = this.a;
                int r4 = InteractionProjectionServiceImpl.f;
                r3.getClass();
                e0.a r5 = r2.a().b;
                if ((r5 instanceof t) == false) goto L5;
                t r6 = (t) r5;
            L6:
                if (r6 == null) goto L546;
                String r7 = r6.getBotId();
                if (r7 != null) goto L45;
                if ((r5 instanceof e0.a) == false) goto L13;
                e0.a r8 = r5;
            L14:
                if (r8 == null) goto L41;
                String r9 = r8.h;
                if (r9 == null) goto L41;
                String r10 = r8.i;
                if (r10 == null) goto L41;
                Iterator<T> r11 = ((LinkedHashMap) r3.c).values().iterator();
            L24:
                if (r11.hasNext() == false) goto L37;
                T r12 = r11.next();
                c r13 = (c) r12;
                if (Intrinsics.areEqual(r13.c, r9) == true) goto L28;
            L34:
                boolean r14 = false;
            L35:
                if (r14 == false) goto L24;
            L38:
                c r15 = (c) r12;
                if (r15 == null) goto L41;
                r7 = r15.a;
            L42:
                if (r7 != null) goto L45;
            L28:
                if (Intrinsics.areEqual(r13.d, r10) == false) goto L34;
                if (r8.c() != null) goto L32;
            L33:
                r14 = true;
                goto L35
            L32:
                if (Intrinsics.areEqual(r13.b, r8.c()) == false) goto L34;
            L37:
                r12 = null;
            L41:
                r7 = null;
                goto L42
            L13:
                r8 = null;
            L45:
                if ((r5.a() instanceof h.c) == false) goto L47;
                r3.a.remove(r1);
            L49:
                if ((r5 instanceof l.b) == false) goto L52;
                r3.a.entrySet().removeIf(new d(new c(r5)));
                ((LinkedHashMap) r3.c).entrySet().removeIf(new f(new e(r5)));
            L52:
                if ((r5 instanceof aha.q.b) == false) goto L98;
                aha.q.b r16 = (aha.q.b) r5;
                Map r17 = r16.i;
                if (r17 == null) goto L56;
                boolean r18 = Intrinsics.areEqual(r17.get("timeout"), Boolean.TRUE);
            L57:
                if (r18 == true) goto L141;
                Map r19 = r16.i;
                if (r19 == null) goto L61;
                boolean r110 = Intrinsics.areEqual(r19.get("round_completed"), Boolean.TRUE);
            L62:
                if (r110 == false) goto L141;
                String r111 = r16.c();
                if (r111 == null) goto L141;
                l r112 = r3.e(r7);
                if (r112 == null) goto L70;
                String r113 = r112.f();
            L72:
                if (Intrinsics.areEqual(r113, r111) == false) goto L141;
                String r114 = r16.e;
                if (r114 == null) goto L141;
                c r115 = new c(r7, r111, r16.d, r114);
                String r20 = r16.d;
                Collection<q<?>> r116 = r3.a.values();
                if (r116.isEmpty() == true) goto L93;
                Iterator<T> r117 = r116.iterator();
            L82:
                if (r117.hasNext() == false) goto L93;
                e0 r118 = ((q) r117.next()).a().b;
                if ((r118 instanceof e0) == false) goto L90;
                e0 r119 = r118;
                if (Intrinsics.areEqual(r119.e(), r20) == false) goto L90;
                if (Intrinsics.areEqual(r119.f(), r114) == false) goto L90;
                boolean r21 = true;
            L91:
                if (r21 == false) goto L82;
                boolean r22 = true;
            L94:
                if (r22 == false) goto L96;
                r3.c.put(r115.b + '#' + r115.c + '#' + r115.d, r115);
                goto L141
            L96:
                d r23 = new d(ForegroundInteractionPhase.Generated, r111);
            L142:
                String r26 = r2.getClass().getSimpleName() + ':' + r5.getClass().getSimpleName();
                Collection<q<?>> r27 = r3.a.values();
                ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
                Iterator<T> r29 = r27.iterator();
            L144:
                if (r29.hasNext() == false) goto L146;
                r28.add(((q) r29.next()).a().b);
                goto L144
            L146:
                ArrayList r30 = new ArrayList();
                Iterator r31 = r28.iterator();
            L148:
                if (r31.hasNext() == false) goto L159;
                Object r120 = r31.next();
                t r121 = (o) r120;
                if ((r121 instanceof t) == false) goto L152;
                t r122 = r121;
            L153:
                if (r122 == null) goto L155;
                String r123 = r122.getBotId();
            L157:
                if (Intrinsics.areEqual(r123, r7) == false) goto L148;
                r30.add(r120);
                goto L148
            L155:
                r123 = null;
                goto L157
            L152:
                r122 = null;
                goto L153
            L159:
                l r32 = r3.e(r7);
                if (r32 != null) goto L167;
                ArrayList r124 = new ArrayList();
                Iterator r33 = r30.iterator();
            L163:
                if (r33.hasNext() == false) goto L186;
                Object r125 = r33.next();
                if ((((o) r125) instanceof l) == true) goto L163;
                r124.add(r125);
            L186:
                if (r32 == null) goto L188;
                String r34 = r32.d();
            L189:
                if (r32 == null) goto L192;
                ObricInteractionType r126 = r32.e();
                if (r126 == null) goto L192;
            L193:
                if (r32 == null) goto L195;
                String r127 = r32.f();
            L197:
                if (r23 == null) goto L210;
                String r35 = r23.b;
                if (r32 == null) goto L201;
                String r36 = r32.f();
            L203:
                if (Intrinsics.areEqual(r35, r36) == true) goto L206;
                r23 = null;
            L206:
                if (r23 == null) goto L210;
                ForegroundInteractionPhase r37 = r23.a;
                if (r37 == null) goto L210;
            L240:
                ForegroundInteractionPhase r128 = r37;
            L429:
                b r38 = new b(r7, r34, r126, r127, r128);
                b r39 = r3.b.get(r7);
                if (r39 != null) goto L432;
            L522:
                b r40 = r3.b.put(r7, r38);
                if (Intrinsics.areEqual(r40, r38) == true) goto L546;
                FLogger r41 = FLogger.a;
                StringBuilder r42 = new StringBuilder("projection changed trigger=");
                r42.append(r26);
                r42.append(", botId=");
                r42.append(r7);
                r42.append(", mode=");
                if (r40 == null) goto L528;
                ObricInteractionType r43 = r40.c;
            L529:
                r42.append(r43);
                r42.append("->");
                r42.append(r38.c);
                r42.append(", sessionId=");
                if (r40 == null) goto L532;
                String r44 = r40.d;
            L533:
                r42.append(r44);
                r42.append("->");
                r42.append(r38.d);
                r42.append(", phase=");
                if (r40 == null) goto L536;
                ForegroundInteractionPhase r45 = r40.e;
            L537:
                r42.append(r45);
                r42.append("->");
                r42.append(r38.e);
                r41.i("InteractionProjectionServiceImpl", r42.toString());
                Iterator<b> r46 = r3.d.iterator();
            L539:
                if (r46.hasNext() == false) goto L546;
                b r47 = r46.next();
                String r48 = r47.a;
                if (r48 == null) goto L544;
                if (Intrinsics.areEqual(r48, r7) == false) goto L539;
            L544:
                r47.b.a(r38);
                goto L539
            L536:
                r45 = null;
                goto L537
            L532:
                r44 = null;
                goto L533
            L528:
                r43 = null;
                goto L529
            L432:
                if (Intrinsics.areEqual(r39.d, r38.d) == false) goto L522;
                if (r39.c != r38.c) goto L522;
                ForegroundInteractionPhase r49 = r39.e;
                ForegroundInteractionPhase r129 = r38.e;
                if (r49 == r129) goto L522;
                if (r129 != ForegroundInteractionPhase.Generated) goto L487;
                String r130 = r38.d;
                if (r130 == null) goto L484;
                Collection<q<?>> r50 = r3.a.values();
                if (r50.isEmpty() == true) goto L484;
                Iterator<T> r51 = r50.iterator();
            L448:
                if (r51.hasNext() == false) goto L484;
                h0.d r52 = ((q) r51.next()).a().b;
                if ((r52 instanceof t) == false) goto L452;
                t r53 = (t) r52;
            L453:
                if (r53 == null) goto L455;
                String r54 = r53.c();
            L457:
                if (Intrinsics.areEqual(r54, r130) == true) goto L459;
                Iterator<T> r210 = r51;
            L480:
                boolean r55 = false;
            L481:
                if (r55 == true) goto L482;
                r51 = r210;
                goto L448
            L482:
                boolean r56 = true;
            L485:
                if (r56 == false) goto L487;
                r38 = b.a(r38, r49);
                goto L522
            L459:
                if ((r52 instanceof h0.b) == false) goto L462;
            L460:
                r210 = r51;
            L474:
                boolean r57 = true;
            L477:
                if (r57 == false) goto L480;
                r55 = true;
                goto L481
            L462:
                if ((r52 instanceof h0.d) == false) goto L475;
                Map r58 = r52.h;
                if (r58 == null) goto L466;
                Object r59 = r58.get("instance_call_state");
            L468:
                if ((r59 instanceof Integer) == false) goto L470;
                Integer r60 = (Integer) r59;
            L471:
                if (r60 == null) goto L460;
                r210 = r51;
                if (SetsKt.setOf(new Integer[]{1, 2, 9, 3}).contains(r60) == true) goto L474;
            L476:
                r57 = false;
                goto L477
            L470:
                r60 = null;
                goto L471
            L466:
                r59 = null;
                goto L468
            L475:
                r210 = r51;
                goto L476
            L455:
                r54 = null;
                goto L457
            L452:
                r53 = null;
            L484:
                r56 = false;
            L487:
                ForegroundInteractionPhase r61 = ForegroundInteractionPhase.Idle;
                if (r129 == r61) goto L522;
                ObricInteractionType r62 = r38.c;
                a0.a r63 = r2.a().b;
                if ((r63 instanceof h0.b) == true) goto L508;
                boolean r131 = r2 instanceof q.b;
                if (r131 == false) goto L499;
                if ((r63 instanceof h0.d) == true) goto L508;
            L499:
                if ((r63 instanceof a0.a) == false) goto L502;
                boolean r64 = CollectionsKt.contains(SetsKt.setOf(new ForegroundInteractionPhase[]{ForegroundInteractionPhase.Activate, ForegroundInteractionPhase.Connecting, ForegroundInteractionPhase.Listen}), InteractionProjectionServiceImpl.g(r63.g));
            L511:
                if (r64 == true) goto L522;
                if (r49 == ForegroundInteractionPhase.Generated) goto L521;
                if (r49 == r61) goto L521;
                if (InteractionProjectionServiceImpl.f(r129) >= InteractionProjectionServiceImpl.f(r49)) goto L522;
                FLogger.a.i("InteractionProjectionServiceImpl", "ignore regressive phase in same session, botId=" + r38.a + ", sessionId=" + r38.d + ", phase=" + r49 + "->" + r129 + ", trigger=" + r2.getClass().getSimpleName() + ':' + r2.a().b.getClass().getSimpleName());
                r38 = b.a(r38, r49);
            L521:
                r38 = b.a(r38, r49);
                goto L522
            L502:
                if (r62 != ObricInteractionType.TextMode) goto L510;
                if (r131 == false) goto L510;
                if ((r63 instanceof aha.q.a) == false) goto L510;
                if (SetsKt.setOf(new Integer[]{0, 1, 2, 10}).contains(Integer.valueOf(((aha.q.a) r63).f)) == true) goto L508;
            L510:
                r64 = false;
            L508:
                r64 = true;
                goto L511
            L201:
                r36 = null;
            L210:
                if (r32 == null) goto L212;
            L214:
                if (r32 == null) goto L216;
                ObricInteractionType r65 = r32.e();
            L218:
                if (r65 == ObricInteractionType.RealtimeCallMode) goto L220;
            L222:
                ArrayList r66 = new ArrayList();
                Iterator<T> r67 = r124.iterator();
            L224:
                if (r67.hasNext() == false) goto L228;
                T r68 = r67.next();
                if ((r68 instanceof a0) == false) goto L224;
                r66.add(r68);
                goto L224
            L228:
                a0.a r69 = (a0) CollectionsKt.firstOrNull(r66);
                if (r69 != null) goto L231;
            L241:
                ArrayList r70 = new ArrayList();
                Iterator<T> r71 = r124.iterator();
            L243:
                if (r71.hasNext() == false) goto L247;
                T r72 = r71.next();
                if ((r72 instanceof h0) == false) goto L243;
                r70.add(r72);
                goto L243
            L247:
                h0 r73 = (h0) CollectionsKt.firstOrNull(r70);
                if (r73 == null) goto L283;
                Map r74 = r73.d();
                if (r74 == null) goto L252;
                Object r75 = r74.get("instance_call_state");
            L254:
                if ((r75 instanceof Integer) == false) goto L256;
                Integer r76 = (Integer) r75;
            L257:
                if (r76 == null) goto L283;
                int r77 = r76.intValue();
                if (r77 == (-1)) goto L278;
                if (r77 != 9) goto L263;
            L276:
                ForegroundInteractionPhase r78 = ForegroundInteractionPhase.Activate;
            L279:
                if (r78 == null) goto L283;
            L294:
                r128 = r78;
                goto L429
            L263:
                if (r77 != 1) goto L265;
                r78 = ForegroundInteractionPhase.Connecting;
                goto L279
            L265:
                if (r77 == 2) goto L276;
                if (r77 != 4) goto L269;
                r78 = ForegroundInteractionPhase.Thinking;
                goto L279
            L269:
                if (r77 != 5) goto L271;
                r78 = ForegroundInteractionPhase.Generating;
                goto L279
            L271:
                if (r77 == 6) goto L278;
                r78 = null;
            L278:
                r78 = ForegroundInteractionPhase.Idle;
                goto L279
            L256:
                r76 = null;
                goto L257
            L252:
                r75 = null;
            L283:
                if (r124.isEmpty() == true) goto L291;
                Iterator<T> r79 = r124.iterator();
            L287:
                if (r79.hasNext() == false) goto L291;
                if ((r79.next() instanceof h0.b) == false) goto L287;
                boolean r80 = true;
            L292:
                if (r80 == false) goto L296;
                r78 = ForegroundInteractionPhase.Listen;
                goto L294
            L296:
                if (r124.isEmpty() == true) goto L304;
                Iterator<T> r81 = r124.iterator();
            L300:
                if (r81.hasNext() == false) goto L304;
                if ((r81.next() instanceof h0.a) == false) goto L300;
                boolean r82 = true;
            L305:
                if (r82 == false) goto L308;
                r78 = ForegroundInteractionPhase.Thinking;
                goto L294
            L308:
                if (r124.isEmpty() == true) goto L324;
                Iterator<T> r83 = r124.iterator();
            L312:
                if (r83.hasNext() == false) goto L324;
                T r84 = r83.next();
                if ((r84 instanceof h0.d) == false) goto L321;
                Map r85 = ((h0.d) r84).h;
                if (r85 == null) goto L318;
                boolean r86 = Intrinsics.areEqual(r85.get("instance_call_state"), 2);
            L319:
                if (r86 == false) goto L321;
                boolean r87 = true;
            L322:
                if (r87 == false) goto L312;
                boolean r88 = true;
            L325:
                if (r88 == false) goto L327;
                r78 = ForegroundInteractionPhase.Activate;
                goto L294
            L327:
                if (r32 == null) goto L329;
                ObricInteractionType r89 = r32.e();
            L331:
                if (r89 != ObricInteractionType.AutoHalfDuplex) goto L345;
                if (r124.isEmpty() == true) goto L341;
                Iterator<T> r90 = r124.iterator();
            L337:
                if (r90.hasNext() == false) goto L341;
                if ((r90.next() instanceof h0.d) == false) goto L337;
                boolean r91 = true;
            L342:
                if (r91 == false) goto L345;
                r78 = ForegroundInteractionPhase.Connecting;
            L341:
                r91 = false;
            L345:
                if (r124.isEmpty() == true) goto L353;
                Iterator<T> r92 = r124.iterator();
            L349:
                if (r92.hasNext() == false) goto L353;
                if ((r92.next() instanceof j.b) == false) goto L349;
                boolean r93 = true;
            L354:
                if (r93 == false) goto L356;
                r78 = ForegroundInteractionPhase.Thinking;
                goto L294
            L356:
                ArrayList r94 = new ArrayList();
                Iterator<T> r95 = r124.iterator();
            L358:
                if (r95.hasNext() == false) goto L363;
                T r132 = r95.next();
                if ((r132 instanceof aha.q.a) == false) goto L358;
                r94.add(r132);
                goto L358
            L363:
                if (r94.isEmpty() == true) goto L377;
                Iterator r96 = r94.iterator();
            L367:
                if (r96.hasNext() == false) goto L377;
                int r133 = ((aha.q.a) r96.next()).f;
                if (r133 != 20) goto L371;
            L374:
                boolean r134 = true;
            L375:
                if (r134 == false) goto L367;
                boolean r97 = true;
            L378:
                if (r97 == false) goto L380;
                r78 = ForegroundInteractionPhase.Generating;
                goto L294
            L380:
                Set r98 = SetsKt.setOf(new ObricInteractionType[]{ObricInteractionType.DefaultMode, ObricInteractionType.TextMode});
                if (r32 == null) goto L383;
                ObricInteractionType r99 = r32.e();
            L385:
                if (CollectionsKt.contains(r98, r99) == false) goto L402;
                if (r94.isEmpty() == true) goto L398;
                Iterator r100 = r94.iterator();
            L391:
                if (r100.hasNext() == false) goto L398;
                if (((aha.q.a) r100.next()).f != 11) goto L395;
                boolean r101 = true;
            L396:
                if (r101 == false) goto L391;
                boolean r102 = true;
            L399:
                if (r102 == false) goto L402;
                r78 = ForegroundInteractionPhase.Thinking;
                goto L294
            L395:
                r101 = false;
            L398:
                r102 = false;
            L402:
                if (r124.isEmpty() == true) goto L410;
                Iterator<T> r103 = r124.iterator();
            L406:
                if (r103.hasNext() == false) goto L410;
                if ((r103.next() instanceof e0.b) == false) goto L406;
                boolean r104 = true;
            L411:
                if (r104 == false) goto L414;
                r78 = ForegroundInteractionPhase.Generating;
                goto L294
            L414:
                if (r124.isEmpty() == true) goto L422;
                Iterator<T> r105 = r124.iterator();
            L418:
                if (r105.hasNext() == false) goto L422;
                if ((r105.next() instanceof d.a) == false) goto L418;
                boolean r106 = true;
            L423:
                if (r106 == false) goto L426;
                r78 = ForegroundInteractionPhase.Thinking;
                goto L294
            L426:
                if ((!r94.isEmpty()) == false) goto L428;
                r78 = ForegroundInteractionPhase.Activate;
                goto L294
            L428:
                r78 = ForegroundInteractionPhase.Activate;
            L422:
                r106 = false;
            L410:
                r104 = false;
                goto L411
            L383:
                r99 = null;
                goto L385
            L371:
                if (r133 == 24) goto L374;
                r134 = false;
            L377:
                r97 = false;
            L353:
                r93 = false;
                goto L354
            L329:
                r89 = null;
                goto L331
            L318:
                r86 = false;
            L321:
                r87 = false;
            L324:
                r88 = false;
            L304:
                r82 = false;
            L291:
                r80 = false;
                goto L292
            L231:
                if ((r69 instanceof a0.a) == false) goto L238;
                Map r107 = r69.i;
                if (r107 == null) goto L235;
                boolean r108 = Intrinsics.areEqual(r107.get("round_completed"), Boolean.TRUE);
            L236:
                if (r108 == false) goto L238;
                r37 = ForegroundInteractionPhase.Generated;
                goto L240
            L235:
                r108 = false;
            L238:
                r37 = InteractionProjectionServiceImpl.g(r69.d());
                if (r37 == null) goto L241;
            L220:
                if (r124.isEmpty() == false) goto L222;
                r37 = ForegroundInteractionPhase.Idle;
                goto L240
            L216:
                r65 = null;
                goto L218
            L212:
                if (r124.isEmpty() == false) goto L214;
                r37 = ForegroundInteractionPhase.Idle;
                goto L240
            L195:
                r127 = null;
            L192:
                r126 = ObricInteractionType.DefaultMode;
                goto L193
            L188:
                r34 = null;
                goto L189
            L167:
                r124 = new ArrayList();
                Iterator r109 = r30.iterator();
            L169:
                if (r109.hasNext() == false) goto L186;
                Object r135 = r109.next();
                t r136 = (o) r135;
                if ((r136 instanceof l) == false) goto L173;
            L182:
                boolean r137 = false;
            L183:
                if (r137 == false) goto L169;
                r124.add(r135);
                goto L169
            L173:
                if ((r136 instanceof t) == false) goto L175;
                t r138 = r136;
            L176:
                if (r138 == null) goto L178;
                String r139 = r138.c();
            L180:
                if (Intrinsics.areEqual(r139, r32.f()) == false) goto L182;
                r137 = true;
                goto L183
            L178:
                r139 = null;
                goto L180
            L175:
                r138 = null;
            L90:
                r21 = false;
            L93:
                r22 = false;
                goto L94
            L70:
                r113 = null;
                goto L72
            L61:
                r110 = false;
            L141:
                r23 = null;
                goto L142
            L56:
                r18 = false;
                goto L57
            L98:
                if ((r5 instanceof e0.a) == false) goto L130;
                e0.a r140 = r5;
                String r141 = r140.h;
                if (r141 == null) goto L141;
                String r142 = r140.i;
                if (r142 == null) goto L141;
                if (r140.c() != null) goto L123;
                Iterator<T> r143 = ((LinkedHashMap) r3.c).entrySet().iterator();
            L109:
                if (r143.hasNext() == false) goto L118;
                T r144 = r143.next();
                c r145 = (c) ((Map.Entry) r144).getValue();
                if (Intrinsics.areEqual(r145.c, r141) == true) goto L113;
            L115:
                boolean r146 = false;
            L116:
                if (r146 == false) goto L109;
            L119:
                Map.Entry r147 = (Map.Entry) r144;
                if (r147 == null) goto L122;
                c r148 = r3.c.remove(r147.getKey());
            L124:
                if (r148 == null) goto L141;
                String r149 = r148.b;
                if (r149 == null) goto L141;
                d r150 = new d(ForegroundInteractionPhase.Generated, r149);
            L140:
                r23 = r150;
                goto L142
            L122:
                r148 = null;
                goto L124
            L113:
                if (Intrinsics.areEqual(r145.d, r142) == false) goto L115;
                r146 = true;
                goto L116
            L118:
                r144 = null;
                goto L119
            L123:
                r148 = r3.c.remove(r140.c() + '#' + r141 + '#' + r142);
                goto L124
            L130:
                if ((r5 instanceof a0.a) == false) goto L141;
                a0.a r151 = (a0.a) r5;
                Map r152 = r151.i;
                if (r152 == null) goto L134;
                boolean r153 = Intrinsics.areEqual(r152.get("round_completed"), Boolean.TRUE);
            L135:
                if (r153 == false) goto L141;
                String r154 = r151.c();
                if (r154 == null) goto L141;
                r150 = new d(ForegroundInteractionPhase.Generated, r154);
                goto L140
            L134:
                r153 = false;
                goto L135
            L47:
                r3.a.put(r1, r2);
            L546:
                return Unit.INSTANCE;
            L5:
                r6 = null;
                goto L6
            }
        }

        public AnonymousClass1(InteractionProjectionServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            a1 r6 = TaskFlowManager.h;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public InteractionProjectionServiceImpl() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new LinkedHashMap();
        this.d = new CopyOnWriteArraySet();
        ExecutorCoroutineDispatcher r0 = f.a;
        Intrinsics.checkNotNullParameter("InteractionProjectionServiceImpl", "orderingDomain");
        CoroutineScope r1 = f.b("InteractionProjectionServiceImpl").b;
        this.e = r1;
        BuildersKt.launch$default(r1, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
    }

    public static int f(ForegroundInteractionPhase r1) {
        switch(e.a[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return 6;
    L7:
        return 5;
    L8:
        return 4;
    L9:
        return 3;
    L10:
        return 1;
    L11:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static ForegroundInteractionPhase g(int r1) {
        if (r1 == 9) goto L12;
        switch(r1) {
            case -1: goto L18;
            case 0: goto L17;
            case 1: goto L17;
            case 2: goto L12;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L18;
            default: goto L13;
        };
    L13:
        return ForegroundInteractionPhase.Activate;
    L14:
        return ForegroundInteractionPhase.Generating;
    L15:
        return ForegroundInteractionPhase.Thinking;
    L16:
        return ForegroundInteractionPhase.Listen;
    L17:
        return ForegroundInteractionPhase.Connecting;
    L18:
        return ForegroundInteractionPhase.Idle;
    L12:
        return ForegroundInteractionPhase.Activate;
    }

    public final b a(String r8) {
        if (r8 != null) goto L6;
        b r9 = (b) CollectionsKt.maxWithOrNull(this.b.values(), new i(new h(this)));
        if (r9 == null) goto L12;
        return r9;
    L12:
        return new b(null, null, ObricInteractionType.NullMode, null, ForegroundInteractionPhase.Idle);
    L6:
        b r0 = this.b.get(r8);
        if (r0 != null) goto L10;
        r0 = new b(r8, null, ObricInteractionType.DefaultMode, null, ForegroundInteractionPhase.Idle);
    L10:
        return r0;
    }

    public final void c(c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.d.removeIf(new b(new a(r3)));
    }

    public final l e(String r7) {
        Collection<q<?>> r0 = this.a.values();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((q) r2.next()).a().b);
        goto L4
    L6:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        t r6 = (o) r5;
        String r8 = null;
        if ((r6 instanceof t) == false) goto L12;
        t r9 = r6;
    L13:
        if (r9 == null) goto L16;
        r8 = r9.getBotId();
    L16:
        if (Intrinsics.areEqual(r8, r7) == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        r9 = null;
        goto L13
    L18:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r3.iterator();
    L20:
        if (r11.hasNext() == false) goto L25;
        Object r12 = r11.next();
        if ((r12 instanceof l) == false) goto L20;
        r10.add(r12);
        goto L20
    L25:
        return (l) CollectionsKt.maxWithOrNull(r10, new g(new f(this)));
    }

    public static final int d(InteractionProjectionServiceImpl r0, ObricInteractionType r1) {
        r0.getClass();
        switch(e.b[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 0;
    L7:
        return 1;
    L8:
        return 2;
    L9:
        return 3;
    L10:
        return 4;
    L11:
        return 5;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(String r3, c r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        this.d.add(new b(r3, r4));
        r4.a(a(r3));
    }
}
