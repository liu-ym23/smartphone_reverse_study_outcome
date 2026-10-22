package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/obric/oui/avatar/OAvatar;", "getAvatars", "()Ljava/util/List;", "Landroid/graphics/drawable/Drawable;", "drawables", "", "setAvatars", "(Ljava/util/List;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueView extends ConstraintLayout {
    @JvmOverloads
    public OAvatarQueueView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final List<OAvatar> getAvatars() {
        ArrayList r5 = new ArrayList();
        Iterator<View> r10 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        View r11 = r10.next();
        if ((r11 instanceof OAvatar) == false) goto L4;
        r5.add(r11);
        goto L4
    L8:
        return r5;
    }

    public final void setAvatars(List<? extends Drawable> r5) {
        Intrinsics.checkNotNullParameter(r5, "drawables");
        int r10 = 0;
        Iterator<T> r11 = r5.subList(0, 5).iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Object r12 = r11.next();
        int r13 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Drawable r14 = (Drawable) r12;
        View r15 = getChildAt(r10);
        if (r15 == null) goto L12;
        ((OAvatar) r15).getContentImageView().setImageDrawable(r14);
        r10 = r13;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
    }

    @JvmOverloads
    public OAvatarQueueView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        View.inflate(r5, R$layout.o_widget_avatar_queue, this);
    }
}
