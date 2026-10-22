package q18;

import com.alibaba.fastjson.JSON;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import j18.d;
import j18.f;
import j18.i;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static boolean b(Method r10) {
        Class<?>[] r0 = r10.getParameterTypes();
        Annotation[][] r11 = r10.getParameterAnnotations();
        boolean r2 = true;
        if (r11.length <= 0) goto L33;
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
    L6:
        if (r3 >= r11.length) goto L30;
        Annotation[] r6 = r11[r3];
        if (r6.length == 0) goto L15;
        int r7 = r6.length;
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L29;
        if ((r6[r8] instanceof LKPluginParam) == true) goto L13;
        r8 = r8 + 1;
        goto L10
    L13:
        r5 = true;
    L29:
        r3 = r3 + 1;
        goto L6
    L15:
        Class<?> r9 = r0[r3];
        if (r9 == LKEvent.class) goto L29;
        if (f.class == r9) goto L29;
        if (i18.c.class == r9) goto L29;
        if (d.class == r9) goto L29;
        if (i.class.isAssignableFrom(r9) == true) goto L29;
        if (hyb.a.class == r0[r3]) goto L29;
        r4 = true;
        goto L29
    L30:
        if (r4 == false) goto L33;
        if (r5 == false) goto L33;
        r2 = false;
    L33:
        if (r2 == true) goto L35;
        Log.e("PluginUtil", "You added the LKPluginFunction annotation to the relevant methods of Plugin, every annotation of param need LKPluginParam except the first param \n");
    L35:
        return r2;
    }

    public static JSONObject d(LKBaseResponseModel r3) {
        JSONObject r0 = new JSONObject();
        r0.put(LKBaseResponseModel.ERROR_MSG_KEY, r18.b.c(r3));     // Catch: JSONException -> L7
        r0.put(LKBaseResponseModel.INNER_MSG_KEY, r3.mInnerMsg);     // Catch: JSONException -> L7
        int r1 = r3.getErrNo();     // Catch: JSONException -> L7
        if (r1 == 0) goto L6;
        r0.put(LKBaseResponseModel.ERROR_NO_KEY, r1);     // Catch: JSONException -> L7
        r0.put(LKBaseResponseModel.ERROR_STRING_KEY, r3.getErrString());     // Catch: JSONException -> L7
    L6:
        return r0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static s18.b a(LKEvent r9, Method r10) {
        Annotation[][] r0 = r10.getParameterAnnotations();
        int r1 = r0.length;
        Class<?>[] r2 = r10.getParameterTypes();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L53;
        Class<?> r5 = r2[r3];
        if (LKEvent.class == r5) goto L51;
        if (f.class == r5) goto L51;
        if (i18.c.class == r5) goto L51;
        if (d.class == r5) goto L51;
        if (hyb.a.class == r5) goto L51;
        if (i.class.isAssignableFrom(r5) == true) goto L51;
        if (r0[r3].length != 0) goto L51;
        Class<?> r4 = r10.getParameterTypes()[r3];
        JSONObject r6 = r9.b;
        if (r6 == null) goto L51;
        String r7 = r6.toString();
        s18.a r8 = new s18.a(new w18.b(), (com.alibaba.fastjson.JSONObject) JSON.parse(r7), r4, r9);
        com.alibaba.fastjson.JSONObject r11 = r8.b;
        if (r11 == null) goto L40;
        Class<?> r12 = r8.c;
        if (r12 == null) goto L40;
        s18.b r13 = r8.a(r11, r12);
        if (r8.g == false) goto L37;
        if (r13.a == false) goto L37;
        r13.e = r8.b.toJSONString();
        Log.i("Validator", "put transfer params to valid check result");
    L37:
        if (r8.f == false) goto L42;
        new OPMonitor(ncb.a.a).addCategoryValue("api_name", r8.d.a).addCategoryValue("check_results", r8.e).flush(r8.d.m.a);
    L42:
        if (r13.a == false) goto L44;
        String r14 = "param check success";
    L45:
        Log.d("PluginUtil", r14);
        if (r13.a == false) goto L47;
        if (r13.e == null) goto L51;
        return r13;
    L47:
        return r13;
    L44:
        r14 = "param check fail";
    L40:
        r13 = new s18.b();
    L51:
        r3 = r3 + 1;
        goto L3
    L53:
        return new s18.b();
    }

    public static Object[] c(final LKEvent r12, Method r13) {
        Annotation[][] r0 = r13.getParameterAnnotations();
        int r1 = r0.length;
        Object[] r2 = new Object[r1];
        Class<?>[] r3 = r13.getParameterTypes();
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L44;
        Class<?> r7 = r3[r5];
        if (LKEvent.class != r7) goto L8;
        r2[r5] = r12;
    L43:
        r5 = r5 + 1;
        goto L3
    L8:
        if (f.class != r7) goto L11;
        Objects.requireNonNull(r12);
        r2[r5] = new b(r12);
        goto L43
    L11:
        if (i18.c.class != r7) goto L14;
        r2[r5] = r12.j;
        goto L43
    L14:
        if (d.class != r7) goto L17;
        r2[r5] = r12.m;
        goto L43
    L17:
        if (hyb.a.class != r7) goto L20;
        r2[r5] = r12.m.b;
        goto L43
    L20:
        if (i.class.isAssignableFrom(r7) == false) goto L22;
        r12.getClass();
    L22:
        JSONObject r6 = r12.b;
        if (r6 == null) goto L43;
        Annotation[] r8 = r0[r5];
        int r9 = r8.length;
        int r10 = 0;
    L25:
        if (r10 >= r9) goto L31;
        Annotation r11 = r8[r10];
        if ((r11 instanceof LKPluginParam) == false) goto L29;
        r2[r5] = r6.opt(((LKPluginParam) r11).value());
    L29:
        r10 = r10 + 1;
        goto L25
    L31:
        if (r8.length != 0) goto L43;
        Map<String, Object> r14 = r12.i;
        if (r14 == null) goto L42;
        Iterator<String> r15 = r14.keySet().iterator();
    L36:
        if (r15.hasNext() == false) goto L42;
        String r16 = r15.next();
        Log.i("PluginUtil", "common key:" + r16);
        r6.put(r16, r14.get(r16));     // Catch: JSONException -> L40
    L40:
        e = move-exception;
        Log.e("PluginUtil", "JSONException", e);
    L42:
        r2[r5] = JSON.parseObject(r6.toString(), r13.getParameterTypes()[r5]);
        goto L43
    L44:
        return r2;
    }
}
