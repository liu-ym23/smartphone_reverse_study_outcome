package o1b;

import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.MGetChattersRequest;
import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.Chatter;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.Entity;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyMGetChattersRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyMGetChattersResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final MGetChattersRequest.Builder a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        MGetChattersRequest.Builder r0 = new MGetChattersRequest.Builder();     // Catch: Exception -> L21
        MyMGetChattersRequest r6 = (MyMGetChattersRequest) JSON.parseObject(r5, MyMGetChattersRequest.class);     // Catch: Exception -> L21
        SyncDataStrategy r1 = SyncDataStrategy.LOCAL;     // Catch: Exception -> L21
        Integer r2 = r6.getSyncDataStrategy();     // Catch: Exception -> L21
        if (r2 != null) goto L7;
    L9:
        if (r2 != null) goto L12;
    L14:
        if (r2 != null) goto L17;
    L19:
        r0.chatter_ids(r6.getChatterIds()).is_from_server(r6.isFromServer()).sync_data_strategy(r1);     // Catch: Exception -> L21
        return r0;
    L17:
        if (r2.intValue() != 3) goto L19;
        r1 = SyncDataStrategy.FORCE_SERVER;     // Catch: Exception -> L21
        goto L19
    L12:
        if (r2.intValue() != 2) goto L14;
        r1 = SyncDataStrategy.TRY_LOCAL;     // Catch: Exception -> L21
        goto L19
    L7:
        if (r2.intValue() != 1) goto L9;
    L21:
        return null;
    }

    public static final MyMGetChattersResponse b(MGetChattersResponse r6) {
        Intrinsics.checkNotNullParameter(r6, "value");
        HashMap r0 = new HashMap();
        Iterator r7 = r6.entity.chatters.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put(r1.getKey(), new Chatter(((com.bytedance.lark.pb.basic.v1.Chatter) r1.getValue()).avatar_key, ((com.bytedance.lark.pb.basic.v1.Chatter) r1.getValue()).name, ((com.bytedance.lark.pb.basic.v1.Chatter) r1.getValue()).localized_name));
        goto L4
    L7:
        return new MyMGetChattersResponse(new Entity(r0));
    }
}
