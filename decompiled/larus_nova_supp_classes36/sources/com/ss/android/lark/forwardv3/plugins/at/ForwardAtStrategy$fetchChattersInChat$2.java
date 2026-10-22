package com.ss.android.lark.forwardv3.plugins.at;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import hob.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.plugins.at.ForwardAtStrategy$fetchChattersInChat$2", f = "ForwardAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ForwardAtStrategy$fetchChattersInChat$2 extends SuspendLambda implements Function2<Map<String, ? extends Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Collection<String> $ids;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ForwardAtStrategy this$0;

    public ForwardAtStrategy$fetchChattersInChat$2(ForwardAtStrategy r1, Collection<String> r2, Continuation<? super ForwardAtStrategy$fetchChattersInChat$2> r3) {
        this.this$0 = r1;
        this.$ids = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ForwardAtStrategy$fetchChattersInChat$2 r0 = new ForwardAtStrategy$fetchChattersInChat$2(this.this$0, this.$ids, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Map) r1, (Continuation) r2);
    }

    public final Object invoke(Map<String, Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r9);
        Map r10 = (Map) this.L$0;
        ForwardAtStrategy r0 = this.this$0;
        List<String> r1 = CollectionsKt.toList(this.$ids);
        int r2 = ForwardAtStrategy.j;
        r0.getClass();
        if (r10 != null) goto L7;
    L10:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        Log.e("ForwardAtStrategy", "get chatter in chat success, but data is empty");
        r0.a(r1);
    L26:
        return Unit.INSTANCE;
    L14:
        Log.e("ForwardAtStrategy", "get chatter in chat success, " + r10);
        Iterator<T> r4 = r1.iterator();
    L16:
        if (r4.hasNext() == false) goto L26;
        String r5 = (String) r4.next();
        Boolean r6 = (Boolean) r10.get(r5);
        List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<c>> r7 = r0.e.remove(r5);
        if (r6 != null) goto L20;
        Log.e("ForwardAtStrategy", "get chatter in chat success, but id = " + r5 + " chatter is null");
        r0.h.invoke(r7);
    L23:
        if (r7 == null) goto L16;
        r7.clear();
        goto L16
    L20:
        c r8 = (c) ((LinkedHashMap) r0.f).get(r5);
        if (r8 == null) goto L23;
        r8.d = !r6.booleanValue();
        r0.i.invoke(r8, r7);
        goto L23
    L7:
        if (r10.isEmpty() == true) goto L10;
        r3 = false;
        goto L12
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
