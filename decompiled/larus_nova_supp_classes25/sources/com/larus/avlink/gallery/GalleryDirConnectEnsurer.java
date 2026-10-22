package com.larus.avlink.gallery;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GalleryDirConnectEnsurer {
    public static final AtomicBoolean a = null;
    public static final CoroutineScope b = null;
    public static final GalleryDirConnectEnsurer$doraLinkCallback$1 c = null;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.avlink.gallery.GalleryDirConnectEnsurer$doraLinkCallback$1] */
    static {
        a = new AtomicBoolean(false);
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new GalleryDirConnectEnsurer$doraLinkCallback$1();
    }
}
