package com.larus.chat.gallery.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewLegacyReason;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.chat.gallery.api.l;
import com.larus.chat.gallery.impl.preview.m;
import com.larus.chat.gallery.impl.preview.p;
import com.larus.chat.gallery.impl.preview.q;
import com.larus.chat.gallery.providers.input.GalleryInputProvider;
import com.larus.community.impl.component.g0;
import com.larus.gallery.adapter.ui.i;
import com.larus.gallery.api.DisplayGravity;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.gallery.api.t;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.b0;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.model.chat.h0;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.model.preview.MediaEntryScene;
import com.larus.platform.service.i2;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationAiEditService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J8\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016Jo\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010+JP\u0010,\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0018\u00107\u001a\u0002062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00101\u001a\u000202H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u00109\u001a\u00020\u0013*\u0002062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.2\u0006\u0010\b\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u0010<J8\u0010=\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010#2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010\u001d2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016JL\u0010C\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010I\u001a\u00020J2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010LH\u0016J,\u0010M\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010#2\u0006\u0010N\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016JB\u0010O\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010'2\b\u0010;\u001a\u0004\u0018\u00010#2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010I\u001a\u00020J2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016¨\u0006S"}, d2 = {"Lcom/larus/chat/gallery/impl/ChatGalleryServiceImpl;", "Lcom/larus/chat/gallery/api/IChatGalleryService;", "<init>", "()V", "openChatGallery", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "galleryContext", "Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;", "getChatGalleryInputProvider", "Lcom/larus/gallery/api/IGalleryComponentProvider;", "Lcom/larus/chat/gallery/api/bean/ChatGalleryData;", "getDisplayArea", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "isEnableNewPreview", "", "isInCollectionMode", "isPreviewEnabled", "scene", "Lcom/larus/chat/gallery/api/PreviewScene;", "getGalleryNavigationBarHeight", "openPreviewCreationRecord", "dataBridge", "Lcom/larus/chat/gallery/api/ICreationFeedDataBridge;", "selectCreationId", "", "clickIndex", "openPreviewChatMessage", "conversationId", "selectMessageId", "selectMessage", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "startView", "Landroid/view/View;", "initialVideoStartTime", "initialVideoCoverBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/chat/api/MessageAdapter;ILandroid/view/View;Ljava/lang/Integer;Landroid/graphics/Bitmap;Lcom/larus/chat/gallery/api/PreviewScene;)V", "openPreviewMedia", "items", "", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "initialPosition", "session", "Lcom/larus/chat/gallery/api/PreviewMediaSession;", "capability", "Lcom/larus/chat/gallery/api/PreviewCapability;", "entryContext", "Lcom/larus/platform/model/preview/MediaEntryContext;", "defaultEntryContext", "isMediaSourceScene", "matches", "transformMessageToGalleryData", "message", "(Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImage", "imageData", "Lcom/larus/bmhome/bigimg/ImageData;", "key", "reportParams", "Lorg/json/JSONObject;", "downloadVideo", "videoData", "Lcom/larus/platform/model/video/VideoPlayData;", "videoParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "messageId", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lkotlin/Function1;", "shareImage", "imageUrl", "shareVideo", "rootView", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatGalleryServiceImpl implements IChatGalleryService {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreviewScene.values().length];
            r0[PreviewScene.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PreviewScene.ATTACHMENT_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PreviewScene.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PreviewScene.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public ChatGalleryServiceImpl() {
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final Pair<Integer, Integer> a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = m0.b(r4);
        int r1 = (m0.a(r4) - i5.n()) - c(r4);
        return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r1));
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final int c(Context r2) {
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r3 = (FragmentActivity) r2;
    L6:
        if (r3 == null) goto L8;
        int r4 = u.b(r3);
    L9:
        if (r4 == 0) goto L11;
        return r4;
    L11:
        return i5.h();
    L8:
        r4 = 0;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final boolean h(boolean r2) {
        return n(PreviewScene.MESSAGE, r2);
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final t<ty8.b> m(ty8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        return new GalleryInputProvider(r2);
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void i(FragmentManager r18, ty8.a r19) {
        Intrinsics.checkNotNullParameter(r19, "galleryContext");
        Lazy r3 = e.a;
        Intrinsics.checkNotNullParameter(r19, "galleryContext");
        int r2 = z2.a.getCreationDetailLayoutConfig().c();
        IChatGalleryService.Companion r4 = IChatGalleryService.a;
        PreviewScene r14 = PreviewScene.MESSAGE;
        boolean r5 = r4.n(r14, false);
        q0 r6 = r19.e;
        String r7 = null;
        if (r6 == null) goto L11;
        q0.a r8 = r6.getProvider();
        if (r8 == null) goto L11;
        y r9 = r8.u0();
        if (r9 == null) goto L11;
        wc9.e r10 = r9.h();
        if (r10 == null) goto L11;
        Integer r11 = r10.v;
    L12:
        if (r5 == true) goto L20;
        boolean r12 = true;
        if (1 <= r2) goto L16;
    L18:
        r12 = false;
    L19:
        if (r12 == true) goto L20;
    L41:
        Pair<Integer, Integer> r13 = r4.a(r19.getContext());
        GalleryBuilder r15 = new GalleryBuilder(r19.getContext());
        vy8.a r16 = new vy8.a(r19);
        Intrinsics.checkNotNullParameter(r16, "dataSource");
        r15.b = r16;
        r15.a(ProviderType.TOP, new com.larus.chat.gallery.impl.providers.d(r19));
        r15.a(ProviderType.NON_UI, new az8.a());
        int r17 = r19.f;
        if (r17 < 0) goto L44;
        r15.c = r17;
    L44:
        com.larus.gallery.api.a r20 = new com.larus.gallery.api.a(((Number) r13.getFirst()).intValue(), ((Number) r13.getSecond()).intValue(), DisplayGravity.TOP, new i(i5.Z()));
        Lazy r21 = e.a;
        com.larus.gallery.api.b r22 = new com.larus.gallery.api.b(r20, false, null, ((h0) r21.getValue()).b.b, false, false, false, null, null, false, 32510);
        Intrinsics.checkNotNullParameter(r22, "displayConfig");
        r15.d = r22;
        Intrinsics.checkNotNullParameter("ChatGalleryDialog", "tag");
        r15.m = "ChatGalleryDialog";
        r15.l = r19.h;
        if (((h0) r21.getValue()).a.b == false) goto L48;
        r15.a(ProviderType.BOTTOM, new GalleryInputProvider(r19));
    L48:
        if (((h0) r21.getValue()).a.c == false) goto L50;
        ProviderType r23 = ProviderType.RIGHT_SIDE;
        int r24 = jy9.d.a;
        Intrinsics.checkNotNullParameter(r19, "aiEditContext");
        r15.a(r23, new az8.e(ICreationAiEditService.a.a(r19)));
    L50:
        r15.b(r18);
        return;
    L16:
        if (r2 >= 7) goto L18;
    L20:
        Message r25 = r19.b;
        if (r25 == null) goto L23;
        String r26 = r25.getConversationId();
    L25:
        if (com.larus.bmhome.utils.i.e(r26, r11) == false) goto L41;
        Message r27 = r19.b;
        if (r27 == null) goto L29;
        String r28 = r27.getConversationId();
    L30:
        if (r27 == null) goto L32;
        r7 = r27.getMessageId();
    L32:
        if (r28 == null) goto L40;
        if (r7 == null) goto L40;
        if (r18 == null) goto L40;
        int r29 = m.a;
        Context r30 = r19.getContext();
        q0 r31 = r19.e;
        if (r11 == null) goto L38;
        int r32 = r11.intValue();
    L39:
        m.a(r30, r18, new p.a(r28, r7, r27, r31, r32, r19.f, r19.h, null, null, r14));
        return;
    L38:
        r32 = 0;
    L40:
        FLogger.a.e("ChatGalleryHelper", "实验组参数转换失败, 降级走 ChatGallery");
        goto L41
    L29:
        r28 = null;
        goto L30
    L23:
        r26 = null;
    L11:
        r11 = null;
        goto L12
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final boolean n(PreviewScene r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        boolean r0 = false;
        if (r4 == false) goto L5;
    L19:
        return false;
    L5:
        if (q.a(r3) == false) goto L19;
        if (r3 != PreviewScene.ALBUM) goto L10;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L18;
        return true;
    L18:
        return q.b(r3);
    L10:
        if (r3 == PreviewScene.ATTACHMENT_PANEL) goto L15;
        if (r3 == PreviewScene.CAMERA_RESULT) goto L15;
        if (r3 != PreviewScene.CLOUD_DRIVE) goto L16;
        goto L15
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void j(FragmentActivity r9, Message r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "imageUrl");
        Lazy r2 = e.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "imageUrl");
        ShareServiceDelegate.b.w(r12);
        if (r10 == null) goto L5;
        String r13 = r10.getMessageId();
    L6:
        e.a(r9, r13, r11, true, MusicAppletPage.KEY_SOURCE, r12, null, 64);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void g(final Context r14, final Message r15, m1 r16, String r17, JSONObject r18) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Lazy r4 = e.a;
        String r6 = "";
        Intrinsics.checkNotNullParameter(r14, "context");
        if (r15 == null) goto L88;
        UserCreationFromIM r0 = IUgcAIGCService.a.I(r15, r16.f, r17);
        FragmentActivity r7 = null;
        if (r0 == null) goto L7;
        String r8 = r0.getCreationId();
    L8:
        final ChatGalleryHelper$downloadImage$1$checkBlock$1 r9 = new ChatGalleryHelper$downloadImage$1$checkBlock$1(r8, r16, r15, null);
        if (r18 != null) goto L11;
        JSONObject r10 = new JSONObject();
    L12:
        r10.put("click_method", "detail_click");
        r10.put("click_from", "click_download");
        Map r1 = r15.getExt();
        if (r1 == null) goto L15;
        String r2 = (String) r1.get("creativity_scene");
    L17:
        if (Intrinsics.areEqual(r2, CreativeScene.AVATAR_IMAGE) == false) goto L19;
        String r3 = "replica";
    L20:
        r10.put("is_replica_gen", r3);
        Map r5 = r15.getExt();
        if (r5 == null) goto L23;
        String r11 = (String) r5.get("creativity_scene");
    L24:
        r10.put("is_image_edit", Intrinsics.areEqual(r11, CreativeScene.AI_BEAUTIFY_IMAGE) ? 1 : 0);
        r10.put("download_method", "click_icon");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        Map r13 = r15.getExt();     // Catch: Throwable -> L33
        if (r13 == null) goto L30;
        String r19 = (String) r13.get("bot_state");     // Catch: Throwable -> L33
        if (r19 == null) goto L30;
        String r20 = new JSONObject(r19).optString("agent_id", "");     // Catch: Throwable -> L33
    L31:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r21) == false) goto L38;
        r21 = null;
    L38:
        String r22 = (String) r21;
        if (r22 != null) goto L41;
        r22 = "";
    L41:
        r10.put("agent_id", r22);
        Map r23 = r15.getExt();     // Catch: Throwable -> L50
        if (r23 == null) goto L47;
        String r24 = (String) r23.get("fpa_common_param");     // Catch: Throwable -> L50
        if (r24 == null) goto L47;
        String r25 = new JSONObject(r24).optString("agent_tool", "");     // Catch: Throwable -> L50
    L48:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r26) == false) goto L55;
        r26 = null;
    L55:
        String r27 = (String) r26;
        if (r27 == null) goto L59;
        r6 = r27;
    L59:
        r10.put("agent_tool", r6);
        r10.put("creation_id", r8);
        o.a.reportEvent("picture_download", r10);
        String r28 = r16.c;
        if (r28 != null) goto L62;
    L66:
        String r29 = r16.a;
        if (r29 == null) goto L69;
        Uri r30 = b0.a(r29, "send.photo_dialog_download", false, false, 6);
    L70:
        if (r30 == null) goto L90;
        final String r31 = r30.toString();
        if (Build.VERSION.SDK_INT <= 29) goto L75;
    L82:
        Lazy r32 = e.a;
        e.a(r14, r15.getMessageId(), r31, false, null, r10, r9, 16);
        return;
    L75:
        if (ContextCompat.checkSelfPermission(r14, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L82;
        if ((r14 instanceof FragmentActivity) == false) goto L79;
        r7 = (FragmentActivity) r14;
    L79:
        if (r7 == null) goto L91;
        final JSONObject r33 = r10;
        i2.b.a(r7, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new d(r14, r15, r31, r33, r9));
        return;
    L91:
        return;
    L90:
        return;
    L69:
        r30 = null;
        goto L70
    L62:
        if (Intrinsics.areEqual(r16.a, r28) == true) goto L66;
        String r34 = r16.c;
        if (r34 == null) goto L69;
        r30 = b0.a(r34, "send.photo_dialog_download", false, false, 6);
    L47:
        r25 = null;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L30:
        r20 = null;
    L33:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L23:
        r11 = null;
        goto L24
    L19:
        r3 = ReeditType.IMAGE;
        goto L20
    L15:
        r2 = null;
        goto L17
    L11:
        r10 = r18;
        goto L12
    L7:
        r8 = null;
        goto L8
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void l(View r82, Message r83, g r84, c4 r85, CoroutineScope r86) {
        Intrinsics.checkNotNullParameter(r86, "lifecycleScope");
        Lazy r1 = e.a;
        Intrinsics.checkNotNullParameter(r86, "lifecycleScope");
        wc9.e r6 = r85.e;
        BotModel r7 = r85.d;
        String r8 = r85.c;
        LruCache<String, wc9.e> r0 = ko8.a.a;
        String r10 = ko8.a.e(ko8.a.e);
        String r11 = r85.a;
        String r12 = r85.b;
        String r2 = r85.j;
        String r3 = r85.h;
        Boolean r4 = r85.k;
        h r80 = new h(r6, r7, r8, "video_detail", r10, r11, r12, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r3, r85.i, r2, r4, null, null, null, null, null, null, r83, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741572, -260, 1023);
        IUgcAIGCService.a.o(new com.larus.uaigc.creation.f(r80, r86, r84, r85, r82, r83));
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void d(final Context r23, g r24, c4 r25, String r26, CoroutineScope r27, final Function1<? super Boolean, Unit> r28) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r27, "lifecycleScope");
        Lazy r4 = e.a;
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r27, "lifecycleScope");
        IAIChatUgcAIGCService.a.e(IAIChatUgcAIGCService.a, r23, r24, new c4(r25.a, r26, r25.c, null, null, null, r25.g, null, null, null, null, null, null, null, 16312), "detail_click", r27, null, null, null, false, new c(r23, r28), 2016);
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void e(Context r1, FragmentManager r2, g0 r3, String r4, int r5, PreviewScene r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "dataBridge");
        Intrinsics.checkNotNullParameter(r4, "selectCreationId");
        Intrinsics.checkNotNullParameter(r6, "scene");
        int r7 = m.a;
        m.a(r1, r2, new p.b(r3, r4, r6));
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final boolean k(Context r25, FragmentManager r26, PreviewScene r27, List r28, int r29, com.larus.chat.gallery.api.a r30, l r31, dr9.b r32) {
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r26, "fragmentManager");
        Intrinsics.checkNotNullParameter(r27, "scene");
        Intrinsics.checkNotNullParameter(r28, "items");
        Intrinsics.checkNotNullParameter(r30, "session");
        Intrinsics.checkNotNullParameter(r31, "capability");
        if (r27 != PreviewScene.ALBUM) goto L5;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L16;
        return false;
    L16:
        if (r32 != null) goto L36;
        int[] r14 = a.a;
        int r15 = r14[r27.ordinal()];
        if (r15 == 1) goto L26;
        if (r15 == 2) goto L25;
        if (r15 == 3) goto L24;
        if (r15 == 4) goto L23;
        MediaEntryScene r16 = MediaEntryScene.MESSAGE;
    L27:
        MediaEntryScene r17 = r16;
        int r18 = r14[r27.ordinal()];
        if (r18 == 2) goto L34;
        if (r18 == 3) goto L33;
        if (r18 == 4) goto L32;
        MediaEntry r19 = MediaEntry.MAIN_INPUT;
    L35:
        dr9.b r110 = new dr9.b(r17, r19, r30.k(), null, null, new f(r30), 120);
    L37:
        int r111 = a.a[r27.ordinal()];
        if (r111 == 1) goto L53;
        if (r111 == 2) goto L50;
        if (r111 == 3) goto L47;
        if (r111 == 4) goto L44;
    L55:
        boolean r12 = false;
    L57:
        if (r12 == true) goto L60;
        FLogger.a.e("ChatGalleryServiceImpl", "openPreviewMedia rejected mismatched entry scene");
        return false;
    L60:
        int r13 = com.larus.chat.gallery.api.m.a;
        boolean r112 = n(r27, false);
        l r10 = r30.getCapability();
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r28, "items");
        Intrinsics.checkNotNullParameter(r10, "sessionCapability");
        Intrinsics.checkNotNullParameter(r31, "requestedCapability");
        int r2 = ((ArrayList) r28).size();
        if (r112 == true) goto L64;
        PreviewLegacyReason r3 = PreviewLegacyReason.CONFIG_DISABLED;
    L145:
        if (r3 != null) goto L147;
        boolean r11 = true;
    L148:
        if (r11 == true) goto L168;
        return false;
    L168:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L160
        int r5 = m.a;     // Catch: Throwable -> L160
        m.a(r25, r26, new p.c(r28, r29, r30, r31, r27));     // Catch: Throwable -> L160
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L153
    L155:
        Throwable r1 = Result.exceptionOrNull-impl(r0);     // Catch: Throwable -> L160
        if (r1 == null) goto L158;
        FLogger.a.e("ChatGalleryServiceImpl", "preview session open callback failed", r1);     // Catch: Throwable -> L160
    L158:
        Object r6 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L160
    L162:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L167;
        FLogger.a.e("ChatGalleryServiceImpl", "openPreviewMedia failed", r7);
        r6 = Boolean.FALSE;
    L167:
        return ((Boolean) r6).booleanValue();
    L153:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L160
        r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L162
    L147:
        r11 = false;
        goto L148
    L64:
        if (StringsKt.isBlank(r110.c) == false) goto L67;
        r3 = PreviewLegacyReason.SOURCE_NODE_MISSING;
        goto L145
    L67:
        String r21 = r110.g;
        if (r21 == null) goto L70;
        String r22 = r21.toLowerCase(Locale.ROOT);
    L71:
        if (r22 != null) goto L74;
        r22 = "";
    L74:
        if (Intrinsics.areEqual(r22, "ecom_page") == false) goto L76;
    L79:
        boolean r23 = true;
    L80:
        if (r23 == true) goto L144;
        dr9.c r24 = r110.h;
        if (r24 != null) goto L84;
    L86:
        boolean r33 = false;
    L87:
        if (r33 == true) goto L144;
        if (r31.a == false) goto L101;
        dr9.c r34 = r110.h;
        if (r34 == null) goto L97;
        if (r34.b() != true) goto L97;
        boolean r35 = true;
    L98:
        if (r35 == true) goto L101;
        r3 = PreviewLegacyReason.HOST_UNAVAILABLE;
    L97:
        r35 = false;
    L101:
        if (r2 > 0) goto L104;
        r3 = PreviewLegacyReason.EMPTY_ITEMS;
        goto L145
    L104:
        if (r28.isEmpty() == true) goto L118;
        Iterator r36 = r28.iterator();
    L108:
        if (r36.hasNext() == false) goto L118;
        com.larus.chat.gallery.api.o r37 = (com.larus.chat.gallery.api.o) r36.next();
        if (StringsKt.isBlank(r37.a) == false) goto L112;
    L115:
        boolean r38 = true;
    L116:
        if (r38 == false) goto L108;
        boolean r39 = true;
    L119:
        if (r39 == true) goto L143;
        ArrayList r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r41 = r28.iterator();
    L122:
        if (r41.hasNext() == false) goto L125;
        r40.add(((com.larus.chat.gallery.api.o) r41.next()).a);
        goto L122
    L125:
        if (CollectionsKt.distinct(r40).size() != r2) goto L143;
        if (r29 < 0) goto L130;
        if (r29 >= r2) goto L130;
        boolean r42 = true;
    L131:
        if (r42 == true) goto L134;
        r3 = PreviewLegacyReason.INVALID_POSITION;
        goto L145
    L134:
        if (com.larus.chat.gallery.api.m.a(r10) == true) goto L136;
    L142:
        r3 = PreviewLegacyReason.CAPABILITY_MISMATCH;
        goto L145
    L136:
        if (com.larus.chat.gallery.api.m.a(r31) == false) goto L142;
        if (Intrinsics.areEqual(r10, r31) == true) goto L141;
        r3 = PreviewLegacyReason.CAPABILITY_MISMATCH;
        goto L145
    L141:
        r3 = null;
    L130:
        r42 = false;
    L143:
        r3 = PreviewLegacyReason.INVALID_ITEMS;
        goto L145
    L112:
        if (StringsKt.isBlank(r37.b) == true) goto L115;
        r38 = false;
    L118:
        r39 = false;
        goto L119
    L84:
        if (r24.a() != true) goto L86;
        r33 = true;
    L144:
        r3 = PreviewLegacyReason.ENTRY_EXCLUDED;
        goto L145
    L76:
        if (StringsKt.startsWith$default(r22, "edu_", false, 2, null) == true) goto L79;
        r23 = false;
        goto L80
    L70:
        r22 = null;
        goto L71
    L44:
        if (r110.a != MediaEntryScene.CLOUD_DRIVE) goto L55;
    L54:
        r12 = true;
        goto L57
    L47:
        if (r110.a != MediaEntryScene.CAMERA_RESULT) goto L55;
    L50:
        if (r110.a != MediaEntryScene.ATTACHMENT_PANEL) goto L55;
    L53:
        if (r110.a != MediaEntryScene.ALBUM) goto L55;
    L32:
        r19 = MediaEntry.PREVIEW_PLUS;
        goto L35
    L33:
        r19 = MediaEntry.CAMERA_ALBUM;
        goto L35
    L34:
        r19 = MediaEntry.ATTACHMENT_PANEL;
        goto L35
    L23:
        r16 = MediaEntryScene.CLOUD_DRIVE;
        goto L27
    L24:
        r16 = MediaEntryScene.CAMERA_RESULT;
        goto L27
    L25:
        r16 = MediaEntryScene.ATTACHMENT_PANEL;
        goto L27
    L26:
        r16 = MediaEntryScene.ALBUM;
        goto L27
    L36:
        r110 = r32;
        goto L37
    L5:
        if (r27 == PreviewScene.ATTACHMENT_PANEL) goto L12;
        if (r27 == PreviewScene.CAMERA_RESULT) goto L12;
        if (r27 == PreviewScene.CLOUD_DRIVE) goto L12;
        r9 = false;
        goto L13
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void f(Context r15, FragmentManager r16, String r17, String r18, Message r19, q0 r20, int r21, View r22, Integer r23, Bitmap r24, PreviewScene r25) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "fragmentManager");
        Intrinsics.checkNotNullParameter(r17, "conversationId");
        Intrinsics.checkNotNullParameter(r18, "selectMessageId");
        Intrinsics.checkNotNullParameter(r25, "scene");
        int r2 = m.a;
        if (r20 == null) goto L13;
        q0.a r3 = r20.getProvider();
        if (r3 == null) goto L13;
        y r4 = r3.u0();
        if (r4 == null) goto L13;
        wc9.e r5 = r4.h();
        if (r5 == null) goto L13;
        Integer r6 = r5.v;
        if (r6 == null) goto L13;
        int r8 = r6.intValue();
    L14:
        m.a(r15, r16, new p.a(r17, r18, r19, r20, r8, r21, r22, r23, r24, r25));
        return;
    L13:
        r8 = 0;
        goto L14
    }
}
