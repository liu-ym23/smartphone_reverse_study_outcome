package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.pb.chatters.PullUserAgreementResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends ClickableSpan {
    public final /* synthetic */ PullUserAgreementResponse.UserAgreement.UserAgreementContent a;
    public final /* synthetic */ Context b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        ContactBaseModuleDependency r4 = ContactBaseModuleDependency.b;
        String r0 = this.a.mlink_url;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "url");
        r4.openUrl(r0);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        r3.setColor(ContextCompat.getColor(this.b, 2131100677));
    }

    public a(PullUserAgreementResponse.UserAgreement.UserAgreementContent r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
