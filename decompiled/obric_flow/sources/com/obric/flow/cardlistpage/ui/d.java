package com.obric.flow.cardlistpage.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import com.zte.miboard.cards.common.MiddleJumpAty;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11768b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f11767a = r10;
        this.f11768b = r5;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        Object r10 = this.f11768b;
        switch(this.f11767a) {
            case 0: goto L15;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        MiddleJumpAty.b((Activity) r10, r5);
        return;
    L6:
        com.obric.oui.privacy.b r11 = (com.obric.oui.privacy.b) r10;
        Intrinsics.checkNotNullParameter(r11, "this$0");
        com.obric.oui.window.permission.c r12 = r11.e;
        if (r12 == null) goto L17;
        Intrinsics.checkNotNullParameter(r12, "this");
        PrivacyStatementActivity r13 = r12.f14920a;
        r13.getClass();
        String r14 = r13.getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r14 == null) goto L13;
        PrivacyStatementActivity.f14908x.remove(r14);
        PrivacyStatementActivity.f14909y.remove(r14);
        PrivacyStatementActivity.A.remove(r14);
        List r15 = (List) PrivacyStatementActivity.B.remove(r14);
    L13:
        r13.finish();
        return;
    L17:
        return;
    L15:
        int r16 = CardFeedLayout.f11536c0;
        CardFeedLayout r17 = (CardFeedLayout) r10;
        Intrinsics.checkNotNullParameter(r17, "this$0");
        r17.f11544j = false;
        r17.f11545k = null;
    }
}
