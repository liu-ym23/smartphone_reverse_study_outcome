package com.ss.android.lark.download.service.impl;

import com.bytedance.lark.pb.media.v1.FileState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final Map<String, wbb.d.a<wbb.d.b>> a;
    public final List<wbb.e> b;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileState.values().length];
            a = r0;
            r0[FileState.DOWNLOAD_WAIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[FileState.DOWNLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[FileState.DOWNLOAD_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[FileState.DOWNLOAD_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[FileState.DOWNLOAD_CANCEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[FileState.CANCEL_BY_RISK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class b {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public e() {
        this.a = new HashMap();
        this.b = new CopyOnWriteArrayList();
    }
}
