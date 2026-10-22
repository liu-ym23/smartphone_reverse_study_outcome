package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f19195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map.Entry f19196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19197c;

    public o(GeneratedMessageLite.ExtendableMessage r5, boolean r10) {
        k r11 = GeneratedMessageLite.ExtendableMessage.access$200(r5);
        r11.getClass();
        Iterator r12 = ((m0) r11.f19181a.entrySet()).iterator();
        this.f19195a = r12;
        if (r12.hasNext() == false) goto L5;
        this.f19196b = (Map.Entry) r12.next();
    L5:
        this.f19197c = r10;
    }

    public final void a(int r10, g r11) {
    L2:
        Map.Entry r5 = this.f19196b;
        if (r5 == null) goto L40;
        if (((p) r5.getKey()).f19200b >= r10) goto L56;
        p r12 = (p) this.f19196b.getKey();
        int r13 = 0;
        if (this.f19197c == true) goto L9;
    L13:
        Object r14 = this.f19196b.getValue();
        k r15 = k.f19180c;
        WireFormat$FieldType r16 = r12.f19201c;
        boolean r17 = r12.d;
        int r18 = r12.f19200b;
        if (r17 == false) goto L33;
        List r19 = (List) r14;
        if (r12.e == false) goto L25;
        r11.x(r18, 2);
        Iterator r20 = r19.iterator();
    L19:
        if (r20.hasNext() == false) goto L21;
        r13 = r13 + k.c(r16, r20.next());
        goto L19
    L21:
        r11.v(r13);
        Iterator r21 = r19.iterator();
    L23:
        if (r21.hasNext() == false) goto L36;
        k.l(r11, r16, r21.next());
    L36:
        Iterator r22 = this.f19195a;
        if (r22.hasNext() == true) goto L38;
        this.f19196b = null;
        goto L2
    L38:
        this.f19196b = (Map.Entry) r22.next();
        goto L2
    L25:
        Iterator r23 = r19.iterator();
    L27:
        if (r23.hasNext() == false) goto L36;
        Object r24 = r23.next();
        if (r16 == WireFormat$FieldType.GROUP) goto L30;
        r11.x(r18, r16.getWireType());
        k.l(r11, r16, r24);
        goto L27
    L30:
        r11.x(r18, 3);
        ((z) r24).writeTo(r11);
        r11.x(r18, 4);
        goto L27
    L33:
        if (r16 != WireFormat$FieldType.GROUP) goto L35;
        r11.x(r18, 3);
        ((z) r14).writeTo(r11);
        r11.x(r18, 4);
        goto L36
    L35:
        r11.x(r18, r16.getWireType());
        k.l(r11, r16, r14);
        goto L36
    L9:
        if (r12.f19201c.getJavaType() != WireFormat$JavaType.MESSAGE) goto L13;
        if (r12.d == true) goto L13;
        z r25 = (z) this.f19196b.getValue();
        r11.x(1, 3);
        r11.x(2, 0);
        r11.v(r12.f19200b);
        r11.p(3, r25);
        r11.x(1, 4);
        goto L36
    L56:
        return;
    }
}
