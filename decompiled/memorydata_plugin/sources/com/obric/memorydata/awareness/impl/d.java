package com.obric.memorydata.awareness.impl;

import com.obric.memorydata.awareness.impl.data.AwarenessEventTriggerConfig;
import com.obric.memorydata.awareness.impl.data.PapayaConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\n¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessEventSubscriptionResolver;", "", "<init>", "()V", "resolve", "", "Lcom/obric/memorydata/awareness/impl/AwarenessEventSubscription;", "config", "Lcom/obric/memorydata/awareness/impl/data/PapayaConfig;", "isFeature", "Lkotlin/Function1;", "", "", "isEnabled", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8663a = null;

    static {
        f8663a = new d();
    }

    private d() {
    }

    public final Set<c> a(PapayaConfig r10, Function1<? super String, Boolean> r11, Function1<? super c, Boolean> r12) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "isFeature");
        Intrinsics.checkNotNullParameter(r13, "isEnabled");
        if (r10 == null) goto L5;
        List<AwarenessEventTriggerConfig> r14 = r10.getAwarenessEventTriggers();
        if (r14 != null) goto L9;
        r14 = CollectionsKt.emptyList();
    L9:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L10:
        boolean r3 = true;
        c r5 = null;
        if (r16.hasNext() == false) goto L22;
        AwarenessEventTriggerConfig r2 = (AwarenessEventTriggerConfig) ZeusTransformUtils.preCheckCast(r16.next(), AwarenessEventTriggerConfig.class, "com.obric.memorydata.plugin");
        AwarenessEventTriggerType r6 = AwarenessEventTriggerType.Companion.a(r2.getType());
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2.getName(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r6 != null) goto L15;
    L20:
        if (r5 == null) goto L10;
        r1.add(r5);
        goto L10
    L15:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L18;
        r3 = false;
    L18:
        if (r3 == false) goto L20;
        r5 = new c(r6, r4);
        goto L20
    L22:
        Set r17 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        List<String> r18 = r10.getTriggerEvents();
        if (r18 != null) goto L25;
        r18 = CollectionsKt.emptyList();
    L25:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
    L27:
        if (r110.hasNext() == false) goto L44;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == true) goto L35;
        r8 = null;
    L35:
        if (r8 != null) goto L38;
        c r21 = null;
    L42:
        if (r21 == null) goto L27;
        r7.add(r21);
        goto L27
    L38:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(r8), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L40;
        AwarenessEventTriggerType r22 = AwarenessEventTriggerType.FEATURE_CHANGED;
    L41:
        r21 = new c(r22, r8);
        goto L42
    L40:
        r22 = AwarenessEventTriggerType.CONTEXT_EVENT;
        goto L41
    L31:
        r20 = false;
        goto L32
    L44:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        Set r111 = SetsKt.createSetBuilder();
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L46:
        if (r26.hasNext() == false) goto L50;
        Object r27 = r26.next();
        if (r17.contains((c) ZeusTransformUtils.preCheckCast(r27, c.class, "com.obric.memorydata.plugin")) == true) goto L46;
        r25.add(r27);
        goto L46
    L50:
        r111.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r28.iterator();
    L52:
        if (r29.hasNext() == false) goto L56;
        Object r30 = r29.next();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13.invoke(r30), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L52;
        r112.add(r30);
        goto L52
    L56:
        r111.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return SetsKt.build(r111);
    L5:
        return SetsKt.emptySet();
    }
}
