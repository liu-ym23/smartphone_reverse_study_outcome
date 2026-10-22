package com.obric.assistant.spi.audio;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u000e\u0010\u001e\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001fJ\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016¨\u0006,"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricEnrollInteropServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService;", "<init>", "()V", "setAssistantEnrollingStatus", "", "enrolling", "", "trackEnrollData", "eventId", "", "data", "", "setVoiceWakeupEnabled", "enabled", "setContinueSpeakNoiseReductionEnabled", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "uid", "isVoiceWakeupEnabled", "migrateLegacyPhoneWakeupSettingsToPersonalUid", "isBreathWakeupEnabled", "setBreathWakeupEnabled", "applyBreathWakeupEnabled", "isLockedScreenUseEnabled", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", "", "setHelpImproveVoiceWakeupEnabled", "isHelpImproveVoiceWakeupEnabled", "refreshHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEnrollGuideRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService$EnrollPermissionCallback;", "useSystemDrawableForEnrollGuide", "getDeviceUuid", "buildDoraEngineVersionJson", "buildObricContPvadVersionJson", "isCurrentSessionFromBreathWakeup", "setSvaSdkEnrollingStatus", "reloadVoiceWakeupSamiCore", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricEnrollInteropServiceImpl implements IObricEnrollInteropService {
    public DefaultObricEnrollInteropServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String A() {
        return "";
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean b() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String c() {
        return "";
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean d() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void e(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void f(boolean r1) {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean g() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void h() {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean i() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void j(boolean r1) {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void l(boolean r1, List<String> r2) {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void n(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void o() {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void p() {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void r(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void s() {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean t() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String v() {
        return "";
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void w(boolean r1) {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void x(boolean r1) {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void z(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final Object q(Continuation<? super Boolean> r1) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void k(FragmentActivity r4, IObricEnrollInteropService.a r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "callback");
        r5.a(true, false, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
