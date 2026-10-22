package if8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final /* synthetic */ int l = 0;
    public final Message a;
    public final int b;
    public final ChatParam c;
    public final BotModel d;
    public final boolean e;
    public final boolean f;
    public final q0 g;
    public final Boolean h;
    public final Block i;
    public final q0.a j;
    public final Function0<Map<String, Object>> k;

    public static final class a {
        public Message a;
        public Integer b;
        public ChatParam c;
        public BotModel d;
        public boolean e;
        public boolean f;
        public q0 g;
        public Boolean h;
        public Block i;
        public q0.a j;
        public Function0<? extends Map<String, ? extends Object>> k;

        public a() {
        }

        public final d a() {
            Message r1 = this.a;
            if (r1 != null) goto L5;
            r1 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        L5:
            Message r2 = r1;
            Integer r3 = this.b;
            if (r3 == null) goto L8;
            int r4 = r3.intValue();
        L9:
            ChatParam r5 = this.c;
            if (r5 != null) goto L12;
            ChatParam r6 = new ChatParam(null, null, null, null, null, 255);
        L13:
            BotModel r7 = this.d;
            if (r7 != null) goto L17;
            r7 = new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
        L17:
            return new d(r2, r4, r6, r7, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
        L12:
            r6 = r5;
            goto L13
        L8:
            r4 = 0;
            goto L9
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        q0 r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        Boolean r9 = this.h;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Block r12 = this.i;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        q0.a r15 = this.j;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        Function0<Map<String, Object>> r18 = this.k;
        if (r18 == null) goto L31;
        r6 = r18.hashCode();
    L31:
        return r17 + r6;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownEventProcessorParams(data=" + this.a + ", position=" + this.b + ", chatParam=" + this.c + ", bot=" + this.d + ", isDeepThinkArea=" + this.e + ", isStreaming=" + this.f + ", adapter=" + this.g + ", isImmersive=" + this.h + ", block=" + this.i + ", modelProvider=" + this.j + ", eventExtra=" + this.k + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Message r2, int r3, ChatParam r4, BotModel r5, boolean r6, boolean r7, q0 r8, Boolean r9, Block r10, q0.a r11, Function0<? extends Map<String, ? extends Object>> r12) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r4, "chatParam");
        Intrinsics.checkNotNullParameter(r5, "bot");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
