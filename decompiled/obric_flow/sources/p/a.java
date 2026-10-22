package p;

import java.util.ArrayList;
import l.g;
import l.k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f21308c;

    public /* synthetic */ a(ArrayList r5, int r10) {
        this.f21308c = r10;
        super(r5, 7);
    }

    @Override // p.e
    public final l.d d() {
        switch(this.f21308c) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return new l.e((ArrayList) this.f22372b, 2);
    L7:
        return new k((ArrayList) this.f22372b);
    L9:
        return new g((ArrayList) this.f22372b, 2);
    L11:
        return new g((ArrayList) this.f22372b, 1);
    L13:
        return new l.e((ArrayList) this.f22372b, 1);
    L15:
        return new g((ArrayList) this.f22372b, 0);
    L17:
        return new l.e((ArrayList) this.f22372b, 0);
    }
}
