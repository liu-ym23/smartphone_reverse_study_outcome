package com.obric.memorydata.memory.ui;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/ObservationMemorySourcePresentationPolicy;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/memory/ui/ObservationMemorySourcePresentation;", "productType", "", "shouldShowNewAuditoryDebugBadge", "", "isContextAwarenessPage", "isDebug", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10968a = null;

    static {
        f10968a = new i();
    }

    private i() {
    }

    public final h a(int r4) {
        if (r4 == 1005) goto L9;
        if (r4 == 1006) goto L11;
        return new h(ZeusTransformUtils.mapRes(R.string.memory_item_recommend_memory_data_text, TypedValues.Custom.S_STRING, "memory_item_recommend_memory_data_text"), ZeusTransformUtils.mapRes(R.drawable.screen_memory_tab_select_icon, "drawable", "screen_memory_tab_select_icon"));
    L11:
        return new h(ZeusTransformUtils.mapRes(R.string.memory_list_source_voice, TypedValues.Custom.S_STRING, "memory_list_source_voice"), ZeusTransformUtils.mapRes(R.drawable.ic_memory_source_voice, "drawable", "ic_memory_source_voice"));
    L9:
        return new h(ZeusTransformUtils.mapRes(R.string.memory_list_source_glasses, TypedValues.Custom.S_STRING, "memory_list_source_glasses"), ZeusTransformUtils.mapRes(R.drawable.ic_memory_source_glasses, "drawable", "ic_memory_source_glasses"));
    }

    public final boolean a(int r1, boolean r2, boolean r3) {
        if (r3 == false) goto L7;
        if (r2 == false) goto L7;
        if (r1 != 1006) goto L7;
        return true;
    L7:
        return false;
    }
}
