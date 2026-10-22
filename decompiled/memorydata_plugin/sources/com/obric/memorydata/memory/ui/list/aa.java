package com.obric.memorydata.memory.ui.list;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.obric.memorydata.memory.databinding.MemoryLoadingTipsLayoutBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryLoadingTipViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/MemoryLoadingTipsLayoutBinding;", "<init>", "(Lcom/obric/memorydata/memory/databinding/MemoryLoadingTipsLayoutBinding;)V", "getBinding", "()Lcom/obric/memorydata/memory/databinding/MemoryLoadingTipsLayoutBinding;", "bind", "", "tipsString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryLoadingTipsLayoutBinding f11172a;

    public aa(MemoryLoadingTipsLayoutBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        this.f11172a = r4;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tipsString");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.f11172a.noMemoryTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        this.f11172a.noMemoryTips.getLayoutParams().height = MathKt.roundToInt(TypedValue.applyDimension(1, 78, Resources.getSystem().getDisplayMetrics()));
    L9:
        this.f11172a.noMemoryTips.requestLayout();
        return;
    L8:
        this.f11172a.noMemoryTips.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        this.f11172a.noMemoryTips.getLayoutParams().height = 0;
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
