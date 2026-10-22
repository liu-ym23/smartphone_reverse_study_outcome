package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.dw;
import com.bytedance.android.livesdk.config.oz;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b4 {
    public ArrayList<b> a;
    public ArrayList<b> b;

    public class a extends TypeToken<List<b>> {
        public a() {
        }
    }

    public class b {

        @SerializedName("key")
        public String mKey;

        @SerializedName("local_version")
        public int mLocalShowedVersion;

        @SerializedName("version")
        public int mOnlineShowVersion;
    }

    public static class c {
        public static final b4 a = null;

        static {
            a = new b4();
        }
    }

    public b4() {
        ArrayList<b> r0 = c(oz.a.getValue());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L25;
        ArrayList r1 = c((String) com.bytedance.android.livesdk.sharedpref.b.n0.getValue());
        if (r1 != null) goto L10;
    L17:
        this.a = r0;
        this.b = new ArrayList();
        return;
    L10:
        if (r1.size() <= 0) goto L17;
        Iterator<b> r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L17;
        b r3 = r2.next();
        b r4 = a(r3.mKey, r1);
        if (r4 == null) goto L13;
        r3.mLocalShowedVersion = r4.mLocalShowedVersion;
        r1.remove(r4);
        goto L13
    }

    public static ArrayList c(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        return (ArrayList) com.bytedance.android.livesdk.service.l.d().c().fromJson(r2, new a().getType());
    L6:
        e = move-exception;
        e.printStackTrace();
        ALogger.e("ToolbarMoreRedDotManager", e);
        return null;
    L12:
        return null;
    }

    public final void b(String r4) {
        b r5 = a(r4, this.b);
        if (r5 == null) goto L13;
        r5.mLocalShowedVersion = r5.mOnlineShowVersion;
        if (this.a == null) goto L14;
        String r1 = GsonHelper.get().toJson(this.a);     // Catch: Exception -> L8
        ALogger.e("ToolbarMoreRedDotManager", "saveRedDotSetting fullInfo: " + r1);     // Catch: Exception -> L8
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.n0;     // Catch: Exception -> L8
        r0.getClass();     // Catch: Exception -> L8
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ALogger.e("ToolbarMoreRedDotManager", e);
        return;
    L14:
        return;
    }

    public final boolean e(String r2) {
        b r3 = a(r2, this.b);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.mLocalShowedVersion >= r3.mOnlineShowVersion) goto L7;
        return true;
    }

    public final void f(List<String> r4) {
        ArrayList<b> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L32;
        ArrayList<b> r1 = this.b;
        if (r1 == null) goto L10;
        r1.clear();
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.size() <= 0) goto L31;
        Iterator<String> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L33;
        b r2 = a(r5.next(), this.a);
        if (r2 != null) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L15;
        this.b.add(r2);
        goto L15
    L19:
        if (r2.mLocalShowedVersion >= r2.mOnlineShowVersion) goto L21;
        r3 = true;
        goto L22
    L33:
        return;
    L31:
        return;
    }

    public static b a(String r2, ArrayList r3) {
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.size() <= 0) goto L19;
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L20;
        b r0 = (b) r4.next();
        if (r0.mKey.equals(r2) == false) goto L9;
        return r0;
    L20:
        return null;
    L19:
        return null;
    L13:
        return null;
    }

    public final boolean d(ExtendedToolbarButton r5, x3 r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        c0.b r7 = r6.s(r5);
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.showRedDot() == false) goto L13;
        ALogger.d("toolbar-red-dot", r5.f() + " show red dot by behavior control");
        return true;
    L13:
        if (dw.a.getValue().booleanValue() == true) goto L15;
    L17:
        b r8 = a(r5.f(), this.b);
        if (r8 != null) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == false) goto L26;
        ALogger.d("toolbar-red-dot", r5.f() + " show red dot by setting control");
        return true;
    L26:
        return false;
    L20:
        if (r8.mLocalShowedVersion >= r8.mOnlineShowVersion) goto L22;
        r9 = true;
        goto L23
    L15:
        if (r5 != ToolbarButton.HASH_TAG.extended()) goto L17;
        return false;
    }
}
