package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AddressSDK$startUpdateCycle$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $curBtm;
    final /* synthetic */ Function1 $onLocateSuccess;

    public AddressSDK$startUpdateCycle$1(String r1, Function1 r10) {
        this.$curBtm = r1;
        this.$onLocateSuccess = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1139invoke() {
        w r0 = AddressSDK.a;
        String r1 = this.$curBtm;
        Function1 r10 = this.$onLocateSuccess;
        w r11 = AddressSDK.a;
        boolean r12 = false;
        boolean r13 = true;
        if (r11.b.c == null) goto L5;
        boolean r14 = AddressSDK.r();
        AddressSDKLog.a("start update cycle: isLocationEnabled=" + r14, false);
        if (r14 == true) goto L18;
        if (r11.b.b < z.j()) goto L13;
        r13 = false;
    L13:
        if (r13 == true) goto L15;
        return;
    L15:
        if (r11.c.c != null) goto L44;
        AddressSDK.h("", null, false, null, 30);
        return;
    L44:
        return;
    L18:
        if (ECSettingKeys.i() == false) goto L23;
        Set<String> r15 = r11.g.d().a();
        if (r15 != null) goto L22;
    L24:
        if (r12 == false) goto L26;
        String r16 = "bpea-ecom_address_sdk_trylocate";
    L27:
        if (r12 == false) goto L29;
        String r17 = "wwac";
    L30:
        m r18 = new m(r12, r1, r10);
        if (r12 == false) goto L35;
        wi.c r19 = AddressSDK.m();
        if (r19 == null) goto L46;
        r19.d(r16, r17, r18);
        return;
    L46:
        return;
    L35:
        wi.c r20 = AddressSDK.m();
        if (r20 == null) goto L48;
        wi.a r21 = r20.h(r16, r17);
        if (r21 == null) goto L49;
        r18.a(r21);
        return;
    L49:
        return;
    L48:
        return;
    L29:
        r17 = "auom";
        goto L30
    L26:
        r16 = "bpea-ecom_address_sdk_trylocate_only_cache";
        goto L27
    L22:
        if (CollectionsKt.contains(r15, r1) != true) goto L24;
    L23:
        r12 = true;
        goto L24
    L5:
        if ((!Intrinsics.areEqual(AddressSDK.h, Boolean.FALSE)) == false) goto L41;
        AddressSDK.h("refresh", null, false, null, 30);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1139invoke();
        return Unit.INSTANCE;
    }
}
