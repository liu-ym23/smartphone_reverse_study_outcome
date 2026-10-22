package yg8;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.timestamp.TimestampCell;
import com.larus.bmhome.chat.trace.i0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.InputDialog;
import com.larus.im.bean.message.Message;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements View.OnClickListener {
    public final /* synthetic */ TimestampCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ c(TimestampCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        TimestampCell r12 = this.a;
        Message r0 = this.b;
        int r1 = TimestampCell.k;
        int r2 = i0.a;
        y r3 = r12.o();
        String r4 = "";
        if (r3 == null) goto L6;
        String r5 = r3.getBotId();
        if (r5 == null) goto L6;
    L7:
        y r6 = r12.o();
        if (r6 == null) goto L11;
        String r7 = r6.Y1();
        if (r7 == null) goto L11;
    L12:
        JSONObject r8 = TimestampCell.r(r5, r7);
        Intrinsics.checkNotNullParameter(r8, "params");
        FragmentActivity r9 = null;
        i0.a("click_edit_chat_name", r8, null);
        String r10 = r0.getSectionName();
        if (r10 == null) goto L16;
        r4 = r10;
    L16:
        String r13 = r0.getSectionId();
        Intrinsics.checkNotNull(r13);
        Activity r14 = AppHost.a.a().getCurrentActivity();
        if ((r14 instanceof FragmentActivity) == false) goto L19;
        r9 = (FragmentActivity) r14;
    L19:
        if (r9 == null) goto L42;
        FragmentManager r15 = r9.getSupportFragmentManager();
        if (r15 == null) goto L45;
        y r16 = r12.o();
        if (r16 == null) goto L43;
        String r17 = r16.Y1();
        if (r17 == null) goto L46;
        RecyclerView r18 = ((BaseMessageListCell) r12).b;
        if (r18 == null) goto L44;
        Context r19 = r18.getContext();
        if (r19 == null) goto L47;
        List r20 = CollectionsKt.emptyList();
        Boolean r21 = Boolean.TRUE;
        String r22 = r19.getString(2131900666);
        Intrinsics.checkNotNullParameter(r22, "title");
        d r23 = new d(r12, r17, r13, r4);
        String r24 = r19.getString(2131900664);
        Intrinsics.checkNotNullParameter(r23, "listener");
        e r25 = new e(r12);
        String r110 = r19.getString(2131900662);
        Intrinsics.checkNotNullParameter(r25, "listener");
        InputDialog r26 = new InputDialog();
        r26.e = r21;
        r26.f = r22;
        r26.g = r4;
        r26.k = r24;
        r26.l = r23;
        r26.m = r110;
        r26.n = r25;
        r26.h = 40;
        r26.i = r20;
        r26.j = false;
        LandscapeRestrictionOperation r111 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r26, "TimeStampHolder", r111);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r26, r111) == true) goto L48;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L37:
        r26.show(r15, "TimeStampHolder");
        return;
    L48:
        return;
    L47:
        return;
    L44:
        return;
    L46:
        return;
    L43:
        return;
    L45:
        return;
    L42:
        return;
    L11:
        r7 = "";
    L6:
        r5 = "";
        goto L7
    }
}
