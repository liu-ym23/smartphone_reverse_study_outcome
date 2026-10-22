package com.larus.doc.impl.crowdtest;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocCrowdTestHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Message r15, String r16) {
        if (r15 == null) goto L5;
        Map r0 = r15.getBusinessExt();
    L7:
        if (r0 != null) goto L10;
        FLogger.a.i("DocCrowdTestHelper", "ext is null, return");
        return;
    L10:
        boolean r3 = true;
        if (d.b0(r15) == false) goto L32;
        String r2 = (String) r0.get("real_selected_index");
        if (r2 == null) goto L15;
        Integer r4 = StringsKt.toIntOrNull(r2);
    L16:
        if (r4 != null) goto L32;
        String r5 = (String) r0.get("sub_group_full_single_text");
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L32;
        String r7 = (String) r0.get("all_sub_group_received");
        if (r7 != null) goto L27;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == false) goto L32;
        boolean r9 = true;
    L33:
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("isTesting=");
        r11.append(r9);
        r11.append(", isCrowdTest=");
        r11.append(d.b0(r15));
        r11.append(", index=");
        String r12 = (String) r0.get("real_selected_index");
        if (r12 == null) goto L36;
        Integer r13 = StringsKt.toIntOrNull(r12);
    L37:
        r11.append(r13);
        r11.append(", fullSingleText=");
        String r14 = (String) r0.get("sub_group_full_single_text");
        if (r14 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        r11.append(r17);
        r11.append(", allSubGroupReceived=");
        String r1 = (String) r0.get("all_sub_group_received");
        if (r1 != null) goto L46;
    L48:
        r3 = false;
    L49:
        r11.append(r3);
        r10.i("DocCrowdTestHelper", r11.toString());
        if (r9 == false) goto L65;
        Integer r18 = com.larus.im.bean.message.a.M(r15);
        if (r18 == null) goto L54;
        int r20 = r18.intValue();
    L55:
        String r21 = String.valueOf(r20);
        LruCache r22 = ko8.a.a;
        if (r16 != null) goto L58;
        String r23 = "";
    L59:
        String r24 = r15.getMessageId();
        if (r24 != null) goto L62;
        String r25 = "";
    L63:
        Intrinsics.checkNotNullParameter(r21, "result");
        Intrinsics.checkNotNullParameter(r15, "data");
        IAIChatControlTraceService.a.hc(r21, r15, r23, r25, "doc_card");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DocCrowdTestHelper$trySubmitCrowdTestSelectionOnDocCreate$1(r15, r20, null), 2, null);
        return;
    L62:
        r25 = r24;
        goto L63
    L58:
        r23 = r16;
        goto L59
    L54:
        r20 = 0;
        goto L55
    L65:
        return;
    L46:
        if (Boolean.parseBoolean(r1) != true) goto L48;
    L40:
        if (Boolean.parseBoolean(r14) != true) goto L42;
        r17 = true;
        goto L43
    L36:
        r13 = null;
        goto L37
    L27:
        if (Boolean.parseBoolean(r7) != true) goto L29;
        r8 = true;
        goto L30
    L20:
        if (Boolean.parseBoolean(r5) != true) goto L22;
        r6 = true;
        goto L23
    L15:
        r4 = null;
    L32:
        r9 = false;
        goto L33
    L5:
        r0 = null;
        goto L7
    }
}
