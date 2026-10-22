package qa;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class x2 implements Comparator<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y2 f11225a;

    public x2(y2 r8) {
        this.f11225a = r8;
    }

    @Override // java.util.Comparator
    public final int compare(String r8, String r10) {
        y2 r11 = this.f11225a;
        ConcurrentHashMap r12 = r11.f11233c;
        long r13 = ((y2.b) r12.get(r10)).f11241c;
        ConcurrentHashMap r14 = r11.f11233c;
        long r15 = ((y2.b) r14.get(r8)).f11241c;
        if (r13 >= r15) goto L5;
        return -1;
    L5:
        if (r13 != r15) goto L7;
        return 0;
    L7:
        return 1;
    }
}
