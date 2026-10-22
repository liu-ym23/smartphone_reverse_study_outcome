package lq8;

import com.larus.bmhome.interactionpanel.InteractionPanelType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final InteractionPanelType a;
    public final Block b;
    public final Message c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ResolvedInteractionPanelBlock(type=" + this.a + ", block=" + this.b + ", message=" + this.c + ')';
    }

    public final InteractionPanelType getType() {
        return this.a;
    }

    public e(InteractionPanelType r2, Block r3, Message r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "block");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
