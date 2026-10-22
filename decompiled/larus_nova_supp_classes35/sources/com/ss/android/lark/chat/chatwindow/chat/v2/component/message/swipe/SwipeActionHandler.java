package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SwipeActionHandler {
    public final m2b.a a;
    public final jdb.g b;
    public final e<y6b.c<?>> c;
    public final c<y6b.c<?>> d;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.a e;
    public final b.a f;
    public CapturedItemInfo g;
    public float h;
    public final g i;
    public RecyclerView j;
    public int k;
    public final float l;
    public final float m;
    public final float n;
    public final SwipeActionHandler$onItemTouchListener$1 o;
    public SwipeActionItemDecoration p;
    public final SwipeActionHandler$childAttachStateChangeListener$1 q;

    public static final class CapturedItemInfo {
        public static final /* synthetic */ int i = 0;
        public final RecyclerView a;
        public final RecyclerView.ViewHolder b;
        public final View c;
        public final b d;
        public ViewTreeObserver.OnGlobalLayoutListener e;
        public final int[] f;
        public final int[] g;
        public final Lazy h;

        public static final class a {
        }

        static {
        }

        public final float a() {
            this.c.getLocationInWindow(this.f);
            this.b.itemView.getLocationInWindow(this.g);
            return (this.f[1] - this.g[1]) + (this.c.getHeight() / 2);
        }

        public CapturedItemInfo(RecyclerView r2, RecyclerView.ViewHolder r3, View r4, b r5) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            Intrinsics.checkNotNullParameter(r4, "anchorView");
            Intrinsics.checkNotNullParameter(r5, Keys.API_PARAM_KEY_ACTION);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.f = new int[2];
            this.g = new int[2];
            this.h = LazyKt.lazy(new SwipeActionHandler$CapturedItemInfo$iconDrawable$2(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public static final void a(SwipeActionHandler r3) {
        SwipeActionItemDecoration r0 = r3.p;
        if (r0 == null) goto L5;
        r0.d = null;
    L5:
        CapturedItemInfo r1 = r3.g;
        if (r1 == null) goto L8;
        r1.b.itemView.getViewTreeObserver().removeOnGlobalLayoutListener(r1.e);
    L8:
        r3.g = null;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionHandler$onItemTouchListener$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionHandler$childAttachStateChangeListener$1] */
    public SwipeActionHandler(m2b.a r2, jdb.g r3, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.c r4, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.e r5, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.f r6, f r7) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r4, "handlerDependency");
        Intrinsics.checkNotNullParameter(r5, "messageItemProvider");
        Intrinsics.checkNotNullParameter(r6, "messageListModeProvider");
        Intrinsics.checkNotNullParameter(r7, "actionProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.i = new g(this);
        this.l = UIHelper.dp2px(60.0f);
        this.m = UIHelper.dp2px(60.0f);
        this.n = UIHelper.dp2px(46.0f);
        this.o = new SwipeActionHandler$onItemTouchListener$1(this);
        this.q = new SwipeActionHandler$childAttachStateChangeListener$1(this);
    }
}
