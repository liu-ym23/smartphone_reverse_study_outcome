package com.ss.android.lark.chat.preview.components;

import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.preview.components.view.ImageContainerView;
import com.ss.android.lark.chat.preview.entity.component.property.ImageContainerProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.tangram.base.style.TCStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends q6c.e<ImageContainerProperty, ImageContainerView, r6c.a> {
    public final boolean f;

    public static final class a {
    }

    public static final class b extends SimpleTarget<Drawable> {
        public final ImageContainerView a;

        public b(ImageContainerView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }

        public final void onLoadCleared(Drawable r2) {
            this.a.setImageDrawable(r2);
        }

        public final void onLoadFailed(Drawable r2) {
            this.a.setImageDrawable(r2);
            Log.e("ImageContainerComponent", "image load failed");
        }

        public final void onLoadStarted(Drawable r2) {
            this.a.setImageDrawable(r2);
        }

        public final void onResourceReady(Object r2) {
            ImageContainerView r0 = this.a;
            r0.setImageDrawable((Drawable) r2);
            Log.e("ImageContainerComponent", "image load success");
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageContainerProperty.ContentMode.values().length];
            r0[ImageContainerProperty.ContentMode.SCALE_TO_FILL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ImageContainerProperty.ContentMode.SCALE_ASPECT_FIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ImageContainerProperty.ContentMode.SCALE_ASPECT_FILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ImageContainerProperty.ContentMode.CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final String i() {
        return "com.ss.android.lark.chat.preview.components.view.ImageContainerView";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r5) {
        Intrinsics.checkNotNullParameter(r5, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "size");
        return null;
    L5:
        return new ImageContainerView(r1.getContext(), null, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void update(ImageContainerView r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        ImageSet r0 = ((ImageContainerProperty) ((q6c.e) this).e).getBackground();
        if (r0 == null) goto L5;
        Image r1 = r0.getThumbnail();
    L6:
        boolean r3 = false;
        if (r1 != null) goto L12;
        StringBuilder r2 = new StringBuilder("thumbnail == null,bg:");
        if (((ImageContainerProperty) ((q6c.e) this).e).getBackground() == null) goto L11;
        r3 = true;
    L11:
        r2.append(r3);
        Log.w("ImageContainerComponent", r2.toString());
    L25:
        ImageContainerProperty.ContentMode r4 = ((ImageContainerProperty) ((q6c.e) this).e).getContentMode();
        if (r4 != null) goto L28;
        int r5 = -1;
    L30:
        if (r5 == (-1)) goto L43;
        if (r5 == 1) goto L42;
        if (r5 != 2) goto L34;
        ImageView.ScaleType r6 = ImageView.ScaleType.FIT_CENTER;
    L44:
        r9.setScaleType(r6);
        TCStyle r7 = ((q6c.b) this).c;
        if ((r7 instanceof Style) == false) goto L47;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Style.applyBackground$default((Style) r7, r9, null, 2, null);
        return;
    L47:
        r9.setBackground(null);
        return;
    L34:
        if (r5 != 3) goto L36;
        r6 = ImageView.ScaleType.CENTER_CROP;
        goto L44
    L36:
        if (r5 != 4) goto L39;
        r6 = ImageView.ScaleType.CENTER;
        goto L44
    L39:
        throw new NoWhenBranchMatchedException();
    L42:
        r6 = ImageView.ScaleType.FIT_XY;
        goto L44
    L43:
        r6 = ImageView.ScaleType.FIT_CENTER;
        goto L44
    L28:
        r5 = c.a[r4.ordinal()];
        goto L30
    L12:
        float r8 = (r1.getHeight() * 1.0f) / r1.getWidth();
        if (r9.getLayoutParams().width <= 0) goto L15;
        int r10 = r9.getLayoutParams().width;
    L17:
        if (r9.getLayoutParams().height <= 0) goto L19;
        int r11 = r9.getLayoutParams().height;
    L20:
        IRequestCreator r12 = ImageLoader.with(r9.getContext()).load(new EncryptImage(r1)).isAsync(this.f).override(r10, r11).dontAnimate(false);
        Object r13 = r9.getTag(2131373828);
        if ((r13 instanceof b) == false) goto L23;
        b r14 = (b) r13;
    L24:
        r12.into(r14);
        goto L25
    L23:
        r14 = new b(r9);
        r9.setTag(2131373828, r14);
        goto L24
    L19:
        Resources r15 = r9.getResources();
        r11 = (int) (WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).widthPixels * r8);
        goto L20
    L15:
        Resources r16 = r9.getResources();
        r10 = WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).widthPixels;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ void update(View r1) {
        update((ImageContainerView) r1);
    }

    public e(ImageContainerProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        g6b.a.InterfaceC0223a r5 = g6b.a.a;
        if (r5 == null) goto L5;
        r5.c();
    L5:
        this.f = false;
    }
}
