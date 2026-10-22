package com.obric.memorydata.memory.ui.automemory;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.fragment.app.Fragment;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"getContentTopPadding", "", "Landroidx/fragment/app/Fragment;", "DEFAULT_COLLECTION_CONTENT_TOP_PADDING_DP", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {
    public static final /* synthetic */ int a(Fragment r0) {
        return b(r0);
    }

    private static final int b(Fragment r2) {
        Fragment r3 = r2.getParentFragment();
        if (ZeusTransformUtils.instanceOf(r3, AutoMemoryTaskFragment.class) == false) goto L5;
        AutoMemoryTaskFragment r4 = (AutoMemoryTaskFragment) ZeusTransformUtils.preCheckCast(r3, AutoMemoryTaskFragment.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L9;
        return r4.getCollectionListTopPadding();
    L9:
        return MathKt.roundToInt(TypedValue.applyDimension(1, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, Resources.getSystem().getDisplayMetrics()));
    L5:
        r4 = null;
        goto L6
    }
}
