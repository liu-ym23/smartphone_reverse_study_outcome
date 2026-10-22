package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1", f = "FlowMessageSelectPlugin.kt", i = {}, l = {633}, m = "invokeSuspend", n = {}, s = {})
public final class FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ccb.c $data;
    int label;
    final /* synthetic */ FlowMessageSelectPlugin this$0;

    public FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1(FlowMessageSelectPlugin r1, ccb.c r2, Continuation<? super FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1(this.this$0, this.$data, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        List r9 = (List) r8;
        FlowMessageSelectPlugin r2 = this.this$0;
        ((ArrayList) r2.w).clear();
        ArrayList r3 = (ArrayList) r2.w;
        r3.addAll(r9);
        IMessageListComponent r4 = r2.j;
        if (r4 == null) goto L18;
        List r5 = r9;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        r6.add(((ccb.c.a) r7.next()).a);
        goto L15
    L17:
        r4.wb(r6);
    L18:
        FlowMessageSelectPlugin$mSelectedMessageChangeListener$2.a r10 = (FlowMessageSelectPlugin$mSelectedMessageChangeListener$2.a) r2.c0.getValue();
        r9.size();
        r10.a();
        UICallbackExecutor.removeCallbacks((Runnable) r2.C.getValue());
        LKUIToast.cancelLoading();
        r2.y = true;
        Function1<? super List<ccb.c.a>, Unit> r11 = r2.z;
        if (r11 == null) goto L21;
        r11.invoke(r2.w);
    L21:
        r2.z = null;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r12 = Dispatchers.getIO();
        FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1 r13 = new FlowMessageSelectPlugin$pullFollowingMessages$1$onSuccessed$1$filteredMessages$1(this.this$0, this.$data, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r12, r13, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
