package fab;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final AtomicBoolean a;
    public volatile b b;

    public static class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public interface b {
    }

    public e() {
        this.a = new AtomicBoolean(false);
    }
}
