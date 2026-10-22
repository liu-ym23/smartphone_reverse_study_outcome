package yt0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import io.reactivex.Single;
import java.util.List;
import zt0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends dy0.c {
    f getPrivilegeSlardarMonitor();

    List<zo2.a> getProfitNitaViewList();

    void showVipEmojiTemplatePanel(String r1, String r2);

    Single<e<com.bytedance.android.live.profit.vip.model.b>> uploadVipCustomEmoji(int r1, String r2, MultipartTypedOutput r3);
}
