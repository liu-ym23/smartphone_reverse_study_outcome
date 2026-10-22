package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MessageListScrollManager {
    public ScrollState a;
    public int b;
    public boolean c;
    public final SmoothLinearLayoutManager d;
    public final AnonymousClass3 e;
    public final AnonymousClass4 f;
    public final a g;
    public Disposable h;
    public IMessageListManager i;
    public boolean j;
    public boolean k;
    public final RecyclerView l;
    public final View m;
    public final TextView n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/messagelist/MessageListScrollManager$ScrollState;", BuildConfig.FLAVOR, "AutoScroll", "Focus", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState AutoScroll = null;
        public static final ScrollState Focus = null;
        public static final /* synthetic */ ScrollState[] a = null;

        static {
            ScrollState r1 = new ScrollState("AutoScroll", 0);
            AutoScroll = r1;
            ScrollState r2 = new ScrollState("Focus", 1);
            Focus = r2;
            a = new ScrollState[]{r1, r2};
        }

        public static ScrollState valueOf(String r1) {
            return (ScrollState) r27.a.a(ScrollState.class, r1);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) a.clone();
        }

        public ScrollState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ MessageListScrollManager a;

        public a(MessageListScrollManager r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (r2.getAction() == 1) goto L5;
            return false;
        L5:
            if (this.a.l.canScrollVertically(1) == true) goto L7;
            this.a.e(ScrollState.AutoScroll);
            return false;
        L7:
            this.a.e(ScrollState.Focus);
            MessageListScrollManager.a(this.a);
            return false;
        }
    }

    public static final class b {
    }

    static {
    }

    public static final void a(MessageListScrollManager r4) {
        int r0 = r4.d.findLastVisibleItemPosition();
        if (r0 <= r4.b) goto L13;
        IMessageListManager r1 = r4.i;
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.service.messagelist.b r2 = r1.getConfig();
        if (r2 == null) goto L11;
        l r3 = r2.b();
        if (r3 == null) goto L11;
        r3.a(Math.max(r3.a - (r0 - r4.b), 0));
    L11:
        r4.d(r0);
        return;
    }

    public final void c(boolean r2) {
        if (r2 == true) goto L4;
        e(ScrollState.Focus);
    L4:
        if (r2 == true) goto L6;
        return;
    L6:
        if (this.k == false) goto L10;
        this.l.addOnScrollListener(this.e);
        this.l.setOnFlingListener(this.f);
        this.l.setOnTouchListener(this.g);
        this.k = false;
        return;
    }

    public final void d(int r2) {
        this.b = Math.max(r2, 0);
    }

    public final void e(ScrollState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        int r0 = h.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        this.a = r4;
        IMessageListManager r5 = this.i;
        if (r5 == null) goto L21;
        com.bytedance.android.livesdk.interactivity.service.messagelist.b r6 = r5.getConfig();
        if (r6 == null) goto L21;
        l r7 = r6.b();
        if (r7 == null) goto L21;
        r7.g = false;
        r7.a(0);
    L21:
        RecyclerView.Adapter r8 = this.l.getAdapter();
        if (r8 == null) goto L29;
        int r9 = r8.getItemCount() - 1;
        this.l.scrollToPosition(r9);
        d(r9);
        return;
    L29:
        return;
    L5:
        if (r0 != 2) goto L30;
        this.a = r4;
        IMessageListManager r10 = this.i;
        if (r10 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.service.messagelist.b r11 = r10.getConfig();
        if (r11 == null) goto L26;
        l r13 = r11.b();
        if (r13 == null) goto L27;
        r13.g = true;
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void onEvent(IMessageListManager.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        IMessageListManager.MessageChangeType r0 = r3.getType();
        int r1 = h.b[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r4 = r3.b;
        int r2 = this.b;
        if (r4 > r2) goto L20;
        d(r2 + 1);
        return;
    L20:
        return;
    L5:
        if (r1 != 2) goto L21;
        int r5 = this.b;
        int r6 = r3.d;
        if (r5 < r6) goto L10;
        d(r5 - (r6 - r3.c));
        return;
    L10:
        int r7 = r3.c;
        if (r5 < r7) goto L18;
        d(r7);
        return;
    L18:
        return;
    }

    public static final void b(MessageListScrollManager r6, int r7) {
        if (r7 < 300) goto L6;
        r6.getClass();
        r6.e(ScrollState.AutoScroll);
    L6:
        if (r7 > 0) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
    L37:
        r6.m.setVisibility(8);
        r6.n.setText(BuildConfig.FLAVOR);
        return;
    L14:
        if (r6.c == false) goto L16;
        boolean r3 = true;
    L28:
        if ((!r3) == true) goto L37;
        TextView r4 = r6.n;
        Object[] r0 = new Object[1];
        if (r7 > 99) goto L33;
        String r8 = String.valueOf(r7);
    L34:
        r0[0] = r8;
        r4.setText(s1.C(2131915221, r0));
        if (r6.m.getVisibility() == 0) goto L42;
        MainThreadPostUtils.b(new k(r6));
        return;
    L42:
        return;
    L33:
        r8 = "99+";
        goto L34
    L16:
        int r5 = r6.d.getItemCount();
        int r9 = 0;
        int r10 = 0;
    L17:
        if (r9 >= r5) goto L23;
        View r11 = r6.d.findViewByPosition(r9);
        if (r11 == null) goto L21;
        r10 = (r10 + r11.getHeight()) + m.g;
    L21:
        r9 = r9 + 1;
        goto L17
    L23:
        if (r10 < r6.l.getHeight()) goto L25;
        r3 = true;
    L26:
        r6.c = r3;
        goto L28
    L25:
        r3 = false;
        goto L26
    L8:
        if (r6.a == ScrollState.AutoScroll) goto L11;
        r2 = false;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [com.bytedance.android.livesdk.interactivity.service.messagelist.MessageListScrollManager$3] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.bytedance.android.livesdk.interactivity.service.messagelist.MessageListScrollManager$4] */
    public MessageListScrollManager(RecyclerView r2, View r3, TextView r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "hintLayout");
        Intrinsics.checkNotNullParameter(r4, "hintTextView");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.a = ScrollState.Focus;
        this.j = true;
        this.k = true;
        r3.setOnClickListener(x0.a(new AnonymousClass1(this)));
        SmoothLinearLayoutManager r6 = new SmoothLinearLayoutManager(r2.getContext());
        r6.p(r5);
        Unit r7 = Unit.INSTANCE;
        this.d = r6;
        this.e = new AnonymousClass3(this);
        this.f = new AnonymousClass4(this);
        this.g = new a(this);
        r2.setItemAnimator(null);
        r2.setLayoutManager(r6);
    }
}
