package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelCommentWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Ls22/c$a;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsChatChannelCommentWidget extends RoomRecyclableWidget implements s22.c.a {
    public View a;
    public TextView b;
    public View c;
    public ViewGroup d;
    public final int e;
    public CompositeDisposable f;
    public s22.c g;

    public final int getLayoutId() {
        return 2131566634;
    }

    public abstract void xq();

    public abstract void yq(boolean r1);

    @Override // s22.c.a
    public final int U9() {
        View r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L9;
        int r2 = r0.getWidth();
        TextView r3 = this.b;
        if (r3 == null) goto L8;
        r1 = a1.f(r3);
    L8:
        return (r2 - r1) - this.e;
    L9:
        return 0;
    }

    public final void onUnload() {
        CompositeDisposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        s22.c r1 = this.g;
        if (r1 == null) goto L8;
        r1.b(ContainerType.MultiTab);
    L8:
        this.g = null;
    }

    public AbsChatChannelCommentWidget() {
        this.e = UtilityKotlinExtentionsKt.i(100);
    }

    public static final boolean wq(AbsChatChannelCommentWidget r2) {
        r2.getClass();
        s22.a r0 = ChatChannelUtils.c(null);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.s());
    L6:
        boolean r3 = true;
        if ((!Intrinsics.areEqual(r1, Boolean.TRUE)) == false) goto L15;
        s22.a r4 = ChatChannelUtils.c(null);
        r3 = false;
        if (r4 == null) goto L15;
        PropertyOwner<String> r5 = r4.r();
        if (r5 == null) goto L15;
        String r6 = (String) r5.a;
        if (r6 == null) goto L15;
        f2.c(r6, 0);
    L15:
        return r3;
    L5:
        r1 = null;
        goto L6
    }

    public final void onInit(Object[] r3) {
        View r4 = ((Widget) this).contentView;
        ViewGroup.LayoutParams r0 = null;
        if (r4 == null) goto L5;
        View r5 = r4.findViewById(2131367369);
    L6:
        this.a = r5;
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L9;
        TextView r7 = (TextView) r6.findViewById(2131367372);
    L10:
        this.b = r7;
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L13;
        View r9 = r8.findViewById(2131367368);
    L14:
        this.c = r9;
        View r10 = ((Widget) this).contentView;
        if (r10 == null) goto L17;
        ViewGroup r11 = (ViewGroup) r10.findViewById(2131375114);
    L18:
        this.d = r11;
        ViewGroup r13 = ((Widget) this).containerView;
        if (r13 == null) goto L21;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L23:
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        r0 = r14;
    L26:
        ViewGroup.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r1 == null) goto L32;
        ((ConstraintLayout.LayoutParams) r1).goneLeftMargin = s1.f(12.0f);
        ((ConstraintLayout.LayoutParams) r1).goneRightMargin = s1.f(12.0f);
        ViewGroup r15 = ((Widget) this).containerView;
        if (r15 == null) goto L33;
        r15.setLayoutParams(r1);
        return;
    L33:
        return;
    L32:
        return;
    L21:
        r14 = null;
        goto L23
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void onLoad(Object[] r5) {
        this.f = new CompositeDisposable();
        View r6 = this.a;
        if (r6 == null) goto L5;
        r6.setOnClickListener(x0.a(new AbsChatChannelCommentWidget$initView$1(this)));
    L5:
        View r7 = this.c;
        if (r7 == null) goto L8;
        r7.setOnClickListener(x0.a(new AbsChatChannelCommentWidget$initView$2(this)));
    L8:
        xq();
        RoomContext r8 = getDataContext();
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L13;
        Room r10 = (Room) r9.getValue();
    L15:
        if (ht2.g.f(r10, 15, true) == false) goto L18;
        ht2.g.c(15, r10, this.c);
    L18:
        if (ht2.g.f(r10, 18, com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true)) == false) goto L20;
        ht2.g.b(18, r10, this.a, com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true));
    L20:
        View r11 = this.a;
        if (r11 == null) goto L23;
        r11.setFocusable(true);
    L23:
        View r13 = this.a;
        String r0 = s1.B(2131915703);
        int r2 = r3.a;
        if (r13 == null) goto L28;
        if (r0 == null) goto L28;
        r3.a r3 = new r3.a(r13);
        r3.a = r0;
        r3.d = "编辑框";
        ViewCompat.setAccessibilityDelegate(r13, r3);
    L28:
        View r14 = this.c;
        if (r14 == null) goto L31;
        r14.setFocusable(true);
    L31:
        r3.c(this.c, "表情", true);
        com.bytedance.live.datacontext.j<s22.e> r15 = ChatChannelUtils.n(getDataContext());
        if (r15 == null) goto L37;
        Disposable r16 = n32.a.a(r15, new AnonymousClass1(this));
        if (r16 == null) goto L38;
        RxUtilKt.c(r16, this.f);
        return;
    L38:
        return;
    L37:
        return;
    L13:
        r10 = null;
        goto L15
    }

    @Override // s22.c.a
    public final void q7(boolean r2) {
        if (r2 == false) goto L12;
        ViewGroup r3 = this.d;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r3);
    L6:
        View r4 = this.c;
        if (r4 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r4);
    L9:
        TextView r5 = this.b;
        if (r5 == null) goto L22;
        r5.setText(s1.B(2131915702));
        return;
    L22:
        return;
    L12:
        ViewGroup r6 = this.d;
        if (r6 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r6);
    L15:
        View r7 = this.c;
        if (r7 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r7);
    L18:
        TextView r8 = this.b;
        if (r8 == null) goto L24;
        r8.setText(s1.B(2131915703));
        return;
    }
}
