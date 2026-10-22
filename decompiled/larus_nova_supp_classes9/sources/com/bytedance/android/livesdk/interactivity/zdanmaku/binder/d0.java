package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 extends tk6.e<q72.e, View> {
    public final LinearLayout e;
    public final ImageView f;
    public final StrokeColorTextView g;
    public final ImageView h;

    public d0(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.e = (LinearLayout) r4.findViewById(2131380980);
        this.f = (ImageView) r4.findViewById(2131392217);
        this.g = (StrokeColorTextView) r4.findViewById(2131363970);
        this.h = (ImageView) r4.findViewById(2131374718);
    }

    public final void b(Object r21, RenderEntity r23) {
        q72.e r2 = (q72.e) r21;
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r23, "entity");
        BarrageSettingFont r0 = BarrageSettingFont.PORTRAIT;
        if (r0 == null) goto L11;
        int r1 = p22.j.a[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L10;
        p22.i.a r3 = new p22.i.a(p22.m.a(12.0f), p22.m.a(24.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
    L16:
        p22.i.a r6 = r3;
        this.g.setText(com.bytedance.android.livesdk.interactivity.utils.b.b(r2, r6.a));
        this.g.setTextSize(0, r6.a);
        this.g.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout r7 = this.e;
        Intrinsics.checkNotNullParameter(r2, "$this$getOfficialBackgroundDrawable");
        if (r2.a() == true) goto L32;
    L18:
        GradientDrawable r9 = null;
    L24:
        r7.setBackground(r9);
        float[] r4 = {0.0f, 1.0f};
        String[] r5 = {"#EDF4FF", "#CDD5FF"};
        ArrayList r8 = new ArrayList(2);
        int r10 = 0;
    L25:
        if (r10 >= 2) goto L27;
        r8.add(Integer.valueOf(ColorProtector.parseColor(r5[r10])));
        r10 = r10 + 1;
        goto L25
    L27:
        this.g.z(CollectionsKt.toIntArray(r8), r4);
        this.g.x(0.0f, ColorProtector.parseColor((String) ArraysKt.first(r6.d)));
        this.f.setImageDrawable(null);
        UtilityKotlinExtentionsKt.t(this.f);
        Bitmap r11 = r2.c;
        if (r11 == null) goto L30;
        UtilityKotlinExtentionsKt.w(this.h);
        this.h.setImageBitmap(r11);
        return;
    L30:
        UtilityKotlinExtentionsKt.t(this.h);
        return;
    L32:
        int r13 = Color.parseColor("#" + r2.d());     // Catch: Exception -> L22
        r9 = new GradientDrawable();     // Catch: Exception -> L22
        r9.setCornerRadius(50.0f);     // Catch: Exception -> L22
        int r14 = (int) 76.5f;     // Catch: Exception -> L22
        r9.setColors(new int[]{ColorUtils.setAlphaComponent(r13, r14), ColorUtils.setAlphaComponent(r13, r14)});     // Catch: Exception -> L22
        r9.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L22
        Paint r15 = new Paint(1);     // Catch: Exception -> L22
        r15.setShader(new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, new int[]{Color.parseColor("#4DDAE6FF"), Color.parseColor("#4DBAD1FF"), Color.parseColor("#4DCFDFFF")}, new float[]{0.0f, 0.48f, 1.0f}, Shader.TileMode.CLAMP));     // Catch: Exception -> L22
        r15.setStyle(Paint.Style.STROKE);     // Catch: Exception -> L22
        r15.setStrokeWidth(UtilityKotlinExtentionsKt.h(1));     // Catch: Exception -> L22
        Field r16 = GradientDrawable.class.getDeclaredField("mStrokePaint");     // Catch: Exception -> L22
        r16.setAccessible(true);     // Catch: Exception -> L22
        r16.set(r9, r15);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ALogger.e("BarrageUtils", e);
        goto L18
    L10:
        if (r1 != 4) goto L11;
        r3 = new p22.i.a(p22.m.a(14.0f), p22.m.a(22.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L16
    L14:
        r3 = new p22.i.a(p22.m.a(16.0f), p22.m.a(28.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L16
    L15:
        r3 = new p22.i.a(p22.m.a(20.0f), p22.m.a(32.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
    L11:
        r3 = new p22.i.a(p22.m.a(16.0f), p22.m.a(28.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L16
    }
}
