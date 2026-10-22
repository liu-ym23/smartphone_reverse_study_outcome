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
public final class ByteContinuousLocationImpl$startLocationLegacy$$inlined$synchronized$lambda$1 extends j implements l<a.AbstractC0030a, xd.j> {
    final /* synthetic */ BDLocationCallback $callback$inlined;
    final /* synthetic */ Looper $looper$inlined;
    final /* synthetic */ LocationOption $option$inlined;
    final /* synthetic */ ByteContinuousLocationImpl this$0;

    public ByteContinuousLocationImpl$startLocationLegacy$$inlined$synchronized$lambda$1(ByteContinuousLocationImpl r8, Looper r10, LocationOption r11, BDLocationCallback r12) {
        this.this$0 = r8;
        this.$looper$inlined = r10;
        this.$option$inlined = r11;
        this.$callback$inlined = r12;
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
        if ((r8 instanceof a.AbstractC0030a.b) == false) goto L15;
        LocationOption r10 = this.$option$inlined;
        if (r10 == null) goto L7;
        r10.setEnableUploadNetSignal(false);
    L7:
        long r11 = System.currentTimeMillis();
        if ((r11 - ByteContinuousLocationImpl.access$getMLastSetUploadNetSignalTime$p(this.this$0)) < BDLocationConfig.getUploadNetSignalInterval()) goto L13;
        LocationOption r12 = this.$option$inlined;
        if (r12 == null) goto L12;
        r12.setEnableUploadNetSignal(true);
    L12:
        ByteContinuousLocationImpl.access$setMLastSetUploadNetSignalTime$p(this.this$0, r11);
    L13:
        ByteContinuousLocationImpl.access$onSuccessLegacy(this.this$0, (a.AbstractC0030a.b) r8, this.$option$inlined, this.$callback$inlined);
        return;
    L15:
        if ((r8 instanceof a.AbstractC0030a.C0031a) == false) goto L19;
        StringBuilder r13 = new StringBuilder("location error reason: ");
        a.AbstractC0030a.C0031a r14 = (a.AbstractC0030a.C0031a) r8;
        String r15 = r14.f3022a;
        r13.append(r15);
        Logger.e(r13.toString());
        ByteContinuousLocationImpl r16 = this.this$0;
        LocationOption r17 = this.$option$inlined;
        BDLocationCallback r18 = this.$callback$inlined;
        ByteContinuousLocationImpl.access$onErrorLegacy(r16, r15, r17, r14.f3023b, r18);
        return;
    }
}
