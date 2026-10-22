package com.bytedance.android.livesdk.chatroom.viewmodel;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/UserRoomActionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/k;", "", "onSlide$delegate", "Lcom/bytedance/live/datacontext/p;", "getOnSlide", "()Lcom/bytedance/live/datacontext/k;", "onSlide", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "onEnterRoom$delegate", "getOnEnterRoom", "onEnterRoom", "", "onDrawerOpen$delegate", "getOnDrawerOpen", "onDrawerOpen", "onLeave$delegate", "getOnLeave", "onLeave", "<init>", "()V", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserRoomActionContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "UserRoomActionContext";
    private final p onDrawerOpen$delegate;
    private final p onEnterRoom$delegate;
    private final p onLeave$delegate;
    private final p onSlide$delegate;

    public static final class a {
        public a() {
        }

        public static UserRoomActionContext a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(UserRoomActionContext.TAG);
            if ((r0 instanceof UserRoomActionContext) == true) goto L6;
            r0 = null;
        L6:
            return (UserRoomActionContext) r0;
        }

        public static void b(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            if (a() != null) goto L6;
            Intrinsics.checkNotNullParameter(r2, "owner");
            Intrinsics.checkNotNullParameter(r2, "owner");
            ViewModelProvider r3 = ViewModelProviders.of(r2);
            Intrinsics.checkNotNullParameter(UserRoomActionContext.class, "cls");
            DataContext r4 = r3.get(UserRoomActionContext.class);
            com.bytedance.live.datacontext.d.c(r4, UserRoomActionContext.TAG);
            UserRoomActionContext r5 = (UserRoomActionContext) r4;
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UserRoomActionContext.class, "onSlide", "getOnSlide()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(UserRoomActionContext.class, "onEnterRoom", "getOnEnterRoom()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(UserRoomActionContext.class, "onDrawerOpen", "getOnDrawerOpen()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(UserRoomActionContext.class, "onLeave", "getOnLeave()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.k<Boolean> getOnDrawerOpen() {
        return (com.bytedance.live.datacontext.k) this.onDrawerOpen$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.k<Room> getOnEnterRoom() {
        return (com.bytedance.live.datacontext.k) this.onEnterRoom$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getOnLeave() {
        return (com.bytedance.live.datacontext.k) this.onLeave$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.k<Object> getOnSlide() {
        return (com.bytedance.live.datacontext.k) this.onSlide$delegate.a(this, $$delegatedProperties[0]);
    }

    public UserRoomActionContext() {
        this.onSlide$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onEnterRoom$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onDrawerOpen$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onLeave$delegate = com.bytedance.live.datacontext.e.b(this);
    }
}
