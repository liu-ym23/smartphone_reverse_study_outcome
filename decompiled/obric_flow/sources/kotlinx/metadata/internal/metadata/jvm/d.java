package kotlinx.metadata.internal.metadata.jvm;

import kotlinx.metadata.internal.protobuf.r;
import kotlinx.metadata.internal.protobuf.s;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements s {
    @Override // kotlinx.metadata.internal.protobuf.s
    public final r findValueByNumber(int r5) {
        return JvmProtoBuf$StringTableTypes.Record.Operation.valueOf(r5);
    }
}
