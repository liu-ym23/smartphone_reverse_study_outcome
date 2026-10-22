package com.bytedance.lark.lark_bitable_android;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H&J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/NativeLib;", "Lcom/sun/jna/Library;", "molten_ffi_init_lark_bitable_bc8fdfae5ca0c1aa", "", "frontend", "", "library_id", "entry", "Lcom/bytedance/lark/lark_bitable_android/CallbackEntry;", "molten_ffi_lark_bitable_call", "Lcom/bytedance/lark/lark_bitable_android/BufferCallStatus$ByValue;", "runtime", "Lcom/sun/jna/Pointer;", "pointer", "method", "param", "Lcom/bytedance/lark/lark_bitable_android/RustBuffer$ByValue;", "molten_ffi_lark_bitable_free", "molten_ffi_rustbuffer_alloc", "capacity", "molten_ffi_rustbuffer_free", "", "buf", "molten_ffi_rustbuffer_from_bytes", "bytes", "Lcom/bytedance/lark/lark_bitable_android/ForeignBytes$ByValue;", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeLib extends Library {
    public static final Companion Companion = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<NativeLib> b = null;
        public static final Lazy<Pointer> c = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(NativeLib$Companion$INSTANCE$2.INSTANCE);
            c = LazyKt.lazy(NativeLib$Companion$runtime$2.INSTANCE);
        }

        public static NativeLib a() {
            return (NativeLib) b.getValue();
        }

        public static Pointer b() {
            return (Pointer) c.getValue();
        }
    }

    static {
        Companion = Companion.a;
    }

    long molten_ffi_init_lark_bitable_bc8fdfae5ca0c1aa(int r1, long r10, CallbackEntry r11);

    BufferCallStatus.ByValue molten_ffi_lark_bitable_call(Pointer r1, Pointer r10, long r11, RustBuffer.ByValue r12);

    BufferCallStatus.ByValue molten_ffi_lark_bitable_free(Pointer r1, Pointer r10, long r11);

    RustBuffer.ByValue molten_ffi_rustbuffer_alloc(int r1);

    void molten_ffi_rustbuffer_free(RustBuffer.ByValue r1);

    RustBuffer.ByValue molten_ffi_rustbuffer_from_bytes(ForeignBytes.ByValue r1);
}
