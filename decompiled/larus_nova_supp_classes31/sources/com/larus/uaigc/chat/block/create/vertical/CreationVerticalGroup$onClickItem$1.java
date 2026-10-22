package com.larus.uaigc.chat.block.create.vertical;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.tencent.open.log.TraceLevel;
import kc8.q;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.vertical.CreationVerticalGroup$onClickItem$1", f = "CreationVerticalGroup.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
final class CreationVerticalGroup$onClickItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationItem $clickItem;
    final /* synthetic */ View $rootView;
    final /* synthetic */ iy9.b $videoPlayParams;
    int label;
    final /* synthetic */ CreationVerticalGroup this$0;

    public CreationVerticalGroup$onClickItem$1(CreationVerticalGroup r1, View r2, CreationItem r3, iy9.b r4, Continuation<? super CreationVerticalGroup$onClickItem$1> r5) {
        this.this$0 = r1;
        this.$rootView = r2;
        this.$clickItem = r3;
        this.$videoPlayParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationVerticalGroup$onClickItem$1(this.this$0, this.$rootView, this.$clickItem, this.$videoPlayParams, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r25);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r25);
        CreationChatItemClickHelper r1 = CreationChatItemClickHelper.a;
        CreationVerticalGroup r2 = this.this$0;
        int r3 = CreationVerticalGroup.u;
        Fragment r4 = r2.d;
        if (r4 == null) goto L12;
        View r5 = r4.getView();
        if (r5 == null) goto L12;
    L13:
        View r6 = r5;
        CreationVerticalGroup r8 = this.this$0;
        ChatParam r9 = r8.g;
        String r10 = null;
        if (r9 == null) goto L16;
        String r18 = r9.d;
    L17:
        if (r9 == null) goto L19;
        String r20 = r9.c;
    L20:
        boolean r11 = r8.h();
        CreationVerticalGroup r12 = this.this$0;
        q r14 = r12.f;
        Message r13 = r12.e;
        if (r13 == null) goto L23;
        r10 = r13.getMessageId();
    L23:
        if (r10 != null) goto L25;
        String r21 = "";
    L26:
        CreationVerticalGroup r15 = this.this$0;
        Message r16 = r15.e;
        LifecycleCoroutineScope r17 = LifecycleOwnerKt.getLifecycleScope(r15);
        com.larus.uaigc.chat.markdown.image.component.a r19 = this.this$0.f();
        com.larus.uaigc.chat.markdown.image.component.k r110 = this.this$0.g();
        View r22 = this.$rootView;
        Boolean r23 = Boxing.boxBoolean(r11);
        CreationItem r24 = this.$clickItem;
        iy9.b r26 = this.$videoPlayParams;
        this.label = 1;
        if (CreationChatItemClickHelper.q(r1, "CreationVerticalGroup", r6, r22, r18, r20, r23, r14, r21, r24, null, r17, r19, r110, r26, r16, null, false, this, 229888) != r7) goto L30;
        return r7;
    L25:
        r21 = r10;
        goto L26
    L19:
        r20 = null;
        goto L20
    L16:
        r18 = null;
    L12:
        r5 = this.this$0.r;
        goto L13
    }
}
