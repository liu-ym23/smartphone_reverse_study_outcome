package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3;

import a20.e;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.LabelType;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.s;
import com.bytedance.android.live.broadcastgame.api.model.t;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.dux.font.DuxFontHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import f10.f;
import g20.g;
import g20.h;
import g20.i;
import h20.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import va1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureTabListItemViewHolderV3;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/AbsOpenFeatureTabListItemViewHolder;", "Lf10/f;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenFeatureTabListItemViewHolderV3 extends AbsOpenFeatureTabListItemViewHolder<f> {
    public static final /* synthetic */ int m = 0;
    public final TextView a;
    public final TextView b;
    public final HSImageView c;
    public final HSImageView d;
    public final View e;
    public final View f;
    public final TextView g;
    public final TextView h;
    public final LinearLayout i;
    public final TextView j;
    public final e k;
    public final OpenFeatureIconCallbackFrom l;

    public static boolean V3(f r1) {
        if ((r1 instanceof f) == true) goto L5;
    L7:
        return false;
    L5:
        if (a.a(((ExtendedToolbarButton.c) r1).k) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence] */
    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder
    public final void T3(f r11) {
        f r7 = r11;
        Intrinsics.checkNotNullParameter(r7, "item");
        List<s> r12 = r7.D.highlightDesc;
        boolean r0 = true;
        String r2 = null;
        if (r12 != null) goto L5;
    L27:
        TextView r13 = this.b;
        if (r13 == null) goto L30;
        r13.setText(r7.C);
    L30:
        String r14 = r7.D.highlightIcon;
        if (r14 != null) goto L33;
    L40:
        this.c.setVisibility(8);
    L41:
        U3(this.a, this.d, this.f, this.i, ((RecyclerView.ViewHolder) this).itemView, this.k, r7, getAdapterPosition());
        return;
    L33:
        if (r14.length() > 0) goto L36;
        r0 = false;
    L36:
        if (r0 == false) goto L38;
        r2 = r14;
    L38:
        if (r2 == null) goto L40;
        this.c.setVisibility(0);
        ImageLoader.bindImage(this.c, r2);
        goto L41
    L5:
        if ((!r12.isEmpty()) == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L27;
        ?? r3 = new SpannableStringBuilder();
        Iterator r15 = r12.iterator();
    L11:
        if (r15.hasNext() == false) goto L18;
        s r4 = (s) r15.next();
        r3.append(r4.text);
        if (r4.highlightText.length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L11;
        r3.append(" ");
        r3.append(r4.highlightText);
        r3.setSpan(new ForegroundColorSpan(s1.i(r4.highlightColor, s1.h(2131107014))), r3.length() - r4.highlightText.length(), r3.length(), 33);
        r3.setSpan(new AbsoluteSizeSpan(13, true), r3.length() - r4.highlightText.length(), r3.length(), 33);
        r3.setSpan(new StyleSpan(1), r3.length() - r4.highlightText.length(), r3.length(), 33);
        goto L11
    L15:
        r5 = false;
        goto L16
    L18:
        ?? r16 = this.b;
        if (r16 == 0) goto L30;
        if (r3.length() != 0) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == false) goto L26;
        r3 = r7.C;
    L26:
        r16.setText(r3);
        goto L30
    L23:
        r6 = false;
        goto L24
    }

    public OpenFeatureTabListItemViewHolderV3(View r2, e r3, OpenFeatureIconCallbackFrom r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "callbackFrom");
        super(r2);
        this.k = r3;
        this.l = r4;
        this.a = (TextView) r2.findViewById(2131391745);
        this.b = (TextView) r2.findViewById(2131391746);
        this.c = (HSImageView) r2.findViewById(2131375147);
        this.d = (HSImageView) r2.findViewById(2131374757);
        this.e = r2.findViewById(2131384095);
        this.f = r2.findViewById(2131362039);
        this.g = (TextView) r2.findViewById(2131365292);
        this.h = (TextView) r2.findViewById(2131372189);
        this.i = (LinearLayout) r2.findViewById(2131372185);
        this.j = (TextView) r2.findViewById(2131391754);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v29 */
    public void U3(TextView r22, HSImageView r23, View r24, LinearLayout r25, View r26, e r27, f r28, int r29) {
        Intrinsics.checkNotNullParameter(r22, "nameView");
        Intrinsics.checkNotNullParameter(r23, "iconView");
        Intrinsics.checkNotNullParameter(r24, "actionView");
        Intrinsics.checkNotNullParameter(r25, "labelLayout");
        Intrinsics.checkNotNullParameter(r26, "itemView");
        Intrinsics.checkNotNullParameter(r28, "item");
        ?? r11 = 0;
        r22.setText(r28.i(false));
        r22.requestLayout();
        GenericDraweeHierarchy r0 = r23.getHierarchy();
        r23.setActualImageResource(((ExtendedToolbarButton.c) r28).i);
        r0.setPlaceholderImage(((ExtendedToolbarButton.c) r28).i);
        r0.setFailureImage(((ExtendedToolbarButton.c) r28).i);
        r23.setHierarchy(r0);
        ?? r4 = 1;
        if ((!((ExtendedToolbarButton.c) r28).p.isEmpty()) == false) goto L11;
        if (((CharSequence) ListProtector.get(((ExtendedToolbarButton.c) r28).p, 0)).length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        r23.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(((ExtendedToolbarButton.c) r28).p, 0))).build());
        goto L11
    L7:
        r1 = false;
    L11:
        if (r28.u == false) goto L18;
        UtilityKotlinExtentionsKt.v(this.e, false);
        UtilityKotlinExtentionsKt.v(this.h, true);
        this.h.setAlpha(0.5f);
        TextView r2 = this.h;
        if (V3(r28) == false) goto L15;
        String r3 = "退出";
    L16:
        r2.setText(r3);
    L53:
        this.h.setTag("button");
        if (TextUtils.isEmpty(r28.D.iconLabel) == false) goto L56;
    L58:
        this.g.setText("");
        UtilityKotlinExtentionsKt.v(this.g, false);
    L59:
        r25.removeAllViews();
        if (r2.a(r28.D.titleLabel) == false) goto L62;
        UtilityKotlinExtentionsKt.v(this.j, true);
        this.j.setText(r28.D.titleLabel);
        this.j.requestLayout();
    L62:
        List<t> r5 = r28.D.highlightLabel;
        if (r5 == null) goto L71;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L66:
        if (r7.hasNext() == false) goto L70;
        Object r13 = r7.next();
        if ((!TextUtils.isEmpty(((t) r13).text)) == false) goto L66;
        r6.add(r13);
        goto L66
    L70:
        List r8 = CollectionsKt.take(r6, 3);
    L72:
        List<v> r9 = r28.D.labels;
        if (r9 == null) goto L82;
        ArrayList r14 = new ArrayList();
        Iterator<T> r12 = r9.iterator();
    L76:
        if (r12.hasNext() == false) goto L81;
        Object r15 = r12.next();
        if ((!TextUtils.isEmpty(((v) r15).text)) == false) goto L76;
        r14.add(r15);
        goto L76
    L81:
        List r16 = CollectionsKt.take(r14, 2);
    L83:
        List r17 = r8;
        if (r17 != null) goto L86;
    L89:
        boolean r18 = true;
    L90:
        float r19 = 10.0f;
        if (r18 == true) goto L166;
        UtilityKotlinExtentionsKt.v(r25, true);
        List r21 = r8;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r110 = r21.iterator();
    L94:
        if (r110.hasNext() == false) goto L96;
        r31.add(((t) r110.next()).text);
        goto L94
    L96:
        Iterator r111 = CollectionsKt.withIndex(r31).iterator();
        if (r111.hasNext() == true) goto L99;
        Object r32 = null;
    L108:
        IndexedValue r33 = (IndexedValue) r32;
        if (r33 == null) goto L111;
        Integer r34 = Integer.valueOf(r33.getIndex() + 1);
    L112:
        Iterator r35 = r21.iterator();
        int r112 = 0;
    L114:
        if (r35.hasNext() == false) goto L187;
        t r113 = (t) r35.next();
        r112 = r112 + r4;
        TextView r114 = new TextView(r26.getContext());
        r114.setMaxLines(r4);
        r114.setEllipsize(TextUtils.TruncateAt.END);
        r114.setSingleLine(r4);
        r114.setText(r113.text);
        r114.setTextSize(r4, r19);
        r114.setGravity(16);
        r114.setPadding(s1.f(3.0f), r11, s1.f(3.0f), r11);
        if (Build.VERSION.SDK_INT < 28) goto L118;
        Typeface r36 = Typeface.create(r114.getTypeface(), b5.BOLD, r11);
    L119:
        r114.setTypeface(r36);
        FrameLayout r37 = new FrameLayout(r25.getContext());
        r37.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        if (r112 == 2) goto L125;
        if (r112 == 3) goto L125;
    L126:
        if (r34 == null) goto L132;
        if (r34.intValue() != r112) goto L132;
        r37.post(new g20.f(r37));
    L132:
        if (r113.labelType != LabelType.GAME_VALUE.getId()) goto L159;
        String r115 = r113.labelNameFontStyle;
        if (r115 != null) goto L136;
    L146:
        r114.setTextColor(s1.i(r113.labelNameFontColor, s1.h(2131107010)));
        SimpleDraweeView r116 = new HSImageView(r25.getContext());
        r116.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r116.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r116.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(s1.f(3.0f)));
        r116.setActualImageResource(2131250560);
        r116.getHierarchy().setPlaceholderImage(2131250560);
        r116.getHierarchy().setFailureImage(2131250560);
        String r38 = r113.labelBottomImageUrl;
        if (r38 != null) goto L149;
    L157:
        r37.addView(r116);
        r37.addView(r114, new ViewGroup.LayoutParams(-2, -1));
        r25.addView(r37);
    L165:
        r19 = 10.0f;
        r4 = 1;
        r11 = 0;
        goto L114
    L149:
        if (r38.length() <= 0) goto L151;
        boolean r117 = true;
    L152:
        if (r117 == true) goto L155;
        r38 = null;
    L155:
        if (r38 == null) goto L157;
        r116.setImageURI(UriProtector.parse(r38));
        Unit r39 = Unit.INSTANCE;
        goto L157
    L151:
        r117 = false;
        goto L152
    L136:
        if (r115.length() <= 0) goto L138;
        boolean r118 = true;
    L139:
        if (r118 == true) goto L142;
        r115 = null;
    L142:
        if (r115 == null) goto L146;
        Lazy r119 = DuxFontHelper.a;
        Typeface r120 = DuxFontHelper.c(r26.getContext(), r115);
        if (r120 == null) goto L146;
        r114.setTypeface(r120);
        Unit r121 = Unit.INSTANCE;
        goto L146
    L138:
        r118 = false;
        goto L139
    L159:
        if (r113.labelType != LabelType.TASK.getId()) goto L163;
        r114.setTextColor(s1.h(2131107010));
        r114.setBackgroundResource(2131250560);
        if (r113.status != 1) goto L164;
        r114.setTextColor(s1.h(2131107058));
        r114.setBackgroundResource(2131250559);
    L164:
        r37.addView(r114, new ViewGroup.LayoutParams(-2, -1));
        r25.addView(r37);
        goto L165
    L163:
        r114.setTextColor(s1.h(2131107013));
        r114.setBackgroundResource(2131250560);
    L125:
        r37.setPadding(s1.f(4.0f), 0, 0, 0);
        goto L126
    L118:
        r36 = Typeface.create(r114.getTypeface(), r4);
    L187:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L192;
        if (r27 != null) goto L202;
    L194:
        r24.setOnClickListener(new h(this, r27, r26, r28, r29));
        if (V3(r28) == false) goto L197;
    L200:
        this.h.setOnClickListener(new i(this, r27, r28, r29));
        return;
    L197:
        if (r28.u == false) goto L200;
        this.h.setOnClickListener(null);
        this.h.setClickable(false);
        return;
    L202:
        r27.b(r26, r28, r29);     // Catch: Exception -> L191
        Unit r41 = Unit.INSTANCE;     // Catch: Exception -> L191
    L191:
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L194
    L192:
        if (r27 == null) goto L194;
        r27.b(r26, r28, r29);
        Unit r42 = Unit.INSTANCE;
        goto L194
    L111:
        r34 = null;
        goto L112
    L99:
        r32 = r111.next();
        if (r111.hasNext() == false) goto L108;
        int r122 = ((String) ((IndexedValue) r32).component2()).length();
    L103:
        Object r123 = r111.next();
        int r124 = ((String) ((IndexedValue) r123).component2()).length();
        if (r122 >= r124) goto L107;
        r122 = r124;
        r32 = r123;
    L107:
        if (r111.hasNext() == true) goto L103;
    L166:
        List r43 = r16;
        if (r43 != null) goto L169;
    L172:
        boolean r44 = true;
    L173:
        if (r44 == true) goto L185;
        int r45 = 1;
        UtilityKotlinExtentionsKt.v(r25, true);
        Iterator r46 = r16.iterator();
        int r47 = 0;
    L176:
        if (r46.hasNext() == false) goto L187;
        v r48 = (v) r46.next();
        r47 = r47 + r45;
        TextView r125 = new TextView(r26.getContext());
        r125.setText(r48.text);
        r125.setTextSize(r45, 10.0f);
        r125.setGravity(17);
        r125.setTextColor(s1.h(2131107013));
        r125.setPadding(s1.f(3.0f), 0, s1.f(3.0f), 0);
        r125.setBackgroundResource(2131250560);
        if (Build.VERSION.SDK_INT < 28) goto L180;
        Typeface r126 = Typeface.create(r125.getTypeface(), b5.BOLD, false);
    L181:
        r125.setTypeface(r126);
        if (r47 != 2) goto L184;
        r125.post(new g(r125));
    L184:
        r25.addView(r125, new ViewGroup.LayoutParams(-2, -1));
        r45 = 1;
        goto L176
    L180:
        r126 = Typeface.create(r125.getTypeface(), 1);
        goto L181
    L185:
        UtilityKotlinExtentionsKt.v(r25, false);
        goto L187
    L169:
        if (r43.isEmpty() == true) goto L172;
        r44 = false;
        goto L173
    L86:
        if (r17.isEmpty() == true) goto L89;
        r18 = false;
        goto L90
    L82:
        r16 = null;
        goto L83
    L71:
        r8 = null;
        goto L72
    L56:
        if (r28.A == false) goto L58;
        this.g.setText(r28.D.iconLabel);
        UtilityKotlinExtentionsKt.v(this.g, true);
        goto L59
    L15:
        r3 = "已启动";
        goto L16
    L18:
        if (r28.v == false) goto L21;
        UtilityKotlinExtentionsKt.v(this.e, false);
        UtilityKotlinExtentionsKt.v(this.h, true);
        this.h.setAlpha(0.5f);
        this.h.setText("已绑定");
        goto L53
    L21:
        if (r28.k() == false) goto L35;
        UtilityKotlinExtentionsKt.v(this.e, true);
        String r49 = r28.h();
        if (r49 != null) goto L25;
    L36:
        this.h.setAlpha(1.0f);
        TextView r51 = this.h;
        k0 r52 = r28.F;
        if (r52 == null) goto L39;
        String r53 = r52.text;
    L40:
        r51.setText(r53);
        k0 r54 = r28.F;
        if (r54 == null) goto L43;
        String r55 = r54.text;
    L44:
        if (r55 != null) goto L46;
    L49:
        boolean r56 = true;
    L50:
        if (r56 == false) goto L52;
        UtilityKotlinExtentionsKt.v(this.h, false);
        goto L53
    L52:
        UtilityKotlinExtentionsKt.v(this.h, true);
        goto L53
    L46:
        if (r55.length() == 0) goto L49;
        r56 = false;
        goto L50
    L43:
        r55 = null;
        goto L44
    L39:
        r53 = null;
        goto L40
    L25:
        if (r49.length() <= 0) goto L27;
        boolean r57 = true;
    L28:
        if (r57 == true) goto L31;
        r49 = null;
    L31:
        if (r49 == null) goto L36;
        ((IBroadcastService) b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L27:
        r57 = false;
        goto L28
    L35:
        UtilityKotlinExtentionsKt.v(this.e, false);
        goto L36
    }
}
