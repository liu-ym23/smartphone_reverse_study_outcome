package nub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc.VCMediaStreamType;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b extends IOfficeSDKProtocol {
    void A1(VCMediaStreamType r1);

    void B0(List<String> r1);

    void D1(String r1);

    void G0(int r1);

    void H();

    void J(int r1, int r2);

    void Q1(boolean r1);

    void U0(boolean r1);

    void V0(String r1);

    boolean W1(boolean r1);

    void b(String r1);

    void d(int r1);

    void e1(String r1);

    void g(String r1);

    void h(sub.a r1);

    void h1(String r1, String r2, String r3, String r4, String r5);

    void j0(boolean r1);

    void k1();

    void m1();

    void muteLocalAudioStream(boolean r1);

    eo9.d t(String r1);

    void t1(int r1, int r2);

    boolean v(Context r1, String r2, String r3, String r4, String r5);

    void x(JSONObject r1);

    void z(c r1);
}
