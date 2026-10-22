package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityStartMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingRejectReason;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecordingPriorityDecisionEngine {
    public final c a;
    public final RecordingSamePriorityArbitrator b;
    public final String c;
    public final LinkedHashMap<String, tub.d> d;

    public RecordingPriorityDecisionEngine(int r3) {
        c r4 = new c(0);
        RecordingSamePriorityArbitrator r0 = new RecordingSamePriorityArbitrator();
        Intrinsics.checkNotNullParameter(r4, "rejectMessageResolver");
        Intrinsics.checkNotNullParameter(r0, "samePriorityArbitrator");
        this.a = r4;
        this.b = r0;
        this.c = "RecordingPriorityDecisionEngine_" + hashCode();
        this.d = new LinkedHashMap();
    }

    public static String g(Collection r9) {
        if (r9.isEmpty() == false) goto L7;
        return "[]";
    L7:
        return CollectionsKt.joinToString$default(r9, null, "[", "]", 0, null, RecordingPriorityDecisionEngine$toLogText$1.INSTANCE, 25, null);
    }

    public static List c(List r3, SceneRelation... r4) {
        ArrayList r0 = new ArrayList();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r1 = r5.next();
        if (ArraysKt.contains(r4, (SceneRelation) ((Pair) r1).component2()) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r7 = r0.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.add((tub.d) ((Pair) r7.next()).component1());
        goto L10
    L12:
        return r6;
    }

    public final void a(String r4, tub.e r5) {
        lvb.a.e(this.c, "[resolveStart] decision=" + r5 + ", scene=null, sceneInstanceId=" + r4 + ", active=" + g(this.d.values()));
    }

    public final synchronized void b(RecordingPriorityScene r5, String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "scene");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r6, "sceneInstanceId");     // Catch: Throwable -> L15
        tub.d r3 = this.d.get(r6);     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
        lvb.a.h(this.c, "[onSceneEnded] ignored missing instance, scene=" + r5 + ", sceneInstanceId=" + r6 + ", active=" + g(this.d.values()));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (r3.a != r5) goto L12;
        this.d.remove(r6);     // Catch: Throwable -> L15
        lvb.a.e(this.c, "[onSceneEnded] scene=" + r5 + ", sceneInstanceId=" + r6 + ", active=" + g(this.d.values()));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L12:
        lvb.a.h(this.c, "[onSceneEnded] ignored scene mismatch, scene=" + r5 + ", sceneInstanceId=" + r6 + ", current=" + r3 + ", active=" + g(this.d.values()));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final String d(RecordingPriorityScene r6, List<tub.d> r7) {
        Intrinsics.checkNotNullParameter(r6, "targetScene");
        Intrinsics.checkNotNullParameter(r7, "blockingInstances");
        c r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "targetScene");
        Intrinsics.checkNotNullParameter(r7, "blockingInstances");
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.add(((tub.d) r8.next()).a);
        goto L4
    L6:
        Iterator<T> r9 = c.b.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        Object r1 = r9.next();
        if (r0.contains((RecordingPriorityScene) r1) == false) goto L8;
    L13:
        RecordingPriorityScene r3 = (RecordingPriorityScene) r1;
        if (r3 == null) goto L28;
        String r10 = (String) r2.a.invoke(r6, r3);
        if (r10 != null) goto L19;
        return null;
    L19:
        if ((!StringsKt.isBlank(r10)) == true) goto L21;
        return null;
    L21:
        return r10;
    L28:
        return null;
    L12:
        r1 = null;
        goto L13
    }

    public final synchronized tub.e f(String r6, tub.b r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(null, "scene");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r7, "priorityContext");     // Catch: Throwable -> L25
        if (r6 == null) goto L24;
        List r1 = CollectionsKt.toList(this.d.values());     // Catch: Throwable -> L25
        lvb.a.e(this.c, "[resolveStart] scene=null, sceneInstanceId=" + r6 + ", priorityContext=" + r7 + ", active=" + g(r1));     // Catch: Throwable -> L25
        Iterator r0 = r1.iterator();     // Catch: Throwable -> L25
    L8:
        if (r0.hasNext() == false) goto L12;
        Object r3 = r0.next();     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(((tub.d) r3).b, r6) == false) goto L8;
    L13:
        tub.d r4 = (tub.d) r3;     // Catch: Throwable -> L25
        if (r4 != null) goto L16;
    L20:
        tub.e r8 = e(r6, r7, r1);     // Catch: Throwable -> L25
        a(r6, r8);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r8;
    L16:
        if (r4.a == null) goto L20;
        RecordingRejectReason r9 = RecordingRejectReason.SAME_INSTANCE_ALREADY_RUNNING;     // Catch: Throwable -> L25
        d(null, CollectionsKt.listOf(r4));     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L12:
        r3 = null;
        goto L13
    L24:
        throw null;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final tub.e e(String r10, tub.b r11, List r12) {
        List r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r14 = r13.iterator();
    L3:
        boolean r2 = true;
        tub.b.a r3 = null;
        if (r14.hasNext() == false) goto L28;
        tub.d r1 = (tub.d) r14.next();
        SceneRelation r4 = RecordingPriorityDecisionTableKt.a.get(TuplesKt.to(r1.a, null));
        if (r4 != null) goto L8;
        r4 = SceneRelation.REJECT;
    L8:
        RecordingSamePriorityArbitrator r5 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "activeInstance");
        Intrinsics.checkNotNullParameter(null, "requestedScene");
        Intrinsics.checkNotNullParameter(r11, "requestedContext");
        Intrinsics.checkNotNullParameter(r4, "configuredRelation");
        RecordingSamePriorityArbitrator.SamePriorityArbitrationPolicy r6 = RecordingSamePriorityArbitrator.b.get(new RecordingSamePriorityArbitrator.b(r1.a, null));
        if (r6 == null) goto L25;
        tub.b r7 = r1.c;
        if ((r7 instanceof tub.b.a) == false) goto L14;
        tub.b.a r8 = (tub.b.a) r7;
    L15:
        if (r8 == null) goto L25;
        if ((r11 instanceof tub.b.a) == false) goto L20;
        r3 = (tub.b.a) r11;
    L20:
        if (r3 == null) goto L25;
        lvb.a.e(r5.a, "[resolveRelation] activeScene=" + r1.a + ", requestedScene=null, activeStartedAt=" + r8 + ", requestedStartedAt=" + r3 + ", policy=" + r6);
        if (RecordingSamePriorityArbitrator.d.a[r6.ordinal()] != 1) goto L27;
        r4 = SceneRelation.INTERRUPT;
        goto L25
    L27:
        throw new NoWhenBranchMatchedException();
    L14:
        r8 = null;
    L25:
        r0.add(TuplesKt.to(r1, r4));
        goto L3
    L28:
        List<tub.d> r15 = c(r0, new SceneRelation[]{SceneRelation.REJECT});
        if (((ArrayList) r15).isEmpty() == false) goto L52;
        List r16 = c(r0, new SceneRelation[]{SceneRelation.INTERRUPT});
        if (RecordingPriorityScene.CALL_RECORD == null) goto L33;
    L49:
        RecordingPriorityStartMode r9 = RecordingPriorityStartMode.NORMAL;
    L51:
        return new tub.e.a(r10, r9, r16);
    L33:
        if (r0.isEmpty() == true) goto L46;
        Iterator r17 = r0.iterator();
    L37:
        if (r17.hasNext() == false) goto L46;
        Pair r18 = (Pair) r17.next();
        tub.d r19 = (tub.d) r18.component1();
        SceneRelation r20 = (SceneRelation) r18.component2();
        if (r19.a == RecordingPriorityScene.VIDEO_CONFERENCE) goto L41;
    L43:
        boolean r21 = false;
    L44:
        if (r21 == false) goto L37;
    L47:
        if (r2 == false) goto L49;
        r9 = RecordingPriorityStartMode.BACKGROUND;
        goto L51
    L41:
        if (r20 != SceneRelation.COEXIST) goto L43;
        r21 = true;
    L46:
        r2 = false;
        goto L47
    L52:
        RecordingRejectReason r110 = RecordingRejectReason.SAME_INSTANCE_ALREADY_RUNNING;
        d(null, r15);
        throw null;
    }
}
