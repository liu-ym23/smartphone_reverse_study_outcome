package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class EnterTransitionLancet {
    public EnterTransitionLancet() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public void onStop() {
        Origin.callVoid();
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(EnterTransitionCrashOptimizer.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L11;
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(This.get(), Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L12;
        ZeusTransformUtils.getWindow(r3, "com.obric.memorydata.plugin").getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L12:
        return;
    }
}
