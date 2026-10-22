package vb;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThreadLocal<a> f12782f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<b, Long> f12783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f12784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0181a f12785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f12786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12787e;

    /* JADX INFO: renamed from: vb.a$a, reason: collision with other inner class name */
    public class C0181a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f12788a;

        public C0181a(a r8) {
            this.f12788a = r8;
        }
    }

    public interface b {
        boolean doAnimationFrame(long r8);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0181a f12789a;

        public c(C0181a r8) {
            this.f12789a = r8;
        }
    }

    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f12790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChoreographerFrameCallbackC0182a f12791c;

        /* JADX INFO: renamed from: vb.a$d$a, reason: collision with other inner class name */
        public class ChoreographerFrameCallbackC0182a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f12792a;

            public ChoreographerFrameCallbackC0182a(d r8) {
                this.f12792a = r8;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r10) {
                C0181a r8 = this.f12792a.f12789a;
                r8.getClass();
                long r11 = SystemClock.uptimeMillis();
                a r12 = r8.f12788a;
                r12.getClass();
                long r13 = SystemClock.uptimeMillis();
                int r14 = 0;
            L3:
                ArrayList<b> r15 = r12.f12784b;
                if (r14 >= r15.size()) goto L20;
                b r16 = r15.get(r14);
                if (r16 == null) goto L18;
                ArrayMap<b, Long> r17 = r12.f12783a;
                Long r18 = r17.get(r16);
                if (r18 != null) goto L12;
            L14:
                boolean r19 = true;
            L16:
                if (r19 == false) goto L18;
                r16.doAnimationFrame(r11);
                goto L18
            L12:
                if (r18.longValue() >= r13) goto L15;
                r17.remove(r16);
                goto L14
            L15:
                r19 = false;
            L18:
                r14 = r14 + 1;
                goto L3
            L20:
                if (r12.f12787e == false) goto L29;
                int r20 = r15.size();
            L22:
                r20 = r20 - 1;
                if (r20 < 0) goto L27;
                if (r15.get(r20) != null) goto L22;
                r15.remove(r20);
                goto L22
            L27:
                r12.f12787e = false;
            L29:
                if (r15.size() > 0) goto L31;
                return;
            L31:
                if (r12.f12786d != null) goto L33;
                r12.f12786d = new d(r12.f12785c);
            L33:
                d r21 = r12.f12786d;
                r21.f12790b.postFrameCallback(r21.f12791c);
            }
        }

        public d(C0181a r8) {
            super(r8);
            this.f12790b = Choreographer.getInstance();
            this.f12791c = new ChoreographerFrameCallbackC0182a(this);
        }
    }

    static {
        f12782f = new ThreadLocal();
    }

    public a() {
        this.f12783a = new ArrayMap();
        this.f12784b = new ArrayList();
        this.f12785c = new C0181a(this);
        this.f12787e = false;
    }
}
