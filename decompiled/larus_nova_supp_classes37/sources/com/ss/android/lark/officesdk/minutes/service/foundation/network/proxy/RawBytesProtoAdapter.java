package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/RawBytesProtoAdapter;", "Lcom/squareup/wire/ProtoAdapter;", "", "<init>", "()V", "encodedSize", "", "value", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "redact", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class RawBytesProtoAdapter extends ProtoAdapter<byte[]> {
    public static final RawBytesProtoAdapter INSTANCE = null;

    static {
        INSTANCE = new RawBytesProtoAdapter();
    }

    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
    public byte[] m211decode(ProtoReader r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return new byte[0];
    }

    public byte[] redact(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        return r2;
    }

    private RawBytesProtoAdapter() {
        super(FieldEncoding.LENGTH_DELIMITED, byte[].class);
    }

    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return m211decode(r1);
    }

    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((byte[]) r1);
    }

    public /* bridge */ /* synthetic */ Object redact(Object r1) {
        return redact((byte[]) r1);
    }

    public int encodedSize(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        return r2.length;
    }

    public void encode(ProtoWriter r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r3, "writer");
        Intrinsics.checkNotNullParameter(r4, "value");
        ByteString.a r0 = ByteString.Companion;
        byte[] r5 = Arrays.copyOf(r4, r4.length);
        r0.getClass();
        r3.writeBytes(ByteString.a.c(r5));
    }

    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (byte[]) r2);
    }
}
