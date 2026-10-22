package com.obric.oui.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "topAvatar", "Lcom/obric/oui/avatar/OAvatar;", "underAvatar", "configAvatar", "", "avatar", "size", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "borderWidth", "", "getTopAvatar", "getUnderAvatar", "setAvatarGroupSize", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarGroupView extends ConstraintLayout {
    private final OAvatar topAvatar;
    private final OAvatar underAvatar;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13310a = null;

        static {
            int[] r0 = new int[OAvatar.AvatarSize.values().length];
            r0[OAvatar.AvatarSize.DP_24.ordinal()] = 1;
            r0[OAvatar.AvatarSize.DP_32.ordinal()] = 2;
            r0[OAvatar.AvatarSize.DP_40.ordinal()] = 3;
            r0[OAvatar.AvatarSize.DP_48.ordinal()] = 4;
            r0[OAvatar.AvatarSize.DP_56.ordinal()] = 5;
            r0[OAvatar.AvatarSize.DP_64.ordinal()] = 6;
            r0[OAvatar.AvatarSize.DP_72.ordinal()] = 7;
            f13310a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAvatarGroupView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OAvatarGroupView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_widget_avatar_group, "layout", "o_widget_avatar_group"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.under_avatar, OaidModel.KEY_ID, "under_avatar"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.under_avatar)");
        this.underAvatar = (OAvatar) ZeusTransformUtils.preCheckCast(r8, OAvatar.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.top_avatar, OaidModel.KEY_ID, "top_avatar"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.top_avatar)");
        this.topAvatar = (OAvatar) ZeusTransformUtils.preCheckCast(r9, OAvatar.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OAvatarGroupView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final void configAvatar(OAvatar r7, OAvatar.AvatarSize r8, int r9) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int r3 = r9 * 2;
        r2.width = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r8.getDpValue()) + r3;
        r2.height = r3 + h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r8.getDpValue());
        r0.setLayoutParams(r2);
        r7.setAvatarInset(r9);
    }

    public final OAvatar getTopAvatar() {
        return this.topAvatar;
    }

    public final OAvatar getUnderAvatar() {
        return this.underAvatar;
    }

    public final void setAvatarGroupSize(OAvatar.AvatarSize r6) {
        Intrinsics.checkNotNullParameter(r6, "size");
        switch(a.f13310a[r6.ordinal()]) {
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
        OAvatar.AvatarSize r0 = OAvatar.AvatarSize.DP_48;
    L13:
        if (r6.getDpValue() < OAvatar.AvatarSize.DP_56.getDpValue()) goto L15;
        View r1 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r2 = 3;
    L16:
        int r3 = h.a(r1, r2);
        configAvatar(this.topAvatar, r0, r3);
        configAvatar(this.underAvatar, r0, r3);
        View r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r5.height = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r6.getDpValue());
        r5.width = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r6.getDpValue());
        r4.setLayoutParams(r5);
        return;
    L15:
        r1 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r2 = 2;
        goto L16
    L7:
        r0 = OAvatar.AvatarSize.DP_40;
        goto L13
    L8:
        r0 = OAvatar.AvatarSize.DP_32;
        goto L13
    L9:
        r0 = OAvatar.AvatarSize.DP_24;
        goto L13
    L10:
        r0 = OAvatar.AvatarSize.DP_20;
        goto L13
    L11:
        r0 = OAvatar.AvatarSize.DP_16;
        goto L13
    L5:
        throw new IllegalArgumentException(Intrinsics.stringPlus("disallow the size: ", r6));
    }
}
