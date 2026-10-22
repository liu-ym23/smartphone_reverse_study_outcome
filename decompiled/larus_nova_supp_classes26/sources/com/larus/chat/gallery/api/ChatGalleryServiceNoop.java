package com.larus.chat.gallery.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.utils.c4;
import com.larus.community.impl.component.g0;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J8\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016Jo\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010+JP\u0010,\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J(\u00107\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.2\u0006\u0010\b\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u00109J8\u0010:\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010#2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010\u001d2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016JL\u0010@\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010\u001d2\u0006\u0010F\u001a\u00020G2\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010IH\u0016J,\u0010J\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010#2\u0006\u0010K\u001a\u00020\u001d2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016JB\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010'2\b\u00108\u001a\u0004\u0018\u00010#2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020G2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016¨\u0006P"}, d2 = {"Lcom/larus/chat/gallery/api/ChatGalleryServiceNoop;", "Lcom/larus/chat/gallery/api/IChatGalleryService;", "<init>", "()V", "openChatGallery", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "galleryContext", "Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;", "getChatGalleryInputProvider", "Lcom/larus/gallery/api/IGalleryComponentProvider;", "Lcom/larus/chat/gallery/api/bean/ChatGalleryData;", "getDisplayArea", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "isEnableNewPreview", "", "isInCollectionMode", "isPreviewEnabled", "scene", "Lcom/larus/chat/gallery/api/PreviewScene;", "getGalleryNavigationBarHeight", "openPreviewCreationRecord", "dataBridge", "Lcom/larus/chat/gallery/api/ICreationFeedDataBridge;", "selectCreationId", "", "clickIndex", "openPreviewChatMessage", "conversationId", "selectMessageId", "selectMessage", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "startView", "Landroid/view/View;", "initialVideoStartTime", "initialVideoCoverBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/chat/api/MessageAdapter;ILandroid/view/View;Ljava/lang/Integer;Landroid/graphics/Bitmap;Lcom/larus/chat/gallery/api/PreviewScene;)V", "openPreviewMedia", "items", "", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "initialPosition", "session", "Lcom/larus/chat/gallery/api/PreviewMediaSession;", "capability", "Lcom/larus/chat/gallery/api/PreviewCapability;", "entryContext", "Lcom/larus/platform/model/preview/MediaEntryContext;", "transformMessageToGalleryData", "message", "(Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImage", "imageData", "Lcom/larus/bmhome/bigimg/ImageData;", "key", "reportParams", "Lorg/json/JSONObject;", "downloadVideo", "videoData", "Lcom/larus/platform/model/video/VideoPlayData;", "videoParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "messageId", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lkotlin/Function1;", "shareImage", "imageUrl", "shareVideo", "rootView", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatGalleryServiceNoop implements IChatGalleryService {
    public ChatGalleryServiceNoop() {
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final int c(Context r1) {
        return 0;
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void e(Context r1, FragmentManager r2, g0 r3, String r4, int r5, PreviewScene r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "dataBridge");
        Intrinsics.checkNotNullParameter(r4, "selectCreationId");
        Intrinsics.checkNotNullParameter(r6, "scene");
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void f(Context r1, FragmentManager r2, String r3, String r4, Message r5, q0 r6, int r7, View r8, Integer r9, Bitmap r10, PreviewScene r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "selectMessageId");
        Intrinsics.checkNotNullParameter(r11, "scene");
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void g(Context r1, Message r2, m1 r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final boolean h(boolean r1) {
        return false;
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void i(FragmentManager r1, ty8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void j(FragmentActivity r1, Message r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "imageUrl");
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final boolean k(Context r1, FragmentManager r2, PreviewScene r3, List r4, int r5, a r6, l r7, dr9.b r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "items");
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "capability");
        return false;
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void l(View r1, Message r2, nr9.g r3, c4 r4, CoroutineScope r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final com.larus.gallery.api.t<ty8.b> m(ty8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        return null;
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final boolean n(PreviewScene r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        return false;
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final Pair<Integer, Integer> a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return TuplesKt.to(0, 0);
    }

    @Override // com.larus.chat.gallery.api.IChatGalleryService
    public final void d(Context r1, nr9.g r2, c4 r3, String r4, CoroutineScope r5, Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        if (r6 == null) goto L6;
        r6.invoke(Boolean.FALSE);
        return;
    }
}
