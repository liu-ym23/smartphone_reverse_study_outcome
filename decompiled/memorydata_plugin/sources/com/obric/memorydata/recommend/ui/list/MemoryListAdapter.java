package com.obric.memorydata.recommend.ui.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.obric.memorydata.ui.recyclerview.OuiPagingDataAdapter;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryListAdapter;", "Lcom/obric/memorydata/ui/recyclerview/OuiPagingDataAdapter;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryItemViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryListAdapter extends OuiPagingDataAdapter<f, j<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f12649a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryListAdapter$Companion;", "", "<init>", "()V", "TAG", "", "DiffCallback", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryListAdapter$Companion$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class DiffCallback extends DiffUtil.ItemCallback<f> {
            public DiffCallback() {
            }

            /* JADX INFO: renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
            public boolean areContentsTheSame2(f r8, f r9) {
                Intrinsics.checkNotNullParameter(r8, "oldItem");
                Intrinsics.checkNotNullParameter(r9, "newItem");
                if (ZeusTransformUtils.instanceOf(r8, f.b.class) == false) goto L13;
                if (ZeusTransformUtils.instanceOf(r9, f.b.class) == false) goto L13;
                if (((f.b) ZeusTransformUtils.preCheckCast(r8, f.b.class, "com.obric.memorydata.plugin")).a().id != ((f.b) ZeusTransformUtils.preCheckCast(r9, f.b.class, "com.obric.memorydata.plugin")).a().id) goto L32;
                if (((f.b) ZeusTransformUtils.preCheckCast(r8, f.b.class, "com.obric.memorydata.plugin")).a().updateTime != ((f.b) ZeusTransformUtils.preCheckCast(r9, f.b.class, "com.obric.memorydata.plugin")).a().updateTime) goto L32;
                return true;
            L32:
                return false;
            L13:
                if (ZeusTransformUtils.instanceOf(r8, f.c.class) == false) goto L22;
                if (ZeusTransformUtils.instanceOf(r9, f.c.class) == false) goto L22;
                if (((f.c) ZeusTransformUtils.preCheckCast(r8, f.c.class, "com.obric.memorydata.plugin")).a().id != ((f.c) ZeusTransformUtils.preCheckCast(r9, f.c.class, "com.obric.memorydata.plugin")).a().id) goto L32;
                if (((f.c) ZeusTransformUtils.preCheckCast(r8, f.c.class, "com.obric.memorydata.plugin")).a().updateTime != ((f.c) ZeusTransformUtils.preCheckCast(r9, f.c.class, "com.obric.memorydata.plugin")).a().updateTime) goto L32;
                return true;
            L22:
                if (ZeusTransformUtils.instanceOf(r8, f.d.class) == false) goto L31;
                if (ZeusTransformUtils.instanceOf(r9, f.d.class) == false) goto L31;
                if (((f.d) ZeusTransformUtils.preCheckCast(r8, f.d.class, "com.obric.memorydata.plugin")).a().id != ((f.d) ZeusTransformUtils.preCheckCast(r9, f.d.class, "com.obric.memorydata.plugin")).a().id) goto L32;
                if (((f.d) ZeusTransformUtils.preCheckCast(r8, f.d.class, "com.obric.memorydata.plugin")).a().updatedAt != ((f.d) ZeusTransformUtils.preCheckCast(r9, f.d.class, "com.obric.memorydata.plugin")).a().updatedAt) goto L32;
                return true;
            L31:
                return Intrinsics.areEqual(r8, r9);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public /* synthetic */ boolean areContentsTheSame(f r3, f r4) {
                return areContentsTheSame2((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: areItemsTheSame, reason: avoid collision after fix types in other method */
            public boolean areItemsTheSame2(f r5, f r6) {
                Intrinsics.checkNotNullParameter(r5, "oldItem");
                Intrinsics.checkNotNullParameter(r6, "newItem");
                if (ZeusTransformUtils.instanceOf(r5, f.b.class) == false) goto L11;
                if (ZeusTransformUtils.instanceOf(r6, f.b.class) == false) goto L11;
                if (((f.b) ZeusTransformUtils.preCheckCast(r5, f.b.class, "com.obric.memorydata.plugin")).a().id != ((f.b) ZeusTransformUtils.preCheckCast(r6, f.b.class, "com.obric.memorydata.plugin")).a().id) goto L26;
                return true;
            L26:
                return false;
            L11:
                if (ZeusTransformUtils.instanceOf(r5, f.c.class) == false) goto L18;
                if (ZeusTransformUtils.instanceOf(r6, f.c.class) == false) goto L18;
                if (((f.c) ZeusTransformUtils.preCheckCast(r5, f.c.class, "com.obric.memorydata.plugin")).a().id != ((f.c) ZeusTransformUtils.preCheckCast(r6, f.c.class, "com.obric.memorydata.plugin")).a().id) goto L26;
                return true;
            L18:
                if (ZeusTransformUtils.instanceOf(r5, f.d.class) == false) goto L25;
                if (ZeusTransformUtils.instanceOf(r6, f.d.class) == false) goto L25;
                if (((f.d) ZeusTransformUtils.preCheckCast(r5, f.d.class, "com.obric.memorydata.plugin")).a().id != ((f.d) ZeusTransformUtils.preCheckCast(r6, f.d.class, "com.obric.memorydata.plugin")).a().id) goto L26;
                return true;
            L25:
                return Intrinsics.areEqual(r5, r6);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public /* synthetic */ boolean areItemsTheSame(f r3, f r4) {
                return areItemsTheSame2((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin"));
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12649a = new Companion(null);
    }

    public MemoryListAdapter() {
        super((DiffUtil.ItemCallback) ZeusTransformUtils.preCheckCast(new Companion.DiffCallback(), DiffUtil.ItemCallback.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r4) {
        f r0 = (f) ZeusTransformUtils.preCheckCast(b(r4), f.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        MemoryListItemType r1 = g.a(r0);
        if (r1 == null) goto L8;
        return r1.ordinal();
    L8:
        return super.a(r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(j<?> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        f r1 = (f) ZeusTransformUtils.preCheckCast(b(r3), f.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r2.a(r1);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4);
    }

    public j<?> b(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return j.f12710a.a(r1, r2);
    }
}
