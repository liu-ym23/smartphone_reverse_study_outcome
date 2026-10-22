package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.preview.entity.component.Direction;
import com.ss.android.lark.chat.preview.entity.component.property.ButtonProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w extends q6c.e<ButtonProperty, UDButton, r6c.a> {
    public final Integer f;
    public final Integer g;
    public final com.ss.android.lark.chat.preview.actions.b h;
    public final String i;
    public int j;
    public final URLPreviewParams k;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Direction.values().length];
            r0[Direction.LTR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Direction.RTL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ w a;

        public c(w r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            com.ss.android.lark.chat.preview.actions.b r12 = this.a.h;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r12.a(1);
            UrlPreviewAction r13 = this.a.h.a;
            g6b.a.InterfaceC0223a r1 = g6b.a.a;
            if (r1 == null) goto L19;
            com.ss.android.lark.officesdk.integrator.im.a r2 = r1.a();
            if (r2 == null) goto L20;
            String r3 = null;
            if (r13 == null) goto L9;
            String r4 = r13.getUrl();
        L10:
            w r14 = this.a;
            URLPreviewParams r5 = r14.k;
            String r6 = r5.a;
            String r7 = r14.i;
            String r15 = r14.h.b;
            Long r8 = r5.h;
            if (r8 == null) goto L13;
            String r9 = r8.toString();
        L14:
            Long r10 = this.a.k.i;
            if (r10 == null) goto L17;
            r3 = r10.toString();
        L17:
            r2.c(r4, r6, "button", r7, r15, r9, r3, this.a.k.e);
            return;
        L13:
            r9 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L20:
            return;
        }
    }

    static {
    }

    public final String i() {
        return "com.larksuite.component.universe_design.button.UDButton";
    }

    public final boolean j() {
        return true;
    }

    public final View a(RectF r9) {
        Intrinsics.checkNotNullParameter(r9, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L6;
        UDButton r10 = new UDButton(r1.getContext(), null, 0, 6, null);
        r10.applyStyle(2131953831);
        return r10;
    L6:
        Intrinsics.checkNotNullParameter(r9, "size");
        return null;
    }

    public final s6c.b.a d(s6c.b.a r9) {
        Intrinsics.checkNotNullParameter(r9, "size");
        TCStyle r1 = ((q6c.b) this).c;
        if (r1 != null) goto L5;
    L25:
        r6c.a r2 = ((q6c.a) this).a;
        if (r2 == null) goto L85;
        UDButton r0 = new UDButton(r2.getContext(), null, 0, 6, null);
        r0.applyStyle(2131953832);
        r0.setText(((ButtonProperty) ((q6c.e) this).e).getText());
        int r3 = 0;
        r0.measure(View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(r9.a), PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(536870911, 0));
        ImageSet r10 = ((ButtonProperty) ((q6c.e) this).e).getIconKey();
        boolean r4 = true;
        if (r10 == null) goto L39;
        Image r11 = r10.getThumbnail();
        if (r11 == null) goto L39;
        String r12 = r11.getKey();
        if (r12 == null) goto L39;
        if (r12.length() <= 0) goto L36;
        boolean r13 = true;
    L37:
        if (r13 != true) goto L39;
        boolean r14 = true;
    L40:
        if (r14 == false) goto L46;
        int r15 = r0.getMeasuredWidth() + UIHelper.dp2px(4.0f);
        Integer r5 = this.f;
        if (r5 == null) goto L44;
        int r6 = r5.intValue();
    L45:
        int r16 = r15 + r6;
    L58:
        this.j = r16;
        ImageSet r17 = ((ButtonProperty) ((q6c.e) this).e).getIconKey();
        if (r17 == null) goto L70;
        Image r18 = r17.getThumbnail();
        if (r18 == null) goto L70;
        String r19 = r18.getKey();
        if (r19 == null) goto L70;
        if (r19.length() <= 0) goto L67;
        boolean r20 = true;
    L68:
        if (r20 != true) goto L70;
        boolean r21 = true;
    L71:
        if (r21 == true) goto L82;
        String r22 = ((ButtonProperty) ((q6c.e) this).e).getText();
        if (r22 != null) goto L75;
    L80:
        r4 = false;
    L81:
        if (r4 == true) goto L82;
    L84:
        return new s6c.b.a(UIHelper.px2dp(this.j), UIHelper.px2dp(r3));
    L75:
        if (r22.length() <= 0) goto L77;
        boolean r23 = true;
    L78:
        if (r23 != true) goto L80;
    L77:
        r23 = false;
    L82:
        r3 = r0.getMeasuredHeight();
        goto L84
    L67:
        r20 = false;
    L70:
        r21 = false;
        goto L71
    L44:
        r6 = 0;
        goto L45
    L46:
        String r24 = ((ButtonProperty) ((q6c.e) this).e).getText();
        if (r24 != null) goto L49;
    L54:
        boolean r25 = false;
    L55:
        if (r25 == false) goto L57;
        r16 = r0.getMeasuredWidth();
        goto L58
    L57:
        r16 = 0;
        goto L58
    L49:
        if (r24.length() <= 0) goto L51;
        boolean r26 = true;
    L52:
        if (r26 != true) goto L54;
        r25 = true;
        goto L55
    L51:
        r26 = false;
        goto L52
    L36:
        r13 = false;
    L39:
        r14 = false;
    L85:
        Intrinsics.checkNotNullParameter(r9, "size");
        return r9;
    L5:
        if (r1.getHeight() == null) goto L25;
        TCStyle r7 = ((q6c.b) this).c;
        ValueType r8 = null;
        if (r7 == null) goto L9;
        Value r27 = r7.getWidth();
    L10:
        if (r27 == null) goto L25;
        TCStyle r28 = ((q6c.b) this).c;
        if (r28 == null) goto L16;
        Value r29 = r28.getHeight();
        if (r29 == null) goto L16;
        ValueType r30 = r29.getValueType();
    L17:
        ValueType r31 = ValueType.AUTO;
        if (r30 == r31) goto L25;
        TCStyle r32 = ((q6c.b) this).c;
        if (r32 == null) goto L24;
        Value r33 = r32.getWidth();
        if (r33 == null) goto L24;
        r8 = r33.getValueType();
    L24:
        if (r8 != r31) goto L85;
    L16:
        r30 = null;
        goto L17
    L9:
        r27 = null;
        goto L10
    }

    public void update(UDButton r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.update(r8);
        String r1 = null;
        int r2 = 0;
        if (this.h != null) goto L5;
        r8.setOnClickListener(null);
        r8.setClickable(false);
    L6:
        TCStyle r0 = ((q6c.b) this).c;
        if ((r0 instanceof Style) == false) goto L17;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Style.applyBackground$default((Style) r0, r8, null, 2, null);
        TCStyle r3 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        if (((Style) r3).getTextColorV2() == null) goto L11;
        TCStyle r4 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        ThemeColor r5 = ((Style) r4).getTextColorV2();
        Intrinsics.checkNotNull(r5);
        r8.setTextColor(com.ss.android.lark.export.entity.preview.a.a(r5, r8.getContext(), null));
    L12:
        TCStyle r6 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        if (((Style) r6).getFontLevel() == null) goto L15;
        int r7 = h6b.a.a;
        Context r9 = r8.getContext();
        TCStyle r10 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        r8.setTextSize(0, h6b.a.c(r9, ((Style) r10).getFontLevel()));
    L16:
        TextPaint r11 = r8.getPaint();
        int r12 = h6b.a.a;
        TCStyle r13 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        r11.setFakeBoldText(h6b.a.a(((Style) r13).getFontLevel()));
        goto L17
    L15:
        r8.setTextSize(14.0f);
        goto L16
    L11:
        r8.setTextColor(r8.getContext().getResources().getColor(2131103399));
    L17:
        ButtonProperty r14 = (ButtonProperty) ((q6c.e) this).e;
        ImageSet r15 = r14.getIconKey();
        if (r15 == null) goto L22;
        Image r16 = r15.getThumbnail();
        if (r16 == null) goto L22;
        String r17 = r16.getKey();
    L23:
        boolean r18 = true;
        if (r17 != null) goto L26;
    L29:
        boolean r19 = true;
    L30:
        if (r19 == false) goto L43;
        UDIcon r20 = r14.getUdIcon();
        if (r20 == null) goto L34;
        String r21 = r20.getKey();
    L35:
        if (r21 != null) goto L37;
    L40:
        boolean r22 = true;
    L41:
        if (r22 == false) goto L43;
        r8.setText(r14.getText());
    L131:
        ((ButtonProperty) ((q6c.e) this).e).applyToView(r8);
        return;
    L37:
        if (r21.length() == 0) goto L40;
        r22 = false;
        goto L41
    L34:
        r21 = null;
    L43:
        String r23 = r14.getText();
        Direction r24 = r14.getDirection();
        UDIcon r25 = ((ButtonProperty) ((q6c.e) this).e).getUdIcon();
        if (r25 == null) goto L46;
        String r26 = r25.getUnicode();
    L47:
        if (r26 != null) goto L49;
    L52:
        boolean r27 = true;
    L53:
        if (r27 == true) goto L70;
        Integer[] r28 = sbb.d.a;
        UDIcon r29 = ((ButtonProperty) ((q6c.e) this).e).getUdIcon();
        if (r29 == null) goto L58;
        String r30 = r29.getUnicode();
        if (r30 == null) goto L58;
    L59:
        Bitmap r31 = sbb.d.a(r30);
        if (r31 == null) goto L131;
        BitmapDrawable r32 = new BitmapDrawable(r31);
        Integer r33 = this.f;
        if (r33 == null) goto L64;
        int r34 = r33.intValue();
    L65:
        Integer r35 = this.g;
        if (r35 == null) goto L68;
        int r36 = r35.intValue();
    L69:
        r32.setBounds(0, 0, r34, r36);
        k(r8, r23, r24, r32);
        goto L131
    L68:
        r36 = 0;
        goto L69
    L64:
        r34 = 0;
    L58:
        r30 = BuildConfig.FLAVOR;
        goto L59
    L70:
        UDIcon r37 = ((ButtonProperty) ((q6c.e) this).e).getUdIcon();
        if (r37 == null) goto L73;
        String r38 = r37.getKey();
    L74:
        if (r38 != null) goto L76;
    L79:
        boolean r39 = true;
    L80:
        if (r39 == true) goto L108;
        int r40 = edb.a.a;
        UDIcon r41 = ((ButtonProperty) ((q6c.e) this).e).getUdIcon();
        if (r41 == null) goto L84;
        String r42 = r41.getKey();
    L85:
        int r43 = edb.a.a(r42);
        if (r43 == 0) goto L131;
        Drawable r44 = r8.getContext().getResources().getDrawable(r43, null);
        if (r44 == null) goto L99;
        UDIcon r45 = ((ButtonProperty) ((q6c.e) this).e).getUdIcon();
        if (r45 == null) goto L92;
        ThemeColor r46 = r45.getThemeColor();
    L93:
        if (r46 == null) goto L99;
        r44.mutate();
        UDIcon r47 = ((ButtonProperty) ((q6c.e) this).e).getUdIcon();
        if (r47 == null) goto L97;
        ThemeColor r48 = r47.getThemeColor();
    L98:
        Intrinsics.checkNotNull(r48);
        r44.setTint(com.ss.android.lark.export.entity.preview.a.a(r48, r8.getContext(), null));
        goto L99
    L97:
        r48 = null;
        goto L98
    L92:
        r46 = null;
    L99:
        Integer r49 = this.f;
        if (r49 == null) goto L102;
        int r50 = r49.intValue();
    L103:
        Integer r51 = this.g;
        if (r51 == null) goto L106;
        int r52 = r51.intValue();
    L107:
        r44.setBounds(0, 0, r50, r52);
        Intrinsics.checkNotNull(r44);
        k(r8, r23, r24, r44);
        goto L131
    L106:
        r52 = 0;
        goto L107
    L102:
        r50 = 0;
        goto L103
    L84:
        r42 = null;
        goto L85
    L108:
        ImageSet r53 = ((ButtonProperty) ((q6c.e) this).e).getIconKey();
        if (r53 == null) goto L113;
        Image r54 = r53.getThumbnail();
        if (r54 == null) goto L113;
        r1 = r54.getKey();
    L113:
        if (r1 != null) goto L115;
    L118:
        if (r18 == false) goto L120;
        r8.setText(r23);
        goto L131
    L120:
        IRequestCreator r55 = ImageLoader.with(r8.getContext()).load(new EncryptImage(r1));
        g6b.a.InterfaceC0223a r56 = g6b.a.a;
        if (r56 == null) goto L123;
        r56.c();
    L123:
        IRequestCreator r57 = r55.isAsync(false).asDrawable().centerCrop();
        Integer r58 = this.f;
        if (r58 == null) goto L126;
        int r59 = r58.intValue();
    L127:
        Integer r60 = this.g;
        if (r60 == null) goto L130;
        r2 = r60.intValue();
    L130:
        r57.override(r59, r2).error(UDIconUtils.getIconDrawable(r8.getContext(), 2131255013, r8.getCurrentTextColor())).into(new x(this, r8, r23, r24));
        goto L131
    L126:
        r59 = 0;
        goto L127
    L115:
        if (r1.length() == 0) goto L118;
        r18 = false;
        goto L118
    L76:
        if (r38.length() == 0) goto L79;
        r39 = false;
        goto L80
    L73:
        r38 = null;
        goto L74
    L49:
        if (r26.length() == 0) goto L52;
        r27 = false;
        goto L53
    L46:
        r26 = null;
        goto L47
    L26:
        if (r17.length() == 0) goto L29;
        r19 = false;
    L22:
        r17 = null;
        goto L23
    L5:
        r8.setOnClickListener(new c(this));
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((UDButton) r1);
    }

    public static void k(UDButton r4, String r5, Direction r6, Drawable r7) {
        com.larksuite.component.universe_design.button.a r0 = new com.larksuite.component.universe_design.button.a();
        r0.b = r5;
        if (r6 != null) goto L5;
        int r8 = -1;
    L6:
        boolean r1 = true;
        if (r8 != 1) goto L9;
        r0.c = 0;
    L13:
        r0.e = UIHelper.dp2px(4.0f);
        if (r5 != null) goto L16;
    L19:
        if (r1 == false) goto L21;
        r4.setCompoundDrawables(r7, null, null, null);
        return;
    L21:
        com.larksuite.component.universe_design.button.e.d(r4, r7, r0);
        return;
    L16:
        if (r5.length() == 0) goto L19;
        r1 = false;
        goto L19
    L9:
        if (r8 != 2) goto L13;
        r0.c = 1;
        goto L13
    L5:
        r8 = b.a[r6.ordinal()];
        goto L6
    }

    public w(Integer r2, Integer r3, ButtonProperty r4, Style r5, vcb.d r6, com.ss.android.lark.chat.preview.actions.b r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "props");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        super(r4, r5, r6);
        this.f = r2;
        this.g = r3;
        this.h = r7;
        this.i = r8;
        this.k = r6.d;
    }
}
