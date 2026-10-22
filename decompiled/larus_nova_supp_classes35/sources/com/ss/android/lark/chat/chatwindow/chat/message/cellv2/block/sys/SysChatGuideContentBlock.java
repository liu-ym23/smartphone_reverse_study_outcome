package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewGroupKt;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.I18nText;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SystemGuideCTAItem;
import com.bytedance.lark.pb.basic.v1.SystemGuideContent;
import com.bytedance.lark.pb.basic.v1.SystemMessageItemAction;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.d;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import h18.f;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SysChatGuideContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<d>, Object> {
    public final IMMessageKeys$Blocks g;
    public final int h;

    public static final class a implements k<View> {
        public final View a;
        public final View b;
        public final View c;
        public final FrameLayout d;
        public final FrameLayout e;

        public final View getView() {
            return this.a;
        }

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r2.findViewById(2131387975);
            this.c = r2.findViewById(2131387971);
            this.d = (FrameLayout) r2.findViewById(2131387978);
            this.e = (FrameLayout) r2.findViewById(2131387977);
        }
    }

    public static final class b {
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public SysChatGuideContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.SYS_CHAT_GUIDE;
        this.h = zz7.b.g(getContext(), 16);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<y6b.a<d>> r31, q<y6b.a<d>> r32, y6b.a<d> r33) {
        Intrinsics.checkNotNullParameter(r31, "cell");
        Intrinsics.checkNotNullParameter(r32, "layout");
        Intrinsics.checkNotNullParameter(r33, Keys.API_RETURN_KEY_DATA);
        Content.SystemExtraContent r2 = ((SystemContent) r33.b().a).getSystemExtraContent();
        if (r2 == null) goto L110;
        SystemGuideContent r3 = r2.guide_content;
        if (r3 == null) goto L110;
        a r1 = (a) r32.c(this.g, IMMessageKeys$Slots.CONTENT, SysChatGuideContentBlock$update$blockView$1.INSTANCE);
        r1.b.setVisibility(8);
        r1.c.setVisibility(8);
        r1.e.setVisibility(0);
        r1.d.setVisibility(0);
        LinearLayout r4 = new LinearLayout(getContext());
        r4.setGravity(1);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r4.setOrientation(1);
        LinearLayout r7 = new LinearLayout(getContext());
        r7.setGravity(1);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        View r9 = new View(getContext());
        r9.setBackground(UIUtils.getDrawable(this.c.getContext(), 2131232172));
        TextView r10 = new TextView(getContext());
        r10.setGravity(1);
        I18nText r11 = r3.title;
        if (r11 == null) goto L10;
        String r12 = r11.localized_text;
    L11:
        String r13 = BuildConfig.FLAVOR;
        if (r12 != null) goto L14;
        r12 = BuildConfig.FLAVOR;
    L14:
        r10.setText(r12);
        r10.setTextColor(UDColorUtils.getColor(r10.getContext(), 2131106622));
        zz7.a.d(r10, LarkFont.TITLE3);
        r10.setTypeface(Typeface.DEFAULT_BOLD);
        TextView r14 = new TextView(getContext());
        r14.setGravity(1);
        I18nText r15 = r3.sub_title;
        if (r15 == null) goto L17;
        String r16 = r15.localized_text;
    L18:
        if (r16 != null) goto L20;
        r16 = BuildConfig.FLAVOR;
    L20:
        r14.setText(r16);
        r14.setTextColor(UDColorUtils.getColor(r14.getContext(), 2131106620));
        zz7.a.d(r14, LarkFont.BODY1);
        AppCompatImageView r17 = new AppCompatImageView(getContext());
        r17.setVisibility(8);
        if (f.a(r17.getContext()) == false) goto L23;
        ImageSetPassThrough r18 = r3.dm_image;
    L24:
        IRequestCreator r19 = ImageLoader.with(r17.getContext());
        if (r18 == null) goto L27;
        String r5 = r18.key;
    L28:
        if (r5 != null) goto L30;
        r5 = BuildConfig.FLAVOR;
    L30:
        if (r18 == null) goto L32;
        String r110 = r18.fs_unit;
    L33:
        r19.load(new PassThroughImage(r5, r110)).override(UIHelper.dp2px(176.0f), UIHelper.dp2px(132.0f)).listener(new c(r17)).into(r17);
        r4.addView(r10);
        r4.addView(r14);
        r4.addView(r17);
        r7.addView(r9);
        Iterator r6 = r3.items.iterator();
    L35:
        if (r6.hasNext() == false) goto L73;
        SystemGuideCTAItem r8 = (SystemGuideCTAItem) r6.next();
        if (f.a(r4.getContext()) == false) goto L39;
        ImageSetPassThrough r111 = r8.dm_icon;
    L40:
        String r20 = r8.id;
        I18nText r112 = r8.text;
        if (r112 == null) goto L43;
        String r113 = r112.localized_text;
    L44:
        SystemMessageItemAction r21 = r8.action;
        if (r21 == null) goto L58;
        SystemMessageItemAction.Url r22 = r21.url;
        if (r22 == null) goto L58;
        String r23 = r22.android;
        if (r23 != null) goto L51;
    L54:
        boolean r24 = true;
    L55:
        if (r24 == false) goto L57;
        String r25 = r22.common;
    L59:
        UDButton r26 = new UDButton(getContext(), null, 0, 6, null);
        Iterator r114 = r6;
        r26.setGravity(1);
        String r27 = r13;
        View r28 = r9;
        SystemGuideContent r29 = r3;
        r26.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(7.0f), UIHelper.dp2px(16.0f), UIHelper.dp2px(7.0f));
        r26.setBackgroundColor(UDColorUtils.getColorStateList(r26.getContext(), 2131108893));
        r26.setTextColor(UDColorUtils.getColor(r26.getContext(), 2131108884));
        r26.setStrokeColor(UDColorUtils.getColor(r26.getContext(), 2131103352));
        r26.setStrokeWidth(UIHelper.dp2px(1.0f));
        r26.setCornerRadius(UIHelper.dp2px(6.0f));
        r26.setSingleLine();
        if (r113 != null) goto L62;
        String r30 = r27;
    L63:
        r26.setText(r30);
        zz7.a.d(r26, LarkFont.HEADLINE);
        IRequestCreator r34 = ImageLoader.with(r26.getContext()).asDrawable();
        if (r111 == null) goto L66;
        String r35 = r111.key;
    L67:
        if (r35 != null) goto L69;
        r35 = r27;
    L69:
        if (r111 == null) goto L71;
        String r115 = r111.fs_unit;
    L72:
        IRequestCreator r36 = r34.load(new PassThroughImage(r35, r115));
        int r37 = this.h;
        r36.override(r37, r37).into(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.a(this, r26, r113));
        r26.setOnClickListener(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.b(r26, r25, r20));
        r4.addView(r26);
        r6 = r114;
        r13 = r27;
        r9 = r28;
        r3 = r29;
        goto L35
    L71:
        r115 = null;
        goto L72
    L66:
        r35 = null;
        goto L67
    L62:
        r30 = r113;
        goto L63
    L57:
        r25 = r22.android;
        goto L59
    L51:
        if (r23.length() == 0) goto L54;
        r24 = false;
    L58:
        r25 = null;
        goto L59
    L43:
        r113 = null;
        goto L44
    L39:
        r111 = r8.lm_icon;
        goto L40
    L73:
        SystemGuideContent r210 = r3;
        View r211 = r9;
        String r212 = r13;
        FrameLayout r38 = r1.e;
        r38.removeAllViews();
        r38.addView(r4);
        ViewGroup.LayoutParams r39 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r39, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r39).gravity = 1;
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r40 = new LinearLayout.LayoutParams(-2, -2);
        r40.topMargin = UIHelper.dp2px(4.0f);
        r14.setLayoutParams(r40);
        LinearLayout.LayoutParams r41 = new LinearLayout.LayoutParams(-2, -2);
        r41.topMargin = UIHelper.dp2px(20.0f);
        r41.bottomMargin = UIHelper.dp2px(4.0f);
        r17.setLayoutParams(r41);
        Iterator r42 = ViewGroupKt.getChildren(r4).iterator();
    L75:
        if (r42.hasNext() == false) goto L79;
        UDButton r43 = (View) r42.next();
        if ((r43 instanceof UDButton) == false) goto L75;
        LinearLayout.LayoutParams r44 = new LinearLayout.LayoutParams(-2, -2);
        r44.topMargin = UIHelper.dp2px(16.0f);
        r43.setLayoutParams(r44);
        goto L75
    L79:
        ChatThemeInfo r45 = this.c.r8();
        if (r45 != null) goto L82;
        return;
    L82:
        if (p.g(r45.getComponentScene()) == false) goto L108;
        r1.d.setVisibility(0);
        FrameLayout r46 = r1.d;
        r46.removeAllViews();
        r46.addView(r7);
        ViewGroup.LayoutParams r47 = r7.getLayoutParams();
        Intrinsics.checkNotNull(r47, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r47).gravity = 1;
        Rect r48 = new Rect();
        I18nText r49 = r210.sub_title;
        if (r49 == null) goto L86;
        String r50 = r49.localized_text;
    L87:
        if (r50 != null) goto L89;
        r50 = r212;
    L89:
        r14.getPaint().getTextBounds(r50, 0, r50.length(), r48);
        int r51 = r48.width() + (UIUtils.dp2px(getContext(), 8.0f) * 2);
        Rect r52 = new Rect();
        Rect r53 = new Rect();
        I18nText r54 = r210.title;
        if (r54 == null) goto L92;
        String r55 = r54.localized_text;
    L93:
        if (r55 != null) goto L95;
        String r116 = r212;
    L96:
        I18nText r56 = r210.sub_title;
        if (r56 == null) goto L99;
        String r117 = r56.localized_text;
    L100:
        if (r117 != null) goto L102;
        String r57 = r212;
    L103:
        r10.getPaint().getTextBounds(r116, 0, r116.length(), r52);
        r14.getPaint().getTextBounds(r57, 0, r57.length(), r53);
        Integer r58 = f3b.b.a(this.c);
        if (r58 == null) goto L106;
        int r59 = r58.intValue();
        Context r60 = getContext();
        Intrinsics.checkNotNullParameter(r60, "context");
        int r61 = UIUtils.dp2px(r60, 24.0f);
    L107:
        int r213 = r59 - (r61 * 2);
        r211.setLayoutParams(new LinearLayout.LayoutParams(r51, ((new StaticLayout(r116, r10.getPaint(), r213, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getHeight() + new StaticLayout(r57, r14.getPaint(), r213, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getHeight()) + UIUtils.dp2px(getContext(), 4.0f)) + UIUtils.dp2px(getContext(), 4.0f)));
        return;
    L106:
        r59 = DeviceUtils.getScreenWidth(getContext());
        Context r62 = getContext();
        Intrinsics.checkNotNullParameter(r62, "context");
        r61 = UIUtils.dp2px(r62, 24.0f);
        goto L107
    L102:
        r57 = r117;
        goto L103
    L99:
        r117 = null;
        goto L100
    L95:
        r116 = r55;
        goto L96
    L92:
        r55 = null;
        goto L93
    L86:
        r50 = null;
        goto L87
    L108:
        r1.d.setVisibility(8);
        return;
    L32:
        r110 = null;
        goto L33
    L27:
        r5 = null;
        goto L28
    L23:
        r18 = r3.lm_image;
        goto L24
    L17:
        r16 = null;
        goto L18
    L10:
        r12 = null;
    L110:
        Log.e("SysChatGuideContentBlock", "chat guide system content is empty, id：" + r33.getId());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(m<y6b.a<d>> r1, q<y6b.a<d>> r2, y6b.a<d> r3) {
        update2(r1, r2, r3);
    }
}
