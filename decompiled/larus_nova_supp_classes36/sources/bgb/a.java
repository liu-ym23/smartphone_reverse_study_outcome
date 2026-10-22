package bgb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.k1;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.flow.bottomsheet.biz.replyinthread.ReplyInThreadFrameFragment;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.bottomsheet.fragment.a.c {
    public a() {
    }

    public final void a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    public final String clazz() {
        return FlowReplyInThreadActivity.class.getName();
    }

    public final com.ss.android.lark.bottomsheet.fragment.a.b config() {
        return new com.ss.android.lark.bottomsheet.fragment.a.b(false);
    }

    public final BottomSheetFrameFragment f() {
        return new ReplyInThreadFrameFragment();
    }

    public final Integer b() {
        return 2131102061;
    }

    public final void c(Context r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        l1.a r0 = new l1.a();
        r0.e = r7.getString("key_params_thread_id");
        r0.h = r7.getSerializable("key_params_thread");
        r0.c = r7.getSerializable("key_params_thread_chat");
        r0.a = r7.getString("key_params_thread_source");
        r0.i = r7.getSerializable("key_params_topic_group");
        r0.f = r7.getInt("key_params_jump_position");
        r0.l = r7.getString("key_params_chat_id");
        r0.m = r7.getBoolean("key_params_is_from_card", false);
        String r3 = "";
        r0.j = r7.getString("key_params_from", "");
        r0.n = r7.getBoolean("key_params_has_create_thread", true);
        r0.o = r7.getBoolean("key_params_show_chat_name", true);
        r0.p = r7.getString("key_params_origin_merge_forward_message_id");
        r0.q = r7.getInt("key_params_merge_forward_from_type", 0);
        r0.u = r7.getString("key_params_root_message_id");
        r0.v = r7.getString("key_params_auto_translate_target_lang_by_card", "");
        r0.w = Boolean.valueOf(r7.getBoolean("key_bottom_sheet_container_start", false));
        r0.y = r7.getString("key_params_preview_id");
        r0.z = r7.getString("key_params_msg_link_token");
        r0.A = r7.getString("key_params_thread_source_type");
        r0.B = r7.getBoolean("is_embedded", false);
        Map r2 = k1.a;
        String r4 = r7.getString("key_params_merge_forward_message_id");
        Map r5 = k1.a;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.r = (Message) r5.remove(r4);
        String r8 = r7.getString("key_params_parent_message_content");
        Map r9 = k1.c;
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r0.t = (MergeForwardContent) r9.remove(r8);
        String r10 = r7.getString("key_params_root_message_id");
        Map r1 = k1.d;
        if (r10 == null) goto L12;
        r3 = r10;
    L12:
        r0.x = (MessageInfo) r1.remove(r3);
        whb.d.b(r6, null, new l1(r0));
    }
}
