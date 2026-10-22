package g50;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h2;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c extends IService {
    h2 findLiteGiftById(long r1);

    void openGiftDialog(int r1, long r2, Bundle r4, List<String> r5, boolean r6, String r7);

    void openGiftDialog(int r1, long r2, String r4, Bundle r5, int r6, JSONObject r7, String r8);

    void openGiftDialog(IBaseUser r1);

    void openGiftDialog(IBaseUser r1, Bundle r2);

    void registerRecommendReceiver(String r1, String r2, Map<String, String> r3, Map<String, String> r4);
}
