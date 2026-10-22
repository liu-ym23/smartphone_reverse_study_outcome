package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.f;
import t51.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/f;", "invoke", "()Lt51/f;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$entrance$2 extends FunctionReferenceImpl implements Function0<f> {
    public DefaultConfig$entrance$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initDefaultEntrance", "initDefaultEntrance()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevConfigEntrance;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final f m949invoke() {
        DefaultConfig r0 = (DefaultConfig) ((CallableReference) this).receiver;
        int r1 = DefaultConfig.m;
        r0.getClass();
        f r2 = new f();
        ArrayList r3 = new ArrayList();
        h r4 = new h();
        o51.f.j r5 = o51.f.j.e;
        r4.d(r5.b);
        r4.c(r5.a);
        Unit r6 = Unit.INSTANCE;
        r3.add(r4);
        h r7 = new h();
        o51.f.b r8 = o51.f.b.e;
        r7.d(r8.b);
        r7.c(r8.a);
        r3.add(r7);
        h r9 = new h();
        o51.f.c r10 = o51.f.c.e;
        r9.d(r10.b);
        r9.c(r10.a);
        r3.add(r9);
        r2.b(r3);
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m949invoke();
    }
}
