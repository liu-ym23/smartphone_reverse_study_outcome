package ic8;

import android.util.LruCache;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a implements IIMCallback<List<? extends String>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ CompletableDeferred<List<String>> b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            vc8.d r3 = vc8.d.a;
            String r0 = this.a;
            r3.getClass();
            vc8.d.b(r0);
            this.b.complete(CollectionsKt.emptyList());
        }

        public final void onSuccess(Object r3) {
            List r4 = (List) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            vc8.d r0 = vc8.d.a;
            String r1 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "value");
            if (vc8.d.d == false) goto L6;
            ((LruCache) vc8.d.b.getValue()).put(r1, r4);
        L6:
            vc8.d.b(this.a);
            this.b.complete(r4);
        }

        public a(String r1, CompletableDeferred<List<String>> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements IIMCallback<List<? extends String>> {
        public final /* synthetic */ wc9.e a;
        public final /* synthetic */ CompletableDeferred<List<String>> b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            vc8.d r3 = vc8.d.a;
            String r0 = this.a.a;
            r3.getClass();
            vc8.d.b(r0);
            this.b.complete(CollectionsKt.emptyList());
        }

        public final void onSuccess(Object r4) {
            List r5 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            vc8.d r0 = vc8.d.a;
            wc9.e r1 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "conversation");
            Intrinsics.checkNotNullParameter(r5, "value");
            if (vc8.d.d == false) goto L12;
            Integer r2 = r1.j;
            if (r2 == null) goto L12;
            if (r2.intValue() != 3) goto L12;
            ((LruCache) vc8.d.b.getValue()).put(r1.a, r5);
        L12:
            vc8.d.b(this.a.a);
            this.b.complete(r5);
        }

        public b(wc9.e r1, CompletableDeferred<List<String>> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = LazyKt.lazy(new l());
        b = LazyKt.lazy(new m());
    }

    public static final boolean A(wc9.e r1) {
        if (E(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (j(r1) == true) goto L8;
        return false;
    }

    public static final boolean B(wc9.e r1) {
        if (r1 == null) goto L6;
        Integer r2 = r1.v;
        if (r2 == null) goto L6;
        return r2.equals(6);
    L6:
        return false;
    }

    public static final boolean C(wc9.e r3) {
        if (r3 == null) goto L10;
        String r4 = r3.r;
        if (r4 == null) goto L10;
        return Intrinsics.areEqual(new JSONObject(r4).optString("share_from_review_status"), "3");
    L9:
        FLogger.a.e("ConversationExt", "Call Conversation.isShareReviewBanned error, parse ext error, ext = ".concat(r4));
    L10:
        return false;
    }

    public static final boolean D(wc9.e r1) {
        if (r1 == null) goto L6;
        Integer r2 = r1.v;
        if (r2 == null) goto L6;
        return r2.equals(3);
    L6:
        return false;
    }

    public static final boolean E(wc9.e r7) {
        if (AppHost.a.isPlugin() == false) goto L5;
        return false;
    L5:
        if (r7 == null) goto L15;
        String r1 = r7.r;
        if (r1 == null) goto L15;
        String r3 = new JSONObject(r1).optString("tenant_source");     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r3, "toutiao") == false) goto L15;
        FLogger.a.i("ConversationExt.isToutiaoConversation", "isToutiaoConversation" + r3 + ", conversationId = " + r7.a);     // Catch: Exception -> L14
        return true;
    L14:
        FLogger.a.e("ConversationExt", "Call isToutiaoConversation error, parse ext error, ext = ".concat(r1));
    L15:
        return false;
    }

    public static final String F(wc9.e r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder("Conversation(id=");
        r0.append(r3.a);
        r0.append(",name=");
        String r1 = r3.c;
        if (r1 == null) goto L8;
        String r2 = StringsKt.take(r1, 4);
    L9:
        r0.append(r2);
        r0.append(",status=");
        r0.append(r3.t);
        r0.append(",type=");
        r0.append(r3.j);
        r0.append(",botType=");
        r0.append(r3.v);
        r0.append(",badge=");
        r0.append(r3.l);
        r0.append('_');
        r0.append(r3.m);
        r0.append(",pin=");
        r0.append(r3.e);
        r0.append(",time=");
        r0.append(r3.d);
        r0.append(",version=");
        r0.append(r3.u);
        r0.append(')');
        return r0.toString();
    L8:
        r2 = null;
        goto L9
    }

    public static final String a(wc9.e r2) {
        Object r0 = null;
        if (r2 == null) goto L23;
        String r3 = r2.r;
        if (r3 == null) goto L24;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        String r4 = new JSONObject(r3).optString("agent_task_param");     // Catch: Throwable -> L13
        if ((!StringsKt.isBlank(r4)) == true) goto L11;
        r4 = null;
    L11:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r5) == true) goto L20;
        r0 = r5;
    L20:
        return (String) r0;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    L23:
        return null;
    }

    @Deprecated(message = "使用 IChatUIBlockAbility.isBlocked(ChatUIBlockConfig.HIDE_INPUT_BAR) 配置化控制输入框显隐", replaceWith = @ReplaceWith(expression = "vContext.getAbility(IChatUIBlockAbility::class.java)?.isBlocked(ChatUIBlockConfig.HIDE_INPUT_BAR)", imports = {}))
    public static final boolean d(wc9.e r3) {
        if (r3 == null) goto L10;
        String r4 = r3.r;
        if (r4 == null) goto L10;
        return Intrinsics.areEqual(new JSONObject(r4).optString("forbid_send_msg"), "true");
    L9:
        FLogger.a.e("ConversationExt", "Call Conversation.forbidSendMsg error, parse ext error, ext = ".concat(r4));
    L10:
        return false;
    }

    public static final String e(wc9.e r5) {
        if (r5 == null) goto L16;
        String r6 = r5.s;
        if (r6 == null) goto L16;
        JSONObject r1 = new JSONObject(r6).optJSONObject("route_info");     // Catch: Exception -> L15
        boolean r2 = false;
        if (r1 != null) goto L10;
    L12:
        if (r2 == false) goto L16;
        return r1.optString("route_data");
    L10:
        if (r1.optInt("route_type") != 1) goto L12;
        r2 = true;
    L15:
        FLogger.a.e("ConversationExt", "Call Conversation.getAppletSchema error, parse biz_model error, bizModel = ".concat(r6));
    L16:
        return null;
    }

    public static final String f(wc9.e r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        IAIChatControlTraceService.Companion r0 = IAIChatControlTraceService.a;
        Integer r1 = r4.v;
        BotInfoCache r2 = BotInfoCache.INSTANCE;
        return r0.g(r1, r2.getBotType(r4.a), r2.isOwnBot(r4.a));
    }

    public static final String h(wc9.e r3) {
        if (r3 == null) goto L10;
        String r4 = r3.s;
        if (r4 == null) goto L10;
        return new JSONObject(r4).optString("jump_schema_url");
    L9:
        FLogger.a.e("ConversationExt", "Call Conversation.getPcCellJumpUrl error, parse biz_model error, bizModel = ".concat(r4));
    L10:
        return null;
    }

    public static final String i(wc9.e r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Integer r0 = r3.j;
        if (r0 != null) goto L6;
    L8:
        if (r0 == null) goto L14;
        if (r0.intValue() != 2) goto L14;
        return "group";
    L14:
        return f(r3);
    L6:
        if (r0.intValue() != 1) goto L8;
        return "real_people";
    }

    public static final boolean j(wc9.e r7) {
        if (AppHost.a.isPlugin() == false) goto L5;
        return false;
    L5:
        if (r7 == null) goto L15;
        String r1 = r7.r;
        if (r1 == null) goto L15;
        String r3 = new JSONObject(r1).optString("tenant_source");     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r3, "aweme_business") == false) goto L15;
        FLogger.a.i("ConversationExt.isAwemeBusinessConversation", "isAwemeBusinessConversation" + r3 + ", conversationId = " + r7.a);     // Catch: Exception -> L14
        return true;
    L14:
        FLogger.a.e("ConversationExt", "Call isAwemeBusinessConversation error, parse ext error, ext = ".concat(r1));
    L15:
        return false;
    }

    public static final boolean k(wc9.e r1) {
        if (r1 == null) goto L6;
        Integer r2 = r1.j;
        if (r2 == null) goto L6;
        return r2.equals(2);
    L6:
        return false;
    }

    public static final boolean l(wc9.e r3) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r3 == null) goto L12;
        Integer r4 = r3.E;
        if (r4 == null) goto L12;
        if (r4.intValue() != 3) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        r5 = false;
        goto L13
    }

    public static final boolean m(wc9.e r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.F != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean n(wc9.e r3) {
        if (r3 == null) goto L18;
        String r4 = r3.r;
        if (r4 == null) goto L22;
        String r1 = new JSONObject(r4).optString("agent_task_param");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L14
        if (StringsKt.isBlank(r1) == true) goto L19;
        if (new JSONObject(r1).optInt("runtime_type") != 1) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L14:
        FLogger.a.e("ConversationExt", "Call Conversation.isCloudPcConversation error, parse ext error, ext = ".concat(r4));
        return false;
    L22:
        return false;
    L18:
        return false;
    }

    public static final boolean o(wc9.e r2) {
        if (r2 == null) goto L20;
        String r3 = r2.r;
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((!StringsKt.isBlank(r3)) == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl(Boolean.valueOf(Boolean.parseBoolean(new JSONObject(r3).optString("disable_fork"))));     // Catch: Throwable -> L13
    L15:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L19;
        r4 = r1;
    L19:
        return ((Boolean) r4).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L25:
        return false;
    L20:
        return false;
    }

    public static final boolean p(wc9.e r1) {
        if (E(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (j(r1) == true) goto L8;
        return false;
    }

    public static final boolean q(wc9.e r1) {
        if (w(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (m(r1) == true) goto L8;
        return false;
    }

    public static final boolean r(wc9.e r2) {
        if (r2 == null) goto L11;
        Integer r3 = r2.f;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static final boolean s(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return com.larus.im.j.f(r1);
    }

    public static final boolean t(wc9.e r3) {
        if (r3 == null) goto L18;
        String r4 = r3.r;
        if (r4 == null) goto L22;
        String r1 = new JSONObject(r4).optString("agent_task_param");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L14
        if (StringsKt.isBlank(r1) == true) goto L19;
        if (new JSONObject(r1).optInt("runtime_type") == 2) goto L21;
        return false;
    L21:
        return true;
    L19:
        return false;
    L14:
        FLogger.a.e("ConversationExt", "Call Conversation.isLocalPcConversation error, parse ext error, ext = ".concat(r4));
        return false;
    L22:
        return false;
    L18:
        return false;
    }

    public static final boolean u(wc9.e r1) {
        if (r1 == null) goto L6;
        Integer r2 = r1.v;
        if (r2 == null) goto L6;
        return r2.equals(1);
    L6:
        return false;
    }

    public static final boolean v(wc9.e r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.a.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L28;
        String r2 = r4.a;
        wc9.e r3 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r3 == null) goto L13;
        String r5 = r3.a;
    L15:
        if (Intrinsics.areEqual(r2, r5) == false) goto L29;
        Integer r6 = r4.j;
        if (r6 != null) goto L20;
        return false;
    L20:
        if (r6.intValue() != 3) goto L30;
        Integer r7 = r4.v;
        if (r7 != null) goto L25;
        return false;
    L25:
        if (r7.intValue() != 1) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L13:
        r5 = null;
        goto L15
    L28:
        return false;
    L8:
        r1 = false;
        goto L9
    }

    public static final boolean w(wc9.e r2) {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r2.F != 1) goto L9;
        r3 = true;
        goto L10
    }

    public static final boolean y(wc9.e r4) {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r4 == null) goto L8;
        String r0 = r4.r;
        if (r0 == null) goto L8;
    L23:
    L21:
        FLogger.a.e("ConversationExt", "Call Conversation.isPcCvs error, parse ext error, ext = ".concat(r0));
        return false;
    L10:
        if (D(r4) == true) goto L12;
        return false;
    L12:
        if (r4 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == true) goto L20;
        if (Intrinsics.areEqual(new JSONObject(r0).optString("inner_platform"), "web") == true) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (r4.G != 1) goto L16;
        r5 = true;
    L8:
        r0 = "";
        goto L23
    }

    public static final boolean z(wc9.e r4) {
        if (r4 == null) goto L9;
        Integer r2 = r4.e;
        if (r2 == null) goto L9;
        if (r2.equals(1) != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L13:
        return true;
    L12:
        if (u(r4) == true) goto L13;
        return false;
    L9:
        r3 = false;
        goto L10
    }

    public static final Object b(String r6, Continuation<? super List<String>> r7) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        vc8.d.a.getClass();
        List r3 = vc8.d.a(r6);
        List r4 = r3;
        if (r4 != null) goto L15;
    L16:
        r0 = true;
    L17:
        if (r0 == true) goto L19;
        return r3;
    L19:
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        boolean r5 = vc8.d.d;
        if (r5 == true) goto L22;
        Job r8 = null;
    L23:
        if (r8 != null) goto L25;
    L28:
        CompletableDeferred r1 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        Intrinsics.checkNotNullParameter(r1, "deferred");
        if (r5 == false) goto L32;
        ((LruCache) vc8.d.c.getValue()).put(r6, r1);
    L32:
        com.larus.im.d.a().getBotIdsByConversationId(r6, new a(r6, r1));
        return r1.await(r7);
    L25:
        if (r8.isActive() == false) goto L28;
        return r8.await(r7);
    L22:
        r8 = (Deferred) ((LruCache) vc8.d.c.getValue()).get(r6);
        goto L23
    L15:
        if (r4.isEmpty() == false) goto L17;
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final Object c(wc9.e r6, Continuation<? super List<String>> r7) {
        Integer r0 = r6.j;
        if (r0 != null) goto L6;
    L7:
        Integer r1 = r6.j;
        if (r1 != null) goto L11;
    L13:
        vc8.d r2 = vc8.d.a;
        String r3 = r6.a;
        r2.getClass();
        List r4 = vc8.d.a(r3);
        List r5 = r4;
        if (r5 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L22;
        return r4;
    L22:
        String r9 = r6.a;
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        boolean r10 = vc8.d.d;
        if (r10 == true) goto L25;
        Job r11 = null;
    L26:
        if (r11 != null) goto L28;
    L31:
        CompletableDeferred r12 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r13 = r6.a;
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        Intrinsics.checkNotNullParameter(r12, "deferred");
        if (r10 == false) goto L35;
        ((LruCache) vc8.d.c.getValue()).put(r13, r12);
    L35:
        com.larus.im.d.a().getBotIdsByConversationId(r6.a, new b(r6, r12));
        return r12.await(r7);
    L28:
        if (r11.isActive() == false) goto L31;
        return r11.await(r7);
    L25:
        r11 = (Deferred) ((LruCache) vc8.d.c.getValue()).get(r9);
        goto L26
    L16:
        if (r5.isEmpty() == true) goto L19;
        r8 = false;
        goto L20
    L11:
        if (r1.intValue() != 2) goto L13;
    L38:
        return CollectionsKt.emptyList();
    L6:
        if (r0.intValue() == 1) goto L38;
        goto L7
    }

    public static final String g(wc9.e r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "defaultName");
        String r0 = null;
        boolean r1 = false;
        if (r5 != null) goto L6;
    L24:
        if (r1 == true) goto L26;
    L28:
        if (r5 == null) goto L39;
        String r7 = r5.c;
        if (r7 != null) goto L32;
        return r6;
    L32:
        if ((!StringsKt.isBlank(r7)) == false) goto L34;
        r0 = r7;
    L34:
        if (r0 != null) goto L37;
        return r6;
    L37:
        return r0;
    L39:
        return r6;
    L26:
        if (z2.a.y3() == false) goto L28;
        String r8 = AppHost.a.getApplication().getString(2131907245);
        Intrinsics.checkNotNull(r8);
        return r8;
    L6:
        if (u(r5) == true) goto L23;
        wc9.e r3 = (wc9.e) AuthModelDelegate.b.u().getValue();
        if (r3 == null) goto L11;
        String r4 = r3.a;
    L12:
        if (r4 != null) goto L14;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L24;
        if (Intrinsics.areEqual(r5.a, r4) == false) goto L24;
    L14:
        if (r4.length() <= 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 != true) goto L19;
        r9 = true;
        goto L20
    L16:
        r10 = false;
        goto L17
    L11:
        r4 = null;
    L23:
        r1 = true;
        goto L24
    }

    public static final boolean x(wc9.e r2, wc9.e r3, boolean r4) {
        if (n(r2) == n(r3)) goto L5;
    L10:
        return false;
    L5:
        if (t(r2) != t(r3)) goto L10;
        if (r4 == true) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(a(r2), a(r3)) == false) goto L10;
        goto L9
    }
}
