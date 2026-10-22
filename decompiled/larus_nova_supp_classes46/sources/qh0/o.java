package qh0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostVerify;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livesdk.config.eb0;
import com.bytedance.android.livesdk.config.mb1;
import com.bytedance.android.livesdk.log.j0;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ h d;

    public static final class a implements ILiveFaceCertCallback {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        public final void onVerifyResult(LiveCertResult r4) {
            StringBuilder r0 = new StringBuilder("Linkmic FaceVerify result, isFaceOnly: true, errorCode = ");
            Integer r1 = null;
            if (r4 == null) goto L5;
            Integer r2 = Integer.valueOf(r4.getErrorCode());
        L6:
            r0.append(r2);
            r0.append(", status = ");
            if (r4 == null) goto L11;
            LiveCertStatus r3 = r4.getStatus();
            if (r3 == null) goto L11;
            r1 = Integer.valueOf(r3.getCertStatus());
        L11:
            r0.append(r1);
            ALogger.i("ServerPermissionHandler", r0.toString());
            if (r4 != null) goto L14;
        L16:
            f2.b(2131916536, 0);
            this.a.d.e.invoke();
            return;
        L14:
            if (r4.getErrorCode() != 0) goto L16;
            f2.b(2131916537, 0);
            this.a.d.d.invoke();
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public o(String r1, Activity r2, Map r3, h r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "dialog");
        mb1 r11 = (mb1) eb0.a.getValue();
        if (r11 != null) goto L5;
    L9:
        r9.dismiss();
        new Bundle().putString("enter_from", this.a);
        IMiddlewareUserService r12 = jc1.k.f(IMiddlewareUserService.class);
        if (r12 != null) goto L12;
    L14:
        ALogger.i("ServerPermissionHandler", "showFaceVerifyDialog: verify service = " + jc1.k.f(IMiddlewareHostVerify.class));
        IMiddlewareHostVerify r1 = jc1.k.f(IMiddlewareHostVerify.class);
        if (r1 == null) goto L17;
        Activity r2 = this.b;
        h r13 = this.d;
        String r14 = this.a;
        r13.getClass();
        HashMap r4 = new HashMap();
        r4.put("flow", "auth_face_standalone");
        r4.put("scene", r14);
        r1.doFaceLive(r2, null, r4, new JSONObject(), true, new a(this));
    L17:
        j0.l().sendLog("livesdk_anchor_face_recognition_confirm_click", this.c, new Object[0]);
        return;
    L12:
        if (r12.user().isLogin() == false) goto L14;
        r12.user().a(r12.user().n());
        goto L14
    L5:
        if (r11.a() != true) goto L9;
        if (this.d.b == true) goto L9;
        f2.b(2131914611, 0);
    }
}
