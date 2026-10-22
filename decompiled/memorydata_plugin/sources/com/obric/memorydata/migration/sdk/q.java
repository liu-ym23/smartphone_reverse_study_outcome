package com.obric.memorydata.migration.sdk;

import android.os.StatFs;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a<\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0000¨\u0006\u0011"}, d2 = {"migrationAvailableBytes", "", "dir", "Ljava/io/File;", "ensureFreeSpaceOrError", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "requiredBytes", "step", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", MemoryListActivity.JUMP_FROM_DETAIL, "", "isNoSpaceLeftError", "", "", "migration_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class q {
    public static final long a(File r3) {
        Intrinsics.checkNotNullParameter(r3, "dir");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(Long.valueOf(new StatFs(r3.getAbsolutePath()).getAvailableBytes()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r1) == null) goto L16;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = Result.m1421constructorimpl(Long.valueOf(r3.getUsableSpace()));     // Catch: Throwable -> L12
    L14:
        r1 = r4;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L16:
        if (Result.m1427isFailureimpl(r1) == false) goto L19;
        r1 = 0L;
    L19:
        return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final z<Unit> a(File r8, long r9, MigrationStep r11, m r12, String r13) {
        m r14 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dir");
        Intrinsics.checkNotNullParameter(r11, "step");
        Intrinsics.checkNotNullParameter(r13, MemoryListActivity.JUMP_FROM_DETAIL);
        long r2 = a(r8);
        if (r2 < r9) goto L7;
        Object r10 = ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
    L6:
        return (z) r10;
    L7:
        o r15 = new o(MigrationErrorCode.NO_SPACE_LEFT, r13 + "（需要>=" + r9 + "B，可用=" + r2 + "B）", null, 4, null);
        if (r14 == null) goto L10;
        r14.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(r11, r15), p.class, "com.obric.memorydata.plugin"));
    L10:
        r10 = ZeusTransformUtils.preCheckCast(new z.a(r15), z.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static final boolean a(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
    L3:
        if (r5 == null) goto L15;
        String r0 = r5.getMessage();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (ZeusTransformUtils.instanceOf(r5, IOException.class) == false) goto L14;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("ENOSPC", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L13;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("No space left on device", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L14;
    L13:
        return true;
    L14:
        r5 = r5.getCause();
        goto L3
    L15:
        return false;
    }
}
