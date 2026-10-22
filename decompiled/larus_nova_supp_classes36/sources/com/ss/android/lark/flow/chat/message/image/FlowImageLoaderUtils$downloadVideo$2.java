package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.utils.AuditParamsUtil;
import com.ss.android.lark.auditsdk.v2.utils.DownloadAuthorizationEventType;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$downloadVideo$2", f = "FlowImageLoaderUtils.kt", i = {0, 0}, l = {551}, m = "invokeSuspend", n = {TabAppInfo.IMAGE_JSON_KEY, "file"}, s = {"L$0", "L$1"})
final class FlowImageLoaderUtils$downloadVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PhotoItem $photoItem;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowImageLoaderUtils$downloadVideo$2(PhotoItem r1, Context r2, Continuation<? super FlowImageLoaderUtils$downloadVideo$2> r3) {
        this.$photoItem = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowImageLoaderUtils$downloadVideo$2(this.$photoItem, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$downloadVideo$2$downloadPath$1$1] */
    public final Object invokeSuspend(Object r25) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        PhotoItem r1 = (PhotoItem) this.L$3;
        Context r3 = (Context) this.L$2;
        VFSFile r4 = (VFSFile) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        Object r6 = r25;
    L46:
        String r7 = (String) r6;
        if (r7 == null) goto L72;
        File r8 = VFSFiles.b.i(r7);
        f r9 = f.a;
        if (CipherManager.d() != 1) goto L51;
        boolean r10 = true;
    L52:
        if (r10 == true) goto L54;
    L65:
        if (r8 != null) goto L67;
        return null;
    L67:
        if (r8.exists() == true) goto L69;
        return null;
    L69:
        return r8.getAbsolutePath();
    L54:
        if (r8.exists() == true) goto L74;
    L64:
        r8 = null;
        goto L65
    L74:
    L62:
        e = move-exception;
        Log.i("FlowImageLoaderUtils", "DecryptException / " + e.getErrorCode() + ", " + e.getMessage());
        goto L64
    L56:
        if (CipherManager.d() != 1) goto L58;
        boolean r11 = true;
    L59:
        if (r11 == false) goto L65;
        r8 = CipherManager.e(r8, true);     // Catch: DecryptException -> L62
        goto L65
    L58:
        r11 = false;
        goto L59
    L51:
        r10 = false;
        goto L52
    L72:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r25);
        MediaExtra r12 = this.$photoItem.getMediaExtra();
        if (r12 != null) goto L11;
        return null;
    L11:
        String r15 = r12.getKey();
        if (r15 != null) goto L14;
        return null;
    L14:
        VFSPath r13 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.e, new com.ss.android.lark.storage.d(new String[]{"im", "flow_download_media_cache"}));
        if (com.suite.lark.component.storage.ext.b.b(r13) == true) goto L20;
        Log.i("FlowImageLoaderUtils", "downloadVideo, create cache path: " + r13.getAbsolutePath());
        if (com.suite.lark.component.storage.ext.b.d(r13) == true) goto L20;
        Log.e("FlowImageLoaderUtils", "downloadVideo, mkdirs error");
        return null;
    L20:
        VFSFile r14 = VFSFiles.b.v(r13.getAbsolutePath(), System.currentTimeMillis() + '_' + com.ss.android.lark.widget.photopicker.utils.g.c(r12));
        Context r16 = this.$context;
        PhotoItem r17 = this.$photoItem;
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r16;
        this.L$3 = r17;
        this.label = 1;
        final kotlinx.coroutines.j r18 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r18.C();
        f r19 = f.a;
        MessageIdentity r20 = r17.getMessageIdentity();
        String r110 = r14.getAbsolutePath();
        ?? r111 = new FlowImageLoaderUtils$downloadVideo$2$downloadPath$1$1(r18);
        if (r20 == null) goto L23;
        String r21 = r20.getMessageId();
    L24:
        if (r20 == null) goto L26;
        String r112 = r20.getSourceId();
    L27:
        if (r20 == null) goto L29;
        String r22 = r20.getChatId();
    L30:
        if (r20 == null) goto L32;
        Message.SourceType r23 = r20.getSourceType();
    L33:
        com.ss.android.lark.download.service.impl.j r24 = vbb.a.a();
        if (r23 == null) goto L36;
        int r113 = r23.getNumber();
    L38:
        if (r23 != Message.SourceType.TYPE_FROM_FAVORITE) goto L40;
        int r114 = 2;
    L41:
        com.ss.android.lark.download.service.impl.j r26 = r24;
        r26.getClass();
        long r27 = System.currentTimeMillis();
        AuthorizationServiceV2 r115 = owa.a.c();
        DownloadAuthorizationEventType r28 = DownloadAuthorizationEventType.VIDEO_DOWNLOAD;
        com.ss.android.lark.download.service.impl.f r29 = new com.ss.android.lark.download.service.impl.f(r26, r27, r111, r21, r112, r22, r113, r114, r110, r15, r15);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r28, "eventType");
        Intrinsics.checkNotNullParameter(r15, "auzEntityId");
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r29, "callback");
        AuditParamsUtil r30 = AuditParamsUtil.a;
        AuditParamsUtil.b(AuthorizationServiceV2.k(r28, r15), r22, r21, null, null, r15, new com.ss.android.lark.auditsdk.v2.a(r115, r29, r16, 2131891697));
        r6 = r18.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(this);
    L44:
        if (r6 != r0) goto L46;
        return r0;
    L40:
        r114 = -99;
        goto L41
    L36:
        r113 = 0;
        goto L38
    L32:
        r23 = null;
        goto L33
    L29:
        r22 = null;
        goto L30
    L26:
        r112 = null;
        goto L27
    L23:
        r21 = null;
        goto L24
    }
}
