package com.obric.assistant.voice;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import bga.f;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.d1;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.IObricTtsService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.singleton.DoraWakeupDetector;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.tts.IObricChainTtsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u0007H\u0017J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/assistant/voice/DoraWakeupServiceImpl;", "Lcom/obric/assistant/spi/dora/IDoraWakeupService;", "<init>", "()V", "TAG", "", "handleDoraWakeup", "", "type", "Lcom/obric/assistant/spi/dora/IDoraWakeupService$WakeupType;", "vuiId", "", "needUpdate", "", "onQueryStop", "onSingleClick", WindowEvent.WindowOpenPerfResult.CANCEL, "setStopVUIWhenTtsEnd", "stop", "isInRadioPressing", "isInDoraVoiceWakeup", "setObricContTalkActive", "isActive", "isObricContTalkActive", "stopVUI", "stopVUIWhenTimeout", "setUseDefaultDora", "useDefault", "getUseDefaultDora", "doraSupportFeatureOTA3P5", "notifyDoraWakeupForEnroll", "notifyDoraGWakeupState", "isInWakeup", "isInDoraGWakeup", "isDoraProxyWakeup", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWakeupServiceImpl implements IDoraWakeupService {
    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void a() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        Bundle r1 = new Bundle();
        r1.putInt("custom_show_flags", 0);
        r1.putInt("invocation_type", 24);
        FLogger r2 = FLogger.a;
        r2.i("DoraWakeupDetector", "onQueryStop, isInRadioPressing: " + DoraWakeupDetector.c);
        if (DoraWakeupDetector.c == false) goto L11;
        r2.i("DoraWakeupDetector", "onQueryStop, end intercom. listener = " + DoraWakeupDetector.b);
        DoraWakeupDetector.a r3 = DoraWakeupDetector.c("onQueryStop");
        if (r3 == null) goto L7;
        r3.i(r1);
    L7:
        DoraWakeupDetector.c = false;
        if (DoraWakeupDetector.d() == false) goto L12;
        DoraWakeupDetector.f();
        return;
    L12:
        return;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean b() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        return DoraWakeupDetector.e;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean c() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        IDoraOperation r1 = f.a();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.c() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void cancel() {
        DoraWakeupDetector.a.b();
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean e() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        return DoraWakeupDetector.h.get();
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean f() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        FLogger.a.i("DoraWakeupDetector", "getUseDefaultDora, useDefault: " + DoraWakeupDetector.g);
        return DoraWakeupDetector.g;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean g() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        return DoraWakeupDetector.d();
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void h() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        DoraWakeupDetector.g();
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void m() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        FLogger r1 = FLogger.a;
        r1.i("DoraWakeupDetector", "onSingleClick, try close tts play if tts playing");
        d1 r2 = AudioServiceDelegate.a.i0();
        if (r2.a() == false) goto L5;
        SoundEffectHelper.INSTANCE.playExit();
        r2.cancel("Dora single click cancel", true);
    L5:
        IObricChainTtsService.a.getClass();
        IObricChainTtsService r3 = IObricChainTtsService.a.a();
        boolean r6 = false;
        if (r3 != null) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L13;
        r1.i("DoraWakeupDetector", "onSingleClick, interrupt ObricChainTts (independent tts pipeline)");
        SoundEffectHelper.INSTANCE.playExit();
        r3.c("Dora single click cancel");
    L13:
        ObricChatContextServiceDelegate r4 = ObricChatContextServiceDelegate.b;
        FragmentActivity r8 = AppHost.a.a().getCurrentActivity();
        com.obric.audio.continuous_talk.b r9 = null;
        if ((r8 instanceof FragmentActivity) == false) goto L16;
        FragmentActivity r10 = r8;
    L17:
        t1a.b r5 = r4.b(r10);
        if (r5 == null) goto L20;
        r9 = (com.obric.audio.continuous_talk.b) r5.getAbility(com.obric.audio.continuous_talk.b.class);
    L20:
        if (r9 != null) goto L22;
    L24:
        if (r6 == false) goto L27;
        r2.cancel("Dora single click cancel", true);
        r1.i("DoraWakeupDetector", "onSingleClick, try close obricContinuousTalk");
        DoraWakeupDetector.h();
        return;
    L27:
        return;
    L22:
        if (r9.m0() != true) goto L24;
        r6 = true;
        goto L24
    L16:
        r10 = null;
        goto L17
    L8:
        if (r3.b() != true) goto L10;
        r7 = true;
        goto L11
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean n() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        return DoraWakeupDetector.d;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean o() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        return DoraWakeupDetector.c;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void p() {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        DoraWakeupDetector.f();
    }

    public DoraWakeupServiceImpl() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void d(boolean r4) {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        FLogger.a.i("DoraWakeupDetector", "notifyDoraGWakeupState, isInWakeup: " + r4);
        DoraWakeupDetector.e = r4;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void i(boolean r2) {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        DoraWakeupDetector.h.set(r2);
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void j(boolean r2) {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        DoraWakeupDetector.f = r2;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void k(int r4) {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        FLogger.a.i("DoraWakeupDetector", "notifyDoraWakeupForEnroll, vuiId: " + r4);
        com.obric.audio.enroll.b.a r1 = com.obric.audio.enroll.b.a.getAndSet(null);
        if (r1 == null) goto L10;
        IEnrollService.a.getClass();
        IEnrollService r2 = IEnrollService.a.a();
        if (r2 == null) goto L9;
        r2.e(r1.a, r1.b, String.valueOf(r4));
        return;
    L9:
        return;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void l(boolean r4) {
        DoraWakeupDetector r0 = DoraWakeupDetector.a;
        FLogger.a.i("DoraWakeupDetector", "setUseDefaultDora, useDefault: " + r4);
        DoraWakeupDetector.g = r4;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void q(IDoraWakeupService.WakeupType r54, int r55, boolean r56) {
        Intrinsics.checkNotNullParameter(r54, "type");
        DoraWakeupDetector r3 = DoraWakeupDetector.a;
        Intrinsics.checkNotNullParameter(r54, "type");
        FLogger r2 = FLogger.a;
        r2.i("DoraWakeupDetector", "handleDoraWakeup...wakeupType = " + r54);
        Application r4 = AppHost.a.getApplication();
        String r7 = null;
        if (r56 == false) goto L15;
        r2.i("DoraWakeupDetector", "need update dora version, play notice tts and return");
        IObricTtsService r0 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r0 == null) goto L14;
        IAuthModelService r1 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r1 == null) goto L13;
        LiveData r5 = r1.y();
        if (r5 == null) goto L13;
        e r6 = (e) r5.getValue();
        if (r6 == null) goto L13;
        r7 = r6.a;
    L13:
        r0.e(new Message(r7, null, null, 0, 21, null, 0, false, null, r4.getResources().getString(2131912276), null, null, null, null, "unknown", "notice_update_tts_message", 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -49682, 31, null), 1);
    L14:
        DoraWakeupDetector.f();
        return;
    L15:
        IDoraWakeupService.WakeupType r8 = IDoraWakeupService.WakeupType.VOICE;
        if (r54 != r8) goto L25;
        IObricMultiUserService.a.getClass();
        IObricMultiUserService r10 = IObricMultiUserService.a.a();
        if (r10 != null) goto L20;
    L22:
        boolean r11 = false;
    L23:
        if (r11 == true) goto L25;
        r2.i("DoraWakeupDetector", "is not main user, not support wakeup, stop VUI");
        DoraWakeupDetector.f();
        return;
    L20:
        if (r10.a() != true) goto L22;
        r11 = true;
    L25:
        Job r12 = DoraWakeupDetector.m;
        if (r12 != null) goto L28;
    L33:
        DoraWakeupDetector.m = null;
        new Bundle();
        int r13 = DoraWakeupDetector.b.a[r54.ordinal()];
        if (r13 != 1) goto L36;
    L46:
        Bundle r14 = new Bundle();
        r14.putInt("custom_show_flags", 0);
        r14.putInt("invocation_type", 26);
        r14.putString("keyword", r4.getResources().getString(2131912700));
        r14.putLong("offsetTime", 800);
        r14.putInt("DORA_WAKEUP_VUIID", r55);
        DoraWakeupDetector.d = true;
    L47:
        ObricChatContextServiceDelegate r9 = ObricChatContextServiceDelegate.b;
        FragmentActivity r15 = r9.d();
        t1a.b r16 = r9.b(r15);
        if (r16 == null) goto L50;
        maa.e r17 = (maa.e) r16.getAbility(maa.e.class);
    L51:
        if (r54 != r8) goto L59;
        if (r17 == null) goto L56;
        boolean r18 = true;
        if (r17.x3() != true) goto L56;
    L57:
        if (r18 == false) goto L59;
        r2.i("DoraWakeupDetector", "isClickTalking, abandon dora wakeup, stop VUI");
        DoraWakeupDetector.f();
        return;
    L56:
        r18 = false;
    L59:
        DoraWakeupDetector.f = false;
        r2.i("DoraWakeupDetector", "handleDoraWakeup, DoraWakeupDetector.listener: " + DoraWakeupDetector.b);
        DoraWakeupDetector.a r19 = DoraWakeupDetector.c("handleDoraWakeup type=" + r54 + " vuiId=" + r55);
        if (r19 != null) goto L62;
        r2.e("DoraWakeupDetector", "handleDoraWakeup dispatch failed, stop VUI. type=" + r54 + ", vuiId=" + r55);
        DoraWakeupDetector.f();
        return;
    L62:
        r19.i(r14);
        if (r54 == IDoraWakeupService.WakeupType.RADIO) goto L65;
    L76:
        AudioServiceDelegate.a.r0().m(DoraWakeupDetector.o);
        return;
    L65:
        if (DoraWakeupDetector.d() == true) goto L76;
        r3.i();
        t1a.b r20 = r9.b(r15);
        if (r20 == null) goto L69;
        l r21 = (l) r20.getAbility(l.class);
    L70:
        if (r21 == null) goto L72;
        WeakReference<l> r22 = new WeakReference(r21);
    L73:
        DoraWakeupDetector.i = r22;
        if (r21 == null) goto L76;
        r21.A4(r3);
        goto L76
    L72:
        r22 = null;
        goto L73
    L69:
        r21 = null;
        goto L70
    L50:
        r17 = null;
        goto L51
    L36:
        if (r13 == 2) goto L46;
        if (r13 != 3) goto L40;
        Bundle r23 = new Bundle();
        r23.putInt("custom_show_flags", 0);
        r23.putInt("invocation_type", 26);
        r23.putString("keyword", "");
        r23.putLong("offsetTime", 0);
        r23.putInt("DORA_WAKEUP_VUIID", r55);
        DoraWakeupDetector.d = true;
    L45:
        r14 = r23;
        goto L47
    L40:
        if (r13 != 4) goto L43;
        r23 = new Bundle();
        r23.putInt("custom_show_flags", 0);
        r23.putInt("invocation_type", 23);
        r23.putInt("DORA_WAKEUP_VUIID", r55);
        DoraWakeupDetector.c = true;
        goto L45
    L43:
        throw new NoWhenBranchMatchedException();
    L28:
        if (r12.isActive() == true) goto L31;
        r12 = null;
    L31:
        if (r12 == null) goto L33;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
        goto L33
    }
}
