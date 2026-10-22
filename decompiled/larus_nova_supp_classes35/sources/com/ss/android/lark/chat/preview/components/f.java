package com.ss.android.lark.chat.preview.components;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.preview.entity.component.property.ImageProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends q6c.e<ImageProperty, LKUIRoundedImageView2, r6c.a> {
    public final com.ss.android.lark.chat.preview.actions.b f;
    public final boolean g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.f;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    static {
    }

    public final String i() {
        return "com.larksuite.component.ui.imageview.LKUIRoundedImageView2";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r9) {
        Intrinsics.checkNotNullParameter(r9, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r9, "size");
        return null;
    L5:
        return new LKUIRoundedImageView2(r1.getContext(), null, 0, 6, null);
    }

    public void update(LKUIRoundedImageView2 r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        boolean r1 = true;
        if (h18.f.a(r15.getContext()) == false) goto L18;
        ImageSet r0 = ((ImageProperty) ((q6c.e) this).e).getDmImage();
        if (r0 == null) goto L9;
        Image r2 = r0.getThumbnail();
        if (r2 == null) goto L9;
        String r3 = r2.getKey();
    L10:
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
        ImageSet r5 = ((ImageProperty) ((q6c.e) this).e).getDmImage();
    L20:
        if (h18.f.a(r15.getContext()) == false) goto L30;
        String r6 = ((ImageProperty) ((q6c.e) this).e).getDmImageUrl();
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L30;
        String r8 = ((ImageProperty) ((q6c.e) this).e).getDmImageUrl();
    L31:
        UDIcon r9 = ((ImageProperty) ((q6c.e) this).e).getUdIcon();
        if (r9 == null) goto L34;
        String r10 = r9.getUnicode();
    L35:
        if (r10 != null) goto L37;
    L40:
        boolean r11 = true;
    L42:
        if (r11 == true) goto L51;
        Integer[] r12 = sbb.d.a;
        UDIcon r13 = ((ImageProperty) ((q6c.e) this).e).getUdIcon();
        if (r13 == null) goto L47;
        String r14 = r13.getUnicode();
        if (r14 == null) goto L47;
    L48:
        Bitmap r16 = sbb.d.a(r14);
        if (r16 == null) goto L163;
        r15.setImageBitmap(r16);
    L163:
        TCStyle r17 = ((q6c.b) this).c;
        if ((r17 instanceof Style) == false) goto L187;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Style.applyBackground$default((Style) r17, r15, null, 2, null);
        TCStyle r18 = ((q6c.b) this).c;
        if ((r18 instanceof Style) == false) goto L168;
        Style r19 = (Style) r18;
    L169:
        if (r19 == null) goto L189;
        Border r20 = r19.getBorder();
        if (r20 == null) goto L175;
        ThemeColor r21 = r20.getThemeColor();
        if (r21 == null) goto L175;
        r15.setBorderColor(com.ss.android.lark.export.entity.preview.a.a(r21, r15.getContext(), null));
    L175:
        Border r22 = r19.getBorder();
        float r23 = 0.0f;
        if (r22 == null) goto L180;
        Float r24 = r22.getWidth();
        if (r24 == null) goto L180;
        float r25 = r24.floatValue();
    L181:
        r15.setBorderWidth(UIHelper.dp2px(r25));
        Border r26 = r19.getBorder();
        if (r26 == null) goto L186;
        Float r27 = r26.getCornerRadius();
        if (r27 == null) goto L186;
        r23 = r27.floatValue();
    L186:
        r15.setRadius(UIHelper.dp2px(r23));
    L180:
        r25 = 0.0f;
    L189:
        if (this.f != null) goto L191;
        r15.setOnClickListener(null);
        r15.setClickable(false);
        return;
    L191:
        r15.setOnClickListener(new b(this));
        return;
    L168:
        r19 = null;
        goto L169
    L187:
        r15.setBackground(null);
    L47:
        r14 = BuildConfig.FLAVOR;
        goto L48
    L51:
        UDIcon r28 = ((ImageProperty) ((q6c.e) this).e).getUdIcon();
        if (r28 == null) goto L54;
        String r29 = r28.getKey();
    L56:
        if (TextUtils.isEmpty(r29) == true) goto L76;
        int r30 = edb.a.a;
        UDIcon r31 = ((ImageProperty) ((q6c.e) this).e).getUdIcon();
        if (r31 == null) goto L60;
        String r32 = r31.getKey();
    L61:
        int r33 = edb.a.a(r32);
        if (r33 == 0) goto L163;
        Drawable r34 = r15.getContext().getResources().getDrawable(r33, null);
        if (r34 == null) goto L75;
        UDIcon r35 = ((ImageProperty) ((q6c.e) this).e).getUdIcon();
        if (r35 == null) goto L68;
        ThemeColor r36 = r35.getThemeColor();
    L69:
        if (r36 == null) goto L75;
        r34.mutate();
        UDIcon r37 = ((ImageProperty) ((q6c.e) this).e).getUdIcon();
        if (r37 == null) goto L73;
        ThemeColor r38 = r37.getThemeColor();
    L74:
        Intrinsics.checkNotNull(r38);
        r34.setTint(com.ss.android.lark.export.entity.preview.a.a(r38, r15.getContext(), null));
        goto L75
    L73:
        r38 = null;
        goto L74
    L68:
        r36 = null;
    L75:
        r15.setImageDrawable(r34);
        goto L163
    L60:
        r32 = null;
        goto L61
    L76:
        if (r5 == null) goto L80;
        Image r39 = r5.getThumbnail();
        if (r39 == null) goto L80;
        String r40 = r39.getKey();
    L82:
        if (TextUtils.isEmpty(r40) == false) goto L114;
        r6c.a r41 = ((q6c.a) this).a;
        if ((r41 instanceof vcb.d) == false) goto L86;
        vcb.d r42 = (vcb.d) r41;
    L87:
        if (r42 == null) goto L89;
        boolean r43 = r42.f;
    L90:
        Object r44 = r15.getTag(2131388147);
        if ((r44 instanceof String) == false) goto L93;
        String r45 = (String) r44;
    L95:
        if (TextUtils.isEmpty(r8) == false) goto L97;
    L99:
        r1 = false;
    L100:
        Drawable r46 = UDIconUtils.getIconDrawable(r15.getContext(), 2131254091, UIHelper.getColor(2131102416));
        IRequestCreator r47 = ImageLoader.with(r15.getContext()).load(r8).isAsync(this.g).error(UDIconUtils.getIconDrawable(r15.getContext(), 2131254898, UIHelper.getColor(2131102416))).override(r15.getLayoutParams().width, r15.getLayoutParams().height).dontAnimate(false).centerCrop().diskCacheStrategy(DiskCacheStrategy.RESULT);
        if (r43 == true) goto L107;
        if (r1 == true) goto L104;
    L105:
        r47.placeholder(r46);
    L106:
        r15.setTag(2131388147, r8);
    L108:
        TCStyle r48 = ((q6c.b) this).c;
        if ((r48 instanceof Style) == false) goto L113;
        Intrinsics.checkNotNull(r48, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        if (((Style) r48).getTextColorV2() == null) goto L113;
        TCStyle r49 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r49, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        ThemeColor r50 = ((Style) r49).getTextColorV2();
        Intrinsics.checkNotNull(r50);
        r47.transform(new ColorFilterTransformation(com.ss.android.lark.export.entity.preview.a.a(r50, r15.getContext(), null)));
    L113:
        r47.into(r15);
        goto L163
    L104:
        if (r15.getDrawable() != null) goto L106;
    L107:
        r47.placeholder(r46);
        goto L108
    L97:
        if (TextUtils.equals(r8, r45) == false) goto L99;
    L93:
        r45 = null;
        goto L95
    L89:
        r43 = false;
        goto L90
    L86:
        r42 = null;
        goto L87
    L114:
        if (r5 == null) goto L163;
        Image r51 = r5.getMiddle();
        if (r51 == null) goto L163;
        r6c.a r52 = ((q6c.a) this).a;
        if ((r52 instanceof vcb.d) == false) goto L122;
        vcb.d r53 = (vcb.d) r52;
    L123:
        if (r53 == null) goto L125;
        boolean r54 = r53.f;
    L126:
        Object r55 = r15.getTag(2131388147);
        if ((r55 instanceof String) == false) goto L129;
        String r56 = (String) r55;
    L131:
        if (TextUtils.isEmpty(r51.getKey()) == false) goto L133;
    L135:
        r1 = false;
    L136:
        float r57 = (r51.getHeight() * 1.0f) / r51.getWidth();
        if (r15.getLayoutParams().width <= 0) goto L139;
        int r110 = r15.getLayoutParams().width;
    L141:
        if (r15.getLayoutParams().height <= 0) goto L143;
        int r58 = r15.getLayoutParams().height;
    L144:
        Log.d("ImageViewComponent", "imageKey: " + r51.getKey());
        Drawable r59 = UDIconUtils.getIconDrawable(r15.getContext(), 2131254091, UIHelper.getColor(2131102416));
        IRequestCreator r60 = ImageLoader.with(r15.getContext()).load(new EncryptImage(r51)).isAsync(this.g).override(r110, r58).dontAnimate(false);
        if (r54 == true) goto L151;
        if (r1 == true) goto L148;
    L149:
        r60.placeholder(r59);
    L150:
        r15.setTag(2131388147, r51.getKey());
    L153:
        if (h18.d.e(r15.getContext(), r15.getLayoutParams().width) >= 56) goto L155;
    L157:
        TCStyle r61 = ((q6c.b) this).c;
        if ((r61 instanceof Style) == false) goto L162;
        Intrinsics.checkNotNull(r61, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        if (((Style) r61).getTextColorV2() == null) goto L162;
        TCStyle r62 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r62, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        ThemeColor r63 = ((Style) r62).getTextColorV2();
        Intrinsics.checkNotNull(r63);
        r60.transform(new ColorFilterTransformation(com.ss.android.lark.export.entity.preview.a.a(r63, r15.getContext(), null)));
    L162:
        r60.into(new g(r54, r1, r15));
        goto L163
    L155:
        if (h18.d.e(r15.getContext(), r15.getLayoutParams().height) < 56) goto L157;
        r60.error(UDIconUtils.getIconDrawable(r15.getContext(), 2131254898, r15.getContext().getResources().getColor(2131102416)));
        goto L157
    L148:
        if (r15.getDrawable() != null) goto L150;
    L151:
        r60.placeholder(r59);
        goto L153
    L143:
        Resources r111 = r15.getResources();
        r58 = (int) (WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).widthPixels * r57);
        goto L144
    L139:
        Resources r112 = r15.getResources();
        r110 = WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).widthPixels;
        goto L141
    L133:
        if (TextUtils.equals(r51.getKey(), r56) == false) goto L135;
    L129:
        r56 = null;
        goto L131
    L125:
        r54 = false;
        goto L126
    L122:
        r53 = null;
    L80:
        r40 = null;
        goto L82
    L54:
        r29 = null;
        goto L56
    L37:
        if (r10.length() == 0) goto L40;
        r11 = false;
        goto L42
    L34:
        r10 = null;
        goto L35
    L24:
        if (r6.length() == 0) goto L27;
        r7 = false;
    L30:
        r8 = ((ImageProperty) ((q6c.e) this).e).getImageUrl();
        goto L31
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
    L9:
        r3 = null;
    L18:
        r5 = ((ImageProperty) ((q6c.e) this).e).getImage();
        goto L20
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((LKUIRoundedImageView2) r1);
    }

    public f(ImageProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = null;
        g6b.a.InterfaceC0223a r5 = g6b.a.a;
        if (r5 == null) goto L5;
        r5.c();
    L5:
        this.g = false;
    }
}
