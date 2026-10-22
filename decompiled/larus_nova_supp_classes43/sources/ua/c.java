package ua;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.anniex.bd.foundation.impl.m;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import com.bytedance.salamander.anniex.AnnieXNavBarViewModel;
import com.bytedance.salamander.anniex.AnnieXStatusFontMode;
import com.bytedance.salamander.anniex.g;
import com.bytedance.salamander.anniex.r0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends b implements ia.d {
    public final Activity e;
    public final r0 f;

    @Override // ia.e
    public final void a(View r1) {
    }

    @Override // ia.e
    public final void b(View r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // ia.c
    public final String getViewType() {
        return AIStateLogRequest.SOURCE_PAGE;
    }

    @Override // ia.d
    public final void j(na.b r1) {
    }

    @Override // ia.h
    public final void k(boolean r1) {
    }

    @Override // ia.d
    public final void l(ia.d.a r10) {
        Intrinsics.checkNotNullParameter(r10, "pageComponent");
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r1) {
    }

    @Override // ia.e
    public final void onActivityResult(int r1, int r10, Intent r11) {
    }

    @Override // ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
    }

    @Override // ia.e
    public final void onDestroy() {
    }

    @Override // ia.d, ia.e
    public final void onPause() {
    }

    @Override // ia.e
    public final void onResume() {
    }

    @Override // ia.e
    public final void onStart() {
    }

    @Override // ia.e
    public final void onStop() {
    }

    @Override // ia.e
    public final void setUserVisibleHint(boolean r1) {
    }

    @Override // ia.c
    public final void close() {
        this.e.finish();
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        r0 r0 = this.f;
        g r1 = new g();
        r1.a = new m(r10);
        r0.p(r1);
        return true;
    }

    @Override // ia.h
    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
        g r0 = new g();
        r0.a = new m(r10);
        this.f.l(r0);
        return true;
    }

    @Override // ia.h
    public final void f(boolean r10) {
        boolean r11 = !r10;
        AnnieXNavBarViewModel r0 = ((AnnieXCommonUIViewModel) this.f).l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_navBarViewModel");
        r0 = null;
    L5:
        r0.a(r11);
    }

    @Override // ia.g
    public final void n(boolean r10) {
        this.f.o(r10);
    }

    @Override // ia.h
    public final boolean p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        g r0 = new g();
        r0.a = new m(r10);
        this.f.n(r0);
        return true;
    }

    @Override // ia.g
    public final boolean setStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        if (Intrinsics.areEqual(r10, "light") == false) goto L7;
        this.f.r(AnnieXStatusFontMode.LIGHT);
        return true;
    L7:
        if (Intrinsics.areEqual(r10, "dark") == false) goto L10;
        this.f.r(AnnieXStatusFontMode.DARK);
        return true;
    L10:
        return false;
    }

    @Override // ia.h
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        this.f.m(r10, true);
    }

    public c(Activity r10, r0 r11, t36.d r12, Function1<? super Boolean, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "annieXPageViewModel");
        Intrinsics.checkNotNullParameter(r12, "schemaData");
        super(r10, r11, r12, r13);
        this.e = r10;
        this.f = r11;
    }
}
