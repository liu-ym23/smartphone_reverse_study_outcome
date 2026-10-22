package com.bytedance.android.ec.core.gallery2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/GalleryAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryAdapter extends TransitionPagerAdapter<TransitionViewHolder> {
    public List<? extends l> a;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        List<? extends l> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public GalleryAdapter() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final int getItemViewType(int r10) {
        List<? extends l> r0 = this.a;
        if (r0 == null) goto L7;
        l r11 = (l) ListProtector.get(r0, r10);
        if (r11 == null) goto L7;
        Integer r12 = Integer.valueOf(r11.getType());
    L8:
        if (r12 == null) goto L13;
        r12.intValue();
        return 1;
    L13:
        return 1;
    L7:
        r12 = null;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        TransitionViewHolder r12 = (TransitionViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        List<? extends l> r0 = this.a;
        if (r0 == null) goto L13;
        k r13 = (l) ListProtector.get(r0, r11);
        if (r13 != null) goto L8;
        return;
    L8:
        if ((r12 instanceof PhotoVH) == false) goto L14;
        k r14 = r13;
        AbstractDraweeController r1 = Fresco.newDraweeControllerBuilder().setUri(r14.b).build();
        PhotoVH r15 = (PhotoVH) r12;
        r15.getClass();
        r15.a.setController(r1);
        if (r14.i == null) goto L15;
        r15.a.getHierarchy().setImage(r14.i, 1.0f, true);
        r15.a.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new PhotoVH(LayoutInflater.from(r10.getContext()).inflate(2131560593, r10, false));
    }
}
