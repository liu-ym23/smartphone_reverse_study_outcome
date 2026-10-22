package com.obric.oui.window.permission;

import android.content.DialogInterface;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createClickableSpan$1$onClick$1 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ b $linkClickListener;
    final /* synthetic */ String $title;
    final /* synthetic */ String $url;
    final /* synthetic */ PrivacyStatementActivity this$0;

    public PrivacyStatementActivity$createClickableSpan$1$onClick$1(PrivacyStatementActivity r5, String r10, b r11, String r12) {
        this.this$0 = r5;
        this.$url = r10;
        this.$title = r12;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo2invoke(DialogInterface r5, Integer r10) {
        invoke(r5, r10.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DialogInterface r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r5.dismiss();
        this.this$0.s = true;
        String r11 = this.$url;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() == 0) goto L10;
        PrivacyStatementActivity r12 = this.this$0;
        String r13 = this.$url;
        String r14 = this.$title;
        r12.getClass();
        Intent r15 = new Intent(r12, WebViewActivity.class);
        r15.putExtra("extra_url", r13);
        r15.putExtra("extra_title", r14);
        r12.startActivity(r15);
        return;
    }
}
