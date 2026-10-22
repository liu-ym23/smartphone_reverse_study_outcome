package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.chats.PutChatChatterByMentionResponse;
import com.ss.android.lark.pb.chats.PutChatChatterByMentionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "Lcom/ss/android/lark/pb/chats/PutChatChatterByMentionResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkChatServiceImplV2$putChatChattersByMention$1$1 extends Lambda implements Function1<PutChatChatterByMentionResponse, List<? extends String>> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<Long> $requestedChatterIds;
    final /* synthetic */ String $triggerMessageId;

    public ImSdkChatServiceImplV2$putChatChattersByMention$1$1(List<Long> r1, String r2, String r3) {
        this.$requestedChatterIds = r1;
        this.$chatId = r2;
        this.$triggerMessageId = r3;
        super(1);
    }

    public final List<String> invoke(PutChatChatterByMentionResponse r12) {
        Intrinsics.checkNotNullParameter(r12, "it");
        Map r13 = r12.mresults;
        if (r13 != null) goto L5;
        r13 = MapsKt.emptyMap();
    L5:
        List<Long> r0 = this.$requestedChatterIds;
        Intrinsics.checkNotNullParameter(r0, "requestedChatterIds");
        Intrinsics.checkNotNullParameter(r13, "results");
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        int r3 = 0;
        if (r2.hasNext() == false) goto L27;
        long r5 = ((Number) r2.next()).longValue();
        PutChatChatterByMentionResult r4 = (PutChatChatterByMentionResult) r13.get(Long.valueOf(r5));
        String r7 = String.valueOf(r5);
        if (r4 == null) goto L16;
        Long r8 = r4.mchatter_id;
        if (r8 == null) goto L16;
        if (r8.longValue() != r5) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
    L21:
        if (r3 != 0) goto L24;
        r7 = null;
    L24:
        if (r7 == null) goto L6;
        r1.add(r7);
        goto L6
    L19:
        if (Intrinsics.areEqual(r4.mjoin_result, Boolean.TRUE) == false) goto L21;
        r3 = 1;
    L16:
        r6 = false;
        goto L17
    L27:
        if (r13.isEmpty() == true) goto L35;
        Iterator r9 = r13.entrySet().iterator();
    L31:
        if (r9.hasNext() == false) goto L35;
        Map.Entry r10 = (Map.Entry) r9.next();
        if ((!Intrinsics.areEqual(((PutChatChatterByMentionResult) r10.getValue()).mchatter_id, (Long) r10.getKey())) == false) goto L31;
        r3 = r3 + 1;
    L35:
        Log.i("MentionAgentTrace", "PUT rsp chat=" + this.$chatId + " msg=" + this.$triggerMessageId + " entries=" + r13.size() + " joined=" + r1.size() + " mismatch=" + r3);
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((PutChatChatterByMentionResponse) r1);
    }
}
