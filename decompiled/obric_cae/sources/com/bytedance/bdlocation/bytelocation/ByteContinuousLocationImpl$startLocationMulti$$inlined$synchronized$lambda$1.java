package com.bytedance.bdlocation.bytelocation;

import android.os.Looper;
import b2.a;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import ge.l;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes.dex */
public final class ByteContinuousLocationImpl$startLocationMulti$$inlined$synchronized$lambda$1 extends j implements l<a.AbstractC0030a, xd.j> {
    final /* synthetic */ String $businessId$inlined;
    final /* synthetic */ BDLocationCallback $callback$inlined;
    final /* synthetic */ Looper $looper$inlined;
    final /* synthetic */ LocationOption $option$inlined;
    final /* synthetic */ ByteContinuousLocationImpl this$0;

    public ByteContinuousLocationImpl$startLocationMulti$$inlined$synchronized$lambda$1(ByteContinuousLocationImpl r8, String r10, BDLocationCallback r11, LocationOption r12, Looper r13) {
        this.this$0 = r8;
        this.$businessId$inlined = r10;
        this.$callback$inlined = r11;
        this.$option$inlined = r12;
        this.$looper$inlined = r13;
        super(1);
    }

    @Override // ge.l
    public /* bridge */ /* synthetic */ xd.j invoke(a.AbstractC0030a r8) {
        invoke2(r8);
        return xd.j.f13877a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a.AbstractC0030a r8) {
        i.g(r8, "result");
        if ((r8 instanceof a.AbstractC0030a.b) == false) goto L17;
        LocationOption r10 = this.$option$inlined;
        if (r10 == null) goto L7;
        r10.setEnableUploadNetSignal(false);
    L7:
        long r11 = System.currentTimeMillis();
        ByteContinuousLocationImpl.ContinuousLocationContext r12 = (ByteContinuousLocationImpl.ContinuousLocationContext) ByteContinuousLocationImpl.access$getMContinuousClients$p(this.this$0).get(this.$businessId$inlined);
        if (r12 != null) goto L10;
    L15:
        ByteContinuousLocationImpl.access$onSuccessMulti(this.this$0, this.$businessId$inlined, (a.AbstractC0030a.b) r8, this.$option$inlined, this.$callback$inlined);
        return;
    L10:
        if ((r11 - r12.getLastSetUploadNetSignalTime()) < BDLocationConfig.getUploadNetSignalInterval()) goto L15;
        LocationOption r13 = this.$option$inlined;
        if (r13 == null) goto L14;
        r13.setEnableUploadNetSignal(true);
    L14:
        r12.setLastSetUploadNetSignalTime(r11);
        goto L15
    L17:
        if ((r8 instanceof a.AbstractC0030a.C0031a) == false) goto L21;
        StringBuilder r14 = new StringBuilder("location error reason: ");
        a.AbstractC0030a.C0031a r15 = (a.AbstractC0030a.C0031a) r8;
        r14.append(r15.f3022a);
        r14.append(", businessId: ");
        r14.append(this.$businessId$inlined);
        Logger.e(r14.toString());
        ByteContinuousLocationImpl.access$onErrorMulti(this.this$0, this.$businessId$inlined, r15.f3022a, this.$option$inlined, r15.f3023b, this.$callback$inlined);
        return;
    }
}
