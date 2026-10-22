package com.obric.memorydata.memory.ui.detail;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarViewHolder;", "<init>", "()V", "dataList", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "submitList", "", Constants.KEY_LIST, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s extends RecyclerView.Adapter<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.obric.memorydata.memory.ui.data.a.c> f10874b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarAdapter$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10873a = new a(null);
    }

    public s() {
        this.f10874b = CollectionsKt.emptyList();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(t r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        RunLog.INSTANCE.debug("MemoryCalendarAdapter", "onBindViewHolder, position: " + r8 + ", item: " + this.f10874b.get(r8));
        View r3 = r7.c;
        ViewGroup.LayoutParams r4 = r7.c.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 != 0) goto L5;
        int r5 = 10;
    L6:
        r1.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics()));
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r7.b((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(this.f10874b.get(r8), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r5 = 4;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin"), r4);
    }

    public t b(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return t.f10875a.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f10874b.size();
    }
}
