package kc8;

import android.view.View;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface z {

    public static final class a {
        public static /* synthetic */ void a(z r2, View r3, st8.a r4, int r5) {
            LongClickSource r1 = null;
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r1 = LongClickSource.Content;
        L11:
            r2.b(r3, r4, r1);
        }
    }

    void a(View r1);

    void b(View r1, st8.a r2, LongClickSource r3);
}
