package gb8;

import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends jc8.a implements g {
    @Override // jc8.a
    public final String g() {
        return "DeepThinkBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.A;
    }

    @Override // gb8.g
    public final boolean b(boolean r4) {
        if (r4 == false) goto L16;
        if (com.larus.im.bean.message.a.f0(j()) == true) goto L7;
    L13:
        return false;
    L7:
        if (this.a.isFinish() == true) goto L13;
        if (j().getMessageStatusLocal() == 23) goto L13;
        if (com.larus.im.bean.message.a.w0(j()) == false) goto L13;
        return true;
    L16:
        if (com.larus.im.bean.message.a.f0(j()) == true) goto L18;
    L24:
        return false;
    L18:
        if (this.a.isFinish() == true) goto L24;
        if (j().getMessageStatusLocal() == 23) goto L24;
        if (com.larus.bmhome.chat.bean.d.f0(j()) == false) goto L24;
        return true;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r7) {
        if ((r7 instanceof b) == true) goto L5;
        return false;
    L5:
        b r8 = (b) r7;
        if (this.a.hashCode() == r8.a.hashCode()) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L13;
        return false;
    L13:
        int r1 = i().size();
        int r2 = 0;
    L14:
        if (r2 >= r1) goto L19;
        if (((jc8.a) ListProtector.get(i(), r2)).hashCode() != ((jc8.a) ListProtector.get(r8.i(), r2)).hashCode()) goto L17;
        r2 = r2 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        if (i().size() != r8.i().size()) goto L10;
        r8.getClass();
        r0 = true;
        goto L11
    }
}
