package com.larus.avlink.gallery.processor;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.larus.mirabridge.api.pluginservice.ImagePostProcessParams;
import com.larus.mirabridge.api.pluginservice.ImagePostProcessResult;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlin.text.CharsKt;
import kotlinx.coroutines.CoroutineScope;
import v98.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/gallery/processor/ProcessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.processor.ImagePackProcessor$processSync$2", f = "ImagePackProcessor.kt", i = {0, 0, 0, 0, 0}, l = {DoraCallStateCode.DORA_OB_USER_END}, m = "invokeSuspend", n = {"mediaId", "prefix", "finalFileName", "finalOutputPath", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
public final class ImagePackProcessor$processSync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ MediaMetadata $metadata;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ImagePackProcessor this$0;

    public ImagePackProcessor$processSync$2(MediaMetadata r1, String r2, ImagePackProcessor r3, Continuation<? super ImagePackProcessor$processSync$2> r4) {
        this.$metadata = r1;
        this.$filePath = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImagePackProcessor$processSync$2(this.$metadata, this.$filePath, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super k> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r33) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = this.label;
        if (r9 == 0) goto L12;
        if (r9 != 1) goto L11;
        long r7 = this.J$0;
        String r10 = (String) this.L$3;
        String r13 = (String) this.L$2;
        String r14 = (String) this.L$1;
        String r15 = (String) this.L$0;
        ResultKt.throwOnFailure(r33);     // Catch: Exception -> L8
        String r26 = r14;
        Object r3 = r33;
    L96:
        IDoraPluginService r4 = (IDoraPluginService) r3;     // Catch: Exception -> L88
        if (r4 != null) goto L34;
        int r0 = ImagePackProcessor.a;     // Catch: Exception -> L8
        String r1 = this.$filePath;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L8
        return ImagePackProcessor.a.a(r1, r10, r13, r15, r7, "Plugin service unavailable");
    L34:
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L88
        if (r2 == null) goto L37;
        com.larus.dora.impl.serviceimpl.h r5 = r2.debug();     // Catch: Exception -> L8
    L38:
        if (r5 == null) goto L41;
        Integer r6 = Boxing.boxInt(r5.a());     // Catch: Exception -> L8
    L42:
        e10 r16 = e10.a;     // Catch: Exception -> L88
        boolean r17 = e10.g0().b();     // Catch: Exception -> L88
        if (r6 != null) goto L45;
    L57:
        int r11 = 2;
    L58:
        int r12 = r4.getImageUserMask(r11);     // Catch: Exception -> L88
        FLogger r18 = FLogger.a;     // Catch: Exception -> L88
        String r34 = r13;
        StringBuilder r19 = new StringBuilder("Using user mask: 0x");     // Catch: Exception -> L86
        r19.append(Integer.toString(r12, CharsKt.checkRadix(16)));     // Catch: Exception -> L86
        r19.append(" for media: ");     // Catch: Exception -> L86
        r19.append(r15);     // Catch: Exception -> L86
        r19.append(", faceSr: ");     // Catch: Exception -> L86
        if (r17 == false) goto L63;
        boolean r20 = true;
    L64:
        r19.append(r20);     // Catch: Exception -> L86
        r19.append(", targetMask: ");     // Catch: Exception -> L86
        r19.append(r11);     // Catch: Exception -> L86
        r18.i("ImagePackProcessor", r19.toString());     // Catch: Exception -> L86
        StringBuilder r21 = new StringBuilder();     // Catch: Exception -> L86
        AppHost.Companion r110 = AppHost.a;     // Catch: Exception -> L86
        r21.append(r110.getApplication().getFilesDir().getAbsolutePath());     // Catch: Exception -> L86
        r21.append("/morpho_temp/");     // Catch: Exception -> L86
        String r22 = r21.toString();     // Catch: Exception -> L86
        new PolarisFileWrapper(r22).mkdirs();     // Catch: Exception -> L86
        Application r111 = r110.getApplication();     // Catch: Exception -> L86
        String r112 = this.$filePath;     // Catch: Exception -> L86
        if (r6 != null) goto L68;
    L69:
        boolean r25 = true;
    L71:
        ImagePostProcessResult r23 = r4.processImagePack(r111, new ImagePostProcessParams(r112, r22, r12, 1, r25, r26));     // Catch: Exception -> L86
        if (r23.getSuccess() == false) goto L84;
        byte[] r24 = r23.getOutputImage();     // Catch: Exception -> L86
        if (r24 == null) goto L76;
        r18.i("ImagePackProcessor", "Image post process successful for media: " + r15 + ", masks: " + r23.getRealMask());     // Catch: Exception -> L86
        String r27 = ImagePackProcessor.b(this.this$0, r24, r23.getOutputSize(), r15, this.$metadata, r22);     // Catch: Exception -> L86
        if (r27 == null) goto L83;
        PolarisFileWrapper r28 = new PolarisFileWrapper(this.$filePath);     // Catch: Exception -> L86
        if (r28.exists() == false) goto L102;
        long r113 = r28.length();     // Catch: Exception -> L86
        String r29 = r28.getName();     // Catch: Exception -> L86
        r.a r30 = r.a;     // Catch: Exception -> L86
        String r114 = this.$filePath;     // Catch: Exception -> L86
        Intrinsics.checkNotNull(r29);     // Catch: Exception -> L86
        r30.a(r114, r29, r113);     // Catch: Exception -> L86
        r18.i("ImagePackProcessor", "Added original pack file to StoragePolicyManager for media: " + r15 + ", path: " + this.$filePath + ", size: " + r113 + " bytes");     // Catch: Exception -> L86
    L102:
        return l.a(new k(true, r27, null, System.currentTimeMillis() - r7, null, false, 52), r23.getCode(), r4.getImageRealMask(r23.getRealMask()), r23.getSdkVersion(), r23.getRealMask(), 16);
    L83:
        r18.w("ImagePackProcessor", "Failed to save processed image, trying fallback for media: " + r15);     // Catch: Exception -> L86
        String r31 = this.$filePath;     // Catch: Exception -> L86
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L86
        return l.a(ImagePackProcessor.a.a(r31, r10, r34, r15, r7, "Failed to save processed image"), r23.getCode(), r4.getImageRealMask(r23.getRealMask()), r23.getSdkVersion(), r23.getRealMask(), 16);
    L76:
        return new k(false, null, "Processing returned empty output", System.currentTimeMillis() - r7, null, false, 50);
    L84:
        r18.e("ImagePackProcessor", "MorphoPostProcessor.process() failed for " + r15 + ": 0x" + r23.getCode());     // Catch: Exception -> L86
        int r32 = ImagePackProcessor.a;     // Catch: Exception -> L86
        String r35 = this.$filePath;     // Catch: Exception -> L86
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L86
        return l.a(ImagePackProcessor.a.a(r35, r10, r34, r15, r7, "Processing failed: 0x" + r23.getCode()), r23.getCode(), "", r23.getSdkVersion(), r23.getRealMask(), 16);
    L68:
        if (r6.intValue() != 0) goto L69;
        r25 = false;
        goto L71
    L63:
        r20 = false;
    L86:
        e = e;
    L90:
        String r36 = r34;
        long r115 = r7;
        String r116 = r10;
        String r37 = r15;
    L91:
        String r38 = r36;
        String r39 = r37;
        String r40 = r116;
        long r41 = r115;
        FLogger.a.e("ImagePackProcessor", "Image pack processing exception for " + r39 + ": " + e.getMessage(), e);
        int r42 = ImagePackProcessor.a;
        String r43 = this.$filePath;
        Intrinsics.checkNotNull(r40);
        return ImagePackProcessor.a.a(r43, r40, r38, r39, r41, "Exception during processing: " + e.getMessage());
    L45:
        if (r6.intValue() != 3) goto L49;
        if (r17 == true) goto L49;
        boolean r117 = false;
    L50:
        if (r117 == false) goto L52;
        Integer r118 = r6;
    L53:
        if (r118 == null) goto L57;
        r11 = r118.intValue();     // Catch: Exception -> L8
        goto L58
    L52:
        r118 = null;
    L49:
        r117 = true;
        goto L50
    L41:
        r6 = null;
        goto L42
    L37:
        r5 = null;
    L88:
        e = e;
        r34 = r13;
    L8:
        e = e;
        r116 = r10;
        r36 = r13;
        r37 = r15;
        r115 = r7;
        goto L91
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r33);
        r115 = System.currentTimeMillis();
        r37 = this.$metadata.getUniqId();
        String r119 = this.$metadata.getAlgorithmType();
        if (r119 != null) goto L15;
        r119 = "media";
    L15:
        r36 = r119 + '_' + r37 + "_0_" + this.$metadata.getDuration() + '_' + this.$metadata.getHeight() + '_' + this.$metadata.getWidth() + '_' + this.$metadata.getCreateTime() + ".jpeg";
        r116 = new PolarisFileWrapper(com.larus.avlink.gallery.k.a(), r36).getAbsolutePath();
        IDoraService r44 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r44 == null) goto L22;
        com.larus.dora.impl.serviceimpl.h r45 = r44.debug();
        if (r45 == null) goto L22;
        if (r45.h() != true) goto L22;
        boolean r120 = true;
    L23:
        if (r120 == false) goto L100;
        FLogger.a.w("ImagePackProcessor", "Media processor fallback is enabled, skipping ISP processing for media: " + r37);
        int r46 = ImagePackProcessor.a;
        String r47 = this.$filePath;
        Intrinsics.checkNotNull(r116);
        return ImagePackProcessor.a.a(r47, r116, r36, r37, r115, "Fallback mode enabled via DoraKvUtils");
    L100:
        FLogger.a.i("ImagePackProcessor", "Starting image refiner processing for media: " + r37);     // Catch: Exception -> L92
        this.L$0 = r37;     // Catch: Exception -> L92
        this.L$1 = r119;     // Catch: Exception -> L92
        this.L$2 = r36;     // Catch: Exception -> L92
        this.L$3 = r116;     // Catch: Exception -> L92
        this.J$0 = r115;     // Catch: Exception -> L92
        this.label = 1;     // Catch: Exception -> L92
        r3 = com.larus.avlink.gallery.plugin.f.a(this);     // Catch: Exception -> L92
        if (r3 != r8) goto L29;
        return r8;
    L29:
        r7 = r115;
        r26 = r119;
        r13 = r36;
        r15 = r37;
        r10 = r116;
    L92:
        e = e;
    L22:
        r120 = false;
        goto L23
    }
}
