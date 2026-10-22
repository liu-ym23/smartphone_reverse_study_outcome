package com.larus.bmhome.video.save_share;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.service.z2;
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
import org.json.JSONObject;
import t19.s;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateShareHelper$shareWithShareService$1", f = "VideoGenerateShareHelper.kt", i = {0}, l = {152}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
public final class VideoGenerateShareHelper$shareWithShareService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ com.larus.bmhome.share.panel.h $eventParam;
    final /* synthetic */ l0 $loadingDialog;
    final /* synthetic */ String $messageId;
    final /* synthetic */ Map<String, String> $metaDataMap;
    final /* synthetic */ Integer $reportType;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sendShareEvent;
    final /* synthetic */ View $shareContainer;
    final /* synthetic */ ShareScene $shareScene;
    final /* synthetic */ Integer $taskType;
    final /* synthetic */ nr9.g $videoContent;
    final /* synthetic */ c4 $videoDetailEventParams;
    Object L$0;
    int label;

    public VideoGenerateShareHelper$shareWithShareService$1(String r1, View r2, ShareScene r3, CoroutineScope r4, l0 r5, c4 r6, nr9.g r7, Integer r8, String r9, Map<String, String> r10, Integer r11, com.larus.bmhome.share.panel.h r12, boolean r13, Continuation<? super VideoGenerateShareHelper$shareWithShareService$1> r14) {
        this.$messageId = r1;
        this.$shareContainer = r2;
        this.$shareScene = r3;
        this.$scope = r4;
        this.$loadingDialog = r5;
        this.$videoDetailEventParams = r6;
        this.$videoContent = r7;
        this.$reportType = r8;
        this.$creationId = r9;
        this.$metaDataMap = r10;
        this.$taskType = r11;
        this.$eventParam = r12;
        this.$sendShareEvent = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        return new VideoGenerateShareHelper$shareWithShareService$1(this.$messageId, this.$shareContainer, this.$shareScene, this.$scope, this.$loadingDialog, this.$videoDetailEventParams, this.$videoContent, this.$reportType, this.$creationId, this.$metaDataMap, this.$taskType, this.$eventParam, this.$sendShareEvent, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r42) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r10 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        Context r1 = (Context) this.L$0;
        ResultKt.throwOnFailure(r42);
        Context r11 = r1;
        Object r2 = r42;
    L72:
        String r3 = (String) r2;
        if (TextUtils.isEmpty(r3) == false) goto L76;
        s.a.getClass();
        s.s(r11, 2131909350);
        return Unit.INSTANCE;
    L76:
        Intent r4 = new Intent();
        r4.setAction("android.intent.action.SEND");
        r4.putExtra("android.intent.extra.TEXT", r3);
        r4.setType("text/plain");
        Intent r5 = Intent.createChooser(r4, null);
        if (r11 == null) goto L80;
        r11.startActivity(r5);
    L80:
        if (this.$sendShareEvent == false) goto L116;
        nr9.g r6 = this.$videoContent;
        if (r6 == null) goto L84;
        String r12 = r6.a;
    L85:
        com.larus.bmhome.share.panel.h r7 = this.$eventParam;
        if (r7 == null) goto L88;
        String r13 = r7.h;
    L89:
        if (r7 == null) goto L91;
        String r14 = r7.g;
    L92:
        if (r7 == null) goto L94;
        String r15 = r7.d;
    L95:
        c4 r8 = this.$videoDetailEventParams;
        if (r8 == null) goto L99;
        String r16 = r8.g;
        if (r16 == null) goto L99;
    L100:
        String r17 = r16;
        if (r8 == null) goto L103;
        String r18 = r8.j;
    L104:
        if (r8 == null) goto L106;
        Integer r19 = r8.i;
    L107:
        if (r8 == null) goto L109;
        r10 = r8.h;
    L109:
        String r110 = r10;
        if (r8 == null) goto L113;
        JSONObject r20 = r8.m;
        if (r20 == null) goto L113;
    L114:
        a4.k(r12, r13, r14, r15, r17, r18, r19, r110, r20);
    L113:
        r20 = new JSONObject();
        goto L114
    L106:
        r19 = null;
        goto L107
    L103:
        r18 = null;
    L99:
        r16 = TriggerSendLoading.NO_LOADING;
        goto L100
    L94:
        r15 = null;
        goto L95
    L91:
        r14 = null;
        goto L92
    L88:
        r13 = null;
        goto L89
    L84:
        r12 = null;
    L116:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r42);
        if (z2.a.getShareConfig().p() == false) goto L60;
        String r111 = this.$messageId;
        View r112 = this.$shareContainer;
        ShareScene r113 = this.$shareScene;
        CoroutineScope r114 = this.$scope;
        l0 r21 = this.$loadingDialog;
        c4 r22 = this.$videoDetailEventParams;
        if (r22 == null) goto L13;
        VideoGenerateShareHelper.VideoShareCallback r23 = new VideoGenerateShareHelper.VideoShareCallback(r111, r112, r113, r114, r21, r22, this.$videoContent, this.$reportType, this.$creationId, this.$metaDataMap);
        IShareService r115 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r115 == null) goto L58;
        View r24 = this.$shareContainer;
        if (r24 == null) goto L19;
        Context r25 = r24.getContext();
    L21:
        if ((r25 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r26 = (FragmentActivity) r25;
    L24:
        if (r26 != null) goto L40;
        View r27 = this.$shareContainer;
        if (r27 == null) goto L28;
        Context r28 = r27.getContext();
    L30:
        if ((r28 instanceof ContextThemeWrapper) == false) goto L32;
        ContextThemeWrapper r29 = (ContextThemeWrapper) r28;
    L33:
        if (r29 == null) goto L35;
        Context r30 = r29.getBaseContext();
    L37:
        if ((r30 instanceof FragmentActivity) == false) goto L39;
        r26 = (FragmentActivity) r30;
        goto L40
    L39:
        FragmentActivity r116 = null;
    L41:
        VideoGenerateShareHelper r31 = VideoGenerateShareHelper.a;
        String r210 = VideoGenerateShareHelper.e(r31, this.$shareContainer.getContext());
        nr9.g r32 = this.$videoContent;
        if (r32 == null) goto L46;
        nr9.f r33 = r32.g;
        if (r33 == null) goto L46;
        String r117 = r33.b;
    L47:
        String r211 = VideoGenerateShareHelper.d(r31, this.$shareContainer.getContext());
        nr9.g r34 = this.$videoContent;
        if (r34 == null) goto L50;
        String r118 = r34.c;
    L51:
        if (r34 == null) goto L53;
        String r119 = r34.d;
    L54:
        if (r34 == null) goto L56;
        String r212 = r34.a;
    L57:
        DialogFragment r35 = IShareService$a.g(r115, r116, this.$shareScene, new com.larus.bmhome.share.panel.b(null, null, null, r117, r118, r119, r212, r210, r211, null, null, null, null, null, null, null, true, false, null, null, false, false, this.$taskType, false, null, null, 62848519), this.$eventParam, r23, null, false, 224);
    L59:
        r23.l = r35;
        goto L80
    L56:
        r212 = null;
        goto L57
    L53:
        r119 = null;
        goto L54
    L50:
        r118 = null;
    L46:
        r117 = null;
        goto L47
    L35:
        r30 = null;
        goto L37
    L32:
        r29 = null;
        goto L33
    L28:
        r28 = null;
    L40:
        r116 = r26;
        goto L41
    L23:
        r26 = null;
        goto L24
    L19:
        r25 = null;
        goto L21
    L58:
        r35 = null;
        goto L59
    L13:
        return Unit.INSTANCE;
    L60:
        View r36 = this.$shareContainer;
        if (r36 == null) goto L80;
        r11 = r36.getContext();
        if (r11 == null) goto L80;
        View r37 = this.$shareContainer;
        ShareScene r38 = this.$shareScene;
        String r39 = this.$messageId;
        nr9.g r40 = this.$videoContent;
        String r41 = this.$creationId;
        VideoGenerateShareHelper r43 = VideoGenerateShareHelper.a;
        if (r40 == null) goto L68;
        String r44 = r40.a;
        if (r44 == null) goto L68;
    L69:
        this.L$0 = r11;
        this.label = 1;
        r2 = r43.g(r37, r38, r39, r44, true, r41, this);
        if (r2 != r9) goto L72;
        return r9;
    L68:
        r44 = "";
        goto L69
    }
}
