package com.larus.bmhome.double_post.viewholder;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.searchmixedmedia.RatioMode;
import com.larus.bmhome.searchmixedmedia.SearchMixedMediaItemView;
import com.larus.bmhome.video.Content;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.utils.e1;
import ip8.e;
import ip8.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lp8.a;
import lp8.b;
import lp8.c;
import lp8.h;
import pr8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/double_post/viewholder/AwemeRecommendContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/bmhome/double_post/viewholder/IAwemeRecommendViewHolder;", "view", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaItemView;", "<init>", "(Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaItemView;)V", "data", "Lcom/larus/bmhome/video/Content;", "onViewExposeLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Landroid/view/View;", "getOnViewExposeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "clickX", "", "clickY", "screenPos", "", "isInit", "", "tryObserveExpose", "", "bindData", "position", "", "dependency", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommendAdapterDependency;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendContentViewHolder extends RecyclerView.ViewHolder implements h {
    public static final /* synthetic */ int h = 0;
    public final SearchMixedMediaItemView a;
    public Content b;
    public final MutableLiveData<Pair<Content, View>> c;
    public float d;
    public float e;
    public final int[] f;
    public boolean g;

    public AwemeRecommendContentViewHolder(SearchMixedMediaItemView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r2;
        this.c = new MutableLiveData();
        this.f = new int[2];
    }

    @Override // lp8.h
    public final void n2(final Content r5, f r6) {
        this.b = r5;
        boolean r3 = false;
        this.a.a(d.a(r5), RatioMode.DYNAMIC, false);
        final e r0 = r6.e();
        if (r0 == null) goto L5;
        e1.d(this.a, new a(r0, r5));
        this.a.setOnLongClickListener(new b(r0, r5, this));
    L5:
        this.a.setOnTouchListener(new c(this));
        if (r6.b() != true) goto L8;
        r3 = true;
    L8:
        if (r3 == true) goto L10;
        return;
    L10:
        if (this.g == true) goto L15;
        this.g = true;
        ExposureTrackerExtKt.a(this.a, new lp8.d(this));
        return;
    }
}
