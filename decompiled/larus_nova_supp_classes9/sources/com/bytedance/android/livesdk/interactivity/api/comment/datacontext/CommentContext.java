package com.bytedance.android.livesdk.interactivity.api.comment.datacontext;

import android.widget.FrameLayout;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import t22.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/datacontext/CommentContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lt22/b;", "commentService$delegate", "Lcom/bytedance/live/datacontext/p;", "getCommentService", "()Lcom/bytedance/live/datacontext/j;", "commentService", "Lcom/bytedance/live/datacontext/n;", "Landroid/widget/FrameLayout;", "interactionRootView$delegate", "getInteractionRootView", "()Lcom/bytedance/live/datacontext/n;", "interactionRootView", "<init>", "()V", "Companion", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "CommentContext";
    private final p commentService$delegate;
    private final p interactionRootView$delegate;

    public static final class a {
        public a() {
        }

        public static CommentContext a(DataCenter r2) {
            Intrinsics.checkNotNullParameter(r2, "dataCenter");
            DataContext r3 = d.d(CommentContext.TAG + r2.hashCode());
            if ((r3 instanceof CommentContext) == true) goto L6;
            r3 = null;
        L6:
            return (CommentContext) r3;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CommentContext.class, "commentService", "getCommentService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(CommentContext.class, "interactionRootView", "getInteractionRootView()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final j<b> getCommentService() {
        return (j) this.commentService$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<FrameLayout> getInteractionRootView() {
        return (n) this.interactionRootView$delegate.a(this, $$delegatedProperties[1]);
    }

    public CommentContext() {
        this.commentService$delegate = ConstantKt.c(this);
        this.interactionRootView$delegate = q.c(this);
    }
}
