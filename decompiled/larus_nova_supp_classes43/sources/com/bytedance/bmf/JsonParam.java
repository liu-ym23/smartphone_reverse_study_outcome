package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class JsonParam extends Ptr {
    public String dump() {
        return API.bmf_json_dump(((Ptr) this).ptr);
    }

    public void free() {
        if (((Ptr) this).own == false) goto L6;
        API.bmf_json_free(((Ptr) this).ptr);
        return;
    }

    public JsonParam() {
        ((Ptr) this).ptr = API.bmf_json_make();
        ((Ptr) this).own = true;
    }

    public boolean erase(String r10) {
        return API.bmf_json_erase(((Ptr) this).ptr, r10);
    }

    public double getDouble(String r10) {
        return API.bmf_json_get_double(((Ptr) this).ptr, r10);
    }

    public double[] getDoubleList(String r10) {
        return API.bmf_json_get_double_list(((Ptr) this).ptr, r10);
    }

    public float getFloat(String r10) {
        return API.bmf_json_get_float(((Ptr) this).ptr, r10);
    }

    public float[] getFloatList(String r10) {
        return API.bmf_json_get_float_list(((Ptr) this).ptr, r10);
    }

    public int getInt(String r10) {
        return API.bmf_json_get_int(((Ptr) this).ptr, r10);
    }

    public int[] getIntList(String r10) {
        return API.bmf_json_get_int_list(((Ptr) this).ptr, r10);
    }

    public long getLong(String r10) {
        return API.bmf_json_get_long(((Ptr) this).ptr, r10);
    }

    public String getString(String r10) {
        return API.bmf_json_get_string(((Ptr) this).ptr, r10);
    }

    public String[] getStringList(String r10) {
        return API.bmf_json_get_string_list(((Ptr) this).ptr, r10);
    }

    public boolean hasKey(String r10) {
        return API.bmf_json_has_key(((Ptr) this).ptr, r10);
    }

    public JsonParam(long r1, boolean r10) {
        ((Ptr) this).ptr = r1;
        ((Ptr) this).own = r10;
    }

    public static JsonParam wrap(long r1, boolean r10) {
        return new JsonParam(r1, r10);
    }

    public void set(String r10, Object r11) throws Exception {
        if ((r11 instanceof Integer) == false) goto L6;
        API.bmf_json_set_int(((Ptr) this).ptr, r10, ((Integer) r11).intValue());
        return;
    L6:
        if ((r11 instanceof Long) == false) goto L9;
        API.bmf_json_set_long(((Ptr) this).ptr, r10, ((Long) r11).longValue());
        return;
    L9:
        if ((r11 instanceof Float) == false) goto L12;
        API.bmf_json_set_float(((Ptr) this).ptr, r10, ((Float) r11).floatValue());
        return;
    L12:
        if ((r11 instanceof Double) == false) goto L15;
        API.bmf_json_set_double(((Ptr) this).ptr, r10, ((Double) r11).doubleValue());
        return;
    L15:
        if ((r11 instanceof String) == false) goto L18;
        API.bmf_json_set_string(((Ptr) this).ptr, r10, (String) r11);
        return;
    L18:
        if (r11.getClass().isArray() == false) goto L35;
        if ((r11 instanceof int[]) == false) goto L23;
        API.bmf_json_set_int_list(((Ptr) this).ptr, r10, (int[]) r11);
        return;
    L23:
        if ((r11 instanceof float[]) == false) goto L26;
        API.bmf_json_set_float_list(((Ptr) this).ptr, r10, (float[]) r11);
        return;
    L26:
        if ((r11 instanceof double[]) == false) goto L29;
        API.bmf_json_set_double_list(((Ptr) this).ptr, r10, (double[]) r11);
        return;
    L29:
        if ((r11 instanceof String[]) == false) goto L33;
        API.bmf_json_set_string_list(((Ptr) this).ptr, r10, (String[]) r11);
        return;
    L33:
        throw new IllegalArgumentException("Unknown array type for Jsonparam set()");
    L35:
        throw new IllegalArgumentException("Unknown type for Jsonparam set()");
    }
}
