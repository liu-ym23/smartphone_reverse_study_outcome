package com.larus.drive.sdk.impl.view.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer$attach$1", f = "DriveFloatChatContainer.kt", i = {0}, l = {109}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DriveFloatChatContainer$attach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentAttachVersion;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DriveFloatChatContainer this$0;

    public DriveFloatChatContainer$attach$1(DriveFloatChatContainer r1, int r2, Continuation<? super DriveFloatChatContainer$attach$1> r3) {
        this.this$0 = r1;
        this.$currentAttachVersion = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DriveFloatChatContainer$attach$1 r0 = new DriveFloatChatContainer$attach$1(this.this$0, this.$currentAttachVersion, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L16:
        final Fragment r9 = (Fragment) r8;
        if (r9 != null) goto L19;
    L38:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[attach] failed, fragmentNull=");
        if (r9 != null) goto L41;
        r2 = true;
    L41:
        r5.append(r2);
        r5.append(", parentAdded=");
        r5.append(this.this$0.a.isAdded());
        r5.append(", containerId=");
        r5.append(this.this$0.c);
        r4.i("DriveFloatChatContainer", r5.toString());
        return Unit.INSTANCE;
    L19:
        if (this.this$0.a.isAdded() == false) goto L38;
        final DriveFloatChatContainer r6 = this.this$0;
        int r7 = r6.h;
        final int r10 = this.$currentAttachVersion;
        if (r7 == r10) goto L25;
        FLogger.a.i("DriveFloatChatContainer", "[attach] skip commit, expired=true, fragmentTag=" + this.this$0.b + ", containerId=" + this.this$0.c);
        return Unit.INSTANCE;
    L25:
        r6.f = r9;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L28
        Object r12 = Result.constructor-impl(Boxing.boxInt(INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_chat_DriveFloatChatContainer$attach$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r6.a.getChildFragmentManager().beginTransaction(), r6.c, r9, r6.b).runOnCommit(new e(r6, r10, r9)).commitAllowingStateLoss()));     // Catch: Throwable -> L28
    L30:
        DriveFloatChatContainer r13 = this.this$0;
        Throwable r14 = Result.exceptionOrNull-impl(r12);
        if (r14 == null) goto L37;
        if (r13.f != r9) goto L35;
        r13.f = null;
    L35:
        FLogger.a.e("DriveFloatChatContainer", "[attach] commit failed, fragmentTag=" + r13.b + ", containerId=" + r13.c, r14);
    L37:
        return Unit.INSTANCE;
    L28:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        Function0<Bundle> r17 = this.this$0.d;
        if (r17 == null) goto L12;
        Bundle r18 = (Bundle) r17.invoke();
        if (r18 == null) goto L12;
    L13:
        Bundle r20 = new Bundle(r18);
        r20.putBoolean("key_skip_draft_restore", true);
        com.bytedance.ee.drive.preview.d r21 = com.larus.drive.sdk.impl.service.t.a;
        e89.a r22 = (e89.a) com.larus.drive.sdk.impl.service.t.f.getValue();
        Fragment r23 = this.this$0.a;
        this.L$0 = r16;
        this.label = 1;
        r8 = r22.a(r23, r20, false, this);
        if (r8 != r0) goto L16;
        return r0;
    L12:
        r18 = new Bundle();
        goto L13
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_chat_DriveFloatChatContainer$attach$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}
