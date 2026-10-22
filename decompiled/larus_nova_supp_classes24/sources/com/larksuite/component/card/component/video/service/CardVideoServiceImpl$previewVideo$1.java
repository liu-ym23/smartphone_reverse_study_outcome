package com.larksuite.component.card.component.video.service;

import androidx.lifecycle.LifecycleOwner;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.photo.preview.utils.d;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl$previewVideo$1", f = "CardVideoServiceImpl.kt", i = {0, 1}, l = {89, 108}, m = "invokeSuspend", n = {"sessionID", "sessionID"}, s = {"L$0", "L$0"})
final class CardVideoServiceImpl$previewVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardContext $cardContext;
    final /* synthetic */ boolean $enableDownload;
    final /* synthetic */ RichTextElement.ImageProperty $imageProperty;
    final /* synthetic */ VideoInfo $videoInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CardVideoServiceImpl this$0;

    public CardVideoServiceImpl$previewVideo$1(VideoInfo r1, CardVideoServiceImpl r2, RichTextElement.ImageProperty r3, CardContext r4, boolean r5, Continuation<? super CardVideoServiceImpl$previewVideo$1> r6) {
        this.$videoInfo = r1;
        this.this$0 = r2;
        this.$imageProperty = r3;
        this.$cardContext = r4;
        this.$enableDownload = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        CardVideoServiceImpl$previewVideo$1 r7 = new CardVideoServiceImpl$previewVideo$1(this.$videoInfo, this.this$0, this.$imageProperty, this.$cardContext, this.$enableDownload, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L19;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L14;
        ?? r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L9 CancellationException -> L11
        r2 = r2;
    L42:
        WeakReference<CardVideoServiceImpl> r3 = CardVideoServiceImpl.c;     // Catch: Throwable -> L9 CancellationException -> L11
        LifecycleOwner r4 = this.$cardContext.getFragment();     // Catch: Throwable -> L9 CancellationException -> L11
        if (r4 != null) goto L49;
        LifecycleOwner r5 = UIUtils.getActivityFromContext(this.$cardContext.getContext());     // Catch: Throwable -> L9 CancellationException -> L11
        if ((r5 instanceof LifecycleOwner) == false) goto L48;
        r4 = r5;     // Catch: Throwable -> L9 CancellationException -> L11
        goto L49
    L48:
        r4 = null;
    L49:
        new WeakReference(r4);     // Catch: Throwable -> L9 CancellationException -> L11
        WeakReference<CardVideoServiceImpl> r6 = CardVideoServiceImpl.c;     // Catch: Throwable -> L9 CancellationException -> L11
        CardVideoServiceImpl.c = new WeakReference(this.this$0);     // Catch: Throwable -> L9 CancellationException -> L11
    L55:
        return Unit.INSTANCE;
    L9:
        th = th;
        ?? r10 = r2;
    L53:
        StringBuilder r7 = new StringBuilder();
        WeakReference<CardVideoServiceImpl> r8 = CardVideoServiceImpl.c;
        r7.append(CardVideoServiceImpl.a.a(r10));
        r7.append(" previewVideo error");
        Log.e("CardVideoService", r7.toString(), th);
        WeakReference<CardVideoServiceImpl> r9 = CardVideoServiceImpl.c;
        CardVideoServiceImpl.c = null;
        goto L55
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r11 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L60
        Object r12 = r14;
        r1 = r11;
    L18:
        r10 = r1;
        if (((CardVideoServiceImpl.FileState) r12) == CardVideoServiceImpl.FileState.NORMAL) goto L31;
        UDToast.show(LarkContext.getApplication(), 2131891528);
        return Unit.INSTANCE;
    L31:
        CardVideoServiceImpl r13 = this.this$0;
        RichTextElement.ImageProperty r15 = this.$imageProperty;
        VideoInfo r16 = this.$videoInfo;
        WeakReference<CardVideoServiceImpl> r17 = CardVideoServiceImpl.c;
        r13.getClass();
        CardDataUtils.a.getClass();
        Image r19 = CardDataUtils.e(r15);
        if (r19 != null) goto L34;
        r19 = new Image();
        r19.setKey(r16.getKey());
    L34:
        List<? extends PhotoItem> r20 = d.c(CardDataUtils.h(CollectionsKt.listOf(r19)), "");
        Intrinsics.checkNotNull(r20);
        PhotoItem r21 = (PhotoItem) CollectionsKt.getOrNull(r20, 0);
        if (r21 == null) goto L37;
        MediaExtra r22 = new MediaExtra();
        r22.setKey(r16.getKey());
        r22.setUrl(r16.getUrl());
        r22.setSize(r16.getSize());
        r22.setMime(r16.getMime());
        r22.setDuration(r16.getDuration());
        r21.setMediaExtra(r22);
        r21.setOriginPicInfo(new PhotoItem.PicInfo(r19.getKey(), r19.getUrls(), r19.getWidth(), r19.getHeight()));
    L37:
        Log.i("CardVideoService", CardVideoServiceImpl.a.a(r10) + " start preview video");
        ICardDependency r23 = this.$cardContext.getDependency();     // Catch: CancellationException -> L11 Throwable -> L52
        CardContext r24 = this.$cardContext;     // Catch: CancellationException -> L11 Throwable -> L52
        boolean r25 = this.$enableDownload;     // Catch: CancellationException -> L11 Throwable -> L52
        CardVideoServiceImpl.CardVideoOperateListener r26 = new CardVideoServiceImpl.CardVideoOperateListener(r10);     // Catch: CancellationException -> L11 Throwable -> L52
        CardVideoServiceImpl.CardPreviewFinishedListener r27 = new CardVideoServiceImpl.CardPreviewFinishedListener();     // Catch: CancellationException -> L11 Throwable -> L52
        this.L$0 = r10;     // Catch: CancellationException -> L11 Throwable -> L52
        this.label = 2;     // Catch: CancellationException -> L11 Throwable -> L52
        if (r23.previewVideo(r24, r20, r25, r26, r27, this) != r0) goto L41;
        return r0;
    L41:
        r2 = r10;
    L52:
        th = th;
    L58:
        th = th;
    L62:
        StringBuilder r29 = new StringBuilder();
        WeakReference<CardVideoServiceImpl> r30 = CardVideoServiceImpl.c;
        r29.append(CardVideoServiceImpl.a.a(r10));
        r29.append(" previewVideo checkFileStateSuspend error");
        Log.e("CardVideoService", r29.toString(), th);
        UDToast.show(LarkContext.getApplication(), 2131890450);
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r31 = (CoroutineScope) this.L$0;
        String r32 = this.$videoInfo.getKey();
        if (r32 != null) goto L23;
        Log.e("CardVideoService", "previewVideo sessionID is null");
        return Unit.INSTANCE;
    L23:
        CardVideoServiceImpl r33 = this.this$0;     // Catch: Throwable -> L60
        VideoInfo r34 = this.$videoInfo;     // Catch: Throwable -> L60
        this.L$0 = r32;     // Catch: Throwable -> L60
        this.label = 1;     // Catch: Throwable -> L60
        r12 = CardVideoServiceImpl.m(r33, r32, r34, this);     // Catch: Throwable -> L60
        r1 = r32;
        if (r12 != r0) goto L18;
        return r0;
    L60:
        th = th;
        r10 = r1;
    L11:
        e = move-exception;
        Log.i("CardVideoService", "previewVideo cancelled");
        WeakReference<CardVideoServiceImpl> r35 = CardVideoServiceImpl.c;
        CardVideoServiceImpl.c = null;
        throw e;
    }
}
