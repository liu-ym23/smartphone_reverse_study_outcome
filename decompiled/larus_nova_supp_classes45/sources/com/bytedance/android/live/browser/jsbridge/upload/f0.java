package com.bytedance.android.live.browser.jsbridge.upload;

import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.browser.api.UploadApi;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.TTLiveFileProvider;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 extends com.bytedance.ies.web.jsbridge2.f<a, b> {
    public Fragment a;
    public final String b;
    public final String c;
    public String d;
    public Disposable e;
    public ProgressDialog f;
    public a g;
    public TokenCert h;
    public TokenCert i;

    public static final class a {

        @SerializedName("action_type")
        int actionType;

        @SerializedName("aspect_x")
        int aspect_x;

        @SerializedName("aspect_y")
        int aspect_y;

        @SerializedName("max_size")
        int max_size;

        @SerializedName("min_height")
        int min_height;

        @SerializedName("min_width")
        int min_width;

        @SerializedName("token")
        String token;

        public a() {
        }
    }

    public static final class b {

        @SerializedName("image_data")
        String imageData;

        @SerializedName("uri")
        String uri;

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        String url;

        public b(String r1, String r2) {
            this.uri = r1;
            this.url = r2;
        }
    }

    public final String j() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.c + Item.MIX_ID_SEPERATOR + this.d);
        r0.append(".temp");
        return r0.toString();
    }

    public final String l() {
        return this.c + Item.MIX_ID_SEPERATOR + this.d + "crop";
    }

    public final void n() {
        ProgressDialog r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L27;
        ProgressDialog r1 = this.f;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r1));
        return;
    }

    public final void onTerminate() {
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        n();
    }

    public final Uri k() {
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.b + "/" + j());
        if (r1.exists() == true) goto L12;
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.b);     // Catch: IOException -> L9
        if (r0.exists() == true) goto L7;
        r0.mkdirs();     // Catch: IOException -> L9
    L7:
        r1.createNewFile();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r2 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r3 = e.getStackTrace();
        r2.getClass();
        com.bytedance.android.live.core.log.g.m(6, r3);
    L12:
        return TTLiveFileProvider.getUri(this.a.getActivity(), this.a.getActivity().getPackageName() + ".ttlive_provider", r1);
    }

    public final Uri m() {
        String r0 = l();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.b + "/" + r0);
        if (r1.exists() == true) goto L15;
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.b);     // Catch: IOException -> L12
        if (r2.exists() == true) goto L10;
        r2.mkdirs();     // Catch: IOException -> L12
    L10:
        r1.createNewFile();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L15:
        return Uri.fromFile(r1);
    }

    public final void o() {
        n();
        finishWithFailure();
    }

    public f0(Fragment r2) {
        this.c = "upload_photo";
        this.h = TokenCert.with("bpea-live_uploadPicture_jsb_upload_photo_v2Method_camera");
        this.i = TokenCert.with("bpea-uploadPicture_jsb_upload_photo_v2Method_gallery");
        this.a = r2;
        this.b = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera";
    }

    public final void invoke(Object r4, CallContext r5) throws Exception {
        a r6 = (a) r4;
        this.g = r6;
        this.d = String.valueOf(System.currentTimeMillis());
        FragmentActivity r7 = this.a.getActivity();
        int r0 = r6.actionType;
        if (r0 != 0) goto L11;
        String r1 = r6.token;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.live.core.utils.q.j(r7, this.a, this.b, j(), this.h);
        return;
    L7:
        if (r1.isEmpty() == true) goto L9;
        this.h = TokenCert.with(r6.token);
        goto L9
    L11:
        if (r0 != 1) goto L20;
        String r2 = r6.token;
        if (r2 != null) goto L15;
    L17:
        com.bytedance.android.live.core.utils.q.l(r7, this.a, 40003, this.i, null);
        return;
    L15:
        if (r2.isEmpty() == true) goto L17;
        this.i = TokenCert.with(r6.token);
        goto L17
    }

    public final void p(Uri r6, boolean r7) {
        if (r6 != null) goto L5;
        return;
    L5:
        Intent r1 = new Intent("com.android.camera.action.CROP");
        if (r7 == false) goto L31;
    L14:
        r1.addFlags(1);     // Catch: Exception -> L18
        r1.addFlags(2);     // Catch: Exception -> L18
        r1.setDataAndType(r6, "image/*");     // Catch: Exception -> L18
        r1.putExtra("crop", "true");     // Catch: Exception -> L18
        r1.putExtra("scale", true);     // Catch: Exception -> L18
        r1.putExtra("aspectX", this.g.aspect_x);     // Catch: Exception -> L18
        r1.putExtra("aspectY", this.g.aspect_y);     // Catch: Exception -> L18
        r1.putExtra("return-data", false);     // Catch: Exception -> L18
        r1.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());     // Catch: Exception -> L18
        r1.putExtra("noFaceDetection", true);     // Catch: Exception -> L18
        r1.putExtra("scaleUpIfNeeded", true);     // Catch: Exception -> L18
        Uri r8 = m();     // Catch: Exception -> L18
        if (r8 == null) goto L27;
        r1.putExtra("output", r8);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    L27:
        Fragment r9 = this.a;     // Catch: Exception -> L24
        if (r9 == null) goto L33;
        r9.startActivityForResult(r1, 40002);     // Catch: Exception -> L24
        return;
    L33:
        return;
    L24:
        UIUtils.displayToast(this.a.getContext(), 2131921354);
        return;
    L31:
        String r11 = r6.getLastPathSegment();     // Catch: Exception -> L18
        if (StringUtils.isEmpty(r11) == false) goto L11;
    L29:
        r6 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, CastLongProtector.parseLong(r11));     // Catch: NumberFormatException -> L26 Exception -> L18
        goto L14
    L11:
        if (r11.contains(":") == false) goto L29;
        r11 = r11.split(":")[1];     // Catch: Exception -> L18
        goto L29
    }

    public final void onActivityResult(int r9, int r11, Intent r12) {
        if (r9 != 40003) goto L28;
        if (r11 != (-1)) goto L25;
        if (r12 == null) goto L25;
        if (r12.getData() == null) goto L25;
        FragmentActivity r13 = this.a.getActivity();
        if (r13 != null) goto L13;
        o();
        return;
    L13:
        Uri r14 = r12.getData();
        String r15 = com.bytedance.android.live.core.utils.q.d(r13, r14);
        if (StringUtils.isEmpty(r15) == false) goto L18;
        UIUtils.displayToastWithIcon(r13, 2131250233, 2131921349);
        o();
        return;
    L18:
        if (new PolarisFileWrapper(r15).exists() == true) goto L22;
        UIUtils.displayToastWithIcon(r13, 2131250233, 2131921349);
        o();
        return;
    L22:
        if ("file".equals(r14.getScheme()) == false) goto L24;
        r14 = com.bytedance.android.live.core.utils.q.c(r13, r15);
    L24:
        p(r14, false);
        return;
    L25:
        o();
        return;
    L28:
        if (r9 != 40004) goto L36;
        if (r11 == (-1)) goto L111;
        return;
    L111:
        p(k(), true);     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r16 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r17 = e.getStackTrace();
        r16.getClass();
        com.bytedance.android.live.core.log.g.m(6, r17);
        return;
    L36:
        if (r9 != 40002) goto L122;
        if (r11 == (-1)) goto L40;
        o();
        return;
    L40:
        FragmentActivity r18 = this.a.getActivity();
        if (r18 != null) goto L44;
        o();
        return;
    L44:
        PolarisFileWrapper r19 = new PolarisFileWrapper(this.b + "/" + l());
        if (r19.exists() == false) goto L101;
        String r110 = r19.getAbsolutePath();
        a r1 = this.g;
        int r2 = r1.min_width;
        int r3 = r1.min_height;
        PolarisFileInputStreamWrapper r4 = null;
        PolarisFileInputStreamWrapper r6 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L65 FileNotFoundException -> L67
        BitmapFactory.Options r111 = new BitmapFactory.Options();     // Catch: Throwable -> L61 FileNotFoundException -> L63
        r111.inJustDecodeBounds = true;     // Catch: Throwable -> L61 FileNotFoundException -> L63
        BitmapFactory.decodeStream(r6, null, r111);     // Catch: Throwable -> L61 FileNotFoundException -> L63
        int r7 = r111.outWidth;     // Catch: Throwable -> L61 FileNotFoundException -> L63
        if (r2 > r7) goto L56;
        int r112 = r111.outHeight;     // Catch: Throwable -> L61 FileNotFoundException -> L63
        if (r3 > r112) goto L56;
        if ((r7 * r112) <= 16777216) goto L109;
        f2.b(2131921356, 0);     // Catch: Throwable -> L61 FileNotFoundException -> L63
    L113:
        r6.close();     // Catch: IOException -> L59
    L60:
        boolean r113 = false;
    L75:
        if (r113 == true) goto L78;
        com.bytedance.android.live.core.utils.q.l(r18, this.a, 40003, this.i, null);
        return;
    L78:
        String r21 = r19.getAbsolutePath();
        final PolarisFileWrapper r114 = new PolarisFileWrapper(r21);
        if (r114.exists() == true) goto L81;
        o();
        return;
    L81:
        long r5 = r114.length();
        int r115 = this.g.max_size;
        if (r5 < r115) goto L85;
        f2.c(s1.C(2131919624, new Object[]{Integer.valueOf((r115 / RomUtils.SZ) / RomUtils.SZ)}), 0);
        return;
    L85:
        if (this.f != null) goto L88;
        ProgressDialog r116 = new ProgressDialog(this.a.getActivity());
        this.f = r116;
        r116.setMessage(s1.B(2131920030));
        this.f.setCancelable(false);
    L88:
        if (this.f.isShowing() == true) goto L94;
        ProgressDialog r117 = this.f;
        if (DialogLancet.shouldBlockDialogShow(r117) == false) goto L115;
        DialogLancet.handleBlockedDialogShow(r117);
        goto L94
    L115:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L103
    L93:
        DialogLancet.beforeDialogShow(r117);
        r117.show();
        DialogLancet.afterDialogShow(r117);
    L94:
        TypedOutput r118 = new MultipartTypedOutput();
        r118.addPart("data", new TypedFile("multipart/form-data", r114));
        ((du2.c) ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r118).compose(RxUtil.rxSchedulerHelper()).as(new du2.d())).a(new c0(this, r114)).subscribe(new e0(this, r21, r114));
        return;
    L109:
        r6.close();     // Catch: IOException -> L73
    L74:
        r113 = true;
    L56:
        f2.b(2131921357, 0);     // Catch: Throwable -> L61 FileNotFoundException -> L63
    L63:
        e = e;
    L107:
        e.printStackTrace();     // Catch: Throwable -> L95
        if (r6 == null) goto L74;
    L95:
        th = th;
        r4 = r6;
    L97:
        r6 = r4;
    L98:
        if (r6 != null) goto L105;
    L100:
        throw th;
    L105:
        r6.close();     // Catch: IOException -> L104
    L61:
        th = th;
        goto L98
    L67:
        e = e;
        r6 = null;
    L65:
        th = th;
        goto L97
    L101:
        UIUtils.displayToastWithIcon(r18, 2131250233, 2131921349);
        o();
        return;
    }
}
