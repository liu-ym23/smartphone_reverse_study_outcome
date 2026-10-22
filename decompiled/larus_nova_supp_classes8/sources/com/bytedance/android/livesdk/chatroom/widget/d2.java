package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d2 {
    public final CompositeDisposable a;
    public View b;
    public ViewGroup c;
    public ViewGroup.LayoutParams d;
    public final DataCenter e;
    public final FrameLayout f;
    public final ImageView g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ d2 a;

        public a(d2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            KVData r5 = (KVData) r4;
            this.a.getClass();
            StringBuilder r0 = new StringBuilder("Rev_smoothEnterRoom receive show frame view mock ");
            if (r5 == null) goto L5;
            Object r2 = r5.getData();
        L6:
            r0.append(r2);
            ALogger.d("RevFeedViewHandleWidget", r0.toString());
            if (r5 == null) goto L16;
            Bitmap r6 = (Bitmap) r5.getData(null);
            if (r6 == null) goto L17;
            ImageView r1 = this.a.g;
            if (r1 == null) goto L14;
            r1.setImageBitmap(r6);
        L14:
            this.a.a("leave");
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ d2 a;

        public b(d2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) ((KVData) r4).getData();
            if (r5 != null) goto L5;
            r5 = 0;
        L5:
            int r6 = r5.intValue();
            String r2 = null;
            if (gd0.v.a(r6, 4) == false) goto L18;
            View r7 = this.a.b;
            boolean r0 = r7 instanceof qc0.f;
            if (r0 == false) goto L30;
            if (r0 == true) goto L11;
            r7 = null;
        L11:
            qc0.f r8 = (qc0.f) r7;
            if (r8 == null) goto L15;
            r2 = r8.getFeedViewName();
        L15:
            if ((!Intrinsics.areEqual(r2, "RevPkFullFeedView")) == false) goto L31;
            this.a.a("event");
            return;
        L31:
            return;
        L30:
            return;
        L18:
            if (gd0.v.a(r6, 64) == false) goto L33;
            View r9 = this.a.b;
            boolean r1 = r9 instanceof qc0.f;
            if (r1 == false) goto L34;
            if (r1 == true) goto L23;
            r9 = null;
        L23:
            qc0.f r10 = (qc0.f) r9;
            if (r10 == null) goto L27;
            r2 = r10.getFeedViewName();
        L27:
            if ((!Intrinsics.areEqual(r2, "RevMultiAnchorFeedView")) == false) goto L35;
            this.a.a("event");
            return;
        L35:
            return;
        L34:
            return;
        }
    }

    public static final class c {
    }

    static {
    }

    public final boolean a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if (Intrinsics.areEqual(r7, "leave") == false) goto L15;
        DataCenter r0 = this.e;
        if (r0 == null) goto L7;
        qc0.d r1 = (qc0.d) r0.get("data_rev_enter_room_feed_view_data", null);
    L8:
        if (r1 == null) goto L12;
        Function0 r2 = r1.a();
        if (r2 == null) goto L12;
        Unit r3 = (Unit) r2.invoke();
    L12:
        DataCenter r4 = this.e;
        if (r4 == null) goto L15;
        r4.put("data_rev_enter_room_feed_view_data", null);
        goto L15
    L7:
        r1 = null;
    L15:
        View r5 = this.b;
        if (r5 != null) goto L18;
    L36:
        return false;
    L18:
        if (this.c == null) goto L36;
        if (r5.getParent() != this.f) goto L36;
        ALogger.d("RevFeedViewHandleWidget", "Rev_smoothEnterRoom: remove & back to feed from ".concat(r7));
        FrameLayout r6 = this.f;
        if (r6 == null) goto L25;
        r6.removeView(this.b);
    L25:
        if ((!Intrinsics.areEqual(r7, "event")) == false) goto L32;
        ViewGroup r8 = this.c;
        if (r8 == null) goto L29;
        r8.addView(this.b, this.d);
    L29:
        DataCenter r9 = this.e;
        if (r9 == null) goto L32;
        r9.put("data_rev_enter_room_feed_view_data", null);
    L32:
        this.b = null;
        this.c = null;
        this.d = null;
        ILinkServiceExternal r10 = jc1.k.f(ILinkServiceExternal.class);
        if (r10 == null) goto L35;
        r10.updateEnterRoomViewMock(false);
    L35:
        return true;
    }

    public d2(DataCenter r1, FrameLayout r2, ImageView r3) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.a = new CompositeDisposable();
        if (r1 == null) goto L5;
        r1.observe("cmd_rev_leave_room_show_view_mock", new a(this));
    L5:
        if (r1 == null) goto L8;
        r1.observe("data_link_state", new b(this));
        return;
    }
}
