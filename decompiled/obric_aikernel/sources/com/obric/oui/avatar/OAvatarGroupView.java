package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/avatar/OAvatar;", "avatar", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "borderWidth", "", "configAvatar", "getTopAvatar", "getUnderAvatar", "setAvatarGroupSize", "underAvatar", "Lcom/obric/oui/avatar/OAvatar;", "topAvatar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OAvatarGroupView extends ConstraintLayout {
    private final OAvatar topAvatar;
    private final OAvatar underAvatar;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OAvatarGroupView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OAvatarGroupView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_widget_avatar_group, this);
        View r12 = findViewById(f.under_avatar);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.under_avatar)");
        this.underAvatar = (OAvatar) r12;
        View r13 = findViewById(f.top_avatar);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.top_avatar)");
        this.topAvatar = (OAvatar) r13;
    }

    public /* synthetic */ OAvatarGroupView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final void configAvatar(OAvatar r10, OAvatar.AvatarSize r11, int r12) {
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L7;
        int r14 = r12 * 2;
        float r15 = r11.getDpValue();
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r13.width = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r16.getDisplayMetrics())) + r14;
        float r17 = r11.getDpValue();
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        r13.height = r14 + MathKt.roundToInt(TypedValue.applyDimension(1, r17, r18.getDisplayMetrics()));
        r10.setLayoutParams(r13);
        r10.setAvatarInset(r12);
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final OAvatar getTopAvatar() {
        return this.topAvatar;
    }

    public final OAvatar getUnderAvatar() {
        return this.underAvatar;
    }

    public final void setAvatarGroupSize(OAvatar.AvatarSize r10) {
        Intrinsics.checkNotNullParameter(r10, "size");
        switch(b.f6216a[r10.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        OAvatar.AvatarSize r11 = OAvatar.AvatarSize.DP_48;
    L13:
        if (r10.getDpValue() < OAvatar.AvatarSize.DP_56.getDpValue()) goto L15;
        int r12 = 3;
    L16:
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));
        configAvatar(this.topAvatar, r11, r14);
        configAvatar(this.underAvatar, r11, r14);
        ViewGroup.LayoutParams r15 = getLayoutParams();
        if (r15 == null) goto L21;
        float r16 = r10.getDpValue();
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r15.height = MathKt.roundToInt(TypedValue.applyDimension(1, r16, r17.getDisplayMetrics()));
        float r18 = r10.getDpValue();
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        r15.width = MathKt.roundToInt(TypedValue.applyDimension(1, r18, r19.getDisplayMetrics()));
        setLayoutParams(r15);
        return;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L15:
        r12 = 2;
        goto L16
    L7:
        r11 = OAvatar.AvatarSize.DP_40;
        goto L13
    L8:
        r11 = OAvatar.AvatarSize.DP_32;
        goto L13
    L9:
        r11 = OAvatar.AvatarSize.DP_24;
        goto L13
    L10:
        r11 = OAvatar.AvatarSize.DP_20;
        goto L13
    L11:
        r11 = OAvatar.AvatarSize.DP_16;
        goto L13
    L5:
        throw new IllegalArgumentException("disallow the size: " + r10);
    }
}
