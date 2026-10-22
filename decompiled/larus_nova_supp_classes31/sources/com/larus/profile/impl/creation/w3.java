package com.larus.profile.impl.creation;

import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w3 implements zp9.s {
    public final /* synthetic */ ProfileCreationListFragmentV2 a;

    public w3(ProfileCreationListFragmentV2 r1) {
        this.a = r1;
    }

    @Override // zp9.s
    public final List a(UserCreationModel r91) {
        Intrinsics.checkNotNullParameter(r91, "userCreationModel");
        n3 r3 = this.a.m;
        if (r3 == null) goto L41;
        Intrinsics.checkNotNullParameter(r91, "userCreationModel");
        List<UserCreation> r0 = r91.b();
        if (r0 == null) goto L47;
        UserCreation r1 = (UserCreation) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L47;
        Integer r2 = r1.d;
        if (r2 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        ArrayList r5 = new ArrayList();
        Integer r6 = r1.c;
        if (r6 != null) goto L20;
    L21:
        if (r4 == true) goto L23;
    L25:
        r5.add(new com.larus.bmhome.view.screenmenu.l0(2131901248, 2131901248, null, null, null, 2131103136, null, 2131240232, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        if (r3.b == true) goto L28;
        return r5;
    L28:
        if (r4 == false) goto L30;
        int r9 = 2131900629;
    L31:
        if (r4 == false) goto L33;
        int r10 = 2131900629;
    L35:
        if (r4 == false) goto L37;
        int r7 = 2131240230;
    L38:
        r5.add(new com.larus.bmhome.view.screenmenu.l0(r9, r10, null, null, null, 2131103136, null, Integer.valueOf(r7), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        r5.add(new com.larus.bmhome.view.screenmenu.l0(2131900631, 2131900631, null, null, null, 2131102650, null, 2131243601, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        return r5;
    L37:
        r7 = 2131240225;
        goto L38
    L33:
        r10 = 2131899197;
        goto L35
    L30:
        r9 = 2131899197;
        goto L31
    L23:
        if (com.larus.bmhome.utils.u.e() == false) goto L25;
        r5.add(new com.larus.bmhome.view.screenmenu.l0(2131900631, 2131900631, null, null, null, 2131102650, null, 2131243601, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        return r5;
    L20:
        if (r6.intValue() != 5) goto L21;
        r5.add(new com.larus.bmhome.view.screenmenu.l0(2131900631, 2131900631, null, null, null, 2131102650, null, 2131243601, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        return r5;
    L13:
        if (r2.intValue() != 2) goto L15;
        r4 = true;
    L47:
        return CollectionsKt.emptyList();
    L41:
        return null;
    }
}
