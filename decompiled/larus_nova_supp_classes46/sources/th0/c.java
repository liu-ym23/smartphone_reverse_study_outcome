package th0;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragment;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragmentV2;
import com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget;
import com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;
    public final /* synthetic */ g1 b;
    public final /* synthetic */ d c;

    public c(MultiLinkVideoBaseGuestLinkWidget r1, g1 r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        FragmentActivity r9 = ((Widget) this.a).context;
        if (r9 == null) goto L19;
        FragmentManager r10 = r9.getSupportFragmentManager();
        LinkResultDialogFragment.l.getClass();
        String r1 = LinkResultDialogFragment.k;
        if (r10.findFragmentByTag(r1) != null) goto L17;
        MultiLinkVideoBaseGuestLinkWidget r11 = this.a;
        LinkResultDialogFragmentV2.a r2 = LinkResultDialogFragmentV2.u;
        g1 r3 = this.b;
        AudienceLeaveSourceEnum r4 = AudienceLeaveSourceEnum.AudienceLeave_Leave;
        d r5 = this.c;
        r2.getClass();
        r11.M = LinkResultDialogFragmentV2.a.a(r3, r4, r5);
        MultiLinkVideoBaseGuestLinkWidget r12 = this.a;
        LinkResultDialogFragmentV2 r6 = r12.M;
        if (r6 == null) goto L23;
        FragmentActivity r13 = ((Widget) r12).context;
        if (r13 == null) goto L16;
        FragmentManager r14 = r13.getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r1, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r6, r0) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L14:
        r6.showNow(r14, r1);
        return;
    L25:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L23:
        return;
    L17:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
