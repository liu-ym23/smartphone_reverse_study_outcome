package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,158:1\n11400#2,3:159\n*S KotlinDebug\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n*L\n77#1:159,3\n*E\n"})
public class r extends i {
    public r() {
    }

    private final List<y> f(y r10, boolean r11) {
        File r12 = r10.m();
        String[] r13 = r12.list();
        if (r13 != null) goto L13;
        if (r11 == true) goto L6;
        return null;
    L6:
        if (r12.exists() == true) goto L10;
        throw new FileNotFoundException("no such file: " + r10);
    L10:
        throw new IOException("failed to list " + r10);
    L13:
        ArrayList r14 = new ArrayList();
        int r15 = 0;
        int r16 = r13.length;
    L14:
        if (r15 >= r16) goto L16;
        String r17 = r13[r15];
        Intrinsics.checkNotNull(r17);
        r14.add(r10.j(r17));
        r15 = r15 + 1;
        goto L14
    L16:
        CollectionsKt.sort(r14);
        return r14;
    }

    @Override // okio.i
    public List<y> a(y r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        List<y> r11 = f(r10, true);
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    @Override // okio.i
    public List<y> b(y r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        return f(r10, false);
    }

    @Override // okio.i
    public h d(y r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        File r12 = r13.m();
        boolean r10 = r12.isFile();
        boolean r11 = r12.isDirectory();
        long r14 = r12.lastModified();
        long r15 = r12.length();
        if (r10 == true) goto L14;
        if (r11 == true) goto L14;
        if (r14 != 0) goto L14;
        if (r15 != 0) goto L14;
        if (r12.exists() == true) goto L14;
        return null;
    L14:
        return new h(r10, r11, null, Long.valueOf(r15), null, Long.valueOf(r14), null, null, 128, null);
    }

    @Override // okio.i
    public g e(y r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        return new q(false, new RandomAccessFile(r10.m(), "r"));
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
