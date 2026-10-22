package com.larksuite.component.universe_design.tag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDTagsDrawable extends Drawable {
    public final a a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final boolean i;
    public final Lazy j;
    public final List<d> k;
    public final Rect l;
    public final Rect m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagColorSet;", "", "backgroundColorRes", "", "textColorRes", "iconColorRes", "<init>", "(Ljava/lang/String;IIII)V", "getBackgroundColorRes", "()I", "getTextColorRes", "getIconColorRes", "GRAY", "BLUE", "INDIGO", "WATHET", "RAD", "GREEN", "ORANGE", "VIOLET", "PURPLE", "THROUGH", "LIME", "YELLOW", "CARMINE", "DARK_BLUE", "DARK_CARMINE", "DARK_RAD", "DARK_GRAY", "LIGHT_GRAY", "universe-ui-tag_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TagColorSet extends Enum<TagColorSet> {
        public static final TagColorSet BLUE = null;
        public static final TagColorSet CARMINE = null;
        public static final TagColorSet DARK_BLUE = null;
        public static final TagColorSet DARK_CARMINE = null;
        public static final TagColorSet DARK_GRAY = null;
        public static final TagColorSet DARK_RAD = null;
        public static final TagColorSet GRAY = null;
        public static final TagColorSet GREEN = null;
        public static final TagColorSet INDIGO = null;
        public static final TagColorSet LIGHT_GRAY = null;
        public static final TagColorSet LIME = null;
        public static final TagColorSet ORANGE = null;
        public static final TagColorSet PURPLE = null;
        public static final TagColorSet RAD = null;
        public static final TagColorSet THROUGH = null;
        public static final TagColorSet VIOLET = null;
        public static final TagColorSet WATHET = null;
        public static final TagColorSet YELLOW = null;
        public static final /* synthetic */ TagColorSet[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int backgroundColorRes;
        private final int iconColorRes;
        private final int textColorRes;

        public static EnumEntries<TagColorSet> getEntries() {
            return b;
        }

        static {
            TagColorSet r6 = new TagColorSet("GRAY", 0, 2131109109, 2131109115, 2131109115);
            GRAY = r6;
            TagColorSet r0 = new TagColorSet("BLUE", 1, 2131109083, 2131109125, 2131109125);
            BLUE = r0;
            TagColorSet r1 = new TagColorSet("INDIGO", 2, 2131109089, 2131109128, 2131109128);
            INDIGO = r1;
            TagColorSet r2 = new TagColorSet("WATHET", 3, 2131109103, 2131109135, 2131109135);
            WATHET = r2;
            TagColorSet r3 = new TagColorSet("RAD", 4, 2131109097, 2131109132, 2131109132);
            RAD = r3;
            TagColorSet r4 = new TagColorSet("GREEN", 5, 2131109087, 2131109127, 2131109127);
            GREEN = r4;
            TagColorSet r5 = new TagColorSet("ORANGE", 6, 2131109093, 2131109130, 2131109130);
            ORANGE = r5;
            TagColorSet r13 = new TagColorSet("VIOLET", 7, 2131109101, 2131109134, 2131109134);
            VIOLET = r13;
            TagColorSet r7 = new TagColorSet("PURPLE", 8, 2131109095, 2131109131, 2131109131);
            PURPLE = r7;
            TagColorSet r8 = new TagColorSet("THROUGH", 9, 2131109099, 2131109133, 2131109133);
            THROUGH = r8;
            TagColorSet r9 = new TagColorSet("LIME", 10, 2131109091, 2131109129, 2131109129);
            LIME = r9;
            TagColorSet r10 = new TagColorSet("YELLOW", 11, 2131109105, 2131109136, 2131109136);
            YELLOW = r10;
            TagColorSet r11 = new TagColorSet("CARMINE", 12, 2131109085, 2131109126, 2131109126);
            CARMINE = r11;
            TagColorSet r12 = new TagColorSet("DARK_BLUE", 13, 2131102126, 2131109113, 2131106521);
            DARK_BLUE = r12;
            TagColorSet r20 = new TagColorSet("DARK_CARMINE", 14, 2131108637, 2131109113, 2131106521);
            DARK_CARMINE = r20;
            TagColorSet r14 = new TagColorSet("DARK_RAD", 15, 2131102094, 2131109113, 2131106521);
            DARK_RAD = r14;
            TagColorSet r15 = new TagColorSet("DARK_GRAY", 16, 2131109107, 2131109113, 2131106521);
            DARK_GRAY = r15;
            TagColorSet r16 = new TagColorSet("LIGHT_GRAY", 17, 2131109112, 2131109115, 2131109115);
            LIGHT_GRAY = r16;
            TagColorSet[] r17 = {r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11, r12, r20, r14, r15, r16};
            a = r17;
            b = EnumEntriesKt.enumEntries(r17);
        }

        public static TagColorSet[] values() {
            return (TagColorSet[]) a.clone();
        }

        public final int getBackgroundColorRes() {
            return this.backgroundColorRes;
        }

        public final int getIconColorRes() {
            return this.iconColorRes;
        }

        public final int getTextColorRes() {
            return this.textColorRes;
        }

        public static TagColorSet valueOf(String r1) {
            return (TagColorSet) r27.a.a(TagColorSet.class, r1);
        }

        public TagColorSet(String r1, int r2, int r3, int r4, int r5) {
            super(r1, r2);
            this.backgroundColorRes = r3;
            this.textColorRes = r4;
            this.iconColorRes = r5;
        }
    }

    public static final class a {
        public final Context a;
        public float b;
        public float c;
        public float d;
        public final float e;
        public float f;
        public final float g;
        public float h;
        public boolean i;
        public final List<d> j;

        public final UDTagsDrawable b() {
            if (((ArrayList) this.j).isEmpty() == false) goto L6;
            return null;
        L6:
            return new UDTagsDrawable(this);
        }

        public final int hashCode() {
            return ((((((((((((0 + this.j.hashCode()) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h);
        }

        public final Context getContext() {
            return this.a;
        }

        public a(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            this.a = r5;
            this.b = h18.d.f(r5, 12.0f);
            this.c = h18.d.a(r5, 4.0f);
            this.d = h18.d.a(r5, 18.0f);
            this.e = h18.d.a(r5, 18.0f);
            this.f = Float.MAX_VALUE;
            this.g = h18.d.a(r5, 4.0f);
            this.h = h18.d.a(r5, 12.0f);
            this.j = new ArrayList(2);
        }

        public final void a(d r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            ((ArrayList) this.j).add(r2);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable.Builder");
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L16;
            return false;
        L16:
            if (this.b != r6.b) goto L18;
            boolean r1 = true;
        L19:
            if (r1 == true) goto L22;
            return false;
        L22:
            if (this.c != r6.c) goto L24;
            boolean r3 = true;
        L25:
            if (r3 == true) goto L28;
            return false;
        L28:
            if (this.d != r6.d) goto L30;
            boolean r4 = true;
        L31:
            if (r4 == true) goto L34;
            return false;
        L34:
            if (this.e != r6.e) goto L36;
            boolean r7 = true;
        L37:
            if (r7 == true) goto L40;
            return false;
        L40:
            if (this.g != r6.g) goto L42;
            boolean r8 = true;
        L43:
            if (r8 == true) goto L46;
            return false;
        L46:
            if (this.h != r6.h) goto L48;
            boolean r9 = true;
        L49:
            if (r9 == true) goto L51;
            return false;
        L51:
            return true;
        L48:
            r9 = false;
            goto L49
        L42:
            r8 = false;
            goto L43
        L36:
            r7 = false;
            goto L37
        L30:
            r4 = false;
            goto L31
        L24:
            r3 = false;
            goto L25
        L18:
            r1 = false;
            goto L19
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class b {
    }

    public static final class c extends GradientDrawable {
        public int a;
        public float b;
        public int c;

        public final int hashCode() {
            return (((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + this.c;
        }

        public c() {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(c.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable.SimpleGradientDrawable");
            c r6 = (c) r5;
            if (this.a == r6.a) goto L16;
            return false;
        L16:
            if (this.b != r6.b) goto L18;
            boolean r1 = true;
        L19:
            if (r1 == true) goto L22;
            return false;
        L22:
            if (this.c == r6.c) goto L24;
            return false;
        L24:
            return true;
        L18:
            r1 = false;
            goto L19
        L8:
            r2 = null;
            goto L10
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setColor(int r1) {
            super.setColor(r1);
            this.c = r1;
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setCornerRadius(float r1) {
            super.setCornerRadius(r1);
            this.b = r1;
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setShape(int r1) {
            super.setShape(r1);
            this.a = r1;
        }
    }

    public static final class d {
        public final int a;
        public final String b;
        public final int c;
        public final Drawable d;
        public final Integer e;
        public final Drawable f;
        public final boolean g;
        public String h;
        public boolean i;
        public final Rect j;
        public final Rect k;

        public static final class a {
            public final Context a;
            public int b;
            public String c;
            public int d;
            public Drawable e;
            public Integer f;
            public Drawable g;
            public boolean h;

            public final d b() {
                Drawable r0 = this.e;
                if (r0 == null) goto L8;
                Integer r1 = this.f;
                if (r1 == null) goto L8;
                int r2 = r1.intValue();
                r0.mutate();
                r0.setTint(r2);
            L8:
                return new d(this);
            }

            public a(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                this.a = r2;
                this.b = 10;
                this.d = UDColorUtils.getColor(r2, 2131109113);
            }

            public final void a(int r4) {
                Drawable r0 = this.g;
                if (r0 != null) goto L5;
            L6:
                c r1 = new c();
                r1.setShape(0);
                r1.setCornerRadius(h18.d.a(this.a, 4.0f));
                this.g = r1;
            L7:
                Drawable r2 = this.g;
                if (r2 != null) goto L10;
                return;
            L10:
                if ((r2 instanceof GradientDrawable) == false) goto L14;
                ((GradientDrawable) r2).setColor(r4);
                return;
            L14:
                return;
            L5:
                if ((r0 instanceof c) == true) goto L7;
                goto L6
            }

            public final void c(TagColorSet r3) {
                Intrinsics.checkNotNullParameter(r3, "colorSet");
                a(UDColorUtils.getColor(this.a, r3.getBackgroundColorRes()));
                this.d = UDColorUtils.getColor(this.a, r3.getTextColorRes());
                this.f = Integer.valueOf(UDColorUtils.getColor(this.a, r3.getIconColorRes()));
            }
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (((r0 + r3) * 31) + this.c) * 31;
            Drawable r5 = this.d;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.e;
            if (r8 == null) goto L13;
            int r9 = r8.intValue();
        L14:
            int r10 = (r7 + r9) * 31;
            Drawable r11 = this.f;
            if (r11 == null) goto L18;
            r2 = r11.hashCode();
        L18:
            return r10 + r2;
        L13:
            r9 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public d(a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            this.i = true;
            this.j = new Rect();
            Rect r0 = new Rect();
            this.k = r0;
            this.a = r3.b;
            this.b = r3.c;
            this.c = r3.d;
            this.d = r3.e;
            this.e = r3.f;
            Drawable r1 = r3.g;
            this.f = r1;
            this.g = r3.h;
            if (r1 == null) goto L6;
            r0.set(r1.getBounds());
            return;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(d.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable.TagModel");
            d r6 = (d) r5;
            if (this.a == r6.a) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
            return false;
        L19:
            if (this.c == r6.c) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L25;
            return false;
        L25:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L30;
            return false;
        L30:
            return true;
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((d) r1).a), Integer.valueOf(((d) r2).a));
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public final TextPaint a() {
        return (TextPaint) this.j.getValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.l.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.l.width();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public UDTagsDrawable(a r4) {
        this.a = r4;
        this.j = LazyKt.lazy(new UDTagsDrawable$textPaint$2(this));
        this.l = new Rect();
        this.m = new Rect();
        this.b = r4.b;
        this.c = r4.c;
        this.d = r4.d;
        this.e = r4.e;
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        ArrayList r0 = (ArrayList) r4.j;
        if (r0.size() <= 1) goto L5;
        CollectionsKt.sortWith(r0, new e());
    L5:
        this.k = r4.j;
        b(true);
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v34 */
    public final void b(boolean r17) {
        a().setTextSize(this.b);
        List<d> r1 = this.k;
        ?? r2 = 0;
        if (r1 == null) goto L51;
        Iterator<T> r3 = r1.iterator();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r3.hasNext() == false) goto L52;
        d r7 = (d) r3.next();
        Rect r8 = new Rect(r6, r2, r6, r2);
        boolean r9 = this.i;
        int r10 = LKUIToast.DURATION_MAX;
        if (r9 == true) goto L10;
    L12:
        float r11 = Math.min(r10, this.f);
        float r12 = this.e;
        float r13 = this.d;
        r7.i = true;
        r7.h = null;
        if (r11 > 0.0f) goto L15;
        r7.i = r2;
        r7.h = null;
    L50:
        r7.j.set(r8);
        r4 = r8.right;
        r6 = (int) (r4 + this.g);
        r5 = Math.max(r5, r8.bottom);
        r2 = 0;
        goto L6
    L15:
        Drawable r14 = r7.d;
        if (r14 == null) goto L21;
        float r15 = this.h;
        float r16 = Math.max(r12, r15);
        if (r16 <= r11) goto L20;
        r7.i = r2;
    L20:
        float r19 = Math.min(r16, r11);
        r13 = Math.max(r13, r15);
        int r110 = r8.left;
        r8.set(r110, r8.top, ((int) Math.ceil(r19)) + r110, r8.top + ((int) Math.ceil(r13)));
        float r111 = 2;
        float r20 = (r19 - r15) / r111;
        float r112 = (r13 - r15) / r111;
        r14.setBounds(r8.left + ((int) Math.ceil(r20)), (int) Math.ceil(r8.top + r112), (int) Math.ceil(r8.right - r20), (int) Math.ceil(r8.bottom - r112));
        float r21 = r19;
        r7 = r7;
    L22:
        String r22 = r7.b;
        if (r22 == null) goto L38;
        Paint.FontMetrics r113 = a().getFontMetrics();
        float r114 = a().measureText(r22, 0, r22.length());
        float r115 = r113.descent - r113.ascent;
        if (((int) r19) != 0) goto L27;
        float r116 = this.c;
        float r23 = r19 + (((int) r116) * 2);
        r21 = Math.max(r21, r114 + (r116 * 2));
    L29:
        if (r21 <= r11) goto L37;
        float r24 = r11 - r23;
        if (r24 <= 0.0f) goto L36;
        String r25 = TextUtils.ellipsize(r22, a(), r24, TextUtils.TruncateAt.END).toString();
        r7.h = r25;
        float r26 = r23 + a().measureText(r25, 0, r25.length());
        if (StringsKt.isBlank(r25) == false) goto L35;
        r7.i = false;
    L35:
        r21 = r26;
        goto L37
    L36:
        r7.h = "";
        r7.i = false;
    L37:
        r13 = Math.max(r13, r115);
        goto L38
    L27:
        float r117 = this.c;
        r23 = r19 + ((int) r117);
        r21 = r21 + (r114 + r117);
    L38:
        Drawable r27 = r7.f;
        if (r27 != null) goto L41;
    L49:
        int r29 = r8.left;
        r8.set(r29, r8.top, ((int) Math.ceil(r21)) + r29, r8.top + ((int) Math.ceil(r13)));
        goto L50
    L41:
        if (r7.k.isEmpty() == false) goto L43;
        int r30 = r27.getIntrinsicWidth();
    L45:
        if (r7.k.isEmpty() == false) goto L47;
        int r31 = r27.getIntrinsicHeight();
    L48:
        r21 = Math.min(Math.max(r21, r30), this.f);
        r13 = Math.max(r13, r31);
        int r32 = r8.left;
        r27.setBounds(r32, r8.top, ((int) Math.ceil(r21)) + r32, r8.top + ((int) Math.ceil(r13)));
        goto L49
    L47:
        r31 = r7.k.height();
        goto L48
    L43:
        r30 = r7.k.width();
        goto L45
    L21:
        r21 = r12;
        r19 = 0.0f;
        goto L22
    L10:
        if (getBounds().isEmpty() == true) goto L12;
        r10 = getBounds().right - r6;
    L52:
        this.m.set(0, 0, r4, r5);
        if (r17 == false) goto L59;
        this.l.set(0, 0, r4, r5);
        super.setBounds(0, 0, r4, r5);
        invalidateSelf();
        return;
    L59:
        return;
    L51:
        r4 = 0;
        r5 = 0;
        goto L52
    }

    public final void c(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        Drawable[] r0 = r5.getCompoundDrawables();
        if (Intrinsics.areEqual(r0[2], this) == true) goto L6;
        r5.setCompoundDrawablePadding((int) h18.d.a(this.a.getContext(), 4.0f));
        r5.setCompoundDrawables(r0[0], r0[1], this, r0[3]);
        return;
    }

    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (Intrinsics.areEqual(r2.getBackground(), this) == true) goto L6;
        r2.setBackground(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        List<d> r0 = this.k;
        if (r0 == null) goto L23;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L30;
        d r2 = (d) r1.next();
        if (r2.i == false) goto L9;
        Rect r3 = r2.j;
        int r4 = r3.left;
        Drawable r5 = r2.f;
        if (r5 == null) goto L13;
        r5.draw(r8);
    L13:
        Drawable r6 = r2.d;
        if (r6 == null) goto L16;
        r6.draw(r8);
        r4 = r6.getBounds().right;
    L16:
        String r7 = r2.b;
        if (r7 == null) goto L6;
        a().setTextSize(this.b);
        a().setColor(r2.c);
        a().setStrikeThruText(r2.g);
        Paint.FontMetrics r9 = a().getFontMetrics();
        float r10 = (r9.ascent + r9.descent) / 2;
        String r11 = r2.h;
        if (r11 == null) goto L22;
        r7 = r11;
    L22:
        r8.drawText(r7, (r4 + r3.right) / 2.0f, r3.exactCenterY() - r10, a());
        goto L6
    L9:
        return;
    L30:
        return;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(UDTagsDrawable.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable");
        UDTagsDrawable r6 = (UDTagsDrawable) r5;
        if (this.b != r6.b) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (this.c != r6.c) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == true) goto L25;
        return false;
    L25:
        if (this.d != r6.d) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == true) goto L31;
        return false;
    L31:
        if (this.e != r6.e) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == true) goto L37;
        return false;
    L37:
        if (this.f != r6.f) goto L39;
        boolean r8 = true;
    L40:
        if (r8 == true) goto L43;
        return false;
    L43:
        if (this.g != r6.g) goto L45;
        boolean r9 = true;
    L46:
        if (r9 == true) goto L49;
        return false;
    L49:
        if (this.h != r6.h) goto L51;
        boolean r10 = true;
    L52:
        if (r10 == true) goto L55;
        return false;
    L55:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L57;
        return false;
    L57:
        return true;
    L51:
        r10 = false;
        goto L52
    L45:
        r9 = false;
        goto L46
    L39:
        r8 = false;
        goto L40
    L33:
        r7 = false;
        goto L34
    L27:
        r4 = false;
        goto L28
    L21:
        r3 = false;
        goto L22
    L15:
        r1 = false;
        goto L16
    L8:
        r2 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r1, int r2, int r3, int r4) {
        super.setBounds(r1, r2, r3, r4);
        b(false);
    }
}
