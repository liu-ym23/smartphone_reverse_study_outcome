package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.im.bean.message.UserType;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SaveVideoMenuHandler extends a {
    public SaveVideoMenuHandler() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.SAVE_VIDEO.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r18, View r19, ef8.b r20) {
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r19, "view");
        Intrinsics.checkNotNullParameter(r20, "menuContext");
        AiGenVideoContentData r0 = r20.j;
        if (r0 != null) goto L7;
        int r1 = com.larus.bmhome.chat.layout.holder.video.j.a;
        r0 = com.larus.bmhome.chat.layout.holder.video.j.a(r20.a.getContent());
        if (r0 != null) goto L7;
        return false;
    L7:
        AiGenVideoContentData r3 = r0;
        if (r18.getId() != MenuActionType.SAVE_VIDEO.getType()) goto L42;
        Context r4 = r19.getContext();
        if (r4 != null) goto L12;
        return true;
    L12:
        com.larus.bmhome.chat.api.q0.a r2 = r20.b;
        if (r2 == null) goto L15;
        CoroutineScope r11 = r2.F9();
    L16:
        com.larus.common_ui.dialog.l0 r6 = new com.larus.common_ui.dialog.l0(r4, 0.0f, false, 6);
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r6);
    L21:
        JSONObject r5 = r20.l;
        if (r5 == null) goto L28;
        String r7 = r5.optString("creation_task_id");
        if (r7 == null) goto L28;
        if ((!StringsKt.isBlank(r7)) == false) goto L28;
        String r14 = r7;
    L29:
        if (r11 == null) goto L31;
        String r8 = r14;
        BuildersKt.launch$default(r11, null, null, new SaveVideoMenuHandler$handleAction$1(r20, r8, r3, r4, r11, r6, null), 3, null);
    L32:
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r10 = new JSONObject();
        r10.put("click_method", "long_press_answer");
        r10.put("click_from", "click_download");
        r10.put("message_id", r20.a.getMessageId());
        r10.putOpt("creation_task_id", r8);
        if (r20.a.getUserType() != UserType.HUMAN.value) goto L35;
        String r12 = "user";
    L36:
        r10.put("user_type", r12);
        JSONObject r13 = r20.l;
        if (r13 == null) goto L41;
        Object r15 = r13.opt("_mixed_richmedia_download_trace");
        if (r15 == null) goto L41;
        r10.put("_mixed_richmedia_download_trace", r15);
    L41:
        b2.f(r10, true);
        Unit r16 = Unit.INSTANCE;
        r9.reportEvent("video_download", r10);
        goto L42
    L35:
        r12 = "bot";
        goto L36
    L31:
        r8 = r14;
    L28:
        r14 = null;
        goto L29
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L20:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L21
    L15:
        r11 = null;
    L42:
        return false;
    }
}
