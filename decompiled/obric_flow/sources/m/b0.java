package m;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.zte.miboard.recommend.agent.data.FlightOrTrainInfo;
import com.zte.miboard.recommend.agent.data.IntelligentAgentData;
import kotlin.collections.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 extends d {
    public static Uri a(Context r5) {
        if (r5 != null) goto L4;
    L6:
        String r10 = "content://com.zte.miboard.cards.customprovider";
    L8:
        return Uri.parse(r10);
    L4:
        if (r5.getPackageName().equals("com.zte.miboard.cardsdemo") == false) goto L6;
        r10 = "content://com.zte.miboard.cardsdemo.cards.customprovider";
        goto L8
    }

    public static void b(Context r10, IntelligentAgentData r11) {
        String r5 = d.f19867b;
        Log.d(r5, "callMiBoardOnTravelDataChanged 调用负一屏开始");
        Uri r12 = a(r10);
        String r13 = new Gson().toJson(r11);
        FlightOrTrainInfo.getInstance().setChangeFrom(null);
        Log.d(r5, "callMiBoardOnTravelDataChanged dataStr = " + r13);
        Bundle r14 = new Bundle();
        r14.putString("travel_data", r13);
        ContentProviderClient r15 = r10.getContentResolver().acquireUnstableContentProviderClient(r12);     // Catch: Exception -> L12
        Bundle r16 = r15.call("on_travel_data_changed", null, r14);     // Catch: Throwable -> L7
        boolean r17 = false;
        if (r16 == null) goto L9;
        r17 = r16.getBoolean("boolean_result", false);     // Catch: Throwable -> L7
    L9:
        Log.d(r5, "callMiBoardOnTravelDataChanged handled=" + r17);     // Catch: Throwable -> L7
        r15.close();     // Catch: Exception -> L12
        return;
    L7:
        th = move-exception;
        if (r15 != null) goto L25;
    L19:
        throw th;     // Catch: Exception -> L12
    L25:
        r15.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        a.m(e, "callMiBoardOnTravelDataChanged e=", r5);
    }
}
