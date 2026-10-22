package vr1;

import com.bytedance.android.livesdk.chatroom.likeegg.LikeEggSyncDataModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface n {
    Map<String, String> a(com.bytedance.android.livesdk.chatroom.likeegg.a r1, int r2, String r3);

    void c(String r1, String r2, Map<String, String> r3, Function1<? super String, Unit> r4, Function0<Unit> r5);

    void d(DataCenter r1, Function1<? super LikeEggSyncDataModel, Unit> r2);

    void getQrCodeInfo(int r1, String r2, Function1<? super String, Unit> r3);

    void preloadTemplateResource(String r1);
}
