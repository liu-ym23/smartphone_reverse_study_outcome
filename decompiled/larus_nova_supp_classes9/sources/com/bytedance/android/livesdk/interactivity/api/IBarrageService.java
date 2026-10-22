package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalRedPacketEggResultModel;
import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalTrayContentResultModel;
import com.bytedance.android.livesdkapi.service.IPreviewBarrageService;
import com.bytedance.android.livesdkapi.service.OpenParams;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.BarrageService")
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0005H&J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J>\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0015H&J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001d\u001a\u00020\u001cH&J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH&J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H&J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H&J\b\u0010*\u001a\u00020)H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IBarrageService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "providePortraitBarrageWidget", "provideLandscapeBarrageWidget", "Ljava/lang/Class;", "provideCarnivalManagerWidget", "provideChatCarnivalWidget", "provideLandscapeCarnivalWidget", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "providePortraitSimpleBarrageWidget", "providePortraitSimpleBarrageWidgetClass", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "requestPage", BuildConfig.FLAVOR, "showVSLandscapeBarrageSettingDialog", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraParams", "Ln22/c;", "showLandscapeBarrageSettingDialog", "Ln22/d;", "msg", "addBarrageToScreen", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/b;", "createBarrageContext", "Lq82/c;", "Lq82/f;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ShowCarnivalTrayContentResultModel;", "createShowCarnivalTrayContentMethod", "Lq82/b;", "Lq82/e;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ShowCarnivalRedPacketEggResultModel;", "createShowCarnivalRedPacketEggMethod", "Lcom/bytedance/android/livesdkapi/service/OpenParams;", "params", "openPortraitSimpleBarrageSettingDialog", "Lcom/bytedance/android/livesdkapi/service/IPreviewBarrageService;", "provideILivePreviewBarrageService", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBarrageService extends IService {
    void addBarrageToScreen(n22.d r1);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.b createBarrageContext();

    q82.b<q82.e, ShowCarnivalRedPacketEggResultModel> createShowCarnivalRedPacketEggMethod();

    q82.c<q82.f, ShowCarnivalTrayContentResultModel> createShowCarnivalTrayContentMethod();

    void openPortraitSimpleBarrageSettingDialog(Context r1, OpenParams r2);

    Class<? extends Widget> provideCarnivalManagerWidget();

    Widget provideChatCarnivalWidget();

    IPreviewBarrageService provideILivePreviewBarrageService();

    Widget provideLandscapeBarrageWidget();

    Widget provideLandscapeCarnivalWidget();

    Widget providePortraitBarrageWidget();

    AbsMergeWidget providePortraitSimpleBarrageWidget();

    Class<? extends AbsMergeWidget> providePortraitSimpleBarrageWidgetClass();

    n22.c showLandscapeBarrageSettingDialog(Context r1, DataCenter r2, HashMap<String, String> r3);

    void showVSLandscapeBarrageSettingDialog(Context r1, DataCenter r2, String r3);
}
