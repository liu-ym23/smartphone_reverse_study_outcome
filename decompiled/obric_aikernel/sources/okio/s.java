package okio;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nNioSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NioSystemFileSystem.kt\nokio/NioSystemFileSystem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n1#2:93\n*E\n"})
public class s extends r {
    public s() {
    }

    private final Long h(FileTime r10) {
        Long r11 = Long.valueOf(r10.toMillis());
        if (r11.longValue() == 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L10;
        return null;
    L10:
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    @Override // okio.r, okio.i
    public h d(y r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        return g(r10.n());
    }

    protected final h g(Path r20) {
        Intrinsics.checkNotNullParameter(r20, "nioPath");
        Long r10 = null;
        BasicFileAttributes r11 = Files.readAttributes(r20, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Throwable -> L25
        if (r11.isSymbolicLink() == false) goto L7;
        Path r12 = Files.readSymbolicLink(r20);
    L8:
        boolean r13 = r11.isRegularFile();
        boolean r14 = r11.isDirectory();
        if (r12 == null) goto L11;
        y r15 = y.a.f(y.f12274g, r12, false, 1, null);
    L12:
        Long r16 = Long.valueOf(r11.size());
        FileTime r17 = r11.creationTime();
        if (r17 == null) goto L15;
        Long r18 = h(r17);
    L16:
        FileTime r19 = r11.lastModifiedTime();
        if (r19 == null) goto L19;
        Long r110 = h(r19);
    L20:
        FileTime r21 = r11.lastAccessTime();
        if (r21 == null) goto L24;
        r10 = h(r21);
    L24:
        return new h(r13, r14, r15, r16, r18, r110, r10, null, 128, null);
    L19:
        r110 = null;
        goto L20
    L15:
        r18 = null;
        goto L16
    L11:
        r15 = null;
        goto L12
    L7:
        r12 = null;
    L25:
        return null;
    }

    @Override // okio.r
    public String toString() {
        return "NioSystemFileSystem";
    }
}
