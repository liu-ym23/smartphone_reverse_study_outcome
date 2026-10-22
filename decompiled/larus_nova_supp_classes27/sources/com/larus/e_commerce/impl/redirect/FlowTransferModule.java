package com.larus.e_commerce.impl.redirect;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.host.impl.i;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import v89.c;
import v89.d;
import v89.e;
import v89.f;
import v89.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'H\u0007J\u001a\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0012\u0010/\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\nH\u0007J\u000e\u00102\u001a\u000203*\u0004\u0018\u00010\nH\u0002J\u0018\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n05*\u00020'H\u0002J\f\u00106\u001a\u000207*\u00020'H\u0002J\f\u00108\u001a\u000209*\u00020:H\u0002J\f\u0010;\u001a\u00020<*\u000207H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R9\u0010\b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b!\u0010\"¨\u0006>"}, d2 = {"Lcom/larus/e_commerce/impl/redirect/FlowTransferModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAppContext", "()Landroid/content/Context;", "onOpenSchema", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "schema", "", "getOnOpenSchema", "()Lkotlin/jvm/functions/Function1;", "setOnOpenSchema", "(Lkotlin/jvm/functions/Function1;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "netService", "Lcom/bytedance/android/ec/host/impl/ECHostNetService;", "getNetService", "()Lcom/bytedance/android/ec/host/impl/ECHostNetService;", "netService$delegate", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getIoExecutor", "()Ljava/util/concurrent/ExecutorService;", "ioExecutor$delegate", "fetch", "url", "params", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "method", "callback", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "data", "header", "sendLogV3", "eventName", "openSchema", "log", "message", "isHttpUrl", "", "toStringMap", "", "toJSONObject", "Lorg/json/JSONObject;", "toJSONArray", "Lorg/json/JSONArray;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;", "toJavaOnlyMap", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTransferModule extends JSModule {
    public static final a Companion = null;
    public static final String MODULE_NAME = "TransferModule";
    public static final String TAG = "FlowTransferModule";
    private final Context appContext;
    private final Lazy ioExecutor$delegate;
    private final Lazy mainHandler$delegate;
    private final Lazy netService$delegate;
    private Function1<? super String, Unit> onOpenSchema;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ReadableType.Long.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ReadableType.Null.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(FlowTransferModule r0, String r1, String r2, Map r3, Map r4, Map r5, Callback r6) {
        fetch$lambda$6(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void b(FlowTransferModule r0, String r1) {
        openSchema$lambda$9(r0, r1);
    }

    public static /* synthetic */ ExecutorService c() {
        return ioExecutor_delegate$lambda$2();
    }

    public static /* synthetic */ Handler d() {
        return mainHandler_delegate$lambda$0();
    }

    public static /* synthetic */ i e() {
        return netService_delegate$lambda$1();
    }

    private final ExecutorService getIoExecutor() {
        return (ExecutorService) this.ioExecutor$delegate.getValue();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    private final i getNetService() {
        return (i) this.netService$delegate.getValue();
    }

    private static final ExecutorService ioExecutor_delegate$lambda$2() {
        return PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory(TAG));
    }

    private static final Handler mainHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    private static final i netService_delegate$lambda$1() {
        return new i();
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final Function1<String, Unit> getOnOpenSchema() {
        return this.onOpenSchema;
    }

    public FlowTransferModule(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        super(r2);
        this.appContext = r2;
        this.mainHandler$delegate = LazyKt.lazy(new c());
        this.netService$delegate = LazyKt.lazy(new d());
        this.ioExecutor$delegate = LazyKt.lazy(new e());
    }

    private final boolean isHttpUrl(String r5) {
        if (r5 == null) goto L13;
        String r6 = r5.toLowerCase(Locale.US);
        if (r6 != null) goto L8;
        return false;
    L8:
        if (StringsKt.startsWith$default(r6, "http://", false, 2, null) == false) goto L10;
    L11:
        return true;
    L10:
        if (StringsKt.startsWith$default(r6, "https://", false, 2, null) == true) goto L11;
        return false;
    L13:
        return false;
    }

    private final JSONArray toJSONArray(ReadableArray r6) {
        JSONArray r0 = new JSONArray();
        int r1 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        ReadableType r3 = r6.getType(r2);
        if (r3 != null) goto L7;
        int r4 = -1;
    L8:
        switch(r4) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L9;
        };
    L9:
        Unit r5 = Unit.INSTANCE;
    L17:
        r2 = r2 + 1;
        goto L3
    L10:
        r0.put(JSONObject.NULL);
        goto L17
    L11:
        r0.put(toJSONArray(r6.getArray(r2)));
        goto L17
    L12:
        r0.put(toJSONObject(r6.getMap(r2)));
        goto L17
    L13:
        r0.put(r6.getString(r2));
        goto L17
    L14:
        r0.put(r6.getDouble(r2));
        goto L17
    L15:
        r0.put(r6.getLong(r2));
        goto L17
    L16:
        r0.put(r6.getBoolean(r2));
        goto L17
    L7:
        r4 = b.a[r3.ordinal()];
        goto L8
    L18:
        return r0;
    }

    private final JSONObject toJSONObject(ReadableMap r6) {
        JSONObject r0 = new JSONObject();
        ReadableMapKeySetIterator r1 = r6.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L18;
        String r2 = r1.nextKey();
        ReadableType r3 = r6.getType(r2);
        if (r3 != null) goto L8;
        int r4 = -1;
    L9:
        switch(r4) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        r0.put(r2, JSONObject.NULL);
        goto L4
    L12:
        r0.put(r2, toJSONArray(r6.getArray(r2)));
        goto L4
    L13:
        r0.put(r2, toJSONObject(r6.getMap(r2)));
        goto L4
    L14:
        r0.put(r2, r6.getString(r2));
        goto L4
    L15:
        r0.put(r2, r6.getDouble(r2));
        goto L4
    L16:
        r0.put(r2, r6.getLong(r2));
        goto L4
    L17:
        r0.put(r2, r6.getBoolean(r2));
        goto L4
    L10:
        Unit r5 = Unit.INSTANCE;
        goto L4
    L8:
        r4 = b.a[r3.ordinal()];
        goto L9
    L18:
        return r0;
    }

    private final JavaOnlyMap toJavaOnlyMap(JSONObject r5) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, r5.optString(r2));
        goto L4
    L6:
        return r0;
    }

    private final Map<String, String> toStringMap(ReadableMap r6) {
        HashMap r0 = new HashMap();
        ReadableMapKeySetIterator r1 = r6.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L18;
        String r2 = r1.nextKey();
        ReadableType r3 = r6.getType(r2);
        if (r3 != null) goto L8;
        int r4 = -1;
    L9:
        switch(r4) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r0.put(r2, JSONObject.NULL.toString());
        goto L4
    L12:
        r0.put(r2, toJSONArray(r6.getArray(r2)).toString());
        goto L4
    L13:
        r0.put(r2, toJSONObject(r6.getMap(r2)).toString());
        goto L4
    L14:
        r0.put(r2, r6.getString(r2).toString());
        goto L4
    L15:
        r0.put(r2, String.valueOf(r6.getDouble(r2)));
        goto L4
    L16:
        r0.put(r2, String.valueOf(r6.getLong(r2)));
        goto L4
    L17:
        r0.put(r2, String.valueOf(r6.getBoolean(r2)));
        goto L4
    L8:
        r4 = b.a[r3.ordinal()];
        goto L9
    L18:
        return r0;
    }

    @JSMethod
    public final void log(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        FLogger.a.i(TAG, "[JSLog] " + r4);
    }

    @JSMethod
    public final void openSchema(final String r4) {
        FLogger.a.i(TAG, "[openSchema] schema=" + r4);
        getMainHandler().post(new f(this, r4));
    }

    public final void setOnOpenSchema(Function1<? super String, Unit> r1) {
        this.onOpenSchema = r1;
    }

    private static final void openSchema$lambda$9(FlowTransferModule r0, String r1) {
        Function1<? super String, Unit> r2 = r0.onOpenSchema;
        if (r2 == null) goto L6;
        r2.invoke(r1);
        return;
    }

    @JSMethod
    public final void sendLogV3(String r5, ReadableMap r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        FLogger.a.i(TAG, "[sendLogV3] event=" + r5);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Unit r1 = null;
        if (r6 == null) goto L6;
        JSONObject r7 = toJSONObject(r6);     // Catch: Throwable -> L12
    L7:
        IApplog r2 = (IApplog) ServiceManager.get().getService(IApplog.class);     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        r2.reportEvent(r5, r7);     // Catch: Throwable -> L12
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r8 = Result.constructor-impl(r1);     // Catch: Throwable -> L12
    L14:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L20;
        FLogger.a.e(TAG, "[sendLogV3] error: " + r9.getMessage(), r9);
        return;
    L20:
        return;
    L6:
        r7 = null;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @JSMethod
    public final void fetch(final String r14, ReadableMap r15, final String r16, final Callback r17, ReadableMap r18, ReadableMap r110) {
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r16, "method");
        Intrinsics.checkNotNullParameter(r17, "callback");
        FLogger r5 = FLogger.a;
        r5.i(TAG, "[fetch] url=" + r14 + ", method=" + r16);
        if (r15 == null) goto L5;
        Map<String, String> r10 = toStringMap(r15);
    L6:
        if (r18 == null) goto L8;
        Map<String, String> r11 = toStringMap(r18);
    L9:
        if (r110 == null) goto L11;
        final Map<String, String> r4 = toStringMap(r110);
    L13:
        if (isHttpUrl(r14) == true) goto L16;
        r5.e(TAG, "[fetch] invalid url: " + r14);
        JSONObject r1 = new JSONObject();
        r1.put("code", 0);
        r1.put("msg", "url error, not http url");
        Unit r2 = Unit.INSTANCE;
        r17.invoke(new Object[]{r1});
        return;
    L16:
        final Map<String, String> r6 = r10;
        final Map<String, String> r7 = r11;
        getIoExecutor().execute(new g(this, r14, r16, r4, r6, r7, r17));
        return;
    L11:
        r4 = null;
        goto L13
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    private static final void fetch$lambda$6(FlowTransferModule r8, String r9, String r10, Map r11, Map r12, Map r13, Callback r14) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        String r6 = null;
        FlowTransferApi r5 = (FlowTransferApi) r8.getNetService().create(r9, FlowTransferApi.class, null, null);     // Catch: Throwable -> L19
        if (Intrinsics.areEqual("post", r10.toLowerCase(Locale.ROOT)) == false) goto L7;
        if (r5 == null) goto L9;
        Call<String> r15 = r5.fetchPost(r9, r11, r12, r13);     // Catch: Throwable -> L19
    L10:
        if (r15 == null) goto L14;
        SsResponse r16 = r15.execute();     // Catch: Throwable -> L19
        if (r16 == null) goto L14;
        r6 = (String) r16.body();     // Catch: Throwable -> L19
    L14:
        if (r6 == null) goto L16;
        JSONObject r17 = new JSONObject(r6);     // Catch: Throwable -> L19
        FLogger.a.i(TAG, "[fetch] success, statusCode=" + r17.optLong("status_code"));     // Catch: Throwable -> L19
        r14.invoke(new Object[]{r8.toJavaOnlyMap(r17)});     // Catch: Throwable -> L19
    L17:
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r20 = Result.exceptionOrNull-impl(r18);
        if (r20 == null) goto L27;
        FLogger.a.e(TAG, "[fetch] error: " + r20.getMessage(), r20);
        r14.invoke(new Object[]{new JavaOnlyMap()});
        return;
    L27:
        return;
    L16:
        FLogger.a.e(TAG, "[fetch] empty response");     // Catch: Throwable -> L19
        r14.invoke(new Object[]{new JavaOnlyMap()});     // Catch: Throwable -> L19
    L9:
        r15 = null;
        goto L10
    L7:
        if (r5 == null) goto L9;
        r15 = r5.fetchGet(r9, r11, r12);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public static /* synthetic */ void fetch$default(FlowTransferModule r9, String r10, ReadableMap r11, String r12, Callback r13, ReadableMap r14, ReadableMap r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        ReadableMap r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        ReadableMap r8 = null;
    L10:
        r9.fetch(r10, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }
}
