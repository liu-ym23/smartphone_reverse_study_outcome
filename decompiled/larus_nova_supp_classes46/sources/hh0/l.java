package hh0;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.plantform.dialog.AudienceTypeFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ AudienceTypeFragment a;

    public l(AudienceTypeFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        AudienceTypeFragment r3 = this.a;
        int r4 = AudienceTypeFragment.m;
        r3.ca0();
    }
}
