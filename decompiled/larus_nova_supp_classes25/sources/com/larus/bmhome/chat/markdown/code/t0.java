package com.larus.bmhome.chat.markdown.code;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t0 {
    public static final Lazy<Keva> d = null;
    public static final Lazy<Gson> e = null;
    public final MutableLiveData<ih8.b> a;
    public final MutableLiveData b;
    public boolean c;

    public static final class a {
        public static String a(String r3, String r4) {
            boolean r0 = true;
            if (r3 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L19;
            if (r4 != null) goto L12;
        L15:
            if (r0 == false) goto L18;
            return null;
        L18:
            return r3 + '_' + r4;
        L12:
            if (r4.length() == 0) goto L15;
            r0 = false;
            goto L15
        L19:
            return null;
        L5:
            if (r3.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public static ih8.b b(String r3, String r4) {
            String r5 = a(r3, r4);
            if (r5 != null) goto L16;
            return null;
        L16:
            String r6 = ((Keva) t0.d.getValue()).getString(r5, "");     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r6);     // Catch: Exception -> L13
            if (r6.length() != 0) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == true) goto L18;
            return (ih8.b) ((Gson) t0.e.getValue()).fromJson(r6, ih8.b.class);
        L18:
            return null;
        L8:
            r0 = false;
        L13:
            e = move-exception;
            FLogger.a.d("MarkdownCodePreviewer", "getCachedResponse error: " + e);
            return null;
        }
    }

    static {
        d = LazyKt.lazy(new r0());
        e = LazyKt.lazy(new s0());
    }

    public t0() {
        MutableLiveData<ih8.b> r0 = new MutableLiveData();
        this.a = r0;
        this.b = r0;
    }
}
