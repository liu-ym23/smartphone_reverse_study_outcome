package com.larus.bmhome.chat.auth;

import com.google.gson.reflect.TypeToken;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginAuth;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.r0;
import com.larus.bmhome.chat.t4;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PluginManagerDelegate implements hc8.b {
    public static final PluginManagerDelegate a = null;
    public static final CoroutineScope b = null;
    public static final Set<String> c = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/auth/PluginManagerDelegate$getPluginAuthInfo$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/auth/model/PluginAuth;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<List<? extends PluginAuth>> {
        public a() {
        }
    }

    public PluginManagerDelegate() {
    }

    @Override // hc8.b
    public final String b() {
        return "bot_info";
    }

    @Override // hc8.b
    public final String c() {
        return "previous_page";
    }

    @Override // hc8.b
    public final String i() {
        return "auth_message";
    }

    @Override // hc8.b
    public final String l() {
        return "model_provider";
    }

    @Override // hc8.b
    public final String n() {
        return "ask_message";
    }

    static {
        a = new PluginManagerDelegate();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new LinkedHashSet();
    }

    public static boolean o(Message r2) {
        String r3 = r2.getContent();
        if (r3 == null) goto L15;
        String r4 = StringsKt.removePrefix(r3, "{");
        if (r4 == null) goto L16;
        String r5 = StringsKt.removeSuffix(r4, "}");
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.length() != 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 != true) goto L18;
        return true;
    L18:
        return false;
    L11:
        r6 = false;
        goto L12
    L16:
        return false;
    L15:
        return false;
    }

    public static Map p(String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        ConcurrentHashMap<String, PluginManager> r1 = PluginManager.d;
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        String r5 = PluginManager.e.get(r4);
        if (r5 == null) goto L5;
        PluginManager r6 = PluginManager.a.a(r5);
    L6:
        if (r6 == null) goto L32;
        n0 r7 = r6.c;
        if (r7 == null) goto L32;
        PluginAuthType r0 = PluginAuthType.Once;
        Intrinsics.checkNotNullParameter(r0, "authType");
        ConcurrentHashMap<String, PluginAuthType> r8 = r7.a;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, PluginAuthType>> r9 = r8.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L18;
        Map.Entry<String, PluginAuthType> r3 = r9.next();
        if (r3.getValue() != r0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L11;
        r2.put(r3.getKey(), r3.getValue());
        goto L11
    L15:
        r10 = false;
        goto L16
    L18:
        ArrayList r11 = new ArrayList(r2.size());
        Iterator r12 = r2.entrySet().iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        r11.add((String) ((Map.Entry) r12.next()).getKey());
        goto L20
    L22:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r14 = r11.iterator();
    L24:
        if (r14.hasNext() == false) goto L26;
        String r15 = (String) r14.next();
        JSONObject r16 = new JSONObject();
        r16.put("plugin_id", r15);
        r16.put("auth_type", PluginAuthType.Once.value);
        r13.add(r16);
        goto L24
    L26:
        LinkedHashMap r17 = new LinkedHashMap();
        JSONArray r18 = new JSONArray();
        Iterator r19 = r13.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        r18.put(r19.next());
        goto L28
    L30:
        Unit r20 = Unit.INSTANCE;
        r17.put("ugc_plugin_auth_infos", r18.toString());
        return r17;
    L32:
        return null;
    L5:
        r6 = null;
        goto L6
    }

    @Override // hc8.b
    public final boolean a(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (o(r3) == false) goto L11;
        Set<String> r0 = c;
        if (CollectionsKt.contains(r0, r3.getMessageId()) == true) goto L13;
        String r4 = r3.getMessageId();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r0.add(r4);
        return true;
    L13:
        return false;
    L11:
        return false;
    }

    @Override // hc8.b
    public final hc8.a f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        ConcurrentHashMap<String, PluginManager> r0 = PluginManager.d;
        return PluginManager.a.a(r2).b;
    }

    @Override // hc8.b
    public final PluginAuth h(final Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return (PluginAuth) com.larus.utils.l0.a(null, new i0(r2));
    }

    @Override // hc8.b
    public final boolean j(final Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        int r0 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new j0(r3))).booleanValue() == false) goto L11;
        Map r4 = r3.getBusinessExt();
        if (r4 == null) goto L7;
        String r5 = (String) r4.get("has_handle_plugin_auth");
    L9:
        if (Intrinsics.areEqual(r5, "1") == true) goto L11;
        return true;
    L7:
        r5 = null;
    L11:
        return false;
    }

    @Override // hc8.b
    public final boolean e(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "botId");
        PluginAuth r4 = h(r2);
        if (r4 == null) goto L14;
        String r5 = r4.pluginId;
        if (r5 == null) goto L16;
        PluginAuthType r6 = k(r3, r5);
        if (r6 != null) goto L11;
        return false;
    L11:
        if (r6 != PluginAuthType.Once) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    L14:
        return false;
    }

    @Override // hc8.b
    public final PluginAuthType k(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "pluginId");
        ConcurrentHashMap<String, PluginManager> r1 = PluginManager.d;
        n0 r5 = PluginManager.a.a(r3).c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "pluginId");
        return r5.a.get(r4);
    }

    @Override // hc8.b
    public final void m(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "botId");
        ConcurrentHashMap<String, PluginManager> r2 = PluginManager.d;
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "botId");
        PluginManager.e.put(r4, r5);
    }

    public static void q(String r7, String r8, t4 r9) {
        Intrinsics.checkNotNullParameter(r7, "botId");
        Intrinsics.checkNotNullParameter(r8, "pluginId");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(b, Dispatchers.getMain(), null, new PluginManagerDelegate$getPluginDetail$1(r7, r8, r9, null), 2, null);
    }

    public static void t(String r17, String r18, PluginAuthType r19) {
        ConcurrentHashMap<String, PluginManager> r2 = PluginManager.d;
        PluginItemPagingCache r3 = PluginManager.a.a(r17).a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r18, "pluginId");
        Intrinsics.checkNotNullParameter(r19, "authType");
        CopyOnWriteArrayList<PluginItem> r4 = r3.d;
        Iterator<PluginItem> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        PluginItem r6 = r5.next();
        if (Intrinsics.areEqual(r6.pluginId, r18) == false) goto L4;
    L9:
        PluginItem r7 = r6;
        if (r7 == null) goto L23;
        int r0 = r4.indexOf(r7);
        PluginItem r1 = PluginItem.copy$default(r7, null, null, null, null, Integer.valueOf(r19.value), null, null, null, 239, null);
        if (r0 >= 0) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L24;
        r4.set(r0, r1);
        return;
    L24:
        return;
    L14:
        if (r0 >= r3.d.size()) goto L16;
        r8 = true;
        goto L17
    L23:
        return;
    L8:
        r6 = null;
        goto L9
    }

    public static void r(String r10, boolean r11, DowngradeSource r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r13, "callback");
        BuildersKt.launch$default(b, Dispatchers.getMain(), null, new PluginManagerDelegate$requestNextPagePluginItem$1(r13, r10, r11, r12, null), 2, null);
    }

    public static void s(String r10, String r11, PluginAuthType r12, Function1 r13) {
        if (CollectionsKt.listOf(new PluginAuthType[]{PluginAuthType.Always, PluginAuthType.Ask}).contains(r12) == false) goto L5;
        BuildersKt.launch$default(b, null, null, new PluginManagerDelegate$updatePluginAuthStatus$2(r10, r11, r12, r13, null), 3, null);
        return;
    L5:
        ConcurrentHashMap<String, PluginManager> r0 = PluginManager.d;
        n0 r14 = PluginManager.a.a(r10).c;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r11, "pluginId");
        Intrinsics.checkNotNullParameter(r12, "authType");
        r14.a.put(r11, r12);
        r13.invoke(Boolean.TRUE);
    }

    @Override // hc8.b
    public final String d(final Message r2, BotModel r3, final boolean r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "bot");
        String r6 = (String) com.larus.utils.l0.a("", new h0(r4, r2, r5));
        if (j(r2) == false) goto L18;
        String r7 = r3.getBotId();
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        if (e(r2, r7) == false) goto L10;
        return r6;
    L10:
        if (r6.length() != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        String r9 = "";
    L17:
        return r6 + r9 + ((String) com.larus.utils.l0.a("", new l0(r2)));
    L15:
        r9 = "\n\n";
        goto L17
    L12:
        r8 = false;
        goto L13
    L18:
        return r6;
    }

    @Override // hc8.b
    public final void g(Message r8, Message r9, BotModel r10, PluginAuthType r11, u7 r12) {
        Intrinsics.checkNotNullParameter(r8, "authMsg");
        Intrinsics.checkNotNullParameter(r10, "bot");
        Intrinsics.checkNotNullParameter(r11, "state");
        String r0 = r10.getBotId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        PluginAuth r2 = h(r8);
        if (r2 == null) goto L12;
        String r3 = r2.pluginId;
        if (r3 == null) goto L12;
        s(r0, r3, r11, new k0());
        t(r0, r3, r11);
    L12:
        RepoDispatcher.a.getClass();
        ChatRepo r4 = RepoDispatcher.d;
        String r5 = r8.getMessageId();
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        Pair r6 = TuplesKt.to("has_handle_plugin_auth", "1");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "localMessageId");
        Intrinsics.checkNotNullParameter(r6, "newExt");
        NativeMessageServiceImpl r7 = com.larus.im.d.e();
        r0 r13 = new r0(r6);
        String r14 = null;
        r7.x(r5, r13, null);
        if (CollectionsKt.listOf(new PluginAuthType[]{PluginAuthType.Always, PluginAuthType.Once}).contains(r11) == false) goto L24;
        if (r9 == null) goto L38;
        if (r12 == null) goto L38;
        PluginManagerDelegate r15 = a;
        String r16 = hc8.b.a.a(r15, r9, r10, false, 12);
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("resume", "1");
        JSONArray r18 = new JSONArray();
        JSONObject r19 = new JSONObject();
        PluginAuth r20 = r15.h(r8);
        if (r20 == null) goto L22;
        r14 = r20.pluginId;
    L22:
        r19.put("plugin_id", r14);
        r19.put("auth_type", r11.value);
        r18.put(r19);
        Unit r110 = Unit.INSTANCE;
        r17.put("ugc_plugin_auth_infos", r18.toString());
        r12.HL(r9, r16, r17, false);
    L38:
        if (r12 == null) goto L41;
        r12.wt(r8);
        return;
    L41:
        return;
    L24:
        if (r11 != PluginAuthType.Deny) goto L38;
        String r21 = AppHost.a.getApplication().getResources().getString(2131908376);
        if (r12 == null) goto L38;
        if (o(r8) == true) goto L37;
        StringBuilder r111 = new StringBuilder();
        Regex r112 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        TextContent r113 = vd9.r.b(r8);
        if (r113 == null) goto L33;
        r14 = r113.text;
    L33:
        if (r14 == null) goto L36;
        r1 = r14;
    L36:
        r111.append(r1);
        r111.append("\n\n");
        r111.append(r21);
        r21 = StringsKt.removePrefix(r111.toString(), "\n\n");
    L37:
        r12.Bm(r8, r21);
        goto L38
    }
}
