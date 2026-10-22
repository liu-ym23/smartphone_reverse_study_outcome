package jc8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a {
    public final Block a;
    public final Message b;
    public long c;
    public f d;
    public ra8.b e;
    public final int f;
    public final String g;
    public final List<a> h;

    public final List<a> i() {
        return CollectionsKt.toList(this.h);
    }

    public final Message j() {
        Message r0 = this.b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("This Block model was created without a legacy Message".toString());
    }

    public final a k() {
        f r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final boolean m() {
        f r0 = this.d;
        if (r0 == null) goto L5;
        a r1 = r0.a;
    L6:
        if (r1 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean n() {
        f r0 = this.d;
        if (r0 == null) goto L5;
        a r1 = r0.b;
    L6:
        if (r1 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public String g() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String h() {
        return this.g;
    }

    public int l() {
        return this.f;
    }

    public boolean e(a r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.a.hashCode() != r3.a.hashCode()) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean f(a r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        long r1 = this.c;
        if (r1 <= 0) goto L11;
        if (r9.c > 0) goto L11;
        r9.c = r1;
    L11:
        if (getClass() == r9.getClass()) goto L13;
        return false;
    L13:
        if (l() == r9.l()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.a.getBlockId(), r9.a.getBlockId()) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public a(Block r10, Message r11) {
        Intrinsics.checkNotNullParameter(r10, "block");
        this.a = r10;
        this.b = r11;
        this.e = new ra8.b(null, null, null, false, null, null, 127);
        this.f = r10.getBlockType();
        String r12 = r10.getBlockId();
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        this.g = r12;
        this.h = new ArrayList();
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        this(r3, r2);
    }
}
