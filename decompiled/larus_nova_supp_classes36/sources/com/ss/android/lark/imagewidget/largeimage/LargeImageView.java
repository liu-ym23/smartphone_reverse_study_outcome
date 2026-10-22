package com.ss.android.lark.imagewidget.largeimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.GlideCommonUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.LogSafetyTools;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.imagewidget.largeimage.transform.CropAndRotationTransformation;
import com.ss.android.lark.imagewidget.largeimage.transform.WhiteBgTransformation;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageDecoder;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.RotateLoadingView;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nlb.e;
import nlb.g;
import olb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LargeImageView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public ImageView a;
    public SubsamplingScaleImageView b;
    public olb.a c;
    public g d;
    public c e;

    public class a implements SubsamplingScaleImageView.j {
        public a() {
        }

        @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.j
        public final PointF a(PointF r2) {
            return new PointF(0.0f, 0.0f);
        }

        @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.j
        public final float b(int r3, int r4, int r5, int r6) {
            if (r3 <= 0) goto L13;
            if (r4 <= 0) goto L13;
            if (r5 <= 0) goto L13;
            if (r6 <= 0) goto L13;
            float r7 = (r3 * 1.0f) / r5;
            float r8 = (r4 * 1.0f) / r6;
            if ((r6 / r5) <= 3) goto L12;
            return Math.max(r7, r8);
        L12:
            return Math.min(r7, r8);
        L13:
            return 1.0f;
        }
    }

    public class b extends rkb.b {
        public final /* synthetic */ g b;
        public final /* synthetic */ LargeImageView c;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r3) {
            LargeImageView r4 = this.c;
            g r0 = this.b;
            int r1 = LargeImageView.f;
            r4.s(r0);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r2) {
            Drawable r3 = (Drawable) r2;
            this.c.t(this.b);
        }

        public b(LargeImageView r1, ImageView r2, g r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }
    }

    public interface c {
        void a();

        void b();

        void c(int r1, ErrorResult r2);
    }

    public void setScaleImageViewInfo(g r1) {
    }

    public Drawable getImageDrawable() {
        if (this.a.getVisibility() != 0) goto L11;
        Drawable r0 = this.a.getDrawable();
        if (r0 == null) goto L11;
        if (r0.getConstantState() == null) goto L11;
        return r0.getConstantState().newDrawable();
    L11:
        return this.b.getImageDrawable();
    }

    public SubsamplingScaleImageView.j getSizeChangedStrategy() {
        return new a();
    }

    public final void v() {
        r("show error");
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        g r0 = this.d;
        Drawable r1 = null;
        if (r0 == null) goto L9;
        Drawable r2 = r0.b;
        if (r2 == null) goto L7;
        r1 = r2;
    L8:
        s(this.d);
        goto L9
    L7:
        r0.getClass();
    L9:
        this.a.setImageDrawable(r1);
    }

    public final void w() {
        if (this.c != null) goto L5;
        RotateLoadingView r0 = new RotateLoadingView(getContext());
        int r1 = UIUtils.dp2px(getContext(), 42.0f);
        addView(r0, new FrameLayout.LayoutParams(r1, r1, 17));
        this.c = new olb.a(r0);
    L5:
        olb.a r2 = this.c;
        r2.getClass();
        Log.i("LazyLoadingHelper", "showLoading");
        d.a(r2.b);
        d.a(r2.c);
        olb.c r3 = r2.b;
        d.a.postDelayed(r3, 250);
    }

    public ImageView getImageView() {
        return this.a;
    }

    public c getLoadPreviewListener() {
        return this.e;
    }

    public SubsamplingScaleImageView getScaleImageView() {
        return this.b;
    }

    public LargeImageView(Context r2) {
        this(r2, null);
    }

    public SubsamplingScaleImageView l(Context r2) {
        return new SubsamplingScaleImageView(r2);
    }

    public List<BitmapTransformation> m(g r4) {
        ArrayList r0 = new ArrayList();
        com.ss.android.lark.imagewidget.largeimage.transform.b r5 = r4.d;
        if (r5 == null) goto L5;
        r0.add(new CropAndRotationTransformation(r5.c, r5.b));
    L5:
        r0.add(new WhiteBgTransformation());
        return r0;
    }

    public final boolean n(g r3) {
        if (r3 == this.d) goto L6;
        r("result is not final load file: " + r3.a.getRealPath());
        return true;
    L6:
        return false;
    }

    public final void o(final g r3) {
        if (r3.a.toFile().canRead() == true) goto L6;
        r("file can not read, info: " + r3.a.getRealPath());
        return;
    L6:
        this.d = r3;
        RxScheduledExecutor.execInIO(new nlb.d(this, r3), new e(this));
    }

    public final void p(g r4) {
        r("loadAnimationDrawable");
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        IRequestCreator r0 = ImageLoader.with(getContext()).load(r4.a.toFile()).placeholder(r4.b).error(null).diskCacheStrategy(DiskCacheStrategy.NONE).dontAnimate(false);
        Iterator<BitmapTransformation> r1 = m(r4).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.transform(r1.next());
        goto L4
    L6:
        r0.into(new b(this, this.a, r4));
    }

    public final void r(String r2) {
        Log.i("LargeImageView", r2);
    }

    public final void s(g r3) {
        r("onLoadPreviewFail, info: " + r3.a.getRealPath());
        olb.a r4 = this.c;
        if (r4 == null) goto L5;
        r4.a();
    L5:
        c r5 = this.e;
        if (r5 == null) goto L9;
        r5.c(-20000, null);
        return;
    }

    public void setImageBitmap(Bitmap r3) {
        if (r3 != null) goto L4;
    L10:
        Log.e("LargeImageView", "setImageBitmap failed, bitmap is invalid");
        return;
    L4:
        if (r3.isRecycled() == true) goto L10;
        if (r3.getWidth() <= 0) goto L10;
        if (r3.getHeight() <= 0) goto L10;
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImage(qlb.a.a(r3));
    }

    public void setLoadPreviewListener(c r1) {
        this.e = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        super.setOnClickListener(r2);
        this.a.setOnClickListener(r2);
        this.b.setOnClickListener(r2);
    }

    @Override // android.view.View
    public void setOnGenericMotionListener(View.OnGenericMotionListener r2) {
        super.setOnGenericMotionListener(r2);
        this.a.setOnGenericMotionListener(r2);
        this.b.setOnGenericMotionListener(r2);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r2) {
        super.setOnLongClickListener(r2);
        this.a.setOnLongClickListener(r2);
        this.b.setOnLongClickListener(r2);
    }

    public final void t(g r3) {
        r("onLoadPreviewSuccess, info: " + r3.a.getRealPath());
        olb.a r4 = this.c;
        if (r4 == null) goto L5;
        r4.a();
    L5:
        c r5 = this.e;
        if (r5 == null) goto L9;
        r5.b();
        return;
    }

    public final void u(g r15) {
        File r0 = r15.a.toFile();
        File r1 = GlideCommonUtils.getDecryptFile(r0);
        if (r1 == null) goto L5;
        r15.a = VFSFiles.b.z(r1.getPath());
        r0 = r1;
    L5:
        r15.g = ImageUtils.c(r0);
        r15.h = ImageUtils.e(r0);
        com.ss.android.lark.imagewidget.largeimage.transform.b r2 = r15.d;
        if (r2 == null) goto L10;
        Rect r3 = r2.a;
        if (r3 == null) goto L10;
        r15.e = r3.width();
        r15.f = r15.d.a.height();
        return;
    L10:
        boolean r4 = r15.c;
        String r5 = r0.getPath();
        BitmapFactory.Options r6 = new BitmapFactory.Options();
        r6.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r0.getPath(), r6);
        int r7 = r6.outWidth;
        int r8 = r6.outHeight;
        if ((p.h(r0.getPath()) % 180) != 90) goto L14;
        r7 = r6.outHeight;
        r8 = r6.outWidth;
    L14:
        if (r4 == false) goto L18;
        if (r7 == 0) goto L22;
        if (r8 == 0) goto L22;
    L21:
        boolean r9 = false;
    L24:
        if (r9 == false) goto L26;
        Log.e("LargeImageHelper", "getImageResolution failed, width: " + r7 + ", height: " + r8);
        int r10 = nlb.c.g(this);
        int r11 = nlb.c.f(this);
        int[] r12 = ImageUtils.g(0, 0, r10, r11, r10 >> 2, r11 >> 2);
        r7 = r12[0];
        r8 = r12[1];
    L26:
        Log.i("LargeImageHelper", "getImageResolution, width: " + r7 + ", height: " + r8 + ", file: " + LogSafetyTools.a(r5));
        Pair r13 = new Pair(Integer.valueOf(r7), Integer.valueOf(r8));
        r15.e = ((Integer) r13.first).intValue();
        r15.f = ((Integer) r13.second).intValue();
        return;
    L22:
        r9 = true;
        goto L24
    L18:
        if (r7 <= 0) goto L22;
        if (r8 > 0) goto L21;
        goto L21
    }

    public LargeImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public void q(g r8, Bitmap r9) {
        r("start load large image");
        SubsamplingScaleImageView r0 = this.b;
        boolean r1 = r8.c;
        r0.setBitmapDecoderFactory(new nlb.a(MSkiaImageDecoder.class, r8, r1));
        r0.setRegionDecoderFactory(new nlb.b(MSkiaImageRegionDecoder.class, r8, r1));
        nlb.c.i(this.b, r8, r9);
        SubsamplingScaleImageView r10 = this.b;
        int r2 = r8.e;
        int r3 = r8.f;
        int r4 = nlb.c.g(r10);
        int r5 = nlb.c.f(r10);
        float r6 = nlb.c.b(r4, r5, r2, r3);
        float r7 = nlb.c.c(r4, r5, r2, r3);
        float r11 = nlb.c.d(r4, r5, r2, r3);
        Log.i("LargeImageHelper", "doubleTabScale:" + r6 + ", maxScale:" + r7 + ", minScale:" + r11);
        r10.setDoubleTapZoomScale(r6);
        r10.setMaxScale(r7);
        r10.M(r11, new PointF(0.0f, 0.0f));
        if ((r3 / r2) <= 3) goto L5;
        r10.setMinimumScaleType(1);
    L5:
        r10.setMinScale(r11);
        t(r8);
    }

    public LargeImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ImageView(getContext());
        this.b = l(getContext());
        addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        this.b.setExecutor(CoreThreadPool.getDefault().getCachedThreadPool());
        this.b.setOrientation(-1);
        this.b.setTileBackgroundColor(UIHelper.getColor(2131103450));
        this.b.setOnSizeChangedStrategy(getSizeChangedStrategy());
    }
}
