package c8;

import com.obric.aikernel.sdk.config.RequestParams;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ boolean a(c r10, String r11, String r12, String r13, RequestParams r14, String r15, int r16, Object r17) {
            if (r17 != null) goto L13;
            if ((r16 & 8) == 0) goto L6;
            r14 = new RequestParams(null, null, 3, null);
        L6:
            RequestParams r18 = r14;
            if ((r16 & 16) == 0) goto L9;
            String r19 = null;
        L11:
            return r10.a(r11, r12, r13, r18, r19);
        L9:
            r19 = r15;
            goto L11
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkIsAvail");
        }
    }

    boolean a(String r10, String r11, String r12, RequestParams r13, String r14);
}
