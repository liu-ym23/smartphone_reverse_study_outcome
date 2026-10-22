package com.bytedance.rpc.wire;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArrayProtoAdapter extends ProtoAdapter<byte[]> {
    public ByteArrayProtoAdapter() {
        super(FieldEncoding.LENGTH_DELIMITED, byte[].class);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ byte[] decode(ProtoReader r1) {
        return decode2(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public byte[] decode2(ProtoReader r1) {
        return r1.readBytes().toByteArray();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ void encode(ProtoWriter r3, byte[] r4) {
        encode2(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ProtoWriter r1, byte[] r2) {
        r1.writeBytes(ByteString.of(r2));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ int encodedSize(byte[] r3) {
        return encodedSize2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
    public int encodedSize2(byte[] r1) {
        return r1.length;
    }
}
