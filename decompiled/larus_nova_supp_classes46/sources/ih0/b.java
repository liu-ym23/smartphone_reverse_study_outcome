package ih0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ c a(b r7, Context r8, Uri r9, b7.a r10, long r11) {
            return r7.Bi(r8, r9, r10, r11, null);
        }
    }

    void B1(f r1, h r2, boolean r3);

    com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c Bi(Context r1, Uri r2, b7.a r3, long r4, DataCenter r6);

    void Dk(String r1, String r2, JsonObject r3, boolean r4);

    void E6(String r1, g r2);

    void Gb(String r1, c r2);

    void Ll(List<? extends tf0.e> r1);

    JsonObject Nm();

    Map<Integer, List<Integer>> Pl();

    JsonObject T(e r1);

    void Tl(c r1);

    l U6(String r1);

    Object Xg();

    c Z9();

    Map<String, LayoutConfigModel> en();

    void fa(c r1);

    boolean isDynamicAnimating();

    void jc(String r1);

    boolean jl(String r1);

    void oe(String r1, l r2);

    c oo();

    Object ql(String r1);

    void setDynamicAnimatorListener(Function0<Unit> r1);

    c tb();

    void updateViewInLiveBg(String r1, JsonObject r2, h r3);
}
