package com.larus.setting.impl;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.impl.databinding.LarusBottomSheetDataPermissonBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.DataPermissionBottomSheet$initFaceMemorySwitch$1$1$1", f = "DataPermissionBottomSheet.kt", i = {}, l = {557}, m = "invokeSuspend", n = {}, s = {})
final class DataPermissionBottomSheet$initFaceMemorySwitch$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusBottomSheetDataPermissonBinding $this_apply;
    int label;
    final /* synthetic */ DataPermissionBottomSheet this$0;

    public DataPermissionBottomSheet$initFaceMemorySwitch$1$1$1(DataPermissionBottomSheet r1, LarusBottomSheetDataPermissonBinding r2, Continuation<? super DataPermissionBottomSheet$initFaceMemorySwitch$1$1$1> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DataPermissionBottomSheet$initFaceMemorySwitch$1$1$1(this.this$0, this.$this_apply, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((Boolean) r4).booleanValue() == false) goto L14;
        by7.a r5 = new by7.a("setting_face_memory_switch");
        r5.d("switch_to", "on");
        r5.b();
    L16:
        return Unit.INSTANCE;
    L14:
        this.$this_apply.f.getToggleView().setChecked(false);
        t19.s r6 = t19.s.a;
        FragmentActivity r2 = this.this$0.requireActivity();
        r6.getClass();
        t19.s.b(r2, 2131905612, false);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DataPermissionBottomSheet r7 = this.this$0;
        int r3 = DataPermissionBottomSheet.m;
        SettingModel r8 = r7.T90();
        this.label = 1;
        r4 = r8.setFaceMemoryEnabled(true, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
