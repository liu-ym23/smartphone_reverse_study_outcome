package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public interface SourceElement {
    public static final SourceElement NO_SOURCE = null;

    static {
        NO_SOURCE = new AnonymousClass1();
    }

    SourceFile getContainingFile();
}
