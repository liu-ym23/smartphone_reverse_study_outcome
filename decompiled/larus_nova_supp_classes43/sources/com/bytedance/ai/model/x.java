package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.model.objects.LLMData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class x implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ h5.g b;
    public final /* synthetic */ Function3 c;
    public final /* synthetic */ com.bytedance.ai.utils.j.a d;
    public final /* synthetic */ LLMData e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ long g;

    public /* synthetic */ x(String r1, h5.g r10, com.bytedance.applet.event.c r11, com.bytedance.ai.utils.j.a r12, LLMData r13, long r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = null;
        this.g = r14;
    }

    public final Object invoke() {
        final String r10 = this.a;
        h5.g r1 = this.b;
        final Function3 r11 = this.c;
        final com.bytedance.ai.utils.j.a r12 = this.d;
        final LLMData r13 = this.e;
        final Context r14 = this.f;
        final long r15 = this.g;
        AppletRuntimeManager.o(AppletRuntimeManager.INSTANCE, r10, r1.c, r1.d, r1.b, r1.f, null, new c0(r10, r11, r12, r13, r14, r15), 32);
        return Unit.INSTANCE;
    }
}
