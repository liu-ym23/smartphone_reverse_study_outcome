package org.threeten.bp.format;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21209a;

    public /* synthetic */ c(int r5) {
        this.f21209a = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        switch(this.f21209a) {
            case 0: goto L16;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        d6.f r11 = (d6.f) r5;
        d6.f r12 = (d6.f) r10;
        return Integer.compare((r12.d + 1) * r12.f16609b, (r11.d + 1) * r11.f16609b);
    L12:
        String r13 = (String) r5;
        String r14 = (String) r10;
        int r15 = r14.length() - r13.length();
        if (r15 == 0) goto L15;
        return r15;
    L15:
        return r13.compareTo(r14);
    L16:
        String r16 = (String) r5;
        String r17 = (String) r10;
        if (r16.length() != r17.length()) goto L20;
        return r16.compareTo(r17);
    L20:
        return r16.length() - r17.length();
    L5:
        return ComparisonsKt.compareValues(Long.valueOf(((kb.b) r10).d), Long.valueOf(((kb.b) r5).d));
    L9:
        return (int) (((u6.a) r10).f22263c - ((u6.a) r5).f22263c);
    L11:
        return ((String) ((Map.Entry) r10).getKey()).length() - ((String) ((Map.Entry) r5).getKey()).length();
    }
}
