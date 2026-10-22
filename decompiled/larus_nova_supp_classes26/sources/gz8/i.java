package gz8;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public static final p0 a(List<z0> r7) {
        if (r7 == null) goto L34;
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L23;
        Object r1 = r8.next();
        z0 r2 = (z0) r1;
        p0 r3 = r2.o;
        boolean r4 = true;
        if (r3 == null) goto L15;
        Integer r5 = r3.a;
        int r6 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r5 == null) goto L15;
        if (r5.intValue() != r6) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L21;
        if (Intrinsics.areEqual(r2.b, ActionBarInstructionKey.COCO_DEEP_THINKING.getKey()) == true) goto L21;
        r4 = false;
    L21:
        if (r4 == false) goto L6;
    L24:
        z0 r10 = (z0) r1;
        if (r10 != null) goto L27;
        return null;
    L27:
        return r10.o;
    L15:
        r9 = false;
        goto L16
    L23:
        r1 = null;
        goto L24
    L34:
        return null;
    }

    public static final ReplyOption c(com.larus.bmhome.instruction.g r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ReplyOption r1 = r5.Ql();
        p0 r6 = a(r5.tq());
        if (r6 != null) goto L9;
        b("config_unavailable", r1, null, 0);
        return null;
    L9:
        int r0 = b.b;
        b r7 = b.a.a(r6);
        AgentMode r2 = AgentMode.MOA;
        int r3 = r2.getValue();
        ReplyOption r4 = r7.a.a(r3, r1);
        if (r4 != null) goto L13;
        String r8 = "moa_option_unavailable";
    L16:
        int r9 = r2.getValue();
        b(r8, r1, r4, r7.a.b(r9, true).size());
        return r4;
    L13:
        if (Intrinsics.areEqual(r4, r1) == false) goto L15;
        r8 = "current_moa_option";
        goto L16
    L15:
        r8 = "resolved_moa_option";
        goto L16
    }

    public static final Map<String, String> d(List<z0> r7) {
        p0 r8 = a(r7);
        if (r8 == null) goto L5;
        int r0 = b.b;
        b r9 = b.a.a(r8);
        Map r1 = MapsKt.createMapBuilder();
        Iterator<b2> r10 = r9.a.b(AgentMode.MOA.getValue(), false).iterator();
    L8:
        if (r10.hasNext() == false) goto L34;
        b2 r2 = r10.next();
        ModelItemIdentity r3 = r2.b();
        if (r3 == null) goto L8;
        String r4 = r2.b;
        if (r4 == null) goto L8;
        boolean r5 = true;
        Integer r6 = null;
        if ((!StringsKt.isBlank(r4)) == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L8;
        String r11 = r3.getKey();
        if (r11 == null) goto L23;
        String r12 = (String) r1.put(r11, r4);
    L23:
        Integer r13 = Integer.valueOf(r3.getDeprecatedItemId());
        if (r13.intValue() != 0) goto L27;
        r5 = false;
    L27:
        if (r5 == false) goto L29;
        r6 = r13;
    L29:
        if (r6 == null) goto L8;
        String r14 = r6.toString();
        if (r14 == null) goto L8;
        String r15 = (String) r1.put(r14, r4);
        goto L8
    L34:
        return MapsKt.build(r1);
    L5:
        return MapsKt.emptyMap();
    }

    public static final void b(String r3, ReplyOption r4, ReplyOption r5, int r6) {
        FLogger.a.i("ChatJobReplyMode", "resolve task reply mode, source=" + r3 + ", current=" + r4 + ", target=" + r5 + ", taskModelCount=" + r6);
    }
}
