package v7b;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class s implements com.ss.android.lark.coremd.ext.j {
    public final HashMap<Object, Object> c;
    public s d;
    public s e;
    public s f;
    public s g;
    public s h;
    public List<x> i;

    public abstract void c(f0 r1);

    public abstract s h();

    public String o() {
        return BuildConfig.FLAVOR;
    }

    public final List<x> j() {
        List<x> r0 = this.i;
        if (r0 == null) goto L6;
        return Collections.unmodifiableList(r0);
    L6:
        return Collections.emptyList();
    }

    public final void p() {
        s r0 = this.g;
        if (r0 == null) goto L5;
        r0.h = this.h;
    L8:
        s r1 = this.h;
        if (r1 == null) goto L11;
        r1.g = r0;
    L14:
        this.d = null;
        this.h = null;
        this.g = null;
        return;
    L11:
        s r2 = this.d;
        if (r2 == null) goto L14;
        r2.f = r0;
        goto L14
    L5:
        s r3 = this.d;
        if (r3 == null) goto L8;
        r3.e = this.h;
        goto L8
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + o() + "}";
    }

    public s() {
        this.c = new HashMap();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c;
    }

    public s i() {
        return this.d;
    }

    public final void e(s r2) {
        r2.p();
        r2.m(this);
        s r0 = this.f;
        if (r0 == null) goto L5;
        r0.h = r2;
        r2.g = r0;
        this.f = r2;
        return;
    L5:
        this.e = r2;
        this.f = r2;
    }

    public final void k(s r3) {
        r3.p();
        s r0 = this.h;
        r3.h = r0;
        if (r0 == null) goto L5;
        r0.g = r3;
    L5:
        r3.g = this;
        this.h = r3;
        s r1 = this.d;
        r3.d = r1;
        if (r3.h != null) goto L9;
        r1.f = r3;
        return;
    }

    public final void l(s r3) {
        r3.p();
        s r0 = this.g;
        r3.g = r0;
        if (r0 == null) goto L5;
        r0.h = r3;
    L5:
        r3.h = this;
        this.g = r3;
        s r1 = this.d;
        r3.d = r1;
        if (r3.g != null) goto L9;
        r1.e = r3;
        return;
    }

    public void m(s r1) {
        this.d = r1;
    }

    public final void n(List<x> r2) {
        if (r2.isEmpty() == false) goto L5;
        this.i = null;
        return;
    L5:
        this.i = new ArrayList(r2);
    }
}
