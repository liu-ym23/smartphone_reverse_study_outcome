package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i<T> implements Comparator {
    public final /* synthetic */ ChatRecentFileSelectAdapter a;

    public i(ChatRecentFileSelectAdapter r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r5, T r6) {
        ChatRecentFileSelectAdapter r0 = this.a;
        String r7 = ((x79.a) r6).a;
        int r1 = ChatRecentFileSelectAdapter.p;
        r0.getClass();
        String r8 = ChatRecentFileSelectAdapter.E2(r7);
        long r2 = 0;
        if (r8 == null) goto L7;
        Long r9 = this.a.m.get(r8);
        if (r9 == null) goto L7;
        long r3 = r9.longValue();
    L8:
        Long r10 = Long.valueOf(r3);
        ChatRecentFileSelectAdapter r4 = this.a;
        String r11 = ((x79.a) r5).a;
        r4.getClass();
        String r12 = ChatRecentFileSelectAdapter.E2(r11);
        if (r12 == null) goto L14;
        Long r13 = this.a.m.get(r12);
        if (r13 == null) goto L14;
        r2 = r13.longValue();
    L14:
        return ComparisonsKt.compareValues(r10, Long.valueOf(r2));
    L7:
        r3 = 0;
        goto L8
    }
}
