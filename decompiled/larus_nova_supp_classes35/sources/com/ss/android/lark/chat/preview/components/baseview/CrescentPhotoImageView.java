package com.ss.android.lark.chat.preview.components.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.ss.android.shapeimage.ShaderImageView;
import egc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CrescentPhotoImageView extends ShaderImageView {

    public static class a extends b {
        public final Bitmap a() {
            Drawable r0 = ((egc.a) this).i;
            if (r0 != null) goto L5;
        L7:
            Bitmap r1 = null;
        L8:
            if (r1 == null) goto L14;
            int r2 = r1.getWidth();
            int r3 = r1.getHeight();
            if (r2 <= 0) goto L14;
            if (r3 <= 0) goto L14;
            float r4 = Math.round(((egc.a) this).a - (((egc.a) this).c * 2.0f));
            float r5 = Math.round(((egc.a) this).b - (((egc.a) this).c * 2.0f));
            float r6 = r5 / r3;
            ((egc.a) this).j.setScale(r6, r6);
            Matrix r7 = ((egc.a) this).j;
            float r8 = ((egc.a) this).c;
            r7.postTranslate(r8, r8);
            c(r4, r5);
            return r1;
        L14:
            ((b) this).k.reset();
            ((b) this).l.reset();
            return null;
        L5:
            if ((r0 instanceof BitmapDrawable) == false) goto L7;
            r1 = ((BitmapDrawable) r0).getBitmap();
            goto L8
        }

        public a() {
            super(2131820561);
        }
    }

    public final egc.a a() {
        return new a();
    }

    public CrescentPhotoImageView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageBitmap(Bitmap r2) {
        super.setImageBitmap(r2);
        getPathHelper().b(getDrawable());
    }

    public CrescentPhotoImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CrescentPhotoImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
