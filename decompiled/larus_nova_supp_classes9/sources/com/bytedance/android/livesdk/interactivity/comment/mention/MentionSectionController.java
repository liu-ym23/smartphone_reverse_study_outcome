package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import r52.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MentionSectionController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
    public q4.b c;
    public q4.b d;
    public final MentionListSearchingView e;
    public float f;
    public final float g;
    public final RecyclerView h;
    public List<l> i;
    public final List<k> j;
    public final a k;
    public boolean l;
    public boolean m;
    public final Long n;
    public List<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c> o;
    public final b p;
    public final MentionListAdapter q;
    public final CompositeDisposable r;
    public final View s;

    public static final class a {
        public boolean a;
        public final List<k> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends k> r2) {
            Intrinsics.checkNotNullParameter(r2, "listeners");
            this.b = r2;
        }

        public final void a(boolean r3) {
            this.a = r3;
            Iterator<T> r0 = this.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((k) r0.next()).a(r3);
            goto L4
        }
    }

    public final class b extends Observable<CharSequence> implements TextWatcher {
        public Observer<? super CharSequence> a;
        public final OpenInputSource b;
        public final boolean c;
        public boolean d;
        public final /* synthetic */ MentionSectionController e;

        public static final class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ b b;

            public a(int r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.e.q.notifyItemChanged(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        public final void a() {
            MentionSectionController r0 = this.e;
            r0.i = CollectionsKt.emptyList();
            this.e.k.a(false);
            this.e.b.P(false);
            Observer<? super CharSequence> r1 = this.a;
            if (r1 == null) goto L6;
            r1.onNext(BuildConfig.FLAVOR);
            return;
        }

        public b(MentionSectionController r2) {
            this.e = r2;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = r2.b.V();
            if (r0 == null) goto L7;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
            if (r1 == null) goto L7;
            OpenInputSource r3 = r1.t;
        L8:
            this.b = r3;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r4 = r2.b.V();
            if (r4 == null) goto L15;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r5 = r4.g;
            if (r5 == null) goto L15;
            boolean r6 = true;
            if (r5.v != true) goto L15;
        L16:
            this.c = r6;
            return;
        L15:
            r6 = false;
        L7:
            r3 = null;
            goto L8
        }

        public final void subscribeActual(Observer<? super CharSequence> r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r8, int r9, int r10, int r11) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r10 != 0) goto L40;
            return;
        L40:
            MentionSpan[] r13 = (MentionSpan[]) new SpannableStringBuilder(r8).getSpans(r9 + 1, (r9 + r10) - 1, MentionSpan.class);     // Catch: Throwable -> L19
            if (r13 == null) goto L47;
            int r14 = r13.length;     // Catch: Throwable -> L19
            int r1 = 0;
        L10:
            if (r1 >= r14) goto L48;
            MentionSpan r2 = r13[r1];     // Catch: Throwable -> L19
            Iterator<l> r3 = this.e.i.iterator();     // Catch: Throwable -> L19
            int r4 = 0;
        L13:
            if (r3.hasNext() == false) goto L25;
            l r5 = r3.next();     // Catch: Throwable -> L19
            if (r5.a.getUserId() != null) goto L17;
        L21:
            boolean r6 = false;
        L22:
            if (r6 == true) goto L26;
            r4 = r4 + 1;     // Catch: Throwable -> L19
        L26:
            Integer r7 = Integer.valueOf(r4);     // Catch: Throwable -> L19
            int r15 = r7.intValue();     // Catch: Throwable -> L19
            int r16 = this.e.i.size();     // Catch: Throwable -> L19
            if (r15 < 0) goto L31;
            if (r16 <= r15) goto L31;
            boolean r17 = true;
        L32:
            if (r17 == true) goto L35;
            r7 = null;
        L35:
            if (r7 == null) goto L37;
            int r18 = r7.intValue();     // Catch: Throwable -> L19
            ((l) ListProtector.get(this.e.i, r18)).b = false;     // Catch: Throwable -> L19
            MainThreadPostUtils.b(new a(r18, this));     // Catch: Throwable -> L19
        L37:
            r1 = r1 + 1;
        L31:
            r17 = false;
            goto L32
        L17:
            if (Intrinsics.areEqual(r5.a.getUserId(), r2.b) == false) goto L21;
            r6 = true;
            goto L22
        L25:
            r4 = -1;
            goto L26
        L48:
            return;
        L47:
            return;
        L19:
            th = move-exception;
            SafetyGuard.a(null, th, "Input mention beforeTextChanged error");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r9, int r10, int r11, int r13) {
            if (r9 != null) goto L36;
            return;
        L36:
            int r0 = 0;
            if (this.c == true) goto L7;
        L12:
            this.d = true;     // Catch: Throwable -> L29
            int r14 = r10 + r13;     // Catch: Throwable -> L29
            int r15 = StringsKt.lastIndexOf$default(r9, '@', r14 - 1, false, 4, null);     // Catch: Throwable -> L29
            SpannableStringBuilder r2 = new SpannableStringBuilder(r9);     // Catch: Throwable -> L29
            Object[] r3 = r2.getSpans(0, r14, MentionSpan.class);     // Catch: Throwable -> L29
            int r4 = r3.length;     // Catch: Throwable -> L29
            int r5 = -2;
        L13:
            if (r0 >= r4) goto L15;
            r5 = RangesKt.coerceAtLeast(r5, r2.getSpanEnd((MentionSpan) r3[r0]));     // Catch: Throwable -> L29
            r0 = r0 + 1;     // Catch: Throwable -> L29
            goto L13
        L15:
            EditText r1 = this.e.b.a;     // Catch: Throwable -> L29
            if (r1 == null) goto L22;
            int r6 = r5 + 1;     // Catch: Throwable -> L29
            if (r1.getSelectionStart() != r6) goto L22;
            if (Intrinsics.areEqual(r9.subSequence(r5, r6).toString(), " ") == false) goto L22;
            return;
        L22:
            if (r15 >= 0) goto L25;
            a();     // Catch: Throwable -> L29
            return;
        L25:
            if (r5 > r15) goto L31;
            this.e.k.a(true);     // Catch: Throwable -> L29
            Observer<? super CharSequence> r16 = this.a;     // Catch: Throwable -> L29
            if (r16 == null) goto L38;
            r16.onNext(r9.subSequence(r15, r14));     // Catch: Throwable -> L29
            return;
        L38:
            return;
        L31:
            if (r13 <= 0) goto L40;
            a();     // Catch: Throwable -> L29
            return;
        L40:
            return;
        L7:
            if (this.d == true) goto L12;
            if (CollectionsKt.contains(SetsKt.setOf(new OpenInputSource[]{OpenInputSource.ProfileAt, OpenInputSource.AtUserEvent, OpenInputSource.LongPressMessage}), this.b) == false) goto L12;
            this.d = true;     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            SafetyGuard.a(null, th, "Input mention onTextChanged error");
        }
    }

    public static final class c implements m {
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;

        public c(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.mention.m
        public final void a(l r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "item");
            EditText r0 = this.a.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r9 == true) goto L23;
            Editable r10 = r0.getEditableText();
            if (r10 == null) goto L31;
            int r2 = 0;
            Object[] r1 = r10.getSpans(0, r10.length() - 1, MentionSpan.class);
            ArrayList r3 = new ArrayList();
            int r4 = r1.length;
        L9:
            if (r2 >= r4) goto L14;
            Object r5 = r1[r2];
            if (Intrinsics.areEqual(((MentionSpan) r5).b, r8.a.getUserId()) == false) goto L13;
            r3.add(r5);
        L13:
            r2 = r2 + 1;
            goto L9
        L14:
            Iterator r11 = r3.iterator();
        L16:
            if (r11.hasNext() == false) goto L32;
            MentionSpan r6 = (MentionSpan) r11.next();
            int r7 = r10.getSpanEnd(r6);
            if (r7 >= (r10.length() - 1)) goto L22;
            if (r10.charAt(r7) != ' ') goto L22;
            r7 = r7 + 1;
        L22:
            r10.delete(r10.getSpanStart(r6), r7);
            goto L16
        L32:
            return;
        L31:
            return;
        }
    }

    public final void h() {
        a1.k(this.s, (int) this.g);
        q4.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        q4.b r1 = u4.c(new MentionSectionController$showWithAnimate$1(this));
        r1.c();
        this.c = r1;
    }

    public final void g(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "doOnEnd");
        q4.b r0 = this.d;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        q4.b r3 = u4.c(new MentionSectionController$hideWithAnimate$1(this, r2));
        r3.c();
        this.d = r3;
    }

    public MentionSectionController(View r2, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        super(r2, r3);
        this.s = r2;
        this.e = (MentionListSearchingView) r2.findViewById(2131379091);
        this.g = s1.f(129.0f);
        this.h = r2.findViewById(2131379892);
        this.i = CollectionsKt.emptyList();
        ArrayList r4 = new ArrayList();
        this.j = r4;
        this.k = new a(r4);
        this.l = true;
        this.n = (Long) d1.a.getValue();
        this.p = new b(this);
        this.q = new MentionListAdapter(new c(r3), r3);
        this.r = new CompositeDisposable();
    }
}
