package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewRecordIdCodec;", "", "<init>", "()V", "SEPARATOR", "", "toExternal", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "internalRecordId", "toInternal", "externalRecordId", "externalRecordIdPrefix", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10395a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10396a = null;

        static {
            int[] r0 = new int[MemoryReviewModule.values().length];
            r0[MemoryReviewModule.AUTO_MEMORY_PRO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryReviewModule.PERSONAL_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10396a = r0;
        }
    }

    static {
        f10395a = new i();
    }

    private i() {
    }

    private final String a(MemoryReviewModule r2) {
        int r1 = a.f10396a[r2.ordinal()];
        if (r1 == 1) goto L8;
        if (r1 == 2) goto L8;
        return null;
    L8:
        return r2.getKey() + ':';
    }

    public final String a(MemoryReviewModule r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "internalRecordId");
        String r2 = a(r3);
        if (r2 != null) goto L6;
        return r4;
    L6:
        if (StringsKt.startsWith$default(r4, r2, false, 2, null) == false) goto L9;
        return r4;
    L9:
        return r2 + r4;
    }

    public final String b(MemoryReviewModule r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "externalRecordId");
        String r1 = a(r2);
        if (r1 != null) goto L6;
        return r3;
    L6:
        return StringsKt.removePrefix(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
