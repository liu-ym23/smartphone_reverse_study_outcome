package com.bytedance.android.live.profit.dress;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(DressModelWrapperJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001fB\t\b\u0016¢\u0006\u0004\b\u0019\u0010 R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/profit/dress/DressModelWrapper;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/p;", "Lvh7/h;", "", "jsonString$delegate", "Lkotlin/Lazy;", "getJsonString", "()Ljava/lang/String;", "jsonString", "Lcom/bytedance/android/live/profit/dress/o;", "decoded", "Lcom/bytedance/android/live/profit/dress/o;", "getDecoded", "()Lcom/bytedance/android/live/profit/dress/o;", "", "pbBytes", "[B", "getPbBytes", "()[B", "Lcom/google/gson/JsonObject;", "json", "Lcom/google/gson/JsonObject;", "getJson", "()Lcom/google/gson/JsonObject;", "<init>", "(Lcom/bytedance/android/live/profit/dress/o;[BLcom/google/gson/JsonObject;)V", "Lam3/g;", "reader", "(Lam3/g;)V", "bytes", "([B)V", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DressModelWrapper extends FlexModelBase<p> implements p, vh7.h {
    private final o decoded;
    private final JsonObject json;
    private final Lazy jsonString$delegate;
    private final byte[] pbBytes;

    @Override // com.bytedance.android.live.profit.dress.p
    public String getJsonString() {
        return (String) this.jsonString$delegate.getValue();
    }

    public DressModelWrapper() {
        this((o) vh7.f.c(o.class), null, null);
    }

    @Override // com.bytedance.android.live.profit.dress.p
    public o getDecoded() {
        return this.decoded;
    }

    @Override // com.bytedance.android.live.profit.dress.p
    public JsonObject getJson() {
        return this.json;
    }

    @Override // com.bytedance.android.live.profit.dress.p
    public byte[] getPbBytes() {
        return this.pbBytes;
    }

    public DressModelWrapper(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        this((o) vh7.f.b(r3, o.class), r3, null);
    }

    public DressModelWrapper(am3.g r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        this(am3.h.b(r2));
    }

    public DressModelWrapper(o r2, byte[] r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "decoded");
        super(p.class);
        this.decoded = r2;
        this.pbBytes = r3;
        this.json = r4;
        if (getPbBytes() == null) goto L5;
    L9:
        this.jsonString$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DressModelWrapper$jsonString$2(this));
        return;
    L5:
        if (getJson() != null) goto L9;
        throw new Error("both pb and json data is null");
    }
}
