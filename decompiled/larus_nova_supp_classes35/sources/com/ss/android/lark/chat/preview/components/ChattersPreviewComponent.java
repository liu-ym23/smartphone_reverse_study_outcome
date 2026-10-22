package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.preview.components.baseview.CrescentAvatarListView;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.export.entity.preview.Gradient;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChattersPreviewComponent extends q6c.e<ChattersPreviewProperty, CrescentAvatarListView, r6c.a> {
    public final com.ss.android.lark.chat.preview.actions.b f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Theme.values().length];
            r0[Theme.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Theme.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ChattersPreviewComponent a;

        public c(ChattersPreviewComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.f.a(1);
        }
    }

    static {
    }

    public final String i() {
        return "com.ss.android.lark.chat.preview.components.baseview.CrescentAvatarListView";
    }

    public final boolean j() {
        return true;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new CrescentAvatarListView(r1.getContext());
    }

    public final s6c.b.a d(s6c.b.a r9) {
        Intrinsics.checkNotNullParameter(r9, "size");
        int r0 = CrescentAvatarListView.k;
        TCStyle r1 = ((q6c.b) this).c;
        if ((r1 instanceof Style) == false) goto L5;
        Style r2 = (Style) r1;
    L7:
        if (r2 == null) goto L9;
        float r3 = r2.getWidth();
    L10:
        float r4 = UIHelper.dp2px(r3);
        Integer r5 = ((ChattersPreviewProperty) ((q6c.e) this).e).getChatterCounts();
        int r6 = 5;
        if (r5 == null) goto L13;
        int r7 = r5.intValue();
    L14:
        Integer r8 = ((ChattersPreviewProperty) ((q6c.e) this).e).getMaxShowCount();
        if (r8 == null) goto L17;
        int r10 = r8.intValue();
    L18:
        int r11 = Math.min(r7, r10);
        Integer r12 = ((ChattersPreviewProperty) ((q6c.e) this).e).getChatterCounts();
        int r13 = 0;
        if (r12 == null) goto L21;
        int r14 = r12.intValue();
    L22:
        Integer r15 = ((ChattersPreviewProperty) ((q6c.e) this).e).getMaxShowCount();
        if (r15 == null) goto L25;
        r6 = r15.intValue();
    L25:
        if (r14 <= r6) goto L27;
        r13 = 1;
    L27:
        int r16 = r11 + r13;
        if (r4 <= 0.0f) goto L30;
        int r17 = (int) r4;
    L31:
        float r18 = zz7.b.f(r0);
        return new s6c.b.a(Math.min(r9.a, UIHelper.px2dp(zz7.b.f(r17))), UIHelper.px2dp(r18));
    L30:
        r17 = r0 * r16;
        goto L31
    L21:
        r14 = 0;
        goto L22
    L17:
        r10 = 5;
        goto L18
    L13:
        r7 = 5;
        goto L14
    L9:
        r3 = 0.0f;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.ss.android.lark.chat.preview.components.ChattersPreviewComponent$update$1$2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void update(final CrescentAvatarListView r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        float r1 = r15.getLayoutParams().width;
        Integer r2 = ((ChattersPreviewProperty) ((q6c.e) this).e).getChatterCounts();
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        Integer r4 = ((ChattersPreviewProperty) ((q6c.e) this).e).getMaxShowCount();
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L11:
        if (r3 <= r5) goto L13;
        int r6 = 1;
    L14:
        float r7 = zz7.b.d().getMultiplier() * CrescentAvatarListView.k;
        ChattersPreviewProperty r8 = (ChattersPreviewProperty) ((q6c.e) this).e;
        int r9 = MathKt.roundToInt((r1 / r7) - r6);
        Integer r10 = ((ChattersPreviewProperty) ((q6c.e) this).e).getMaxShowCount();
        if (r10 == null) goto L17;
        int r11 = r10.intValue();
    L18:
        r8.setMaxShowCount(Integer.valueOf(Math.min(r9, r11)));
        List<ChatterPreviewChatterInfo> r12 = ((ChattersPreviewProperty) ((q6c.e) this).e).getChatterInfoList();
        if (r12 == null) goto L42;
        Iterator<ChatterPreviewChatterInfo> r13 = r12.iterator();
    L22:
        if (r13.hasNext() == false) goto L39;
        String r14 = r13.next().getAvatarKey();
        if (r14 != null) goto L26;
    L29:
        boolean r16 = true;
    L30:
        if (r16 == false) goto L22;
        g6b.a.InterfaceC0223a r17 = g6b.a.a;
        if (r17 == 0) goto L38;
        List<ChatterPreviewChatterInfo> r18 = r12;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L35:
        if (r20.hasNext() == false) goto L37;
        r19.add(((ChatterPreviewChatterInfo) r20.next()).getChatterId());
        goto L35
    L37:
        r17.f(r19, new ChattersPreviewComponent$update$1$2(r15, this));
    L38:
        boolean r21 = true;
    L40:
        if (r21 == true) goto L42;
        r15.setData((ChattersPreviewProperty) ((q6c.e) this).e);
        goto L42
    L26:
        if (r14.length() == 0) goto L29;
        r16 = false;
        goto L30
    L39:
        r21 = false;
    L42:
        TextView r22 = r15.getParticipantsNumbView();
        TCStyle r23 = ((q6c.b) this).c;
        Style r24 = null;
        if ((r23 instanceof Style) == false) goto L45;
        Style r25 = (Style) r23;
    L46:
        if (r25 == null) goto L48;
        Gradient r26 = r25.getBackgroundColor();
    L49:
        int r27 = -1;
        if (r26 == null) goto L66;
        TCStyle r28 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Gradient r29 = ((Style) r28).getBackgroundColor();
        Intrinsics.checkNotNull(r29);
        Gradient.Content r30 = r29.getContent();
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
        ArrayList<ThemeColor> r31 = ((Gradient.Linear) r30).getThemeColors();
        if (r31 == null) goto L76;
        int[] r32 = new int[r31.size()];
        int r110 = r31.size();
        int r111 = 0;
    L54:
        if (r111 >= r110) goto L59;
        int r112 = com.ss.android.lark.export.entity.preview.a.a((ThemeColor) ListProtector.get(r31, r111), r22.getContext(), null);
        if (r112 != 0) goto L58;
        r112 = UIUtils.getColor(r22.getContext(), 2131100556);
    L58:
        r32[r111] = r112;
        r111 = r111 + 1;
        goto L54
    L59:
        GradientDrawable r113 = new GradientDrawable();
        if (r31.size() != 1) goto L63;
        r113.setColor(r32[0]);
    L65:
        r113.setShape(1);
        r113.setCornerRadius(UIHelper.dp2px(4.0f));
        r22.setBackground(r113);
        goto L76
    L63:
        if (r31.size() <= 1) goto L65;
        r113.setColors(r32);
    L76:
        TextView r33 = r15.getParticipantsNumbView();
        Intrinsics.checkNotNullParameter(r15, "view");
        TCStyle r0 = ((q6c.b) this).c;
        if ((r0 instanceof Style) == false) goto L79;
        Style r34 = (Style) r0;
    L80:
        if (r34 == null) goto L84;
        ThemeColor r35 = r34.getTextColorV2();
        if (r35 == null) goto L84;
        int r36 = com.ss.android.lark.export.entity.preview.a.a(r35, r15.getContext(), null);
    L94:
        r33.setTextColor(r36);
        TCStyle r37 = ((q6c.b) this).c;
        if ((r37 instanceof Style) == false) goto L97;
        r24 = (Style) r37;
    L97:
        if (r24 == null) goto L99;
        TextPaint r38 = r15.getParticipantsNumbView().getPaint();
        int r39 = h6b.a.a;
        r38.setFakeBoldText(h6b.a.a(r24.getFontLevel()));
    L99:
        r15.setOnClickListener(new c(this));
        return;
    L84:
        Theme r40 = ((ChattersPreviewProperty) ((q6c.e) this).e).getTheme();
        if (r40 == null) goto L89;
        r27 = b.a[r40.ordinal()];
    L89:
        if (r27 == 1) goto L93;
        if (r27 == 2) goto L92;
        r36 = UDColorUtils.getAlphaColor(r15.getContext(), 2131106500, 0.5f);
        goto L94
    L92:
        r36 = UDColorUtils.getColor(r15.getContext(), 2131108717);
        goto L94
    L93:
        r36 = UDColorUtils.getAlphaColor(r15.getContext(), 2131106500, 0.5f);
        goto L94
    L79:
        r34 = null;
        goto L80
    L66:
        GradientDrawable r41 = new GradientDrawable();
        r41.setShape(1);
        Theme r42 = ((ChattersPreviewProperty) ((q6c.e) this).e).getTheme();
        if (r42 != null) goto L69;
        int r43 = -1;
    L70:
        if (r43 == 1) goto L74;
        if (r43 != 2) goto L75;
        r41.setColor(UDColorUtils.getAlphaColor(r22.getContext(), 2131108713, 0.1f));
    L75:
        r22.setBackground(r41);
        goto L76
    L74:
        r41.setColor(UDColorUtils.getAlphaColor(r22.getContext(), 2131106500, 0.2f));
        goto L75
    L69:
        r43 = b.a[r42.ordinal()];
        goto L70
    L48:
        r26 = null;
        goto L49
    L45:
        r25 = null;
        goto L46
    L17:
        r11 = 0;
        goto L18
    L13:
        r6 = 0;
        goto L14
    L9:
        r5 = 5;
        goto L11
    L5:
        r3 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((CrescentAvatarListView) r1);
    }

    public ChattersPreviewComponent(ChattersPreviewProperty r2, Style r3, vcb.d r4, com.ss.android.lark.chat.preview.creator.b r5) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Intrinsics.checkNotNullParameter(r5, Keys.API_PARAM_KEY_ACTION);
        super(r2, r3, r4);
        this.f = r5;
    }
}
