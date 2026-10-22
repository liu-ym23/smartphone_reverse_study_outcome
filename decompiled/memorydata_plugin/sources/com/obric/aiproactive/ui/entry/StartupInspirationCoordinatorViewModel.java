package com.obric.aiproactive.ui.entry;

import androidx.lifecycle.ViewModel;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "updatePendingInspirationId", "", "inspirationId", "", "resolveFromNow", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "batchId", "", "recommendations", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "resolveFromAllToday", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StartupInspirationCoordinatorViewModel extends ViewModel {
    private final kotlinx.coroutines.flow.ae<ac> _state;
    private final ar<ac> state;

    public StartupInspirationCoordinatorViewModel() {
        kotlinx.coroutines.flow.ae<ac> r0 = at.a(new ac(0, null, null, 7, null));
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
    }

    public final ar<ac> getState() {
        return this.state;
    }

    public final ae resolveFromAllToday(long r4, List<ProactiveRecommendationDto> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "recommendations");
        af r5 = ad.b((ac) ZeusTransformUtils.preCheckCast(this._state.c(), ac.class, "com.obric.memorydata.plugin"), r4, r7);
        this._state.b(r5.a());
        return r5.b();
    }

    public final ae resolveFromNow(long r4, List<ProactiveRecommendationDto> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "recommendations");
        af r5 = ad.a((ac) ZeusTransformUtils.preCheckCast(this._state.c(), ac.class, "com.obric.memorydata.plugin"), r4, r7);
        this._state.b(r5.a());
        return r5.b();
    }

    public final void updatePendingInspirationId(String r4) {
        kotlinx.coroutines.flow.ae<ac> r3 = this._state;
        r3.b(ad.a((ac) ZeusTransformUtils.preCheckCast(r3.c(), ac.class, "com.obric.memorydata.plugin"), r4));
    }
}
