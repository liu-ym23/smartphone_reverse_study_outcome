package z00;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.broadcast.LiveBroadcastBaseClientCopy;
import com.bytedance.android.live.broadcast.api.BroadcastUserApi;
import com.bytedance.android.live.broadcast.api.IBroadcastDialogManager;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.sk;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import java.io.FileNotFoundException;
import java.util.HashMap;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements m00.f, com.bytedance.android.live.room.g.b {
    public final long a;
    public final String b;
    public final Context c;
    public final com.bytedance.android.live.room.g d;
    public final CompositeDisposable e;
    public c9 f;
    public c9 g;
    public BaseWebDialogFragment h;
    public HybridDialog i;
    public final Fragment j;
    public final d k;

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e(String r1, String r2, String r3) {
    }

    public final /* synthetic */ void g(String r1, int r2) {
    }

    public final /* synthetic */ void h() {
    }

    public final /* synthetic */ void onError(String r1) {
    }

    @Override // m00.f
    public final void destroy() {
        this.e.dispose();
        k2 r0 = this.d;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        l();
    }

    public final void l() {
        c9 r0 = this.g;
        if (r0 == null) goto L5;
        f(r0);
    L5:
        c9 r1 = this.f;
        if (r1 == null) goto L9;
        f(r1);
    L9:
        if (((Boolean) SettingKeyUtils.i.getValue()).booleanValue() == true) goto L18;
        BaseWebDialogFragment r2 = this.h;
        if (r2 == null) goto L31;
        r2.dismiss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L32;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L32:
        return;
    L31:
        return;
    L18:
        HybridDialog r4 = this.i;
        if (r4 == null) goto L34;
        r4.dismiss();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L35;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L35:
        return;
    }

    public final HashMap<String, String> m() {
        HashMap<String, String> r0 = new HashMap();
        r0.put("room_id", String.valueOf(this.a));
        r0.put("anchor_id", String.valueOf(this.b));
        return r0;
    }

    public final void onCanceled() {
        this.d.e();
        this.e.dispose();
    }

    public static void f(c9 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void i(c9 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // m00.f
    public final void d(sk r6) {
        if (this.g != null) goto L7;
        Context r0 = this.c;
        c9.b r2 = new c9.b();
        r2.a = r0;
        r2.b = 2;
        r2.c = 2131565763;
        r2.d = s1.m(2131250957);
        r2.q = false;
        String r1 = s1.B(2131923005);
        DialogInterface.OnClickListener r3 = new g(this);
        r2.j = r1;
        r2.k = r3;
        String r4 = s1.B(2131923004);
        DialogInterface.OnClickListener r5 = new h();
        r2.l = r4;
        r2.m = r5;
        r2.s = 2131954724;
        this.g = new c9(r2.a, r2);
    L7:
        if (this.g.isShowing() == true) goto L14;
        Spannable r7 = sb2.a.h(r6.P(), r6.P().getDefaultPattern(), false);
        Spannable r8 = sb2.a.h(r6.E(), r6.E().getDefaultPattern(), false);
        Spannable r9 = sb2.a.h(r6.G(), r6.G().getDefaultPattern(), false);
        final String r11 = r6.H();
        this.g.d(r7);
        this.g.c(r8);
        c9 r12 = this.g;
        View.OnClickListener r13 = new c(this, r11);
        r12.i.setText(r9);
        r12.i.setOnClickListener(r13);
        if (TextUtils.isEmpty(r9) == true) goto L12;
        r12.i.setVisibility(0);
    L12:
        i(this.g);
        k(true);
        return;
    }

    public final void j(boolean r4) {
        HashMap<String, String> r0 = m();
        r0.put("room_id", "confirm");
        r0.put("anchor_id", "confirm");
        if (r4 == false) goto L5;
        String r5 = "none";
    L6:
        r0.put("popup", r5);
        u.l().sendLog("livesdk_room_cover_upload_click", r0, new Object[0]);
        return;
    L5:
        r5 = "verify_failed";
        goto L6
    }

    public final void k(boolean r4) {
        HashMap<String, String> r0 = m();
        r0.put("room_id", "confirm");
        r0.put("anchor_id", "confirm");
        if (r4 == false) goto L5;
        String r5 = "none";
    L6:
        r0.put("popup", r5);
        u.l().sendLog("livesdk_room_cover_popup_show", r0, new Object[0]);
        return;
    L5:
        r5 = "verify_failed";
        goto L6
    }

    public final void n(Throwable r2) {
        if ((r2 instanceof FileNotFoundException) == false) goto L6;
        String r3 = this.c.getString(2131921350);
    L9:
        this.d.e();
        f2.c(r3, 0);
        return;
    L6:
        if ((r2 instanceof ApiServerException) == false) goto L8;
        r3 = ((ApiServerException) r2).getErrorMsg();
        goto L9
    L8:
        r3 = this.c.getString(2131923023);
        goto L9
    }

    public k(Fragment r13, Room r14) {
        this.e = new CompositeDisposable();
        this.k = new d(this);
        this.c = r13.getContext();
        this.a = r14.getId();
        this.b = r14.getOwnerUserIdString();
        this.j = r13;
        this.d = jc1.k.f(ILiveSDKService.class).createImagePicker(r13.getActivity(), r13, "cover", null, 1, 1, 750, 750, this, null, null);
    }

    @Override // m00.f
    public final void a(kj r5, LiveMode r6) {
        if (this.f != null) goto L7;
        Context r0 = this.c;
        c9.b r2 = new c9.b();
        r2.a = r0;
        r2.b = 2;
        r2.c = 2131565749;
        r2.d = s1.m(2131251277);
        r2.q = false;
        String r1 = s1.B(2131923003);
        DialogInterface.OnClickListener r3 = new e(this);
        r2.j = r1;
        r2.k = r3;
        String r4 = s1.B(2131923004);
        DialogInterface.OnClickListener r7 = new f();
        r2.l = r4;
        r2.m = r7;
        r2.s = 2131954724;
        this.f = new c9(r2.a, r2);
    L7:
        if (this.f.isShowing() == true) goto L22;
        Text r8 = r5.title;     // Catch: Exception -> L17
        Spannable r9 = sb2.a.h(r8, r8.getDefaultPattern(), false);     // Catch: Exception -> L17
        Text r11 = r5.illegalText;     // Catch: Exception -> L17
        Spannable r12 = sb2.a.h(r11, r11.getDefaultPattern(), false);     // Catch: Exception -> L17
        this.f.d(r9);     // Catch: Exception -> L17
        this.f.c(r12);     // Catch: Exception -> L17
        if (r6 != LiveMode.SCREEN_RECORD) goto L15;
        this.f.setOnDismissListener(new a());
        IBroadcastDialogManager r13 = (IBroadcastDialogManager) jc1.k.f(IBroadcastDialogManager.class);
        if (r13 == null) goto L20;
        r13.addToShow(1, this.j, new b(this));
        return;
    L20:
        return;
    L15:
        this.f.setOnDismissListener(null);
        i(this.f);
        k(false);
        return;
    L23:
        return;
    }

    @Override // m00.f
    public final void onActivityResult(int r2, int r3, Intent r4) {
        this.d.r(r2, r3, r4);
    }

    public final void b(String r1, String r2, IThemeShowArea r3, ThemeUpLoadListener r4, int r5) {
        PolarisFileWrapper r6 = new PolarisFileWrapper(r1);
        if (r6.exists() == true) goto L5;
        n(new FileNotFoundException("avatar file don't exists in path" + r1));
    L6:
        l();
        return;
    L5:
        TypedOutput r7 = new MultipartTypedOutput();
        r7.addPart("file", new TypedFile("multipart/form-data", r6));
        Lazy r8 = LiveBroadcastBaseClientCopy.a;
        ((BroadcastUserApi) LiveBroadcastBaseClientCopy.a(BroadcastUserApi.class)).uploadAvatar(r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r1));
        goto L6
    }
}
