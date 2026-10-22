package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.squareup.wire.Message;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/RawBytesMessageBuilder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/RawBytesMessage;", "bytes", "", "<init>", "([B)V", "build", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class RawBytesMessageBuilder extends Message.Builder<RawBytesMessage, RawBytesMessageBuilder> {
    private final byte[] bytes;

    /* JADX INFO: renamed from: build, reason: collision with other method in class */
    public RawBytesMessage m210build() {
        return new RawBytesMessage(this.bytes);
    }

    public /* bridge */ /* synthetic */ Message build() {
        return m210build();
    }

    public RawBytesMessageBuilder(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        this.bytes = r2;
    }
}
