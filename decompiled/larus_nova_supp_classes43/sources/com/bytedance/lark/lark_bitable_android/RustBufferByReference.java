package com.bytedance.lark.lark_bitable_android;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/RustBufferByReference;", "Lcom/sun/jna/ptr/ByReference;", "()V", "setValue", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Lcom/bytedance/lark/lark_bitable_android/RustBuffer$ByValue;", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RustBufferByReference extends ByReference {
    public RustBufferByReference() {
        super(16);
    }

    public final void setValue(RustBuffer.ByValue r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        Pointer r0 = getPointer();
        r0.setInt(0, r10.capacity);
        r0.setInt(4, r10.len);
        r0.setPointer(8, r10.data);
    }
}
