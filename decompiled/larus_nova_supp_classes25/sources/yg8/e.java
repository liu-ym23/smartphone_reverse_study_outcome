package yg8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.timestamp.TimestampCell;
import com.larus.bmhome.chat.trace.i0;
import com.larus.common_ui.dialog.u;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements u {
    public final /* synthetic */ TimestampCell a;

    public final void cancel() {
        int r0 = i0.a;
        TimestampCell r1 = this.a;
        int r2 = TimestampCell.k;
        y r3 = r1.o();
        String r4 = "";
        if (r3 == null) goto L6;
        String r5 = r3.getBotId();
        if (r5 == null) goto L6;
    L7:
        y r6 = this.a.o();
        if (r6 == null) goto L13;
        String r7 = r6.Y1();
        if (r7 == null) goto L13;
        r4 = r7;
    L13:
        JSONObject r8 = TimestampCell.r(r5, r4);
        Intrinsics.checkNotNullParameter(r8, "params");
        i0.a("cancel_edit_chat_name", r8, null);
        return;
    L6:
        r5 = "";
        goto L7
    }

    public e(TimestampCell r1) {
        this.a = r1;
    }
}
