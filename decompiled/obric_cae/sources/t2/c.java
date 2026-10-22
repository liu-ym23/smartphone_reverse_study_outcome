package t2;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f12267a = 0;

    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Thread r10 = new Thread(r8);
            r10.setName("launch_sleep_detector");
            return r10;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f12268a = null;

        static {
            f12268a = new b[]{new b(BdimCategoryConstants.VALUE_NONE, 0), new b("SLEEP", 1), new b("NOT_SLEEP", 2), new b("DISK_SLEEP", 3)};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f12268a.clone();
        }
    }

    static {
        b[] r8 = b.f12268a;
        Executors.newSingleThreadExecutor(new a());
    }
}
