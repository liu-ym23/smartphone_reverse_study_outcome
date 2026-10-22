package com.obric.common.oea.style.scene.common;

import com.obric.common.oea.foundation.animation.builder.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "finished", "", "throwable", "", "invoke", "com/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer$startExitAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ int $animCount$inlined;
    final /* synthetic */ Ref.IntRef $finishedCount$inlined;
    final /* synthetic */ Ref.BooleanRef $finishedSuccess$inlined;
    final /* synthetic */ b.a $it;
    final /* synthetic */ Function1 $onEnd$inlined;
    final /* synthetic */ Function2 $onSingleEnd$inlined;
    final /* synthetic */ a this$0;

    public AbstractModeSwitchAnimComposer$startExitAnim$$inlined$forEach$lambda$1(b.a r1, a r2, Ref.BooleanRef r3, Ref.IntRef r4, Function2 r5, int r6, Function1 r7) {
        this.$it = r1;
        this.this$0 = r2;
        this.$finishedSuccess$inlined = r3;
        this.$finishedCount$inlined = r4;
        this.$onSingleEnd$inlined = r5;
        this.$animCount$inlined = r6;
        this.$onEnd$inlined = r7;
        super(2);
    }

    public final void invoke(boolean r5, Throwable r6) {
        if (r5 == true) goto L4;
        this.$finishedSuccess$inlined.element = false;
    L4:
        this.$finishedCount$inlined.element++;
        this.$onSingleEnd$inlined.invoke(this.$it.f, Boolean.valueOf(r5));
        if (this.$finishedCount$inlined.element != this.$animCount$inlined) goto L8;
        mja.a.C0063a r7 = mja.a.a;
        String r8 = this.this$0.a;
        StringBuilder r9 = new StringBuilder("startExitAnim, anim complete, finishedSuccess? ");
        r9.append(this.$finishedSuccess$inlined.element);
        r9.append(", time cost: ");
        long r0 = System.currentTimeMillis();
        this.this$0.getClass();
        r9.append(r0 - 0);
        r9.append(" ms");
        mja.a.a(r8, r9.toString());
        this.$onEnd$inlined.invoke(Boolean.valueOf(this.$finishedSuccess$inlined.element));
        ((ArrayList) this.this$0.c).clear();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Boolean) r1).booleanValue(), (Throwable) r2);
        return Unit.INSTANCE;
    }
}
