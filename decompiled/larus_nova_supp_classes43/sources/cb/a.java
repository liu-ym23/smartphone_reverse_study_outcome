package cb;

import android.view.View;
import bb.c;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LynxUI<?> a;
    public final /* synthetic */ bb.a b;

    public a(LynxUI<?> r1, bb.a r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r17) {
        String r1 = this.a.getProps().getString("x-bindtap");
        if (r1 == null) goto L23;
        bb.a r10 = this.b;
        int r11 = gb.a.a;
        Intrinsics.checkNotNullParameter(r1, "jsonString");
        int r13 = StringsKt.indexOf$default(r1, "'", 0, false, 6, null) + 1;
        int r12 = StringsKt.indexOf$default(r1, "',", 0, false, 6, null);
        if (r13 == 0) goto L8;
        if (r12 == (-1)) goto L8;
        String r14 = r1.substring(r13, r12);
    L9:
        String r15 = r14;
        Map r16 = MapsKt.emptyMap();
        int r18 = StringsKt.indexOf$default(r1, "{", 0, false, 6, null);
        int r19 = StringsKt.indexOf$default(r1, "}", 0, false, 6, null) + 1;
        if (r18 == 0) goto L22;
        if (r19 == (-1)) goto L22;
        String r20 = r1.substring(r18, r19);
        int r21 = hb.b.a;
        JSONObject r22 = new JSONObject(r20);
        Intrinsics.checkNotNullParameter(r22, "jsonOb");
        HashMap r23 = new HashMap();     // Catch: Throwable -> L20
        Iterator<String> r24 = r22.keys();     // Catch: Throwable -> L20
    L15:
        if (r24.hasNext() == false) goto L21;
        String r25 = r24.next();     // Catch: Throwable -> L20
        Object r26 = r22.opt(r25);     // Catch: Throwable -> L20
        if (r26 == null) goto L15;
        r23.put(r25, r26);     // Catch: Throwable -> L20
    L21:
        r16 = r23;
    L20:
        r23 = new HashMap();
    L22:
        Pair r27 = new Pair(r15, r16);
        String r28 = (String) r27.getFirst();
        Map<String, ? extends Object> r29 = (Map) r27.getSecond();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r28, "actionName");
        Intrinsics.checkNotNullParameter(r29, "actionData");
        c r30 = c.a;
        AnnieXLynxView r31 = r10.a;
        r30.getClass();
        c.b(r31, r10);
        r10.c.b(r28, r29, r10.b);
    L8:
        r14 = "";
    L23:
        Object r32 = r17.getParent();
        if ((r32 instanceof View) == false) goto L26;
        View r33 = (View) r32;
    L27:
        if (r33 != null) goto L29;
        return;
    L29:
        if (this.a.getProps().containsKey("x-stop") == false) goto L31;
        return;
    L31:
        r33.performClick();
        return;
    L26:
        r33 = null;
        goto L27
    }
}
