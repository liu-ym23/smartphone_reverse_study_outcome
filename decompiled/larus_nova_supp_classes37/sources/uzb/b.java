package uzb;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.flow.passport.ui.widget.layout.CommonContainerLayout;
import com.ss.android.lark.passport.utils.ImeObserver$3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int f = 0;
    public volatile boolean a;
    public volatile int b;
    public final C0199b c;
    public final MutableLiveData<C0199b> d;
    public final MutableLiveData e;

    public static final class a {
    }

    /* JADX INFO: renamed from: uzb.b$b, reason: collision with other inner class name */
    public static final class C0199b {
        public boolean a;
        public int b;

        public C0199b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0199b) == true) goto L8;
            return false;
        L8:
            C0199b r6 = (C0199b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b;
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "ImeInfo(isShowing=" + this.a + ", imeHeight=" + this.b + ')';
        }

        public C0199b(int r1) {
            this.a = false;
            this.b = 0;
        }
    }

    static {
    }

    public b(CommonContainerLayout r3) {
        C0199b r0 = new C0199b(0);
        this.c = r0;
        MutableLiveData<C0199b> r1 = new MutableLiveData(r0);
        this.d = r1;
        this.e = r1;
        ViewCompat.setOnApplyWindowInsetsListener(r3, new uzb.a(this));
        if (r3.isAttachedToWindow() == false) goto L5;
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r3);
    L6:
        LifecycleOwner r4 = qyb.d.a(r3);
        if (r2 != null) goto L10;
        if (r4 == null) goto L12;
        f.a(r4);
    L12:
        if ((r4 instanceof LifecycleOwner) == false) goto L14;
        r4.getLifecycle().addObserver(new ImeObserver$3(this));
    L14:
        if (r2 == null) goto L17;
        a(r2);
        return;
    L17:
        return;
    L10:
        a(r2);
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void a(WindowInsetsCompat r4) {
        int r2 = 0;
        if (r4.getSystemWindowInsetBottom() <= r4.getStableInsetBottom()) goto L5;
        boolean r0 = true;
    L6:
        this.a = r0;
        if (this.a == false) goto L9;
        r2 = r4.getSystemWindowInsetBottom() - r4.getStableInsetBottom();
    L9:
        this.b = r2;
        boolean r5 = this.a;
        int r1 = this.b;
        C0199b r3 = this.c;
        if (r3.a == r5) goto L12;
    L13:
        r3.a = r5;
        r3.b = r1;
        this.d.setValue(r3);
        return;
    L12:
        if (r3.b != r1) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
