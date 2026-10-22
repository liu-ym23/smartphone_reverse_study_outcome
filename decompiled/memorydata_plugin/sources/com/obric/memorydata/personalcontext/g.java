package com.obric.memorydata.personalcontext;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u0007J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u0003J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nH\u0002J\u0012\u0010\u0017\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000RF\u0010\u0006\u001a:\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n0\t0\u0007j\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n0\t`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/DynamicIntentRegister;", "", "<init>", "()V", "TAG", "", "registeredIntentInstancesByXmlResId", "Ljava/util/LinkedHashMap;", "", "", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "registerIntentsXmlRes", "", "context", "Landroid/content/Context;", "intentsXmlResId", "parseIntentsXml", "", "instantiateIntent", "implClassName", "invokeAtomicCapabilityRegisterIntent", "intentInstance", "unregisterIntentsXmlRes", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedHashMap<Integer, List<IntentFunction<?, ?>>> f12182b = null;

    static {
        f12181a = new g();
        f12182b = new LinkedHashMap();
    }

    private g() {
    }

    private final Object a(String r2) {
        Constructor r1 = ZeusTransformUtils.forName(r2, "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]);
        r1.setAccessible(true);
        Object r3 = r1.newInstance(new Object[0]);
        Intrinsics.checkNotNullExpressionValue(r3, "newInstance(...)");
        return r3;
    }

    private final void a(IntentFunction<?, ?> r2) {
        AtomicCapabilitySdk.registerIntent((IntentFunction) ZeusTransformUtils.wrapperContextForParams(r2, IntentFunction.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.CapabilityHandleService");
    }

    private final List<String> b(Context r4, int r5) {
        XmlResourceParser r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getXml(r5);
        Intrinsics.checkNotNullExpressionValue(r3, "getXml(...)");
        ArrayList r6 = new ArrayList(16);
        int r7 = r3.getEventType();     // Catch: Throwable -> L22
    L4:
        boolean r1 = true;
        if (r7 == 1) goto L20;
        if (r7 != 2) goto L18;
        if (Intrinsics.areEqual(r3.getName(), MemorySourceLinkType.INTENT) == false) goto L18;
        String r8 = r3.getAttributeValue(null, "impl");     // Catch: Throwable -> L22
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r2 != null) goto L13;
    L16:
        if (r1 == true) goto L18;
        r6.add(r8);     // Catch: Throwable -> L22
        goto L18
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r1 = false;
    L18:
        r7 = r3.next();     // Catch: Throwable -> L22
        goto L4
    L20:
        r3.close();
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L22:
        th = move-exception;
        r3.close();
        throw th;
    }

    public final synchronized void a(int r10) {
        monitor-enter(this);
        LinkedHashMap<Integer, List<IntentFunction<?, ?>>> r0 = f12182b;     // Catch: Throwable -> L15
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.remove(Integer.valueOf(r10)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        List r2 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        if (r2 == null) goto L7;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DynamicIntentRegister", "unregisterIntentsXmlRes intentsXmlResId=" + r10 + ", registeredSize=" + r0.size(), false, 4, null);     // Catch: Throwable -> L15
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L15
    L9:
        if (r11.hasNext() == false) goto L13;
        AtomicCapabilitySdk.unregisterIntent((IntentFunction) ZeusTransformUtils.preCheckCast(r11.next(), IntentFunction.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(this);
        return;
    L7:
        r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Context r18, int r19) {
        monitor-enter(this);
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L57
        if (f12182b.containsKey(Integer.valueOf(r19)) == false) goto L62;
        monitor-exit(this);
        return;
    L62:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Object r1 = Result.m1421constructorimpl(((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin")).b(r0, r19));     // Catch: Throwable -> L10
    L12:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r1);     // Catch: Throwable -> L57
        if (r4 != null) goto L54;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Iterator r6 = r2.iterator();     // Catch: Throwable -> L57
    L16:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();     // Catch: Throwable -> L57
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        r5.add(r7);     // Catch: Throwable -> L57
        goto L16
    L20:
        LinkedHashSet r8 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(CollectionsKt.toCollection((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin")), LinkedHashSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        if (r8.isEmpty() == false) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DynamicIntentRegister", "no intent impl found in enabled switches", false, 4, null);     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L25:
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L57
        int r11 = 0;
        int r12 = 0;
    L27:
        if (r10.hasNext() == false) goto L49;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        g r14 = f12181a;     // Catch: Throwable -> L57
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L38
        Object r16 = r14.a(r13);     // Catch: Throwable -> L38
        if (ZeusTransformUtils.instanceOf(r16, IntentFunction.class) == false) goto L32;
        IntentFunction<?, ?> r17 = (IntentFunction) ZeusTransformUtils.preCheckCast(r16, IntentFunction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
    L33:
        if (r17 != null) goto L35;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DynamicIntentRegister", "intent impl not implements IntentFunction: " + r13, null, 4, null);     // Catch: Throwable -> L38
        boolean r20 = false;
    L36:
        Object r21 = Result.m1421constructorimpl(Boolean.valueOf(r20));     // Catch: Throwable -> L38
    L40:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r21);     // Catch: Throwable -> L57
        if (r110 == null) goto L45;
        RunLog.INSTANCE.error("DynamicIntentRegister", "register intent failed: " + r13, r110);     // Catch: Throwable -> L57
        r21 = false;     // Catch: Throwable -> L57
    L45:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r21, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L46;
        r12 = r12 + 1;     // Catch: Throwable -> L57
        goto L27
    L46:
        r11 = r11 + 1;     // Catch: Throwable -> L57
        goto L27
    L35:
        r14.a(r17);     // Catch: Throwable -> L38
        r9.add(r17);     // Catch: Throwable -> L38
        r20 = true;
        goto L36
    L32:
        r17 = null;
        goto L33
    L38:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L57
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L40
    L49:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        ((Map) ZeusTransformUtils.preCheckCast(f12182b, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r19), r9);     // Catch: Throwable -> L57
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DynamicIntentRegister", "dynamic register done. success=" + r11 + " fail=" + r12 + " total=" + r8.size(), false, 4, null);     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L54:
        RunLog.INSTANCE.error("DynamicIntentRegister", "parse intents xml failed, resId=" + r19, r4);     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L57
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    }
}
