package mx1;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Question;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kx1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends nx1.a<h> {
    public Map<Integer, View> b;
    public kx1.c c;
    public final a d;

    public static final class a implements kx1.e {
        public final /* synthetic */ d a;
        public final /* synthetic */ b b;

        @Override // kx1.e
        public final void a(kx1.c r2) {
            Intrinsics.checkNotNullParameter(r2, "option");
            if ((!Intrinsics.areEqual(r2, this.a.c)) == false) goto L9;
            kx1.c r0 = this.a.c;
            if (r0 == null) goto L7;
            r0.c();
        L7:
            d r1 = this.a;
            r1.c = r2;
            this.b.b(r1);
            return;
        }

        @Override // kx1.e
        public final void b(kx1.a r2) {
            Intrinsics.checkNotNullParameter(r2, "option");
            if (Intrinsics.areEqual(this.a.c, r2) == false) goto L6;
            d r3 = this.a;
            r3.c = null;
            this.b.a(r3);
            return;
        }

        public a(d r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // nx1.a
    public lx1.b<h> getOptionFactory() {
        return new lx1.e(getContext(), this.d);
    }

    @Override // nx1.a, nx1.b
    public String getSelectResult() {
        StringBuilder r0 = new StringBuilder();
        String r1 = getQuestion().questionKey;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        r0.append('-');
        kx1.c r3 = this.c;
        if (r3 == null) goto L11;
        String r4 = r3.getOptionKey();
        if (r4 == null) goto L11;
        r2 = r4;
    L11:
        r0.append(r2);
        return r0.toString();
    }

    @Override // nx1.a, nx1.b
    public String getSelectToast() {
        kx1.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        kx1.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSubQuestionId();
    }

    @Override // nx1.b
    public final void reset() {
        kx1.c r0 = this.c;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.c = null;
    }

    public final View b(int r3) {
        if (this.b != null) goto L5;
        this.b = new LinkedHashMap();
    L5:
        View r0 = this.b.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.b.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public d(Context r2, Question r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "question");
        Intrinsics.checkNotNullParameter(r4, "listener");
        super(r2, r3);
        this.b = new LinkedHashMap();
        this.d = new a(this, r4);
        View.inflate(r2, 2131566653, this);
        TextView r5 = (TextView) b(2131383539);
        if (r5 == null) goto L5;
        r5.setText(r3.questionText);
    L5:
        GridLayout r6 = (GridLayout) b(2131381607);
        if (r6 == null) goto L13;
        r6.removeAllViews();
        List<h> r7 = a();
        if (r7 == null) goto L15;
        Iterator<T> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        r6.addView((h) r8.next());
        goto L11
    L16:
        return;
    L15:
        return;
    }
}
