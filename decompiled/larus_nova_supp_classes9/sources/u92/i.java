package u92;

import com.bytedance.android.live.base.model.message.d4;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.pin.PublicScreenPinType;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.f0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.c0;
import com.bytedance.android.livesdk.widget.a1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements j {
    public final v92.b a;

    public i(v92.b r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessageGetter");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "textMessage");
        boolean r1 = false;
        if (8 == r9.getType()) goto L6;
        return false;
    L6:
        if ((r9 instanceof c0) == true) goto L8;
        return false;
    L8:
        int r0 = com.bytedance.android.livesdk.interactivity.service.model.e.a;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().roomNoticeMessage == false) goto L11;
    L13:
        c0 r10 = (c0) r9;
        d4 r2 = r10.b;
        if (r2.C0() == true) goto L29;
        v92.c r11 = ((TransTextMessagePresenter) this.a).w;
        if (r11 == null) goto L28;
        String r3 = r2.A1();
        f0 r13 = (f0) r11;
        DataCenter r4 = ((Widget) r13.a).dataCenter;
        if (r4 != null) goto L20;
    L22:
        if (r1 == false) goto L28;
        a1.a r5 = new a1.a(((Widget) r13.a).context);
        Intrinsics.checkNotNullParameter("审核不通过", "title");
        r5.a = "审核不通过";
        Intrinsics.checkNotNullParameter(r3, "content");
        r5.b = r3;
        Intrinsics.checkNotNullParameter("确定", "rightText");
        r5.c = "确定";
        a1 r14 = new a1(r5.e, r5);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L64;
        DialogLancet.handleBlockedDialogShow(r14);
        goto L28
    L64:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L27:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L28
    L20:
        if (((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L22;
        r1 = true;
    L28:
        return true;
    L29:
        TransTextMessagePresenter r6 = (TransTextMessagePresenter) this.a;
        int r7 = 0;
    L30:
        PublicScreenPinType r8 = null;
        if (r7 >= ((ArrayList) r6.f).size()) goto L36;
        if (8 == ((com.bytedance.android.livesdk.interactivity.api.entity.f) ListProtector.get(r6.f, r7)).getType()) goto L34;
        r7 = r7 + 1;
        goto L30
    L34:
        com.bytedance.android.livesdk.interactivity.api.entity.f r15 = (com.bytedance.android.livesdk.interactivity.api.entity.f) ListProtector.get(r6.f, r7);
    L37:
        if (r15 == null) goto L46;
        d4 r16 = r15.b;
        if (r16 == null) goto L46;
        if ((r16 instanceof d4) == false) goto L46;
        d4 r17 = r16;
        r17.Z(r2.g());
        r17.r1();
        v92.c r18 = ((TransTextMessagePresenter) this.a).w;
        if (r18 == null) goto L45;
        ((f0) r18).a(r10);
    L45:
        return true;
    L46:
        v92.c r19 = ((TransTextMessagePresenter) this.a).w;
        if (r19 == null) goto L62;
        f0 r20 = (f0) r19;
        com.bytedance.android.livesdk.interactivity.publicscreen.pin.c r21 = r20.a.l;
        if (r21 == null) goto L58;
        PublicScreenPinType r23 = PublicScreenPinType.ROOM_NOTICE;
        Intrinsics.checkNotNullParameter(r23, "type");
        u42.b r24 = r21.a;
        if (r24 == null) goto L53;
        r8 = r24.getType();
    L53:
        if (r8 != r23) goto L55;
        boolean r25 = true;
    L56:
        if (r25 == false) goto L58;
        boolean r26 = true;
    L59:
        if (r26 == false) goto L62;
        r20.a(r10);
        return true;
    L55:
        r25 = false;
    L58:
        r26 = false;
    L62:
        return false;
    L36:
        r15 = null;
        goto L37
    L11:
        if (((IInteractivityInjectService) k.n(IInteractivityInjectService.class)).currentInSubMatchCamera() == false) goto L13;
        return true;
    }
}
