package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.databinding.FragmentRecommendMemoryListBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"renderObservationBuildMemoryTips", "", "Lcom/obric/memorydata/memory/databinding/FragmentRecommendMemoryListBinding;", "tips", "Lcom/obric/memorydata/memory/ui/list/TipsData;", "loadingTipsAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryLoadingTipsAdapter;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class am {
    public static final void a(FragmentRecommendMemoryListBinding r7, bl r8, ab r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "loadingTipsAdapter");
        if (r8 == null) goto L6;
        String r3 = r8.a();
        if (r3 == null) goto L6;
    L7:
        if (r8 == null) goto L10;
        String r4 = r8.b();
        if (r4 == null) goto L10;
    L11:
        r7.memoryListEmptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        r7.memoryListEmptyDescription.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r10 = r7.memoryListEmptyDescription;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
        int r0 = 8;
    L15:
        r10.setVisibility(r0);
        boolean r11 = true;
        if (r8 != null) goto L18;
    L20:
        r11 = false;
    L21:
        if (r11 == true) goto L24;
        r4 = null;
    L24:
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        r9.a(r4);
        r9.e(0);
        return;
    L18:
        if (r8.c() != true) goto L20;
    L14:
        r0 = 0;
    L10:
        r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_description, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_description"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
    L6:
        r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        goto L7
    }
}
