package kx1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.Option;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends FrameLayout implements c {
    public Map<Integer, View> a;
    public final Option b;
    public final e c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getListener().a(this.a);
            this.a.b();
        }
    }

    @Override // kx1.c
    public final String a() {
        return this.b.toastText;
    }

    @Override // kx1.c
    public String getOptionKey() {
        String r0 = this.b.key;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // kx1.c
    public Long getSubQuestionId() {
        return this.b.question;
    }

    @Override // kx1.c
    public final void b() {
        d(2131373877).setBackgroundResource(2131250996);
    }

    @Override // kx1.c
    public final void c() {
        d(2131373877).setBackgroundResource(2131250998);
    }

    public final e getListener() {
        return this.c;
    }

    public final Option getOption() {
        return this.b;
    }

    public final View d(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.a).get(2131373877);
        if (r4 != null) goto L12;
        View r5 = findViewById(2131373877);
        if (r5 == null) goto L10;
        this.a.put(2131373877, r5);
        return r5;
    L10:
        return null;
    L12:
        return r4;
    }

    public b(Context r3, Option r4, e r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "option");
        Intrinsics.checkNotNullParameter(r5, "listener");
        super(r3, null, 0);
        this.b = r4;
        this.c = r5;
        this.a = new LinkedHashMap();
        View.inflate(r3, 2131566648, this);
        setOnClickListener(new a(this));
    }
}
