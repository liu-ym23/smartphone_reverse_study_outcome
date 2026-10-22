package b4;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends k {
    public final /* synthetic */ Map<String, String> a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.ObjectRef<InputStream> c;
    public final /* synthetic */ Ref.ObjectRef<String> d;
    public final /* synthetic */ Ref.ObjectRef<Throwable> e;
    public final /* synthetic */ Ref.IntRef f;
    public final /* synthetic */ Ref.ObjectRef<WeakReference<Call<TypedInput>>> g;

    @Override // b4.k
    public final void a() {
        InputStream r1 = (InputStream) this.c.element;     // Catch: Throwable -> L7
        if (r1 == null) goto L20;
        r1.close();     // Catch: Throwable -> L7
    L20:
        WeakReference r10 = (WeakReference) this.g.element;     // Catch: Throwable -> L17
        if (r10 == null) goto L24;
        Call r11 = (Call) r10.get();     // Catch: Throwable -> L17
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.isCanceled() == true) goto L26;
        r11.cancel();     // Catch: Throwable -> L17
        return;
    L26:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        Logger.e("HostNetworkDependImpl", "close call failed", th);
        return;
    L7:
        th = move-exception;
        Logger.e("HostNetworkDependImpl", "close inputStream failed", th);
        goto L20
    }

    public final String b() {
        return (String) this.d.element;
    }

    public final Throwable c() {
        return (Throwable) this.e.element;
    }

    public final InputStream d() {
        return (InputStream) this.c.element;
    }

    public c(Map<String, String> r1, Ref.IntRef r10, Ref.ObjectRef<InputStream> r11, Ref.ObjectRef<String> r12, Ref.ObjectRef<Throwable> r13, Ref.IntRef r14, Ref.ObjectRef<WeakReference<Call<TypedInput>>> r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }
}
