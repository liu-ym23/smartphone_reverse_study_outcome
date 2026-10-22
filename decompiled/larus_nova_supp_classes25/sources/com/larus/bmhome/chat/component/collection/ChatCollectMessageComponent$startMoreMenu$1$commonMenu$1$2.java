package com.larus.bmhome.chat.component.collection;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.j1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.y0;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd8.f;
import hq9.k0;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2", f = "ChatCollectMessageComponent.kt", i = {0}, l = {472, 473}, m = "invokeSuspend", n = {"collectionId"}, s = {"L$0"})
final class ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ChatCollectMessageComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2$1", f = "ChatCollectMessageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ boolean $success;
        int label;
        final /* synthetic */ ChatCollectMessageComponent this$0;

        public AnonymousClass1(boolean r1, String r2, ChatCollectMessageComponent r3, Continuation<? super AnonymousClass1> r4) {
            this.$success = r1;
            this.$collectionId = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$success, this.$collectionId, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r4);
            if (this.$success == false) goto L14;
            IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r5 == null) goto L11;
            r5.getCollectService();
            y0 r6 = j1.a.g();
            if (r6 == null) goto L11;
            r6.Of(this.$collectionId);
        L11:
            s.a.g(this.this$0.getContext(), 2131908559, false);
            ChatCollectMessageComponent r7 = this.this$0;
            int r0 = ChatCollectMessageComponent.v;
            f r8 = (f) r7.t.getValue();
            if (r8 == null) goto L16;
            r8.N9(null);
        L16:
            return Unit.INSTANCE;
        L14:
            s r9 = s.a;
            Context r1 = this.this$0.getContext();
            r9.getClass();
            s.b(r1, 2131905625, false);
            goto L16
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2(ChatCollectMessageComponent r1, Continuation<? super ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L37:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r11);
    L31:
        boolean r12 = ((Boolean) r11).booleanValue();
    L33:
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass1 r5 = new AnonymousClass1(r12, r2, this.this$0, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r3, r5, this) != r0) goto L37;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        ChatCollectMessageComponent r13 = this.this$0;
        int r4 = ChatCollectMessageComponent.v;
        r2 = r13.Y2();
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L32;
        r14.getCollectService();
        j1 r15 = j1.a;
        MessageCollection r6 = this.this$0.lA();
        if (r6 == null) goto L25;
        List r7 = r6.getCollectionDetails();
        if (r7 == null) goto L25;
        List r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L26;
        CollectionDetail r10 = (CollectionDetail) r9.next();
        if (Intrinsics.areEqual(r10.isLike(), Boolean.TRUE) == false) goto L22;
        Message r16 = k0.a(r10);
    L23:
        if (r16 == null) goto L18;
        r8.add(r16);
        goto L18
    L22:
        r16 = null;
    L26:
        if (r8 != 0) goto L28;
        r8 = CollectionsKt.emptyList();
    L28:
        this.L$0 = r2;
        this.label = 1;
        r11 = r15.b(r8, this);
        if (r11 != r0) goto L31;
        return r0;
    L25:
        r8 = 0;
        goto L26
    L32:
        r12 = false;
        goto L33
    }
}
