package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.opengame.AudiencePluginManager;
import com.bytedance.android.live.broadcastgame.opengame.control.out_report.OpenGameReportDialog;
import com.bytedance.android.live.broadcastgame.opengame.test.OpenGameTestHelper;
import com.bytedance.android.live.broadcastgame.openplatform.behavior.ToolbarOpenPlatformBehavior;
import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f0 {
    com.bytedance.android.live.broadcastgame.openplatform.behavior.a a(com.bytedance.android.live.broadcastgame.api.model.u r1, mh1.p r2);

    void addItemToDataCacheHelper(String r1);

    ToolbarOpenPlatformBehavior b(Context r1, DataCenter r2, Function2 r3, com.bytedance.android.live.broadcastgame.api.interactgame.g r4);

    com.bytedance.android.live.broadcastgame.opengame.a c(com.bytedance.android.live.pushstream.d r1, Context r2, DataCenter r3, long r4, ViewGroup r6);

    void closeOpenPlatformGame(String r1);

    XplayPerfPanelView d(ViewGroup r1);

    String decryptUserInfo(String r1);

    void deleteData(String r1);

    com.bytedance.android.live.broadcastgame.opengame.test.c e();

    void f(Context r1, String r2, InteractGameService.e r3);

    OpenGameTestHelper g();

    List<Class<?>> getAllOpenPlatformActivity();

    void getOpenGameClient();

    void getXplayGlobalService();

    com.bytedance.android.live.broadcastgame.opengame.behavior.b h();

    AudiencePluginManager i(Context r1, DataCenter r2, long r3, ViewGroup r5);

    com.bytedance.android.live.broadcastgame.opengame.behavior.c j();

    Disposable openCertificatePage(Context r1, Function0<Unit> r2);

    void openOpenPlatformGame(String r1, Map<String, ? extends Object> r2);

    InteractGameFeedbackDialog openOuterGameFeedback(Context r1, boolean r2);

    OpenGameReportDialog openOuterGameReport(Context r1, String r2, String r3, String r4, boolean r5);

    void preloadOpenPlatformGame(String r1);

    Single<Boolean> showOpenGameAuthDialog(Context r1, DataCenter r2, com.bytedance.android.live.broadcastgame.api.model.u r3);
}
