package uf0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends b {
    void Ba(z0 r1);

    void Ff(z0 r1);

    void If();

    void L2(String r1, Throwable r2);

    void e6(String r1, IBaseUser r2, v r3);

    void eo(z0 r1);

    void k5(String r1, Throwable r2);

    void l(String r1, Throwable r2);

    void onPermitSuccess(String r1);

    void vf(ILinkMicGuideMessageBridge r1);
}
