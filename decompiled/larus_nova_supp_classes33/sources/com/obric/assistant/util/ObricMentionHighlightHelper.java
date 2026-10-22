package com.obric.assistant.util;

import android.content.Context;
import android.graphics.Point;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.widget.ShadowLayout;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricMentionHighlightHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/util/ObricMentionHighlightHelper$ObricSelectedMentionForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "color", "", "skillId", "", "<init>", "(ILjava/lang/String;)V", "getSkillId", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricSelectedMentionForegroundColorSpan extends ForegroundColorSpan {
        public final String a;

        public ObricSelectedMentionForegroundColorSpan(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "skillId");
            super(r2);
            this.a = r3;
        }
    }

    public static final class a implements TextWatcher {
        public final EditText a;
        public final int b;
        public final Function0<Boolean> c;
        public final Function0<List<paa.e>> d;
        public final Function1<String, Unit> e;
        public final Function1<String, Unit> f;
        public a2 g;
        public Integer h;
        public boolean i;
        public boolean j;
        public boolean k;
        public c l;
        public View.OnKeyListener m;
        public final LinkedHashSet<String> n;
        public final t1 o;
        public final s1 p;

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public final boolean d() {
            Editable r0 = this.a.getText();
            if (r0 != null) goto L5;
            return false;
        L5:
            int r2 = this.a.getSelectionStart();
            int r3 = this.a.getSelectionEnd();
            if (r2 < 0) goto L81;
            if (r3 < 0) goto L81;
            if (r2 == r3) goto L28;
            c r4 = c(r0, Math.min(r2, r3), Math.max(r2, r3));
            if (r4 == null) goto L90;
            this.j = true;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L24
            Object[] r6 = r0.getSpans(r4.a, r4.b, ObricSelectedMentionForegroundColorSpan.class);     // Catch: Throwable -> L24
            int r7 = r6.length;     // Catch: Throwable -> L24
            int r8 = 0;
        L16:
            if (r8 >= r7) goto L18;
            r0.removeSpan(r6[r8]);     // Catch: Throwable -> L24
            r8 = r8 + 1;     // Catch: Throwable -> L24
            goto L16
        L18:
            r0.delete(r4.a, r4.b);     // Catch: Throwable -> L24
            Iterator<T> r1 = r4.e.iterator();     // Catch: Throwable -> L24
        L20:
            if (r1.hasNext() == false) goto L22;
            m((String) r1.next());     // Catch: Throwable -> L24
            goto L20
        L22:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            this.j = false;
            return true;
        L24:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        L90:
            return false;
        L28:
            Object[] r10 = r0.getSpans(0, r0.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r11 = r10.length;
            int r12 = 0;
        L30:
            if (r12 >= r11) goto L60;
            Object r13 = r10[r12];
            ObricSelectedMentionForegroundColorSpan r14 = (ObricSelectedMentionForegroundColorSpan) r13;
            Intrinsics.checkNotNull(r14);
            int r15 = r0.getSpanStart(r14);
            int r16 = r0.getSpanEnd(r14);
            if (r15 < 0) goto L56;
            if (r16 <= r15) goto L56;
            if (r2 != r16) goto L37;
            boolean r17 = true;
        L39:
            if (r2 != (r16 + 1)) goto L46;
            Character r18 = StringsKt.getOrNull(r0, r16);
            if (r18 == null) goto L46;
            if (r18.charValue() != ' ') goto L46;
            boolean r19 = true;
        L48:
            if ((r15 + 1) > r2) goto L51;
            if (r2 > r16) goto L51;
            boolean r20 = true;
        L52:
            if (r17 == true) goto L55;
            if (r19 == true) goto L55;
            if (r20 == false) goto L56;
        L55:
            boolean r21 = true;
        L57:
            if (r21 == true) goto L61;
            r12 = r12 + 1;
        L61:
            ObricSelectedMentionForegroundColorSpan r22 = (ObricSelectedMentionForegroundColorSpan) r13;
            if (r22 != null) goto L64;
            return false;
        L64:
            int r23 = r0.getSpanStart(r22);
            int r24 = r0.getSpanEnd(r22);
            if (r23 < 0) goto L81;
            if (r24 <= r23) goto L81;
            Character r25 = StringsKt.getOrNull(r0, r24);
            if (r25 != null) goto L72;
        L74:
            this.j = true;
            Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L77
            r0.removeSpan(r22);     // Catch: Throwable -> L77
            r0.delete(r23, RangesKt.coerceAtMost(r24, r0.length()));     // Catch: Throwable -> L77
            m(r22.a);     // Catch: Throwable -> L77
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L77
        L79:
            this.j = false;
            return true;
        L77:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L79
        L72:
            if (r25.charValue() != ' ') goto L74;
            r24 = r24 + 1;
        L51:
            r20 = false;
        L46:
            r19 = false;
            goto L48
        L37:
            r17 = false;
        L56:
            r21 = false;
            goto L57
        L60:
            r13 = null;
        L81:
            return false;
        }

        public final void e() {
            a2 r0 = this.g;
            if (r0 == null) goto L8;
            PopupWindow r2 = r0.d;
            if (r2 == null) goto L7;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
        L7:
            r0.d = null;
            r0.e = null;
        L8:
            this.g = null;
        }

        public final void a(Spannable r13) {
            if (this.k == true) goto L82;
            if (r13 == null) goto L84;
            int r0 = Selection.getSelectionStart(r13);
            int r1 = Selection.getSelectionEnd(r13);
            if (r0 < 0) goto L83;
            if (r1 < 0) goto L85;
            e r4 = null;
            if (r0 != r1) goto L40;
            Object[] r2 = r13.getSpans(0, r13.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r5 = r2.length;
            int r6 = 0;
        L13:
            if (r6 >= r5) goto L22;
            Object r7 = r2[r6];
            ObricSelectedMentionForegroundColorSpan r8 = (ObricSelectedMentionForegroundColorSpan) r7;
            int r9 = r13.getSpanStart(r8);
            int r10 = r13.getSpanEnd(r8);
            if (r0 <= r9) goto L18;
            if (r0 >= r10) goto L18;
            boolean r11 = true;
        L19:
            if (r11 == true) goto L23;
            r6 = r6 + 1;
        L23:
            ObricSelectedMentionForegroundColorSpan r12 = (ObricSelectedMentionForegroundColorSpan) r7;
            if (r12 == null) goto L62;
            int r3 = r13.getSpanStart(r12);
            int r14 = r13.getSpanEnd(r12);
            if (r3 < 0) goto L62;
            if (r14 <= r3) goto L62;
            if ((r0 - r3) <= (r14 - r0)) goto L34;
            r3 = r14;
        L34:
            e r15 = new e(r3, r3);
            if (r3 == r0) goto L37;
            boolean r16 = true;
        L38:
            if (r16 == false) goto L62;
            r4 = r15;
            goto L62
        L37:
            r16 = false;
        L62:
            if (r4 != null) goto L64;
            return;
        L64:
            this.k = true;
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L67
            Selection.setSelection(r13, r4.a, r4.b);     // Catch: Throwable -> L67
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
        L69:
            this.k = false;
            return;
        L67:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L18:
            r11 = false;
            goto L19
        L22:
            r7 = null;
            goto L23
        L40:
            if (r0 <= r1) goto L42;
            boolean r19 = true;
        L43:
            int r20 = Math.min(r0, r1);
            int r21 = Math.max(r0, r1);
            Object[] r22 = r13.getSpans(0, r13.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r23 = r22.length;
            int r24 = 0;
            boolean r25 = false;
        L44:
            if (r24 >= r23) goto L56;
            ObricSelectedMentionForegroundColorSpan r110 = (ObricSelectedMentionForegroundColorSpan) r22[r24];
            int r111 = r13.getSpanStart(r110);
            int r112 = r13.getSpanEnd(r110);
            if (r111 < 0) goto L55;
            if (r112 <= r111) goto L55;
            if (r20 >= r112) goto L55;
            if (r21 <= r111) goto L55;
            if (r20 <= r111) goto L53;
            r20 = r111;
            r25 = true;
        L53:
            if (r21 >= r112) goto L55;
            r21 = r112;
            r25 = true;
        L55:
            r24 = r24 + 1;
            goto L44
        L56:
            if (r25 == false) goto L62;
            if (r19 == false) goto L60;
            e r26 = new e(r21, r20);
        L61:
            r4 = r26;
            goto L62
        L60:
            r26 = new e(r20, r21);
            goto L61
        L42:
            r19 = false;
            goto L43
        L85:
            return;
        L83:
            return;
        L84:
            return;
        }

        /* JADX WARN: Type inference failed for: r6v11, types: [com.obric.assistant.util.q1] */
        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r14) {
            if (this.i == false) goto L5;
            return;
        L5:
            if (this.j == true) goto L135;
            if (r14 == null) goto L139;
            g(r14);
            c r0 = this.l;
            if (r0 == null) goto L15;
            this.l = null;
            int r4 = RangesKt.coerceAtLeast(r0.d - r0.c, 0);
            int r5 = RangesKt.coerceIn(r0.a, 0, r14.length());
            int r6 = RangesKt.coerceIn(r0.b - r4, r5, r14.length());
            if (r5 == r6) goto L14;
        L16:
            this.j = true;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L26
            Object[] r8 = r14.getSpans(r5, r6, ObricSelectedMentionForegroundColorSpan.class);     // Catch: Throwable -> L26
            int r9 = r8.length;     // Catch: Throwable -> L26
            int r10 = 0;
        L18:
            if (r10 >= r9) goto L20;
            r14.removeSpan(r8[r10]);     // Catch: Throwable -> L26
            r10 = r10 + 1;     // Catch: Throwable -> L26
            goto L18
        L20:
            r14.delete(r5, r6);     // Catch: Throwable -> L26
            Iterator<T> r1 = r0.e.iterator();     // Catch: Throwable -> L26
        L22:
            if (r1.hasNext() == false) goto L24;
            m((String) r1.next());     // Catch: Throwable -> L26
            goto L22
        L24:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
        L28:
            this.j = false;
            boolean r2 = true;
        L29:
            if (r2 == false) goto L31;
            return;
        L31:
            o(r14);
            a(r14);
            if (((Boolean) this.c.invoke()).booleanValue() == true) goto L35;
            this.h = null;
            e();
            return;
        L35:
            int r3 = this.a.getSelectionStart();
            if (r3 >= 0) goto L39;
            this.h = null;
            e();
            return;
        L39:
            Integer r11 = h(r14, r3);
            if (r11 != null) goto L43;
            this.h = null;
            e();
            return;
        L43:
            this.h = r11;
            String r15 = r14.subSequence(r11.intValue() + 1, r3).toString();
            if (((List) this.d.invoke()).isEmpty() == false) goto L46;
            e();
            return;
        L46:
            Object r12 = this.a.getParent();
            if ((r12 instanceof View) == false) goto L49;
            View r13 = (View) r12;
        L50:
            if (r13 != null) goto L52;
            r13 = this.a;
        L52:
            final a2 r16 = this.g;
            if (r16 != null) goto L55;
            r16 = new a2(r13, this.d, new q1(this));
            this.g = r16;
        L55:
            Intrinsics.checkNotNullParameter(r15, "searchText");
            List r17 = (List) r16.b.invoke();
            if (r15.length() != 0) goto L58;
            boolean r18 = true;
        L59:
            if (r18 == false) goto L64;
            List r19 = r17;
            ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator r20 = r19.iterator();
        L62:
            if (r20.hasNext() == false) goto L88;
            paa.e r21 = (paa.e) r20.next();
            r110.add(new a2.c(r21, CollectionsKt.toSet(StringsKt.getIndices(r21.b))));
        L88:
            if (r110.isEmpty() == false) goto L93;
            PopupWindow r111 = r16.d;
            if (r111 == null) goto L92;
            PopupWindowLancet.handleDismissBeforeOrigin(r111);
            r111.dismiss();
        L92:
            r16.d = null;
            r16.e = null;
            return;
        L93:
            final PopupWindow r22 = r16.d;
            if (r22 != null) goto L96;
        L104:
            Context r23 = r16.a.getContext();
            LayoutInflater r24 = LayoutInflater.from(r23);
            View r25 = r16.a.getRootView();
            if ((r25 instanceof ViewGroup) == false) goto L107;
            ViewGroup r26 = (ViewGroup) r25;
        L108:
            View r27 = r24.inflate(2131564031, r26, false);
            ShadowLayout r28 = r27.findViewById(2131381216);
            if (r28 == null) goto L111;
            r28.setShadowSize(i5.h());
            r28.setShadowColor(ContextCompat.getColor(r23, 2131103875));
            r28.setShadowOffset(new Point(0, i5.j0()));
            r28.setShadowRadius(i5.h());
        L111:
            final RecyclerView r29 = r27.findViewById(2131381215);
            if (r29 == null) goto L114;
            r29.setItemAnimator(null);
            r29.setLayoutManager(new LinearLayoutManager(r23, 1, false));
            a2.b r30 = new a2.b(r110, ContextCompat.getColor(r23, 2131103873), r16.c);
            r16.e = r30;
            r29.setAdapter(r30);
            r29.addOnScrollListener(new ObricMentionPopupWindow$createContentView$1$2$2(r16));
            r29.post(new z1(r16, r29));
        L114:
            int r31 = com.larus.utils.m0.a;
            PopupWindow r112 = new PopupWindow(r27, com.larus.utils.m0.b(r27.getContext()), -2, false);
            r112.setAnimationStyle(0);
            r112.setOutsideTouchable(false);
            int r32 = com.larus.utils.m0.b(r112.getContentView().getContext());
            ShadowLayout r33 = r112.getContentView().findViewById(2131381216);
            int r34 = r112.getContentView().getResources().getDimensionPixelSize(v19.c.b(2130971382, r112.getContentView().getContext(), 2131167133)) + (r33.getPaddingTop() + r33.getPaddingBottom());
            int r35 = ((-r16.a.getHeight()) - r34) + com.obric.assistant.common.utils.f.a(11);
            r112.setWidth(r32);
            r112.setHeight(r34);
            View r36 = r16.a;
            OverlaySource r37 = PopupWindowLancet.resolveSource(r36);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r112, r36, r37) == true) goto L118;
            r112.showAsDropDown(r36, 0, r35);
            PopupWindowLancet.trackAfterShow(r112, r37, r36);
        L118:
            r16.d = r112;
            return;
        L107:
            r26 = null;
            goto L108
        L96:
            if (r22.isShowing() == true) goto L99;
            r22 = null;
        L99:
            if (r22 == null) goto L104;
            a2.b r38 = r16.e;
            if (r38 == null) goto L103;
            Intrinsics.checkNotNullParameter(r110, "newData");
            r38.c.clear();
            r38.c.addAll(r110);
            r38.notifyDataSetChanged();
        L103:
            r22.getContentView().post(new x1(r22, r16));
            return;
        L64:
            ArrayList r39 = new ArrayList();
            Iterator r40 = r17.iterator();
        L66:
            if (r40.hasNext() == false) goto L86;
            paa.e r41 = (paa.e) r40.next();
            String r42 = r41.b;
            ArrayList r43 = new ArrayList();
            int r44 = 0;
            int r113 = 0;
        L69:
            if (r44 >= r15.length()) goto L81;
            char r114 = r15.charAt(r44);
        L72:
            if (r113 >= r42.length()) goto L77;
            if (CharsKt.equals(r42.charAt(r113), r114, true) == true) goto L75;
            r113 = r113 + 1;
            goto L72
        L75:
            r43.add(Integer.valueOf(r113));
            r113 = r113 + 1;
            boolean r115 = true;
        L78:
            if (r115 == false) goto L79;
            r44 = r44 + 1;
            goto L69
        L79:
            r43 = null;
            goto L81
        L77:
            r115 = false;
        L81:
            if (r43 == null) goto L83;
            a2.c r45 = new a2.c(r41, CollectionsKt.toSet(r43));
        L84:
            if (r45 == null) goto L66;
            r39.add(r45);
            goto L66
        L83:
            r45 = null;
            goto L84
        L86:
            r110 = r39;
            goto L88
        L58:
            r18 = false;
            goto L59
        L49:
            r13 = null;
        L26:
            th = move-exception;
            Result.Companion r46 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        L14:
            if (r0.e.isEmpty() == false) goto L16;
        L15:
            r2 = false;
            goto L29
        L139:
            return;
        }

        public final boolean f(paa.e r12) {
            Editable r0 = this.a.getText();
            if (r0 != null) goto L5;
            return false;
        L5:
            String r8 = "@" + r12.b;
            int r3 = 0;
        L7:
            if (r3 >= r0.length()) goto L24;
            int r1 = StringsKt.indexOf$default(r0, r8, r3, false, 4, null);
            if (r1 < 0) goto L10;
            r3 = r1 + r8.length();
            Object[] r2 = r0.getSpans(r1, r3, ObricSelectedMentionForegroundColorSpan.class);
            int r4 = r2.length;
            int r5 = 0;
        L13:
            if (r5 >= r4) goto L18;
            if ((!Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r2[r5]).a, r12.a)) == true) goto L16;
            r5 = r5 + 1;
            goto L13
        L16:
            boolean r6 = true;
        L20:
            if (ObricMentionHighlightHelper.b(r0, r1, r3) == false) goto L7;
            if (r6 == true) goto L7;
            b(r0, r1, r3, r12);
            return true;
        L18:
            r6 = false;
            goto L20
        L10:
            return false;
        L24:
            return false;
        }

        public final void g(Editable r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            int r0 = r5.getSpanStart(this.o);
            int r1 = r5.getSpanEnd(this.o);
            if (r0 == 0) goto L7;
        L8:
            r5.setSpan(this.o, 0, r5.length(), 18);
            return;
        L7:
            if (r1 != r5.length()) goto L8;
        }

        public final boolean i(String r6) {
            Editable r0 = this.a.getText();
            if (r0 != null) goto L5;
            return false;
        L5:
            Object[] r1 = r0.getSpans(0, r0.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r2 = r1.length;
            int r3 = 0;
        L6:
            if (r3 >= r2) goto L14;
            if (Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r1[r3]).a, r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return true;
        L14:
            return false;
        }

        public final void l(final paa.e r3) {
            Intrinsics.checkNotNullParameter(r3, "obricSkillItem");
            if (i(r3.a) == false) goto L5;
        L11:
            o(this.a.getText());
            return;
        L5:
            if (f(r3) == true) goto L11;
            k(r3, true);
            this.a.post(new p1(this, r3));
            if (i(r3.a) == true) goto L13;
            f(r3);
            return;
        }

        public final void m(String r2) {
            if (this.n.remove(r2) == false) goto L6;
            this.f.invoke(r2);
            return;
        }

        public final boolean n(paa.e r9) {
            Intrinsics.checkNotNullParameter(r9, "obricSkillItem");
            Editable r0 = this.a.getText();
            if (r0 != null) goto L5;
            return false;
        L5:
            Object[] r2 = r0.getSpans(0, r0.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r3 = r2.length;
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L11;
            Object r5 = r2[r4];
            if (Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r5).a, r9.a) == true) goto L12;
            r4 = r4 + 1;
        L12:
            ObricSelectedMentionForegroundColorSpan r6 = (ObricSelectedMentionForegroundColorSpan) r5;
            if (r6 != null) goto L15;
            return false;
        L15:
            int r7 = r0.getSpanStart(r6);
            int r8 = r0.getSpanEnd(r6);
            if (r7 < 0) goto L27;
            if (r8 <= r7) goto L27;
            Character r1 = StringsKt.getOrNull(r0, r8);
            if (r1 != null) goto L23;
        L25:
            r0.removeSpan(r6);
            r0.delete(r7, RangesKt.coerceAtMost(r8, r0.length()));
            m(r9.a);
            return true;
        L23:
            if (r1.charValue() != ' ') goto L25;
            r8 = r8 + 1;
        L27:
            return false;
        L11:
            r5 = null;
            goto L12
        }

        public final void o(Editable r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            int r2 = 0;
            Object[] r6 = r5.getSpans(0, r5.length(), ObricSelectedMentionForegroundColorSpan.class);
            ArrayList r0 = new ArrayList(r6.length);
            int r1 = r6.length;
        L5:
            if (r2 >= r1) goto L7;
            r0.add(((ObricSelectedMentionForegroundColorSpan) r6[r2]).a);
            r2 = r2 + 1;
            goto L5
        L7:
            Set r7 = CollectionsKt.toSet(r0);
            Iterator r3 = SetsKt.minus(this.n, r7).iterator();
        L9:
            if (r3.hasNext() == false) goto L11;
            m((String) r3.next());
            goto L9
        L11:
            Iterator r8 = SetsKt.minus(r7, this.n).iterator();
        L13:
            if (r8.hasNext() == false) goto L17;
            String r4 = (String) r8.next();
            if (this.n.add(r4) == false) goto L13;
            this.e.invoke(r4);
            goto L13
        }

        public final boolean p(String r9) {
            Intrinsics.checkNotNullParameter(r9, "skillId");
            Editable r0 = this.a.getText();
            if (r0 != null) goto L5;
            return false;
        L5:
            Object[] r2 = r0.getSpans(0, r0.length(), ObricSelectedMentionForegroundColorSpan.class);
            ArrayList r3 = new ArrayList();
            int r4 = r2.length;
            int r5 = 0;
        L6:
            if (r5 >= r4) goto L12;
            Object r6 = r2[r5];
            if (Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r6).a, r9) == false) goto L10;
            r3.add(r6);
        L10:
            r5 = r5 + 1;
            goto L6
        L12:
            if (r3.isEmpty() == false) goto L14;
            return false;
        L14:
            Iterator r1 = r3.iterator();
        L16:
            if (r1.hasNext() == false) goto L18;
            r0.removeSpan(r1.next());
            goto L16
        L18:
            m(r9);
            this.a.invalidate();
            return true;
        }

        public static Integer h(Editable r4, int r5) {
            if (r5 > 0) goto L5;
        L28:
            return null;
        L5:
            if (r5 > r4.length()) goto L28;
            boolean r1 = true;
            int r6 = r5 - 1;
        L8:
            if (r6 < 0) goto L28;
            if (CharsKt.isWhitespace(r4.charAt(r6)) == true) goto L28;
            if (r4.charAt(r6) == '@') goto L13;
            r6 = r6 - 1;
            goto L8
        L13:
            Integer r7 = Integer.valueOf(r6);
            int r2 = r7.intValue();
            if (r2 == 0) goto L24;
            Character r8 = StringsKt.getOrNull(r4, r2 - 1);
            if (r8 != null) goto L18;
        L20:
            boolean r9 = false;
        L21:
            if (r9 == true) goto L24;
            r1 = false;
            goto L24
        L18:
            if (CharsKt.isWhitespace(r8.charValue()) != true) goto L20;
            r9 = true;
        L24:
            if (r1 == true) goto L26;
            return null;
        L26:
            return r7;
        }

        public final void k(paa.e r9, boolean r10) {
            if (r10 == false) goto L5;
        L8:
            Editable r1 = this.a.getText();
            if (r1 != null) goto L11;
            return;
        L11:
            int r2 = RangesKt.coerceIn(this.a.getSelectionStart(), 0, r1.length());
            if (r10 == false) goto L14;
            int r3 = RangesKt.coerceAtMost(RangesKt.coerceIn(this.a.getSelectionStart(), 0, r1.length()), RangesKt.coerceIn(this.a.getSelectionEnd(), 0, r1.length()));
        L20:
            if (r10 == false) goto L22;
            r2 = RangesKt.coerceAtLeast(RangesKt.coerceIn(this.a.getSelectionStart(), 0, r1.length()), RangesKt.coerceIn(this.a.getSelectionEnd(), 0, r1.length()));
        L22:
            String r11 = "@" + r9.b;
            this.i = true;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L46
            e();     // Catch: Throwable -> L46
            if (r3 > 0) goto L27;
        L35:
            r1.replace(r3, r2, r11);     // Catch: Throwable -> L46
            b(r1, r3, r11.length() + r3, r9);     // Catch: Throwable -> L46
            int r4 = r3 + r11.length();     // Catch: Throwable -> L46
            Character r12 = StringsKt.getOrNull(r1, r4);     // Catch: Throwable -> L46
            if (r12 != null) goto L39;
        L40:
            r1.insert(r4, " ");     // Catch: Throwable -> L46
        L41:
            this.a.setSelection(RangesKt.coerceAtMost(r4 + 1, r1.length()));     // Catch: Throwable -> L46
            this.h = null;     // Catch: Throwable -> L46
            String r13 = r9.a;     // Catch: Throwable -> L46
            if (this.n.add(r13) == false) goto L44;
            this.e.invoke(r13);     // Catch: Throwable -> L46
        L44:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
        L48:
            this.i = false;
            return;
        L39:
            if (r12.charValue() == ' ') goto L41;
        L27:
            Character r7 = StringsKt.getOrNull(r1, r3 - 1);     // Catch: Throwable -> L46
            if (r7 != null) goto L30;
        L32:
            boolean r8 = false;
        L33:
            if (r8 == true) goto L35;
            r1.insert(r3, " ");     // Catch: Throwable -> L46
            r3 = r3 + 1;     // Catch: Throwable -> L46
            r2 = r2 + 1;     // Catch: Throwable -> L46
            goto L35
        L30:
            if (CharsKt.isWhitespace(r7.charValue()) != true) goto L32;
            r8 = true;
        L46:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L48
        L14:
            Integer r5 = this.h;
            if (r5 != null) goto L19;
            r5 = h(r1, r2);
            if (r5 != null) goto L19;
            return;
        L19:
            r3 = r5.intValue();
            goto L20
        L5:
            if (((Boolean) this.c.invoke()).booleanValue() == true) goto L8;
            this.h = null;
            e();
        }

        public static c c(Spannable r13, int r14, int r15) {
            Object[] r0 = r13.getSpans(0, r13.length(), ObricSelectedMentionForegroundColorSpan.class);
            ArrayList r1 = new ArrayList();
            int r3 = r0.length;
            int r4 = 0;
        L4:
            if (r4 >= r3) goto L32;
            Object r6 = r0[r4];
            Object r7 = (ObricSelectedMentionForegroundColorSpan) r6;
            int r8 = r13.getSpanStart(r7);
            int r9 = r13.getSpanEnd(r7);
            if (r8 < 0) goto L27;
            if (r9 <= r8) goto L27;
            boolean r10 = true;
            if (r14 >= r9) goto L13;
            if (r15 <= r8) goto L13;
            boolean r11 = true;
        L14:
            if (r14 == r9) goto L16;
        L23:
            boolean r5 = false;
        L24:
            if (r11 == true) goto L28;
            if (r5 == false) goto L27;
        L28:
            if (r10 == false) goto L30;
            r1.add(r6);
        L30:
            r4 = r4 + 1;
            goto L4
        L16:
            if (r15 != (r9 + 1)) goto L23;
            Character r12 = StringsKt.getOrNull(r13, r9);
            if (r12 == null) goto L23;
            if (r12.charValue() != ' ') goto L23;
            r5 = true;
        L13:
            r11 = false;
        L27:
            r10 = false;
            goto L28
        L32:
            if (r1.isEmpty() == false) goto L35;
            return null;
        L35:
            LinkedHashSet r2 = new LinkedHashSet();
            Iterator r16 = r1.iterator();
            int r17 = r14;
            int r18 = r15;
        L37:
            if (r16.hasNext() == false) goto L46;
            ObricSelectedMentionForegroundColorSpan r19 = (ObricSelectedMentionForegroundColorSpan) r16.next();
            int r20 = r13.getSpanStart(r19);
            int r21 = r13.getSpanEnd(r19);
            r17 = Math.min(r17, r20);
            r18 = Math.max(r18, r21);
            Character r22 = StringsKt.getOrNull(r13, r21);
            if (r22 == null) goto L44;
            if (r22.charValue() != ' ') goto L44;
            r18 = Math.max(r18, r21 + 1);
        L44:
            r2.add(r19.a);
            goto L37
        L46:
            return new c(RangesKt.coerceAtLeast(r17, 0), RangesKt.coerceAtMost(r18, r13.length()), RangesKt.coerceAtLeast(r14, 0), RangesKt.coerceAtMost(r15, r13.length()), CollectionsKt.toList(r2));
        }

        public final void b(Editable r5, int r6, int r7, paa.e r8) {
            Object[] r0 = r5.getSpans(r6, r7, ObricSelectedMentionForegroundColorSpan.class);
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            r5.removeSpan((ObricSelectedMentionForegroundColorSpan) r0[r2]);
            r2 = r2 + 1;
            goto L3
        L5:
            r5.setSpan(new ObricSelectedMentionForegroundColorSpan(this.b, r8.a), r6, r7, 33);
            this.a.invalidate();
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r2, int r3, int r4, int r5) {
            if (this.i == false) goto L5;
            return;
        L5:
            if (this.j == true) goto L13;
            if (r4 > r5) goto L8;
            return;
        L8:
            if ((r2 instanceof Spannable) == false) goto L15;
            this.l = c((Spannable) r2, r3, r4 + r3);
            return;
        L15:
            return;
        }

        public a(EditText r2, int r3, Function0 r4, com.obric.assistant.chat.component.bottom.core.mention.b r5, Function1 r6, Function1 r7) {
            Intrinsics.checkNotNullParameter(r2, "editText");
            Intrinsics.checkNotNullParameter(r4, "isEnabled");
            Intrinsics.checkNotNullParameter(r5, "mentionItemsProvider");
            Intrinsics.checkNotNullParameter(r6, "onSelected");
            Intrinsics.checkNotNullParameter(r7, "onUnselected");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.n = new LinkedHashSet();
            this.o = new t1(this);
            this.p = new s1(this);
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final paa.e c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "MentionRange(start=" + this.a + ", end=" + this.b + ", item=" + this.c + ')';
        }

        public b(int r2, int r3, paa.e r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final List<String> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "PendingAtomicDelete(start=" + this.a + ", end=" + this.b + ", originalDeleteStart=" + this.c + ", originalDeleteEnd=" + this.d + ", skillIds=" + this.e + ')';
        }

        public c(int r2, int r3, int r4, int r5, List<String> r6) {
            Intrinsics.checkNotNullParameter(r6, "skillIds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class d {
        public final CharSequence a;
        public final List<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "RestoreDraftContent(content=" + this.a + ", mentionedSkillIds=" + this.b + ')';
        }

        public d(CharSequence r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "content");
            Intrinsics.checkNotNullParameter(r3, "mentionedSkillIds");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "SelectionRange(start=" + this.a + ", end=" + this.b + ')';
        }

        public e(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static d a(String r12, int r13, List r14) {
        Intrinsics.checkNotNullParameter(r12, "text");
        Intrinsics.checkNotNullParameter(r14, "mentionItems");
        boolean r1 = false;
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L55:
        List r15 = CollectionsKt.emptyList();
    L57:
        if (r12.length() != 0) goto L59;
        boolean r2 = true;
    L61:
        if (r2 == false) goto L63;
    L81:
        SpannableStringBuilder r3 = null;
    L82:
        if (r3 != null) goto L84;
        return null;
    L84:
        List r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L86:
        if (r18.hasNext() == false) goto L89;
        r17.add(((b) r18.next()).c.a);
        goto L86
    L89:
        return new d(r3, CollectionsKt.distinct(r17));
    L63:
        if (r15.isEmpty() == true) goto L81;
        r3 = new SpannableStringBuilder(r12);
        Iterator r4 = r15.iterator();
    L67:
        if (r4.hasNext() == false) goto L69;
        b r5 = (b) r4.next();
        r3.setSpan(new ObricSelectedMentionForegroundColorSpan(r13, r5.c.a), r5.a, r5.b, 33);
        goto L67
    L69:
        b r19 = (b) CollectionsKt.lastOrNull(r15);
        if (r19 != null) goto L72;
    L74:
        if (r1 == false) goto L82;
        Character r110 = StringsKt.lastOrNull(r3);
        if (r110 != null) goto L79;
    L80:
        r3.append(' ');
        goto L82
    L79:
        if (r110.charValue() == ' ') goto L82;
    L72:
        if (r19.b != r12.length()) goto L74;
        r1 = true;
        goto L74
    L59:
        r2 = false;
        goto L61
    L8:
        if (((ArrayList) r14).isEmpty() == true) goto L55;
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        Iterator r111 = r14.iterator();
    L12:
        if (r111.hasNext() == false) goto L16;
        Object r8 = r111.next();
        if ((!StringsKt.isBlank(((paa.e) r8).b)) == false) goto L12;
        r7.add(r8);
        goto L12
    L16:
        HashSet r112 = new HashSet();
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L18:
        if (r10.hasNext() == false) goto L22;
        Object r11 = r10.next();
        if (r112.add(((paa.e) r11).a) == false) goto L18;
        r9.add(r11);
        goto L18
    L22:
        Iterator r113 = r9.iterator();
    L24:
        if (r113.hasNext() == false) goto L34;
        paa.e r20 = (paa.e) r113.next();
        String r21 = "@" + r20.b;
        int r22 = 0;
    L27:
        if (r22 >= r12.length()) goto L24;
        int r23 = StringsKt.indexOf$default(r12, r21, r22, false, 4, null);
        if (r23 < 0) goto L24;
        r22 = r23 + r21.length();
        if (b(r12, r23, r22) == false) goto L27;
        r6.add(new b(r23, r22, r20));
        goto L27
    L34:
        ArrayList r114 = new ArrayList();
        Iterator r24 = CollectionsKt.sortedWith(r6, new w1(new u1())).iterator();
    L36:
        if (r24.hasNext() == false) goto L54;
        b r25 = (b) r24.next();
        if (r114.isEmpty() == true) goto L51;
        Iterator r26 = r114.iterator();
    L42:
        if (r26.hasNext() == false) goto L51;
        b r27 = (b) r26.next();
        if (r25.a < r27.b) goto L46;
    L48:
        boolean r28 = false;
    L49:
        if (r28 == false) goto L42;
        boolean r29 = false;
    L52:
        if (r29 == false) goto L36;
        r114.add(r25);
        goto L36
    L46:
        if (r25.b <= r27.a) goto L48;
        r28 = true;
    L51:
        r29 = true;
        goto L52
    L54:
        r15 = CollectionsKt.sortedWith(r114, new v1());
        goto L57
    L5:
        r0 = false;
        goto L6
    }

    public static boolean b(CharSequence r3, int r4, int r5) {
        if (r4 == 0) goto L13;
        Character r6 = StringsKt.getOrNull(r3, r4 - 1);
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == true) goto L13;
        boolean r8 = false;
    L15:
        if (r5 == r3.length()) goto L25;
        Character r9 = StringsKt.getOrNull(r3, r5);
        if (r9 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L25;
        boolean r11 = false;
    L26:
        if (r8 == false) goto L30;
        if (r11 == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L19:
        if (CharsKt.isWhitespace(r9.charValue()) != true) goto L21;
        r10 = true;
    L25:
        r11 = true;
        goto L26
    L7:
        if (CharsKt.isWhitespace(r6.charValue()) != true) goto L9;
        r7 = true;
    L13:
        r8 = true;
        goto L15
    }
}
