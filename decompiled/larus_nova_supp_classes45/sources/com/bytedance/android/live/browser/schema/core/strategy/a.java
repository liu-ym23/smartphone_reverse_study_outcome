package com.bytedance.android.live.browser.schema.core.strategy;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends c {
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;
    public final String h;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.strategy.a$a, reason: collision with other inner class name */
    public static final class C0133a implements c.b {
        public final String a;

        public C0133a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appVersion");
            this.a = r2;
        }

        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            return new a(r4.optInt("rule", -1), r4.optString("targetValue"), this.a);
        }
    }

    public static Triple b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "version");
        List r8 = StringsKt.split$default(r7, new String[]{"."}, false, 0, 6, null);
        if (r8.size() == 3) goto L7;
        return new Triple(-1, -1, -1);
    L7:
        return new Triple(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r8, 0))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r8, 1))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r8, 2))));
    }

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "currentState");
        if (this.f == (-1)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L55;
        if (this.g.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L53;
        r6.put("current_version", this.h);
        if (this.b != (-1)) goto L15;
    L51:
        return false;
    L15:
        if (this.c == (-1)) goto L51;
        if (this.d == (-1)) goto L51;
        Triple r7 = b(this.g);
        int r2 = ((Number) r7.component1()).intValue();
        int r3 = ((Number) r7.component2()).intValue();
        int r8 = (((Number) r7.component3()).intValue() + (r3 * 1000)) + (r2 * 1000000);
        int r4 = this.f;
        if (r4 == 0) goto L47;
        if (r4 == 1) goto L44;
        if (r4 == 2) goto L41;
        if (r4 == 3) goto L38;
        if (r4 == 4) goto L35;
        if (r4 == 5) goto L32;
    L49:
        return false;
    L32:
        if (this.e == r8) goto L49;
        return true;
    L35:
        if ((this.e - r8) > 0) goto L49;
        return true;
    L38:
        if ((this.e - r8) < 0) goto L49;
        return true;
    L41:
        if ((this.e - r8) >= 0) goto L49;
        return true;
    L44:
        if ((this.e - r8) <= 0) goto L49;
        return true;
    L47:
        if (this.e != r8) goto L49;
        return true;
    L53:
        throw new IllegalStateException("targetValue not exists, please check config".toString());
    L10:
        r1 = false;
        goto L11
    L55:
        throw new IllegalStateException("rule value not exists, please check config".toString());
    L5:
        r0 = false;
        goto L6
    }

    public a(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "version");
        Intrinsics.checkNotNullParameter(r4, "appVersion");
        super(1);
        this.f = r2;
        this.g = r3;
        this.h = r4;
        Triple r5 = b(r4);
        int r6 = ((Number) r5.component1()).intValue();
        int r7 = ((Number) r5.component2()).intValue();
        int r8 = ((Number) r5.component3()).intValue();
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = (r8 + (r7 * 1000)) + (r6 * 1000000);
    }
}
