package com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment;

import am2.x;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestAppliedDialogV2;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/AudienceInputReasonFragment;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceInputReasonFragment extends CommonBottomDialog {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public String b;
    public final DataCenter c;
    public final IRoom d;

    public static final class a {
    }

    public static final class b extends d2 {
        public final /* synthetic */ AudienceInputReasonFragment a;

        public b(AudienceInputReasonFragment r1) {
            this.a = r1;
        }

        public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            Editable r7 = ((EditText) this.a.findViewById(2131371783)).getText();
            if (r7 == null) goto L5;
            int r8 = r7.length();
        L6:
            ((TextView) this.a.findViewById(2131390014)).setText(s1.C(2131917609, new Object[]{Integer.valueOf(r8)}));
            if (r8 < 25) goto L9;
            ((TextView) this.a.findViewById(2131390014)).setTextColor(ColorProtector.parseColor("#FFFE3824"));
        L11:
            if (r8 < 5) goto L13;
            ((TextView) this.a.findViewById(2131364631)).setBackgroundResource(2131249467);
            return;
        L13:
            ((TextView) this.a.findViewById(2131364631)).setBackgroundResource(2131249430);
            return;
        L9:
            ((TextView) this.a.findViewById(2131390014)).setTextColor(ColorProtector.parseColor("#57161823"));
            goto L11
        L5:
            r8 = 0;
            goto L6
        }
    }

    public static final class c implements View.OnKeyListener {
        public final /* synthetic */ AudienceInputReasonFragment a;

        public c(AudienceInputReasonFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r1, int r2, KeyEvent r3) {
            AudienceInputReasonFragment r4 = this.a;
            int r5 = AudienceInputReasonFragment.e;
            if (r2 != 66) goto L5;
            r4.M0();
            return false;
        L5:
            r4.getClass();
            return false;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AudienceInputReasonFragment a;

        public d(AudienceInputReasonFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            AudienceInputReasonFragment r3 = this.a;
            int r0 = AudienceInputReasonFragment.e;
            r3.M0();
        }
    }

    public static final class e implements InputFilter {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            if (r1 == null) goto L8;
            String r7 = r1.toString();
            if (r7 == null) goto L8;
            String r8 = StringsKt.replace$default(r7, "\n", "", false, 4, null);
            if (r8 == null) goto L8;
            return r8;
        L8:
            return "";
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AudienceInputReasonFragment a;
        public final /* synthetic */ int b;

        public f(AudienceInputReasonFragment r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
            x0.a((EditText) this.a.findViewById(2131371783));
            f2.c(this.a.b, 0);
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
        L18:
            if (this.b != 4) goto L24;
            InteractAudienceGuestAppliedDialogV2 r7 = new InteractAudienceGuestAppliedDialogV2(this.a.getContext(), this.a.c);
            if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L39;
            DialogLancet.handleBlockedDialogShow(r7);
            return;
        L39:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
        L23:
            DialogLancet.beforeDialogShow(r7);
            r7.show();
            DialogLancet.afterDialogShow(r7);
            return;
        L24:
            ChatRoomGuestAppliedDialog r8 = new ChatRoomGuestAppliedDialog(this.a.getContext(), this.a.c, null);
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L34;
            DialogLancet.handleBlockedDialogShow(r8);
            return;
        L34:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
        L28:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
            goto L18
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ AudienceInputReasonFragment a;

        public g(AudienceInputReasonFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ApiServerException r3 = (Throwable) r2;
            ExceptionUtils.handleException(this.a.getContext(), r3);
            if ((r3 instanceof ApiServerException) == false) goto L9;
            com.bytedance.android.live.liveinteract.utils.d r0 = jf0.c.a;
            String r4 = r3.getPrompt();
            if (r4 != null) goto L7;
            r4 = "";
        L7:
            jf0.c.d(r4);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565528;
    }

    public final void M0() {
        if (((EditText) findViewById(2131371783)).getText().length() >= 5) goto L6;
        f2.b(2131917989, 0);
        com.bytedance.android.live.liveinteract.utils.d r1 = jf0.c.a;
        jf0.c.d(s1.B(2131917989));
        return;
    L6:
        com.bytedance.android.live.liveinteract.utils.d r2 = jf0.c.a;
        HashMap r3 = new HashMap();
        if (jf0.c.f() == false) goto L9;
        String r4 = "radio";
    L10:
        r3.put("function_type", r4);
        jf0.c.k(r3);
        String r5 = tc0.c.h().F;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        r3.put("button_type", "submit");
    L21:
        r3.put("connect_type", "apply");
        j0.l().sendLog("livesdk_guest_connection_application_submit_click", r3, new Object[]{IRoom.class, x.class});
        tc0.c.h().F = ((EditText) findViewById(2131371783)).getText().toString();
        int r7 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        LinkAudienceApi r8 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r9 = this.d;
        if (r9 == null) goto L24;
        Long r10 = Long.valueOf(r9.getId());
    L25:
        long r11 = r10.longValue();
        Editable r0 = ((EditText) findViewById(2131371783)).getText();
        if (r0 == null) goto L28;
        String r12 = r0.toString();
    L29:
        Disposable r13 = r8.updateApplyReason(r11, r7, 1, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r7), new g(this));
        if (r13 == null) goto L33;
        this.a.add(r13);
        return;
    L33:
        return;
    L28:
        r12 = null;
        goto L29
    L24:
        r10 = null;
        goto L25
    L20:
        r3.put("button_type", "resubmit");
        goto L21
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
        goto L18
    L9:
        r4 = "audience";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getWindow() == null) goto L29;
        Window r0 = getWindow();
        if (r0 == null) goto L13;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L11:
        if (r1 == null) goto L13;
        r1.setPadding(0, 0, 0, 0);
    L13:
        Window r3 = getWindow();
        if (r3 == null) goto L16;
        r3.setLayout(-1, -1);
    L16:
        Window r4 = getWindow();
        if (r4 == null) goto L19;
        r4.setGravity(80);
    L19:
        Window r5 = getWindow();
        if (r5 == null) goto L22;
        r5.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        Window r6 = getWindow();
        if (r6 == null) goto L25;
        r6.setSoftInputMode(16);
    L25:
        Window r7 = getWindow();
        if (r7 == null) goto L30;
        r7.clearFlags(1024);
        return;
    L30:
        return;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        String r10 = tc0.c.h().F;
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        if (r10.length() != 0) goto L8;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        ((TextView) findViewById(2131364631)).setText(s1.B(2131918019));
        this.b = s1.B(2131917986);
    L12:
        ((EditText) findViewById(2131371783)).setText(r10);
        ((EditText) findViewById(2131371783)).setSelection(r10.length());
        e r4 = e.a;
        ((EditText) findViewById(2131371783)).setFilters(new InputFilter[]{((EditText) findViewById(2131371783)).getFilters()[0], r4});
        ((TextView) findViewById(2131390014)).setText(s1.C(2131917609, new Object[]{String.valueOf(r10.length())}));
        ((EditText) findViewById(2131371783)).addTextChangedListener(new b(this));
        ((EditText) findViewById(2131371783)).setOnKeyListener(new c(this));
        if (r10.length() < 5) goto L15;
        ((TextView) findViewById(2131364631)).setBackgroundResource(2131249467);
    L16:
        ((TextView) findViewById(2131364631)).setOnClickListener(new d(this));
        x0.b((EditText) findViewById(2131371783));
        return;
    L15:
        ((TextView) findViewById(2131364631)).setBackgroundResource(2131249430);
        goto L16
    L8:
        r0 = false;
        goto L10
    }

    public AudienceInputReasonFragment(Context r2, DataCenter r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        super(r2);
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
        this.b = s1.B(2131917988);
    }
}
