package com.larus.bmhome.chat.block.base.config;

import android.util.Size;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kc8.d0;
import kc8.p0;
import kc8.q;
import kc8.q0;
import kc8.s0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 72\u00020\u0001:\u00017Jx\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H¦@¢\u0006\u0002\u0010\u0018Jr\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H¦@¢\u0006\u0002\u0010!J2\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&Jz\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010$\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H¦@¢\u0006\u0002\u0010)J*\u0010*\u001a\u00020+2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\"\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cH&J\b\u00100\u001a\u000201H&Jj\u00102\u001a\u00020\u00032\u0006\u0010&\u001a\u0002032\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0003052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H¦@¢\u0006\u0002\u00106¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationClickService;", "", "onClick", "", "clickHostView", "Landroid/view/View;", "clickView", "message", "Lcom/larus/im/bean/message/Message;", "creationItems", "", "Lcom/larus/im/bean/message/CreationItem;", "clickItem", "currentPage", "", "previousPage", "isCollectMode", "", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "videoPlaybackSnapshot", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;", "(Landroid/view/View;Landroid/view/View;Lcom/larus/im/bean/message/Message;Ljava/util/List;Lcom/larus/im/bean/message/CreationItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindLongClick", "bindView", "itemPosition", "", "itemWidth", "itemHeight", "extraTraceParams", "Lorg/json/JSONObject;", "(Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageButtonCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonCapability;", "isLongPicShare", "onImageButtonClick", "action", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;", "anchorView", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoCapability;", "getCreationDisplaySize", "Landroid/util/Size;", "maxWidth", "totalItemCount", "createVideoPlaybackController", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationVideoPlaybackController;", "onVideoButtonClick", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;", "onCompleted", "Lkotlin/Function0;", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IRichMediaCreationClickService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jp\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096A¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J#\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0001J3\u0010 \u001a\u00020!2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$H\u0096\u0001J+\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0001Jv\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0+2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096A¢\u0006\u0002\u0010.Jx\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096A¢\u0006\u0002\u00103Jh\u00104\u001a\u00020\u00052\u0006\u00100\u001a\u0002052\u0006\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096A¢\u0006\u0002\u00108¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationClickService$Companion;", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationClickService;", "<init>", "()V", "bindLongClick", "", "bindView", "Landroid/view/View;", "message", "Lcom/larus/im/bean/message/Message;", "clickItem", "Lcom/larus/im/bean/message/CreationItem;", "itemPosition", "", "itemWidth", "itemHeight", "currentPage", "", "previousPage", "isCollectMode", "", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "extraTraceParams", "Lorg/json/JSONObject;", "(Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createVideoPlaybackController", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationVideoPlaybackController;", "getCreationDisplaySize", "Landroid/util/Size;", "maxWidth", "totalItemCount", "getImageButtonCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonCapability;", "isLongPicShare", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getVideoCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoCapability;", "onClick", "clickHostView", "clickView", "creationItems", "", "videoPlaybackSnapshot", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;", "(Landroid/view/View;Landroid/view/View;Lcom/larus/im/bean/message/Message;Ljava/util/List;Lcom/larus/im/bean/message/CreationItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onImageButtonClick", "action", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;", "anchorView", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onVideoButtonClick", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;", "onCompleted", "Lkotlin/Function0;", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Companion implements IRichMediaCreationClickService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IRichMediaCreationClickService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final q0 a(Message r2, CreationItem r3, boolean r4, q r5) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "clickItem");
            return this.b.a(r2, r3, r4, r5);
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final Object b(RichMediaCreationVideoButtonAction r14, View r15, Message r16, CreationItem r17, int r18, boolean r19, q r20, CoroutineScope r21, Function0<Unit> r22, JSONObject r23, Continuation<? super Unit> r24) {
            return this.b.b(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final Size c(CreationItem r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "clickItem");
            return this.b.c(r2, r3, r4);
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final Object d(View r15, Message r16, CreationItem r17, int r18, int r19, int r20, String r21, String r22, Boolean r23, q r24, JSONObject r25, Continuation<? super Unit> r26) {
            return this.b.d(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final p0 e(Message r8, CreationItem r9, boolean r10, q r11, CoroutineScope r12) {
            Intrinsics.checkNotNullParameter(r8, "message");
            Intrinsics.checkNotNullParameter(r9, "clickItem");
            Intrinsics.checkNotNullParameter(r12, "lifecycleScope");
            return this.b.e(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final Object f(RichMediaCreationImageButtonAction r16, View r17, Message r18, CreationItem r19, int r20, String r21, String r22, Boolean r23, boolean r24, q r25, CoroutineScope r26, JSONObject r27, Continuation<? super Unit> r28) {
            return this.b.f(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final d0 g() {
            return this.b.g();
        }

        @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
        public final Object h(View r15, View r16, Message r17, List<CreationItem> r18, CreationItem r19, String r20, String r21, Boolean r22, q r23, CoroutineScope r24, s0 r25, Continuation<? super Unit> r26) {
            return this.b.h(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        private Companion() {
            this.b = (IRichMediaCreationClickService) ServiceManager.get().getService(IRichMediaCreationClickService.class);
        }
    }

    static {
        a = Companion.c;
    }

    q0 a(Message r1, CreationItem r2, boolean r3, q r4);

    Object b(RichMediaCreationVideoButtonAction r1, View r2, Message r3, CreationItem r4, int r5, boolean r6, q r7, CoroutineScope r8, Function0<Unit> r9, JSONObject r10, Continuation<? super Unit> r11);

    Size c(CreationItem r1, int r2, int r3);

    Object d(View r1, Message r2, CreationItem r3, int r4, int r5, int r6, String r7, String r8, Boolean r9, q r10, JSONObject r11, Continuation<? super Unit> r12);

    p0 e(Message r1, CreationItem r2, boolean r3, q r4, CoroutineScope r5);

    Object f(RichMediaCreationImageButtonAction r1, View r2, Message r3, CreationItem r4, int r5, String r6, String r7, Boolean r8, boolean r9, q r10, CoroutineScope r11, JSONObject r12, Continuation<? super Unit> r13);

    d0 g();

    Object h(View r1, View r2, Message r3, List<CreationItem> r4, CreationItem r5, String r6, String r7, Boolean r8, q r9, CoroutineScope r10, s0 r11, Continuation<? super Unit> r12);
}
