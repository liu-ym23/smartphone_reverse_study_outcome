package mx1;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends nx1.a<kx1.b> {
    public Map<Integer, View> b;
    public final List<? extends kx1.c> c;
    public kx1.c d;
    public final C0402a e;

    /* JADX INFO: renamed from: mx1.a$a, reason: collision with other inner class name */
    public static final class C0402a implements kx1.e {
        public final /* synthetic */ a a;
        public final /* synthetic */ b b;

        @Override // kx1.e
        public final void b(kx1.a r2) {
            Intrinsics.checkNotNullParameter(r2, "option");
        }

        @Override // kx1.e
        public final void a(kx1.c r5) {
            Intrinsics.checkNotNullParameter(r5, "option");
            List<? extends kx1.c> r0 = this.a.c;
            if (r0 == null) goto L27;
            int r1 = r0.indexOf(r5);
            a r2 = this.a;
            r2.d = r5;
            List<? extends kx1.c> r6 = r2.c;
            if (r6 != null) goto L7;
        L22:
            this.b.b(this.a);
            return;
        L7:
            if ((!r6.isEmpty()) == true) goto L10;
            r6 = null;
        L10:
            if (r6 == null) goto L22;
            Iterator<T> r7 = r6.iterator();
            int r3 = 0;
        L13:
            if (r7.hasNext() == false) goto L22;
            Object r4 = r7.next();
            int r8 = r3 + 1;
            if (r3 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            kx1.c r9 = (kx1.c) r4;
            if (r3 > r1) goto L20;
            r9.b();
        L21:
            r3 = r8;
            goto L13
        L20:
            r9.c();
            goto L21
        }

        public C0402a(a r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // nx1.a
    public lx1.b<kx1.b> getOptionFactory() {
        return new lx1.a(getContext(), this.e);
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
        kx1.c r3 = this.d;
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
        kx1.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        kx1.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSubQuestionId();
    }

    @Override // nx1.b
    public final void reset() {
        List<? extends kx1.c> r0 = this.c;
        if (r0 != null) goto L5;
    L16:
        this.d = null;
        return;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L16;
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L11:
        if (r1.hasNext() == false) goto L16;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ((kx1.c) r3).c();
        r2 = r4;
        goto L11
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

    public a(Context r6, Question r7, b r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "question");
        Intrinsics.checkNotNullParameter(r8, "listener");
        super(r6, r7);
        this.b = new LinkedHashMap();
        this.e = new C0402a(this, r8);
        View.inflate(r6, 2131566647, this);
        List<kx1.b> r9 = a();
        this.c = r9;
        TextView r10 = (TextView) b(2131383539);
        if (r10 == null) goto L5;
        r10.setText(r7.questionText);
    L5:
        GridLayout r11 = (GridLayout) b(2131381607);
        if (r11 == null) goto L32;
        r11.removeAllViews();
        if (r9 == null) goto L38;
        Iterator<T> r12 = r9.iterator();
        int r13 = 0;
    L11:
        if (r12.hasNext() == false) goto L39;
        Object r0 = r12.next();
        int r1 = r13 + 1;
        if (r13 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        Object r2 = (kx1.c) r0;
        Object r3 = null;
        if (r13 != 0) goto L24;
        GridLayout.LayoutParams r14 = new GridLayout.LayoutParams();
        r14.width = UtilityKotlinExtentionsKt.i(32);
        r14.height = UtilityKotlinExtentionsKt.i(32);
        if ((r2 instanceof View) == false) goto L22;
        r3 = r2;
    L22:
        if (((View) r3) == null) goto L31;
        r11.addView((View) r2, r14);
    L31:
        r13 = r1;
        goto L11
    L24:
        GridLayout.LayoutParams r15 = new GridLayout.LayoutParams();
        r15.width = UtilityKotlinExtentionsKt.i(32);
        r15.height = UtilityKotlinExtentionsKt.i(32);
        r15.leftMargin = UtilityKotlinExtentionsKt.i(24);
        if ((r2 instanceof View) == false) goto L29;
        r3 = r2;
    L29:
        if (((View) r3) == null) goto L31;
        r11.addView((View) r2, r15);
        goto L31
    L39:
        return;
    L38:
        return;
    }
}
