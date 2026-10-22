package com.obric.memorydata.recommend;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\b\u0010\r\u001a\u00020\u0007H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH&J\b\u0010\u0012\u001a\u00020\fH&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\fH&J*\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\fH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH&J\b\u0010\u001e\u001a\u00020\u0007H&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H&J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006#"}, d2 = {"Lcom/obric/memorydata/recommend/IRecommendApi;", "Lcom/bytedance/news/common/service/manager/IService;", "getRealtimeContext", "", "type", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openRecommendMemorySettings", "", "context", "Landroid/content/Context;", "screenObservationEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "refreshScreenObservationEnabled", "screenObservationEnabledApps", "", "saveScreenObservationEnabled", "enabled", "getScreenObservationConfigured", "saveScreenObservationConfigured", "configured", "showBlockMemoryDialog", "memoryContent", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDeleteCallback", "Lkotlin/Function0;", "getScreenObservationCellularEnabled", "screenObservationCellularEnabled", "saveScreenObservationCellularEnabled", "refreshEnhancedTimelinessTaskConditions", "getBlockMemoryRuleSnapshots", "", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "openBlockMemorySettings", "recommend_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IRecommendApi extends IService {
    List<a> getBlockMemoryRuleSnapshots();

    Object getRealtimeContext(String r1, Continuation<? super String> r2);

    boolean getScreenObservationCellularEnabled();

    boolean getScreenObservationConfigured();

    void openBlockMemorySettings(Context r1);

    void openRecommendMemorySettings(Context r1);

    void refreshEnhancedTimelinessTaskConditions();

    void refreshScreenObservationEnabled();

    void saveScreenObservationCellularEnabled(boolean r1);

    void saveScreenObservationConfigured(boolean r1);

    void saveScreenObservationEnabled(boolean r1);

    ar<Boolean> screenObservationCellularEnabled();

    ar<Boolean> screenObservationEnabled();

    Set<String> screenObservationEnabledApps();

    void showBlockMemoryDialog(String r1, FragmentActivity r2, Function0<Unit> r3);
}
