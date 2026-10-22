package com.ss.android.lark.flow.chat.message.image;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.flow.photoeditor.FlowPhotoEditorActivity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kza.m;
import kza.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowChatImageClickListener$openGalleryPreview$1", f = "FlowChatImageClickListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatImageClickListener$openGalleryPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ Chat $currentChat;
    final /* synthetic */ int $currentPosition;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ List<PhotoItem> $photoItems;
    int label;
    final /* synthetic */ FlowChatImageClickListener this$0;

    public static final class a implements kza.c {
        public final /* synthetic */ FlowChatImageClickListener a;
        public final /* synthetic */ String b;

        public final void a(SocialGalleryRecallProvider.observer.1 r3) {
            Intrinsics.checkNotNullParameter(r3, "observer");
            ((pgb.a) this.a.g.getValue()).a(this.b, r3);
        }

        public final void d(SocialGalleryRecallProvider.observer.1 r3) {
            Intrinsics.checkNotNullParameter(r3, "observer");
            ((pgb.a) this.a.g.getValue()).b(this.b, r3);
        }

        public a(FlowChatImageClickListener r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(FragmentActivity r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r8, "activity");
            Intrinsics.checkNotNullParameter(r9, "localPath");
            Intrinsics.checkNotNullParameter(r10, "messageId");
            if (r9.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            String r3 = com.ss.android.photoeditor.util.b.b(r8);
            int r1 = FlowPhotoEditorActivity.b;
            Intrinsics.checkNotNull(r3);
            m2b.a r2 = this.a.e;
            if (r2 == null) goto L11;
            String r4 = r2.getChatId();
        L12:
            FlowPhotoEditorActivity.a.a(r8, r9, r3, "", r4, r10);
            return;
        L11:
            r4 = null;
            goto L12
        L5:
            r0 = false;
            goto L6
        }

        public final void c(GallerySource r2, FragmentActivity r3, boolean r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "activity");
            b.a(r3, r4, r5);
        }
    }

    public FlowChatImageClickListener$openGalleryPreview$1(List<? extends PhotoItem> r1, FlowChatImageClickListener r2, int r3, String r4, Fragment r5, Chat r6, Continuation<? super FlowChatImageClickListener$openGalleryPreview$1> r7) {
        this.$photoItems = r1;
        this.this$0 = r2;
        this.$currentPosition = r3;
        this.$chatId = r4;
        this.$fragment = r5;
        this.$currentChat = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new FlowChatImageClickListener$openGalleryPreview$1(this.$photoItems, this.this$0, this.$currentPosition, this.$chatId, this.$fragment, this.$currentChat, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r10);
        ArrayList r11 = new ArrayList();
        List<PhotoItem> r0 = this.$photoItems;
        FlowChatImageClickListener r1 = this.this$0;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        PhotoItem r3 = (PhotoItem) r2.next();
        if ((r3 instanceof FlowPhotoItem) == true) goto L9;
        f r4 = f.a;
        Boxing.boxBoolean(r11.add(f.e(r1.getContext(), r3)));
        goto L6
    L9:
        FlowPhotoItem r5 = (FlowPhotoItem) r3;
        if (r5.getMediaMessageType() == FlowMediaMessageType.Doubao) goto L13;
        if (r5.getMediaMessageType() != FlowMediaMessageType.Lark) goto L6;
    L13:
        m r6 = r5.getPreviewItem();
        if (r6 == null) goto L6;
        r11.add(r6);
        goto L6
    L17:
        m2b.a r7 = this.this$0.e;
        boolean r8 = false;
        if (r7 != null) goto L20;
    L22:
        boolean r9 = false;
    L24:
        if (r9 == true) goto L33;
        m2b.a r12 = this.this$0.e;
        if (r12 != null) goto L28;
    L30:
        if (r8 == true) goto L33;
        final FlowChatImageClickListener r13 = this.this$0;
        final Chat r14 = this.$currentChat;
        final String r15 = this.$chatId;
        kza.f r16 = new FlowChatImageClickListener$openGalleryPreview$1$loadMoreDelegate$1(r13, r14, r15);
    L34:
        kza.f r17 = r16;
        m2b.a r18 = this.this$0.e;
        if (r18 == null) goto L38;
        GallerySource r19 = b.b(r18);
        if (r19 == null) goto L38;
    L39:
        n r20 = new n(r19, r11, this.$currentPosition, r17, true, new a(this.this$0, this.$chatId));
        Log.i("FlowChatImageClickListener", "openGalleryPreview, photoList size: " + r11.size() + ", currentPosition: " + this.$currentPosition);
        int r110 = i.a;
        i.a(this.$chatId, this.$photoItems, this.$currentPosition);
        ((kza.d) this.this$0.f.getValue()).C1(r20, this.$fragment);
        return Unit.INSTANCE;
    L38:
        r19 = GallerySource.DEFAULT;
        goto L39
    L28:
        if (r12.Y() != true) goto L30;
        r8 = true;
    L33:
        Log.i("FlowChatImageClickListener", "loadMoreDelegate == null, in mergeForward or replyInThread");
        r16 = null;
        goto L34
    L20:
        if (r7.e0() != true) goto L22;
        r9 = true;
        goto L24
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
