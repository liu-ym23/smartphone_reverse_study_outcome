package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.FlexboxLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.cot.detail.j;
import com.ss.android.lark.chat.cot.detail.u;
import com.ss.android.lark.chat.cot.detail.v;
import com.ss.android.lark.chat.cot.detail.w;
import com.ss.android.lark.chat.cot.detail.widget.CollapsibleFlexboxLayout;
import com.ss.android.lark.movable.MarkdownMovableView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotToolCallBlock extends com.ss.android.lark.chat.cot.detail.blueprint.block.a {
    public static final Regex r = null;
    public static final Regex s = null;
    public final j c;
    public final com.ss.android.lark.chat.cot.a d;
    public final boolean e;
    public final Function0<Unit> f;
    public final com.ss.android.lark.chat.cot.detail.blueprint.b.e g;
    public final int h;
    public final int i;
    public final int j;
    public final float k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.blueprint.block.CotToolCallBlock$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m505invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m505invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;
        public final View b;
        public final TextView c;
        public final ImageView d;
        public final LinearLayout e;

        public final View getView() {
            return this.a;
        }

        public final void a(d r6) {
            Iterator r0 = CollectionsKt.listOf(new View[]{this.b, this.c, this.d}).iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            View r1 = (View) r0.next();
            r1.setOnClickListener(r6);
            if (r6 == null) goto L8;
            boolean r4 = true;
        L9:
            r1.setClickable(r4);
            goto L4
        L8:
            r4 = false;
            goto L9
        }

        public b(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            this.a = r4;
            View r0 = r4.findViewById(2131368003);
            this.b = r0;
            this.c = (TextView) r4.findViewById(2131368002);
            this.d = (ImageView) r4.findViewById(2131367997);
            this.e = (LinearLayout) r4.findViewById(2131367998);
            r0.setPaddingRelative(r5, r0.getPaddingTop(), r0.getPaddingEnd(), r0.getPaddingBottom());
        }
    }

    static {
        r = new Regex("`+");
        s = new Regex("[A-Za-z0-9_+.#-]+");
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public static void g(ViewGroup r3) {
        int r0 = r3.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        h(r3.getChildAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static void h(View r2) {
        if ((r2 instanceof MarkdownMovableView) == false) goto L12;
        MarkdownMovableView r3 = (MarkdownMovableView) r2;
        CotMovableSetup.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r3, "view");
        Object r0 = r3.getTag(2131367989);
        if ((r0 instanceof c) == false) goto L7;
        c r1 = (c) r0;
    L8:
        if (r1 == null) goto L10;
        r1.b();
        return;
    L10:
        r3.d();
        return;
    L7:
        r1 = null;
        goto L8
    L12:
        if ((r2 instanceof ViewGroup) == false) goto L17;
        g((ViewGroup) r2);
        return;
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public final void d(k<?> r2) {
        if ((r2 instanceof b) == false) goto L5;
        b r3 = (b) r2;
    L6:
        if (r3 == null) goto L9;
        g(r3.e);
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final MarkdownMovableView f(LinearLayout r9, View r10, String r11) {
        if (r11.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L42;
        CotMovableSetup r2 = CotMovableSetup.a;
        com.ss.android.lark.chat.cot.a r3 = this.d;
        r2.getClass();
        if (CotMovableSetup.a(r3) == true) goto L12;
        return null;
    L12:
        if ((r10 instanceof MarkdownMovableView) == false) goto L14;
        MarkdownMovableView r12 = (MarkdownMovableView) r10;
    L16:
        if (r12 != null) goto L39;
        r12 = new MarkdownMovableView(r9.getContext(), null);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        CotMovableSetup.d(r2, r12, "text-caption", 4);
    L39:
        float r13 = CotMovableSetup.c(r9);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r12, "view");     // Catch: Throwable -> L27
        Object r6 = r12.getTag(2131367989);     // Catch: Throwable -> L27
        if ((r6 instanceof c) == false) goto L22;
        c r7 = (c) r6;     // Catch: Throwable -> L27
    L23:
        if (r7 != null) goto L25;
        r7 = CotMovableSetup.d(r2, r12, "text-caption", 4);     // Catch: Throwable -> L27
    L25:
        r7.c(r11, r13);     // Catch: Throwable -> L27
        return r12;
    L22:
        r7 = null;
    L27:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L36
        CotMovableSetup.a.getClass();     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r12, "view");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r12, "view");     // Catch: Throwable -> L36
        Object r15 = r12.getTag(2131367989);     // Catch: Throwable -> L36
        if ((r15 instanceof c) == false) goto L30;
        c r16 = (c) r15;     // Catch: Throwable -> L36
    L31:
        if (r16 == null) goto L33;
        r16.b();     // Catch: Throwable -> L36
    L34:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
        return null;
    L33:
        r12.d();     // Catch: Throwable -> L36
        goto L34
    L30:
        r16 = null;
    L36:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    L14:
        r12 = null;
        goto L16
    L42:
        return null;
    L5:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.ss.android.lark.chat.cot.detail.blueprint.block.CotToolCallBlock, com.ss.android.lark.chat.cot.detail.blueprint.block.a] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v20, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.ViewGroup, com.google.android.flexbox.FlexboxLayout, com.ss.android.lark.chat.cot.detail.widget.CollapsibleFlexboxLayout] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    public void update(m<com.ss.android.lark.chat.cot.detail.k> r20, q<com.ss.android.lark.chat.cot.detail.k> r21, com.ss.android.lark.chat.cot.detail.k r22) {
        Intrinsics.checkNotNullParameter(r20, "cell");
        Intrinsics.checkNotNullParameter(r21, "layout");
        Intrinsics.checkNotNullParameter(r22, Keys.API_RETURN_KEY_DATA);
        b r1 = (b) r21.c(this.g, this.b, new CotToolCallBlock$update$$inlined$acquireBlockView$1(this));
        Context r3 = r1.a.getContext();
        if (this.e == false) goto L11;
        com.ss.android.lark.chat.cot.detail.widget.a r4 = com.ss.android.lark.chat.cot.detail.widget.a.a;
        Intrinsics.checkNotNull(r3);
        u r8 = r22.c();
        if (r8 == null) goto L7;
        com.ss.android.lark.chat.cot.c r9 = r8.a;
    L8:
        r4.getClass();
        if (com.ss.android.lark.chat.cot.detail.widget.a.h(r3, r9) == false) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        int r6 = this.q;
    L15:
        View r10 = r1.b;
        r10.setPaddingRelative(r6, r10.getPaddingTop(), r1.b.getPaddingEnd(), r1.b.getPaddingBottom());
        String r7 = r22.c;
        if (r7 != null) goto L18;
    L25:
        r7 = r3.getString(2131890941);
    L26:
        ?? r11 = r1.e;
        u r12 = r22.c();
        if (r12 == null) goto L35;
        List<v> r13 = r12.b;
        if (r13 == null) goto L35;
        if ((!r13.isEmpty()) == true) goto L34;
        r13 = null;
    L34:
        if (r13 == null) goto L35;
    L50:
        if (r13.isEmpty() == false) goto L60;
        int r14 = r11.getChildCount() - 1;
        if (r14 < 0) goto L59;
    L53:
        View r15 = r11.getChildAt(r14);
        if (r15 == null) goto L57;
        h(r15);
        r11.removeViewAt(r14);
    L57:
        if (r14 == 0) goto L59;
        r14 = r14 - 1;
    L59:
        r11.setVisibility(8);
        boolean r16 = true;
    L191:
        if (this.e == true) goto L208;
        r1.c.setText(r7);
        TextView r17 = r1.c;
        if (r7.length() != 0) goto L195;
        boolean r18 = true;
    L196:
        if (r18 == false) goto L198;
        int r19 = 8;
    L199:
        r17.setVisibility(r19);
        r1.d.setVisibility(8);
        r1.a(null);
        r1.b.setSelected(false);
        LinearLayout r23 = r1.e;
        if (r23.getChildCount() > 0) goto L203;
        r16 = false;
    L203:
        if (r16 == false) goto L205;
        int r24 = 0;
    L206:
        r23.setVisibility(r24);
        ViewCompat.setAccessibilityDelegate(r1.b, null);
    L239:
        e(r1.a, r22);
        e(r1.c, r22);
        return;
    L205:
        r24 = 8;
        goto L206
    L198:
        r19 = 0;
        goto L199
    L195:
        r18 = false;
        goto L196
    L208:
        if (r1.e.getChildCount() <= 0) goto L210;
        boolean r25 = true;
    L211:
        if (r25 == false) goto L215;
        j r26 = this.c;
        String r27 = r22.a;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "stableId");
        if (r26.a(r27 + "#tool-call") == false) goto L215;
        boolean r28 = true;
    L216:
        r1.c.setText(r7);
        TextView r29 = r1.c;
        if (r7.length() == 0) goto L220;
        r16 = false;
    L220:
        if (r16 == false) goto L222;
        int r30 = 8;
    L223:
        r29.setVisibility(r30);
        ImageView r31 = r1.d;
        if (r25 == false) goto L226;
        int r32 = 0;
    L227:
        r31.setVisibility(r32);
        LinearLayout r33 = r1.e;
        if (r28 == false) goto L230;
        int r34 = 0;
    L231:
        r33.setVisibility(r34);
        r1.b.setSelected(r28);
        if (r25 == true) goto L234;
        r1.a(null);
        ViewCompat.setAccessibilityDelegate(r1.b, null);
        goto L239
    L234:
        ImageView r35 = r1.d;
        if (r28 == false) goto L237;
        int r36 = 2131254267;
    L238:
        r35.setImageResource(r36);
        r1.a(new d(this, r22, r1));
        ViewCompat.setAccessibilityDelegate(r1.b, new CotToolCallBlock$bindExpansion$2());
        goto L239
    L237:
        r36 = 2131255567;
        goto L238
    L230:
        r34 = 8;
        goto L231
    L226:
        r32 = 8;
        goto L227
    L222:
        r30 = 0;
    L215:
        r28 = false;
        goto L216
    L210:
        r25 = false;
        goto L211
    L60:
        Iterator r37 = r13.iterator();
        int r110 = 0;
    L62:
        if (r37.hasNext() == false) goto L174;
        Object r111 = r37.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        v r113 = (v) r111;
        View r114 = r11.getChildAt(r110);
        String r115 = r22.a;
        if ((r113 instanceof v.c) == false) goto L74;
        v.c r116 = (v.c) r113;
        TextView r38 = f(r11, r114, r116.a);
        if (r38 != null) goto L71;
        String r39 = r116.a;
        TextView r117 = new TextView(r11.getContext());
        r117.setText(r39);
        r117.setTextColor(UDColorUtils.getColor(r117.getContext(), 2131106607));
        r117.setTextSize(16.0f);
        r117.setLineSpacing(h18.d.a(r117.getContext(), 2.0f), 1.0f);
        TextView r40 = r117;
    L72:
        int r118 = r112;
        TextView r41 = r40;
    L120:
        ?? r42 = r41;
    L152:
        if (r42 == r114) goto L159;
        if (r114 == null) goto L155;
        h(r114);
        r11.removeViewAt(r110);
    L155:
        LinearLayout.LayoutParams r43 = new LinearLayout.LayoutParams(-1, -2);
        if (r110 <= 0) goto L158;
        r43.topMargin = this.h;
    L158:
        r11.addView(r42, r110, r43);
    L171:
        r37 = r37;
        r110 = r118;
        goto L62
    L159:
        ViewGroup.LayoutParams r44 = r42.getLayoutParams();
        if ((r44 instanceof LinearLayout.LayoutParams) == false) goto L162;
        LinearLayout.LayoutParams r45 = (LinearLayout.LayoutParams) r44;
    L163:
        if (r45 == null) goto L171;
        if (r110 <= 0) goto L167;
        int r46 = this.h;
    L169:
        if (r45.topMargin == r46) goto L171;
        r45.topMargin = r46;
        r42.setLayoutParams(r45);
        goto L171
    L167:
        r46 = 0;
        goto L169
    L162:
        r45 = null;
        goto L163
    L71:
        r40 = r38;
        goto L72
    L74:
        if ((r113 instanceof v.a) == false) goto L121;
        v.a r119 = (v.a) r113;
        String r47 = r119.a;
        if (StringsKt.equals(r119.b, "json", true) == false) goto L94;
        String r48 = StringsKt.trim(r47).toString();
        if (r48.length() != 0) goto L81;
        boolean r120 = true;
    L82:
        if (r120 == true) goto L94;
        char r121 = StringsKt.first(r48);     // Catch: JSONException -> L93
        if (r121 != '[') goto L87;
        String r49 = new JSONArray(r48).toString(2);     // Catch: JSONException -> L93
    L91:
        Intrinsics.checkNotNull(r49);     // Catch: JSONException -> L93
        r47 = r49;
        goto L94
    L87:
        if (r121 == '{') goto L89;
        r49 = r47;
        goto L91
    L89:
        r49 = new JSONObject(r48).toString(2);     // Catch: JSONException -> L93
        goto L91
    L81:
        r120 = false;
    L94:
        String r50 = r119.b;
        r37 = r37;
        r118 = r112;
        Integer r51 = (Integer) SequencesKt.maxOrNull(SequencesKt.map(Regex.findAll$default(r, r47, 0, 2, null), CotToolCallBlock$buildCodeFence$maxBacktickCount$1.INSTANCE));
        if (r51 == null) goto L97;
        int r52 = r51.intValue();
    L98:
        String r53 = StringsKt.repeat("`", Math.max(3, r52 + 1));
        if (r50 == null) goto L113;
        String r54 = StringsKt.trim(r50).toString();
        if (r54 == null) goto L113;
        if (r54.length() <= 0) goto L105;
        boolean r55 = true;
    L106:
        if (r55 == true) goto L108;
    L110:
        boolean r56 = false;
    L111:
        if (r56 == false) goto L113;
    L114:
        if (r54 != null) goto L116;
        r54 = BuildConfig.FLAVOR;
    L116:
        TextView r57 = f(r11, r114, r53 + r54 + '\n' + r47 + '\n' + r53);
        if (r57 != null) goto L119;
        String r58 = r119.b;
        Intrinsics.checkNotNullParameter(r47, "code");
        v.a r59 = new v.a(r47, r58);
        TextView r60 = new TextView(r11.getContext());
        r60.setText(r59.a);
        r60.setTextColor(UDColorUtils.getColor(r60.getContext(), 2131106607));
        r60.setTextSize(16.0f);
        r60.setLineSpacing(h18.d.a(r60.getContext(), 2.0f), 1.0f);
        int r61 = this.i;
        int r62 = this.j;
        r60.setPadding(r61, r62, r61, r62);
        GradientDrawable r63 = new GradientDrawable();
        r63.setCornerRadius(this.k);
        r63.setColor(UDColorUtils.getColor(r60.getContext(), 2131100557));
        r60.setBackground(r63);
        r41 = r60;
        goto L120
    L119:
        r41 = r57;
        goto L120
    L108:
        if (s.matches(r54) == false) goto L110;
        r56 = true;
        goto L111
    L105:
        r55 = false;
    L113:
        r54 = null;
        goto L114
    L97:
        r52 = 0;
        goto L98
    L121:
        r37 = r37;
        r118 = r112;
        if ((r113 instanceof v.b) == false) goto L173;
        v.b r122 = (v.b) r113;
        int r64 = j.b;
        Intrinsics.checkNotNullParameter(r115, "stableId");
        final String r65 = r115 + "#list#" + r110;
        if (r122.a.isEmpty() == false) goto L127;
        final ?? r66 = 0;
    L149:
        if (r66 == 0) goto L151;
        r42 = r66;
        goto L152
    L151:
        r42 = new View(r11.getContext());
        goto L152
    L127:
        r66 = new CollapsibleFlexboxLayout(r11.getContext(), null, 6, 0);
        r66.setFlexWrap(1);
        r66.setCollapsedMaxLines(4);
        r66.setItemHorizontalSpacing(this.n);
        r66.setItemVerticalSpacing(this.n);
        r66.setShowCollapseButtonWhenExpanded(false);
        r66.setExpanded(this.c.a(r65));
        r66.setOnFoldButtonClickListener(new CotToolCallBlock$createListResultAreaView$1$1(this, r65));
        r66.setFoldButtonConfigProvider(new CotToolCallBlock$createListResultAreaView$1$2(r66, this));
        Iterator r67 = r122.a.iterator();
    L129:
        if (r67.hasNext() == false) goto L149;
        w r68 = (w) r67.next();
        ?? r123 = new LinearLayout(r66.getContext());
        r123.setOrientation(0);
        r123.setGravity(17);
        r123.setTag(r68);
        r123.setBackgroundResource(2131232187);
        int r124 = this.l;
        int r125 = this.m;
        r123.setPadding(r124, r125, r124, r125);
        CotMovableSetup r126 = CotMovableSetup.a;
        String r127 = r68.b;
        r126.getClass();
        String r128 = CotMovableSetup.b(r127);
        if (r128 == null) goto L133;
        r123.setClickable(true);
        r123.setOnClickListener(new e(r128));
    L133:
        com.ss.android.lark.chat.cot.c r129 = r68.c;
        if (r129 == null) goto L138;
        ImageView r130 = new ImageView(r123.getContext());
        com.ss.android.lark.chat.cot.detail.widget.a.a.getClass();
        if (com.ss.android.lark.chat.cot.detail.widget.a.e(r130, r129) == false) goto L138;
        int r131 = this.o;
        LinearLayout.LayoutParams r69 = new LinearLayout.LayoutParams(r131, r131);
        r69.setMarginEnd(this.p);
        r130.setLayoutParams(r69);
    L140:
        if (r130 == null) goto L142;
        r123.addView(r130);
    L142:
        TextView r70 = new TextView(r123.getContext());
        String r132 = r68.a;
        if (r132 != null) goto L148;
        r132 = r68.b;
        if (r132 != null) goto L148;
        r132 = BuildConfig.FLAVOR;
    L148:
        r70.setText(r132);
        r70.setTextColor(UDColorUtils.getColor(r70.getContext(), 2131106607));
        r70.setTextSize(14.0f);
        r70.setMaxLines(1);
        r70.setEllipsize(TextUtils.TruncateAt.END);
        r70.setGravity(17);
        r123.addView(r70);
        FlexboxLayout.LayoutParams r71 = new FlexboxLayout.LayoutParams(-2, -2);
        r71.setMargins(0, 0, 0, 0);
        r123.setLayoutParams(r71);
        r66.addView(r123);
    L138:
        r130 = null;
        goto L140
    L173:
        throw new NoWhenBranchMatchedException();
    L174:
        r16 = true;
        int r72 = r13.size();
        int r73 = r11.getChildCount() - 1;
        if (r72 > r73) goto L183;
    L176:
        View r74 = r11.getChildAt(r73);
        if (r74 == null) goto L180;
        h(r74);
        r11.removeViewAt(r73);
    L180:
        if (r73 == r72) goto L183;
        r73 = r73 - 1;
    L183:
        if (r11.getChildCount() != 0) goto L185;
        boolean r75 = true;
    L186:
        if (r75 == false) goto L188;
        int r76 = 8;
    L189:
        r11.setVisibility(r76);
        goto L191
    L188:
        r76 = 0;
        goto L189
    L185:
        r75 = false;
    L35:
        CharSequence r77 = r22.d;
        if (r77 == null) goto L48;
        String r78 = r77.toString();
        if (r78 == null) goto L48;
        if (r78.length() <= 0) goto L42;
        boolean r79 = true;
    L43:
        if (r79 == true) goto L46;
        r78 = null;
    L46:
        if (r78 == null) goto L48;
        r13 = CollectionsKt.listOf(new v.c(r78));
        goto L50
    L42:
        r79 = false;
    L48:
        r13 = CollectionsKt.emptyList();
        goto L50
    L18:
        if (r7.length() <= 0) goto L20;
        boolean r80 = true;
    L21:
        if (r80 == true) goto L24;
        r7 = null;
    L24:
        if (r7 != null) goto L26;
    L20:
        r80 = false;
        goto L21
    L14:
        r6 = 0;
        goto L15
    L7:
        r9 = null;
    L11:
        r5 = false;
        goto L12
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (com.ss.android.lark.chat.cot.detail.k) r3);
    }

    public CotToolCallBlock(g r2, j r3, com.ss.android.lark.chat.cot.a r4, boolean r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "expandStore");
        Intrinsics.checkNotNullParameter(r4, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r6, "onToolCallToggle");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = com.ss.android.lark.chat.cot.detail.blueprint.b.c;
        this.h = (int) h18.d.a(r2.getContext(), 8.0f);
        this.i = (int) h18.d.a(r2.getContext(), 8.0f);
        this.j = (int) h18.d.a(r2.getContext(), 6.0f);
        this.k = h18.d.a(r2.getContext(), 6.0f);
        this.l = (int) h18.d.a(r2.getContext(), 10.0f);
        this.m = (int) h18.d.a(r2.getContext(), 4.0f);
        this.n = (int) h18.d.a(r2.getContext(), 8.0f);
        this.o = (int) h18.d.a(r2.getContext(), 14.0f);
        this.p = (int) h18.d.a(r2.getContext(), 4.0f);
        this.q = (int) h18.d.a(r2.getContext(), 24.0f);
    }
}
