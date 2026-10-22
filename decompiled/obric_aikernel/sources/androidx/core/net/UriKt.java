package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class UriKt {
    public static final File toFile(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getScheme(), "file") == false) goto L11;
        String r11 = r10.getPath();
        if (r11 == null) goto L9;
        return new File(r11);
    L9:
        throw new IllegalArgumentException(("Uri path is null: " + r10).toString());
    L11:
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + r10).toString());
    }

    public static final Uri toUri(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Uri r11 = Uri.fromFile(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "fromFile(this)");
        return r11;
    }

    public static final Uri toUri(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Uri r11 = Uri.parse(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "parse(this)");
        return r11;
    }
}
