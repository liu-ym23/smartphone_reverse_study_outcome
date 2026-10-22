package com.larus.uaigc.chat.block.create.vertical;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.vertical.LocalCreationVerticalGroup$onClickItem$1", f = "LocalCreationVerticalGroup.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
final class LocalCreationVerticalGroup$onClickItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationItem $clickItem;
    final /* synthetic */ View $rootView;
    final /* synthetic */ iy9.b $videoPlayParams;
    int label;
    final /* synthetic */ LocalCreationVerticalGroup this$0;

    public LocalCreationVerticalGroup$onClickItem$1(LocalCreationVerticalGroup r1, View r2, CreationItem r3, iy9.b r4, Continuation<? super LocalCreationVerticalGroup$onClickItem$1> r5) {
        this.this$0 = r1;
        this.$rootView = r2;
        this.$clickItem = r3;
        this.$videoPlayParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LocalCreationVerticalGroup$onClickItem$1(this.this$0, this.$rootView, this.$clickItem, this.$videoPlayParams, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        LocalCreationChatItemClickHelper r1 = LocalCreationChatItemClickHelper.a;
        LocalCreationVerticalGroup r2 = this.this$0;
        int r3 = LocalCreationVerticalGroup.u;
        Fragment r4 = r2.d;
        if (r4 == null) goto L12;
        View r5 = r4.getView();
        if (r5 == null) goto L12;
    L13:
        View r6 = r5;
        LocalCreationVerticalGroup r8 = this.this$0;
        ChatParam r9 = r8.g;
        String r10 = null;
        if (r9 == null) goto L16;
        String r16 = r9.d;
    L17:
        if (r9 == null) goto L19;
        String r17 = r9.c;
    L20:
        boolean r11 = r8.h();
        LocalCreationVerticalGroup r12 = this.this$0;
        q r13 = r12.f;
        Message r14 = r12.e;
        if (r14 == null) goto L23;
        r10 = r14.getMessageId();
    L23:
        if (r10 != null) goto L25;
        String r18 = "";
    L26:
        LocalCreationVerticalGroup r15 = this.this$0;
        Message r19 = r15.e;
        LifecycleCoroutineScope r110 = LifecycleOwnerKt.getLifecycleScope(r15);
        com.larus.uaigc.chat.markdown.image.component.a r111 = this.this$0.f();
        com.larus.uaigc.chat.markdown.image.component.k r112 = this.this$0.g();
        View r20 = this.$rootView;
        Boolean r21 = Boxing.boxBoolean(r11);
        CreationItem r23 = this.$clickItem;
        iy9.b r113 = this.$videoPlayParams;
        this.label = 1;
        if (r1.i("LocalCreationVerticalGroup", r6, r20, r16, r17, r21, r13, r18, r23, null, r110, r111, r112, r113, r19, this) != r7) goto L30;
        return r7;
    L25:
        r18 = r10;
        goto L26
    L19:
        r17 = null;
        goto L20
    L16:
        r16 = null;
    L12:
        r5 = this.this$0.r;
        goto L13
    }
}
