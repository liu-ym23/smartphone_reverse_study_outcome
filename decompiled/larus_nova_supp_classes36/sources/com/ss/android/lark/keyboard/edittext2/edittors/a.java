package com.ss.android.lark.keyboard.edittext2.edittors;

import android.text.SpannableStringBuilder;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends BaseFunctionEditor<hob.c> implements com.ss.android.lark.keyboard.edittext2.base.c {
    public static final C0137a e = null;
    public final Map<Class<? extends hob.c>, com.ss.android.lark.keyboard.edittext2.edittors.at.c<? extends hob.c>> c;
    public int d;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.a$a, reason: collision with other inner class name */
    public static final class C0137a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<a> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<a> a() {
            return this.a.a;
        }

        public C0137a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        e = new C0137a();
    }

    public a() {
        this.c = new LinkedHashMap();
        W(CollectionsKt.listOf(new com.ss.android.lark.keyboard.edittext2.edittors.at.common.b()));
    }

    public void V() {
        int r0 = com.ss.android.lark.keyboard.edittext2.utils.e.c(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this));
        if (r0 < 0) goto L6;
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r0, r0 + 1);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
        this.d = UDColorUtils.getColor(context(), 2131106607);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        ((com.ss.android.lark.keyboard.edittext2.edittors.at.c) r1.getValue()).A(getTarget());
        ((com.ss.android.lark.keyboard.edittext2.edittors.at.c) r1.getValue()).d();
        goto L4
    }

    public void U(com.ss.android.lark.keyboard.edittext2.edittors.at.c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        if (this.a == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r2.A(getTarget());
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void W(List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.c<?>> r4) {
        Intrinsics.checkNotNullParameter(r4, LocationHitPoint$ResultType.LIST);
        this.c.clear();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.ss.android.lark.keyboard.edittext2.edittors.at.c<? extends hob.c> r0 = (com.ss.android.lark.keyboard.edittext2.edittors.at.c) r5.next();
        this.c.put((Class<? extends hob.c>) r0.getType(), r0);
        U(r0);
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r5, hob.c r6, int r7) {
        hob.c r8 = r6;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r8, "data");
        boolean r1 = false;
        if (r8.a.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L26:
        Log.i("ATEditor", "onInsert: chatter id or chatter name is null. now return");
        return;
    L9:
        if (r8.b.length() != 0) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L26;
        if (r7 >= 0) goto L15;
    L25:
        Log.e("ATEditor", "on Insert: start = " + r7 + " is valid. no return");
        return;
    L15:
        if (r7 > r5.length()) goto L25;
        String r2 = "@" + r8.b;
        r5.append(r2);
        Object r3 = ((LinkedHashMap) this.c).get(r8.getClass());
        if ((r3 instanceof com.ss.android.lark.keyboard.edittext2.edittors.at.c) == false) goto L20;
        com.ss.android.lark.keyboard.edittext2.edittors.at.c r4 = (com.ss.android.lark.keyboard.edittext2.edittors.at.c) r3;
    L21:
        if (r4 == null) goto L23;
        r5.setSpan(r4.c(this, r8), r7, r2.length() + r7, 33);
    L24:
        V();
        return;
    L23:
        Log.w("ATEditor", "onInsert: not found atStrategy to handle data, id is " + r8.a);
        goto L24
    L20:
        r4 = null;
        goto L21
    L5:
        r0 = false;
        goto L7
    }
}
