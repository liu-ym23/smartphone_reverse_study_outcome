package com.bytedance.android.monitorV2;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.bytedance.ies.bullet.service.base.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends LruCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3606a;

    public /* synthetic */ k(int r5, int r10) {
        this.f3606a = r10;
        super(r5);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean r5, Object r10, Object r11, Object r12) {
        switch(this.f3606a) {
            case 1: goto L15;
            case 2: goto L4;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        super.entryRemoved(r5, r10, r11, r12);
        return;
    L6:
        com.bytedance.gkfs.io.a r13 = (com.bytedance.gkfs.io.a) r10;
        db.c r14 = (db.c) r12;
        super.entryRemoved(r5, r13, (db.c) r11, r14);
        com.bytedance.gkfs.d r15 = GkFSBlockBuffer.f4941k;
        StringBuilder r16 = new StringBuilder();
        GkFSBlockBuffer r17 = null;
        if (r13 == null) goto L9;
        Integer r18 = Integer.valueOf(r13.f4853a);
    L10:
        r16.append(r18);
        r16.append(" removed from buffer-cache, evicted:");
        r16.append(r5);
        r16.append(", newValue=");
        if (r14 == null) goto L13;
        r17 = r14.f16631b;
    L13:
        r16.append(r17);
        com.bytedance.gkfs.d.c(r15, "GkFSBlockBuffer", r16.toString(), 0, 12);
        return;
    L9:
        r18 = null;
        goto L10
    L15:
        com.bytedance.ies.bullet.service.base.e r19 = (com.bytedance.ies.bullet.service.base.e) r11;
        super.entryRemoved(r5, (Uri) r10, r19, (com.bytedance.ies.bullet.service.base.e) r12);
        if (r5 == false) goto L20;
        if (r19 == null) goto L21;
        r19.f5986c.release();
        return;
    L21:
        return;
    }

    @Override // android.util.LruCache
    public int sizeOf(Object r5, Object r10) {
        switch(this.f3606a) {
            case 0: goto L39;
            case 1: goto L5;
            case 2: goto L37;
            case 3: goto L32;
            case 4: goto L23;
            case 5: goto L18;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        String r11 = (String) r5;
        String r12 = (String) r10;
        int r13 = 0;
        if (r11 == null) goto L46;
        int r14 = r11.length();
        if (r12 == null) goto L12;
        r13 = r12.length();
    L12:
        return r13 + r14;
    L46:
        return 0;
    L13:
        String r15 = (String) r5;
        byte[] r16 = (byte[]) r10;
        if (r16 != null) goto L47;
        return 0;
    L47:
        return r16.length;
    L18:
        String r17 = (String) r5;
        byte[] r18 = (byte[]) r10;
        if (r18 != null) goto L48;
        return 0;
    L48:
        return r18.length;
    L23:
        String r19 = (String) r5;
        e3.a r20 = (e3.a) r10;
        if (r20 == null) goto L30;
        d3.b r21 = r20.f16751a;
        if (r21 == null) goto L30;
        byte[] r22 = r21.f16588a;
        if (r22 == null) goto L30;
        return r22.length;
    L30:
        return 0;
    L32:
        com.bytedance.gkfs.io.a r23 = (com.bytedance.gkfs.io.a) r5;
        db.c r24 = (db.c) r10;
        if (r24 != null) goto L50;
        return 1;
    L50:
        return (int) r24.f16630a;
    L37:
        String r25 = (String) r5;
        a0 r26 = (a0) r10;
        return 0;
    L39:
        String r27 = (String) r5;
        String r28 = (String) r10;
        int r29 = 0;
        if (r27 == null) goto L51;
        int r30 = r27.length();
        if (r28 == null) goto L45;
        r29 = r28.length();
    L45:
        return r29 + r30;
    L51:
        return 0;
    L5:
        return super.sizeOf(r5, r10);
    }
}
