package gl8;

import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.g;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ThinkingBlock;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Message a;
    public final Block b;
    public final ThinkingBlock c;
    public final boolean d;
    public final boolean e;
    public final List<jc8.a> f;
    public final g g;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Block r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ThinkingBlock r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.d == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.e == true) goto L22;
        r10 = 1237;
    L22:
        int r13 = (((r12 + r10) * 31) + this.f.hashCode()) * 31;
        g r14 = this.g;
        if (r14 == null) goto L27;
        r1 = r14.hashCode();
    L27:
        return r13 + r1;
    L17:
        r11 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatingThinkVMData(message=" + this.a + ", block=" + this.b + ", thinkingBlock=" + this.c + ", isDeepThinkTyping=" + this.d + ", isLoadingFullMessage=" + this.e + ", childrenBlocks=" + this.f + ", blockBizModel=" + this.g + ')';
    }

    public a(Message r2, Block r3, ThinkingBlock r4, boolean r5, boolean r6, List<? extends jc8.a> r7, g r8) {
        Intrinsics.checkNotNullParameter(r7, "childrenBlocks");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
