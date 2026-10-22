package r4;

import android.graphics.Paint;
import android.graphics.Rect;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21663c;
    public int d;
    public int e;
    public final Rect f;

    public e(int r5) {
        this.f21662b = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f = new Rect();
        return;
    L6:
        this.f = new Rect();
    }

    @Override // r4.a
    public final String d() {
        switch(this.f21662b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "sr";
    L6:
        return "fr";
    }

    @Override // r4.a
    public final void e(HashMap r5, q4.c r10) {
        switch(this.f21662b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21663c = a.c("x", r5);
        this.d = a.c("y", r5);
        this.e = a.c("w", r5);
        int r11 = a.c("h", r5);
        int r12 = this.f21663c;
        Rect r13 = this.f;
        r13.left = r12;
        r13.right = r12 + this.e;
        int r14 = this.d;
        r13.top = r14;
        r13.bottom = r14 + r11;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21663c = a.c("x", r5);
        this.d = a.c("y", r5);
        this.e = a.c("w", r5);
        int r15 = a.c("h", r5);
        int r16 = this.f21663c;
        Rect r17 = this.f;
        r17.left = r16;
        r17.right = r16 + this.e;
        int r18 = this.d;
        r17.top = r18;
        r17.bottom = r18 + r15;
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        switch(this.f21662b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.f21477b.setStyle(Paint.Style.STROKE);
        Paint r10 = r5.f21477b;
        q4.c r11 = r5.d;
        r10.setColor(r11.f21479a);
        r10.setAlpha(r11.f21481c);
        r5.a().drawRect(this.f, r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.f21477b.setStyle(Paint.Style.FILL);
        Paint r12 = r5.f21477b;
        q4.c r13 = r5.d;
        r12.setColor(r13.f21480b);
        r12.setAlpha(r13.f21481c);
        r5.a().drawRect(this.f, r12);
    }
}
