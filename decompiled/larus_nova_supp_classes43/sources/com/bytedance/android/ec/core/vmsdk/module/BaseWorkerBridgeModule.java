package com.bytedance.android.ec.core.vmsdk.module;

import android.content.Context;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002>?B\u0017\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\u000f\u001a\u00020\u0006*\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u0003*\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0006H\u0004J\u001f\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\fH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\nJ\u0011\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0001J\t\u0010\u001f\u001a\u00020\nH\u0096\u0001J\t\u0010!\u001a\u00020 H\u0096\u0001J\u0011\u0010\"\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0001R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00178\u0004X\u0084\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R&\u00103\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000202018\u0004X\u0084\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006@"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/module/BaseWorkerBridgeModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "Lcom/bytedance/android/ec/core/async/b;", "Lorg/json/JSONArray;", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableArray;", "toWritableArray", "Lorg/json/JSONObject;", "data", "Lcom/bytedance/ies/web/jsbridge2/c0;", "call", "", "invokeCallback", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "toJSONObject$ec_core_saasRelease", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)Lorg/json/JSONObject;", "toJSONObject", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;", "toJSONArray$ec_core_saasRelease", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;)Lorg/json/JSONArray;", "toJSONArray", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "toWritableMap", "", "", "toStringMap$ec_core_saasRelease", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)Ljava/util/Map;", "toStringMap", "release", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "Lai/b;", "workerBridgeImpl", "Lai/b;", "getWorkerBridgeImpl", "()Lai/b;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/core/event/EventActionImpl;", "eventAction", "Lcom/bytedance/android/ec/core/event/EventActionImpl;", "getEventAction", "()Lcom/bytedance/android/ec/core/event/EventActionImpl;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "callbackRegistry", "Ljava/util/concurrent/ConcurrentHashMap;", "getCallbackRegistry", "()Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/content/Context;", "context", "", "params", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Companion", "a", "b", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseWorkerBridgeModule extends JSModule implements com.bytedance.android.ec.core.async.b {
    public static final a Companion = null;
    public static final String NAME = "bridge";
    private final /* synthetic */ DisposableScope $$delegate_0;
    private final ConcurrentHashMap<c0, Callback> callbackRegistry;
    private final EventActionImpl eventAction;
    private final String name;
    private final ai.b workerBridgeImpl;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final ai.b a;
        public final String b;

        public b(ai.b r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            this.a = r10;
            this.b = r11;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public Disposable add(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "disposable");
        this.$$delegate_0.add(r10);
        return r10;
    }

    @Override // com.bytedance.android.ec.core.async.b
    public void clearDisposable() {
        this.$$delegate_0.clearDisposable();
    }

    public void invokeCallback(JSONObject r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "call");
    }

    @Override // com.bytedance.android.ec.core.async.b
    public void remove(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "disposable");
        this.$$delegate_0.remove(r10);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public CompositeDisposable compositeDisposable() {
        return this.$$delegate_0.a();
    }

    public final ConcurrentHashMap<c0, Callback> getCallbackRegistry() {
        return this.callbackRegistry;
    }

    public final EventActionImpl getEventAction() {
        return this.eventAction;
    }

    public final String getName() {
        return this.name;
    }

    public final ai.b getWorkerBridgeImpl() {
        return this.workerBridgeImpl;
    }

    public final void release() {
        clearDisposable();
    }

    private final WritableArray toWritableArray(JSONArray r10) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L39;
        Object r12 = r10.opt(r11);
        if ((r12 instanceof Float) == false) goto L7;
    L37:
        r0.pushDouble(JSONArrayProtectorUtils.getDouble(r10, r11));
    L38:
        r11 = r11 + 1;
        goto L3
    L7:
        if ((r12 instanceof Double) == true) goto L37;
        if ((r12 instanceof Long) == false) goto L18;
        long r13 = JSONArrayProtectorUtils.getLong(r10, r11);
        if (r13 <= Integer.MAX_VALUE) goto L14;
    L16:
        r0.pushString(String.valueOf(r13));
        goto L38
    L14:
        if (r13 < Integer.MIN_VALUE) goto L16;
        r0.pushInt((int) r13);
        goto L38
    L18:
        if ((r12 instanceof Number) == false) goto L21;
        r0.pushInt(JSONArrayProtectorUtils.getInt(r10, r11));
        goto L38
    L21:
        if ((r12 instanceof String) == false) goto L24;
        r0.pushString(JSONArrayProtectorUtils.getString(r10, r11));
        goto L38
    L24:
        if ((r12 instanceof Boolean) == false) goto L27;
        r0.pushBoolean(JSONArrayProtectorUtils.getBoolean(r10, r11));
        goto L38
    L27:
        if ((r12 instanceof JSONObject) == false) goto L30;
        r0.pushMap(toWritableMap(JSONArrayProtectorUtils.getJSONObject(r10, r11)));
        goto L38
    L30:
        if ((r12 instanceof JSONArray) == false) goto L33;
        r0.pushArray(toWritableArray(JSONArrayProtectorUtils.getJSONArray(r10, r11)));
        goto L38
    L33:
        if (Intrinsics.areEqual(r12, JSONObject.NULL) == false) goto L36;
        r0.pushNull();
        goto L38
    L36:
        throw new IllegalStateException(("Failed to convert value " + r12 + " of type " + r12.getClass()).toString());
    L39:
        return r0;
    }

    public final JSONArray toJSONArray$ec_core_saasRelease(ReadableArray r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toJSONArray");
        JSONArray r0 = new JSONArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L19;
        ReadableType r12 = r10.getType(r11);
        if (r12 == null) goto L18;
        switch(bi.a.b[r12.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L18;
        };
    L9:
        r0.put(JSONObject.NULL);
    L16:
        r11 = r11 + 1;
        goto L3
    L10:
        r0.put(toJSONArray$ec_core_saasRelease(r10.getArray(r11)));
        goto L16
    L11:
        r0.put(toJSONObject$ec_core_saasRelease(r10.getMap(r11)));
        goto L16
    L12:
        r0.put(r10.getString(r11));
        goto L16
    L13:
        r0.put(r10.getDouble(r11));
        goto L16
    L14:
        r0.put(r10.getLong(r11));
        goto L16
    L15:
        r0.put(r10.getBoolean(r11));
    L18:
        throw new IllegalStateException(("Failed to convert type in ReadableMap: " + r12).toString());
    L19:
        return r0;
    }

    public final JSONObject toJSONObject$ec_core_saasRelease(ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toJSONObject");
        JSONObject r0 = new JSONObject();
        ReadableMapKeySetIterator r1 = r10.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L19;
        String r11 = r1.nextKey();
        ReadableType r12 = r10.getType(r11);
        if (r12 == null) goto L18;
        switch(bi.a.a[r12.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L18;
        };
    L11:
        r0.put(r11, toJSONArray$ec_core_saasRelease(r10.getArray(r11)));
        goto L4
    L12:
        r0.put(r11, toJSONObject$ec_core_saasRelease(r10.getMap(r11)));
        goto L4
    L13:
        r0.put(r11, r10.getString(r11));
        goto L4
    L14:
        r0.put(r11, r10.getDouble(r11));
        goto L4
    L15:
        r0.put(r11, r10.getLong(r11));
        goto L4
    L16:
        r0.put(r11, r10.getBoolean(r11));
        goto L4
    L10:
        r0.put(r11, JSONObject.NULL);
    L18:
        throw new IllegalStateException(("Failed to convert type in ReadableMap: " + r12).toString());
    L19:
        return r0;
    }

    public final Map<String, String> toStringMap$ec_core_saasRelease(ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toStringMap");
        HashMap r0 = new HashMap();
        ReadableMapKeySetIterator r1 = r10.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L19;
        String r11 = r1.nextKey();
        ReadableType r12 = r10.getType(r11);
        if (r12 == null) goto L18;
        switch(bi.a.c[r12.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L18;
        };
    L11:
        r0.put(r11, toJSONArray$ec_core_saasRelease(r10.getArray(r11)).toString());
        goto L4
    L12:
        r0.put(r11, toJSONObject$ec_core_saasRelease(r10.getMap(r11)).toString());
        goto L4
    L13:
        r0.put(r11, r10.getString(r11).toString());
        goto L4
    L14:
        r0.put(r11, String.valueOf(r10.getDouble(r11)));
        goto L4
    L15:
        r0.put(r11, String.valueOf(r10.getLong(r11)));
        goto L4
    L16:
        r0.put(r11, String.valueOf(r10.getBoolean(r11)));
        goto L4
    L10:
        r0.put(r11, JSONObject.NULL.toString());
    L18:
        throw new IllegalStateException(("Failed to convert type in ReadableMap: " + r12).toString());
    L19:
        return r0;
    }

    public final WritableMap toWritableMap(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toWritableMap");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<String> r1 = r10.keys();
    L46:
    L43:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L45:
        return r0;
    L4:
        if (r1.hasNext() == false) goto L45;
        String r11 = r1.next();     // Catch: Exception -> L43
        if (r11 == null) goto L42;
        String r12 = r11;     // Catch: Exception -> L43
        Object r13 = r10.opt(r12);     // Catch: Exception -> L43
        if ((r13 instanceof Float) == true) goto L40;
        if ((r13 instanceof Double) == true) goto L40;
        if ((r13 instanceof Long) == true) goto L14;
        if ((r13 instanceof Number) == true) goto L22;
        if ((r13 instanceof String) == true) goto L25;
        if ((r13 instanceof Boolean) == true) goto L28;
        if ((r13 instanceof JSONObject) == true) goto L31;
        if ((r13 instanceof JSONArray) == true) goto L34;
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == false) goto L39;
        r0.putNull(r12);     // Catch: Exception -> L43
        goto L46
    L39:
        throw new IllegalStateException(("Failed to convert value " + r13 + " of type " + r13.getClass()).toString());     // Catch: Exception -> L43
    L34:
        r0.putArray(r12, toWritableArray(JSONObjectProtectorUtils.getJSONArray(r10, r12)));     // Catch: Exception -> L43
        goto L46
    L31:
        r0.putMap(r12, toWritableMap(JSONObjectProtectorUtils.getJSONObject(r10, r12)));     // Catch: Exception -> L43
        goto L46
    L28:
        r0.putBoolean(r12, JSONObjectProtectorUtils.getBoolean(r10, r12));     // Catch: Exception -> L43
        goto L46
    L25:
        r0.putString(r12, JSONObjectProtectorUtils.getString(r10, r12));     // Catch: Exception -> L43
        goto L46
    L22:
        r0.putInt(r12, JSONObjectProtectorUtils.getInt(r10, r12));     // Catch: Exception -> L43
        goto L46
    L14:
        long r14 = JSONObjectProtectorUtils.getLong(r10, r12);     // Catch: Exception -> L43
        if (r14 > Integer.MAX_VALUE) goto L19;
        if (r14 < Integer.MIN_VALUE) goto L19;
        r0.putInt(r12, (int) r14);     // Catch: Exception -> L43
    L19:
        r0.putString(r12, String.valueOf(r14));     // Catch: Exception -> L43
    L40:
        r0.putDouble(r12, JSONObjectProtectorUtils.getDouble(r10, r12));     // Catch: Exception -> L43
        goto L46
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L43
    }

    public BaseWorkerBridgeModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "params");
        super(r10);
        this.$$delegate_0 = new DisposableScope();
        this.eventAction = new EventActionImpl();
        this.callbackRegistry = new ConcurrentHashMap();
        b r12 = (b) r11;
        ai.b r13 = r12.a;
        if (r13 == null) goto L5;
        r13.n.add(this);
        Unit r0 = Unit.INSTANCE;
    L6:
        this.workerBridgeImpl = r13;
        this.name = r12.b;
        return;
    L5:
        r13 = null;
        goto L6
    }
}
