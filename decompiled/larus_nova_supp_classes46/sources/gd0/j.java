package gd0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface j extends com.bytedance.live.kmp.core.d {
    Integer a();

    ILinkPlayerInfoBridge getGuestInfo(String r1, String r2);

    List<ILinkPlayerInfoBridge> getOnlineUserList();

    int i();

    List<Integer> s();
}
