package com.bytedance.android.livesdk.interactivity.publicscreen.pin;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.TextMessageLayoutManager;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u42.f;
import u42.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements u42.c, WeakHandler.IHandler {
    public u42.b a;
    public final Lazy b;
    public u42.b c;
    public final DataCenter d;
    public final ViewGroup e;
    public final aa2.a f;
    public final MessageListAdapter g;
    public final LinearLayoutManager h;

    public static final class a {
    }

    public static final class b implements u42.a {
        public final Context a;
        public final ViewGroup b;

        @Override // u42.a
        public Context getContext() {
            return this.a;
        }

        public b(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "pinContainer");
            this.b = r2;
            this.a = r2.getContext();
        }

        public final View a(int r4) {
            LayoutInflater.from(getContext()).inflate(r4, this.b, true);
            return this.b.getChildAt(0);
        }
    }

    static {
    }

    public final WeakHandler b() {
        return (WeakHandler) this.b.getValue();
    }

    @Override // u42.c
    public final boolean a(u42.b r13) {
        if (r13 != null) goto L7;
        this.c = null;
        return false;
    L7:
        if (Intrinsics.areEqual(r13, this.c) == false) goto L9;
        return false;
    L9:
        this.c = r13;
        long r9 = r13.h();
        if (r13.a() == false) goto L12;
        return false;
    L12:
        if (r9 <= 0) goto L36;
        f.a("tryPin type=" + r13.getType() + " priority=" + r13.getPriority());
        u42.b r2 = this.a;
        if (r2 != null) goto L16;
        boolean r0 = false;
    L20:
        this.e.setVisibility(0);
        if (this.e.getChildCount() <= 0) goto L23;
        this.e.removeAllViews();
    L23:
        View r6 = r13.i(new b(this.e));
        if (r6.getParent() != null) goto L26;
        this.e.addView(r6);
    L26:
        r13.c(new u42.e(r9, r6, this.d, this.g.e.m));
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1 = r13.getMessage();
        if (r0 == false) goto L30;
        b().post(new e(this, r1));
    L33:
        b().sendEmptyMessageDelayed(1, r9);
        r13.b();
        this.a = r13;
        return true;
    L30:
        if ((r1 instanceof z) == false) goto L32;
        this.f.w(new d(r1));
        goto L33
    L32:
        this.f.Q(r1.b);
        goto L33
    L16:
        if (r2.getPriority() < r13.getPriority()) goto L18;
        f.a("pin failed. cur: type=" + r2.getType() + " priority=" + r2.getPriority());
        return false;
    L18:
        r0 = c(true, null);
        goto L20
    L36:
        return false;
    }

    public final void handleMsg(Message r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.what != 1) goto L8;
        c(false, null);
        return;
    }

    public final boolean c(boolean r5, Boolean r6) {
        u42.b r0 = this.a;
        if (r0 == null) goto L15;
        f.a("unpin. evict=" + r5 + " type=" + r0.getType());
        r0.f(new h(r5, this.d));
        this.e.setVisibility(8);
        this.e.removeAllViews();
        if (r6 == null) goto L7;
        boolean r7 = r6.booleanValue();
    L8:
        if (r7 == false) goto L10;
        int r1 = RangesKt.coerceAtLeast(this.h.findFirstVisibleItemPosition(), 0);
        f.a("insert to message list. pos=" + r1);
        this.f.D(r1, r0.getMessage());
        this.g.notifyDataSetChanged();
    L10:
        this.a = null;
        if (r5 == false) goto L14;
        b().removeMessages(1);
    L14:
        return r7;
    L7:
        r7 = r0.e();
        goto L8
    L15:
        return false;
    }

    public c(DataCenter r2, ViewGroup r3, aa2.a r4, MessageListAdapter r5, TextMessageLayoutManager r6) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "pinContainer");
        Intrinsics.checkNotNullParameter(r4, "presenter");
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.b = LazyKt.lazy(new PinManager$handler$2(this));
    }
}
