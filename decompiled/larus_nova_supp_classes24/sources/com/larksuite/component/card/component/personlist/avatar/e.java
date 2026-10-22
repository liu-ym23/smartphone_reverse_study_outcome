package com.larksuite.component.card.component.personlist.avatar;

import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements f {
    public final /* synthetic */ PersonAvatarGroupView.AvatarGroupAdapter a;

    public e(PersonAvatarGroupView.AvatarGroupAdapter r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.f
    public final void a(Map<String, wy7.c> r9) {
        Intrinsics.checkNotNullParameter(r9, "userMap");
        PersonAvatarGroupView.AvatarGroupAdapter r0 = this.a;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.a.getCurrentList().iterator();
    L4:
        if (r2.hasNext() == false) goto L46;
        PersonInfo r3 = (PersonInfo) r2.next();
        if (k.b(r3.getId()) == false) goto L45;
        if (r9.containsKey(r3.getId()) == false) goto L45;
        String r4 = r3.getAvatarKey();
        boolean r5 = false;
        if (r4 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        String r7 = null;
        if (r6 == false) goto L29;
        wy7.c r8 = r9.get(r3.getId());
        if (r8 == null) goto L21;
        String r10 = r8.a;
    L23:
        if (k.b(r10) == false) goto L29;
        wy7.c r11 = r9.get(r3.getId());
        if (r11 == null) goto L27;
        String r12 = r11.a;
    L28:
        r3.setAvatarKey(r12);
        goto L29
    L27:
        r12 = null;
        goto L28
    L21:
        r10 = null;
    L29:
        String r13 = r3.getContent();
        if (r13 != null) goto L32;
    L33:
        r5 = true;
    L34:
        if (r5 == false) goto L45;
        wy7.c r14 = r9.get(r3.getId());
        if (r14 == null) goto L38;
        String r15 = r14.b;
    L40:
        if (k.b(r15) == false) goto L45;
        wy7.c r16 = r9.get(r3.getId());
        if (r16 == null) goto L44;
        r7 = r16.b;
    L44:
        r3.setContent(r7);
        goto L45
    L38:
        r15 = null;
        goto L40
    L32:
        if (r13.length() != 0) goto L34;
    L12:
        if (r4.length() == 0) goto L15;
        r6 = false;
    L45:
        r1.add(r3);
        goto L4
    L46:
        r0.a.submitList(r1);
    }
}
