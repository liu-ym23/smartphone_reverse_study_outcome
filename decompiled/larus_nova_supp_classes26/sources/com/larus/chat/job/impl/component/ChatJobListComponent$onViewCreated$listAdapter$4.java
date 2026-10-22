package com.larus.chat.job.impl.component;

import com.larus.im.bean.job.AIJob;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListComponent$onViewCreated$listAdapter$4 extends FunctionReferenceImpl implements Function2<com.larus.chat.job.impl.page.i.a, Integer, Unit> {
    public ChatJobListComponent$onViewCreated$listAdapter$4(Object r8) {
        super(2, r8, ez8.a.class, "trackItemShow", "trackItemShow(Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;I)V", 0);
    }

    public final void invoke(com.larus.chat.job.impl.page.i.a r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        ((ez8.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        String r1 = null;
        if (r4.b == false) goto L7;
        String r0 = ez8.a.c(r4.a);
        if (r0 == null) goto L13;
        r1 = "recommend:".concat(r0);
    L13:
        if (r1 != null) goto L16;
        return;
    L16:
        if (ez8.a.b.add(r1) == true) goto L19;
        return;
    L19:
        if (r4.b == false) goto L24;
        String r2 = ez8.a.c(r4.a);
        if (r2 == null) goto L35;
        ez8.a.f("recommend_cron_job_show", ez8.a.d(r4.a, r2, r5));
        return;
    L35:
        return;
    L24:
        AIJob r6 = r4.a;
        JSONObject r7 = new JSONObject().put("job_id", r6.getJobId()).put("current_page", "cron_job_manage").put("index", r5);
        ez8.a.a.getClass();
        String r3 = ez8.a.l(r6);
        if (r3 == null) goto L27;
        r7.put("job_status", r3);
    L27:
        String r8 = ez8.a.e(r6);
        if (r8 == null) goto L30;
        r7.put("repeat_type", r8);
    L30:
        ez8.a.f("cron_job_show", r7);
        return;
    L7:
        String r9 = r4.a.getJobId();
        if ((!StringsKt.isBlank(r9)) == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L13;
        r1 = "job:".concat(r9);
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.larus.chat.job.impl.page.i.a) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
