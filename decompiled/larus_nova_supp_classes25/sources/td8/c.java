package td8;

import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ List b(c r48, int r49, List r50, int r51) {
            if ((r51 & 1) == 0) goto L5;
            int r0 = 0;
        L7:
            if ((r51 & 4) == 0) goto L9;
            yc8.a r1 = new yc8.a(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null));
        L11:
            return r48.b(r0, null, r1, r50);
        L9:
            r1 = null;
            goto L11
        L5:
            r0 = r49;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(c r49, int r50, xc8.b r51, xc8.b r52, List r53, int r54) {
            if ((r54 & 1) == 0) goto L5;
            int r0 = 0;
        L7:
            if ((r54 & 2) == 0) goto L9;
            xc8.b r1 = null;
        L11:
            if ((r54 & 4) == 0) goto L13;
            xc8.b r2 = new yc8.a(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null));
        L15:
            if ((r54 & 8) == 0) goto L17;
            List r3 = new ArrayList();
        L19:
            return r49.a(r0, r1, r2, r3);
        L17:
            r3 = r53;
            goto L19
        L13:
            r2 = r52;
            goto L15
        L9:
            r1 = r51;
            goto L11
        L5:
            r0 = r50;
            goto L7
        }
    }

    boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4);

    List<xc8.b> b(int r1, xc8.b r2, xc8.b r3, List<xc8.b> r4);
}
