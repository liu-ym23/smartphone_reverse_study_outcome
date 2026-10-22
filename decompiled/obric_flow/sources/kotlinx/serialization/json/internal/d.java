package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends dn.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bi.e f19419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jk.a f19420b;

    public d(bi.e r5, kotlinx.serialization.json.b r10) {
        Intrinsics.checkNotNullParameter(r5, "lexer");
        Intrinsics.checkNotNullParameter(r10, "json");
        this.f19419a = r5;
        this.f19420b = r10.f19385b;
    }

    @Override // dn.a, eu.b
    public final byte E() {
        bi.e r5 = this.f19419a;
        String r10 = r5.n();
        return UStringsKt.toUByte(r10);
    L5:
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Failed to parse type 'UByte' for input '", '\'', r10), 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final int g() {
        bi.e r5 = this.f19419a;
        String r10 = r5.n();
        return UStringsKt.toUInt(r10);
    L5:
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Failed to parse type 'UInt' for input '", '\'', r10), 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final long j() {
        bi.e r5 = this.f19419a;
        String r10 = r5.n();
        return UStringsKt.toULong(r10);
    L5:
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Failed to parse type 'ULong' for input '", '\'', r10), 0, null, 6);
        throw null;
    }

    @Override // eu.a
    public final int l(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // dn.a, eu.b
    public final short o() {
        bi.e r5 = this.f19419a;
        String r10 = r5.n();
        return UStringsKt.toUShort(r10);
    L5:
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Failed to parse type 'UShort' for input '", '\'', r10), 0, null, 6);
        throw null;
    }

    @Override // eu.a
    public final jk.a x() {
        return this.f19420b;
    }
}
