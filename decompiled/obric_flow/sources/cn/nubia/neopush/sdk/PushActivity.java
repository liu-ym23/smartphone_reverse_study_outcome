package cn.nubia.neopush.sdk;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PushActivity extends Activity {
    public PushActivity() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        NeoLog.i("luzhi", "PushActivity oncreate");
        Intent r11 = getIntent();
        NeoLog.i("PushMessageHandler onHandleIntent=" + getPackageName());     // Catch: Exception -> L18
        if (r11 != null) goto L6;
    L25:
        finish();
        return;
    L6:
        if (Constant.RECEIVE_MESSAGE_ACTION.equals(r11.getAction()) == false) goto L25;
        Intent r5 = new Intent(Constant.RECEIVE_MESSAGE_ACTION);     // Catch: Exception -> L18
        r5.setPackage(getPackageName());     // Catch: Exception -> L18
        r5.putExtras(r11);     // Catch: Exception -> L18
        List<ResolveInfo> r12 = getPackageManager().queryBroadcastReceivers(r5, 32);     // Catch: Exception -> L18
        if (r12 == null) goto L20;
        Iterator<ResolveInfo> r13 = r12.iterator();     // Catch: Exception -> L18
    L11:
        if (r13.hasNext() == false) goto L20;
        ActivityInfo r14 = r13.next().activityInfo;     // Catch: Exception -> L18
        if (r14 == null) goto L11;
        if (r14.packageName.equals(getPackageName()) == false) goto L11;
        NeoLog.i("PushMessageHandler hasActivityInfo");     // Catch: Exception -> L18
    L21:
        if (r14 == null) goto L25;
        ((PushMessageReceiver) Class.forName(r14.name).newInstance()).onReceive(getApplicationContext(), r5);     // Catch: Exception -> L18
    L20:
        r14 = null;
    L18:
        e = move-exception;
        NeoLog.i("PushMessageHandler onHandleIntent=" + e.getMessage());
        goto L25
    }
}
