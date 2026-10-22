package yg8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.timestamp.TimestampCell;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.trace.i0;
import com.larus.common_ui.dialog.y0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements y0 {
    public final /* synthetic */ TimestampCell a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        int r0 = i0.a;
        TimestampCell r1 = this.a;
        int r2 = TimestampCell.k;
        y r3 = r1.o();
        String r4 = "";
        if (r3 == null) goto L6;
        String r6 = r3.getBotId();
        if (r6 == null) goto L6;
    L7:
        y r7 = this.a.o();
        if (r7 == null) goto L13;
        String r8 = r7.Y1();
        if (r8 == null) goto L13;
        r4 = r8;
    L13:
        JSONObject r9 = TimestampCell.r(r6, r4);
        Intrinsics.checkNotNullParameter(r9, "params");
        i0.a("edit_chat_name", r9, null);
        TimestampCell r10 = this.a;
        String r11 = this.b;
        String r12 = this.c;
        String r13 = this.d;
        r10.getClass();
        if (Intrinsics.areEqual(r5, r13) == true) goto L18;
        com.larus.im.d.d().updateSectionName(r11, r12, r5, new f());
        return;
    L18:
        return;
    L6:
        r6 = "";
        goto L7
    }

    public d(TimestampCell r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
