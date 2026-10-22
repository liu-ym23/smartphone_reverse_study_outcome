package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R-\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR5\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00120\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u000fR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/InteractionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Luf2/d0;", "liveCore$delegate", "Lcom/bytedance/live/datacontext/p;", "getLiveCore", "()Lcom/bytedance/live/datacontext/j;", "liveCore", "Lcom/bytedance/live/datacontext/m;", "", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/constraint/ILayoutConstraint;", "Lcom/bytedance/android/livesdk/room/placeholder/widget/d;", "roomPlaceHolders$delegate", "getRoomPlaceHolders", "()Lcom/bytedance/live/datacontext/m;", "roomPlaceHolders", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ExtendedToolbarButton;", "Lkotlin/Function0;", "Landroid/view/View;", "externalViewForButton$delegate", "getExternalViewForButton", "externalViewForButton", "Lcom/bytedance/live/datacontext/n;", "Landroid/view/View$OnTouchListener;", "interceptViewTouchListener$delegate", "getInterceptViewTouchListener", "()Lcom/bytedance/live/datacontext/n;", "interceptViewTouchListener", "<init>", "()V", "Companion", "b", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractionContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final String TAG = "interaction_context";
    private final com.bytedance.live.datacontext.p externalViewForButton$delegate;
    private final com.bytedance.live.datacontext.p interceptViewTouchListener$delegate;
    private final com.bytedance.live.datacontext.p liveCore$delegate;
    private final com.bytedance.live.datacontext.p roomPlaceHolders$delegate;

    public static final class a implements Action {
        public final /* synthetic */ InteractionContext a;

        public a(InteractionContext r1) {
            this.a = r1;
        }

        public final void run() {
            ALogger.i("InteractionContext", "clear 回调" + this.a.hashCode());
        }
    }

    public static final class b {
        public b() {
        }

        public static InteractionContext a(DataCenter r2) {
            DataContext r3 = com.bytedance.live.datacontext.d.d(b(r2));
            DataContext r1 = null;
            if ((r3 instanceof InteractionContext) == true) goto L5;
            r3 = null;
        L5:
            InteractionContext r4 = (InteractionContext) r3;
            if (r4 == null) goto L8;
            return r4;
        L8:
            DataContext r5 = com.bytedance.live.datacontext.d.d(InteractionContext.TAG);
            if ((r5 instanceof InteractionContext) == false) goto L13;
            r1 = r5;
        L13:
            return (InteractionContext) r1;
        }

        public static String b(DataCenter r2) {
            StringBuilder r0 = new StringBuilder("interaction_context_");
            if (r2 == null) goto L5;
            Integer r3 = Integer.valueOf(r2.hashCode());
        L6:
            r0.append(r3);
            return r0.toString();
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractionContext.class, "liveCore", "getLiveCore()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionContext.class, "roomPlaceHolders", "getRoomPlaceHolders()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionContext.class, "externalViewForButton", "getExternalViewForButton()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionContext.class, "interceptViewTouchListener", "getInterceptViewTouchListener()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new b();
    }

    public final com.bytedance.live.datacontext.m<Map<ExtendedToolbarButton, Function0<View>>> getExternalViewForButton() {
        return (com.bytedance.live.datacontext.m) this.externalViewForButton$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.n<View.OnTouchListener> getInterceptViewTouchListener() {
        return (com.bytedance.live.datacontext.n) this.interceptViewTouchListener$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.j<uf2.d0> getLiveCore() {
        return (com.bytedance.live.datacontext.j) this.liveCore$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Map<ILayoutConstraint, com.bytedance.android.livesdk.room.placeholder.widget.d>> getRoomPlaceHolders() {
        return (com.bytedance.live.datacontext.m) this.roomPlaceHolders$delegate.a(this, $$delegatedProperties[1]);
    }

    public InteractionContext() {
        this.liveCore$delegate = ConstantKt.c(this);
        this.roomPlaceHolders$delegate = com.bytedance.live.datacontext.q.d(this, MapsKt.emptyMap());
        this.externalViewForButton$delegate = com.bytedance.live.datacontext.q.d(this, MapsKt.emptyMap());
        this.interceptViewTouchListener$delegate = com.bytedance.live.datacontext.q.c(this);
        getOnCleared().subscribe(new a(this));
    }
}
