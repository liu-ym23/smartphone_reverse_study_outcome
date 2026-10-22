package com.bytedance.android.live.broadcastgame.opengame.dialog;

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
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportSubmitControl;
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
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/OpenGameReportSubmitDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/broadcastgame/opengame/control/report/c;", "", "a", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameReportSubmitDialog extends CommonBottomDialog implements com.bytedance.android.live.broadcastgame.opengame.control.report.c {
    public int a;
    public Function0<Unit> b;
    public ProgressDialog c;
    public ReportSubmitControl d;
    public q.a e;
    public final String f;
    public final long g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public final OpenGameReportDialog.InnerPageParams l;
    public final boolean m;
    public final /* synthetic */ i20.a n;

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
            ReportSubmitControl r1 = this.a.d;
            if (r1 == null) goto L46;
            HashMap r2 = new HashMap();
            r2.put("user_id", String.valueOf(k.n(IUserService.class).user().b().getIdString()));
            r2.put("room_id", String.valueOf(r1.h));
            r2.put("program_id", r1.g);
            r2.put("program_name", r1.i);
            String r8 = "anchor";
            if (r1.j == false) goto L7;
            Object r3 = "anchor";
        L8:
            r2.put("user_type", r3);
            r2.put("reason", r1.f.a());
            com.bytedance.android.live.broadcastgame.opengame.control.report.c r4 = r1.b;
            if (r4 == null) goto L12;
            String r5 = r4.E0();
            if (r5 == null) goto L12;
        L13:
            r2.put("detail", r5);
            u.l().sendLog("livesdk_open_platform_report_submit", r2, new Object[0]);
            HashMap r6 = new HashMap();
            r6.put("user_id", String.valueOf(k.n(IUserService.class).user().b().getIdString()));
            r6.put("room_id", String.valueOf(r1.h));
            r6.put("program_id", r1.g);
            r6.put("program_name", r1.i);
            if (r1.j == true) goto L17;
            r8 = "user";
        L17:
            r6.put("user_type", r8);
            if (r1.k != PluginType.MINI_APP.getValue()) goto L20;
            String r7 = "little_program";
        L21:
            r6.put("program_type", r7);
            r6.put("submit_status", GamePromoteDataContext.GAME_TYPE_MOBILE);
            r6.put("submit_reason", r1.f.a());
            com.bytedance.android.live.broadcastgame.opengame.control.report.c r9 = r1.b;
            if (r9 == null) goto L25;
            String r11 = r9.E0();
            if (r11 == null) goto L25;
        L26:
            r6.put("detail", r11);
            u.l().sendLog("livesdk_live_small_program_more_panel_report_click", r6, new Object[0]);
            JSONArray r12 = new JSONArray();
            UploadResult r13 = r1.d;
            String r14 = null;
            if (r13 == null) goto L29;
            String r15 = r13.getUri();
        L30:
            r12.put(r15);
            Lazy r16 = LiveOpenGameClient.d;
            GameReportApi r17 = (GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class);
            String r18 = r1.g;
            String r19 = String.valueOf(r1.f.b());
            com.bytedance.android.live.broadcastgame.opengame.control.report.c r21 = r1.b;
            if (r21 == null) goto L36;
            String r22 = r21.E0();
            if (r22 == null) goto L36;
            String r110 = r22;
        L37:
            String r111 = r12.toString();
            long r23 = r1.h;
            String r112 = r1.f.a();
            Boolean r25 = Boolean.valueOf(!r1.l);
            OpenGameReportDialog.InnerPageParams r26 = r1.m;
            if (r26 == null) goto L40;
            String r27 = r26.getPath();
        L41:
            OpenGameReportDialog.InnerPageParams r28 = r1.m;
            if (r28 == null) goto L44;
            r14 = r28.getQuery();
        L44:
            r17.submitReportBaseInfoRequest(r18, r19, r110, r111, r23, r112, r25, r27, r14).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.broadcastgame.opengame.control.report.e(r1), new com.bytedance.android.live.broadcastgame.opengame.control.report.f(r1));
            return;
        L40:
            r27 = null;
        L36:
            r110 = "";
            goto L37
        L29:
            r15 = null;
        L25:
            r11 = "";
            goto L26
        L20:
            r7 = "";
        L12:
            r5 = "";
            goto L13
        L7:
            r3 = "user";
            goto L8
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;

        public e(OpenGameReportSubmitDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ReportSubmitControl r2 = this.a.d;
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
            ReportSubmitControl r4 = this.a.d;
            if (r4 == null) goto L6;
            r4.d = null;
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void B0() {
        f2.b(2131921099, 0);
    }

    public final int getLayoutId() {
        return 2131564134;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void G0() {
        ReportSubmitControl r0 = this.d;
        if (r0 == null) goto L5;
        r0.d = null;
    L5:
        ((HSImageView) findViewById(2131376464)).setController(null);
        ((ImageView) findViewById(2131376107)).setVisibility(8);
        ((EditText) findViewById(2131371798)).setText("");
        f2.b(2131921100, 0);
        cancel();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.control.report.c
    public final void i() {
        ProgressDialog r0 = this.c;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        f2.b(2131921350, 0);
    }

    public final void onDestroy() {
        ProgressDialog r0 = this.c;
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
        ReportSubmitControl r3 = this.d;
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
        if (this.c != null) goto L5;
        ProgressDialog r0 = new ProgressDialog(getContext());
        r0.setMessage(s1.B(2131920029));
        r0.setCancelable(false);
        Unit r1 = Unit.INSTANCE;
        this.c = r0;
    L5:
        ProgressDialog r2 = this.c;
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
        this.n.b();
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
        ((TextView) findViewById(2131391245)).setText(this.e.a());
    }

    public final void show() {
        Disposable r0 = i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.n.a(r0);
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
        ProgressDialog r0 = this.c;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        ((HSImageView) findViewById(2131376464)).setController(Fresco.newDraweeControllerBuilder().setUri("file://" + r4.getPath()).setAutoPlayAnimations(true).build());
        ((ImageView) findViewById(2131376107)).setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        if (this.m == false) goto L16;
        Window r13 = getWindow();
        if (r13 == null) goto L9;
        WindowManager.LayoutParams r14 = r13.getAttributes();
        if (r14 == null) goto L9;
        r14.width = s1.f(390.0f);
    L9:
        View r15 = findViewById(2131384819);
        if (r15 == null) goto L12;
        a1.k(r15, s1.q(getContext()).heightPixels);
    L12:
        Window r16 = getWindow();
        if (r16 == null) goto L15;
        r16.setGravity(5);
    L15:
        t8.d(getWindow());
    L16:
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(getContext());
        if (r1 == null) goto L19;
        ReportSubmitControl r17 = new ReportSubmitControl(r1, this.e, this.f, this.g, this.h, this.i, this.k, this.j, this.l);
        Intrinsics.checkNotNullParameter(this, "callback");
        r17.b = this;
        Unit r0 = Unit.INSTANCE;
        this.d = r17;
    L19:
        ((TextView) findViewById(2131390308)).setOnClickListener(new c(this));
        ((Button) findViewById(2131364848)).setOnClickListener(new d(this));
        ((HSImageView) findViewById(2131376464)).setOnClickListener(new e(this));
        ImageView r2 = (ImageView) findViewById(2131376107);
        if (((HSImageView) findViewById(2131376464)).getController() != null) goto L22;
        int r18 = 8;
    L23:
        r2.setVisibility(r18);
        ((ImageView) findViewById(2131376107)).setOnClickListener(new f(this));
        ((EditText) findViewById(2131371798)).setFilters(new b[]{new b()});
        Window r19 = getWindow();
        if (r19 == null) goto L27;
        r19.setSoftInputMode(18);
        return;
    L27:
        return;
    L22:
        r18 = 0;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r2) {
        super/*android.app.Dialog*/.onWindowFocusChanged(r2);
        if (this.m == false) goto L7;
        if (r2 == false) goto L8;
        t8.d(getWindow());
        return;
    L8:
        return;
    }

    public OpenGameReportSubmitDialog(Context r2, q.a r3, String r4, long r5, String r7, boolean r8, boolean r9, int r11, OpenGameReportDialog.InnerPageParams r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "reasonInfo");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r7, "appName");
        super(r2);
        this.n = new i20.a();
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r11;
        this.l = r12;
        this.m = r13;
    }
}
