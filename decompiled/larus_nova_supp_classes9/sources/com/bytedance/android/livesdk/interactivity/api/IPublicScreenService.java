package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.PublicScreenService")
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\"\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&JJ\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u001e\u0010\u0017\u001a\u001a\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014H&J\u0012\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0018H&J*\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0018H&J\u0012\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H&J\u0018\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0018\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H&J\u0018\u0010/\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H&J\u0018\u00101\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u000200H&J\b\u00102\u001a\u00020\u0016H&J\u0011\u00104\u001a\u0004\u0018\u000103H&¢\u0006\u0004\b4\u00105J!\u00109\u001a\u0002082\u0006\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u000103H&¢\u0006\u0004\b9\u0010:J\u001a\u0010=\u001a\u00020<2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010;\u001a\u00020$H&J(\u0010>\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\rH&J\u001a\u0010@\u001a\u00020?2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020'H&JE\u0010H\u001a\u00020G2\u0006\u0010A\u001a\u00020$2\u0006\u0010C\u001a\u00020B2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0017\u0010F\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\bEH&¨\u0006I"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IPublicScreenService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getTextWidget", "Lcom/bytedance/android/live/base/model/message/t;", "liveMessage", "Lcom/bytedance/android/livesdkapi/depend/live/MessageSceneType;", "sceneType", "Lcom/bytedance/android/livesdk/interactivity/api/entity/f;", "getTextMessage", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "isFromPKCloudGame", "Landroid/view/View;", "createFloatTextMessageView", "usePublicScreenRenderProcessor", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onMessageUpdateListener", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/rendprocessor/k;", "createPublicScreenProcessor", "message", "Lcom/bytedance/android/livesdk/chatroom/ui/NoMoreSpaceTextView;", "renderTextView", "textMessageRenderTextProcessor", "renderLiveMessageWithPublicScreenProcessor", "getLandscapePublicScreenService", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/e;", "createIInteractUIDelegate", BuildConfig.FLAVOR, "url", "showPicPreviewDialogFragment", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "dataContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/c;", "createSquarePage", "getSquareWidget", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/square/b;", "createSquareTabManager", "Lcom/bytedance/android/livesdk/interactivity/api/entity/l;", "createMessageViewInPSOperatePanel", "destroyAll", BuildConfig.FLAVOR, "getVSMessageBackgroundColor", "()Ljava/lang/Integer;", "isLandScape", "landscapeStreamBottom", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/a;", "createAnchorPublicScreenConfigDialog", "(ZLjava/lang/Integer;)Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/a;", "source", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/n;", "createPublicScreenStyleSettingDialog", "loadPubicScreenPlugins", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/l;", "createPSAudienceOperateManager", "id", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/n;", "type", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/f$a;", "Lkotlin/ExtensionFunctionType;", "builder", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/AbsPSHighlightComp;", "createFastHighlightComp", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPublicScreenService extends IService {
    com.bytedance.android.livesdk.interactivity.api.publicscreen.a createAnchorPublicScreenConfigDialog(boolean r1, Integer r2);

    AbsPSHighlightComp createFastHighlightComp(String r1, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n r2, Context r3, DataCenter r4, Function1<? super com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f.a, Unit> r5);

    View createFloatTextMessageView(DataCenter r1, Context r2, boolean r3);

    View createFloatTextMessageView(DataCenter r1, Context r2, boolean r3, boolean r4, Function1<? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r5);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e createIInteractUIDelegate(com.bytedance.android.livesdk.chatroom.o r1, DataCenter r2);

    View createMessageViewInPSOperatePanel(Context r1, com.bytedance.android.livesdk.interactivity.api.entity.l r2);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l createPSAudienceOperateManager(DataCenter r1, MiddlewareRoomContext r2);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> createPublicScreenProcessor();

    com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n createPublicScreenStyleSettingDialog(DataCenter r1, String r2);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c createSquarePage(MiddlewareRoomContext r1, DataCenter r2);

    com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b createSquareTabManager(DataCenter r1, com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2);

    void destroyAll();

    Class<? extends LiveRecyclableWidget> getLandscapePublicScreenService();

    Class<? extends LiveRecyclableWidget> getSquareWidget();

    com.bytedance.android.livesdk.interactivity.api.entity.f<?> getTextMessage(t r1, MessageSceneType r2);

    Class<? extends LiveRecyclableWidget> getTextWidget(DataCenter r1);

    Integer getVSMessageBackgroundColor();

    void loadPubicScreenPlugins(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1, DataCenter r2, com.bytedance.android.livesdk.chatroom.o r3, Context r4);

    void renderLiveMessageWithPublicScreenProcessor(t r1, NoMoreSpaceTextView r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r3);

    void showPicPreviewDialogFragment(String r1, Context r2);
}
