package com.larksuite.component.card.component.video.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.DownloadResourceByUrlRequest;
import com.bytedance.lark.pb.media.v1.DownloadResourceByUrlResponse;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.utils.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl$downloadVideo$1", f = "CardVideoServiceImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {460, 385}, m = "invokeSuspend", n = {"$this$launch", "updateProgressJob", "showErrorToast", "$this$launch", "showErrorToast", "responsePath"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class CardVideoServiceImpl$downloadVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Integer> $downloadFlow;
    final /* synthetic */ PhotoItem $photoItem;
    final /* synthetic */ String $sessionID;
    final /* synthetic */ com.ss.android.lark.widget.photo.preview.video.online.c $videoGalleryView;
    final /* synthetic */ String $videoKey;
    final /* synthetic */ String $videoPath;
    final /* synthetic */ String $videoUrl;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    public static final class a<T> implements SdkSender.IParser {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r3) {
            return (DownloadResourceByUrlResponse) DownloadResourceByUrlResponse.ADAPTER.decode(r3);
        L4:
            th = move-exception;
            StringBuilder r0 = new StringBuilder();
            WeakReference<CardVideoServiceImpl> r1 = CardVideoServiceImpl.c;
            r0.append(CardVideoServiceImpl.a.a(this.a));
            r0.append(" DOWNLOAD_RESOURCE_BY_URL decode error");
            Log.e("CardVideoService", r0.toString(), th);
            return null;
        }
    }

    public CardVideoServiceImpl$downloadVideo$1(String r1, com.ss.android.lark.widget.photo.preview.video.online.c r2, PhotoItem r3, Flow<Integer> r4, String r5, String r6, String r7, Continuation<? super CardVideoServiceImpl$downloadVideo$1> r8) {
        this.$sessionID = r1;
        this.$videoGalleryView = r2;
        this.$photoItem = r3;
        this.$downloadFlow = r4;
        this.$videoKey = r5;
        this.$videoUrl = r6;
        this.$videoPath = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        CardVideoServiceImpl$downloadVideo$1 r9 = new CardVideoServiceImpl$downloadVideo$1(this.$sessionID, this.$videoGalleryView, this.$photoItem, this.$downloadFlow, this.$videoKey, this.$videoUrl, this.$videoPath, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.jvm.functions.Function1] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$2;
        Function1 r3 = (Function1) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
        ?? r5 = r3;
    L31:
        String r16 = (String) r15;
        if (r16 != null) goto L38;
        String r17 = this.$sessionID;
        com.ss.android.lark.widget.photo.preview.video.online.c r6 = this.$videoGalleryView;
        StringBuilder r7 = new StringBuilder();
        WeakReference<CardVideoServiceImpl> r8 = CardVideoServiceImpl.c;
        r7.append(CardVideoServiceImpl.a.a(r17));
        r7.append(" download success, decryptPath is null");
        Log.e("CardVideoService", r7.toString());
        r5.invoke(new RuntimeException("invoke DOWNLOAD_RESOURCE_BY_URL success, but decryptPath is null"));
        if (r6 == null) goto L37;
        r6.c3();
    L37:
        return Unit.INSTANCE;
    L38:
        StringBuilder r9 = new StringBuilder();
        WeakReference<CardVideoServiceImpl> r10 = CardVideoServiceImpl.c;
        r9.append(CardVideoServiceImpl.a.a(this.$sessionID));
        r9.append(" download success, start copy, path: ");
        r9.append(r2);
        r9.append(", decryptPath: ");
        r9.append(r16);
        Log.i("CardVideoService", r9.toString());
        MediaExtra r11 = this.$photoItem.getMediaExtra();
        if (r11 == null) goto L41;
        g.b(r11, LarkContext.getApplication(), r16);
    L41:
        com.ss.android.lark.widget.photo.preview.video.online.c r12 = this.$videoGalleryView;
        if (r12 == null) goto L45;
        r12.P3(r16);
    L45:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r13 = (String) this.L$6;
        String r14 = (String) this.L$5;
        String r19 = (String) this.L$4;
        String r20 = (String) this.L$3;
        Function1 r21 = (Function1) this.L$2;
        Job r22 = (Job) this.L$1;
        CoroutineScope r23 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L46 CancellationException -> L53
        r1 = r21;
    L19:
        DownloadResourceByUrlResponse r110 = (DownloadResourceByUrlResponse) r15;     // Catch: Throwable -> L46 CancellationException -> L53
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
        if (r110.status == DownloadResourceByUrlResponse.Status.SUCCESS) goto L27;
        StringBuilder r111 = new StringBuilder();
        WeakReference<CardVideoServiceImpl> r24 = CardVideoServiceImpl.c;
        r111.append(CardVideoServiceImpl.a.a(this.$sessionID));
        r111.append(" download error status not success");
        Log.e("CardVideoService", r111.toString());
        r1.invoke(new RuntimeException("invoke DOWNLOAD_RESOURCE_BY_URL success, but status is not success"));
        com.ss.android.lark.widget.photo.preview.video.online.c r112 = this.$videoGalleryView;
        if (r112 == null) goto L26;
        r112.c3();
    L26:
        return Unit.INSTANCE;
    L27:
        String r113 = r110.path;
        CoroutineDispatcher r25 = Dispatchers.getIO();
        CardVideoServiceImpl$downloadVideo$1$path$1 r26 = new CardVideoServiceImpl$downloadVideo$1$path$1(r113, null);
        this.L$0 = r23;
        this.L$1 = r1;
        this.L$2 = r113;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 2;
        Object r27 = BuildersKt.withContext(r25, r26, this);
        if (r27 != r0) goto L30;
        return r0;
    L30:
        r2 = r113;
        r15 = r27;
        r5 = r1;
        goto L31
    L12:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        r22 = BuildersKt.launch$default(r114, null, null, new CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1(this.$downloadFlow, this.$sessionID, this.$videoGalleryView, null), 3, null);
        CardVideoServiceImpl$downloadVideo$1$showErrorToast$1 r29 = CardVideoServiceImpl$downloadVideo$1$showErrorToast$1.INSTANCE;
        String r30 = this.$videoKey;     // Catch: Throwable -> L46 CancellationException -> L53
        String r31 = this.$videoUrl;     // Catch: Throwable -> L46 CancellationException -> L53
        String r32 = this.$videoPath;     // Catch: Throwable -> L46 CancellationException -> L53
        final String r115 = this.$sessionID;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$0 = r114;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$1 = r22;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$2 = r29;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$3 = r30;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$4 = r31;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$5 = r32;     // Catch: Throwable -> L46 CancellationException -> L53
        this.L$6 = r115;     // Catch: Throwable -> L46 CancellationException -> L53
        this.label = 1;     // Catch: Throwable -> L46 CancellationException -> L53
        final j r116 = new j(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L46 CancellationException -> L53
        r116.C();     // Catch: Throwable -> L46 CancellationException -> L53
        DownloadResourceByUrlRequest.Builder r33 = new DownloadResourceByUrlRequest.Builder().key(r30).url(r31).path(r32).need_progress(Boxing.boxBoolean(true));     // Catch: Throwable -> L46 CancellationException -> L53
        SdkSender.asynSendRequestNonWrap(Command.DOWNLOAD_RESOURCE_BY_URL, r33, new CardVideoServiceImpl$downloadVideo$1$downloadResponse$1$1(r115, r116), new a(r115));     // Catch: Throwable -> L46 CancellationException -> L53
        Object r34 = r116.B();     // Catch: Throwable -> L46 CancellationException -> L53
        if (r34 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L46 CancellationException -> L53
    L16:
        if (r34 != r0) goto L18;
        return r0;
    L18:
        r23 = r114;
        r15 = r34;
        r1 = r29;
    L56:
        th = move-exception;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
        throw th;
    L53:
        e = move-exception;
        StringBuilder r35 = new StringBuilder();     // Catch: Throwable -> L56
        WeakReference<CardVideoServiceImpl> r36 = CardVideoServiceImpl.c;     // Catch: Throwable -> L56
        r35.append(CardVideoServiceImpl.a.a(this.$sessionID));     // Catch: Throwable -> L56
        r35.append(" download sdk invoke cancelled");     // Catch: Throwable -> L56
        Log.d("CardVideoService", r35.toString());     // Catch: Throwable -> L56
        throw e;     // Catch: Throwable -> L56
    L46:
        th = move-exception;
        StringBuilder r37 = new StringBuilder();     // Catch: Throwable -> L56
        WeakReference<CardVideoServiceImpl> r38 = CardVideoServiceImpl.c;     // Catch: Throwable -> L56
        r37.append(CardVideoServiceImpl.a.a(this.$sessionID));     // Catch: Throwable -> L56
        r37.append(" download error");     // Catch: Throwable -> L56
        Log.e("CardVideoService", r37.toString(), th);     // Catch: Throwable -> L56
        r1.invoke(th);     // Catch: Throwable -> L56
        com.ss.android.lark.widget.photo.preview.video.online.c r117 = this.$videoGalleryView;     // Catch: Throwable -> L56
        if (r117 == null) goto L50;
        r117.c3();     // Catch: Throwable -> L56
    L50:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L56
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
        return r118;
    }
}
