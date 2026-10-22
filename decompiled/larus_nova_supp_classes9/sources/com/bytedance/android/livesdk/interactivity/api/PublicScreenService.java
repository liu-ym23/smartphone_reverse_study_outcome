package com.bytedance.android.livesdk.interactivity.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.interactivity.common.adjuster.delegates.InteractUIContextDelegate;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.AIAutoReplyPublicScreenPlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.CombinedTextMessagePlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.EmojiChatPublicScreenPluginV2;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.LiteInteractionPlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.RoomIntroV2PublicScreenPlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.SecretChatPublicScreenPlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.mention.MentionChatPlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.PhotoViewerDialogFragment;
import com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui.PublicScreenStyleSettingDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.AnchorPublicScreenConfigDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.FloatTextMessageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.LandscapeServiceWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.interactivity.service.richcontent.config.LiveRichContentConfig;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.LiveImageResourceLoader;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.LiveNinePatchResourceLoader;
import com.bytedance.android.livesdk.interactivity.square.SquareTabManager;
import com.bytedance.android.livesdk.interactivity.square.SquareTabWidget;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r52.a4;
import r52.k3;
import r52.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bJ\u0010KJ\u001c\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016JJ\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u001e\u0010\u001c\u001a\u001a\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u001dH\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010'\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\f2\u0006\u0010%\u001a\u00020$2\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u001dH\u0016J\u0012\u0010(\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\u0018\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\u001a\u00103\u001a\u00020\u001b2\u0006\u00102\u001a\u0002012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0011\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b5\u00106J!\u0010:\u001a\u0002092\u0006\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b:\u0010;J\u001a\u0010>\u001a\u00020=2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010<\u001a\u000201H\u0016J(\u0010?\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020)2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010A\u001a\u00020@2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\u001fH\u0016JE\u0010I\u001a\u00020H2\u0006\u0010B\u001a\u0002012\u0006\u0010D\u001a\u00020C2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0017\u0010G\u001a\u0013\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u001b0\u0019¢\u0006\u0002\bFH\u0016¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenService;", "Lcom/bytedance/android/livesdk/interactivity/api/IPublicScreenService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getTextWidget", "getSquareWidget", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/square/b;", "createSquareTabManager", "Lcom/bytedance/android/live/base/model/message/t;", "liveMessage", "Lcom/bytedance/android/livesdkapi/depend/live/MessageSceneType;", "sceneType", "Lcom/bytedance/android/livesdk/interactivity/api/entity/f;", "getTextMessage", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "isFromPKCloudGame", "Landroid/view/View;", "createFloatTextMessageView", "usePublicScreenRenderProcessor", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onMessageUpdateListener", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/rendprocessor/k;", "createPublicScreenProcessor", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "dataContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/c;", "createSquarePage", "message", "Lcom/bytedance/android/livesdk/chatroom/ui/NoMoreSpaceTextView;", "renderTextView", "textMessageRenderTextProcessor", "renderLiveMessageWithPublicScreenProcessor", "getLandscapePublicScreenService", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/e;", "createIInteractUIDelegate", "Lcom/bytedance/android/livesdk/interactivity/api/entity/l;", "event", "createMessageViewInPSOperatePanel", "destroyAll", BuildConfig.FLAVOR, "url", "showPicPreviewDialogFragment", BuildConfig.FLAVOR, "getVSMessageBackgroundColor", "()Ljava/lang/Integer;", "isLandScape", "landscapeStreamBottom", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/a;", "createAnchorPublicScreenConfigDialog", "(ZLjava/lang/Integer;)Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/a;", "source", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/n;", "createPublicScreenStyleSettingDialog", "loadPubicScreenPlugins", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/l;", "createPSAudienceOperateManager", "id", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/n;", "type", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/f$a;", "Lkotlin/ExtensionFunctionType;", "builder", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/AbsPSHighlightComp;", "createFastHighlightComp", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PublicScreenService implements IPublicScreenService {

    public static final class a implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> {
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k a;
        public final /* synthetic */ NoMoreSpaceTextView b;

        public a(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k r1, NoMoreSpaceTextView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
        public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "rendResult");
            this.b.setText(r3.a);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> createPublicScreenProcessor() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L6:
        int r2 = da2.a.a;
        if (r1 == null) goto L11;
        boolean r3 = true;
        if (r1.isMediaRoom() != true) goto L11;
    L12:
        if (r1 == null) goto L14;
        Boolean r4 = r1.isAnchor();
    L16:
        return new da2.b(new da2.c(r3, Intrinsics.areEqual(r4, Boolean.TRUE), null));
    L14:
        r4 = null;
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public void destroyAll() {
        PthreadHandlerThreadV2 r0 = zb2.a.a;
        if (r0 == null) goto L5;
        r0.quit();
    L5:
        ak6.b.a r1 = LiveRichContentEngine.a().config();
        if ((r1 instanceof LiveRichContentConfig) == true) goto L8;
        r1 = null;
    L8:
        LiveRichContentConfig r2 = (LiveRichContentConfig) r1;
        if (r2 == null) goto L12;
        LiveImageResourceLoader r3 = r2.b;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a r4 = r2.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "logger");
        r4.info("LiveImageResourceLoader params: " + r3.a.a);
        r4.info("LiveImageResourceLoader state: " + r3.a.c());
        r2.b.a.d.h(-1);
        LiveNinePatchResourceLoader r5 = r2.c;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a r6 = r2.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "logger");
        r6.info("LiveNinePatchResourceLoader params: " + r5.a.a);
        r6.info("LiveNinePatchResourceLoader state: " + r5.a.c());
        r2.c.a.d.h(-1);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public Integer getVSMessageBackgroundColor() {
        int r0 = com.bytedance.android.livesdk.interactivity.textmessage.utils.i.a;
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
    L11:
        if (r4 != null) goto L13;
    L14:
        if (r4 != null) goto L16;
        return null;
    L16:
        if (r4.isMergeVSRoom() != true) goto L34;
    L17:
        IEpisodeExtraInfo r5 = r4.getEpisodeExtra();
        if (r5 == null) goto L20;
        String r6 = r5.getPublicScreenColor();
    L21:
        if (r6 != null) goto L23;
        return null;
    L23:
        if (TextUtils.isEmpty(r6) == false) goto L31;
        return null;
    L31:
        if (StringsKt.startsWith$default(r6, '#', false, 2, null) == true) goto L28;
        r6 = "#".concat(r6);     // Catch: Exception -> L30
    L28:
        return Integer.valueOf(Color.parseColor(r6));
    L37:
        return null;
    L20:
        r6 = null;
        goto L21
    L34:
        return null;
    L13:
        if (r4.isVsLive() == true) goto L17;
    L9:
        r4 = null;
        goto L11
    }

    public PublicScreenService() {
        jc1.k.l(IPublicScreenService.class, this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public Class<? extends LiveRecyclableWidget> getLandscapePublicScreenService() {
        return LandscapeServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public Class<? extends LiveRecyclableWidget> getSquareWidget() {
        return SquareTabWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public Class<? extends LiveRecyclableWidget> getTextWidget(DataCenter r1) {
        zb2.a.a();
        return TextMessageWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.a createAnchorPublicScreenConfigDialog(boolean r2, Integer r3) {
        return new AnchorPublicScreenConfigDialog(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e createIInteractUIDelegate(com.bytedance.android.livesdk.chatroom.o r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        return new InteractUIContextDelegate(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public View createMessageViewInPSOperatePanel(Context r2, com.bytedance.android.livesdk.interactivity.api.entity.l r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        return new com.bytedance.android.livesdk.interactivity.publicscreen.ui.l(r2, r3).a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l createPSAudienceOperateManager(DataCenter r3, MiddlewareRoomContext r4) {
        Intrinsics.checkNotNullParameter(r4, "roomContext");
        w92.a r1 = new w92.a(r3);
        Intrinsics.checkNotNullParameter(r4, "roomContext");
        r1.c = r4;
        return r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n createPublicScreenStyleSettingDialog(DataCenter r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        return new PublicScreenStyleSettingDialog(r3, new ma2.a(r4, r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c createSquarePage(MiddlewareRoomContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "dataContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        return new com.bytedance.android.livesdk.interactivity.square.g(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b createSquareTabManager(DataCenter r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.l r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        return new SquareTabManager(r3, r4, new com.bytedance.android.livesdk.interactivity.square.a());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public com.bytedance.android.livesdk.interactivity.api.entity.f<?> getTextMessage(t r2, MessageSceneType r3) {
        Intrinsics.checkNotNullParameter(r2, "liveMessage");
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        return i0.e(r2, r3, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public void showPicPreviewDialogFragment(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        if (r3 == null) goto L20;
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(r3);
        FragmentManager r0 = null;
        if (r4 == null) goto L7;
        FragmentManager r5 = r4.getSupportFragmentManager();
    L8:
        if (r5 != null) goto L17;
        WeakReference r6 = com.bytedance.android.live.core.utils.a.a;
        if (r6 == null) goto L12;
        Activity r7 = (Activity) r6.get();
    L13:
        FragmentActivity r8 = ContextUtil.contextToFragmentActivity(r7);
        if (r8 == null) goto L16;
        r0 = r8.getSupportFragmentManager();
    L16:
        r5 = r0;
        goto L17
    L12:
        r7 = null;
    L17:
        if (r5 == null) goto L21;
        int r1 = PhotoViewerDialogFragment.j;
        Intrinsics.checkNotNullParameter(r2, "imageUrl");
        PhotoViewerDialogFragment r9 = new PhotoViewerDialogFragment();
        r9.g = r2;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_api_PublicScreenService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r9, r5, "PhotoViewerDialogFragment");
        return;
    L21:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_api_PublicScreenService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(PhotoViewerDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        PhotoViewerDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public View createFloatTextMessageView(DataCenter r8, Context r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        return createFloatTextMessageView(r8, r9, r10, false, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public void renderLiveMessageWithPublicScreenProcessor(t r3, NoMoreSpaceTextView r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r5) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "renderTextView");
        Intrinsics.checkNotNullParameter(r5, "textMessageRenderTextProcessor");
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6 = i0.e(r3, MessageSceneType.PUBLIC_SCREEN, null);
        if (r6 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r7 = r5.b(r6, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new a(r5, r4));
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r8 = r7.b;
        if (r8 != null) goto L7;
    L9:
        r4.setText(r7.a);
        return;
    L7:
        if (r8.a != true) goto L9;
        r4.setAlwaysInvalidate(true);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public void loadPubicScreenPlugins(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r11, DataCenter r13, com.bytedance.android.livesdk.chatroom.o r14, Context r15) {
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "dataContext");
        Intrinsics.checkNotNullParameter(r15, "context");
        int r3 = com.bytedance.android.livesdk.interactivity.publicscreen.plugin.b.e;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        if (PublicScreenStyleHelper.n == false) goto L5;
        r11.registerPlugin(new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.b());
    L5:
        int r4 = EmojiChatPublicScreenPluginV2.d;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        r11.registerPlugin(new EmojiChatPublicScreenPluginV2(r13, r14));
        Boolean r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a;
        com.bytedance.live.datacontext.m r6 = r14.getRoom();
        String r7 = null;
        if (r6 == null) goto L8;
        IRoom r8 = (IRoom) r6.getValue();
    L9:
        IMiddlewareUserService r9 = jc1.k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L14;
        com.bytedance.android.livesdk.user.e r10 = r9.user();
        if (r10 == null) goto L14;
        String r16 = r10.n();
    L15:
        if (r8 == null) goto L17;
        r7 = r8.getAnchorId();
    L17:
        boolean r17 = Intrinsics.areEqual(r16, r7);
        boolean r18 = PadConfigUtils.c();
        boolean r19 = FoldScreenUtils.f();
        boolean r20 = true;
        if (r17 == true) goto L20;
        if (r18 == true) goto L37;
        if (r19 == true) goto L37;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a.booleanValue() == false) goto L37;
        if (r8 == null) goto L37;
        IRoomAuthStatus r21 = r8.getRoomAuthStatus();
        if (r21 == null) goto L37;
        if (r21.isEnableAIClone() != true) goto L37;
    L36:
        boolean r23 = true;
    L38:
        if (r23 == false) goto L41;
        int r24 = AIAutoReplyPublicScreenPlugin.e;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        r11.registerPlugin(new AIAutoReplyPublicScreenPlugin(r13, r14));
    L41:
        if (PublicScreenABHelper.S.booleanValue() == false) goto L44;
        int r25 = CombinedTextMessagePlugin.e;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        r11.registerPlugin(new CombinedTextMessagePlugin(r13, r14));
    L44:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b == false) goto L46;
        int r26 = SecretChatPublicScreenPlugin.g;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        r11.registerPlugin(new SecretChatPublicScreenPlugin(r13, r14));
    L46:
        r11.registerPlugin(new MentionChatPlugin(r13));
        int r27 = z92.c.c;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        if (u42.d.a == true) goto L49;
    L51:
        int r28 = com.bytedance.android.livesdk.interactivity.publicscreen.plugin.d.v;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        q0 r29 = (q0) u3.a.getValue();
        if (a0.d(r13, false) == false) goto L65;
        if (r29.e() == false) goto L75;
        List<String> r30 = r29.a();
        if (r30 != null) goto L58;
    L61:
        boolean r31 = true;
    L62:
        if (r31 == true) goto L75;
    L76:
        if (r20 == false) goto L78;
        r11.registerPlugin(new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.d(r29, r13));
    L79:
        int r33 = RoomIntroV2PublicScreenPlugin.g;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "context");
        if (((u0) a4.a.getValue()).b() == false) goto L83;
        ALogger.i("RoomIntroV2PublicScreenPlugin", "load RoomIntroV2PublicScreenPlugin");
        r11.registerPlugin(new RoomIntroV2PublicScreenPlugin(r13, r14, new WeakReference(r15)));
    L83:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o.b(r13) == false) goto L85;
        int r110 = com.bytedance.android.livesdk.interactivity.publicscreen.plugin.h.d;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        r11.registerPlugin(new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.h(r13, r14));
    L85:
        int r111 = LiteInteractionPlugin.f;
        Intrinsics.checkNotNullParameter(r11, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "roomContext");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        int r112 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k.a;
        if (((Boolean) k3.a.getValue()).booleanValue() == false) goto L90;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k.a("register LiteInteractionPlugin");
        r11.registerPlugin(new LiteInteractionPlugin(r13, r14));
        return;
    L90:
        return;
    L78:
        ALogger.i("PublicScreenStatisticsPlugin", "disabled");
        goto L79
    L58:
        if (r30.isEmpty() == true) goto L61;
        r31 = false;
    L75:
        r20 = false;
        goto L76
    L65:
        if (r29.f() == false) goto L75;
        List<String> r34 = r29.b();
        if (r34 != null) goto L69;
    L72:
        boolean r35 = true;
    L73:
        if (r35 == true) goto L75;
    L69:
        if (r34.isEmpty() == true) goto L72;
        r35 = false;
        goto L73
    L49:
        if (a0.k(r13) == true) goto L51;
        r11.registerPlugin(new z92.c(r13));
    L37:
        r23 = false;
        goto L38
    L20:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a.booleanValue() == false) goto L37;
        if (r8 == null) goto L37;
        IRoomAuthStatus r36 = r8.getRoomAuthStatus();
        if (r36 == null) goto L37;
        if (r36.isEnableAIClone() != true) goto L37;
    L14:
        r16 = null;
        goto L15
    L8:
        r8 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public AbsPSHighlightComp createFastHighlightComp(String r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n r13, Context r14, DataCenter r15, Function1<? super com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f.a, Unit> r16) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r16, "builder");
        int r3 = com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f.i;
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r16, "builder");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f.a r9 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f.a(r11, r13, r14, r15);
        r16.invoke(r9);
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f(r9.c, r9.d, r9.e, r9.f, r9);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenService
    public View createFloatTextMessageView(DataCenter r8, Context r9, boolean r10, boolean r11, Function1<? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        return new FloatTextMessageView(r8, r9, r10, r11, r13);
    }
}
