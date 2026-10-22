package com.larus.dora.impl.ota.g2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AndroidG2OtaRuntime$startLocked$1 implements o$a {
    final /* synthetic */ q.l $effect;
    final /* synthetic */ Function1<s, Unit> $emit;
    final /* synthetic */ AndroidG2OtaRuntime$c $key;
    final /* synthetic */ AndroidG2OtaRuntime$b $session;
    final /* synthetic */ AndroidG2OtaRuntime this$0;

    @Override // com.larus.dora.impl.ota.g2.o$a
    public final void c() {
        if (AndroidG2OtaRuntime.e(this.this$0).remove(this.$key, this.$session) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(AndroidG2OtaRuntime.f(this.this$0), null, null, new AndroidG2OtaRuntime$startLocked$1$succeeded$1(this.this$0, this.$effect, this.$emit, this.$session, null), 3, null);
    }

    @Override // com.larus.dora.impl.ota.g2.o$a
    public final void z() {
        if (AndroidG2OtaRuntime.e(this.this$0).remove(this.$key, this.$session) == true) goto L5;
        return;
    L5:
        this.$emit.invoke(new s$g(this.$effect.a(), this.$effect.c(), this.$session.d(), ((Number) AndroidG2OtaRuntime.d(this.this$0).invoke()).longValue()));
    }

    @Override // com.larus.dora.impl.ota.g2.o$a
    public final void a(boolean r8) {
        if (AndroidG2OtaRuntime.e(this.this$0).remove(this.$key, this.$session) == true) goto L5;
        return;
    L5:
        AndroidG2OtaRuntime r1 = this.this$0;
        e r2 = this.$effect.a();
        long r3 = this.$effect.c();
        if (r8 == false) goto L8;
        FailureReason r9 = FailureReason.DOWNLOAD_NETWORK_UNAVAILABLE;
    L9:
        AndroidG2OtaRuntime.k(r1, r2, r3, r9, this.$emit);
        return;
    L8:
        r9 = FailureReason.DOWNLOAD_FAILED;
        goto L9
    }

    @Override // com.larus.dora.impl.ota.g2.o$a
    public final void b(long r11) {
        if (AndroidG2OtaRuntime.e(this.this$0).get(this.$key) == this.$session) goto L5;
        return;
    L5:
        int r4 = 0;
        if (this.$effect.d().h().e() <= 0) goto L9;
        r4 = RangesKt.coerceIn((int) ((((long) 100) * r11) / this.$effect.d().h().e()), 0, 100);
    L9:
        if (r4 == this.$session.c()) goto L11;
    L13:
        this.$session.g(r4);
        this.$session.f(r11);
        this.$emit.invoke(new s$i(this.$effect.a(), this.$effect.c(), r11, ((Number) AndroidG2OtaRuntime.d(this.this$0).invoke()).longValue()));
        return;
    L11:
        if ((r11 - this.$session.b()) >= j0.G2_OTA_SPACE_CHECK_BYTES) goto L13;
    }

    public AndroidG2OtaRuntime$startLocked$1(AndroidG2OtaRuntime r1, AndroidG2OtaRuntime$c r2, AndroidG2OtaRuntime$b r3, q.l r4, Function1<? super s, Unit> r5) {
        this.this$0 = r1;
        this.$key = r2;
        this.$session = r3;
        this.$effect = r4;
        this.$emit = r5;
    }
}
