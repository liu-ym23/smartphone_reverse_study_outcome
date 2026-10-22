package v4;

import k5.l;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12727a = null;

    public static class a extends l<Boolean> {
        @Override // k5.l
        public final Boolean a(Object[] r8) {
            Class<?> r10 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L4
            return Boolean.valueOf("harmony".equals(r10.getMethod("getOsBrand", new Class[0]).invoke(r10, new Object[0])));
        L5:
            return Boolean.FALSE;
        }
    }

    static {
        f12727a = new a();
    }
}
