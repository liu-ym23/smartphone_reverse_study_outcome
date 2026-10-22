package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002/0B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#J\u0010\u0010!\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bJ\u001a\u0010*\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u001a\u0010*\u001a\u00020\u00152\b\b\u0001\u0010&\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010+\u001a\u00020\u00152\b\b\u0001\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarSize", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "iconBorderColor", "", "iconType", "Lcom/obric/oui/avatar/OAvatar$IconType;", "ivAvatar", "Lcom/obric/oui/avatar/OCircleImageView;", "ivBg", "Landroidx/appcompat/widget/AppCompatImageView;", "ivIcon", "spacer", "Landroid/widget/Space;", "applyIconSizeInternal", "", "spaceHorizontalMargin", "spaceVerticalMargin", "borderWidth", "contentSize", "applyLogoIconSize", "size", "applyOnlineIconSize", "getBackgroundImageView", "getContentImageView", "getLogoImageView", "hideIcon", "setAvatar", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "setAvatarInset", "inset", "setAvatarSize", "setIcon", "setIconBorderColor", TypedValues.Custom.S_COLOR, "setIconType", "showIcon", "AvatarSize", "IconType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatar extends ConstraintLayout {
    private AvatarSize avatarSize;
    private int iconBorderColor;
    private IconType iconType;
    private final OCircleImageView ivAvatar;
    private final AppCompatImageView ivBg;
    private final OCircleImageView ivIcon;
    private final Space spacer;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "", "dpValue", "", "(Ljava/lang/String;II)V", "getDpValue", "()I", "DP_16", "DP_20", "DP_24", "DP_32", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

        private static final /* synthetic */ AvatarSize[] $values() {
            return new AvatarSize[]{DP_16, DP_20, DP_24, DP_32, DP_40, DP_48, DP_56, DP_64, DP_72};
        }

        static {
            DP_16 = new AvatarSize("DP_16", 0, 16);
            DP_20 = new AvatarSize("DP_20", 1, 20);
            DP_24 = new AvatarSize("DP_24", 2, 24);
            DP_32 = new AvatarSize("DP_32", 3, 32);
            DP_40 = new AvatarSize("DP_40", 4, 40);
            DP_48 = new AvatarSize("DP_48", 5, 48);
            DP_56 = new AvatarSize("DP_56", 6, 56);
            DP_64 = new AvatarSize("DP_64", 7, 64);
            DP_72 = new AvatarSize("DP_72", 8, 72);
            $VALUES = $values();
        }

        private AvatarSize(String r1, int r2, int r3) {
            super(r1, r2);
            this.dpValue = r3;
        }

        public static AvatarSize valueOf(String r2) {
            return (AvatarSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(AvatarSize.class, r2), AvatarSize.class, "com.obric.memorydata.plugin");
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AvatarSize[].class, "com.obric.memorydata.plugin");
        }

        public final int getDpValue() {
            return this.dpValue;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$IconType;", "", "(Ljava/lang/String;I)V", "ONLINE", "LOGO", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum IconType extends Enum<IconType> {
        private static final /* synthetic */ IconType[] $VALUES = null;
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        private static final /* synthetic */ IconType[] $values() {
            return new IconType[]{ONLINE, LOGO};
        }

        static {
            ONLINE = new IconType("ONLINE", 0);
            LOGO = new IconType("LOGO", 1);
            $VALUES = $values();
        }

        private IconType(String r1, int r2) {
            super(r1, r2);
        }

        public static IconType valueOf(String r2) {
            return (IconType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IconType.class, r2), IconType.class, "com.obric.memorydata.plugin");
        }

        public static IconType[] values() {
            return (IconType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IconType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13308a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13309b = null;

        static {
            int[] r0 = new int[AvatarSize.values().length];
            r0[AvatarSize.DP_24.ordinal()] = 1;
            r0[AvatarSize.DP_32.ordinal()] = 2;
            r0[AvatarSize.DP_40.ordinal()] = 3;
            r0[AvatarSize.DP_48.ordinal()] = 4;
            r0[AvatarSize.DP_56.ordinal()] = 5;
            r0[AvatarSize.DP_64.ordinal()] = 6;
            r0[AvatarSize.DP_72.ordinal()] = 7;
            f13308a = r0;
            int[] r1 = new int[IconType.values().length];
            r1[IconType.LOGO.ordinal()] = 1;
            r1[IconType.ONLINE.ordinal()] = 2;
            f13309b = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAvatar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OAvatar(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        this.avatarSize = AvatarSize.DP_24;
        this.iconType = IconType.LOGO;
        this.iconBorderColor = -1;
        ConstraintLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_widget_avatar, "layout", "o_widget_avatar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_avatar, OaidModel.KEY_ID, "iv_avatar"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.iv_avatar)");
        OCircleImageView r10 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r9, OCircleImageView.class, "com.obric.memorydata.plugin");
        this.ivAvatar = r10;
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.iv_icon)");
        this.ivIcon = (OCircleImageView) ZeusTransformUtils.preCheckCast(r2, OCircleImageView.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_bg, OaidModel.KEY_ID, "iv_bg"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.iv_bg)");
        this.ivBg = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r3, AppCompatImageView.class, "com.obric.memorydata.plugin");
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.spacer, OaidModel.KEY_ID, "spacer"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.spacer)");
        this.spacer = (Space) ZeusTransformUtils.preCheckCast(r0, Space.class, "com.obric.memorydata.plugin");
        setClipChildren(false);
        r10.setBorderWidth(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1));
        r10.setBorderColor(ContextCompat.getColor(r7, ZeusTransformUtils.mapRes(R.color.LineReverse2, TypedValues.Custom.S_COLOR, "LineReverse2")));
    }

    public /* synthetic */ OAvatar(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final void applyIconSizeInternal(int r6, int r7, int r8, int r9) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.spacer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r4.rightMargin = r6;
        r4.bottomMargin = r7;
        r0.setLayoutParams(r2);
        setAvatarInset(1);
        this.ivIcon.setContentPadding(0);
        this.ivIcon.setBorderWidth(r8);
        this.ivIcon.setBorderColor(this.iconBorderColor);
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r11 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        int r13 = r9 + (r8 * 2);
        r12.width = r13;
        r12.height = r13;
        r5.setLayoutParams(r11);
    }

    private final void applyLogoIconSize(AvatarSize r12) {
        float r0 = 20.0f;
        float r3 = 1.0f;
        float r6 = 0.0f;
        switch(a.f13308a[r12.ordinal()]) {
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
        float r13 = 0.0f;
        r0 = 0.0f;
        r3 = 0.0f;
    L13:
        applyIconSizeInternal(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r6), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r13), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r0));
        return;
    L5:
        float r14 = (2 * 2.0f) + 20.0f;
        float r7 = r14 - 2.0f;
        float r15 = r14 - 4.0f;
    L7:
        r3 = 2.0f;
    L12:
        float r10 = r7;
        r6 = r15;
        r13 = r10;
        goto L13
    L6:
        float r16 = (2 * 2.0f) + 16.0f;
        r7 = r16 - 2.0f;
        r15 = r16 - 4.0f;
        r0 = 16.0f;
        goto L7
    L8:
        float r17 = (2 * 1.5f) + 16.0f;
        r7 = r17 - 1.5f;
        r15 = r17 - 3.5f;
        r0 = 16.0f;
    L10:
        r3 = 1.5f;
        goto L12
    L9:
        float r18 = (2 * 1.5f) + 12.0f;
        r7 = r18 - 1.5f;
        r15 = r18 - 3.5f;
        r0 = 12.0f;
        goto L10
    L11:
        r0 = 10.0f;
        float r19 = (2 * 1.0f) + 10.0f;
        r7 = r19 - 1.0f;
        r15 = r19 - 3.0f;
        goto L12
    }

    private final void applyOnlineIconSize(AvatarSize r10) {
        float r0 = 12.0f;
        float r3 = 1.5f;
        float r5 = 0.0f;
        switch(a.f13308a[r10.ordinal()]) {
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
        r0 = 0.0f;
        r3 = 0.0f;
    L13:
        applyIconSizeInternal(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r0));
        return;
    L5:
        r5 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L8:
        r3 = 2.0f;
        goto L13
    L6:
        r5 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L8
    L7:
        r5 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r0 = 10.0f;
        goto L8
    L9:
        r5 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L11:
        r0 = 8.0f;
        goto L13
    L10:
        r5 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L11
    L12:
        r0 = 6.0f;
        r5 = ((2 * 1.0f) + 6.0f) - 1;
        r3 = 1.0f;
        goto L13
    }

    public static /* synthetic */ void setIcon$default(OAvatar r0, int r1, IconType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = IconType.LOGO;
    L5:
        r0.setIcon(r1, r2);
    }

    public static /* synthetic */ void setIcon$default(OAvatar r0, Drawable r1, IconType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = IconType.LOGO;
    L5:
        r0.setIcon(r1, r2);
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
        o.b((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.memorydata.plugin"));
    }

    public final void setAvatar(int r1) {
        this.ivAvatar.setImageResource(r1);
    }

    public final void setAvatar(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        this.ivAvatar.setImageBitmap(r2);
    }

    public final void setAvatar(Drawable r1) {
        this.ivAvatar.setImageDrawable(r1);
    }

    public final void setAvatarInset(int r5) {
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.ivAvatar, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMargins(r5, r5, r5, r5);
        r4.setLayoutParams(r1);
    }

    public final void setAvatarSize(AvatarSize r6) {
        Intrinsics.checkNotNullParameter(r6, "size");
        this.avatarSize = r6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r2.width = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r6.getDpValue());
        r2.height = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r6.getDpValue());
        r0.setLayoutParams(r2);
        if (this.ivIcon.isShown() == true) goto L5;
        return;
    L5:
        if (this.ivIcon.getDrawable() != null) goto L7;
        return;
    L7:
        if (this.iconType != IconType.ONLINE) goto L10;
        applyOnlineIconSize(r6);
        return;
    L10:
        if (this.iconType != IconType.LOGO) goto L16;
        applyLogoIconSize(r6);
        return;
    }

    public final void setIcon(int r4, IconType r5) {
        Intrinsics.checkNotNullParameter(r5, "iconType");
        setIcon(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4), r5);
    }

    public final void setIcon(Drawable r4, IconType r5) {
        Intrinsics.checkNotNullParameter(r5, "iconType");
        if (r4 != null) goto L6;
        o.b((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (getParent() != null) goto L8;
    L10:
        this.iconType = r5;
        this.ivIcon.setImageDrawable(r4);
        o.a((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.memorydata.plugin"));
        int r6 = a.f13309b[r5.ordinal()];
        if (r6 != 1) goto L13;
        applyLogoIconSize(this.avatarSize);
        return;
    L13:
        if (r6 != 2) goto L20;
        applyOnlineIconSize(this.avatarSize);
        return;
    L20:
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L10;
        ViewParent r1 = getParent();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin")).setClipChildren(false);
        goto L10
    }

    public final void setIconBorderColor(int r1) {
        this.iconBorderColor = r1;
    }

    public final void setIconType(IconType r2) {
        Intrinsics.checkNotNullParameter(r2, "iconType");
        this.iconType = r2;
    }

    public final void showIcon() {
        o.a((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.memorydata.plugin"));
    }
}
