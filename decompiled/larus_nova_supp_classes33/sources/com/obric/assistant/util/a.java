package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final Set<String> a = null;

    /* JADX INFO: renamed from: com.obric.assistant.util.a$a, reason: collision with other inner class name */
    public static final class C0027a {
        public final List<String> a;
        public final List<String> b;

        public C0027a() {
            List r0 = null;
            this(r0, r0, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0027a) == true) goto L8;
            return false;
        L8:
            C0027a r6 = (C0027a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PathClassifyResult(imagePaths=" + this.a + ", otherPaths=" + this.b + ')';
        }

        public C0027a(List<String> r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "imagePaths");
            Intrinsics.checkNotNullParameter(r3, "otherPaths");
            this.a = r2;
            this.b = r3;
        }

        public /* synthetic */ C0027a(List r2, List r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = CollectionsKt.emptyList();
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = CollectionsKt.emptyList();
        L8:
            this(r2, r3);
        }
    }

    public static final class b {
        public final List<String> a;
        public final List<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PathSplitResult(imagePaths=" + this.a + ", otherPaths=" + this.b + ')';
        }

        public b(List<String> r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "imagePaths");
            Intrinsics.checkNotNullParameter(r3, "otherPaths");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"png", "jpg", "jpeg", "webp", "heic", "heif", "bmp"});
    }

    public static C0027a a(File r12) {
        int r2 = 3;
        List r3 = null;
        if (r12.exists() == true) goto L6;
        FLogger.a.w("ObricTipOffDialogFragment", "gui log classification skipped: path not found, rawPath=" + r12.getAbsolutePath());
        return new C0027a(r3, r3, r2);
    L6:
        int r4 = 1;
        int r5 = 2;
        if (r12.isFile() == false) goto L14;
        if (a.contains(FilesKt.getExtension(r12).toLowerCase(Locale.ROOT)) == false) goto L12;
        return new C0027a(CollectionsKt.listOf(r12.getAbsolutePath()), r3, r5);
    L12:
        return new C0027a(r3, CollectionsKt.listOf(r12.getAbsolutePath()), r4);
    L14:
        if (r12.isDirectory() == false) goto L16;
        File[] r0 = r12.listFiles();
        int r6 = 0;
        if (r0 != null) goto L21;
        r0 = new File[0];
    L21:
        if (r0.length != 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
        FLogger.a.i("ObricTipOffDialogFragment", "gui log classification skipped: empty directory, dir=" + r12.getAbsolutePath());
        return new C0027a(r3, r3, r2);
    L27:
        LinkedHashSet r8 = new LinkedHashSet();
        LinkedHashSet r9 = new LinkedHashSet();
        int r10 = r0.length;
    L28:
        if (r6 >= r10) goto L31;
        File r11 = r0[r6];
        Intrinsics.checkNotNull(r11);
        C0027a r13 = a(r11);
        r8.addAll(r13.a);
        r9.addAll(r13.b);
        r6 = r6 + 1;
        goto L28
    L31:
        if (r8.isEmpty() == false) goto L36;
        if (r9.isEmpty() == false) goto L36;
        FLogger.a.i("ObricTipOffDialogFragment", "gui log classification skipped: no uploadable files under directory, dir=" + r12.getAbsolutePath());
        return new C0027a(r3, r3, r2);
    L36:
        if ((!r8.isEmpty()) == false) goto L42;
        if (r9.isEmpty() == false) goto L42;
        FLogger.a.i("ObricTipOffDialogFragment", "gui log classification: directory contains images only, keep directory path, dir=" + r12.getAbsolutePath());
        C0027a r1 = new C0027a(CollectionsKt.listOf(r12.getAbsolutePath()), r3, r5);
    L51:
        return r1;
    L42:
        if (r8.isEmpty() == true) goto L44;
    L46:
        FLogger.a.i("ObricTipOffDialogFragment", "gui log classification: directory contains both image and non-image files, split into child paths, dir=" + r12.getAbsolutePath());
        return new C0027a(CollectionsKt.toList(r8), CollectionsKt.toList(r9));
    L44:
        if ((!r9.isEmpty()) == false) goto L46;
        FLogger.a.i("ObricTipOffDialogFragment", "gui log classification: directory contains non-image files only, keep directory path, dir=" + r12.getAbsolutePath());
        r1 = new C0027a(r3, CollectionsKt.listOf(r12.getAbsolutePath()), r4);
        goto L51
    L23:
        r7 = false;
        goto L24
    L16:
        return new C0027a(r3, r3, r2);
    }
}
