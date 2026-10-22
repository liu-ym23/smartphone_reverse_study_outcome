package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiMicPanelIcon;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "user", "Lcom/bytedance/android/live/base/model/user/IUser;", "invoke"}, k = 3, mv = {1, 4, 3})
final class MediaMultiLinkAnchorMicDialog$tryQueryUser$1 extends Lambda implements Function1<IUser, Unit> {
    final /* synthetic */ MediaMultiLinkAnchorMicDialog this$0;

    public MediaMultiLinkAnchorMicDialog$tryQueryUser$1(MediaMultiLinkAnchorMicDialog r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(IUser r6) {
        if (r6 == null) goto L5;
        final boolean r7 = r6.isFollowing();
    L6:
        Integer r4 = null;
        MediaMultiMicPanelIcon r1 = new MediaMultiMicPanelIcon(this.this$0.getContext(), null, 6, 0);
        if (r7 == false) goto L9;
        String r0 = s1.B(2131920319);
    L10:
        r1.setDesc(r0);
        if (r7 == false) goto L13;
        int r2 = 2131252436;
    L14:
        r1.setIcon(r2);
        r1.setOnClick(new MediaMultiLinkAnchorMicDialog$tryQueryUser$1$$special$$inlined$apply$lambda$1(this, r7));
        LinearLayout r8 = (LinearLayout) this.this$0.findViewById(2131389657);
        if (r8 == null) goto L17;
        r4 = Integer.valueOf(r8.getChildCount());
    L17:
        int r9 = r4.intValue();
        LinearLayout r3 = (LinearLayout) this.this$0.findViewById(2131389657);
        if (r3 == null) goto L21;
        r3.addView(r1, RangesKt.coerceAtLeast(r9, 1) - 1);
        return;
    L21:
        return;
    L13:
        r2 = 2131252431;
        goto L14
    L9:
        r0 = s1.B(2131920313);
        goto L10
    L5:
        r7 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IUser) r1);
        return Unit.INSTANCE;
    }
}
