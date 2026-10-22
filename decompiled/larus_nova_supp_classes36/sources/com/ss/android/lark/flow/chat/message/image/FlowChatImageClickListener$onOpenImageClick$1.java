package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kza.l;
import kza.m;
import kza.o;
import kza.p;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowChatImageClickListener$onOpenImageClick$1", f = "FlowChatImageClickListener.kt", i = {0}, l = {136}, m = "invokeSuspend", n = {"previewItem"}, s = {"L$0"})
public final class FlowChatImageClickListener$onOpenImageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clickMessageId;
    final /* synthetic */ int $groupIndex;
    final /* synthetic */ List<Object> $openFeishuGalleryPreviewItemList;
    Object L$0;
    int label;
    final /* synthetic */ FlowChatImageClickListener this$0;

    public FlowChatImageClickListener$onOpenImageClick$1(List<? extends Object> r1, int r2, String r3, FlowChatImageClickListener r4, Continuation<? super FlowChatImageClickListener$onOpenImageClick$1> r5) {
        this.$openFeishuGalleryPreviewItemList = r1;
        this.$groupIndex = r2;
        this.$clickMessageId = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowChatImageClickListener$onOpenImageClick$1(this.$openFeishuGalleryPreviewItemList, this.$groupIndex, this.$clickMessageId, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        ValidateResult r3 = null;
        boolean r4 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Object r2 = this.L$0;
        ResultKt.throwOnFailure(r10);
    L14:
        List<? extends PhotoItem> r11 = (List) r10;
        int r5 = FlowMediaPreviewUtils.a;
        m r6 = (m) r2;
        int r7 = FlowMediaPreviewUtils.a(r11, new FlowPhotoItem(FlowMediaMessageType.Doubao, r6));
        if (r7 > (-1)) goto L23;
        Log.i("FlowChatImageClickListener", "onOpenImageClick, currentPosition is -1, rebuild source preview items");
        r11.clear();
        Iterator<T> r8 = this.$openFeishuGalleryPreviewItemList.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
        if ((r9 instanceof m) == false) goto L18;
        r11.add(new FlowPhotoItem(FlowMediaMessageType.Doubao, (m) r9));
        goto L18
    L22:
        r7 = this.$groupIndex;
    L23:
        Object r12 = CollectionsKt.getOrNull(r11, r7);
        if ((r12 instanceof FlowPhotoItem) == false) goto L26;
        FlowPhotoItem r13 = (FlowPhotoItem) r12;
    L27:
        if (r13 == null) goto L32;
        m r14 = r13.getPreviewItem();
        if (r14 == null) goto L32;
        r6 = r14;
    L32:
        int r15 = i.a;
        Context r16 = this.this$0.getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r6, "previewItem");
        if (r6.e == GalleryItemType.Doubao) goto L89;
        o r17 = r6.g;
        if (r17 == null) goto L70;
        l r18 = r6.b;
        if (r18 == null) goto L41;
        Object r19 = r18.e;
    L43:
        if ((r19 instanceof PhotoItem) == false) goto L45;
        PhotoItem r20 = (PhotoItem) r19;
    L46:
        if (r20 != null) goto L57;
        p r21 = r6.c;
        if (r21 == null) goto L50;
        Object r22 = r21.k;
    L52:
        if ((r22 instanceof PhotoItem) == false) goto L54;
        r20 = (PhotoItem) r22;
    L55:
        if (r20 != null) goto L57;
    L60:
        int r23 = r17.a;
        u r24 = MessagePermissionUtil.a;
        MessagePermissionUtil.ReceiveAuthorizationState.Companion.getClass();
        MessagePermissionUtil.ReceiveAuthorizationState r25 = MessagePermissionUtil.ReceiveAuthorizationState.a.a(r23);
        if (MessagePermissionUtil.g(r25) == true) goto L63;
        owa.a.c().a(r3, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        goto L70
    L63:
        if (r25 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L66;
        MessagePermissionUtil.m(r16);
    L68:
        owa.a.c().a(r3, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        boolean r26 = false;
    L71:
        if (r26 == false) goto L87;
        ValidateResult r27 = MessagePermissionUtil.b();
        o r28 = r6.g;
        if (r28 == null) goto L76;
        boolean r29 = r28.b;
    L77:
        if (r29 == true) goto L88;
        int r30 = i.a.a[r6.getType().ordinal()];
        if (r30 != 1) goto L81;
        int r31 = 2131891410;
    L86:
        MessagePermissionUtil.n(r16, r31, r27);
        owa.a.c().a(r27, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        goto L87
    L81:
        if (r30 != 2) goto L84;
        r31 = 2131891413;
        goto L86
    L84:
        throw new NoWhenBranchMatchedException();
    L88:
        owa.a.c().a(r27, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        goto L89
    L76:
        r29 = MessagePermissionUtil.e(r27);
    L87:
        r4 = false;
        goto L89
    L66:
        if (r25 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L68;
        owa.a.c().d(r3, MessagePermissionUtil.a());
        goto L68
    L54:
        r20 = null;
        goto L55
    L50:
        r22 = null;
    L57:
        ValidateIMFileResult r32 = r20.getValidateIMFileResult();
        if (r32 == null) goto L60;
        r3 = r32.getValidateResult();
        goto L60
    L45:
        r20 = null;
        goto L46
    L41:
        r19 = null;
    L70:
        r26 = true;
    L89:
        if (r4 == false) goto L91;
        this.this$0.a(r11, r7);
    L94:
        return Unit.INSTANCE;
    L91:
        return Unit.INSTANCE;
    L26:
        r13 = null;
        goto L27
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Object r110 = ListProtector.get(this.$openFeishuGalleryPreviewItemList, this.$groupIndex);
        if ((r110 instanceof m) == false) goto L94;
        Log.i("FlowChatImageClickListener", "onOpenImageClick, clickMessageId: " + this.$clickMessageId + ", previewItem: " + ((m) r110).d + ", groupIndex: " + this.$groupIndex);
        CoroutineDispatcher r33 = Dispatchers.getIO();
        FlowChatImageClickListener$onOpenImageClick$1$photoItems$1 r34 = new FlowChatImageClickListener$onOpenImageClick$1$photoItems$1(this.this$0, this.$clickMessageId, this.$openFeishuGalleryPreviewItemList, null);
        this.L$0 = r110;
        this.label = 1;
        Object r35 = BuildersKt.withContext(r33, r34, this);
        if (r35 != r0) goto L13;
        return r0;
    L13:
        r2 = r110;
        r10 = r35;
        goto L14
    }
}
