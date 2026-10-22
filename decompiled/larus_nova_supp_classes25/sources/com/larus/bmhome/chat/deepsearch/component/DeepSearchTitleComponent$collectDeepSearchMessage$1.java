package com.larus.bmhome.chat.deepsearch.component;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.home.impl.sdk.j1;
import com.larus.im.bean.message.Message;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchTitleComponent$collectDeepSearchMessage$1", f = "DeepSearchTitleComponent.kt", i = {4}, l = {118, DoraCallStateCode.DOUBAO_VUI_ERROR, 148, DoraCallStateCode.DOUBAO_STOP_SI_BY_VUI, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_IM}, m = "invokeSuspend", n = {"collectResult"}, s = {"L$2"})
final class DeepSearchTitleComponent$collectDeepSearchMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ q0.a $modelProvider;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DeepSearchTitleComponent this$0;

    public DeepSearchTitleComponent$collectDeepSearchMessage$1(DeepSearchTitleComponent r1, Message r2, q0.a r3, Continuation<? super DeepSearchTitleComponent$collectDeepSearchMessage$1> r4) {
        this.this$0 = r1;
        this.$message = r2;
        this.$modelProvider = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeepSearchTitleComponent$collectDeepSearchMessage$1(this.this$0, this.$message, this.$modelProvider, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r57) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r8 = false;
        Message r10 = null;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L13;
        if (r2 == 4) goto L12;
        if (r2 != 5) goto L11;
        com.larus.network.http.a r3 = (com.larus.network.http.a) this.L$2;
        DeepSearchTitleComponent r4 = (DeepSearchTitleComponent) this.L$1;
        Message r5 = (Message) this.L$0;
        ResultKt.throwOnFailure(r57);
    L94:
        int r6 = DeepSearchTitleComponent.r;
        DeepSearchParam r7 = r4.m3();
        if (r7 == null) goto L97;
        r8 = Intrinsics.areEqual(r7.f, Boxing.boxBoolean(true));
    L97:
        if (r8 == false) goto L110;
        Message r9 = r4.p;
        if (r9 == null) goto L103;
        Map r11 = r9.getExt();
        if (r11 == null) goto L103;
        Map r12 = MapsKt.toMutableMap(r11);
    L104:
        if (r12 == null) goto L106;
        String r13 = (String) r12.put("collection_status", "1");
    L106:
        Message r14 = r4.p;
        if (r14 == null) goto L109;
        r10 = Message.copy$default(r14, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, r12, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8193, 31, null);
    L109:
        r4.p = r10;
    L103:
        r12 = null;
    L110:
        com.larus.network.http.a r15 = r3;
        Message r16 = r5;
    L111:
        ICollectionReport.a.a(CollectionReportDelegate.b, r15, CollectionsKt.listOf(r16), "deep_search_page", "None", "deep_search_page", null, 32);
    L113:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        DeepSearchTitleComponent r17 = (DeepSearchTitleComponent) this.L$2;
        r16 = (Message) this.L$1;
        q0.a r18 = (q0.a) this.L$0;
        ResultKt.throwOnFailure(r57);
        DeepSearchTitleComponent r19 = r17;
        Object r20 = r57;
    L81:
        com.larus.network.http.a r21 = (com.larus.network.http.a) r20;
        q0.a r110 = r18;
    L84:
        if ((r21 instanceof y) == true) goto L90;
        if (r110 == null) goto L89;
        u7 r22 = r110.u3();
        if (r22 == null) goto L89;
        r22.zZ(r16);
    L89:
        FLogger.a.d(r19.m, "[biz_deep_search]CollectMenuCreator un collectMessage, msgId=" + r16.getMessageId());
        r15 = r21;
        goto L111
    L90:
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2 r24 = new DeepSearchTitleComponent$collectDeepSearchMessage$1$1$2(r19, null);
        this.L$0 = r16;
        this.L$1 = r19;
        this.L$2 = r21;
        this.label = 5;
        if (BuildersKt.withContext(r23, r24, this) != r1) goto L93;
        return r1;
    L93:
        r3 = r21;
        r5 = r16;
        r4 = r19;
        goto L94
    L13:
        DeepSearchTitleComponent r25 = (DeepSearchTitleComponent) this.L$0;
        ResultKt.throwOnFailure(r57);
    L55:
        int r26 = DeepSearchTitleComponent.r;
        DeepSearchParam r27 = r25.m3();
        if (r27 == null) goto L58;
        r8 = Intrinsics.areEqual(r27.f, Boxing.boxBoolean(true));
    L58:
        if (r8 == false) goto L113;
        Message r28 = r25.p;
        if (r28 == null) goto L64;
        Map r29 = r28.getExt();
        if (r29 == null) goto L64;
        Map r30 = MapsKt.toMutableMap(r29);
    L65:
        if (r30 == null) goto L67;
        String r31 = (String) r30.put("collection_status", "2");
    L67:
        Message r111 = r25.p;
        if (r111 == null) goto L70;
        r10 = Message.copy$default(r111, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, r30, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8193, 31, null);
    L70:
        r25.p = r10;
    L64:
        r30 = null;
        goto L65
    L14:
        DeepSearchTitleComponent r32 = (DeepSearchTitleComponent) this.L$2;
        Message r33 = (Message) this.L$1;
        q0.a r34 = (q0.a) this.L$0;
        ResultKt.throwOnFailure(r57);
        r19 = r32;
        Object r35 = r57;
    L42:
        com.larus.network.http.a r36 = (com.larus.network.http.a) r35;
        Message r112 = r33;
        r110 = r34;
    L44:
        ICollectionReport.a.b(CollectionReportDelegate.b, r36, CollectionsKt.listOf(r112), "deep_search_page", "deep_search_page", null, null, DoraCallStateCode.DOUBAO_CMD_12);
        if ((r36 instanceof y) == true) goto L51;
        if (r110 == null) goto L50;
        u7 r37 = r110.u3();
        if (r37 == null) goto L50;
        r37.J80(r112);
    L50:
        FLogger.a.i(r19.m, "CancelCollectMenuCreator un cancelCollectMessage, msgId=" + r112.getMessageId());
        goto L113
    L51:
        MainCoroutineDispatcher r38 = Dispatchers.getMain();
        DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1 r39 = new DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1(r19, null);
        this.L$0 = r19;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (BuildersKt.withContext(r38, r39, this) != r1) goto L54;
        return r1;
    L54:
        r25 = r19;
        goto L55
    L15:
        ResultKt.throwOnFailure(r57);
        Object r40 = r57;
    L28:
        Message r41 = (Message) r40;
    L29:
        if (r41 == null) goto L113;
        r110 = this.$modelProvider;
        r112 = this.$message;
        r19 = this.this$0;
        Regex r113 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r41, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r41).isCollected() == false) goto L71;
        if (r110 == null) goto L36;
        u7 r42 = r110.u3();
        if (r42 == null) goto L36;
        r42.zZ(r112);
    L36:
        FLogger.a.i(r19.m, "CancelCollectMenuCreator cancelCollectMessage, msgId=" + r112.getMessageId());
        IFlowSdkDepend r43 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r43 == null) goto L43;
        r43.getCollectService();
        j1 r44 = j1.a;
        this.L$0 = r110;
        this.L$1 = r112;
        this.L$2 = r19;
        this.label = 2;
        r35 = r44.c(r112, 1, this);
        if (r35 != r1) goto L41;
        return r1;
    L41:
        r34 = r110;
        r33 = r112;
        goto L42
    L43:
        r36 = null;
        goto L44
    L71:
        if (r110 == null) goto L75;
        u7 r45 = r110.u3();
        if (r45 == null) goto L75;
        r45.J80(r112);
    L75:
        FLogger.a.d(r19.m, "[biz_deep_search]CollectMenuCreator collectMessage, msgId=" + r112.getMessageId());
        IFlowSdkDepend r46 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r46 == null) goto L82;
        r46.getCollectService();
        j1 r47 = j1.a;
        List r48 = CollectionsKt.listOf(r112);
        this.L$0 = r110;
        this.L$1 = r112;
        this.L$2 = r19;
        this.label = 4;
        r20 = r47.d(1, r48, this);
        if (r20 != r1) goto L80;
        return r1;
    L80:
        r18 = r110;
        r16 = r112;
        goto L81
    L82:
        r21 = null;
        r16 = r112;
        goto L84
    L16:
        ResultKt.throwOnFailure(r57);
        DeepSearchTitleComponent r49 = this.this$0;
        int r114 = DeepSearchTitleComponent.r;
        DeepSearchParam r50 = r49.m3();
        if (r50 == null) goto L19;
        boolean r51 = Intrinsics.areEqual(r50.f, Boxing.boxBoolean(true));
    L20:
        if (r51 == false) goto L22;
        r41 = this.$message;
        goto L29
    L22:
        IChatRepoService r52 = zh8.a.a;
        String r115 = this.$message.getMessageId();
        if (r115 != null) goto L25;
        r115 = "";
    L25:
        this.label = 1;
        r40 = r52.E1(r115, this);
        if (r40 != r1) goto L28;
        return r1;
    L19:
        r51 = false;
        goto L20
    }
}
