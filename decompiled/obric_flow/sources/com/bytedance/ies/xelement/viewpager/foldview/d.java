package com.bytedance.ies.xelement.viewpager.foldview;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f6562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Callback f6563c;
    public final /* synthetic */ UISimpleView d;

    public /* synthetic */ d(UISimpleView r5, double r10, Callback r11, int r12) {
        this.f6561a = r12;
        this.d = r5;
        this.f6562b = r10;
        this.f6563c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Callback r5 = this.f6563c;
        UISimpleView r10 = this.d;
        double r11 = this.f6562b;
        switch(this.f6561a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        float r12 = (float) r11;
        float[] r13 = ((UIScrollView) r10).scrollBy(r12, r12);
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.putDouble("consumedX", (int) (r13[0] / DisplayMetricsHolder.a().density));
        r14.putDouble("consumedY", (int) (r13[1] / DisplayMetricsHolder.a().density));
        r14.putDouble("unconsumedX", (int) (r13[2] / DisplayMetricsHolder.a().density));
        r14.putDouble("unconsumedY", (int) (r13[3] / DisplayMetricsHolder.a().density));
        r5.invoke(new Object[]{0, r14});
        return;
    L6:
        float r15 = (float) r11;
        float[] r16 = ((UIListContainer) r10).scrollBy(r15, r15);
        JavaOnlyMap r17 = new JavaOnlyMap();
        r17.putDouble("consumedX", (int) (r16[0] / DisplayMetricsHolder.a().density));
        r17.putDouble("consumedY", (int) (r16[1] / DisplayMetricsHolder.a().density));
        r17.putDouble("unconsumedX", (int) (r16[2] / DisplayMetricsHolder.a().density));
        r17.putDouble("unconsumedY", (int) (r16[3] / DisplayMetricsHolder.a().density));
        r5.invoke(new Object[]{0, r17});
        return;
    L8:
        float r18 = (float) r11;
        float[] r19 = ((UIList) r10).scrollBy(r18, r18);
        JavaOnlyMap r20 = new JavaOnlyMap();
        r20.putDouble("consumedX", (int) (r19[0] / DisplayMetricsHolder.a().density));
        r20.putDouble("consumedY", (int) (r19[1] / DisplayMetricsHolder.a().density));
        r20.putDouble("unconsumedX", (int) (r19[2] / DisplayMetricsHolder.a().density));
        r20.putDouble("unconsumedY", (int) (r19[3] / DisplayMetricsHolder.a().density));
        r5.invoke(new Object[]{0, r20});
        return;
    L10:
        int r110 = LynxFoldViewNG.f6556h;
        LynxFoldViewNG r21 = (LynxFoldViewNG) r10;
        Intrinsics.checkNotNullParameter(r21, "this$0");
        float r111 = (float) r11;
        float[] r112 = r21.scrollBy(r111, r111);
        JavaOnlyMap r22 = new JavaOnlyMap();
        r22.putDouble("consumedX", (int) (r112[0] / DisplayMetricsHolder.a().density));
        r22.putDouble("consumedY", (int) (r112[1] / DisplayMetricsHolder.a().density));
        r22.putDouble("unconsumedX", (int) (r112[2] / DisplayMetricsHolder.a().density));
        r22.putDouble("unconsumedY", (int) (r112[3] / DisplayMetricsHolder.a().density));
        r5.invoke(new Object[]{0, r22});
    }
}
