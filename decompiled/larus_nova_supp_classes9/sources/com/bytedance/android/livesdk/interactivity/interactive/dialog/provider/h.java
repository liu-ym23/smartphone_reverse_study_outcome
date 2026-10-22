package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.msgboard.DressListTextConfig;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.util.Quarter;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Runnable {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b a;
    public final /* synthetic */ SkinSelection b;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ VSMsgBoardDress b;

        public a(h r1, VSMsgBoardDress r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            VSMsgBoardDress r1 = this.b;
            if (r1 == null) goto L7;
            String r2 = r1.getDressColor();
            if (r2 == null) goto L7;
            int r3 = n82.c.k(r2, -1);
        L8:
            com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b r4 = this.a.a;
            ImageView r5 = r4.m;
            if (r5 == null) goto L38;
            k82.a r6 = r4.t.a;
            if (r6 == null) goto L35;
            t9 r7 = r6.s();
            if (r7 == null) goto L35;
            if (r7.e != 1) goto L35;
            int r8 = n82.b.a;
            int r9 = Color.argb(51, Color.red(r3), Color.green(r3), Color.blue(r3));
            Quarter r10 = Quarter.RIGHT_BOTTOM;
            ImageView r11 = this.a.a.m;
            if (r11 == null) goto L19;
            int r13 = r11.getWidth();
        L20:
            ImageView r14 = this.a.a.m;
            if (r14 == null) goto L23;
            int r15 = r14.getHeight();
        L24:
            int r16 = r15 / 2;
            int r17 = s1.f(0.8f);
            int r18 = s1.f(11.5f);
            Intrinsics.checkNotNullParameter(r10, "quarter");
            GradientDrawable r19 = new GradientDrawable(GradientDrawable.Orientation.TR_BL, new int[]{r9, 0});
            r19.setGradientType(1);
            int r20 = n82.a.a[r10.ordinal()];
            if (r20 == 1) goto L33;
            if (r20 == 2) goto L32;
            if (r20 == 3) goto L31;
            if (r20 != 4) goto L34;
            float r110 = r16;
            r19.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, s1.f(r13 / 2), s1.f(r110)});
            float r21 = r13;
            r19.setGradientRadius(s1.f(0.5f * r21));
            r19.setGradientCenter(s1.f(r21), s1.f(r110));
        L34:
            r19.setGradientType(0);
            GradientDrawable r23 = new GradientDrawable();
            r23.setColor(0);
            r23.setShape(1);
            GradientDrawable r24 = n82.b.a(0, -1, GradientDrawable.Orientation.TOP_BOTTOM);
            GradientDrawable r111 = n82.b.a(0, -1, GradientDrawable.Orientation.TR_BL);
            float r112 = r18;
            n82.b.b(r23, r112);
            n82.b.b(r19, r112);
            n82.b.b(r24, r112);
            n82.b.b(r111, r112);
            LayerDrawable r113 = new LayerDrawable(new GradientDrawable[]{r23, r19, r24, r111});
            r113.setLayerInset(0, (r13 / 2) - r16, r17, r17, 0);
            r113.setLayerInset(1, 0, r17, r17, 0);
            r113.setLayerInset(2, 0, r17, r17, 0);
            r113.setLayerInset(3, 0, r17, r17, 0);
            Drawable r114 = r113;
        L36:
            r5.setBackground(r114);
            return;
        L31:
            r19.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, s1.f(r13 / 2), s1.f(r16), 0.0f, 0.0f});
            float r25 = r13;
            r19.setGradientRadius(s1.f(0.5f * r25));
            r19.setGradientCenter(s1.f(r25), 0.0f);
            goto L34
        L32:
            float r115 = r16;
            r19.setCornerRadii(new float[]{0.0f, 0.0f, s1.f(r13 / 2), s1.f(r115), 0.0f, 0.0f, 0.0f, 0.0f});
            r19.setGradientRadius(s1.f(r13 * 0.5f));
            r19.setGradientCenter(0.0f, s1.f(r115));
            goto L34
        L33:
            r19.setCornerRadii(new float[]{s1.f(r13 / 2), s1.f(r16), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            r19.setGradientRadius(s1.f(r13 * 0.5f));
            r19.setGradientCenter(0.0f, 0.0f);
            goto L34
        L23:
            r15 = 0;
            goto L24
        L19:
            r13 = 0;
        L35:
            int r26 = n82.b.a;
            r114 = n82.b.a(Color.argb(26, Color.red(r3), Color.green(r3), Color.blue(r3)), 0, GradientDrawable.Orientation.TOP_BOTTOM);
            goto L36
        L38:
            return;
        L7:
            r3 = -1;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.c("购买权益包后可使用该皮肤/该勋章", 0);
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.c("购买权益包后可使用该勋章", 0);
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.c("购买权益包后可使用该皮肤", 0);
        }
    }

    public static final class e implements View.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.c("购买权益包后可使用该皮肤/该勋章", 0);
        }
    }

    public h(com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b r1, SkinSelection r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        SkinSelection r1 = this.b;
        if (r1 != null) goto L5;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b.b(this.a);
        return;
    L5:
        int r2 = n82.c.a;
        String r3 = r1.a;
        String r4 = BuildConfig.FLAVOR;
        if (r3 != null) goto L8;
        r3 = BuildConfig.FLAVOR;
    L8:
        k82.a r5 = this.a.t.a;
        String r6 = null;
        if (r5 == null) goto L13;
        t9 r7 = r5.s();
        if (r7 == null) goto L13;
        DataCenter r8 = r7.l;
    L14:
        VSMsgBoardDress r9 = n82.c.j(r3, r8);
        String r10 = this.b.b;
        if (r10 == null) goto L18;
        r4 = r10;
    L18:
        k82.a r11 = this.a.t.a;
        if (r11 == null) goto L23;
        t9 r13 = r11.s();
        if (r13 == null) goto L23;
        DataCenter r14 = r13.l;
    L24:
        VSMsgBoardDress r15 = n82.c.e(r4, r14);
        if (r9 != null) goto L27;
    L28:
        if (r15 != null) goto L30;
    L247:
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b.b(this.a);
        return;
    L30:
        if (r15.getDressId() <= 0) goto L247;
    L31:
        k82.a r16 = this.a.t.a;
        boolean r17 = false;
        if (r16 == null) goto L37;
        t9 r18 = r16.s();
        if (r18 == null) goto L37;
        if (r18.g != true) goto L37;
    L43:
        HSImageView r19 = this.a.j;
        if (r19 == null) goto L46;
        UtilityKotlinExtentionsKt.z(r19, true);
    L46:
        TextView r20 = this.a.k;
        if (r20 == null) goto L49;
        UtilityKotlinExtentionsKt.z(r20, true);
    L49:
        this.a.c();
        HSImageView r21 = this.a.l;
        if (r21 == null) goto L57;
        if (r15 != null) goto L53;
    L55:
        boolean r23 = false;
    L56:
        UtilityKotlinExtentionsKt.z(r21, r23);
        goto L57
    L53:
        if (r15.getDressId() <= 0) goto L55;
        r23 = true;
    L57:
        HSImageView r24 = this.a.l;
        if (r15 == null) goto L60;
        py.k r110 = r15.getBadgeMiniIcon();
    L61:
        ImageUtil.loadImageWithRadiiAndScaleType(r24, r110, 0, 0.0f, s1.f(4.0f), 0.0f, 0.0f, ImageView.ScaleType.FIT_XY);
        FrameLayout r25 = this.a.c;
        if (r25 == null) goto L64;
        r25.setBackground(null);
    L64:
        View r26 = this.a.i;
        if (r26 != null) goto L67;
    L83:
        ImageView r27 = this.a.m;
        if (r27 == null) goto L91;
        if (r9 != null) goto L87;
    L89:
        boolean r28 = false;
    L90:
        UtilityKotlinExtentionsKt.z(r27, r28);
        goto L91
    L87:
        if (r9.getDressId() <= 0) goto L89;
        r28 = true;
    L91:
        ImageView r29 = this.a.m;
        if (r29 == null) goto L95;
        r29.post(new a(this, r9));
    L95:
        k82.a r30 = this.a.t.a;
        if (r30 == null) goto L100;
        t9 r31 = r30.s();
        if (r31 == null) goto L100;
        DataCenter r33 = r31.l;
    L102:
        if (n82.c.b(r9, r33) == false) goto L128;
        k82.a r34 = this.a.t.a;
        if (r34 == null) goto L108;
        t9 r35 = r34.s();
        if (r35 == null) goto L108;
        DataCenter r36 = r35.l;
    L110:
        if (n82.c.b(r15, r36) == false) goto L128;
        FrameLayout r37 = this.a.c;
        if (r37 == null) goto L114;
        UtilityKotlinExtentionsKt.z(r37, true);
    L114:
        this.a.e();
        if (TextUtils.isEmpty(this.a.o) == false) goto L122;
        k82.a r38 = this.a.t.a;
        if (r38 == null) goto L119;
        r38.d(false);
    L119:
        TextView r39 = this.a.n;
        if (r39 == null) goto L220;
        UtilityKotlinExtentionsKt.w(r39);
    L220:
        FrameLayout r40 = this.a.d;
        if (r40 != null) goto L223;
    L224:
        k82.a r41 = this.a.t.a;
        if (r41 == null) goto L230;
        t9 r43 = r41.s();
        if (r43 == null) goto L230;
        if (r43.g != true) goto L230;
    L236:
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b r44 = this.a;
        if (r9 != null) goto L239;
    L241:
        boolean r45 = false;
    L242:
        if (r15 != null) goto L244;
    L246:
        r44.d(true, r45, r17);
        return;
    L244:
        if (r15.getDressId() <= 0) goto L246;
        r17 = true;
        goto L246
    L239:
        if (r9.getDressId() <= 0) goto L241;
        r45 = true;
    L230:
        k82.a r46 = this.a.t.a;
        if (r46 == null) goto L251;
        t9 r47 = r46.s();
        if (r47 != null) goto L235;
        return;
    L235:
        if (r47.h == true) goto L236;
        return;
    L251:
        return;
    L223:
        if (r40.getVisibility() != 0) goto L224;
        return;
    L122:
        k82.a r48 = this.a.t.a;
        if (r48 == null) goto L125;
        r48.d(true);
    L125:
        TextView r49 = this.a.n;
        if (r49 == null) goto L220;
        UtilityKotlinExtentionsKt.t(r49);
    L108:
        r36 = null;
    L128:
        FrameLayout r50 = this.a.c;
        if (r50 == null) goto L131;
        UtilityKotlinExtentionsKt.z(r50, false);
    L131:
        TextView r51 = this.a.n;
        if (r51 == null) goto L134;
        UtilityKotlinExtentionsKt.z(r51, true);
    L134:
        k82.a r53 = this.a.t.a;
        if (r53 == null) goto L139;
        t9 r54 = r53.s();
        if (r54 == null) goto L139;
        DataCenter r55 = r54.l;
    L141:
        if (n82.c.b(r9, r55) == true) goto L167;
        k82.a r56 = this.a.t.a;
        if (r56 == null) goto L147;
        t9 r57 = r56.s();
        if (r57 == null) goto L147;
        DataCenter r58 = r57.l;
    L149:
        if (n82.c.b(r15, r58) == true) goto L167;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b r59 = this.a;
        TextView r60 = r59.n;
        if (r60 == null) goto L164;
        k82.a r61 = r59.t.a;
        if (r61 == null) goto L157;
        t9 r63 = r61.s();
        if (r63 == null) goto L157;
        DataCenter r64 = r63.l;
    L158:
        com.bytedance.android.livesdk.chatroom.msgboard.b r65 = n82.c.i(r64);
        if (r65 == null) goto L163;
        DressListTextConfig r66 = r65.b();
        if (r66 == null) goto L163;
        r6 = r66.getInputBoxCbText();
    L163:
        r60.setText(r6);
    L157:
        r64 = null;
    L164:
        TextView r67 = this.a.n;
        if (r67 == null) goto L220;
        r67.setOnClickListener(b.a);
    L147:
        r58 = null;
    L167:
        k82.a r68 = this.a.t.a;
        if (r68 == null) goto L172;
        t9 r69 = r68.s();
        if (r69 == null) goto L172;
        DataCenter r70 = r69.l;
    L174:
        if (n82.c.b(r15, r70) == true) goto L192;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b r71 = this.a;
        TextView r73 = r71.n;
        if (r73 == null) goto L189;
        k82.a r74 = r71.t.a;
        if (r74 == null) goto L182;
        t9 r75 = r74.s();
        if (r75 == null) goto L182;
        DataCenter r76 = r75.l;
    L183:
        com.bytedance.android.livesdk.chatroom.msgboard.b r77 = n82.c.i(r76);
        if (r77 == null) goto L188;
        DressListTextConfig r78 = r77.b();
        if (r78 == null) goto L188;
        r6 = r78.getInputBoxBadgeText();
    L188:
        r73.setText(r6);
    L182:
        r76 = null;
    L189:
        TextView r79 = this.a.n;
        if (r79 == null) goto L220;
        r79.setOnClickListener(c.a);
        goto L220
    L192:
        k82.a r80 = this.a.t.a;
        if (r80 == null) goto L197;
        t9 r81 = r80.s();
        if (r81 == null) goto L197;
        DataCenter r83 = r81.l;
    L199:
        if (n82.c.b(r9, r83) == true) goto L217;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b r84 = this.a;
        TextView r85 = r84.n;
        if (r85 == null) goto L214;
        k82.a r86 = r84.t.a;
        if (r86 == null) goto L207;
        t9 r87 = r86.s();
        if (r87 == null) goto L207;
        DataCenter r88 = r87.l;
    L208:
        com.bytedance.android.livesdk.chatroom.msgboard.b r89 = n82.c.i(r88);
        if (r89 == null) goto L213;
        DressListTextConfig r90 = r89.b();
        if (r90 == null) goto L213;
        r6 = r90.getInputBoxCoverText();
    L213:
        r85.setText(r6);
    L207:
        r88 = null;
    L214:
        TextView r91 = this.a.n;
        if (r91 == null) goto L220;
        r91.setOnClickListener(d.a);
        goto L220
    L217:
        this.a.e();
        TextView r93 = this.a.n;
        if (r93 == null) goto L220;
        r93.setOnClickListener(e.a);
    L197:
        r83 = null;
    L172:
        r70 = null;
    L139:
        r55 = null;
    L100:
        r33 = null;
        goto L102
    L67:
        if (r9 != null) goto L69;
    L75:
        int r94 = n82.c.k("#161823", -1);
        t9 r111 = this.a.b.s();
        if (r111 == null) goto L80;
        u9 r112 = r111.c;
        if (r112 == null) goto L80;
        String r113 = r112.d;
    L81:
        int r95 = n82.c.k(r113, r94);
        this.a.getClass();
        LayerDrawable r114 = new RoundedColorDrawable(UtilityKotlinExtentionsKt.h(12), ColorUtils.setAlphaComponent(r95, (int) 12.75f));
    L82:
        r26.setBackground(r114);
    L80:
        r113 = null;
        goto L81
    L69:
        if (r9.getDressId() <= 0) goto L75;
        int r115 = n82.b.a;
        float r116 = s1.f(12.0f);
        String r117 = r9.getDressColor();
        if (r117 != null) goto L74;
        r117 = "000000";
    L74:
        int r118 = n82.c.k(r117, -1);
        int r119 = s1.f(0.8f);
        GradientDrawable r120 = new GradientDrawable();
        r120.setColor(0);
        r120.setStroke(r119, r118);
        r120.setCornerRadius(r116);
        GradientDrawable r96 = n82.b.a(Color.argb(217, Color.red(-1), Color.green(-1), Color.blue(-1)), Color.argb(217, Color.red(-1), Color.green(-1), Color.blue(-1)), GradientDrawable.Orientation.TOP_BOTTOM);
        r96.setCornerRadius(r116);
        GradientDrawable r121 = new GradientDrawable();
        r121.setColor(0);
        r121.setCornerRadius(r116);
        r114 = new LayerDrawable(new GradientDrawable[]{r121, r120, r96});
        r114.setLayerInset(0, 0, 0, 0, 0);
        r114.setLayerInset(1, 0, 0, 0, 0);
        r114.setLayerInset(2, 0, 0, 0, 0);
        goto L82
    L60:
        r110 = null;
    L37:
        k82.a r97 = this.a.t.a;
        if (r97 == null) goto L94;
        t9 r98 = r97.s();
        if (r98 == null) goto L94;
        if (r98.h == true) goto L43;
    L94:
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.b.b(this.a);
        goto L95
    L27:
        if (r9.getDressId() > 0) goto L31;
    L23:
        r14 = null;
    L13:
        r8 = null;
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
