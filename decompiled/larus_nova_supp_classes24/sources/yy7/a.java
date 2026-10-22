package yy7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import wy7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a {

    /* JADX INFO: renamed from: yy7.a$a, reason: collision with other inner class name */
    public static class C0139a {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final boolean e;
        public final String f;
        public final String g;

        public C0139a(String r1, String r2, String r3, boolean r4, boolean r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    C0139a getAccountInfo();

    Map<String, c> getChatterByIds(List<String> r1);

    Context getContext();

    String getDebugUrl();

    String getDynamicDomain(String r1);

    Locale getLanguageSetting();

    String getLoginUserId();

    Long getNtpTime();

    boolean is12HourClock();

    void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void openUrl(Context r1, String r2, boolean r3, boolean r4, Boolean r5, String r6, Bundle r7);

    void pickGroupMember(Activity r1, String r2, List<String> r3, boolean r4, String r5, IGetDataCallback<List<ChatChatter>> r6);

    void pickTargetMember(Activity r1, List<String> r2, List<String> r3, boolean r4, String r5, IGetDataCallback<List<ChatChatter>> r6);

    void showProfile(Context r1, String r2);

    void startContactsProfileActivityByChatterId(Context r1, String r2, String r3);
}
