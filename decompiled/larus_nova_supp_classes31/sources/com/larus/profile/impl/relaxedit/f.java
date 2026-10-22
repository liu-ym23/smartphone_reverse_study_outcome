package com.larus.profile.impl.relaxedit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.profile.impl.viewmodel.ProfileEditViewModel;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final Fragment a;
    public final Activity b;
    public ProfileEditViewModel c;
    public final Lazy d;
    public r38.b e;
    public final boolean f;
    public final String g;
    public String h;
    public String i;
    public Callback j;
    public String k;
    public String l;
    public String m;
    public Callback n;
    public boolean o;

    public final Map<String, Object> c() {
        q38.a r0 = ILoginService.a.getAccountInfo();
        r38.b r1 = this.e;
        if (r1 != null) goto L5;
        r1 = IAccountService.a.getUserInfo();
        this.e = r1;
    L5:
        Pair[] r2 = new Pair[13];
        r2[0] = TuplesKt.to("userId", r0.c);
        String r3 = null;
        if (r1 == null) goto L8;
        String r4 = r1.d();
    L9:
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r2[1] = TuplesKt.to("nickName", r4);
        if (r1 == null) goto L15;
        String r6 = r1.g();
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r2[2] = TuplesKt.to("userName", r6);
        if (r1 == null) goto L23;
        AvatarInfo r7 = r1.a();
        if (r7 == null) goto L23;
        String r8 = r7.a();
    L24:
        if (r8 != null) goto L26;
        r8 = "";
    L26:
        r2[3] = TuplesKt.to("avatarUrl", r8);
        if (r1 == null) goto L29;
        boolean r9 = r1.i();
    L30:
        r2[4] = TuplesKt.to("isDefaultAvatar", Boolean.valueOf(r9));
        r2[5] = TuplesKt.to("isEnterpriseAccount", Boolean.valueOf(r0.g));
        if (r1 == null) goto L35;
        r38.a r10 = r1.e();
        if (r10 == null) goto L35;
        r3 = r10.b();
    L35:
        if (r3 == null) goto L38;
        r5 = r3;
    L38:
        r2[6] = TuplesKt.to("enterpriseDisplayName", r5);
        r2[7] = TuplesKt.to("enterFrom", this.g);
        if (this.f == false) goto L41;
        String r11 = "account";
    L42:
        r2[8] = TuplesKt.to("scene", r11);
        r2[9] = TuplesKt.to("platform", "android");
        r2[10] = TuplesKt.to("isOversea", Boolean.valueOf(AppHost.a.isOversea()));
        boolean r12 = v19.h.a;
        r2[11] = TuplesKt.to("isDarkMode", Boolean.valueOf(v19.h.b(this.b)));
        r2[12] = TuplesKt.to("avatarEditable", Boolean.valueOf(!r0.g));
        return MapsKt.mapOf(r2);
    L41:
        r11 = "default";
        goto L42
    L29:
        r9 = true;
    L23:
        r8 = null;
        goto L24
    L15:
        r6 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }

    public static void a(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void b(JavaOnlyMap r4) {
        Callback r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        this.j = null;
        r0.invoke(new Object[]{r4});
    }

    public final void d(ProfileEditViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        this.c = r5;
        r5.getUserNameAvailable().observe(this.a.getViewLifecycleOwner(), new g.a(new b(this)));
        r5.getEditProfileState().observe(this.a.getViewLifecycleOwner(), new g.a(new c(this)));
    }

    public final JavaOnlyMap e(boolean r8) {
        if (r8 == false) goto L11;
        CommonDialog.a r9 = new CommonDialog.a();
        r9.i(this.b.getString(2131909224));
        CommonDialog.a.f(r9, new d(this), this.b.getString(2131909222), false, 12);
        CommonDialog.a.e(r9, new e(), this.b.getString(2131909223), 4);
        CommonDialog r10 = r9.c();
        FragmentManager r4 = this.a.getChildFragmentManager();
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, null, r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r10, r5) == false) goto L14;
    L9:
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putBoolean("closed", false);
        r11.putBoolean("pendingConfirm", true);
        return r11;
    L14:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        r10.show(r4, null);
        goto L9
    L11:
        this.b.finish();
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putBoolean("closed", true);
        r12.putBoolean("pendingConfirm", false);
        return r12;
    }

    public f(Fragment r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.a = r3;
        this.b = r4;
        this.d = LazyKt.lazy(new a(this));
        this.e = IAccountService.a.getUserInfo();
        Intent r5 = r4.getIntent();
        String r0 = null;
        if (r5 == null) goto L7;
        Uri r6 = r5.getData();
        if (r6 == null) goto L7;
        String r7 = UriProtector.getQueryParameter(r6, "scene");
    L8:
        this.f = Intrinsics.areEqual(r7, "account");
        Bundle r8 = r3.getArguments();
        String r9 = "setting";
        if (r8 == null) goto L20;
        String r10 = r8.getString("enter_from", "setting");
        if (r10 == null) goto L20;
        if (r10.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        r0 = r10;
    L18:
        if (r0 == null) goto L20;
        r9 = r0;
        goto L20
    L15:
        r1 = false;
    L20:
        this.g = r9;
        this.h = "";
        this.i = "";
        this.k = "";
        this.l = "";
        this.m = "";
        return;
    L7:
        r7 = null;
        goto L8
    }
}
