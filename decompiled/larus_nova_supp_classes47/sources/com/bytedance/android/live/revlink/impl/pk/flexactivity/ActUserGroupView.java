package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActUserGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInteractContainerFragment$b;", "c", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInteractContainerFragment$b;", "getUpdataTab", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInteractContainerFragment$b;", "setUpdataTab", "(Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInteractContainerFragment$b;)V", "updataTab", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActUserGroupView extends ConstraintLayout {
    public Map<Integer, View> a;
    public final UserGroupAdapter b;
    public AnchorInteractContainerFragment.b c;

    public final AnchorInteractContainerFragment.b getUpdataTab() {
        return this.c;
    }

    public ActUserGroupView(Context r2) {
        this(r2, null);
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
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        int r0 = r4.getAction();
        if (r0 != 0) goto L5;
        AnchorInteractContainerFragment.b r1 = this.c;
        if (r1 == null) goto L16;
        r1.q60(true);
    L16:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    L5:
        if (r0 == 2) goto L9;
        AnchorInteractContainerFragment.b r2 = this.c;
        if (r2 == null) goto L16;
        r2.q60(false);
        goto L16
    L9:
        AnchorInteractContainerFragment.b r3 = this.c;
        if (r3 == null) goto L16;
        r3.q60(true);
        goto L16
    }

    public final void setUpdataTab(AnchorInteractContainerFragment.b r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActUserGroupView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131567284, this);
        StaggeredGridLayoutManager r4 = new StaggeredGridLayoutManager(2, 0);
        _$_findCachedViewById(2131384069).setLayoutManager(r4);
        UserGroupAdapter r5 = new UserGroupAdapter(getContext());
        this.b = r5;
        _$_findCachedViewById(2131384069).setAdapter(r5);
        ViewParent r6 = getParent();
        if (r6 == null) goto L6;
        r6.requestDisallowInterceptTouchEvent(true);
        return;
    }
}
