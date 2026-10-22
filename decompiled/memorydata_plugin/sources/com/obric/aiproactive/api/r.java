package com.obric.aiproactive.api;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveFeedbackValue;", "", "<init>", "()V", "MIN", "", "MAX", "NOT_SELECTED_SENTINEL", "PRESETS", "", "getPRESETS", "()Ljava/util/List;", "isValid", "", EventBody.KEY_VALUE, "(Ljava/lang/Integer;)Z", "normalizeOrNull", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "toReportedAmount", "(Ljava/lang/Integer;)I", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f6271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f6272b = null;

    static {
        f6271a = new r();
        f6272b = CollectionsKt.listOf(new Integer[]{0, 1, 5, 10, 20});
    }

    private r() {
    }

    public final Integer a(Integer r4) {
        if (r4 == null) goto L12;
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        boolean r1 = false;
        if (r0 >= 0) goto L7;
    L9:
        if (r1 == false) goto L12;
        return r4;
    L7:
        if (r0 >= 10000) goto L9;
        r1 = true;
    L12:
        return null;
    }

    public final int b(Integer r1) {
        Integer r0 = a(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.intValue();
    }
}
