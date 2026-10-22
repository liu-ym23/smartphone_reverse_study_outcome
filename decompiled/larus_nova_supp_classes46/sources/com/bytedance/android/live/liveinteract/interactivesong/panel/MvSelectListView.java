package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectListView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectListView extends FrameLayout {
    public IMVTab a;
    public final LinearLayout b;
    public final FrameLayout c;
    public final com.bytedance.android.livesdk.ktvapi.model.mv.e<i> d;
    public com.bytedance.android.livesdk.ktvapi.model.mv.i<i> e;
    public MvSelectViewModel f;

    public static final class a implements com.bytedance.android.livesdk.ktvapi.model.mv.i<i> {
        public final /* synthetic */ MvSelectListView a;

        public a(MvSelectListView r1) {
            this.a = r1;
        }

        public final boolean G70(int r1, Object r2) {
            Intrinsics.checkNotNullParameter((i) r2, "info");
            return false;
        }

        public final void G80(int r2, Object r3, IMvPreviewViewHolder r4, Function0 r5) {
            i r6 = (i) r3;
            Intrinsics.checkNotNullParameter(r6, "panel");
            Intrinsics.checkNotNullParameter(r4, "vh");
            Intrinsics.checkNotNullParameter(r5, "unSelectedCb");
            com.bytedance.android.livesdk.ktvapi.model.mv.i<i> r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.G80(r2, r6, r4, r5);
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MvSelectListView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ List c;

        public b(MvSelectListView r1, boolean r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            MvSelectViewModel r0 = this.a.f;
            RecyclerView r1 = null;
            if (r0 == null) goto L5;
            i r2 = r0.getLastMvData();
        L6:
            if (r2 != null) goto L8;
            return;
        L8:
            if (this.b == false) goto L29;
            List r3 = this.c;
            MvSelectViewModel r4 = this.a.f;
            if (r4 == null) goto L12;
            i r5 = r4.getLastMvData();
        L13:
            int r6 = CollectionsKt.indexOf(r3, r5);
            com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r7 = this.a.d;
            if (r7 == null) goto L16;
            RecyclerView r8 = r7.c();
        L18:
            if ((r8 instanceof RecyclerView) == false) goto L21;
            r1 = r8;
        L21:
            if (r1 == null) goto L30;
            RecyclerView.ViewHolder r9 = r1.findViewHolderForAdapterPosition(r6);
            if (r9 == null) goto L31;
            View r10 = r9.itemView;
            if (r10 == null) goto L32;
            r10.performClick();
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L16:
            r8 = null;
            goto L18
        L12:
            r5 = null;
            goto L13
        L29:
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0 r2 = this.a;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public MvSelectListView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MvSelectListView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public MvSelectListView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = vh7.f.c(IMVTab.class);
        com.bytedance.android.live.liveinteract.interactivesong.panel.c r6 = new com.bytedance.android.live.liveinteract.interactivesong.panel.c();
        LayoutInflater.from(r3).inflate(2131567026, this);
        this.b = (LinearLayout) findViewById(2131371607);
        this.c = (FrameLayout) findViewById(2131364805);
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r7 = k.n(IKtvService.class).createMvPreviewList(r3, r6);
        this.d = r7;
        RecyclerView r8 = null;
        if (r7 == null) goto L7;
        RecyclerView r0 = r7.c();
        if (r0 == null) goto L7;
        ViewParent r1 = r0.getParent();
    L8:
        if (r1 == null) goto L23;
        if (r7 == null) goto L13;
        RecyclerView r2 = r7.c();
        if (r2 == null) goto L13;
        ViewParent r9 = r2.getParent();
    L15:
        if ((r9 instanceof ViewGroup) == true) goto L17;
        r9 = null;
    L17:
        ViewGroup r10 = (ViewGroup) r9;
        if (r10 == null) goto L23;
        if (r7 == null) goto L21;
        RecyclerView r11 = r7.c();
    L22:
        r10.removeView(r11);
        goto L23
    L21:
        r11 = null;
    L13:
        r9 = null;
    L23:
        if (r7 == null) goto L25;
        r7.d(r6);
    L25:
        if (r7 == null) goto L27;
        r7.a(new a(this));
    L27:
        if (r7 == null) goto L29;
        RecyclerView r12 = r7.c();
    L31:
        if ((r12 instanceof RecyclerView) == true) goto L33;
        r12 = null;
    L33:
        if (r12 == null) goto L35;
        r12.addOnScrollListener(new AnonymousClass2());
    L35:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -1);
        if (r7 == null) goto L38;
        r8 = r7.c();
    L38:
        addView(r8, r13);
        return;
    L29:
        r12 = null;
    L7:
        r1 = null;
        goto L8
    }

    public /* synthetic */ MvSelectListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(List<i> r2, String r3, boolean r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "mvList");
        Intrinsics.checkNotNullParameter(r3, "tabName");
        if ((!Intrinsics.areEqual(this.a.getName(), r3)) == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r6 = this.d;
        if (r6 == null) goto L8;
        r6.b(r2);
    L8:
        post(new b(this, r4, r2));
        if (r2.isEmpty() == false) goto L18;
        LinearLayout r7 = this.b;
        if (r7 == null) goto L13;
        r7.setVisibility(0);
    L13:
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r8 = this.d;
        if (r8 == null) goto L26;
        RecyclerView r9 = r8.c();
        if (r9 == null) goto L26;
        r9.setVisibility(8);
    L26:
        FrameLayout r10 = this.c;
        if (r10 == null) goto L30;
        r10.setOnClickListener(new c(r5));
        return;
    L30:
        return;
    L18:
        LinearLayout r11 = this.b;
        if (r11 == null) goto L21;
        r11.setVisibility(8);
    L21:
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r12 = this.d;
        if (r12 == null) goto L26;
        RecyclerView r13 = r12.c();
        if (r13 == null) goto L26;
        r13.setVisibility(0);
        goto L26
    }
}
