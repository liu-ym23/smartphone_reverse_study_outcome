package com.obric.aikernel.request;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.aikernel.request.a$a, reason: collision with other inner class name */
    public static final class C0111a {
        public static Object a(a r10, List<String> r11, RequestParams r12, com.obric.aikernel.b r13, Continuation<? super b> r14) {
            return new b(false, null, 3, null);
        }

        public static Object b(a r10, List<String> r11, RequestParams r12, com.obric.aikernel.b r13, Continuation<? super b> r14) {
            return new b(false, null, 3, null);
        }
    }

    Object a(String r10, RequestParams r11, Continuation<? super b> r12);

    Object b(String r10, RequestParams r11, Continuation<? super PackageResource> r12);

    Object c(List<String> r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super b> r13);

    Object d(String r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super b> r13);

    Object e(String r10, RequestParams r11, Continuation<? super PackageResource> r12);

    Object f(List<String> r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super b> r13);

    Object g(String r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super b> r13);

    Object h(String r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super b> r13);
}
