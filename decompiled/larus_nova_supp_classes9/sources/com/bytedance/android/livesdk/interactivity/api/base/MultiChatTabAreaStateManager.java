package com.bytedance.android.livesdk.interactivity.api.base;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k;
import com.bytedance.android.livesdk.interactivity.api.f;
import com.bytedance.android.livesdk.interactivity.api.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.j;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/base/MultiChatTabAreaStateManager;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/a;", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageType;", BuildConfig.FLAVOR, "findFirstPage", "Lcom/bytedance/android/livesdk/interactivity/api/base/d;", "newState", BuildConfig.FLAVOR, "changeState", "pageType", "pageId", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageChangeSource;", "source", "tryChangePage", "resetPage", "tryAutoPositionToPage", "Lcom/bytedance/live/datacontext/m;", "state$delegate", "Lcom/bytedance/live/datacontext/p;", "getState", "()Lcom/bytedance/live/datacontext/m;", "state", "Lio/reactivex/subjects/PublishSubject;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/j;", "redDotStatus", "Lio/reactivex/subjects/PublishSubject;", "getRedDotStatus", "()Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Ls22/e;", "getChatChannelManager", "()Ls22/e;", "chatChannelManager", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;)V", "Companion", "b", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiChatTabAreaStateManager extends DataContext implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    private static final long EMPTY_PAGE_ID = 0;
    private static final d EMPTY_STATE = null;
    private final CompositeDisposable compositeDisposable;
    private final PublishSubject<j> redDotStatus;
    private final RoomContext roomContext;
    private final p state$delegate;

    public static final class a implements Action {
        public final /* synthetic */ MultiChatTabAreaStateManager a;

        public a(MultiChatTabAreaStateManager r1) {
            this.a = r1;
        }

        public final void run() {
            MultiChatTabAreaStateManager.access$getCompositeDisposable$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiChatTabAreaStateManager.class, "state", "getState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new b();
        EMPTY_STATE = new d(PublicScreenAreaPageType.Empty, 0, PublicScreenAreaPageChangeSource.Init);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public m<d> getState() {
        return (m) this.state$delegate.a(this, $$delegatedProperties[0]);
    }

    private final s22.e getChatChannelManager() {
        f r0 = g.a(this.roomContext);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<s22.e> r1 = r0.getChatChannelManager();
        if (r1 == null) goto L7;
        return (s22.e) r1.getValue();
    L7:
        return null;
    }

    private final Pair<PublicScreenAreaPageType, Long> findFirstPage() {
        s22.e r0 = getChatChannelManager();
        if (r0 == null) goto L13;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r1 = r0.getCurrentChannel();
        if (r1 == null) goto L13;
        sh6.b r2 = (sh6.b) r1.getValue();
        if (r2 == null) goto L13;
        s22.a r3 = (s22.a) sh6.c.b(r2);
        if (r3 == null) goto L13;
        return new Pair(PublicScreenAreaPageType.ChatChannel, Long.valueOf(r3.getChannelId()));
    L13:
        return new Pair(PublicScreenAreaPageType.Empty, 0L);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public void tryAutoPositionToPage() {
        PublicScreenAreaPageChangeSource r0 = ((d) getState().getValue()).c;
        PublicScreenAreaPageChangeSource r1 = PublicScreenAreaPageChangeSource.Init;
        if (r0 == r1) goto L5;
        return;
    L5:
        Pair<PublicScreenAreaPageType, Long> r2 = findFirstPage();
        PublicScreenAreaPageType r3 = (PublicScreenAreaPageType) r2.getFirst();
        long r4 = ((Number) r2.getSecond()).longValue();
        PublicScreenAreaPageType r5 = PublicScreenAreaPageType.ChatChannel;
        if (r3 != r5) goto L13;
        s22.e r6 = getChatChannelManager();
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.getChannel(r4) == null) goto L15;
        tryChangePage(r5, r4, r1);
        return;
    L15:
        return;
    }

    public static final /* synthetic */ d access$getEMPTY_STATE$cp() {
        return EMPTY_STATE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public PublishSubject<j> getRedDotStatus() {
        return this.redDotStatus;
    }

    public MultiChatTabAreaStateManager(RoomContext r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.roomContext = r3;
        this.state$delegate = q.d(this, EMPTY_STATE);
        this.redDotStatus = PublishSubject.create();
        CompositeDisposable r4 = new CompositeDisposable();
        this.compositeDisposable = r4;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r4);
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(MultiChatTabAreaStateManager r0) {
        return r0.compositeDisposable;
    }

    private final void changeState(d r3) {
        k.b("multitab pager state change from " + ((d) getState().getValue()) + " to " + r3);
        getState().setValue(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public void resetPage(PublicScreenAreaPageChangeSource r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        changeState(new d(PublicScreenAreaPageType.Empty, 0, r5));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public void tryChangePage(PublicScreenAreaPageType r3, long r4, PublicScreenAreaPageChangeSource r6) {
        Intrinsics.checkNotNullParameter(r3, "pageType");
        Intrinsics.checkNotNullParameter(r6, "source");
        if (r3 != ((d) getState().getValue()).a) goto L6;
        return;
    L6:
        if (c.a[r3.ordinal()] == 1) goto L8;
        changeState(new d(PublicScreenAreaPageType.Empty, 0, r6));
        return;
    L8:
        s22.e r0 = getChatChannelManager();
        if (r0 == null) goto L11;
        s22.a r1 = r0.getChannel(r4);
    L12:
        if (r1 == null) goto L16;
        changeState(new d(r3, r4, r6));
        return;
    L16:
        return;
    L11:
        r1 = null;
        goto L12
    }
}
