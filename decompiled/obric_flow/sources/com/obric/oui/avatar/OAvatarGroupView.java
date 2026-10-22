package com.obric.oui.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import vq.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/avatar/OAvatar;", "getTopAvatar", "()Lcom/obric/oui/avatar/OAvatar;", "getUnderAvatar", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "setAvatarGroupSize", "(Lcom/obric/oui/avatar/OAvatar$AvatarSize;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarGroupView extends ConstraintLayout {
    public final OAvatar g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OAvatar f11954h;

    @JvmOverloads
    public OAvatarGroupView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final void e(OAvatar r5, OAvatar.AvatarSize r10, int r11) {
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        if (r12 == null) goto L7;
        int r13 = r11 * 2;
        r12.width = a.B(r10.getDpValue(), this) + r13;
        r12.height = a.B(r10.getDpValue(), this) + r13;
        r5.setLayoutParams(r12);
        r5.setAvatarInset(r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final OAvatar getTopAvatar() {
        return this.f11954h;
    }

    public final OAvatar getUnderAvatar() {
        return this.g;
    }

    public final void setAvatarGroupSize(OAvatar.AvatarSize r5) {
        Intrinsics.checkNotNullParameter(r5, "size");
        switch(b.f22650a[r5.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        OAvatar.AvatarSize r10 = OAvatar.AvatarSize.DP_48;
    L14:
        if (r5.getDpValue() < OAvatar.AvatarSize.DP_56.getDpValue()) goto L17;
        int r11 = 3;
    L16:
        int r12 = a.B(r11, this);
        e(this.f11954h, r10, r12);
        e(this.g, r10, r12);
        ViewGroup.LayoutParams r13 = getLayoutParams();
        if (r13 == null) goto L23;
        r13.height = a.B(r5.getDpValue(), this);
        r13.width = a.B(r5.getDpValue(), this);
        setLayoutParams(r13);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        r11 = 2;
        goto L16
    L7:
        r10 = OAvatar.AvatarSize.DP_40;
        goto L14
    L8:
        r10 = OAvatar.AvatarSize.DP_40;
        goto L14
    L9:
        r10 = OAvatar.AvatarSize.DP_32;
        goto L14
    L10:
        r10 = OAvatar.AvatarSize.DP_24;
        goto L14
    L11:
        r10 = OAvatar.AvatarSize.DP_20;
        goto L14
    L12:
        r10 = OAvatar.AvatarSize.DP_16;
        goto L14
    L5:
        throw new IllegalArgumentException(Intrinsics.stringPlus("disallow the size: ", r5));
    }

    @JvmOverloads
    public OAvatarGroupView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        View.inflate(r5, R$layout.o_widget_avatar_group, this);
        this.g = (OAvatar) findViewById(R$id.under_avatar);
        this.f11954h = (OAvatar) findViewById(R$id.top_avatar);
    }
}
