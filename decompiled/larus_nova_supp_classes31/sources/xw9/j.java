package xw9;

import android.app.Activity;
import android.view.OrientationEventListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public static final /* synthetic */ int d = 0;
    public Function1<? super Integer, Boolean> a;
    public int b;
    public final b c;

    public static final class a {
    }

    public static final class b extends OrientationEventListener {
        public final /* synthetic */ j a;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r5) {
            if (r5 != (-1)) goto L5;
            return;
        L5:
            this.a.getClass();
            int r1 = 0;
            if (r5 > 60) goto L8;
        L24:
            j r6 = this.a;
            if (r6.b != r1) goto L27;
            return;
        L27:
            r6.b = r1;
            if (((Boolean) r6.a.invoke(Integer.valueOf(r1))).booleanValue() == true) goto L31;
            disable();
            return;
        L31:
            return;
        L8:
            if (r5 > 300) goto L24;
            if (61 > r5) goto L14;
            if (r5 >= 136) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L17;
            r1 = 90;
            goto L24
        L17:
            if (136 <= r5) goto L19;
        L21:
            if (r1 == 0) goto L23;
            r1 = 180;
            goto L24
        L23:
            r1 = 270;
            goto L24
        L19:
            if (r5 >= 226) goto L21;
            r1 = 1;
        L14:
            r2 = false;
            goto L15
        }

        public b(Activity r1, j r2) {
            this.a = r2;
            super(r1);
        }
    }

    static {
    }

    public j(Activity r2, Function1<? super Integer, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onChange");
        this.a = r3;
        this.b = -1;
        b r4 = new b(r2, this);
        this.c = r4;
        r4.enable();
    }
}
