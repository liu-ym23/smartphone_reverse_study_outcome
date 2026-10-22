package r4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21667c;
    public float d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f21668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f21669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f21670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f21671k;

    public g() {
        this.f21666b = 1;
    }

    @Override // r4.a
    public final String d() {
        return "im";
    }

    @Override // r4.a
    public final void e(HashMap r10, q4.c r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "dataManager");
        Object r5 = r10.get("st");
        String r12 = null;
        if ((r5 instanceof String) == false) goto L5;
        String r13 = (String) r5;
    L6:
        Object r14 = r10.get("im");
        if ((r14 instanceof String) == false) goto L9;
        r12 = (String) r14;
    L9:
        this.f21667c = r12;
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.length() == 0) goto L44;
        if (r13 != null) goto L16;
        return;
    L16:
        if (r13.length() == 0) goto L45;
        int r15 = r13.hashCode();
        if (r15 == 115) goto L34;
        if (r15 == 3178) goto L30;
        if (r15 == 3180) goto L26;
    L37:
        String r16 = this.f21667c;
        if (r16 == null) goto L43;
        r11.f21485k.get(r16);
        return;
    L43:
        return;
    L26:
        if (r13.equals("co") == false) goto L37;
        this.d = a.b("x", r10);
        this.e = a.b("y", r10);
        this.f = a.b("w", r10);
        this.g = a.b("h", r10);
        this.f21668h = a.b("sx", r10);
        this.f21669i = a.b("sy", r10);
        this.f21670j = a.b("sw", r10);
        this.f21671k = a.b("sh", r10);
        goto L37
    L30:
        if (r13.equals("cm") == false) goto L37;
        this.d = a.b("x", r10);
        this.e = a.b("y", r10);
        this.f = a.b("w", r10);
        this.g = a.b("h", r10);
        goto L37
    L34:
        if (r13.equals("s") == false) goto L37;
        this.d = a.b("x", r10);
        this.e = a.b("y", r10);
        goto L37
    L45:
        return;
    L44:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // r4.a
    public final void f(q4.b r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Bitmap r5 = (Bitmap) r10.d.f21485k.get(this.f21667c);
        if (r5 == null) goto L16;
        Paint r11 = r10.f21477b;
        int r12 = this.f21666b;
        if (r12 != 0) goto L9;
        r10.a().drawBitmap(r5, this.d, this.e, r11);
        return;
    L9:
        if (r12 != 1) goto L13;
        Canvas r13 = r10.a();
        float r14 = this.d;
        float r15 = this.e;
        r13.drawBitmap(r5, null, new RectF(r14, r15, this.f + r14, this.g + r15), r11);
        return;
    L13:
        if (r12 != 2) goto L17;
        Canvas r16 = r10.a();
        float r17 = this.f21668h;
        float r18 = this.f21669i;
        Rect r19 = new Rect((int) r17, (int) r18, (int) (r17 + this.f21670j), (int) (r18 + this.f21671k));
        float r20 = this.d;
        float r21 = this.e;
        r16.drawBitmap(r5, r19, new RectF(r20, r21, this.f + r20, this.g + r21), r11);
        return;
    L17:
        return;
    }
}
