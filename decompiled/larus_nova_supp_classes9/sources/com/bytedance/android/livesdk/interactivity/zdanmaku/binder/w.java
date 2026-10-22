package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends tk6.e<n22.d, View> {
    public final LinearLayout e;
    public final ImageView f;
    public final StrokeColorTextView g;
    public final h80.d<p22.i> h;

    public w(View r4, h80.d<p22.i> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "danmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.h = r5;
        this.e = (LinearLayout) r4.findViewById(2131380980);
        this.f = (ImageView) r4.findViewById(2131392217);
        this.g = (StrokeColorTextView) r4.findViewById(2131363970);
    }

    public final void b(Object r11, RenderEntity r13) {
        n22.d r14 = (n22.d) r11;
        Intrinsics.checkNotNullParameter(r14, "data");
        Intrinsics.checkNotNullParameter(r13, "entity");
        p22.i r15 = (p22.i) this.h.get();
        this.g.setText(r14.b);
        this.g.setTextSize(0, r15.d.a);
        this.g.setTypeface(Typeface.DEFAULT_BOLD);
        int r0 = ColorProtector.parseColor((String) ArraysKt.first(r15.d.c));
        int r1 = ColorProtector.parseColor((String) ArraysKt.first(r15.d.d));
        Integer r3 = r14.e;
        if (r3 == null) goto L5;
        this.e.setBackgroundResource(r3.intValue());
    L6:
        String[] r4 = r14.g;
        if (r4 != null) goto L9;
        this.g.setTextColor(r0);
    L20:
        String[] r2 = r14.i;
        if (r2 == null) goto L37;
        this.g.x(s1.f(0.5f), -1);
        if (r2.length != 1) goto L25;
        this.g.setStrokeColor(ColorProtector.parseColor((String) ArraysKt.first(r2)));
    L38:
        Bitmap r5 = r14.a;
        if (r5 == null) goto L41;
        this.f.setImageBitmap(r5);
        return;
    L41:
        Integer r16 = r14.c;
        if (r16 == null) goto L44;
        int r17 = r16.intValue();
        a1.k(this.f, r15.d.b);
        a1.p(this.f, r15.d.b);
        this.f.setImageResource(r17);
        this.f.setAlpha(r15.c / 100.0f);
        return;
    L44:
        this.f.setImageDrawable(null);
        UtilityKotlinExtentionsKt.t(this.f);
        return;
    L25:
        float[] r8 = r14.j;
        if (r8 == null) goto L38;
        if (r8.length != r2.length) goto L38;
        ArrayList r6 = new ArrayList(r2.length);
        int r7 = r2.length;
        int r9 = 0;
    L30:
        if (r9 >= r7) goto L32;
        r6.add(Integer.valueOf(ColorProtector.parseColor(r2[r9])));
        r9 = r9 + 1;
        goto L30
    L32:
        AppCompatTextView r10 = this.g;
        int[] r18 = CollectionsKt.toIntArray(r6);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "intArray");
        Intrinsics.checkNotNullParameter(r8, "position");
        r10.g = new LinearGradient(0.0f, 0.0f, r10.getPaint().measureText(r10.getText(), 0, r10.getText().length()), 0.0f, r18, r8, Shader.TileMode.CLAMP);
        AppCompatTextView r19 = r10.getOutlineTextView();
        if (r19 == null) goto L38;
        TextPaint r20 = r19.getPaint();
        if (r20 == null) goto L38;
        r20.setShader(r10.g);
        goto L38
    L37:
        this.g.x(0.0f, r1);
        goto L38
    L9:
        if (r4.length != 1) goto L11;
        this.g.setTextColor(ColorProtector.parseColor((String) ArraysKt.first(r4)));
        goto L20
    L11:
        float[] r21 = r14.h;
        if (r21 == null) goto L20;
        if (r21.length != r4.length) goto L20;
        ArrayList r23 = new ArrayList(r4.length);
        int r24 = r4.length;
        int r25 = 0;
    L16:
        if (r25 >= r24) goto L18;
        r23.add(Integer.valueOf(ColorProtector.parseColor(r4[r25])));
        r25 = r25 + 1;
        goto L16
    L18:
        this.g.z(CollectionsKt.toIntArray(r23), r21);
        goto L20
    L5:
        this.e.setBackground(r14.f);
        goto L6
    }
}
