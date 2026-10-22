package com.obric.common.oea.style.scene.common;

import com.obric.common.oea.foundation.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "finished", "", "throwable", "", "invoke", "com/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer$startExitAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ int $animCount$inlined;
    final /* synthetic */ Ref.IntRef $finishedCount$inlined;
    final /* synthetic */ Ref.BooleanRef $finishedSuccess$inlined;
    final /* synthetic */ com.obric.common.oea.foundation.animation.builder.a.C0372a $it;
    final /* synthetic */ Function1 $onEnd$inlined;
    final /* synthetic */ Function2 $onSingleEnd$inlined;
    final /* synthetic */ a this$0;

    AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1(com.obric.common.oea.foundation.animation.builder.a.C0372a r3, a r4, Ref.BooleanRef r5, Ref.IntRef r6, Function2 r7, int r8, Function1 r9) {
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        this.$it = r3;
        this.this$0 = r4;
        this.$finishedSuccess$inlined = r5;
        this.$finishedCount$inlined = r6;
        this.$onSingleEnd$inlined = r10;
        this.$animCount$inlined = r8;
        this.$onEnd$inlined = r11;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(Boolean r3, Throwable r4) {
        invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r6, Throwable r7) {
        if (r6 == true) goto L4;
        this.$finishedSuccess$inlined.element = false;
    L4:
        this.$finishedCount$inlined.element++;
        this.$onSingleEnd$inlined.invoke(this.$it.a(), Boolean.valueOf(r6));
        if (this.$finishedCount$inlined.element != this.$animCount$inlined) goto L8;
        b.f7661a.b(a.a(this.this$0), "startExitAnim, anim complete, finishedSuccess? " + this.$finishedSuccess$inlined.element + ", time cost: " + (System.currentTimeMillis() - a.b(this.this$0)) + " ms");
        this.$onEnd$inlined.invoke(Boolean.valueOf(this.$finishedSuccess$inlined.element));
        a.d(this.this$0).clear();
        return;
    }
}
