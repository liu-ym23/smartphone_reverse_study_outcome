package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalinvite.view.a$a, reason: collision with other inner class name */
    public static final class C0174a implements com.ss.android.lark.utils.h.e {
        public final /* synthetic */ OfficeInviteExternalFragment a;

        public C0174a(OfficeInviteExternalFragment r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == true) goto L10;
            return;
        L10:
            Statistics.sendEvent("Scan_QRCode_Contacts", InvHitPoint.b(this.a.d).put("origination", "invite_external_contacts_scan").put("source", "add_external_contact"));     // Catch: JSONException -> L6
        L8:
            this.a.U90().startScanQRCodeActivity(this.a);
            Statistics.sendEvent("invite_people_external_Scan_QRCode_click", InvHitPoint.b(this.a.d));
            return;
        L6:
            e = move-exception;
            Log.e("InvHitPoint", e);
            goto L8
        }
    }

    public a(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        com.ss.android.lark.utils.h.b(this.a.getActivity(), new C0174a(this.a));
    }
}
