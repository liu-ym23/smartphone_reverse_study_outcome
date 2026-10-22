package s2b;

import android.os.Handler;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.e0;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class o implements f0 {
    public final com.ss.android.lark.im.sdk.service.p a;
    public final b b;
    public final Handler c;
    public final CopyOnWriteArrayList<e0> d;
    public String e;
    public final AndroidThrottle<MessageInfo> f;
    public int g;
    public final HashSet<String> h;
    public final Map<String, Long> i;

    public static final class a {
    }

    public static final class b implements AndroidThrottle.d<MessageInfo> {
        public final Map<String, MessageInfo> a;

        public final Collection<MessageInfo> a() {
            ArrayList r0 = new ArrayList(((HashMap) this.a).values());
            ((HashMap) this.a).clear();
            return r0;
        }

        public final void clear() {
            ((HashMap) this.a).clear();
        }

        public final int size() {
            return ((HashMap) this.a).size();
        }

        public b() {
            this.a = new HashMap();
        }

        public final void put(Object r3) {
            MessageInfo r4 = (MessageInfo) r3;
            if (r4 == null) goto L6;
            Map<String, MessageInfo> r0 = this.a;
            HashMap r1 = (HashMap) r0;
            r1.put(r4.getId(), r4);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (((HashMap) this.a.b.a).isEmpty() == true) goto L9;
            Collection<MessageInfo> r0 = this.a.b.a();     // Catch: Throwable -> L6
            this.a.e(r0, false, null);     // Catch: Throwable -> L6
            this.a.f.b();     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    public abstract boolean d();

    public final void b() {
        this.c.post(new c(this));
    }

    public o() {
        com.ss.android.lark.im.sdk.service.p r0 = ImSdkService.f();
        Intrinsics.checkNotNullParameter(r0, "messageService");
        this.a = r0;
        b r1 = new b();
        this.b = r1;
        Handler r2 = CoreThreadPool.getNonblockingHandler();
        this.c = r2;
        this.d = new CopyOnWriteArrayList();
        AndroidThrottle.a r3 = new AndroidThrottle.a();
        r3.b = 2000;
        r3.c = 2;
        r3.d = r1;
        r3.a = r2;
        r3.e = new p(this);
        this.f = new AndroidThrottle(r3);
        this.h = new HashSet();
        this.i = new LinkedHashMap();
    }

    public void c(List<? extends MessageInfo> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        ArrayList r0 = new ArrayList();
        Iterator<? extends MessageInfo> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L22;
        MessageInfo r1 = r10.next();
        MessageFoldDetail r2 = r1.getMessageFoldDetail();
        if (r2 == null) goto L18;
        if (r2.getFoldId().length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L18;
        Map<String, Long> r4 = this.i;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        Long r6 = (Long) r5.get(r2.getFoldId());
        long r7 = r2.getUpdateTimeMs();
        if (r6 == null) goto L17;
        if (r6.longValue() == r7) goto L4;
    L17:
        this.i.put(r2.getFoldId(), Long.valueOf(r2.getUpdateTimeMs()));
        r0.add(r1);
        goto L4
    L10:
        r3 = false;
    L18:
        String r8 = r1.getId();
        if (this.h.contains(r8) == true) goto L4;
        this.h.add(r8);
        r0.add(r1);
        goto L4
    L22:
        this.f.e(r0);
    }

    public final void e(Collection<? extends MessageInfo> r4, boolean r5, MessageInfo r6) {
        Intrinsics.checkNotNullParameter(r4, "dataList");
        Iterator<e0> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        e0 r1 = r0.next();
        CollectionsKt.toList(r4);
        r1.a();
        goto L4
    L6:
        a0.a r2 = new a0.a();
        ArrayList r3 = new ArrayList(r4);
        Intrinsics.checkNotNullParameter(r3, "messages");
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.a = r3;
        r2.b = this.g;
        r2.d = d();
        r2.e = r5;
        if (r6 == null) goto L9;
        Message r7 = r6.getMessage();
    L10:
        r2.f = r7;
        String r8 = this.e;
        if (r8 == null) goto L13;
        Intrinsics.checkNotNullParameter(r8, "threadId");
        r2.c = r8;
    L13:
        this.a.j6(new a0(r2));
        return;
    L9:
        r7 = null;
        goto L10
    }
}
