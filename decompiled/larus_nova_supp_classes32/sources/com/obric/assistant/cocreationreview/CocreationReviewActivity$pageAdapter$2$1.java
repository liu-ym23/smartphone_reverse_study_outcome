package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$pageAdapter$2$1 extends FunctionReferenceImpl implements Function1<q5, View> {
    public CocreationReviewActivity$pageAdapter$2$1(Object r8) {
        super(1, r8, CocreationReviewActivity.class, "renderPageItem", "renderPageItem(Lcom/obric/assistant/cocreationreview/PageItem;)Landroid/view/View;", 0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.app.Activity, android.content.Context, androidx.appcompat.app.AppCompatActivity, com.obric.assistant.cocreationreview.CocreationReviewActivity, java.lang.Object] */
    public final View invoke(q5 r36) {
        Intrinsics.checkNotNullParameter(r36, "p0");
        final ?? r2 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        Set<String> r3 = CocreationReviewActivity.P1;
        r2.getClass();
        int r9 = 17;
        int r10 = 4;
        int r14 = 2;
        int r15 = 1;
        if ((r36 instanceof q5.h) == false) goto L40;
        final p4 r4 = (p4) r2.u.getValue();
        q5.h r0 = (q5.h) r36;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        Context r6 = r4.a;
        LinearLayout r13 = c4.e(r6);
        CocreationTaskFilter[] r11 = CocreationTaskFilter.values();
        int r8 = r11.length;
        int r5 = 0;
        int r22 = 0;
    L5:
        if (r5 >= r8) goto L167;
        final CocreationTaskFilter r7 = r11[r5];
        int r23 = r22 + 1;
        if (r0.d != r7) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        int r24 = -14979842;
    L13:
        int r16 = p4.a.a[r7.ordinal()];
        if (r16 == r15) goto L22;
        if (r16 != r14) goto L17;
        int r17 = r0.b - r0.c;
    L23:
        LinearLayout r18 = c4.k(r6);
        r18.setGravity(r9);
        q5.h r37 = r0;
        r18.setPadding(c4.c(r6, r10), c4.c(r6, 9), c4.c(r6, r10), c4.c(r6, 9));
        if (r12 == false) goto L26;
        int r1 = -14979842;
        int r19 = c4.g(-14979842);
    L27:
        if (r12 == false) goto L29;
        int r20 = c4.i(r1);
        int r21 = 12;
    L30:
        r18.setBackground(c4.h(r6, r19, r21, r20, 1));
        int r25 = r24;
        TextView r26 = c4.f(r6, String.valueOf(r17), 20.0f, r25, 1);
        r26.setGravity(17);
        r18.addView(r26);
        String r27 = r7.getLabel();
        if (r12 == true) goto L34;
        r25 = -9735552;
    L34:
        TextView r28 = c4.f(r6, r27, 12.0f, r25, 0);
        r28.setGravity(17);
        r18.addView(r28);
        r18.setContentDescription(r7.getLabel() + ' ' + r17);
        r18.setSelected(r12);
        r18.setFocusable(true);
        r18.setOnClickListener(new f4(r4, r7));
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(0, c4.c(r6, 64), 1.0f);
        if (r22 <= 0) goto L37;
        r29.leftMargin = c4.c(r6, 10);
    L37:
        Unit r30 = Unit.INSTANCE;
        r13.addView(r18, r29);
        r5 = r5 + 1;
        r0 = r37;
        r22 = r23;
        r9 = 17;
        r10 = 4;
        r14 = 2;
        r15 = 1;
        goto L5
    L29:
        r21 = 12;
        r20 = -1512723;
        goto L30
    L26:
        r1 = -14979842;
        r19 = -1;
        goto L27
    L17:
        if (r16 != 3) goto L20;
        r17 = r0.c;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        r17 = r0.b;
        goto L23
    L12:
        r24 = -15656921;
        goto L13
    L9:
        r12 = false;
        goto L10
    L167:
        return CocreationReviewActivity.j2(r2, r13, 0, c4.c(r2, 16), 2);
    L40:
        if ((r36 instanceof q5.f) == false) goto L68;
        final p4 r31 = (p4) r2.u.getValue();
        q5.f r32 = (q5.f) r36;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "item");
        Context r33 = r31.a;
        final e4 r110 = r32.b;
        LinearLayout r111 = c4.k(r33);
        r111.setPadding(c4.c(r33, 16), c4.c(r33, 12), c4.c(r33, 16), c4.c(r33, 16));
        r111.setBackground(c4.h(r33, -1, 20, -1512723, 1));
        LinearLayout r34 = c4.e(r33);
        r34.addView(r31.b("任务", -15656921));
        boolean r112 = r32.d;
        if (r112 == false) goto L44;
        String r113 = "已运行";
    L45:
        if (r112 == false) goto L47;
        int r114 = -15293622;
    L48:
        TextView r115 = r31.b(r113, r114);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, c4.c(r33, 30));
        r116.leftMargin = c4.c(r33, 8);
        Unit r35 = Unit.INSTANCE;
        r34.addView(r115, r116);
        r34.addView(new View(r34.getContext()), new LinearLayout.LayoutParams(0, 1, 1.0f));
        if (r32.c == false) goto L51;
        String r38 = "取消";
    L52:
        TextView r39 = r31.b(r38, -15656921);
        if (r32.c == false) goto L55;
        String r40 = "收起任务";
    L56:
        r39.setContentDescription(r40);
        r39.setFocusable(true);
        r39.setOnClickListener(new h4(r31, r110));
        r34.addView(r39);
        r34.setOnClickListener(new i4(r31, r110));
        c4.b(r111, r34, 0, 0, 0, 14);
        TextView r41 = c4.f(r33, r110.b, 14.0f, -15656921, 1);
        r41.setLineSpacing(c4.c(r33, 2), 1.15f);
        r41.setOnClickListener(new j4(r31, r110));
        c4.b(r111, r41, 0, c4.c(r33, 10), 0, 10);
        r111.setOnClickListener(new k4(r31, r110));
        if (r32.c == false) goto L168;
        LinearLayout r42 = c4.k(r33);
        r42.setClickable(true);
        r42.setFocusable(false);
        c4.b(r42, c4.f(r33, "你可以结合真实生活需求，改写任务", 12.0f, -9735552, 0), 0, 0, 0, 14);
        final EditText r43 = new EditText(r111.getContext());
        r43.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10000)});
        q4 r44 = r31.b;
        r44.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        String r45 = r44.d.get(r110.a);
        if (r45 != null) goto L61;
        r45 = r110.b;
    L61:
        r43.setText(r45);
        r43.setTextSize(14.0f);
        r43.setTextColor(-15656921);
        r43.setGravity(8388659);
        r43.setInputType(147457);
        r43.setPadding(c4.c(r33, 12), c4.c(r33, 10), c4.c(r33, 12), c4.c(r33, 10));
        r43.setBackground(c4.h(r33, -1, 12, -1512723, 1));
        r43.setVerticalScrollBarEnabled(true);
        r43.setContentDescription("任务内容");
        c4.d(r43);
        r43.setOnFocusChangeListener(new l4(r31));
        c4.b(r42, r43, c4.c(r33, SpeechEvent.SERVER_UPLINK_EVENT_MUTE_CALL), c4.c(r33, 5), 0, 8);
        LinearLayout r46 = c4.e(r33);
        r46.setGravity(8388613);
        TextView r47 = r31.b("还原", -15656921);
        r47.setFocusable(true);
        r47.setOnClickListener(new m4(r43, r31, r110));
        r46.addView(r47, new LinearLayout.LayoutParams(c4.c(r33, 76), c4.c(r33, 36)));
        if (Intrinsics.areEqual(r31.b.g, r110.a) == false) goto L64;
        String r48 = "启动中…";
    L65:
        final TextView r49 = r31.b(r48, -15656921);
        r49.setFocusable(true);
        r49.setOnClickListener(new n4(r31, r110));
        r43.addTextChangedListener(new r5(new o4(r31, r110, r49, r43)));
        p4.a(r49, r43, r31);
        LinearLayout.LayoutParams r50 = new LinearLayout.LayoutParams(c4.c(r33, 76), c4.c(r33, 36));
        r50.leftMargin = c4.c(r33, 8);
        r46.addView(r49, r50);
        c4.b(r42, r46, 0, c4.c(r33, 12), 0, 10);
        c4.b(r111, r42, 0, c4.c(r33, 18), 0, 10);
        goto L168
    L64:
        r48 = "试运行";
    L168:
        return CocreationReviewActivity.j2(r2, r111, 0, c4.c(r2, 12), 2);
    L55:
        r40 = "展开任务";
        goto L56
    L51:
        r38 = "查看";
        goto L52
    L47:
        r114 = -6657518;
        goto L48
    L44:
        r113 = "未运行";
        goto L45
    L68:
        if ((r36 instanceof q5.g) == false) goto L86;
        final p4 r51 = (p4) r2.u.getValue();
        q5.g r52 = (q5.g) r36;
        r51.getClass();
        Intrinsics.checkNotNullParameter(r52, "item");
        if (r52.c == false) goto L73;
        String r53 = r51.a.getString(2131898843);
    L79:
        Intrinsics.checkNotNull(r53);
        TextView r54 = c4.f(r51.a, r53, 14.0f, -9735552, 0);
        r54.setGravity(17);
        r54.setPadding(0, c4.c(r54.getContext(), 36), 0, c4.c(r54.getContext(), 36));
        if (r52.d == false) goto L169;
        if (r52.c == true) goto L169;
        r54.setFocusable(true);
        r54.setOnClickListener(new g4(r51));
    L169:
        return CocreationReviewActivity.j2(r2, r54, 0, 0, 6);
    L73:
        if (r52.d == false) goto L76;
        r53 = r51.a.getString(2131900772);
        goto L79
    L76:
        if (r52.b != CocreationTaskFilter.ALL) goto L78;
        r53 = r51.a.getString(2131902030);
        goto L79
    L78:
        r53 = "暂无" + r52.b.getLabel() + "的任务";
        goto L79
    L86:
        if ((r36 instanceof q5.b) == false) goto L100;
        q5.b r55 = (q5.b) r36;
        LinearLayout r56 = c4.e(r2);
        r56.setGravity(16);
        r56.setClipChildren(false);
        r56.setClipToPadding(false);
        r56.setPadding(0, 0, 0, c4.c(r2, 18));
        int r57 = r2.getResources().getIdentifier("doubao_phone_icon", "drawable", r2.getPackageName());
        ImageView r58 = new ImageView(r2);
        if (r57 == 0) goto L90;
        r58.setImageResource(r57);
    L90:
        r58.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r56.addView(r58, new LinearLayout.LayoutParams(c4.c(r2, 44), c4.c(r2, 44)));
        LinearLayout r59 = c4.k(r2);
        r59.addView(c4.f(r2, r55.b.getTitle(), 20.0f, -15656921, 1));
        TextView r60 = c4.f(r2, "豆包共创评测 " + r55.c, 13.0f, -9735552, 0);
        r60.setPadding(0, c4.c(r2, 4), 0, 0);
        r59.addView(r60);
        LinearLayout.LayoutParams r61 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r61.setMargins(c4.c(r2, 10), 0, c4.c(r2, 10), 0);
        Unit r62 = Unit.INSTANCE;
        r56.addView(r59, r61);
        MainView r63 = r55.b;
        if (r63 != MainView.OVERVIEW) goto L97;
        final q0 r64 = (q0) r2.t.getValue();
        ImageView r65 = r2.g2(r55);
        r64.getClass();
        Intrinsics.checkNotNullParameter(r65, "settlementAction");
        Context r66 = r64.a;
        int r67 = c4.c(r66, 4);
        int r68 = c4.c(r66, 40);
        final LinearLayout r69 = c4.e(r66);
        r69.setPadding(r67, r67, r67, r67);
        r69.setBackground(c4.h(r66, -1, 24, -986637, 1));
        r69.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r69.setElevation(c4.c(r66, 10));
        if (Build.VERSION.SDK_INT < 28) goto L95;
        r69.setOutlineAmbientShadowColor(-14404022);
        r69.setOutlineSpotShadowColor(-14404022);
    L95:
        r65.setImageResource(2131235876);
        r65.setScaleType(ImageView.ScaleType.CENTER);
        r65.setPadding(0, 0, 0, 0);
        r65.setBackground(r64.a(20));
        r69.addView(r65, new LinearLayout.LayoutParams(r68, r68));
        final ImageView r70 = new ImageView(r64.a);
        r70.setImageResource(2131235875);
        r70.setScaleType(ImageView.ScaleType.CENTER);
        r70.setContentDescription(r66.getString(2131898851));
        r70.setFocusable(true);
        r70.setBackground(r64.a(20));
        r69.addView(r70, new LinearLayout.LayoutParams(r68, r68));
        r70.setOnClickListener(new m0(r64, r69, r70));
        r69.addOnAttachStateChangeListener(new p0(r64));
        r56.addView(r69);
    L99:
        FrameLayout r71 = CocreationReviewActivity.j2(r2, r56, c4.c(r2, 10), 0, 4);
        r71.setClipChildren(false);
        r71.setClipToPadding(false);
        return r71;
    L97:
        if (r63 != MainView.REVIEW) goto L99;
        r56.addView(r2.g2(r55), new LinearLayout.LayoutParams(c4.c(r2, 48), c4.c(r2, 48)));
        goto L99
    L100:
        int r72 = 14;
        if ((r36 instanceof q5.d) == false) goto L117;
        q5.d r73 = (q5.d) r36;
        LinearLayout r74 = c4.e(r2);
        r74.setGravity(48);
        Iterator r75 = r73.c.iterator();
        int r76 = 0;
    L104:
        if (r75.hasNext() == false) goto L112;
        Object r117 = r75.next();
        int r118 = r76 + 1;
        if (r76 >= 0) goto L108;
        CollectionsKt.throwIndexOverflow();
    L108:
        o5 r119 = (o5) r117;
        l5 r120 = r119.a;
        int r121 = r119.b;
        int r122 = r119.c;
        int r77 = r119.d;
        int r123 = r119.e;
        LinearLayout r78 = c4.k(r2);
        Iterator r310 = r75;
        r78.setPadding(c4.c(r2, r72), 0, c4.c(r2, r72), c4.c(r2, r72));
        r78.setBackground(c4.h(r2, -1, r72, -1512723, 1));
        View r79 = new View(r2);
        r79.setBackground(c4.h(r2, r120.e, 3, 0, 0));
        c4.b(r78, r79, c4.c(r2, 4), 0, 0, 12);
        LinearLayout r80 = c4.e(r2);
        ImageView r81 = new ImageView(r2);
        r81.setImageResource(r120.d);
        r81.setContentDescription(r120.b);
        r81.setScaleType(ImageView.ScaleType.FIT_CENTER);
        q5.d r311 = r73;
        LinearLayout r312 = r74;
        r81.setPadding(c4.c(r2, 5), c4.c(r2, 5), c4.c(r2, 5), c4.c(r2, 5));
        r81.setBackground(c4.h(r2, c4.g(r120.e), 9, c4.i(r120.e), 1));
        LinearLayout.LayoutParams r82 = new LinearLayout.LayoutParams(c4.c(r2, 34), c4.c(r2, 34));
        r82.setMargins(0, 0, c4.c(r2, 8), 0);
        Unit r83 = Unit.INSTANCE;
        r80.addView(r81, r82);
        r80.addView(c4.f(r2, r120.b, 13.0f, -15656921, 1));
        c4.b(r78, r80, 0, c4.c(r2, 16), 0, 10);
        LinearLayout r84 = c4.e(r2);
        r84.setGravity(80);
        r84.addView(c4.f(r2, String.valueOf(r121), 28.0f, -15656921, 1));
        TextView r85 = c4.f(r2, "条", 13.0f, -9735552, 0);
        r85.setPadding(c4.c(r2, 4), 0, 0, c4.c(r2, 3));
        r84.addView(r85);
        c4.b(r78, r84, 0, c4.c(r2, 16), 0, 10);
        c4.b(r78, r2.U1(), c4.c(r2, 1), c4.c(r2, 12), 0, 8);
        c4.b(r78, c4.f(r2, "已反馈 " + r122 + "\n赞 " + r77 + " / 踩 " + r123, 13.0f, -9735552, 0), 0, c4.c(r2, 10), 0, 10);
        LinearLayout.LayoutParams r86 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        if (r76 != 0) goto L111;
        r86.setMargins(0, 0, c4.c(r2, 10), 0);
    L111:
        r312.addView(r78, r86);
        r75 = r310;
        r74 = r312;
        r76 = r118;
        r73 = r311;
        r72 = 14;
        goto L104
    L112:
        LinearLayout r87 = r74;
        if (r73.c.size() != 1) goto L171;
        r87.addView(new View(r2), new LinearLayout.LayoutParams(0, 1, 1.0f));
    L171:
        return CocreationReviewActivity.j2(r2, r87, 0, c4.c(r2, 12), 2);
    L117:
        if ((r36 instanceof q5.e) == false) goto L136;
        q5.e r88 = (q5.e) r36;
        u5 r89 = r88.c;
        int r90 = r89.a;
        if (r90 != 0) goto L121;
        int r91 = 0;
    L122:
        int r92 = s3.a;
        s3.a("ui.summary", "total=" + r89.a + ", completed=" + r89.b + ", pending=" + r89.c + ", up=" + r89.d + ", down=" + r89.e + ", progress=" + r91);
        LinearLayout r93 = c4.e(r2);
        r93.setGravity(16);
        r93.setPadding(c4.c(r2, 18), c4.c(r2, 12), c4.c(r2, 18), c4.c(r2, 12));
        GradientDrawable.Orientation r94 = GradientDrawable.Orientation.LEFT_RIGHT;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r94, "orientation");
        GradientDrawable r95 = new GradientDrawable(r94, new int[]{-656897, -1});
        r95.setCornerRadius((float) c4.c(r2, 14));
        r95.setStroke(c4.c(r2, 1), -1973274);
        r93.setBackground(r95);
        LinearLayout r96 = c4.k(r2);
        r96.addView(c4.f(r2, "今日进度", 12.0f, -14979842, 1));
        TextView r97 = c4.f(r2, r89.c + " 条待反馈", 20.0f, -15656921, 1);
        r97.setPadding(0, c4.c(r2, 8), 0, 0);
        r96.addView(r97);
        TextView r98 = c4.f(r2, "已反馈 " + r89.b + " / " + r89.a + "，点赞 " + r89.d + "，点踩 " + r89.e, 12.5f, -9735552, 0);
        r98.setPadding(0, c4.c(r2, 6), 0, 0);
        r96.addView(r98);
        ReviewMode r99 = r88.b;
        LinearLayout r100 = c4.e(r2);
        r100.setGravity(16);
        r100.setMinimumHeight(c4.c(r2, 38));
        r100.setPadding(c4.c(r2, 4), c4.c(r2, 4), c4.c(r2, 4), c4.c(r2, 4));
        r100.setBackground(c4.h(r2, -722945, 11, -1512723, 1));
        ReviewMode r101 = ReviewMode.QUEUE;
        String r102 = r101.getLabel();
        if (r99 != r101) goto L125;
        boolean r103 = true;
    L126:
        r100.addView(r2.B2(r102, r103, new l1(r2)), new LinearLayout.LayoutParams(-2, c4.c(r2, 30)));
        ReviewMode r104 = ReviewMode.HISTORY;
        String r105 = r104.getLabel();
        if (r99 != r104) goto L129;
        boolean r106 = true;
    L130:
        r100.addView(r2.B2(r105, r106, new m1(r2)), new LinearLayout.LayoutParams(-2, c4.c(r2, 30)));
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.setMargins(0, c4.c(r2, 10), 0, 0);
        Unit r108 = Unit.INSTANCE;
        r96.addView(r100, r107);
        r93.addView(r96, new LinearLayout.LayoutParams(0, -2, 1.0f));
        int r109 = RangesKt.coerceIn(r91, 0, 100);
        int r124 = c4.c(r2, 64);
        LinearLayout r125 = c4.k(r2);
        r125.setGravity(1);
        StringBuilder r126 = new StringBuilder();
        r126.append(r109);
        r126.append('%');
        TextView r127 = c4.f(r2, r126.toString(), 18.0f, -14979842, 1);
        r127.setGravity(17);
        c4.b(r125, r127, 0, 0, 0, 14);
        FrameLayout r128 = new FrameLayout(r2);
        r128.setBackground(c4.h(r2, -1576963, 8, 0, 0));
        View r129 = new View(r2);
        r129.setBackground(c4.h(r2, -14979842, 8, 0, 0));
        int r130 = (r124 * r109) / 100;
        if (r109 <= 0) goto L133;
        int r131 = c4.c(r2, 4);
    L134:
        r128.addView(r129, new FrameLayout.LayoutParams(RangesKt.coerceAtLeast(r130, r131), c4.c(r2, 5), 16));
        LinearLayout.LayoutParams r132 = new LinearLayout.LayoutParams(r124, c4.c(r2, 5));
        r132.setMargins(0, c4.c(r2, 12), 0, 0);
        r125.addView(r128, r132);
        LinearLayout.LayoutParams r133 = new LinearLayout.LayoutParams(c4.c(r2, 86), -2);
        r133.setMargins(c4.c(r2, 12), 0, 0, 0);
        r93.addView(r125, r133);
        return CocreationReviewActivity.j2(r2, r93, 0, c4.c(r2, 8), 2);
    L133:
        r131 = 0;
        goto L134
    L129:
        r106 = false;
        goto L130
    L125:
        r103 = false;
        goto L126
    L121:
        r91 = (int) ((r89.b / r90) * 100);
        goto L122
    L136:
        if ((r36 instanceof q5.c) == true) goto L159;
        if ((r36 instanceof q5.i) == false) goto L149;
        q5.i r134 = (q5.i) r36;
        a r135 = r134.b;
        a5 r136 = r134.c;
        boolean r137 = r134.d;
        List<b5> r138 = r134.e;
        Object r139 = ((Map) r2.b.getValue()).get(r135.b());
        if (r139 == null) goto L147;
        l0 r140 = (l0) r139;
        int r141 = s3.a;
        s3.a("ui.card", "render recordId=" + r135.a() + ", module=" + r135.b().getRaw() + ", record=" + r135.getClass().getSimpleName() + ", feature=" + r140.getClass().getSimpleName());
        j5 r142 = new j5(r2);
        if (r136.e == false) goto L144;
        b r143 = b.c.a;
    L145:
        w5 r144 = r140.c(r142, r135, r136, r137, r143);
        UsageCardTemplateRenderer r145 = (UsageCardTemplateRenderer) r2.g.getValue();
        String r146 = r144.a;
        int r147 = r144.b;
        e r148 = r144.c;
        a5 r149 = r144.d;
        boolean r150 = r144.e;
        List<d> r151 = r144.f;
        View r152 = r144.g;
        boolean r153 = r144.h;
        List<c> r154 = r144.i;
        z4 r155 = r144.j;
        b r156 = r144.k;
        boolean r157 = r144.m;
        Intrinsics.checkNotNullParameter(r146, "recordId");
        Intrinsics.checkNotNullParameter(r148, "title");
        Intrinsics.checkNotNullParameter(r149, "feedback");
        Intrinsics.checkNotNullParameter(r151, "headerTags");
        Intrinsics.checkNotNullParameter(r152, "domainContent");
        Intrinsics.checkNotNullParameter(r154, "footTags");
        Intrinsics.checkNotNullParameter(r155, "detailView");
        Intrinsics.checkNotNullParameter(r156, "feedbackState");
        Intrinsics.checkNotNullParameter(r138, "feedbackMedia");
        return CocreationReviewActivity.j2(r2, r145.c(new w5(r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r138, r157)), 0, c4.c(r2, 14), 2);
    L144:
        r143 = b.C0079b.a;
        goto L145
    L147:
        throw new IllegalArgumentException(("No CocreationModuleFeature registered for " + r135.b().getRaw()).toString());
    L149:
        if ((r36 instanceof q5.a) == false) goto L157;
        if (r2.B != ReviewMode.QUEUE) goto L153;
        String r158 = "当前没有待反馈内容";
    L154:
        TextView r159 = c4.f(r2, r158, 14.0f, -9735552, 0);
        r159.setGravity(17);
        r159.setPadding(0, c4.c(r2, 56), 0, c4.c(r2, 56));
        return CocreationReviewActivity.j2(r2, r159, 0, c4.c(r2, 12), 2);
    L153:
        r158 = "暂无已反馈历史";
        goto L154
    L157:
        throw new NoWhenBranchMatchedException();
    L159:
        throw new IllegalStateException("Module tabs are rendered by ModuleTabsViewHolder.".toString());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((q5) r1);
    }
}
