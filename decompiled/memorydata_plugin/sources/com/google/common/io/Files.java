package com.google.common.io;

import com.google.common.base.o;
import com.google.common.graph.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class Files {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a<File> f4737a = null;

    /* JADX INFO: renamed from: com.google.common.io.Files$1, reason: invalid class name */
    class AnonymousClass1 {
    }

    private static abstract enum FilePredicate extends Enum<FilePredicate> implements o<File> {
        private static final /* synthetic */ FilePredicate[] $VALUES = null;
        public static final FilePredicate IS_DIRECTORY = null;
        public static final FilePredicate IS_FILE = null;

        private static /* synthetic */ FilePredicate[] $values() {
            return new FilePredicate[]{IS_DIRECTORY, IS_FILE};
        }

        static {
            final String r1 = "IS_DIRECTORY";
            final int r2 = 0;
            IS_DIRECTORY = new AnonymousClass1(r1, r2);
            final String r3 = "IS_FILE";
            final int r4 = 1;
            IS_FILE = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        private FilePredicate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ FilePredicate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static FilePredicate valueOf(String r2) {
            return (FilePredicate) ZeusTransformUtils.preCheckCast(Enum.valueOf(FilePredicate.class, r2), FilePredicate.class, "com.obric.memorydata.plugin");
        }

        public static FilePredicate[] values() {
            return (FilePredicate[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FilePredicate[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f4737a = new AnonymousClass2();
    }
}
