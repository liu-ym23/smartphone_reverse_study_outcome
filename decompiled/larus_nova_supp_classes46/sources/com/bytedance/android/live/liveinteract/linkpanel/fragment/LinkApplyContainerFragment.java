package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkApplyListWidget;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/LinkApplyContainerFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkApplyContainerFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public com.bytedance.android.live.liveinteract.component.a<Integer> d;
    public yf0.g e;
    public LinkApplyListWidget f;
    public WidgetManager g;
    public int h;

    public static final class a {
    }

    static {
    }

    public LinkApplyContainerFragment() {
        this.h = -1;
    }

    public final void onDestroy() {
        super.onDestroy();
        t61 r0 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (u61.c(r0) != true) goto L15;
        WidgetManager r1 = this.g;
        if (r1 == null) goto L9;
        r1.unload(this.f);
    L9:
        WidgetManager r2 = this.g;
        if (r2 == null) goto L12;
        r2.contentView = null;
    L12:
        this.g = null;
        this.e = null;
        this.d = null;
        this.f = null;
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        if (this.f != null) goto L5;
        int r6 = LinkApplyListWidget.O;
        yf0.g r7 = this.e;
        int r0 = this.h;
        com.bytedance.android.live.liveinteract.component.a<Integer> r1 = this.d;
        LinkApplyListWidget r2 = new LinkApplyListWidget();
        r2.a = r7;
        r2.d = r1;
        r2.g = r0;
        this.f = r2;
    L5:
        FragmentActivity r8 = getContext();
        if (r8 == null) goto L12;
        WidgetManager r9 = WidgetManager.of(r8, r4);
        this.g = r9;
        if (r9 == null) goto L13;
        r9.load(2131375598, this.f);
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565539, r3, false);
    }
}
