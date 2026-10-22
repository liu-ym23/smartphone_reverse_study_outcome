package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public interface z extends a0 {
    int getSerializedSize();

    y newBuilderForType();

    y toBuilder();

    byte[] toByteArray();

    void writeTo(g r5);
}
