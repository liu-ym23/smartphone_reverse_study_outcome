package com.obric.aiproactive.impl.livecard;

import androidx.core.app.NotificationCompat;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardTracker;", "", "<init>", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "resolveCardClickButtonType", "buttonType", "reportCardShow", "", NotificationCompat.CATEGORY_RECOMMENDATION, "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "reportCardClick", "reportCardClose", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f6485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f6486b = null;

    static {
        f6485a = new r();
        f6486b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private r() {
    }

    public static final /* synthetic */ String a(r r0, String r1) {
        return r0.a(r1);
    }

    private final String a(String r4) {
        int r3 = r4.hashCode();
        if (r3 == (-1834360967)) goto L16;
        if (r3 == (-1335224239)) goto L13;
        if (r3 == (-1190396462)) goto L10;
    L17:
        return "click_button";
    L10:
        if (r4.equals("ignore") == false) goto L17;
        return "ignore";
    L13:
        if (r4.equals(MemoryListActivity.JUMP_FROM_DETAIL) == false) goto L17;
        return MemoryListActivity.JUMP_FROM_DETAIL;
    L16:
        if (r4.equals("left_slide") == false) goto L17;
        return "ignore";
    }

    public final void a(ProactiveRecommendationDto r7) {
        Intrinsics.checkNotNullParameter(r7, NotificationCompat.CATEGORY_RECOMMENDATION);
        kotlinx.coroutines.i.a(f6486b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardTracker$reportCardShow$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(ProactiveRecommendationDto r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, NotificationCompat.CATEGORY_RECOMMENDATION);
        Intrinsics.checkNotNullParameter(r8, "buttonType");
        kotlinx.coroutines.i.a(f6486b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardTracker$reportCardClick$1(r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_RECOMMENDATION);
        a(r2, "ignore");
    }
}
