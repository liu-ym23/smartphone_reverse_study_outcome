package tc0;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b extends dn0.b {
    void Ah(String r1);

    void Ba();

    void Cl(Map<Long, ? extends g2> r1);

    void D0(com.bytedance.android.livesdk.message.linker.b r1);

    void D6(String r1);

    void De();

    void F7(LinkMatchType r1);

    void H9(boolean r1);

    void Jm(String r1);

    void Kj(boolean r1);

    com.bytedance.android.livesdk.message.linker.b Oa();

    void Pd(int r1);

    void R0(int r1);

    String Vd();

    void c1(String r1);

    void dh(String r1);

    String getApplyReason();

    long getChannelId();

    String getLiveCoreExtInfo();

    e0 getMcuContent();

    u1 getMultiLiveCoreInfo();

    v1 getMultiRtcInfo();

    String getRtcExtInfo();

    boolean isSupportCamera();

    void rg(int r1);

    void setApplyType(int r1);

    void setChorusCDNInfo(v r1);

    void setLiveCoreExtInfo(String r1);

    void setMcuContent(e0 r1);

    void setMultiLiveCoreInfo(u1 r1);

    void setMultiRtcInfo(v1 r1);

    void setRtcExtInfo(String r1);

    String u();

    void v6(boolean r1);

    String x9();

    boolean zi();
}
