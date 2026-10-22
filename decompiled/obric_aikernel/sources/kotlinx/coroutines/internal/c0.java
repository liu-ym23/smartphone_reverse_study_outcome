package kotlinx.coroutines.internal;

import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final LockFreeLinkedListNode f10543a;

    public c0(LockFreeLinkedListNode r10) {
        this.f10543a = r10;
    }

    public String toString() {
        return "Removed[" + this.f10543a + ']';
    }
}
