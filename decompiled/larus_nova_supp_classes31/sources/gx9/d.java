package gx9;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ List<Message> b;
    public final /* synthetic */ b c;
    public final /* synthetic */ String d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("delete wcb failed, remote=");
        r2.append(this.a);
        r2.append(", error=");
        r2.append(r8);
        r2.append(", deleted=");
        List<Message> r3 = this.b;
        b r4 = this.c;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Message r7 = (Message) r6.next();
        r4.getClass();
        r5.add(b.a(r7));
        goto L4
    L6:
        r2.append(r5);
        r1.e("ChatWcbMessageCleaner", r2.toString());
        a r9 = this.c.b;
        String r10 = this.d;
        boolean r11 = this.a;
        int r12 = this.b.size();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "error");
        JSONObject r0 = new JSONObject();
        r0.put("conversation_id", r10);
        r0.put("trigger", "background");
        r0.put("delete_remote", r11);
        r0.put("delete_cnt", r12);
        r0.put("success", "0");
        r0.put("error_code", r8.getCode());
        r0.put("error_msg", r8.getTips());
        com.larus.platform.service.o.a.reportEvent("dev_wcb_delete_event", r0);
    }

    public final void onSuccess(Object r6) {
        Intrinsics.checkNotNullParameter((List) r6, "result");
        FLogger r7 = FLogger.a;
        StringBuilder r0 = new StringBuilder("delete wcb success, remote=");
        r0.append(this.a);
        r0.append(", deleted=");
        List<Message> r1 = this.b;
        b r2 = this.c;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Message r5 = (Message) r4.next();
        r2.getClass();
        r3.add(b.a(r5));
        goto L4
    L6:
        r0.append(r3);
        r7.i("ChatWcbMessageCleaner", r0.toString());
    }

    public d(boolean r1, List<Message> r2, b r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
