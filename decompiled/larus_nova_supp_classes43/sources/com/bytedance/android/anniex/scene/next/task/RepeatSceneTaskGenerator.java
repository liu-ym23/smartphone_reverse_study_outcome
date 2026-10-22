package com.bytedance.android.anniex.scene.next.task;

import com.bytedance.android.anniex.scene.handler.idle.h;
import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wa.e;
import xa.a;
import xa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RepeatSceneTaskGenerator implements e<List<? extends b<Boolean>>, a> {
    public final Lazy a;

    public RepeatSceneTaskGenerator() {
        this.a = LazyKt.lazy(RepeatSceneTaskGenerator$preExecutionElementList$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wa.e
    public final void a(PredictElementType r10, String r11, List<? extends b<Boolean>> r12) {
        List<? extends b<Boolean>> r13 = r12;
        Intrinsics.checkNotNullParameter(r10, "elementType");
        Intrinsics.checkNotNullParameter(r11, "currentSceneId");
        Intrinsics.checkNotNullParameter(r13, "input");
        if (r13.isEmpty() == false) goto L5;
        return;
    L5:
        if (((Boolean) ((b) CollectionsKt.first(r13)).b).booleanValue() == false) goto L33;
        b r14 = (b) CollectionsKt.first(r13);
        ArrayList r15 = new ArrayList();
        List r0 = StringsKt.split$default(r11, new char[]{','}, false, 0, 6, null);
        ArrayList r1 = new ArrayList();
        Iterator r16 = r0.iterator();
    L9:
        if (r16.hasNext() == false) goto L13;
        Object r17 = r16.next();
        if ((!StringsKt.isBlank((String) r17)) == false) goto L9;
        r1.add(r17);
        goto L9
    L13:
        r15.add(new a(r11, CollectionsKt.distinct(r1)));
        if ((true ^ r15.isEmpty()) == false) goto L32;
        Iterator r18 = ((List) this.a.getValue()).iterator();
    L17:
        if (r18.hasNext() == false) goto L34;
        com.bytedance.android.anniex.scene.handler.idle.b r19 = ((wa.a) r18.next()).a(r11, r15);
        if (r19 == null) goto L17;
        h.a.a(r19);
        HybridLogger.f("PredictManager", "RepeatScene IdleTaskQueue 执行预执行任务", null, 12);
        goto L17
    L34:
        return;
    L32:
        return;
    }
}
