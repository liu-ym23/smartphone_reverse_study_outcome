package com.obric.memorydata.recommend;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096A¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fH\u0096\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0096\u0001J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0096\u0001J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001eH\u0096\u0001J)\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010$H\u0096\u0001¨\u0006%"}, d2 = {"Lcom/obric/memorydata/recommend/RecommendApi;", "Lcom/obric/memorydata/recommend/IRecommendApi;", "<init>", "()V", "getBlockMemoryRuleSnapshots", "", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "getRealtimeContext", "", "type", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenObservationCellularEnabled", "", "getScreenObservationConfigured", "openBlockMemorySettings", "", "context", "Landroid/content/Context;", "openRecommendMemorySettings", "refreshEnhancedTimelinessTaskConditions", "refreshScreenObservationEnabled", "saveScreenObservationCellularEnabled", "enabled", "saveScreenObservationConfigured", "configured", "saveScreenObservationEnabled", "screenObservationCellularEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "screenObservationEnabled", "screenObservationEnabledApps", "", "showBlockMemoryDialog", "memoryContent", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDeleteCallback", "Lkotlin/Function0;", "recommend_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendApi implements IRecommendApi {
    public static final RecommendApi INSTANCE = null;
    private final /* synthetic */ IRecommendApi $$delegate_0;

    static {
        INSTANCE = new RecommendApi();
    }

    private RecommendApi() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IRecommendApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IRecommendApi) ZeusTransformUtils.preCheckCast(r0, IRecommendApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public List<a> getBlockMemoryRuleSnapshots() {
        return this.$$delegate_0.getBlockMemoryRuleSnapshots();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public Object getRealtimeContext(String r3, Continuation<? super String> r4) {
        Continuation<? super String> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return this.$$delegate_0.getRealtimeContext(r3, r5);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public boolean getScreenObservationCellularEnabled() {
        return this.$$delegate_0.getScreenObservationCellularEnabled();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public boolean getScreenObservationConfigured() {
        return this.$$delegate_0.getScreenObservationConfigured();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void openBlockMemorySettings(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.$$delegate_0.openBlockMemorySettings(r4);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void openRecommendMemorySettings(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.$$delegate_0.openRecommendMemorySettings(r4);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void refreshEnhancedTimelinessTaskConditions() {
        this.$$delegate_0.refreshEnhancedTimelinessTaskConditions();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void refreshScreenObservationEnabled() {
        this.$$delegate_0.refreshScreenObservationEnabled();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void saveScreenObservationCellularEnabled(boolean r1) {
        this.$$delegate_0.saveScreenObservationCellularEnabled(r1);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void saveScreenObservationConfigured(boolean r1) {
        this.$$delegate_0.saveScreenObservationConfigured(r1);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void saveScreenObservationEnabled(boolean r1) {
        this.$$delegate_0.saveScreenObservationEnabled(r1);
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public ar<Boolean> screenObservationCellularEnabled() {
        return this.$$delegate_0.screenObservationCellularEnabled();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public ar<Boolean> screenObservationEnabled() {
        return this.$$delegate_0.screenObservationEnabled();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public Set<String> screenObservationEnabledApps() {
        return this.$$delegate_0.screenObservationEnabledApps();
    }

    @Override // com.obric.memorydata.recommend.IRecommendApi
    public void showBlockMemoryDialog(String r3, FragmentActivity r4, Function0<Unit> r5) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "memoryContent");
        Intrinsics.checkNotNullParameter(r6, "activity");
        this.$$delegate_0.showBlockMemoryDialog(r3, r6, r7);
    }
}
