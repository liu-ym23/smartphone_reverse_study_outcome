package com.bytedance.android.live.revlink.impl.intercomment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r11.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/intercomment/InteractCommentBeInviteDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommentBeInviteDialog extends CommonBottomDialog {
    public static final /* synthetic */ int d = 0;
    public String a;
    public Disposable b;
    public final a c;

    public interface a {
        void a();

        void b(int r1, boolean r2);
    }

    public static final class b {
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ InteractCommentBeInviteDialog a;

        public c(InteractCommentBeInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r4) {
            InteractCommentBeInviteDialog r5 = this.a;
            r5.c.b(2, ((RadioButton) r5.findViewById(2131363881)).isChecked());
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ InteractCommentBeInviteDialog a;

        public d(InteractCommentBeInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            AppCompatDialog r0 = this.a;
            long r1 = 8 - ((Long) r8).longValue();
            int r9 = InteractCommentBeInviteDialog.d;
            ((Button) r0.findViewById(2131364604)).setText(r0.getContext().getString(2131917468, new Object[]{Long.valueOf(r1)}));
            if (r1 > 0) goto L22;
            r0.c.b(3, ((RadioButton) r0.findViewById(2131363881)).isChecked());
            Handler r10 = DialogLancet.resolveDialogHandler(r0);
            if (r10 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r0);
        L19:
            JSONObject r12 = new JSONObject();
            r12.put("eventName", "intercom_intro_end_page");
            ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).sendEventToAllJsBridges("H5_webcastNotification", r12);
            return;
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r13 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r13 == null) goto L18;
            com.bytedance.crash.d.d(r13, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r10.getLooper()) goto L9;
            r10.post(DialogLancet.createDismissRunnable(r0));
            goto L19
        }
    }

    static {
    }

    public final String getDegradeTag() {
        return "anchor_intercom_panel";
    }

    public final int getLayoutId() {
        return 2131565586;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r15) {
        super.onCreate(r15);
        s41.b r16 = s41.b.c;
        u r0 = r16.a();
        String r2 = null;
        if (r0 == null) goto L15;
        String r4 = r0.i();
        if (r4 == null) goto L15;
        if (r4.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        ((TextView) findViewById(2131390795)).setText(r4);
        goto L15
    L9:
        r5 = false;
    L15:
        if (r0 == null) goto L27;
        String r6 = r0.h();
        if (r6 == null) goto L27;
        if (r6.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L27;
        ((TextView) findViewById(2131390796)).setText(r6);
        goto L27
    L21:
        r7 = false;
    L27:
        if (r0 == null) goto L38;
        String r1 = r0.g();
        if (r1 == null) goto L38;
        if (r1.length() <= 0) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L36;
        r2 = r1;
    L36:
        if (r2 == null) goto L38;
        this.a = r2;
        goto L38
    L33:
        r8 = false;
    L38:
        ImageLoader.bindImage(findViewById(2131376319), this.a);
        ((Button) findViewById(2131364604)).setText(getContext().getString(2131917468, new Object[]{8L}));
        this.b = du2.a.e(1, 8, 1200, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this));
        ((Button) findViewById(2131364593)).setOnClickListener(x0.a(new AnonymousClass8(this)));
        ((Button) findViewById(2131364604)).setOnClickListener(x0.a(new AnonymousClass9(this)));
        ((LinearLayout) findViewById(2131378616)).setOnClickListener(x0.a(new AnonymousClass10(this)));
        setOnCancelListener(new c(this));
        if (r16.a().a() == false) goto L41;
        ((ImageView) findViewById(2131367374)).setVisibility(0);
        ((ImageView) findViewById(2131367374)).setOnClickListener(x0.a(new AnonymousClass12(this)));
    L42:
        setCanceledOnTouchOutside(true);
        return;
    L41:
        ((ImageView) findViewById(2131367374)).setVisibility(8);
        goto L42
    }

    public InteractCommentBeInviteDialog(Context r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.c = r3;
        this.a = "https://" + k0.a + "/obj/live-android/ttlive_inter_comment_caption.png";
    }
}
