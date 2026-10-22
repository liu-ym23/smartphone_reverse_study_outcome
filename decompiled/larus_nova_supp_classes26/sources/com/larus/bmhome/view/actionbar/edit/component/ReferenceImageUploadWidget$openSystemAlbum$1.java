package com.larus.bmhome.view.actionbar.edit.component;

import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.e4;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$openSystemAlbum$1", f = "ReferenceImageUploadWidget.kt", i = {0}, l = {387}, m = "invokeSuspend", n = {"activity"}, s = {"L$0"})
public final class ReferenceImageUploadWidget$openSystemAlbum$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isImeShow;
    Object L$0;
    int label;
    final /* synthetic */ ReferenceImageUploadWidget this$0;

    public ReferenceImageUploadWidget$openSystemAlbum$1(ReferenceImageUploadWidget r1, boolean r2, Continuation<? super ReferenceImageUploadWidget$openSystemAlbum$1> r3) {
        this.this$0 = r1;
        this.$isImeShow = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ReferenceImageUploadWidget$openSystemAlbum$1(this.this$0, this.$isImeShow, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.view.actionbar.edit.component.h2] */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        FragmentActivity r2 = (FragmentActivity) this.L$0;
        ResultKt.throwOnFailure(r9);
    L23:
        final FragmentActivity r3 = r2;
    L25:
        final ReferenceImageUploadWidget r10 = this.this$0;
        final ?? r4 = new h2(r3, r10);
        int r5 = ReferenceImageUploadWidget.k;
        r10.getClass();
        com.larus.platform.service.k2 r11 = com.larus.platform.service.k2.a;
        com.larus.platform.api.g3.a.a(null, r3, false, null, false, new d2(r4), 29);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ReferenceImageUploadWidget r12 = this.this$0;
        int r6 = ReferenceImageUploadWidget.k;
        Fragment r13 = r12.getFragment();
        if (r13 == null) goto L11;
        FragmentActivity r14 = r13.requireActivity();
    L13:
        if ((r14 instanceof e4) == true) goto L15;
    L24:
        r3 = r14;
        goto L25
    L15:
        if (this.$isImeShow == false) goto L24;
        Window r7 = r14.getWindow();
        if (r7 == null) goto L19;
        new WindowInsetsControllerCompat(r7, this.this$0).hide(WindowInsetsCompat.Type.ime());
    L19:
        this.L$0 = r14;
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L22;
        return r0;
    L22:
        r2 = r14;
        goto L23
    L11:
        r14 = null;
        goto L13
    }
}
