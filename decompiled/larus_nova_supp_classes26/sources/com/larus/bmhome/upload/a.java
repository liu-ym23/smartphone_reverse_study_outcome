package com.larus.bmhome.upload;

import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.UploadDataType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.bmhome.upload.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0040a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadDataType.values().length];
            r0[UploadDataType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UploadDataType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UploadDataType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UploadDataType.UNCLEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final FlowResourceType a(mr9.j r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        FlowResourceType r0 = mr9.a.a(r2.o.c);
        FlowResourceType r1 = FlowResourceType.Unknown;
        if (r0 == r1) goto L5;
        return r0;
    L5:
        UploadDataType r3 = r2.c;
        int r4 = C0040a.a[r3.ordinal()];
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L21;
        if (r4 == 3) goto L20;
        if (r4 != 4) goto L15;
        return r1;
    L15:
        throw new NoWhenBranchMatchedException();
    L20:
        return FlowResourceType.Video;
    L21:
        return FlowResourceType.File;
    L19:
        return FlowResourceType.Image;
    }
}
