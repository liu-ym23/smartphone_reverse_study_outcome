package com.obric.common.oea.style.scene.common;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbstractModeSwitchAnimComposer$playExitAnim$2 extends FunctionReferenceImpl implements Function2<View, Boolean, Unit> {
    AbstractModeSwitchAnimComposer$playExitAnim$2(a r8) {
        super(2, r8, a.class, "handleSingleExitAnimEnd", "handleSingleExitAnimEnd(Landroid/view/View;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(View r3, Boolean r4) {
        invoke((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin")).b(r3, r4);
    }
}
