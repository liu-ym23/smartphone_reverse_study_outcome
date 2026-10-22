package com.obric.aikernel.model.cloud.common;

import com.google.gson.k;
import java.util.Map;
import kotlin.collections.MapsKt;
import okhttp3.y;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c a(e r10, String r11, Map r12, Map r13, int r14, Object r15) {
            if (r15 != null) goto L12;
            if ((r14 & 2) == 0) goto L7;
            r12 = MapsKt.emptyMap();
        L7:
            if ((r14 & 4) == 0) goto L10;
            r13 = MapsKt.emptyMap();
        L10:
            return r10.b(r11, r12, r13);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeGet");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c b(e r10, String r11, Object r12, Map r13, Map r14, int r15, Object r16) {
            if (r16 != null) goto L12;
            if ((r15 & 4) == 0) goto L7;
            r13 = MapsKt.emptyMap();
        L7:
            if ((r15 & 8) == 0) goto L10;
            r14 = MapsKt.emptyMap();
        L10:
            return r10.a(r11, r12, r13, r14);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executePost");
        }
    }

    c a(String r10, Object r11, Map<String, String> r12, Map<String, String> r13);

    c b(String r10, Map<String, String> r11, Map<String, String> r12);

    c c(String r10, y r11, Map<String, String> r12, Map<String, String> r13);

    c d(String r10, Object r11, Map<String, String> r12, Map<String, String> r13);

    c e(String r10, k r11, k r12, k r13);

    c f(String r10, String r11, Map<String, String> r12, Map<String, String> r13);
}
