package cb8;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u1 {
    public static final po8.p a(t1 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        hk9.a r3 = r2.p;
        if (r3 == null) goto L13;
        Sequence r4 = ViewGroupKt.getChildren(r3);
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L19;
        po8.p r0 = (View) r5.next();
        if ((r0 instanceof po8.p) == false) goto L8;
        return r0;
    L19:
        return null;
    L18:
        return null;
    L13:
        return null;
    }

    public static final void b(JSONObject r3, JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        r3.put(r1, r4.get(r1));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(Message r3, JSONObject r4, View r5) {
        ViewGroup r1 = null;
        if ((r5 instanceof bd8.d) == false) goto L5;
        b(r4, ((bd8.d) r5).m(r3));
    L33:
        if ((r5 instanceof ViewGroup) == false) goto L35;
        r1 = (ViewGroup) r5;
    L35:
        if (r1 == null) goto L42;
        Sequence r6 = ViewGroupKt.getChildren(r1);
        if (r6 == null) goto L44;
        Iterator r7 = r6.iterator();
    L40:
        if (r7.hasNext() == false) goto L45;
        c(r3, r4, (View) r7.next());
        goto L40
    L45:
        return;
    L44:
        return;
    L42:
        return;
    L5:
        if (r5 == 0) goto L7;
        Object r0 = r5.getTag();
    L9:
        if ((r0 instanceof bd8.d) == false) goto L19;
        Object r2 = r5.getTag();
        if ((r2 instanceof bd8.d) == false) goto L13;
        bd8.d r8 = (bd8.d) r2;
    L14:
        if (r8 == null) goto L16;
        JSONObject r9 = r8.m(r3);
    L17:
        b(r4, r9);
        goto L33
    L16:
        r9 = null;
        goto L17
    L13:
        r8 = null;
        goto L14
    L19:
        if (r5 == 0) goto L21;
        Object r10 = r5.getTag(2131385210);
    L23:
        if ((r10 instanceof bd8.d) == false) goto L33;
        Object r11 = r5.getTag(2131385210);
        if ((r11 instanceof bd8.d) == false) goto L27;
        bd8.d r12 = (bd8.d) r11;
    L28:
        if (r12 == null) goto L30;
        JSONObject r13 = r12.m(r3);
    L31:
        b(r4, r13);
        goto L33
    L30:
        r13 = null;
        goto L31
    L27:
        r12 = null;
        goto L28
    L21:
        r10 = null;
        goto L23
    L7:
        r0 = null;
        goto L9
    }
}
