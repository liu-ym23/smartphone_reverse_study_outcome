package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface m {
    public static final a q0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static String a(String r3) {
            if (r3 != null) goto L4;
            return "";
        L4:
            if (r3.length() > 6) goto L9;
            return r3;
        L9:
            return r3.subSequence(0, 5).toString() + "...";
        }
    }

    static {
        q0 = a.a;
    }
}
