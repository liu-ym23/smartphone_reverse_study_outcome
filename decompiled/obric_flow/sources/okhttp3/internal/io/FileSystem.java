package okhttp3.internal.io;

import cn.nubia.neopush.commons.Constant;
import f4.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.a0;
import nu.c0;
import nu.t;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/io/FileSystem;", "", "Ljava/io/File;", "file", "Lnu/c0;", "source", "(Ljava/io/File;)Lnu/c0;", "Lnu/a0;", "sink", "(Ljava/io/File;)Lnu/a0;", "appendingSink", "", Constant.ClientMessageType.DELETE, "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface FileSystem {
    public static final Companion Companion = null;

    @JvmField
    public static final FileSystem SYSTEM = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "()V", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "SystemFileSystem", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion$SystemFileSystem;", "Lokhttp3/internal/io/FileSystem;", "<init>", "()V", "Ljava/io/File;", "file", "Lnu/c0;", "source", "(Ljava/io/File;)Lnu/c0;", "Lnu/a0;", "sink", "(Ljava/io/File;)Lnu/a0;", "appendingSink", "", Constant.ClientMessageType.DELETE, "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "", "toString", "()Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class SystemFileSystem implements FileSystem {
            public SystemFileSystem() {
            }

            @Override // okhttp3.internal.io.FileSystem
            public a0 appendingSink(File r5) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r5, "file");
                Logger r10 = t.f20339a;     // Catch: FileNotFoundException -> L5
                Intrinsics.checkNotNullParameter(r5, "$this$appendingSink");     // Catch: FileNotFoundException -> L5
                return b.n(new FileOutputStream(r5, true));
            L5:
                r5.getParentFile().mkdirs();
                Logger r11 = t.f20339a;
                Intrinsics.checkNotNullParameter(r5, "$this$appendingSink");
                return b.n(new FileOutputStream(r5, true));
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File r5) throws IOException {
                Intrinsics.checkNotNullParameter(r5, "file");
                if (r5.delete() == false) goto L5;
                return;
            L5:
                if (r5.exists() == true) goto L8;
                return;
            L8:
                throw new IOException("failed to delete " + r5);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File r5) throws IOException {
                Intrinsics.checkNotNullParameter(r5, "directory");
                File[] r10 = r5.listFiles();
                if (r10 == null) goto L16;
                int r11 = r10.length;
                int r12 = 0;
            L5:
                if (r12 >= r11) goto L14;
                File r13 = r10[r12];
                if (r13.isDirectory() == false) goto L10;
                deleteContents(r13);
            L10:
                if (r13.delete() == false) goto L13;
                r12 = r12 + 1;
                goto L5
            L13:
                throw new IOException("failed to delete " + r13);
            L14:
                return;
            L16:
                throw new IOException("not a readable directory: " + r5);
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File r5) {
                Intrinsics.checkNotNullParameter(r5, "file");
                return r5.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File r5, File r10) throws IOException {
                Intrinsics.checkNotNullParameter(r5, "from");
                Intrinsics.checkNotNullParameter(r10, "to");
                delete(r10);
                if (r5.renameTo(r10) == false) goto L6;
                return;
            L6:
                throw new IOException("failed to rename " + r5 + " to " + r10);
            }

            @Override // okhttp3.internal.io.FileSystem
            public a0 sink(File r5) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r5, "file");
                Logger r10 = t.f20339a;     // Catch: FileNotFoundException -> L5
                Intrinsics.checkNotNullParameter(r5, "$this$sink");     // Catch: FileNotFoundException -> L5
                return b.n(new FileOutputStream(r5, false));
            L5:
                r5.getParentFile().mkdirs();
                Logger r11 = t.f20339a;
                Intrinsics.checkNotNullParameter(r5, "$this$sink");
                return b.n(new FileOutputStream(r5, false));
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File r5) {
                Intrinsics.checkNotNullParameter(r5, "file");
                return r5.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public c0 source(File r5) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r5, "file");
                Logger r10 = t.f20339a;
                Intrinsics.checkNotNullParameter(r5, "$this$source");
                return b.p(new FileInputStream(r5));
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        SYSTEM = new Companion.SystemFileSystem();
    }

    a0 appendingSink(File r5) throws FileNotFoundException;

    void delete(File r5) throws IOException;

    void deleteContents(File r5) throws IOException;

    boolean exists(File r5);

    void rename(File r5, File r10) throws IOException;

    a0 sink(File r5) throws FileNotFoundException;

    long size(File r5);

    c0 source(File r5) throws FileNotFoundException;
}
