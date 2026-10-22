package jnb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.LarkContext;
import e7c.c;
import java.util.HashMap;
import java.util.Map;
import k7c.b;
import k7c.d;
import k7c.e;
import k7c.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.todo.a implements c {

    /* JADX INFO: renamed from: jnb.a$a, reason: collision with other inner class name */
    public static final class C0286a {
    }

    static {
    }

    public final Map g() {
        HashMap r0 = new HashMap();
        etb.a r1 = (etb.a) LarkContext.spiByDwarf(etb.a.class);
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isEnable() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        r0.put("/client/todo/detail", new d(this));
        r0.put("/client/todo/open", new f());
        r0.put("/client/todo/view", new e());
        r0.put("/client/todo/create", new k7c.c());
        r0.put("/client/todo/task_list", new b());
        r0.put("/client/todo/record", new k7c.a());
    L10:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public a() {
    }

    public final View getSendToChatView(Context r4, Drawable r5, String r6, View.OnClickListener r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "clickListener");
        View r8 = LayoutInflater.from(r4).inflate(2131561710, null);
        LinearLayout r0 = (LinearLayout) r8.findViewById(2131378916);
        ImageView r1 = (ImageView) r8.findViewById(2131375173);
        TextView r2 = (TextView) r8.findViewById(2131388516);
        if (r5 == null) goto L5;
        r1.setImageDrawable(r5);
    L5:
        if (r6 == null) goto L7;
        r2.setText(r6);
    L7:
        r0.setOnClickListener(r7);
        Intrinsics.checkNotNull(r8);
        return r8;
    }
}
