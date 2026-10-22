package com.larus.extension.chat_extension.impl.ltm;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements p0 {
    public final /* synthetic */ ChatLtmFragment a;

    public final void confirm() {
        BotModel r0 = this.a.g;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L5:
        String r2 = r0.getBotId();
        String r3 = this.a.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L9:
        this.a.getClass();
        String r4 = this.a.h;
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter("delete_all", "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r2 != null) goto L27;
    L14:
        if (r1 == null) goto L16;
        r5.put("conversation_id", r1);     // Catch: JSONException -> L12
    L16:
        r5.put("current_page", "memory_manage");     // Catch: JSONException -> L12
        if (r4 == null) goto L19;
        r5.put("previous_page", r4);     // Catch: JSONException -> L12
    L19:
        r5.put("type", "delete_all");     // Catch: JSONException -> L12
    L22:
        TrackParams r6 = new TrackParams().merge(r5);
        by7.a r7 = new by7.a("confirm_delete_all_memory");
        r7.a.merge(r6);
        r7.b();
        if (NetworkUtils.isNetworkAvailable(this.a.requireContext().getApplicationContext()) == false) goto L25;
        this.a.V90().requireClearLtmItem();
        return;
    L25:
        t19.s r8 = t19.s.a;
        Context r9 = this.a.getContext();
        r8.getClass();
        t19.s.b(r9, 2131906741, false);
        return;
    L12:
        e = move-exception;
        FLogger.a.e("ConfirmEventHelper", "error in ConfirmEventHelper mobConfirmDeleteAllMemory " + e.getLocalizedMessage());
        goto L22
    L27:
        r5.put("bot_id", r2);     // Catch: JSONException -> L12
        goto L14
    L8:
        r1 = r3;
        goto L9
    }

    public g(ChatLtmFragment r1) {
        this.a = r1;
    }
}
