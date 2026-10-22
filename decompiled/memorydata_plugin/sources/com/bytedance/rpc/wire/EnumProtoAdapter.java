package com.bytedance.rpc.wire;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Enum;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class EnumProtoAdapter<E extends Enum> extends ProtoAdapter<E> {
    private Method findByValueMethod;
    private Method getValueMethod;
    private Class<E> messageType;

    public EnumProtoAdapter(Class<E> r6) {
        super(FieldEncoding.VARINT, r6);
        this.messageType = r6;
        this.getValueMethod = r6.getMethod("getValue", new Class[0]);     // Catch: NoSuchMethodException -> L9
        this.findByValueMethod = r6.getMethod("findByValue", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L7
    L15:
        return;
    L7:
        this.findByValueMethod = r6.getMethod("fromValue", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L9
        return;
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private E fromValue(int r4) {
        return (E) ZeusTransformUtils.preCheckCast(this.findByValueMethod.invoke(null, new Object[]{Integer.valueOf(r4)}), Enum.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private int getValue(E r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(this.getValueMethod.invoke(r2, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r3) {
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.UINT32.decode(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();
        E r0 = (E) fromValue(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r4, this.messageType);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    public final void encode(ProtoWriter r2, E r3) {
        ProtoAdapter.UINT32.encode(r2, Integer.valueOf(getValue(r3)));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ void encode(ProtoWriter r3, Object r4) {
        encode(r3, (Enum) ZeusTransformUtils.preCheckCast(r4, Enum.class, "com.obric.memorydata.plugin"));
    }

    public final int encodedSize(E r2) {
        return ProtoAdapter.UINT32.encodedSize(Integer.valueOf(getValue(r2)));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ int encodedSize(Object r3) {
        return encodedSize((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"));
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }
}
