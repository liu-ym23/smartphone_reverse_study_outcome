package okio;

import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.internal.FileSystem;
import okio.internal.ResourceFileSystem;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,165:1\n52#2,21:166\n52#2,21:187\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n*L\n67#1:166,21\n81#1:187,21\n*E\n"})
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final i f12227b = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f12226a = new a(null);
        Class.forName("java.nio.file.Files");     // Catch: ClassNotFoundException -> L5
        i r10 = new s();     // Catch: ClassNotFoundException -> L5
    L6:
        f12227b = r10;
        y.a r11 = y.f12274g;
        String r12 = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(r12, "getProperty(...)");
        y.a.e(r11, r12, false, 1, null);
        ClassLoader r13 = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(r13, "getClassLoader(...)");
        new ResourceFileSystem(r13, false, null, 4, null);
        return;
    L5:
        r10 = new r();
        goto L6
    }

    public i() {
    }

    public abstract List<y> a(y r10);

    public abstract List<y> b(y r10);

    public final h c(y r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        return FileSystem.b(this, r10);
    }

    public abstract h d(y r10);

    public abstract g e(y r10);
}
