package com.larus.sheet.operation.share.view;

import android.content.Context;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.sheet.biz.impl.databinding.LarusPageSheetPermissionSettingsBinding;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.sheet.operation.share.view.SheetPermissionSettingFragment$updatePermissionPublic$1$2$1", f = "SheetPermissionSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SheetPermissionSettingFragment$updatePermissionPublic$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $it;
    int label;
    final /* synthetic */ SheetPermissionSettingFragment this$0;

    public SheetPermissionSettingFragment$updatePermissionPublic$1$2$1(SheetPermissionSettingFragment r1, boolean r2, Continuation<? super SheetPermissionSettingFragment$updatePermissionPublic$1$2$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SheetPermissionSettingFragment$updatePermissionPublic$1$2$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        s r3 = s.a;
        Context r0 = this.this$0.getContext();
        r3.getClass();
        s.s(r0, 2131899587);
        SheetPermissionSettingFragment r4 = this.this$0;
        r4.n = true;
        LarusPageSheetPermissionSettingsBinding r5 = r4.e;
        if (r5 == null) goto L11;
        ItemTextToggle r6 = r5.b;
        if (r6 == null) goto L11;
        CustomSwitchCompat r7 = r6.getToggleView();
        if (r7 == null) goto L11;
        r7.setChecked(this.$it);
    L11:
        this.this$0.n = false;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
