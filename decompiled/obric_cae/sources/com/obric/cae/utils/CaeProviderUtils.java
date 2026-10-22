package com.obric.cae.utils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.cae.log.CaeLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CaeProviderUtils {
    public static final Uri BLUETOOTH_A2DP_JITTER_ML_URI = null;
    public static final Uri BLUETOOTH_COMPATIBILITY_URI = null;
    public static final Uri BLUETOOTH_PROFILE_INFO_URI = null;
    private static final String TAG = "CaeProviderUtils";

    public static class BtA2dpJitterMlEntry {
        public int Auto_optimize_count;
        public String Fence_location;
        public String Last_optimize_time;
        public String MAC;
        public int Manual_disabled;
        public int Optimize_count;
        public String Remote_Device_name;
        public int Severe_trigger_count;

        public BtA2dpJitterMlEntry() {
        }
    }

    public static class BtCompatibilityEntry {
        public int COD;
        public int Category;
        public String Detail_msg;
        public String Err_code;
        public int Err_count;
        public int Fixed;
        public int Issue_id;
        public String Last_happened_time;
        public String MAC;
        public int Module;
        public int Profile_type;
        public String Remote_Device_name;
        public String Solution;
        public int Uploaded;
        public String Uploaded_time;

        public BtCompatibilityEntry() {
        }
    }

    public static class BtProfileInfoEntry {
        public String MAC;
        public int Module;
        public int Profile_count;
        public int Profile_type;

        public BtProfileInfoEntry() {
        }
    }

    public static class caeEntryClass<T> {
        private T entry;

        public caeEntryClass() {
        }

        public T getData() {
            return this.entry;
        }

        public void setData(T r8) {
            this.entry = r8;
        }
    }

    static {
        BLUETOOTH_COMPATIBILITY_URI = Uri.parse("content://com.cae.CaeProvider/bluetooth_compatibility");
        BLUETOOTH_PROFILE_INFO_URI = Uri.parse("content://com.cae.CaeProvider/bluetooth_profile_info");
        BLUETOOTH_A2DP_JITTER_ML_URI = Uri.parse("content://com.cae.CaeProvider/bluetooth_a2dp_jitter_ml");
    }

    public CaeProviderUtils() {
    }

    public static boolean isDatabaseSelectionExists(Context r8, Uri r10, String r11, String[] r12) {
        boolean r13 = false;
        if (r8 != null) goto L22;
        return false;
    L22:
        Cursor r14 = r8.getContentResolver().query(r10, null, r11, r12, null);     // Catch: Throwable -> L17
        if (r14 != null) goto L24;
    L13:
        CaeLog.d(TAG, "isDatabaseSelectionExists : " + r13);     // Catch: Throwable -> L11
        if (r14 == null) goto L16;
        r14.close();
    L16:
        return r13;
    L11:
        th = th;
    L19:
        if (r14 == null) goto L21;
        r14.close();
    L21:
        throw th;
    L24:
        if (r14.moveToFirst() == false) goto L13;
        r13 = true;
    L17:
        th = th;
        r14 = null;
        goto L19
    }

    public static Map<String, String> queryDatabaseEntry(Context r8, Uri r10, String r11, String[] r12) {
        Cursor r13 = null;
        if (r8 != null) goto L5;
    L24:
        return null;
    L5:
        if (isDatabaseSelectionExists(r8, r10, r11, r12) == false) goto L24;
        ContentResolver r14 = r8.getContentResolver();
        HashMap r15 = new HashMap();
        r13 = r14.query(r10, null, r11, r12, null);     // Catch: Throwable -> L20
        if (r13 != null) goto L11;
    L17:
        if (r13 == null) goto L19;
        r13.close();
    L19:
        return r15;
    L11:
        if (r13.moveToFirst() == false) goto L17;
        int r16 = 0;
    L14:
        if (r16 >= r13.getColumnCount()) goto L17;
        r15.put(r13.getColumnName(r16), r13.getString(r16));     // Catch: Throwable -> L20
        r16 = r16 + 1;
    L20:
        th = move-exception;
        if (r13 == null) goto L23;
        r13.close();
    L23:
        throw th;
    }

    public static List<Map<String, String>> queryDatabaseEntryList(Context r8, Uri r10, String r11, String[] r12) {
        Cursor r13 = null;
        if (r8 != null) goto L5;
    L25:
        return null;
    L5:
        if (isDatabaseSelectionExists(r8, r10, r11, r12) == false) goto L25;
        ContentResolver r14 = r8.getContentResolver();
        CopyOnWriteArrayList r15 = new CopyOnWriteArrayList();
        r13 = r14.query(r10, null, r11, r12, null);     // Catch: Throwable -> L21
        if (r13 != null) goto L11;
    L18:
        if (r13 == null) goto L20;
        r13.close();
    L20:
        return r15;
    L11:
        if (r13.moveToFirst() == false) goto L18;
    L12:
        HashMap r16 = new HashMap();     // Catch: Throwable -> L21
        int r17 = 0;
    L14:
        if (r17 >= r13.getColumnCount()) goto L16;
        r16.put(r13.getColumnName(r17), r13.getString(r17));     // Catch: Throwable -> L21
        r17 = r17 + 1;     // Catch: Throwable -> L21
        goto L14
    L16:
        r15.add(r16);     // Catch: Throwable -> L21
        if (r13.moveToNext() == true) goto L12;
    L21:
        th = move-exception;
        if (r13 == null) goto L24;
        r13.close();
    L24:
        throw th;
    }

    @SuppressLint({"Range"})
    public static String queryDatabaseKeyValue(Context r8, Uri r10, String r11, String[] r12, String r13) {
        Cursor r14 = null;
        String r15 = null;
        r15 = null;
        if (r8 != null) goto L5;
    L23:
        return null;
    L5:
        if (isDatabaseSelectionExists(r8, r10, r11, r12) == false) goto L23;
        Cursor r16 = r8.getContentResolver().query(r10, null, r11, r12, null);     // Catch: Throwable -> L19
        if (r16 != null) goto L26;
    L16:
        if (r16 == null) goto L18;
        r16.close();
    L18:
        return r15;
    L26:
    L14:
        th = th;
        r14 = r16;
    L20:
        if (r14 == null) goto L22;
        r14.close();
    L22:
        throw th;
    L11:
        if (r16.moveToFirst() == false) goto L16;
        r15 = r16.getString(r16.getColumnIndex(r13));     // Catch: Throwable -> L14
    L19:
        th = th;
        goto L20
    }

    public static void removeFromDatabase(Context r8, Uri r10, String r11, String[] r12) {
        if (isDatabaseSelectionExists(r8, r10, r11, r12) == true) goto L5;
        return;
    L5:
        r8.getContentResolver().delete(r10, r11, r12);
    }

    public static <T> void saveToDatabase(Context r10, Uri r11, caeEntryClass<T> r12) {
        if (r12 == null) goto L16;
        if (r10 == null) goto L16;
        ContentResolver r13 = r10.getContentResolver();
        ContentValues r8 = new ContentValues();
        CaeLog.d(TAG, "t.getClass:" + r12.getData().getClass());
        Field[] r14 = r12.getData().getClass().getDeclaredFields();
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L15;
        Field r17 = r14[r16];
        r17.setAccessible(true);
        Object r18 = r17.get(r12.getData());     // Catch: IllegalAccessException -> L12
        if (r18 == null) goto L14;
        r8.put(r17.getName(), r18.toString());     // Catch: IllegalAccessException -> L12
        CaeLog.d(TAG, "Type:" + r17.getName() + ", value:" + r18.toString());     // Catch: IllegalAccessException -> L12
    L14:
        r16 = r16 + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        r13.insert(r11, r8);
        return;
    L16:
        CaeLog.e(TAG, "saveToDatabase fail: entry null");
    }

    public static <T> void updateDatabaseEntry(Context r8, Uri r10, String r11, String[] r12, caeEntryClass<T> r13) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (isDatabaseSelectionExists(r8, r10, r11, r12) == false) goto L25;
        ContentResolver r14 = r8.getContentResolver();
        ContentValues r15 = new ContentValues();
        Field[] r16 = r13.getData().getClass().getDeclaredFields();
        int r17 = r16.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L16;
        Field r19 = r16[r18];
        r19.setAccessible(true);
        Object r20 = r19.get(r13.getData());     // Catch: IllegalAccessException -> L13
        if (r20 == null) goto L15;
        r15.put(r19.getName(), r20.toString());     // Catch: IllegalAccessException -> L13
    L15:
        r18 = r18 + 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r14.update(r10, r15, null, null);
        return;
    }

    public static void updateDatabaseKeyType(Context r8, Uri r10, String r11, String[] r12, String[] r13, String[] r14) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (isDatabaseSelectionExists(r8, r10, r11, r12) == false) goto L14;
        ContentResolver r15 = r8.getContentResolver();
        ContentValues r16 = new ContentValues();
        int r17 = 0;
    L8:
        if (r17 >= r13.length) goto L10;
        r16.put(r13[r17], r14[r17]);
        r17 = r17 + 1;
        goto L8
    L10:
        r15.update(r10, r16, r11, r12);
        return;
    }
}
