package w20;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import com.bytedance.android.live.browser.jsbridge.base.ScreenShotLocalTestResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.io.ByteArrayOutputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "screenShotLocalTest")
public final class td extends q5<JsonObject, ScreenShotLocalTestResultModel> {

    public static final class a {
    }

    static {
    }

    public td() {
    }

    public final void invoke(Object r7, CallContext r8) {
        Intrinsics.checkNotNullParameter((JsonObject) r7, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L6;
        ScreenShotLocalTestResultModel r9 = new ScreenShotLocalTestResultModel();
        r9.a(ScreenShotLocalTestResultModel.Code.NO_PERMISSION);
        Unit r11 = Unit.INSTANCE;
        finishWithResult(r9);
        return;
    L6:
        if (getCallContext().d != null) goto L8;
        Bitmap r12 = null;
    L19:
        if (r12 == null) goto L35;
        ScreenShotLocalTestResultModel r13 = new ScreenShotLocalTestResultModel();
        r13.a(ScreenShotLocalTestResultModel.Code.Success);
        ScreenShotLocalTestResultModel.a r0 = new ScreenShotLocalTestResultModel.a();
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        int r3 = 800;
        if (800 >= r12.getWidth()) goto L23;
        float r2 = 800 / r12.getWidth();
    L25:
        if (r2 <= 0) goto L27;
        int r4 = (int) (r12.getHeight() * r2);
    L28:
        if (r4 <= 0) goto L31;
        if (r3 <= 0) goto L31;
        Bitmap.createScaledBitmap(r12, r3, r4, true).compress(Bitmap.CompressFormat.JPEG, 50, r1);
        String r14 = "data:image/jpg;base64," + Base64.encodeToString(r1.toByteArray(), 0);
    L32:
        r0.a(r14);
        Unit r15 = Unit.INSTANCE;
        r13.b(r0);
        finishWithResult(r13);
        return;
    L31:
        r14 = "";
        goto L32
    L27:
        r4 = 0;
        r3 = 0;
        goto L28
    L23:
        r2 = 0.0f;
        goto L25
    L35:
        return;
    L8:
        View r16 = getCallContext().d;
        if (r16 == null) goto L11;
        int r17 = r16.getWidth();
    L12:
        View r18 = getCallContext().d;
        if (r18 == null) goto L15;
        int r19 = r18.getHeight();
    L16:
        r12 = Bitmap.createBitmap(r17, r19, Bitmap.Config.ARGB_8888);
        Canvas r21 = new Canvas(r12);
        View r5 = getCallContext().d;
        if (r5 == null) goto L19;
        r5.draw(r21);
        goto L19
    L15:
        r19 = com.bytedance.android.live.core.utils.s1.w();
        goto L16
    L11:
        r17 = com.bytedance.android.live.core.utils.s1.y();
        goto L12
    }
}
