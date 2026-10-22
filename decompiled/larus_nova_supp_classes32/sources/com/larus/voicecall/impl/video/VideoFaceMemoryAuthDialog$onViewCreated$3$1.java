package com.larus.voicecall.impl.video;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog$onViewCreated$3$1", f = "VideoFaceMemoryAuthDialog.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class VideoFaceMemoryAuthDialog$onViewCreated$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoFaceMemoryAuthDialog this$0;

    public VideoFaceMemoryAuthDialog$onViewCreated$3$1(VideoFaceMemoryAuthDialog r1, Continuation<? super VideoFaceMemoryAuthDialog$onViewCreated$3$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoFaceMemoryAuthDialog$onViewCreated$3$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_voicecall_impl_video_VideoFaceMemoryAuthDialog$onViewCreated$3$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(VideoFaceMemoryAuthDialog r1) {
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

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        boolean r6 = ((Boolean) r5).booleanValue();
        c3a.a.a(true, r6);
        if (r6 == false) goto L14;
        INVOKEVIRTUAL_com_larus_voicecall_impl_video_VideoFaceMemoryAuthDialog$onViewCreated$3$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
    L16:
        return Unit.INSTANCE;
    L14:
        VideoFaceMemoryAuthDialog r7 = this.this$0;
        r7.e = "other";
        t19.s r2 = t19.s.a;
        Context r8 = r7.requireContext();
        r2.getClass();
        t19.s.b(r8, 2131905611, false);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        VideoFaceMemoryAuthDialog r9 = this.this$0;
        VideoFaceMemoryAuthDialog$onViewCreated$3$1$result$1 r3 = new VideoFaceMemoryAuthDialog$onViewCreated$3$1$result$1(null);
        this.label = 1;
        int r4 = VideoFaceMemoryAuthDialog.g;
        r5 = r9.T90(Dispatchers.getIO(), r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
