package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Rect;
import com.lynx.tasm.LynxView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "v", "Lcom/lynx/tasm/LynxView;", "bound", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class BlankViewDetector$detect$1$1 extends Lambda implements Function2<LynxView, Rect, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rect f3658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f3659b;

    public BlankViewDetector$detect$1$1(Rect r5, g r10) {
        Lazy r11 = e.f3670a;
        this.f3658a = r5;
        this.f3659b = r10;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Unit mo2invoke(LynxView r12, Rect r13) {
        LynxView r14 = r12;
        Rect r15 = r13;
        Intrinsics.checkNotNullParameter(r14, "v");
        Intrinsics.checkNotNullParameter(r15, "bound");
        int r5 = r15.left;
        Rect r10 = this.f3658a;
        int r11 = r5 - r10.left;
        int r16 = r15.top - r10.top;
        Lazy r17 = e.f3670a;
        e.d(this.f3659b, r14.getLynxUIRoot(), 0, 0, r11, r16, r14.getWidth() + r11, r14.getHeight() + r16);
        return Unit.INSTANCE;
    }
}
