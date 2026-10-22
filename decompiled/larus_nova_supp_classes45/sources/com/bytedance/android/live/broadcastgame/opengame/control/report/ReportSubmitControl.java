package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialog;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ReportSubmitControl {
    public static final TokenCert n = null;
    public final ReqResultFragment a;
    public c b;
    public final g c;
    public UploadResult d;
    public final FragmentActivity e;
    public final q.a f;
    public final String g;
    public final long h;
    public final String i;
    public final boolean j;
    public final int k;
    public final boolean l;
    public final OpenGameReportDialog.InnerPageParams m;

    public static final class a {
    }

    static {
        n = TokenCert.Companion.with("bpea-live_reportsubmitcontrol_open_gallery");
    }

    public final void a() {
        FragmentManager r0 = this.e.getSupportFragmentManager();
        if (r0.findFragmentByTag(OpenGameReportSubmitDialog.class.getName()) != null) goto L9;
        FragmentTransaction r1 = r0.beginTransaction();
        ReqResultFragment r2 = this.a;
        String r3 = OpenGameReportSubmitDialog.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r3, 0) == true) goto L8;
        r1 = r1.add(r2, r3);
    L8:
        r1.commitNow();
        Unit r4 = Unit.INSTANCE;
    L9:
        com.bytedance.android.live.core.utils.q.l(this.e, this.a, 40003, n, null);
    }

    public final FragmentActivity getActivity() {
        return this.e;
    }

    public ReportSubmitControl(FragmentActivity r2, q.a r3, String r4, long r5, String r7, boolean r8, int r9, boolean r11, OpenGameReportDialog.InnerPageParams r12) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "reasonInfo");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r7, "appName");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r11;
        this.m = r12;
        ReqResultFragment r6 = new ReqResultFragment();
        this.a = r6;
        this.c = new g();
        Function2<Integer, Intent, Unit> r13 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r13, "callback");
        r6.d = r13;
    }
}
