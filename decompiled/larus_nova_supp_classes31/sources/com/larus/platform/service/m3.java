package com.larus.platform.service;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.bot.BotMakerDataModel;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;
import nq9.c;
import nq9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m3 implements com.larus.platform.api.t3 {
    public static final m3 a = null;
    public static final Lazy b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;

    public m3() {
    }

    static {
        a = new m3();
        b = LazyKt.lazy(new l3());
        com.larus.platform.api.t3 r0 = s();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.e();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        c = r2;
        com.larus.platform.api.t3 r4 = s();
        if (r4 == null) goto L12;
        String r5 = r4.getPrivacyPolicyUrl();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        d = r5;
        com.larus.platform.api.t3 r6 = s();
        if (r6 == null) goto L18;
        String r7 = r6.m();
    L19:
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        e = r7;
        com.larus.platform.api.t3 r8 = s();
        if (r8 == null) goto L24;
        String r9 = r8.k();
    L25:
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        f = r9;
        com.larus.platform.api.t3 r10 = s();
        if (r10 == null) goto L30;
        String r11 = r10.j();
    L31:
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        g = r11;
        com.larus.platform.api.t3 r12 = s();
        if (r12 == null) goto L36;
        String r13 = r12.a();
    L37:
        if (r13 != null) goto L39;
        r13 = "";
    L39:
        h = r13;
        com.larus.platform.api.t3 r14 = s();
        if (r14 == null) goto L42;
        r1 = r14.h();
    L42:
        if (r1 == null) goto L45;
        r3 = r1;
    L45:
        i = r3;
        return;
    L36:
        r13 = null;
        goto L37
    L30:
        r11 = null;
        goto L31
    L24:
        r9 = null;
        goto L25
    L18:
        r7 = null;
        goto L19
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public static com.larus.platform.api.t3 s() {
        return (com.larus.platform.api.t3) b.getValue();
    }

    public final void b() {
        com.larus.platform.api.t3 r0 = s();
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Deprecated(message = "not recommend", replaceWith = @ReplaceWith(expression = "IBotService::class.getService()?.registerBotChangeListener", imports = {}))
    public final d1<nq9.b> c() {
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final BottomSheetDialogFragment l() {
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l();
    }

    public final f o() {
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o();
    }

    public final int r() {
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.r();
    }

    public final String a() {
        return h;
    }

    public final String e() {
        return c;
    }

    public final String getPrivacyPolicyUrl() {
        return d;
    }

    public final String h() {
        return i;
    }

    public final String j() {
        return g;
    }

    public final String k() {
        return f;
    }

    public final String m() {
        return e;
    }

    public final BotMakerDataModel g(String r2) {
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(r2);
    }

    public final void n(Message r2) {
        com.larus.platform.api.t3 r0 = s();
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    public final zp9.u p(Context r2) {
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p(r2);
    }

    public final sq9.t q(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q(r2);
    }

    public final void Z0(FragmentManager r2, sq9.j r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "creationImageShareModel");
        com.larus.platform.api.t3 r0 = s();
        if (r0 == null) goto L6;
        r0.Z0(r2, r3);
        return;
    }

    public final c i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i(r2, r3);
    }

    public final void d(Context r2, BotModel r3, by7.e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "botInfo");
        Intrinsics.checkNotNullParameter(r4, "trackNode");
        com.larus.platform.api.t3 r0 = s();
        if (r0 == null) goto L6;
        r0.d(r2, r3, r4);
        return;
    }

    public final nq9.e f(Fragment r2, Bundle r3, by7.e r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "trackNode");
        com.larus.platform.api.t3 r0 = s();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f(r2, r3, r4);
    }
}
