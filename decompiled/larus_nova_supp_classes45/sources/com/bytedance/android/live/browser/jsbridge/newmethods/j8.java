package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livesdk.config.nd0;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j8 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {
    public Fragment a;
    public IHostOCRApiProxy b;
    public a c;
    public TokenCert d;
    public final h8 e;

    public static final class a {

        @SerializedName("action_type")
        public int actionType;

        @SerializedName("compress")
        public int compress;

        @SerializedName("max_side")
        public int maxSide;

        @SerializedName("token")
        public String token;

        @SerializedName("type")
        public String type;

        public a() {
        }
    }

    public final void onTerminate() {
        this.b = null;
        this.c = null;
        this.a = null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.browser.jsbridge.newmethods.h8] */
    public j8(Fragment r2) {
        this.d = TokenCert.with("bpea-live_ocrTakePhoto_jsb_ocr_take_photo_method");
        this.e = new h8(this);
        this.a = r2;
    }

    public final void invoke(Object r7, CallContext r8) throws Exception {
        a r9 = (a) r7;
        IHostOCRApiProxy r11 = jc1.k.f(IHostOCRApiProxy.class);
        this.b = r11;
        if (r11 != null) goto L5;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr service proxy is unavaliable"));
        return;
    L5:
        this.c = r9;
        ILiveActivityResultListener r12 = this.a.getActivity();
        nd0 r1 = nd0.a;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L8;
    L10:
        int r2 = r9.actionType;
        if (r2 == 0) goto L36;
        if (r2 == 1) goto L15;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "input param error"));
        return;
    L15:
        String r0 = this.c.token;
        if (r0 == null) goto L21;
        if (r0.isEmpty() == true) goto L21;
        this.d = TokenCert.with(this.c.token);
    L21:
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L34;
        Fragment r3 = this.a;
        TokenCert r4 = this.d;
        TokenCert r5 = com.bytedance.android.live.core.utils.q.a;
        int r6 = Build.VERSION.SDK_INT;
        if (r6 < 34) goto L28;
        if (r12.getApplicationInfo().targetSdkVersion < 34) goto L28;
        String r13 = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED";
    L33:
        com.bytedance.android.live.core.utils.q.m(r12, r3, 512, r4, new String[]{r13});
        return;
    L28:
        if (r6 >= 33) goto L30;
    L32:
        r13 = "android.permission.READ_EXTERNAL_STORAGE";
        goto L33
    L30:
        if (r12.getApplicationInfo().targetSdkVersion < 33) goto L32;
        r13 = "android.permission.READ_MEDIA_IMAGES";
        goto L33
    L34:
        com.bytedance.android.live.core.utils.q.l(r12, this.a, 512, this.d, null);
        return;
    L36:
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L38;
        Intent r14 = this.b.getTakeOCRPhotoIntent(r12, r9.type);
        if (r14 != null) goto L43;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr plugin not ready"));
    L43:
        this.a.startActivityForResult(r14, 511);
        return;
    L38:
        if (this.b.startTakeOCRPhoto(r12, r9.type, 511, this.e) == true) goto L49;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr plugin not ready"));
        return;
    L49:
        return;
    L8:
        if ((r12 instanceof ILiveActivityResultListener) == false) goto L10;
        r12.setOnLiveActivityResultListener(new i8(this));
        goto L10
    }

    public final void onActivityResult(int r8, int r9, Intent r11) {
        IHostOCRApiProxy r0 = this.b;
        if (r0 != null) goto L5;
    L37:
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr service proxy is unavaliable"));
        return;
    L5:
        if (this.c == null) goto L37;
        if (r8 != 511) goto L13;
        if (r9 != (-1)) goto L11;
        Context r1 = this.a.getContext();
        a r12 = this.c;
        finishWithResult(r0.convertOCRData(r1, 0, r12.type, r12.maxSide, r12.compress));
        return;
    L11:
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(1, ""));
        return;
    L13:
        if (r8 != 512) goto L41;
        if (r9 != (-1)) goto L35;
        if (r11 == null) goto L35;
        if (r11.getData() == null) goto L35;
        FragmentActivity r13 = this.a.getActivity();
        if (r13 != null) goto L23;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr service proxy is unavaliable"));
        return;
    L23:
        Uri r14 = r11.getData();
        String r15 = com.bytedance.android.live.core.utils.q.d(r13, r14);
        if (StringUtils.isEmpty(r15) == false) goto L28;
        UIUtils.displayToastWithIcon(r13, 2131250233, 2131921349);
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr service proxy is unavaliable"));
        return;
    L28:
        if (new PolarisFileWrapper(r15).exists() == true) goto L32;
        UIUtils.displayToastWithIcon(r13, 2131250233, 2131921349);
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(IQRCodeService.ERR_CAMERA, "ocr service proxy is unavaliable"));
        return;
    L32:
        if ("file".equals(r14.getScheme()) == false) goto L34;
        r14 = com.bytedance.android.live.core.utils.q.c(r13, r15);
    L34:
        this.b.keepUriPhoto(this.a.getContext(), this.c.type, r14);
        IHostOCRApiProxy r2 = this.b;
        Context r3 = this.a.getContext();
        a r16 = this.c;
        finishWithResult(r2.convertOCRData(r3, 0, r16.type, r16.maxSide, r16.compress));
        return;
    L35:
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(1, "action canceled"));
        return;
    }
}
