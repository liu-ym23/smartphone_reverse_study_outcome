package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiMicPanelIcon;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "invoke"}, k = 3, mv = {1, 5, 1})
final class MultiLinkAnchorMicDialog$tryQueryUser$1 extends Lambda implements Function1<IBaseUser, Unit> {
    final /* synthetic */ MultiLinkAnchorMicDialog this$0;

    public MultiLinkAnchorMicDialog$tryQueryUser$1(MultiLinkAnchorMicDialog r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(IBaseUser r6) {
        if (r6 == null) goto L5;
        final boolean r7 = r6.isFollowing();
    L6:
        Integer r4 = null;
        MultiMicPanelIcon r1 = new MultiMicPanelIcon(this.this$0.getContext(), null, 6, 0);
        if (r7 == false) goto L9;
        String r0 = s1.B(2131920562);
    L10:
        r1.setDesc(r0);
        if (r7 == false) goto L13;
        int r2 = 2131252436;
    L14:
        r1.setIcon(r2);
        r1.setOnClick(new MultiLinkAnchorMicDialog$tryQueryUser$1$$special$$inlined$apply$lambda$1(this, r7));
        WrapLineFlowLayout r8 = this.this$0.findViewById(2131389657);
        if (r8 == null) goto L17;
        r4 = Integer.valueOf(r8.getChildCount());
    L17:
        int r9 = r4.intValue();
        WrapLineFlowLayout r3 = this.this$0.findViewById(2131389657);
        if (r3 == null) goto L21;
        r3.addView(r1, RangesKt.coerceAtLeast(r9, 1) - 1);
        return;
    L21:
        return;
    L13:
        r2 = 2131252431;
        goto L14
    L9:
        r0 = s1.B(2131920552);
        goto L10
    L5:
        r7 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IBaseUser) r1);
        return Unit.INSTANCE;
    }
}
