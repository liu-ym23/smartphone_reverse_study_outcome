package com.larus.bmhome.chat.list.cell.record;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.message.Message;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ic8.p0;
import kotlin.Pair;
import kotlin.TuplesKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements View.OnClickListener {
    public final /* synthetic */ RecordCardCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ p0 c;

    public /* synthetic */ e(RecordCardCell r1, Message r2, p0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        RecordCardCell r7 = this.a;
        Message r8 = this.b;
        p0 r0 = this.c;
        u3 r1 = r7.e;
        RecordStatus r9 = null;
        if (r1 == null) goto L5;
        RecordStatus r2 = r1.getRecordStatus();
    L6:
        int r10 = -1;
        if (r2 != null) goto L9;
        int r3 = -1;
    L10:
        String r12 = "";
        switch(r3) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L32;
            case 4: goto L32;
            case 5: goto L23;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            default: goto L51;
        };
    L13:
        Context r4 = r14.getContext();
        String r5 = r0.c();
        String r15 = r8.getMessageId();
        if (r15 != null) goto L16;
        String r6 = "";
    L17:
        String r16 = r8.getConversationId();
        if (r16 != null) goto L20;
        String r11 = "";
    L21:
        r7.u(r4, r5, false, r6, r11, "view_detail");
        goto L51
    L20:
        r11 = r16;
        goto L21
    L16:
        r6 = r15;
        goto L17
    L32:
        FragmentActivity r17 = AppHost.a.a().getCurrentActivity();
        if ((r17 instanceof FragmentActivity) == false) goto L35;
        FragmentActivity r18 = r17;
    L36:
        if (r18 == null) goto L45;
        FragmentManager r19 = r18.getSupportFragmentManager();
        if (r19 == null) goto L45;
        CommonDialog.a r13 = new CommonDialog.a();
        int r20 = j0.a;
        r13.i(j0.d(2131907333));
        r13.g(j0.d(2131907332));
        CommonDialog.a.f(r13, new i(r7), j0.d(2131907331), false, 12);
        CommonDialog.a.e(r13, new j(), j0.d(2131907330), 4);
        CommonDialog r21 = r13.a();
        LandscapeRestrictionOperation r22 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r21, null, r22);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r21, r22) == true) goto L51;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L44:
        r21.show(r19, null);
    L45:
        r7.i.a("fragmentManager is null when click");
        return;
    L35:
        r18 = null;
        goto L36
    L46:
        RecordStatus r23 = RecordStatus.Connecting;
        String r110 = r8.getMessageId();
        if (r110 != null) goto L49;
        String r24 = "";
    L50:
        RecordCardCell.r(r7, r23, r24, null, "setButtonClick UNAUTHORIZED_ERROR or EarlyEndError", 12);
        goto L51
    L49:
        r24 = r110;
    L51:
        String r111 = r8.getMessageId();
        if (r111 != null) goto L54;
        r111 = "";
    L54:
        String r25 = r8.getConversationId();
        if (r25 == null) goto L58;
        r12 = r25;
    L58:
        Pair[] r26 = new Pair[2];
        u3 r27 = r7.e;
        if (r27 == null) goto L61;
        RecordStatus r28 = r27.getRecordStatus();
    L62:
        r26[0] = TuplesKt.to("card_status", RecordCardCell.s(r28));
        u3 r29 = r7.e;
        if (r29 == null) goto L65;
        r9 = r29.getRecordStatus();
    L65:
        if (r9 == null) goto L68;
        r10 = RecordCardCell$c.a[r9.ordinal()];
    L68:
        switch(r10) {
            case 1: goto L72;
            case 2: goto L69;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L72;
            case 6: goto L70;
            case 7: goto L69;
            case 8: goto L70;
            case 9: goto L70;
            case 10: goto L70;
            default: goto L69;
        };
    L69:
        String r30 = "other";
    L73:
        r26[1] = TuplesKt.to("action_type", r30);
        r7.x("voice_note_card_click", r111, r12, r26);
        return;
    L70:
        r30 = "click_view_details";
        goto L73
    L71:
        r30 = "click_end_audio_note";
        goto L73
    L72:
        r30 = "click_restart_audio_note";
        goto L73
    L61:
        r28 = null;
        goto L62
    L23:
        if (r7.i.isRecording() == false) goto L27;
        u3 r112 = r7.e;
        if (r112 == null) goto L51;
        s r31 = s.a;
        Context r113 = r112.getContext();
        String r32 = AppHost.a.getApplication().getString(2131907353);
        r31.getClass();
        s.t(r113, r32);
        goto L51
    L27:
        RecordStatus r33 = RecordStatus.Connecting;
        String r114 = r8.getMessageId();
        if (r114 != null) goto L30;
        String r34 = "";
    L31:
        RecordCardCell.r(r7, r33, r34, null, "setButtonClick RECORD_ERROR", 12);
        goto L51
    L30:
        r34 = r114;
        goto L31
    L9:
        r3 = RecordCardCell$c.a[r2.ordinal()];
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
