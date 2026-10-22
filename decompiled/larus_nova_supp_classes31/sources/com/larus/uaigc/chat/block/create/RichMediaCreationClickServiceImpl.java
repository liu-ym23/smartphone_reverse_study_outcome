package com.larus.uaigc.chat.block.create;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationImageButtonAction;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationVideoButtonAction;
import com.larus.bmhome.utils.c4;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.image.MDImageScrollWidget;
import com.larus.uaigc.chat.markdown.image.component.ImageEditorComponent;
import com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent;
import com.larus.uaigc.chat.markdown.image.component.VideoEditorComponent;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.utils.DataConverterKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kc8.a0;
import kc8.b0;
import kc8.d0;
import kc8.p0;
import kc8.q0;
import kc8.s0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t19.s;
import tx9.b2;
import tx9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jv\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096@¢\u0006\u0002\u0010\u001aJp\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010#J2\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016Jx\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010+J*\u0010,\u001a\u00020-2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u000203H\u0016Jh\u00104\u001a\u00020\u00052\u0006\u0010(\u001a\u0002052\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005072\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u00108JX\u00109\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005072\b\u0010!\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010:J*\u0010;\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002JM\u0010<\u001a\u00020=2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010>J\u001c\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010A\u001a\u0004\u0018\u00010B2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¨\u0006D"}, d2 = {"Lcom/larus/uaigc/chat/block/create/RichMediaCreationClickServiceImpl;", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationClickService;", "<init>", "()V", "onClick", "", "clickHostView", "Landroid/view/View;", "clickView", "message", "Lcom/larus/im/bean/message/Message;", "creationItems", "", "Lcom/larus/im/bean/message/CreationItem;", "clickItem", "currentPage", "", "previousPage", "isCollectMode", "", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "videoPlaybackSnapshot", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;", "(Landroid/view/View;Landroid/view/View;Lcom/larus/im/bean/message/Message;Ljava/util/List;Lcom/larus/im/bean/message/CreationItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindLongClick", "bindView", "itemPosition", "", "itemWidth", "itemHeight", "extraTraceParams", "Lorg/json/JSONObject;", "(Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageButtonCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonCapability;", "isLongPicShare", "onImageButtonClick", "action", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;", "anchorView", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoCapability;", "getCreationDisplaySize", "Landroid/util/Size;", "maxWidth", "totalItemCount", "createVideoPlaybackController", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationVideoPlaybackController;", "onVideoButtonClick", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;", "onCompleted", "Lkotlin/Function0;", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadVideo", "(Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;ILcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extendVideo", "imageOperator", "Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "(Landroid/view/View;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;)Lcom/larus/uaigc/chat/markdown/image/component/ImageOperatorComponent;", "imageEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorComponent;", "videoEditorComponent", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorComponent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RichMediaCreationClickServiceImpl implements IRichMediaCreationClickService {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[RichMediaCreationImageButtonAction.values().length];
            r0[RichMediaCreationImageButtonAction.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r0[RichMediaCreationImageButtonAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L38:
            r0[RichMediaCreationImageButtonAction.IMAGE_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L28:
            r0[RichMediaCreationImageButtonAction.VIDEO_EDIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L30:
            r0[RichMediaCreationImageButtonAction.CITE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[RichMediaCreationVideoButtonAction.values().length];
            r1[RichMediaCreationVideoButtonAction.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L24:
            r1[RichMediaCreationVideoButtonAction.CITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L32:
            r1[RichMediaCreationVideoButtonAction.EXTEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L14:
            b = r1;
        }
    }

    static {
    }

    public RichMediaCreationClickServiceImpl() {
    }

    public final d0 g() {
        return new RichMediaCreationVideoPlaybackController();
    }

    public final Size c(CreationItem r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "clickItem");
        if (r3 <= 0) goto L14;
        if (r4 <= 0) goto L14;
        Size r5 = bz9.b.b(r2, r3, r4);
        if (r5.getWidth() > 0) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L14;
        return r5;
    L9:
        if (r5.getHeight() <= 0) goto L11;
        r6 = true;
    L14:
        return null;
    }

    public final q0 a(Message r4, CreationItem r5, boolean r6, kc8.q r7) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "clickItem");
        VideoData r8 = r5.video;
        Integer r0 = r5.type;
        boolean r1 = false;
        if (r0 == null) goto L71;
        if (r0.intValue() != 2) goto L71;
        if (bz9.a.f(r5) == false) goto L71;
        rd8.b r9 = null;
        if (r8 == null) goto L12;
        String r10 = r8.vid;
    L14:
        if (r10 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == true) goto L71;
        if (r7 == null) goto L26;
        a0 r12 = r7.d;
        if (r12 == null) goto L26;
        wc9.e r13 = r12.h();
    L27:
        if (r7 == null) goto L31;
        a0 r2 = r7.d;
        if (r2 == null) goto L31;
        String r3 = r2.getBotId();
    L32:
        if (r3 != null) goto L34;
        r3 = "";
    L34:
        if (r6 == false) goto L36;
    L56:
        boolean r14 = false;
    L58:
        if (r7 == null) goto L60;
        r9 = r7.g;
    L60:
        if (r9 == null) goto L62;
        boolean r15 = true;
    L63:
        boolean r16 = !r6;
        if (r14 == true) goto L69;
        if (z2.a.getCreationExtendVideoConfig().a() == false) goto L69;
        r1 = true;
    L69:
        return new q0(r15, r16, r14, r1);
    L62:
        r15 = false;
        goto L63
    L36:
        if (q.a(r13) == true) goto L56;
        Integer r17 = z2.a.attachmentEditConfig().getCreationVideoCoverFollowUp();
        if (r17 == null) goto L56;
        if (r17.intValue() != 1) goto L56;
        if (r3.length() != 0) goto L45;
        boolean r18 = true;
    L46:
        if (r18 == true) goto L55;
        e0 r19 = (e0) AuthModelDelegate.b.e().getValue();
        if (r19 == null) goto L52;
        LaunchInfo r20 = r19.a;
        if (r20 == null) goto L52;
        String r21 = r20.W();
    L54:
        if (Intrinsics.areEqual(r3, r21) == false) goto L56;
    L52:
        r21 = null;
    L55:
        r14 = true;
        goto L58
    L45:
        r18 = false;
    L31:
        r3 = null;
    L26:
        r13 = null;
        goto L27
    L16:
        if (StringsKt.isBlank(r10) == true) goto L19;
        r11 = false;
        goto L20
    L12:
        r10 = null;
    L71:
        return new q0(false, false, false, false);
    }

    public final p0 e(Message r16, CreationItem r17, boolean r18, kc8.q r19, CoroutineScope r20) {
        Intrinsics.checkNotNullParameter(r16, "message");
        Intrinsics.checkNotNullParameter(r17, "clickItem");
        Intrinsics.checkNotNullParameter(r20, "lifecycleScope");
        Integer r2 = r17.type;
        if (r2 == null) goto L115;
        if (r2.intValue() != 1) goto L115;
        if (bz9.a.f(r17) == false) goto L115;
        String r0 = null;
        if (r19 == null) goto L15;
        a0 r3 = r19.d;
        if (r3 == null) goto L15;
        wc9.e r4 = r3.h();
    L16:
        if (r19 == null) goto L20;
        a0 r5 = r19.d;
        if (r5 == null) goto L20;
        String r6 = r5.getBotId();
    L21:
        if (r6 != null) goto L23;
        r6 = "";
    L23:
        String r13 = r6;
        CreationChatItemClickHelper r7 = CreationChatItemClickHelper.a;
        if (r19 == null) goto L28;
        a0 r8 = r19.d;
        if (r8 == null) goto L28;
        BotModel r9 = r8.j0();
    L29:
        if (r19 == null) goto L35;
        Fragment r10 = r19.a;
        if (r10 == null) goto L35;
        t1a.b r11 = s1a.a.g(r10);
        if (r11 == null) goto L35;
        ChatPageContext r12 = (ChatPageContext) r11.a(ChatPageContext.class);
    L36:
        if (r19 == null) goto L38;
        Fragment r14 = r19.a;
    L39:
        if (r4 == null) goto L41;
        String r15 = r4.a;
    L42:
        r7.getClass();
        com.larus.uaigc.chat.markdown.image.component.a r110 = CreationChatItemClickHelper.g(r20, r13, r9, r12, r14, r15);
        if (r19 == null) goto L47;
        a0 r21 = r19.d;
        if (r21 == null) goto L47;
        BotModel r22 = r21.j0();
    L48:
        if (r19 == null) goto L54;
        Fragment r23 = r19.a;
        if (r23 == null) goto L54;
        t1a.b r24 = s1a.a.g(r23);
        if (r24 == null) goto L54;
        ChatPageContext r25 = (ChatPageContext) r24.a(ChatPageContext.class);
    L55:
        if (r19 == null) goto L57;
        Fragment r26 = r19.a;
    L58:
        if (r4 == null) goto L60;
        String r27 = r4.a;
    L61:
        com.larus.uaigc.chat.markdown.image.component.k r1 = CreationChatItemClickHelper.h(r20, r13, r22, r25, r26, r27);
        boolean r28 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
        if (com.larus.im.bean.message.a.e0(r16) == true) goto L65;
        if (r28 == true) goto L65;
        boolean r29 = true;
    L66:
        IAIChatUgcAIGCService.Companion r30 = IAIChatUgcAIGCService.a;
        if (r30.E0() == false) goto L70;
        if (r18 == true) goto L70;
        boolean r31 = true;
    L72:
        if (r30.l0() == false) goto L75;
        if (r18 == true) goto L75;
        boolean r32 = true;
    L76:
        Lazy<Boolean> r33 = MDImageScrollWidget.w;
        if (MDImageScrollWidget.a.a() == false) goto L82;
        if (r110 == null) goto L82;
        if (r18 == true) goto L82;
        if (r29 == false) goto L82;
        boolean r34 = true;
    L84:
        if (MDImageScrollWidget.a.b() == false) goto L89;
        if (r1 == null) goto L89;
        if (r18 == true) goto L89;
        if (r29 == false) goto L89;
        boolean r35 = true;
    L90:
        if (r18 == false) goto L92;
    L111:
        boolean r36 = false;
    L113:
        return new p0(r31, r32, r34, r35, r36);
    L92:
        if (q.a(r4) == true) goto L111;
        Integer r37 = z2.a.attachmentEditConfig().getCreationCoverFollowUp();
        if (r37 == null) goto L111;
        if (r37.intValue() != 1) goto L111;
        if (r13.length() != 0) goto L101;
        boolean r38 = true;
    L102:
        if (r38 == true) goto L110;
        e0 r39 = (e0) AuthModelDelegate.b.e().getValue();
        if (r39 == null) goto L109;
        LaunchInfo r40 = r39.a;
        if (r40 == null) goto L109;
        r0 = r40.W();
    L109:
        if (Intrinsics.areEqual(r13, r0) == false) goto L111;
    L110:
        r36 = true;
        goto L113
    L101:
        r38 = false;
    L89:
        r35 = false;
    L82:
        r34 = false;
    L75:
        r32 = false;
    L70:
        r31 = false;
    L65:
        r29 = false;
        goto L66
    L60:
        r27 = null;
        goto L61
    L57:
        r26 = null;
    L54:
        r25 = null;
    L47:
        r22 = null;
        goto L48
    L41:
        r15 = null;
        goto L42
    L38:
        r14 = null;
    L35:
        r12 = null;
    L28:
        r9 = null;
    L20:
        r6 = null;
    L15:
        r4 = null;
    L115:
        return new p0(0);
    }

    public final Object i(View r36, Message r37, CreationItem r38, int r39, kc8.q r40, CoroutineScope r41, Function0<Unit> r42, JSONObject r43, Continuation<? super Unit> r44) {
        if ((r44 instanceof RichMediaCreationClickServiceImpl$downloadVideo$1) == false) goto L7;
        RichMediaCreationClickServiceImpl$downloadVideo$1 r2 = (RichMediaCreationClickServiceImpl$downloadVideo$1) r44;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        RichMediaCreationClickServiceImpl$downloadVideo$1 r11 = r2;
        Object r1 = r11.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r11.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        boolean r0 = r11.Z$0;
        int r5 = r11.I$0;
        CoroutineScope r6 = (CoroutineScope) r11.L$11;
        String r7 = (String) r11.L$10;
        c4 r8 = (c4) r11.L$9;
        nr9.g r9 = (nr9.g) r11.L$8;
        Context r12 = (Context) r11.L$7;
        com.larus.bmhome.video.save_share.a r13 = (com.larus.bmhome.video.save_share.a) r11.L$6;
        final UserCreationFromIM r14 = (UserCreationFromIM) r11.L$5;
        JSONObject r15 = (JSONObject) r11.L$4;
        Function0<Unit> r16 = (Function0) r11.L$3;
        CreationItem r17 = (CreationItem) r11.L$2;
        final Message r18 = (Message) r11.L$1;
        final View r19 = (View) r11.L$0;
        ResultKt.throwOnFailure(r1);
        boolean r23 = r0;
        CoroutineScope r21 = r6;
        String r20 = r7;
        c4 r110 = r8;
        nr9.g r111 = r9;
        final Function0<Unit> r22 = r16;
        Context r112 = r12;
        com.larus.bmhome.video.save_share.a r113 = r13;
        JSONObject r24 = r15;
    L30:
        if (r5 == 0) goto L32;
        boolean r25 = true;
    L33:
        JSONObject r26 = (JSONObject) r1;
        b2.c(r26);
        c2.a(r26, r24);
        Map<String, String> r27 = ICreationMetadataService.a.s(r14, null);
        CreationGenDetail r28 = r17.genDetail;
        if (r28 == null) goto L38;
        Integer r29 = r28.taskType;
        if (r29 == null) goto L38;
        String r210 = DataConverterKt.h(r29.intValue());
    L39:
        com.larus.bmhome.video.save_share.a.a.a(r113, r112, r111, r110, r20, r21, r25, r23, r26, r27, r210, true, new p(r22, r19, r18, r14), 32);
        return Unit.INSTANCE;
    L38:
        r210 = null;
        goto L39
    L32:
        r25 = false;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        IFlowSdkDepend r30 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r30 == null) goto L17;
        r30.D0();
        b1.a.c("chat_thumbnail_download");
    L17:
        UserCreationFromIM r31 = ICreationMetadataService.a.I(r37, r38.id, String.valueOf(r39));
        com.larus.bmhome.video.save_share.a r32 = IAIChatUgcAIGCService.a.G();
        Context r33 = r36.getContext();
        VideoData r34 = r38.video;
        if (r34 == null) goto L20;
        nr9.g r35 = bz9.a.l(r34);
    L21:
        if (r40 == null) goto L25;
        a0 r45 = r40.d;
        if (r45 == null) goto L25;
        String r46 = r45.getBotId();
    L26:
        String r47 = r37.getMessageId();
        IAIChatControlTraceService.Companion r48 = IAIChatControlTraceService.a;
        String r49 = r48.bb(r48.gb());
        String r50 = r38.id;
        String r114 = tz9.a.a(r37);
        boolean r51 = com.larus.im.bean.message.a.C0(r37);
        nr9.g r115 = r35;
        JSONObject r52 = new JSONObject();
        b2.c(r52);
        c2.a(r52, r43);
        c4 r116 = new c4(r46, r47, r49, null, null, null, "0", r50, Boxing.boxInt(r39 + 1), r114, Boxing.boxBoolean(r51), r37, r52, null, 8248);
        boolean r53 = z2.a.Q3();
        CreationChatItemClickHelper r54 = CreationChatItemClickHelper.a;
        r11.L$0 = r36;
        r11.L$1 = r37;
        r11.L$2 = r38;
        r22 = r42;
        r11.L$3 = r22;
        r11.L$4 = r43;
        r11.L$5 = r31;
        r11.L$6 = r32;
        r11.L$7 = r33;
        r11.L$8 = r115;
        r11.L$9 = r116;
        r11.L$10 = "overview_click";
        r11.L$11 = r41;
        r11.I$0 = 0;
        r11.Z$0 = r53;
        r11.label = 1;
        r54.getClass();
        r1 = CreationChatItemClickHelper.n(r37, r11);
        if (r1 != r10) goto L29;
        return r10;
    L29:
        r23 = r53;
        r24 = r43;
        r113 = r32;
        r112 = r33;
        r111 = r115;
        r110 = r116;
        r20 = "overview_click";
        r21 = r41;
        r19 = r36;
        r18 = r37;
        r17 = r38;
        r14 = r31;
        r5 = 0;
    L25:
        r46 = null;
        goto L26
    L20:
        r35 = null;
    L7:
        r2 = new RichMediaCreationClickServiceImpl$downloadVideo$1(this, r44);
        goto L8
    }

    public final Object b(RichMediaCreationVideoButtonAction r38, View r39, Message r40, CreationItem r41, int r42, boolean r43, kc8.q r44, CoroutineScope r45, Function0<Unit> r46, JSONObject r47, Continuation<? super Unit> r48) {
        q0 r0 = a(r40, r41, r43, r44);
        int r1 = b.b[r38.ordinal()];
        if (r1 == 1) goto L105;
        Function4 r9 = null;
        if (r1 == 2) goto L41;
        if (r1 != 3) goto L39;
        if (r0.d == false) goto L37;
        VideoData r2 = r41.video;
        CreationNoWatermarkManager r3 = CreationNoWatermarkManager.a;
        if (r2 == null) goto L12;
        String r7 = r2.vid;
    L13:
        if (r2 == null) goto L15;
        nr9.g r8 = bz9.a.l(r2);
    L16:
        if (r2 == null) goto L20;
        Cover r4 = r2.cover;
        if (r4 == null) goto L20;
        String r5 = r4.key;
    L21:
        nr9.g r13 = r3.h0(r7, r8, r5);
        if (r13 == null) goto L37;
        hy9.d r14 = ICreationReportService.a.j();
        String r15 = AppHost.a.getApplication().getString(2131905605);
        IAIChatControlTraceService.Companion r6 = IAIChatControlTraceService.a;
        hy9.d.a.a(r14, r15, null, null, "video_overview", "single_function", null, null, null, null, r6.bb(r6.gb()), null, null, null, null, null, null, null, null, "chat", null, null, 3931622);
        IAIChatUgcAIGCService.Companion r11 = IAIChatUgcAIGCService.a;
        Context r12 = r39.getContext();
        String r16 = r40.getMessageId();
        String r10 = r41.id;
        if (r44 == null) goto L31;
        Function0 r17 = r44.e;
        if (r17 == null) goto L31;
        if (((Boolean) r17.invoke()).booleanValue() != true) goto L31;
        boolean r18 = true;
    L32:
        if (r44 == null) goto L36;
        final b0 r19 = r44.k;
        if (r19 == null) goto L36;
        r9 = new m(r19);
    L36:
        IAIChatUgcAIGCService.a.c(r11, r12, r13, r16, null, null, r10, r18, r9, MapsKt.mapOf(TuplesKt.to("enter_method", "ai_edit_video_overview")));
    L31:
        r18 = false;
    L20:
        r5 = null;
        goto L21
    L15:
        r8 = null;
        goto L16
    L12:
        r7 = null;
    L37:
        r46.invoke();
    L103:
        return Unit.INSTANCE;
    L39:
        throw new NoWhenBranchMatchedException();
    L41:
        if (r0.c == false) goto L101;
        VideoData r20 = r41.video;
        CreationNoWatermarkManager r21 = CreationNoWatermarkManager.a;
        if (r20 == null) goto L45;
        String r110 = r20.vid;
    L46:
        if (r20 == null) goto L48;
        nr9.g r111 = bz9.a.l(r20);
    L49:
        if (r20 == null) goto L53;
        Cover r112 = r20.cover;
        if (r112 == null) goto L53;
        String r113 = r112.key;
    L54:
        nr9.g r22 = r21.h0(r110, r111, r113);
        CreationChatItemClickHelper r114 = CreationChatItemClickHelper.a;
        if (r44 == null) goto L57;
        Fragment r23 = r44.a;
    L58:
        Pair[] r115 = new Pair[5];
        r115[0] = TuplesKt.to("creation_task_id", r41.id);
        if (r22 == null) goto L62;
        String r24 = r22.a;
        if (r24 == null) goto L62;
    L65:
        r115[1] = TuplesKt.to("vid", r24);
        if (r22 == null) goto L71;
        nr9.f r25 = r22.g;
        if (r25 == null) goto L71;
        String r26 = r25.b;
        if (r26 == null) goto L71;
    L92:
        r115[2] = TuplesKt.to("cover_url", r26);
        if (r22 == null) goto L98;
        Function4 r27 = r22.c;
        if (r27 == null) goto L98;
        r9 = r27;
    L100:
        r115[3] = TuplesKt.to("download_url", r9);
        r115[4] = TuplesKt.to("message_type", String.valueOf(r40.getContentType()));
        CreationChatItemClickHelper.f(r114, r39, r23, r40, "creation_video_cite_btn", MapsKt.mapOf(r115));
    L98:
        if (r20 == null) goto L100;
        r9 = r20.downloadUrl;
    L71:
        if (r22 == null) goto L75;
        nr9.f r28 = r22.g;
        if (r28 == null) goto L75;
        r26 = r28.a;
    L76:
        if (r26 != null) goto L92;
        if (r20 == null) goto L83;
        Cover r29 = r20.cover;
        if (r29 == null) goto L83;
        ImageObj r30 = r29.imagePreview;
        if (r30 == null) goto L83;
        r26 = r30.url;
    L84:
        if (r26 != null) goto L92;
        if (r20 == null) goto L91;
        Cover r31 = r20.cover;
        if (r31 == null) goto L91;
        ImageObj r32 = r31.imageThumb;
        if (r32 == null) goto L91;
        r26 = r32.url;
    L91:
        r26 = null;
    L83:
        r26 = null;
    L75:
        r26 = null;
    L62:
        if (r20 == null) goto L64;
        r24 = r20.vid;
        goto L65
    L64:
        r24 = null;
        goto L65
    L57:
        r23 = null;
    L53:
        r113 = null;
        goto L54
    L48:
        r111 = null;
        goto L49
    L45:
        r110 = null;
    L101:
        r46.invoke();
        goto L103
    L105:
        if (r0.b == true) goto L108;
        r46.invoke();
        return Unit.INSTANCE;
    L108:
        Object r33 = i(r39, r40, r41, r42, r44, r45, r46, r47, r48);
        if (r33 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L112;
        return r33;
    L112:
        return Unit.INSTANCE;
    }

    public final Object d(View r21, Message r22, CreationItem r23, int r24, int r25, int r26, String r27, String r28, Boolean r29, kc8.q r30, JSONObject r31, Continuation<? super Unit> r32) {
        if ((r32 instanceof RichMediaCreationClickServiceImpl$bindLongClick$1) == false) goto L7;
        RichMediaCreationClickServiceImpl$bindLongClick$1 r1 = (RichMediaCreationClickServiceImpl$bindLongClick$1) r32;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L60:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Map r5 = (Map) r1.L$5;
        cz9.b r6 = (cz9.b) r1.L$4;
        JSONObject r7 = (JSONObject) r1.L$3;
        kc8.q r9 = (kc8.q) r1.L$2;
        Message r10 = (Message) r1.L$1;
        View r11 = (View) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L54:
        JSONObject r8 = (JSONObject) r0;
        c2.a(r8, r7);
        View r19 = r11;
        final kc8.q r12 = r9;
        View r13 = r19;
    L56:
        CreationChatItemClickHelper r14 = CreationChatItemClickHelper.a;
        Function5 r15 = new n(r12);
        Function4 r16 = new o(r12);
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 3;
        if (CreationChatItemClickHelper.c(r14, r6, r13, r10, r5, r8, true, r15, r16, r1, 8) != r3) goto L60;
        return r3;
    L17:
        cz9.b r17 = (cz9.b) r1.L$4;
        r7 = (JSONObject) r1.L$3;
        kc8.q r18 = (kc8.q) r1.L$2;
        r10 = (Message) r1.L$1;
        View r110 = (View) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r12 = r18;
        r13 = r110;
    L35:
        Map r20 = (Map) r0;
        if (r20 == null) goto L46;
        Map r33 = MapsKt.toMutableMap(r20);
        if (r33 == null) goto L46;
        if (r7 == null) goto L45;
        Iterator<String> r34 = r7.keys();
        if (r34 == null) goto L45;
    L43:
        if (r34.hasNext() == false) goto L45;
        String r111 = r34.next();
        r33.put(r111, r7.opt(r111));
    L45:
        cz9.b r112 = r17;
        r5 = r33;
        cz9.b r35 = r112;
    L49:
        if ((r35 instanceof cz9.o) == false) goto L55;
        CreationChatItemClickHelper r36 = CreationChatItemClickHelper.a;
        r1.L$0 = r13;
        r1.L$1 = r10;
        r1.L$2 = r12;
        r1.L$3 = r7;
        r1.L$4 = r35;
        r1.L$5 = r5;
        r1.label = 2;
        r36.getClass();
        Object r37 = CreationChatItemClickHelper.n(r10, r1);
        if (r37 != r3) goto L53;
        return r3;
    L53:
        r6 = r35;
        r0 = r37;
        kc8.q r113 = r12;
        r11 = r13;
        r9 = r113;
        goto L54
    L55:
        r6 = r35;
        r8 = null;
    L46:
        r35 = r17;
        r5 = null;
        goto L49
    L18:
        ResultKt.throwOnFailure(r0);
        Integer r38 = r23.type;
        if (r38 != null) goto L22;
    L24:
        if (r38 == null) goto L62;
        if (r38.intValue() != 2) goto L62;
        r17 = new cz9.o(r25, r26, r23, r22, r24, 193);
    L30:
        if ((r17 instanceof cz9.h) == false) goto L47;
        CoroutineDispatcher r39 = Dispatchers.getIO();
        r10 = r22;
        RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1 r114 = new RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1(r10, r27, r28, r29, r30, null);
        r13 = r21;
        r1.L$0 = r13;
        r1.L$1 = r10;
        r12 = r30;
        r1.L$2 = r12;
        r1.L$3 = r31;
        r1.L$4 = r17;
        r1.label = 1;
        r0 = BuildersKt.withContext(r39, r114, r1);
        if (r0 != r3) goto L34;
        return r3;
    L34:
        r7 = r31;
        goto L35
    L47:
        r13 = r21;
        r10 = r22;
        r12 = r30;
        r35 = r17;
        r5 = null;
        r7 = r31;
    L62:
        return Unit.INSTANCE;
    L22:
        if (r38.intValue() != 1) goto L24;
        r17 = new cz9.h(r25, r26, r23, r22, r24, 1985);
    L7:
        r1 = new RichMediaCreationClickServiceImpl$bindLongClick$1(this, r32);
        goto L8
    }

    public final Object h(View r21, View r22, Message r23, List<CreationItem> r24, CreationItem r25, String r26, String r27, Boolean r28, kc8.q r29, CoroutineScope r30, s0 r31, Continuation<? super Unit> r32) {
        CreationChatItemClickHelper r2 = CreationChatItemClickHelper.a;
        String r1 = r23.getMessageId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r8 = r1;
        rd8.b r3 = null;
        if (r31 == null) goto L10;
        if (r29 == null) goto L9;
        r3 = r29.g;
    L9:
        Long r4 = Boxing.boxLong(r31.a);
        Bitmap r0 = r31.b;
        r2.getClass();
        iy9.b r14 = CreationChatItemClickHelper.i(r3, r4, r0);
    L11:
        Object r5 = CreationChatItemClickHelper.q(r2, "RichMediaCreationClick", r21, r22, r26, r27, r28, r29, r8, r25, null, r30, null, null, r14, r23, r24, true, r32, 6656);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r5;
    L15:
        return Unit.INSTANCE;
    L10:
        r14 = null;
        goto L11
    }

    public final Object f(RichMediaCreationImageButtonAction r16, final View r17, final Message r18, CreationItem r19, int r20, final String r21, final String r22, final Boolean r23, boolean r24, final kc8.q r25, final CoroutineScope r26, JSONObject r27, Continuation<? super Unit> r28) {
        p0 r0 = e(r18, r19, r24, r25, r26);
        int r1 = b.a[r16.ordinal()];
        Fragment r3 = null;
        if (r1 == 1) goto L148;
        if (r1 == 2) goto L132;
        if (r1 == 3) goto L64;
        if (r1 == 4) goto L23;
        if (r1 != 5) goto L21;
        if (r0.e == false) goto L15;
        CreationChatItemClickHelper r2 = CreationChatItemClickHelper.a;
        if (r25 == null) goto L19;
        r3 = r25.a;
    L19:
        Boxing.boxBoolean(CreationChatItemClickHelper.f(r2, r17, r3, r18, "creation_image_cite_btn", MapsKt.mapOf(new Pair[]{TuplesKt.to("creation_task_id", r19.id), TuplesKt.to("message_type", String.valueOf(r18.getContentType()))})));
    L128:
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        if (r0.d == false) goto L62;
        if (r0.e == true) goto L62;
        if (r25 == null) goto L31;
        a0 r4 = r25.d;
        if (r4 == null) goto L31;
        wc9.e r5 = r4.h();
    L32:
        CreationChatItemClickHelper r6 = CreationChatItemClickHelper.a;
        if (r25 == null) goto L37;
        a0 r7 = r25.d;
        if (r7 == null) goto L37;
        String r8 = r7.getBotId();
    L38:
        if (r25 == null) goto L42;
        a0 r9 = r25.d;
        if (r9 == null) goto L42;
        BotModel r10 = r9.j0();
    L43:
        if (r25 == null) goto L49;
        Fragment r11 = r25.a;
        if (r11 == null) goto L49;
        t1a.b r12 = s1a.a.g(r11);
        if (r12 == null) goto L49;
        ChatPageContext r13 = (ChatPageContext) r12.a(ChatPageContext.class);
    L50:
        if (r25 == null) goto L52;
        Fragment r14 = r25.a;
    L53:
        if (r5 == null) goto L55;
        String r15 = r5.a;
    L56:
        r6.getClass();
        com.larus.uaigc.chat.markdown.image.component.k r29 = CreationChatItemClickHelper.h(r26, r8, r10, r13, r14, r15);
        if (r29 == null) goto L59;
        r3 = new VideoEditorComponent(r29);
    L59:
        if (r3 == null) goto L128;
        r3.b(q.d(r19, q.c(r19)));
        goto L128
    L55:
        r15 = null;
        goto L56
    L52:
        r14 = null;
    L49:
        r13 = null;
    L42:
        r10 = null;
    L37:
        r8 = null;
    L31:
        r5 = null;
    L62:
        return Unit.INSTANCE;
    L64:
        if (r0.c == false) goto L130;
        if (r0.e == true) goto L130;
        Map r30 = r18.getBusinessExt();
        if (r30 == null) goto L71;
        String r31 = (String) r30.get("message_case_mode");
    L73:
        if (Intrinsics.areEqual(r31, "1") == false) goto L79;
        s r32 = s.a;
        AppHost.Companion r33 = AppHost.a;
        Application r34 = r33.getApplication();
        String r35 = r33.getApplication().getString(2131909395);
        if (r35 != null) goto L77;
        r35 = "";
    L77:
        r32.getClass();
        s.t(r34, r35);
        return Unit.INSTANCE;
    L79:
        ImageInfo r36 = q.c(r19);
        if (r25 == null) goto L84;
        a0 r37 = r25.d;
        if (r37 == null) goto L84;
        wc9.e r38 = r37.h();
    L85:
        CreationChatItemClickHelper r39 = CreationChatItemClickHelper.a;
        if (r25 == null) goto L90;
        a0 r40 = r25.d;
        if (r40 == null) goto L90;
        String r41 = r40.getBotId();
    L91:
        if (r25 == null) goto L95;
        a0 r42 = r25.d;
        if (r42 == null) goto L95;
        BotModel r43 = r42.j0();
    L96:
        if (r25 == null) goto L102;
        Fragment r44 = r25.a;
        if (r44 == null) goto L102;
        t1a.b r45 = s1a.a.g(r44);
        if (r45 == null) goto L102;
        ChatPageContext r46 = (ChatPageContext) r45.a(ChatPageContext.class);
    L103:
        if (r25 == null) goto L105;
        Fragment r47 = r25.a;
    L106:
        if (r38 == null) goto L108;
        String r48 = r38.a;
    L109:
        r39.getClass();
        com.larus.uaigc.chat.markdown.image.component.a r49 = CreationChatItemClickHelper.g(r26, r41, r43, r46, r47, r48);
        if (r49 == null) goto L112;
        ImageEditorComponent r50 = new ImageEditorComponent(r49);
    L113:
        if (r50 == null) goto L128;
        String r51 = q.d(r19, r36);
        if (r36 == null) goto L122;
        Image r52 = r36.i;
        if (r52 == null) goto L122;
        Fragment r53 = bz9.a.b(r52);
        if (r53 == null) goto L122;
        r3 = r53;
    L126:
        r50.b(r51, r3);
    L122:
        if (r36 == null) goto L126;
        Image r54 = r36.a;
        if (r54 == null) goto L126;
        r3 = bz9.a.b(r54);
        goto L126
    L112:
        r50 = null;
        goto L113
    L108:
        r48 = null;
        goto L109
    L105:
        r47 = null;
    L102:
        r46 = null;
    L95:
        r43 = null;
    L90:
        r41 = null;
    L84:
        r38 = null;
        goto L85
    L71:
        r31 = null;
    L130:
        return Unit.INSTANCE;
    L132:
        if (r0.b == false) goto L134;
        ImageOperatorComponent r55 = new ImageOperatorComponent(new RichMediaCreationClickServiceImpl$imageOperator$1(r17, r26, r18, r21, r22, r23, r25));
        ImageData r56 = r19.image;
        if (r56 == null) goto L138;
        ImageInfo r57 = bz9.a.j(r56, r19.genDetail);
    L139:
        JSONObject r58 = q.b(r18, r19, r20, false, false, r27);
        String r59 = r18.getMessageId();
        CreationGenDetail r60 = r19.genDetail;
        if (r60 == null) goto L142;
        r3 = r60.taskType;
    L142:
        Object r61 = ez9.b.a(r55, r57, r58, r59, r3, r28);
        if (r61 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L146;
        return r61;
    L146:
        return Unit.INSTANCE;
    L138:
        r57 = null;
        goto L139
    L134:
        return Unit.INSTANCE;
    L148:
        if (r0.a == false) goto L150;
        ImageOperatorComponent r62 = new ImageOperatorComponent(new RichMediaCreationClickServiceImpl$imageOperator$1(r17, r26, r18, r21, r22, r23, r25));
        ImageData r63 = r19.image;
        if (r63 == null) goto L154;
        ImageInfo r64 = bz9.a.j(r63, r19.genDetail);
    L155:
        JSONObject r65 = q.b(r18, r19, r20, true, true, r27);
        String r66 = r18.getMessageId();
        CreationGenDetail r67 = r19.genDetail;
        if (r67 == null) goto L158;
        r3 = r67.taskType;
    L158:
        Object r68 = r62.e(r64, r65, r66, r3, r28);
        if (r68 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L162;
        return r68;
    L162:
        return Unit.INSTANCE;
    L154:
        r64 = null;
        goto L155
    L150:
        return Unit.INSTANCE;
    }
}
