package com.ss.android.lark.feed.shared.page.click_hint;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jeb.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yua.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedClickHintLogic {
    public final LarkFeedInBoxListAdapter a;
    public final FragmentActivity b;
    public final Lazy c;
    public final c d;
    public final b e;
    public final Function1<ForsetiMode, Unit> f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FeedClickHintLogic a;

        public b(FeedClickHintLogic r1) {
            this.a = r1;
        }

        public final void a() {
            tua.b r0 = (tua.b) this.a.c.getValue();
            if (r0 == null) goto L7;
            d r1 = r0.q();
            if (r1 == null) goto L7;
            List r2 = r1.d();
        L8:
            if (r2 != null) goto L10;
            r2 = CollectionsKt.emptyList();
        L10:
            Collection r3 = r2;
            boolean r4 = r3 instanceof Collection;
            boolean r5 = false;
            if (r4 == true) goto L13;
        L15:
            Iterator r6 = r3.iterator();
            if (r6.hasNext() == false) goto L18;
            Fragment r7 = (Fragment) r6.next();
            heb.a.a.getFeedDependency().getClass();
            Intrinsics.checkNotNullParameter(r7, "fragment");
            boolean r8 = true;
        L19:
            if (r4 == true) goto L21;
        L23:
            Iterator r9 = r3.iterator();
        L25:
            if (r9.hasNext() == false) goto L29;
            if ((((Fragment) r9.next()) instanceof ForsetiPlaceHolderFragment) == false) goto L25;
            boolean r10 = true;
        L30:
            int r11 = r2.size();
            if (r11 != 1) goto L33;
            r5 = r8;
        L39:
            if (r5 == false) goto L43;
            LarkFeedInBoxListAdapter r12 = this.a.a;
            if (r12 == null) goto L50;
            jeb.b.a().Xa();
            r12.notifyDataSetChanged();
            return;
        L50:
            return;
        L43:
            LarkFeedInBoxListAdapter r13 = this.a.a;
            if (r13 == null) goto L52;
            r13.H2(jeb.b.a().q3());
            return;
        L52:
            return;
        L33:
            if (r11 != 2) goto L39;
            if (r8 == false) goto L39;
            if (r10 == false) goto L39;
            r5 = true;
        L29:
            r10 = false;
            goto L30
        L21:
            if (r3.isEmpty() == false) goto L23;
        L18:
            r8 = false;
            goto L19
        L13:
            if (r3.isEmpty() == false) goto L15;
        L7:
            r2 = null;
            goto L8
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

    public static final class c implements e {
        public final /* synthetic */ FeedClickHintLogic a;

        public c(FeedClickHintLogic r1) {
            this.a = r1;
        }

        @Override // jeb.e
        public final void a(String r1) {
            LarkFeedInBoxListAdapter r2 = this.a.a;
            if (r2 == null) goto L6;
            r2.notifyDataSetChanged();
            return;
        }
    }

    static {
    }

    public FeedClickHintLogic(LarkFeedInBoxListAdapter r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
        this.c = LazyKt.lazy(new FeedClickHintLogic$chainManager$2(this));
        this.d = new c(this);
        this.e = new b(this);
        this.f = new FeedClickHintLogic$modeChangeCallback$1(this);
    }
}
