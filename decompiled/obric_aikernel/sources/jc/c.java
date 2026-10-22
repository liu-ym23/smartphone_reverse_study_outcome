package jc;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n*L\n1#1,218:1\n*E\n"})
public final class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f9918e;

    public c(String r10, boolean r11, Function0<Unit> r12) {
        this.f9918e = r12;
        super(r10, r11);
    }

    @Override // jc.a
    public long f() {
        this.f9918e.invoke();
        return -1;
    }
}
