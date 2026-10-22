package ulc;

import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import tlc.d;
import vlc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements b {
    public static final LimitedSizeHashMap d = null;
    public final k a;
    public final LimitedSizeHashMap b;
    public final LimitedSizeHashMap c;

    /* JADX INFO: renamed from: ulc.a$a, reason: collision with other inner class name */
    public static class C0332a {
        public final int a;
        public final long b;

        public C0332a(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // ulc.b
    public final String getName() {
        return "MsgIdDuplicateWithType";
    }

    static {
        d = new LimitedSizeHashMap(512);
    }

    public static String a(d r3) {
        return r3.getMessageMethod() + "_" + r3.getMessageId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vlc.b
    public final boolean onMessage(d r14) {
        int r0 = r14.getGeneralMessageType();
        String r1 = a(r14);
        if (r14.isGlobalMessage() == false) goto L9;
        LimitedSizeHashMap r15 = d;
        if (r15.containsKey(r1) == false) goto L7;
        return true;
    L7:
        r15.put(r1, null);
        return false;
    L9:
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L16;
    L23:
        return false;
    L16:
        if (this.c.containsKey(r1) == false) goto L22;
        C0332a r2 = (C0332a) this.c.get(r1);
        if (this.a == null) goto L21;
        if (r2 == null) goto L21;
        long r11 = System.currentTimeMillis() - r2.b;
        this.a.b(r14.getMessageId(), r2.a, r14.getMessageFrom(), r11);
    L21:
        return true;
    L22:
        long r3 = System.currentTimeMillis();
        C0332a r4 = new C0332a(r14.getMessageFrom(), r3);
        this.c.put(a(r14), r4);
        goto L23
    L11:
        if (this.b.containsKey(r1) == false) goto L13;
        return true;
    L13:
        this.b.put(r1, null);
        goto L23
    }

    public a(k r3, int r4) {
        this.a = r3;
        this.b = new LimitedSizeHashMap(Math.max(r4, 512));
        this.c = new LimitedSizeHashMap(Math.max(r4, 512));
    }
}
