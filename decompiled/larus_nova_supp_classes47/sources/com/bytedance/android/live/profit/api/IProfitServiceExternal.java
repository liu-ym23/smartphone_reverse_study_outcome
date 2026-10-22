package com.bytedance.android.live.profit.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.profit.vip.model.b;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import zo2.a;
import zt0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.profit.ProfitServiceWrapper")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J,\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/api/IProfitServiceExternal;", "Lcom/bytedance/android/live/base/IService;", "", "requestPage", "authorId", "", "showVipEmojiTemplatePanel", "", "ratioType", "Lcom/bytedance/retrofit2/mime/MultipartTypedOutput;", "typedOutput", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/profit/vip/model/b;", "uploadVipCustomEmoji", "", "Lzo2/a;", "getProfitNitaViewList", "Lzt0/f;", "getPrivilegeSlardarMonitor", "()Lzt0/f;", "privilegeSlardarMonitor", "liverevenue-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IProfitServiceExternal extends IService {
    f getPrivilegeSlardarMonitor();

    List<a> getProfitNitaViewList();

    void showVipEmojiTemplatePanel(String r1, String r2);

    Single<e<b>> uploadVipCustomEmoji(int r1, String r2, MultipartTypedOutput r3);
}
