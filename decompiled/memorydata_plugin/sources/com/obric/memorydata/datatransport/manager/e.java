package com.obric.memorydata.datatransport.manager;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshotCodec;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "encode", "", "snapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "decode", EventBody.KEY_VALUE, "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f9766b = null;

    static {
        f9765a = new e();
        f9766b = new Gson();
    }

    private e() {
    }

    public final d a(String r21) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L30;
        return null;
    L30:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L22
        e r5 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        d r6 = (d) ZeusTransformUtils.preCheckCast(f9766b.fromJson(r21, d.class), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        r6.k().a();     // Catch: Throwable -> L15
        Object r7 = Result.m1421constructorimpl(r6.k());     // Catch: Throwable -> L15
    L17:
        q r8 = q.f9792a.a();     // Catch: Throwable -> L22
        if (Result.m1427isFailureimpl(r7) == false) goto L20;
        r7 = r8;
    L20:
        Object r9 = Result.m1421constructorimpl(d.a(r6, null, null, null, null, null, 0, 0, 0, null, null, (q) ZeusTransformUtils.preCheckCast(r7, q.class, "com.obric.memorydata.plugin"), 1023, null));     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r9) == true) goto L29;
        r3 = r9;
    L29:
        return (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final String a(d r1) {
        Intrinsics.checkNotNullParameter(r1, "snapshot");
        String r0 = f9766b.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "toJson(...)");
        return r0;
    }
}
