package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface SourceElement {
    public static final SourceElement NO_SOURCE = null;

    SourceFile getContainingFile();

    static {
        NO_SOURCE = new AnonymousClass1();
    }
}
