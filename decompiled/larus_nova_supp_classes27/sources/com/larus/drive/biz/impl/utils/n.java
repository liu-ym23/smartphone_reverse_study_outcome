package com.larus.drive.biz.impl.utils;

import android.content.Context;
import android.view.View;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.j0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.q0;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.drive.biz.impl.view.DriveMainFragment;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.radius.RadiusLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public n() {
    }

    public static String a(Map r18, int r110) {
        Intrinsics.checkNotNullParameter(r18, "map");
        Iterator r1 = r18.entrySet().iterator();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r1.hasNext() == false) goto L13;
        DriveUploadStatus r6 = ((com.larus.drive.biz.api.model.a) ((Map.Entry) r1.next()).getValue()).f;
        if (r6 == DriveUploadStatus.FINISH) goto L7;
        if (r6 != DriveUploadStatus.FAILED) goto L4;
        r5 = r5 + 1;
    L11:
        r3 = r3 + 1;
        goto L4
    L7:
        r4 = r4 + 1;
        goto L11
    L13:
        if (r110 == 1) goto L22;
        if (r110 == 2) goto L31;
        if (r110 == 3) goto L30;
        return "";
    L30:
        return StringsKt.replace$default(AppHost.a.getApplication().getString(2131905403), "%s", String.valueOf(r4), false, 4, null);
    L31:
        return StringsKt.replace$default(StringsKt.replace$default(AppHost.a.getApplication().getString(2131905427), "%1$s", String.valueOf(r4), false, 4, null), "%2$s", String.valueOf(r5), false, 4, null);
    L22:
        return AppHost.a.getApplication().getString(2131905404) + ' ' + r3 + '/' + r18.size();
    }

    public static void b(Context r9, final View r10, List r11, final JSONObject r12, final DriveMainFragment r13, final Function1 r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 16) == 0) goto L8;
        r13 = null;
    L8:
        Intrinsics.checkNotNullParameter(r10, "anchor");
        Intrinsics.checkNotNullParameter(r11, "items");
        Intrinsics.checkNotNullParameter(r14, "clickListener");
        if (r9 == null) goto L25;
        CommonMenu r16 = new CommonMenu(r9);
        r16.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r16.h(Reflection.getOrCreateKotlinClass(l0.class), new q0());
        r16.d(i5.B());
        r16.g(r11, new k(r12, r13, r14, r10));
        boolean r17 = com.larus.utils.i.h(r9);
        Balloon r18 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r10, r16.i(), false, null, null, null, new l(), 56);
        int r110 = r10.getMeasuredWidth();
        if (r17 == false) goto L14;
        r110 = -r110;
    L14:
        final int r111 = i5.E();
        if (r17 == false) goto L17;
        r111 = -r111;
    L17:
        r18.x(r10, r110, -i5.Q());
        final RadiusLayout r20 = r18.c.d;
        r20.post(new m(r20, r111));
        if (r12 != null) goto L20;
        r12 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.put("show_from", "click_plus");
        r12.put("panel_type", "create");
        TrackParams r21 = new TrackParams().merge(r12);
        by7.a r112 = new by7.a("ai_space_create_upload_panel_show");
        if (r13 == null) goto L23;
        r112.b = r13;
    L23:
        r112.a.merge(r21);
        r112.b();
        return;
    }
}
