package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rj0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeCancelOperateDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeCancelOperateDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int F = 0;
    public long B;
    public String C;
    public final CompositeDisposable D;
    public DataCenter E;

    public static final class a {
    }

    public static final class b implements MultiLinkEnlargeSelectGuestDialog.b {
        public final /* synthetic */ MultiLinkEnlargeCancelOperateDialog a;

        public b(MultiLinkEnlargeCancelOperateDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.enlarge.dialog.MultiLinkEnlargeSelectGuestDialog.b
        public final void a(List<String> r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r3, "selectedUserIdList");
            Intrinsics.checkNotNullParameter(r4, "unSelectedUserIdList");
            if (je0.d.D() == false) goto L14;
            k.m2.getClass();
            if (k.a.a() == null) goto L9;
            k r5 = k.a.a();
            if (r5 == null) goto L25;
            r5.closeMultiEnlargePosition(this.a.B, r4);
            return;
        L25:
            return;
        L9:
            com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
            if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L27;
            com.bytedance.android.live.liveinteract.voicechat.d r6 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r6 == null) goto L28;
            r6.closeMultiEnlargePosition(this.a.B, r4);
            return;
        L28:
            return;
        L27:
            return;
        L14:
            com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
            if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L19;
            com.bytedance.android.live.liveinteract.plantform.base.k r7 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
            if (r7 == null) goto L30;
            r7.closeMultiEnlargePosition(this.a.B, r4);
            return;
        L30:
            return;
        L19:
            IVoiceChatAdminService.Companion.getClass();
            if (IVoiceChatAdminService.a.a() == null) goto L32;
            IVoiceChatAdminService r8 = IVoiceChatAdminService.a.a();
            if (r8 == null) goto L33;
            r8.closeMultiEnlargePosition(this.a.B, r4);
            return;
        L33:
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565654;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0() {
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList().size();
        CPositionContext r1 = CPositionContext.Companion.getContext();
        if (r1 == null) goto L9;
        m<EnlargeGuestInfo> r2 = r1.getEnlargeGuestInfo();
        if (r2 == null) goto L9;
        EnlargeGuestInfo r3 = (EnlargeGuestInfo) r2.getValue();
        if (r3 == null) goto L9;
        long r4 = r3.getSourceUILayoutMaxMembers();
    L11:
        if (r0 <= r4) goto L18;
        int r5 = MultiLinkEnlargeSelectGuestDialog.F;
        Context r6 = getContext();
        DataCenter r7 = this.E;
        b r8 = new b(this);
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "selectedResultListener");
        MultiLinkEnlargeSelectGuestDialog r9 = new MultiLinkEnlargeSelectGuestDialog(r6);
        r9.B = r8;
        r9.E = r7;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L16:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        return;
    L18:
        if (je0.d.D() == false) goto L29;
        k.m2.getClass();
        if (k.a.a() == null) goto L24;
        k r10 = k.a.a();
        if (r10 == null) goto L45;
        r10.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L45:
        return;
    L24:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L47;
        com.bytedance.android.live.liveinteract.voicechat.d r11 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r11 == null) goto L48;
        r11.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L48:
        return;
    L47:
        return;
    L29:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L34;
        com.bytedance.android.live.liveinteract.plantform.base.k r12 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r12 == null) goto L50;
        r12.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L50:
        return;
    L34:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L52;
        IVoiceChatAdminService r13 = IVoiceChatAdminService.a.a();
        if (r13 == null) goto L53;
        r13.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L53:
        return;
    L52:
        return;
    L9:
        r4 = 0;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X0() {
        int r0 = MultiLinkEnlargeSelectNewEnlargeUserDialog.H;
        Context r1 = getContext();
        long r2 = this.B;
        String r3 = this.C;
        DataCenter r4 = this.E;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "targetUserId");
        MultiLinkEnlargeSelectNewEnlargeUserDialog r5 = new MultiLinkEnlargeSelectNewEnlargeUserDialog(r1);
        r5.B = r2;
        r5.C = r3;
        r5.G = r4;
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.D.clear();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public MultiLinkEnlargeCancelOperateDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.C = "";
        this.D = new CompositeDisposable();
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        ((TextView) findViewById(2131381550)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$1(this)));
        ((TextView) findViewById(2131381548)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$2(this)));
        ((TextView) findViewById(2131381547)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$3(this)));
        ((TextView) findViewById(2131381549)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$4(this)));
        Iterable r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((!((ILinkPlayerInfoBridge) r5).isEnlarged()) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        int r6 = r3.size();
        CPositionContext.a r7 = CPositionContext.Companion;
        CPositionContext r8 = r7.getContext();
        if (r8 == null) goto L15;
        m<EnlargeGuestInfo> r10 = r8.getEnlargeGuestInfo();
        if (r10 == null) goto L15;
        EnlargeGuestInfo r11 = (EnlargeGuestInfo) r10.getValue();
        if (r11 == null) goto L15;
        long r12 = r11.getMaxMemberExceptEnlarge();
    L16:
        long r13 = r6;
        if (r13 < r12) goto L19;
        UtilityKotlinExtentionsKt.w(findViewById(2131381550));
        UtilityKotlinExtentionsKt.w(findViewById(2131381547));
    L20:
        Integer r14 = je0.d.h();
        if (r14 != null) goto L24;
    L29:
        CPositionContext r15 = r7.getContext();
        if (r15 == null) goto L44;
        m<EnlargeGuestInfo> r16 = r15.getEnlargeGuestInfo();
        if (r16 == null) goto L45;
        Observable r17 = r16.a();
        if (r17 == null) goto L46;
        Disposable r18 = r17.subscribe(new com.bytedance.android.live.liveinteract.enlarge.dialog.a(this));
        if (r18 == null) goto L47;
        this.D.add(r18);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L24:
        if (r14.intValue() != 26) goto L29;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() != 26) goto L29;
        if (r13 < r12) goto L29;
        UtilityKotlinExtentionsKt.t(findViewById(2131381547));
        goto L29
    L19:
        UtilityKotlinExtentionsKt.w(findViewById(2131381548));
        UtilityKotlinExtentionsKt.w(findViewById(2131381547));
    L15:
        r12 = 0;
        goto L16
    }
}
