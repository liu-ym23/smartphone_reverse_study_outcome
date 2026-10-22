package com.larus.uaigc.instruction.widget;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import vz9.c;
import vz9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "disableGifAnim", "", "<init>", "(Landroid/view/View;Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;Z)V", "getItemView", "()Landroid/view/View;", "getCallback", "()Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "getDisableGifAnim", "()Z", "img", "Lcom/facebook/drawee/view/SimpleDraweeView;", "title", "Landroid/widget/TextView;", "selectedIcon", "Landroid/widget/ImageView;", "selectedColor", "", "selectedRoundParams", "Lcom/facebook/drawee/generic/RoundingParams;", "kotlin.jvm.PlatformType", "unSelectedRoundParams", "animatable", "Landroid/graphics/drawable/Animatable;", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "bindPayload", "payload", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter$ChangePayload$Status;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "startGifAnim", "stopGifAnim", "isFullyVisible", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageSelectorHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int h = 0;
    public final View a;
    public final d b;
    public final boolean c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final ImageView f;
    public Animatable g;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ ImageSelectorHolder a;

        public a(ImageSelectorHolder r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            super.onFinalImageSet(r2, (ImageInfo) r3, this.a.g);
            this.a.g = r4;
        }
    }

    public final boolean U3() {
        if (this.a.isShown() == true) goto L5;
        return false;
    L5:
        Rect r0 = new Rect();
        this.a.getLocalVisibleRect(r0);
        if (r0.top <= 0) goto L8;
        return false;
    L8:
        if (r0.bottom < this.a.getHeight()) goto L12;
        return true;
    L12:
        return false;
    }

    public final void V3() {
        if (this.c == false) goto L5;
        return;
    L5:
        Animatable r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L15;
        Animatable r2 = this.g;
        if (r2 == null) goto L16;
        r2.stop();
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r0.isRunning() != true) goto L10;
        r1 = true;
        goto L10
    }

    public final void T3(final w r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        this.e.setText(r6.b);
        Integer r0 = r6.s;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        SimpleDraweeView r1 = this.d;
        g1 r2 = r6.f;
        if (r2 == null) goto L16;
        String r3 = r2.b;
    L17:
        ImageLoaderKt.y(r1, r3, "custom_actionbar_icon_instruction", new vz9.b(this), 4);
        this.b.b(r6, getAdapterPosition());
        e1.d(this.a, new c(this, r6));
        return;
    L16:
        r3 = null;
        goto L17
    L11:
        if (r0.intValue() != 1) goto L13;
        e1.x(this.f);
        goto L13
    L6:
        if (r0.intValue() != 0) goto L8;
        e1.o(this.f);
        goto L13
    }

    public ImageSelectorHolder(View r2, d r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r2.findViewById(2131375080);
        this.e = (TextView) r2.findViewById(2131390830);
        this.f = (ImageView) r2.findViewById(2131374767);
        new RoundingParams().setCornersRadius(i5.m()).setBorder(ContextCompat.getColor(r2.getContext(), v19.c.b(2130972123, r2.getContext(), 2131103203)), i5.z());
        new RoundingParams().setCornersRadius(i5.m());
    }
}
