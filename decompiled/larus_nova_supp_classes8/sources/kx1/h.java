package kx1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Option;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends a {
    public Map<Integer, View> d;

    @Override // kx1.a, kx1.c
    public final void b() {
        this.a = true;
        d(2131384840).setBackgroundResource(2131249124);
        d(2131374710).setVisibility(0);
    }

    @Override // kx1.a, kx1.c
    public final void c() {
        this.a = false;
        d(2131384840).setBackgroundResource(2131249125);
        d(2131374710).setVisibility(8);
    }

    @Override // kx1.a
    public int getLayoutId() {
        return 2131566650;
    }

    public final View d(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.d.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public h(Context r2, Option r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "option");
        Intrinsics.checkNotNullParameter(r4, "listener");
        super(r2, r3, r4);
        this.d = new LinkedHashMap();
        View.inflate(r2, getLayoutId(), this);
        TextView r5 = (TextView) d(2131381605);
        String r6 = r3.text;
        if (r6 != null) goto L6;
        r6 = "";
    L6:
        r5.setText(r6);
    }
}
