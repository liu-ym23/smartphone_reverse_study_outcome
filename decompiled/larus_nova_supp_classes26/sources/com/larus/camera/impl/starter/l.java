package com.larus.camera.impl.starter;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ InputParam b;
    public final /* synthetic */ OutputParam c;
    public final /* synthetic */ Uri d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ l(FragmentActivity r1, InputParam r2, OutputParam r3, Uri r4, String r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = false;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }

    public final Object invoke() {
        final FragmentActivity r3 = this.a;
        InputParam r0 = this.b;
        OutputParam r1 = this.c;
        final Uri r5 = this.d;
        final boolean r2 = this.e;
        final String r4 = this.f;
        final boolean r6 = this.g;
        final boolean r7 = this.h;
        FLogger.a.i("CameraStarter", "open on resume");
        FragmentManager r8 = r3.getSupportFragmentManager();
        Fragment r10 = r8.findFragmentByTag("com.larus.camera.impl.starter.CameraStarter");
        String r12 = null;
        if ((r10 instanceof CameraStarter) == false) goto L5;
        CameraStarter r11 = (CameraStarter) r10;
    L6:
        if (r11 == null) goto L8;
        r8.beginTransaction().remove(r11).commitNow();
    L8:
        final CameraStarter r13 = new CameraStarter();
        Bundle r14 = new Bundle();
        r14.putSerializable("STARTER_INPUT_PARAM", r0);
        r14.putSerializable("STARTER_OUTPUT_PARAM", r1);
        if (r5 == null) goto L11;
        r12 = r5.toString();
    L11:
        r14.putString("STARTER_ALBUM_URI", r12);
        r13.setArguments(r14);
        FragmentTransaction r9 = r8.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "com.larus.camera.impl.starter.CameraStarter", 0) == true) goto L15;
        r9 = r9.add(r13, "com.larus.camera.impl.starter.CameraStarter");
    L15:
        r9.commitNow();
        t0.a.post(new o(r2, r13, r3, r4, r5, r6, r7));
        return Unit.INSTANCE;
    L5:
        r11 = null;
        goto L6
    }
}
