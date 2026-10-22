package com.bytedance.android.live.liveinteract.enlarge.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/widget/MultiEnlargeSelectView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getSelectState", "", "getSelectUserPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiEnlargeSelectView extends ConstraintLayout {
    public Map<Integer, View> a;
    public ILinkPlayerInfoBridge b;
    public boolean c;

    public MultiEnlargeSelectView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MultiEnlargeSelectView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final long getSelectUserPosition() {
        ILinkPlayerInfoBridge r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getUserPosition();
    }

    public final boolean getSelectState() {
        return this.c;
    }

    public final void R5(ILinkPlayerInfoBridge r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        this.b = r4;
        ImageView r0 = (ImageView) _$_findCachedViewById(2131371667);
        IBaseUser r1 = r4.getUser();
        String r2 = null;
        if (r1 == null) goto L5;
        k r3 = r1.getAvatarMedium();
    L6:
        ImageUtil.loadRoundImage(r0, r3);
        TextView r5 = (TextView) _$_findCachedViewById(2131371671);
        IBaseUser r6 = r4.getUser();
        if (r6 == null) goto L9;
        r2 = r6.getNickName();
    L9:
        r5.setText(r2);
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(2131385838));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void S5(boolean r2) {
        this.c = r2;
        if (r2 == false) goto L5;
        UtilityKotlinExtentionsKt.w(_$_findCachedViewById(2131385838));
        return;
    L5:
        UtilityKotlinExtentionsKt.t(_$_findCachedViewById(2131385838));
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

    /* JADX WARN: Multi-variable type inference failed */
    public MultiEnlargeSelectView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131565652, this);
    }

    public /* synthetic */ MultiEnlargeSelectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
