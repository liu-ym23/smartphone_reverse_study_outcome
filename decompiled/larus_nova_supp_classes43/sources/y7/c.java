package y7;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.debug.ui.DialogItem;
import com.bytedance.android.annie.debug.ui.JsbWhiteListFragment;
import com.bytedance.android.annie.debug.ui.ParamsModelFragment;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements d {
    public final Context a;
    public final AnnieCard b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            a8.c.b(this.a.a, new JsbWhiteListFragment(), "white_list");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Context r11 = this.a.a;
            ParamsModelFragment r0 = new ParamsModelFragment();
            r0.d = this.a.b;
            a8.c.b(r11, r0, "params_model");
        }
    }

    @Override // y7.d
    public final String getTitle() {
        return "CONTAINER";
    }

    @Override // y7.d
    public final List<DialogItem> a() {
        LinkedList r0 = new LinkedList();
        AnnieCard r10 = this.b;
        if (r10 == null) goto L6;
        String r11 = r10.getBizKey();
        if (r11 == null) goto L6;
    L7:
        String r1 = ((i9.d) Annie.getService(i9.d.class, r11)).k0();
        if (r1 == null) goto L10;
        r0.add(new DialogItem("容器版本", r1, null, 4));
    L10:
        r0.add(new DialogItem("JSB白名单", null, new a(this), 2));
        r0.add(new DialogItem("ParamsModel", null, new b(this), 2));
        return r0;
    L6:
        r11 = "host";
        goto L7
    }

    public c(Context r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r10;
        this.b = r11;
    }
}
