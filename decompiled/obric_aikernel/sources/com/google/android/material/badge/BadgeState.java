package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.c;
import java.util.Locale;
import q5.d;
import q5.i;
import q5.j;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BadgeState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final State f2992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f2993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final float f2994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f2995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final float f2996e;

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = null;
        private static final int NOT_SET = -2;

        @Dimension(unit = 1)
        private Integer additionalHorizontalOffset;

        @Dimension(unit = 1)
        private Integer additionalVerticalOffset;
        private int alpha;

        @ColorInt
        private Integer backgroundColor;
        private Integer badgeGravity;

        @XmlRes
        private int badgeResId;

        @ColorInt
        private Integer badgeTextColor;

        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @Nullable
        private CharSequence contentDescriptionNumberless;

        @PluralsRes
        private int contentDescriptionQuantityStrings;

        @Dimension(unit = 1)
        private Integer horizontalOffsetWithText;

        @Dimension(unit = 1)
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private int maxCharacterCount;
        private int number;
        private Locale numberLocale;

        @Dimension(unit = 1)
        private Integer verticalOffsetWithText;

        @Dimension(unit = 1)
        private Integer verticalOffsetWithoutText;

        class a implements Parcelable.Creator<State> {
            a() {
            }

            @NonNull
            public State a(@NonNull Parcel r10) {
                return new State(r10);
            }

            @NonNull
            public State[] b(int r10) {
                return new State[r10];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ State createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ State[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = Boolean.TRUE;
        }

        State(@NonNull Parcel r10) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = Boolean.TRUE;
            this.badgeResId = r10.readInt();
            this.backgroundColor = (Integer) r10.readSerializable();
            this.badgeTextColor = (Integer) r10.readSerializable();
            this.alpha = r10.readInt();
            this.number = r10.readInt();
            this.maxCharacterCount = r10.readInt();
            this.contentDescriptionNumberless = r10.readString();
            this.contentDescriptionQuantityStrings = r10.readInt();
            this.badgeGravity = (Integer) r10.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) r10.readSerializable();
            this.verticalOffsetWithoutText = (Integer) r10.readSerializable();
            this.horizontalOffsetWithText = (Integer) r10.readSerializable();
            this.verticalOffsetWithText = (Integer) r10.readSerializable();
            this.additionalHorizontalOffset = (Integer) r10.readSerializable();
            this.additionalVerticalOffset = (Integer) r10.readSerializable();
            this.isVisible = (Boolean) r10.readSerializable();
            this.numberLocale = (Locale) r10.readSerializable();
        }

        static /* synthetic */ int access$000(State r10) {
            return r10.badgeResId;
        }

        static /* synthetic */ int access$002(State r10, int r11) {
            r10.badgeResId = r11;
            return r11;
        }

        static /* synthetic */ int access$100(State r10) {
            return r10.alpha;
        }

        static /* synthetic */ Integer access$1000(State r10) {
            return r10.badgeGravity;
        }

        static /* synthetic */ Integer access$1002(State r10, Integer r11) {
            r10.badgeGravity = r11;
            return r11;
        }

        static /* synthetic */ int access$102(State r10, int r11) {
            r10.alpha = r11;
            return r11;
        }

        static /* synthetic */ Integer access$1100(State r10) {
            return r10.horizontalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1102(State r10, Integer r11) {
            r10.horizontalOffsetWithoutText = r11;
            return r11;
        }

        static /* synthetic */ Integer access$1200(State r10) {
            return r10.verticalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1202(State r10, Integer r11) {
            r10.verticalOffsetWithoutText = r11;
            return r11;
        }

        static /* synthetic */ Integer access$1300(State r10) {
            return r10.horizontalOffsetWithText;
        }

        static /* synthetic */ Integer access$1302(State r10, Integer r11) {
            r10.horizontalOffsetWithText = r11;
            return r11;
        }

        static /* synthetic */ Integer access$1400(State r10) {
            return r10.verticalOffsetWithText;
        }

        static /* synthetic */ Integer access$1402(State r10, Integer r11) {
            r10.verticalOffsetWithText = r11;
            return r11;
        }

        static /* synthetic */ Integer access$1500(State r10) {
            return r10.additionalHorizontalOffset;
        }

        static /* synthetic */ Integer access$1502(State r10, Integer r11) {
            r10.additionalHorizontalOffset = r11;
            return r11;
        }

        static /* synthetic */ Integer access$1600(State r10) {
            return r10.additionalVerticalOffset;
        }

        static /* synthetic */ Integer access$1602(State r10, Integer r11) {
            r10.additionalVerticalOffset = r11;
            return r11;
        }

        static /* synthetic */ Locale access$1700(State r10) {
            return r10.numberLocale;
        }

        static /* synthetic */ Locale access$1702(State r10, Locale r11) {
            r10.numberLocale = r11;
            return r11;
        }

        static /* synthetic */ CharSequence access$200(State r10) {
            return r10.contentDescriptionNumberless;
        }

        static /* synthetic */ CharSequence access$202(State r10, CharSequence r11) {
            r10.contentDescriptionNumberless = r11;
            return r11;
        }

        static /* synthetic */ int access$300(State r10) {
            return r10.contentDescriptionQuantityStrings;
        }

        static /* synthetic */ int access$302(State r10, int r11) {
            r10.contentDescriptionQuantityStrings = r11;
            return r11;
        }

        static /* synthetic */ int access$400(State r10) {
            return r10.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static /* synthetic */ int access$402(State r10, int r11) {
            r10.contentDescriptionExceedsMaxBadgeNumberRes = r11;
            return r11;
        }

        static /* synthetic */ Boolean access$500(State r10) {
            return r10.isVisible;
        }

        static /* synthetic */ Boolean access$502(State r10, Boolean r11) {
            r10.isVisible = r11;
            return r11;
        }

        static /* synthetic */ int access$600(State r10) {
            return r10.maxCharacterCount;
        }

        static /* synthetic */ int access$602(State r10, int r11) {
            r10.maxCharacterCount = r11;
            return r11;
        }

        static /* synthetic */ int access$700(State r10) {
            return r10.number;
        }

        static /* synthetic */ int access$702(State r10, int r11) {
            r10.number = r11;
            return r11;
        }

        static /* synthetic */ Integer access$800(State r10) {
            return r10.backgroundColor;
        }

        static /* synthetic */ Integer access$802(State r10, Integer r11) {
            r10.backgroundColor = r11;
            return r11;
        }

        static /* synthetic */ Integer access$900(State r10) {
            return r10.badgeTextColor;
        }

        static /* synthetic */ Integer access$902(State r10, Integer r11) {
            r10.badgeTextColor = r11;
            return r11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            r10.writeInt(this.badgeResId);
            r10.writeSerializable(this.backgroundColor);
            r10.writeSerializable(this.badgeTextColor);
            r10.writeInt(this.alpha);
            r10.writeInt(this.number);
            r10.writeInt(this.maxCharacterCount);
            CharSequence r12 = this.contentDescriptionNumberless;
            if (r12 != null) goto L5;
            String r13 = null;
        L6:
            r10.writeString(r13);
            r10.writeInt(this.contentDescriptionQuantityStrings);
            r10.writeSerializable(this.badgeGravity);
            r10.writeSerializable(this.horizontalOffsetWithoutText);
            r10.writeSerializable(this.verticalOffsetWithoutText);
            r10.writeSerializable(this.horizontalOffsetWithText);
            r10.writeSerializable(this.verticalOffsetWithText);
            r10.writeSerializable(this.additionalHorizontalOffset);
            r10.writeSerializable(this.additionalVerticalOffset);
            r10.writeSerializable(this.isVisible);
            r10.writeSerializable(this.numberLocale);
            return;
        L5:
            r13 = r12.toString();
            goto L6
        }
    }

    BadgeState(Context r10, @XmlRes int r11, @AttrRes int r12, @StyleRes int r13, @Nullable State r14) {
        State r15 = new State();
        this.f2993b = r15;
        if (r14 != null) goto L5;
        r14 = new State();
    L5:
        if (r11 == 0) goto L7;
        State.access$002(r14, r11);
    L7:
        TypedArray r16 = a(r10, State.access$000(r14), r12, r13);
        Resources r17 = r10.getResources();
        this.f2994c = r16.getDimensionPixelSize(l.Badge_badgeRadius, r17.getDimensionPixelSize(d.mtrl_badge_radius));
        this.f2996e = r16.getDimensionPixelSize(l.Badge_badgeWidePadding, r17.getDimensionPixelSize(d.mtrl_badge_long_text_horizontal_padding));
        this.f2995d = r16.getDimensionPixelSize(l.Badge_badgeWithTextRadius, r17.getDimensionPixelSize(d.mtrl_badge_with_text_radius));
        if (State.access$100(r14) != (-2)) goto L10;
        int r18 = 255;
    L11:
        State.access$102(r15, r18);
        if (State.access$200(r14) != null) goto L14;
        CharSequence r19 = r10.getString(j.mtrl_badge_numberless_content_description);
    L15:
        State.access$202(r15, r19);
        if (State.access$300(r14) != 0) goto L18;
        int r20 = i.mtrl_badge_content_description;
    L19:
        State.access$302(r15, r20);
        if (State.access$400(r14) != 0) goto L22;
        int r21 = j.mtrl_exceed_max_badge_number_content_description;
    L23:
        State.access$402(r15, r21);
        int r22 = 0;
        if (State.access$500(r14) != null) goto L26;
    L29:
        boolean r23 = true;
    L30:
        State.access$502(r15, Boolean.valueOf(r23));
        if (State.access$600(r14) != (-2)) goto L33;
        int r24 = r16.getInt(l.Badge_maxCharacterCount, 4);
    L34:
        State.access$602(r15, r24);
        if (State.access$700(r14) == (-2)) goto L38;
        int r25 = State.access$700(r14);
    L37:
        State.access$702(r15, r25);
        if (State.access$800(r14) != null) goto L45;
        int r26 = u(r10, r16, l.Badge_backgroundColor);
    L46:
        State.access$802(r15, Integer.valueOf(r26));
        if (State.access$900(r14) == null) goto L50;
        Integer r27 = State.access$900(r14);
    L49:
        State.access$902(r15, r27);
        if (State.access$1000(r14) != null) goto L58;
        int r28 = r16.getInt(l.Badge_badgeGravity, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END);
    L59:
        State.access$1002(r15, Integer.valueOf(r28));
        if (State.access$1100(r14) != null) goto L62;
        int r29 = r16.getDimensionPixelOffset(l.Badge_horizontalOffset, 0);
    L63:
        State.access$1102(r15, Integer.valueOf(r29));
        if (State.access$1100(r14) != null) goto L66;
        int r30 = r16.getDimensionPixelOffset(l.Badge_verticalOffset, 0);
    L67:
        State.access$1202(r15, Integer.valueOf(r30));
        if (State.access$1300(r14) != null) goto L70;
        int r31 = r16.getDimensionPixelOffset(l.Badge_horizontalOffsetWithText, State.access$1100(r15).intValue());
    L71:
        State.access$1302(r15, Integer.valueOf(r31));
        if (State.access$1400(r14) != null) goto L74;
        int r32 = r16.getDimensionPixelOffset(l.Badge_verticalOffsetWithText, State.access$1200(r15).intValue());
    L75:
        State.access$1402(r15, Integer.valueOf(r32));
        if (State.access$1500(r14) != null) goto L78;
        int r33 = 0;
    L79:
        State.access$1502(r15, Integer.valueOf(r33));
        if (State.access$1600(r14) == null) goto L83;
        r22 = State.access$1600(r14).intValue();
    L83:
        State.access$1602(r15, Integer.valueOf(r22));
        r16.recycle();
        if (State.access$1700(r14) == null) goto L86;
        Locale r34 = State.access$1700(r14);
    L90:
        State.access$1702(r15, r34);
        this.f2992a = r14;
        return;
    L86:
        if (Build.VERSION.SDK_INT < 24) goto L88;
        r34 = Locale.getDefault(Locale.Category.FORMAT);
        goto L90
    L88:
        r34 = Locale.getDefault();
        goto L90
    L78:
        r33 = State.access$1500(r14).intValue();
        goto L79
    L74:
        r32 = State.access$1400(r14).intValue();
        goto L75
    L70:
        r31 = State.access$1300(r14).intValue();
        goto L71
    L66:
        r30 = State.access$1200(r14).intValue();
        goto L67
    L62:
        r29 = State.access$1100(r14).intValue();
        goto L63
    L58:
        r28 = State.access$1000(r14).intValue();
        goto L59
    L50:
        int r35 = l.Badge_badgeTextColor;
        if (r16.hasValue(r35) == false) goto L53;
        int r36 = u(r10, r16, r35);
    L54:
        r27 = Integer.valueOf(r36);
        goto L49
    L53:
        r36 = new TextAppearance(r10, k.TextAppearance_MaterialComponents_Badge).i().getDefaultColor();
        goto L54
    L45:
        r26 = State.access$800(r14).intValue();
        goto L46
    L38:
        int r37 = l.Badge_number;
        if (r16.hasValue(r37) == false) goto L41;
        r25 = r16.getInt(r37, 0);
        goto L37
    L41:
        r25 = -1;
        goto L37
    L33:
        r24 = State.access$600(r14);
        goto L34
    L26:
        if (State.access$500(r14).booleanValue() == true) goto L29;
        r23 = false;
        goto L30
    L22:
        r21 = State.access$400(r14);
        goto L23
    L18:
        r20 = State.access$300(r14);
        goto L19
    L14:
        r19 = State.access$200(r14);
        goto L15
    L10:
        r18 = State.access$100(r14);
        goto L11
    }

    private TypedArray a(Context r10, @XmlRes int r11, @AttrRes int r12, @StyleRes int r13) {
        if (r11 == 0) goto L5;
        AttributeSet r14 = v5.a.a(r10, r11, "badge");
        int r15 = r14.getStyleAttribute();
    L6:
        AttributeSet r16 = r14;
        if (r15 != 0) goto L9;
        int r17 = r13;
    L11:
        return com.google.android.material.internal.k.h(r10, r16, l.Badge, r12, r17, new int[0]);
    L9:
        r17 = r15;
        goto L11
    L5:
        r14 = null;
        r15 = 0;
        goto L6
    }

    private static int u(Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        return c.a(r10, r11, r12).getDefaultColor();
    }

    @Dimension(unit = 1)
    int b() {
        return State.access$1500(this.f2993b).intValue();
    }

    @Dimension(unit = 1)
    int c() {
        return State.access$1600(this.f2993b).intValue();
    }

    int d() {
        return State.access$100(this.f2993b);
    }

    @ColorInt
    int e() {
        return State.access$800(this.f2993b).intValue();
    }

    int f() {
        return State.access$1000(this.f2993b).intValue();
    }

    @ColorInt
    int g() {
        return State.access$900(this.f2993b).intValue();
    }

    @StringRes
    int h() {
        return State.access$400(this.f2993b);
    }

    CharSequence i() {
        return State.access$200(this.f2993b);
    }

    @PluralsRes
    int j() {
        return State.access$300(this.f2993b);
    }

    @Dimension(unit = 1)
    int k() {
        return State.access$1300(this.f2993b).intValue();
    }

    @Dimension(unit = 1)
    int l() {
        return State.access$1100(this.f2993b).intValue();
    }

    int m() {
        return State.access$600(this.f2993b);
    }

    int n() {
        return State.access$700(this.f2993b);
    }

    Locale o() {
        return State.access$1700(this.f2993b);
    }

    State p() {
        return this.f2992a;
    }

    @Dimension(unit = 1)
    int q() {
        return State.access$1400(this.f2993b).intValue();
    }

    @Dimension(unit = 1)
    int r() {
        return State.access$1200(this.f2993b).intValue();
    }

    boolean s() {
        if (State.access$700(this.f2993b) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean t() {
        return State.access$500(this.f2993b).booleanValue();
    }

    void v(int r10) {
        State.access$102(this.f2992a, r10);
        State.access$102(this.f2993b, r10);
    }
}
