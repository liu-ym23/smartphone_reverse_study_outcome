package com.larus.bmhome.music.edit;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.larus.bmhome.music.protocol.UpdateBigMusicMessageApi;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicNameEditSheetDialogFragment$editName$2", f = "MusicNameEditSheetDialogFragment.kt", i = {}, l = {203, 206}, m = "invokeSuspend", n = {}, s = {})
final class MusicNameEditSheetDialogFragment$editName$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentPage;
    final /* synthetic */ Function1<String, Unit> $editNameCallback;
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ MusicNameEditSheetDialogFragment this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MusicNameEditSheetDialogFragment$editName$2(String r1, MusicNameEditSheetDialogFragment r2, Function1<? super String, Unit> r3, String r4, Continuation<? super MusicNameEditSheetDialogFragment$editName$2> r5) {
        this.$name = r1;
        this.this$0 = r2;
        this.$editNameCallback = r3;
        this.$currentPage = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MusicNameEditSheetDialogFragment$editName$2(this.$name, this.this$0, this.$editNameCallback, this.$currentPage, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_music_edit_MusicNameEditSheetDialogFragment$editName$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(MusicNameEditSheetDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L24:
        dm9.a.b r16 = (dm9.a) r15;
        String r2 = "";
        if ((r16 instanceof dm9.a.b) == false) goto L45;
        dm9.a.b r17 = r16;
        if (r17.a.isSuccess() == false) goto L40;
        FLogger.a.i("MusicNameEditSheetDialogFragment", "Message id " + this.this$0.e + " Edit name success code 0 name " + this.$name);
        String r3 = this.$currentPage;
        String r4 = this.this$0.d.getVid();
        String r5 = this.$currentPage;
        if (Intrinsics.areEqual(r5, "chat") == false) goto L32;
        r2 = "click_music_card";
    L34:
        kr8.g r18 = new kr8.g(r3, r4, r2, 1);
        MusicNameEditSheetDialogFragment r6 = this.this$0;
        if (r6.i == false) goto L37;
        kr8.n r7 = kr8.n.a;
        kr8.o r8 = r6.j;
        String r9 = this.$currentPage;
        String r10 = r6.g;
        String r11 = this.$name;
        Intrinsics.checkNotNullParameter(r9, "currentPage");
        JSONObject r12 = kr8.n.c(r8, r9, true);
        kr8.n.f(r12, "old_title", r10);
        kr8.n.f(r12, "new_title", r11);
        kr8.l.a.b(r18, r12, 1);
    L38:
        INVOKEVIRTUAL_com_larus_bmhome_music_edit_MusicNameEditSheetDialogFragment$editName$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
        this.$editNameCallback.invoke(this.$name);
        return Unit.INSTANCE;
    L37:
        kr8.l.a.b(r18, null, 3);
        goto L38
    L32:
        if (Intrinsics.areEqual(r5, "music_detail") == false) goto L34;
        r2 = "click_music_detail";
        goto L34
    L40:
        FLogger.a.e("MusicNameEditSheetDialogFragment", "Message id " + this.this$0.e + " Edit name failed code " + r17.a.getCode() + " message " + r17.a.getMsg());
        MusicNameEditSheetDialogFragment r13 = this.this$0;
        String r14 = r17.a.getMsg();
        if (r14 != null) goto L43;
        r14 = AppHost.a.getApplication().getString(2131907952) + " code: " + r17.a.getCode();
    L43:
        r13.getClass();
        t19.s r19 = t19.s.a;
        Application r20 = AppHost.a.getApplication();
        r19.getClass();
        t19.s.c(r20, r14);
    L53:
        INVOKEVIRTUAL_com_larus_bmhome_music_edit_MusicNameEditSheetDialogFragment$editName$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
        this.$editNameCallback.invoke(null);
        return Unit.INSTANCE;
    L45:
        if ((r16 instanceof dm9.a.a) == false) goto L53;
        FLogger.a.e("MusicNameEditSheetDialogFragment", "Message id " + this.this$0.e + " Edit name key failed remote " + ((dm9.a.a) r16).c);
        Context r110 = this.this$0.getContext();
        if (r110 == null) goto L52;
        String r111 = r110.getString(2131907952);
        if (r111 == null) goto L52;
        r2 = r111;
    L52:
        t19.s r112 = t19.s.a;
        Application r21 = AppHost.a.getApplication();
        r112.getClass();
        t19.s.c(r21, r2);
        goto L53
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L20:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r15);
        if (TextUtils.isEmpty(this.$name) == false) goto L15;
        INVOKEVIRTUAL_com_larus_bmhome_music_edit_MusicNameEditSheetDialogFragment$editName$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
        this.$editNameCallback.invoke(null);
        return Unit.INSTANCE;
    L15:
        if (o0.d(this.this$0.f) == false) goto L21;
        MusicNameEditSheetDialogFragment r113 = this.this$0;
        String r22 = this.$name;
        Function1<String, Unit> r23 = this.$editNameCallback;
        this.label = 1;
        if (MusicNameEditSheetDialogFragment.U90(r113, r22, r23, this) != r0) goto L20;
        return r0;
    L21:
        UpdateBigMusicMessageApi.a r114 = UpdateBigMusicMessageApi.a;
        MusicNameEditSheetDialogFragment$editName$2$result$1 r24 = new MusicNameEditSheetDialogFragment$editName$2$result$1(this.this$0, this.$name, null);
        this.label = 2;
        r114.getClass();
        FlowHttpConnection r115 = FlowHttpConnection.a;
        r15 = FlowHttpConnection.g("Social", UpdateBigMusicMessageApi.class, r24, false, null, null, null, this, 248);
        if (r15 != r0) goto L24;
        return r0;
    }
}
