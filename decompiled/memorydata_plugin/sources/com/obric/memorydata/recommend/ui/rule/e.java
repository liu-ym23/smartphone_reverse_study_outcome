package com.obric.memorydata.recommend.ui.rule;

import com.bytedance.crash.entity.EventBody;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0014\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ConflictWithViewPage2Handler;", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "<init>", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;Lcom/obric/oui/viewpager2/widget/ViewPager2;)V", "getRecyclerView", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getViewPager", "()Lcom/obric/oui/viewpager2/widget/ViewPager2;", EventBody.KEY_VALUE, "", "allowViewPager2Fling", "getAllowViewPager2Fling", "()Z", "setAllowViewPager2Fling", "(Z)V", "listener", "com/obric/memorydata/recommend/ui/rule/ConflictWithViewPage2Handler$listener$1", "Lcom/obric/memorydata/recommend/ui/rule/ConflictWithViewPage2Handler$listener$1;", "remove", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView f12745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f12746b;
    private boolean c;
    private final a d;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/rule/ConflictWithViewPage2Handler$listener$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f12747a;

        a(e r1) {
            this.f12747a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            super.a(r2, r3);
            if (r3 != 0) goto L5;
            ViewPager2 r4 = this.f12747a.a();
            if (r4 == null) goto L18;
            r4.setUserInputEnabled(this.f12747a.b());
            return;
        L18:
            return;
        L5:
            if (r3 != 1) goto L7;
        L9:
            ViewPager2 r1 = this.f12747a.a();
            if (r1 == null) goto L16;
            r1.setUserInputEnabled(false);
            return;
        L16:
            return;
        L7:
            if (r3 == 2) goto L9;
        }
    }

    public e(RecyclerView r2, ViewPager2 r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.f12745a = r2;
        this.f12746b = r3;
        this.c = true;
        a r4 = new a(this);
        this.d = r4;
        r2.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(r4, RecyclerView.m.class, "com.obric.memorydata.plugin"));
    }

    public final ViewPager2 a() {
        return this.f12746b;
    }

    public final boolean b() {
        return this.c;
    }

    public final void c() {
        this.f12745a.removeOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(this.d, RecyclerView.m.class, "com.obric.memorydata.plugin"));
    }
}
