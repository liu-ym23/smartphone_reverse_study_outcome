package com.obric.oui.texteffects.core;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a]\u0010\u0000\u001a\u00020\u0001*\u00020\u00022K\u0010\u0003\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\bø\u0001\u0000\u001az\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102`\u0010\u0011\u001a\\\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e0\u0012H\u0080\bø\u0001\u0000\u001aP\u0010\u0014\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e0\u0015H\u0080\bø\u0001\u0000\u001a3\u0010\u0016\u001a\u00020\u000e*\u00020\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0017H\u0080\bø\u0001\u0000\u001a3\u0010\u0018\u001a\u00020\u000e*\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0017H\u0080\bø\u0001\u0000\u001aH\u0010\u0018\u001a\u00020\u000e*\u00020\u000526\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0015H\u0080\bø\u0001\u0000\u001a]\u0010\u0018\u001a\u00020\u000e*\u00020\u00022K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0004H\u0080\bø\u0001\u0000\u001a3\u0010\u0019\u001a\u00020\u000e*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u0017H\u0080\bø\u0001\u0000\u001a3\u0010\u001a\u001a\u00020\u000e*\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0017H\u0080\bø\u0001\u0000\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0000\u001a\f\u0010\u001e\u001a\u00020\u001d*\u00020\u0002H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"anyLayer", "", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "predicate", "Lkotlin/Function3;", "Lcom/obric/oui/texteffects/core/EffectStage;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "stage", "Lcom/obric/oui/texteffects/core/EffectLayerGroupSpec;", "group", "Lcom/obric/oui/texteffects/core/EffectLayer;", "layer", "forEachActiveLayer", "", "normalizedPlayTimeMs", "", "action", "Lkotlin/Function4;", "stagePlayTimeMs", "forEachActiveStage", "Lkotlin/Function2;", "forEachGroup", "Lkotlin/Function1;", "forEachLayer", "forEachStage", "forEachTextLayer", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "layerCount", "", "maxStageLayerCount", "OUITextEffects_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class v {
    public static final int a(l r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<k> r5 = r4.e().iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + ((k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.memorydata.plugin")).b().size();
        goto L4
    L6:
        return r0;
    }

    public static final int a(u r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r5.hasNext() == true) goto L5;
        Comparable r6 = null;
    L12:
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        return 0;
    L16:
        return r7.intValue();
    L5:
        Comparable r0 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(a((l) ZeusTransformUtils.preCheckCast(r5.next(), l.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin");
    L7:
        if (r5.hasNext() == false) goto L11;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(a((l) ZeusTransformUtils.preCheckCast(r5.next(), l.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compareTo(r2) >= 0) goto L7;
        r0 = r2;
        goto L7
    L11:
        r6 = r0;
        goto L12
    }
}
