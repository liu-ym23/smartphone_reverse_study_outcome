package com.larus.drive.sdk.impl.view.preview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.larus.drive.sdk.impl.DriveLocalFilePreviewDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.DrivePreviewActivity$openLocalFilePreview$1", f = "DrivePreviewActivity.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class DrivePreviewActivity$openLocalFilePreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $localFileProviderAuthority;
    int label;
    final /* synthetic */ DrivePreviewActivity this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.preview.DrivePreviewActivity$openLocalFilePreview$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.DrivePreviewActivity$openLocalFilePreview$1$1", f = "DrivePreviewActivity.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $filePath;
        final /* synthetic */ String $localFileProviderAuthority;
        int label;
        final /* synthetic */ DrivePreviewActivity this$0;

        public AnonymousClass1(DrivePreviewActivity r1, String r2, String r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$filePath = r2;
            this.$fileName = r3;
            this.$localFileProviderAuthority = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$filePath, this.$fileName, this.$localFileProviderAuthority, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7 CancellationException -> L9
        L25:
            if (((Boolean) r5).booleanValue() == true) goto L29;
            DrivePreviewActivity.N1(this.this$0);     // Catch: Exception -> L7 CancellationException -> L9
            return Unit.INSTANCE;
        L29:
            if (DrivePreviewActivity.O1(this.this$0) == true) goto L33;
            this.this$0.finish();     // Catch: Exception -> L7 CancellationException -> L9
            return Unit.INSTANCE;
        L33:
            if (this.this$0.isFinishing() == true) goto L45;
            if (this.this$0.isDestroyed() == true) goto L45;
            if (this.this$0.getSupportFragmentManager().isStateSaved() == true) goto L45;
            int r6 = DriveLocalFilePreviewDelegate.a;     // Catch: Exception -> L7 CancellationException -> L9
            Fragment r7 = DriveLocalFilePreviewDelegate.a(this.$filePath, this.$fileName, this.$localFileProviderAuthority);     // Catch: Exception -> L7 CancellationException -> L9
            if (r7 != null) goto L43;
            DrivePreviewActivity.N1(this.this$0);     // Catch: Exception -> L7 CancellationException -> L9
            return Unit.INSTANCE;
        L43:
            INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_DrivePreviewActivity$openLocalFilePreview$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this.this$0.getSupportFragmentManager().beginTransaction(), 2131373275, r7, "drive_local_file_preview").commit();     // Catch: Exception -> L7 CancellationException -> L9
        L48:
            return Unit.INSTANCE;
        L45:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r5);
            if (DrivePreviewActivity.O1(this.this$0) == true) goto L18;
            this.this$0.finish();
            return Unit.INSTANCE;
        L18:
            if (this.this$0.getSupportFragmentManager().findFragmentByTag("drive_local_file_preview") != null) goto L20;
            int r8 = DriveLocalFilePreviewDelegate.a;     // Catch: Exception -> L7 CancellationException -> L9
            this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r5 = DriveLocalFilePreviewDelegate.b(this);     // Catch: Exception -> L7 CancellationException -> L9
            if (r5 != r0) goto L25;
            return r0;
        L20:
            return Unit.INSTANCE;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            FLogger.a.e("DrivePreviewActivity", "local preview failed, errorType=".concat(e.getClass().getSimpleName()));
            DrivePreviewActivity.N1(this.this$0);
            goto L48
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_DrivePreviewActivity$openLocalFilePreview$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
            return r1;
        L6:
            return r1.replace(r2, r3, r4);
        }
    }

    public DrivePreviewActivity$openLocalFilePreview$1(DrivePreviewActivity r1, String r2, String r3, String r4, Continuation<? super DrivePreviewActivity$openLocalFilePreview$1> r5) {
        this.this$0 = r1;
        this.$filePath = r2;
        this.$fileName = r3;
        this.$localFileProviderAuthority = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DrivePreviewActivity$openLocalFilePreview$1(this.this$0, this.$filePath, this.$fileName, this.$localFileProviderAuthority, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        DrivePreviewActivity r12 = this.this$0;
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r9 = new AnonymousClass1(r12, this.$filePath, this.$fileName, this.$localFileProviderAuthority, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r12, r2, r9, this) != r0) goto L12;
        return r0;
    }
}
