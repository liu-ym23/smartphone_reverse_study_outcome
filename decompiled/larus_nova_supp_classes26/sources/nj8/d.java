package nj8;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.standarduikit.codeartifact.viewmodel.CodeArtifactVMData;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.f;
import kc8.y;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements c {
    public final y a;

    public d(y r1) {
        this.a = r1;
    }

    @Override // nj8.c
    public final void a(Context r6, CodeArtifactVMData r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "data");
        Message r0 = r7.a;
        i r8 = SmartRouter.buildRoute(r6, "//flow/code_block_detail");
        Pair[] r1 = new Pair[13];
        r1[0] = TuplesKt.to("key_is_from_code_artifact", Boolean.TRUE);
        r1[1] = TuplesKt.to("key_artifact_code_code_id", r7.b);
        r1[2] = TuplesKt.to("key_artifact_code_version", r7.d);
        String r2 = "";
        r1[3] = TuplesKt.to("key_mark_down_detail_raw_content", "");
        r1[4] = TuplesKt.to("key_mark_down_detail_copy_content", "");
        r1[5] = TuplesKt.to("key_code_block_code_info", "html");
        r1[6] = TuplesKt.to("key_mark_down_detail_message_id", r0.getMessageId());
        r1[7] = TuplesKt.to("key_mark_down_detail_conversation_id", r0.getConversationId());
        y r9 = this.a;
        if (r9 == null) goto L5;
        Long r10 = r9.b;
    L6:
        r1[8] = TuplesKt.to("key_mark_down_detail_chat_unique_key", r10);
        r1[9] = TuplesKt.to("key_mark_down_detail_is_immersive", Boolean.FALSE);
        r1[10] = TuplesKt.to("key_can_code_be_previewed", Boolean.valueOf(!AppHost.a.isOversea()));
        String r11 = com.larus.im.bean.message.a.r(r0);
        if (r11 != null) goto L9;
        r11 = TriggerSendLoading.NO_LOADING;
    L9:
        r1[11] = TuplesKt.to("is_general_agent", r11);
        String r12 = com.larus.im.bean.message.a.s(r0);
        if (r12 == null) goto L13;
        r2 = r12;
    L13:
        r1[12] = TuplesKt.to("chat_id", r2);
        r8.c.putExtras(f.c(r1));
        r8.d();
        return;
    L5:
        r10 = null;
        goto L6
    }
}
