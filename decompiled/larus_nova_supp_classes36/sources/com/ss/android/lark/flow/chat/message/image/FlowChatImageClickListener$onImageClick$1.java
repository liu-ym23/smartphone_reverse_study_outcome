package com.ss.android.lark.flow.chat.message.image;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowChatImageClickListener$onImageClick$1", f = "FlowChatImageClickListener.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatImageClickListener$onImageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PhotoItem $selectPhoItem;
    int label;
    final /* synthetic */ FlowChatImageClickListener this$0;

    public FlowChatImageClickListener$onImageClick$1(FlowChatImageClickListener r1, PhotoItem r2, Continuation<? super FlowChatImageClickListener$onImageClick$1> r3) {
        this.this$0 = r1;
        this.$selectPhoItem = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowChatImageClickListener$onImageClick$1(this.this$0, this.$selectPhoItem, r4);
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
        int r2 = 0;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L60:
        List<? extends PhotoItem> r9 = (List) r8;
        int r3 = FlowMediaPreviewUtils.a;
        int r4 = FlowMediaPreviewUtils.a(r9, this.$selectPhoItem);
        if (r4 <= (-1)) goto L66;
        if (this.$selectPhoItem == null) goto L66;
        ((PhotoItem) ListProtector.get(r9, r4)).setThumbnail(this.$selectPhoItem.getThumbnail());
    L66:
        if (this.$selectPhoItem == null) goto L68;
        if (r4 > (-1)) goto L71;
        Log.i("FlowChatImageClickListener", "onImageClick, currentPosition is -1, clear and add selectPhoItem");
        r9.clear();
        r9.add(this.$selectPhoItem);
    L72:
        this.this$0.a(r9, r2);
        return Unit.INSTANCE;
    L71:
        r2 = r4;
        goto L72
    L68:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FlowChatImageClickListener r10 = this.this$0;
        PhotoItem r5 = this.$selectPhoItem;
        if (r5 != null) goto L11;
        int r6 = FlowChatImageClickListener.h;
        r10.getClass();
    L45:
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        String r7 = "";
        r11.element = "";
        PhotoItem r12 = this.$selectPhoItem;
        if (r12 == null) goto L48;
        MessageIdentity r13 = r12.getMessageIdentity();
    L49:
        if (r13 == null) goto L57;
        MessageIdentity r14 = this.$selectPhoItem.getMessageIdentity();
        if (r14 == null) goto L56;
        String r15 = r14.getMessageId();
        if (r15 == null) goto L56;
        r7 = r15;
    L56:
        r11.element = r7;
    L57:
        CoroutineDispatcher r16 = Dispatchers.getIO();
        FlowChatImageClickListener$onImageClick$1$photoItems$1 r17 = new FlowChatImageClickListener$onImageClick$1$photoItems$1(this.this$0, r11, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r16, r17, this);
        if (r8 != r0) goto L60;
        return r0;
    L48:
        r13 = null;
        goto L49
    L11:
        IMessageListViewModel r18 = r10.c;
        if (r18 == null) goto L19;
        MutableLiveData r19 = r18.getCurrentChat();
        if (r19 == null) goto L19;
        Chat r20 = (Chat) r19.getValue();
        if (r20 == null) goto L19;
        String r21 = r20.getId();
        if (r21 == null) goto L19;
    L25:
        if (r21 != null) goto L27;
    L30:
        boolean r22 = true;
    L31:
        if (r22 == true) goto L45;
        MessageIdentity r23 = r5.getMessageIdentity();
        if (r23 != null) goto L36;
        r5.setMessageIdentity(new MessageIdentity(r5.getMessageId(), r21));
        goto L45
    L36:
        String r24 = r23.getChatId();
        if (r24 != null) goto L39;
    L42:
        boolean r25 = true;
    L43:
        if (r25 == false) goto L45;
        r23.setChatId(r21);
        goto L45
    L39:
        if (r24.length() == 0) goto L42;
        r25 = false;
        goto L43
    L27:
        if (r21.length() == 0) goto L30;
        r22 = false;
    L19:
        m2b.a r26 = r10.e;
        if (r26 == null) goto L24;
        Chat r27 = r26.getChat();
        if (r27 == null) goto L24;
        r21 = r27.getId();
    L24:
        r21 = null;
        goto L25
    }
}
