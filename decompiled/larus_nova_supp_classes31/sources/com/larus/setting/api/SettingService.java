package com.larus.setting.api;

import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.trace.ISettingTrackApi;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016JJ\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J \u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010)\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u00061"}, d2 = {"Lcom/larus/setting/api/SettingService;", "Lcom/larus/setting/api/ISettingApi;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/setting/api/ISettingApi;", "impl$delegate", "Lkotlin/Lazy;", "getSettingTrackImpl", "Lcom/larus/setting/api/trace/ISettingTrackApi;", "openChangeAppIconPage", "", "context", "Landroid/content/Context;", "enterFrom", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "localConversationId", "conversationId", "previousPage", "pendingDeeplinkSchema", "setEnableShowSynDialog", "enable", "", "preloadAppDynamicIcons", "initRegisterAppBackGroundListener", "setEnableBackGroundUpdate", "enableBackGroundUpdate", "getFindSettingsItemList", "", "Lcom/larus/setting/api/data/SettingsSection;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotifySettingItems", "isAppNotifyEnable", "application", "Landroid/app/Application;", "isAppNotifyDetailEnable", "jumpPrivacyModelTrainingPage", "bindManualCacheCleanEntry", "fragment", "Landroidx/fragment/app/Fragment;", "entryView", "Landroid/view/View;", "currentPage", "trackNode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SettingService implements ISettingApi {
    public static final SettingService a = null;
    public static final Lazy b = null;

    private SettingService() {
    }

    static {
        a = new SettingService();
        b = LazyKt.lazy(new v());
    }

    public static ISettingApi l() {
        return (ISettingApi) b.getValue();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final ISettingTrackApi f() {
        ISettingApi r0 = l();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void g() {
        ISettingApi r0 = l();
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void i() {
        ISettingApi r0 = l();
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void k() {
        ISettingApi r0 = l();
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final List<zs9.c> a(FragmentActivity r2) {
        ISettingApi r0 = l();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final boolean e(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        ISettingApi r0 = l();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.e(r2);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final boolean h(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        ISettingApi r0 = l();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.h(r2);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void j(Context r2) {
        ISettingApi r0 = l();
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final Object d(FragmentActivity r2, Continuation<? super List<zs9.c>> r3) {
        ISettingApi r0 = l();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.d(r2, r3);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void c(Fragment r3, View r4, String r5, by7.e r6) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r5, "currentPage");
        ISettingApi r0 = l();
        if (r0 != null) goto L12;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
        return;
    L14:
        return;
    L12:
        r0.c(r3, r4, r5, r6);     // Catch: AbstractMethodError -> L9
        return;
    L9:
        if (r4 == null) goto L15;
        r4.setVisibility(8);
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void b(Context r10, String r11, by7.e r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        ISettingApi r1 = l();
        if (r1 == null) goto L6;
        r1.b(r10, r11, r12, r13, r14, r15, r16);
        return;
    }
}
