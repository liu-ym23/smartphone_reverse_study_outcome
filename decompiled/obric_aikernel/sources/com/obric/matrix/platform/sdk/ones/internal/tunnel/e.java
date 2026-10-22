package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import com.obric.matrix.proto.Response;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends f9.b.a {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public e() {
    }

    @Override // f9.b
    public void t1(int r10, byte[] r11) {
        e9.b.b("DefaultServerCallbackImpl", "onResult(cmd: " + r10 + ", bytes: " + r11 + ").", null, 4, null);
        Iterator<T> r12 = i.f5899a.n().iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        c r13 = (c) r12.next();
        e9.b.b("DefaultServerCallbackImpl", "notification start", null, 4, null);     // Catch: Exception -> L14
        if (r11 == null) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == true) goto L11;
        throw new IllegalStateException("result bytes is null".toString());     // Catch: Exception -> L14
    L11:
        Response r15 = Response.ADAPTER.decode(r11);     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r15, "ADAPTER.decode(bytes)");     // Catch: Exception -> L14
        r13.a(r10, r15);     // Catch: Exception -> L14
        goto L4
    L9:
        r14 = false;
    L14:
        e = move-exception;
        e9.b.b("DefaultServerCallbackImpl", "on notification exception " + Log.getStackTraceString(e), null, 4, null);
        goto L4
    }
}
