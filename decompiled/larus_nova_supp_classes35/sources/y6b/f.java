package y6b;

import com.ss.android.lark.biz.im.api.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements y28.b<f>, n0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final CharSequence e;
    public final int f;

    public static final class a extends n0.a {
        public a() {
        }
    }

    public final String a() {
        return this.d;
    }

    public final int b() {
        return this.f;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final CharSequence getMessageContent() {
        return this.e;
    }

    public final String getMessageId() {
        return this.a;
    }

    public f(a r2) {
        this.a = ((n0.a) r2).a;
        this.b = ((n0.a) r2).b;
        this.c = ((n0.a) r2).c;
        this.d = ((n0.a) r2).d;
        this.e = ((n0.a) r2).e;
        this.f = ((n0.a) r2).f;
    }

    public final boolean isContentSame(y28.b r4) {
        f r5 = (f) r4;
        String r0 = this.a;
        CharSequence r1 = null;
        if (r5 == null) goto L5;
        String r2 = r5.a;
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L14;
        CharSequence r3 = this.e;
        if (r5 == null) goto L12;
        r1 = r5.e;
    L12:
        if (Intrinsics.areEqual(r3, r1) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public final /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        f r2 = (f) r1;
        return true;
    }
}
