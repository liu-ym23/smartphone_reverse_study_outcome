package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\b\u0012\u0004\u0012\u00020\u00050\bH\u0000¨\u0006\t"}, d2 = {"handleProactiveLoginGate", "", "hasAgreePrivacyAndLogin", "closeProactiveTask", "Lkotlin/Function0;", "", "restartAfterLogin", "requestAgreePrivacyAndLogin", "Lkotlin/Function1;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class v {
    private static final Unit a(Function0 r2, boolean r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L6;
        r4.invoke();
    L6:
        return Unit.INSTANCE;
    }

    public static final boolean a(boolean r2, Function0<Unit> r3, Function0<Unit> r4, Function1<? super Function1<? super Boolean, Unit>, Unit> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "closeProactiveTask");
        Intrinsics.checkNotNullParameter(r7, "restartAfterLogin");
        Intrinsics.checkNotNullParameter(r8, "requestAgreePrivacyAndLogin");
        if (r2 == false) goto L6;
        return true;
    L6:
        r8.invoke(new $$Lambda$v$w2KO6nrgZprF5mTCBq8z1WDGNM(r7));
        r6.invoke();
        return false;
    }

    /* JADX INFO: renamed from: lambda$w2KO6nrgZprF5mTCBq-8z1WDGNM, reason: not valid java name */
    public static /* synthetic */ Unit m293lambda$w2KO6nrgZprF5mTCBq8z1WDGNM(Function0 r0, boolean r1) {
        return a(r0, r1);
    }
}
