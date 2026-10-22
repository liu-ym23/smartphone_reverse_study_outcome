package com.larus.bmhome.double_post.viewholder;

import android.view.ViewGroup;
import com.larus.bmhome.databinding.LarusCardAwemeRecommendEmptyBinding;
import com.larus.bmhome.video.Content;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.common_ui.view.ViewBindingHolder;
import ip8.b;
import ip8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lp8.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/double_post/viewholder/AwemeRecommendEmptyViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bmhome/double_post/viewholder/IAwemeRecommendViewHolder;", "viewBinding", "Lcom/larus/bmhome/databinding/LarusCardAwemeRecommendEmptyBinding;", "<init>", "(Lcom/larus/bmhome/databinding/LarusCardAwemeRecommendEmptyBinding;)V", "bindData", "", "data", "Lcom/larus/bmhome/video/Content;", "position", "", "dependency", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommendAdapterDependency;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendEmptyViewHolder extends ViewBindingHolder implements h {
    public final LarusCardAwemeRecommendEmptyBinding a;

    public AwemeRecommendEmptyViewHolder(LarusCardAwemeRecommendEmptyBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.a = r2;
    }

    @Override // lp8.h
    public final void n2(Content r5, f r6) {
        int r7 = ((b) r6).a.f;
        int r8 = (int) (((double) r7) * 1.62d);
        ShapeConstraintLayout r0 = this.a.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = r8 + i5.v();
        r1.width = r7 + i5.v();
        r0.setLayoutParams(r1);
    }
}
