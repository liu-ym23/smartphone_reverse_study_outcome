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
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 N2\u00020\u0001:\u0001NJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J<\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J}\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&¢\u0006\u0002\u0010)JT\u0010*\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H&J(\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010,2\u0006\u0010\u0006\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010!H¦@¢\u0006\u0002\u00107J:\u00108\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010!2\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H&JN\u0010>\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u0010D\u001a\u00020E2\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010GH&J.\u0010H\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010!2\u0006\u0010I\u001a\u00020\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H&JD\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010%2\b\u00106\u001a\u0004\u0018\u00010!2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020E2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MH&¨\u0006O"}, d2 = {"Lcom/larus/chat/gallery/api/IChatGalleryService;", "", "openChatGallery", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "galleryContext", "Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;", "getChatGalleryInputProvider", "Lcom/larus/gallery/api/IGalleryComponentProvider;", "Lcom/larus/chat/gallery/api/bean/ChatGalleryData;", "getDisplayArea", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "isEnableNewPreview", "", "isInCollectionMode", "isPreviewEnabled", "scene", "Lcom/larus/chat/gallery/api/PreviewScene;", "getGalleryNavigationBarHeight", "openPreviewCreationRecord", "dataBridge", "Lcom/larus/chat/gallery/api/ICreationFeedDataBridge;", "selectCreationId", "", "clickIndex", "openPreviewChatMessage", "conversationId", "selectMessageId", "selectMessage", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "startView", "Landroid/view/View;", "initialVideoStartTime", "initialVideoCoverBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/chat/api/MessageAdapter;ILandroid/view/View;Ljava/lang/Integer;Landroid/graphics/Bitmap;Lcom/larus/chat/gallery/api/PreviewScene;)V", "openPreviewMedia", "items", "", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "initialPosition", "session", "Lcom/larus/chat/gallery/api/PreviewMediaSession;", "capability", "Lcom/larus/chat/gallery/api/PreviewCapability;", "entryContext", "Lcom/larus/platform/model/preview/MediaEntryContext;", "transformMessageToGalleryData", "message", "(Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImage", "imageData", "Lcom/larus/bmhome/bigimg/ImageData;", "key", "reportParams", "Lorg/json/JSONObject;", "downloadVideo", "videoData", "Lcom/larus/platform/model/video/VideoPlayData;", "videoParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "messageId", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lkotlin/Function1;", "shareImage", "imageUrl", "shareVideo", "rootView", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatGalleryService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001JM\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019H\u0096\u0001J\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0096\u0001J\u0019\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020\u001aH\u0096\u0001J\u001b\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001Jp\u0010,\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\t2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\"2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\"2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010'\u001a\u00020(H\u0096\u0001¢\u0006\u0002\u00108J9\u00109\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00102\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0096\u0001JQ\u0010=\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020(2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0001J-\u0010H\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010I\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001JC\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u0001042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010MH\u0096\u0001J(\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010?2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096A¢\u0006\u0002\u0010O¨\u0006P"}, d2 = {"Lcom/larus/chat/gallery/api/IChatGalleryService$Companion;", "Lcom/larus/chat/gallery/api/IChatGalleryService;", "<init>", "()V", "downloadImage", "", "context", "Landroid/content/Context;", "message", "Lcom/larus/im/bean/message/Message;", "imageData", "Lcom/larus/bmhome/bigimg/ImageData;", "key", "", "reportParams", "Lorg/json/JSONObject;", "downloadVideo", "videoData", "Lcom/larus/platform/model/video/VideoPlayData;", "videoParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "messageId", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lkotlin/Function1;", "", "getChatGalleryInputProvider", "Lcom/larus/gallery/api/IGalleryComponentProvider;", "Lcom/larus/chat/gallery/api/bean/ChatGalleryData;", "galleryContext", "Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;", "getDisplayArea", "Lkotlin/Pair;", "", "getGalleryNavigationBarHeight", "isEnableNewPreview", "isInCollectionMode", "isPreviewEnabled", "scene", "Lcom/larus/chat/gallery/api/PreviewScene;", "openChatGallery", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "openPreviewChatMessage", "conversationId", "selectMessageId", "selectMessage", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "clickIndex", "startView", "Landroid/view/View;", "initialVideoStartTime", "initialVideoCoverBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/chat/api/MessageAdapter;ILandroid/view/View;Ljava/lang/Integer;Landroid/graphics/Bitmap;Lcom/larus/chat/gallery/api/PreviewScene;)V", "openPreviewCreationRecord", "dataBridge", "Lcom/larus/chat/gallery/api/ICreationFeedDataBridge;", "selectCreationId", "openPreviewMedia", "items", "", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "initialPosition", "session", "Lcom/larus/chat/gallery/api/PreviewMediaSession;", "capability", "Lcom/larus/chat/gallery/api/PreviewCapability;", "entryContext", "Lcom/larus/platform/model/preview/MediaEntryContext;", "shareImage", "imageUrl", "shareVideo", "rootView", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "transformMessageToGalleryData", "(Lcom/larus/chat/gallery/api/bean/ChatGalleryContext;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IChatGalleryService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IChatGalleryService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final Pair<Integer, Integer> a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.b.a(r2);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final int c(Context r2) {
            return this.b.c(r2);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void d(Context r9, nr9.g r10, c4 r11, String r12, CoroutineScope r13, Function1<? super Boolean, Unit> r14) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r13, "lifecycleScope");
            this.b.d(r9, r10, r11, r12, r13, r14);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void e(Context r9, FragmentManager r10, g0 r11, String r12, int r13, PreviewScene r14) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r10, "fragmentManager");
            Intrinsics.checkNotNullParameter(r11, "dataBridge");
            Intrinsics.checkNotNullParameter(r12, "selectCreationId");
            Intrinsics.checkNotNullParameter(r14, "scene");
            this.b.e(r9, r10, r11, r12, r13, r14);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void f(Context r14, FragmentManager r15, String r16, String r17, Message r18, q0 r19, int r20, View r21, Integer r22, Bitmap r23, PreviewScene r24) {
            Intrinsics.checkNotNullParameter(r14, "context");
            Intrinsics.checkNotNullParameter(r15, "fragmentManager");
            Intrinsics.checkNotNullParameter(r16, "conversationId");
            Intrinsics.checkNotNullParameter(r17, "selectMessageId");
            Intrinsics.checkNotNullParameter(r24, "scene");
            this.b.f(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void g(Context r8, Message r9, m1 r10, String r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r8, "context");
            this.b.g(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final boolean h(boolean r2) {
            return this.b.h(r2);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void i(FragmentManager r2, ty8.a r3) {
            Intrinsics.checkNotNullParameter(r3, "galleryContext");
            this.b.i(r2, r3);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void j(FragmentActivity r2, Message r3, String r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "imageUrl");
            this.b.j(r2, r3, r4, r5);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final boolean k(Context r11, FragmentManager r12, PreviewScene r13, List r14, int r15, com.larus.chat.gallery.api.a r16, l r17, dr9.b r18) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "fragmentManager");
            Intrinsics.checkNotNullParameter(r13, "scene");
            Intrinsics.checkNotNullParameter(r14, "items");
            Intrinsics.checkNotNullParameter(r16, "session");
            Intrinsics.checkNotNullParameter(r17, "capability");
            return this.b.k(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final void l(View r8, Message r9, nr9.g r10, c4 r11, CoroutineScope r12) {
            Intrinsics.checkNotNullParameter(r12, "lifecycleScope");
            this.b.l(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final com.larus.gallery.api.t<ty8.b> m(ty8.a r2) {
            Intrinsics.checkNotNullParameter(r2, "galleryContext");
            return this.b.m(r2);
        }

        @Override // com.larus.chat.gallery.api.IChatGalleryService
        public final boolean n(PreviewScene r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            return this.b.n(r2, r3);
        }

        private Companion() {
            IChatGalleryService r0 = (IChatGalleryService) ServiceManager.get().getService(IChatGalleryService.class);
            if (r0 != null) goto L5;
            r0 = new ChatGalleryServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ boolean b(Companion r11, Context r12, FragmentManager r13, PreviewScene r14, List r15, int r16, com.larus.chat.gallery.api.a r17, l r18, dr9.b r19, int r20) {
            if ((r20 & 64) == 0) goto L5;
            l r9 = r17.getCapability();
        L7:
            if ((r20 & 128) == 0) goto L9;
            dr9.b r10 = null;
        L11:
            return r11.k(r12, r13, r14, r15, r16, r17, r9, r10);
        L9:
            r10 = r19;
            goto L11
        L5:
            r9 = r18;
            goto L7
        }

        public static /* synthetic */ void a(Companion r15, Context r16, FragmentManager r17, String r18, String r19, Message r20, q0 r21, int r22, View r23, PreviewScene r24, int r25) {
            if ((r25 & 16) == 0) goto L5;
            Message r8 = null;
        L7:
            if ((r25 & 32) == 0) goto L9;
            q0 r9 = null;
        L11:
            if ((r25 & 64) == 0) goto L13;
            int r10 = 0;
        L15:
            if ((r25 & 128) == 0) goto L17;
            View r11 = null;
        L19:
            if ((r25 & 1024) == 0) goto L21;
            PreviewScene r14 = PreviewScene.MESSAGE;
        L22:
            r15.f(r16, r17, r18, r19, r8, r9, r10, r11, null, null, r14);
            return;
        L21:
            r14 = r24;
            goto L22
        L17:
            r11 = r23;
            goto L19
        L13:
            r10 = r22;
            goto L15
        L9:
            r9 = r21;
            goto L11
        L5:
            r8 = r20;
            goto L7
        }
    }

    static {
        a = Companion.c;
    }

    Pair<Integer, Integer> a(Context r1);

    int c(Context r1);

    void d(Context r1, nr9.g r2, c4 r3, String r4, CoroutineScope r5, Function1<? super Boolean, Unit> r6);

    void e(Context r1, FragmentManager r2, g0 r3, String r4, int r5, PreviewScene r6);

    void f(Context r1, FragmentManager r2, String r3, String r4, Message r5, q0 r6, int r7, View r8, Integer r9, Bitmap r10, PreviewScene r11);

    void g(Context r1, Message r2, m1 r3, String r4, JSONObject r5);

    boolean h(boolean r1);

    void i(FragmentManager r1, ty8.a r2);

    void j(FragmentActivity r1, Message r2, String r3, JSONObject r4);

    boolean k(Context r1, FragmentManager r2, PreviewScene r3, List r4, int r5, com.larus.chat.gallery.api.a r6, l r7, dr9.b r8);

    void l(View r1, Message r2, nr9.g r3, c4 r4, CoroutineScope r5);

    com.larus.gallery.api.t<ty8.b> m(ty8.a r1);

    boolean n(PreviewScene r1, boolean r2);
}
