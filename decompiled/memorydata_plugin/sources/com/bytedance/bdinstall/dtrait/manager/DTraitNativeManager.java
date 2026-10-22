package com.bytedance.bdinstall.dtrait.manager;

import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitNativeManager {
    private Class<?> aClass;

    public DTraitNativeManager() {
        this.aClass = null;
        this.aClass = ZeusTransformUtils.forName(DTraitConstant.DEVICE_NATIVE_MANAGER, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        DTLog.d("[dt] ~~~reflect success~~~");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_DTRAIT_NATIVE_MANAGER, "native反射失败" + e.getMessage(), e);
    }

    public String getA0Result(String r7) {
        Class<?> r6 = this.aClass;
        if (r6 != null) goto L10;
        return "";
    L10:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.getDeclaredMethod("getDA0Result", new Class[]{String.class}).invoke(null, new Object[]{r7}), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r8) == true) goto L8;
        return r8;
    L8:
        return "";
    }

    public String getDI0Result(String[] r9) {
        Class<?> r8 = this.aClass;
        if (r8 != null) goto L17;
        return "";
    L17:
        int r7 = 0;
        int[] r10 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r8.getDeclaredMethod("getDI0Result", new Class[]{String[].class}).invoke(null, new Object[]{r9}), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        if (r10 == null) goto L15;
        if (r10.length <= 0) goto L15;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L16
    L11:
        if (r7 >= r10.length) goto L13;
        r0.put(r9[r7], r10[r7]);     // Catch: Exception -> L16
        r7 = r7 + 1;     // Catch: Exception -> L16
        goto L11
    L13:
        return r0.toString();
    L15:
        return "";
    }

    public String getM0Result(String r7) {
        Class<?> r6 = this.aClass;
        if (r6 != null) goto L10;
        return "";
    L10:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.getDeclaredMethod("getDM0Result", new Class[]{String.class}).invoke(null, new Object[]{r7}), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r8) == true) goto L8;
        return r8;
    L8:
        return "";
    }

    public byte[] getMMMapResult(Map<String, JSONObject> r15, int r16, int r17, String r18) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        Class<?> r5 = this.aClass;
        if (r5 == null) goto L5;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5.getDeclaredMethod(DTraitConstant.METHOD_GET_MMMAP_RESULT, new Class[]{Map.class, Integer.TYPE, Integer.TYPE, String.class}).invoke(null, new Object[]{r3, Integer.valueOf(r16), Integer.valueOf(r17), r18}), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        if (r0 == null) goto L9;
        return r0;
    L9:
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_DTRAIT_NATIVE_MANAGER, " getMMMapResult map result is null");     // Catch: Exception -> L11
        return new byte[0];
    L11:
        e = move-exception;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_DTRAIT_NATIVE_MANAGER, " getMMMapResult error" + e.getMessage(), e);
        return new byte[0];
    L5:
        return new byte[0];
    }
}
