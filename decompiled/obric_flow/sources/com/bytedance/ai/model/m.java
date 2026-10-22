package com.bytedance.ai.model;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.resource.core.AIPackageOperationGroup;
import com.bytedance.ai.uiu.objects.UIOperationDef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.z;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2254a;

    public /* synthetic */ m(int r5) {
        this.f2254a = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        boolean r5 = false;
        int r11 = 24;
        switch(this.f2254a) {
            case 0: goto L128;
            case 1: goto L126;
            case 2: goto L125;
            case 3: goto L92;
            case 4: goto L88;
            case 5: goto L83;
            case 6: goto L78;
            case 7: goto L73;
            case 8: goto L68;
            case 9: goto L63;
            case 10: goto L58;
            case 11: goto L53;
            case 12: goto L48;
            case 13: goto L43;
            case 14: goto L38;
            case 15: goto L33;
            case 16: goto L28;
            case 17: goto L24;
            case 18: goto L23;
            case 19: goto L18;
            case 20: goto L13;
            case 21: goto L10;
            case 22: goto L8;
            case 23: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter((XmlSerializer) r10, "<this>");
        return Unit.INSTANCE;
    L6:
        XmlSerializer r12 = (XmlSerializer) r10;
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        XmlPullParserFactory r13 = x1.b.f22944a;
        x1.b.b(r12, w1.i.f22688b, new m(r11));
        x1.b.b(r12, w1.j.f22690b, new m(r11));
        x1.b.b(r12, w1.n.f22697b, new m(r11));
        x1.b.b(r12, w1.b.f22677b, new m(r11));
        return Unit.INSTANCE;
    L8:
        XmlSerializer r14 = (XmlSerializer) r10;
        Intrinsics.checkNotNullParameter(r14, "$this$insertTag");
        XmlPullParserFactory r15 = x1.b.f22944a;
        x1.b.b(r14, w1.j.f22690b, new m(r11));
        return Unit.INSTANCE;
    L10:
        XmlSerializer r16 = (XmlSerializer) r10;
        Intrinsics.checkNotNullParameter(r16, "$this$insertTag");
        r16.text("infinite");
        return Unit.INSTANCE;
    L24:
        CoroutineContext.Element r17 = (CoroutineContext.Element) r10;
        if ((r17 instanceof d1) == true) goto L27;
        return null;
    L27:
        return (d1) r17;
    L28:
        CoroutineContext.Element r18 = (CoroutineContext.Element) r10;
        if ((r18 instanceof z) == true) goto L31;
        return null;
    L31:
        return (z) r18;
    L92:
        String r19 = (String) r10;
        Intrinsics.checkNotNullParameter(r19, "originPart");
        String r20 = StringsKt.drop(r19, 1);
        Character r21 = StringsKt.o(r20);
        if (r21 == null) goto L149;
        char r22 = r21.charValue();
        UIOperationDef r23 = (UIOperationDef) g3.d.f17028a.get(r21);
        if (r23 == null) goto L120;
        String r24 = StringsKt.drop(r20, 2);
        if (r23 != UIOperationDef.d) goto L102;
        Integer r25 = StringsKt.toIntOrNull(r24.substring(0, 3));
        if (r25 == null) goto L116;
        List r26 = CollectionsKt.listOf(new g3.a(r23.f2837a, r24.substring(4), r25));
    L117:
        if (r26 == null) goto L120;
        return r26;
    L116:
        r26 = null;
        goto L117
    L102:
        if (com.bytedance.ai.uiu.d.f2829b.matches(r24) == false) goto L113;
        List r27 = StringsKt.K(r24, new String[]{"&&"}, 0, 6);
        ArrayList r28 = new ArrayList();
        Iterator r29 = r27.iterator();
    L105:
        if (r29.hasNext() == false) goto L112;
        Integer r30 = StringsKt.toIntOrNull((String) r29.next());
        if (r30 == null) goto L109;
        g3.a r31 = new g3.a(r23.f2837a, null, Integer.valueOf(r30.intValue()));
    L110:
        if (r31 == null) goto L105;
        r28.add(r31);
        goto L105
    L109:
        r31 = null;
        goto L110
    L112:
        r26 = r28;
        goto L117
    L113:
        String r32 = "parseOperation Invalid Operation: " + r20;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.UIUMessageFormatter", "tag");
        t0.d r33 = com.bytedance.ai.utils.c.f2846a;
        if (r33 == null) goto L116;
        r33.e("com.bytedance.ai.uiu.UIUMessageFormatter", r32);
    L120:
        String r34 = "parseUIOperations Unknown operation key=" + r22;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.UIUMessageFormatter", "tag");
        t0.d r35 = com.bytedance.ai.utils.c.f2846a;
        if (r35 == null) goto L151;
        r35.e("com.bytedance.ai.uiu.UIUMessageFormatter", r34);
        return null;
    L151:
        return null;
    L149:
        return null;
    L126:
        Intrinsics.checkNotNullParameter((Throwable) r10, ST.IMPLICIT_ARG_NAME);
        return Unit.INSTANCE;
    L128:
        Map.Entry r36 = (Map.Entry) r10;
        Intrinsics.checkNotNullParameter(r36, ST.IMPLICIT_ARG_NAME);
        return (com.bytedance.ai.model.widgets.a) r36.getValue();
    L13:
        if (((s1.d) r10).d.get() != null) goto L16;
        r5 = true;
    L16:
        return Boolean.valueOf(r5);
    L18:
        if (((s1.d) r10).d.get() != null) goto L21;
        r5 = true;
    L21:
        return Boolean.valueOf(r5);
    L23:
        return 30L;
    L33:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L36;
        return com.obric.oui.color.f.f12449z;
    L36:
        return com.obric.oui.color.f.A;
    L38:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L41;
        return com.obric.oui.color.f.f12446w;
    L41:
        return com.obric.oui.color.f.f12447x;
    L43:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L46;
        return com.obric.oui.color.f.f12443t;
    L46:
        return com.obric.oui.color.f.f12444u;
    L48:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L51;
        return com.obric.oui.color.f.f12441q;
    L51:
        return com.obric.oui.color.f.f12442r;
    L53:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L56;
        return com.obric.oui.color.f.f12436l;
    L56:
        return com.obric.oui.color.f.f12437m;
    L58:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L61;
        return com.obric.oui.color.f.f12433i;
    L61:
        return com.obric.oui.color.f.f12434j;
    L63:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L66;
        return com.obric.oui.color.f.f;
    L66:
        return com.obric.oui.color.f.g;
    L68:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L71;
        return com.obric.oui.color.f.L;
    L71:
        return com.obric.oui.color.f.M;
    L73:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L76;
        return com.obric.oui.color.f.I;
    L76:
        return com.obric.oui.color.f.J;
    L78:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L81;
        return com.obric.oui.color.f.F;
    L81:
        return com.obric.oui.color.f.G;
    L83:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L86;
        return com.obric.oui.color.f.C;
    L86:
        return com.obric.oui.color.f.D;
    L88:
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L91;
        return com.obric.oui.color.f.f12431c;
    L91:
        return com.obric.oui.color.f.d;
    L125:
        return AIPackageOperationGroup.a((AIPackageOperationGroup.Action) r10);
    }
}
