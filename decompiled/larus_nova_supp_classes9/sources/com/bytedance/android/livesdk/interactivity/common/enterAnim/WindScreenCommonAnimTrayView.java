package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class WindScreenCommonAnimTrayView extends BaseWindScreenAnimEnterTrayView {
    public TextView b;
    public HSImageView c;
    public ConstraintLayout d;

    public class a implements qb2.e {
        public final /* synthetic */ WindScreenCommonAnimTrayView a;

        @Override // qb2.e
        public final void a(ak6.g r1) {
        }

        public a(WindScreenCommonAnimTrayView r1) {
            this.a = r1;
        }

        @Override // qb2.e
        public final void b(ak6.g r2) {
            this.a.b.setText(r2.a);
            c r3 = this.a.a;
            if (r3 == null) goto L6;
            r3.b();
            return;
        }
    }

    public WindScreenCommonAnimTrayView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void R5(k32.d r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        setTextContent(r1);
        setIcon(r1);
        setBackground(r1);
    }

    public void setBackground(k32.d r3) {
        Drawable r0 = this.d.getBackground();
        h3 r1 = r3.t;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getBackground() != null) goto L7;
        return;
    L7:
        if (r3.t.getBackground().b() == null) goto L12;
        ((GradientDrawable) r0).setColor(com.bytedance.android.live.schema.helper.g.b(r3.t.getBackground().b(), ColorProtector.parseColor("#99FAA14F")));
        return;
    }

    public void setIcon(k32.d r3) {
        h3 r0 = r3.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.N() != null) goto L7;
        return;
    L7:
        if (r3.t.N().isEmpty() == false) goto L9;
        return;
    L9:
        if (ListProtector.get(r3.t.N(), 0) == null) goto L15;
        ImageUtil.loadImage(this.c, (py.k) ListProtector.get(r3.t.N(), 0), 0);
        return;
    }

    public void setTextContent(k32.d r6) {
        h3 r0 = r6.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.M() != null) goto L7;
        return;
    L7:
        if (r6.t.M().a() != null) goto L9;
    L31:
        Text r7 = r6.t.getText();
    L32:
        if (r7 == null) goto L42;
        com.bytedance.android.livesdk.interactivity.common.utils.d.a(r7);
        qb2.c.a(r7, new a(this));
        return;
    L42:
        return;
    L9:
        if (r6.u == false) goto L31;
        String r1 = IESUIUtils.getDisplayCount(r6.t.M().a().longValue(), "w");
        if (r6.t.M().b() == null) goto L30;
        r7 = r6.t.M().b();
        if (r7 == null) goto L32;
        if (r7.getPieces() == null) goto L32;
        if (r7.getPieces().isEmpty() == true) goto L32;
        int r2 = 0;
    L21:
        if (r2 >= r7.getPieces().size()) goto L32;
        if (ListProtector.get(r7.getPieces(), r2) == null) goto L29;
        if (((c5) ListProtector.get(r7.getPieces(), r2)).getStringValue() == null) goto L29;
        if (((c5) ListProtector.get(r7.getPieces(), r2)).getStringValue().contains("$aggregate_num_sum") == false) goto L29;
        ((c5) ListProtector.get(r7.getPieces(), r2)).setStringValue(((c5) ListProtector.get(r7.getPieces(), r2)).getStringValue().replace("$aggregate_num_sum", r1));
    L29:
        r2 = r2 + 1;
        goto L21
    L30:
        r7 = null;
        goto L32
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public void setTextSize(float r3) {
        this.b.setTextSize(0, r3);
    }

    public void setIcon(Bitmap r2) {
        this.c.setImageBitmap(r2);
        this.a.c();
    }

    public WindScreenCommonAnimTrayView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void U5(int r2, int r3) {
        ViewGroup.LayoutParams r0 = this.c.getLayoutParams();
        r0.width = r2;
        r0.height = r3;
        this.c.setLayoutParams(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindScreenCommonAnimTrayView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        ViewGroup.inflate(getContext(), 2131568047, this);
        this.b = (TextView) findViewById(2131393274);
        this.c = findViewById(2131393273);
        this.d = findViewById(2131365073);
    }
}
