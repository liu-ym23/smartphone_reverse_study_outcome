package com.larus.bmhome.chat.trace;

import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileLocalPath;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageTrace {
    public static final ChatMessageTrace a = null;
    public static final Lazy b = null;

    public ChatMessageTrace() {
    }

    static {
        a = new ChatMessageTrace();
        b = LazyKt.lazy(new t());
    }

    public static final String a(List r4) {
        List r5 = r4;
        Iterator r0 = r5.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (com.larus.bmhome.chat.bean.d.G0((Message) r1) == false) goto L3;
    L9:
        Message r3 = (Message) r1;
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();
        if ((!com.larus.bmhome.chat.bean.d.G0((Message) r7)) == false) goto L11;
        r2 = r7;
    L15:
        Message r8 = (Message) r2;
        if (r3 == null) goto L19;
        if (r8 == null) goto L19;
        return "user_and_bot";
    L19:
        if (r3 == null) goto L21;
        return "user";
    L21:
        return "bot";
    L8:
        r1 = null;
        goto L9
    }

    public static final Object b(ChatMessageTrace r8, String r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof ChatMessageTrace$getVoice$1) == false) goto L7;
        ChatMessageTrace$getVoice$1 r0 = (ChatMessageTrace$getVoice$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ChatMessageTrace$getVoice$1 r6 = r0;
        Object r11 = r6.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L29:
        BotModel r13 = (BotModel) r11;
        if (r13 != null) goto L34;
    L32:
        return null;
    L34:
        return r13.getVoiceType();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (r9 != null) goto L17;
    L20:
        boolean r14 = true;
    L21:
        if (r14 == true) goto L32;
        RepoDispatcher.a.getClass();
        BotRepo r15 = RepoDispatcher.g;
        if (r9 == null) goto L32;
        r6.label = 1;
        r11 = IBotRepoService.b.a(r15, r9, false, null, false, r6, 30);
        if (r11 != r12) goto L29;
        return r12;
    L17:
        if (r9.length() == 0) goto L20;
        r14 = false;
    L7:
        r0 = new ChatMessageTrace$getVoice$1(r8, r10);
        goto L8
    }

    public static void e(List r15, String r16, String r17, Integer r18, JSONObject r19) {
        Intrinsics.checkNotNullParameter(r15, "messages");
        Intrinsics.checkNotNullParameter(r16, "clickFrom");
        Intrinsics.checkNotNullParameter(r17, "botId");
        Intrinsics.checkNotNullParameter(r19, "traceInfo");
        if (r15.size() <= 1) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onMultipleMessageDelete$1(r19, r15, r17, r18, r16, null), 2, null);
        return;
    L5:
        Message r2 = (Message) CollectionsKt.firstOrNull(r15);
        if (r2 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r16, "clickFrom");
        Intrinsics.checkNotNullParameter(r17, "botId");
        Intrinsics.checkNotNullParameter(r19, "traceInfo");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onMessageDelete$1(r2, r17, r19, r18, r16, null), 2, null);
    }

    public static void d(List r12, String r13, Integer r14, boolean r15, String r16, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r17, "traceInfo");
        if (r12.isEmpty() == false) goto L6;
        return;
    L6:
        if (r12.size() <= 1) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onMultiMessageDeleteResult$1(r17, r12, r15, r13, r14, r16, null), 2, null);
        return;
    L8:
        Message r2 = (Message) CollectionsKt.firstOrNull(r12);
        if (r2 != null) goto L11;
        return;
    L11:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onSingleMessageDeleteResult$1(r2, r17, r15, r13, r14, r16, null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.bmhome.chat.trace.u] */
    public static void c(final Message r12, final String r13, final String r14, final String r15, final String r16, final String r17, final String r18) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r14, "scene");
        ArrayList r9 = null;
        if (r12.getContentType() != 6) goto L21;
        List r0 = com.larus.bmhome.chat.bean.d.g(r12).imageList;
        if (r0 == null) goto L12;
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        String r7 = ((Image) r1.next()).localResPath;
        if (r7 == null) goto L8;
        r6.add(r7);
    L13:
        if (r0 == null) goto L18;
        List r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L19;
        r3.add(((Image) r4.next()).key);
    L19:
        Pair r5 = new Pair(r6, r3);
    L75:
        List r10 = (List) r5.component1();
        List r8 = (List) r5.component2();
        ?? r11 = new u(r12, r13, r14, r15, r16, r17, r18);
        int r19 = 0;
        if (r10 == null) goto L84;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r10.iterator();
    L79:
        if (r21.hasNext() == false) goto L83;
        Object r22 = r21.next();
        if ((!StringsKt.contains$default((String) r22, (String) b.getValue(), false, 2, null)) == false) goto L79;
        r20.add(r22);
        goto L79
    L83:
        r9 = r20;
    L84:
        if (r9 != null) goto L86;
    L88:
        boolean r23 = false;
    L90:
        if (r23 == false) goto L92;
        JSONObject r24 = (JSONObject) r11.invoke();
        r24.put("type", 0);
        r24.put("local_res_path", r9.toString());
        r24.put("illegal_count", r9.size());
        com.larus.platform.service.o.a.reportEvent("dev_illegal_send_image_path", r24);
    L92:
        if (r8 == null) goto L113;
        List r25 = r8;
        if ((r25 instanceof Collection) == true) goto L96;
    L98:
        Iterator r26 = r25.iterator();
        int r27 = 0;
    L100:
        if (r26.hasNext() == false) goto L112;
        String r28 = (String) r26.next();
        if (r28 != null) goto L104;
    L107:
        boolean r29 = true;
    L108:
        if (r29 == false) goto L100;
        r27 = r27 + 1;
        if (r27 >= 0) goto L100;
        CollectionsKt.throwCountOverflow();
        goto L100
    L104:
        if (r28.length() == 0) goto L107;
        r29 = false;
        goto L108
    L112:
        r19 = r27;
        goto L113
    L96:
        if (r25.isEmpty() == false) goto L98;
    L113:
        if (r19 <= 0) goto L149;
        JSONObject r30 = (JSONObject) r11.invoke();
        r30.put("type", 1);
        r30.put("illegal_count", r19);
        com.larus.platform.service.o.a.reportEvent("dev_illegal_send_image_path", r30);
        return;
    L149:
        return;
    L86:
        if ((!r9.isEmpty()) != true) goto L88;
        r23 = true;
        goto L90
    L18:
        r3 = null;
        goto L19
    L12:
        r6 = null;
        goto L13
    L21:
        if (r12.getContentType() != 7) goto L39;
        List r31 = com.larus.bmhome.chat.sendimage.e.f(r12.getContent()).getFileList();
        if (r31 == null) goto L30;
        ArrayList r32 = new ArrayList();
        Iterator r33 = r31.iterator();
    L26:
        if (r33.hasNext() == false) goto L31;
        String r34 = ((SendFile) r33.next()).getLocalResPath();
        if (r34 == null) goto L26;
        r32.add(r34);
    L31:
        if (r31 == null) goto L36;
        List r35 = r31;
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r37 = r35.iterator();
    L34:
        if (r37.hasNext() == false) goto L37;
        r36.add(((SendFile) r37.next()).getTosKey());
    L37:
        r5 = new Pair(r32, r36);
        goto L75
    L36:
        r36 = null;
        goto L37
    L30:
        r32 = null;
        goto L31
    L39:
        if (lr8.c.a(r12) == false) goto L74;
        Map r38 = r12.getBusinessExt();
        if (r38 == null) goto L52;
        String r39 = (String) r38.get("nested_file_local_path_list");
        if (r39 == null) goto L52;
        List r40 = com.larus.bmhome.chat.sendimage.e.g(r39);
        if (r40 == null) goto L52;
        ArrayList r41 = new ArrayList();
        Iterator r42 = r40.iterator();
    L48:
        if (r42.hasNext() == false) goto L53;
        String r43 = ((NestedFileLocalPath) r42.next()).getPath();
        if (r43 == null) goto L48;
        r41.add(r43);
    L53:
        List r44 = com.larus.bmhome.chat.bean.d.f(r12).getEntities();
        if (r44 == null) goto L72;
        List r45 = r44;
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r45, 10));
        Iterator r47 = r45.iterator();
    L57:
        if (r47.hasNext() == false) goto L73;
        UplinkFileEntity r48 = (UplinkFileEntity) r47.next();
        if (n1.d(r48) == false) goto L65;
        UplinkEntityContent r49 = r48.getUplinkEntityContent();
        if (r49 == null) goto L70;
        Image r50 = r49.getUplinkImageInfo();
        if (r50 == null) goto L70;
        String r51 = r50.key;
    L71:
        r46.add(r51);
    L70:
        r51 = null;
        goto L71
    L65:
        UplinkEntityContent r52 = r48.getUplinkEntityContent();
        if (r52 == null) goto L70;
        UplinkFileInfo r53 = r52.getUplinkFileInfo();
        if (r53 == null) goto L70;
        r51 = r53.getTosKey();
    L73:
        r5 = new Pair(r41, r46);
        goto L75
    L72:
        r46 = null;
    L52:
        r41 = null;
        goto L53
    L74:
        r5 = new Pair(null, null);
        goto L75
    }
}
