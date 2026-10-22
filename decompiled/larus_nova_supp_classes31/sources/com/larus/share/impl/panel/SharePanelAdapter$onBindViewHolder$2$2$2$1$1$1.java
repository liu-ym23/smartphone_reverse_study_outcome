package com.larus.share.impl.panel;

import android.content.Context;
import android.widget.LinearLayout;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.panel.SharePanelAdapter$onBindViewHolder$2$2$2$1$1$1", f = "SharePanelAdapter.kt", i = {0, 0}, l = {280}, m = "invokeSuspend", n = {"localMediaPath", "localMdlCacheHit"}, s = {"L$0", "L$1"})
final class SharePanelAdapter$onBindViewHolder$2$2$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelType;
    final /* synthetic */ jr9.a $itemData;
    final /* synthetic */ boolean $saveImage;
    final /* synthetic */ boolean $saveVideo;
    final /* synthetic */ com.larus.bmhome.share.panel.b $shareContent;
    final /* synthetic */ String $shareType;
    final /* synthetic */ boolean $showLoading;
    final /* synthetic */ LinearLayout $this_apply;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SharePanelAdapter this$0;

    public SharePanelAdapter$onBindViewHolder$2$2$2$1$1$1(SharePanelAdapter r1, com.larus.bmhome.share.panel.b r2, boolean r3, boolean r4, String r5, LinearLayout r6, String r7, boolean r8, jr9.a r9, Continuation<? super SharePanelAdapter$onBindViewHolder$2$2$2$1$1$1> r10) {
        this.this$0 = r1;
        this.$shareContent = r2;
        this.$saveImage = r3;
        this.$saveVideo = r4;
        this.$shareType = r5;
        this.$this_apply = r6;
        this.$channelType = r7;
        this.$showLoading = r8;
        this.$itemData = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new SharePanelAdapter$onBindViewHolder$2$2$2$1$1$1(this.this$0, this.$shareContent, this.$saveImage, this.$saveVideo, this.$shareType, this.$this_apply, this.$channelType, this.$showLoading, this.$itemData, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        AtomicReference r4 = (AtomicReference) this.L$1;
        final AtomicReference r5 = (AtomicReference) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r6 = r19;
    L63:
        com.larus.bmhome.share.panel.b r7 = (com.larus.bmhome.share.panel.b) r6;
        final AtomicReference r16 = r4;
        final AtomicReference r15 = r5;
    L64:
        com.larus.bmhome.share.panel.b r8 = r7;
        ShareServiceDelegate r9 = ShareServiceDelegate.b;
        Context r10 = this.$this_apply.getContext();
        final String r11 = this.$channelType;
        final String r12 = this.$shareType;
        boolean r13 = this.$showLoading;
        final SharePanelAdapter r14 = this.this$0;
        final boolean r17 = this.$saveImage;
        final boolean r18 = this.$saveVideo;
        final jr9.a r110 = this.$itemData;
        final com.larus.bmhome.share.panel.b r111 = this.$shareContent;
        r9.b(r10, r11, r12, r8, r13, new e(r14, r17, r18, r110, r111, r11, r12, r15, r16));
        if (this.$showLoading == false) goto L72;
        g r20 = this.this$0.c;
        if (r20 == null) goto L72;
        r20.e(this.$itemData.b());
    L72:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        SharePanelAdapter r21 = this.this$0;
        com.larus.bmhome.share.panel.b r22 = this.$shareContent;
        boolean r23 = this.$saveImage;
        boolean r24 = this.$saveVideo;
        Set<String> r25 = SharePanelAdapter.n;
        r21.getClass();
        if (r23 == false) goto L11;
        String r26 = r22.a;
    L14:
        r5 = new AtomicReference(r26);
        final AtomicReference r27 = new AtomicReference(null);
        if (this.$saveImage == false) goto L17;
    L20:
        r7 = com.larus.bmhome.share.panel.b.a(this.$shareContent, null, null, null, null, null, null, false, 67108863);
        r7.A = new c(r5);
        r7.B = new d(r5, r27);
    L21:
        SharePanelAdapter r28 = this.this$0;
        String r29 = this.$shareType;
        r28.getClass();
        boolean r30 = false;
        if (Intrinsics.areEqual(r29, "image") == false) goto L35;
        if (r7.b != null) goto L38;
        String r31 = r7.a;
        if (r31 != null) goto L28;
    L31:
        boolean r32 = true;
    L32:
        if (r32 == false) goto L38;
    L39:
        boolean r33 = false;
    L40:
        if (r33 == false) goto L65;
        SharePanelAdapter r34 = this.this$0;
        this.L$0 = r5;
        this.L$1 = r27;
        this.label = 1;
        r34.getClass();
        DownloadWatermarkService r35 = DownloadWatermarkService.a;
        r35.getClass();
        if (DownloadWatermarkService.d() == true) goto L45;
        r35 = null;
    L45:
        if (r35 != null) goto L47;
        int r36 = WatermarkPerfLogger.a;
        WatermarkPerfLogger.a r37 = WatermarkPerfLogger.a("share_panel_save", WatermarkPerfLogger.Version.PERSONAL, null);
        r37.c(WatermarkPerfLogger.Path.NONE);
        r37.a("no_watermark");
        r37.b(WatermarkPerfLogger.Result.SUCCESS, null);
        r6 = r7;
    L60:
        if (r6 != r1) goto L62;
        return r1;
    L62:
        r4 = r27;
        goto L63
    L47:
        String r38 = r7.a;
        if (r38 != null) goto L51;
    L57:
        if (r30 == false) goto L59;
        r6 = r34.z2(r35, r7, this);
        goto L60
    L59:
        r6 = r34.y2(r35, r7, this);
        goto L60
    L51:
        if (StringsKt.startsWith(r38, "http://", true) == false) goto L53;
    L56:
        r30 = r3;
        goto L57
    L53:
        if (StringsKt.startsWith(r38, "https://", true) == true) goto L56;
        r3 = false;
        goto L56
    L65:
        r15 = r5;
        r16 = r27;
        goto L64
    L28:
        if (r31.length() == 0) goto L31;
        r32 = false;
    L38:
        r33 = true;
        goto L40
    L35:
        if (Intrinsics.areEqual(r29, "video") == false) goto L39;
        if (r7.e == null) goto L39;
    L17:
        if (this.$saveVideo == true) goto L20;
        r7 = this.$shareContent;
        goto L21
    L11:
        if (r24 == false) goto L13;
        r26 = r22.e;
        goto L14
    L13:
        r26 = null;
        goto L14
    }
}
