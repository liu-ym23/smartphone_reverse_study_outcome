package com.obric.aikernel;

import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.config.RequestParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a {
        public static void a(e r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
            Intrinsics.checkNotNullParameter(r11, "fd");
            Intrinsics.checkNotNullParameter(r12, "fout");
        }

        public static Bundle b(e r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r11, "args");
            if (Intrinsics.areEqual(e8.a.h(r11), IdlKeys.Method_GrantUri) == true) goto L5;
            return null;
        L5:
            return com.obric.aikernel.request.b.f4839c.e();
        }

        public static Object c(e r10, RequestParams r11, b r12, Continuation<? super b> r13) {
            return r12;
        }
    }

    boolean a(RequestParams r10);

    void b(FileDescriptor r10, PrintWriter r11, String[] r12);

    Object c(RequestParams r10, b r11, Continuation<? super Unit> r12);

    Object d(RequestParams r10, b r11, Continuation<? super b> r12);

    Bundle e(Bundle r10);
}
