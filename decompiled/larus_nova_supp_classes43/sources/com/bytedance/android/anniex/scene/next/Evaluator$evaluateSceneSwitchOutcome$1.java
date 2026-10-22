package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class Evaluator$evaluateSceneSwitchOutcome$1 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends h>, Unit> {
    public Evaluator$evaluateSceneSwitchOutcome$1(Object r10) {
        super(2, r10, d.class, "evaluate", "evaluate(Ljava/lang/String;Ljava/util/Map;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(String r10, Map<String, h> r11) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        Intrinsics.checkNotNullParameter(r11, "p1");
        d r0 = (d) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "actualValue");
        Intrinsics.checkNotNullParameter(r11, "predictionsMap");
        Iterator<Map.Entry<String, h>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L45;
        Map.Entry<String, h> r1 = r12.next();
        String r13 = r1.getKey();
        h r14 = r1.getValue();
        if (r14.a != PredictElementType.SceneId) goto L4;
        List<xa.b<?>> r15 = r14.b;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L16;
        T r18 = ((xa.b) r17.next()).b;
        if ((r18 instanceof String) == false) goto L13;
        String r19 = (String) r18;
    L14:
        if (r19 == null) goto L9;
        r16.add(r19);
        goto L9
    L13:
        r19 = null;
        goto L14
    L16:
        ConcurrentHashMap r20 = (ConcurrentHashMap) r0.a;
        Object r21 = r20.get(r13);
        if (r21 != null) goto L22;
        r21 = new d.a(0);
        Object r22 = r20.putIfAbsent(r13, r21);
        if (r22 == null) goto L22;
        r21 = r22;
    L22:
        d.a r23 = (d.a) r21;
        if ((!r16.isEmpty()) == true) goto L25;
        r23.b++;
    L39:
        List<String> r24 = r0.b;
        if (r24 != null) goto L42;
    L44:
        r0.b = r16;
        goto L4
    L42:
        if (r0.b(r24, r10) == false) goto L44;
        r23.f++;
        Lazy r25 = SceneConnectCenter.a;
        SceneConnectCenter.h(r10, r13, SceneConnectCenter.HitType.DELAY_HIT);
        goto L44
    L25:
        if (r0.a((String) CollectionsKt.first(r16), r10) == false) goto L28;
        r23.d++;
        Lazy r26 = SceneConnectCenter.a;
        SceneConnectCenter.h(r10, r13, SceneConnectCenter.HitType.HIT);
    L28:
        if (r0.b(r16, r10) == false) goto L33;
        r23.e++;
        Lazy r27 = SceneConnectCenter.a;
        SceneConnectCenter.h(r10, r13, SceneConnectCenter.HitType.TOP_N_HIT);
        b r28 = b.a;
        Intrinsics.checkNotNullParameter(r10, "sceneId");
        if (((ConcurrentHashMap) b.b).containsKey(r10) == false) goto L32;
        r23.g++;
    L34:
        Iterator r29 = r16.iterator();
    L36:
        if (r29.hasNext() == false) goto L39;
        SceneConnectCenter.g((String) r29.next(), r13);
        goto L36
    L32:
        r23.h++;
        goto L34
    L33:
        r23.c++;
        goto L34
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        invoke((String) r1, (Map) r10);
        return Unit.INSTANCE;
    }
}
