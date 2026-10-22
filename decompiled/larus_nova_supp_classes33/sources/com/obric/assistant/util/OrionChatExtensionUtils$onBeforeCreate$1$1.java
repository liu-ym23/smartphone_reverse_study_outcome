package com.obric.assistant.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.OrionChatExtensionUtils$onBeforeCreate$1$1", f = "OrionChatExtensionUtils.kt", i = {0, 0}, l = {257}, m = "invokeSuspend", n = {"chatListAbility", "orionPageAbility"}, s = {"L$0", "L$1"})
public final class OrionChatExtensionUtils$onBeforeCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ OrionChatExtensionUtils this$0;

    public OrionChatExtensionUtils$onBeforeCreate$1$1(OrionChatExtensionUtils r1, FragmentActivity r2, Continuation<? super OrionChatExtensionUtils$onBeforeCreate$1$1> r3) {
        this.this$0 = r1;
        this.$activity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OrionChatExtensionUtils$onBeforeCreate$1$1(this.this$0, this.$activity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00bc -> B:33:0x00bf). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r4 = this.I$0;
        FragmentActivity r5 = (FragmentActivity) this.L$3;
        OrionChatExtensionUtils r6 = (OrionChatExtensionUtils) this.L$2;
        laa.d r7 = (laa.d) this.L$1;
        u7 r8 = (u7) this.L$0;
        ResultKt.throwOnFailure(r14);
        OrionChatExtensionUtils$onBeforeCreate$1$1 r15 = this;
    L33:
        r2 = r2 + 1;
    L18:
        if (r2 >= r4) goto L35;
        FLogger r9 = FLogger.a;
        String r10 = r6.a;
        StringBuilder r11 = new StringBuilder("try requestLayout for screen unlock event, ");
        r11.append(r5);
        r11.append(", ");
        r11.append(r8);
        r11.append(", ");
        if (r7 == null) goto L22;
        RecyclerView r12 = r7.Xw();
    L23:
        r11.append(r12);
        r9.i(r10, r11.toString());
        if (r8 == null) goto L26;
        r8.C90();
    L26:
        if (r7 == null) goto L30;
        RecyclerView r13 = r7.Xw();
        if (r13 == null) goto L30;
        r13.requestLayout();
    L30:
        r15.L$0 = r8;
        r15.L$1 = r7;
        r15.L$2 = r6;
        r15.L$3 = r5;
        r15.I$0 = r4;
        r15.I$1 = r2;
        r15.label = 1;
        if (DelayKt.delay(500, r15) != r0) goto L33;
        return r0;
    L22:
        r12 = null;
        goto L23
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        OrionChatExtensionUtils r16 = this.this$0;
        FragmentActivity r3 = this.$activity;
        r16.getClass();
        Fragment r17 = OrionChatExtensionUtils.m(r3);
        if (r17 == null) goto L13;
        t1a.b r18 = s1a.a.g(r17);
        if (r18 == null) goto L13;
        u7 r19 = (u7) r18.getAbility(u7.class);
    L14:
        OrionChatExtensionUtils r20 = this.this$0;
        FragmentActivity r21 = this.$activity;
        r20.getClass();
        laa.d r22 = OrionChatExtensionUtils.n(r21);
        if (r22 == null) goto L17;
        r22.uv();
    L17:
        OrionChatExtensionUtils r23 = this.this$0;
        r5 = this.$activity;
        r8 = r19;
        r7 = r22;
        r6 = r23;
        r2 = 0;
        r4 = 3;
        r15 = this;
    L13:
        r19 = null;
        goto L14
    }
}
