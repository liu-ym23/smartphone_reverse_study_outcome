package com.obric.assistant.interaction.impl.window.landscape.restriction;

import com.larus.business.multitask_management.api.IMultiTaskService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import jea.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeTaskbarExpandedAllowHelper;", "", "<init>", "()V", "TAG", "", "taskbarExpandedResolver", "Lkotlin/Function0;", "", "getTaskbarExpandedResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setTaskbarExpandedResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "isTaskbarExpanded", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeTaskbarExpandedAllowHelper {
    public static final LandscapeTaskbarExpandedAllowHelper INSTANCE = null;
    private static final String TAG = "LandscapeTaskbarExpandedAllowHelper";
    private static Function0<Boolean> taskbarExpandedResolver;

    private LandscapeTaskbarExpandedAllowHelper() {
    }

    public static /* synthetic */ boolean a() {
        return taskbarExpandedResolver$lambda$0();
    }

    static {
        INSTANCE = new LandscapeTaskbarExpandedAllowHelper();
        taskbarExpandedResolver = new h();
    }

    @JvmStatic
    public static final boolean isTaskbarExpanded() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(((Boolean) taskbarExpandedResolver.invoke()).booleanValue()));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L9;
        FLogger.a.w(TAG, "resolve taskbar expanded failed", r2);
    L9:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = r3;
    L13:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private static final boolean taskbarExpandedResolver$lambda$0() {
        IMultiTaskService r0 = (IMultiTaskService) ServiceManager.get().getService(IMultiTaskService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.n() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final Function0<Boolean> getTaskbarExpandedResolver$impl_mainlandRelease() {
        return taskbarExpandedResolver;
    }

    public final void setTaskbarExpandedResolver$impl_mainlandRelease(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        taskbarExpandedResolver = r2;
    }
}
