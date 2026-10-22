package com.bytedance.ies.abmock.datacenter.event;

import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ABMockEvent$sdkInit$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $endTime;
    final /* synthetic */ Ref.ObjectRef<String> $errorMessage;
    final /* synthetic */ Ref.IntRef $initCode;
    final /* synthetic */ Ref.IntRef $sdkInitType;
    final /* synthetic */ long $startTime;
    final /* synthetic */ a this$0;

    ABMockEvent$sdkInit$2(a r1, long r2, long r4, Ref.IntRef r6, Ref.IntRef r7, Ref.ObjectRef<String> r8) {
        this.this$0 = r1;
        this.$endTime = r2;
        this.$startTime = r4;
        this.$initCode = r6;
        this.$sdkInitType = r7;
        this.$errorMessage = r8;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Keva r0 = a.b(this.this$0);
        if (r0 == null) goto L5;
        r0.storeLong(a.c(this.this$0), (this.$endTime - this.$startTime) / ((long) 1000));
    L5:
        Keva r1 = a.b(this.this$0);
        if (r1 == null) goto L8;
        r1.storeInt(a.d(this.this$0), this.$initCode.element);
    L8:
        Keva r2 = a.b(this.this$0);
        if (r2 == null) goto L11;
        r2.storeInt(a.e(this.this$0), this.$sdkInitType.element);
    L11:
        Keva r3 = a.b(this.this$0);
        if (r3 == null) goto L15;
        r3.storeString(a.f(this.this$0), (String) ZeusTransformUtils.preCheckCast(this.$errorMessage.element, String.class, "com.obric.memorydata.plugin"));
        return;
    }
}
