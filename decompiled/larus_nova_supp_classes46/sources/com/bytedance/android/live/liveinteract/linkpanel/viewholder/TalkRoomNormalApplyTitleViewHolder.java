package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.x0;
import java.util.LinkedList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/TalkRoomNormalApplyTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkRoomNormalApplyTitleViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int m = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final boolean h;
    public final boolean i;
    public c90.a j;
    public final com.bytedance.android.live.liveinteract.linkpanel.list.a k;
    public final LinkedList<?> l;

    public static final class a {
    }

    static {
    }

    public final TextView U3() {
        return (TextView) this.b.getValue();
    }

    public final TextView W3() {
        return (TextView) this.d.getValue();
    }

    public static int V3(ApplyTitlePanelType r3) {
        Integer r0 = (Integer) b6.B.getValue();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        if (r0 != null) goto L16;
    L21:
        return 2131923706;
    L16:
        if (r0.intValue() != 42) goto L21;
        if (r3 != ApplyTitlePanelType.GUEST_APPLY) goto L20;
        return 2131912774;
    L20:
        return 2131912773;
    L11:
        if (r0.intValue() != 40) goto L13;
    L6:
        if (r0.intValue() != 41) goto L8;
        return 2131897296;
    }

    public final void X3(TextView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$updateBubbleSelectUi");
        if (r3 == false) goto L5;
        r2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131251102, 0);
        return;
    L5:
        r2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public TalkRoomNormalApplyTitleViewHolder(final View r2, com.bytedance.android.live.liveinteract.linkpanel.list.a r3, LinkedList<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.k = r3;
        this.l = r4;
        this.a = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$sortViewLayout$2(r2));
        this.b = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$currentOrder$2(r2));
        this.c = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$switchSortLayout$2(r2));
        this.d = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$tvSortType$2(r2));
        this.e = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$ivSwitcher$2(r2));
        this.f = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$ivRule$2(r2));
        this.g = LazyKt.lazy(new TalkRoomNormalApplyTitleViewHolder$priceAmountSortTypeTv$2(r2));
        Boolean r5 = m.i().isAnchor();
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        this.h = r6;
        this.i = k.n(IMiddlewareUserService.class).user().c();
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void T3(boolean r5, int r6, ApplyTitlePanelType r7) {
        Intrinsics.checkNotNullParameter(r7, "panelType");
        if (r6 != 1) goto L9;
        View r8 = ((RecyclerView.ViewHolder) this).itemView;
        ((ImageView) this.e.getValue()).setVisibility(8);
        a1.n(W3(), s1.f(0.0f));
        if (this.h == false) goto L7;
        ((FrameLayout) this.c.getValue()).setVisibility(8);
        r8.setBackgroundColor(s1.h(2131107203));
        U3().setText(2131913564);
        return;
    L7:
        U3().setText(2131913564);
        W3().setText(2131913565);
        return;
    L9:
        if (r6 != 2) goto L29;
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundColor(s1.h(2131107196));
        boolean r9 = this.h;
        if (r9 == false) goto L23;
        if (r9 == false) goto L19;
        IInteractService r10 = (IInteractService) k.f(IInteractService.class);
        if (r10 != null) goto L16;
    L18:
        ((FrameLayout) this.c.getValue()).setOnClickListener(x0.a(new TalkRoomNormalApplyTitleViewHolder$initSortView$1(this)));
        goto L19
    L16:
        if (r10.getCurrentScene() != 4) goto L18;
        ((ImageView) this.e.getValue()).setVisibility(8);
        a1.n(W3(), s1.f(0.0f));
    L19:
        if (r5 == false) goto L21;
        U3().setText(2131911880);
    L22:
        W3().setText(V3(r7));
        return;
    L21:
        U3().setText(2131896066);
        goto L22
    L23:
        UtilityKotlinExtentionsKt.t((ImageView) this.f.getValue());
        a1.n(W3(), s1.f(0.0f));
        ((ImageView) this.e.getValue()).setVisibility(8);
        if (r5 == false) goto L26;
        U3().setText(2131911880);
    L27:
        W3().setText(V3(r7));
        return;
    L26:
        U3().setText(2131894405);
        goto L27
    L29:
        if (r6 != 3) goto L43;
        UtilityKotlinExtentionsKt.t((ImageView) this.e.getValue());
        UtilityKotlinExtentionsKt.t(W3());
        if (this.i == false) goto L33;
    L36:
        UtilityKotlinExtentionsKt.t((TextView) this.g.getValue());
    L37:
        U3().setText(s1.B(2131911880));
        return;
    L33:
        if (this.h == true) goto L36;
        UtilityKotlinExtentionsKt.w((TextView) this.g.getValue());
        goto L37
    }
}
