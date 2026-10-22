package d59;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.dynamic.t1;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/dynamic/entity/SingleProductDisplayV2Entity;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", "imageLink", "Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "batteryInfo", "Lcom/larus/dora/impl/dynamic/BatteryInfo;", "getBatteryInfo", "()Lcom/larus/dora/impl/dynamic/BatteryInfo;", "boxBatteryInfo", "getBoxBatteryInfo", "shouldVisible", "", "connected", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m implements j {

    @SerializedName("battery_info")
    private final com.larus.dora.impl.dynamic.b batteryInfo;

    @SerializedName("box_battery_info")
    private final com.larus.dora.impl.dynamic.b boxBatteryInfo;

    @SerializedName("image_link")
    private final t1 imageLink;

    public m() {
    }

    @Override // d59.j
    public final boolean a(boolean r1) {
        return true;
    }
}
