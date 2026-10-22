package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.data.FlowSettingsScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ List a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ FlowSettingsScene c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Function1 e;

    public /* synthetic */ e(List r1, FragmentActivity r2, FlowSettingsScene r3, int r4, Function1 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r7) {
        List r0 = this.a;
        FragmentActivity r1 = this.b;
        FlowSettingsScene r2 = this.c;
        int r3 = this.d;
        Function1 r4 = this.e;
        List r8 = (List) r7;
        Intrinsics.checkNotNullParameter(r8, "sections");
        r0.add(r8);
        h r9 = h.a;
        h.b(r1, r2, r3 + 1, r0, r4);
        return Unit.INSTANCE;
    }
}
