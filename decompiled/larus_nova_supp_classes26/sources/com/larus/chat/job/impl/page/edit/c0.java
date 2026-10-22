package com.larus.chat.job.impl.page.edit;

import android.os.Bundle;
import com.larus.im.bean.job.AIJob;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 {
    public static final AIJob b(Bundle r21) {
        AIJob r1 = null;
        if (r21 == null) goto L23;
        Bundle r0 = r21.getBundle("chat_job_snapshot");
        if (r0 == null) goto L23;
        String r2 = r0.getString("chat_job_snapshot_job_id");
        if (r2 == null) goto L23;
        if ((!StringsKt.isBlank(r2)) == false) goto L12;
        String r5 = r2;
    L13:
        if (r5 == null) goto L23;
        int r6 = r0.getInt("chat_job_snapshot_job_type");
        int r7 = r0.getInt("chat_job_snapshot_status");
        long r8 = r0.getLong("chat_job_snapshot_update_version");
        String r10 = r0.getString("chat_job_snapshot_conversation_id");
        long r11 = r0.getLong("chat_job_snapshot_create_time");
        long r13 = r0.getLong("chat_job_snapshot_update_time");
        String r3 = r0.getString("chat_job_snapshot_content");
        if (r3 != null) goto L17;
        String r15 = "";
    L18:
        String r4 = r0.getString("chat_job_snapshot_ext");
        if (r4 != null) goto L21;
        String r16 = "";
    L22:
        r1 = new AIJob(r5, r6, r7, r8, r10, r11, r13, r15, r16, r0.getString("chat_job_snapshot_local_job_id"), null, 1024, null);
        goto L23
    L21:
        r16 = r4;
        goto L22
    L17:
        r15 = r3;
        goto L18
    L12:
        r5 = null;
    L23:
        return r1;
    }

    public static final void a(Bundle r4, AIJob r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "job");
        Bundle r0 = new Bundle();
        r0.putString("chat_job_snapshot_job_id", r5.getJobId());
        r0.putInt("chat_job_snapshot_job_type", r5.getJobType());
        r0.putInt("chat_job_snapshot_status", r5.getStatus());
        r0.putLong("chat_job_snapshot_update_version", r5.getUpdateVersion());
        r0.putString("chat_job_snapshot_conversation_id", r5.getConversationId());
        r0.putLong("chat_job_snapshot_create_time", r5.getCreateTime());
        r0.putLong("chat_job_snapshot_update_time", r5.getUpdateTime());
        r0.putString("chat_job_snapshot_content", r5.getContent());
        r0.putString("chat_job_snapshot_ext", r5.getExt());
        r0.putString("chat_job_snapshot_local_job_id", r5.getLocalJobId());
        Unit r6 = Unit.INSTANCE;
        r4.putBundle("chat_job_snapshot", r0);
    }
}
