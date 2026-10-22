package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmLambdaVisitor;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/LambdaWriter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "stringTable", "<init>", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function$Builder;", "setT", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function$Builder;)V", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "getC", "()Lkotlinx/metadata/impl/e;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class LambdaWriter extends KmLambdaVisitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WriteContext f599c;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ProtoBuf.Function.Builder f600t;

    public LambdaWriter(StringTable r5) {
        Intrinsics.checkNotNullParameter(r5, "stringTable");
        super(null, 1, null);
        this.f599c = new WriteContext(r5, null, 2, null);
    }

    public final WriteContext getC() {
        return this.f599c;
    }

    public final ProtoBuf.Function.Builder getT() {
        return this.f600t;
    }

    public final void setT(ProtoBuf.Function.Builder r5) {
        this.f600t = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmLambdaVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return WritersKt.access$writeFunction(this.f599c, r5, r10, new AnonymousClass1(this));
    }
}
