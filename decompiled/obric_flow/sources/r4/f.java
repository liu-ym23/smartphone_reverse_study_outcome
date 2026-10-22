package r4;

import android.graphics.Paint;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21665c;
    public float d;
    public float e;

    public /* synthetic */ f(int r5) {
        this.f21664b = r5;
    }

    @Override // r4.a
    public final String d() {
        switch(this.f21664b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "st";
    L6:
        return "ft";
    }

    @Override // r4.a
    public final void e(HashMap r5, q4.c r10) {
        switch(this.f21664b) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.d = a.b("x", r5);
        this.e = a.b("y", r5);
        Object r11 = r5.get(MessageIndication.CONTENT_TYPE_TEXT);
        if (r11 == null) goto L8;
        String r12 = r11.toString();
        if (r12 == null) goto L8;
    L9:
        this.f21665c = r12;
        return;
    L8:
        r12 = "";
        goto L9
    L11:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.d = a.b("x", r5);
        this.e = a.b("y", r5);
        Object r13 = r5.get(MessageIndication.CONTENT_TYPE_TEXT);
        if (r13 == null) goto L15;
        String r14 = r13.toString();
        if (r14 == null) goto L15;
    L16:
        this.f21665c = r14;
        return;
    L15:
        r14 = "";
        goto L16
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        switch(this.f21664b) {
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
        float r12 = a.a(r11.d, this.e, r10);
        r5.a().drawText(this.f21665c, this.d, r12, r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.f21477b.setStyle(Paint.Style.FILL);
        Paint r13 = r5.f21477b;
        q4.c r14 = r5.d;
        r13.setColor(r14.f21480b);
        r13.setAlpha(r14.f21481c);
        float r15 = a.a(r14.d, this.e, r13);
        r5.a().drawText(this.f21665c, this.d, r15, r13);
    }
}
