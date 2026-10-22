package com.bytedance.android.livesdk.interactivity.api.base;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.j;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/base/PublicScreenAreaPageStateManager;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/a;", "Lcom/bytedance/android/livesdk/interactivity/api/base/d;", "newState", BuildConfig.FLAVOR, "changeState", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageType;", "pageType", BuildConfig.FLAVOR, "pageId", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageChangeSource;", "source", "tryChangePage", "resetPage", "Lcom/bytedance/live/datacontext/m;", "state$delegate", "Lcom/bytedance/live/datacontext/p;", "getState", "()Lcom/bytedance/live/datacontext/m;", "state", "Lio/reactivex/subjects/PublishSubject;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/j;", "Lcom/bytedance/revenue/platform/api/core/rx/PublishSubject;", "redDotStatus", "Lio/reactivex/subjects/PublishSubject;", "getRedDotStatus", "()Lio/reactivex/subjects/PublishSubject;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;)V", "Companion", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenAreaPageStateManager extends DataContext implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static final d PUBLIC_SCREEN_DEFAULT_STATE = null;
    private static final long PUBLIC_SCREEN_PAGE_ID = 0;
    private final PublishSubject<j> redDotStatus;
    private final RoomContext roomContext;
    private final p state$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PublicScreenAreaPageStateManager.class, "state", "getState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
        PUBLIC_SCREEN_DEFAULT_STATE = new d(PublicScreenAreaPageType.PublicScreen, 0, PublicScreenAreaPageChangeSource.Init);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public m<d> getState() {
        return (m) this.state$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public void tryAutoPositionToPage() {
    }

    public static final /* synthetic */ d access$getPUBLIC_SCREEN_DEFAULT_STATE$cp() {
        return PUBLIC_SCREEN_DEFAULT_STATE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public PublishSubject<j> getRedDotStatus() {
        return this.redDotStatus;
    }

    public PublicScreenAreaPageStateManager(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.roomContext = r2;
        this.state$delegate = q.d(this, PUBLIC_SCREEN_DEFAULT_STATE);
        this.redDotStatus = PublishSubject.create();
    }

    private final void changeState(d r3) {
        k.b("public screen pager state change from " + ((d) getState().getValue()) + " to " + r3);
        getState().setValue(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public void resetPage(PublicScreenAreaPageChangeSource r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        changeState(new d(PublicScreenAreaPageType.PublicScreen, 0, r5));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a
    public void tryChangePage(PublicScreenAreaPageType r5, long r6, PublicScreenAreaPageChangeSource r8) {
        Intrinsics.checkNotNullParameter(r5, "pageType");
        Intrinsics.checkNotNullParameter(r8, "source");
        if (r5 == ((d) getState().getValue()).a) goto L5;
    L7:
        int r0 = e.a[r5.ordinal()];
        if (r0 != 1) goto L10;
        changeState(new d(r5, 0, r8));
        return;
    L10:
        if (r0 != 2) goto L12;
        changeState(new d(r5, r6, r8));
        return;
    L12:
        if (r0 == 3) goto L14;
        changeState(new d(PublicScreenAreaPageType.PublicScreen, 0, r8));
        return;
    L14:
        changeState(new d(r5, r6, r8));
        return;
    L5:
        if (r6 != ((d) getState().getValue()).b) goto L7;
    }
}
