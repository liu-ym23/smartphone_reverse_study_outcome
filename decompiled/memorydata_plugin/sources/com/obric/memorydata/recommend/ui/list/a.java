package com.obric.memorydata.recommend.ui.list;

import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/BounceEdgeEffectFactory;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$EdgeEffectFactory;", "isVertical", "", "<init>", "(Z)V", "()Z", "createEdgeEffect", "Landroid/widget/EdgeEffect;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "direction", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends RecyclerView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12697a;

    public a() {
        this(false, 1, null);
    }

    public a(boolean r1) {
        this.f12697a = r1;
    }

    public /* synthetic */ a(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }
}
