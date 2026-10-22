package com.larus.community.impl.component;

import android.view.View;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u1 {
    public final zp9.e a;
    public View b;

    public u1(zp9.e r2) {
        Intrinsics.checkNotNullParameter(r2, "initDependency");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final UserCreationModel r54, final List<com.larus.bmhome.view.screenmenu.l0> r55, final View r56, final bp8.a r57) {
        List r0 = r54.b();
        if (r0 == null) goto L32;
        final UserCreation r2 = (UserCreation) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L33;
        ArrayList r11 = new ArrayList();
        r11.addAll(r55);
        if (com.larus.platform.service.g0.a.e() == false) goto L13;
        if (AppHost.a.isTestChannel() == false) goto L13;
        r11.add(new com.larus.bmhome.view.screenmenu.l0(101, 0, "Debug", null, null, null, null, 2131241955, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
    L13:
        if (r11.isEmpty() == false) goto L16;
        m29.a.c("OpenLongClickMenuDialogHelper", "showMenu empty");
        return;
    L16:
        View r3 = CreateMenu.f(new CreateMenu(r56.getContext()), r11, 0, false, null, null, null, null, new t1(r56, r2, r55, this, r54, r57), 510);
        Balloon r1 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r56, r3, false, null, null, null, null, 124);
        if ((r56 instanceof z19.j) == false) goto L19;
        z19.j r4 = (z19.j) r56;
    L20:
        if (r4 == null) goto L24;
        Float r5 = r4.getLastMotionX();
        if (r5 == null) goto L24;
        int r6 = (int) r5.floatValue();
    L25:
        if (r4 == null) goto L29;
        Float r7 = r4.getLastMotionY();
        if (r7 == null) goto L29;
        int r8 = (int) r7.floatValue();
    L30:
        r1.v(r56, r6, r8);
        return;
    L29:
        r8 = r56.getHeight() / 2;
    L24:
        r6 = r56.getWidth() / 2;
        goto L25
    L19:
        r4 = null;
        goto L20
    L33:
        return;
    }
}
