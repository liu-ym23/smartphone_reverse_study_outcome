package m82;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.msgboard.DressListTextConfig;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.ugc.effectplatform.util.r;
import i82.g;
import i82.i;
import java.util.List;
import kotlin.collections.CollectionsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends a {
    public View a;
    public TextView b;
    public OverScrollRecyclerView c;
    public g d;
    public final MultiTypeAdapter e;
    public com.bytedance.android.livesdk.chatroom.msgboard.a f;
    public k82.a g;
    public final Context h;
    public final i i;

    public final void b() {
        int r0 = n82.c.a;
        k82.a r1 = this.g;
        String r2 = null;
        if (r1 == null) goto L7;
        t9 r3 = r1.s();
        if (r3 == null) goto L7;
        DataCenter r4 = r3.l;
    L8:
        com.bytedance.android.livesdk.chatroom.msgboard.b r5 = n82.c.i(r4);
        TextView r6 = this.b;
        if (r6 == null) goto L24;
        int r7 = r.a;
        if (r5 == null) goto L15;
        DressListTextConfig r8 = r5.b();
        if (r8 == null) goto L15;
        String r9 = r8.getBadgeTitle();
    L17:
        if (r.b(r9) == false) goto L19;
        r2 = "主题皮肤";
    L23:
        r6.setText(r2);
        goto L24
    L19:
        if (r5 == null) goto L23;
        DressListTextConfig r10 = r5.b();
        if (r10 == null) goto L23;
        r2 = r10.getDressTitle();
    L15:
        r9 = null;
    L24:
        if (r5 == null) goto L31;
        List r11 = r5.c();
        if (r11 == null) goto L32;
        List r13 = CollectionsKt.toMutableList(r11);
        if (r13 == null) goto L33;
        MultiTypeAdapter r14 = this.e;
        r14.a = r13;
        r14.notifyDataSetChanged();
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final Context getContext() {
        return this.h;
    }

    public c(Context r1, i r2) {
        this.h = r1;
        this.i = r2;
        this.e = new MultiTypeAdapter();
    }
}
