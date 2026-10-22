package com.obric.aiproactive.ui.detail;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.ui.feedback.ProactiveValueTargetType;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\f\u001a\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000fH\u0000¨\u0006\u0012"}, d2 = {"updatedDetailRecommendationIfCurrent", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "current", AILabCheckPermissionTask.KEY_SOURCE, "updated", "resolveValueTargetType", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueTargetType;", "dto", "isAiProactiveRecommendation", "", "resolveAiProactiveRecommendationId", "", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;)Ljava/lang/Long;", "isKnownActionText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "resolveFeedbackActionForDetailReport", "action", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final ProactiveRecommendationDto a(ProactiveRecommendationDto r3, ProactiveRecommendationDto r4, ProactiveRecommendationDto r5) {
        Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "updated");
        if (r3 == null) goto L5;
        String r1 = r3.getRecommendId();
    L7:
        if (Intrinsics.areEqual(r1, r4.getRecommendId()) == true) goto L10;
        return null;
    L10:
        if (Intrinsics.areEqual(r3.getInspirationId(), r4.getInspirationId()) == true) goto L12;
        return null;
    L12:
        return r5;
    L5:
        r1 = null;
        goto L7
    }

    public static final ProactiveValueTargetType a(ProactiveRecommendationDto r1) {
        Intrinsics.checkNotNullParameter(r1, "dto");
        if (d.g(r1) == false) goto L8;
        if (d.d(r1) == false) goto L8;
        return ProactiveValueTargetType.ACTION_RESULT;
    L8:
        return ProactiveValueTargetType.SUGGESTION;
    }

    public static final String a(ProactiveRecommendationDto r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        Intrinsics.checkNotNullParameter(r4, "action");
        if (r3.getRecommendStatus() == 2) goto L5;
        return r4;
    L5:
        if (StringsKt.equals(r3.getInspirationFeedbackAction(), "ignore", true) == true) goto L7;
        return r4;
    L7:
        return "ignore";
    }

    public static final /* synthetic */ boolean a(String r0) {
        return b(r0);
    }

    public static final /* synthetic */ Long b(ProactiveRecommendationDto r0) {
        return e(r0);
    }

    private static final boolean b(String r1) {
        if (Intrinsics.areEqual(r1, "知道了") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "我知道了") == true) goto L10;
        if (Intrinsics.areEqual(r1, "已知晓") == true) goto L10;
        return false;
    }

    public static final /* synthetic */ boolean c(ProactiveRecommendationDto r0) {
        return d(r0);
    }

    private static final boolean d(ProactiveRecommendationDto r1) {
        return Intrinsics.areEqual(r1.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE);
    }

    private static final Long e(ProactiveRecommendationDto r4) {
        Long r0 = StringsKt.toLongOrNull(r4.getRecommendId());
        if (r0 == null) goto L12;
        long r2 = r0.longValue();
        if (d(r4) == true) goto L7;
        Long r1 = Long.valueOf(r2);
        ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (Intrinsics.areEqual(r4.getInspirationId(), r4.getRecommendId()) == true) goto L11;
        return null;
    L11:
        return r1;
    L7:
        return Long.valueOf(r2);
    L12:
        return null;
    }
}
