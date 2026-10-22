package com.larus.uaigc.chat;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationComponent$onReceiveCreationCanvasMsg$1", f = "CreationComponent.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
final class CreationComponent$onReceiveCreationCanvasMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ CreationComponent this$0;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ Message a;
        public final /* synthetic */ CreationComponent b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("CreationComponent", "getCanvasReplyMsgError: errorCode = " + r4.getCode());
        }

        public final void onSuccess(Object r10) {
            Message r11 = (Message) r10;
            Intrinsics.checkNotNullParameter(r11, "result");
            FLogger.a.i("CreationComponent", "getCanvasReplyMsgSuccess: replyId = " + this.a.getReplyId());
            List r12 = d.f(r11).getEntities();
            if (r12 == null) goto L30;
            ArrayList r0 = new ArrayList();
            Iterator r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L16;
            Object r1 = r13.next();
            Integer r2 = ((UplinkFileEntity) r1).getEntityType();
            int r3 = UplinkEntityType.EntityTypeImage.getValue();
            if (r2 != null) goto L11;
        L13:
            boolean r4 = false;
        L14:
            if (r4 == false) goto L6;
            r0.add(r1);
            goto L6
        L11:
            if (r2.intValue() != r3) goto L13;
            r4 = true;
            goto L14
        L16:
            ArrayList r14 = new ArrayList();
            Iterator r5 = r0.iterator();
        L17:
            String r6 = null;
            if (r5.hasNext() == false) goto L26;
            Image r7 = l1.c((UplinkFileEntity) r5.next());
            if (r7 == null) goto L24;
            ImageObj r8 = r7.imageThumb;
            if (r8 == null) goto L24;
            r6 = r8.url;
        L24:
            if (r6 == null) goto L17;
            r14.add(r6);
            goto L17
        L26:
            CreationComponent r9 = this.b;
            Iterator r15 = r14.iterator();
        L28:
            if (r15.hasNext() == false) goto L42;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new CreationComponent$onReceiveCreationCanvasMsg$1$1$onSuccess$3$1((String) r15.next(), null), 3, null);
            goto L28
        L42:
            return;
        }

        public a(Message r1, CreationComponent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public CreationComponent$onReceiveCreationCanvasMsg$1(Message r1, CreationComponent r2, Continuation<? super CreationComponent$onReceiveCreationCanvasMsg$1> r3) {
        this.$msg = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationComponent$onReceiveCreationCanvasMsg$1(this.$msg, this.this$0, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        NativeMessageServiceImpl r6 = com.larus.im.d.e();
        String r2 = this.$msg.getReplyId();
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r6.m(r2, new a(this.$msg, this.this$0));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
