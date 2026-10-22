package o1;

import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Singleton<Boolean> f11386a = null;

    static class a extends Singleton<Boolean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        protected Boolean create(Object... r10) {
            Class<?> r11 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L4
            return Boolean.valueOf("harmony".equals(r11.getMethod("getOsBrand", new Class[0]).invoke(r11, new Object[0])));
        L5:
            return Boolean.FALSE;
        }

        @Override // com.bytedance.bdinstall.util.Singleton
        protected /* bridge */ /* synthetic */ Boolean create(Object[] r10) {
            return create(r10);
        }
    }

    static {
        f11386a = new a();
    }

    public static boolean a() {
        return f11386a.get(new Object[0]).booleanValue();
    }
}
