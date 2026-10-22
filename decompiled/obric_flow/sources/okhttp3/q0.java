package okhttp3;

import java.io.File;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 {
    public static final p0 Companion = null;

    static {
        Companion = new p0();
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final q0 create(String r5, h0 r10) {
        Companion.getClass();
        return p0.a(r5, r10);
    }

    public abstract long contentLength();

    public abstract h0 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(nu.k r5);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    public static final q0 create(h0 r5, File r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r10, "$this$asRequestBody");
        return new ai.c0(1, r10, r5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final q0 create(h0 r5, String r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        return p0.a(r10, r5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final q0 create(h0 r5, ByteString r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r10, "$this$toRequestBody");
        return new ai.c0(2, r10, r5);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final q0 create(byte[] r5) {
        return p0.c(Companion, r5, null, 0, 7);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final q0 create(byte[] r5, h0 r10) {
        return p0.c(Companion, r5, r10, 0, 6);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final q0 create(byte[] r5, h0 r10, int r11) {
        return p0.c(Companion, r5, r10, r11, 4);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final q0 create(byte[] r5, h0 r10, int r11, int r12) {
        Companion.getClass();
        return p0.b(r5, r10, r11, r12);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final q0 create(ByteString r5, h0 r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$toRequestBody");
        return new ai.c0(2, r5, r10);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final q0 create(File r5, h0 r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$asRequestBody");
        return new ai.c0(1, r5, r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @JvmOverloads
    public static final q0 create(h0 r5, byte[] r10) {
        p0 r11 = Companion;
        int r12 = r10.length;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        return p0.b(r10, r5, 0, r12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @JvmOverloads
    public static final q0 create(h0 r5, byte[] r10, int r11) {
        p0 r12 = Companion;
        int r13 = r10.length;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        return p0.b(r10, r5, r11, r13);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @JvmOverloads
    public static final q0 create(h0 r5, byte[] r10, int r11, int r12) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        return p0.b(r10, r5, r11, r12);
    }
}
