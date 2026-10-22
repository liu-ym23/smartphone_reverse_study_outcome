package fa1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.share.jsbridge.n;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m60.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends Dialog implements View.OnClickListener {
    public static final TokenCert j = null;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public String e;
    public boolean f;
    public final b g;
    public CompositeDisposable h;
    public final CallContext i;

    /* JADX INFO: renamed from: fa1.a$a, reason: collision with other inner class name */
    public static final class C0239a {
    }

    public interface b {
        void a(String r1, String r2, String r3, String r4);

        void b();
    }

    static {
        j = TokenCert.Companion.with("bpea-livescreenshotsharedialog_request_permission");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable r0 = this.h;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public static void a(a r3) {
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

    @Deprecated(message = "后续不要使用这个方法，使用checkAndSaveImage(channel: String,cert: Cert) 这个方法")
    public final void b(String r5) {
        TokenCert r0 = j;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        List r1 = null;
    L7:
        if (m60.c.c(getContext(), r1) == false) goto L9;
        e(r5);
        return;
    L9:
        Activity r2 = ContextUtil.contextToActivity(getContext());
        SettingKey r3 = i.a;
        new i.b(r2).a(new fa1.b(this, r5), r0, r1);
        return;
    L5:
        r1 = CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
        goto L7
    }

    public final View c(int r6) {
        View r0 = getLayoutInflater().inflate(2131567839, null);
        r0.setTag(Integer.valueOf(r6));
        r0.setOnClickListener(this);
        ImageView r1 = (ImageView) r0.findViewById(2131374931);
        TextView r2 = (TextView) r0.findViewById(2131388367);
        if (r6 != 1) goto L5;
        int r7 = 2131251798;
        int r3 = 2131919542;
    L18:
        if (r7 == (-1)) goto L20;
        r1.setImageResource(r7);
    L20:
        if (r3 == (-1)) goto L22;
        r2.setText(r3);
    L22:
        return r0;
    L5:
        if (r6 != 2) goto L7;
        r7 = 2131251799;
        r3 = 2131919538;
        goto L18
    L7:
        if (r6 != 3) goto L9;
        r7 = 2131251792;
        r3 = 2131919539;
        goto L18
    L9:
        if (r6 != 4) goto L11;
        r7 = 2131251794;
        r3 = 2131919540;
        goto L18
    L11:
        if (r6 == 5) goto L13;
        r7 = -1;
        r3 = -1;
        goto L18
    L13:
        r7 = 2131251192;
        r3 = 2131919541;
        goto L18
    }

    public final void d(String r6) {
        String r0 = "douyin_" + System.currentTimeMillis() + ".jpeg";
        Context r1 = getContext();
        String r2 = this.e;
        MediaStore.Images.Media.insertImage(r1.getContentResolver(), r2, r0, null);     // Catch: FileNotFoundException -> L5
    L7:
        r1.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriProtector.parse("file://" + r2)));
        String r3 = "";
        if (StringUtils.isEmpty(r6) == false) goto L10;
    L26:
        String r4 = rm3.c.a;
        rm3.c.f(getContext(), 2131922315, true, 16);
        this.g.a(r6, "", "", "");
    L27:
        a(this);
        return;
    L10:
        if (Intrinsics.areEqual("picture_save", r6) == true) goto L26;
        String r5 = s1.B(2131922315);
        if (Intrinsics.areEqual("weixin", r6) == false) goto L15;
    L24:
        r3 = s1.B(2131921126);
        String r7 = "com.tencent.mm";
    L25:
        this.g.a(r6, r5, r3, r7);
        goto L27
    L15:
        if (Intrinsics.areEqual("weixin_moment", r6) == true) goto L24;
        if (Intrinsics.areEqual("qq", r6) == false) goto L20;
    L23:
        r3 = s1.B(2131921124);
        r7 = "com.tencent.mobileqq";
        goto L25
    L20:
        if (Intrinsics.areEqual("qzone", r6) == true) goto L23;
        r7 = "";
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void e(String r14) {
        if (StringUtils.isEmpty(this.e) == false) goto L76;
        String r1 = "";
        if (this.f == true) goto L86;
        this.f = true;
        Activity r3 = ContextUtil.contextToActivity(getContext());
        if (r3 != null) goto L10;
    L75:
        this.f = false;
        String r15 = rm3.c.a;
        rm3.c.f(getContext(), 2131922314, true, 16);
        return;
    L10:
        if (r3.isFinishing() == true) goto L75;
        View r7 = this.i.d;
        if (r7 != null) goto L19;
        r7 = r3.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r8 = ThreadMethodProxy.currentThread();
        if (r8 == com.larus.home.impl.utils.c.a) goto L19;
        com.larus.home.impl.utils.c.a(r8, "getDecorView");
    L19:
        r7.setDrawingCacheEnabled(true);
        r7.buildDrawingCache();
        Bitmap r9 = r7.getDrawingCache();
        if (r9 == null) goto L87;
        int r10 = this.c;
        if ((this.a + r10) <= r9.getWidth()) goto L25;
        r10 = r9.getWidth() - this.a;
    L25:
        int r12 = this.d;
        if ((this.b + r12) <= r9.getHeight()) goto L28;
        r12 = r9.getHeight() - this.b;
    L28:
        Bitmap r13 = Bitmap.createBitmap(r9, this.a, this.b, r10, r12);
        r7.destroyDrawingCache();
        r7.setDrawingCacheEnabled(false);
        File r16 = r3.getExternalCacheDir();     // Catch: Throwable -> L63 Exception -> L68
        if (r16 == null) goto L32;
        String r4 = r16.getAbsolutePath();     // Catch: Throwable -> L63 Exception -> L68
    L37:
        if (StringUtils.isEmpty(r4) == false) goto L44;
        String r0 = rm3.c.a;     // Catch: Throwable -> L63 Exception -> L68
        rm3.c.f(getContext(), 2131922314, true, 16);     // Catch: Throwable -> L63 Exception -> L68
        this.f = false;     // Catch: Throwable -> L63 Exception -> L68
        r9.recycle();
        if (r13 == null) goto L79;
    L54:
        r13.recycle();
        return;
    L79:
        return;
    L44:
        if (StringsKt.contains$default(r4, "../", false, 2, null) == false) goto L49;
        String r2 = rm3.c.a;     // Catch: Throwable -> L63 Exception -> L68
        rm3.c.f(getContext(), 2131922314, true, 16);     // Catch: Throwable -> L63 Exception -> L68
        this.f = false;     // Catch: Throwable -> L63 Exception -> L68
        r9.recycle();
        if (r13 != null) goto L54;
        return;
    L49:
        String r5 = r4 + "/temp_screen.jpeg";     // Catch: Throwable -> L63 Exception -> L68
        if (StringsKt.contains$default(r5, "../", false, 2, null) == false) goto L55;
        String r6 = rm3.c.a;     // Catch: Throwable -> L63 Exception -> L68
        rm3.c.f(getContext(), 2131922314, true, 16);     // Catch: Throwable -> L63 Exception -> L68
        this.f = false;     // Catch: Throwable -> L63 Exception -> L68
        r9.recycle();
        if (r13 != null) goto L54;
        return;
    L55:
        PolarisFileOutputStreamWrapper r17 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L63 Exception -> L68
        if (r13 == null) goto L58;
        r13.compress(Bitmap.CompressFormat.JPEG, 50, r17);     // Catch: Throwable -> L63 Exception -> L68
    L58:
        r17.close();     // Catch: Throwable -> L63 Exception -> L68
        r9.recycle();
        if (r13 == null) goto L62;
        r13.recycle();
    L62:
        r1 = r5;
    L71:
        this.f = false;
        if (StringUtils.isEmpty(r1) == false) goto L74;
        String r18 = rm3.c.a;
        rm3.c.f(getContext(), 2131922314, true, 16);
        return;
    L74:
        this.e = r1;
        d(r14);
        return;
    L32:
        File r19 = r3.getExternalFilesDir("");     // Catch: Throwable -> L63 Exception -> L68
        if (r19 == null) goto L35;
        r4 = r19.getAbsolutePath();     // Catch: Throwable -> L63 Exception -> L68
        goto L37
    L35:
        r4 = "";
    L68:
        r9.recycle();
        if (r13 == null) goto L71;
        r13.recycle();
    L63:
        th = move-exception;
        r9.recycle();
        if (r13 == null) goto L67;
        r13.recycle();
    L67:
        throw th;
    L87:
        return;
    L86:
        return;
    L76:
        d(r14);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 != null) goto L4;
    L7:
        Object r0 = null;
        if (r3 == null) goto L10;
        Object r1 = r3.getTag();
    L12:
        if ((r1 instanceof Integer) == true) goto L14;
        return;
    L14:
        if (r3 == null) goto L16;
        r0 = r3.getTag();
    L16:
        if (r0 == null) goto L34;
        int r4 = ((Integer) r0).intValue();
        if (r4 != 3) goto L21;
        b("qq");
        return;
    L21:
        if (r4 != 4) goto L24;
        b("qzone");
        return;
    L24:
        if (r4 != 1) goto L27;
        b("weixin");
        return;
    L27:
        if (r4 != 2) goto L30;
        b("weixin_moment");
        return;
    L30:
        if (r4 != 5) goto L39;
        b("picture_save");
        return;
    L39:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L10:
        r1 = null;
        goto L12
    L4:
        if (2131365114 != r3.getId()) goto L7;
        this.g.b();
        a(this);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        setContentView(2131567455);
        boolean r7 = false;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        LinearLayout r0 = (LinearLayout) findViewById(2131362082);
        Context r1 = getContext();
        if (r1 != null) goto L5;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
        r0.addView(c(3));
        r0.addView(c(4));
    L13:
        Context r3 = getContext();
        if (r3 != null) goto L16;
    L21:
        if (r7 == false) goto L23;
        r0.addView(c(1));
        r0.addView(c(2));
    L23:
        r0.addView(c(5));
        findViewById(2131365114).setOnClickListener(this);
        this.h = new CompositeDisposable();
        return;
    L16:
        if (TextUtils.isEmpty("com.tencent.mm") == true) goto L21;
        r3.getPackageManager().getPackageInfo("com.tencent.mm", 0);     // Catch: Exception -> L25
        r7 = true;
        goto L21
    L5:
        if (TextUtils.isEmpty("com.tencent.mobileqq") == true) goto L10;
        r1.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);     // Catch: Exception -> L26
        r2 = true;
        goto L11
    }

    public a(CallContext r3, int r4, int r5, int r6, int r7, n r8) {
        Intrinsics.checkNotNullParameter(r3, "callContext");
        Intrinsics.checkNotNullParameter(r8, "callback");
        super(r3.getContext(), 2131954613);
        this.i = r3;
        this.e = "";
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.g = r8;
    }
}
