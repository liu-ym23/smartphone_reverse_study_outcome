package c7a;

import b8a.l;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxViewClientV2;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.frame.LynxFrameView;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends LynxViewClientV2 {
    public final WeakReference<LynxFrameView> a;

    public a(LynxFrameView r2) {
        this.a = new WeakReference(r2);
    }

    @Override // com.lynx.tasm.LynxViewClientV2, y7a.a
    public final void onPerformanceEvent(l r9) {
        LynxFrameView r0 = this.a.get();
        if (r0 == null) goto L43;
        boolean r2 = true;
        if ("pipeline".equals(r9.b) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L48;
        LynxContext r3 = r0.f;
        if (r3 != null) goto L15;
        return;
    L15:
        if (r3.getEventEmitter() != null) goto L17;
        return;
    L17:
        if (r0.f.getLynxUIOwner() == null) goto L49;
        LynxBaseUI r4 = r0.f.getLynxUIOwner().findLynxUIBySign(r0.e);
        if (r4 != null) goto L22;
        return;
    L22:
        if (r4.getEvents() != null) goto L24;
        return;
    L24:
        if (r4.getEvents().containsKey("loadmetrics") == false) goto L50;
        EventEmitter r5 = r0.f.getEventEmitter();
        int r6 = r0.e;
        String r7 = r0.b;
        if ((r0.r & 1) > 0) goto L30;
        r2 = false;
    L30:
        HashMap r8 = new HashMap();
        if (r7 != null) goto L33;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        r8.put(LynxEventReporter.PROP_NAME_URL, r7);
        if (r2 == false) goto L36;
        String r10 = "embedded";
    L37:
        r8.put("mode", r10);
        if (r9.d != null) goto L40;
        HashMap r11 = new HashMap();
    L41:
        r8.put("entry", r11);
        r5.sendCustomEvent(new m7a.a(r6, "loadmetrics", r8));
        return;
    L40:
        r11 = new HashMap(r9.d);
        goto L41
    L36:
        r10 = "standard";
        goto L37
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L7:
        if ("loadBundle".equals(r9.a) == false) goto L9;
        r1 = true;
        goto L10
    }
}
