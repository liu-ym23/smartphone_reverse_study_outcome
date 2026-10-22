package c62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements vlc.b {
    public final Map<Long, c> a;
    public final vlc.k b;

    public static final class a {
    }

    /* JADX INFO: renamed from: c62.b$b, reason: collision with other inner class name */
    public static final class C0007b {
        public final int a;
        public final long b;

        public C0007b(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements vlc.b {
        public final LimitedSizeHashMap a;
        public final LimitedSizeHashMap b;
        public final vlc.k c;

        public c(vlc.k r2) {
            Intrinsics.checkNotNullParameter(r2, "onMessageDuplicateListener");
            this.c = r2;
            this.a = new LimitedSizeHashMap(512);
            this.b = new LimitedSizeHashMap(512);
        }

        public final boolean onMessage(tlc.d r11) {
            if (r11 != null) goto L5;
            return false;
        L5:
            int r1 = r11.getGeneralMessageType();
            long r3 = r11.getMessageId();
            if (r1 != 2) goto L12;
            if (this.a.containsKey(Long.valueOf(r3)) == false) goto L10;
            return true;
        L10:
            this.a.put(Long.valueOf(r3), null);
        L20:
            return false;
        L12:
            if (r1 != 3) goto L20;
            if (this.b.containsKey(Long.valueOf(r3)) == false) goto L19;
            C0007b r0 = (C0007b) this.b.get(Long.valueOf(r3));
            if (r0 == null) goto L18;
            long r7 = System.currentTimeMillis() - r0.b;
            this.c.b(r3, r0.a, r11.getMessageFrom(), r7);
        L18:
            return true;
        L19:
            long r2 = System.currentTimeMillis();
            C0007b r4 = new C0007b(r11.getMessageFrom(), r2);
            this.b.put(Long.valueOf(r11.getMessageId()), r4);
            goto L20
        }
    }

    static {
    }

    public b(vlc.k r2) {
        Intrinsics.checkNotNullParameter(r2, "onMessageDuplicateListener");
        this.b = r2;
        this.a = new LinkedHashMap();
    }

    public final boolean onMessage(tlc.d r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        long r1 = o.b(r7);
        if (r1 > 0) goto L8;
        return false;
    L8:
        Map<Long, c> r0 = this.a;
        LinkedHashMap r2 = (LinkedHashMap) r0;
        c r3 = (c) r2.get(Long.valueOf(r1));
        if (r3 != null) goto L12;
        r3 = new c(this.b);
        this.a.put(Long.valueOf(r1), r3);
    L12:
        return r3.onMessage(r7);
    }
}
