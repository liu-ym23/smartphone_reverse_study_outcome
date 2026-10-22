package androidx.profileinstaller;

import android.util.SparseArray;
import android.view.View;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.Event;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.w0;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.ui.image.s;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import im.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pn.g;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f558c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(com.obric.oui.popover.menu.c r5, View r10, int r11) {
        this.f556a = 2;
        this.f558c = r5;
        this.d = r10;
        this.f557b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.d;
        int r10 = this.f557b;
        Object r11 = this.f558c;
        switch(this.f556a) {
            case 0: goto L83;
            case 1: goto L76;
            case 2: goto L71;
            case 3: goto L69;
            case 4: goto L67;
            case 5: goto L65;
            default: goto L4;
        };
    L4:
        BaseAbility r12 = (BaseAbility) r11;
        CopyOnWriteArrayList r13 = r12.f9575a;
        if (r13.isEmpty() == true) goto L98;
        HashMap r14 = (HashMap) r5;
        switch(Event.values()[r10].ordinal()) {
            case 0: goto L60;
            case 1: goto L56;
            case 2: goto L52;
            case 3: goto L48;
            case 4: goto L44;
            case 5: goto L40;
            case 6: goto L36;
            case 7: goto L32;
            case 8: goto L22;
            case 9: goto L18;
            case 10: goto L14;
            case 11: goto L10;
            default: goto L99;
        };
    L10:
        dm.a r15 = new dm.a(r14);
        Iterator r16 = r13.iterator();
    L12:
        if (r16.hasNext() == false) goto L100;
        ((dm.c) r16.next()).i(r15);
        goto L12
    L100:
        return;
    L14:
        n r17 = new n(r14);
        Iterator r18 = r13.iterator();
    L16:
        if (r18.hasNext() == false) goto L101;
        ((dm.c) r18.next()).j(r17);
        goto L16
    L101:
        return;
    L18:
        dm.b r19 = new dm.b(r14);
        Iterator r20 = r13.iterator();
    L20:
        if (r20.hasNext() == false) goto L102;
        ((dm.c) r20.next()).k(r19);
        goto L20
    L102:
        return;
    L22:
        n r21 = new n(r14);
        Iterator r22 = r13.iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        ((dm.c) r22.next()).a(r21);
        goto L24
    L26:
        WeakReference r23 = r12.f9576b;
        if (r23 == null) goto L29;
        h r24 = (h) r23.get();
    L30:
        if (r24 == null) goto L64;
        r24.a();
        return;
    L64:
        return;
    L29:
        r24 = null;
        goto L30
    L32:
        dm.b r25 = new dm.b(r14);
        Iterator r26 = r13.iterator();
    L34:
        if (r26.hasNext() == false) goto L103;
        ((dm.c) r26.next()).g(r25);
        goto L34
    L103:
        return;
    L36:
        dm.a r27 = new dm.a(r14);
        Iterator r28 = r13.iterator();
    L38:
        if (r28.hasNext() == false) goto L104;
        ((dm.c) r28.next()).l(r27);
        goto L38
    L104:
        return;
    L40:
        n r29 = new n(r14);
        Iterator r30 = r13.iterator();
    L42:
        if (r30.hasNext() == false) goto L105;
        ((dm.c) r30.next()).d(r29);
        goto L42
    L105:
        return;
    L44:
        n r31 = new n(r14);
        Iterator r32 = r13.iterator();
    L46:
        if (r32.hasNext() == false) goto L106;
        ((dm.c) r32.next()).e(r31);
        goto L46
    L106:
        return;
    L48:
        n r33 = new n(r14);
        Iterator r34 = r13.iterator();
    L50:
        if (r34.hasNext() == false) goto L107;
        ((dm.c) r34.next()).f(r33);
        goto L50
    L107:
        return;
    L52:
        n r35 = new n(r14);
        Iterator r36 = r13.iterator();
    L54:
        if (r36.hasNext() == false) goto L108;
        ((dm.c) r36.next()).h(r35);
        goto L54
    L108:
        return;
    L56:
        n r37 = new n(r14);
        Iterator r38 = r13.iterator();
    L58:
        if (r38.hasNext() == false) goto L109;
        ((dm.c) r38.next()).c(r37);
        goto L58
    L109:
        return;
    L60:
        n r39 = new n(r14);
        Iterator r40 = r13.iterator();
    L62:
        if (r40.hasNext() == false) goto L110;
        ((dm.c) r40.next()).b(r39);
        goto L62
    L110:
        return;
    L99:
        return;
    L98:
        return;
    L65:
        LynxEventReporter.b(r10, (String) r11, (Map) r5);
        return;
    L67:
        g r41 = (g) r11;
        LynxEventReporter.e(r41, r10, (String) r5);
        return;
    L69:
        LynxEventReporter.h(r10, (String) r11, r5);
        return;
    L71:
        int r42 = OPopoverEntranceMenuView.f14129n;
        com.obric.oui.popover.menu.c r43 = (com.obric.oui.popover.menu.c) r11;
        Intrinsics.checkNotNullParameter(r43, "$item");
        Function2 r44 = r43.f14156j;
        if (r44 == null) goto L111;
        View r45 = (View) r5;
        r44.mo2invoke(r45, Integer.valueOf(r10));
        return;
    L111:
        return;
    L76:
        w0 r46 = (w0) ((LynxContext) r11).f10151t.get();
        if (r46 == null) goto L112;
        ShadowNode r47 = (ShadowNode) ((SparseArray) r46.g.f10812a).get(r10);
        s r48 = (s) r5;
        r48.getClass();
        if ((r47 instanceof AutoSizeImage) == true) goto L81;
        LynxLog.b(4, "ImageDelegate", "ShadowNode is not an instance of AutoSizeImage.");
        return;
    L81:
        int r49 = r48.f11100b;
        int r50 = r48.f11101c;
        boolean r51 = r48.f11099a;
        ((AutoSizeImage) r47).s(r49, r50, r48.d, r48.e, r51);
        return;
    L112:
        return;
    L83:
        DeviceProfileWriter.a((DeviceProfileWriter) r11, r10, r5);
    }

    public /* synthetic */ a(Object r5, int r10, Object r11, int r12) {
        this.f556a = r12;
        this.f558c = r5;
        this.f557b = r10;
        this.d = r11;
    }

    public /* synthetic */ a(String r5, int r10, int r11, Object r12) {
        this.f556a = r11;
        this.f557b = r10;
        this.f558c = r5;
        this.d = r12;
    }
}
