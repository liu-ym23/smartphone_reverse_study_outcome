package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.common.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/obric/oui/avatar/OAvatar;", "getAvatars", "Landroid/graphics/drawable/Drawable;", "drawables", "", "setAvatars", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", CommonConsts.COUNT_TYPE, "configAvatarSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OAvatarQueueView extends ConstraintLayout {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OAvatarQueueView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OAvatarQueueView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_widget_avatar_queue, this);
    }

    public /* synthetic */ OAvatarQueueView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void configAvatarSize(OAvatar.AvatarSize r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "size");
        Iterator<View> r10 = ViewGroupKt.getChildren(this).iterator();
    L3:
        int r11 = 0;
        if (r10.hasNext() == false) goto L16;
        View r12 = r10.next();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
        OAvatar r13 = (OAvatar) r12;
        r13.setAvatarSize(r14);
        if (r14.getDpValue() < OAvatar.AvatarSize.DP_40.getDpValue()) goto L8;
        float r16 = 3;
    L9:
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        int r18 = MathKt.roundToInt(TypedValue.applyDimension(1, r16, r17.getDisplayMetrics()));
        ViewGroup.LayoutParams r19 = r13.getLayoutParams();
        if (r19 == null) goto L15;
        int r110 = r18 * 2;
        float r111 = r14.getDpValue();
        Resources r112 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r112, "Resources.getSystem()");
        r19.width = MathKt.roundToInt(TypedValue.applyDimension(1, r111, r112.getDisplayMetrics())) + r110;
        float r113 = r14.getDpValue();
        Resources r114 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
        r19.height = r110 + MathKt.roundToInt(TypedValue.applyDimension(1, r113, r114.getDisplayMetrics()));
        r13.setLayoutParams(r19);
        r13.setAvatarInset(r18);
        OCircleImageView r20 = r13.getContentImageView();
        Resources r115 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r115, "Resources.getSystem()");
        r20.setContentPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 0, r115.getDisplayMetrics())));
        if ((!Intrinsics.areEqual(r12, (View) SequencesKt.first(ViewGroupKt.getChildren(this)))) == false) goto L3;
        ViewGroup.LayoutParams r21 = r13.getLayoutParams();
        Objects.requireNonNull(r21, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        float r23 = r14.getDpValue();
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        r22.setMargins(0, 0, (MathKt.roundToInt(TypedValue.applyDimension(1, r23, r24.getDisplayMetrics())) / 3) * 2, 0);
        r13.setLayoutParams(r22);
        goto L3
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r16 = 2;
        goto L9
    L16:
        int r116 = getChildCount();
    L17:
        if (r11 >= r116) goto L23;
        View r25 = getChildAt(r11);
        Intrinsics.checkNotNullExpressionValue(r25, "getChildAt(index)");
        if (r11 < r15) goto L21;
        k.f(r25);
    L22:
        r11 = r11 + 1;
        goto L17
    L21:
        k.h(r25);
        goto L22
    }

    public final List<OAvatar> getAvatars() {
        ArrayList r10 = new ArrayList();
        Iterator<View> r11 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        View r12 = r11.next();
        if ((r12 instanceof OAvatar) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    public final void setAvatars(List<? extends Drawable> r10) {
        Intrinsics.checkNotNullParameter(r10, "drawables");
        int r11 = 0;
        Iterator<T> r12 = r10.subList(0, 5).iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r15 = getChildAt(r11);
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
        OCircleImageView r16 = ((OAvatar) r15).getContentImageView();
        r16.setImageDrawable((Drawable) r13);
        r11 = r14;
        goto L4
    }
}
