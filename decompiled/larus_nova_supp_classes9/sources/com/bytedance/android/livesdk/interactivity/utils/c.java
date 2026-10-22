package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c {
    public final int a;
    public final int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final DecimalFormat p;

    public abstract void b(Map<String, String> r1);

    public void d() {
    }

    public void e() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.g = 0;
        this.f = 0;
        this.h = 0;
        this.i = 0;
    }

    public c() {
        this.a = 1;
        this.b = 2;
        this.j = "_pv";
        this.k = "_arrive_delay_time";
        this.l = "_show_delay_time";
        this.m = "_pv_male";
        this.n = "_pv_female";
        this.o = "_pv_range_avg";
        DecimalFormat r0 = new DecimalFormat("0.##");
        DecimalFormatSymbols r1 = new DecimalFormatSymbols();
        r1.setDecimalSeparator('.');
        Unit r2 = Unit.INSTANCE;
        r0.setDecimalFormatSymbols(r1);
        this.p = r0;
    }

    public void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.c++;
        long r0 = this.f;
        IBaseUser r4 = r7.x();
        if (r4 == null) goto L9;
        py.d r5 = r4.getUserHonor();
        if (r5 == null) goto L9;
        int r6 = r5.getLevel();
    L10:
        this.f = r0 + ((long) r6);
        IBaseUser r1 = r7.x();
        if (r1 == null) goto L18;
        int r2 = r1.getGender();
        if (r2 != this.a) goto L16;
        this.d++;
    L16:
        if (r2 != this.b) goto L18;
        this.e++;
    L18:
        this.g += r7.o.longValue();
        this.h += r7.p.longValue();
        return;
    L9:
        r6 = 0;
        goto L10
    }

    public final float c(long r10, long r13) {
        if (r13 == 0) goto L11;
        return CastFloatProtector.parseFloat(StringsKt.replace$default(this.p.format(Float.valueOf(r10 / r13)), ",", ".", false, 4, null));
    L7:
        ALogger.e("PublicScreenStatTrack", "get avg NumberFormat error,stat:" + r10 + " , pv:" + r13);
        return 0.0f;
    L11:
        return 0.0f;
    }
}
