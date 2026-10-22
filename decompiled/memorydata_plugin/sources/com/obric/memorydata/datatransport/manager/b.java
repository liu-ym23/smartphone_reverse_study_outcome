package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryPolicy;", "", "<init>", "()V", "decide", "Lcom/obric/memorydata/datatransport/manager/DataExportRecoveryDecision;", "snapshot", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "currentUserId", "", "completedFileExists", "", "hasActiveJob", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9759a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9760a = null;

        static {
            int[] r0 = new int[DataExportPhase.values().length];
            r0[DataExportPhase.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DataExportPhase.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DataExportPhase.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DataExportPhase.INTERRUPTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f9760a = r0;
        }
    }

    static {
        f9759a = new b();
    }

    private b() {
    }

    public final com.obric.memorydata.datatransport.manager.a a(d r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        Intrinsics.checkNotNullParameter(r4, "currentUserId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        Object r2 = com.obric.memorydata.datatransport.manager.a.g.f9758a;
    L6:
        return (com.obric.memorydata.datatransport.manager.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.datatransport.manager.a.class, "com.obric.memorydata.plugin");
    L8:
        if (Intrinsics.areEqual(r3.b(), r4) == true) goto L10;
        r2 = com.obric.memorydata.datatransport.manager.a.C0473a.f9752a;
        goto L6
    L10:
        DataExportPhase r7 = r3.c();
        int r8 = a.f9760a[r7.ordinal()];
        if (r8 != 1) goto L13;
    L27:
        Object r9 = com.obric.memorydata.datatransport.manager.a.C0473a.f9752a;
    L29:
        return (com.obric.memorydata.datatransport.manager.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.datatransport.manager.a.class, "com.obric.memorydata.plugin");
    L13:
        if (r8 != 2) goto L15;
        if (r5 == false) goto L27;
        r9 = com.obric.memorydata.datatransport.manager.a.e.f9756a;
        goto L29
    L15:
        if (r8 != 3) goto L17;
        r9 = com.obric.memorydata.datatransport.manager.a.d.f9755a;
        goto L29
    L17:
        if (r8 == 4) goto L23;
        if (r6 == false) goto L21;
        r9 = com.obric.memorydata.datatransport.manager.a.b.f9753a;
        goto L29
    L21:
        if (r3.f() >= 1) goto L23;
        r9 = new com.obric.memorydata.datatransport.manager.a.c(r3.f() + 1);
    L23:
        r9 = com.obric.memorydata.datatransport.manager.a.f.f9757a;
        goto L29
    }
}
