package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.ClassNameKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0001j\u0002`\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"jvmInternalName", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "getJvmInternalName", "(Ljava/lang/String;)Ljava/lang/String;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "JvmMetadataUtil")
public final class JvmMetadataUtil {
    public static final String getJvmInternalName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (ClassNameKt.isLocal(r5) == false) goto L6;
        return r5.substring(1);
    L6:
        return StringsKt.E(r5, '.', Typography.dollar);
    }
}
