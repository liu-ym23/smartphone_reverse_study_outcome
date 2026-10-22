package z00;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.PermissionGrantStatus;
import com.bytedance.android.livesdk.utils.j2;
import com.bytedance.android.livesdk.utils.k2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ k a;

    public /* synthetic */ d(k r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        k r5 = this.a;
        r5.d.v();
        k2 r6 = r5.d;
        r6.getClass();
        jc1.k.f(IRoomService.class).savePermissionGrantStatus(PermissionGrantStatus.GRANT_DOING);
        r6.f = String.valueOf(System.currentTimeMillis());
        String[] r7 = r6.b.getStringArray(2130903114);
        AlertDialog.Builder r0 = new AlertDialog.Builder(r6.a);
        r0.setItems(r7, new j2(r6));
        r0.setCancelable(false);
        r0.show();
    }
}
