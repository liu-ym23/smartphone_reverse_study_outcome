package com.larus.sheet.impl;

import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import va8.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p implements pw9.d {
    public final /* synthetic */ SheetFragment a;

    public p(SheetFragment r1) {
        this.a = r1;
    }

    @Override // pw9.d
    public final void P(boolean r4) {
        FLogger.a.i("SheetFragment", "refSelectStateChange, isRefSelect:" + r4);
        SheetFragment r0 = this.a;
        int r1 = SheetFragment.R;
        Fragment r2 = ((OfficeBaseFragment) r0).f;
        if (r2 == null) goto L10;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L11;
        n0 r5 = r3.getAbility(n0.class);
        if (r5 == null) goto L12;
        r5.P(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // pw9.d
    public final void b(String r5) {
        if (r5 == null) goto L15;
        String r6 = r5.toLowerCase(Locale.ROOT);
        if (r6 == null) goto L16;
        int r0 = nw9.a.b;
        JSONObject r1 = this.a.t9();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("button_name_level_one", r6);     // Catch: JSONException -> L9
    L11:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("text_selection_bar_show");
        r2.a.merge(r7);
        r2.b();
        return;
    L9:
        e = move-exception;
        FLogger.a.e("SheetDetailTracer", "error in SheetDetailTracer reportOutputPreviewToolShow: " + e.getLocalizedMessage());
        goto L11
    L16:
        return;
    }

    @Override // pw9.d
    public final void a(String r2, String r3, Integer r4) {
        SheetFragment r0 = this.a;
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r0.G = r5;
        Fragment r6 = ((OfficeBaseFragment) this.a).f;
        if (r6 == null) goto L11;
        boolean r1 = true;
        if (r6.isAdded() != true) goto L11;
    L12:
        if (r1 == false) goto L14;
        this.a.fa0(r2, r3);
        return;
    L14:
        SheetFragment r7 = this.a;
        r7.E = r2;
        r7.F = r3;
        return;
    L11:
        r1 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }
}
