package androidx.room.jarjarred.kotlinx.metadata.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H&J\u0006\u0010\n\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMemberSignature;", "", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "name", "getName", "asString", "toString", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JvmMemberSignature {
    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker r5) {
        this();
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }

    private JvmMemberSignature() {
    }
}
