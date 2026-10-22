package com.larus.bmhome.chat.component.collection;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.home.impl.sdk.j1;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.y0;
import com.larus.platform.model.CancelCollectionResponse;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1", f = "ChatCollectMessageComponent.kt", i = {0}, l = {448, 454}, m = "invokeSuspend", n = {"collectionId"}, s = {"L$0"})
final class ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ChatCollectMessageComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.collection.ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1$2", f = "ChatCollectMessageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ com.larus.network.http.a<CancelCollectionResponse> $resp;
        int label;
        final /* synthetic */ ChatCollectMessageComponent this$0;

        public AnonymousClass2(com.larus.network.http.a<CancelCollectionResponse> r1, ChatCollectMessageComponent r2, String r3, Continuation<? super AnonymousClass2> r4) {
            this.$resp = r1;
            this.this$0 = r2;
            this.$collectionId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$resp, this.this$0, this.$collectionId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r4);
            if ((this.$resp instanceof y) == false) goto L16;
            ChatCollectMessageComponent r5 = this.this$0;
            int r1 = ChatCollectMessageComponent.v;
            if (r5.m3() == false) goto L13;
            IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r6 == null) goto L13;
            r6.getCollectService();
            y0 r7 = j1.a.g();
            if (r7 == null) goto L13;
            r7.Of(this.$collectionId);
        L13:
            s.a.g(this.this$0.getContext(), 2131910858, false);
            f r8 = (f) this.this$0.t.getValue();
            if (r8 == null) goto L18;
            r8.N9(null);
        L18:
            return Unit.INSTANCE;
        L16:
            s r9 = s.a;
            Context r2 = this.this$0.getContext();
            r9.getClass();
            s.b(r2, 2131905625, false);
            goto L18
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1(ChatCollectMessageComponent r1, Continuation<? super ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatCollectMessageComponent$startMoreMenu$1$commonMenu$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        com.larus.network.http.a r15 = (com.larus.network.http.a) r14;
    L21:
        CollectionReportDelegate r5 = CollectionReportDelegate.b;
        MessageCollection r3 = this.this$0.lA();
        if (r3 == null) goto L30;
        List r4 = r3.getCollectionDetails();
        if (r4 == null) goto L30;
        List r6 = r4;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L27:
        if (r8.hasNext() == false) goto L29;
        r7.add(k0.a((CollectionDetail) r8.next()));
        goto L27
    L29:
        ArrayList r9 = r7;
    L31:
        ICollectionReport.a.b(r5, r15, r9, "temporary_chat_dots", null, null, null, 120);
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass2 r11 = new AnonymousClass2(r15, this.this$0, r2, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r10, r11, this) != r0) goto L35;
        return r0;
    L30:
        r9 = null;
        goto L31
    L10:
        ResultKt.throwOnFailure(r14);
        ChatCollectMessageComponent r16 = this.this$0;
        int r12 = ChatCollectMessageComponent.v;
        r2 = r16.Y2();
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L20;
        r17.getCollectService();
        j1 r18 = j1.a;
        if (r2 != null) goto L15;
        String r13 = "";
    L16:
        this.L$0 = r2;
        this.label = 1;
        r14 = r18.a(r13, this);
        if (r14 != r0) goto L19;
        return r0;
    L15:
        r13 = r2;
        goto L16
    L20:
        r15 = null;
        goto L21
    }
}
