package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.LarkFeedListViewObjectFieldType;
import com.bytedance.lark.lark_biz_feed_android.LarkFeedListViewObjectLiveQueryFieldType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.g0;
import com.bytedance.lark.lark_biz_feed_android.o;
import com.bytedance.lark.lark_biz_feed_android.w0;
import com.bytedance.lark.molten_livequery_wrapper.h;
import com.bytedance.lark.pb.feed.v1.LarkFeedListItem;
import com.bytedance.lark.pb.feed.v1.LarkFeedListKeyChange;
import com.bytedance.lark.view_flow_wrapper.i;
import com.bytedance.lark.view_flow_wrapper.l;
import com.bytedance.lark.view_flow_wrapper.q;
import com.bytedance.lark.view_flow_wrapper.v;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface ILarkFeedListViewFlow extends i {
    public static final Companion w1 = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;

        static {
            a = new Companion();
        }

        public Companion() {
        }

        public static a a(final g0 r2, final v r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "strategy");
            return new a(new ILarkFeedListViewFlow$Companion$of$1(r3, r2));
        }
    }

    public static final class a extends com.bytedance.lark.lark_biz_feed_android_wrapper.c<ILarkFeedListViewFlow> {
        public a(Function0<? extends ILarkFeedListViewFlow> r2) {
            Intrinsics.checkNotNullParameter(r2, "viewFlowProvider");
            super(r2);
        }
    }

    public interface b {
    }

    public static abstract class c<Key, Inner> extends q<Key, Inner> {

        public static final class a extends e<Boolean> {
            public static final a c = null;

            static {
                c = new a();
            }

            public a() {
                super(LarkFeedListViewObjectFieldType.CanLoadMore);
            }
        }

        public static final class b extends C0374c<LarkFeedListItem, LarkFeedListKeyChange> {
            public static final b e = null;

            static {
                e = new b();
            }

            public b() {
                super(new l(LarkFeedListViewObjectLiveQueryFieldType.FeedList, null), null, null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow$c$c, reason: collision with other inner class name */
        public static class C0374c<Item, KeyChange> extends c<l<LarkFeedListViewObjectLiveQueryFieldType>, h<Item, KeyChange>> {
            public final Function3<Integer, Function0<? extends Object>, Item, Item> c;
            public final Function0<com.bytedance.lark.molten_livequery_wrapper.d> d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0374c(l<LarkFeedListViewObjectLiveQueryFieldType> r4, Function3<? super Integer, ? super Function0<? extends Object>, ? super Item, ? extends Item> r5, Function0<? extends com.bytedance.lark.molten_livequery_wrapper.d> r6) {
                Intrinsics.checkNotNullParameter(r4, "key");
                super(r4, new h(CollectionsKt.emptyList(), null, null));
                this.c = r5;
                this.d = r6;
            }
        }

        public static final class d<Inner> extends e<Inner> {
        }

        public static abstract class e<Inner> extends c<LarkFeedListViewObjectFieldType, Inner> {
            public e(LarkFeedListViewObjectFieldType r2) {
                super(r2, null);
            }
        }

        public static final class f extends e<w0> {
            public static final f c = null;

            static {
                c = new f();
            }

            public f() {
                super(LarkFeedListViewObjectFieldType.ToastStatus);
            }
        }

        public c(Object r1, Object r2) {
            super(r1, r2);
        }
    }

    static {
        w1 = Companion.a;
    }

    /* JADX INFO: renamed from: action-vFDjHp0, reason: not valid java name */
    Object mo1707actionvFDjHp0(o r1, Continuation<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>> r2);

    <Item, KeyChange> i1<h<Item, KeyChange>> subscribe(c.C0374c<Item, KeyChange> r1);

    <Inner> i1<Inner> subscribe(c.e<Inner> r1);
}
