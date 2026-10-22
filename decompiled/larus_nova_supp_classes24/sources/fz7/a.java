package fz7;

import com.bytedance.ee.bear.bitable.msgcenter.UniversalCardWrapper;
import com.larksuite.component.card.protocol.context.CardStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;
    public final boolean c;
    public final InterfaceC0109a d;
    public final CardStyle e;

    /* JADX INFO: renamed from: fz7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0109a {
        UniversalCardWrapper.render.1.getOpenUrlService.1 getOpenUrlService();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        InterfaceC0109a r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return ((r2 + r4) * 31) + this.e.hashCode();
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CardRenderEntityConfig(businessType=" + this.a + ", scene=" + this.b + ", asyncRender=" + this.c + ", dependency=" + this.d + ", cardStyle=" + this.e + ')';
    }

    public a(UniversalCardWrapper.a r4, CardStyle r5) {
        Intrinsics.checkNotNullParameter("base", "businessType");
        Intrinsics.checkNotNullParameter("message_center", "scene");
        Intrinsics.checkNotNullParameter(r5, "cardStyle");
        this.a = "base";
        this.b = "message_center";
        this.c = false;
        this.d = r4;
        this.e = r5;
    }
}
