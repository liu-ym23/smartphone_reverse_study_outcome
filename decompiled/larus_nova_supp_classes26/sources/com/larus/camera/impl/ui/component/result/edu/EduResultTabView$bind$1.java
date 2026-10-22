package com.larus.camera.impl.ui.component.result.edu;

import com.google.android.material.tabs.TabLayout;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/camera/impl/entity/EduResultTabState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduResultTabView$bind$1", f = "EduResultTabView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EduResultTabView$bind$1 extends SuspendLambda implements Function2<px8.b, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EduResultTabView this$0;

    public EduResultTabView$bind$1(EduResultTabView r1, CameraResultViewModel r2, Continuation<? super EduResultTabView$bind$1> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        EduResultTabView$bind$1 r0 = new EduResultTabView$bind$1(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((px8.b) r1, (Continuation) r2);
    }

    public final Object invoke(px8.b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.HorizontalScrollView, com.google.android.material.tabs.TabLayout, com.larus.camera.impl.ui.component.result.edu.EduResultTabView] */
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r12);
        px8.b r13 = (px8.b) this.L$0;
        ?? r0 = this.this$0;
        CameraResultViewModel r7 = this.$viewModel;
        r0.a = r13;
        if (r13.c == true) goto L7;
    L34:
        r0.setVisibility(8);
    L36:
        return Unit.INSTANCE;
    L7:
        if (r13.a.size() <= 1) goto L34;
        r0.setVisibility(0);
        if (Intrinsics.areEqual(r0.b, r13.a) == true) goto L26;
        f r1 = r0.c;
        if (r1 == null) goto L14;
        r0.removeOnTabSelectedListener(r1);
    L14:
        r0.removeAllTabs();
        List<EduResultMode> r10 = r13.a;
        r0.b = r10;
        if (r0.d == true) goto L17;
        r0.d = true;
        CameraResultViewModel.showCameraItemForEduMode$default(r7, "tab_navigation", null, null, 6, null);
    L17:
        Iterator<T> r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L25;
        EduResultMode r2 = (EduResultMode) r11.next();
        TabLayout.Tab r3 = r0.newTab();
        r3.setText(r0.getContext().getText(r2.getTextResId()));
        r3.setTag(r2);
        r0.addTab(r3);
        String r4 = EduResultTabView.b(r2);
        if (r2 != r13.d) goto L23;
        boolean r5 = true;
    L24:
        CameraResultViewModel.showCameraItemForEduMode$default(r7, r4, null, Boolean.valueOf(r5), 2, null);
        goto L19
    L23:
        r5 = false;
        goto L24
    L25:
        f r6 = new f(r7, r0);
        r0.c = r6;
        r0.addOnTabSelectedListener(r6);
    L26:
        int r14 = r13.a.indexOf(r13.b);
        if (r14 < 0) goto L36;
        if (r0.getSelectedTabPosition() == r14) goto L36;
        r0.e = true;
        TabLayout.Tab r15 = r0.getTabAt(r14);
        if (r15 == null) goto L33;
        r15.select();
    L33:
        r0.e = false;
        goto L36
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
