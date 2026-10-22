package zv0;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface f {
    long getAvailableDiamonds();

    ExchangeInfo getExchangeInfo();

    boolean isDiamondAvailable(long r1);

    boolean isSyncWalletInfoSuccess();

    Observable<ExchangeInfo> observeExchangeInfo();

    Observable<Long> observeWallet();

    void setAvailableDiamonds(long r1);

    void sync(String r1);

    void syncExchangeInfo();

    void syncFromEnterRoom();

    void syncWithExtra(String r1, String r2);
}
