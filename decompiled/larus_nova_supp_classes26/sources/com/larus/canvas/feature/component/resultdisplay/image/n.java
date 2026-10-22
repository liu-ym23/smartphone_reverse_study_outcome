package com.larus.canvas.feature.component.resultdisplay.image;

import com.larus.bmhome.view.ChatConstraintLayout$b;
import com.larus.utils.e1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements ChatConstraintLayout$b {
    public final /* synthetic */ CreationImagePagerComponent a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // com.larus.bmhome.view.ChatConstraintLayout$b
    public final void a() {
        CreationImagePagerComponent r0 = this.a;
        int r1 = CreationImagePagerComponent.B;
        boolean r2 = e1.s(r0.F2());
        this.a.m3(r2);
        ((com.larus.canvas.feature.component.resultdisplay.image.widget.q) this.a.w.getValue()).b(r2, true);
        this.a.t.setValue(Boolean.valueOf(r2));
    }

    @Override // com.larus.bmhome.view.ChatConstraintLayout$b
    public final void b() {
        CreationImagePagerComponent r0 = this.a;
        int r1 = CreationImagePagerComponent.B;
        boolean r2 = e1.s(r0.F2());
        this.a.m3(r2);
        ((com.larus.canvas.feature.component.resultdisplay.image.widget.q) this.a.w.getValue()).b(r2, false);
        this.a.t.setValue(Boolean.valueOf(r2));
        if (r2 == false) goto L16;
        int r3 = this.b.element;
        if (r3 > 300) goto L7;
        return;
    L7:
        if (r3 >= CreationImagePagerComponent.D) goto L18;
        CreationImagePagerComponent.D = r3;
        x r4 = x.a;
        int r5 = CreationImagePagerComponent.D;
        r4.getClass();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        x.b.storeInt("ime_max_height", r5);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L18:
        return;
    }

    @Override // com.larus.bmhome.view.ChatConstraintLayout$b
    public final void onUpdate(int r2) {
        int r0 = CreationImagePagerComponent.B;
        CreationImagePagerComponent.D = RangesKt.coerceAtLeast(CreationImagePagerComponent.D, r2);
        this.b.element = r2;
    }

    public n(CreationImagePagerComponent r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
