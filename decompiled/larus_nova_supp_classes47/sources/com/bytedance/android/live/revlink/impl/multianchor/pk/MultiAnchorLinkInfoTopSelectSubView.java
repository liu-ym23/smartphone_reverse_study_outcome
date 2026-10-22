package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.common.utility.UIUtils;
import gd0.v;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/MultiAnchorLinkInfoTopSelectSubView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorLinkInfoTopSelectSubView extends FrameLayout {
    public VHeadView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public VHeadView e;
    public ViewGroup f;
    public boolean g;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a h;

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567783, this, true);
        this.a = r0.findViewById(2131376019);
        this.b = (TextView) r0.findViewById(2131391507);
        this.c = (ImageView) r0.findViewById(2131376374);
        this.d = (TextView) r0.findViewById(2131390995);
        this.e = r0.findViewById(2131376107);
        this.f = (ViewGroup) r0.findViewById(2131372685);
        setSelected(true);
    }

    public MultiAnchorLinkInfoTopSelectSubView(Context r1) {
        Intrinsics.checkNotNull(r1);
        super(r1);
        this.h = com.bytedance.android.live.revlink.impl.global.b.t();
        a();
    }

    public MultiAnchorLinkInfoTopSelectSubView(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2);
        this.h = com.bytedance.android.live.revlink.impl.global.b.t();
        a();
    }

    public final void b(p r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "anchorLinkUser");
        boolean r2 = true;
        if (r8.getStatus() != 1) goto L5;
        boolean r0 = true;
    L6:
        this.g = r0;
        ImageView r1 = this.c;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(0);
        VHeadView r3 = this.a;
        IBaseUser r4 = r8.getUser();
        Intrinsics.checkNotNull(r4);
        k r5 = r4.getAvatarThumbKt();
        VHeadView r6 = this.a;
        Intrinsics.checkNotNull(r6);
        int r7 = r6.getWidth();
        VHeadView r10 = this.a;
        Intrinsics.checkNotNull(r10);
        a1.x(r3, r5, r7, r10.getHeight(), 2131251253);
        UIUtils.updateLayout(this.f, r9, r9);
        TextView r12 = this.d;
        if (r12 == null) goto L13;
        IBaseUser r13 = r8.getUser();
        if (r13 == null) goto L11;
        String r14 = r13.getNickName();
    L12:
        r12.setText(r14);
        goto L13
    L11:
        r14 = null;
    L13:
        TextView r15 = this.d;
        Intrinsics.checkNotNull(r15);
        r15.setVisibility(0);
        TextView r16 = this.d;
        if (r16 == null) goto L17;
        r16.setMaxWidth(r9);
    L17:
        if (this.g == false) goto L23;
        TextView r17 = this.b;
        Intrinsics.checkNotNull(r17);
        r17.setVisibility(0);
        TextView r18 = this.b;
        Intrinsics.checkNotNull(r18);
        if (r8.getRoleType() != 4) goto L21;
        int r19 = 2131914812;
    L22:
        r18.setText(r19);
    L25:
        if (this.g == true) goto L27;
    L68:
        VHeadView r20 = this.e;
        Intrinsics.checkNotNull(r20);
        r20.setVisibility(8);
    L69:
        VHeadView r22 = this.e;
        Intrinsics.checkNotNull(r22);
        r22.setOnClickListener(new a(this, r8));
        setOnClickListener(new b(this));
        return;
    L27:
        if (com.bytedance.android.live.revlink.impl.global.b.I() == null) goto L31;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r23 = com.bytedance.android.live.revlink.impl.global.b.I();
        Intrinsics.checkNotNull(r23);
        if (r23.Qd() == false) goto L31;
    L65:
        r2 = false;
    L66:
        if (r2 == false) goto L68;
        VHeadView r24 = this.e;
        Intrinsics.checkNotNull(r24);
        r24.setVisibility(0);
    L31:
        com.bytedance.android.live.revlink.impl.service.internal.a r25 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r25 == null) goto L34;
        int r26 = r25.getCurrentMode();
    L36:
        if (v.a(r26, 4) == false) goto L44;
        com.bytedance.android.live.revlink.impl.pk.service.b r27 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r27 == null) goto L40;
        i11.b r28 = r27.getLinkUserCenter();
    L41:
        if (r28 == null) goto L51;
        i11.b r29 = r27.getLinkUserCenter();
        Intrinsics.checkNotNull(r29);
        List<IBaseUser> r30 = r29.getInviteeList();
    L53:
        if (r8.getUser() == null) goto L65;
        if (r30 == null) goto L65;
        Iterator<IBaseUser> r32 = r30.iterator();
    L57:
        if (r32.hasNext() == false) goto L65;
        String r33 = iz.a.a(r32.next());
        IBaseUser r34 = r8.getUser();
        if (r34 == null) goto L61;
        String r35 = r34.getIdString();
    L63:
        if (TextUtils.equals(r33, r35) == false) goto L57;
    L61:
        r35 = null;
    L51:
        r30 = null;
        goto L53
    L40:
        r28 = null;
        goto L41
    L44:
        if (v.a(r26, 64) == false) goto L51;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r36 = this.h;
        if (r36 == null) goto L48;
        i11.b r37 = r36.getLinkUserCenter();
    L49:
        if (r37 == null) goto L51;
        r30 = this.h.getLinkUserCenter().getInviteeList();
        goto L53
    L48:
        r37 = null;
        goto L49
    L34:
        r26 = 0;
        goto L36
    L21:
        r19 = 2131914827;
        goto L22
    L23:
        TextView r38 = this.b;
        Intrinsics.checkNotNull(r38);
        r38.setVisibility(8);
        TextView r39 = this.b;
        Intrinsics.checkNotNull(r39);
        r39.setText("");
        goto L25
    L5:
        r0 = false;
        goto L6
    }

    public MultiAnchorLinkInfoTopSelectSubView(Context r1, AttributeSet r2, int r3) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2, r3);
        this.h = com.bytedance.android.live.revlink.impl.global.b.t();
        a();
    }
}
