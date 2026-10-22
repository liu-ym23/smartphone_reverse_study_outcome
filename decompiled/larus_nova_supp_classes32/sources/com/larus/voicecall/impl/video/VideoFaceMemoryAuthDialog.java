package com.larus.voicecall.impl.video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusDialogVideoFaceMemoryAuthBinding;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016JG\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001d¢\u0006\u0002\b!H\u0082@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/voicecall/impl/video/VideoFaceMemoryAuthDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusDialogVideoFaceMemoryAuthBinding;", "dismissReason", NameKeys.UnloadStrategy_No_Strategy, "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getTheme", NameKeys.UnloadStrategy_No_Strategy, "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "withLoading", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoFaceMemoryAuthDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDialogVideoFaceMemoryAuthBinding d;
    public String e;
    public l0 f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog$onDestroy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog$onDestroy$1", f = "VideoFaceMemoryAuthDialog.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            SettingRepoDelegate r5 = SettingRepoDelegate.b;
            this.label = 1;
            if (r5.X(false, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954362;
    }

    public VideoFaceMemoryAuthDialog() {
        this.e = "other";
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FLogger.a.i("face_auth", "onDestroy: " + this.e);
        if (Intrinsics.areEqual(this.e, "confirm") == true) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
        c3a.a.a(false, true);
        return;
    }

    public static void S90(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        by7.a r4 = new by7.a("face_memory_pop_up_show");
        r4.d("pop_up_type", "first_time_auth");
        r4.b();
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        LarusDialogVideoFaceMemoryAuthBinding r5 = this.d;
        LarusDialogVideoFaceMemoryAuthBinding r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        Object r6 = r5.a.getParent();
        if ((r6 instanceof View) == false) goto L8;
        View r7 = (View) r6;
    L9:
        if (r7 == null) goto L11;
        r7.setBackground(null);
    L11:
        LarusDialogVideoFaceMemoryAuthBinding r8 = this.d;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L14:
        r8.b.setOnClickListener(new p(this));
        LarusDialogVideoFaceMemoryAuthBinding r9 = this.d;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L17:
        r9.d.setOnClickListener(new q(this));
        LarusDialogVideoFaceMemoryAuthBinding r10 = this.d;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r0.c.setOnClickListener(new r(this));
        return;
    L20:
        r0 = r10;
        goto L21
    L8:
        r7 = null;
        goto L9
    }

    public final <T> Object T90(CoroutineContext r9, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        if ((r11 instanceof VideoFaceMemoryAuthDialog$withLoading$1) == false) goto L7;
        VideoFaceMemoryAuthDialog$withLoading$1 r0 = (VideoFaceMemoryAuthDialog$withLoading$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L25:
        l0 r13 = this.f;
        if (r13 == null) goto L28;
        S90(r13);
    L28:
        this.f = null;
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        l0 r14 = this.f;
        if (r14 == null) goto L17;
        S90(r14);
    L17:
        l0 r15 = new l0(requireActivity(), 0.0f, false, 6);
        this.f = r15;
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r15);
    L22:
        VideoFaceMemoryAuthDialog$withLoading$result$1 r16 = new VideoFaceMemoryAuthDialog$withLoading$result$1(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r9, r16, r0);
        if (r12 != r2) goto L25;
        return r2;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L21:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
    L7:
        r0 = new VideoFaceMemoryAuthDialog$withLoading$1(this, r11);
        goto L8
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ConstraintLayout r7 = r4.inflate(2131562109, r5, false);
        int r8 = 2131366984;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r7, 2131366984);
        if (r9 == null) goto L17;
        r8 = 2131367647;
        AppCompatButton r0 = ViewBindings.findChildViewById(r7, 2131367647);
        if (r0 == null) goto L17;
        r8 = 2131374254;
        if (ViewBindings.findChildViewById(r7, 2131374254) == null) goto L17;
        r8 = 2131384152;
        AppCompatTextView r1 = ViewBindings.findChildViewById(r7, 2131384152);
        if (r1 == null) goto L17;
        r8 = 2131387674;
        if (ViewBindings.findChildViewById(r7, 2131387674) == null) goto L17;
        r8 = 2131388921;
        if (ViewBindings.findChildViewById(r7, 2131388921) == null) goto L17;
        ConstraintLayout r10 = r7;
        this.d = new LarusDialogVideoFaceMemoryAuthBinding(r10, r9, r0, r1);
        return r10;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
