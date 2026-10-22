package androidx.core.net;

import ai.j0;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class UriKt {
    public static final File toFile(Uri r5) {
        if (Intrinsics.areEqual(r5.getScheme(), "file") == false) goto L11;
        String r10 = r5.getPath();
        if (r10 == null) goto L9;
        return new File(r10);
    L9:
        throw new IllegalArgumentException(j0.i(r5, "Uri path is null: ").toString());
    L11:
        throw new IllegalArgumentException(j0.i(r5, "Uri lacks 'file' scheme: ").toString());
    }

    public static final Uri toUri(String r5) {
        return Uri.parse(r5);
    }

    public static final Uri toUri(File r5) {
        return Uri.fromFile(r5);
    }
}
