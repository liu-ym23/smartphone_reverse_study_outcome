package r4;

import android.graphics.Path;
import android.graphics.RectF;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f21658c;

    public /* synthetic */ b(int r5) {
        this.f21657b = r5;
    }

    @Override // r4.a
    public final String d() {
        switch(this.f21657b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return "sta";
    L6:
        return "cp";
    L8:
        return "cr";
    }

    @Override // r4.a
    public final void e(HashMap r5, q4.c r10) {
        switch(this.f21657b) {
            case 0: goto L13;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        Object r11 = r5.get("state");
        if (r11 == null) goto L8;
        String r12 = r11.toString();
        if (r12 == null) goto L8;
    L9:
        this.f21658c = r12;
        return;
    L8:
        r12 = "";
        goto L9
    L11:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21658c = (Path) CollectionsKt.last(r10.f21484j);
        r10.f21483i = true;
        return;
    L13:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21658c = new RectF();
        float r13 = a.b("x", r5);
        float r14 = a.b("y", r5);
        RectF r15 = (RectF) this.f21658c;
        if (r15 == null) goto L17;
        r15.left = r13;
        r15.top = r14;
        r15.right = a.b("w", r5) + r13;
        r15.bottom = a.b("h", r5) + r13;
        return;
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        switch(this.f21657b) {
            case 0: goto L15;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "context");
        String r10 = (String) this.f21658c;
        if (Intrinsics.areEqual(r10, SVGRenderEngine.SAVE) == false) goto L8;
        r5.a().save();
        return;
    L8:
        if (Intrinsics.areEqual(r10, "restore") == false) goto L20;
        r5.a().restore();
        return;
    L20:
        return;
    L11:
        Intrinsics.checkNotNullParameter(r5, "context");
        Path r11 = (Path) this.f21658c;
        if (r11 == null) goto L21;
        r5.a().clipPath(r11);
        return;
    L21:
        return;
    L15:
        Intrinsics.checkNotNullParameter(r5, "context");
        RectF r12 = (RectF) this.f21658c;
        if (r12 == null) goto L22;
        r5.a().drawRect(r12, r5.f21478c);
        return;
    }
}
