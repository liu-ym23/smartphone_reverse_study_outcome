package com.larus.platform.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s2 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CachedVideosPreloadFrom.values().length];
            r0[CachedVideosPreloadFrom.OUTER_FALLBACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[CachedVideosPreloadFrom.CMD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[CachedVideosPreloadFrom.BIND_PULL_API.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[CachedVideosPreloadFrom.REFRESH_VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[CachedVideosPreloadFrom.UN_CONSUMED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[CachedVideosPreloadFrom.UNLIMITED_FLOW.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final PrefetchVideoProcessStage a(CachedVideosPreloadFrom r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L5:
        switch(r2) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        return PrefetchVideoProcessStage.EXCEPTION;
    L15:
        return PrefetchVideoProcessStage.UNLIMITED_FLOW_PROCESS;
    L16:
        return PrefetchVideoProcessStage.UN_CONSUMED_PROCESS;
    L17:
        return PrefetchVideoProcessStage.REFRESH_PROCESS;
    L18:
        return PrefetchVideoProcessStage.BIND_PROCESS;
    L19:
        return PrefetchVideoProcessStage.CMD_PROCESS;
    L13:
        return PrefetchVideoProcessStage.CMD_PROCESS;
    L4:
        r2 = a.a[r1.ordinal()];
        goto L5
    }
}
