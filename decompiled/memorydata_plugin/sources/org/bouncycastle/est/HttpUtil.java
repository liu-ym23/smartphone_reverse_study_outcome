package org.bouncycastle.est;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
class HttpUtil {

    static class Headers extends HashMap<String, String[]> {
        private static final String EMPTY = "";

        public Headers() {
        }

        private String actualKey(String r4) {
            if (containsKey(r4) == false) goto L5;
            return r4;
        L5:
            Iterator<String> r3 = keySet().iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            if (r4.equalsIgnoreCase(r0) == false) goto L7;
            return r0;
        L11:
            return null;
        }

        private String[] copy(String[] r3) {
            int r2 = r3.length;
            String[] r0 = new String[r2];
            System.arraycopy(r3, 0, r0, 0, r2);
            return r0;
        }

        private boolean hasHeader(String r1) {
            if (actualKey(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void add(String r4, String r5) {
            put(r4, HttpUtil.append((String[]) ZeusTransformUtils.preCheckCast(get(r4), String[].class, "com.obric.memorydata.plugin"), r5));
        }

        @Override // java.util.HashMap, java.util.AbstractMap
        public Object clone() {
            Headers r0 = new Headers();
            Iterator<Map.Entry<String, String[]>> r1 = entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), copy((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r2.getValue(), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin")));
            goto L4
        L6:
            return r0;
        }

        public void ensureHeader(String r2, String r3) {
            if (containsKey(r2) == true) goto L6;
            set(r2, r3);
            return;
        }

        public String getFirstValue(String r1) {
            String[] r0 = getValues(r1);
            if (r0 != null) goto L5;
            return null;
        L5:
            if (r0.length > 0) goto L7;
            return null;
        L7:
            return r0[0];
        }

        public String getFirstValueOrEmpty(String r1) {
            String[] r0 = getValues(r1);
            if (r0 != null) goto L5;
            return "";
        L5:
            if (r0.length > 0) goto L7;
            return "";
        L7:
            return r0[0];
        }

        public String[] getValues(String r2) {
            String r3 = actualKey(r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return (String[]) ZeusTransformUtils.preCheckCast(get(r3), String[].class, "com.obric.memorydata.plugin");
        }

        public void set(String r3, String r4) {
            put(r3, new String[]{r4});
        }
    }

    public static String[] append(String[] r3, String r4) {
        if (r3 == null) goto L5;
        int r1 = r3.length;
        String[] r2 = new String[r1 + 1];
        System.arraycopy(r3, 0, r2, 0, r1);
        r2[r1] = r4;
        return r2;
    L5:
        return new String[]{r4};
    }
}
