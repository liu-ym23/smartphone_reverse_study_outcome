package i18;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.validator.IllegalValidatorException;
import com.ss.android.lark.log.Log;
import j18.e;
import j18.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class b extends d {
    private static final String ERROR_NO = "errno";
    private static final String ERROR_STRING = "errString";
    private static final String ERR_MSG = "errMsg";
    private static final String TAG = "AutoRegisterLKPlugin";
    private Map<String, us5.b> mEvent2Method;
    private final AtomicBoolean mIsInit;

    public static /* synthetic */ void b(b r0, LKEvent r1, Method r2) {
        r0.lambda$asyncHandle$0(r1, r2);
    }

    private void checkInit() {
        if (this.mIsInit.get() == false) goto L5;
        return;
    L5:
        this.mIsInit.set(true);
        q18.a r0 = q18.a.C0120a.a;
        Class<?> r1 = getClass();
        Map<String, us5.b> r2 = (Map) ((ConcurrentHashMap) r0.b).get(r1);
        if (r2 != null) goto L8;
    L21:
        Method[] r3 = getClass().getDeclaredMethods();
        HashMap r4 = new HashMap();
        if (r3 == null) goto L33;
        int r5 = r3.length;
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L33;
        Method r7 = r3[r6];
        LKPluginFunction r8 = (LKPluginFunction) r7.getAnnotation(LKPluginFunction.class);
        if (r8 == null) goto L32;
        if (q18.c.b(r7) == false) goto L32;
        boolean r9 = r8.async();
        us5.b r10 = new us5.b();
        r10.a = r7;
        r10.b = r9;
        String[] r11 = r8.eventName();
        int r12 = r11.length;
        int r13 = 0;
    L30:
        if (r13 >= r12) goto L32;
        r4.put(r11[r13], r10);
        r13 = r13 + 1;
    L32:
        r6 = r6 + 1;
    L33:
        q18.a r14 = q18.a.C0120a.a;
        Class<?> r15 = getClass();
        Map r16 = (Map) ((ConcurrentHashMap) r14.b).get(r15);
        if (r16 != null) goto L36;
        r16 = new HashMap();
    L36:
        Iterator r17 = r4.entrySet().iterator();
    L38:
        if (r17.hasNext() == false) goto L40;
        Map.Entry r19 = (Map.Entry) r17.next();
        r16.put((String) r19.getKey(), (us5.b) r19.getValue());
        goto L38
    L40:
        ((ConcurrentHashMap) r14.b).put(r15, r16);
        this.mEvent2Method = r4;
        return;
    L8:
        if (r2.isEmpty() == true) goto L21;
        Iterator<Map.Entry<String, us5.b>> r20 = r2.entrySet().iterator();
    L11:
        if (r20.hasNext() == false) goto L19;
        Map.Entry<String, us5.b> r21 = r20.next();
        if (r21 == null) goto L11;
        if (r21.getValue() == null) goto L11;
        if (q18.c.b(r21.getValue().a) == true) goto L11;
        r20.remove();
        goto L11
    L19:
        this.mEvent2Method = r2;
    }

    public JSONObject generateParamsInvalidResult() {
        k18.a r0 = k18.a.c;
        return generateResult("invalid parameter");
    }

    public b() {
        this.mEvent2Method = Collections.EMPTY_MAP;
        this.mIsInit = new AtomicBoolean(false);
        checkInit();
    }

    private JSONObject createErrMsgJSONObject(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("errMsg", r4);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        Log.e(TAG, "createErrMsgJSONObject Exception", e);
        goto L7
    }

    private JSONObject generateResult(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("errMsg", r4);     // Catch: JSONException -> L5
        return r0;
    L5:
        e = move-exception;
        Log.e(TAG, "put errMsg jsonException: " + e.getMessage());
        return r0;
    }

    private String generateThrowableExtraInfo(Throwable r7) {
        if ((r7 instanceof InvocationTargetException) == false) goto L8;
        Throwable r0 = ((InvocationTargetException) r7).getTargetException();
        if (r0 == null) goto L8;
        r7 = r0;
    L8:
        Object[] r1 = new Object[2];
        int r2 = 0;
        r1[0] = r7;
        StackTraceElement[] r8 = r7.getStackTrace();
        StringBuilder r3 = new StringBuilder();
        int r4 = 5;
        if (5 <= r8.length) goto L12;
        r4 = r8.length;
    L12:
        if (r4 <= 0) goto L17;
        r3.append(r8[0]);
    L14:
        r2 = r2 + 1;
        if (r2 >= r4) goto L17;
        r3.append(" ");
        r3.append(r8[r2]);
    L17:
        r1[1] = r3.toString();
        return String.format("native exception %s stack:%s", r1);
    }

    @Override // i18.d
    public void addEvents(e r4) {
        checkInit();
        Map<String, us5.b> r0 = this.mEvent2Method;
        if (r0 == null) goto L8;
        Iterator<String> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        ((ArrayList) ((l18.d) r4).a).add(r2);
        goto L6
    L10:
        return;
    }

    public LKBaseResponseModel generateParamsInvalidResponse(String r2) {
        return generateResponse(r2, k18.a.e);
    }

    @Override // i18.d, j18.g
    public LKPluginHandleResult handleEvent(LKEvent r5) {
        String r0 = r5.a;
        Map<String, us5.b> r1 = this.mEvent2Method;
        if (r1 == null) goto L16;
        us5.b r2 = r1.get(r0);
        if (r2 == null) goto L18;
        Method r3 = r2.a;     // Catch: Exception -> L14
        if (r2.b == false) goto L13;
        if (asyncHandle(r5, r0, r3) == true) goto L18;
        return LKPluginHandleResult.g;
    L13:
        return syncHandle(r5, r3, r0);
    L14:
        e = move-exception;
        Log.e(TAG, "exception", e);
    L18:
        return super.handleEvent(r5);
    L16:
        Log.e(TAG, "handleEvent mEvent2Method is null", new Throwable());
        goto L18
    }

    private LKBaseResponseModel generateResponse(String r2, k18.a r3) {
        LKBaseResponseModel r0 = new LKBaseResponseModel(r3);
        r0.mInnerMsg = r2;
        return r0;
    }

    private JSONObject generateResult(String r3, n18.b r4) {
        JSONObject r0 = new JSONObject();
        r0.put("errMsg", r3);     // Catch: JSONException -> L9
        if (r4 == null) goto L8;
        int r5 = r4.a;     // Catch: JSONException -> L9
        if (r5 == 0) goto L8;
        r0.put("errno", r5);     // Catch: JSONException -> L9
        r0.put("errString", r4.b);     // Catch: JSONException -> L9
    L8:
        return r0;
    L9:
        e = move-exception;
        Log.e(TAG, "put errMsg jsonException: " + e.getMessage());
        return r0;
    }

    private /* synthetic */ void lambda$asyncHandle$0(LKEvent r1, Method r2) {
        asyncHandleImpl(r1, r2);
    }

    public void asyncHandleImpl(LKEvent r7, Method r8) {
        s18.b r0 = q18.c.a(r7, r8);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        if (r0.a == true) goto L16;
        LKBaseResponseModel r9 = generateParamsInvalidResponse(r0.b);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        if (TextUtils.equals(r0.c, "no_require_params") == false) goto L8;
        r9.setApiErrNo(new o18.a(104, String.format("Parameter error. %s cannot be empty", new Object[]{r0.d})));     // Catch: Exception -> L29 IllegalValidatorException -> L32
    L13:
        r7.b(r9);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        return;
    L8:
        if (TextUtils.equals(r0.c, "illegal_value") == false) goto L11;
        r9.setApiErrNo(new o18.a(104, String.format("Parameter error. Invalid value for %s", new Object[]{r0.d})));     // Catch: Exception -> L29 IllegalValidatorException -> L32
        goto L13
    L11:
        if (TextUtils.equals(r0.c, "illegal_params_type") == false) goto L13;
        r9.setApiErrNo(new o18.a(104, String.format("Parameter error. %s is of wrong type", new Object[]{r0.d})));     // Catch: Exception -> L29 IllegalValidatorException -> L32
        goto L13
    L16:
        if (r0.e == null) goto L18;
        r7.b = new JSONObject(r0.e);     // Catch: Exception -> L29 IllegalValidatorException -> L32
    L18:
        Object[] r1 = q18.c.c(r7, r8);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        monitor-enter(this);     // Catch: Exception -> L26
        r8.invoke(this, r1);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
    L39:
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "invoke Exception: ", e);
        r7.b(generateResponse(generateThrowableExtraInfo(e), k18.a.c));
        return;
    L32:
        e = move-exception;
        Log.e(TAG, "validator invalid", e);
        r7.b(generateResponse(e.getMessage(), k18.a.d));
        return;
    L29:
        e = move-exception;
        Log.e(TAG, "async JSON.parseObject error", e);
        r7.b(generateResponse(e.getMessage(), k18.a.e));
    }

    public JSONObject generateParamsInvalidResult(String r5, String r6) {
        if (TextUtils.equals(r5, "no_require_params") == false) goto L6;
        o18.a r7 = new o18.a(104, String.format("Parameter error. %s cannot be empty", new Object[]{r6}));
    L12:
        k18.a r8 = k18.a.c;
        return generateResult("invalid parameter", r7);
    L6:
        if (TextUtils.equals(r5, "illegal_value") == false) goto L9;
        r7 = new o18.a(104, String.format("Parameter error. Invalid value for %s", new Object[]{r6}));
        goto L12
    L9:
        if (TextUtils.equals(r5, "illegal_params_type") == false) goto L11;
        r7 = new o18.a(104, String.format("Parameter error. %s is of wrong type", new Object[]{r6}));
        goto L12
    L11:
        r7 = o18.a.c;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [i18.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean asyncHandle(final LKEvent r3, String r4, final Method r5) {
        if (r3.k == null) goto L5;
    L17:
        j18.a r0 = r3.k;
        if (r0 == 0) goto L21;
        r0.a(r4, new a(this, r3, r5));
        return true;
    L21:
        Log.e(TAG, "lkAsyncHandleEventExecutor is null,proceed handle");
        return false;
    L5:
        if (l18.b.b == null) goto L7;
    L16:
        r3.k = l18.b.b;
        goto L17
    L7:
        monitor-enter(l18.b.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (l18.b.b != null) goto L11;
        l18.b.b = new l18.b();     // Catch: Throwable -> L13
    L11:
        monitor-exit(l18.b.class);     // Catch: Throwable -> L13
        goto L16
    }

    private LKPluginHandleResult createFailResult(LKEvent r1, int r2, String r3) {
        JSONObject r4 = createErrMsgJSONObject(r3);
        r1.getClass();
        return LKEvent.d(r2, r4);
    }

    private LKPluginHandleResult getSyncHandleResult(LKEvent r8, String r9, Object r10) {
        if ((r10 instanceof LKPluginHandleResult) == true) goto L5;
        boolean r1 = true;
        if ((r10 instanceof LKBaseResponseModel) == false) goto L34;
        LKBaseResponseModel r0 = (LKBaseResponseModel) r10;
        if (r0.getApiErrCode() != null) goto L12;
        k18.a r11 = k18.a.c;
        return createFailResult(r8, 102, "apiErrCode cannot be null");
    L12:
        String r4 = JSON.toJSONString(r10);
        LKPluginHandleResult.a r5 = new LKPluginHandleResult.a();
        JSONObject r6 = new JSONObject(r4);     // Catch: JSONException -> L30
        r18.b.a(r6, (LKBaseResponseModel) r10);     // Catch: JSONException -> L30
        r5.a = r6;     // Catch: JSONException -> L30
        r6.put("errMsg", r18.b.c(r0));     // Catch: JSONException -> L30
        if (r0.isFail() == false) goto L16;
        r5.c = r0.getApiErrCode().a;     // Catch: JSONException -> L30
    L18:
        if (r0.mIsArrayBuffer == true) goto L20;
    L22:
        r1 = false;
    L23:
        if (r1 == false) goto L28;
        Log.i(TAG, "eventName:" + r9 + " is arrayBuffer");
        List<LKBasePluginResult.b.a> r12 = r0.getArrayBuffers();
        if (r5.d != null) goto L27;
        r5.d = new ArrayList();
    L27:
        ((ArrayList) r5.d).addAll(r12);
    L28:
        r5.e = r0.isCease();
        return new LKPluginHandleResult(r5);
    L20:
        if (r0.getArrayBuffers() == null) goto L22;
    L16:
        r6.remove("errno");     // Catch: JSONException -> L30
        r6.remove("errString");     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        Log.e(TAG, "JSONException when new JSONObject", e);
        k18.a r13 = k18.a.c;
        return createFailResult(r8, 102, e.getMessage());
    L34:
        if ((r10 instanceof k) == false) goto L43;
        r8.getClass();
        LKPluginHandleResult.a r14 = new LKPluginHandleResult.a();
        r14.b = (k) r10;
        r14.c = LKBaseResponseModel.DEFAULT_ERROR_CODE;
        r14.e = true;
        return new LKPluginHandleResult(r14);
    L43:
        JSONObject r15 = new JSONObject(JSON.toJSONString(r10));     // Catch: JSONException -> L40
        r8.a(r15);     // Catch: JSONException -> L40
        return LKEvent.d(LKBaseResponseModel.DEFAULT_ERROR_CODE, r15);
    L40:
        e = move-exception;
        Log.e(TAG, "JSONException", e);
        k18.a r16 = k18.a.c;
        return createFailResult(r8, 102, e.getMessage());
    L5:
        return (LKPluginHandleResult) r10;
    }

    public <T extends LKBaseResponseModel> void fillFailedResponse(T r1, n18.a r2, String r3) {
        if (r1 == null) goto L6;
        r1.mInnerMsg = r3;
        r1.setApiErrCode(r2);
        return;
    }

    public LKPluginHandleResult syncHandle(LKEvent r5, Method r6, String r7) {
        s18.b r2 = q18.c.a(r5, r6);     // Catch: Exception -> L16 IllegalValidatorException -> L19
        if (r2.a == true) goto L8;
        Log.i(TAG, "invalid params");     // Catch: Exception -> L16 IllegalValidatorException -> L19
        k18.a r8 = k18.a.c;     // Catch: Exception -> L16 IllegalValidatorException -> L19
        JSONObject r9 = generateParamsInvalidResult(r2.c, r2.d);     // Catch: Exception -> L16 IllegalValidatorException -> L19
        r5.getClass();     // Catch: Exception -> L16 IllegalValidatorException -> L19
        return LKEvent.d(104, r9);
    L8:
        if (r2.e == null) goto L22;
        r5.b = new JSONObject(r2.e);     // Catch: Exception -> L16 IllegalValidatorException -> L19
    L22:
        return getSyncHandleResult(r5, r7, r6.invoke(this, q18.c.c(r5, r6)));
    L13:
        e = move-exception;
        Log.e(TAG, "You added the LKPluginFunction annotation to the relevant method of the plugin, but the method call failed ：", e);
        k18.a r10 = k18.a.c;
        return createFailResult(r5, 101, "unknown exception");
    L19:
        e = move-exception;
        Log.e(TAG, "validator invalid", e);
        k18.a r11 = k18.a.c;
        JSONObject r12 = generateResult("internal error");
        r5.getClass();
        return LKEvent.d(102, r12);
    L16:
        e = move-exception;
        Log.e(TAG, "Exception", e);
        k18.a r13 = k18.a.c;
        JSONObject r14 = generateParamsInvalidResult();
        r5.getClass();
        return LKEvent.d(104, r14);
    }

    public <T extends LKBaseResponseModel> void fillFailedResponse(T r1, n18.a r2, String r3, n18.b r4) {
        if (r1 == null) goto L6;
        r1.mInnerMsg = r3;
        r1.setApiErrCode(r2);
        r1.setApiErrNo(r4);
        return;
    }
}
