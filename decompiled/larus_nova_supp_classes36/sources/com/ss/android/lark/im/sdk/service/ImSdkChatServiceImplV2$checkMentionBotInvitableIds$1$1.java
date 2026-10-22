package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.chats.CheckPutChatChatterResponse;
import com.ss.android.lark.pb.chats.CheckPutChatChatterResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "Lcom/ss/android/lark/pb/chats/CheckPutChatChatterResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkChatServiceImplV2$checkMentionBotInvitableIds$1$1 extends Lambda implements Function1<CheckPutChatChatterResponse, List<? extends String>> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ LinkedHashMap<Long, String> $requestedBotIds;

    public ImSdkChatServiceImplV2$checkMentionBotInvitableIds$1$1(LinkedHashMap<Long, String> r1, String r2) {
        this.$requestedBotIds = r1;
        this.$chatId = r2;
        super(1);
    }

    public final List<String> invoke(CheckPutChatChatterResponse r12) {
        Intrinsics.checkNotNullParameter(r12, "it");
        Map r13 = r12.mresults;
        if (r13 != null) goto L5;
        r13 = MapsKt.emptyMap();
    L5:
        LinkedHashMap<Long, String> r0 = this.$requestedBotIds;
        Intrinsics.checkNotNullParameter(r0, "requestedBotIds");
        Intrinsics.checkNotNullParameter(r13, "results");
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<Long, String>> r2 = r0.entrySet().iterator();
    L6:
        boolean r3 = true;
        int r4 = 0;
        if (r2.hasNext() == false) goto L25;
        Map.Entry<Long, String> r5 = r2.next();
        long r6 = r5.getKey().longValue();
        String r7 = r5.getValue();
        CheckPutChatChatterResult r8 = (CheckPutChatChatterResult) r13.get(Long.valueOf(r6));
        if (r8 == null) goto L16;
        Long r9 = r8.mchatter_id;
        if (r9 == null) goto L16;
        if (r9.longValue() != r6) goto L16;
    L17:
        if (r3 == true) goto L19;
    L21:
        r7 = null;
    L22:
        if (r7 == null) goto L6;
        r1.add(r7);
        goto L6
    L19:
        if (Intrinsics.areEqual(r8.mcheck_result, Boolean.TRUE) == false) goto L21;
    L16:
        r3 = false;
        goto L17
    L25:
        if (r13.isEmpty() == false) goto L27;
        int r10 = 0;
    L33:
        StringBuilder r11 = new StringBuilder("CHECK rsp chat=");
        r11.append(this.$chatId);
        r11.append(" entries=");
        r11.append(r13.size());
        r11.append(" pass=");
        Collection r14 = r13.values();
        if ((r14 instanceof Collection) == true) goto L36;
    L38:
        Iterator r15 = r14.iterator();
    L40:
        if (r15.hasNext() == false) goto L46;
        if (Intrinsics.areEqual(((CheckPutChatChatterResult) r15.next()).mcheck_result, Boolean.TRUE) == false) goto L40;
        r4 = r4 + 1;
        if (r4 >= 0) goto L40;
        CollectionsKt.throwCountOverflow();
    L46:
        r11.append(r4);
        r11.append(" allowed=");
        r11.append(r1.size());
        r11.append(" mismatch=");
        r11.append(r10);
        Log.i("MentionAgentTrace", r11.toString());
        return r1;
    L36:
        if (r14.isEmpty() == false) goto L38;
    L27:
        Iterator r16 = r13.entrySet().iterator();
        r10 = 0;
    L29:
        if (r16.hasNext() == false) goto L33;
        Map.Entry r17 = (Map.Entry) r16.next();
        if ((!Intrinsics.areEqual(((CheckPutChatChatterResult) r17.getValue()).mchatter_id, (Long) r17.getKey())) == false) goto L29;
        r10 = r10 + 1;
        goto L29
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((CheckPutChatChatterResponse) r1);
    }
}
