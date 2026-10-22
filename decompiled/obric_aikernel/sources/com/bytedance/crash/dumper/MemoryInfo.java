package com.bytedance.crash.dumper;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryInfo {

    @Keep
    static class AppMemoryInfo implements Serializable {
        private static final String FILE_NAME = "app_memory.inf";
        private static final long serialVersionUID = 1;
        private int mLargeMemoryClass;
        private int mMemoryClass;
        private final long mNativeHeapAllocSize;
        private final long mNativeHeapFreeSize;
        private final long mNativeHeapSize;
        private final long mRuntimeFree;
        private final long mRuntimeMax;
        private final long mRuntimeTotal;

        AppMemoryInfo(ActivityManager r10) {
            this.mNativeHeapSize = Debug.getNativeHeapSize();
            this.mNativeHeapAllocSize = Debug.getNativeHeapAllocatedSize();
            this.mNativeHeapFreeSize = Debug.getNativeHeapFreeSize();
            Runtime r11 = Runtime.getRuntime();
            this.mRuntimeMax = r11.maxMemory();
            this.mRuntimeFree = r11.freeMemory();
            this.mRuntimeTotal = r11.totalMemory();
            if (r10 == null) goto L6;
            this.mMemoryClass = r10.getMemoryClass();
            this.mLargeMemoryClass = r10.getLargeMemoryClass();
            return;
        }

        public static void dump(File r10, ActivityManager r11) {
            AppMemoryInfo r12 = new AppMemoryInfo(r11);
            SerializeFactory.store(new File(r10, FILE_NAME), r12);
        }

        public static AppMemoryInfo load(File r10) {
            return (AppMemoryInfo) SerializeFactory.load(new File(r10, FILE_NAME));
        }

        void pushTo(@NonNull JSONObject r10) {
            JSONObject r11 = new JSONObject();
            r11.put("native_heap_size", this.mNativeHeapSize);     // Catch: JSONException -> L5
            r11.put("native_heap_alloc_size", this.mNativeHeapAllocSize);     // Catch: JSONException -> L5
            r11.put("native_heap_free_size", this.mNativeHeapFreeSize);     // Catch: JSONException -> L5
            r11.put("max_memory", this.mRuntimeMax);     // Catch: JSONException -> L5
            r11.put("free_memory", this.mRuntimeFree);     // Catch: JSONException -> L5
            r11.put("total_memory", this.mRuntimeTotal);     // Catch: JSONException -> L5
            r11.put("memory_class", this.mMemoryClass);     // Catch: JSONException -> L5
            r11.put("large_memory_class", this.mLargeMemoryClass);     // Catch: JSONException -> L5
            r10.put("app_memory_info", r11);     // Catch: JSONException -> L5
            return;
        }
    }

    @Keep
    static class DevMemoryInfo implements Serializable {
        private static final String FILE_NAME = "dev_memory.inf";
        private static final long KB = 1024;
        private static final long serialVersionUID = 1;
        private final long mDalvikPrivateDirty;
        private final long mDalvikPss;
        private final long mDalvikSharedDirty;
        private final long mNativePrivateDirty;
        private final long mNativePss;
        private final long mNativeSharedDirty;
        private final long mOtherPrivateDirty;
        private final long mOtherPss;
        private final long mOtherSharedDirty;
        private final long mSummaryGraphics;
        private final long mTotalPrivateClean;
        private final long mTotalPrivateDirty;
        private final long mTotalPss;
        private final long mTotalSharedClean;
        private final long mTotalSharedDirty;
        private final long mTotalSwappablePss;

        DevMemoryInfo() {
            Debug.MemoryInfo r10 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(r10);
            this.mDalvikPss = ((long) r10.dalvikPss) * 1024;
            this.mDalvikSharedDirty = ((long) r10.dalvikSharedDirty) * 1024;
            this.mDalvikPrivateDirty = ((long) r10.dalvikPrivateDirty) * 1024;
            this.mNativePss = ((long) r10.nativePss) * 1024;
            this.mNativeSharedDirty = ((long) r10.nativeSharedDirty) * 1024;
            this.mNativePrivateDirty = ((long) r10.nativePrivateDirty) * 1024;
            this.mOtherPss = ((long) r10.otherPss) * 1024;
            this.mOtherSharedDirty = ((long) r10.otherSharedDirty) * 1024;
            this.mOtherPrivateDirty = ((long) r10.otherPrivateDirty) * 1024;
            this.mTotalPss = ((long) r10.getTotalPss()) * 1024;
            if (Build.VERSION.SDK_INT < 19) goto L5;
            this.mTotalSharedClean = ((long) r10.getTotalSharedClean()) * 1024;
            this.mTotalPrivateClean = ((long) r10.getTotalPrivateClean()) * 1024;
            long r11 = ((long) r10.getTotalSwappablePss()) * 1024;
        L6:
            this.mTotalSwappablePss = r11;
            this.mTotalSharedDirty = ((long) r10.getTotalSharedDirty()) * 1024;
            this.mTotalPrivateDirty = ((long) r10.getTotalPrivateDirty()) * 1024;
            this.mSummaryGraphics = getSummaryGraphics(r10);
            return;
        L5:
            r11 = 0;
            this.mTotalSharedClean = 0;
            this.mTotalPrivateClean = 0;
            goto L6
        }

        public static void dump(File r10) {
            DevMemoryInfo r11 = new DevMemoryInfo();
            SerializeFactory.store(new File(r10, FILE_NAME), r11);
        }

        private static long getSummaryGraphics(Debug.MemoryInfo r10) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
            return 0;
        L10:
            return ((long) Integer.parseInt(r10.getMemoryStat("summary.graphics"))) * 1024;
        L12:
            return 0;
        }

        public static DevMemoryInfo load(File r10) {
            return (DevMemoryInfo) SerializeFactory.load(new File(r10, FILE_NAME));
        }

        public void pushTo(@NonNull JSONObject r10) {
            JSONObject r11 = new JSONObject();
            r11.put("dalvikPss", this.mDalvikPss);     // Catch: JSONException -> L5
            r11.put("dalvikSharedDirty", this.mDalvikSharedDirty);     // Catch: JSONException -> L5
            r11.put("dalvikPrivateDirty", this.mDalvikPrivateDirty);     // Catch: JSONException -> L5
            r11.put("nativePss", this.mNativePss);     // Catch: JSONException -> L5
            r11.put("nativeSharedDirty", this.mNativeSharedDirty);     // Catch: JSONException -> L5
            r11.put("nativePrivateDirty", this.mNativePrivateDirty);     // Catch: JSONException -> L5
            r11.put("otherPss", this.mOtherPss);     // Catch: JSONException -> L5
            r11.put("otherSharedDirty", this.mOtherSharedDirty);     // Catch: JSONException -> L5
            r11.put("otherPrivateDirty", this.mOtherPrivateDirty);     // Catch: JSONException -> L5
            r11.put("totalPss", this.mTotalPss);     // Catch: JSONException -> L5
            r11.put("totalPrivateClean", this.mTotalPrivateClean);     // Catch: JSONException -> L5
            r11.put("totalSharedClean", this.mTotalSharedClean);     // Catch: JSONException -> L5
            r11.put("totalSwappablePss", this.mTotalSwappablePss);     // Catch: JSONException -> L5
            r11.put("totalSharedDirty", this.mTotalSharedDirty);     // Catch: JSONException -> L5
            r11.put("totalPrivateDirty", this.mTotalPrivateDirty);     // Catch: JSONException -> L5
            r11.put("summary.graphics", this.mSummaryGraphics);     // Catch: JSONException -> L5
            r10.put("memory_info", r11);     // Catch: JSONException -> L5
            return;
        }
    }

    @Keep
    static class SysMemoryInfo implements Serializable {
        private static final String FILE_NAME = "sys_memory.inf";
        private static final long UNIT_SIZE = 536870912;
        private static final long serialVersionUID = 1;
        private final long mAvailMem;
        private final boolean mLowMemory;
        private final long mThreshold;
        private final long mTotalMem;

        SysMemoryInfo(ActivityManager r10) {
            ActivityManager.MemoryInfo r11 = new ActivityManager.MemoryInfo();
            r10.getMemoryInfo(r11);
            this.mLowMemory = r11.lowMemory;
            this.mThreshold = r11.threshold;
            this.mAvailMem = r11.availMem;
            this.mTotalMem = r11.totalMem;
        }

        static void dump(File r10, ActivityManager r11) {
            if (r11 == null) goto L5;
            SysMemoryInfo r12 = new SysMemoryInfo(r11);
            SerializeFactory.store(new File(r10, FILE_NAME), r12);
            return;
        }

        static SysMemoryInfo load(File r10) {
            return (SysMemoryInfo) SerializeFactory.load(new File(r10, FILE_NAME));
        }

        void pushTo(@NonNull JSONObject r10) {
            JSONObject r11 = new JSONObject();
            r11.put("lowMemory", this.mLowMemory);     // Catch: JSONException -> L5
            r11.put("threshold", this.mThreshold);     // Catch: JSONException -> L5
            r11.put("availMemUnit", this.mAvailMem / UNIT_SIZE);     // Catch: JSONException -> L5
            r11.put("totalMemUnit", this.mTotalMem / UNIT_SIZE);     // Catch: JSONException -> L5
            r10.put("sys_memory_info", r11);     // Catch: JSONException -> L5
            return;
        }
    }

    public MemoryInfo() {
    }

    public static void dump(File r10) {
        Context r11 = Global.getContext();
        if (r11 == null) goto L6;
        ActivityManager r12 = (ActivityManager) r11.getSystemService("activity");
        DevMemoryInfo.dump(r10);
        SysMemoryInfo.dump(r10, r12);
        AppMemoryInfo.dump(r10, r12);
        return;
    }

    private static void packMemTrackInfo(JSONObject r10, JSONObject r11) {
        JSONObject r12 = r10.optJSONObject("memory_info");
        if (r12 != null) goto L7;
        r10.putOpt("memory_info", r11);     // Catch: JSONException -> L10
        return;
    L15:
        return;
    L7:
        if (r12.has("graphicPss") == true) goto L13;
        JSONUtils.assignIfNoExist(r12, r11);
        return;
    }

    public static void packTaggedMapsSize(JSONObject r10, File r11) {
        File r12 = new File(r11, "maps_size.txt");
        if (r12.exists() == false) goto L32;
        BufferedReader r13 = new BufferedReader(new FileReader(r12));     // Catch: Throwable -> L23
        String r14 = r13.readLine();     // Catch: Throwable -> L23
        if (r14 != null) goto L7;
        return;
    L7:
        String[] r15 = r14.trim().split(" ");     // Catch: Throwable -> L23
        if (r15.length >= 2) goto L10;
        return;
    L10:
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L23
    L11:
        String r17 = r13.readLine();     // Catch: Throwable -> L23
        if (r17 == null) goto L20;
        String[] r18 = r17.trim().split(" ");     // Catch: Throwable -> L23
        if (r18.length != r15.length) goto L11;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L23
        int r20 = 0;
    L17:
        if (r20 >= r15.length) goto L19;
        r19.put(r15[r20], r18[r20]);     // Catch: Throwable -> L23
        r20 = r20 + 1;     // Catch: Throwable -> L23
        goto L17
    L19:
        r16.put(r19);     // Catch: Throwable -> L23
        goto L11
    L20:
        r13.close();     // Catch: Throwable -> L23
        r10.put("tagged_maps_size", r16);     // Catch: Throwable -> L23
    L21:
        FileUtils.deleteFile(r12);
        return;
    }

    private static JSONObject parseMemTrackInfo(File r10) {
        JSONObject r11 = new JSONObject();
        File r12 = new File(r10, "sys_memtrack.txt");
        if (r12.exists() == false) goto L18;
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new FileReader(r12));     // Catch: Throwable -> L19
    L20:
        String r15 = r14.readLine();     // Catch: Throwable -> L16
        if (r15 == null) goto L15;
        if ("".equals(r15) == true) goto L20;
        String[] r16 = r15.split(" ");     // Catch: Throwable -> L16
        if (r16.length != 3) goto L20;
        String r17 = r16[0];     // Catch: Throwable -> L16
        long r18 = Long.parseLong(r16[1]) * 1024;     // Catch: Throwable -> L16
        r11.putOpt(r17.substring(0, r17.length() - 1), Long.valueOf(r18));     // Catch: Throwable -> L16
        goto L20
    L15:
        IoUtil.close(r14);
    L16:
        r13 = r14;
    L17:
        IoUtil.close(r13);
    L18:
        return r11;
    }

    public static void pushTo(@NonNull JSONObject r10) {
        pushTo(r10, null);
    }

    public static void pushTo(@NonNull JSONObject r10, File r11) {
        if (r11 == null) goto L5;
        AppMemoryInfo r12 = AppMemoryInfo.load(r11);
        SysMemoryInfo r13 = SysMemoryInfo.load(r11);
        DevMemoryInfo r14 = DevMemoryInfo.load(r11);
        JSONObject r15 = parseMemTrackInfo(r11);
    L12:
        if (r12 == null) goto L14;
        r12.pushTo(r10);
    L14:
        if (r13 == null) goto L16;
        r13.pushTo(r10);
    L16:
        if (r14 == null) goto L18;
        r14.pushTo(r10);
    L18:
        if (r15 == null) goto L21;
        packMemTrackInfo(r10, r15);
        return;
    L21:
        return;
    L5:
        Context r16 = Global.getContext();
        if (r16 == null) goto L10;
        ActivityManager r17 = (ActivityManager) r16.getSystemService("activity");
        if (r17 == null) goto L10;
        AppMemoryInfo r18 = new AppMemoryInfo(r17);
        SysMemoryInfo r19 = new SysMemoryInfo(r17);
    L11:
        SysMemoryInfo r20 = r19;
        r14 = new DevMemoryInfo();
        r15 = null;
        r12 = r18;
        r13 = r20;
    L10:
        r18 = null;
        r19 = null;
        goto L11
    }
}
