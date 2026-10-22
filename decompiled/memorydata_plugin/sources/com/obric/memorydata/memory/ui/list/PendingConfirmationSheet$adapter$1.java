package com.obric.memorydata.memory.ui.list;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class PendingConfirmationSheet$adapter$1 extends FunctionReferenceImpl implements Function1<Rect, Boolean> {
    PendingConfirmationSheet$adapter$1(Object r8) {
        super(1, r8, ap.class, "clipVisibleBounds", "clipVisibleBounds(Landroid/graphics/Rect;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return Boolean.valueOf(ap.a((ap) ZeusTransformUtils.preCheckCast(this.receiver, ap.class, "com.obric.memorydata.plugin"), r3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(Rect r3) {
        return invoke2((Rect) ZeusTransformUtils.preCheckCast(r3, Rect.class, "com.obric.memorydata.plugin"));
    }
}
