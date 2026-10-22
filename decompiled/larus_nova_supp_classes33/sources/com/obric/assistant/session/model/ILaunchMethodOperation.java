package com.obric.assistant.session.model;

import android.content.Context;
import com.obric.assistant.session.bean.ActivateEventType;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J+\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001cH&¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/session/model/ILaunchMethodOperation;", "", "onAiKeyDown", "", "updateWakeupSource", "updateLaunchReportParams", "launchService", "", "updateLaunchMethod", "eventType", "Lcom/obric/assistant/session/bean/ActivateEventType;", "rawLaunchMethod", "getLaunchMethod", "shouldDisableScreenShot", "", "foreGroundAppPackageName", "foreGroundActivityName", "getDefaultLauncherPackageName", "context", "Landroid/content/Context;", "reportAiKeyPressDuration", "duration", "", "payload", "Lorg/json/JSONObject;", "reportAiKeyWakeupDuration", "systemKeyToWakeupDuration", "wakeupTimeMillis", "", "(ILjava/lang/Integer;J)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILaunchMethodOperation {

    public static final class a {
        public static /* synthetic */ void a(ILaunchMethodOperation r2, ActivateEventType r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            r2.e(r3, r4);
        }
    }

    String a();

    String b(Context r1);

    void c(int r1, JSONObject r2);

    void e(ActivateEventType r1, String r2);

    void g();

    void i(int r1, Integer r2, long r3);

    void j();

    void k(String r1);

    boolean l(String r1, String r2);
}
