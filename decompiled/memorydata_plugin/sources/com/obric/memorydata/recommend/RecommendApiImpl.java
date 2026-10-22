package com.obric.memorydata.recommend;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.recommend.guide.ScreenObservationGuideFeatureActivity;
import com.obric.memorydata.recommend.settings.ScreenObservationSettingsActivity;
import com.obric.memorydata.recommend.settings.g;
import com.obric.memorydata.recommend.settings.o;
import com.obric.memorydata.recommend.settings.p;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.recommend.ui.list.ContextItemType;
import com.obric.memorydata.recommend.ui.rule.BlockMemoryContentActivity;
import com.obric.memorydata.recommend.ui.rule.BlockMemoryContentViewModel;
import com.obric.memorydata.recommend.ui.rule.d;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J(\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010%H\u0016¨\u0006&"}, d2 = {"Lcom/obric/memorydata/recommend/RecommendApiImpl;", "Lcom/obric/memorydata/recommend/IRecommendApi;", "<init>", "()V", "getInstance", "getRealtimeContext", "", "type", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openRecommendMemorySettings", "", "context", "Landroid/content/Context;", "screenObservationEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "refreshScreenObservationEnabled", "screenObservationEnabledApps", "", "getScreenObservationCellularEnabled", "screenObservationCellularEnabled", "saveScreenObservationCellularEnabled", "enabled", "refreshEnhancedTimelinessTaskConditions", "getBlockMemoryRuleSnapshots", "", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "openBlockMemorySettings", "saveScreenObservationEnabled", "getScreenObservationConfigured", "saveScreenObservationConfigured", "configured", "showBlockMemoryDialog", "memoryContent", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDeleteCallback", "Lkotlin/Function0;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendApiImpl implements IRecommendApi {
    public static final RecommendApiImpl INSTANCE = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class a implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f12491a;

        a(Continuation<? super String> r3) {
            this.f12491a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
            Continuation<String> r1 = this.f12491a;
            Result.Companion r0 = Result.Companion;
            r1.resumeWith(Result.m1421constructorimpl(r2));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new RecommendApiImpl();
    }

    private RecommendApiImpl() {
    }

    @JvmStatic
    public static final RecommendApiImpl getInstance() {
        return INSTANCE;
    }

    private static final ContextItemType getRealtimeContext$lambda$0(String r0) {
        return ContextItemType.valueOf(r0);
    }

    public static /* synthetic */ ContextItemType lambda$vzrGnFfYsM3a1Zc7QCZdjiuZDq8(String r0) {
        return getRealtimeContext$lambda$0(r0);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public List<com.obric.memorydata.recommend.a> getBlockMemoryRuleSnapshots() {
        return g.f12602a.a(BlockMemoryContentViewModel.Companion.a());
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public Object getRealtimeContext(final String r4, Continuation<? super String> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ContextItemType r6 = (ContextItemType) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$RecommendApiImpl$vzrGnFfYsM3a1Zc7QCZdjiuZDq8(r4), 1, null), ContextItemType.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return "";
    L6:
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r3));
        new com.obric.memorydata.recommend.context.a(r6, (Function1) ZeusTransformUtils.preCheckCast(new a((Continuation) ZeusTransformUtils.preCheckCast(r7, Continuation.class, "com.obric.memorydata.plugin")), Function1.class, "com.obric.memorydata.plugin")).a();
        Object r8 = r7.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L9:
        return r8;
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public boolean getScreenObservationCellularEnabled() {
        return o.f12616a.b();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public boolean getScreenObservationConfigured() {
        return t.f12630a.p();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void openBlockMemorySettings(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        BlockMemoryContentActivity.Companion.a(r1);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void openRecommendMemorySettings(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (t.f12630a.p() == false) goto L5;
        ScreenObservationSettingsActivity.a.a(ScreenObservationSettingsActivity.Companion, r3, false, 2, null);
        return;
    L5:
        ScreenObservationGuideFeatureActivity.a.a(ScreenObservationGuideFeatureActivity.Companion, r3, false, 2, null);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void refreshEnhancedTimelinessTaskConditions() {
        p.f12618a.b();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void refreshScreenObservationEnabled() {
        t.f12630a.h();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void saveScreenObservationCellularEnabled(boolean r1) {
        o.f12616a.a(r1);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void saveScreenObservationConfigured(boolean r1) {
        t.f12630a.c(r1);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void saveScreenObservationEnabled(boolean r1) {
        com.obric.memorydata.recommend.feature.a r0 = com.obric.memorydata.recommend.feature.a.f12505a;
        if (r1 == false) goto L5;
        r0.c();
        return;
    L5:
        r0.d();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public ar<Boolean> screenObservationCellularEnabled() {
        return o.f12616a.a();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public ar<Boolean> screenObservationEnabled() {
        return t.f12630a.e();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public Set<String> screenObservationEnabledApps() {
        return t.f12630a.d();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void showBlockMemoryDialog(String r11, FragmentActivity r12, Function0<Unit> r13) {
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r12, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "memoryContent");
        Intrinsics.checkNotNullParameter(r2, "activity");
        new d(r2, true, r11, r5, null, false, 48, null).a();
    }
}
