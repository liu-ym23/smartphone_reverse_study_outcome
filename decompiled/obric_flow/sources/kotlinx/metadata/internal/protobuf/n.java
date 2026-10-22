package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;
import java.util.Map;
import kotlinx.metadata.internal.metadata.ProtoBuf$Property;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends m implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f19192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19193c;

    public n() {
        this.f19192b = k.f19180c;
    }

    public final void f(q r5, ProtoBuf$Property r10) {
        if (r5.f19203a != a()) goto L10;
        if (this.f19193c == true) goto L7;
        this.f19192b = this.f19192b.b();
        this.f19193c = true;
    L7:
        this.f19192b.a(r5.d, r5.b(r10));
        return;
    L10:
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }

    public final void g(GeneratedMessageLite.ExtendableMessage r5) {
        if (this.f19193c == true) goto L5;
        this.f19192b = this.f19192b.b();
        this.f19193c = true;
    L5:
        k r10 = this.f19192b;
        k r11 = GeneratedMessageLite.ExtendableMessage.access$200(r5);
        r10.getClass();
        int r12 = 0;
    L6:
        int r13 = r11.f19181a.f19170b.size();
        g0 r14 = r11.f19181a;
        if (r12 >= r13) goto L9;
        r10.h(r14.c(r12));
        r12 = r12 + 1;
        goto L6
    L9:
        Iterator r15 = r14.d().iterator();
    L11:
        if (r15.hasNext() == false) goto L13;
        r10.h((Map.Entry) r15.next());
        goto L11
    }
}
