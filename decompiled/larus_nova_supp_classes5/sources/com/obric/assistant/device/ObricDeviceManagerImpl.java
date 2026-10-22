package com.obric.assistant.device;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricSettingsApi;
import com.obric.assistant.utils.j;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/device/ObricDeviceManagerImpl;", "Lcom/obric/assistant/device/IObricDeviceManager;", "<init>", "()V", "onLogin", "", "onLogout", "generate", "", "getUuid", "saveUuid", "did", "generate17BitRandomStrSecure", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDeviceManagerImpl implements IObricDeviceManager {
    static {
    }

    public ObricDeviceManagerImpl() {
    }

    public final synchronized void b() {
        monitor-enter(this);
        FLogger.a.i("ObricDeviceManagerImpl", "onLogout");     // Catch: Throwable -> L8
        IObricSettingsApi r0 = (IObricSettingsApi) ServiceManager.get().getService(IObricSettingsApi.class);     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.b1();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static String c() {
        FLogger.a.i("ObricDeviceManagerImpl", "generating.............");
        String r0 = String.valueOf(System.currentTimeMillis());
        List r1 = CollectionsKt.plus(CollectionsKt.plus(new CharRange('A', 'Z'), new CharRange('a', 'z')), new CharRange('0', '9'));
        SecureRandom r2 = new SecureRandom();
        IntRange r3 = new IntRange(1, 5);
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<Integer> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        ((IntIterator) r4).nextInt();
        r6.add(Character.valueOf(((Character) ListProtector.get(r1, r2.nextInt(r1.size()))).charValue()));
        goto L4
    L7:
        return r0 + CollectionsKt.joinToString$default(r6, "", null, null, 0, null, null, 62, null);
    }

    public final synchronized void a() {
        monitor-enter(this);
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L20
        r1.i("ObricDeviceManagerImpl", "onLogin....");     // Catch: Throwable -> L20
        IObricSettingsApi r2 = (IObricSettingsApi) ServiceManager.get().getService(IObricSettingsApi.class);     // Catch: Throwable -> L20
        if (r2 == null) goto L8;
        String r3 = r2.w0();     // Catch: Throwable -> L20
        if (r3 == null) goto L8;
    L9:
        r1.i("ObricDeviceManagerImpl", "onLogin uuid : " + j.d(r3));     // Catch: Throwable -> L20
        if (r3.length() <= 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L17;
        r1.i("ObricDeviceManagerImpl", "onLogin not empty , just return , do not re-generate");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L17:
        d(c());     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L12:
        r0 = false;
    L8:
        r3 = "";
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized String getUuid() {
        monitor-enter(this);
        IObricSettingsApi r3 = (IObricSettingsApi) ServiceManager.get().getService(IObricSettingsApi.class);     // Catch: Throwable -> L25
        if (r3 == null) goto L8;
        String r4 = r3.w0();     // Catch: Throwable -> L25
        if (r4 == null) goto L8;
    L9:
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L25
        r5.i("ObricDeviceManagerImpl", "getUuid uuid length " + r4.length());     // Catch: Throwable -> L25
        if (r4.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L18;
        r5.i("ObricDeviceManagerImpl", "getUuid A ---> " + j.d(r4));     // Catch: Throwable -> L25
        monitor-exit(this);
        return r4;
    L18:
        if (ILoginService.a.getAccountInfo().a == true) goto L22;
        r5.i("ObricDeviceManagerImpl", "getUuid empty caused by not login");     // Catch: Throwable -> L25
        monitor-exit(this);
        return "";
    L22:
        String r1 = c();     // Catch: Throwable -> L25
        d(r1);     // Catch: Throwable -> L25
        r5.i("ObricDeviceManagerImpl", "getUuid B with brand-new generated  --> " + j.d(r1));     // Catch: Throwable -> L25
        monitor-exit(this);
        return r1;
    L12:
        r2 = false;
    L8:
        r4 = "";
    L25:
        th = move-exception;
        throw th;
    }

    public static void d(String r3) {
        FLogger.a.i("ObricDeviceManagerImpl", "saveUuid ....to DB " + j.d(r3));
        IObricSettingsApi r0 = (IObricSettingsApi) ServiceManager.get().getService(IObricSettingsApi.class);
        if (r0 == null) goto L6;
        r0.M0(r3);
        return;
    }
}
