package com.bytedance.android.live.profit.vote;

import com.bytedance.android.live.profit.vote.model.VoteType;
import com.bytedance.android.livesdk.message.model.s7;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteUtilsKt {
    public static final iq2.a e() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(er2.b.class);
        Intrinsics.checkNotNull(r0);
        iq2.h r2 = ((com.bytedance.live.kmp.core.c) r0).getKtvRoomInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.c();
    }

    public static final boolean g() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(er2.b.class);
        Intrinsics.checkNotNull(r0);
        return ((com.bytedance.live.kmp.core.c) r0).yg();
    }

    public static final String b(com.bytedance.android.live.profit.vote.model.a r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$describe");
        StringBuilder r0 = new StringBuilder("VoteDto(vote_id=");
        r0.append(r10.getVoteId());
        r0.append(", status=");
        r0.append(r10.getStatus());
        r0.append(", vote_type=");
        r0.append(r10.getVoteType());
        r0.append(", time=");
        r0.append(r10.getCurrentTime());
        r0.append('/');
        r0.append(r10.getFinishTime());
        r0.append(", results=[");
        List<a> r12 = r10.getVoteItems();
        if (r12 == null) goto L7;
        List r13 = CollectionsKt.toList(r12);
        if (r13 == null) goto L7;
        String r14 = CollectionsKt.joinToString$default(r13, null, null, null, 0, null, VoteUtilsKt$describe$2.INSTANCE, 31, null);
    L8:
        r0.append(r14);
        r0.append("])");
        return r0.toString();
    L7:
        r14 = null;
        goto L8
    }

    public static final String c(s7 r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$describe");
        return "GiftVoteMessage(vote_id=" + r10.getVoteId() + ", msg_type=" + r10.getMsgType() + ", vote_type=" + r10.getVoteType() + ", time=" + r10.getCurrentTime() + '/' + r10.getFinishTime() + ", results=[" + CollectionsKt.joinToString$default(CollectionsKt.toList(r10.getResults()), null, null, null, 0, null, VoteUtilsKt$describe$1.INSTANCE, 31, null) + "])";
    }

    public static final String d(List<g> r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$describe");
        return CollectionsKt.joinToString$default(CollectionsKt.toList(r9), null, "[", "]", 0, null, VoteUtilsKt$describe$3.INSTANCE, 25, null);
    }

    public static final String f(g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$displayText");
        String r0 = r2.d;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        return r0;
    L8:
        return r2.c;
    L5:
        r1 = false;
        goto L6
    }

    public static final boolean h(b r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isKtvVote");
        if (r4.getVoteType() != VoteType.Ktv.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void i(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$putSongInfo");
        iq2.f r0 = e();
        if (r0 != null) goto L5;
        return;
    L5:
        iq2.f r1 = r0;
        r3.put("song_name", r1.c());
        r3.put("song_id", String.valueOf(r1.a()));
    }

    public static final VoteCompare a(g r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$compareTo");
        Intrinsics.checkNotNullParameter(r4, "rhs");
        long r0 = r3.a;
        long r5 = r4.a;
        if (r0 <= r5) goto L6;
        return VoteCompare.LeftWin;
    L6:
        if (r0 >= r5) goto L9;
        return VoteCompare.RightWin;
    L9:
        return VoteCompare.Draw;
    }

    public static final void j(Map<String, String> r5, b r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$putVoteInfo");
        Intrinsics.checkNotNullParameter(r6, "vote");
        Intrinsics.checkNotNullParameter(r6, "$this$isNormalVote");
        if (r6.getVoteType() != VoteType.Normal.getValue()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        String r7 = "gift_pk";
    L12:
        r5.put("vote_type", r7);
        return;
    L9:
        if (h(r6) == false) goto L11;
        r7 = "song_pk";
        goto L12
    L11:
        r7 = String.valueOf(r6.getVoteType());
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}
