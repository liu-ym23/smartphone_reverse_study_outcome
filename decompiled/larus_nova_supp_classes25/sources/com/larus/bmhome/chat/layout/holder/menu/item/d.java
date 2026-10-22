package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131907406) goto L5;
        return true;
    L5:
        return false;
    }

    public d() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r17, View r18, ef8.b r19) {
        Intrinsics.checkNotNullParameter(r17, "item");
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "menuContext");
        Message r4 = r19.a;
        String r5 = c.c(r19);
        if (c.d(r19, r5) == false) goto L5;
        return true;
    L5:
        b r9 = c.b(r19);
        UplinkFileEntity r1 = c.a(r19, r5);
        if (r1 == null) goto L13;
        if (r9 == null) goto L12;
        UplinkFileEntity r6 = (UplinkFileEntity) r9.invoke(r1);
        if (r6 == null) goto L12;
        r1 = r6;
    L12:
        UplinkFileEntity r7 = r1;
    L14:
        ic8.o r2 = ic8.o.a;
        com.larus.bmhome.chat.api.q0.a r8 = r19.b;
        if (r8 == null) goto L21;
        com.larus.bmhome.chat.api.q0 r10 = r8.e();
        if (r10 == null) goto L21;
        Function0<Fragment> r11 = r10.getHostFragment();
        if (r11 == null) goto L21;
        Fragment r12 = (Fragment) r11.invoke();
    L22:
        JSONObject r0 = r19.l;
        if (r0 == null) goto L45;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<String> r14 = r0.keys();
    L27:
        if (r14.hasNext() == false) goto L43;
        String r15 = r14.next();
        Intrinsics.checkNotNull(r15);
        if (StringsKt.isBlank(r15) == true) goto L27;
        Object r16 = r0.opt(r15);
        if (r16 != null) goto L34;
    L40:
        String r110 = null;
    L41:
        r13.put(r15, r110);
        goto L27
    L34:
        if (Intrinsics.areEqual(r16, JSONObject.NULL) == true) goto L40;
        if ((r16 instanceof String) == false) goto L39;
        r110 = (String) r16;
        goto L41
    L39:
        r110 = r16.toString();
        goto L41
    L43:
        if ((!r13.isEmpty()) == false) goto L45;
    L46:
        r2.getClass();
        ic8.o.a(r18, r12, r4, r5, r7, "long_press_reply", r13, r9);
        return true;
    L45:
        r13 = null;
    L21:
        r12 = null;
        goto L22
    L13:
        r7 = null;
        goto L14
    }
}
