package com.obric.assistant.settings;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.settings.memory.ObricPersonalContextSettingActivity;
import com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity;
import com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/ObricRouteServiceImpl;", "Lcom/obric/assistant/settings/IObricSettingRouteService;", "<init>", "()V", "jumpObricSettingPage", "", "context", "Landroid/content/Context;", "themeSource", "", "markJumpObricSettingIfAllowed", "", "jumpMemorySettingPage", "jumpGlobalMemoryDataPage", "jumpVoicePrintManagementPage", "previousPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRouteServiceImpl implements IObricSettingRouteService {
    public static final AtomicLong a = null;

    public static final class a {
    }

    public ObricRouteServiceImpl() {
    }

    static {
        a = new AtomicLong(0);
    }

    @Override // com.obric.assistant.settings.IObricSettingRouteService
    public final void b(Context r6) {
        Intrinsics.checkNotNullParameter("system", "themeSource");
        if ((r6 instanceof Activity) == false) goto L5;
        Activity r7 = (Activity) r6;
    L7:
        if (r7 == null) goto L9;
        Intent r2 = new Intent(r7, ObricPersonalContextSettingActivity.class);
        r2.putExtra("theme_source", "system");
        r7.startActivity(r2);
        return;
    L9:
        AppHost.Companion r8 = AppHost.a;
        Application r3 = r8.getApplication();
        Intent r4 = new Intent(r8.getApplication(), ObricPersonalContextSettingActivity.class);
        r4.putExtra("theme_source", "system");
        r4.addFlags(268435456);
        r3.startActivity(r4);
        return;
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.obric.assistant.settings.IObricSettingRouteService
    public final void c(Context r14) {
        Intrinsics.checkNotNullParameter("system", "themeSource");
        long r2 = SystemClock.elapsedRealtime();
        AtomicLong r0 = a;
        long r4 = r0.get();
        if (r4 != 0) goto L5;
    L7:
        boolean r1 = r0.compareAndSet(r4, r2);
    L8:
        if (r1 == true) goto L28;
        return;
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        if ((r14 instanceof Activity) == false) goto L14;
        Activity r15 = (Activity) r14;     // Catch: Throwable -> L21
    L16:
        if (r15 == null) goto L18;
        Intent r5 = new Intent(r15, ObricSettingActivity.class);     // Catch: Throwable -> L21
        r5.putExtra("theme_source", "system");     // Catch: Throwable -> L21
        r5.addFlags(603979776);     // Catch: Throwable -> L21
        r15.startActivity(r5);     // Catch: Throwable -> L21
    L19:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L26;
        return;
    L26:
        a.set(0);
        throw r17;
    L18:
        AppHost.Companion r18 = AppHost.a;     // Catch: Throwable -> L21
        Application r6 = r18.getApplication();     // Catch: Throwable -> L21
        Intent r7 = new Intent(r18.getApplication(), ObricSettingActivity.class);     // Catch: Throwable -> L21
        r7.putExtra("theme_source", "system");     // Catch: Throwable -> L21
        r7.addFlags(872415232);     // Catch: Throwable -> L21
        r6.startActivity(r7);     // Catch: Throwable -> L21
        goto L19
    L14:
        r15 = null;
    L21:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L5:
        if ((r2 - r4) >= ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS) goto L7;
        r1 = false;
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricSettingRouteService
    public final void d(Context r4) {
        if ((r4 instanceof Activity) == false) goto L5;
        Activity r5 = (Activity) r4;
    L6:
        if (r5 == null) goto L8;
        r5.startActivity(new Intent(r5, MemoryListActivity.class));
        return;
    L8:
        AppHost.Companion r6 = AppHost.a;
        Application r0 = r6.getApplication();
        Intent r1 = new Intent(r6.getApplication(), MemoryListActivity.class);
        r1.addFlags(268435456);
        r0.startActivity(r1);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.obric.assistant.settings.IObricSettingRouteService
    public final void a(Context r7, String r8) {
        Intrinsics.checkNotNullParameter("system", "themeSource");
        if ((r7 instanceof Activity) == false) goto L5;
        Activity r9 = (Activity) r7;
    L7:
        if (r9 == null) goto L12;
        Intent r3 = new Intent(r9, ObricVoicePrintManagementActivity.class);
        r3.putExtra("theme_source", "system");
        if (r8 == null) goto L11;
        r3.putExtra("previous_page", r8);
    L11:
        r9.startActivity(r3);
        return;
    L12:
        AppHost.Companion r10 = AppHost.a;
        Application r4 = r10.getApplication();
        Intent r5 = new Intent(r10.getApplication(), ObricVoicePrintManagementActivity.class);
        r5.addFlags(268435456);
        r5.putExtra("theme_source", "system");
        if (r8 == null) goto L15;
        r5.putExtra("previous_page", r8);
    L15:
        r4.startActivity(r5);
        return;
    L5:
        r9 = null;
        goto L7
    }
}
