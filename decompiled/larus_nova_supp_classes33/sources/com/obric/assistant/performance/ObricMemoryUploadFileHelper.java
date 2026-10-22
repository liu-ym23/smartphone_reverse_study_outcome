package com.obric.assistant.performance;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricThresholdItemConfig;
import com.obric.memorydata.sdk.entity.search.SearchError;
import com.ss.android.agilelogger.ALog;
import java.io.BufferedInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricMemoryUploadFileHelper {
    public static final ObricMemoryUploadFileHelper a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((File) r1).getName(), ((File) r2).getName());
        }
    }

    static {
        a = new ObricMemoryUploadFileHelper();
    }

    public ObricMemoryUploadFileHelper() {
    }

    public static String b(long r8) {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Map r1 = MapsKt.toSortedMap(r0.getMemoryStats());
    L6:
        Runtime r2 = Runtime.getRuntime();
        StringBuilder r3 = new StringBuilder();
        StringBuilder r4 = new StringBuilder("Uptime=");
        a.getClass();
        r4.append(d(r8));
        r4.append('}');
        r3.append(r4.toString());
        r3.append('\n');
        r3.append("** MEMINFO in pid " + Process.myPid() + " [" + AppHost.a.getApplication().getPackageName() + "] **");
        r3.append('\n');
        StringBuilder r9 = new StringBuilder("total_pss=");
        r9.append(r0.getTotalPss());
        r3.append(r9.toString());
        r3.append('\n');
        r3.append("dalvik_pss=" + r0.dalvikPss);
        r3.append('\n');
        r3.append("native_pss=" + r0.nativePss);
        r3.append('\n');
        r3.append("other_pss=" + r0.otherPss);
        r3.append('\n');
        r3.append("total_private_dirty=" + r0.getTotalPrivateDirty());
        r3.append('\n');
        r3.append("total_shared_dirty=" + r0.getTotalSharedDirty());
        r3.append('\n');
        r3.append("total_swappable_pss=" + r0.getTotalSwappablePss());
        r3.append('\n');
        r3.append("native_heap_allocated=" + Debug.getNativeHeapAllocatedSize());
        r3.append('\n');
        r3.append("java_heap_used=" + (r2.totalMemory() - r2.freeMemory()));
        r3.append('\n');
        r3.append("java_heap_total=" + r2.totalMemory());
        r3.append('\n');
        r3.append("java_heap_max=" + r2.maxMemory());
        r3.append('\n');
        if ((!r1.isEmpty()) == false) goto L13;
        r3.append("memory_stats=\n");
        Iterator r10 = r1.entrySet().iterator();
    L10:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r5 = (Map.Entry) r10.next();
        r3.append("    " + ((String) r5.getKey()) + '=' + ((String) r5.getValue()));
        r3.append('\n');
    L13:
        return r3.toString();
    L5:
        r1 = MapsKt.emptyMap();
        goto L6
    }

    public static String d(long r4) {
        String r0 = new SimpleDateFormat("yyyyMMdd.HHmmss", Locale.getDefault()).format(new Date(r4));     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        FLogger.a.e("ObricMemoryUploadFileHelper", "formatFileTime error, timestamp=" + r4, th);
        return String.valueOf(r4);
    }

    public static int a(ZipOutputStream r9, List r10, ObricThresholdItemConfig r11) {
        Intrinsics.checkNotNullParameter(r9, "output");
        Intrinsics.checkNotNullParameter(r10, "alogFiles");
        Intrinsics.checkNotNullParameter(r11, "config");
        if (r11.getEnableAlog() == true) goto L6;
        return 0;
    L6:
        if (r10.isEmpty() == false) goto L9;
        FLogger.a.i("ObricMemoryUploadFileHelper", "appendAlog skipped, no recent alog files");
        return 0;
    L9:
        Iterator r12 = r10.iterator();
        int r2 = 0;
    L11:
        if (r12.hasNext() == false) goto L42;
        File r3 = (File) r12.next();
        String r4 = "alog/" + r3.getName();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L31
        r9.putNextEntry(new ZipEntry(r4));     // Catch: Throwable -> L31
        BufferedInputStream r6 = new PolarisFileInputStreamWrapper(r3);     // Catch: Throwable -> L31
        if ((r6 instanceof BufferedInputStream) == false) goto L17;
        BufferedInputStream r7 = r6;     // Catch: Throwable -> L31
    L46:
        ByteStreamsKt.copyTo$default(r7, r9, 0, 2, null);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L31
        r9.closeEntry();     // Catch: Throwable -> L31
        int r8 = r2 + 1;
        Object r13 = Result.constructor-impl(Integer.valueOf(r2));     // Catch: Throwable -> L24
    L34:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L41;
        r9.closeEntry();     // Catch: Throwable -> L38
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        FLogger.a.e("ObricMemoryUploadFileHelper", "appendAlog failed, path=" + r3.getAbsolutePath(), r14);
    L38:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L41:
        r2 = r8;
    L24:
        Throwable th = th;
    L33:
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L17:
        r7 = new BufferedInputStream(r6, 8192);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r8 = r2;
        th = th;
        goto L33
    L42:
        FLogger.a.i("ObricMemoryUploadFileHelper", "appendAlog finished, count=" + r2 + ", total=" + r10.size());
        return r2;
    }

    public final Object c(long r7, ObricThresholdItemConfig r9, Continuation<? super List<? extends File>> r10) {
        if ((r10 instanceof ObricMemoryUploadFileHelper$collectRecentAlogFiles$1) == false) goto L7;
        ObricMemoryUploadFileHelper$collectRecentAlogFiles$1 r0 = (ObricMemoryUploadFileHelper$collectRecentAlogFiles$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        long r8 = r0.J$1;
        long r4 = r0.J$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L27:
        long r12 = SearchError.ERR_UNKNOWN;
        List r13 = ALog.getALogFiles(r8 / r12, r4 / r12);     // Catch: Throwable -> L14
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Throwable -> L14
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L14
    L30:
        if (r15.hasNext() == false) goto L32;
        r14.add(new PolarisFileWrapper((String) r15.next()));     // Catch: Throwable -> L14
        goto L30
    L32:
        HashSet r16 = new HashSet();     // Catch: Throwable -> L14
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r18 = r14.iterator();     // Catch: Throwable -> L14
    L34:
        if (r18.hasNext() == false) goto L38;
        Object r19 = r18.next();     // Catch: Throwable -> L14
        if (r16.add(((File) r19).getAbsolutePath()) == false) goto L34;
        r17.add(r19);     // Catch: Throwable -> L14
        goto L34
    L38:
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r21 = r17.iterator();     // Catch: Throwable -> L14
    L40:
        if (r21.hasNext() == false) goto L49;
        Object r22 = r21.next();     // Catch: Throwable -> L14
        File r110 = (File) r22;     // Catch: Throwable -> L14
        if (r110.exists() == true) goto L44;
    L46:
        boolean r111 = false;
    L47:
        if (r111 == false) goto L40;
        r20.add(r22);     // Catch: Throwable -> L14
        goto L40
    L44:
        if (r110.isFile() == false) goto L46;
        r111 = true;
        goto L47
    L49:
        Object r23 = Result.constructor-impl(CollectionsKt.sortedWith(r20, new a()));     // Catch: Throwable -> L14
    L54:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L57;
        FLogger.a.e("ObricMemoryUploadFileHelper", "collectRecentAlogFiles failed, endTimeMs=" + r4, r24);
    L57:
        List r25 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r23) == true) goto L60;
        return r23;
    L60:
        return r25;
    L14:
        Throwable th = th;
    L53:
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        if (r9.getEnableAlog() == false) goto L21;
        long r27 = RangesKt.coerceAtLeast(r7 - RangesKt.coerceAtLeast(r9.getRecentAlogMs(), 0), 0);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L51
        ALog.asyncFlush();     // Catch: Throwable -> L51
        r0.J$0 = r7;     // Catch: Throwable -> L51
        r0.J$1 = r27;     // Catch: Throwable -> L51
        r0.label = 1;     // Catch: Throwable -> L51
        if (DelayKt.delay(1000, r0) != r2) goto L26;
        return r2;
    L26:
        r4 = r7;
        r8 = r27;
    L51:
        th = move-exception;
        r4 = r7;
        th = th;
        goto L53
    L21:
        return CollectionsKt.emptyList();
    L7:
        r0 = new ObricMemoryUploadFileHelper$collectRecentAlogFiles$1(this, r10);
        goto L8
    }
}
