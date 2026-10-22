package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.nz;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarMoreSecondRedDotManager {
    public static final Lazy b = null;
    public ArrayList<b> a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarMoreSecondRedDotManager$b;", "", "", "mKey", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setMKey", "(Ljava/lang/String;)V", "", "mOnlineShowVersion", "I", "getMOnlineShowVersion", "()I", "setMOnlineShowVersion", "(I)V", "mLocalShowedVersion", "b", "c", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("key")
        private String mKey;

        @SerializedName("local_version")
        private int mLocalShowedVersion;

        @SerializedName("version")
        private int mOnlineShowVersion;

        public b() {
        }

        public final String a() {
            return this.mKey;
        }

        public final int b() {
            return this.mLocalShowedVersion;
        }

        public final void c(int r1) {
            this.mLocalShowedVersion = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarMoreSecondRedDotManager$c", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarMoreSecondRedDotManager$b;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c extends TypeToken<List<? extends b>> {
        public c() {
        }
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ToolbarMoreSecondRedDotManager$Companion$instance$2.INSTANCE);
    }

    public ToolbarMoreSecondRedDotManager() {
        String r0 = nz.a.getValue();
        if (r0 != null) goto L5;
        r0 = null;
    L5:
        ALogger.e("ToolbarMoreSecondRedDotManager", "intSecondRedDotSettingList onlineRedDotStr: " + r0);
        ArrayList<b> r1 = a(r0);
        if (r1 == null) goto L36;
        String r2 = (String) com.bytedance.android.livesdk.sharedpref.b.o0.getValue();
        if (r2 != null) goto L10;
        r2 = null;
    L10:
        ALogger.e("ToolbarMoreSecondRedDotManager", "intSecondRedDotSettingList localRedDotStr: " + r2);
        ArrayList r3 = a(r2);
        if (r3 == null) goto L26;
        Iterator<b> r4 = r1.iterator();
    L14:
        if (r4.hasNext() == false) goto L26;
        b r5 = r4.next();
        String r6 = r5.a();
        if (r6 == null) goto L23;
        Iterator r7 = r3.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        b r8 = (b) r7.next();
        if (StringsKt.equals$default(r8.a(), r6, false, 2, null) == false) goto L19;
    L24:
        if (r8 == null) goto L14;
        r5.c(r8.b());
        r3.remove(r8);
    L23:
        r8 = null;
    L26:
        this.a = r1;
        new ArrayList();
        return;
    }

    public static ArrayList a(String r2) {
        if (r2 == null) goto L11;
        return (ArrayList) com.bytedance.android.livesdk.service.l.d().c().fromJson(r2, new c().getType());
    L5:
        e = move-exception;
        e.printStackTrace();
        ALogger.e("ToolbarMoreSecondRedDotManager", e);
        return null;
    L11:
        return null;
    }
}
