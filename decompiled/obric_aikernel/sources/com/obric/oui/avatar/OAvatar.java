package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.k;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000267B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\u001eR\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "applyOnlineIconSize", "applyLogoIconSize", "", "spaceHorizontalMargin", "spaceVerticalMargin", "borderWidth", "contentSize", "applyIconSizeInternal", "setAvatarSize", "inset", "setAvatarInset", TypedValues.Custom.S_COLOR, "setIconBorderColor", "Landroid/graphics/Bitmap;", "bitmap", "setAvatar", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "Lcom/obric/oui/avatar/OAvatar$IconType;", "iconType", "setIconType", "setIcon", "hideIcon", "showIcon", "Lcom/obric/oui/avatar/OCircleImageView;", "getContentImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackgroundImageView", "getLogoImageView", "Lcom/obric/oui/avatar/OAvatar$IconType;", "Landroid/widget/Space;", "spacer", "Landroid/widget/Space;", "avatarSize", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "ivBg", "Landroidx/appcompat/widget/AppCompatImageView;", "ivAvatar", "Lcom/obric/oui/avatar/OCircleImageView;", "ivIcon", "iconBorderColor", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AvatarSize", "IconType", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OAvatar extends ConstraintLayout {
    private AvatarSize avatarSize;
    private int iconBorderColor;
    private IconType iconType;
    private final OCircleImageView ivAvatar;
    private final AppCompatImageView ivBg;
    private final OCircleImageView ivIcon;
    private final Space spacer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "", "", "dpValue", "I", "getDpValue", "()I", "<init>", "(Ljava/lang/String;II)V", "DP_16", "DP_20", "DP_24", "DP_32", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AvatarSize extends Enum<AvatarSize> {
        private static final /* synthetic */ AvatarSize[] $VALUES = null;
        public static final AvatarSize DP_16 = null;
        public static final AvatarSize DP_20 = null;
        public static final AvatarSize DP_24 = null;
        public static final AvatarSize DP_32 = null;
        public static final AvatarSize DP_40 = null;
        public static final AvatarSize DP_48 = null;
        public static final AvatarSize DP_56 = null;
        public static final AvatarSize DP_64 = null;
        public static final AvatarSize DP_72 = null;
        private final int dpValue;

        static {
            AvatarSize r10 = new AvatarSize("DP_16", 0, 16);
            DP_16 = r10;
            AvatarSize r11 = new AvatarSize("DP_20", 1, 20);
            DP_20 = r11;
            AvatarSize r12 = new AvatarSize("DP_24", 2, 24);
            DP_24 = r12;
            AvatarSize r13 = new AvatarSize("DP_32", 3, 32);
            DP_32 = r13;
            AvatarSize r14 = new AvatarSize("DP_40", 4, 40);
            DP_40 = r14;
            AvatarSize r15 = new AvatarSize("DP_48", 5, 48);
            DP_48 = r15;
            AvatarSize r16 = new AvatarSize("DP_56", 6, 56);
            DP_56 = r16;
            AvatarSize r17 = new AvatarSize("DP_64", 7, 64);
            DP_64 = r17;
            AvatarSize r18 = new AvatarSize("DP_72", 8, 72);
            DP_72 = r18;
            $VALUES = new AvatarSize[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private AvatarSize(String r10, int r11, int r12) {
            super(r10, r11);
            this.dpValue = r12;
        }

        public static AvatarSize valueOf(String r10) {
            return (AvatarSize) Enum.valueOf(AvatarSize.class, r10);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) $VALUES.clone();
        }

        public final int getDpValue() {
            return this.dpValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$IconType;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE", "LOGO", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum IconType extends Enum<IconType> {
        private static final /* synthetic */ IconType[] $VALUES = null;
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        static {
            IconType r10 = new IconType("ONLINE", 0);
            ONLINE = r10;
            IconType r11 = new IconType("LOGO", 1);
            LOGO = r11;
            $VALUES = new IconType[]{r10, r11};
        }

        private IconType(String r10, int r11) {
            super(r10, r11);
        }

        public static IconType valueOf(String r10) {
            return (IconType) Enum.valueOf(IconType.class, r10);
        }

        public static IconType[] values() {
            return (IconType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OAvatar(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OAvatar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.avatarSize = AvatarSize.DP_24;
        this.iconType = IconType.LOGO;
        this.iconBorderColor = -1;
        ViewGroup.inflate(r10, h.o_widget_avatar, this);
        View r12 = findViewById(f.iv_avatar);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.iv_avatar)");
        OCircleImageView r13 = (OCircleImageView) r12;
        this.ivAvatar = r13;
        View r14 = findViewById(f.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.iv_icon)");
        this.ivIcon = (OCircleImageView) r14;
        View r15 = findViewById(f.iv_bg);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.iv_bg)");
        this.ivBg = (AppCompatImageView) r15;
        View r16 = findViewById(f.spacer);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.spacer)");
        this.spacer = (Space) r16;
        setClipChildren(false);
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r13.setBorderWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 1, r17.getDisplayMetrics())));
        r13.setBorderColor(ContextCompat.getColor(r10, u8.c.LineReverse2));
    }

    public /* synthetic */ OAvatar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final void applyIconSizeInternal(int r10, int r11, int r12, int r13) {
        Space r14 = this.spacer;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).rightMargin = r10;
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = r11;
        r14.setLayoutParams(r16);
        setAvatarInset(1);
        this.ivIcon.setContentPadding(0);
        this.ivIcon.setBorderWidth(r12);
        this.ivIcon.setBorderColor(this.iconBorderColor);
        OCircleImageView r17 = this.ivIcon;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        int r20 = r13 + (r12 * 2);
        ((ViewGroup.MarginLayoutParams) r19).width = r20;
        ((ViewGroup.MarginLayoutParams) r19).height = r20;
        r17.setLayoutParams(r19);
    }

    private final void applyLogoIconSize(AvatarSize r12) {
        float r10 = 20.0f;
        float r11 = 1.0f;
        float r13 = 0.0f;
        switch(a.f6214b[r12.ordinal()]) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        float r14 = 0.0f;
        r10 = 0.0f;
        r11 = 0.0f;
    L13:
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r15.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        int r18 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r17.getDisplayMetrics()));
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        int r20 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r19.getDisplayMetrics()));
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        applyIconSizeInternal(r16, r18, r20, MathKt.roundToInt(TypedValue.applyDimension(1, r10, r21.getDisplayMetrics())));
        return;
    L5:
        float r110 = (2 * 2.0f) + 20.0f;
        float r22 = r110 - 2.0f;
        float r111 = r110 - 4.0f;
    L7:
        r11 = 2.0f;
    L12:
        float r112 = r22;
        r13 = r111;
        r14 = r112;
        goto L13
    L6:
        float r113 = (2 * 2.0f) + 16.0f;
        r22 = r113 - 2.0f;
        r111 = r113 - 4.0f;
        r10 = 16.0f;
        goto L7
    L8:
        float r114 = (2 * 1.5f) + 16.0f;
        r22 = r114 - 1.5f;
        r111 = r114 - 3.5f;
        r10 = 16.0f;
    L10:
        r11 = 1.5f;
        goto L12
    L9:
        float r115 = (2 * 1.5f) + 12.0f;
        r22 = r115 - 1.5f;
        r111 = r115 - 3.5f;
        r10 = 12.0f;
        goto L10
    L11:
        r10 = 10.0f;
        float r116 = (2 * 1.0f) + 10.0f;
        r22 = r116 - 1.0f;
        r111 = r116 - 3.0f;
        goto L12
    }

    private final void applyOnlineIconSize(AvatarSize r11) {
        float r10 = 12.0f;
        float r12 = 1.5f;
        float r13 = 0.0f;
        switch(a.f6213a[r11.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        r10 = 0.0f;
        r12 = 0.0f;
    L13:
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        int r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r14.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        int r17 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r16.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        int r19 = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r18.getDisplayMetrics()));
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        applyIconSizeInternal(r15, r17, r19, MathKt.roundToInt(TypedValue.applyDimension(1, r10, r20.getDisplayMetrics())));
        return;
    L5:
        r13 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L8:
        r12 = 2.0f;
        goto L13
    L6:
        r13 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L8
    L7:
        r13 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r10 = 10.0f;
        goto L8
    L9:
        r13 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L11:
        r10 = 8.0f;
        goto L13
    L10:
        r13 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L11
    L12:
        r10 = 6.0f;
        r13 = ((2 * 1.0f) + 6.0f) - 1;
        r12 = 1.0f;
        goto L13
    }

    public static /* synthetic */ void setIcon$default(OAvatar r10, int r11, IconType r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = IconType.LOGO;
    L5:
        r10.setIcon(r11, r12);
    }

    public static /* synthetic */ void setIcon$default(OAvatar r10, Drawable r11, IconType r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = IconType.LOGO;
    L5:
        r10.setIcon(r11, r12);
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.ivBg;
    }

    public final OCircleImageView getContentImageView() {
        return this.ivAvatar;
    }

    public final OCircleImageView getLogoImageView() {
        return this.ivIcon;
    }

    public final void hideIcon() {
        k.f(this.ivIcon);
    }

    public final void setAvatar(int r10) {
        this.ivAvatar.setImageResource(r10);
    }

    public final void setAvatar(Bitmap r10) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        this.ivAvatar.setImageBitmap(r10);
    }

    public final void setAvatar(Drawable r10) {
        this.ivAvatar.setImageDrawable(r10);
    }

    public final void setAvatarInset(int r10) {
        OCircleImageView r11 = this.ivAvatar;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        r13.setMargins(r10, r10, r10, r10);
        r11.setLayoutParams(r13);
    }

    public final void setAvatarSize(AvatarSize r10) {
        Intrinsics.checkNotNullParameter(r10, "size");
        this.avatarSize = r10;
        ViewGroup.LayoutParams r11 = getLayoutParams();
        if (r11 == null) goto L16;
        float r12 = r10.getDpValue();
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r11.width = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));
        float r14 = r10.getDpValue();
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        r11.height = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        setLayoutParams(r11);
        if (this.ivIcon.isShown() == true) goto L7;
        return;
    L7:
        if (this.ivIcon.getDrawable() == null) goto L18;
        IconType r16 = this.iconType;
        if (r16 != IconType.ONLINE) goto L12;
        applyOnlineIconSize(r10);
        return;
    L12:
        if (r16 != IconType.LOGO) goto L20;
        applyLogoIconSize(r10);
        return;
    L20:
        return;
    L18:
        return;
    L16:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIcon(@DrawableRes int r10, IconType r11) {
        Intrinsics.checkNotNullParameter(r11, "iconType");
        setIcon(ContextCompat.getDrawable(getContext(), r10), r11);
    }

    public final void setIcon(Drawable r10, IconType r11) {
        Intrinsics.checkNotNullParameter(r11, "iconType");
        if (r10 != null) goto L6;
        k.f(this.ivIcon);
        return;
    L6:
        if (getParent() != null) goto L8;
    L10:
        this.iconType = r11;
        this.ivIcon.setImageDrawable(r10);
        k.h(this.ivIcon);
        int r12 = a.f6215c[r11.ordinal()];
        if (r12 != 1) goto L13;
        applyLogoIconSize(this.avatarSize);
        return;
    L13:
        if (r12 != 2) goto L20;
        applyOnlineIconSize(this.avatarSize);
        return;
    L20:
        return;
    L8:
        if ((getParent() instanceof ViewGroup) == false) goto L10;
        ViewParent r13 = getParent();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r13).setClipChildren(false);
        goto L10
    }

    public final void setIconBorderColor(@ColorInt int r10) {
        this.iconBorderColor = r10;
    }

    public final void setIconType(IconType r10) {
        Intrinsics.checkNotNullParameter(r10, "iconType");
        this.iconType = r10;
    }

    public final void showIcon() {
        k.h(this.ivIcon);
    }
}
