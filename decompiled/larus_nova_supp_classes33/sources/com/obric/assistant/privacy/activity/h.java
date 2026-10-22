package com.obric.assistant.privacy.activity;

import com.larus.network.HttpConst;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements com.obric.oui.privacy.i {
    public final /* synthetic */ ObricPrivacyAgreeActivity a;

    public final void a() {
        FLogger.a.i("ObricPrivacyActivity", "click disagree");
        ObricPrivacyAgreeActivity.O1(this.a);
    }

    public final void b() {
        FLogger.a.i("ObricPrivacyActivity", "click agree");
        ObricPrivacyAgreeActivity r0 = this.a;
        int r1 = ObricPrivacyAgreeActivity.n;
        r0.Q1();
    }

    public final void onBackPressed() {
        FLogger.a.i("ObricPrivacyActivity", "click onBackPressed");
        ObricPrivacyAgreeActivity.O1(this.a);
    }

    public final void onDismiss() {
        Intrinsics.checkNotNullParameter(this, "this");
    }

    public h(ObricPrivacyAgreeActivity r1) {
        this.a = r1;
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "linkText");
        if (Intrinsics.areEqual(r3, this.a.getString(2131912376)) == false) goto L6;
        ObricPrivacyAgreeActivity r4 = this.a;
        HttpConst.a.getClass();
        ObricPrivacyAgreeActivity.N1(r4, HttpConst.M);
        return;
    L6:
        if (Intrinsics.areEqual(r3, this.a.getString(2131912345)) == false) goto L9;
        ObricPrivacyAgreeActivity.N1(this.a, "https://www.doubao.com/ocean_legal/terms");
        return;
    L9:
        if (Intrinsics.areEqual(r3, this.a.getString(2131912346)) == false) goto L14;
        ObricPrivacyAgreeActivity r5 = this.a;
        HttpConst.a.getClass();
        ObricPrivacyAgreeActivity.N1(r5, HttpConst.L);
        return;
    }
}
