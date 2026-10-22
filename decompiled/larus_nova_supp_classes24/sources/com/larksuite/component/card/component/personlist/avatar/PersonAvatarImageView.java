package com.larksuite.component.card.component.personlist.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.shapeimage.ShaderImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class PersonAvatarImageView extends ShaderImageView {
    public a b;

    public static class a extends egc.b {
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
            ((egc.b) this).k.reset();
            ((egc.b) this).l.reset();
            return null;
        L5:
            if ((r0 instanceof BitmapDrawable) == false) goto L7;
            r1 = ((BitmapDrawable) r0).getBitmap();
            goto L8
        }

        public a() {
            super(2131820555);
        }
    }

    public final egc.a a() {
        a r0 = new a();
        this.b = r0;
        return r0;
    }

    public PersonAvatarImageView(Context r1) {
        super(r1);
    }

    public final void onDraw(Canvas r2) {
        TraceEvent.beginSection("PersonAvatarImageView.onDraw");
        super.onDraw(r2);
        TraceEvent.beginSection("PersonAvatarImageView.onDraw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageBitmap(Bitmap r4) {
        super.setImageBitmap(r4);
        ViewGroup.LayoutParams r5 = getLayoutParams();
        getDrawable().setBounds(0, 0, r5.width, r5.height);
        getPathHelper().b(getDrawable());
    }

    public PersonAvatarImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public PersonAvatarImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
