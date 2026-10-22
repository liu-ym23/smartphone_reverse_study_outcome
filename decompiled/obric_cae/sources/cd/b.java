package cd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.obric.cae.R;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import com.obric.oui.window.permission.WebViewActivity;
import gc.g;
import gc.h;
import ge.p;
import he.i;
import he.j;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyStatementActivity f3432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3433b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Context f3435n;

    public static final class a extends j implements p<DialogInterface, Integer, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f3436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrivacyStatementActivity.a f3437b;

        public a(b r8, PrivacyStatementActivity.a r10) {
            this.f3436a = r8;
            this.f3437b = r10;
            super(2);
        }

        @Override // ge.p
        public final xd.j invoke(DialogInterface r8, Integer r10) {
            DialogInterface r11 = r8;
            r10.intValue();
            i.f(r11, "dialog");
            r11.dismiss();
            b r12 = this.f3436a;
            boolean r13 = true;
            r12.f3432a.f6693a = true;
            String r14 = r12.f3433b;
            if (r14 != null) goto L5;
        L8:
            if (r13 == true) goto L14;
            PrivacyStatementActivity.a r15 = this.f3437b;
            if (r15 == null) goto L12;
            r15.a();
            goto L14
        L12:
            PrivacyStatementActivity r16 = r12.f3432a;
            r16.getClass();
            Intent r17 = new Intent(r16, WebViewActivity.class);
            r17.putExtra("extra_url", r14);
            r17.putExtra("extra_title", r12.f3434m);
            r16.startActivity(r17);
        L14:
            return xd.j.f13877a;
        L5:
            if (r14.length() == 0) goto L8;
            r13 = false;
            goto L8
        }
    }

    /* JADX INFO: renamed from: cd.b$b, reason: collision with other inner class name */
    public static final class C0043b extends j implements p<DialogInterface, Integer, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0043b f3438a = null;

        static {
            f3438a = new C0043b();
        }

        public C0043b() {
            super(2);
        }

        @Override // ge.p
        public final xd.j invoke(DialogInterface r8, Integer r10) {
            DialogInterface r11 = r8;
            r10.intValue();
            i.f(r11, "dialog");
            r11.dismiss();
            return xd.j.f13877a;
        }
    }

    public b(PrivacyStatementActivity r8, String r10, String r11, Context r12) {
        this.f3432a = r8;
        this.f3433b = r10;
        this.f3434m = r11;
        this.f3435n = r12;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r8) {
        i.f(r8, "widget");
        LinkedHashMap r10 = PrivacyStatementActivity.f6691q;
        PrivacyStatementActivity r11 = this.f3432a;
        PrivacyStatementActivity.a r12 = (PrivacyStatementActivity.a) r10.get(r11.getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        boolean r13 = r11.f6694b;
        boolean r14 = true;
        String r15 = this.f3433b;
        if (r13 == true) goto L14;
        if (r15 != null) goto L6;
    L9:
        if (r14 == true) goto L26;
        if (r12 == null) goto L27;
        r12.a();
        return;
    L27:
        return;
    L26:
        return;
    L6:
        if (r15.length() == 0) goto L9;
        r14 = false;
        goto L9
    L14:
        if (r11.f6693a == false) goto L24;
        if (r15 != null) goto L17;
    L20:
        if (r14 == true) goto L28;
        if (r12 == null) goto L23;
        r12.a();
        return;
    L23:
        Intent r16 = new Intent(r11, WebViewActivity.class);
        r16.putExtra("extra_url", r15);
        r16.putExtra("extra_title", this.f3434m);
        r11.startActivity(r16);
        return;
    L28:
        return;
    L17:
        if (r15.length() == 0) goto L20;
        r14 = false;
        goto L20
    L24:
        gc.i r17 = new gc.i(r11);
        r17.f7826s = false;
        String r18 = r11.getString(R.string.privacy_permisssion_dialog_title);
        r17.f7816i = false;
        r17.f7814g = r18;
        r17.f7815h = r11.getString(R.string.privacy_permisssion_dialog_message);
        String r19 = r11.getString(R.string.oui_agree);
        i.e(r19, "getString(R.string.oui_agree)");
        a r20 = new a(this, r12);
        r17.f7822o = r19;
        r17.f7823p = new h(r20);
        String r21 = r11.getString(R.string.oui_cancel_only);
        i.e(r21, "getString(R.string.oui_cancel_only)");
        C0043b r22 = C0043b.f3438a;
        i.f(r22, "listener");
        r17.f7819l = r21;
        r17.f7820m = new g(r22);
        r17.a().show();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r8) {
        i.f(r8, "ds");
        super.updateDrawState(r8);
        Object r10 = androidx.core.content.a.f1674a;
        r8.setColor(androidx.core.content.a.c.a(this.f3435n, R.color.oui_fill_highlighted));
        r8.setUnderlineText(false);
    }
}
