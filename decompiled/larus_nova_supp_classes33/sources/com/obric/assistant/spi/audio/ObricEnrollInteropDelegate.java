package com.obric.assistant.spi.audio;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\t\u0010\u000b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u000e\u0010\u0013\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fH\u0096\u0001J\u0011\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010&\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tH\u0096\u0001J\t\u0010+\u001a\u00020\u0007H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricEnrollInteropDelegate;", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService;", "<init>", "()V", "applyBreathWakeupEnabled", "", "enabled", "", "buildDoraEngineVersionJson", "", "buildObricContPvadVersionJson", "getDeviceUuid", "isBreathWakeupEnabled", "uid", "isCurrentSessionFromBreathWakeup", "isHelpImproveVoiceWakeupEnabled", "isLockedScreenUseEnabled", "isVoiceWakeupEnabled", "migrateLegacyPhoneWakeupSettingsToPersonalUid", "refreshHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reloadVoiceWakeupSamiCore", "requestEnrollGuideRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService$EnrollPermissionCallback;", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", "", "setAssistantEnrollingStatus", "enrolling", "setBreathWakeupEnabled", "setContinueSpeakNoiseReductionEnabled", "setHelpImproveVoiceWakeupEnabled", "setSvaSdkEnrollingStatus", "setVoiceWakeupEnabled", "trackEnrollData", "eventId", "", "data", "useSystemDrawableForEnrollGuide", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollInteropDelegate implements IObricEnrollInteropService {
    public static final ObricEnrollInteropDelegate b = null;
    public final /* synthetic */ IObricEnrollInteropService a;

    static {
        b = new ObricEnrollInteropDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String A() {
        return this.a.A();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String c() {
        return this.a.c();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void e(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a.e(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void f(boolean r2) {
        this.a.f(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean g() {
        return this.a.g();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void h() {
        this.a.h();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean i() {
        return this.a.i();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void j(boolean r2) {
        this.a.j(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void k(FragmentActivity r2, IObricEnrollInteropService.a r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.k(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void l(boolean r2, List<String> r3) {
        this.a.l(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.a.m(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void n(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.a.n(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void o() {
        this.a.o();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void p() {
        this.a.p();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final Object q(Continuation<? super Boolean> r2) {
        return this.a.q(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void r(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.a.r(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void s() {
        this.a.s();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean t() {
        return this.a.t();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.a.u(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String v() {
        return this.a.v();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void w(boolean r2) {
        this.a.w(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void x(boolean r2) {
        this.a.x(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.a.y(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void z(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.a.z(r2);
    }

    private ObricEnrollInteropDelegate() {
        IObricEnrollInteropService r0 = (IObricEnrollInteropService) ServiceManager.get().getService(IObricEnrollInteropService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricEnrollInteropServiceImpl();
    L5:
        this.a = r0;
    }
}
