package q4;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import r4.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r4.c f21473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f21475c;

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        b r10 = new b();
        this.f21474b = r10;
        this.f21475c = r5.getResources().getDisplayMetrics().density;
        r10.d.getClass();
    }

    public final r4.c getCommandProvider() {
        return this.f21473a;
    }

    public final b getDrawContext() {
        return this.f21474b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        b r10 = this.f21474b;
        r10.f21477b.clearShadowLayer();
        r10.d.f21484j.clear();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f21476a = r5;
        Canvas r11 = r10.a();
        float r12 = this.f21475c;
        r11.scale(r12, r12);
        r4.c r13 = this.f21473a;
        if (r13 == null) goto L16;
        d r14 = (d) r13;
        ArrayList r15 = r14.f21660b;
        if (r15.isEmpty() == true) goto L10;
        Iterator r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        ((r4.a) r16.next()).f(r10);
    L10:
        ArrayList r17 = r14.f21661c;
        if (r17.isEmpty() == true) goto L19;
        Iterator r18 = r17.iterator();
    L14:
        if (r18.hasNext() == false) goto L20;
        ((r4.a) r18.next()).f(r10);
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public final void setCommandProvider(r4.c r5) {
        this.f21473a = r5;
    }
}
