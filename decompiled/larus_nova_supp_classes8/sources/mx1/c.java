package mx1;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Question;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kx1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends nx1.a<f> {
    public Map<Integer, View> b;
    public final Set<kx1.c> c;
    public final a d;

    public static final class a implements kx1.e {
        public final /* synthetic */ c a;
        public final /* synthetic */ b b;

        @Override // kx1.e
        public final void a(kx1.c r2) {
            Intrinsics.checkNotNullParameter(r2, "option");
            this.a.c.add(r2);
            this.b.b(this.a);
        }

        @Override // kx1.e
        public final void b(kx1.a r2) {
            Intrinsics.checkNotNullParameter(r2, "option");
            this.a.c.remove(r2);
            Set<kx1.c> r3 = this.a.c;
            if (r3.size() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r3 = null;
        L9:
            if (r3 == null) goto L12;
            this.b.a(this.a);
            return;
        L12:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public a(c r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        return null;
    }

    @Override // nx1.a
    public lx1.b<f> getOptionFactory() {
        return new lx1.c(getContext(), this.d);
    }

    @Override // nx1.a, nx1.b
    public String getSelectResult() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        kx1.c r2 = (kx1.c) r1.next();
        StringBuilder r3 = new StringBuilder();
        String r4 = getQuestion().questionKey;
        String r5 = "";
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r3.append(r4);
        r3.append('-');
        String r6 = r2.getOptionKey();
        if (r6 == null) goto L12;
        r5 = r6;
    L12:
        r3.append(r5);
        r0.add(r3.toString());
        goto L4
    L14:
        return CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null);
    }

    @Override // nx1.a, nx1.b
    public String getSelectToast() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = ((kx1.c) r0.next()).a();
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // nx1.b
    public final void reset() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((kx1.c) r0.next()).c();
        goto L4
    L6:
        this.c.clear();
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

    public c(Context r2, Question r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "question");
        Intrinsics.checkNotNullParameter(r4, "listener");
        super(r2, r3);
        this.b = new LinkedHashMap();
        this.c = new LinkedHashSet();
        this.d = new a(this, r4);
        View.inflate(r2, 2131566652, this);
        TextView r5 = (TextView) b(2131383539);
        if (r5 == null) goto L5;
        r5.setText(r3.questionText);
    L5:
        GridLayout r6 = (GridLayout) b(2131381607);
        if (r6 == null) goto L13;
        r6.removeAllViews();
        List<f> r7 = a();
        if (r7 == null) goto L15;
        Iterator<T> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        r6.addView((f) r8.next());
        goto L11
    L16:
        return;
    L15:
        return;
    }
}
