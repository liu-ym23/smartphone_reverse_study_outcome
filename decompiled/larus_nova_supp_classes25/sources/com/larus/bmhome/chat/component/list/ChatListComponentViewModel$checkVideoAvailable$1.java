package com.larus.bmhome.chat.component.list;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$checkVideoAvailable$1", f = "ChatListComponentViewModel.kt", i = {0}, l = {976}, m = "invokeSuspend", n = {"videoIdToMessage"}, s = {"L$0"})
public final class ChatListComponentViewModel$checkVideoAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    Object L$0;
    int label;

    public ChatListComponentViewModel$checkVideoAvailable$1(Message r1, Continuation<? super ChatListComponentViewModel$checkVideoAvailable$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListComponentViewModel$checkVideoAvailable$1(this.$message, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r41) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r4 = 10;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r41);
        Object r5 = r41;
    L65:
        List r6 = (List) r5;
        if (r6 == null) goto L123;
        Iterator r7 = r6.iterator();
    L69:
        if (r7.hasNext() == false) goto L121;
        MediaEntity r8 = (MediaEntity) r7.next();
        ArrayList r10 = new ArrayList();
        Iterator r9 = r3.iterator();
    L72:
        if (r9.hasNext() == false) goto L76;
        Object r11 = r9.next();
        if (Intrinsics.areEqual(((Pair) r11).getFirst(), r8.getItem_id()) == false) goto L72;
        r10.add(r11);
        goto L72
    L76:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, r4));
        Iterator r13 = r10.iterator();
    L78:
        if (r13.hasNext() == false) goto L80;
        r12.add((Message) ((Pair) r13.next()).getSecond());
        goto L78
    L80:
        Iterator r14 = r12.iterator();
    L82:
        if (r14.hasNext() == false) goto L69;
        Message r15 = (Message) r14.next();
        CommonVideoModel.a r16 = CommonVideoModel.Companion;
        if (r15 == null) goto L86;
        String r17 = r15.getContent();
    L87:
        r16.getClass();
        MediaEntityContainer r18 = CommonVideoModel.a.a(r17);
        if (r18 == null) goto L119;
        ArrayList r19 = r18.mediaList();
        if (r19 == null) goto L119;
        MediaEntity r110 = (MediaEntity) CollectionsKt.firstOrNull(r19);
        if (r110 == null) goto L119;
        int r111 = r8.getMedia_status();
        String r112 = r8.getMedia_cover_image();
        if (r110.getMedia_status() == r111) goto L98;
        boolean r113 = true;
    L100:
        if (Intrinsics.areEqual(r110.getMedia_cover_image(), r112) == true) goto L109;
        if (r112 != null) goto L103;
    L106:
        boolean r20 = true;
    L107:
        if (r20 == true) goto L109;
        boolean r21 = true;
    L110:
        if (r113 == true) goto L112;
        if (r21 == false) goto L119;
    L112:
        MediaEntity r22 = MediaEntity.copy$default(r110, null, null, null, null, null, null, null, r112, null, null, null, null, null, null, null, null, r111, null, null, null, null, null, null, null, 16711551, null);
        ArrayList r114 = r18.mediaList();
        if (r114 == null) goto L115;
        MediaEntity r23 = (MediaEntity) ListProtector.set(r114, 0, r22);
    L115:
        RepoDispatcher.a.getClass();
        ChatRepo r24 = RepoDispatcher.d;
        String r115 = r15.getMessageId();
        if (r115 != null) goto L118;
        r115 = "";
    L118:
        Intrinsics.checkNotNullParameter(r18, "what");
        r24.J1(r115, GsonProtectorUtils.toJson(HttpExtKt.f, r18), null);
        goto L119
    L103:
        if (r112.length() == 0) goto L106;
        r20 = false;
    L109:
        r21 = false;
        goto L110
    L98:
        r113 = false;
    L119:
        r4 = 10;
        goto L82
    L86:
        r17 = null;
        goto L87
    L121:
        return Unit.INSTANCE;
    L123:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r41);
        List r25 = CollectionsKt.listOf(this.$message);
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L10:
        if (r27.hasNext() == false) goto L27;
        Message r28 = (Message) r27.next();
        CommonVideoModel.a r116 = CommonVideoModel.Companion;
        if (r28 == null) goto L14;
        String r117 = r28.getContent();
    L15:
        r116.getClass();
        MediaEntityContainer r118 = CommonVideoModel.a.a(r117);
        if (r118 == null) goto L23;
        ArrayList r119 = r118.mediaList();
        if (r119 == null) goto L21;
        MediaEntity r120 = (MediaEntity) CollectionsKt.firstOrNull(r119);
    L22:
        if (r120 == null) goto L23;
        Pair r29 = TuplesKt.to(r28, r118);
    L25:
        if (r29 == null) goto L10;
        r26.add(r29);
        goto L10
    L21:
        r120 = null;
    L23:
        r29 = null;
        goto L25
    L14:
        r117 = null;
        goto L15
    L27:
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r31 = r26.iterator();
    L29:
        if (r31.hasNext() == false) goto L39;
        Pair r121 = (Pair) r31.next();
        ArrayList r122 = ((MediaEntityContainer) r121.getSecond()).mediaList();
        if (r122 == null) goto L35;
        MediaEntity r123 = (MediaEntity) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L35;
        String r124 = r123.getItem_id();
    L36:
        if (r124 != null) goto L38;
        r124 = "";
    L38:
        r30.add(TuplesKt.to(r124, r121.getFirst()));
    L35:
        r124 = null;
        goto L36
    L39:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r30.iterator();
    L41:
        if (r33.hasNext() == false) goto L48;
        Object r125 = r33.next();
        if (((CharSequence) ((Pair) r125).getFirst()).length() <= 0) goto L45;
        boolean r126 = true;
    L46:
        if (r126 == false) goto L41;
        r32.add(r125);
        goto L41
    L45:
        r126 = false;
        goto L46
    L48:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r26.iterator();
    L50:
        if (r35.hasNext() == false) goto L57;
        ArrayList r127 = ((MediaEntityContainer) ((Pair) r35.next()).getSecond()).mediaList();
        if (r127 == null) goto L54;
        MediaEntity r128 = (MediaEntity) CollectionsKt.firstOrNull(r127);
    L55:
        if (r128 == null) goto L50;
        r34.add(r128);
        goto L50
    L54:
        r128 = null;
        goto L55
    L57:
        IFlowSdkDepend r36 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r36 == null) goto L123;
        r2 r37 = r36.A0();
        if (r37 == null) goto L123;
        this.L$0 = r32;
        this.label = 1;
        r5 = r37.n(r34);
        if (r5 != r1) goto L64;
        return r1;
    L64:
        r3 = r32;
        goto L65
    }
}
