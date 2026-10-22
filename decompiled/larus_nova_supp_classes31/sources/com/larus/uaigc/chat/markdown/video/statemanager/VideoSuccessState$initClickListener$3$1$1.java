package com.larus.uaigc.chat.markdown.video.statemanager;

import android.graphics.Bitmap;
import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.helper.CreationMDCardClickHelper;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$initClickListener$3$1$1", f = "VideoSuccessState.kt", i = {}, l = {443}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessState$initClickListener$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ i this$0;

    public static final class a implements rd8.b {
        public final /* synthetic */ qd8.b a;

        public final kh8.a q3() {
            return this.a.q3();
        }

        public a(qd8.b r1) {
            this.a = r1;
        }

        public final void u(String r17, String r18, String r19, Boolean r20, String r21, String r22, String r23, Integer r24, String r25, String r26, JSONObject r27, by7.e r28, Boolean r29, Boolean r30) {
            Intrinsics.checkNotNullParameter(r27, "params");
            this.a.u(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
        }
    }

    public VideoSuccessState$initClickListener$3$1$1(i r1, Message r2, Continuation<? super VideoSuccessState$initClickListener$3$1$1> r3) {
        this.this$0 = r1;
        this.$message = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoSuccessState$initClickListener$3$1$1(this.this$0, this.$message, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        VideoPlayView.z(this.this$0.d0().i, 0, 2);
        CreationMDCardClickHelper r1 = CreationMDCardClickHelper.a;
        View r3 = this.this$0.getHostView();
        if (r3 != null) goto L11;
        r3 = this.this$0.d0().a;
    L11:
        View r4 = this.this$0.d0().a;
        String r5 = this.this$0.getCurrentPage();
        String r6 = this.this$0.b();
        Boolean r7 = this.this$0.d();
        q0.a r8 = this.this$0.f();
        Message r9 = this.$message;
        if (r9 == null) goto L14;
        String r10 = r9.getMessageId();
    L15:
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        i r11 = this.this$0;
        CreationTask r12 = r11.c;
        if (r12 == null) goto L20;
        String r13 = r12.id;
    L21:
        CoroutineScope r15 = r11.c();
        com.larus.uaigc.chat.markdown.image.component.a r16 = (com.larus.uaigc.chat.markdown.image.component.a) this.this$0.e.getValue();
        com.larus.uaigc.chat.markdown.image.component.k r17 = (com.larus.uaigc.chat.markdown.image.component.k) this.this$0.f.getValue();
        CreationChatItemClickHelper r18 = CreationChatItemClickHelper.a;
        q0.a r2 = this.this$0.f();
        if (r2 == null) goto L26;
        qd8.b r19 = r2.H9();
        if (r19 == null) goto L26;
        a r110 = new a(r19);
    L27:
        Long r20 = Boxing.boxLong(this.this$0.d0().i.getCurrentPlaybackTime());
        Bitmap r111 = this.this$0.d0().i.getMVideoView().getBitmap();
        r18.getClass();
        iy9.b r112 = CreationChatItemClickHelper.i(r110, r20, r111);
        this.label = 1;
        if (r1.a("VideoSuccessState", r3, r4, r5, r6, r7, r8, r10, r13, null, r15, r16, r17, r112, this) != r14) goto L31;
        return r14;
    L26:
        r110 = null;
        goto L27
    L20:
        r13 = null;
        goto L21
    L14:
        r10 = null;
        goto L15
    }
}
