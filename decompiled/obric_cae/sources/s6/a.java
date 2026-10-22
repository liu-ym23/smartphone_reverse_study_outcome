package s6;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0154a f12039a = null;

    /* JADX INFO: renamed from: s6.a$a, reason: collision with other inner class name */
    public class C0154a extends HashMap {
        public C0154a() {
            put("ocean_memorydata", "com.obric.memorydata");
            put("obric_assistant_aiagent", "com.obric.assistantaiagent");
            put("ocean_oauto", "com.obric.autoaction");
            put("obric_doubao_assistant", "com.larus.nova");
        }
    }

    static {
        f12039a = new C0154a();
    }

    public static boolean a(String r8) {
        return f12039a.containsKey(r8);
    }

    public static String b(String r8) {
        return (String) f12039a.get(r8);
    }
}
