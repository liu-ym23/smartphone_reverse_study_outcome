package i;

import ai.j0;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.ai.utils.c;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.crash.n;
import com.bytedance.lynx.service.security.LynxSecurityService;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.google.common.reflect.w;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.utils.p;
import com.lynx.tasm.utils.b;
import com.lynx.tasm.utils.e;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f17475a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f17476b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static JSONObject f17477c;

    public static int a(Context r5) {
        int r10 = f17475a;
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        if (r5 != null) goto L8;
        return 0;
    L8:
        p(r5);
        int r11 = f17475a;
        if (r11 <= 0) goto L11;
        return r11;
    L11:
        return 0;
    }

    public static int b(Context r5, float r10) {
        if (r5 == null) goto L11;
        if (r5.getResources() == null) goto L11;
        if (r5.getResources().getDisplayMetrics() == null) goto L11;
        return (int) (((double) (r10 / r5.getResources().getDisplayMetrics().density)) + 0.5d);
    L11:
        return (int) r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static PointF c(UIBody r5, PointF r10) {
        if (r5 != null) goto L6;
        LynxLog.b(4, "LynxUIHelper", "convertPointFromUIToScreen failed since ui is null");
        return r10;
    L6:
        PointF r11 = new PointF(r10.x, r10.y);
        if (r5.isFlatten() == false) goto L13;
        r11.x += r5.getLeft();
        r11.y += r5.getTop();
        if (r5.getDrawParent() != null) goto L12;
        LynxLog.b(4, "LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToScreen returns is not the correct coordinates relative to the screen!");
        return r10;
    L12:
        View r12 = ((LynxUI) r5.getDrawParent()).getView();
        r11.x -= r12.getScrollX();
        r11.y -= r12.getScrollY();
        ?? r13 = r12;
    L15:
        return p.m(r13, r13.getRootView(), r11);
    L13:
        r13 = r5.getView();
        goto L15
    }

    public static RectF d(LynxBaseUI r5, RectF r10) {
        LynxContext r11 = r5.getLynxContext();
        if (r11 != null) goto L6;
        LynxLog.b(4, "LynxUIHelper", "convertRectFromUIToRootUI failed since context is null");
        return r10;
    L6:
        UIBody r12 = r11.f10145m;
        if (r12 != null) goto L11;
        LynxLog.b(4, "LynxUIHelper", "convertRectFromUIToRootUI failed since rootUI is null");
        return r10;
    L11:
        return f(r5, r12, r10);
    }

    public static RectF e(LynxBaseUI r5, ReadableMap r10) {
        if (r10 == null) goto L40;
        if (r10.getBoolean("androidEnableTransformProps", false) == false) goto L40;
        LynxBaseUI r11 = null;
        if (r10.hasKey("relativeTo") == true) goto L8;
    L11:
        String r12 = null;
    L13:
        if (r5 == null) goto L29;
        if (r12 == null) goto L29;
        LynxBaseUI r13 = (LynxBaseUI) r5.getParent();
    L17:
        if (r13 == null) goto L23;
        if (r12.equals(r13.getIdSelector()) == true) goto L20;
        r13 = (LynxBaseUI) r13.getParent();
        goto L17
    L20:
        r11 = r13;
    L31:
        if ("screen".equals(r12) == true) goto L33;
        if (r11 == null) goto L38;
        return f(r5, r11, new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight()));
    L38:
        return d(r5, new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight()));
    L33:
        return o(r5, new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight()));
    L23:
        if (r5.getLynxContext() != null) goto L26;
        LynxLog.b(4, "LynxUIHelper", "getRelativeUI failed since context is null");
        goto L31
    L26:
        if (((n0) r5.getLynxContext().f10147o.get()) != null) goto L28;
        LynxLog.b(4, "LynxUIHelper", "getRelativeUI failed since uiowner is null");
        goto L31
    L28:
        r11 = ((n0) r5.getLynxContext().f10147o.get()).E(r12);
    L29:
        LynxLog.b(4, "LynxUIHelper", "getRelativeUI failed since ui or relativeID is null");
        goto L31
    L8:
        if (r10.getString("relativeTo") == null) goto L11;
        r12 = r10.getString("relativeTo");
    L40:
        return new RectF(r5.getBoundingClientRect());
    }

    public static RectF f(LynxBaseUI r10, LynxBaseUI r11, RectF r12) {
        if (r10 != null) goto L6;
        LynxLog.b(4, "LynxUIHelper", "convertRectFromUIToRootUI failed since descendant is null");
        return r12;
    L6:
        if (r11 != null) goto L9;
        LynxLog.b(4, "LynxUIHelper", "convertRectFromUIToRootUI failed since another ui is null");
        return r12;
    L9:
        if (r10 != r11) goto L11;
        return r12;
    L11:
        RectF r5 = new RectF(r12.left, r12.top, r12.right, r12.bottom);
        if (r10.isFlatten() == false) goto L18;
        r5.left += r10.getLeft();
        r5.top += r10.getTop();
        if (r10.getDrawParent() != null) goto L17;
        LynxLog.b(4, "LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
        return r12;
    L17:
        View r13 = ((LynxUI) r10.getDrawParent()).getView();
        r5.left -= r13.getScrollX();
        r5.top -= r13.getScrollY();
        r5.right = r12.width() + r5.left;
        r5.bottom = r12.height() + r5.top;
    L19:
        float r14 = 0.0f;
        if (r11.isFlatten() == false) goto L26;
        float r15 = r11.getLeft() + 0.0f;
        float r16 = r11.getTop() + 0.0f;
        if (r11.getDrawParent() != null) goto L25;
        LynxLog.b(4, "LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
        return r12;
    L25:
        View r17 = ((LynxUI) r11.getDrawParent()).getView();
        r14 = r15 - r17.getScrollX();
        float r18 = r16 - r17.getScrollY();
    L27:
        if (r13 == null) goto L39;
        if (r17 == null) goto L39;
        if (r13 != r17) goto L33;
    L40:
        r5.offset(-r14, -r18);
        return r5;
    L33:
        if (p.k(r13, r17) == false) goto L36;
        r5 = p.b(r13, r17, r5);
        goto L40
    L36:
        if (p.k(r17, r13) == false) goto L38;
        r5 = p.n(r13, r17, r5);
        goto L40
    L38:
        r5 = p.b(r17.getRootView(), r17, p.n(r13, r13.getRootView(), r5));
    L39:
        LynxLog.b(4, "ViewHelper", "convertRectFromViewToAnother failed since view or another is null");
        goto L40
    L26:
        r17 = ((LynxUI) r11).getView();
        r18 = 0.0f;
        goto L27
    L18:
        r13 = ((LynxUI) r10).getView();
        goto L19
    }

    public static Object g(String r10, String r11, ContinuationImpl r12) {
        if (r10.length() != 0) goto L6;
    L7:
        String r13 = j0.l("url: ", r10, ", path: ", r11, " ===> The download url and path are empty");
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r14 = c.f2846a;
        if (r14 == null) goto L11;
        r14.e("AIPackageManager", r13);
    L11:
        return Boxing.boxBoolean(false);
    L6:
        if (r11.length() == 0) goto L7;
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r12));
        String r15 = j0.l("url: ", r10, ", path: ", r11, " ===> Start downloading");
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r16 = c.f2846a;
        if (r16 == null) goto L15;
        r16.d("AIPackageManager", r15);
    L15:
        w r17 = new w(r10, r11, r5);
        String r18 = StringsKt.U(r10, '/');
        Downloader.b(s0.c.a());
        DownloadTask r19 = new DownloadTask();
        DownloadInfo.Builder r20 = r19.f15884k;
        r20.f15853c = r10;
        r20.f15851a = r18;
        r20.d = r11;
        com.bytedance.ai.resource.a r21 = new com.bytedance.ai.resource.a(r17);
        DownloadTask r22 = r19.c(r21.hashCode(), r21);
        r22.d();
        StringBuilder r23 = e.b("start download:  ", r10, "， download id: ");
        r23.append(r22.e());
        String r24 = r23.toString();
        Intrinsics.checkNotNullParameter("AIDownloadManager", "tag");
        d r25 = c.f2846a;
        if (r25 == null) goto L18;
        r25.i("AIDownloadManager", r24);
    L18:
        Object r26 = r5.getOrThrow();
        if (r26 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L21:
        return r26;
    }

    public static String h(Exception r5, StringBuilder r10, String r11) {
        r10.append(ExceptionsKt.stackTraceToString(r5));
        String r12 = r10.toString();
        Intrinsics.checkNotNullParameter(r11, "tag");
        return r12;
    }

    public static String i(String r5) {
        if (r5 == null) goto L13;
    L7:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXMonitor", "clearUrlQuery failed, error: " + e.toString());
        return "unknown";
    L4:
        if (r5.isEmpty() == true) goto L14;
        return Uri.parse(r5).buildUpon().clearQuery().build().toString();
    L14:
        return "unknown";
    L13:
        return "unknown";
    }

    public static JSONObject j() {
        if (f17477c != null) goto L11;
        String r5 = Settings.Global.getString(n.f4057a.getContentResolver(), "bytest_automation_info");     // Catch: Throwable -> L9
        if (r5 == null) goto L7;
        f17477c = new JSONObject(r5);     // Catch: Throwable -> L9
    L12:
        goto L11
    L7:
        f17477c = new JSONObject();     // Catch: Throwable -> L9
    L9:
        f17477c = new JSONObject();
    L11:
        return f17477c;
    }

    public static void k() {
        Lazy r5 = com.bytedance.ies.argus.repository.a.d;
        com.bytedance.ies.argus.repository.a r10 = o.c();
        r10.getClass();
        int r11 = com.bytedance.sdk.xbridge.cn.auth.e.a("");
        if (r10.f5133c != r11) goto L5;
        return;
    L5:
        r10.f5133c = r11;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = com.bytedance.sdk.xbridge.cn.auth.e.f().entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        li.a r16 = (li.a) r14.getValue();
        if (r16.f19633a != AuthConfigType.f7306c) goto L7;
        r12.put(r15, r16.f19635c.f19671a);
        goto L7
    L11:
        JSONObject r17 = new JSONObject();
        Iterator r18 = r12.entrySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        Map.Entry r19 = (Map.Entry) r18.next();
        r17.put((String) r19.getKey(), (String) r19.getValue());
        goto L13
    L15:
        String r20 = r17.toString();
        LynxSecurityService.Companion.getClass();
        ((LynxSecurityService) LynxSecurityService.access$getINSTANCE$delegate$cp().getValue()).updateRSAPublicKeys(r20);
        StringBuilder r21 = new StringBuilder("update public keys success, package version: ");
        r21.append(r11);
        r21.append(", keys length: ");
        r21.append(r20.length());
        r21.append(", config from: ");
        String r22 = com.bytedance.sdk.xbridge.cn.auth.e.g;
        if (r22 != null) goto L18;
        r22 = "unknown";
    L18:
        r21.append(r22);
        k5.d.i("ArgusConfigManager", r21.toString());
    }

    public static void l(String r10, Object r11, AnnieXLynxView r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r12, "lynxView");
        Intrinsics.checkNotNullParameter(r13, "bid");
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        TemplateData r5 = null;
        String r15 = null;
        r15 = null;
        r5 = null;
        if (Intrinsics.areEqual(r10, "__updateData") == false) goto L24;
        if (r11 != null) goto L6;
    L20:
        if (r15 == null) goto L72;
        r12.updateData(r15);
        return;
    L72:
        return;
    L6:
        if ((r11 instanceof CharSequence) == false) goto L9;
        r15 = String.valueOf(r11);
        goto L20
    L9:
        if ((r11 instanceof JSONObject) == false) goto L12;
        r15 = String.valueOf(((JSONObject) r11).put("bullet_update_type", 1));
        goto L20
    L12:
        if ((r11 instanceof JSONArray) == false) goto L15;
        r15 = String.valueOf(r11);
        goto L20
    L15:
        if ((r11 instanceof ReadableMap) == false) goto L18;
        r15 = String.valueOf(b.m((ReadableMap) r11).put("bullet_update_type", 1));
        goto L20
    L18:
        if ((r11 instanceof ReadableArray) == false) goto L20;
        r15 = String.valueOf(b.l((ReadableArray) r11));
        goto L20
    L24:
        if (Intrinsics.areEqual("__updateTemplateData", r10) == false) goto L39;
        if (r11 != null) goto L27;
    L35:
        if (r5 == null) goto L37;
        r5.i("bullet_update_type", 1);
    L37:
        r12.updateData(r5);
        return;
    L27:
        if ((r11 instanceof ae.a) == false) goto L35;
        ae.a r16 = (ae.a) r11;
        String r17 = r16.f161b;
        if (r17 == null) goto L34;
        r5 = TemplateData.b(r17);
        Iterator r18 = r16.f160a.entrySet().iterator();
    L32:
        if (r18.hasNext() == false) goto L35;
        Map.Entry r19 = (Map.Entry) r18.next();
        r5.i((String) r19.getKey(), r19.getValue());
        goto L32
    L34:
        r5 = TemplateData.c(r16.f160a);
        goto L35
    L39:
        JavaOnlyArray r20 = new JavaOnlyArray();
        JSONObject r21 = new JSONObject();
        if (r11 != null) goto L42;
    L57:
        lc.a r22 = new lc.a(r14);
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "data");
        r21.put("containerID", r14);
        r21.put("protocolVersion", "1.0");
        if (Intrinsics.areEqual(r13, "webcast") == false) goto L69;
        r21.put("code", 1);
    L69:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L62
        r20.pushMap(b.e(r21));     // Catch: Throwable -> L62
        Object r24 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L64:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);
        if (r25 == null) goto L67;
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("EventHelper", "error===>" + r25.getMessage(), null, 12);
    L67:
        Unit r27 = Unit.INSTANCE;
        com.bytedance.android.anniex.utils.e.e(r12, r10, r20);
        return;
    L62:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L64
    L42:
        if ((r11 instanceof CharSequence) == false) goto L44;
        boolean r29 = true;
    L45:
        if (r29 == false) goto L47;
        boolean r30 = true;
    L48:
        if (r30 == false) goto L51;
        r21.put("data", r11);
        goto L57
    L51:
        if ((r11 instanceof ReadableMap) == false) goto L54;
        r21.put("data", b.m((ReadableMap) r11));
        goto L57
    L54:
        if ((r11 instanceof ReadableArray) == false) goto L56;
        r21.put("data", b.l((ReadableArray) r11));
        goto L57
    L56:
        r21.put("data", new JSONObject());
        goto L57
    L47:
        r30 = r11 instanceof JSONArray;
        goto L48
    L44:
        r29 = r11 instanceof JSONObject;
        goto L45
    }

    public static void m(JSONObject r5) {
        if (r5 == null) goto L25;
        j();     // Catch: Throwable -> L18
        JSONObject r10 = f17477c;     // Catch: Throwable -> L18
        if (r10 == null) goto L23;
        JSONObject r11 = r10.optJSONObject("slardar_filter");     // Catch: Throwable -> L18
        if (mh.e.n(r11) == true) goto L24;
        JSONObject r12 = r5.optJSONObject("filters");     // Catch: Throwable -> L18
        if (r12 != null) goto L15;
        r12 = new JSONObject();     // Catch: Throwable -> L18
        r5.put("filters", r12);     // Catch: JSONException -> L17 Throwable -> L18
    L15:
        z8.c.n(r12, r11);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L26:
        return;
    }

    public static int n(Context r5) {
        int r10 = f17476b;
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        if (r5 != null) goto L8;
        return 0;
    L8:
        p(r5);
        int r11 = f17476b;
        if (r11 <= 0) goto L11;
        return r11;
    L11:
        return 0;
    }

    public static RectF o(LynxBaseUI r10, RectF r11) {
        if (r10 != null) goto L6;
        LynxLog.b(4, "LynxUIHelper", "convertRectFromUIToScreen failed since ancestor or descendant is null");
        return r11;
    L6:
        RectF r5 = new RectF(r11.left, r11.top, r11.right, r11.bottom);
        if (r10.isFlatten() == false) goto L13;
        r5.left += r10.getLeft();
        r5.top += r10.getTop();
        if (r10.getDrawParent() != null) goto L12;
        LynxLog.b(4, "LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToScreen returns is not the correct coordinates relative to the screen!");
        return r11;
    L12:
        View r12 = ((LynxUI) r10.getDrawParent()).getView();
        r5.left -= r12.getScrollX();
        r5.top -= r12.getScrollY();
        r5.right = r11.width() + r5.left;
        r5.bottom = r11.height() + r5.top;
    L15:
        return p.n(r12, r12.getRootView(), r5);
    L13:
        r12 = ((LynxUI) r10).getView();
        goto L15
    }

    public static void p(Context r5) {
        Object r10 = r5.getSystemService("window");     // Catch: Exception -> L14
        if ((r10 instanceof WindowManager) == false) goto L5;
        WindowManager r11 = (WindowManager) r10;     // Catch: Exception -> L14
    L6:
        if (r11 == null) goto L12;
        Display r12 = r11.getDefaultDisplay();     // Catch: Exception -> L14
        Point r13 = new Point();     // Catch: Exception -> L14
        if (r12 == null) goto L16;
        r12.getRealSize(r13);     // Catch: Exception -> L14
        f17475a = r13.y;     // Catch: Exception -> L14
        f17476b = r13.x;     // Catch: Exception -> L14
        return;
    L16:
        return;
    L12:
        DisplayMetrics r14 = r5.getResources().getDisplayMetrics();     // Catch: Exception -> L14
        f17475a = r14.heightPixels;     // Catch: Exception -> L14
        f17476b = r14.widthPixels;     // Catch: Exception -> L14
        return;
    L5:
        r11 = null;
        goto L6
    }
}
