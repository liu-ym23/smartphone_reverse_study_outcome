package b;

import android.util.Log;
import com.obric.aikernel.runtime.utils.i;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f488c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f490b;

    public a() {
    }

    public static a d() {
        if (f488c != null) goto L6;
        f488c = new a();
    L6:
        return f488c;
    }

    private void f() {
        if (this.f490b != null) goto L5;
    L11:
        Class<?> r10 = Class.forName(h());     // Catch: Exception -> L8
        this.f489a = r10;     // Catch: Exception -> L8
        this.f490b = r10.newInstance();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("BDKeyManagerRef", "init failed, " + e.getMessage());
        return;
    L5:
        if (this.f489a == null) goto L11;
    }

    private String h() {
        return i.f();
    }

    public long a() {
        f();
        Method r10 = this.f489a.getDeclaredMethod("getAlgorithmAddress", new Class[0]);     // Catch: Exception -> L5
        r10.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) r10.invoke(this.f490b, new Object[0])).longValue();
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getAlgorithmAddress failed, " + e.getMessage());
        return -1;
    }

    public List<X509Certificate> b(String r10) {
        f();
        Method r11 = this.f489a.getDeclaredMethod("getCertChain", new Class[]{String.class});     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        return (List) r11.invoke(this.f490b, new Object[]{r10});
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getCertChain failed, " + e.getMessage());
        return null;
    }

    public long c(String r10) {
        f();
        Method r11 = this.f489a.getDeclaredMethod("getDoSignAddress", new Class[]{String.class});     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) r11.invoke(this.f490b, new Object[]{r10})).longValue();
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getDoSignAddress failed, " + e.getMessage());
        return -1;
    }

    public PrivateKey e(String r10) {
        f();
        Method r11 = this.f489a.getDeclaredMethod("getPrivateKey", new Class[]{String.class});     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        return (PrivateKey) r11.invoke(this.f490b, new Object[]{r10});
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getPrivateKey failed, " + e.getMessage());
        return null;
    }

    public boolean g(String r10) {
        f();
        Method r11 = this.f489a.getDeclaredMethod("isContainsKey", new Class[]{String.class});     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) r11.invoke(this.f490b, new Object[]{r10})).booleanValue();
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "isContainsKey failed, " + e.getMessage());
        return false;
    }
}
