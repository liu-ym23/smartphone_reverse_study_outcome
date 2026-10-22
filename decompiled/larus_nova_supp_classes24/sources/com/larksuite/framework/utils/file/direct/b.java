package com.larksuite.framework.utils.file.direct;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DirectFileAccess.PathType.values().length];
            r0[DirectFileAccess.PathType.ROOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DirectFileAccess.PathType.CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DirectFileAccess.PathType.CODE_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DirectFileAccess.PathType.FILES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}
