package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.UIHelper;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final boolean a;
        public final Float b;
        public final boolean c;
        public final boolean d;

        public a() {
            this(false, null, false, false, 15);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            Float r3 = this.b;
            if (r3 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r2 + r4) * 31;
            if (this.c == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (r5 + r6) * 31;
            if (this.d == true) goto L19;
            r1 = 1237;
        L19:
            return r7 + r1;
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = r3.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "HandleResult(needAddCurPersonIndex=" + this.a + ", curLineUsedWidth=" + this.b + ", needAddCurLine=" + this.c + ", needBreak=" + this.d + ')';
        }

        public a(boolean r3, Float r4, boolean r5, boolean r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = false;
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = false;
        L14:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class b extends ClickableSpan {
        public final d a;

        public b(d r2) {
            Intrinsics.checkNotNullParameter(r2, "comInfo");
            this.a = r2;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            if ((r3.getContext() instanceof FragmentActivity) == false) goto L5;
            Context r4 = r3.getContext();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity r5 = (FragmentActivity) r4;
        L9:
            FragmentActivity r6 = r5;
            if (r6 == null) goto L15;
            d r0 = this.a;
            com.larksuite.component.card.component.personlist.a r1 = r0.y;
            if (r1 == null) goto L16;
            r1.a(r6, r0.c);
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r5 = AppLifecycle.a.a.f();
            if ((r5 instanceof FragmentActivity) == true) goto L9;
            r5 = null;
            goto L9
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setColor(this.a.k);
        }
    }

    public static final class c extends ClickableSpan {
        public final PersonInfo a;
        public final d b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
            com.larksuite.component.card.component.personlist.b r3 = this.b.z;
            if (r3 == null) goto L6;
            r3.a(this.a.getId());
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setColor(this.b.n);
        }

        public c(PersonInfo r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "info");
            Intrinsics.checkNotNullParameter(r3, "comInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d {
        public final Context a;
        public final TextPaint b;
        public final List<PersonInfo> c;
        public final String d;
        public final float e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final int m;
        public final int n;
        public final float o;
        public final float p;
        public final float q;
        public final boolean r;
        public final int s;
        public final int t;
        public final float u;
        public final boolean v;
        public final boolean w;
        public final int x;
        public final com.larksuite.component.card.component.personlist.a y;
        public final com.larksuite.component.card.component.personlist.b z;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (Float.compare(this.o, r6.o) == 0) goto L54;
            return false;
        L54:
            if (Float.compare(this.p, r6.p) == 0) goto L57;
            return false;
        L57:
            if (Float.compare(this.q, r6.q) == 0) goto L60;
            return false;
        L60:
            if (this.r == r6.r) goto L63;
            return false;
        L63:
            if (this.s == r6.s) goto L66;
            return false;
        L66:
            if (this.t == r6.t) goto L69;
            return false;
        L69:
            if (Float.compare(this.u, r6.u) == 0) goto L72;
            return false;
        L72:
            if (this.v == r6.v) goto L75;
            return false;
        L75:
            if (this.w == r6.w) goto L78;
            return false;
        L78:
            if (this.x == r6.x) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.z, r6.z) == true) goto L86;
            return false;
        L86:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + Float.floatToIntBits(this.o)) * 31) + Float.floatToIntBits(this.p)) * 31) + Float.floatToIntBits(this.q)) * 31;
            int r2 = 1231;
            if (this.r == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((((r0 + r1) * 31) + this.s) * 31) + this.t) * 31) + Float.floatToIntBits(this.u)) * 31;
            if (this.v == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            if (this.w == true) goto L14;
            r2 = 1237;
        L14:
            int r6 = (((r5 + r2) * 31) + this.x) * 31;
            com.larksuite.component.card.component.personlist.a r7 = this.y;
            int r8 = 0;
            if (r7 != null) goto L17;
            int r9 = 0;
        L18:
            int r10 = (r6 + r9) * 31;
            com.larksuite.component.card.component.personlist.b r11 = this.z;
            if (r11 == null) goto L23;
            r8 = r11.hashCode();
        L23:
            return r10 + r8;
        L17:
            r9 = r7.hashCode();
            goto L18
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PersonComInfo(context=" + this.a + ", paint=" + this.b + ", persons=" + this.c + ", nameSeparator=" + this.d + ", lineWidth=" + this.e + ", avatarSize=" + this.f + ", avatarNameSpanGap=" + this.g + ", avatarNameLineGap=" + this.h + ", avatarMoreBgColor=" + this.i + ", moreTextSize=" + this.j + ", moreTextColor=" + this.k + ", avatarMoreMaxCount=" + this.l + ", textLineHeight=" + this.m + ", textColor=" + this.n + ", curNameMeasureW=" + this.o + ", nameSeparatorWidth=" + this.p + ", newLineUsedWidth=" + this.q + ", isLastLine=" + this.r + ", curLine=" + this.s + ", curPersonIndex=" + this.t + ", curLineAvailWidth=" + this.u + ", isSingleLineOverflow=" + this.v + ", isAvatarNameMode=" + this.w + ", spaceForAvatarIfNeed=" + this.x + ", clickMoreListener=" + this.y + ", clickPersonListener=" + this.z + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public d(Context r7, TextPaint r8, List r9, String r10, float r11, int r12, int r13, int r14, int r15, int r16, int r17, int r19, int r110, int r20, float r21, float r22, float r23, boolean r24, int r25, int r26, float r27, boolean r29, boolean r210, int r30, PersonListLynxUI.a r31, com.larksuite.component.card.component.personlist.b r32) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "paint");
            Intrinsics.checkNotNullParameter(r9, "persons");
            Intrinsics.checkNotNullParameter(r10, "nameSeparator");
            this.a = r7;
            this.b = r8;
            this.c = r9;
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r17;
            this.l = r19;
            this.m = r110;
            this.n = r20;
            this.o = r21;
            this.p = r22;
            this.q = r23;
            this.r = r24;
            this.s = r25;
            this.t = r26;
            this.u = r27;
            this.v = r29;
            this.w = r210;
            this.x = r30;
            this.y = r31;
            this.z = r32;
        }
    }

    static {
    }

    public static String c(String r7) {
        String r1 = UIHelper.getString(2131890319);
        if (r7 != null) goto L5;
        return r1;
    L5:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return StringsKt.replace$default(r1, String.format("{%s}", Arrays.copyOf(new Object[]{"count"}, 1)), r7, false, 4, null);
    }

    public static void a(SpannableStringBuilder r21, d r22) {
        if (r22.w == true) goto L6;
        String r0 = c(String.valueOf(r22.c.size() - r22.t));
        r21.append(r0);
    L5:
        String r9 = r0;
        int r1 = StringsKt.lastIndexOf$default(r21, r9, 0, false, 6, null);
        if (r1 == (-1)) goto L28;
        int r2 = r9.length() + r1;
        if (r2 <= r21.length()) goto L26;
        r2 = r21.length();
    L26:
        r21.setSpan(new b(r22), r1, r2, 33);
        return;
    L28:
        return;
    L6:
        int r3 = r22.c.size() - r22.t;
        int r4 = r22.l;
        if (r3 <= r4) goto L9;
        r3 = r4;
    L9:
        r0 = "+" + r3;
        if (r22.u != r22.e) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        int r14 = 0;
    L17:
        if (r22.s != 1) goto L19;
        int r16 = 0;
    L20:
        Context r10 = r22.getContext();
        int r6 = r22.f;
        int r7 = r22.i;
        GradientDrawable r11 = new GradientDrawable();
        r11.setColor(r7);
        r11.setShape(1);
        r11.setCornerRadius(0.0f);
        r11.setSize(r6, r6);
        r21.append(r0, new com.larksuite.component.card.component.personlist.avatar.a(r10, r11, r22.f, r22.j, r14, 0, r16, "", "", true, r22.k), 33);
        goto L5
    L19:
        r16 = r22.h;
        goto L20
    L15:
        r14 = r22.g;
        goto L17
    L12:
        r5 = false;
        goto L13
    }

    public static void b(SpannableStringBuilder r22, String r23, PersonInfo r24, boolean r25, d r26) {
        if (r26.w == true) goto L5;
    L19:
        r22.append(r23);
        int r0 = StringsKt.lastIndexOf$default(r22, r23, 0, false, 6, null);
        if (r0 == (-1)) goto L25;
        g.a.getClass();
        int r1 = RangesKt.coerceAtMost(g.f(r24).length(), r23.length()) + r0;
        if (r1 <= r22.length()) goto L24;
        r1 = r22.length();
    L24:
        r22.setSpan(new c(r24, r26), r0, r1, 33);
    L25:
        if (r25 == false) goto L27;
        return;
    L27:
        if (r26.w == true) goto L31;
        r22.append(UIHelper.getString(2131892752));
        return;
    L31:
        return;
    L5:
        if (r26.u != r26.e) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        int r15 = 0;
    L12:
        if (r26.s != 1) goto L14;
        int r17 = 0;
    L15:
        Context r11 = r26.getContext();
        Drawable r12 = UIHelper.getDrawable(2131232484);
        int r13 = r26.f;
        int r14 = r26.j;
        g.a.getClass();
        int r16 = g.d;
        String r3 = r24.getAvatarKey();
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        r22.append("_card_avatar_", new com.larksuite.component.card.component.personlist.avatar.a(r11, r12, r13, r14, r15, r16, r17, r3, r24.getId(), false, r26.k), 33);
        int r4 = r22.length();
        r22.setSpan(new c(r24, r26), r4 - 13, r4, 33);
        goto L19
    L14:
        r17 = r26.h;
        goto L15
    L10:
        r15 = r26.g;
        goto L12
    L7:
        r2 = false;
        goto L8
    }
}
