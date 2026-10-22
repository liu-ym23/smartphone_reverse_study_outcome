package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0016\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkResultContributeAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "avatarList", "", "setDebugAvatarList", "Lpy/k;", "setAvatarList", "", "Lcom/bytedance/android/live/ui/ClipImageView;", "b", "Ljava/util/List;", "getAvatarViewList", "()Ljava/util/List;", "avatarViewList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkResultContributeAvatarView extends ConstraintLayout {
    public Map<Integer, View> a;
    public final List<ClipImageView> b;

    public LinkResultContributeAvatarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LinkResultContributeAvatarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<ClipImageView> getAvatarViewList() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setAvatarList(List<? extends py.k> r6) {
        Intrinsics.checkNotNullParameter(r6, "avatarList");
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ClipImageView r4 = (ClipImageView) r2;
        if (r1 >= r6.size()) goto L11;
        UtilityKotlinExtentionsKt.w(r4);
        ImageUtil.loadRoundImage(r4, (py.k) ListProtector.get(r6, r1));
    L12:
        r1 = r3;
        goto L4
    L11:
        UtilityKotlinExtentionsKt.t(r4);
        r4.setImageURI(null);
        goto L12
    }

    public final void setDebugAvatarList(List<Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, "avatarList");
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ClipImageView r4 = (ClipImageView) r2;
        if (r1 >= r6.size()) goto L12;
        r4.setActualImageResource(((Number) ListProtector.get(r6, r1)).intValue());
        r1 = r3;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkResultContributeAvatarView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.a = new LinkedHashMap();
        ArrayList r11 = new ArrayList();
        this.b = r11;
        LayoutInflater.from(r8).inflate(2131566836, this);
        r11.add(_$_findCachedViewById(2131376145));
        r11.add(_$_findCachedViewById(2131376146));
        r11.add(_$_findCachedViewById(2131376147));
        Path r12 = new Path();
        r12.addCircle(o.a(-4.0f), o.a(8.0f), o.a(10.0f), Path.Direction.CCW);
        _$_findCachedViewById(2131376146).setMClipPath(r12);
        new Path();
        r12.addCircle(o.a(-4.0f), o.a(8.0f), o.a(10.0f), Path.Direction.CCW);
        _$_findCachedViewById(2131376147).setMClipPath(r12);
    }

    public /* synthetic */ LinkResultContributeAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
