package com.ss.android.lark.inline.ai.logic.push;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements slb.d.a {
    public final slb.d.a a;
    public final List<AbstractC0106a> b;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0106a implements slb.d.a {
        public a a;

        public AbstractC0106a() {
        }

        public final void b(InlineAITaskStatus r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "data");
            a r0 = this.a;
            if (r0 == null) goto L12;
            int r1 = ((ArrayList) r0.b).indexOf(this);
            if (r1 >= 0) goto L7;
        L10:
            r0.a.a(r4, r5);
            return;
        L7:
            if (r1 >= (((ArrayList) r0.b).size() - 1)) goto L10;
            ((AbstractC0106a) ListProtector.get(r0.b, r1 + 1)).a(r4, r5);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(slb.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final void b(AbstractC0106a r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        if (((ArrayList) this.b).contains(r2) == true) goto L6;
        Intrinsics.checkNotNullParameter(this, "handler");
        r2.a = this;
        ((ArrayList) this.b).add(r2);
        return;
    }

    @Override // slb.d.a
    public final void a(InlineAITaskStatus r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        StringBuilder r0 = new StringBuilder("onPush()... taskId = ");
        r0.append(r3.unique_task_id);
        r0.append(", status = ");
        r0.append(r3.task_status);
        r0.append(", code = ");
        r0.append(r3.status_code);
        r0.append(", content length = ");
        String r1 = r3.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", seq id = ");
        r0.append(r3.seq_id);
        Log.i("InlineAIPushHandler", r0.toString());
        if (((ArrayList) this.b).isEmpty() == false) goto L10;
        this.a.a(r3, r4);
        return;
    L10:
        ((AbstractC0106a) ListProtector.get(this.b, 0)).a(r3, r4);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
