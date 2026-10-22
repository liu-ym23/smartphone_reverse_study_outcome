package eab;

import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownAtUser;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends v7b.a {
    public final String j;
    public final Map<String, ImageSetV2> k;
    public final List<Long> l;
    public final boolean m;
    public final Map<String, MarkdownAtUser> n;

    public e() {
        this(BuildConfig.FLAVOR, null, null, false, null);
    }

    @Override // v7b.s
    public final s h() {
        return new e(this.j, this.k, this.l, this.m, this.n);
    }

    public final int hashCode() {
        int r0 = this.j.hashCode() * 31;
        Map<String, ImageSetV2> r1 = this.k;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L9:
        int r4 = (r0 + r3) * 31;
        List<Long> r5 = this.l;
        if (r5 == null) goto L12;
        int r6 = r5.hashCode();
    L13:
        int r7 = (r4 + r6) * 31;
        if (this.m == false) goto L16;
        int r8 = 1231;
    L17:
        int r9 = (r7 + r8) * 31;
        Map<String, MarkdownAtUser> r10 = this.n;
        if (r10 == null) goto L21;
        r2 = r10.hashCode();
    L21:
        return r9 + r2;
    L16:
        r8 = 1237;
        goto L17
    L12:
        r6 = 0;
        goto L13
    L5:
        Iterator<Map.Entry<String, ImageSetV2>> r11 = r1.entrySet().iterator();
        r3 = 0;
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, ImageSetV2> r12 = r11.next();
        String r13 = r12.getKey();
        ImageSetV2 r14 = r12.getValue();
        int r15 = r13.hashCode();
        r3 = r3 + (Arrays.hashCode(r14.encode()) ^ r15);
        goto L7
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.j, r9.j) == false) goto L48;
        Map<String, ImageSetV2> r1 = this.k;
        Map<String, ImageSetV2> r3 = r9.k;
        if (r1 == r3) goto L39;
        if (r1 == null) goto L38;
        if (r3 == null) goto L38;
        if (r1.size() != r3.size()) goto L38;
        if (r1.isEmpty() == true) goto L39;
        Iterator<Map.Entry<String, ImageSetV2>> r2 = r1.entrySet().iterator();
    L23:
        if (r2.hasNext() == false) goto L39;
        Map.Entry<String, ImageSetV2> r4 = r2.next();
        String r5 = r4.getKey();
        ImageSetV2 r6 = r4.getValue();
        if (r3.containsKey(r5) == false) goto L36;
        ImageSetV2 r7 = r3.get(r5);
        if (r6 != r7) goto L29;
        boolean r10 = true;
    L34:
        if (r10 == false) goto L36;
        boolean r11 = true;
    L37:
        if (r11 == true) goto L23;
    L29:
        if (r6 == null) goto L33;
        if (r7 == null) goto L33;
        r10 = Arrays.equals(r6.encode(), r7.encode());
    L33:
        r10 = false;
    L36:
        r11 = false;
    L38:
        boolean r12 = false;
    L40:
        if (r12 == false) goto L48;
        if (Intrinsics.areEqual(this.l, r9.l) == false) goto L48;
        if (this.m != r9.m) goto L48;
        if (Intrinsics.areEqual(this.n, r9.n) == false) goto L48;
        return true;
    L39:
        r12 = true;
    L48:
        return false;
    }

    public e(String r2, Map<String, ImageSetV2> r3, List<Long> r4, boolean r5, Map<String, MarkdownAtUser> r6) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
    }
}
