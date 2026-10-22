package androidx.room.util;

import com.lynx.serval.svg.SVGRenderEngine;
import java.io.File;
import java.nio.file.Path;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/room/util/SchemaFileResolver;", "", "getFile", "Ljava/io/File;", SVGRenderEngine.PATH, "Ljava/nio/file/Path;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SchemaFileResolver {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/room/util/SchemaFileResolver$Companion;", "", "()V", "DEFAULT_RESOLVER", "androidx/room/util/SchemaFileResolver$Companion$DEFAULT_RESOLVER$1", "Landroidx/room/util/SchemaFileResolver$Companion$DEFAULT_RESOLVER$1;", "RESOLVER", "Landroidx/room/util/SchemaFileResolver;", "getRESOLVER", "()Landroidx/room/util/SchemaFileResolver;", "RESOLVER$delegate", "Lkotlin/Lazy;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final SchemaFileResolver$Companion$DEFAULT_RESOLVER$1 DEFAULT_RESOLVER = null;
        private static final Lazy<SchemaFileResolver> RESOLVER$delegate = null;

        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.room.util.SchemaFileResolver$Companion$DEFAULT_RESOLVER$1] */
        static {
            $$INSTANCE = new Companion();
            RESOLVER$delegate = LazyKt.lazy(SchemaFileResolver$Companion$RESOLVER$2.INSTANCE);
            DEFAULT_RESOLVER = new SchemaFileResolver$Companion$DEFAULT_RESOLVER$1();
        }

        private Companion() {
        }

        public static final /* synthetic */ SchemaFileResolver$Companion$DEFAULT_RESOLVER$1 access$getDEFAULT_RESOLVER$p() {
            return DEFAULT_RESOLVER;
        }

        public final SchemaFileResolver getRESOLVER() {
            return RESOLVER$delegate.getValue();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    File getFile(Path r5);
}
