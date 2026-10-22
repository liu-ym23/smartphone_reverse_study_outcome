package com.larus.dora.impl.device_v2;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.dynamic.s1;
import com.larus.dora.impl.dynamic.t1;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/impl/device_v2/BindDeviceItem;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", "title", "Lcom/larus/dora/impl/dynamic/Identifier;", "getTitle", "()Lcom/larus/dora/impl/dynamic/Identifier;", "desc", "getDesc", "imageLink", "Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "bindButtonInfo", "Lcom/larus/dora/impl/device_v2/BindButtonInfo;", "getBindButtonInfo", "()Lcom/larus/dora/impl/device_v2/BindButtonInfo;", "buyButtonInfo", "Lcom/larus/dora/impl/device_v2/BuyButtonInfo;", "getBuyButtonInfo", "()Lcom/larus/dora/impl/device_v2/BuyButtonInfo;", "shouldVisible", "", "connected", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e implements d59.j {

    @SerializedName("bind_button_info")
    private final c bindButtonInfo;

    @SerializedName("buy_button_info")
    private final h buyButtonInfo;

    @SerializedName("desc")
    private final s1 desc;

    @SerializedName("image_link")
    private final t1 imageLink;

    @SerializedName("title")
    private final s1 title;

    public e() {
    }

    @Override // d59.j
    public final boolean a(boolean r1) {
        return true;
    }
}
