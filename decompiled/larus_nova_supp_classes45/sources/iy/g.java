package iy;

import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface g {
    boolean Bk();

    JsonObject C(my.b r1);

    void Dd(String r1, JsonObject r2);

    void Dh(String r1, JsonObject r2, Function1<? super JsonObject, Unit> r3);

    boolean Do(String r1);

    void Io(String r1);

    void Kp(i r1);

    List<ILinkPlayerInfoBridge> L4();

    void P0(my.c r1, k r2, boolean r3);

    boolean Rp();

    int Ti();

    int getCurrentScene();

    tf0.h getInteractAnimationService();

    void gk(dq2.k r1);

    boolean isEngineOn();

    boolean rb();

    Map<String, String> to(String r1);

    void updateFullScreenDialogShowStatus(boolean r1);
}
