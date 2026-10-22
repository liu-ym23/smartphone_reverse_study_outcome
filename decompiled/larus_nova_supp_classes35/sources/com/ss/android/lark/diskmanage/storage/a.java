package com.ss.android.lark.diskmanage.storage;

import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends com.ss.android.lark.vfs2.file.b {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.diskmanage.storage.a$a, reason: collision with other inner class name */
    public static final class C0192a {
        public final jkc.c a;

        @Inject
        public C0192a(jkc.c r2) {
            Intrinsics.checkNotNullParameter(r2, "cipherManager");
            this.a = r2;
        }
    }

    public static final class b {
    }

    static {
        new WeakHashMap();
    }
}
