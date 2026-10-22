package com.loc;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class dv implements Serializable {
    public String a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public dv() {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = true;
    }

    public dv(boolean r3, boolean r4) {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = r3;
        this.i = r4;
    }

    public abstract dv a();

    public final void a(dv r3) {
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }

    public final int b() {
        return CastIntegerProtector.parseInt(this.a);
    L5:
        return 0;
    }

    public final int c() {
        return CastIntegerProtector.parseInt(this.b);
    L5:
        return 0;
    }
}
