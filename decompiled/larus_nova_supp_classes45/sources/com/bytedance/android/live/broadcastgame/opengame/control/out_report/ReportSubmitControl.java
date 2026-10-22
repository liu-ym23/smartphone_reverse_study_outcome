package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReqResultFragment;
import com.bytedance.android.live.broadcastgame.opengame.control.report.g;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ReportSubmitControl {
    public static final TokenCert i = null;
    public final ReqResultFragment a;
    public com.bytedance.android.live.broadcastgame.opengame.control.report.c b;
    public final g c;
    public UploadResult d;
    public final FragmentActivity e;
    public final q.a f;
    public final String g;
    public final String h;

    public static final class a {
    }

    static {
        i = TokenCert.Companion.with("bpea-live_reportsubmitcontrol_open_gallery");
    }

    public final void a() {
        FragmentManager r0 = this.e.getSupportFragmentManager();
        if (r0.findFragmentByTag(com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog.class.getName()) != null) goto L9;
        FragmentTransaction r1 = r0.beginTransaction();
        ReqResultFragment r2 = this.a;
        String r3 = com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r3, 0) == true) goto L8;
        r1 = r1.add(r2, r3);
    L8:
        r1.commitNow();
        Unit r4 = Unit.INSTANCE;
    L9:
        com.bytedance.android.live.core.utils.q.l(this.e, this.a, 40003, i, null);
    }

    public final FragmentActivity getActivity() {
        return this.e;
    }

    public ReportSubmitControl(FragmentActivity r2, q.a r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "reasonInfo");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appName");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        ReqResultFragment r6 = new ReqResultFragment();
        this.a = r6;
        this.c = new g();
        Function2<Integer, Intent, Unit> r7 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r7, "callback");
        r6.d = r7;
    }
}
