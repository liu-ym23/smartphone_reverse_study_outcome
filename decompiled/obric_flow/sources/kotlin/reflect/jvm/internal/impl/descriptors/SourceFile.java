package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = null;

    static {
        NO_SOURCE_FILE = new AnonymousClass1();
    }

    String getName();
}
