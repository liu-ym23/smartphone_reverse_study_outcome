package com.bytedance.android.livesdk.interactivity.medialink.dialog.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import gy.c;
import hy.e;
import hy.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/dialog/vm/MediaMultiAnchorStartViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "onCleared", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/user/User;", "getOnLineList", BuildConfig.FLAVOR, "uid", BuildConfig.FLAVOR, "isOrganizer", "loadData", "isOverLimit", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Lgy/f;", "rtcManager", "Lgy/f;", "Lhy/e;", "anchorInfoCenter", "Lhy/e;", "Lvlc/d;", "messageManager", "Lvlc/d;", "Landroidx/lifecycle/MutableLiveData;", "_finishState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "finishState", "Landroidx/lifecycle/LiveData;", "getFinishState", "()Landroidx/lifecycle/LiveData;", "_onlineStateNotify", "onlineStateNotify", "getOnlineStateNotify", "Lgy/b;", "rtcListener$delegate", "Lkotlin/Lazy;", "getRtcListener", "()Lgy/b;", "rtcListener", "Lhy/f$a;", "anchorLinkCallback", "Lhy/f$a;", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorStartViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "MediaMultiAnchorStartViewModel";
    private final MutableLiveData<Boolean> _finishState;
    private final MutableLiveData<Boolean> _onlineStateNotify;
    private final e anchorInfoCenter;
    private final f.a anchorLinkCallback;
    private final LiveData<Boolean> finishState;
    private final d messageManager;
    private final LiveData<Boolean> onlineStateNotify;
    private final Room room;
    private final Lazy rtcListener$delegate;
    private final gy.f rtcManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends f.a {
        public final /* synthetic */ MediaMultiAnchorStartViewModel a;

        public b(MediaMultiAnchorStartViewModel r1) {
            this.a = r1;
        }

        public final void d(int r1, List<AnchorLinkUser> r2) {
            MediaMultiAnchorStartViewModel.access$get_onlineStateNotify$p(this.a).postValue(Boolean.TRUE);
        }
    }

    static {
        Companion = new a();
    }

    private final gy.b getRtcListener() {
        return (gy.b) this.rtcListener$delegate.getValue();
    }

    public final List<User> getOnLineList() {
        e r0 = this.anchorInfoCenter;
        if (r0 == null) goto L14;
        List r1 = r0.getOnlineUserList();
        if (r1 == null) goto L14;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        User r5 = ((AnchorLinkUser) r4.next()).getUser();
        if (r5 == null) goto L13;
        r3.add(r5);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.User");
    L18:
        return r3;
    L14:
        return null;
    }

    public final void loadData() {
        e r0 = this.anchorInfoCenter;
        if (r0 == null) goto L6;
        r0.b(4, "show_link_list_dialog");
        return;
    }

    public MediaMultiAnchorStartViewModel() {
        RoomContext.a r0 = RoomContext.Companion;
        d r1 = null;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        m r6 = r5.getRoom();
        if (r6 == null) goto L7;
        Room r7 = (Room) r6.getValue();
    L8:
        this.room = r7;
        c.c2.getClass();
        c r8 = c.a.a();
        if (r8 == null) goto L11;
        gy.f r9 = r8.getRtcManager();
    L12:
        this.rtcManager = r9;
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r10 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r10 == null) goto L15;
        e r11 = r10.Np();
    L16:
        this.anchorInfoCenter = r11;
        RoomContext r2 = RoomContext.a.c(r0, null, 0, 3);
        if (r2 == null) goto L21;
        j r3 = r2.getMessageManager();
        if (r3 == null) goto L21;
        r1 = (d) r3.getValue();
    L21:
        this.messageManager = r1;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        this._finishState = r4;
        this.finishState = r4;
        MutableLiveData<Boolean> r13 = new MutableLiveData();
        this._onlineStateNotify = r13;
        this.onlineStateNotify = r13;
        this.rtcListener$delegate = LazyKt.lazy(new MediaMultiAnchorStartViewModel$rtcListener$2(this));
        b r14 = new b(this);
        this.anchorLinkCallback = r14;
        if (r9 == null) goto L24;
        r9.m(getRtcListener());
    L24:
        if (r11 == null) goto L27;
        r11.i(r14);
        return;
    L27:
        return;
    L15:
        r11 = null;
        goto L16
    L11:
        r9 = null;
    L7:
        r7 = null;
        goto L8
    }

    public final boolean isOverLimit() {
        List<User> r0 = getOnLineList();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L7:
        if (r1 < 4) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public void onCleared() {
        super.onCleared();
        e r0 = this.anchorInfoCenter;
        if (r0 == null) goto L5;
        r0.h(this.anchorLinkCallback);
    L5:
        gy.f r1 = this.rtcManager;
        if (r1 == null) goto L9;
        r1.e(getRtcListener());
        return;
    }

    public final LiveData<Boolean> getFinishState() {
        return this.finishState;
    }

    public final LiveData<Boolean> getOnlineStateNotify() {
        return this.onlineStateNotify;
    }

    public static final /* synthetic */ MutableLiveData access$get_finishState$p(MediaMultiAnchorStartViewModel r0) {
        return r0._finishState;
    }

    public static final /* synthetic */ MutableLiveData access$get_onlineStateNotify$p(MediaMultiAnchorStartViewModel r0) {
        return r0._onlineStateNotify;
    }

    public final boolean isOrganizer(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        e r0 = this.anchorInfoCenter;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.N(r2);
    }

    public static boolean isOrganizer$default(MediaMultiAnchorStartViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ey.c.b();
    L6:
        return r0.isOrganizer(r1);
    }
}
