package dda;

import com.larus.bmhome.utils.i;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.agent.IObricSemanticApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements td8.c {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = LazyKt.lazy(new b());
    }

    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        xc8.b r5 = (xc8.b) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L9;
        Message r6 = r5.getMessage();
        if (r6 == null) goto L9;
        String r7 = r6.getConversationId();
        if (r7 == null) goto L9;
        boolean r8 = i.g(r7);
    L10:
        IObricSemanticApi r9 = (IObricSemanticApi) this.a.getValue();
        if (r9 == null) goto L20;
        List<Message> r10 = r9.getDeleted();
        if (r10 == null) goto L23;
        if (r8 == true) goto L17;
        return false;
    L17:
        if ((!r10.isEmpty()) == false) goto L22;
        return true;
    L22:
        return false;
    L23:
        return false;
    L20:
        return false;
    L9:
        r8 = false;
        goto L10
    }

    public final List<xc8.b> b(int r2, xc8.b r3, xc8.b r4, List<xc8.b> r5) {
        Intrinsics.checkNotNullParameter(r4, "current");
        Intrinsics.checkNotNullParameter(r5, "input");
        IObricSemanticApi r6 = (IObricSemanticApi) this.a.getValue();
        if (r6 == null) goto L18;
        List<Message> r7 = r6.getDeleted();
        if (r7 == null) goto L18;
        FLogger.a.d("Pipeline_List_OSemanticCutTask", "process: called, deleted = " + r7);
        List<Message> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        r9.add(((Message) r10.next()).getLocalMessageId());
        goto L9
    L11:
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        xc8.b r13 = (xc8.b) r12.next();
        if (r9.contains(r13.getMessage().getLocalMessageId()) == true) goto L13;
        r11.add(r13);
        goto L13
    L17:
        return r11;
    L18:
        return r5;
    }
}
