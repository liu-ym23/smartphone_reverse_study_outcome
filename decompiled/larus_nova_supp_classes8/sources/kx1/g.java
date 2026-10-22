package kx1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.live.core.utils.s1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends FrameLayout {
    public Map<Integer, View> a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ Option b;

        public a(d r1, Option r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a(this.b);
        }
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public g(Context r3, Option r4, d r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "option");
        Intrinsics.checkNotNullParameter(r5, "listener");
        super(r3, null, 0);
        this.a = new LinkedHashMap();
        View.inflate(r3, 2131566651, this);
        TextView r0 = (TextView) a(2131381605);
        String r1 = r4.text;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0.setText(r1);
        TextView r6 = (TextView) a(2131381605);
        Boolean r2 = r4.negative;
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r7) == false) goto L9;
        int r8 = -16777216;
    L10:
        r6.setTextColor(r8);
        if (Intrinsics.areEqual(r4.negative, r7) == false) goto L13;
        int r9 = 2131249127;
    L14:
        a(2131384840).setBackground(s1.m(r9));
        setOnClickListener(new a(r5, r4));
        return;
    L13:
        r9 = 2131249128;
        goto L14
    L9:
        r8 = -1;
        goto L10
    }
}
