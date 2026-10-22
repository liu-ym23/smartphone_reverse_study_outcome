package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendFileAndText$sendAction$1$1", f = "ChatSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$sendFileAndText$sendAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMCallback<List<Message>> $callback;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ boolean $sameScene;
    final /* synthetic */ Long $sendClickTimestamp;
    final /* synthetic */ List<ic8.w> $sendStrategies;
    final /* synthetic */ String $txtScene;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSender$sendFileAndText$sendAction$1$1(List<? extends ic8.w> r1, ChatSender r2, String r3, String r4, boolean r5, IIMCallback<List<Message>> r6, boolean r7, Long r8, wc9.e r9, String r10, Continuation<? super ChatSender$sendFileAndText$sendAction$1$1> r11) {
        this.$sendStrategies = r1;
        this.this$0 = r2;
        this.$cvsId = r3;
        this.$txtScene = r4;
        this.$sameScene = r5;
        this.$callback = r6;
        this.$needInterrupt = r7;
        this.$sendClickTimestamp = r8;
        this.$conversation = r9;
        this.$fromScene = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ChatSender$sendFileAndText$sendAction$1$1(this.$sendStrategies, this.this$0, this.$cvsId, this.$txtScene, this.$sameScene, this.$callback, this.$needInterrupt, this.$sendClickTimestamp, this.$conversation, this.$fromScene, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        ChatSender$sendFileAndText$sendAction$1$1 r0 = this;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r0.label != 0) goto L119;
        ResultKt.throwOnFailure(r22);
        String r1 = UUID.randomUUID().toString();
        ArrayList r2 = new ArrayList();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        List<ic8.w> r4 = r0.$sendStrategies;
        List<ic8.w> r5 = r4;
        ChatSender r6 = r0.this$0;
        String r7 = r0.$cvsId;
        wc9.e r8 = r0.$conversation;
        String r9 = r0.$txtScene;
        String r10 = r0.$fromScene;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L113;
        ic8.w r12 = (ic8.w) r11.next();
        boolean r14 = r12 instanceof ai8.f;
        if (r14 == false) goto L68;
        ai8.f r15 = (ai8.f) r12;
        int r17 = ChatSender.j;
        r6.getClass();
        if (r15 == null) goto L68;
        NestedFileContent r16 = r15.a;
        if (r16 == null) goto L68;
        List r18 = r16.getEntities();
        if (r18 == null) goto L26;
        ArrayList r19 = new ArrayList();
        Iterator r110 = r18.iterator();
    L17:
        if (r110.hasNext() == false) goto L25;
        Iterator r111 = r11;
        Object r20 = r110.next();
        Image r21 = l1.c((UplinkFileEntity) r20);
        if (r21 == null) goto L21;
        boolean r23 = Intrinsics.areEqual(r21.isMarked(), Boolean.TRUE);
    L22:
        if (r23 == false) goto L24;
        r19.add(r20);
    L24:
        r11 = r111;
        r13 = r13;
        goto L17
    L21:
        r23 = false;
        goto L22
    L25:
        Iterator r112 = r11;
        ArrayList r24 = r13;
        Integer r25 = Integer.valueOf(r19.size());
    L27:
        List r26 = r16.getEntities();
        if (r26 == null) goto L40;
        ArrayList r113 = new ArrayList();
        Iterator r27 = r26.iterator();
    L31:
        if (r27.hasNext() == false) goto L39;
        Object r114 = r27.next();
        Image r115 = l1.c((UplinkFileEntity) r114);
        if (r115 == null) goto L35;
        boolean r28 = Intrinsics.areEqual(r115.isCropped(), Boolean.TRUE);
    L36:
        if (r28 == false) goto L38;
        r113.add(r114);
    L38:
        r27 = r27;
        goto L31
    L35:
        r28 = false;
        goto L36
    L39:
        Integer r29 = Integer.valueOf(r113.size());
    L41:
        ChatControlTrace.b.getClass();
        if (r7 != null) goto L44;
    L47:
        boolean r116 = true;
    L48:
        if (r116 == true) goto L55;
        ConcurrentHashMap r117 = ChatControlTrace.k;
        if (r25 == null) goto L53;
        int r30 = r25.intValue();
    L54:
        r117.put(r7, Integer.valueOf(r30));
        goto L55
    L53:
        r30 = 0;
    L55:
        if (r7 != null) goto L57;
    L60:
        boolean r31 = true;
    L61:
        if (r31 == true) goto L69;
        ConcurrentHashMap r32 = ChatControlTrace.l;
        if (r29 == null) goto L66;
        int r33 = r29.intValue();
    L67:
        r32.put(r7, Integer.valueOf(r33));
        goto L69
    L66:
        r33 = 0;
    L69:
        if (r14 == false) goto L71;
    L72:
        r3.element = r12.a();
    L73:
        r2.add(r12.h());
        Map<String, String> r34 = r12.a();
        if (r34 == null) goto L77;
        Map<String, String> r35 = MapsKt.toMutableMap(r34);
        if (r35 == null) goto L77;
    L79:
        if (r4.size() <= 1) goto L82;
        r35.put("collection_id", r1);
    L82:
        if (r8.i == false) goto L84;
        r35.put("tts", "1");
    L84:
        Map<String, String> r36 = r12.f();
        if (r36 == null) goto L88;
        Map<String, String> r37 = MapsKt.toMutableMap(r36);
        if (r37 == null) goto L88;
    L89:
        r37.put("send_loading", "1");
        ic8.w r38 = r12.c(r35, r37);
        int r39 = ChatSender.j;
        r6.getClass();
        String r40 = r38.b();
        String r118 = "";
        if (r40 != null) goto L92;
        r40 = "";
    L92:
        Map<String, String> r119 = r38.a();
        if (r119 == null) goto L95;
        String r120 = r119.get("scene");
    L96:
        if (r120 == null) goto L99;
        r118 = r120;
    L99:
        ChatControlTrace r121 = ChatControlTrace.b;
        r121.getClass();
        if (ChatControlTrace.A == false) goto L103;
        r121.Ma(r40, "share_send");
        ChatControlTrace.A = false;
    L112:
        ArrayList r41 = r24;
        r41.add(r38);
        r0 = this;
        r13 = r41;
        r11 = r112;
        goto L6
    L103:
        if (com.larus.utils.o0.d(r118) == false) goto L106;
        r121.Ma(r40, r118);
        goto L112
    L106:
        if (r38.contentType() != 1) goto L108;
        r121.Ma(r40, r9);
        goto L112
    L108:
        if (r10 != null) goto L110;
        String r122 = "other";
    L111:
        r121.Ma(r40, r122);
        goto L112
    L110:
        r122 = r10;
        goto L111
    L95:
        r120 = null;
    L88:
        r37 = new LinkedHashMap();
    L77:
        r35 = new LinkedHashMap();
        goto L79
    L71:
        if ((r12 instanceof ai8.e) == false) goto L73;
    L57:
        if (r7.length() == 0) goto L60;
        r31 = false;
        goto L61
    L44:
        if (r7.length() == 0) goto L47;
        r116 = false;
        goto L48
    L40:
        r29 = null;
        goto L41
    L26:
        r112 = r11;
        r24 = r13;
        r25 = null;
    L68:
        r112 = r11;
        r24 = r13;
        goto L69
    L113:
        r0.this$0.k(r0.$cvsId, r13, r0.$txtScene, r0.$sameScene, "sendFileAndText", r0.$callback, r0.$needInterrupt, r0.$sendClickTimestamp);
        LocalTakePictureImpl r42 = r0.this$0.g;
        if (r42 == null) goto L117;
        r42.e((Map) r3.element, r2);
    L117:
        return Unit.INSTANCE;
    L119:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
