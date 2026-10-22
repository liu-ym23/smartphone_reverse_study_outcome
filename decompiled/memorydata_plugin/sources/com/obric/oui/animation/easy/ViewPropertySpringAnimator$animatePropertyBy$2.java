package com.obric.oui.animation.easy;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcom/obric/oui/animation/easy/SpringAnimationConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ViewPropertySpringAnimator$animatePropertyBy$2 extends Lambda implements Function1<a, Unit> {
    public static final ViewPropertySpringAnimator$animatePropertyBy$2 INSTANCE = null;

    static {
        INSTANCE = new ViewPropertySpringAnimator$animatePropertyBy$2();
    }

    ViewPropertySpringAnimator$animatePropertyBy$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(a r3) {
        invoke2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$null");
    }
}
