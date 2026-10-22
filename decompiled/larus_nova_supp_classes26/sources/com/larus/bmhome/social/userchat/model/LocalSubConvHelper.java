package com.larus.bmhome.social.userchat.model;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatConversationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LocalSubConvHelper {
    public static final LocalSubConvHelper a = null;
    public static final Map<String, x> b = null;
    public static final MutexImpl c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/LocalSubConvHelper$UploadMsgBean;", "", "localMsgId", "", "sourceMsgId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocalMsgId", "()Ljava/lang/String;", "getSourceMsgId", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("local_msg_id")
        private final String localMsgId;

        @SerializedName("from_msg_id")
        private final String sourceMsgId;

        public a() {
            this("", "");
        }

        public a(String r1, String r2) {
            this.localMsgId = r1;
            this.sourceMsgId = r2;
        }
    }

    public LocalSubConvHelper() {
    }

    static {
        a = new LocalSubConvHelper();
        b = new LinkedHashMap();
        c = kotlinx.coroutines.sync.b.a();
    }

    public static String b(String r3) {
        if (StringsKt.isBlank(r3) == false) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), r3) == false) goto L30;
        com.larus.bmhome.auth.h0 r0 = AuthModelDelegate.b.v();
        if (r0 != null) goto L10;
        return null;
    L10:
        if (Intrinsics.areEqual(r0.h(), r3) == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L27;
        String r4 = r0.b();
        if (r4 == null) goto L28;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
    L21:
        r2 = false;
    L22:
        if (r2 == true) goto L24;
        return null;
    L24:
        return r4;
    L19:
        if (Intrinsics.areEqual(r4, TriggerSendLoading.NO_LOADING) == true) goto L21;
    L28:
        return null;
    L27:
        return null;
    L30:
        return null;
    }

    public static Map d(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        x r2 = (x) ((LinkedHashMap) b).get(r1);
        if (r2 == null) goto L16;
        Map<String, String> r3 = r2.b;
        if (r3 == null) goto L16;
        return r3;
    L16:
        return MapsKt.emptyMap();
    L10:
        return MapsKt.emptyMap();
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static String g(wc9.e r5) {
        boolean r0 = false;
        if (r5 == null) goto L10;
        Integer r2 = r5.j;
        if (r2 == null) goto L10;
        if (r2.intValue() != 1) goto L10;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L66;
        if (r5 == null) goto L20;
        Integer r4 = r5.j;
        if (r4 == null) goto L20;
        if (r4.intValue() != 2) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == true) goto L72;
        if (r5 == null) goto L30;
        Integer r7 = r5.v;
        if (r7 == null) goto L30;
        if (r7.intValue() != 1) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == true) goto L40;
        if (r5 == null) goto L39;
        Integer r9 = r5.v;
        if (r9 == null) goto L39;
        if (r9.intValue() != 3) goto L39;
        r0 = true;
    L39:
        if (r0 == true) goto L40;
    L43:
        if (r5 == null) goto L67;
        String r10 = r5.a;
        if (r10 != null) goto L47;
        return null;
    L47:
        if ((!StringsKt.isBlank(r10)) == true) goto L50;
        r10 = null;
    L50:
        if (r10 == null) goto L73;
        String r1 = BotInfoCache.INSTANCE.getBotId(r10);
        if ((!StringsKt.isBlank(r1)) == true) goto L56;
        r1 = null;
    L56:
        if (r1 == null) goto L59;
        return r1;
    L59:
        if (com.larus.im.j.f(r10) == false) goto L69;
        String r11 = com.larus.im.j.b(r10);
        if (r11 != null) goto L63;
        return null;
    L63:
        if ((!StringsKt.isBlank(r11)) == true) goto L65;
        return null;
    L65:
        return r11;
    L69:
        return null;
    L73:
        return null;
    L67:
        return null;
    L40:
        String r12 = b(AccountService.a.getSecUserId());
        if (r12 == null) goto L43;
        return r12;
    L30:
        r8 = false;
        goto L31
    L72:
        return null;
    L20:
        r6 = false;
        goto L21
    L66:
        return null;
    L10:
        r3 = false;
        goto L12
    }

    public static boolean i(String r5) {
        if (com.larus.platform.exp.o.a() == true) goto L6;
        return false;
    L6:
        if (r5 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return true;
    L14:
        AuthModelDelegate r3 = AuthModelDelegate.b;
        wc9.e r4 = (wc9.e) r3.y().getValue();
        String r6 = null;
        if (r4 == null) goto L17;
        String r7 = r4.a;
    L19:
        if (Intrinsics.areEqual(r5, r7) == true) goto L29;
        wc9.e r8 = (wc9.e) r3.u().getValue();
        if (r8 == null) goto L24;
        r6 = r8.a;
    L24:
        if (Intrinsics.areEqual(r5, r6) == true) goto L29;
        if (com.larus.im.j.g(r5) == true) goto L29;
        if (e(r5, b(AccountService.a.getSecUserId())) == true) goto L29;
        return false;
    L29:
        return true;
    L17:
        r7 = null;
        goto L19
    L8:
        if (StringsKt.isBlank(r5) == true) goto L11;
        r2 = false;
        goto L12
    }

    public static boolean e(String r3, String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (com.larus.im.j.f(r3) == true) goto L14;
    L16:
        return false;
    L14:
        if (Intrinsics.areEqual(com.larus.im.j.b(r3), r4) == false) goto L16;
        return true;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static boolean h(String r3, wc9.e r4) {
        if (com.larus.im.j.f(r3) == true) goto L5;
        return false;
    L5:
        if (com.larus.platform.exp.o.a() == true) goto L8;
        return false;
    L8:
        if (r4 == null) goto L15;
        Integer r2 = r4.v;
        if (r2 == null) goto L15;
        if (r2.intValue() != 1) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L28;
        if (r4 == null) goto L24;
        Integer r6 = r4.v;
        if (r6 == null) goto L24;
        if (r6.intValue() != 3) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == true) goto L28;
        if (i(r3) == true) goto L28;
        return false;
    L24:
        r7 = false;
    L28:
        return true;
    L15:
        r5 = false;
        goto L16
    }

    public final Object a(String r8, Continuation<? super String> r9) {
        if ((r9 instanceof LocalSubConvHelper$awaitCurrentAccountMainBotId$1) == false) goto L7;
        LocalSubConvHelper$awaitCurrentAccountMainBotId$1 r0 = (LocalSubConvHelper$awaitCurrentAccountMainBotId$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L28:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        c1 r11 = (c1) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
        c1 r12 = r11;
        r8 = r4;
    L25:
        LocalSubConvHelper$awaitCurrentAccountMainBotId$4 r5 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$4(r8, r12, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r10 = TimeoutKt.c(10000, r5, r0);
        if (r10 != r2) goto L28;
        return r2;
    L16:
        ResultKt.throwOnFailure(r10);
        if (StringsKt.isBlank(r8) == false) goto L19;
        return null;
    L19:
        String r13 = b(r8);
        if (r13 == null) goto L22;
        return r13;
    L22:
        r12 = (c1) AuthModelDelegate.b.a().getValue();
        MainCoroutineDispatcher r6 = Dispatchers.getMain().getImmediate();
        LocalSubConvHelper$awaitCurrentAccountMainBotId$3 r7 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$3(r8, r12, null);
        r0.L$0 = r8;
        r0.L$1 = r12;
        r0.label = 1;
        if (BuildersKt.withContext(r6, r7, r0) != r2) goto L25;
        return r2;
    L7:
        r0 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$1(this, r9);
        goto L8
    }

    public final Object f(wc9.e r7, Continuation<? super String> r8) {
        if ((r8 instanceof LocalSubConvHelper$resolveBotId$1) == false) goto L7;
        LocalSubConvHelper$resolveBotId$1 r0 = (LocalSubConvHelper$resolveBotId$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L32:
        List r10 = (List) r9;
        if (r10 != null) goto L41;
        return null;
    L41:
        return (String) CollectionsKt.firstOrNull(r10);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L22:
        List r11 = (List) r9;
        if (r11 != null) goto L25;
        return null;
    L25:
        return (String) CollectionsKt.firstOrNull(r11);
    L16:
        ResultKt.throwOnFailure(r9);
        if (com.larus.platform.exp.o.a() == true) goto L26;
        if (r7 == null) goto L37;
        r0.label = 1;
        r9 = ic8.n.c(r7, r0);
        if (r9 != r2) goto L22;
        return r2;
    L37:
        return null;
    L26:
        String r12 = g(r7);
        if (r12 != null) goto L36;
        if (r7 == null) goto L39;
        r0.label = 2;
        r9 = ic8.n.c(r7, r0);
        if (r9 != r2) goto L32;
        return r2;
    L39:
        return null;
    L36:
        return r12;
    L7:
        r0 = new LocalSubConvHelper$resolveBotId$1(this, r8);
        goto L8
    }

    public static void j(String r9, List r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "convId");
        Intrinsics.checkNotNullParameter(r10, "list");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r11 == false) goto L18;
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        Object r4 = r12.next();
        if (com.larus.bmhome.chat.bean.d.x((Message) r4).getSkillCardCnt() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
    L15:
        if (((Message) r4) == null) goto L17;
        r0.put("sub_conv_firstmet_type", "2");
        goto L18
    L17:
        r0.put("sub_conv_firstmet_type", "1");
        goto L18
    L10:
        r5 = false;
        goto L11
    L13:
        r4 = null;
    L18:
        Gson r13 = HttpExtKt.f;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r10.iterator();
    L20:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        if (((Message) r8).getContentType() == 2) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L20;
        r6.add(r8);
        goto L20
    L24:
        r14 = false;
        goto L25
    L27:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r16 = r6.iterator();
    L29:
        if (r16.hasNext() == false) goto L37;
        Message r17 = (Message) r16.next();
        String r18 = com.larus.bmhome.chat.bean.d.x(r17).getSourceMessageId();
        String r19 = r17.getLocalMessageId();
        if (r18.length() != 0) goto L33;
        boolean r20 = true;
    L34:
        if (r20 == false) goto L36;
        r18 = null;
    L36:
        r15.add(new a(r19, r18));
        goto L29
    L33:
        r20 = false;
        goto L34
    L37:
        r0.put("sub_conv_source_message", GsonProtectorUtils.toJson(r13, r15));
        b.put(r9, new x(r9, r10, r0));
    }

    public final Object c(String r11, wc9.e r12, Continuation<? super wc9.e> r13) {
        if ((r13 instanceof LocalSubConvHelper$findOrCreateMainBotSubConversation$1) == false) goto L7;
        LocalSubConvHelper$findOrCreateMainBotSubConversation$1 r0 = (LocalSubConvHelper$findOrCreateMainBotSubConversation$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L19;
        if (r3 != 4) goto L18;
        r11 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r15 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L66
    L65:
        wc9.e r16 = (wc9.e) r14;     // Catch: Throwable -> L66
        String r6 = r15;
    L69:
        if (com.larus.platform.exp.o.a() == false) goto L73;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), r6) == false) goto L73;
        r4 = true;
    L73:
        if (r4 == true) goto L76;
    L75:
        r16 = null;
    L76:
        r11.unlock(null);
        return r16;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r11 = (kotlinx.coroutines.sync.a) r0.L$3;
        String r17 = (String) r0.L$2;
        wc9.e r5 = (wc9.e) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L66
    L45:
        r16 = (wc9.e) r14;     // Catch: Throwable -> L66
        if (r16 == null) goto L56;
        Integer r9 = r16.v;     // Catch: Throwable -> L66
        if (r9 != null) goto L51;
    L53:
        boolean r7 = false;
    L54:
        if (r7 == false) goto L56;
    L57:
        if (r16 != null) goto L69;
        IAIChatConversationService.Companion r18 = IAIChatConversationService.a;     // Catch: Throwable -> L66
        if (r5 != null) goto L61;
        r5 = (wc9.e) AuthModelDelegate.b.u().getValue();     // Catch: Throwable -> L66
    L61:
        List r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L66
        r0.L$0 = r6;     // Catch: Throwable -> L66
        r0.L$1 = r11;     // Catch: Throwable -> L66
        r0.L$2 = null;     // Catch: Throwable -> L66
        r0.L$3 = null;     // Catch: Throwable -> L66
        r0.label = 4;     // Catch: Throwable -> L66
        r14 = r18.a(r17, r5, r8, r0);     // Catch: Throwable -> L66
        if (r14 != r2) goto L64;
        return r2;
    L64:
        r15 = r6;
        goto L65
    L51:
        if (r9.intValue() != 3) goto L53;
        r7 = true;
    L56:
        r16 = null;
        goto L57
    L22:
        r11 = (kotlinx.coroutines.sync.a) r0.L$3;
        r17 = (String) r0.L$2;
        r5 = (wc9.e) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L38:
        if (com.larus.platform.exp.o.a() == false) goto L75;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), r6) == false) goto L75;
        IConversationRepoService r19 = zh8.a.b;     // Catch: Throwable -> L66
        r0.L$0 = r6;     // Catch: Throwable -> L66
        r0.L$1 = r5;     // Catch: Throwable -> L66
        r0.L$2 = r17;     // Catch: Throwable -> L66
        r0.L$3 = r11;     // Catch: Throwable -> L66
        r0.label = 3;     // Catch: Throwable -> L66
        r14 = r19.m(r17, r0);     // Catch: Throwable -> L66
        if (r14 != r2) goto L45;
        return r2;
    L23:
        r12 = (wc9.e) r0.L$1;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L30:
        String r110 = (String) r14;
        if (r110 != null) goto L33;
        return null;
    L33:
        String r10 = c;
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.L$2 = r110;
        r0.L$3 = r10;
        r0.label = 2;
        if (r10.a(null, r0) != r2) goto L36;
        return r2;
    L36:
        r6 = r11;
        r11 = r10;
        r5 = r12;
        r17 = r110;
        goto L38
    L24:
        ResultKt.throwOnFailure(r14);
        if (com.larus.platform.exp.o.a() == true) goto L27;
        return null;
    L27:
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 1;
        r14 = a(r11, r0);
        if (r14 != r2) goto L30;
        return r2;
    L66:
        th = move-exception;
        r11.unlock(null);
        throw th;
    L7:
        r0 = new LocalSubConvHelper$findOrCreateMainBotSubConversation$1(this, r13);
        goto L8
    }
}
