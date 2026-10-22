package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.common.utility.Logger;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NativeRequestInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1606a;

    public static final enum RequestModified extends Enum<RequestModified> {
        private static final /* synthetic */ RequestModified[] $VALUES = null;
        public static final RequestModified BOTH_MODIFIED = null;
        public static final RequestModified HEADER_MODIFIED = null;
        public static final RequestModified NOT_MODIFIED = null;
        public static final RequestModified URL_MODIFIED = null;
        public final int mValue;

        static {
            RequestModified r10 = new RequestModified("NOT_MODIFIED", 0, 0);
            NOT_MODIFIED = r10;
            RequestModified r11 = new RequestModified("URL_MODIFIED", 1, 1);
            URL_MODIFIED = r11;
            RequestModified r12 = new RequestModified("HEADER_MODIFIED", 2, 2);
            HEADER_MODIFIED = r12;
            RequestModified r13 = new RequestModified("BOTH_MODIFIED", 3, 3);
            BOTH_MODIFIED = r13;
            $VALUES = new RequestModified[]{r10, r11, r12, r13};
        }

        private RequestModified(String r10, int r11, int r12) {
            super(r10, r11);
            this.mValue = r12;
        }

        public static RequestModified valueOf(String r10) {
            return (RequestModified) Enum.valueOf(RequestModified.class, r10);
        }

        public static RequestModified[] values() {
            return (RequestModified[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public interface a {
        b a(String r10, Map<String, String> r11, List<String> r12);

        c b(String r10, Map<String, List<String>> r11, int r12);
    }

    public static class b {
    }

    public static class c {
    }

    public static String a(String r10, Map<String, String> r11, List<String> r12) {
        if (f1606a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "request url:" + r10 + " headers:" + r11.toString() + " domains:" + r12);
    L8:
        f1606a.a(r10, r11, r12);
        return null;
    }

    public static String b(String r10, Map<String, List<String>> r11, int r12) {
        if (f1606a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "response url:" + r10 + " headers:" + r11.toString() + " code:" + r12);
    L8:
        f1606a.b(r10, r11, r12);
        return null;
    }
}
