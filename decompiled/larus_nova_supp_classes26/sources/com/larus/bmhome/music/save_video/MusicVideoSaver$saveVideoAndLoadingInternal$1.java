package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.music.protocol.MusicPullingApi;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
import kr8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver$saveVideoAndLoadingInternal$1", f = "MusicVideoSaver.kt", i = {0, 0, 1, 1, 1}, l = {286, 298}, m = "invokeSuspend", n = {"preparedContent", "preparedLyricsSeekContent", "vid", "resultPath", "startTime"}, s = {"L$0", "L$1", "L$0", "L$1", "J$0"})
public final class MusicVideoSaver$saveVideoAndLoadingInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function2<Integer, String, Unit> $dismissLoadingCallback;
    final /* synthetic */ String $downloadTaskKey;
    final /* synthetic */ LyricsSeekContent $lyricsSeekContent;
    final /* synthetic */ Message $message;
    final /* synthetic */ MusicCreationContent $musicContent;
    final /* synthetic */ ViewGroup $viewParent;
    long J$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MusicVideoSaver$saveVideoAndLoadingInternal$1(MusicCreationContent r1, LyricsSeekContent r2, Message r3, Function2<? super Integer, ? super String, Unit> r4, Context r5, ViewGroup r6, String r7, Continuation<? super MusicVideoSaver$saveVideoAndLoadingInternal$1> r8) {
        this.$musicContent = r1;
        this.$lyricsSeekContent = r2;
        this.$message = r3;
        this.$dismissLoadingCallback = r4;
        this.$context = r5;
        this.$viewParent = r6;
        this.$downloadTaskKey = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MusicVideoSaver$saveVideoAndLoadingInternal$1(this.$musicContent, this.$lyricsSeekContent, this.$message, this.$dismissLoadingCallback, this.$context, this.$viewParent, this.$downloadTaskKey, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r10 = "";
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        long r1 = this.J$0;
        String r2 = (String) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r22);
        long r13 = r1;
        String r18 = r3;
        Object r4 = r22;
    L60:
        int r5 = ((Number) r4).intValue();
        if (r5 != 0) goto L63;
        String r6 = "1";
    L64:
        String r16 = r6;
        if (r5 == 0) goto L67;
        String r17 = "error code " + r5;
    L68:
        kr8.l.a.b(new y(r16, r17, r18, Boxing.boxLong(System.currentTimeMillis() - r13), 1), null, 3);
        Function2<Integer, String, Unit> r7 = this.$dismissLoadingCallback;
        Integer r8 = Boxing.boxInt(r5);
        Intrinsics.checkNotNull(r2);
        r7.invoke(r8, r2);
        MusicVideoSaver r11 = MusicVideoSaver.a;
        String r12 = this.$musicContent.getVid();
        if (r12 == null) goto L72;
        r10 = r12;
    L72:
        MusicVideoSaver.i(r10);
        return Unit.INSTANCE;
    L67:
        r17 = "";
        goto L68
    L63:
        r6 = TriggerSendLoading.NO_LOADING;
        goto L64
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LyricsSeekContent r14 = (LyricsSeekContent) this.L$1;
        MusicCreationContent r15 = (MusicCreationContent) this.L$0;
        ResultKt.throwOnFailure(r22);
        LyricsSeekContent r19 = r14;
        Object r20 = r22;
    L30:
        Pair r21 = (Pair) r20;
        if (r21 == null) goto L36;
        MusicCreationContent r23 = (MusicCreationContent) r21.getFirst();
        if (r23 == null) goto L36;
        String r24 = r23.getVid();
        if (r24 == null) goto L36;
    L37:
        if (r21 == null) goto L39;
        MusicCreationContent r25 = (MusicCreationContent) r21.getFirst();
    L40:
        if (r25 != null) goto L42;
    L51:
        this.$dismissLoadingCallback.invoke(Boxing.boxInt(101), "no message");
        MusicVideoSaver r26 = MusicVideoSaver.a;
        String r27 = this.$musicContent.getVid();
        if (r27 != null) goto L54;
        r27 = "";
    L54:
        MusicVideoSaver.i(r27);
    L55:
        MusicCreationContent r28 = r15;
        String r110 = r24;
    L25:
        LyricsSeekContent r29 = r19;
        r13 = System.currentTimeMillis();
        MusicVideoSaver r30 = MusicVideoSaver.a;
        aa9.a.a r31 = aa9.a.a;
        StringBuilder r32 = new StringBuilder("/nova_video/");
        String r210 = r110;
        r32.append(System.currentTimeMillis());
        r32.append(".mp4");
        String r33 = r32.toString();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r33, "subPath");
        aa9.h r34 = r31.b;
        r34.getClass();
        Intrinsics.checkNotNullParameter(r33, "subPath");
        PolarisFileWrapper r35 = new PolarisFileWrapper((File) r34.f.getValue(), r33);
        r35.mkdirs();
        r34.g(r35, "getDirOfExternalCache");
        String r111 = r35.getPath();
        Context r36 = this.$context;
        ViewGroup r37 = this.$viewParent;
        String r38 = this.$downloadTaskKey;
        Intrinsics.checkNotNull(r111);
        this.L$0 = r210;
        this.L$1 = r111;
        this.J$0 = r13;
        this.label = 2;
        r4 = MusicVideoSaver.b(r30, r36, r37, r38, r111, r28, r29, this);
        if (r4 != r9) goto L59;
        return r9;
    L59:
        r2 = r111;
        r18 = r210;
        goto L60
    L42:
        if (r21.getSecond() == null) goto L51;
        MusicCreationContent r39 = (MusicCreationContent) r21.getFirst();
        if (r39 == null) goto L47;
        r15 = r39;
    L47:
        LyricsSeekContent r40 = (LyricsSeekContent) r21.getSecond();
        if (r40 == null) goto L55;
        r19 = r40;
        goto L55
    L39:
        r25 = null;
    L36:
        r24 = "";
        goto L37
    L10:
        ResultKt.throwOnFailure(r22);
        String r41 = this.$musicContent.getVid();
        MusicCreationContent r42 = this.$musicContent;
        r19 = this.$lyricsSeekContent;
        if (TextUtils.isEmpty(r41) == true) goto L26;
        if (r19 == null) goto L14;
        List r43 = r19.getUtterances();
    L15:
        List r44 = r43;
        if (r44 != null) goto L18;
    L21:
        boolean r45 = true;
    L22:
        if (r45 == true) goto L26;
        r110 = r41;
        r28 = r42;
        goto L25
    L18:
        if (r44.isEmpty() == true) goto L21;
        r45 = false;
        goto L22
    L14:
        r43 = null;
    L26:
        MusicPullingApi r46 = MusicPullingApi.a;
        Message r47 = this.$message;
        String r48 = this.$musicContent.getPlayList().getItemId();
        this.L$0 = r42;
        this.L$1 = r19;
        this.label = 1;
        r20 = MusicPullingApi.a.b(r47, r48, 20, this);
        if (r20 != r9) goto L29;
        return r9;
    L29:
        r15 = r42;
        goto L30
    }
}
