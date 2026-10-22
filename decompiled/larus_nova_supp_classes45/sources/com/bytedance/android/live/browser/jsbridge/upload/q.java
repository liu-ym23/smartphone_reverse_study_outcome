package com.bytedance.android.live.browser.jsbridge.upload;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.TTLiveFileProvider;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.chatroom.ui.n6;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.internal.ImmutableList;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q extends com.bytedance.ies.web.jsbridge2.f<JSONObject, f> {
    public String A;
    public TokenCert B;
    public TokenCert C;
    public n6 D;
    public z E;
    public boolean F;
    public final boolean G;
    public Uri H;
    public Uri I;
    public boolean J;
    public boolean K;
    public ByteArrayOutputStream L;
    public Bitmap M;
    public int N;
    public final String a;
    public Disposable b;
    public Disposable c;
    public final CompositeDisposable d;
    public Fragment e;
    public ProgressDialog f;
    public CallContext g;
    public String h;
    public final String i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public boolean o;
    public JSONObject p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public String z;

    public class a implements o60.e {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ CallContext b;
        public final /* synthetic */ q c;

        @Override // o60.e
        public final void onPermissionDenied(String... r3) {
            UIUtils.displayToastWithIcon(this.b.getContext(), 2131250233, 2131916011);
            this.c.finishWithFailure();
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r3) {
            int r4 = this.a.optInt("duration_limit", 10000) / 1000;
            Intent r0 = new Intent("android.media.action.VIDEO_CAPTURE");
            r0.putExtra("android.intent.extra.durationLimit", r4);
            r0.putExtra("android.intent.extra.videoQuality", 1);
            if (this.c.e.getActivity() != null) goto L6;
            this.c.finishWithFailure();
            return;
        L6:
            this.c.e.startActivityForResult(r0, 9001);
        }

        public a(q r1, JSONObject r2, CallContext r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements SingleObserver<File> {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ q b;

        public final void onError(Throwable r3) {
            UIUtils.displayToastWithIcon(this.a, 2131250233, 2131921349);
            this.b.B();
        }

        public final void onSubscribe(Disposable r2) {
            this.b.d.add(r2);
        }

        public final void onSuccess(Object r5) {
            File r6 = (File) r5;
            if (r6.exists() == false) goto L8;
            q r0 = this.b;
            String r1 = r6.getAbsolutePath();
            q r2 = this.b;
            if (r0.z(r1, r2.k, r2.j) == true) goto L7;
            q r7 = this.b;
            com.bytedance.android.live.core.utils.q.o(this.a, r7.e);
            return;
        L7:
            this.b.A(r6.getAbsolutePath());
            return;
        L8:
            UIUtils.displayToastWithIcon(this.a, 2131250233, 2131921349);
            this.b.B();
        }

        public b(q r1, FragmentActivity r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements BDImageXUploaderListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ q b;

        public final void onLog(int r1, int r2, String r3) {
        }

        public c(q r1, String r2) {
            this.b = r1;
            this.a = r2;
        }

        public final int imageXUploadCheckNetState(int r1, int r2) {
            return NetworkUtils.f(this.b.g.getContext()) ? 1 : 0;
        }

        public final void onNotify(int r1, long r2, BDImageXInfo r4) {
            if (r1 != 6) goto L6;
            UploadResult r3 = new UploadResult();
            r3.setUri(r4.mImageTosKey);
            q.j(this.b, r3, this.a);
            return;
        L6:
            if (r1 != 7) goto L10;
            this.b.B();
            return;
        }
    }

    public class d implements SingleObserver<Response<UploadResult>> {
        public final /* synthetic */ File a;
        public final /* synthetic */ q b;

        public final void onError(Throwable r5) {
            Context r0 = this.b.e.getContext();
            if (r0 == null) goto L6;
            ExceptionUtils.handleException(r0, r5);
        L6:
            if (this.a.length() > 0) goto L8;
            this.b.getClass();
            return;
        L8:
            f2.b(2131921350, 0);
            this.b.B();
        }

        public final void onSubscribe(Disposable r2) {
            this.b.b = r2;
        }

        public final void onSuccess(Object r3) {
            Response r4 = (Response) r3;
            Object r0 = ((BaseResponse) r4).data;
            if (r0 != null) goto L5;
            String r1 = "";
        L6:
            q.j(this.b, (UploadResult) ((BaseResponse) r4).data, r1);
            return;
        L5:
            r1 = ((UploadResult) r0).getPath();
            goto L6
        }

        public d(q r1, PolarisFileWrapper r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class e {

        @SerializedName("local_img")
        String local_img;

        @SerializedName("local_url")
        String local_url;

        @SerializedName("uri")
        String uri;

        public e() {
        }
    }

    public static final class f {

        @SerializedName("code")
        int code;

        @SerializedName("data")
        e data;

        @SerializedName("status")
        int status;

        @SerializedName("status_msg")
        String status_msg;

        public f(int r2, String r3, e r4) {
            this.code = 1;
            this.status = r2;
            this.status_msg = r3;
            this.data = r4;
        }
    }

    public static class g {
        public final Response<UploadResult> a;
        public final String b;

        public g(String r1, Response<UploadResult> r2) {
            this.a = r2;
            this.b = r1;
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d.clear();
        Disposable r1 = this.c;
        if (r1 != null) goto L8;
    L10:
        this.e = null;
        this.g = null;
        this.D = null;
        return;
    L8:
        if (r1.isDisposed() == true) goto L10;
        this.c.dispose();
        goto L10
    }

    public final String q() {
        if (this.x == false) goto L7;
        return this.a + "/" + r();
    L7:
        return this.e.getContext().getCacheDir() + "/EncryptedUploadMethod/live_jsb_photo/" + r();
    }

    public final String r() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.i + Item.MIX_ID_SEPERATOR + this.h);
        r0.append(".jpeg");
        return r0.toString();
    }

    public final Uri s() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(q());
        if (r0.exists() == true) goto L12;
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.a);     // Catch: IOException -> L9
        if (r1.exists() == true) goto L7;
        r1.mkdirs();     // Catch: IOException -> L9
    L7:
        r0.createNewFile();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r2 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r3 = e.getStackTrace();
        r2.getClass();
        com.bytedance.android.live.core.log.g.m(6, r3);
    L12:
        return TTLiveFileProvider.getUri(this.e.getActivity(), this.e.getActivity().getPackageName() + ".ttlive_provider", r0);
    }

    public final String t() {
        return this.i + Item.MIX_ID_SEPERATOR + this.h + "crop";
    }

    public final void y() {
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

    public final void B() {
        y();
        p(new f(1, "失败", new e()), false);
    }

    public final void C() {
        y();
        p(new f(1, "失败", new e()), false);
    }

    public final Uri u() {
        String r0 = t();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.a + "/" + r0);
        if (r1.exists() == true) goto L15;
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.a);     // Catch: IOException -> L12
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

    public q(Fragment r6) {
        this.a = "";
        this.d = new CompositeDisposable();
        this.i = "upload_photo";
        this.B = TokenCert.with("bpea-live_upload_jsb_encrypted_upload_method");
        this.C = TokenCert.with("bpea-live_upload_jsb_encrypted_upload_method_camera");
        TokenCert.with("bpea-live_upload_jsb_encrypted_upload_method_gallery");
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        this.J = true;
        this.K = false;
        this.L = null;
        this.M = null;
        this.N = 0;
        this.e = r6;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 <= 29) goto L5;
        this.G = true;
    L16:
        String r2 = r6.getContext().getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/Camera";     // Catch: Exception -> L12
        this.a = r2;     // Catch: Exception -> L12
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);     // Catch: Exception -> L12
        if (r3.exists() == true) goto L18;
        r3.mkdirs();     // Catch: Exception -> L12
    L18:
        o30.c.b.b(r6.getContext().getCacheDir().getCanonicalPath());     // Catch: IOException -> L15
        return;
    L20:
        return;
    L12:
        this.a = com.bytedance.android.live.core.utils.q.h(r6.getContext(), Environment.DIRECTORY_DCIM + "/Camera").getAbsolutePath();
        goto L18
    L5:
        if (r1 != 29) goto L7;
        this.G = !Environment.isExternalStorageLegacy();
        goto L16
    L7:
        this.G = false;
        goto L16
    }

    public final void A(String r11) {
        final PolarisFileWrapper r0 = new PolarisFileWrapper(r11);
        if (r0.exists() == true) goto L7;
        B();
        return;
    L7:
        if (this.f != null) goto L10;
        ProgressDialog r1 = new ProgressDialog(this.e.getActivity());
        this.f = r1;
        r1.setMessage(s1.B(2131920029));
        this.f.setCancelable(false);
    L10:
        if (this.f.isShowing() == true) goto L16;
        ProgressDialog r2 = this.f;
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r2);
        goto L16
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L15:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    L16:
        z r3 = this.E;
        if (r3 == null) goto L26;
        int r4 = com.bytedance.android.live.browser.utils.e.a;
        String[] r5 = {r11};
        c r6 = new c(this, r11);
        Intrinsics.checkNotNullParameter(r3, "imageXConfig");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "listener");
        BDImageXUploader r12 = new BDImageXUploader();
        r12.setUploadDomain(r3.a);
        r12.setTopAccessKey(r3.b);
        r12.setTopSecretKey(r3.c);
        r12.setTopSessionToken(r3.d);
        r12.setServiceID(r3.e);
        r12.setTraceId(r3.f);
        IHostContext r7 = jc1.k.n(IHostContext.class);
        r12.setServerParameter("appid=" + r7.appId() + "&did=" + r7.getServerDeviceId() + "&uid=" + jc1.k.n(IUserService.class).user().n() + "&Region=cn&StoreRegion=cn");
        r12.setObjectType("image");
        r12.setRWTimeout(40);
        r12.setMaxFailTime(70);
        r12.setTranTimeOutUnit(8);
        r12.setFileRetryCount(1);
        r12.setEnableHttps(1);
        int r8 = r3.g;
        if (r8 <= 0) goto L21;
        r12.setSliceSize(r8);
    L21:
        int r9 = r3.h;
        if (r9 <= 0) goto L24;
        r12.setSocketNum(r9);
    L24:
        r12.setFilePath(1, r5);
        r12.setListener(new com.bytedance.android.live.browser.utils.d(r6, r12));
        r12.start();
        return;
    L26:
        Single.just(this.n).subscribeOn(Schedulers.io()).map(new m(this, r0)).zipWith(Single.just(r11).subscribeOn(Schedulers.io()).map(new n(this, r0)), new o()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r0));
    }

    public final void E(int r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L6
        r0.put("progress", r3);     // Catch: JSONException -> L6
        r0.put("phases", "zip/uplaod");     // Catch: JSONException -> L6
        CallContext r4 = this.g;     // Catch: JSONException -> L6
        if (r4 == null) goto L9;
        r4.b("H5_uploadProgress", r0);     // Catch: JSONException -> L6
        return;
    L9:
        return;
    }

    public final void F(Uri r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Intent r0 = new Intent("com.android.camera.action.CROP");
        r0.addFlags(1);     // Catch: Exception -> L14
        r0.addFlags(2);     // Catch: Exception -> L14
        r0.setDataAndType(r4, "image/*");     // Catch: Exception -> L14
        r0.putExtra("crop", "true");     // Catch: Exception -> L14
        r0.putExtra("scale", true);     // Catch: Exception -> L14
        r0.putExtra("aspectX", this.q);     // Catch: Exception -> L14
        r0.putExtra("aspectY", this.r);     // Catch: Exception -> L14
        r0.putExtra("return-data", false);     // Catch: Exception -> L14
        r0.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());     // Catch: Exception -> L14
        r0.putExtra("noFaceDetection", true);     // Catch: Exception -> L14
        r0.putExtra("scaleUpIfNeeded", true);     // Catch: Exception -> L14
        if (this.G == false) goto L10;
        Uri r5 = v(t());     // Catch: Exception -> L14
        if (r5 == null) goto L11;
        this.H = r5;     // Catch: Exception -> L14
    L11:
        if (r5 == null) goto L24;
        r0.putExtra("output", r5);     // Catch: Exception -> L14
    L24:
        Fragment r6 = this.e;     // Catch: Exception -> L20
        if (r6 == null) goto L26;
        r6.startActivityForResult(r0, 40002);     // Catch: Exception -> L20
        return;
    L26:
        return;
    L20:
        UIUtils.displayToast(this.e.getContext(), 2131921354);
        return;
    L10:
        r5 = u();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public final void k(String r4) {
        FragmentActivity r0 = this.e.getActivity();
        if (r0 != null) goto L7;
        B();
        return;
    L7:
        if (z(r4, this.k, this.j) == true) goto L10;
        com.bytedance.android.live.core.utils.q.o(r0, this.e);
        return;
    L10:
        A(r4);
    }

    public final Uri v(String r24) {
        Uri r0 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues r1 = new ContentValues();
        r1.put("title", r24);
        r1.put("date_added", Long.valueOf(System.currentTimeMillis()));
        FragmentActivity r3 = this.e.getActivity();
        if (r3 != null) goto L5;
        return null;
    L5:
        ContentResolver r4 = r3.getContentResolver();
        ArrayList r13 = new ArrayList();
        Object[] r14 = {r0, r1};
        f06.b r16 = new f06.b();
        g06.a r5 = (g06.a) ApiHookConfig.b.get(240017);
        if (r5 == null) goto L8;
        f06.a[] r6 = r5.i;
    L9:
        f06.a[] r12 = r6;
        int r11 = r12.length;
        int r15 = 0;
    L11:
        if (r15 >= r11) goto L18;
        f06.a r9 = r12[r15];
        int r21 = r15;
        int r22 = r11;
        f06.a[] r23 = r12;
        f06.d r7 = r9.preInvoke(240017, "android/content/ContentResolver", "insert", r4, r14, "android.net.Uri", r16);     // Catch: Exception -> L24
        if (r7.a == true) goto L20;
        r13.add(r9);     // Catch: Exception -> L24
    L20:
        if (r7.a == false) goto L23;
        return (Uri) r7.b;
    L23:
        return r4.insert(r0, r1);
    L17:
        r15 = r21 + 1;
        r11 = r22;
        r12 = r23;
        goto L11
    L18:
        r7 = new f06.d(false, null);
        goto L20
    L8:
        r6 = ApiHookConfig.d;
        goto L9
    }

    public static ParcelFileDescriptor l(ContentResolver r21, Uri r22) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r22, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r11 = r4;
        int r9 = r11.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r11[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r11;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r21, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r21, r22, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r11 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static Cursor m(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, null, null};
        f06.b r11 = new f06.b();
        f06.d r14 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r11);
        if (r14.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r11, false);
        return (Cursor) r14.b;
    L6:
        Cursor r15 = r12.query(r13, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r11, true);
        return r15;
    }

    public static String n(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String w(ContentResolver r2, Uri r3) {
        String r0 = "";
        Cursor r1 = null;
        r1 = m(r2, r3);     // Catch: Throwable -> L11 Exception -> L15
        if (r1 != null) goto L6;
    L9:
        if (r1 != null) goto L21;
    L18:
        return r0;
    L21:
        r1.close();     // Catch: Exception -> L19
        goto L18
    L6:
        if (r1.moveToFirst() == false) goto L9;
        r0 = r1.getString(r1.getColumnIndex("_display_name"));     // Catch: Throwable -> L11 Exception -> L15
        goto L9
    L11:
        th = move-exception;
        if (r1 != null) goto L23;
    L14:
        throw th;
    L23:
        r1.close();     // Catch: Exception -> L20
    L16:
        if (r1 == null) goto L18;
        goto L18
    }

    public static ParcelFileDescriptor x(Context r0, Uri r1) {
        if (r0 == null) goto L9;
        if (r1 == null) goto L9;
        return l(r0.getContentResolver(), r1);
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return null;
    }

    public final void invoke(JSONObject r21, CallContext r22) throws Exception {
        this.g = r22;
        String r3 = r21.optString("type");
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r21, "args");
        if (r4 != null) goto L7;
        p(new f(4, "参数为空", new e()), false);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        boolean r6 = true;
    L10:
        this.F = r6;
        this.y = r4.optInt("action_type", 0);
        if (r4.optInt("disable_edit", 0) == 1) goto L13;
        boolean r7 = true;
    L14:
        this.o = r7;
        this.n = r4.optString(LiveSlardarConstants.EXTRA_KEY_URL);
        this.t = r4.optInt("min_upload_duration_limit");
        this.u = r4.optInt("max_upload_duration_limit");
        this.z = r4.optString("min_upload_limit_error_msg");
        this.A = r4.optString("max_upload_limit_error_msg");
        this.v = r4.optBoolean("hide_loading");
        this.w = r4.optBoolean("show_progress");
        this.p = new JSONObject();
        if (JSONObjectProtectorUtils.getJSONObject(r4, "params") == null) goto L17;
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r4, "params");
        this.p = r8;
        int r9 = r8.optInt("encrypt", -1);
    L19:
        if (TextUtils.isEmpty(this.n) == false) goto L21;
    L71:
        p(new f(5, "加密情况下必须是https请求", new e()), false);
        return;
    L21:
        if (this.n.startsWith("https") == true) goto L24;
        if (r9 == 1) goto L71;
    L24:
        String r11 = r21.optString("token", "");
        if (r11 == null) goto L30;
        if (r11.isEmpty() == true) goto L30;
        this.B = TokenCert.with(r11);
    L30:
        if (TextUtils.equals(FileUtils.VIDEO, r3) == false) goto L49;
        if ((r22.getContext() instanceof Activity) == false) goto L49;
        int r1 = this.y;
        if (r1 == 0) goto L36;
        if (r1 != 1) goto L74;
        Intent r2 = new Intent("android.intent.action.GET_CONTENT");
        if (r4.optInt("duration_limit", -1) == (-1)) goto L44;
        p(new f(1, "本地视频不支持duration_limit参数", new e()), false);
        return;
    L44:
        r2.setType("video/*");
        if (this.e.getActivity() != null) goto L47;
        finishWithFailure();
        return;
    L47:
        this.e.startActivityForResult(r2, 9002);
        return;
    L74:
        return;
    L36:
        if (this.F == false) goto L38;
        ImmutableList r5 = ImmutableList.of(new String[]{"android.permission.CAMERA"});
    L39:
        Activity r12 = (Activity) r22.getContext();
        SettingKey<Boolean> r13 = m60.i.a;
        new m60.i.b(r12).a(new a(this, r4, r22), this.B, r5);
        return;
    L38:
        r5 = ImmutableList.of(new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"});
    L49:
        if (TextUtils.equals(FileUtils.PICTURE, r3) == false) goto L78;
        this.h = String.valueOf(System.currentTimeMillis());
        this.k = r4.optInt("min_width");
        this.j = r4.optInt("min_height");
        this.l = r4.optInt("max_width");
        this.m = r4.optInt("max_height");
        this.q = r4.optInt("aspect_x", 1);
        this.r = r4.optInt("aspect_y", 1);
        this.s = r4.optInt("max_length");
        this.x = r4.optBoolean("save_album", true);
        FragmentActivity r14 = this.e.getActivity();
        String r15 = r21.optString("token", "");
        int r16 = this.y;
        if (r16 != 0) goto L63;
        if (r15 == null) goto L57;
        if (r15.isEmpty() == true) goto L57;
        this.C = TokenCert.with(r15);
    L57:
        if (this.x == true) goto L59;
        Fragment r17 = this.e;
        String r18 = r();
        Cert r19 = this.C;
        TokenCert r23 = com.bytedance.android.live.core.utils.q.a;
        SettingKey<Boolean> r24 = m60.i.a;
        m60.i.b r25 = new m60.i.b(r14);
        r25.d = new com.bytedance.android.live.core.utils.i();
        r25.e = new com.bytedance.android.live.core.utils.i();
        r25.b(new com.bytedance.android.live.core.utils.p(r14, r18, r17), null, r19, new String[]{"android.permission.CAMERA"});
        return;
    L59:
        if (this.F == false) goto L61;
        com.bytedance.android.live.core.utils.q.k(r14, this.e, 40004, this.a, r(), this.C, null);
        return;
    L61:
        com.bytedance.android.live.core.utils.q.j(r14, this.e, this.a, r(), this.C);
        return;
    L63:
        if (r16 != 1) goto L82;
        jc1.k.f(IRoomService.class).setIsOnNeedMuteAudioFullPage(true);
        if (r15 != null) goto L67;
    L69:
        com.bytedance.android.live.core.utils.q.o(r14, this.e);
        return;
    L67:
        if (r15.isEmpty() == true) goto L69;
        TokenCert.with(r15);
        goto L69
    L82:
        return;
    L78:
        return;
    L17:
        r9 = -1;
        goto L19
    L13:
        r7 = false;
        goto L14
    L9:
        r6 = false;
        goto L10
    }

    public final void p(f r2, boolean r3) {
        n6 r0 = this.D;
        if (r0 == null) goto L7;
        if (r3 == false) goto L6;
        r0.z9(r2.data.uri);
        return;
    L6:
        r0.i();
        return;
    L7:
        finishWithResult(r2);
    }

    public final /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r2) throws Exception {
        invoke((JSONObject) r1, r2);
    }

    public static Response G(String r13, File r14, JSONObject r15) throws Exception {
        MultipartTypedOutput r0 = new MultipartTypedOutput();
        r0.addPart("data", new TypedFile("multipart/form-data", r14));
        IHostNetwork r4 = jc1.k.f(INetworkService.class);
        Uri.Builder r16 = UriProtector.parse(r13).buildUpon();
        if (r15 == null) goto L8;
        Iterator<String> r3 = r15.keys();
    L6:
        if (r3.hasNext() == false) goto L8;
        String r5 = r3.next();
        r16.appendQueryParameter(r5, String.valueOf(r15.opt(r5)));
    L8:
        ByteArrayOutputStream r17 = new ByteArrayOutputStream();
        r0.writeTo(r17);     // Catch: IOException -> L11
    L13:
        String r6 = r16.build().toString();
        ALogger.d("EncryptedUploadMethod", r6);
        String r18 = new String(((HttpResponse) r4.uploadFile(-1, r6, new ArrayList(1), r0.mimeType(), r17.toByteArray(), r0.length(), r0.md5Stub()).execute()).getBody());
        Response r19 = (Response) GsonProtectorUtils.fromJson(GsonHelper.get(), r18, new s().getType());
        if (r19 == null) goto L28;
    L20:
        e = move-exception;
        Logger.e("EncryptedUploadMethod", "uploadFile", e);
        return r19;
    L17:
        if (((BaseResponse) r19).statusCode == 0) goto L29;
        JSONObject r1 = new JSONObject(r18);     // Catch: JSONException -> L20
        ((BaseResponse) r19).error = (RequestError) GsonProtectorUtils.fromJson(GsonHelper.get(), JSONObjectProtectorUtils.getJSONObject(r1, "data").toString(), RequestError.class);     // Catch: JSONException -> L20
        return r19;
    L29:
        return r19;
    L28:
        return new Response();
    L11:
        e = move-exception;
        Logger.e("EncryptedUploadMethod", "uploadFile", e);
        goto L13
    }

    public static void j(q r2, UploadResult r3, String r4) {
        r2.y();
        e r0 = new e();
        if (r3 != null) goto L5;
        String r5 = null;
    L6:
        r0.uri = r5;
        o30.c.b.getClass();
        r0.local_img = o30.c.a(r4);
        r2.p(new f(0, "成功", r0), true);
        return;
    L5:
        r5 = r3.getUri();
        goto L6
    }

    public static com.bytedance.android.annie.util.q o(Context r3, ParcelFileDescriptor r4, String r5) {
        if (r4 == null) goto L5;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r3.getCacheDir(), r5);
        FileUtils.writeStreamToFile(new PolarisFileInputStreamWrapper(r4.getFileDescriptor()), r2.getAbsolutePath());
        if (r2.exists() == false) goto L11;
        return new com.bytedance.android.annie.util.q(true, r2.getPath());
    L11:
        return new com.bytedance.android.annie.util.q(false, "copy failed");
    L5:
        return new com.bytedance.android.annie.util.q(false, "copy failed");
    }

    public final void D(UploadResult r2, String r3, String r4) {
        y();
        e r0 = new e();     // Catch: Exception -> L5
        r0.uri = r2.getUri();     // Catch: Exception -> L5
        o30.c.b.getClass();     // Catch: Exception -> L5
        r0.local_url = o30.c.a(r3);     // Catch: Exception -> L5
        r0.local_img = o30.c.a(r4);     // Catch: Exception -> L5
        f r5 = new f(0, "成功", r0);     // Catch: Exception -> L5
        E(100);     // Catch: Exception -> L5
        this.g.b("H5_uploadVideoStatus", r5);     // Catch: Exception -> L5
        p(r5, true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final void onActivityResult(int r9, int r11, Intent r12) {
        int r4 = 0;
        if (9001 != r9) goto L5;
    L86:
        if ((-1) == r11) goto L88;
        p(new f(2, "取消操作", new e()), false);
        return;
    L88:
        if (r12 != null) goto L90;
    L129:
        C();
        return;
    L90:
        if (r12.getData() == null) goto L129;
        FragmentActivity r13 = this.e.getActivity();
        if (r13 != null) goto L95;
        C();
        return;
    L95:
        Uri r14 = r12.getData();
        Logger.d("EncryptedUploadMethod", "onActivityResult: uri=" + r14.toString());
        this.I = r14;
        final ParcelFileDescriptor r0 = x(r13, r14);
        if (r0 != null) goto L99;
        C();
        return;
    L99:
        if (this.v == true) goto L102;
        this.f = ProgressDialog.show(r13, s1.B(2131923438), s1.B(2131923437), true, false);
    L102:
        if (this.w == true) goto L104;
    L125:
        final String r15 = w(this.e.getContext().getContentResolver(), r14);
        if (this.w == false) goto L128;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new r(this, r0, r15, r11)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("EncryptedUploadMethod");
        return;
    L128:
        Observable.create(new p(this, r0)).flatMap(new com.bytedance.android.live.browser.jsbridge.upload.c(this, r15)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.browser.jsbridge.upload.d(this), new com.bytedance.android.live.browser.jsbridge.upload.e(this));
        return;
    L104:
        if (this.t <= 0) goto L125;
        MediaMetadataRetriever r2 = new MediaMetadataRetriever();     // Catch: Exception -> L109
        r2.setDataSource(r0.getFileDescriptor());     // Catch: Exception -> L109
        String r3 = n(r2, 9);     // Catch: Exception -> L109
        if (r3 == null) goto L110;
        r4 = CastIntegerProtector.parseInt(r3) / 1000;     // Catch: Exception -> L109
    L110:
        String r5 = s1.B(2131923090);
        String r6 = s1.B(2131923089);
        if (TextUtils.isEmpty(this.z) == true) goto L114;
        r5 = this.z;
    L114:
        if (TextUtils.isEmpty(this.A) == true) goto L116;
        r6 = this.A;
    L116:
        if (r4 <= 0) goto L121;
        int r7 = this.u;
        if (r7 <= 0) goto L121;
        if (r4 <= r7) goto L121;
        UIUtils.displayToastWithIcon(r13, 2131250233, r6);
        C();
        int r16 = a0.a;
        LiveTracingMonitor.e("ttlive_upload_video_dissatisfy", LiveTracingMonitor.EventModule.ACTIVITY, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, null);
        return;
    L121:
        if (r4 <= 0) goto L125;
        if (r4 >= this.t) goto L125;
        UIUtils.displayToastWithIcon(r13, 2131250233, r5);
        C();
        int r17 = a0.a;
        LiveTracingMonitor.e("ttlive_upload_video_dissatisfy", LiveTracingMonitor.EventModule.ACTIVITY, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, null);
        return;
    L5:
        if (9002 == r9) goto L86;
        if (r9 != 40003) goto L65;
        if ((-1) == r11) goto L12;
        p(new f(2, "取消操作", new e()), false);
        return;
    L12:
        if (r12 != null) goto L14;
    L62:
        B();
        return;
    L14:
        if (r12.getData() == null) goto L62;
        FragmentActivity r18 = this.e.getActivity();
        if (r18 != null) goto L20;
        B();
        return;
    L20:
        Uri r19 = r12.getData();
        Context r110 = this.e.getContext();
        String r1 = null;
        if (r19 == null) goto L51;
        String r8 = r19.getScheme();
        if (StringUtils.isEmpty(r8) == false) goto L26;
    L49:
        r1 = r19.getPath();
        goto L51
    L26:
        if ("file".equals(r8) == true) goto L49;
        if ("http".equals(r8) == false) goto L32;
        r1 = r19.toString();
        goto L51
    L32:
        if ("content".equals(r8) == false) goto L51;
        String r21 = w(r110.getContentResolver(), r19);
        ParcelFileDescriptor r22 = x(r110, r19);     // Catch: Exception -> L42
        if (r22 == null) goto L51;
        PolarisFileWrapper r23 = new PolarisFileWrapper(r110.getCacheDir(), r21);     // Catch: Exception -> L42
        FileUtils.writeStreamToFile(new PolarisFileInputStreamWrapper(r22.getFileDescriptor()), r23.getAbsolutePath());     // Catch: Exception -> L40
    L45:
        if (r23 == null) goto L51;
        if (r23.exists() == false) goto L51;
        r1 = r23.getAbsolutePath();
    L40:
        e = e;
    L44:
        e.printStackTrace();
    L42:
        e = e;
        r23 = null;
    L51:
        if (StringUtils.isEmpty(r1) == false) goto L54;
        UIUtils.displayToastWithIcon(r18, 2131250233, 2131921349);
        B();
        return;
    L54:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r1);
        if (r111.exists() == true) goto L59;
        UIUtils.displayToastWithIcon(r18, 2131250233, 2131921349);
        B();
        return;
    L59:
        if (this.o == false) goto L61;
        F(r19);
        return;
    L61:
        k(r111.getAbsolutePath());
        return;
    L65:
        if (r9 != 40004) goto L77;
        if ((-1) == r11) goto L70;
        p(new f(2, "取消操作", new e()), false);
        return;
    L70:
        if (this.o == true) goto L131;
        k(q());
        return;
    L131:
        F(s());     // Catch: Exception -> L73
        return;
    L73:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r112 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r24 = e.getStackTrace();
        r112.getClass();
        com.bytedance.android.live.core.log.g.m(6, r24);
        return;
    L77:
        if (r9 != 40002) goto L143;
        if ((-1) == r11) goto L81;
        p(new f(2, "取消操作", new e()), false);
        return;
    L81:
        final FragmentActivity r25 = this.e.getActivity();
        if (r25 != null) goto L85;
        B();
        return;
    L85:
        Single.fromCallable(new com.bytedance.android.live.browser.jsbridge.upload.b(this, r25)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r25));
        return;
    }

    public final boolean z(String r5, int r6, int r7) {
        InputStream r1 = null;
        InputStream r2 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L24 FileNotFoundException -> L26
        BitmapFactory.Options r8 = new BitmapFactory.Options();     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r8.inJustDecodeBounds = true;     // Catch: Throwable -> L20 FileNotFoundException -> L22
        BitmapFactory.decodeStream(r2, null, r8);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        int r3 = r8.outWidth;     // Catch: Throwable -> L20 FileNotFoundException -> L22
        if (r6 > r3) goto L17;
        int r9 = r8.outHeight;     // Catch: Throwable -> L20 FileNotFoundException -> L22
        if (r7 > r9) goto L17;
        if ((r3 * r9) <= 20971520) goto L14;
        f2.b(2131921356, 0);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r2.close();     // Catch: IOException -> L34
    L13:
        return false;
    L14:
        r2.close();     // Catch: IOException -> L35
    L38:
    L17:
        f2.b(2131921357, 0);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r2.close();     // Catch: IOException -> L36
    L19:
        return false;
    L22:
        e = e;
        r1 = r2;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r1 == null) goto L30;
        r1.close();     // Catch: IOException -> L35
    L20:
        th = th;
        r1 = r2;
    L31:
        if (r1 != null) goto L46;
    L33:
        throw th;
    L46:
        r1.close();     // Catch: IOException -> L37
    L26:
        e = e;
    L24:
        th = th;
    L30:
        return true;
    }
}
