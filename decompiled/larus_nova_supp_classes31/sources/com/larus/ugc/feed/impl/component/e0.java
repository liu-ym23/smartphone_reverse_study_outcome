package com.larus.ugc.feed.impl.component;

import android.view.View;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.business.debug.api.IDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.CollectionType;
import com.larus.profile.api.bean.UserCreationModel;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 {
    public final zp9.e a;
    public View b;

    public e0(zp9.e r2) {
        Intrinsics.checkNotNullParameter(r2, "initDependency");
        this.a = r2;
    }

    public final void a(final UserCreationModel r54, final List<l0> r55, final View r56, final bp8.a r57) {
        List<UserCreation> r0 = r54.b();
        if (r0 == null) goto L37;
        final UserCreation r2 = (UserCreation) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L38;
        ArrayList r11 = new ArrayList();
        r11.addAll(r55);
        IDebugService r1 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r1 == null) goto L12;
        boolean r3 = true;
        if (r1.e() != true) goto L12;
    L13:
        if (r3 == false) goto L18;
        if (AppHost.a.isTestChannel() == false) goto L18;
        r11.add(new l0(CollectionType.SINGLE_QISHUI_ALBUM, 0, "Debug", null, null, null, null, 2131241955, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
    L18:
        if (r11.isEmpty() == false) goto L21;
        w0a.a.c("OpenLongClickMenuDialogHelper", "showMenu empty");
        return;
    L21:
        View r4 = CreateMenu.f(new CreateMenu(r56.getContext()), r11, 0, false, null, null, null, null, new d0(r56, r2, r55, this, r54, r57), 510);
        Balloon r5 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r56, r4, false, null, null, null, null, 124);
        if ((r56 instanceof z19.j) == false) goto L24;
        z19.j r6 = (z19.j) r56;
    L25:
        if (r6 == null) goto L29;
        Float r7 = r6.getLastMotionX();
        if (r7 == null) goto L29;
        int r8 = (int) r7.floatValue();
    L30:
        if (r6 == null) goto L34;
        Float r9 = r6.getLastMotionY();
        if (r9 == null) goto L34;
        int r10 = (int) r9.floatValue();
    L35:
        r5.v(r56, r8, r10);
        return;
    L34:
        r10 = r56.getHeight() / 2;
    L29:
        r8 = r56.getWidth() / 2;
        goto L30
    L24:
        r6 = null;
    L12:
        r3 = false;
        goto L13
    L38:
        return;
    }
}
