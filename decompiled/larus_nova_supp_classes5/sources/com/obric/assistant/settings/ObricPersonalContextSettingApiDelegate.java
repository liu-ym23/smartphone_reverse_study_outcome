package com.obric.assistant.settings;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0013\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0014H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0014H\u0097\u0001J\t\u0010\u001f\u001a\u00020\u0012H\u0096\u0001J\t\u0010 \u001a\u00020\u0012H\u0096\u0001J\t\u0010!\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0014H\u0096\u0001J\u001e\u0010'\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0014H\u0096A¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0014H\u0096\u0001J\u0019\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0096\u0001J9\u0010/\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0096\u0001J\u0011\u00104\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u00105\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u000e\u00106\u001a\u00020\u0014H\u0096A¢\u0006\u0002\u00107¨\u00068"}, d2 = {"Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "Lcom/obric/assistant/settings/IObricPersonalContextSettingApi;", "<init>", "()V", "getKevaRepo", "", "getLastLocalDataSearchInitPermissionRequestTimestamp", "", "getLocalDataSearchSwitchReportValue", "", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "getObricPersonalContextSettingsClassName", "Ljava/lang/Class;", "Landroid/app/Activity;", "getReferenceMemorySyncSnapshot", "Lcom/obric/assistant/settings/ReferenceMemorySyncSnapshot;", "initReferenceMemorySync", "", "isDataDomainDialogAlreadyShown", "", "isGovernedByNewGlobalMemorySwitch", "isGovernedBySystemPermission", "isHideEventMemory", "isLocalDataSearchEnabled", "isPersonalContextOpened", "isReferenceMemoryToggleEnabled", "key", "defVal", "isToggleOn", "isUseDataOnLockScreenEnabled", "personalContextOff", "personalContextOn", "registerMessageExt", "setDataDomainDialogAlreadyShown", "enable", "setLastLocalDataSearchInitPermissionRequestTimestamp", "timestamp", "setLocalDataSearchEnabled", "setReferenceMemoryToggleEnabledWithSync", "enabled", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUseDataOnLockScreen", "showLocalDataSearchConfirmFragment", "Landroidx/lifecycle/LiveData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "showLocalDataSearchSelectFragment", "Lkotlin/Pair;", "", "Lcom/obric/assistant/settings/SelectableToggleItem;", "toggleList", "turnOffToggle", "turnOnToggle", "updateReferenceMemoryCloudConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPersonalContextSettingApiDelegate implements IObricPersonalContextSettingApi {
    public static final ObricPersonalContextSettingApiDelegate b = null;
    public final /* synthetic */ IObricPersonalContextSettingApi a;

    static {
        b = new ObricPersonalContextSettingApiDelegate();
    }

    public final Object a() {
        return this.a.a();
    }

    public final void b(long r2) {
        this.a.b(r2);
    }

    public final boolean c() {
        return this.a.c();
    }

    public final Object d(String r2, boolean r3, Continuation<? super Boolean> r4) {
        return this.a.d(r2, r3, r4);
    }

    public final long e() {
        return this.a.e();
    }

    public final d1 f() {
        return this.a.f();
    }

    public final void g() {
        this.a.g();
    }

    public final Class<? extends Activity> h() {
        return this.a.h();
    }

    public final boolean i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter("reference_memory", "key");
        return this.a.i("reference_memory", false);
    }

    public final boolean j(ToggleName r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        return this.a.j(r2, r3);
    }

    public final LiveData<Pair<Boolean, List<SelectableToggleItem>>> k(FragmentActivity r2, List<SelectableToggleItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "toggleList");
        return this.a.k(r2, r3);
    }

    public final boolean l(ToggleName r2) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        return this.a.l(r2);
    }

    public final void m(boolean r2) {
        this.a.m(r2);
    }

    public final void n(ToggleName r2) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        this.a.n(r2);
    }

    public final boolean o(ToggleName r2) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        return this.a.o(r2);
    }

    public final void p(ToggleName r2) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        this.a.p(r2);
    }

    public final boolean q() {
        return this.a.q();
    }

    public final Object r(Continuation<? super Boolean> r2) {
        return this.a.r(r2);
    }

    public final String s(ToggleName r2) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        return this.a.s(r2);
    }

    public final boolean t() {
        return this.a.t();
    }

    public final void u() {
        this.a.u();
    }

    private ObricPersonalContextSettingApiDelegate() {
        this.a = (IObricPersonalContextSettingApi) ServiceManager.get().getService(IObricPersonalContextSettingApi.class);
    }
}
