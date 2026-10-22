package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/RawBytesMessage;", "Lcom/squareup/wire/Message;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/RawBytesMessageBuilder;", "bytes", "", "<init>", "([B)V", "newBuilder", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class RawBytesMessage extends Message<RawBytesMessage, RawBytesMessageBuilder> {
    private static final ProtoAdapter<RawBytesMessage> ADAPTER = null;
    public static final a Companion = null;
    private final byte[] bytes;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final Class<RawBytesMessage> r1 = RawBytesMessage.class;
        ADAPTER = new RawBytesMessage$Companion$ADAPTER$1(r0, r1);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public RawBytesMessageBuilder m208newBuilder() {
        return new RawBytesMessageBuilder(this.bytes);
    }

    public String toString() {
        return "RawBytesMessage(size=" + this.bytes.length + ')';
    }

    public static final /* synthetic */ ProtoAdapter access$getADAPTER$cp() {
        return ADAPTER;
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m208newBuilder();
    }

    public RawBytesMessage(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        super(ADAPTER, ByteString.EMPTY);
        this.bytes = r3;
    }

    public static final /* synthetic */ byte[] access$getBytes$p(RawBytesMessage r0) {
        return r0.bytes;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof RawBytesMessage) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.bytes, ((RawBytesMessage) r2).bytes) == false) goto L7;
        return true;
    }
}
