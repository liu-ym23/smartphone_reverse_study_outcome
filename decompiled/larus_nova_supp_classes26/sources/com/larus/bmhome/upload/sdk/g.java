package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final ConcurrentHashMap<String, j> a = null;
    public static final ConcurrentHashMap<String, gs8.b> b = null;
    public static final ConcurrentHashMap<String, l> c = null;
    public static final ConcurrentHashMap<String, Boolean> d = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadScene.values().length];
            r0[UploadScene.O_SERVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[UploadScene.O_MOBILE_TMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "identifier");
        a.remove(r1);
        b.remove(r1);
        c.remove(r1);
        d.remove(r1);
    }
}
