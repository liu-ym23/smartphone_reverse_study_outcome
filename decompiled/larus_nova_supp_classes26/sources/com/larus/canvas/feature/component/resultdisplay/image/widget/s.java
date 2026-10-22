package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.view.ViewStub;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    public static final /* synthetic */ int f = 0;
    public final CoroutineScope a;
    public final Function0<CanvasProgressState> b;
    public final Lazy c;
    public Job d;
    public String e;

    public static final class a {
    }

    static {
    }

    public s(final ViewStub r2, CoroutineScope r3, Function0<CanvasProgressState> r4) {
        Intrinsics.checkNotNullParameter(r2, "sketchProgressLoadingViewStub");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "canvasProgressStateGetter");
        this.a = r3;
        this.b = r4;
        this.c = LazyKt.lazy(new r(r2));
    }

    public final void a(boolean r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "description");
        if (r9 == false) goto L10;
        ISketchLoadingController.a.b((ISketchLoadingController) this.c.getValue(), false, null, 0, 7);
        if (Intrinsics.areEqual(this.e, r10) == true) goto L15;
        this.e = r10;
        ISketchLoadingController.a.a((ISketchLoadingController) this.c.getValue(), r11, i5.m(), 4);
        Job r12 = this.d;
        if (r12 == null) goto L9;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L9:
        this.d = BuildersKt.launch$default(this.a, null, null, new LoadingProgressController$observeProgress$1(this, r10, null), 3, null);
        return;
    L15:
        return;
    L10:
        ((ISketchLoadingController) this.c.getValue()).hide();
        Job r13 = this.d;
        if (r13 == null) goto L13;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L13:
        this.d = null;
    }
}
