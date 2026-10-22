package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004RA\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectTabView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getTabViewSelectedTab", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVTab;", "list", "", "setDataAndNotify", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tab", "d", "Lkotlin/jvm/functions/Function1;", "getTabSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "tabSelectedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TabViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectTabView extends RecyclerView {
    public final List<IMVTab> a;
    public String b;
    public final MvSelectTabView$tabAdapter$1 c;
    public Function1<? super IMVTab, Unit> d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectTabView$TabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class TabViewHolder extends RecyclerView.ViewHolder {
        public IMVTab a;
        public final TextView b;
        public final View c;
        public final /* synthetic */ MvSelectTabView d;

        public static final class a implements Runnable {
            public final /* synthetic */ TabViewHolder a;
            public final /* synthetic */ View b;

            public a(TabViewHolder r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(this.b.getWidth(), o.a(32.0f));     // Catch: Throwable -> L6
                r0.gravity = 17;     // Catch: Throwable -> L6
                View r1 = this.a.c;     // Catch: Throwable -> L6
                if (r1 == null) goto L9;
                r1.setLayoutParams(r0);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ TabViewHolder a;

            public b(TabViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                Function1<IMVTab, Unit> r3 = this.a.d.getTabSelectedListener();
                if (r3 == null) goto L6;
                Unit r4 = (Unit) r3.invoke(this.a.a);
                return;
            }
        }

        public TabViewHolder(MvSelectTabView r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "rootView");
            this.d = r2;
            super(r3);
            this.b = (TextView) r3.findViewById(2131388041);
            this.c = r3.findViewById(2131388006);
            r3.post(new a(this, r3));
            r3.setOnClickListener(new b(this));
        }
    }

    public MvSelectTabView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MvSelectTabView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final String getTabViewSelectedTab() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final Function1<IMVTab, Unit> getTabSelectedListener() {
        return this.d;
    }

    public final void r(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tabName");
        if (((ArrayList) this.a).size() != 0) goto L5;
        return;
    L5:
        int r0 = ((ArrayList) this.a).size();
        int r1 = -1;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (Intrinsics.areEqual(((IMVTab) ListProtector.get(this.a, r2)).getName(), r5) == false) goto L10;
        r1 = r2;
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        int r3 = ((ArrayList) this.a).size();
        if (r1 < 0) goto L16;
        if (r3 <= r1) goto L16;
        this.b = r5;
        scrollToPosition(r1);
    L16:
        notifyDataSetChanged();
    }

    public final void setDataAndNotify(List<? extends IMVTab> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        ((ArrayList) this.a).clear();
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r2);
        notifyDataSetChanged();
    }

    public final void setTabSelectedListener(Function1<? super IMVTab, Unit> r1) {
        this.d = r1;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.bytedance.android.live.liveinteract.interactivesong.panel.MvSelectTabView$tabAdapter$1] */
    public MvSelectTabView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        ?? r5 = new MvSelectTabView$tabAdapter$1(this);
        this.c = r5;
        setLayoutManager(new SSLinearLayoutManager(r2, 0));
        setAdapter(r5);
        setNestedScrollingEnabled(false);
        addItemDecoration(new AnonymousClass1());
    }

    public /* synthetic */ MvSelectTabView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
