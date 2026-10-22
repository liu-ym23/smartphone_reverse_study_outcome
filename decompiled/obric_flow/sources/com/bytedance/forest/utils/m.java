package com.bytedance.forest.utils;

import android.util.LruCache;
import com.lynx.tasm.ui.image.f0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class m extends LruCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4651b;

    public m(n r5, int r10) {
        this.f4650a = 0;
        this.f4651b = r5;
        super(r10);
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r5, Object r10, Object r11, Object r12) {
        switch(this.f4650a) {
            case 0: goto L21;
            case 1: goto L15;
            default: goto L4;
        };
    L4:
        String r13 = (String) r10;
        if (r11 != null) goto L14;
        if (r12 != null) goto L12;
        super.entryRemoved(r5, r13, null, null);
        StringBuilder r14 = new StringBuilder("移除缓存 ");
        String r15 = (String) this.f4651b;
        r14.append(r15);
        r14.append(", size ");
        r14.append(size());
        r14.append(", maxSize ");
        r14.append(maxSize());
        r14.append(", key ");
        r14.append(r13);
        com.bytedance.ies.bullet.base.utils.b.m(r14.toString());
        if (StringsKt.g(r15, "重定向") == true) goto L32;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPreload", "移除对象 size null", null, 12);
        return;
    L32:
        return;
    L12:
        throw new ClassCastException();
    L14:
        throw new ClassCastException();
    L15:
        com.bytedance.ies.bullet.service.base.e r16 = (com.bytedance.ies.bullet.service.base.e) r11;
        super.entryRemoved(r5, (String) r10, r16, (com.bytedance.ies.bullet.service.base.e) r12);
        if (r5 == false) goto L19;
        if (r16 == null) goto L19;
        r16.f5986c.release();
    L19:
        ((ug.e) this.f4651b).getClass();
        return;
    L21:
        a r17 = (a) r10;
        h r18 = (h) r11;
        super.entryRemoved(r5, r17, r18, (h) r12);
        if (r18 == null) goto L26;
        f r19 = r18.f4627c;
        if (r19 == null) goto L26;
        r19.close();
    L26:
        StringBuilder r20 = new StringBuilder("[");
        r20.append(((n) this.f4651b).f4653b);
        r20.append(']');
        if (r5 == false) goto L29;
        String r21 = "evicted";
    L30:
        r20.append(r21);
        r20.append(' ');
        r20.append(r18);
        r20.append(", key=");
        r20.append(r17);
        f0.h("MemoryManager", 60, r20.toString(), false);
        return;
    L29:
        r21 = "remove";
        goto L30
    }

    @Override // android.util.LruCache
    public int sizeOf(Object r5, Object r10) {
        switch(this.f4650a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        a r11 = (a) r5;
        h r12 = (h) r10;
        if (r12 != null) goto L11;
        return 1;
    L11:
        return r12.f4626b;
    L5:
        return super.sizeOf(r5, r10);
    }

    public m(String r5, int r10) {
        this.f4650a = 2;
        Intrinsics.checkNotNullParameter(r5, "name");
        super(r10);
        this.f4651b = r5;
    }

    public m(ug.e r5) {
        this.f4650a = 1;
        this.f4651b = r5;
        super(3);
    }
}
