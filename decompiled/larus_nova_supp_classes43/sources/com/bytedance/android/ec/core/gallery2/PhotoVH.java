package com.bytedance.android.ec.core.gallery2;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.facebook.drawee.controller.BaseControllerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/PhotoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoVH extends TransitionViewHolder {
    public final TransitionPhotoDraweeView a;
    public final ECStatusView b;

    public static final class a extends BaseControllerListener<Object> {
        public final /* synthetic */ PhotoVH a;

        public a(PhotoVH r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r10) {
            super.onFailure(r1, r10);
            ECStatusView r11 = this.a.b;
            r11.setVisibility(0);
            b r12 = r11.a;
            if (r12 == null) goto L6;
            r12.e();
            return;
        }

        public final void onSubmit(String r1, Object r10) {
            super.onSubmit(r1, r10);
            this.a.b.c();
        }

        public final void onFinalImageSet(String r1, Object r10, Animatable r11) {
            super.onFinalImageSet(r1, r10, r11);
            this.a.b.a();
        }
    }

    public PhotoVH(View r10) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        super(r10);
        TransitionPhotoDraweeView r0 = r10.findViewById(2131382247);
        this.a = r0;
        ECStatusView r1 = (ECStatusView) r10.findViewById(2131371035);
        this.b = r1;
        r1.a();
        r1.b(r10.getContext(), null, null);
        r0.setControllerListener(new a(this));
    }
}
