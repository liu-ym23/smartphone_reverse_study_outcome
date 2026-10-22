package com.obric.aiproactive.ui.progress;

import android.app.PendingIntent;
import android.os.BadParcelableException;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\b\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\nH\u0002\u001a\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0000¨\u0006\u0012"}, d2 = {"canContinueMobileUseNavigation", "", "attemptedBinding", "Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "mobileUsePlayerRequestValues", "", "", "buildMobileUsePlayerRequest", "Landroid/os/Bundle;", "findCurrentMobileUseBinding", "pendingIntentOrNull", "Landroid/app/PendingIntent;", "readPendingIntentOrNull", "valueReader", "Lkotlin/Function0;", "", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class w {
    public static final /* synthetic */ PendingIntent a(Bundle r0) {
        return b(r0);
    }

    public static final PendingIntent a(Function0<? extends Object> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "valueReader");
        Object r5 = r4.invoke();     // Catch: BadParcelableException -> L8
        if (ZeusTransformUtils.instanceOf(r5, PendingIntent.class) == false) goto L11;
        return (PendingIntent) ZeusTransformUtils.preCheckCast(r5, PendingIntent.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    L12:
        return null;
    }

    public static final z a(com.obric.aiproactive.api.g r12) {
        if (r12 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r12.c(), "running") == false) goto L8;
    L10:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(m.a(r12), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L45;
        n r3 = (n) ZeusTransformUtils.preCheckCast(r14.next(), n.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.h(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
    L42:
        List r4 = CollectionsKt.emptyList();
    L43:
        CollectionsKt.addAll(r1, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        goto L12
    L16:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.i(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L42;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.j(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L42;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3.k(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L22:
        if (r7.hasNext() == false) goto L41;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.memorydata.plugin");
        boolean r9 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
    L32:
        r9 = false;
    L33:
        if (r9 == false) goto L35;
        a r10 = r8;
    L36:
        if (r10 == null) goto L38;
        z r11 = new z(r3.h(), r3.i(), r8.a(), r3.j());
    L39:
        if (r11 == null) goto L22;
        r6.add(r11);
        goto L22
    L38:
        r11 = null;
        goto L39
    L35:
        r10 = null;
        goto L36
    L26:
        if (r8.e() == false) goto L32;
        if (Intrinsics.areEqual(r8.f(), "open_mobile_use_player") == false) goto L32;
        if (SetsKt.setOf(new AgentRunUiState[]{AgentRunUiState.PENDING, AgentRunUiState.RUNNING, AgentRunUiState.COMPLETED}).contains(r8.d()) == false) goto L32;
    L41:
        r4 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        goto L43
    L45:
        return (z) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")), z.class, "com.obric.memorydata.plugin");
    L8:
        if (Intrinsics.areEqual(r12.c(), "waiting") == true) goto L10;
        return null;
    }

    public static final Map<String, String> a() {
        return MapsKt.mapOf(TuplesKt.to("source_from", "ai_proactive_agent_run"));
    }

    private static final void a(Function2 r2, Object r3, Object r4) {
        ((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4);
    }

    public static final boolean a(z r1, com.obric.aiproactive.api.g r2) {
        Intrinsics.checkNotNullParameter(r1, "attemptedBinding");
        return Intrinsics.areEqual(a(r2), r1);
    }

    private static final PendingIntent b(final Bundle r1) {
        return a(new $$Lambda$w$QbCxQjn3hS3pFErAPJGbXbloxKw(r1));
    }

    public static final Bundle b() {
        Bundle r0 = new Bundle();
        Map<String, String> r1 = a();
        final Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new MobileUsePlayerProviderClientKt$buildMobileUsePlayerRequest$1$1(r0), Function2.class, "com.obric.memorydata.plugin");
        r1.forEach(new $$Lambda$w$hEBXwWUhpx2_f0olDba38P_dcM(r2));
        return r0;
    }

    private static final Object c(Bundle r1) {
        return r1.getParcelable("open_player_pending_intent");
    }

    public static /* synthetic */ Object lambda$QbCxQjn3hS3pFErAPJGbXbloxKw(Bundle r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$hEBXwWUhpx2_f0olDba38P_dc-M, reason: not valid java name */
    public static /* synthetic */ void m343lambda$hEBXwWUhpx2_f0olDba38P_dcM(Function2 r0, Object r1, Object r2) {
        a(r0, r1, r2);
    }
}
