package com.larus.bmhome.chat.block.base.config;

import android.util.Size;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import java.util.List;
import kc8.d0;
import kc8.p0;
import kc8.q;
import kc8.q0;
import kc8.r0;
import kc8.s0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jv\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096@¢\u0006\u0002\u0010\u001aJp\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010#J2\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016Jx\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010+J*\u0010,\u001a\u00020-2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u000203H\u0016Jh\u00104\u001a\u00020\u00052\u0006\u0010(\u001a\u0002052\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005072\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u00108¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationClickServiceNoop;", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationClickService;", "<init>", "()V", "onClick", "", "clickHostView", "Landroid/view/View;", "clickView", "message", "Lcom/larus/im/bean/message/Message;", "creationItems", "", "Lcom/larus/im/bean/message/CreationItem;", "clickItem", "currentPage", "", "previousPage", "isCollectMode", "", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "videoPlaybackSnapshot", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;", "(Landroid/view/View;Landroid/view/View;Lcom/larus/im/bean/message/Message;Ljava/util/List;Lcom/larus/im/bean/message/CreationItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoPlaybackSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindLongClick", "bindView", "itemPosition", "", "itemWidth", "itemHeight", "extraTraceParams", "Lorg/json/JSONObject;", "(Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageButtonCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonCapability;", "isLongPicShare", "onImageButtonClick", "action", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;", "anchorView", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoCapability", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoCapability;", "getCreationDisplaySize", "Landroid/util/Size;", "maxWidth", "totalItemCount", "createVideoPlaybackController", "Lcom/larus/bmhome/chat/block/base/config/IRichMediaCreationVideoPlaybackController;", "onVideoButtonClick", "Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;", "onCompleted", "Lkotlin/Function0;", "(Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;Landroid/view/View;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/CreationItem;IZLcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RichMediaCreationClickServiceNoop implements IRichMediaCreationClickService {
    public RichMediaCreationClickServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final Size c(CreationItem r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "clickItem");
        return null;
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final d0 g() {
        return new r0();
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final q0 a(Message r1, CreationItem r2, boolean r3, q r4) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r2, "clickItem");
        return new q0(false, false, false, false);
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final p0 e(Message r1, CreationItem r2, boolean r3, q r4, CoroutineScope r5) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r2, "clickItem");
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        return new p0(0);
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final Object b(RichMediaCreationVideoButtonAction r1, View r2, Message r3, CreationItem r4, int r5, boolean r6, q r7, CoroutineScope r8, Function0<Unit> r9, JSONObject r10, Continuation<? super Unit> r11) {
        r9.invoke();
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final Object d(View r1, Message r2, CreationItem r3, int r4, int r5, int r6, String r7, String r8, Boolean r9, q r10, JSONObject r11, Continuation<? super Unit> r12) {
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final Object h(View r1, View r2, Message r3, List<CreationItem> r4, CreationItem r5, String r6, String r7, Boolean r8, q r9, CoroutineScope r10, s0 r11, Continuation<? super Unit> r12) {
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService
    public final Object f(RichMediaCreationImageButtonAction r1, View r2, Message r3, CreationItem r4, int r5, String r6, String r7, Boolean r8, boolean r9, q r10, CoroutineScope r11, JSONObject r12, Continuation<? super Unit> r13) {
        return Unit.INSTANCE;
    }
}
