package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"MEMORY_REVIEW_SOURCE_LABEL_APP", "", "toServerModule", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ag {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10409a = null;

        static {
            int[] r0 = new int[MemoryReviewModule.values().length];
            r0[MemoryReviewModule.SCREEN_MEMORY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[MemoryReviewModule.AUDIO_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[MemoryReviewModule.AUTO_MEMORY_PRO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MemoryReviewModule.PERSONAL_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[MemoryReviewModule.COLLECTION_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f10409a = r0;
        }
    }

    public static final int a(MemoryReviewModule r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r4 = a.f10409a[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 != 2) goto L7;
        return 5;
    L7:
        if (r4 == 3) goto L14;
        if (r4 == 4) goto L13;
        if (r4 != 5) goto L12;
        return 8;
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        return 7;
    L14:
        return 6;
    L16:
        return 4;
    }
}
