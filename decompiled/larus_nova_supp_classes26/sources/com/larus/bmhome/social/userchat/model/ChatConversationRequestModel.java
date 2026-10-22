package com.larus.bmhome.social.userchat.model;

import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.ConversationReceiverServiceImpl;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatConversationRequestModel {
    public static final /* synthetic */ int r = 0;
    public final String a;
    public final boolean b;
    public final String c;
    public final CoroutineScope d;
    public final String e;
    public final boolean f;
    public final NativeConversationServiceImpl g;
    public final ConversationReceiverServiceImpl h;
    public final BotServiceImpl i;
    public final MutableLiveData<wc9.e> j;
    public final MutableLiveData k;
    public final LiveData<com.larus.bmhome.social.userchat.model.a> l;
    public h m;
    public final MutableLiveData<wc9.e> n;
    public final MutableLiveData o;
    public final b p;
    public final String q;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.d0<wc9.e> {
        public final /* synthetic */ ChatConversationRequestModel a;

        public b(ChatConversationRequestModel r1) {
            this.a = r1;
        }

        public final void c(Object r5) {
            final wc9.e r6 = (wc9.e) r5;
            Intrinsics.checkNotNullParameter(r6, "conversation");
            FLogger.a.i(this.a.q, "Conversation onChange " + r6);
            SoftReference r0 = com.larus.utils.y.a;
            final ChatConversationRequestModel r1 = this.a;
            com.larus.utils.y.c(new e(r1, r6));
        }

        public final void a(wc9.e r2, final wc9.e r3) {
            Intrinsics.checkNotNullParameter(r3, "new");
            SoftReference r4 = com.larus.utils.y.a;
            final ChatConversationRequestModel r5 = this.a;
            com.larus.utils.y.c(new d(r5, r3));
        }
    }

    static {
    }

    public final Map<String, String> c() {
        String r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        String r3 = this.e;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        return null;
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L20:
        LinkedHashMap r5 = new LinkedHashMap();
        String r6 = this.c;
        if (r6 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == true) goto L29;
        r5.put("push_content_id", this.c);
    L29:
        String r8 = this.e;
        if (r8 != null) goto L32;
    L33:
        r1 = true;
    L34:
        if (r1 == true) goto L36;
        r5.put("ug_advertise_schema", this.e);
    L36:
        return r5;
    L32:
        if (r8.length() != 0) goto L34;
    L23:
        if (r6.length() == 0) goto L26;
        r7 = false;
        goto L27
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void d() {
        com.larus.bmhome.social.userchat.model.a r0 = (com.larus.bmhome.social.userchat.model.a) this.l.getValue();
        if (r0 == null) goto L12;
        BotModel r1 = r0.b;
        if (r1 == null) goto L13;
        String r2 = r1.getBotId();
        if (r2 == null) goto L14;
        h r3 = this.m;
        if (r3 == null) goto L15;
        this.i.unregisterBotChangeListener(r2, r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public static final void a(ChatConversationRequestModel r2, wc9.e r3) {
        r2.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.j.setValue(r3);
        return;
    L5:
        r2.j.postValue(r3);
    }

    public final Object b(String r12, String r13, MutableLiveData<com.larus.bmhome.social.userchat.model.a> r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof ChatConversationRequestModel$getBotFromDbAndServer$1) == false) goto L7;
        ChatConversationRequestModel$getBotFromDbAndServer$1 r0 = (ChatConversationRequestModel$getBotFromDbAndServer$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r16);
    L56:
        return Unit.INSTANCE;
    L13:
        MutableLiveData<com.larus.bmhome.social.userchat.model.a> r17 = (MutableLiveData) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L52:
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        ChatConversationRequestModel$getBotFromDbAndServer$4 r19 = new ChatConversationRequestModel$getBotFromDbAndServer$4((BotModel) r16, this, r17, null);
        r0.L$0 = null;
        r0.label = 6;
        if (BuildersKt.withContext(r18, r19, r0) != r8) goto L56;
        return r8;
    L14:
        ResultKt.throwOnFailure(r16);
    L45:
        return Unit.INSTANCE;
    L15:
        MutableLiveData<com.larus.bmhome.social.userchat.model.a> r110 = (MutableLiveData) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L41:
        MainCoroutineDispatcher r111 = Dispatchers.getMain();
        ChatConversationRequestModel$getBotFromDbAndServer$3 r112 = new ChatConversationRequestModel$getBotFromDbAndServer$3(r110, (BotModel) r16, null);
        r0.L$0 = null;
        r0.label = 4;
        if (BuildersKt.withContext(r111, r112, r0) != r8) goto L45;
        return r8;
    L16:
        BotModel r113 = (BotModel) r0.L$2;
        MutableLiveData<com.larus.bmhome.social.userchat.model.a> r114 = (MutableLiveData) r0.L$1;
        String r115 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        String r4 = r115;
    L32:
        if (this.f == true) goto L47;
        IBotRepoService r2 = RepoDispatcherDelegate.b.b();
        String r116 = r113.getBotId();
        if (r116 != null) goto L36;
        String r3 = "";
    L37:
        r0.L$0 = r114;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        r16 = IBotRepoService.b.a(r2, r3, true, r4, false, r0, 24);
        if (r16 != r8) goto L40;
        return r8;
    L40:
        r110 = r114;
        goto L41
    L36:
        r3 = r116;
        goto L37
    L47:
        return Unit.INSTANCE;
    L17:
        r14 = (MutableLiveData) r0.L$2;
        r13 = (String) r0.L$1;
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L18:
        String r5 = r12;
        r113 = (BotModel) r16;
        if (r113 == null) goto L48;
        String r117 = r113.getBotId();
        if (r117 != null) goto L27;
        r117 = "";
    L27:
        d();
        h r6 = new h(r14);
        this.m = r6;
        this.i.registerBotChangeListener(r117, r6);
        MainCoroutineDispatcher r118 = Dispatchers.getMain();
        ChatConversationRequestModel$getBotFromDbAndServer$2 r7 = new ChatConversationRequestModel$getBotFromDbAndServer$2(r14, r113, null);
        r0.L$0 = r13;
        r0.L$1 = r14;
        r0.L$2 = r113;
        r0.label = 2;
        if (BuildersKt.withContext(r118, r7, r0) != r8) goto L30;
        return r8;
    L30:
        r4 = r13;
        r114 = r14;
        goto L32
    L48:
        IBotRepoService r9 = RepoDispatcherDelegate.b.b();
        r0.L$0 = r14;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 5;
        r16 = IBotRepoService.b.a(r9, r5, true, null, false, r0, 28);
        if (r16 != r8) goto L51;
        return r8;
    L51:
        r17 = r14;
        goto L52
    L19:
        ResultKt.throwOnFailure(r16);
        IBotRepoService r10 = RepoDispatcherDelegate.b.b();
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.L$2 = r14;
        r0.label = 1;
        r16 = IBotRepoService.b.a(r10, r12, false, null, false, r0, 30);
        if (r16 != r8) goto L18;
        return r8;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new ChatConversationRequestModel$getBotFromDbAndServer$1(this, r15);
        goto L8
    }

    public ChatConversationRequestModel(String r2, boolean r3, String r4, CoroutineScope r5, String r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        if (com.larus.platform.exp.c.d == false) goto L5;
        RepoDispatcherDelegate.b.b().g1(r2, r8);
    L5:
        this.g = com.larus.im.d.d();
        this.h = com.larus.im.d.c();
        this.i = com.larus.im.d.a();
        MutableLiveData<wc9.e> r9 = new MutableLiveData();
        this.j = r9;
        this.k = r9;
        final MediatorLiveData r10 = new MediatorLiveData();
        r10.addSource(r9, new ChatConversationRequestModel$special$$inlined$distinctUntilChanged$1(r10));
        this.l = Transformations.switchMap(r10, new c(this));
        MutableLiveData<wc9.e> r11 = new MutableLiveData();
        this.n = r11;
        this.o = r11;
        this.p = new b(this);
        this.q = "ChatConversationRequestModel_" + hashCode();
    }
}
