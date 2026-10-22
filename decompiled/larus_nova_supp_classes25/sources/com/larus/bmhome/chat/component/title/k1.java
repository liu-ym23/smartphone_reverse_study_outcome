package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import by9.a;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.tips.IGuideTipsService;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k1 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatTitleComponent a;

    public k1(ChatTitleComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.component.title.l0] */
    public final void c(Object r12) {
        BotModel r13 = (BotModel) r12;
        Intrinsics.checkNotNullParameter(r13, "new");
        Gson r0 = new Gson();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl((EditPos) r0.fromJson(r13.getEditPos(), EditPos.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        EditPos r3 = (EditPos) r2;
        boolean r4 = false;
        if (r3 != null) goto L13;
        r3 = new EditPos(0);
    L13:
        ChatTitleComponent r5 = this.a;
        int r6 = ChatTitleComponent.P1;
        if (r5.B3() == null) goto L16;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), new s1(CoroutineExceptionHandler.Key), null, new ChatTitleComponent$initTitleByBot$1$2(r5, r13, null), 2, null);
    L16:
        ChatTitleComponent r7 = this.a;
        r7.getClass();
        SpeakerVoice r8 = r13.getVoiceType();
        if (r8 == null) goto L23;
        ChatTitleComponentViewModel r9 = r7.h4();
        e r10 = r7.V3();
        if (r10 == null) goto L21;
        Integer r11 = r10.v;
    L22:
        r9.updateAsrLanguage(r8, r11);
        goto L23
    L21:
        r11 = null;
    L23:
        a r14 = r7.i4();
        if (r14 == null) goto L26;
        r14.EL(r13);
    L26:
        this.a.B4();
        ChatTitleComponent.Y2(this.a);
        ICoreInputAbility r15 = this.a.W3();
        if (r15 == null) goto L29;
        r15.eQ(r3, r13);
    L29:
        FLogger.a.d(this.a.d4(), "onBotChanged");
        final ChatTitleComponent r16 = this.a;
        LiveData r17 = (LiveData) r16.V.getValue();
        if (r17 == null) goto L39;
        Job r18 = r16.X;
        if (r18 == null) goto L35;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L35:
        k0 r19 = r16.H0;
        if (r19 == null) goto L38;
        r17.removeObserver(r19);
    L38:
        k0 r20 = new k0(r16, r17);
        r17.observe(r16, r20);
        r16.H0 = r20;
    L39:
        LiveData r21 = AuthModelDelegate.b.B();
        l0 r22 = r16.L0;
        if (r22 == null) goto L42;
        r21.removeObserver(r22);
    L42:
        ?? r23 = new l0(r16);
        r21.observe(r16, r23);
        r16.L0 = r23;
        final ChatTitleComponent r110 = this.a;
        BotModel r24 = r110.j0();
        if (r24 == null) goto L47;
        BotMemoryConfig r25 = r24.getBotMemoryConfig();
        if (r25 == null) goto L47;
        boolean r26 = Intrinsics.areEqual(r25.getEnableBotMemory(), Boolean.TRUE);
    L48:
        if (r26 == false) goto L79;
        BotModel r27 = r110.j0();
        if (r27 == null) goto L54;
        BotMemoryConfig r28 = r27.getBotMemoryConfig();
        if (r28 == null) goto L54;
        boolean r29 = Intrinsics.areEqual(r28.getShowMemoryGuideTips(), Boolean.TRUE);
    L55:
        if (r29 == false) goto L80;
        IFlowSdkDepend r30 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r30 == null) goto L61;
        r30.r0();
        if (e2.a.w() != true) goto L61;
        boolean r31 = true;
    L62:
        if (r31 == false) goto L74;
        IGuideTipsService r32 = (IGuideTipsService) ServiceManager.get().getService(IGuideTipsService.class);
        if (r32 != null) goto L66;
    L68:
        boolean r33 = false;
    L69:
        if (r33 == false) goto L74;
        if (AccountService.a.a() == true) goto L74;
        r4 = true;
        goto L74
    L66:
        if (r32.f(8) == true) goto L68;
        r33 = true;
    L74:
        if ((!r4) == false) goto L81;
        com.larus.utils.t0.d(new m0(r110), 300);
        return;
    L81:
        return;
    L61:
        r31 = false;
        goto L62
    L80:
        return;
    L54:
        r29 = false;
        goto L55
    L79:
        return;
    L47:
        r26 = false;
    L5:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
