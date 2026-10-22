package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
final class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f10542b = null;

    public static final class a extends ClassValue<Function1<? super Throwable, ? extends Throwable>> {
        a() {
        }
    }

    static {
        f10541a = new c();
        f10542b = new a();
    }

    private c() {
    }

    @Override // kotlinx.coroutines.internal.k
    public Function1<Throwable, Throwable> a(Class<? extends Throwable> r10) {
        return (Function1) f10542b.get(r10);
    }
}
