package zlc;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import ylc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(WebcastRoomDataSyncMessage r2) {
        if (r2 != null) goto L4;
        return "null";
    L4:
        return r2.syncKey + "|version." + r2.version;
    }

    @JvmStatic
    public static final String b(f r5) {
        if (r5 == null) goto L9;
        Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r6 = r5.h;
        if (r6 == null) goto L9;
        Collection r0 = new ArrayList(r6.size());
        Iterator<Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r1 = r7.next();
        r0.add(r1.getKey() + "|version." + r1.getValue().a);
    L11:
        return TextUtils.join(",", r0);
    L9:
        r0 = CollectionsKt.emptyList();
        goto L11
    }
}
