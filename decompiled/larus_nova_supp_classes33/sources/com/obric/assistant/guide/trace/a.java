package com.obric.assistant.guide.trace;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void d() {
        Intrinsics.checkNotNullParameter("obric_onboarding_assistant_init_guide", "currentPage");
        FLogger.a.i("UserGuideTrace", "trackSystemPageClickEvent, currentPage: obric_onboarding_assistant_init_guide, actionType: enable_set_default_option");
        BuildersKt.launch$default(a, null, null, new UserGuideTrace$trackSystemPageClickEvent$1("obric_onboarding_assistant_init_guide", "enable_set_default_option", null), 3, null);
    }

    public static void c(String r10) {
        Intrinsics.checkNotNullParameter("obric_onboarding_assistant_init_guide", "currentPage");
        FLogger.a.i("UserGuideTrace", "trackSystemEnterPageEvent, currentPage: obric_onboarding_assistant_init_guide, previousPage: " + r10);
        BuildersKt.launch$default(a, null, null, new UserGuideTrace$trackSystemEnterPageEvent$1("obric_onboarding_assistant_init_guide", r10, null), 3, null);
    }

    public static void a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "currentPage");
        FLogger.a.i("UserGuideTrace", "trackEnterPage, currentPage: " + r11 + ", previousPage: " + r12 + ", enterFrom: null, extraParams: null");
        BuildersKt.launch$default(a, null, null, new UserGuideTrace$trackEnterPage$1(r11, r12, null, null, null), 3, null);
    }

    public static void b(String r10, String r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "currentPage");
        FLogger.a.i("UserGuideTrace", "trackPageClick, currentPage: " + r10 + ", actionType: " + r11 + ", enterFrom: null, extraParams: " + r12);
        BuildersKt.launch$default(a, null, null, new UserGuideTrace$trackPageClick$1(r10, r11, null, r12, null), 3, null);
    }
}
