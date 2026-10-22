package com.bytedance.android.live.browser.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam;
import com.bytedance.android.live.browser.IHybridBaseService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements u9.b {
    public final com.bytedance.android.live.browser.w a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class H1() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.ies.stark.framework.HybridDevTool");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ies.stark.framework.HybridDevTool");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ies.stark.framework.HybridDevTool");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.ies.stark.framework.HybridDevTool");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ies.stark.framework.HybridDevTool");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ies.stark.framework.HybridDevTool");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ies.stark.framework.HybridDevTool");
    }

    public final boolean p0() {
        com.bytedance.android.live.browser.w r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEnableDevtoolDebug();
    }

    public l(com.bytedance.android.live.browser.w r1) {
        this.a = r1;
    }

    public final boolean V(String r7) {
        Intrinsics.checkNotNullParameter(r7, LiveSlardarConstants.EXTRA_KEY_URL);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = H1().getDeclaredMethod("handleSchema", new Class[]{String.class}).invoke(null, new Object[]{r7});     // Catch: Throwable -> L8
        if (r8 == null) goto L7;
        Object r9 = Result.constructor-impl(Boolean.valueOf(((Boolean) r8).booleanValue()));     // Catch: Throwable -> L8
    L10:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L14;
        r9 = r1;
    L14:
        return ((Boolean) r9).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void i1(AnnieCard r7) {
        if (r7 == null) goto L21;
        Context r0 = r7.getContext();
        String r2 = null;
        if ((r0 instanceof FragmentActivity) == true) goto L6;
        r0 = null;
    L6:
        FragmentActivity r1 = (FragmentActivity) r0;
        CardParamVoNew r3 = r7.getMHybridParamVoNew();
        if (r1 == null) goto L22;
        IHybridBaseService r4 = (IHybridBaseService) jc1.k.n(IHybridBaseService.class);
        if (r3 == null) goto L12;
        String r5 = ((HybridSchemaParam) r3).b;
        if (r5 == null) goto L12;
    L14:
        if (r7.hybridType() != IHybridComponent.HybridType.LYNX) goto L16;
        boolean r8 = true;
    L17:
        if (r3 == null) goto L19;
        r2 = r3.o();
    L19:
        r4.showHybridDebugFragment(r1, r5, r8, r2);
        return;
    L16:
        r8 = false;
    L12:
        r5 = "";
        goto L14
    L22:
        return;
    }

    public final void n0(boolean r2) {
        com.bytedance.android.live.browser.w r0 = this.a;
        if (r0 == null) goto L6;
        r0.setEnableDevtoolDebug(r2);
        return;
    }
}
