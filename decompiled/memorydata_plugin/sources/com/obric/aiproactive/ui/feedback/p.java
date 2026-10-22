package com.obric.aiproactive.ui.feedback;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"effectiveVote", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore$Vote;", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "voteStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class p {
    public static final ProactiveVoteStore.Vote a(ProactiveRecommendationDto r2, ProactiveVoteStore r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "voteStore");
        if (r3.c(r2.getInspirationId()) == false) goto L5;
        return null;
    L5:
        ProactiveVoteStore.Vote r4 = r3.a(r2.getInspirationId());
        if (r4 == null) goto L8;
        return r4;
    L8:
        String r5 = r2.getInspirationFeedbackAction();
        if (Intrinsics.areEqual(r5, "LIKE") == false) goto L12;
        return ProactiveVoteStore.Vote.LIKE;
    L12:
        if (Intrinsics.areEqual(r5, "DISLIKE") == true) goto L14;
        return null;
    L14:
        return ProactiveVoteStore.Vote.DISLIKE;
    }
}
