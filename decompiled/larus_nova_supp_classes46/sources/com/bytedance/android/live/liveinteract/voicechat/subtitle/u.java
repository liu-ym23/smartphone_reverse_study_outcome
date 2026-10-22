package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u {
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public LinearLayoutManager a;
    public LinkmicSubtitleAdapter b;
    public final h0<Boolean> c;
    public final h0<Boolean> d;
    public final b e;
    public final Context f;
    public final IRoom g;
    public final SubtitleRecyclerView h;
    public final TextView i;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ u a;

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            u r4 = this.a;
            RecyclerView r0 = r4.h;
            if (r0 == null) goto L5;
            r0.post(new v(r4));
        L5:
            removeCallbacksAndMessages(null);
            int r5 = u.j;
            sendEmptyMessageDelayed(1, u.j + 100);
        }

        public b(u r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
        j = vm2.c.b().getSubtitleAnimDuration();
        k = vm2.c.b().getSubtitleAnimDuration();
        l = UtilityKotlinExtentionsKt.i(18);
    }

    public final void a() {
        this.e.removeCallbacksAndMessages(null);
        LinkmicSubtitleAdapter r0 = this.b;
        if (r0 == null) goto L6;
        r0.b.removeCallbacksAndMessages(null);
        return;
    }

    public final Context getContext() {
        return this.f;
    }

    public final void b(List<nj0.g> r13) {
        Intrinsics.checkNotNullParameter(r13, "subtitles");
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L63;
        nj0.g r0 = (nj0.g) r14.next();
        if (r0.c.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
        LinkmicSubtitleAdapter r2 = this.b;
        String r4 = null;
        if (r2 == null) goto L41;
        Intrinsics.checkNotNullParameter(r0, "subtitleItem");
        int r7 = 10;
        if (r2.a.size() > 10) goto L16;
        r7 = r2.a.size();
    L16:
        if (r7 == 0) goto L41;
        if (1 > r7) goto L41;
        int r6 = 1;
    L20:
        int r8 = r2.a.size() - r6;
        nj0.g r9 = r2.a.get(r8);
        if (r9 != null) goto L23;
    L39:
        if (r6 == r7) goto L41;
        r6 = r6 + 1;
        goto L20
    L23:
        if (Intrinsics.areEqual(r9.b, r0.b) == true) goto L25;
    L27:
        Intrinsics.checkNotNullParameter(r0, "subtitleItem");
        if (Intrinsics.areEqual(r9.b, r0.b) == true) goto L30;
    L36:
        boolean r10 = false;
    L37:
        if (r10 == false) goto L39;
        Pair r3 = new Pair(r9, Integer.valueOf(r8));
    L42:
        if (r3 != null) goto L43;
        LinkmicSubtitleAdapter r5 = this.b;
        if (r5 == null) goto L60;
        CopyOnWriteArrayList<nj0.g> r11 = r5.a;
        if (r11 == null) goto L60;
        if (r11.isEmpty() != true) goto L60;
        TextView r12 = this.i;
        if (r12 == null) goto L60;
        IBaseUser r15 = r0.a;
        if (r15 == null) goto L59;
        r4 = r15.getRealNickName();
    L59:
        r12.setText(r4);
    L60:
        LinkmicSubtitleAdapter r16 = this.b;
        if (r16 == null) goto L4;
        r16.z2(this.d, this.c, r0);
        goto L4
    L43:
        boolean r17 = !Intrinsics.areEqual(r0.c, ((nj0.g) r3.getFirst()).c);
        nj0.g r18 = (nj0.g) r3.getFirst();
        int r19 = ((Number) r3.getSecond()).intValue();
        r18.a = r0.a;
        String r20 = r0.c;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.c = r20;
        r18.e = r0.e;
        r18.d = r0.d;
        if (r17 == false) goto L4;
        LinkmicSubtitleAdapter r21 = this.b;
        if (r21 == null) goto L4;
        r21.y2(this.d, this.c, r19);
        goto L4
    L30:
        if (Intrinsics.areEqual(r9.c, r0.c) == false) goto L36;
        if (r9.d != r0.d) goto L36;
        if (r9.e != r0.e) goto L36;
        r10 = true;
        goto L37
    L25:
        if (r9.e == true) goto L27;
        r3 = new Pair(r9, Integer.valueOf(r8));
    L41:
        r3 = null;
        goto L42
    L8:
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Context r5, IRoom r6, SubtitleRecyclerView r7, TextView r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        int r0 = j;
        int r1 = k;
        h0<Boolean> r9 = new h0((r0 + r1) * 2);
        this.c = r9;
        h0<Boolean> r2 = new h0(r1 * 2);
        this.d = r2;
        this.e = new b(this, Looper.getMainLooper());
        this.a = new LinearLayoutManager(r5);
        this.b = new LinkmicSubtitleAdapter(r6);
        if (r7 == 0) goto L5;
        r7.setHasFixedSize(true);
        r7.setLayoutManager(this.a);
        r7.setOverScrollMode(2);
        r7.setItemAnimator(null);
        r7.setAdapter(this.b);
        r7.addOnScrollListener(new LinkmicSubtitleManager$initRecyclerView$$inlined$apply$lambda$1(this));
    L5:
        Boolean r10 = Boolean.FALSE;
        r9.b(r10);
        r2.b(r10);
    }
}
