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
public final class SceneInfoTaskGenerator implements e<List<? extends b<String>>, a> {
    public final Lazy a;

    public SceneInfoTaskGenerator() {
        this.a = LazyKt.lazy(SceneInfoTaskGenerator$preExecutionElementList$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wa.e
    public final void a(PredictElementType r10, String r11, List<? extends b<String>> r12) {
        List<? extends b<String>> r13 = r12;
        Intrinsics.checkNotNullParameter(r10, "elementType");
        Intrinsics.checkNotNullParameter(r11, "currentSceneId");
        Intrinsics.checkNotNullParameter(r13, "input");
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L3:
        a r1 = null;
        if (r15.hasNext() == false) goto L18;
        String r0 = (String) ((b) r15.next()).b;
        if (StringsKt.isBlank(r0) == true) goto L15;
        List r16 = StringsKt.split$default(r0, new char[]{','}, false, 0, 6, null);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L10:
        if (r18.hasNext() == false) goto L14;
        Object r19 = r18.next();
        if ((!StringsKt.isBlank((String) r19)) == false) goto L10;
        r17.add(r19);
        goto L10
    L14:
        r1 = new a(r0, CollectionsKt.distinct(r17));
    L15:
        if (r1 == null) goto L3;
        r14.add(r1);
        goto L3
    L18:
        if ((!r14.isEmpty()) == false) goto L25;
        Iterator r110 = ((List) this.a.getValue()).iterator();
    L21:
        if (r110.hasNext() == false) goto L41;
        com.bytedance.android.anniex.scene.handler.idle.b r20 = ((wa.a) r110.next()).a(r11, r14);
        if (r20 == null) goto L21;
        h.a.a(r20);
        HybridLogger.f("PredictManager", "IdleTaskQueue 执行预执行任务", null, 12);
        goto L21
    L41:
        return;
    }
}
