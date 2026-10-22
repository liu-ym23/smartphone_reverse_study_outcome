package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class Evaluator$evaluateSceneRepeatOutcome$1 extends FunctionReferenceImpl implements Function2<Boolean, Map<String, ? extends h>, Unit> {
    public Evaluator$evaluateSceneRepeatOutcome$1(Object r10) {
        super(2, r10, e.class, "evaluate", "evaluate(ZLjava/util/Map;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(boolean r10, Map<String, h> r11) {
        Intrinsics.checkNotNullParameter(r11, "p1");
        e r0 = (e) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "predictionsMap");
        Iterator<Map.Entry<String, h>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L36;
        Map.Entry<String, h> r1 = r12.next();
        String r13 = r1.getKey();
        h r14 = r1.getValue();
        if (r14.a != PredictElementType.SceneRepeat) goto L4;
        List<xa.b<?>> r15 = r14.b;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L16;
        T r18 = ((xa.b) r17.next()).b;
        if ((r18 instanceof Boolean) == false) goto L13;
        Boolean r19 = (Boolean) r18;
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
        r21 = new e.a(0);
        Object r22 = r20.putIfAbsent(r13, r21);
        if (r22 == null) goto L22;
        r21 = r22;
    L22:
        e.a r23 = (e.a) r21;
        r23.a++;
        if (r10 == false) goto L26;
        r23.b++;
    L26:
        if ((!r16.isEmpty()) == false) goto L4;
        if (((Boolean) CollectionsKt.first(r16)).booleanValue() == false) goto L31;
        r23.d++;
    L31:
        if (r16.contains(Boolean.valueOf(r10)) == false) goto L4;
        if (r10 == false) goto L34;
        r23.f++;
    L35:
        r23.e++;
        goto L4
    L34:
        r23.g++;
        goto L35
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        invoke(((Boolean) r1).booleanValue(), (Map) r10);
        return Unit.INSTANCE;
    }
}
