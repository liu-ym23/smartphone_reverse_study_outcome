package com.obric.memorydata.recommend.guide;

import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.RecyclerView.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001#B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rH\u0016J&\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/recommend/guide/HeaderFooterWrapper;", "VH", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "originalAdapter", "<init>", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;)V", "getOriginalAdapter", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "headerView", "Landroid/view/View;", "footerView", "TYPE_HEADER", "", "TYPE_FOOTER", "setHeaderView", "", "view", "removeHeaderView", "setFooterView", "removeFooterView", "getItemCount", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getOriginalPosition", "wrapperPosition", "HeaderFooterHolder", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e<VH extends RecyclerView.v> extends RecyclerView.Adapter<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView.Adapter<VH> f12527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f12528b;
    private View c;
    private final int d;
    private final int e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/guide/HeaderFooterWrapper$HeaderFooterHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends RecyclerView.v {
        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public e(RecyclerView.Adapter<VH> r3) {
        Intrinsics.checkNotNullParameter(r3, "originalAdapter");
        this.f12527a = r3;
        this.d = 10000;
        this.e = 10001;
        r3.a((RecyclerView.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), RecyclerView.b.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ View a(e r0) {
        return r0.f12528b;
    }

    private final int b(int r1) {
        if (this.f12528b != null) goto L5;
        return r1;
    L5:
        return r1 - 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        if (this.f12528b == null) goto L7;
        if (r2 != 0) goto L7;
        return this.d;
    L7:
        if (this.c == null) goto L12;
        if (r2 != (d() - 1)) goto L12;
        return this.e;
    L12:
        return this.f12527a.a(b(r2));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != this.d) goto L7;
        View r2 = this.f12528b;
        Intrinsics.checkNotNull(r2);
        a r5 = new a(r2);
    L11:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r5, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L7:
        if (r4 != this.e) goto L10;
        View r6 = this.c;
        Intrinsics.checkNotNull(r6);
        r5 = new a(r6);
        goto L11
    L10:
        return this.f12527a.a(r3, r4);
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.f12528b = r2;
        f(0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        int r0 = a(r4);
        if (r0 != this.d) goto L5;
        return;
    L5:
        if (r0 == this.e) goto L12;
        if (r3 != null) goto L9;
        return;
    L9:
        int r5 = b(r4);
        this.f12527a.a(r3, r5);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r3, int r4, List<Object> r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        int r0 = a(r4);
        if (r0 != this.d) goto L5;
        return;
    L5:
        if (r0 == this.e) goto L12;
        if (r3 != null) goto L9;
        return;
    L9:
        int r7 = b(r4);
        this.f12527a.a(r3, r7, r6);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        if (this.f12528b == null) goto L5;
        int r0 = 1;
    L7:
        if (this.c == null) goto L10;
        r0 = r0 + 1;
    L10:
        return this.f12527a.d() + r0;
    L5:
        r0 = 0;
        goto L7
    }
}
