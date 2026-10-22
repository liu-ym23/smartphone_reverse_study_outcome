package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.va;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BaseEnterSpecialView extends ConstraintLayout {
    public HSImageView a;
    public HSImageView b;
    public TextView c;
    public HSImageView d;
    public BaseLightView e;

    private int getLayoutResource() {
        return 2131567902;
    }

    public final void S5() {
        boolean r1 = false;
        if (this.c.getLayout() == null) goto L7;
        final int r0 = ((int) this.c.getLayout().getLineWidth(0)) - ((this.c.getWidth() - this.c.getCompoundPaddingRight()) - this.c.getCompoundPaddingLeft());
        if (r0 <= 0) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L11;
        this.c.post(new a(this, r0));
        return;
    L11:
        return;
    L7:
        r0 = 0;
        goto L8
    }

    public final void T5() {
        BaseLightView r1 = this.e;
        r1.a = true;
        int r11 = r1.getResources().getColor(2131108466);
        int r3 = r1.getResources().getColor(2131108468);
        int r4 = r1.getResources().getColor(2131108467);
        r1.k = new RectF(0.0f, 0.0f, r1.m, r1.n);
        r1.b = new Matrix();
        r1.c = r1.m;
        r1.d = new LinearGradient(0.0f, 0.0f, r1.m, r1.n, r11, r11, Shader.TileMode.CLAMP);
        r1.e = new LinearGradient(0.0f, 0.0f, 60.0f, 14.0f, new int[]{r4, r3, r3, r4}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
        r1.f = new ComposeShader(r1.d, r1.e, PorterDuff.Mode.DST_ATOP);
        r1.l = Bitmap.createBitmap((int) r1.m, (int) r1.n, Bitmap.Config.ARGB_8888);
        r1.j = new Canvas(r1.l);
        r1.d.setLocalMatrix(r1.g);
        r1.e.setLocalMatrix(r1.g);
        r1.f.setLocalMatrix(r1.g);
        r1.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseEnterSpecialView(Context r2) {
        super(r2);
        ViewGroup.inflate(r2, getLayoutResource(), this);
        this.a = findViewById(2131363667);
        this.b = findViewById(2131374500);
        this.c = (TextView) findViewById(2131368866);
        this.d = findViewById(2131362938);
        this.e = (BaseLightView) findViewById(2131364000);
        if (RTLUtil.isAppRTL(getContext()) == true) goto L5;
        this.c.setTextDirection(3);
    L5:
        this.d.setVisibility(4);
    }

    public final void R5(k32.a r4, yb2.a r5) {
        k r0 = r4.d;
        if (r0 == null) goto L5;
        a1.v(this.a, r0, 2131250965);
    L5:
        k r1 = r4.e;
        if (r1 == null) goto L8;
        ImageLoader.bindImage(this.b, r1);
    L9:
        va.a r2 = r4.k;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getText() == null) goto L14;
        String r6 = sb2.a.g(r4.k.getText().getDefaultPattern(), r4.k.getText(), r5).a.toString();
        this.c.setText(r6);
    L14:
        va.a r7 = r4.k;
        if (r7 != null) goto L17;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L26;
    L28:
        this.d.setVisibility(8);
        return;
    L26:
        if (r4.k.getIcon() == null) goto L28;
        ImageLoader.bindImage(this.d, r4.k.getIcon());
        return;
    L17:
        if (r7.getType() == 5) goto L21;
        if (r7.getType() != 7) goto L23;
    L21:
        if (r4.l == null) goto L23;
        r8 = true;
        goto L24
    L8:
        this.b.setVisibility(8);
        goto L9
    }
}
