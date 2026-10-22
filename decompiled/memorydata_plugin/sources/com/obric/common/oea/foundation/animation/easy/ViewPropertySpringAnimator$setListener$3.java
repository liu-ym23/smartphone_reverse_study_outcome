package com.obric.common.oea.foundation.animation.easy;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewPropertySpringAnimator$setListener$3<T> extends Lambda implements Function1<b<T>, Unit> {
    public static final ViewPropertySpringAnimator$setListener$3 INSTANCE = null;

    static {
        INSTANCE = new ViewPropertySpringAnimator$setListener$3();
    }

    ViewPropertySpringAnimator$setListener$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Object r3) {
        invoke((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(b<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
    }
}
