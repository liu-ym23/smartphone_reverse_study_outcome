package com.larus.setting.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.setting.impl.view.FontSizeSettingView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z0 implements FontSizeSettingView.b {
    public final /* synthetic */ FontAndThemeSettingFragment a;

    public z0(FontAndThemeSettingFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.setting.impl.view.FontSizeSettingView.b
    public final void a(int r3) {
        FontAndThemeSettingFragment r0 = this.a;
        int r1 = FontAndThemeSettingFragment.o;
        r0.h = r0.U90(r3);
        FontAndThemeSettingFragment r4 = this.a;
        r4.Y90(r4.h);
    }

    @Override // com.larus.setting.impl.view.FontSizeSettingView.b
    public final void b(int r5) {
        FontAndThemeSettingFragment r0 = this.a;
        int r1 = FontAndThemeSettingFragment.o;
        r0.h = r0.U90(r5);
        FontAndThemeSettingFragment r6 = this.a;
        r6.V90(r6.h, r6.g);
        this.a.X90(true);
        String r7 = this.a.getCurrentPage();
        String r2 = we8.f.a(this.a.h);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r7 != null) goto L12;
    L7:
        r3.put("to_status", r2);     // Catch: JSONException -> L5
    L10:
        TrackParams r8 = new TrackParams().merge(r3);
        by7.a r4 = new by7.a("click_adjust_text_size");
        r4.a.merge(r8);
        r4.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FontAndThemeEventHelper", "error in FontAndThemeEventHelper mobClickAdjustTextSize " + e.getLocalizedMessage());
        goto L10
    L12:
        r3.put("current_page", r7);     // Catch: JSONException -> L5
        goto L7
    }
}
