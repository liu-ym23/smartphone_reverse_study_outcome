package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ai.event.MessageIndication;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000 \b2\u00020\u0001:\u0002\u0007\bB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/BufferCallStatus;", "Lcom/sun/jna/Structure;", "code", "", "data", "Lcom/bytedance/lark/lark_bitable_android/RustBuffer$ByValue;", "(ILcom/bytedance/lark/lark_bitable_android/RustBuffer$ByValue;)V", "ByValue", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"code", "data"})
public class BufferCallStatus extends Structure {
    public static final Companion Companion = null;
    public int code;
    public RustBuffer.ByValue data;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/BufferCallStatus$ByValue;", "Lcom/bytedance/lark/lark_bitable_android/BufferCallStatus;", "Lcom/sun/jna/Structure$ByValue;", "()V", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ByValue extends BufferCallStatus implements Structure.ByValue {
        public ByValue() {
            RustBuffer.ByValue r0 = null;
            int r10 = 0;
            super(r10, r0, 3, r0);
        }
    }

    public static final class Companion {
        public Companion() {
        }

        public static BufferCallStatus a(String r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            final byte[] r11 = r10.getBytes(Charsets.UTF_8);
            int r1 = r11.length;
            Function1<OutputStream, Unit> r12 = new BufferCallStatus$Companion$panic$1(r11);
            Intrinsics.checkNotNullParameter(r12, "write_block");
            if (r1 <= 0) goto L5;
            RustBuffer.Companion.getClass();
            RustBuffer.ByValue r13 = RustBuffer.a.a(r1);
            Pointer r14 = r13.data;
            Intrinsics.checkNotNull(r14);
            o0 r15 = new o0(r14);
            r12.invoke(r15);
            r15.close();
        L7:
            return new BufferCallStatus(2, r13);
        L5:
            RustBuffer.Companion.getClass();
            r13 = RustBuffer.a.a(0);
            goto L7
        }

        public static BufferCallStatus b(Companion r10) {
            RustBuffer.ByValue r0 = new RustBuffer.ByValue();
            r10.getClass();
            Intrinsics.checkNotNullParameter(r0, "data");
            return new BufferCallStatus(0, r0);
        }
    }

    static {
        Companion = new Companion();
    }

    public BufferCallStatus() {
        RustBuffer.ByValue r0 = null;
        int r10 = 0;
        this(r10, r0, 3, r0);
    }

    public BufferCallStatus(int r10, RustBuffer.ByValue r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        this.code = r10;
        this.data = r11;
    }

    public /* synthetic */ BufferCallStatus(int r1, RustBuffer.ByValue r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = new RustBuffer.ByValue();
    L8:
        this(r1, r10);
    }
}
