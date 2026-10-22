package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.a2;
import kotlinx.serialization.internal.r1;
import kotlinx.serialization.internal.u1;
import kotlinx.serialization.internal.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f19439a = null;

    static {
        Intrinsics.checkNotNullParameter(UInt.Companion, "<this>");
        Intrinsics.checkNotNullParameter(ULong.Companion, "<this>");
        Intrinsics.checkNotNullParameter(UByte.Companion, "<this>");
        Intrinsics.checkNotNullParameter(UShort.Companion, "<this>");
        f19439a = SetsKt.setOf(new kotlinx.serialization.descriptors.g[]{u1.f19353b, x1.f19371b, r1.f19340b, a2.f19260b});
    }
}
