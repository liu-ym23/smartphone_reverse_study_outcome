package c2;

import com.bytedance.common.utility.Logger;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap f1105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f1106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f1107c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ Ref.IntRef f;
    public final /* synthetic */ Ref.ObjectRef g;

    public a(LinkedHashMap r5, Ref.IntRef r10, Ref.ObjectRef r11, Ref.ObjectRef r12, Ref.ObjectRef r13, Ref.IntRef r14, Ref.ObjectRef r15) {
        this.f1105a = r5;
        this.f1106b = r10;
        this.f1107c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        InputStream r5 = (InputStream) this.f1107c.element;     // Catch: Throwable -> L7
        if (r5 == null) goto L20;
        r5.close();     // Catch: Throwable -> L7
    L20:
        WeakReference r10 = (WeakReference) this.g.element;     // Catch: Throwable -> L17
        if (r10 == null) goto L24;
        ai.c r11 = (ai.c) r10.get();     // Catch: Throwable -> L17
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
}
