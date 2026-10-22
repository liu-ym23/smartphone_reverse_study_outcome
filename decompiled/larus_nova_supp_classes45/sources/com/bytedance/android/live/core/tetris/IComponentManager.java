package com.bytedance.android.live.core.tetris;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.componentx.schedule.BatchTogetherConditionManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.c;
import com.bytedance.android.live.core.tetris.componentx.schedule.j;
import com.bytedance.android.live.core.tetris.componentx.schedule.q;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import j70.f;
import j70.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/IComponentManager;", "Landroidx/lifecycle/LifecycleOwner;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IComponentManager extends LifecycleOwner {
    void C8();

    void L3(LayerDescriptorList r1, boolean r2, boolean r3, boolean r4);

    void X7(h<? extends h70.b> r1);

    void c5(c r1, q r2);

    com.bytedance.android.live.core.tetris.componentx.a config();

    void dd(LayerDescriptorList r1);

    void dl(f r1);

    Element<?> f2(f r1);

    void iS(c r1, ComponentSchedulingManager.ScenInfo r2, Map r3, e0 r4, j r5, q r6);

    <T extends LayerDelegate<? extends i70.a, ? extends h70.b>> T o4(f70.b r1, LayerIndex r2);

    void q6(List<? extends f> r1, Map<f70.b, List<f>> r2);

    void release();

    void rq(BatchTogetherConditionManager.BatchLoadConditionType r1);
}
