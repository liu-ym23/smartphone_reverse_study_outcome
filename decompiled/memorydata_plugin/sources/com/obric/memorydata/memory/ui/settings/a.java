package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\f\u001a>\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0013\u0012\u0004\u0012\u00020\u000e0\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"AI_PROACTIVE_ENABLED_STATUS", "", "AI_PROACTIVE_DISABLED_STATUS", "shouldShowAiProactiveEntry", "", "status", "(Ljava/lang/Integer;)Z", "buildAiProactiveEntryUiState", "Lcom/obric/memorydata/memory/ui/settings/AiProactiveEntryUiState;", "shortcutExists", "currentEntryVisible", "currentPinVisible", "(Ljava/lang/Integer;ZZZ)Lcom/obric/memorydata/memory/ui/settings/AiProactiveEntryUiState;", "handleAiProactiveEntryClick", "", "hasAgreePrivacyAndLogin", "startProactive", "Lkotlin/Function0;", "requestAgreePrivacyAndLogin", "Lkotlin/Function1;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final b a(Integer r3, boolean r4, boolean r5, boolean r6) {
        if (r3 != null) goto L6;
    L8:
        if (r3 == null) goto L14;
        if (r3.intValue() != 0) goto L14;
        return new b(false, false, r4);
    L14:
        return new b(r5, r6, false);
    L6:
        if (r3.intValue() != 1) goto L8;
        return new b(true, true, false);
    }

    private static final Unit a(Function0 r2, boolean r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L6;
        r4.invoke();
    L6:
        return Unit.INSTANCE;
    }

    public static final void a(boolean r2, Function0<Unit> r3, Function1<? super Function1<? super Boolean, Unit>, Unit> r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "startProactive");
        Intrinsics.checkNotNullParameter(r6, "requestAgreePrivacyAndLogin");
        if (r2 == false) goto L6;
        r5.invoke();
        return;
    L6:
        r6.invoke(new $$Lambda$a$hsvq037YQxpTuhHBebOUd3HAPwA(r5));
    }

    public static /* synthetic */ Unit lambda$hsvq037YQxpTuhHBebOUd3HAPwA(Function0 r0, boolean r1) {
        return a(r0, r1);
    }
}
