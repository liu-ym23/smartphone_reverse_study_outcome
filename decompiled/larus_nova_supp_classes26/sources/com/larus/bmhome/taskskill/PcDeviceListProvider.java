package com.larus.bmhome.taskskill;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcDeviceListProvider implements com.larus.bmhome.taskskill.service.d {
    public final MutableLiveData<bs8.e> a;
    public boolean b;
    public final g c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final bs8.e b() {
        GetAllDevicesRepo r0 = GetAllDevicesRepo.a;
        AllDeviceResponse r1 = GetAllDevicesRepo.d();
        if (r1 != null) goto L7;
        return null;
    L7:
        return g(r1.getDevices());
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final void e() {
        if (this.b == true) goto L5;
        return;
    L5:
        GetAllDevicesRepo.o.removeObserver(this.c);
        this.b = false;
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final void f() {
        if (this.b == false) goto L5;
        return;
    L5:
        GetAllDevicesRepo r0 = GetAllDevicesRepo.a;
        GetAllDevicesRepo.g();
        GetAllDevicesRepo.o.observeForever(this.c);
        this.b = true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.taskskill.g] */
    public PcDeviceListProvider() {
        this.a = new MutableLiveData();
        this.c = new g(this);
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final MutableLiveData<bs8.e> d() {
        return this.a;
    }

    public static bs8.e g(List r2) {
        Pair r3 = com.larus.dispatcher.api.d.a(r2);
        List r0 = (List) r3.component1();
        List r4 = (List) r3.component2();
        return new bs8.e(CollectionsKt.filterNotNull(r0), CollectionsKt.filterNotNull(r4));
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final Object a(Continuation<? super bs8.f> r6) {
        if ((r6 instanceof PcDeviceListProvider$loadDevices$1) == false) goto L7;
        PcDeviceListProvider$loadDevices$1 r0 = (PcDeviceListProvider$loadDevices$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        bs8.e r4 = (bs8.e) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L21:
        AllDeviceResponse r8 = (AllDeviceResponse) r7;
        if (r8 == null) goto L24;
        bs8.e r9 = g(r8.getDevices());
        this.a.postValue(r9);
        return new bs8.f(r9, true);
    L24:
        return new bs8.f(r4, false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        bs8.e r10 = b();
        if (r10 == null) goto L17;
        this.a.postValue(r10);
    L17:
        GetAllDevicesRepo r5 = GetAllDevicesRepo.a;
        r0.L$0 = r10;
        r0.label = 1;
        Object r11 = GetAllDevicesRepo.e("PcDeviceListProvider", r0);
        if (r11 != r2) goto L20;
        return r2;
    L20:
        r4 = r10;
        r7 = r11;
    L7:
        r0 = new PcDeviceListProvider$loadDevices$1(this, r6);
        goto L8
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final void c(PcDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        GetAllDevicesRepo r0 = GetAllDevicesRepo.a;
        Intrinsics.checkNotNullParameter(r8, "targetDevice");
        AllDeviceResponse r1 = GetAllDevicesRepo.b;
        if (r1 == null) goto L27;
        String r2 = r8.getDeviceId();
        if (r2 == null) goto L28;
        List r3 = r1.getDevices();
        ArrayList r4 = null;
        if (r3 == null) goto L22;
        List r5 = r3;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L21;
        PcDevice r9 = (PcDevice) r7.next();
        if (r9 == null) goto L16;
        String r10 = r9.getDeviceId();
    L18:
        if (Intrinsics.areEqual(r10, r2) == false) goto L20;
        r9 = r8;
    L20:
        r6.add(r9);
        goto L12
    L16:
        r10 = null;
        goto L18
    L21:
        r4 = r6;
    L22:
        GetAllDevicesRepo.j(r1.copy(r4));
        return;
    L28:
        return;
    }
}
