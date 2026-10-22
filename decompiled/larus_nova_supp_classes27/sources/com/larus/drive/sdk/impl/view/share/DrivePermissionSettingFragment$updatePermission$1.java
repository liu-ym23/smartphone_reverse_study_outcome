package com.larus.drive.sdk.impl.view.share;

import android.content.Context;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.drive.sdk.impl.databinding.LarusPageDrivePermissionSettingsBinding;
import com.larus.drive.sdk.impl.service.t;
import com.larus.utils.logger.FLogger;
import e89.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.share.DrivePermissionSettingFragment$updatePermission$1", f = "DrivePermissionSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DrivePermissionSettingFragment$updatePermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $public;
    int label;
    final /* synthetic */ DrivePermissionSettingFragment this$0;

    public static final class a implements v79.b<Boolean> {
        public final /* synthetic */ DrivePermissionSettingFragment a;

        public a(DrivePermissionSettingFragment r1) {
            this.a = r1;
        }

        @Override // v79.b
        public final void onFailure(String r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            LarusPageDrivePermissionSettingsBinding r3 = this.a.e;
            if (r3 == null) goto L9;
            ItemTextToggle r4 = r3.b;
            if (r4 == null) goto L9;
            CustomSwitchCompat r5 = r4.getToggleView();
            if (r5 == null) goto L9;
            r5.setChecked(this.a.f);
        L9:
            Context r6 = this.a.getContext();
            if (r6 == null) goto L13;
            s.a.getClass();
            s.s(r6, 2131901792);
            return;
        }

        @Override // v79.b
        public final void onSuccess(Boolean r2) {
            this.a.f = r2.booleanValue();
        }
    }

    public DrivePermissionSettingFragment$updatePermission$1(DrivePermissionSettingFragment r1, boolean r2, Continuation<? super DrivePermissionSettingFragment$updatePermission$1> r3) {
        this.this$0 = r1;
        this.$public = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DrivePermissionSettingFragment$updatePermission$1(this.this$0, this.$public, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r6);
        if (this.this$0.g.length() != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L11;
        FLogger.a.i("DrivePermissionSettingFragment", "[updatePermission] File Token is empty");
        return Unit.INSTANCE;
    L11:
        c r8 = t.a();
        DrivePermissionSettingFragment r0 = this.this$0;
        r8.h(r0.g, r0.h, this.$public, new a(r0));
        return Unit.INSTANCE;
    L7:
        r7 = false;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
