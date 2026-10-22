package com.larus.common_ui.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"com/larus/common_ui/utils/ViewExtKt$setImeAnimationCallback$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "bounds", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onEnd", "", "isIMEShow", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt$setImeAnimationCallback$1 extends WindowInsetsAnimationCompat.Callback {
    public final /* synthetic */ Function1<Boolean, Unit> a;
    public final /* synthetic */ Function1<Boolean, Unit> b;
    public final /* synthetic */ Function1<Boolean, Unit> c;
    public final /* synthetic */ View d;

    public final boolean b() {
        Context r0 = this.d.getContext();
    L3:
        boolean r1 = r0 instanceof Activity;
        if (r1 == true) goto L9;
        if ((r0 instanceof ContextWrapper) == false) goto L9;
        FLogger.a.i("setImeAnimationCallback", "context is not Activity, find baseContext");
        r0 = ((ContextWrapper) r0).getBaseContext();
    L9:
        if (r1 == false) goto L20;
        Window r2 = ((Activity) r0).getWindow();
        if (r2 == null) goto L24;
        View r3 = r2.getDecorView();
        if (c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L17;
        c.a(r4, "getDecorView");
    L17:
        if (r3 != null) goto L19;
        return false;
    L19:
        return ViewExtKt.h(r3);
    L24:
        return false;
    L20:
        FLogger.a.e("setImeAnimationCallback", "activity not found");
        return false;
    }

    public final void onEnd(WindowInsetsAnimationCompat r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        boolean r5 = b();
        FLogger.a.i("setImeAnimationCallback", "onEnd, isIMEShow:" + r5);
        Function1<Boolean, Unit> r0 = this.c;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r5));
        return;
    }

    public final WindowInsetsCompat onProgress(WindowInsetsCompat r4, List<WindowInsetsAnimationCompat> r5) {
        Intrinsics.checkNotNullParameter(r4, "insets");
        Intrinsics.checkNotNullParameter(r5, "runningAnimations");
        boolean r6 = b();
        FLogger.a.i("setImeAnimationCallback", "onProgress, isIMEShow:" + r6);
        Function1<Boolean, Unit> r0 = this.b;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.valueOf(r6));
    L5:
        return r4;
    }

    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r4, WindowInsetsAnimationCompat.BoundsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        Intrinsics.checkNotNullParameter(r5, "bounds");
        boolean r6 = b();
        FLogger.a.i("setImeAnimationCallback", "onStart, isIMEShow:" + r6);
        Function1<Boolean, Unit> r0 = this.a;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.valueOf(r6));
    L5:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewExtKt$setImeAnimationCallback$1(Function1<? super Boolean, Unit> r1, Function1<? super Boolean, Unit> r2, Function1<? super Boolean, Unit> r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        super(1);
    }
}
