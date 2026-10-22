package h4;

import android.view.View;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k5.d;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxUI f17280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g4.a f17281b;

    public a(LynxUI r5, g4.a r10) {
        this.f17280a = r5;
        this.f17281b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        LynxUI r5 = this.f17280a;
        String r11 = r5.getProps().getString("x-bindtap");
        if (r11 == null) goto L23;
        Intrinsics.checkNotNullParameter(r11, "jsonString");
        int r12 = StringsKt.r("'", 0, 6, r11) + 1;
        int r13 = StringsKt.r("',", 0, 6, r11);
        if (r12 == 0) goto L8;
        if (r13 == (-1)) goto L8;
        String r14 = r11.substring(r12, r13);
    L9:
        Map r15 = MapsKt.emptyMap();
        int r16 = StringsKt.r("{", 0, 6, r11);
        int r17 = StringsKt.r("}", 0, 6, r11) + 1;
        if (r16 == 0) goto L22;
        if (r17 == (-1)) goto L22;
        JSONObject r18 = new JSONObject(r11.substring(r16, r17));
        Intrinsics.checkNotNullParameter(r18, "jsonOb");
        HashMap r19 = new HashMap();     // Catch: Throwable -> L21
        Iterator<String> r20 = r18.keys();     // Catch: Throwable -> L21
    L15:
        if (r20.hasNext() == false) goto L20;
        String r21 = r20.next();     // Catch: Throwable -> L21
        Object r22 = r18.opt(r21);     // Catch: Throwable -> L21
        if (r22 == null) goto L15;
        r19.put(r21, r22);     // Catch: Throwable -> L21
    L20:
        r15 = r19;
    L21:
        r19 = new HashMap();
    L22:
        Pair r23 = new Pair(r14, r15);
        String r24 = (String) r23.getFirst();
        Map r25 = (Map) r23.getSecond();
        g4.a r26 = this.f17281b;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r24, "actionName");
        Intrinsics.checkNotNullParameter(r25, "actionData");
        d.e(r26.f17029a, r26);
        r26.f17031c.k(r24, r25, r26.f17030b);
    L8:
        r14 = "";
    L23:
        Object r27 = r10.getParent();
        if ((r27 instanceof View) == false) goto L26;
        View r28 = (View) r27;
    L27:
        if (r28 != null) goto L29;
        return;
    L29:
        if (r5.getProps().containsKey("x-stop") == true) goto L41;
        r28.performClick();
        return;
    L41:
        return;
    L26:
        r28 = null;
        goto L27
    }
}
