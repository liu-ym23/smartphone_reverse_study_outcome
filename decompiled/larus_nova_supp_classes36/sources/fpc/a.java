package fpc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import epc.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Context a;
    public TenantCertificationData b;

    /* JADX INFO: renamed from: fpc.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0265a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TenantCertificationData.CertificateStatus.values().length];
            r0[TenantCertificationData.CertificateStatus.CERTIFICATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[TenantCertificationData.CertificateStatus.EXPIRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[TenantCertificationData.CertificateStatus.UNCERTIFICATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[TenantCertificationData.CertificateStatus.TEAM_CERTIFICATED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public final SpannableStringBuilder a() {
        TenantCertificationData r1 = this.b;     // Catch: Throwable -> L28
        if (r1 != null) goto L6;
    L27:
        return null;
    L6:
        if (Intrinsics.areEqual(r1.a, Boolean.TRUE) == false) goto L27;
        Drawable r5 = UIUtils.getDrawable(this.a, 2131256120);     // Catch: Throwable -> L28
        r5.setTint(UIUtils.getColor(this.a, 2131100666));     // Catch: Throwable -> L28
        TenantCertificationData r2 = this.b;     // Catch: Throwable -> L28
        if (r2 == null) goto L10;
        TenantCertificationData.CertificateStatus r3 = r2.b;     // Catch: Throwable -> L28
    L11:
        if (r3 != null) goto L13;
        int r4 = -1;
    L15:
        if (r4 != 1) goto L17;
        Context r6 = this.a;     // Catch: Throwable -> L28
        epc.a r7 = new epc.a(r6, r5, UIUtils.getString(r6, 2131892763), UIUtils.getColor(this.a, 2131109099), UIUtils.getColor(this.a, 2131109133));     // Catch: Throwable -> L28
    L23:
        if (r7 != null) goto L25;
        return null;
    L25:
        SpannableStringBuilder r8 = new SpannableStringBuilder().append("$");     // Catch: Throwable -> L28
        r8.setSpan(new b(r7), r8.length() - 1, r8.length(), 34);     // Catch: Throwable -> L28
        return r8;
    L17:
        if (r4 != 2) goto L19;
    L21:
        Context r9 = this.a;     // Catch: Throwable -> L28
        r7 = new epc.a(r9, null, UIUtils.getString(r9, 2131892762), UIUtils.getColor(this.a, 2131109109), UIUtils.getColor(this.a, 2131109115));     // Catch: Throwable -> L28
        goto L23
    L19:
        if (r4 == 3) goto L21;
        r7 = null;
        goto L23
    L13:
        r4 = C0265a.a[r3.ordinal()];     // Catch: Throwable -> L28
        goto L15
    L10:
        r3 = null;
    L28:
        th = move-exception;
        Log.e("TenantName", "TenantCertificationBuilder#build failed", th);
        return null;
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
