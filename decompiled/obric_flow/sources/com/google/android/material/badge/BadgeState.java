package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    final float badgeHeight;
    final float badgeRadius;
    final float badgeWidth;
    final float badgeWithTextHeight;
    final float badgeWithTextRadius;
    final float badgeWithTextWidth;
    private final State currentState;
    final int horizontalInset;
    final int horizontalInsetWithText;
    int offsetAlignmentMode;
    private final State overridingState;

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = null;
        private static final int NOT_SET = -2;

        @Dimension(unit = 1)
        private Integer additionalHorizontalOffset;

        @Dimension(unit = 1)
        private Integer additionalVerticalOffset;
        private int alpha;
        private Boolean autoAdjustToWithinGrandparentBounds;

        @ColorInt
        private Integer backgroundColor;
        private Integer badgeGravity;

        @Px
        private Integer badgeHorizontalPadding;

        @XmlRes
        private int badgeResId;

        @StyleRes
        private Integer badgeShapeAppearanceOverlayResId;

        @StyleRes
        private Integer badgeShapeAppearanceResId;

        @StyleRes
        private Integer badgeTextAppearanceResId;

        @ColorInt
        private Integer badgeTextColor;

        @Px
        private Integer badgeVerticalPadding;

        @StyleRes
        private Integer badgeWithTextShapeAppearanceOverlayResId;

        @StyleRes
        private Integer badgeWithTextShapeAppearanceResId;

        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @Nullable
        private CharSequence contentDescriptionForText;

        @Nullable
        private CharSequence contentDescriptionNumberless;

        @PluralsRes
        private int contentDescriptionQuantityStrings;

        @Dimension(unit = 1)
        private Integer horizontalOffsetWithText;

        @Dimension(unit = 1)
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;

        @Dimension(unit = 1)
        private Integer largeFontVerticalOffsetAdjustment;
        private int maxCharacterCount;
        private int maxNumber;
        private int number;
        private Locale numberLocale;

        @Nullable
        private String text;

        @Dimension(unit = 1)
        private Integer verticalOffsetWithText;

        @Dimension(unit = 1)
        private Integer verticalOffsetWithoutText;

        static {
            CREATOR = new AnonymousClass1();
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = Boolean.TRUE;
        }

        public static /* synthetic */ int access$000(State r5) {
            return r5.badgeResId;
        }

        public static /* synthetic */ int access$002(State r5, int r10) {
            r5.badgeResId = r10;
            return r10;
        }

        public static /* synthetic */ int access$100(State r5) {
            return r5.alpha;
        }

        public static /* synthetic */ int access$1000(State r5) {
            return r5.maxNumber;
        }

        public static /* synthetic */ int access$1002(State r5, int r10) {
            r5.maxNumber = r10;
            return r10;
        }

        public static /* synthetic */ int access$102(State r5, int r10) {
            r5.alpha = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1100(State r5) {
            return r5.badgeShapeAppearanceResId;
        }

        public static /* synthetic */ Integer access$1102(State r5, Integer r10) {
            r5.badgeShapeAppearanceResId = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1200(State r5) {
            return r5.badgeShapeAppearanceOverlayResId;
        }

        public static /* synthetic */ Integer access$1202(State r5, Integer r10) {
            r5.badgeShapeAppearanceOverlayResId = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1300(State r5) {
            return r5.badgeWithTextShapeAppearanceResId;
        }

        public static /* synthetic */ Integer access$1302(State r5, Integer r10) {
            r5.badgeWithTextShapeAppearanceResId = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1400(State r5) {
            return r5.badgeWithTextShapeAppearanceOverlayResId;
        }

        public static /* synthetic */ Integer access$1402(State r5, Integer r10) {
            r5.badgeWithTextShapeAppearanceOverlayResId = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1500(State r5) {
            return r5.backgroundColor;
        }

        public static /* synthetic */ Integer access$1502(State r5, Integer r10) {
            r5.backgroundColor = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1600(State r5) {
            return r5.badgeTextAppearanceResId;
        }

        public static /* synthetic */ Integer access$1602(State r5, Integer r10) {
            r5.badgeTextAppearanceResId = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1700(State r5) {
            return r5.badgeTextColor;
        }

        public static /* synthetic */ Integer access$1702(State r5, Integer r10) {
            r5.badgeTextColor = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1800(State r5) {
            return r5.badgeGravity;
        }

        public static /* synthetic */ Integer access$1802(State r5, Integer r10) {
            r5.badgeGravity = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$1900(State r5) {
            return r5.badgeHorizontalPadding;
        }

        public static /* synthetic */ Integer access$1902(State r5, Integer r10) {
            r5.badgeHorizontalPadding = r10;
            return r10;
        }

        public static /* synthetic */ int access$200(State r5) {
            return r5.number;
        }

        public static /* synthetic */ Integer access$2000(State r5) {
            return r5.badgeVerticalPadding;
        }

        public static /* synthetic */ Integer access$2002(State r5, Integer r10) {
            r5.badgeVerticalPadding = r10;
            return r10;
        }

        public static /* synthetic */ int access$202(State r5, int r10) {
            r5.number = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2100(State r5) {
            return r5.horizontalOffsetWithoutText;
        }

        public static /* synthetic */ Integer access$2102(State r5, Integer r10) {
            r5.horizontalOffsetWithoutText = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2200(State r5) {
            return r5.verticalOffsetWithoutText;
        }

        public static /* synthetic */ Integer access$2202(State r5, Integer r10) {
            r5.verticalOffsetWithoutText = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2300(State r5) {
            return r5.horizontalOffsetWithText;
        }

        public static /* synthetic */ Integer access$2302(State r5, Integer r10) {
            r5.horizontalOffsetWithText = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2400(State r5) {
            return r5.verticalOffsetWithText;
        }

        public static /* synthetic */ Integer access$2402(State r5, Integer r10) {
            r5.verticalOffsetWithText = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2500(State r5) {
            return r5.largeFontVerticalOffsetAdjustment;
        }

        public static /* synthetic */ Integer access$2502(State r5, Integer r10) {
            r5.largeFontVerticalOffsetAdjustment = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2600(State r5) {
            return r5.additionalHorizontalOffset;
        }

        public static /* synthetic */ Integer access$2602(State r5, Integer r10) {
            r5.additionalHorizontalOffset = r10;
            return r10;
        }

        public static /* synthetic */ Integer access$2700(State r5) {
            return r5.additionalVerticalOffset;
        }

        public static /* synthetic */ Integer access$2702(State r5, Integer r10) {
            r5.additionalVerticalOffset = r10;
            return r10;
        }

        public static /* synthetic */ Boolean access$2800(State r5) {
            return r5.autoAdjustToWithinGrandparentBounds;
        }

        public static /* synthetic */ Boolean access$2802(State r5, Boolean r10) {
            r5.autoAdjustToWithinGrandparentBounds = r10;
            return r10;
        }

        public static /* synthetic */ Locale access$2900(State r5) {
            return r5.numberLocale;
        }

        public static /* synthetic */ Locale access$2902(State r5, Locale r10) {
            r5.numberLocale = r10;
            return r10;
        }

        public static /* synthetic */ String access$300(State r5) {
            return r5.text;
        }

        public static /* synthetic */ String access$302(State r5, String r10) {
            r5.text = r10;
            return r10;
        }

        public static /* synthetic */ CharSequence access$400(State r5) {
            return r5.contentDescriptionForText;
        }

        public static /* synthetic */ CharSequence access$402(State r5, CharSequence r10) {
            r5.contentDescriptionForText = r10;
            return r10;
        }

        public static /* synthetic */ CharSequence access$500(State r5) {
            return r5.contentDescriptionNumberless;
        }

        public static /* synthetic */ CharSequence access$502(State r5, CharSequence r10) {
            r5.contentDescriptionNumberless = r10;
            return r10;
        }

        public static /* synthetic */ int access$600(State r5) {
            return r5.contentDescriptionQuantityStrings;
        }

        public static /* synthetic */ int access$602(State r5, int r10) {
            r5.contentDescriptionQuantityStrings = r10;
            return r10;
        }

        public static /* synthetic */ int access$700(State r5) {
            return r5.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        public static /* synthetic */ int access$702(State r5, int r10) {
            r5.contentDescriptionExceedsMaxBadgeNumberRes = r10;
            return r10;
        }

        public static /* synthetic */ Boolean access$800(State r5) {
            return r5.isVisible;
        }

        public static /* synthetic */ Boolean access$802(State r5, Boolean r10) {
            r5.isVisible = r10;
            return r10;
        }

        public static /* synthetic */ int access$900(State r5) {
            return r5.maxCharacterCount;
        }

        public static /* synthetic */ int access$902(State r5, int r10) {
            r5.maxCharacterCount = r10;
            return r10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            r5.writeInt(this.badgeResId);
            r5.writeSerializable(this.backgroundColor);
            r5.writeSerializable(this.badgeTextColor);
            r5.writeSerializable(this.badgeTextAppearanceResId);
            r5.writeSerializable(this.badgeShapeAppearanceResId);
            r5.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            r5.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            r5.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            r5.writeInt(this.alpha);
            r5.writeString(this.text);
            r5.writeInt(this.number);
            r5.writeInt(this.maxCharacterCount);
            r5.writeInt(this.maxNumber);
            CharSequence r11 = this.contentDescriptionForText;
            String r12 = null;
            if (r11 == null) goto L5;
            String r13 = r11.toString();
        L6:
            r5.writeString(r13);
            CharSequence r14 = this.contentDescriptionNumberless;
            if (r14 == null) goto L9;
            r12 = r14.toString();
        L9:
            r5.writeString(r12);
            r5.writeInt(this.contentDescriptionQuantityStrings);
            r5.writeSerializable(this.badgeGravity);
            r5.writeSerializable(this.badgeHorizontalPadding);
            r5.writeSerializable(this.badgeVerticalPadding);
            r5.writeSerializable(this.horizontalOffsetWithoutText);
            r5.writeSerializable(this.verticalOffsetWithoutText);
            r5.writeSerializable(this.horizontalOffsetWithText);
            r5.writeSerializable(this.verticalOffsetWithText);
            r5.writeSerializable(this.largeFontVerticalOffsetAdjustment);
            r5.writeSerializable(this.additionalHorizontalOffset);
            r5.writeSerializable(this.additionalVerticalOffset);
            r5.writeSerializable(this.isVisible);
            r5.writeSerializable(this.numberLocale);
            r5.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
            return;
        L5:
            r13 = null;
            goto L6
        }

        public State(@NonNull Parcel r5) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = Boolean.TRUE;
            this.badgeResId = r5.readInt();
            this.backgroundColor = (Integer) r5.readSerializable();
            this.badgeTextColor = (Integer) r5.readSerializable();
            this.badgeTextAppearanceResId = (Integer) r5.readSerializable();
            this.badgeShapeAppearanceResId = (Integer) r5.readSerializable();
            this.badgeShapeAppearanceOverlayResId = (Integer) r5.readSerializable();
            this.badgeWithTextShapeAppearanceResId = (Integer) r5.readSerializable();
            this.badgeWithTextShapeAppearanceOverlayResId = (Integer) r5.readSerializable();
            this.alpha = r5.readInt();
            this.text = r5.readString();
            this.number = r5.readInt();
            this.maxCharacterCount = r5.readInt();
            this.maxNumber = r5.readInt();
            this.contentDescriptionForText = r5.readString();
            this.contentDescriptionNumberless = r5.readString();
            this.contentDescriptionQuantityStrings = r5.readInt();
            this.badgeGravity = (Integer) r5.readSerializable();
            this.badgeHorizontalPadding = (Integer) r5.readSerializable();
            this.badgeVerticalPadding = (Integer) r5.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) r5.readSerializable();
            this.verticalOffsetWithoutText = (Integer) r5.readSerializable();
            this.horizontalOffsetWithText = (Integer) r5.readSerializable();
            this.verticalOffsetWithText = (Integer) r5.readSerializable();
            this.largeFontVerticalOffsetAdjustment = (Integer) r5.readSerializable();
            this.additionalHorizontalOffset = (Integer) r5.readSerializable();
            this.additionalVerticalOffset = (Integer) r5.readSerializable();
            this.isVisible = (Boolean) r5.readSerializable();
            this.numberLocale = (Locale) r5.readSerializable();
            this.autoAdjustToWithinGrandparentBounds = (Boolean) r5.readSerializable();
        }
    }

    public BadgeState(Context r10, @XmlRes int r11, @AttrRes int r12, @StyleRes int r13, @Nullable State r14) {
        State r5 = new State();
        this.currentState = r5;
        if (r14 != null) goto L5;
        r14 = new State();
    L5:
        if (r11 == 0) goto L7;
        State.access$002(r14, r11);
    L7:
        TypedArray r15 = generateTypedArray(r10, State.access$000(r14), r12, r13);
        Resources r16 = r10.getResources();
        this.badgeRadius = r15.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.horizontalInset = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = r15.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        this.badgeWidth = r15.getDimension(R.styleable.Badge_badgeWidth, r16.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextWidth = r15.getDimension(R.styleable.Badge_badgeWithTextWidth, r16.getDimension(R.dimen.m3_badge_with_text_size));
        this.badgeHeight = r15.getDimension(R.styleable.Badge_badgeHeight, r16.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextHeight = r15.getDimension(R.styleable.Badge_badgeWithTextHeight, r16.getDimension(R.dimen.m3_badge_with_text_size));
        boolean r17 = true;
        this.offsetAlignmentMode = r15.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        if (State.access$100(r14) != (-2)) goto L10;
        int r18 = 255;
    L11:
        State.access$102(r5, r18);
        if (State.access$200(r14) == (-2)) goto L15;
        State.access$202(r5, State.access$200(r14));
    L19:
        if (State.access$300(r14) == null) goto L22;
        State.access$302(r5, State.access$300(r14));
    L24:
        State.access$402(r5, State.access$400(r14));
        if (State.access$500(r14) != null) goto L27;
        CharSequence r19 = r10.getString(R.string.mtrl_badge_numberless_content_description);
    L28:
        State.access$502(r5, r19);
        if (State.access$600(r14) != 0) goto L31;
        int r20 = R.plurals.mtrl_badge_content_description;
    L32:
        State.access$602(r5, r20);
        if (State.access$700(r14) != 0) goto L35;
        int r21 = R.string.mtrl_exceed_max_badge_number_content_description;
    L36:
        State.access$702(r5, r21);
        if (State.access$800(r14) != null) goto L39;
    L42:
        State.access$802(r5, Boolean.valueOf(r17));
        if (State.access$900(r14) != (-2)) goto L45;
        int r22 = r15.getInt(R.styleable.Badge_maxCharacterCount, -2);
    L46:
        State.access$902(r5, r22);
        if (State.access$1000(r14) != (-2)) goto L49;
        int r23 = r15.getInt(R.styleable.Badge_maxNumber, -2);
    L50:
        State.access$1002(r5, r23);
        if (State.access$1100(r14) != null) goto L53;
        int r24 = r15.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
    L54:
        State.access$1102(r5, Integer.valueOf(r24));
        if (State.access$1200(r14) != null) goto L57;
        int r25 = r15.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0);
    L58:
        State.access$1202(r5, Integer.valueOf(r25));
        if (State.access$1300(r14) != null) goto L61;
        int r26 = r15.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
    L62:
        State.access$1302(r5, Integer.valueOf(r26));
        if (State.access$1400(r14) != null) goto L65;
        int r27 = r15.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0);
    L66:
        State.access$1402(r5, Integer.valueOf(r27));
        if (State.access$1500(r14) != null) goto L69;
        int r28 = readColorFromAttributes(r10, r15, R.styleable.Badge_backgroundColor);
    L70:
        State.access$1502(r5, Integer.valueOf(r28));
        if (State.access$1600(r14) != null) goto L73;
        int r29 = r15.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge);
    L74:
        State.access$1602(r5, Integer.valueOf(r29));
        if (State.access$1700(r14) == null) goto L78;
        State.access$1702(r5, State.access$1700(r14));
    L82:
        if (State.access$1800(r14) != null) goto L84;
        int r30 = r15.getInt(R.styleable.Badge_badgeGravity, 8388661);
    L85:
        State.access$1802(r5, Integer.valueOf(r30));
        if (State.access$1900(r14) != null) goto L88;
        int r31 = r15.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, r16.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
    L89:
        State.access$1902(r5, Integer.valueOf(r31));
        if (State.access$2000(r14) != null) goto L92;
        int r32 = r15.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, r16.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding));
    L93:
        State.access$2002(r5, Integer.valueOf(r32));
        if (State.access$2100(r14) != null) goto L96;
        int r33 = r15.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
    L97:
        State.access$2102(r5, Integer.valueOf(r33));
        if (State.access$2200(r14) != null) goto L100;
        int r34 = r15.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
    L101:
        State.access$2202(r5, Integer.valueOf(r34));
        if (State.access$2300(r14) != null) goto L104;
        int r35 = r15.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, State.access$2100(r5).intValue());
    L105:
        State.access$2302(r5, Integer.valueOf(r35));
        if (State.access$2400(r14) != null) goto L108;
        int r36 = r15.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, State.access$2200(r5).intValue());
    L109:
        State.access$2402(r5, Integer.valueOf(r36));
        if (State.access$2500(r14) != null) goto L112;
        int r37 = r15.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0);
    L113:
        State.access$2502(r5, Integer.valueOf(r37));
        if (State.access$2600(r14) != null) goto L116;
        int r38 = 0;
    L117:
        State.access$2602(r5, Integer.valueOf(r38));
        if (State.access$2700(r14) != null) goto L120;
        int r39 = 0;
    L121:
        State.access$2702(r5, Integer.valueOf(r39));
        if (State.access$2800(r14) != null) goto L124;
        boolean r40 = r15.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false);
    L125:
        State.access$2802(r5, Boolean.valueOf(r40));
        r15.recycle();
        if (State.access$2900(r14) != null) goto L128;
        State.access$2902(r5, Locale.getDefault(Locale.Category.FORMAT));
    L129:
        this.overridingState = r14;
        return;
    L128:
        State.access$2902(r5, State.access$2900(r14));
        goto L129
    L124:
        r40 = State.access$2800(r14).booleanValue();
        goto L125
    L120:
        r39 = State.access$2700(r14).intValue();
        goto L121
    L116:
        r38 = State.access$2600(r14).intValue();
        goto L117
    L112:
        r37 = State.access$2500(r14).intValue();
        goto L113
    L108:
        r36 = State.access$2400(r14).intValue();
        goto L109
    L104:
        r35 = State.access$2300(r14).intValue();
        goto L105
    L100:
        r34 = State.access$2200(r14).intValue();
        goto L101
    L96:
        r33 = State.access$2100(r14).intValue();
        goto L97
    L92:
        r32 = State.access$2000(r14).intValue();
        goto L93
    L88:
        r31 = State.access$1900(r14).intValue();
        goto L89
    L84:
        r30 = State.access$1800(r14).intValue();
        goto L85
    L78:
        if (r15.hasValue(R.styleable.Badge_badgeTextColor) == false) goto L80;
        State.access$1702(r5, Integer.valueOf(readColorFromAttributes(r10, r15, R.styleable.Badge_badgeTextColor)));
        goto L82
    L80:
        State.access$1702(r5, Integer.valueOf(new TextAppearance(r10, State.access$1600(r5).intValue()).getTextColor().getDefaultColor()));
        goto L82
    L73:
        r29 = State.access$1600(r14).intValue();
        goto L74
    L69:
        r28 = State.access$1500(r14).intValue();
        goto L70
    L65:
        r27 = State.access$1400(r14).intValue();
        goto L66
    L61:
        r26 = State.access$1300(r14).intValue();
        goto L62
    L57:
        r25 = State.access$1200(r14).intValue();
        goto L58
    L53:
        r24 = State.access$1100(r14).intValue();
        goto L54
    L49:
        r23 = State.access$1000(r14);
        goto L50
    L45:
        r22 = State.access$900(r14);
        goto L46
    L39:
        if (State.access$800(r14).booleanValue() == true) goto L42;
        r17 = false;
        goto L42
    L35:
        r21 = State.access$700(r14);
        goto L36
    L31:
        r20 = State.access$600(r14);
        goto L32
    L27:
        r19 = State.access$500(r14);
        goto L28
    L22:
        if (r15.hasValue(R.styleable.Badge_badgeText) == false) goto L24;
        State.access$302(r5, r15.getString(R.styleable.Badge_badgeText));
        goto L24
    L15:
        if (r15.hasValue(R.styleable.Badge_number) == false) goto L17;
        State.access$202(r5, r15.getInt(R.styleable.Badge_number, 0));
        goto L19
    L17:
        State.access$202(r5, -1);
        goto L19
    L10:
        r18 = State.access$100(r14);
        goto L11
    }

    private TypedArray generateTypedArray(Context r10, @XmlRes int r11, @AttrRes int r12, @StyleRes int r13) {
        if (r11 == 0) goto L6;
        AttributeSet r14 = DrawableUtils.parseDrawableXml(r10, r11, BADGE_RESOURCE_TAG);
        int r5 = r14.getStyleAttribute();
    L5:
        AttributeSet r15 = r14;
        if (r5 != 0) goto L9;
        int r16 = r13;
    L11:
        return ThemeEnforcement.obtainStyledAttributes(r10, r15, R.styleable.Badge, r12, r16, new int[0]);
    L9:
        r16 = r5;
        goto L11
    L6:
        r14 = null;
        r5 = 0;
        goto L5
    }

    private static int readColorFromAttributes(Context r5, @NonNull TypedArray r10, @StyleableRes int r11) {
        return MaterialResources.getColorStateList(r5, r10, r11).getDefaultColor();
    }

    public void clearNumber() {
        setNumber(-1);
    }

    public void clearText() {
        setText(null);
    }

    @Dimension(unit = 1)
    public int getAdditionalHorizontalOffset() {
        return State.access$2600(this.currentState).intValue();
    }

    @Dimension(unit = 1)
    public int getAdditionalVerticalOffset() {
        return State.access$2700(this.currentState).intValue();
    }

    public int getAlpha() {
        return State.access$100(this.currentState);
    }

    @ColorInt
    public int getBackgroundColor() {
        return State.access$1500(this.currentState).intValue();
    }

    public int getBadgeGravity() {
        return State.access$1800(this.currentState).intValue();
    }

    @Px
    public int getBadgeHorizontalPadding() {
        return State.access$1900(this.currentState).intValue();
    }

    public int getBadgeShapeAppearanceOverlayResId() {
        return State.access$1200(this.currentState).intValue();
    }

    public int getBadgeShapeAppearanceResId() {
        return State.access$1100(this.currentState).intValue();
    }

    @ColorInt
    public int getBadgeTextColor() {
        return State.access$1700(this.currentState).intValue();
    }

    @Px
    public int getBadgeVerticalPadding() {
        return State.access$2000(this.currentState).intValue();
    }

    public int getBadgeWithTextShapeAppearanceOverlayResId() {
        return State.access$1400(this.currentState).intValue();
    }

    public int getBadgeWithTextShapeAppearanceResId() {
        return State.access$1300(this.currentState).intValue();
    }

    @StringRes
    public int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return State.access$700(this.currentState);
    }

    public CharSequence getContentDescriptionForText() {
        return State.access$400(this.currentState);
    }

    public CharSequence getContentDescriptionNumberless() {
        return State.access$500(this.currentState);
    }

    @PluralsRes
    public int getContentDescriptionQuantityStrings() {
        return State.access$600(this.currentState);
    }

    @Dimension(unit = 1)
    public int getHorizontalOffsetWithText() {
        return State.access$2300(this.currentState).intValue();
    }

    @Dimension(unit = 1)
    public int getHorizontalOffsetWithoutText() {
        return State.access$2100(this.currentState).intValue();
    }

    @Dimension(unit = 1)
    public int getLargeFontVerticalOffsetAdjustment() {
        return State.access$2500(this.currentState).intValue();
    }

    public int getMaxCharacterCount() {
        return State.access$900(this.currentState);
    }

    public int getMaxNumber() {
        return State.access$1000(this.currentState);
    }

    public int getNumber() {
        return State.access$200(this.currentState);
    }

    public Locale getNumberLocale() {
        return State.access$2900(this.currentState);
    }

    public State getOverridingState() {
        return this.overridingState;
    }

    public String getText() {
        return State.access$300(this.currentState);
    }

    @StyleRes
    public int getTextAppearanceResId() {
        return State.access$1600(this.currentState).intValue();
    }

    @Dimension(unit = 1)
    public int getVerticalOffsetWithText() {
        return State.access$2400(this.currentState).intValue();
    }

    @Dimension(unit = 1)
    public int getVerticalOffsetWithoutText() {
        return State.access$2200(this.currentState).intValue();
    }

    public boolean hasNumber() {
        if (State.access$200(this.currentState) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasText() {
        if (State.access$300(this.currentState) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAutoAdjustedToGrandparentBounds() {
        return State.access$2800(this.currentState).booleanValue();
    }

    public boolean isVisible() {
        return State.access$800(this.currentState).booleanValue();
    }

    public void setAdditionalHorizontalOffset(@Dimension(unit = 1) int r5) {
        State.access$2602(this.overridingState, Integer.valueOf(r5));
        State.access$2602(this.currentState, Integer.valueOf(r5));
    }

    public void setAdditionalVerticalOffset(@Dimension(unit = 1) int r5) {
        State.access$2702(this.overridingState, Integer.valueOf(r5));
        State.access$2702(this.currentState, Integer.valueOf(r5));
    }

    public void setAlpha(int r5) {
        State.access$102(this.overridingState, r5);
        State.access$102(this.currentState, r5);
    }

    public void setAutoAdjustToGrandparentBounds(boolean r5) {
        State.access$2802(this.overridingState, Boolean.valueOf(r5));
        State.access$2802(this.currentState, Boolean.valueOf(r5));
    }

    public void setBackgroundColor(@ColorInt int r5) {
        State.access$1502(this.overridingState, Integer.valueOf(r5));
        State.access$1502(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeGravity(int r5) {
        State.access$1802(this.overridingState, Integer.valueOf(r5));
        State.access$1802(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeHorizontalPadding(@Px int r5) {
        State.access$1902(this.overridingState, Integer.valueOf(r5));
        State.access$1902(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeShapeAppearanceOverlayResId(int r5) {
        State.access$1202(this.overridingState, Integer.valueOf(r5));
        State.access$1202(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeShapeAppearanceResId(int r5) {
        State.access$1102(this.overridingState, Integer.valueOf(r5));
        State.access$1102(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeTextColor(@ColorInt int r5) {
        State.access$1702(this.overridingState, Integer.valueOf(r5));
        State.access$1702(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeVerticalPadding(@Px int r5) {
        State.access$2002(this.overridingState, Integer.valueOf(r5));
        State.access$2002(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeWithTextShapeAppearanceOverlayResId(int r5) {
        State.access$1402(this.overridingState, Integer.valueOf(r5));
        State.access$1402(this.currentState, Integer.valueOf(r5));
    }

    public void setBadgeWithTextShapeAppearanceResId(int r5) {
        State.access$1302(this.overridingState, Integer.valueOf(r5));
        State.access$1302(this.currentState, Integer.valueOf(r5));
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int r5) {
        State.access$702(this.overridingState, r5);
        State.access$702(this.currentState, r5);
    }

    public void setContentDescriptionForText(CharSequence r5) {
        State.access$402(this.overridingState, r5);
        State.access$402(this.currentState, r5);
    }

    public void setContentDescriptionNumberless(CharSequence r5) {
        State.access$502(this.overridingState, r5);
        State.access$502(this.currentState, r5);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int r5) {
        State.access$602(this.overridingState, r5);
        State.access$602(this.currentState, r5);
    }

    public void setHorizontalOffsetWithText(@Dimension(unit = 1) int r5) {
        State.access$2302(this.overridingState, Integer.valueOf(r5));
        State.access$2302(this.currentState, Integer.valueOf(r5));
    }

    public void setHorizontalOffsetWithoutText(@Dimension(unit = 1) int r5) {
        State.access$2102(this.overridingState, Integer.valueOf(r5));
        State.access$2102(this.currentState, Integer.valueOf(r5));
    }

    public void setLargeFontVerticalOffsetAdjustment(@Dimension(unit = 1) int r5) {
        State.access$2502(this.overridingState, Integer.valueOf(r5));
        State.access$2502(this.currentState, Integer.valueOf(r5));
    }

    public void setMaxCharacterCount(int r5) {
        State.access$902(this.overridingState, r5);
        State.access$902(this.currentState, r5);
    }

    public void setMaxNumber(int r5) {
        State.access$1002(this.overridingState, r5);
        State.access$1002(this.currentState, r5);
    }

    public void setNumber(int r5) {
        State.access$202(this.overridingState, r5);
        State.access$202(this.currentState, r5);
    }

    public void setNumberLocale(Locale r5) {
        State.access$2902(this.overridingState, r5);
        State.access$2902(this.currentState, r5);
    }

    public void setText(String r5) {
        State.access$302(this.overridingState, r5);
        State.access$302(this.currentState, r5);
    }

    public void setTextAppearanceResId(@StyleRes int r5) {
        State.access$1602(this.overridingState, Integer.valueOf(r5));
        State.access$1602(this.currentState, Integer.valueOf(r5));
    }

    public void setVerticalOffsetWithText(@Dimension(unit = 1) int r5) {
        State.access$2402(this.overridingState, Integer.valueOf(r5));
        State.access$2402(this.currentState, Integer.valueOf(r5));
    }

    public void setVerticalOffsetWithoutText(@Dimension(unit = 1) int r5) {
        State.access$2202(this.overridingState, Integer.valueOf(r5));
        State.access$2202(this.currentState, Integer.valueOf(r5));
    }

    public void setVisible(boolean r5) {
        State.access$802(this.overridingState, Boolean.valueOf(r5));
        State.access$802(this.currentState, Boolean.valueOf(r5));
    }
}
