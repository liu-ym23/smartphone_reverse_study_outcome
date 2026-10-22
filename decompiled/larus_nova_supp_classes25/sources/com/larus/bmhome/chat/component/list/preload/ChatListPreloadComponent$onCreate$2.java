package com.larus.bmhome.chat.component.list.preload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.s7;
import com.larus.bmhome.social.page.datasource.event.c;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.platform.api.e0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import td8.i;
import wc9.e;
import wr8.d;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.preload.ChatListPreloadComponent$onCreate$2", f = "ChatListPreloadComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListPreloadComponent$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatListPreloadComponent this$0;

    public ChatListPreloadComponent$onCreate$2(ChatListPreloadComponent r1, Continuation<? super ChatListPreloadComponent$onCreate$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatListPreloadComponent$onCreate$2 r0 = new ChatListPreloadComponent$onCreate$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        CompletableDeferred r8 = d.a;
        e r9 = d.b.a();
        if (r9 != null) goto L11;
        IAppLaunchReporter r10 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r10 == null) goto L10;
        IAppLaunchReporter.a.a(r10, "MainBotConvId is null");
    L10:
        return Unit.INSTANCE;
    L11:
        e0 r0 = (e0) this.this$0.h.getValue();
        if (r0 == null) goto L25;
        List r1 = r0.d(r9.a);
        if (r1 == null) goto L25;
        this.this$0.getClass();
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        r3.add(xc8.f.f((Message) r4.next()));
        goto L18
    L20:
        c<b> r5 = new c(r3, 1, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(true)));
        ChatListPreloadComponent r11 = this.this$0;
        c<b> r12 = new i(new f(r9, (de8.c) r11.l.getValue(), r11)).a(r5);
        ConcurrentHashMap<String, List<b>> r13 = s7.a;
        String r14 = r9.a;
        List<b> r15 = r12.a;
        Intrinsics.checkNotNullParameter(r14, "conversationId");
        Intrinsics.checkNotNullParameter(r15, "messageList");
        s7.a.put(r14, r15);
        IAppLaunchReporter r16 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r16 == null) goto L24;
        r16.b("load_message_from_cache", MapsKt.mapOf(TuplesKt.to("message_count", Boxing.boxInt(r12.a.size()))));
    L24:
        return Unit.INSTANCE;
    L25:
        IAppLaunchReporter r17 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r17 == null) goto L29;
        IAppLaunchReporter.a.a(r17, "PrefetchMessageList is null");
    L29:
        return Unit.INSTANCE;
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
