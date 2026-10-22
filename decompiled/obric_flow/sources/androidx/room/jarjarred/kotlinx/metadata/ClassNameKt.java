package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004*\n\u0010\u0005\"\u00020\u00022\u00020\u0002¨\u0006\u0006"}, d2 = {"isLocal", "", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "(Ljava/lang/String;)Z", "ClassName", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "ClassNameKt")
public final class ClassNameKt {
    public static final boolean isLocal(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return StringsKt.P(r5, ".");
    }
}
