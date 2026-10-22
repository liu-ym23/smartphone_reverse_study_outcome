package com.obric.assistant.account;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.api.ILoginService;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.home.IObricBottomTabSPIService;
import com.obric.assistant.t1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q38.a;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/account/ObricBottomTabServiceImpl;", "Lcom/obric/assistant/spi/home/IObricBottomTabSPIService;", "<init>", "()V", "resolveFallbackBottomTabKeys", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "originKeys", "resolveEnterpriseFallbackBottomTabKeys", "shouldApplyConfig", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBottomTabServiceImpl implements IObricBottomTabSPIService {
    public ObricBottomTabServiceImpl() {
    }

    public static boolean c() {
        if (b.a().b() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(t1.a.getObricBottomTabConfig().getEnable(), Boolean.TRUE) == false) goto L7;
        return true;
    }

    public final List<String> a(List<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "originKeys");
        if (c() == true) goto L5;
        return r7;
    L5:
        a r0 = ILoginService.a.getAccountInfo();
        boolean r1 = r0.a;
        if (r1 == true) goto L8;
    L11:
        if (r1 == true) goto L14;
        return r7;
    L14:
        if (Intrinsics.areEqual(t1.a.getObricBottomTabConfig().getPersonalReplaceDriveEnable(), Boolean.TRUE) == true) goto L16;
        return r7;
    L16:
        List r8 = CollectionsKt.toMutableList(r7);
        Iterator r2 = r8.iterator();
        int r3 = 0;
    L18:
        if (r2.hasNext() == false) goto L29;
        String r4 = (String) r2.next();
        if (Intrinsics.areEqual(r4, LynxResourceModule.VIDEO_TYPE) == false) goto L22;
    L25:
        boolean r5 = true;
    L26:
        if (r5 == true) goto L31;
        r3 = r3 + 1;
    L31:
        if (r3 < 0) goto L34;
        ListProtector.set(r8, r3, "drive");
    L40:
        return CollectionsKt.distinct(r8);
    L34:
        if (r8.contains("drive") == true) goto L40;
        int r6 = r8.indexOf("mine");
        if (r6 < 0) goto L38;
        ListProtector.add(r8, r6, "drive");
        goto L40
    L38:
        r8.add("drive");
        goto L40
    L22:
        if (Intrinsics.areEqual(r4, "notice") == true) goto L25;
        r5 = false;
        goto L26
    L29:
        r3 = -1;
        goto L31
    L8:
        if (r0.g == false) goto L11;
        return b(CollectionsKt.listOf(new String[]{"home_message", "mine"}));
    }

    public final List<String> b(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "originKeys");
        if (c() == true) goto L5;
        return r3;
    L5:
        a r0 = ILoginService.a.getAccountInfo();
        if (r0.a == true) goto L8;
    L19:
        return r3;
    L8:
        if (r0.g == false) goto L19;
        if (Intrinsics.areEqual(t1.a.getObricBottomTabConfig().getEnterpriseInsertDriveEnable(), Boolean.TRUE) == false) goto L19;
        if (r3.contains("drive") == true) goto L19;
        r3 = CollectionsKt.toMutableList(r3);
        int r1 = r3.indexOf("mine");
        if (r1 < 0) goto L18;
        ListProtector.add(r3, r1, "drive");
        goto L19
    L18:
        r3.add("drive");
        goto L19
    }
}
