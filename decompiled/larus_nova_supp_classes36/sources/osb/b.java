package osb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final String b;

    public static final class a {
        public String a;
        public String b;

        public a() {
        }
    }

    public final String toString() {
        return "ChatModeInitParam(appScene='" + this.a + "', link=" + this.b + ", appData=null, sceneId=null, belongToBot=null)";
    }

    public b(a r2) {
        String r0 = r2.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("appScene");
        r0 = null;
    L6:
        this.a = r0;
        this.b = r2.b;
    }
}
