package com.bytedance.android.monitorV2.jsworker;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Keep;
import b5.a;
import com.bytedance.android.monitorV2.h;
import com.bytedance.android.monitorV2.lynx.d;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.b;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x4.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001'B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0018\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/monitorV2/jsworker/JsWorkerModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "Landroid/content/Context;", "ctx", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "", "code", "", "msg", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "callbackResponse", "(ILjava/lang/String;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "Lorg/json/JSONObject;", "event", "", "reportInternally", "(Lorg/json/JSONObject;)V", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "data", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "callback", "customReport", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Lcom/bytedance/vmsdk/jsbridge/utils/Callback;)V", "Landroid/view/View;", "view", "onAttachView", "(Landroid/view/View;)V", "fireAllEvents", "()V", "Ljava/util/Queue;", "mPendingEvents", "Ljava/util/Queue;", "Ljava/lang/ref/WeakReference;", "mViewRef", "Ljava/lang/ref/WeakReference;", "Companion", "b5/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class JsWorkerModule extends JSModule {
    public static final a Companion = null;
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final int FAIL = -1;
    public static final String NAME = "hybridMonitor";
    public static final int SUCCESS = 0;
    public static final String TAG = "JsWorkerModule";
    private final Queue<JSONObject> mPendingEvents;
    private WeakReference<View> mViewRef;

    static {
        Companion = new a();
    }

    public JsWorkerModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        super(r5, r10);
        this.mPendingEvents = new LinkedList();
    }

    private final JavaOnlyMap callbackResponse(int r5, String r10) {
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putInt("errorCode", r5);
        r11.putString("errorMessage", r10);
        return r11;
    }

    private final void reportInternally(JSONObject r10) {
        if (r10 == null) goto L28;
        String r5 = r10.optString("eventName", "");
        JSONObject r11 = r10.optJSONObject(LynxMonitorService.KEY_METRICS);
        JSONObject r12 = r10.optJSONObject("category");
        int r13 = r10.optInt("level", -1);
        String r14 = r10.optString("bid", "");
        if (Intrinsics.areEqual(r5, "") == true) goto L29;
        l r15 = new l(r5, 1);
        if (r11 == null) goto L8;
        r15.f6293i = r11;
    L8:
        if (r12 == null) goto L10;
        r15.f6293i = r12;
    L10:
        if (r13 == (-1)) goto L13;
        r15.b(r13);
    L13:
        if (Intrinsics.areEqual(r14, "") == true) goto L15;
        r15.f6291c = r14;
    L15:
        WeakReference<View> r16 = this.mViewRef;
        if (r16 == null) goto L18;
        View r17 = r16.get();
    L19:
        if (r17 != null) goto L23;
        h r18 = h.e();
        c r19 = r15.a();
        r18.getClass();
        h.d(r19);
        return;
    L23:
        if ((r17 instanceof LynxView) == false) goto L26;
        d r20 = d.f3638a;
        c r21 = r15.a();
        r20.getClass();
        d.g((LynxView) r17, r21);
        return;
    L26:
        boolean r22 = r17 instanceof WebView;
        return;
    L18:
        r17 = null;
        goto L19
    L29:
        return;
    }

    @Keep
    @b
    public final void customReport(ReadableMap r5, Callback r10) {
        if (r5 == null) goto L4;
        HashMap<String, Object> r11 = r5.toHashMap();
    L5:
        if (r11 == null) goto L13;
        JSONObject r12 = new JSONObject(r11);
        if (this.mViewRef == null) goto L9;
        reportInternally(r12);
    L10:
        if (r10 == null) goto L16;
        r10.invoke(new Object[]{callbackResponse(0, "success")});
        return;
    L16:
        return;
    L9:
        this.mPendingEvents.add(r12);
        goto L10
    L13:
        if (r10 == null) goto L17;
        r10.invoke(new Object[]{callbackResponse(-1, "bad parameters")});
        return;
    L17:
        return;
    L4:
        r11 = null;
        goto L5
    }

    public final synchronized void fireAllEvents() {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mPendingEvents.isEmpty() == true) goto L9;
        reportInternally(this.mPendingEvents.poll());     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }

    public final void onAttachView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.mViewRef = new WeakReference(r5);
        fireAllEvents();
    }
}
