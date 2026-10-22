package com.larus.bmhome.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/utils/BizSecureKtxKt$eraseSuggestItems$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends PromptContent.SuggestItem>> {
        public a() {
        }
    }

    public static final IMMsgExt a(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        IMMsgExt r11 = com.larus.bmhome.chat.bean.d.x(r10);
        if (r11.isEmpty() == true) goto L98;
        IMMsgExt r0 = new IMMsgExt();
        r0.putAll(r11);
        Object r2 = "";
        if (com.larus.utils.o0.d(r11.getBrief()) == false) goto L11;
        String r1 = g2a.d.b(r11.getBrief());
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        r0.setBrief(r1);
    L11:
        boolean r3 = false;
        Object r6 = null;
        if (com.larus.utils.o0.d(r11.getSuggestPrompt()) == false) goto L46;
        String r4 = r11.getSuggestPrompt();
        if (r4 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        String r5 = null;
    L42:
        if (r5 != null) goto L44;
        r5 = "";
    L44:
        r0.put("sp", r5);
        goto L46
    L22:
        Gson r8 = HttpExtKt.f;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L36
        List r12 = (List) r8.fromJson(r4, new g().getType());     // Catch: Throwable -> L36
        if (r12 == null) goto L33;
        List r13 = r12;     // Catch: Throwable -> L36
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Throwable -> L36
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L36
    L27:
        if (r15.hasNext() == false) goto L32;
        String r16 = g2a.d.b((String) r15.next());     // Catch: Throwable -> L36
        if (r16 != null) goto L31;
        r16 = "";
    L31:
        r14.add(r16);     // Catch: Throwable -> L36
        goto L27
    L32:
        String r17 = r8.toJson(r14);     // Catch: Throwable -> L36
    L34:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r18) == false) goto L41;
        r18 = null;
    L41:
        r5 = (String) r18;
        goto L42
    L33:
        r17 = null;
    L36:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L16:
        if (r4.length() == 0) goto L19;
        r7 = false;
    L46:
        if (com.larus.utils.o0.d(r11.getSuggestItems()) == false) goto L52;
        String r20 = b(r11.getSuggestItems());
        if (r20 != null) goto L50;
        r20 = "";
    L50:
        r0.put("suggest_items", r20);
    L52:
        if (com.larus.utils.o0.d(r11.getSuggestItemsV2()) == false) goto L58;
        String r21 = b(r11.getSuggestItemsV2());
        if (r21 != null) goto L56;
        r21 = "";
    L56:
        r0.put("suggest_items_v2", r21);
    L58:
        if (com.larus.utils.o0.d(r11.getSuggestV2Prompt()) == false) goto L89;
        String r110 = r11.getSuggestV2Prompt();
        if (r110 != null) goto L62;
    L63:
        r3 = true;
    L64:
        if (r3 == true) goto L84;
        Gson r22 = HttpExtKt.f;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L77
        List r111 = (List) r22.fromJson(r110, new h().getType());     // Catch: Throwable -> L77
        if (r111 == null) goto L74;
        List r112 = r111;     // Catch: Throwable -> L77
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));     // Catch: Throwable -> L77
        Iterator r113 = r112.iterator();     // Catch: Throwable -> L77
    L71:
        if (r113.hasNext() == false) goto L73;
        PromptContent.SuggestV2 r25 = (PromptContent.SuggestV2) r113.next();     // Catch: Throwable -> L77
        r25.setContent(g2a.d.b(r25.getContent()));     // Catch: Throwable -> L77
        r24.add(Unit.INSTANCE);     // Catch: Throwable -> L77
        goto L71
    L73:
        String r114 = r22.toJson(r24);     // Catch: Throwable -> L77
    L75:
        Object r115 = Result.constructor-impl(r114);     // Catch: Throwable -> L77
    L80:
        if (Result.isFailure-impl(r115) == true) goto L83;
        r6 = r115;
    L83:
        r6 = (String) r6;
        goto L84
    L74:
        r114 = null;
    L77:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
    L84:
        if (r6 == null) goto L87;
        r2 = r6;
    L87:
        r0.put("sp_v2", r2);
        goto L89
    L62:
        if (r110.length() != 0) goto L64;
    L89:
        return r0;
    L98:
        return r11;
    }

    public static final String b(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Object r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        Gson r2 = HttpExtKt.f;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        List r6 = (List) r2.fromJson(r5, new a().getType());     // Catch: Throwable -> L22
        if (r6 == null) goto L19;
        List r7 = r6;     // Catch: Throwable -> L22
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L22
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L22
    L16:
        if (r8.hasNext() == false) goto L18;
        PromptContent.SuggestItem r9 = (PromptContent.SuggestItem) r8.next();     // Catch: Throwable -> L22
        r9.setSuggest(g2a.d.b(r9.getSuggest()));     // Catch: Throwable -> L22
        r4.add(Unit.INSTANCE);     // Catch: Throwable -> L22
        goto L16
    L18:
        String r10 = r2.toJson(r4);     // Catch: Throwable -> L22
    L20:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r11) == true) goto L29;
        r1 = r11;
    L29:
        return (String) r1;
    L19:
        r10 = null;
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
