package com.bytedance.android.monitorV2.lynx.jsb;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.lynx.impl.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.n;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import d5.b;
import g5.d;
import h5.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import mn.h;
import oo.j;
import org.json.JSONObject;
import x4.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0017J#\u0010\u0019\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0019\u0010\u0017J#\u0010\u001a\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewMonitorModule;", "Lcom/lynx/jsbridge/LynxModule;", "Landroid/content/Context;", "context", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Lcom/lynx/react/bridge/ReadableMap;", "dataMap", "", "getCanSample", "(Lcom/lynx/react/bridge/ReadableMap;)I", "Lg5/d;", "getError", "(Lcom/lynx/react/bridge/ReadableMap;)Lg5/d;", "Lorg/json/JSONObject;", "convertJson", "(Lcom/lynx/react/bridge/ReadableMap;)Lorg/json/JSONObject;", "Lcom/lynx/react/bridge/Callback;", "callback", "", "config", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "reportJSError", "customReport", "getInfo", "Companion", "h5/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nLynxViewMonitorModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LynxViewMonitorModule.kt\ncom/bytedance/android/monitorV2/lynx/jsb/LynxViewMonitorModule\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,231:1\n1#2:232\n*E\n"})
public final class LynxViewMonitorModule extends LynxModule {
    public static final a Companion = null;
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final int FAIL = -1;
    public static final String NAME = "hybridMonitor";
    public static final int SUCCESS = 0;
    public static final String TAG = "LynxViewMonitorModule";

    static {
        Companion = new a();
    }

    public LynxViewMonitorModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "param");
        super(r5, r10);
    }

    private final JSONObject convertJson(ReadableMap r5) {
        if (r5 != null) goto L10;
        return null;
    L10:
        return new JSONObject(r5.toHashMap());
    L7:
        th = move-exception;
        h.g("default_handle", th);
        return null;
    }

    private final int getCanSample(ReadableMap r10) {
        int r5 = r10.getInt("level", 2);
        int r11 = r10.getInt("canSample", 1);
        boolean r12 = r10.getBoolean("canSample", true);
        if (r10.hasKey("level") == false) goto L6;
        return r5;
    L6:
        if (r10.hasKey("canSample") == false) goto L13;
        if (r11 == 0) goto L11;
        if (r12 == false) goto L14;
        return 2;
    L14:
        return 0;
    L11:
        return 0;
    L13:
        return 2;
    }

    private final d getError(ReadableMap r5) {
        d r10 = new d();
        r10.f17056b = "lynx_error_custom";     // Catch: Exception -> L5
        r10.f17057c = 201;     // Catch: Exception -> L5
        r10.d = String.valueOf(convertJson(r5));     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        h.g("default_handle", e);
        return r10;
    }

    @n
    @Keep
    public final void config(ReadableMap r5, Callback r10) {
        b.f(TAG, "config");
        if (this.mParam == null) goto L24;
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putInt("errorCode", -1);
        Object r12 = this.mParam;
        if ((r12 instanceof h5.b) == false) goto L20;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider");
        LynxView r13 = ((h5.b) r12).f17282a;
        if (r13 == null) goto L20;
        JSONObject r14 = j.f(convertJson(r5));
        e r15 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k.a(r13, null).e;
        if (r15 == null) goto L20;
        Intrinsics.checkNotNullParameter("jsBase", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r14, "value");
        if (Intrinsics.areEqual("jsBase", "jsBase") == true) goto L14;
    L19:
        r11.putInt("errorCode", 0);
        goto L20
    L14:
        if (StringsKt.isBlank(r15.f) == false) goto L16;
        r15.f = r14.optString("bid");
    L16:
        r15.f3693h = qo.a.q(r15.f3693h, r14);
        if (StringsKt.isBlank(r15.f) == true) goto L19;
        String r16 = com.bytedance.android.monitorV2.exception.b.f3568a;
        com.bytedance.android.monitorV2.exception.b.a(r15.f3696k, r15.f);
    L20:
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{r11});
        return;
    L23:
        return;
    }

    @n
    @Keep
    public final void customReport(ReadableMap r13, Callback r14) {
        b.f(TAG, "customReport");
        if (r13 != null) goto L5;
        return;
    L5:
        if (this.mParam == null) goto L24;
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.putInt("errorCode", -1);
        Object r10 = this.mParam;
        if ((r10 instanceof h5.b) == false) goto L16;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider");
        LynxView r11 = ((h5.b) r10).f17282a;
        if (r11 != null) goto L20;
        r5.putString("errorMessage", "view is empty.");
    L17:
        if (r14 == null) goto L23;
        r14.invoke(new Object[]{r5});
        return;
    L23:
        return;
    L20:
        String r12 = r13.getString("eventName", "");     // Catch: Exception -> L13
        ReadableMap r15 = r13.getMap("category");     // Catch: Exception -> L13
        ReadableMap r16 = r13.getMap(LynxMonitorService.KEY_METRICS);     // Catch: Exception -> L13
        ReadableMap r17 = r13.getMap("timing");     // Catch: Exception -> L13
        ReadableMap r18 = r13.getMap("extra");     // Catch: Exception -> L13
        String r19 = r13.getString("bid");     // Catch: Exception -> L13
        int r110 = getCanSample(r13);     // Catch: Exception -> L13
        l r111 = new l(r12, 1);     // Catch: Exception -> L13
        r111.f6291c = r19;     // Catch: Exception -> L13
        r111.f6290b = r11.getTemplateUrl();     // Catch: Exception -> L13
        r111.f6292h = convertJson(r15);     // Catch: Exception -> L13
        r111.f6293i = convertJson(r16);     // Catch: Exception -> L13
        r111.f6294j = convertJson(r18);     // Catch: Exception -> L13
        r111.f6295k = convertJson(r17);     // Catch: Exception -> L13
        r111.b(r110);     // Catch: Exception -> L13
        c r112 = r111.a();     // Catch: Exception -> L13
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();     // Catch: Exception -> L13
        com.bytedance.android.monitorV2.lynx.d.g(r11, r112);     // Catch: Exception -> L13
        r5.putInt("errorCode", 0);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r5.putString("errorMessage", "cause: " + e.getMessage());
        h.g("default_handle", e);
        goto L17
    L16:
        r5.putString("errorMessage", "mParam is not LynxViewProvider.");
        goto L17
    }

    @n
    @Keep
    public final void getInfo(ReadableMap r5, Callback r10) {
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putString(WsConstants.KEY_SDK_VERSION, "9.0.0");
        if (r10 == null) goto L6;
        r10.invoke(new Object[]{r11});
        return;
    }

    @n
    @Keep
    public final void reportJSError(ReadableMap r10, Callback r11) {
        b.f(TAG, "reportJSError");
        Intrinsics.checkNotNullParameter("js_exception", "eventType");
        com.bytedance.android.monitorV2.event.a r5 = j.c("js_exception", null, null);
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        HybridEvent$TerminateType r13 = HybridEvent$TerminateType.f3541b;
        r5.d(r12, r13);
        if (r12 == true) goto L23;
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.putInt("errorCode", -1);
        Object r15 = this.mParam;
        if ((r15 instanceof h5.b) == false) goto L18;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider");
        LynxView r16 = ((h5.b) r15).f17282a;
        if (r16 == null) goto L17;
        d r17 = getError(r10);
        r5.f3550m = r17;
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        com.bytedance.android.monitorV2.lynx.d.d(r16, r17, r5);
        r14.putInt("errorCode", 0);
    L19:
        if (r11 == null) goto L22;
        r11.invoke(new Object[]{r14});
        return;
    L22:
        return;
    L17:
        r5.b(r13);
        goto L19
    L18:
        r5.b(r13);
        goto L19
    L23:
        return;
    L5:
        if (this.mParam == null) goto L8;
        r12 = false;
        goto L9
    }
}
