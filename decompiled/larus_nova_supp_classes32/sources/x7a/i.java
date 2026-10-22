package x7a;

import android.util.LruCache;
import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends LruCache<h, LynxView> {
    public final a a;

    public interface a {
    }

    @Override // android.util.LruCache
    public final /* bridge */ /* synthetic */ LynxView create(h r1) {
        return null;
    }

    public i(int r1, a r2) {
        super(r1);
        this.a = r2;
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r1, h r2, LynxView r3, LynxView r4) {
        LynxView r5 = r3;
        if (r1 == false) goto L11;
        a r6 = this.a;
        if (r6 == null) goto L12;
        f r7 = ((d) r6).b();
        if (r7 == null) goto L9;
        r7.d(r5);
    L9:
        r5.destroy();
        return;
    L12:
        return;
    }
}
