package kotlinx.coroutines.channels;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.c3;
import kotlinx.coroutines.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
final class m<E> implements c3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final kotlinx.coroutines.o<g<? extends E>> f10326c;

    /* JADX WARN: Multi-variable type inference failed */
    public m(kotlinx.coroutines.o<? super g<? extends E>> r10) {
        this.f10326c = r10;
    }

    @Override // kotlinx.coroutines.c3
    public void c(f0<?> r10, int r11) {
        this.f10326c.c(r10, r11);
    }
}
