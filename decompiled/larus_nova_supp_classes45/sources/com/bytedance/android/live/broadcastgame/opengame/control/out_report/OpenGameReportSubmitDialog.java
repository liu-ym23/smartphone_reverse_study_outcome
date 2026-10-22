package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.opengame.network.GameReportApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.android.live.broadcastgame.opengame.utils.i;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/control/out_report/OpenGameReportSubmitDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/broadcastgame/opengame/control/report/c;", "", "a", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameReportSubmitDialog extends CommonBottomDialog implements com.bytedance.android.live.broadcastgame.opengame.control.report.c {
    public int a;
    public Function0<Unit> b;
    public Function1<? super Boolean, Unit> c;
    public ProgressDialog d;
    public ReportSubmitControl e;
    public q.a f;
    public final String g;
    public final String h;
    public final boolean i;
    public final /* synthetic */ i20.a j;

    public static final class a {
    }

    public static final class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r5, "dest");
            int r8 = 200 - (r5.length() - (r7 - r6));
            int r9 = r4 - r3;
            if (r8 >= r9) goto L6;
            f2.b(2131917453, 0);
        L6:
            if (r8 <= 0) goto L18;
            if (r8 < r9) goto L10;
            return null;
        L10:
            int r11 = r8 + r3;
            int r12 = r11 - 1;
            if (Character.isHighSurrogate(r2.charAt(r12)) == false) goto L16;
            if (r12 != r3) goto L14;
            return "";
        L14:
            r11 = r12;
        L16:
            return r2.subSequence(r3, r11);
        L18:
            return "";
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;

        public c(OpenGameReportSubmitDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            OpenGameReportSubmitDialog r3 = this.a;
            r3.a = 1;
            r3.cancel();
            Function0<Unit> r4 = this.a.b;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;

        public d(OpenGameReportSubmitDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r24) {
            ReportSubmitControl r1 = this.a.e;
            if (r1 == null) goto L27;
            HashMap r2 = new HashMap();
            r2.put("user_id", String.valueOf(k.n(IUserService.class).user().b().getIdString()));
            r2.put("room_id", "-1L");
            r2.put("program_id", r1.g);
            r2.put("program_name", r1.h);
            r2.put("user_type", "anchor");
            r2.put("reason", r1.f.a());
            com.bytedance.android.live.broadcastgame.opengame.control.report.c r11 = r1.b;
            if (r11 == null) goto L8;
            String r12 = r11.E0();
            if (r12 == null) goto L8;
        L9:
            r2.put("detail", r12);
            u.l().sendLog("livesdk_open_platform_report_submit", r2, new Object[0]);
            HashMap r3 = new HashMap();
            r3.put("user_id", String.valueOf(k.n(IUserService.class).user().b().getIdString()));
            r3.put("room_id", "-1L");
            r3.put("program_id", r1.g);
            r3.put("program_name", r1.h);
            r3.put("user_type", "anchor");
            r3.put("submit_status", GamePromoteDataContext.GAME_TYPE_MOBILE);
            r3.put("submit_reason", r1.f.a());
            com.bytedance.android.live.broadcastgame.opengame.control.report.c r4 = r1.b;
            if (r4 == null) goto L13;
            String r5 = r4.E0();
            if (r5 == null) goto L13;
        L14:
            r3.put("detail", r5);
            u.l().sendLog("livesdk_live_small_program_more_panel_report_click", r3, new Object[0]);
            JSONArray r6 = new JSONArray();
            UploadResult r7 = r1.d;
            if (r7 == null) goto L17;
            String r8 = r7.getUri();
        L18:
            r6.put(r8);
            Lazy r9 = LiveOpenGameClient.d;
            GameReportApi r13 = (GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class);
            String r14 = r1.g;
            String r15 = String.valueOf(r1.f.b());
            com.bytedance.android.live.broadcastgame.opengame.control.report.c r16 = r1.b;
            if (r16 == null) goto L24;
            String r17 = r16.E0();
            if (r17 == null) goto L24;
            String r18 = r17;
        L25:
            r13.submitReportBaseInfoRequest(r14, r15, r18, r6.toString(), 0, r1.f.a(), Boolean.TRUE, "", "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.broadcastgame.opengame.control.out_report.b(r1), new com.bytedance.android.live.broadcastgame.opengame.control.out_report.c(r1));
            return;
        L24:
            r18 = "";
            goto L25
        L17:
            r8 = null;
        L13:
            r5 = "";
        L8:
            r12 = "";
            goto L9
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;

        public e(OpenGameReportSubmitDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ReportSubmitControl r2 = this.a.e;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;

        public f(OpenGameReportSubmitDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ((HSImageView) this.a.findViewById(2131376464)).setController(null);
            ((ImageView) this.a.findViewById(2131376107)).setVisibility(8);
            ReportSubmitControl r4 = this.a.e;
            if (r4 == null) goto L6;
            r4.d = null;
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131564134;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void B0() {
        Function1<? super Boolean, Unit> r0 = this.c;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(Boolean.FALSE);
    L5:
        f2.b(2131921099, 0);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void G0() {
        ReportSubmitControl r0 = this.e;
        if (r0 == null) goto L5;
        r0.d = null;
    L5:
        ((HSImageView) findViewById(2131376464)).setController(null);
        ((ImageView) findViewById(2131376107)).setVisibility(8);
        ((EditText) findViewById(2131371798)).setText("");
        f2.b(2131921100, 0);
        Function1<? super Boolean, Unit> r1 = this.c;
        if (r1 == null) goto L8;
        Unit r2 = (Unit) r1.invoke(Boolean.TRUE);
    L8:
        cancel();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void i() {
        ProgressDialog r0 = this.d;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        f2.b(2131921350, 0);
    }

    public final void onDestroy() {
        ProgressDialog r0 = this.d;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        ReportSubmitControl r3 = this.e;
        if (r3 == null) goto L32;
        FragmentManager r4 = r3.a.getFragmentManager();
        if (r4 != null) goto L26;
        return;
    L26:
        if (r3.a.isAdded() == false) goto L34;
        r4.beginTransaction().remove(r3.a).commitNow();
        return;
    L34:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void t0() {
        if (this.d != null) goto L5;
        ProgressDialog r0 = new ProgressDialog(getContext());
        r0.setMessage(s1.B(2131920029));
        r0.setCancelable(false);
        Unit r1 = Unit.INSTANCE;
        this.d = r0;
    L5:
        ProgressDialog r2 = this.d;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isShowing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final String E0() {
        return ((EditText) findViewById(2131371798)).getText().toString();
    }

    public final void cancel() {
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialog*/.cancel();
        onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        onDestroy();
        this.j.b();
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

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a = 0;
        ((TextView) findViewById(2131391245)).setText(this.f.a());
    }

    public final void show() {
        Disposable r0 = i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.j.a(r0);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void J(UploadResult r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        ProgressDialog r0 = this.d;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        ((HSImageView) findViewById(2131376464)).setController(Fresco.newDraweeControllerBuilder().setUri("file://" + r4.getPath()).setAutoPlayAnimations(true).build());
        ((ImageView) findViewById(2131376107)).setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (this.i == false) goto L16;
        Window r6 = getWindow();
        if (r6 == null) goto L9;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        if (r7 == null) goto L9;
        r7.width = s1.f(390.0f);
    L9:
        View r8 = findViewById(2131384819);
        if (r8 == null) goto L12;
        a1.k(r8, s1.q(getContext()).heightPixels);
    L12:
        Window r9 = getWindow();
        if (r9 == null) goto L15;
        r9.setGravity(5);
    L15:
        t8.d(getWindow());
    L16:
        FragmentActivity r11 = ContextUtil.contextToFragmentActivity(getContext());
        if (r11 == null) goto L19;
        ReportSubmitControl r0 = new ReportSubmitControl(r11, this.f, this.g, this.h);
        Intrinsics.checkNotNullParameter(this, "callback");
        r0.b = this;
        Unit r12 = Unit.INSTANCE;
        this.e = r0;
    L19:
        ((TextView) findViewById(2131390308)).setOnClickListener(new c(this));
        ((Button) findViewById(2131364848)).setOnClickListener(new d(this));
        ((HSImageView) findViewById(2131376464)).setOnClickListener(new e(this));
        ImageView r1 = (ImageView) findViewById(2131376107);
        if (((HSImageView) findViewById(2131376464)).getController() != null) goto L22;
        int r13 = 8;
    L23:
        r1.setVisibility(r13);
        ((ImageView) findViewById(2131376107)).setOnClickListener(new f(this));
        ((EditText) findViewById(2131371798)).setFilters(new b[]{new b()});
        Window r14 = getWindow();
        if (r14 == null) goto L27;
        r14.setSoftInputMode(18);
        return;
    L27:
        return;
    L22:
        r13 = 0;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r2) {
        super/*android.app.Dialog*/.onWindowFocusChanged(r2);
        if (this.i == false) goto L7;
        if (r2 == false) goto L8;
        t8.d(getWindow());
        return;
    L8:
        return;
    }

    public OpenGameReportSubmitDialog(Context r2, q.a r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "reasonInfo");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appName");
        super(r2);
        this.j = new i20.a();
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
    }
}
