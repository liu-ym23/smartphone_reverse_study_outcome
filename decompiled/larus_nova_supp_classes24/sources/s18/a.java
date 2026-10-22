package s18;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.settings.ApiCrossPlatformRefactorSettings$RefactorConfigModel;
import com.larksuite.framework.apiplugin.validator.IllegalValidatorException;
import com.larksuite.framework.apiplugin.validator.format.GrayKey;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t18.u;
import u18.d;
import u18.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final w18.a a;
    public final JSONObject b;
    public final Class<?> c;
    public final LKEvent d;
    public final List<Map<String, String>> e;
    public boolean f;
    public boolean g;

    public static boolean b(Class r1) {
        if (r1 != Long.TYPE) goto L5;
    L30:
        return true;
    L5:
        if (Long.class.isAssignableFrom(r1) == true) goto L30;
        if (r1 == Integer.TYPE) goto L30;
        if (Integer.class.isAssignableFrom(r1) == true) goto L30;
        if (r1 == Short.TYPE) goto L30;
        if (Short.class.isAssignableFrom(r1) == true) goto L30;
        if (r1 == Byte.TYPE) goto L30;
        if (Byte.class.isAssignableFrom(r1) == true) goto L30;
        if (r1 == Float.TYPE) goto L30;
        if (Float.class.isAssignableFrom(r1) == true) goto L30;
        if (r1 == Double.TYPE) goto L30;
        if (Double.class.isAssignableFrom(r1) == true) goto L30;
        if (BigDecimal.class.isAssignableFrom(r1) == true) goto L30;
        return false;
    }

    public static b c(List r2) {
        ArrayList r3 = (ArrayList) r2;
        if (r3.isEmpty() == true) goto L18;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L18;
        v18.a r0 = (v18.a) r4.next();
        if (r0.check() == true) goto L6;
        b r5 = new b(r0.a());
        if ((r0 instanceof h) == false) goto L12;
    L15:
        r5.c = "no_require_params";
    L16:
        return r5;
    L12:
        if ((r0 instanceof d) == true) goto L15;
        r5.c = "illegal_value";
    L18:
        return new b();
    }

    public final b a(JSONObject r19, Class<?> r20) {
        Field[] r3 = r20.getDeclaredFields();
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L255;
        Field r7 = r3[r6];
        if (r7.isAnnotationPresent(JSONField.class) == false) goto L7;
        String r0 = r7.getAnnotation(JSONField.class).name();
    L8:
        String r8 = r0;
        Object r9 = r19.get(r8);
        Class<?> r10 = r7.getType();
        if ((r9 instanceof JSONObject) == false) goto L14;
        b r1 = a((JSONObject) r9, r10);
        if (r1.a == true) goto L253;
        return r1;
    L253:
        r6 = r6 + 1;
        goto L3
    L14:
        if (r10.isPrimitive() == false) goto L16;
    L39:
        boolean r2 = true;
    L40:
        if (r2 == false) goto L42;
        Class<?> r5 = r7.getType();
        if (r5 == Boolean.TYPE) goto L119;
        if (Boolean.class.isAssignableFrom(r5) == true) goto L119;
        if (String.class.isAssignableFrom(r5) == false) goto L54;
        if ((r9 instanceof Number) == false) goto L138;
        r19.remove(r8);
        r19.put(r8, String.valueOf(r9));
        Log.i("Validator", "transfer origin value :  " + r9 + " to String value");
    L137:
        boolean r12 = true;
    L139:
        if (r12 == false) goto L141;
        r9 = r19.get(r8);
        this.g = true;
    L141:
        Class<?> r11 = r7.getType();
        b r13 = new b();
        if ((r9 instanceof Number) == false) goto L169;
        if ((r9 instanceof Double) == true) goto L154;
        if ((r9 instanceof Float) == true) goto L154;
        if ((r9 instanceof BigDecimal) == true) goto L154;
        if (b(r11) == true) goto L189;
        r13.a = false;
        r13.b = r7.getName() + " type is not Integer Number";
    L189:
        if (r13.a == false) goto L190;
        Annotation[] r14 = r7.getAnnotations();
        if (r14 != null) goto L195;
    L248:
        b r15 = new b();
    L250:
        if (r15.a == true) goto L253;
        r15.d = r8;
        return r15;
    L195:
        if (r14.length == 0) goto L248;
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        int r110 = r14.length;
        int r111 = 0;
    L198:
        if (r111 >= r110) goto L215;
        Annotation r112 = r14[r111];
        HashMap r113 = (HashMap) u.a;
        if (r113.containsKey(r112.annotationType()) == true) goto L202;
        Annotation[] r114 = r14;
    L214:
        r111 = r111 + 1;
        r14 = r114;
        goto L198
    L202:
        w18.a r115 = this.a;
        r114 = r14;
        u.a r21 = (u.a) r113.get(r112.annotationType());
        if (r21 != null) goto L205;
        Log.w("FieldCheckerFactory", "cannot find ICheckerFactory for " + r112.annotationType());
        List<v18.a> r22 = null;
    L206:
        if (r22 == null) goto L214;
        Iterator<v18.a> r23 = r22.iterator();
    L209:
        if (r23.hasNext() == false) goto L214;
        v18.a r116 = r23.next();
        if (r116.isGray() == true) goto L212;
        r16.add(r116);
        goto L209
    L212:
        r17.add(r116);
        goto L209
    L205:
        r22 = r21.a(r7, r9, r112, r115);
        goto L206
    L215:
        r15 = c(r16);
        b r24 = c(r17);
        HashMap r25 = new HashMap();
        ((ArrayList) this.e).add(r25);
        r25.put("param_key", r8);
        r25.put("valid_checker_result", r15.toString());
        if (CollectionUtils.isNotEmpty(r17) == false) goto L218;
        boolean r117 = true;
        this.f = true;
    L220:
        if (r17.isEmpty() == true) goto L239;
        GrayKey r118 = (GrayKey) r7.getAnnotation(GrayKey.class);
        if (r118 == null) goto L247;
        String r119 = r118.value();
        if (r119 != null) goto L227;
    L238:
        Log.i("ApiCrossPlatformRefactorUtil", "feature is invalid:" + r119);
        goto L239
    L227:
        if (r119.length() == 0) goto L238;
        ApiCrossPlatformRefactorSettings$RefactorConfigModel r120 = (ApiCrossPlatformRefactorSettings$RefactorConfigModel) SettingManager.getInstance().get(ApiCrossPlatformRefactorSettings$RefactorConfigModel.class);
        if (r120 != null) goto L232;
    L237:
        Log.i("ApiCrossPlatformRefactorUtil", "config model :" + r120);
        goto L239
    L232:
        if (CollectionUtils.isNotEmpty(r120.enableFeatures) == false) goto L237;
        if (r120.enableFeatures.contains(r119) == false) goto L236;
        Log.i("ApiCrossPlatformRefactorUtil", "feature:" + r119 + " is enable");
    L240:
        if (r117 == false) goto L250;
        r25.put("gray_valid_checker_result", r24.toString());
        GrayKey r26 = (GrayKey) r7.getAnnotation(GrayKey.class);
        if (r26 == null) goto L245;
        r25.put("gray_feature_key", r26.value());
        r15 = r24;
        goto L250
    L245:
        throw new IllegalValidatorException("gray key is required!");
    L236:
        Log.i("ApiCrossPlatformRefactorUtil", "feature:" + r119 + " is not enable");
        goto L239
    L247:
        throw new IllegalValidatorException("gray key is required!");
    L239:
        r117 = false;
        goto L240
    L218:
        r117 = true;
        goto L220
    L190:
        Log.w("FieldChecker", r7.getName() + " type is not " + r10);
        r13.c = "illegal_params_type";
        r13.d = r8;
        return r13;
    L154:
        if (r11 != Float.TYPE) goto L156;
    L165:
        boolean r27 = true;
    L166:
        if (r27 == true) goto L189;
        r13.a = false;
        r13.b = r7.getName() + " type is not Decimal Number";
        goto L189
    L156:
        if (Float.class.isAssignableFrom(r11) == true) goto L165;
        if (r11 == Double.TYPE) goto L165;
        if (Double.class.isAssignableFrom(r11) == true) goto L165;
        if (BigDecimal.class.isAssignableFrom(r11) == true) goto L165;
        r27 = false;
        goto L166
    L169:
        if ((r9 instanceof CharSequence) == false) goto L175;
        if (String.class.isAssignableFrom(r11) == true) goto L189;
        r13.a = false;
        r13.b = r7.getName() + " type is not String";
        goto L189
    L175:
        if ((r9 instanceof Boolean) == false) goto L182;
        if (r11 == Boolean.TYPE) goto L189;
        if (Boolean.class.isAssignableFrom(r11) == true) goto L189;
        r13.a = false;
        r13.b = r7.getName() + " type is not Boolean";
        goto L189
    L182:
        if ((r9 instanceof JSONArray) == false) goto L189;
        if (List.class.isAssignableFrom(r11) == true) goto L189;
        if (r11.isArray() == true) goto L189;
        r13.a = false;
        r13.b = r7.getName() + " type is not List or Array";
    L138:
        r12 = false;
        goto L139
    L54:
        if (b(r5) == false) goto L138;
        if (r5 == Long.TYPE) goto L109;
        if (Long.class.isAssignableFrom(r5) == true) goto L109;
        if (r5 == Float.TYPE) goto L104;
        if (Float.class.isAssignableFrom(r5) == true) goto L104;
        short r121 = -1;
        int r122 = -1;
        if (r5 == Short.TYPE) goto L89;
        if (Short.class.isAssignableFrom(r5) == true) goto L89;
        if (r5 == Integer.TYPE) goto L76;
        if (Integer.class.isAssignableFrom(r5) == false) goto L138;
    L76:
        if ((r9 instanceof String) == false) goto L80;
        int r29 = CastDoubleProtector.valueOf((String) r9).intValue();     // Catch: Exception -> L115
    L78:
        r122 = r29;
        r12 = true;
    L85:
        if (r12 == false) goto L139;
        r19.remove(r8);     // Catch: Exception -> L101
        r19.put(r8, Integer.valueOf(r122));     // Catch: Exception -> L101
        Log.i("Validator", "transfer origin String value : " + r9 + " to int value");     // Catch: Exception -> L101
    L101:
        e = e;
    L117:
        Log.i("Validator", "checkFiledTypeAndTransfer2Default err : " + e.getMessage());
        goto L139
    L80:
        if ((r9 instanceof Number) == false) goto L84;
        r29 = ((Number) r9).intValue();     // Catch: Exception -> L115
        goto L78
    L84:
        r12 = false;
    L89:
        if ((r9 instanceof String) == false) goto L93;
        short r30 = CastDoubleProtector.valueOf((String) r9).shortValue();     // Catch: Exception -> L115
    L91:
        r121 = r30;
        r12 = true;
    L98:
        if (r12 == false) goto L139;
        r19.remove(r8);     // Catch: Exception -> L101
        r19.put(r8, Short.valueOf(r121));     // Catch: Exception -> L101
        Log.i("Validator", "transfer origin String value : " + r9 + " to short value");     // Catch: Exception -> L101
        goto L139
    L93:
        if ((r9 instanceof Number) == false) goto L97;
        r30 = ((Number) r9).shortValue();     // Catch: Exception -> L115
        goto L91
    L97:
        r12 = false;
    L104:
        if ((r9 instanceof String) == false) goto L138;
        float r31 = CastFloatProtector.valueOf((String) r9).floatValue();     // Catch: Exception -> L115
        r19.remove(r8);     // Catch: Exception -> L115
        r19.put(r8, Float.valueOf(r31));     // Catch: Exception -> L115
        Log.i("Validator", "transfer origin String value : " + r9 + " to float value");     // Catch: Exception -> L113
    L113:
        e = e;
        r12 = true;
    L109:
        if ((r9 instanceof String) == false) goto L138;
        double r123 = CastDoubleProtector.valueOf((String) r9).doubleValue();     // Catch: Exception -> L115
        r19.remove(r8);     // Catch: Exception -> L115
        r19.put(r8, Double.valueOf(r123));     // Catch: Exception -> L115
        Log.i("Validator", "transfer origin String value : " + r9 + " to double value");     // Catch: Exception -> L113
    L115:
        e = e;
        r12 = false;
    L119:
        if ((r9 instanceof CharSequence) == false) goto L130;
        String r32 = String.valueOf(r9).trim();
        if (TextUtils.equals("0", r32.toLowerCase()) == false) goto L123;
    L128:
        r19.remove(r8);
        r19.put(r8, Boolean.FALSE);
        Log.i("Validator", "transfer origin value : " + r32 + " to false");
        goto L137
    L123:
        if (TextUtils.equals("", r32.toLowerCase()) == true) goto L128;
        if (TextUtils.equals("1", r32.toLowerCase()) == false) goto L138;
        r19.remove(r8);
        r19.put(r8, Boolean.TRUE);
        Log.i("Validator", "transfer origin value :  " + r32 + " to true");
        goto L137
    L130:
        if ((r9 instanceof Number) == false) goto L138;
        int r33 = ((Number) r9).intValue();
        if (r33 != 0) goto L135;
        r19.remove(r8);
        r19.put(r8, Boolean.FALSE);
        Log.i("Validator", "transfer origin value :  " + r33 + " to false");
        goto L137
    L135:
        if (r33 != 1) goto L138;
        r19.remove(r8);
        r19.put(r8, Boolean.TRUE);
        Log.i("Validator", "transfer origin value :  " + r33 + " to true");
        goto L137
    L42:
        return new b();
    L16:
        if (r10.isArray() == true) goto L39;
        if (Long.class.isAssignableFrom(r10) == true) goto L39;
        if (Integer.class.isAssignableFrom(r10) == true) goto L39;
        if (Short.class.isAssignableFrom(r10) == true) goto L39;
        if (Byte.class.isAssignableFrom(r10) == true) goto L39;
        if (Float.class.isAssignableFrom(r10) == true) goto L39;
        if (Double.class.isAssignableFrom(r10) == true) goto L39;
        if (Boolean.class.isAssignableFrom(r10) == true) goto L39;
        if (Character.class.isAssignableFrom(r10) == true) goto L39;
        if (String.class.isAssignableFrom(r10) == true) goto L39;
        if (List.class.isAssignableFrom(r10) == true) goto L39;
        r2 = false;
        goto L40
    L7:
        r0 = r7.getName();
        goto L8
    L255:
        return new b();
    }

    public a(w18.a r2, JSONObject r3, Class<?> r4, LKEvent r5) {
        this.e = new ArrayList();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
