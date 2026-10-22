package com.ss.android.lark.image.entity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LoadParams {
    public int a;
    public int b;
    public Drawable c;
    public Drawable d;
    public ImageView.ScaleType e;
    public final ImageView.ScaleType f;
    public final List<Transformation<Bitmap>> g;
    public DiskCacheStrategy h;
    public boolean i;
    public boolean j;
    public boolean k;
    public ListenerParams l;
    public int m;
    public int n;
    public int o;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CropType {
        public static final String CROP_BOTTOM = "c2_";
        public static final String CROP_CENTER = "c5_";
        public static final String CROP_LEFT = "c3_";
        public static final String CROP_RIGHT = "c4_";
        public static final String CROP_SMART = "cs_";
        public static final String CROP_TOP = "c1_";
        public static final String NOTHING = "";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageFormat {
        public static final String IMAGE = "image";
        public static final String JPEG = "jpeg";
        public static final String PNG = "png";
        public static final String WEBP = "webp";
    }

    public LoadParams() {
        this.a = -1;
        this.b = -1;
        this.e = ImageView.ScaleType.CENTER_CROP;
        this.f = ImageView.ScaleType.CENTER;
        this.g = new ArrayList();
        this.h = DiskCacheStrategy.ALL;
        this.i = false;
        this.j = true;
        this.k = false;
    }
}
