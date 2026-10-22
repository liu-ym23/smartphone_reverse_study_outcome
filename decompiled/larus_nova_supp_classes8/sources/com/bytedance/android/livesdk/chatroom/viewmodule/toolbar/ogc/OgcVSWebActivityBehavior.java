package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import am2.x;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.j;
import io.reactivex.l;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pp1.g;
import py.k;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class OgcVSWebActivityBehavior extends fm3.b implements c0.a {
    public static final /* synthetic */ int o = 0;
    public final List<Disposable> d;
    public DataCenter e;
    public View f;
    public View g;
    public Drawable h;
    public final Lazy i;
    public final String j;
    public final k k;
    public final Integer l;
    public final k m;
    public final boolean n;

    public static final class a<T> implements l {
        public final /* synthetic */ OgcVSWebActivityBehavior a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc.OgcVSWebActivityBehavior$a$a, reason: collision with other inner class name */
        public static final class C0081a<T> implements Consumer {
            public final /* synthetic */ j a;

            public C0081a(j r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                Bitmap r5 = (Bitmap) r4;
                if (r5 != null) goto L5;
            L8:
                this.a.onError(new Throwable("invalide bitmap"));
                return;
            L5:
                if (r5.isRecycled() == true) goto L8;
                this.a.onSuccess(new BitmapDrawable(s1.getResources(), r5));
                this.a.onComplete();
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ j a;

            public b(j r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                Intrinsics.checkNotNullParameter(r3, "e");
                this.a.onError(r3);
            }
        }

        public a(OgcVSWebActivityBehavior r1) {
            this.a = r1;
        }

        public final void a(j<Drawable> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            Disposable r5 = a1.k(this.a.k).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0081a(r4), new b(r4));
            ((ArrayList) this.a.d).add(r5);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.a
    public final Maybe<Drawable> getIcon() {
        return Maybe.create(new a(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.a
    public final Maybe<String> getTitle() {
        return Maybe.just("活动");
    }

    public final void a(View r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Integer r0 = this.l;
        if (r0 != null) goto L8;
    L9:
        Integer r1 = this.l;
        if (r1 != null) goto L13;
    L18:
        fq1.d.a().handleSchema(r6.getContext(), UriProtector.parse(new UrlBuilder(this.j).build()));
        Pair[] r7 = new Pair[1];
        if (this.n == true) goto L21;
        String r2 = "toolbar";
    L22:
        r7[0] = TuplesKt.to("vs_scene_source", r2);
        Map r8 = MapsKt.mutableMapOf(r7);
        j0.l().sendLog("livesdk_ogc_icon_click", r8, new Object[]{x.class, IRoom.class});
        return;
    L21:
        r2 = "more";
        goto L22
    L13:
        if (r1.intValue() != 2) goto L18;
    L15:
        if (r.r().isRecording(this.e) == false) goto L18;
        f2.b(2131921938, 0);
        return;
    L8:
        if (r0.intValue() == 1) goto L15;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r6) {
        Intrinsics.checkNotNullParameter(r6, "command");
        if ((r6 instanceof g) == true) goto L5;
    L7:
        DataCenter r0 = this.e;
        if (r0 != null) goto L10;
        return;
    L10:
        final View r1 = this.f;
        if (r1 != null) goto L14;
        return;
    L14:
        if ((r6 instanceof pp1.c) == false) goto L26;
        u r2 = r.u(r0, null, 2);
        if (r2 == null) goto L27;
        z<pp1.c> r3 = r.y().createToolbarBubble(this.e, r1.getContext(), r1);
        if (r3 != null) goto L20;
        return;
    L20:
        com.bytedance.live.datacontext.j<a0<pp1.c>> r4 = r2.e1();
        if (r4 == null) goto L28;
        a0 r5 = (a0) r4.getValue();
        if (r5 == null) goto L29;
        r5.addBubble(r6, ((pp1.c) r6).k, r3, new OgcVSWebActivityBehavior$onCommand$1(this, r1));
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (((g) r6).a == false) goto L7;
        y3.f(this.e).k(ToolbarButton.VS_ACTIVITY_ONE, (OgcVSWebActivityBehavior) this.i.getValue());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e = null;
        this.f = null;
        Iterator<T> r4 = this.d.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((Disposable) r4.next()).dispose();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.e = r6;
        this.f = r5;
        this.g = r5.findViewById(2131374718);
        if (this.n == false) goto L5;
    L7:
        Pair[] r7 = new Pair[1];
        if (this.n == true) goto L10;
        String r0 = "toolbar";
    L11:
        r7[0] = TuplesKt.to("vs_scene_source", r0);
        Map r8 = MapsKt.mutableMapOf(r7);
        j0.l().sendLog("livesdk_ogc_icon_show", r8, new Object[]{x.class, IRoom.class});
    L12:
        View r9 = this.f;
        if (r9 == null) goto L15;
        r9.setContentDescription(getTitle().toString());
    L15:
        getIcon().observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
        Disposable r10 = r.f().k(new OgcVSWebActivityBehavior$onLoad$d$1(this));
        if (r10 == null) goto L19;
        ((ArrayList) this.d).add(r10);
        return;
    L19:
        return;
    L10:
        r0 = "more";
        goto L11
    L5:
        if (y3.m(this.e).n(ToolbarButton.VS_ACTIVITY_ONE) == true) goto L7;
        goto L7
    }

    public OgcVSWebActivityBehavior(String r2, k r3, Integer r4, k r5, boolean r6) {
        super(0);
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.d = new ArrayList();
        this.i = LazyKt.lazy(new OgcVSWebActivityBehavior$foldOgcBehavior$2(this));
    }
}
