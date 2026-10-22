package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }

    public boolean equals(Object r2) {
        return getValue().equals(r2);
    }
}
