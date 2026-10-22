package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/TableElementWrapper;", "Element", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/GeneratedMessageLite$Builder;", "", "builder", "(Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;)V", "getBuilder", "()Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/GeneratedMessageLite$Builder;", "bytes", "", "hashCode", "", "equals", "", "other", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class TableElementWrapper<Element extends GeneratedMessageLite.Builder<?, Element>> {
    private final Element builder;
    private final byte[] bytes;
    private final int hashCode;

    public TableElementWrapper(Element r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.builder = r5;
        byte[] r10 = r5.build().toByteArray();
        this.bytes = r10;
        this.hashCode = Arrays.hashCode(r10);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof TableElementWrapper) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.bytes, ((TableElementWrapper) r5).bytes) == false) goto L7;
        return true;
    }

    public final Element getBuilder() {
        return this.builder;
    }

    public int hashCode() {
        return this.hashCode;
    }
}
