package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.s;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data.PSHighlightCommonCompLauncher;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0007\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\t\u0010!R\u001b\u0010&\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010%R\u001b\u0010\r\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u0001038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/PSHighlightContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/k;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/j;", "container", BuildConfig.FLAVOR, "bindContainer", "getContainer", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/h;", "getLaunchManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/m$c;", "getTriggerMapper", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/l;", "stateCenter", BuildConfig.BUILD_TYPE, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/AbsPSHighlightComp;", "comp", "show", "dismiss", "Lcom/bytedance/live/datacontext/n;", "container$delegate", "Lcom/bytedance/live/datacontext/p;", "()Lcom/bytedance/live/datacontext/n;", BuildConfig.FLAVOR, "hasComponentShow", "Z", "getHasComponentShow", "()Z", "setHasComponentShow", "(Z)V", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/b;", "launchManager$delegate", "Lkotlin/Lazy;", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/b;", "launchManager", "mapper$delegate", "getMapper", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/m$c;", "mapper", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/s;", "stateCenter$delegate", "getStateCenter", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/s;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSHighlightContext extends DataContext implements k {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p container$delegate;
    private Context context;
    private final DataCenter dataCenter;
    private boolean hasComponentShow;
    private final Lazy launchManager$delegate;
    private final Lazy mapper$delegate;
    private final MiddlewareRoomContext roomContext;
    private final Lazy stateCenter$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PSHighlightContext.class, "container", "getContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    private final n<j> getContainer() {
        return (n) this.container$delegate.a(this, $$delegatedProperties[0]);
    }

    private final b getLaunchManager() {
        return (b) this.launchManager$delegate.getValue();
    }

    private final m.c getMapper() {
        return (m.c) this.mapper$delegate.getValue();
    }

    private final s getStateCenter() {
        return (s) this.stateCenter$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    /* JADX INFO: renamed from: getContainer, reason: collision with other method in class */
    public j mo773getContainer() {
        return (j) getContainer().getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    /* JADX INFO: renamed from: getLaunchManager, reason: collision with other method in class */
    public h mo774getLaunchManager() {
        return getLaunchManager();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public m.c getTriggerMapper() {
        return getMapper();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void release() {
        b r0 = getLaunchManager();
        ArrayList r1 = (ArrayList) r0.a;
        if ((!r1.isEmpty()) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L15;
        List r2 = CollectionsKt.toList(r1);
        if (r2 == null) goto L15;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        i r4 = (i) r3.next();
        Intrinsics.checkNotNullParameter(r4, "launcher");
        if (((ArrayList) r0.a).remove(r4) == false) goto L11;
        r4.onUnload();
    L15:
        ((ArrayList) getMapper().a).clear();
        getStateCenter().getClass();
        getContainer().setValue(null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public l stateCenter() {
        return getStateCenter();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public boolean getHasComponentShow() {
        return this.hasComponentShow;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    public static final /* synthetic */ Context access$getContext$p(PSHighlightContext r0) {
        return r0.context;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void bindContainer(j r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        getContainer().setValue(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void dismiss(AbsPSHighlightComp r2) {
        Intrinsics.checkNotNullParameter(r2, "comp");
        j r0 = (j) getContainer().getValue();
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        r2.h(IPSHighlightCompLifecycle$State.Destroyed);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void setHasComponentShow(boolean r1) {
        this.hasComponentShow = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k
    public void show(AbsPSHighlightComp r3) {
        Intrinsics.checkNotNullParameter(r3, "comp");
        IPSHighlightCompLifecycle$State r0 = (IPSHighlightCompLifecycle$State) r3.b.a;
        IPSHighlightCompLifecycle$State r1 = IPSHighlightCompLifecycle$State.Created;
        if (r0.isAtLeast(r1) == true) goto L5;
        r3.h(r1);
    L5:
        r3.h(IPSHighlightCompLifecycle$State.Started);
        j r2 = (j) getContainer().getValue();
        if (r2 == null) goto L9;
        r2.b(r3);
        return;
    }

    public static final /* synthetic */ void access$setContext$p(PSHighlightContext r0, Context r1) {
        r0.context = r1;
    }

    public PSHighlightContext(Context r2, DataCenter r3, MiddlewareRoomContext r4) {
        this.context = r2;
        this.dataCenter = r3;
        this.roomContext = r4;
        this.container$delegate = q.c(this);
        this.launchManager$delegate = LazyKt.lazy(new PSHighlightContext$launchManager$2(this));
        this.mapper$delegate = LazyKt.lazy(PSHighlightContext$mapper$2.INSTANCE);
        this.stateCenter$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        b r5 = getLaunchManager();
        r5.getClass();
        PSHighlightCommonCompLauncher r6 = new PSHighlightCommonCompLauncher();
        Intrinsics.checkNotNullParameter(r6, "launcher");
        if (((ArrayList) r5.a).contains(r6) == true) goto L5;
        ((ArrayList) r5.a).add(r6);
        r6.f(r5.b, r5.c);
    L5:
        Disposables.fromAction(new a(r5, r6));
        m.c r7 = getMapper();
        r7.getClass();
        e r8 = new e();
        Intrinsics.checkNotNullParameter(r8, "factory");
        if (((ArrayList) r7.a).contains(r8) == true) goto L9;
        ((ArrayList) r7.a).add(r8);
        return;
    }
}
