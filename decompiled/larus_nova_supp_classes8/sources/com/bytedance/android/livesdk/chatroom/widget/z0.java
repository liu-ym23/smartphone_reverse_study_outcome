package com.bytedance.android.livesdk.chatroom.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PointF;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.ui.u7;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.LiveRecordWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z0 extends Dialog implements View.OnClickListener, SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, WeakHandler.IHandler {
    public static final String u = null;
    public final Activity a;
    public boolean b;
    public HSImageView c;
    public SurfaceView d;
    public View e;
    public View f;
    public final boolean g;
    public final int h;
    public String i;
    public com.bytedance.android.livesdk.chatroom.record.x j;
    public boolean k;
    public boolean l;
    public final WeakHandler m;
    public u7 n;
    public String o;
    public boolean p;
    public int q;
    public final Room r;
    public final CompositeDisposable s;
    public b t;

    public class a implements o60.e {
        public final /* synthetic */ z0 a;

        public final void onPermissionDenied(String... r1) {
        }

        public a(z0 r1) {
            this.a = r1;
        }

        public final void onPermissionGrant(String... r1) {
            this.a.c();
        }
    }

    public interface b {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r1) {
    }

    static {
        u = z0.class.getSimpleName();
    }

    public final void c() {
        if (this.k == false) goto L5;
        return;
    L5:
        if (this.l == false) goto L8;
        com.bytedance.android.live.core.utils.f2.b(2131919863, 0);
        return;
    L8:
        this.k = true;
        f(true);
        new com.bytedance.android.livesdk.chatroom.record.a0(this.m, 0).execute1(new String[]{this.i});
    }

    public final void d() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        c();
        return;
    L6:
        Activity r0 = ContextUtil.contextToActivity(com.bytedance.android.live.core.utils.s1.getContext());
        SettingKey r1 = m60.i.a;
        new m60.i.b(r0).b(new a(this), null, TokenCert.with("bpea-live_record_LiveRecordShareDialog"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        if (this.h != 0) goto L5;
        this.c.setImageURI(Uri.fromFile(new PolarisFileWrapper(this.i)));
        return;
    L5:
        this.d.getHolder().addCallback(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m.removeCallbacksAndMessages(null);
        this.b = false;
        u7 r0 = this.n;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        a(this.n);
    L8:
        if (1 != this.h) goto L13;
        com.bytedance.android.livesdk.chatroom.record.x r1 = this.j;
        if (r1 == null) goto L13;
        r1.stop();
        this.j.release();
    L13:
        if (this.p == true) goto L15;
    L17:
        this.s.clear();
        return;
    L15:
        if (jc1.k.f(IRoomService.class) == null) goto L17;
        com.bytedance.android.livesdk.module.d r2 = jc1.k.f(IRoomService.class).roomInteractService();
        long r3 = this.r.getId();
        int r5 = this.q;
        String r7 = this.r.getLabels();
        r2.a(null, r3, r5, 3, r7);
        goto L17
    }

    public static void a(Dialog r3) {
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

    public final View b(int r6) {
        View r0 = getLayoutInflater().inflate(2131567826, null);
        r0.setTag(Integer.valueOf(r6));
        r0.setOnClickListener(this);
        ImageView r1 = (ImageView) r0.findViewById(2131374931);
        TextView r2 = (TextView) r0.findViewById(2131388367);
        switch(r6) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        int r7 = -1;
        int r4 = -1;
    L12:
        if (r7 == (-1)) goto L14;
        r1.setImageResource(r7);
    L14:
        if (r4 == (-1)) goto L16;
        r2.setText(r4);
    L16:
        return r0;
    L5:
        r7 = 2131251188;
        r4 = 2131919869;
        goto L12
    L6:
        r7 = 2131251189;
        r4 = 2131919872;
        goto L12
    L7:
        r7 = 2131251795;
        r4 = 2131919871;
        goto L12
    L8:
        r7 = 2131251797;
        r4 = 2131923442;
        goto L12
    L9:
        r7 = 2131251793;
        r4 = 2131919870;
        goto L12
    L10:
        r7 = 2131251800;
        r4 = 2131919868;
        goto L12
    L11:
        r7 = 2131251801;
        r4 = 2131919873;
        goto L12
    }

    public final void f(boolean r2) {
        if (r2 == true) goto L9;
        u7 r3 = this.n;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.isShowing() == false) goto L32;
        a(this.n);
        return;
    L32:
        return;
    L9:
        u7 r4 = this.n;
        if (r4 != null) goto L18;
        u7 r5 = new u7(ContextUtil.contextToActivity(getContext()));
        r5.b = com.bytedance.android.live.core.utils.s1.B(2131919864);
        r5.setCancelable(false);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r5);
    L16:
        this.n = r5;
        return;
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L15:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L16
    L18:
        if (r4.isShowing() == true) goto L34;
        u7 r6 = this.n;
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L23:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    }

    public final void handleMsg(Message r7) {
        int r0 = r7.what;
        if (r0 == 0) goto L10;
        if (r0 != 2) goto L24;
        Object r8 = r7.obj;
        if ((r8 instanceof String) == false) goto L9;
        this.o = (String) r8;
        return;
    L9:
        com.bytedance.android.live.core.utils.f2.b(2131919852, 0);
        return;
    L24:
        return;
    L10:
        this.k = false;
        f(false);
        Object r1 = r7.obj;
        if ((r1 instanceof File) == false) goto L15;
        File r2 = (File) r1;
        this.i = r2.getAbsolutePath();
        Context r9 = com.bytedance.android.live.core.utils.s1.getContext();
        MediaScannerConnection.scanFile(r9, new String[]{r2.getAbsolutePath()}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension("3gp"), MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4")}, new w0(r9));
        com.bytedance.android.live.core.utils.f2.b(2131919863, 0);
        this.l = true;
        b r10 = this.t;
        if (r10 == null) goto L21;
        ((LiveRecordWidget.e) r10).b();
        return;
    L21:
        return;
    L15:
        com.bytedance.android.live.core.utils.f2.b(2131919862, 0);
        b r3 = this.t;
        if (r3 == null) goto L23;
        ((LiveRecordWidget.e) r3).a(r7.obj);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (2131366972 != r5.getId()) goto L22;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
    L25:
        if ((r5.getTag() instanceof Integer) == true) goto L27;
        return;
    L27:
        int r6 = ((Integer) r5.getTag()).intValue();
        switch(r6) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L31;
            default: goto L62;
        };
    L39:
        d();
        return;
    L40:
        e(r6, "qzone");
        return;
    L45:
        e(r6, "qq");
        return;
    L46:
        e(r6, "weixin_moment");
        return;
    L47:
        e(r6, "weixin");
        return;
    L62:
        return;
    L31:
        if (this.k == true) goto L52;
        com.bytedance.android.livesdk.chatroom.record.x r7 = this.j;
        if (r7 == null) goto L53;
        int r8 = r7.getDuration();
        if (r8 > 0) goto L37;
    L38:
        com.bytedance.android.live.core.utils.f2.b(2131919857, 0);
        return;
    L37:
        if (r8 > 15000) goto L38;
        return;
    L53:
        return;
    L52:
        return;
    L42:
        if (jc1.k.f(ILiveShareService.class).isShareAvailable(this.a, "weibo") == true) goto L44;
        com.bytedance.android.live.core.utils.f2.b(2131923443, 0);
        return;
    L44:
        e(r6, "weibo");
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L25
    L22:
        if (2131362562 != r5.getId()) goto L25;
        d();
        goto L25
    }

    public final void onCompletion(MediaPlayer r2) {
        if (this.b == true) goto L5;
        return;
    L5:
        r2.start();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        View r7 = findViewById(2131366972);
        this.c = findViewById(2131374931);
        this.d = (SurfaceView) findViewById(2131392236);
        this.e = findViewById(2131362562);
        this.f = findViewById(2131363363);
        this.c.getHierarchy().setActualImageFocusPoint(new PointF(0.5f, 0.0f));
        boolean r1 = false;
        if (this.h != 0) goto L5;
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    L6:
        r7.setOnClickListener(this);
        if (this.g == false) goto L10;
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        return;
    L10:
        if (1 != this.h) goto L12;
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.e.setOnClickListener(this);
        return;
    L12:
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        LinearLayout r8 = (LinearLayout) findViewById(2131362082);
        Context r2 = getContext();
        if (r2 != null) goto L15;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L23;
        r8.addView(b(1));
        r8.addView(b(2));
    L23:
        Context r4 = getContext();
        if (r4 != null) goto L26;
    L31:
        if (r1 == false) goto L33;
        r8.addView(b(3));
    L33:
        r8.addView(b(4));
        return;
    L26:
        if (TextUtils.isEmpty("com.tencent.mobileqq") == true) goto L31;
        r4.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);     // Catch: Exception -> L35
        r1 = true;
        goto L31
    L15:
        if (TextUtils.isEmpty("com.tencent.mm") == true) goto L20;
        r2.getPackageManager().getPackageInfo("com.tencent.mm", 0);     // Catch: Exception -> L36
        r3 = true;
        goto L21
    L5:
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.d.getHolder().addCallback(this);
        goto L6
    }

    public final void onPrepared(MediaPlayer r2) {
        if (this.b == true) goto L5;
        return;
    L5:
        r2.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r1) {
        com.bytedance.android.livesdk.chatroom.record.x r2 = this.j;
        if (r2 == null) goto L6;
        r2.stop();
        return;
    }

    public final void e(int r6, String r7) {
        i81.a.a r0 = new i81.a.a();
        int r1 = this.h;
        String r2 = u;
        if (r1 != 0) goto L13;
        ILiveShareService r8 = jc1.k.f(ILiveShareService.class);
        r0.d = ShareParams.builder().setPlatform(r7).setLocalFilePath(this.i).build();
        r0.b = this.a;
        Single r9 = r8.share(r0.a(), r2, LiveShareType.SHARE_THIRD, null);
        if (r9 == null) goto L7;
        r9.observeOn(AndroidSchedulers.mainThread()).subscribe(new x0(this));
    L7:
        JSONObject r10 = new JSONObject();
        r10.put("request_id", this.r.getRequestId());     // Catch: JSONException -> L10
        r10.put("log_pb", this.r.getLog_pb());     // Catch: JSONException -> L10
        r10.put("source", this.r.getUserFrom());     // Catch: JSONException -> L10
        getContext();
        this.r.getId();
        this.r.getId();
        return;
    L10:
        e = move-exception;
        Logger.e(r2, e.toString());
        return;
    L13:
        if (TextUtils.isEmpty(this.o) == false) goto L17;
        new com.bytedance.android.livesdk.chatroom.record.a(this.m).execute1(new String[]{this.i});
        return;
    L17:
        if (TextUtils.isEmpty(null) == false) goto L19;
        return;
    L19:
        ILiveShareService r3 = jc1.k.f(ILiveShareService.class);
        r0.d = ShareParams.builder().setPlatform(r7).setLocalFilePath(this.o).build();
        r0.b = this.a;
        Single r11 = r3.share(r0.a(), r2, LiveShareType.SHARE_THIRD, null);
        if (r11 == null) goto L27;
        r11.observeOn(AndroidSchedulers.mainThread()).subscribe(new y0(this, r6));
        return;
    }

    public final boolean onError(MediaPlayer r4, int r5, int r6) {
        ALogger.e(u, "MediaPlayer onError, what = " + r5 + " extra = " + r6 + " ,fileExist=" + FileUtils.checkFileExists(this.i));
        r4.release();
        this.j = null;
        com.bytedance.android.live.core.utils.f2.b(2131919883, 0);
        return false;
    }

    public z0(Activity r5, Room r6, boolean r7, String r8) {
        super(r5, 2131954730);
        this.s = new CompositeDisposable();
        ViewGroup.LayoutParams r2 = new ViewGroup.LayoutParams((int) UIUtils.dip2Px(r5, 306.0f), (int) UIUtils.dip2Px(r5, 541.0f));
        setContentView(LayoutInflater.from(r5).inflate(2131565619, null), r2);
        setCancelable(false);
        if (TextUtils.isEmpty(r8) == true) goto L7;
        this.r = r6;
        this.g = r7;
        this.h = 1;
        this.i = r8;
        this.m = new WeakHandler(this);
        this.a = r5;
        return;
    L7:
        throw new RuntimeException("File path is empty");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        if (this.h == 1) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.record.x r5 = this.j;
        if (r5 == null) goto L8;
        r5.reset();
    L9:
        this.j.setSurface(r1.getSurface());
        this.j.setIntOption(36, 1);     // Catch: IOException -> L12
        this.j.setOnCompletionListener(this);     // Catch: IOException -> L12
        this.j.setOnPreparedListener(this);     // Catch: IOException -> L12
        this.j.setOnErrorListener(this);     // Catch: IOException -> L12
        this.j.setDataSource(this.i);     // Catch: IOException -> L12
        this.j.setVolume(0.0f, 0.0f);     // Catch: IOException -> L12
        this.j.prepareAsync();     // Catch: IOException -> L12
        return;
    L12:
        e = move-exception;
        this.j = null;
        String r6 = u;
        Logger.e(r6, e.toString());
        com.bytedance.android.live.core.utils.f2.b(2131919883, 0);
        ALogger.e(r6, "surfaceChanged-exception", e);
        return;
    L8:
        this.j = com.bytedance.android.livesdk.chatroom.record.x.b(getContext());
        goto L9
    }
}
