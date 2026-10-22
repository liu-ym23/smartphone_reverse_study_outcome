package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordFileHelper {
    public static final MmRecordFileHelper a = null;

    static {
        a = new MmRecordFileHelper();
    }

    public MmRecordFileHelper() {
    }

    public static VFSFile g(String r5) {
        h r0 = a.a;
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordingParts", "directoryName");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordingParts", "childPath");
        h r1 = a.a;
        f r2 = f.d;
        return r1.D(LarkFileStorage.f(r5).b(r2, new d(new String[]{"minutes"})).toFile(), "MinutesRecordingParts");
    }

    public static Object b(String r3, Continuation r4) {
        if (StringsKt.isBlank(r3) == true) goto L5;
        Object r5 = BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$deleteFile$2(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r5;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static Object d(String r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$findLocalMeetingIds$2(r3, null), r4);
    }

    public static Object e(String r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$findNativeLocalSessionKeys$2(r3, null), r4);
    }

    public static VFSFile f(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        return a.b(g(r1), r2);
    }

    public static Object c(String r3, String r4, ContinuationImpl r5) {
        if (StringsKt.isBlank(r3) == false) goto L5;
    L9:
        lvb.a.b("MmRecordFileHelper", "[deleteRecordingPartDir] invalid params: userId=" + r3 + ", recordingId=" + r4);
        return Boxing.boxBoolean(false);
    L5:
        if (StringsKt.isBlank(r4) == true) goto L9;
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$deleteRecordingPartDir$2(r3, r4, null), r5);
    }

    public static Object h(String r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$listRecordingPartFileNames$2(r3, r4, null), r5);
    }

    public static Object a(String r3, String r4, String r5, Continuation r6) {
        if (StringsKt.isBlank(r4) == false) goto L5;
    L13:
        lvb.a.b("MmRecordFileHelper", "[copyRecordingDirToMeetingId] invalid params: fromSessionKey=" + r4 + ", toMeetingId=" + r5);
        return Boxing.boxBoolean(false);
    L5:
        if (StringsKt.isBlank(r5) == true) goto L13;
        if (Intrinsics.areEqual(r4, r5) == false) goto L12;
        lvb.a.e("MmRecordFileHelper", "[copyRecordingDirToMeetingId] skip same dir: " + r4);
        return Boxing.boxBoolean(true);
    L12:
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$copyRecordingDirToMeetingId$2(r3, r4, r5, null), r6);
    }
}
