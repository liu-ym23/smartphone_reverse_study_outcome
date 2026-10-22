package com.obric.common.oea.style.scene.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "finished", "", "throwable", "", "invoke", "com/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer$startExitAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ int $animCount$inlined;
    final /* synthetic */ Ref.IntRef $finishedCount$inlined;
    final /* synthetic */ Ref.BooleanRef $finishedSuccess$inlined;
    final /* synthetic */ com.obric.common.oea.foundation.animation.builder.a $it;
    final /* synthetic */ Function1 $onEnd$inlined;
    final /* synthetic */ Function2 $onSingleEnd$inlined;
    final /* synthetic */ a this$0;

    public AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1(com.obric.common.oea.foundation.animation.builder.a r5, a r10, Ref.BooleanRef r11, Ref.IntRef r12, Function2 r13, int r14, Function1 r15) {
        this.$it = r5;
        this.$finishedSuccess$inlined = r11;
        this.$finishedCount$inlined = r12;
        this.$onSingleEnd$inlined = r13;
        this.$animCount$inlined = r14;
        this.$onEnd$inlined = r15;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo2invoke(Boolean r5, Throwable r10) {
        invoke(r5.booleanValue(), r10);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r5, Throwable r10) {
        if (r5 == true) goto L4;
        this.$finishedSuccess$inlined.element = false;
    L4:
        this.$finishedCount$inlined.element++;
        this.$onSingleEnd$inlined.mo2invoke(this.$it.f, Boolean.valueOf(r5));
        if (this.$finishedCount$inlined.element == this.$animCount$inlined) goto L8;
        return;
    L8:
        throw null;
    }
}
