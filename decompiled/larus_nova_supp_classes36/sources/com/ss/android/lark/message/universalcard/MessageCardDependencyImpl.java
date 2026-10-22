package com.ss.android.lark.message.universalcard;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.UpdateMessageCardLocalDataRequest;
import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.plugin.CardUpdateLocalDataPlugin;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.context.StreamingState;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.protocol.context.action.CardOpenUrlService;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.action.LynxCardActionClient;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.lynxcard.entity.SummaryHolder;
import com.ss.android.lark.message.lynxcard.message.LynxCardViewHolder;
import com.ss.android.lark.message.lynxcard.message.d;
import com.ss.android.lark.message.lynxcard.plugin.MsgCardUpdateLocalDataResponse;
import com.ss.android.lark.message.universalcard.datachannel.MessageCardStreamingManager;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener;
import com.ss.android.lark.widget.richtext.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import mya.h;
import r5b.b;
import v5b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J<\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016JO\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0016¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001aH\u0016J\u001c\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010%2\b\u00104\u001a\u0004\u0018\u00010%H\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/ss/android/lark/message/universalcard/MessageCardDependencyImpl;", "Lcom/larksuite/component/card/protocol/context/ICardDependency;", "bizContext", "Lcom/ss/android/lark/message/universalcard/MessageCardBizContext;", "lynxCardCellCallback", "Lcom/ss/android/lark/message/lynxcard/message/LynxCardCellCallback;", "messageCardActionService", "Lcom/ss/android/lark/message/universalcard/MessageCardActionService;", "<init>", "(Lcom/ss/android/lark/message/universalcard/MessageCardBizContext;Lcom/ss/android/lark/message/lynxcard/message/LynxCardCellCallback;Lcom/ss/android/lark/message/universalcard/MessageCardActionService;)V", "getCardActionService", "Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "previewImage", "", "imageView", "Landroid/view/View;", "cardImages", "", "Lcom/ss/android/lark/widget/richtext/Image;", "clickedImageItem", "previewVideo", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "photoItems", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "enableDownload", "", "videoOperateListener", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;", "previewFinishListener", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "(Lcom/larksuite/component/card/protocol/CardContext;Ljava/util/List;ZLcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLongClicked", "view", "canCopy", "updateCardLocalCache", "cardID", "", "cardVersion", "deltaData", "needPush", "sourceId", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin$CardUpdateLocalDataResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larksuite/framework/callback/IGetDataCallback;)V", "onCopySelectText", "copyText", "", "isPartial", "setMsgCardSummary", "summary", "translateSummary", "updateStreamingState", "streamingPhase", "Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "reRender", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MessageCardDependencyImpl implements ICardDependency {
    public static final a Companion = null;
    public static final String TAG = "MsgCardUpdateLocalData";
    private final MessageCardBizContext bizContext;
    private final d lynxCardCellCallback;
    private final MessageCardActionService messageCardActionService;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.message.universalcard.MessageCardDependencyImpl$previewVideo$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.message.universalcard.MessageCardDependencyImpl", f = "MessageCardDependencyImpl.kt", i = {0, 0, 0, 0, 0}, l = {62}, m = "previewVideo", n = {"cardContext", "photoItems", "videoOperateListener", "previewFinishListener", "enableDownload"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MessageCardDependencyImpl this$0;

        public AnonymousClass1(MessageCardDependencyImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Target.SIZE_ORIGINAL;
            return this.this$0.previewVideo(null, null, false, null, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public CardOpenUrlService getOpenUrlService() {
        return null;
    }

    public boolean canCopy() {
        d r0 = this.lynxCardCellCallback;
        if (r0 == null) goto L7;
        int r2 = d.g;
        if (d.a.c(r0.a, r0.b) != true) goto L7;
        boolean r1 = true;
    L9:
        return !r1;
    L7:
        r1 = false;
        goto L9
    }

    public void reRender() {
        d r0 = this.lynxCardCellCallback;
        if (r0 == null) goto L10;
        LynxCardViewHolder r1 = LynxCardViewHolder.V3(r0.a);
        if (r1 != null) goto L8;
        Log.e("LynxCardCellCallback", "reRender viewHolder is null");
        return;
    L8:
        UniversalCardLynxRender r2 = r1.m.b();
        int r3 = UniversalCardLynxRender.g;
        r2.b(null);
        return;
    }

    public CardActionService getCardActionService() {
        return this.messageCardActionService;
    }

    public static final /* synthetic */ d access$getLynxCardCellCallback$p(MessageCardDependencyImpl r0) {
        return r0.lynxCardCellCallback;
    }

    public boolean onLongClicked(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        d r5 = this.lynxCardCellCallback;
        if (r5 == null) goto L9;
        c<LynxCardContentVO> r0 = r5.b;
        if (r0 == null) goto L9;
        b<LynxCardContentVO> r1 = r5.c;
        if (r1 == null) goto L9;
        int r2 = d.g;
        d.a.a(r5.a, r0);
        return r1.d(r5.a, r0);
    L9:
        return false;
    }

    public void updateStreamingState(StreamingState.StreamingPhase r11) {
        Intrinsics.checkNotNullParameter(r11, "streamingPhase");
        d r1 = this.lynxCardCellCallback;
        if (r1 == null) goto L34;
        Intrinsics.checkNotNullParameter(r11, "streamingPhase");
        LynxCardViewHolder r0 = LynxCardViewHolder.V3(r1.a);
        if (r0 != null) goto L8;
        Log.e("LynxCardCellCallback", "updateStreamingState viewHolder is null");
        return;
    L8:
        if (r1.f == null) goto L36;
        Intrinsics.checkNotNullParameter(r0, "lynxCardViewHolder");
        Intrinsics.checkNotNullParameter(r11, "newPhase");
        StringBuilder r2 = new StringBuilder("onStreamingStateChanged, messageId=");
        c<LynxCardContentVO> r3 = r0.k;
        if (r3 == null) goto L12;
        String r4 = r3.getId();
    L13:
        r2.append(r4);
        r2.append(", newPhase=");
        r2.append(r11);
        Log.i("MessageCardStreamingManager", r2.toString());
        StreamingState r5 = MessageCardStreamingManager.a(r0.m);
        if (r5 != null) goto L16;
        Log.e("MessageCardStreamingManager", "onStreamingStateChanged currentState is null");
        return;
    L16:
        int r12 = MessageCardStreamingManager.b.a[r11.ordinal()];
        if (r12 != 1) goto L19;
        r5.setStreamingPhase(StreamingState.StreamingPhase.IN_STREAMING);
        return;
    L19:
        if (r12 != 2) goto L31;
        StreamingState.StreamingPhase r13 = r5.component2();
        CardRenderData r6 = r5.component3();
        if (r13 != StreamingState.StreamingPhase.IN_STREAMING) goto L29;
        if (r6 == null) goto L29;
        CardData r7 = r6.component3();
        CardContext r8 = r6.component4();
        CardConfig r9 = r6.component5();
        bz7.a r10 = r0.m;
        c<LynxCardContentVO> r14 = r0.k;
        if (r14 == null) goto L27;
        String r15 = r14.getId();
        if (r15 == null) goto L27;
    L28:
        MessageCardStreamingManager.c(r10, r15, r7, r8, r9, false);
    L27:
        r15 = "";
    L29:
        r5.reset();
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    L12:
        r4 = null;
        goto L13
    L36:
        return;
    }

    public void onCopySelectText(CharSequence r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "copyText");
        d r3 = this.lynxCardCellCallback;
        if (r3 == null) goto L9;
        c<LynxCardContentVO> r4 = r3.b;
        if (r4 == null) goto L9;
        LynxCardContentVO r5 = r4.b();
        if (r5 == null) goto L9;
        r5.w = r1;
    L9:
        d r6 = this.lynxCardCellCallback;
        if (r6 == null) goto L15;
        c<LynxCardContentVO> r7 = r6.b;
        if (r7 == null) goto L16;
        LynxCardContentVO r8 = r7.b();
        return;
    L16:
        return;
    }

    public void setMsgCardSummary(String r4, String r5) {
        if (r4 == null) goto L24;
        d r0 = this.lynxCardCellCallback;
        if (r0 == null) goto L25;
        Intrinsics.checkNotNullParameter(r4, "digest");
        c<LynxCardContentVO> r2 = r0.b;
        if (r2 == null) goto L17;
        LynxCardContentVO r3 = r2.b();
        if (r3 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "digest");
        ((v5b.a) r3).a.setLynxDigest(r4);
        f r1 = ((f) r3).g;
        if (r1 == null) goto L14;
        CardContent r6 = ((v5b.a) r1).a;
        if (r6 == null) goto L14;
        r6.setLynxDigest(r5);
    L14:
        c<LynxCardContentVO> r7 = r0.b;
        if (r7 == null) goto L26;
        SummaryHolder.a r8 = SummaryHolder.Companion;
        String r9 = r7.getId();
        SummaryHolder.b r10 = new SummaryHolder.b(r4, r5);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "summary");
        SummaryHolder.access$getDataMap$cp().put(r9, r10);
        Log.i(SummaryHolder.TAG, "put " + r9);
        return;
    L26:
        return;
    L17:
        CardContent r11 = r0.d;
        if (r11 == null) goto L20;
        r11.setLynxDigest(r4);
    L20:
        CardContent r12 = r0.d;
        if (r12 == null) goto L28;
        r12.setTranslateMsgCardSummary(r4);
        return;
    L28:
        return;
    L25:
        return;
    }

    public MessageCardDependencyImpl(MessageCardBizContext r2, d r3, MessageCardActionService r4) {
        Intrinsics.checkNotNullParameter(r2, "bizContext");
        Intrinsics.checkNotNullParameter(r4, "messageCardActionService");
        this.bizContext = r2;
        this.lynxCardCellCallback = r3;
        this.messageCardActionService = r4;
    }

    public void openProfilePage(Context r1, String r2, String r3) {
        ICardDependency.b.a(r1, r2, r3);
    }

    public void previewImage(View r5, List<? extends Image> r6, Image r7) {
        Intrinsics.checkNotNullParameter(r5, "imageView");
        Intrinsics.checkNotNullParameter(r6, "cardImages");
        Intrinsics.checkNotNullParameter(r7, "clickedImageItem");
        d r1 = this.lynxCardCellCallback;
        if (r1 == null) goto L16;
        String r2 = this.bizContext.getMsgId();
        Intrinsics.checkNotNullParameter(r5, "imageView");
        Intrinsics.checkNotNullParameter(r6, LocationHitPoint$ResultType.LIST);
        Intrinsics.checkNotNullParameter(r7, "it");
        Intrinsics.checkNotNullParameter(r2, "msgId");
        r5b.a r0 = r1.e;
        if (r0 == null) goto L9;
        h r3 = r0.j5();
        if (r3 == null) goto L9;
        mya.a r4 = (mya.a) r3.b(mya.a.class);
    L10:
        if (r4 != null) goto L14;
        b<LynxCardContentVO> r8 = r1.c;
        if (r8 == null) goto L17;
        r8.a(r5, r6, r7, r2);
        return;
    L17:
        return;
    L14:
        r4.a(r5, r6, r7, r2);
        return;
    L9:
        r4 = null;
        goto L10
    }

    public Object previewVideo(CardContext r9, List<? extends PhotoItem> r10, boolean r11, VideoOperateListener r12, OnImageSelectListener r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r14;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = r0.Z$0;
        r13 = (OnImageSelectListener) r0.L$3;
        r12 = (VideoOperateListener) r0.L$2;
        r10 = (List) r0.L$1;
        r9 = (CardContext) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        Chat r16 = (Chat) r15;
        Activity r17 = UIUtils.getActivityFromContext(r9.getContext());
        if (r17 != null) goto L22;
        Log.e(TAG, "previewVideo error, context is not activity");
        return Unit.INSTANCE;
    L22:
        if (r16 == null) goto L30;
        Chat.RestrictedModeSetting r4 = r16.getRestrictedModeSetting();
        if (r4 == null) goto L30;
        Chat.RestrictedWhiteListSetting r5 = r4.getWhiteListSetting();
        if (r5 == null) goto L30;
        if (r5.isHitWhiteList() != true) goto L30;
        boolean r6 = true;
    L31:
        if (r16 == null) goto L43;
        if (r6 == false) goto L35;
    L40:
        boolean r7 = true;
    L41:
        if (r7 == true) goto L43;
        boolean r8 = true;
    L44:
        boolean r18 = !r8;
        if (r16 == null) goto L57;
        if (r6 == false) goto L49;
    L54:
        boolean r19 = true;
    L55:
        if (r19 == true) goto L57;
        boolean r110 = true;
    L59:
        if ((!r110) == false) goto L62;
        if (r11 == false) goto L62;
        boolean r111 = true;
    L63:
        List<? extends PhotoItem> r112 = r10;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L65:
        if (r114.hasNext() == false) goto L67;
        PhotoItem r20 = (PhotoItem) r114.next();
        MessageIdentity r21 = new MessageIdentity(this.bizContext.getMsgId(), this.bizContext.getChatId());
        r21.setSenderId(this.bizContext.getSenderId());
        r21.setSenderTenantId(this.bizContext.getSenderTenantId());
        r113.add(r20.setMessageIdentity(r21));
        goto L65
    L67:
        int r115 = k.a;
        k.c r116 = k.a.a(r113, 0, null);
        r116.c(0);
        r116.f(r12);
        if (r13 == null) goto L70;
        r116.a.putParcelable("image_select_listener", r13);
    L70:
        r116.l(r111);
        r116.e(r18);
        r116.a.putBoolean("extra_auto_play", true);
        r116.q(Biz.Messenger, Scene.Chat, 7);
        r116.b(EnterSource.Message);
        r116.u(r17);
        return Unit.INSTANCE;
    L62:
        r111 = false;
        goto L63
    L49:
        if (r16.getRestrictedModeSetting().getSwitch() == false) goto L54;
        if (r16.getRestrictedModeSetting().getDownload() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L54;
        r19 = false;
    L57:
        r110 = false;
        goto L59
    L35:
        if (r16.getRestrictedModeSetting().getSwitch() == false) goto L40;
        if (r16.getRestrictedModeSetting().getScreenshot() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L40;
        r7 = false;
    L43:
        r8 = false;
    L30:
        r6 = false;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        CoroutineDispatcher r117 = Dispatchers.getIO();
        MessageCardDependencyImpl$previewVideo$chat$1 r22 = new MessageCardDependencyImpl$previewVideo$chat$1(this, null);
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r12;
        r0.L$3 = r13;
        r0.Z$0 = r11;
        r0.label = 1;
        r15 = BuildersKt.withContext(r117, r22, r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }

    public void updateCardLocalCache(String r3, final String r4, String r5, Boolean r6, String r7, final IGetDataCallback<CardUpdateLocalDataPlugin.CardUpdateLocalDataResponse> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        LynxCardActionClient r9 = (LynxCardActionClient) LynxCardActionClient.a.getValue();
        Boolean r0 = Boolean.FALSE;
        IGetDataCallback<MsgCardUpdateLocalDataResponse> r1 = new C04401(r8, this, r4);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        UpdateMessageCardLocalDataRequest.Builder r10 = new UpdateMessageCardLocalDataRequest.Builder().message_id(r3).version(r4).json_delta_data(r5).need_push(r0);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_MESSAGE_CARD_LOCAL_DATA, r10, r1, com.ss.android.lark.message.lynxcard.action.b.a);
    }
}
