package com.ss.android.lark.flow.feed.sidebar.human;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.sidebar.view.FeedSidebarCommonViewHolder;
import deb.d;
import iza.e;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSidebarHumanFeedRenderDelegate {
    public static final /* synthetic */ int l = 0;
    public final Fragment a;
    public final e b;
    public final d c;
    public final Function0<l> d;
    public final Function0<s> e;
    public final WeakHashMap<View, b> f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b {
        public final FeedSidebarCommonViewHolder a;
        public final FeedCard.Type b;
        public final AppFeedCardType c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "RenderState(holder=" + this.a + ", feedType=" + this.b + ", bizType=" + this.c + ')';
        }

        public b(FeedSidebarCommonViewHolder r2, FeedCard.Type r3, AppFeedCardType r4) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            Intrinsics.checkNotNullParameter(r3, "feedType");
            Intrinsics.checkNotNullParameter(r4, "bizType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements UIFeedCard.DataObserver {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final /* synthetic */ void onChanged(String r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public OfficeSidebarHumanFeedRenderDelegate(Fragment r2, e r3, d r4, Function0<? extends l> r5, Function0<? extends s> r6) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "rustClientProvider");
        Intrinsics.checkNotNullParameter(r6, "sidebarViewModelProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new WeakHashMap();
        this.g = LazyKt.lazy(new OfficeSidebarHumanFeedRenderDelegate$feedCardContext$2(this));
        this.h = LazyKt.lazy(OfficeSidebarHumanFeedRenderDelegate$paramsFactory$2.INSTANCE);
        this.i = LazyKt.lazy(new OfficeSidebarHumanFeedRenderDelegate$feedActionManager$2(this));
        this.j = LazyKt.lazy(new OfficeSidebarHumanFeedRenderDelegate$itemContainer$2(this));
        this.k = LazyKt.lazy(OfficeSidebarHumanFeedRenderDelegate$feedCardWrapper$2.INSTANCE);
    }
}
