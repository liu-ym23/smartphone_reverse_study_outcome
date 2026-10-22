package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.PictureSaveActionSheet$doDownloadImg$1", f = "PictureSaveActionSheet.kt", i = {}, l = {158, 159}, m = "invokeSuspend", n = {}, s = {})
final class PictureSaveActionSheet$doDownloadImg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imgUrl;
    int label;
    final /* synthetic */ PictureSaveActionSheet this$0;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.PictureSaveActionSheet$doDownloadImg$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.PictureSaveActionSheet$doDownloadImg$1$1", f = "PictureSaveActionSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PictureSaveActionSheet this$0;

        public AnonymousClass1(boolean r1, PictureSaveActionSheet r2, Continuation<? super AnonymousClass1> r3) {
            this.$result = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$result, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_PictureSaveActionSheet$doDownloadImg$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(PictureSaveActionSheet r1) {
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L11;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r4);
            CoroutineScope r5 = (CoroutineScope) this.L$0;
            if (this.$result == false) goto L7;
            t19.s r6 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            r6.getClass();
            t19.s.o(r1, 2131908983, false);
        L8:
            PictureSaveActionSheet r7 = this.this$0;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
            INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_PictureSaveActionSheet$doDownloadImg$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r7);     // Catch: Throwable -> L11
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L18;
            FLogger.a.e("PictureSaveActionSheet", "dismiss error ,info is " + r9.getMessage());
        L18:
            return Unit.INSTANCE;
        L11:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        L7:
            t19.s r10 = t19.s.a;
            Application r3 = AppHost.a.getApplication();
            r10.getClass();
            t19.s.b(r3, 2131908982, false);
            goto L8
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PictureSaveActionSheet$doDownloadImg$1(PictureSaveActionSheet r1, String r2, Continuation<? super PictureSaveActionSheet$doDownloadImg$1> r3) {
        this.this$0 = r1;
        this.$imgUrl = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PictureSaveActionSheet$doDownloadImg$1(this.this$0, this.$imgUrl, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L19:
        boolean r10 = ((Boolean) r9).booleanValue();
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(r10, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r4, this) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        final PictureSaveActionSheet r11 = this.this$0;
        String r3 = this.$imgUrl;
        this.label = 1;
        int r5 = PictureSaveActionSheet.j;
        r11.getClass();
        if (r3.length() != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        FLogger.a.w("ImageSave", "url is null");
        r9 = Boxing.boxBoolean(false);
    L17:
        if (r9 != r0) goto L19;
        return r0;
    L16:
        final CompletableDeferred r7 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ImageLoaderKt.l(r3, "image_save", new r(r7, r11), new s(), 20);
        r9 = r7.await(this);
        goto L17
    L13:
        r6 = false;
        goto L14
    }
}
