package rpc;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.Packet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final Command a;
    public final Packet b;
    public final a c;

    public static final class a {
        public final com.lark.kmp.server.pb.improto.Command a;
        public final com.lark.kmp.server.pb.improto.Packet b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ServerPushData(serverCommand=" + this.a + ", packet=" + this.b + ')';
        }

        public a(com.lark.kmp.server.pb.improto.Command r2, com.lark.kmp.server.pb.improto.Packet r3) {
            Intrinsics.checkNotNullParameter(r2, "serverCommand");
            Intrinsics.checkNotNullParameter(r3, "packet");
            this.a = r2;
            this.b = r3;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        a r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "PushData(command=" + this.a + ", packet=" + this.b + ", serverPush=" + this.c + ')';
    }

    public c(Command r2, Packet r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "command");
        Intrinsics.checkNotNullParameter(r3, "packet");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
