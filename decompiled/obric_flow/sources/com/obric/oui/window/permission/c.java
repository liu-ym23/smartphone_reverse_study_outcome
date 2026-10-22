package com.obric.oui.window.permission;

import android.content.DialogInterface;
import android.content.Intent;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$string;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyStatementActivity f14920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f14921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f14922c;
    public final /* synthetic */ String d;

    public c(PrivacyStatementActivity r5, List r10, String[] r11, String r12) {
        this.f14920a = r5;
        this.f14921b = r10;
        this.f14922c = r11;
        this.d = r12;
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "linkText");
        if (r10.length() != 0) goto L5;
        return;
    L5:
        List r5 = this.f14921b;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isEmpty() == true) goto L25;
        final String r11 = this.f14922c[r5.indexOf(r10)];
        final PrivacyStatementActivity r12 = this.f14920a;
        if (r12.f14911t == true) goto L13;
        return;
    L13:
        boolean r13 = r12.s;
        final String r14 = this.d;
        if (r13 == false) goto L20;
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.length() == 0) goto L26;
        Intent r15 = new Intent(r12, WebViewActivity.class);
        r15.putExtra("extra_url", r11);
        r15.putExtra("extra_title", r14);
        r12.startActivity(r15);
        return;
    L26:
        return;
    L20:
        com.obric.oui.dialog.v2.alert.e r16 = new com.obric.oui.dialog.v2.alert.e(r12);
        r16.s = false;
        String r17 = r12.getString(R$string.privacy_permisssion_dialog_title);
        r16.f13159i = false;
        r16.g = r17;
        r16.f13158h = r12.getString(R$string.privacy_permisssion_dialog_message);
        String r18 = r12.getString(R$string.oui_agree);
        final b r19 = null;
        Function2<DialogInterface, Integer, Unit> r20 = new PrivacyStatementActivity$showSheetDialog$1$onPrivacyPolicyClicked$1(r12, r11, r19, r14);
        Intrinsics.checkNotNullParameter(r18, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r20, "listener");
        r16.f13165o = r18;
        r16.f13166p = new com.obric.oui.dialog.v2.alert.c(r20, 1);
        String r21 = r12.getString(R$string.oui_cancel_only);
        PrivacyStatementActivity$showSheetDialog$1$onPrivacyPolicyClicked$2 r22 = PrivacyStatementActivity$showSheetDialog$1$onPrivacyPolicyClicked$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r21, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r22, "listener");
        r16.f13162l = r21;
        r16.f13163m = new com.obric.oui.dialog.v2.alert.c(r22, 0);
        r16.a().show();
        return;
    }
}
