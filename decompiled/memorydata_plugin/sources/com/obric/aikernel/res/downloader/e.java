package com.obric.aikernel.res.downloader;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0016\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001aa\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\n\u001a\u0002H\u000726\u0010\u000b\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00050\fH\u0000¢\u0006\u0002\u0010\u0011\u001a!\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\n\u001a\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0018\u001a\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"DOWNLOAD_PROGRESS_LOG_STEP", "", "activeForegroundDownloadTaskCount", "taskCompletedStates", "", "", "insertOrderedTaskOnce", ExifInterface.GPS_DIRECTION_TRUE, "orderedTasks", "", "task", "shouldInsertBefore", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "candidate", "queued", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)I", "nextProgressLogCheckpoint", "lastLoggedProgress", "progress", "(Ljava/lang/Integer;I)Ljava/lang/Integer;", "removeAllOccurrences", "tasks", "(Ljava/util/List;Ljava/lang/Object;)I", "shouldKeepDownloadForegroundServiceRunning", "enableForegroundService", "taskCount", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class e {
    public static final int a(Collection<Boolean> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "taskCompletedStates");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L13;
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        if ((!((Boolean) ZeusTransformUtils.preCheckCast(r7.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue()) == false) goto L7;
        r2 = r2 + 1;
        if (r2 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
    L13:
        return r2;
    }

    public static final /* synthetic */ int a(List r2, Object r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final <T> int a(List<T> r7, T r8, Function2<? super T, ? super T, Boolean> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "orderedTasks");
        Intrinsics.checkNotNullParameter(r11, "shouldInsertBefore");
        int r0 = b(r10, r8);
        Iterator r2 = r10.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.invoke(r8, r2.next()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L10;
        r3 = r3 + 1;
    L10:
        if (r3 != (-1)) goto L12;
        r10.add(r8);
    L13:
        return r0;
    L12:
        r10.add(r3, r8);
        goto L13
    L9:
        r3 = -1;
        goto L10
    }

    public static final Integer a(Integer r3, int r4) {
        if (r4 < 100) goto L5;
        return null;
    L5:
        if (r4 < 10) goto L18;
        Integer r5 = Integer.valueOf((r4 / 10) * 10);
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        boolean r2 = false;
        if (r3 == null) goto L10;
        int r6 = r3.intValue();
    L11:
        if (r1 <= r6) goto L13;
        r2 = true;
    L13:
        if (r2 == true) goto L15;
        return null;
    L15:
        return r5;
    L10:
        r6 = 0;
        goto L11
    L18:
        return null;
    }

    public static final boolean a(boolean r0, int r1) {
        if (r0 == false) goto L5;
        if (r1 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final <T> int b(List<T> r2, T r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r4.remove(r3) == false) goto L6;
        r0 = r0 + 1;
        goto L4
    L6:
        return r0;
    }
}
