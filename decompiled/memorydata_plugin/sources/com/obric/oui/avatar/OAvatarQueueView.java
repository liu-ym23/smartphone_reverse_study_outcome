package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "configAvatarSize", "", "size", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", CommonConsts.COUNT_TYPE, "", "getAvatars", "", "Lcom/obric/oui/avatar/OAvatar;", "setAvatars", "drawables", "Landroid/graphics/drawable/Drawable;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueView extends ConstraintLayout {
    /* JADX WARN: Multi-variable type inference failed */
    public OAvatarQueueView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OAvatarQueueView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_widget_avatar_queue, "layout", "o_widget_avatar_queue"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ OAvatarQueueView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final void configAvatarSize(OAvatar.AvatarSize r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "size");
        Iterator<View> r0 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        int r3 = 0;
        if (r0.hasNext() == false) goto L12;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin");
        OAvatar r4 = (OAvatar) ZeusTransformUtils.preCheckCast(r2, OAvatar.class, "com.obric.memorydata.plugin");
        r4.setAvatarSize(r14);
        if (r14.getDpValue() < OAvatar.AvatarSize.DP_40.getDpValue()) goto L8;
        int r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 3);
    L9:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int r10 = r5 * 2;
        r9.width = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r14.getDpValue()) + r10;
        r9.height = r10 + h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r14.getDpValue());
        r6.setLayoutParams(r9);
        r4.setAvatarInset(r5);
        r4.getContentImageView().setContentPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0));
        if (Intrinsics.areEqual(r2, SequencesKt.first(ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin")))) == true) goto L3;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r11 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMargins(0, 0, (h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r14.getDpValue()) / 3) * 2, 0);
        r7.setLayoutParams(r11);
        goto L3
    L8:
        r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2);
        goto L9
    L12:
        int r16 = getChildCount();
    L13:
        if (r3 >= r16) goto L19;
        int r1 = r3 + 1;
        View r12 = getChildAt(r3);
        Intrinsics.checkNotNullExpressionValue(r12, "getChildAt(index)");
        if (r3 < r15) goto L17;
        o.b(r12);
    L18:
        r3 = r1;
        goto L13
    L17:
        o.a(r12);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<OAvatar> getAvatars() {
        List<OAvatar> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<View> r4 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, OAvatar.class) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final void setAvatars(List<? extends Drawable> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "drawables");
        int r0 = 0;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.subList(0, 5), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r8.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Drawable r4 = (Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.memorydata.plugin");
        View r1 = getChildAt(r0);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
        ((OAvatar) ZeusTransformUtils.preCheckCast(r1, OAvatar.class, "com.obric.memorydata.plugin")).getContentImageView().setImageDrawable(r4);
        r0 = r3;
        goto L4
    }
}
