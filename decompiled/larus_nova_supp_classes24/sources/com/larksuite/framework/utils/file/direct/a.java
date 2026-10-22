package com.larksuite.framework.utils.file.direct;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larksuite.framework.utils.file.direct.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0055a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DirectFileAccess.PathType.values().length];
            r0[DirectFileAccess.PathType.CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DirectFileAccess.PathType.FILES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DirectFileAccess.PathType.ROOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }
}
