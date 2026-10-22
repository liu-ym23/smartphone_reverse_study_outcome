package n49;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import g49.d;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mj4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends p49.a {
    public static final C0131a b = null;
    public static volatile a c;
    public final AtomicBoolean a;

    /* JADX INFO: renamed from: n49.a$a, reason: collision with other inner class name */
    public static final class C0131a {
        public C0131a() {
        }
    }

    public static final class b implements h {
        public final /* synthetic */ a a;

        public final /* synthetic */ void D(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void J(byte[] r1) {
        }

        public final /* synthetic */ void N(int r1, int r2) {
        }

        public final /* synthetic */ void N0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void P0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void Y(int r1, int r2, int r3) {
        }

        public final /* synthetic */ void a0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void a1(DoraDevice r1, mj4.b r2) {
        }

        public final /* synthetic */ void b0(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void d1(DoraDevice r1, int r2) {
        }

        public final /* synthetic */ void e1(DoraDevice r1, int[] r2) {
        }

        public final /* synthetic */ void f1(int r1, byte r2) {
        }

        public final /* synthetic */ void l1(DoraDevice r1) {
        }

        public final /* synthetic */ void p(int r1) {
        }

        public final /* synthetic */ void u(DoraDevice r1, int r2) {
        }

        public final /* synthetic */ void y0(DoraDevice r1, int[] r2) {
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void y(DoraDevice r3, int r4, byte[] r5) {
            d.d("EnvDeviceJob", "onEnvObserStateChanged device:" + r3 + ", nid:" + r4 + ", envObserInfo:" + Arrays.toString(r5));
            if (r5 == null) goto L24;
            boolean r6 = true;
            if (r5.length != 0) goto L7;
            boolean r7 = true;
        L9:
            if ((!r7) == false) goto L25;
            a r8 = this.a;
            Byte r1 = ArraysKt.firstOrNull(r5);
            if (r1 == null) goto L13;
            byte r2 = r1.byteValue();
        L14:
            Byte r9 = ArraysKt.getOrNull(r5, 1);
            if (r9 == null) goto L17;
            byte r10 = r9.byteValue();
        L18:
            r8.getClass();
            EnvObserveChangeReason r11 = EnvObserveChangeReason.DEVICE_CHANGE;
            r11.setReason(r10);
            if (r2 == 1) goto L22;
            r6 = false;
        L22:
            Intrinsics.checkNotNullParameter(r11, "reason");
            DoraEnvObserveManager.a.getClass();
            DoraEnvObserveManager.i(r6, r11, r10);
            return;
        L17:
            r10 = 0;
            goto L18
        L13:
            r2 = 0;
            goto L14
        L25:
            return;
        L7:
            r7 = false;
            goto L9
        }
    }

    static {
        b = new C0131a();
    }

    public final void a() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        kj4.a.g().k(new b(this));
    }

    public a() {
        this.a = new AtomicBoolean(false);
    }
}
