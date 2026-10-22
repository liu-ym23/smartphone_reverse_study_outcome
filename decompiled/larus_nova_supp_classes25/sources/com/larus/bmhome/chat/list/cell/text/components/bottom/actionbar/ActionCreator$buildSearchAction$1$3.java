package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.app.Application;
import androidx.core.os.BundleKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.ActionCreator$buildSearchAction$1$3", f = "ActionCreator.kt", i = {}, l = {471, 475}, m = "invokeSuspend", n = {}, s = {})
final class ActionCreator$buildSearchAction$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.q1 $suggestModel;
    Object L$0;
    int label;
    final /* synthetic */ z this$0;

    public ActionCreator$buildSearchAction$1$3(Message r1, com.larus.bmhome.chat.component.bottom.q1 r2, z r3, Continuation<? super ActionCreator$buildSearchAction$1$3> r4) {
        this.$msg = r1;
        this.$suggestModel = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ActionCreator$buildSearchAction$1$3(this.$msg, this.$suggestModel, this.this$0, r5);
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
        z r2 = (z) this.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        String r10 = (String) r9;
        String r3 = UriProtector.parse("" + r10).getHost();
        if (r3 != null) goto L24;
    L29:
        boolean r4 = false;
    L30:
        if (r4 == false) goto L32;
        com.larus.platform.service.q.a.e(r2.b.getContext(), BundleKt.bundleOf(new Pair[]{TuplesKt.to("link_url", r10)}), null);
    L34:
        return Unit.INSTANCE;
    L32:
        t19.s r11 = t19.s.a;
        Application r5 = AppHost.a.getApplication();
        r11.getClass();
        t19.s.b(r5, 2131906756, false);
        goto L34
    L24:
        if (r3.length() <= 0) goto L26;
        boolean r6 = true;
    L27:
        if (r6 != true) goto L29;
        r4 = true;
        goto L30
    L26:
        r6 = false;
        goto L27
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        Message r12 = (Message) r9;
        if (r12 == null) goto L34;
        String r13 = r12.getContent();
        if (r13 == null) goto L34;
        com.larus.bmhome.chat.component.bottom.q1 r7 = this.$suggestModel;
        z r8 = this.this$0;
        CoroutineDispatcher r14 = Dispatchers.getIO();
        ActionCreator$buildSearchAction$1$3$1$url$1 r15 = new ActionCreator$buildSearchAction$1$3$1$url$1(r7, r13, null);
        this.L$0 = r8;
        this.label = 2;
        r9 = BuildersKt.withContext(r14, r15, this);
        if (r9 != r0) goto L20;
        return r0;
    L20:
        r2 = r8;
        goto L21
    L10:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        ActionCreator$buildSearchAction$1$3$question$1 r17 = new ActionCreator$buildSearchAction$1$3$question$1(this.$msg, null);
        this.label = 1;
        r9 = BuildersKt.withContext(r16, r17, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
