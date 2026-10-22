package l;

/* JADX INFO: loaded from: classes.dex */
public final class f extends h {
    @Override // l.d
    public final Object g(v.a r5, float r10) {
        return Float.valueOf(l(r5, r10));
    }

    public final float k() {
        return l(b(), d());
    }

    public final float l(v.a r5, float r10) {
        Object r11 = r5.f22471b;
        if (r11 == null) goto L19;
        if (r5.f22472c == null) goto L19;
        v.c r12 = this.e;
        if (r12 == null) goto L11;
        r5.f.getClass();
        Object r13 = r5.f22472c;
        e();
        return ((Float) r12.a(r5.f22471b, r13)).floatValue();
    L11:
        if (r5.g != (-3987645.8f)) goto L13;
        r5.g = ((Float) r11).floatValue();
    L13:
        float r14 = r5.g;
        if (r5.f22473h != (-3987645.8f)) goto L17;
        r5.f22473h = ((Float) r5.f22472c).floatValue();
    L17:
        return u.e.d(r14, r5.f22473h, r10);
    L19:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
