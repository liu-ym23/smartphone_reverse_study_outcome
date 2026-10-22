package com.larus.common_ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;
import z19.a0;
import z19.y;
import z19.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002!\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u001a\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/common_ui/widget/TagTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "orangeStyle", "Lcom/larus/common_ui/widget/TagTextView$TagStyleData;", "getOrangeStyle", "()Lcom/larus/common_ui/widget/TagTextView$TagStyleData;", "orangeStyle$delegate", "Lkotlin/Lazy;", "blueStyle", "getBlueStyle", "blueStyle$delegate", "blueStyleForImmerse", "getBlueStyleForImmerse", "blueStyleForImmerse$delegate", "setTagFromFreeStyle", "tagName", "", "darkMode", "", "fontColor", "backgroundColor", "edgeColor", "setTag", "style", "Lcom/larus/common_ui/widget/TagTextView$TagStyle;", "TagStyleData", "TagStyle", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagTextView extends AppCompatTextView {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/widget/TagTextView$TagStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BLUE", "BLUE_IMMERSE", "ORANGE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TagStyle extends Enum<TagStyle> {
        public static final TagStyle BLUE = null;
        public static final TagStyle BLUE_IMMERSE = null;
        public static final TagStyle ORANGE = null;
        public static final /* synthetic */ TagStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TagStyle> getEntries() {
            return b;
        }

        static {
            TagStyle r0 = new TagStyle("BLUE", 0);
            BLUE = r0;
            TagStyle r1 = new TagStyle("BLUE_IMMERSE", 1);
            BLUE_IMMERSE = r1;
            TagStyle r3 = new TagStyle("ORANGE", 2);
            ORANGE = r3;
            TagStyle[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static TagStyle[] values() {
            return (TagStyle[]) a.clone();
        }

        public static TagStyle valueOf(String r1) {
            return (TagStyle) r27.a.a(TagStyle.class, r1);
        }

        public TagStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final int a;
        public final int b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "TagStyleData(textColor=" + this.a + ", bgDrawable=" + this.b + ')';
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TagStyle.values().length];
            r0[TagStyle.BLUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TagStyle.ORANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TagStyle.BLUE_IMMERSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public TagTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TagTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final a getBlueStyle() {
        return (a) this.b.getValue();
    }

    private final a getBlueStyleForImmerse() {
        return (a) this.c.getValue();
    }

    private final a getOrangeStyle() {
        return (a) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "deprecated for setTag by tag info ui kit")
    public final void x(String r2, TagStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "tagName");
        Intrinsics.checkNotNullParameter(r3, "style");
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        a r5 = getBlueStyle();
    L13:
        setText(r2);
        setTextColor(ContextCompat.getColor(getContext(), r5.a));
        setBackground(ContextCompat.getDrawable(getContext(), r5.b));
        return;
    L5:
        if (r4 != 2) goto L7;
        r5 = getOrangeStyle();
        goto L13
    L7:
        if (r4 != 3) goto L10;
        r5 = getBlueStyleForImmerse();
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TagTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new y());
        this.b = LazyKt.lazy(new z());
        this.c = LazyKt.lazy(new a0());
        setTextSize(11.0f);
        setTypeface(getTypeface(), 1);
        setPadding(i5.j0(), 0, i5.j0(), 0);
        setGravity(16);
    }

    public /* synthetic */ TagTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(String r4, boolean r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "tagName");
        setText(r4);
        GradientDrawable r9 = null;
        if (r5 == false) goto L7;
        Drawable r10 = ContextCompat.getDrawable(getContext(), 2131239793);
        if (r10 == null) goto L10;
        Drawable r11 = r10.mutate();
    L11:
        if (r6 != 0) goto L15;
        if (r7 != 0) goto L15;
        if (r8 != 0) goto L15;
        setTextColor(ContextCompat.getColor(getContext(), c.b(2130972123, getContext(), 2131103203)));
    L22:
        setBackground(r11);
        return;
    L15:
        setTextColor(r6);
        if (r11 == null) goto L22;
        if ((r11 instanceof GradientDrawable) == false) goto L20;
        r9 = (GradientDrawable) r11;
    L20:
        if (r9 == null) goto L22;
        r9.setColor(r7);
        r9.setStroke(1, r8);
        Unit r12 = Unit.INSTANCE;
    L10:
        r11 = null;
        goto L11
    L7:
        Drawable r13 = ContextCompat.getDrawable(getContext(), c.b(2130970855, getContext(), 2131239791));
        if (r13 == null) goto L10;
        r11 = r13.mutate();
        goto L11
    }
}
