package com.larus.bmhome.music.protocol;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kr8.z;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.protocol.MusicShareApi$shareWithShareService$1", f = "MusicShareApi.kt", i = {0}, l = {301}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
final class MusicShareApi$shareWithShareService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ com.larus.bmhome.share.panel.h $eventParam;
    final /* synthetic */ l0 $loadingDialog;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $messageId;
    final /* synthetic */ kr8.o $musicAppletMobContext;
    final /* synthetic */ MusicCreationContent $musicContent;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sendShareEvent;
    final /* synthetic */ ViewGroup $shareContainer;
    final /* synthetic */ ShareScene $shareScene;
    Object L$0;
    Object L$1;
    int label;

    public MusicShareApi$shareWithShareService$1(ViewGroup r1, CoroutineScope r2, l0 r3, String r4, String r5, MusicCreationContent r6, String r7, Message r8, kr8.o r9, com.larus.bmhome.share.panel.h r10, ShareScene r11, boolean r12, String r13, Continuation<? super MusicShareApi$shareWithShareService$1> r14) {
        this.$shareContainer = r1;
        this.$scope = r2;
        this.$loadingDialog = r3;
        this.$currentPage = r4;
        this.$clickFrom = r5;
        this.$musicContent = r6;
        this.$messageId = r7;
        this.$message = r8;
        this.$musicAppletMobContext = r9;
        this.$eventParam = r10;
        this.$shareScene = r11;
        this.$sendShareEvent = r12;
        this.$botId = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        return new MusicShareApi$shareWithShareService$1(this.$shareContainer, this.$scope, this.$loadingDialog, this.$currentPage, this.$clickFrom, this.$musicContent, this.$messageId, this.$message, this.$musicAppletMobContext, this.$eventParam, this.$shareScene, this.$sendShareEvent, this.$botId, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r43) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r11 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        Context r1 = (Context) this.L$1;
        MusicCreationContent r2 = (MusicCreationContent) this.L$0;
        ResultKt.throwOnFailure(r43);
        Context r12 = r1;
        Object r3 = r43;
    L60:
        String r4 = (String) r3;
        if (TextUtils.isEmpty(r4) == false) goto L64;
        s.a.getClass();
        s.s(r12, 2131909350);
        return Unit.INSTANCE;
    L64:
        Intent r5 = new Intent();
        r5.setAction("android.intent.action.SEND");
        r5.putExtra("android.intent.extra.TEXT", r4);
        if (o0.d(r2.getTitle()) == false) goto L67;
        r5.putExtra("android.intent.extra.TITLE", r2.getTitle());
    L67:
        r5.setType("text/plain");
        Intent r6 = Intent.createChooser(r5, null);
        if (r12 == null) goto L71;
        r12.startActivity(r6);
    L71:
        if (this.$sendShareEvent == false) goto L108;
        MusicShareApi r7 = MusicShareApi.a;
        String r9 = this.$currentPage;
        MusicCreationContent r10 = this.$musicContent;
        String r13 = this.$clickFrom;
        String r14 = this.$messageId;
        String r15 = this.$botId;
        Message r16 = this.$message;
        kr8.o r17 = this.$musicAppletMobContext;
        long r18 = ko8.a.e;
        if (TextUtils.equals(r9, "music_detail") == false) goto L75;
        String r19 = "chat";
    L79:
        if (r15 != null) goto L85;
        com.larus.bmhome.chat.trace.a r20 = IAIChatControlTraceService.a.gc(r18);
        if (r20 == null) goto L83;
        r15 = r20.a;
        goto L85
    L83:
        r15 = null;
    L85:
        if (r19 != null) goto L87;
        String r110 = "";
    L88:
        if (r15 != null) goto L90;
        r15 = "";
    L90:
        String r111 = r10.getTitle();
        if (r10.getCoverEdited() == false) goto L93;
        String r112 = TriggerSendLoading.NO_LOADING;
    L95:
        if (r10.getTitleEdited() == false) goto L97;
        String r113 = TriggerSendLoading.NO_LOADING;
    L98:
        String r114 = r10.getVid();
        String r21 = r10.getPlayList().getItemId();
        if ((r10 instanceof bq8.a) == false) goto L101;
        String r22 = "1";
    L102:
        if (r16 == null) goto L106;
        Map r23 = r16.getExt();
        if (r23 == null) goto L106;
        r11 = (String) r23.get("gen_music_create_way");
    L106:
        z r115 = new z(r9, r110, r15, r111, r112, r113, r114, r21, r22, r13, r14, r11, 129);
        kr8.n r24 = kr8.n.a;
        kr8.l.a.b(r115, kr8.n.e(r17, r10, r9), 1);
        goto L108
    L101:
        r22 = TriggerSendLoading.NO_LOADING;
        goto L102
    L97:
        r113 = "1";
        goto L98
    L93:
        r112 = "1";
        goto L95
    L87:
        r110 = r19;
        goto L88
    L75:
        com.larus.bmhome.chat.trace.a r25 = IAIChatControlTraceService.a.gc(r18);
        if (r25 == null) goto L78;
        r19 = r25.k;
        goto L79
    L78:
        r19 = null;
    L108:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r43);
        if (z2.a.getShareConfig().p() == false) goto L54;
        MusicShareApi.ShareCallback r26 = new MusicShareApi.ShareCallback(this.$shareContainer, this.$scope, this.$loadingDialog, this.$currentPage, this.$clickFrom, this.$musicContent, this.$messageId, this.$message, this.$musicAppletMobContext);
        r26.k = this.$eventParam;
        IShareService r116 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r116 == null) goto L52;
        FragmentActivity r27 = this.$shareContainer.getContext();
        if ((r27 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r28 = r27;
    L16:
        if (r28 != null) goto L28;
        Context r29 = this.$shareContainer.getContext();
        if ((r29 instanceof ContextThemeWrapper) == false) goto L20;
        ContextThemeWrapper r30 = (ContextThemeWrapper) r29;
    L21:
        if (r30 == null) goto L23;
        Context r31 = r30.getBaseContext();
    L25:
        if ((r31 instanceof FragmentActivity) == false) goto L27;
        r28 = (FragmentActivity) r31;
        goto L28
    L27:
        FragmentActivity r117 = null;
    L29:
        String r32 = this.$musicContent.getTitle();
        if (r32 != null) goto L32;
        r32 = "";
    L32:
        ViewGroup r33 = this.$shareContainer;
        if (r32.length() != 0) goto L35;
        boolean r34 = true;
    L36:
        if (r34 == false) goto L38;
        r32 = r33.getContext().getString(2131908033);
    L38:
        String r210 = r32;
        Image r35 = this.$musicContent.getCover();
        if (r35 == null) goto L46;
        ImageObj r36 = r35.imageThumb;
        if (r36 == null) goto L46;
        String r37 = r36.url;
        if (r37 == null) goto L46;
        String r118 = r37;
    L47:
        Context r38 = this.$shareContainer.getContext();
        if (r38 == null) goto L50;
        String r211 = r38.getString(2131909361);
    L51:
        DialogFragment r39 = IShareService$a.g(r116, r117, this.$shareScene, new com.larus.bmhome.share.panel.b(null, null, null, r118, null, null, null, r210, r211, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108471), this.$eventParam, r26, null, false, 224);
    L53:
        r26.j = r39;
        goto L71
    L50:
        r211 = null;
    L46:
        r118 = "";
        goto L47
    L35:
        r34 = false;
        goto L36
    L23:
        r31 = null;
        goto L25
    L20:
        r30 = null;
    L28:
        r117 = r28;
        goto L29
    L15:
        r28 = null;
        goto L16
    L52:
        r39 = null;
        goto L53
    L54:
        r12 = this.$shareContainer.getContext();
        if (r12 == null) goto L71;
        ViewGroup r40 = this.$shareContainer;
        String r41 = this.$messageId;
        Message r42 = this.$message;
        MusicCreationContent r119 = this.$musicContent;
        MusicShareApi r44 = MusicShareApi.a;
        this.L$0 = r119;
        this.L$1 = r12;
        this.label = 1;
        r3 = r44.b(r40, r41, r42, r119, true, this);
        if (r3 != r8) goto L59;
        return r8;
    L59:
        r2 = r119;
        goto L60
    }
}
