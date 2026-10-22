package com.ss.android.lark.chat.chatwindow.chat.model.pin;

import com.bytedance.lark.pb.im.v1.ChatPinInfo;
import com.bytedance.lark.pb.im.v1.GetChatPinInfoRequest;
import com.bytedance.lark.pb.im.v1.GetChatPinInfoResponse;
import com.bytedance.lark.pb.im.v1.PushChatPinInfo;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.message.AnnouncementUniversalPinExtra;
import com.ss.android.lark.chat.entity.message.MessageUniversalPinExtra;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListPinExtraLoader implements CoroutineScope {
    public static final /* synthetic */ int j = 0;
    public final String a;
    public final boolean b;
    public final CoroutineContext c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public volatile Long h;
    public final AtomicLong i;

    public static final class a {
    }

    public interface b {
        void a(Map<Long, MessageUniversalPinExtra> r1);
    }

    static {
    }

    public final void b() {
        if (this.b == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this, (ExecutorCoroutineDispatcher) this.d.getValue(), null, new MessageListPinExtraLoader$create$1(this, null), 2, null);
        BuildersKt.launch$default(this, (ExecutorCoroutineDispatcher) this.d.getValue(), null, new MessageListPinExtraLoader$create$2(this, null), 2, null);
    }

    public final CopyOnWriteArrayList<UniversalPinExtra> c() {
        return (CopyOnWriteArrayList) this.f.getValue();
    }

    public final ConcurrentHashMap<Long, MessageUniversalPinExtra> d() {
        return (ConcurrentHashMap) this.g.getValue();
    }

    public final CoroutineContext getCoroutineContext() {
        return this.c;
    }

    public final Object f(Continuation<? super Unit> r10) {
        if ((r10 instanceof MessageListPinExtraLoader$loadSync$1) == false) goto L7;
        MessageListPinExtraLoader$loadSync$1 r0 = (MessageListPinExtraLoader$loadSync$1) r10;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L19:
        com.larksuite.rucket.job.base.b.b r12 = (com.larksuite.rucket.job.base.b) r11;
        if ((r12 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L25;
        StringBuilder r5 = new StringBuilder("Error get chat ");
        r5.append(this.a);
        r5.append(" pin info for message list: ");
        String r13 = r12.b.getDisplayMsg();
        if (r13 != null) goto L24;
        r13 = BuildConfig.FLAVOR;
    L24:
        r5.append(r13);
        Log.e("ChatPinModel_Message_List", r5.toString());
    L61:
        return Unit.INSTANCE;
    L25:
        GetChatPinInfoResponse r6 = (GetChatPinInfoResponse) r12.b();
        if (this.i.get() <= ((GetChatPinInfoResponse) r12.b()).version.longValue()) goto L29;
        Log.i("ChatPinModel_Message_List", "current version is newer than response ");
        return Unit.INSTANCE;
    L29:
        Long r7 = null;
        com.ss.android.lark.chat.entity.chatter.a r8 = j.b(((GetChatPinInfoResponse) r12.b()).entity, null);
        d().clear();
        c().clear();
        Iterator r9 = r6.infos.iterator();
    L31:
        if (r9.hasNext() == false) goto L35;
        ChatPinInfo r14 = (ChatPinInfo) r9.next();
        UniversalPinExtra.a r15 = UniversalPinExtra.Companion;
        Intrinsics.checkNotNull(r14);
        String r16 = this.a;
        r15.getClass();
        UniversalPinExtra r17 = UniversalPinExtra.a.a(r14, r16, r8);
        if (r17 == null) goto L31;
        c().add(r17);
        goto L31
    L35:
        CopyOnWriteArrayList<UniversalPinExtra> r18 = c();
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L37:
        if (r20.hasNext() == false) goto L41;
        Object r21 = r20.next();
        if ((r21 instanceof MessageUniversalPinExtra) == false) goto L37;
        r19.add(r21);
        goto L37
    L41:
        Iterator r22 = r19.iterator();
    L43:
        if (r22.hasNext() == false) goto L45;
        MessageUniversalPinExtra r23 = (MessageUniversalPinExtra) r22.next();
        d().put(Boxing.boxLong(r23.getMessageId()), r23);
        goto L43
    L45:
        Iterator<T> r24 = c().iterator();
    L47:
        if (r24.hasNext() == false) goto L51;
        Object r25 = r24.next();
        if ((((UniversalPinExtra) r25) instanceof AnnouncementUniversalPinExtra) == false) goto L47;
    L52:
        UniversalPinExtra r26 = (UniversalPinExtra) r25;
        if (r26 == null) goto L55;
        r7 = r26.getPinId();
    L55:
        this.h = r7;
        StringBuilder r27 = new StringBuilder("[getPinInfo] update chat ");
        r27.append(this.a);
        r27.append(" pin info for message list, size = ");
        r27.append(d().size());
        r27.append(", has announcement = ");
        if (this.h != null) goto L59;
        r4 = false;
    L59:
        r27.append(r4);
        r27.append(", version = ");
        r27.append(r6.version);
        Log.i("ChatPinModel_Message_List", r27.toString());
        this.i.set(((GetChatPinInfoResponse) r12.b()).version.longValue());
        goto L61
    L51:
        r25 = null;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Long r110 = StringsKt.toLongOrNull(this.a);
        if (r110 == null) goto L63;
        RucketJob<GetChatPinInfoResponse> r111 = ((com.ss.android.lark.chat.chatwindow.chat.model.pin.a) b38.b.a.create(com.ss.android.lark.chat.chatwindow.chat.model.pin.a.class)).getChatPinExtras(new GetChatPinInfoRequest.Builder().chat_id(Boxing.boxLong(r110.longValue())).build());
        r0.label = 1;
        r11 = r111.awaitGet(r0);
        if (r11 != r2) goto L19;
        return r2;
    L63:
        return Unit.INSTANCE;
    L7:
        r0 = new MessageListPinExtraLoader$loadSync$1(this, r10);
        goto L8
    }

    public MessageListPinExtraLoader(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        this.a = r3;
        this.b = r4;
        this.c = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
        this.d = LazyKt.lazy(MessageListPinExtraLoader$dispatcher$2.INSTANCE);
        this.e = LazyKt.lazy(MessageListPinExtraLoader$listeners$2.INSTANCE);
        this.f = LazyKt.lazy(MessageListPinExtraLoader$allExtraInfo$2.INSTANCE);
        this.g = LazyKt.lazy(MessageListPinExtraLoader$messageExtraInfoMap$2.INSTANCE);
        this.i = new AtomicLong(-1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0082 -> B:17:0x0058). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0097 -> B:17:0x0058). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0198 -> B:17:0x0058). Please report as a decompilation issue!!! */
    public static final Object a(MessageListPinExtraLoader r12, Continuation r13) {
        r12.getClass();
        if ((r13 instanceof MessageListPinExtraLoader$startPush$1) == false) goto L7;
        MessageListPinExtraLoader$startPush$1 r0 = (MessageListPinExtraLoader$startPush$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        com.larksuite.rucket.job.extension.a r4 = (com.larksuite.rucket.job.extension.a) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        r0.L$0 = r4;
        r0.label = 1;
        r14 = r4.hasNext(r0);
        if (r14 != r2) goto L21;
        return r2;
    L21:
        if (((Boolean) r14).booleanValue() == false) goto L63;
        PushChatPinInfo r15 = (PushChatPinInfo) r4.a().b();
        if (Intrinsics.areEqual(r15.chat_id, StringsKt.toLongOrNull(r12.a)) == false) goto L17;
        if (r12.i.get() <= r15.version.longValue()) goto L28;
        Log.i("ChatPinModel_Message_List", "current version is newer than response ");
        goto L17
    L28:
        com.ss.android.lark.chat.entity.chatter.a r5 = j.b(r15.entity, null);
        r12.d().clear();
        r12.c().clear();
        Iterator r7 = r15.infos.iterator();
    L30:
        if (r7.hasNext() == false) goto L34;
        ChatPinInfo r8 = (ChatPinInfo) r7.next();
        UniversalPinExtra.a r10 = UniversalPinExtra.Companion;
        Intrinsics.checkNotNull(r8);
        String r11 = r12.a;
        r10.getClass();
        UniversalPinExtra r9 = UniversalPinExtra.a.a(r8, r11, r5);
        if (r9 == null) goto L30;
        r12.c().add(r9);
        goto L30
    L34:
        CopyOnWriteArrayList<UniversalPinExtra> r6 = r12.c();
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r6.iterator();
    L36:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        if ((r18 instanceof MessageUniversalPinExtra) == false) goto L36;
        r16.add(r18);
        goto L36
    L40:
        Iterator r19 = r16.iterator();
    L42:
        if (r19.hasNext() == false) goto L44;
        MessageUniversalPinExtra r20 = (MessageUniversalPinExtra) r19.next();
        r12.d().put(Boxing.boxLong(r20.getMessageId()), r20);
        goto L42
    L44:
        Iterator<T> r21 = r12.c().iterator();
    L46:
        if (r21.hasNext() == false) goto L50;
        Object r22 = r21.next();
        if ((((UniversalPinExtra) r22) instanceof AnnouncementUniversalPinExtra) == false) goto L46;
    L51:
        UniversalPinExtra r23 = (UniversalPinExtra) r22;
        if (r23 == null) goto L54;
        Long r24 = r23.getPinId();
    L55:
        r12.h = r24;
        StringBuilder r25 = new StringBuilder("[pushChatPinInfo] update chat ");
        r25.append(r12.a);
        r25.append(" pin info for message list, size = ");
        r25.append(r12.d().size());
        r25.append(", has announcement = ");
        if (r12.h == null) goto L58;
        boolean r26 = true;
    L59:
        r25.append(r26);
        r25.append(", version = ");
        r25.append(r15.version);
        Log.i("ChatPinModel_Message_List", r25.toString());
        r12.i.set(r15.version.longValue());
        MessageListPinExtraLoader$startPush$5 r110 = new MessageListPinExtraLoader$startPush$5(r12, null);
        r0.L$0 = r4;
        r0.label = 2;
        if (CoroutineScopeKt.coroutineScope(r110, r0) != r2) goto L17;
        return r2;
    L58:
        r26 = false;
        goto L59
    L54:
        r24 = null;
        goto L55
    L50:
        r22 = null;
        goto L51
    L63:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r4 = (com.larksuite.rucket.job.extension.a) r0.L$0;
        ResultKt.throwOnFailure(r14);
        goto L21
    L16:
        ResultKt.throwOnFailure(r14);
        r4 = ((com.ss.android.lark.chat.chatwindow.chat.model.pin.a) b38.b.a.create(com.ss.android.lark.chat.chatwindow.chat.model.pin.a.class)).pushChatPinExtras().iterator();
    L7:
        r0 = new MessageListPinExtraLoader$startPush$1(r12, r13);
        goto L8
    }

    public final Object e(List<Long> r9, Continuation<? super Map<Long, ? extends UniversalPinExtra>> r10) {
        if ((r10 instanceof MessageListPinExtraLoader$getUniversalPinExtras$1) == false) goto L7;
        MessageListPinExtraLoader$getUniversalPinExtras$1 r0 = (MessageListPinExtraLoader$getUniversalPinExtras$1) r10;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        HashMap r12 = new HashMap();
        Iterator<T> r13 = r9.iterator();
    L21:
        if (r13.hasNext() == false) goto L25;
        long r4 = ((Number) r13.next()).longValue();
        MessageUniversalPinExtra r5 = d().get(Boxing.boxLong(r4));
        if (r5 == null) goto L21;
        r12.put(Boxing.boxLong(r4), r5);
        goto L21
    L25:
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (this.i.get() != (-1)) goto L19;
        r0.L$0 = r9;
        r0.label = 1;
        if (f(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new MessageListPinExtraLoader$getUniversalPinExtras$1(this, r10);
        goto L8
    }
}
