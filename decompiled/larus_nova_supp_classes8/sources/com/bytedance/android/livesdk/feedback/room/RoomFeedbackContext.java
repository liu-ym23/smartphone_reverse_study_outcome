package com.bytedance.android.livesdk.feedback.room;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R,\u0010\u0018\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR,\u0010!\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u000b0\u001bj\b\u0012\u0004\u0012\u00020\u000b` 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010\u001eR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010&R \u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010&R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010&R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010&¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/room/RoomFeedbackContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/feedback/room/a;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPlayFragment$LiveRoomListener;", "listener", "", "updateRoomListener", "", "roomId", "notifyOnForeground", "notifyOnBackground", "", "isSlideUp", "Z", "()Z", "setSlideUp", "(Z)V", "Lcom/bytedance/live/datacontext/n;", "_roomListener$delegate", "Lcom/bytedance/live/datacontext/p;", "get_roomListener", "()Lcom/bytedance/live/datacontext/n;", "_roomListener", "Lcom/bytedance/android/live/core/utils/IReadonlyNullable;", "roomListener", "Lcom/bytedance/live/datacontext/n;", "getRoomListener", "Lcom/bytedance/live/datacontext/m;", "_isHideViewsOnClearScreen$delegate", "get_isHideViewsOnClearScreen", "()Lcom/bytedance/live/datacontext/m;", "_isHideViewsOnClearScreen", "Lcom/bytedance/android/live/core/utils/IReadonlyNonNull;", "isHideViewsOnClearScreen", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/live/datacontext/k;", "_onRoomForegroundEvent$delegate", "get_onRoomForegroundEvent", "()Lcom/bytedance/live/datacontext/k;", "_onRoomForegroundEvent", "onRoomForegroundEvent", "Lcom/bytedance/live/datacontext/k;", "getOnRoomForegroundEvent", "_onRoomBackgroundEvent$delegate", "get_onRoomBackgroundEvent", "_onRoomBackgroundEvent", "onRoomBackgroundEvent", "getOnRoomBackgroundEvent", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomFeedbackContext extends DataContext implements com.bytedance.android.livesdk.feedback.room.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "RoomFeedbackContext";
    private final p _isHideViewsOnClearScreen$delegate;
    private final p _onRoomBackgroundEvent$delegate;
    private final p _onRoomForegroundEvent$delegate;
    private final p _roomListener$delegate;
    private final m<? extends Boolean> isHideViewsOnClearScreen;
    private boolean isSlideUp;
    private final k<Long> onRoomBackgroundEvent;
    private final k<Long> onRoomForegroundEvent;
    private final n<? extends ILiveRoomPlayFragment.LiveRoomListener> roomListener;

    public static final class a {
        @JvmStatic
        public static RoomFeedbackContext a() {
            DataContext r0 = d.d(RoomFeedbackContext.TAG);
            if ((r0 instanceof RoomFeedbackContext) == true) goto L6;
            r0 = null;
        L6:
            return (RoomFeedbackContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RoomFeedbackContext.class, "_roomListener", "get_roomListener()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomFeedbackContext.class, "_isHideViewsOnClearScreen", "get_isHideViewsOnClearScreen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomFeedbackContext.class, "_onRoomForegroundEvent", "get_onRoomForegroundEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RoomFeedbackContext.class, "_onRoomBackgroundEvent", "get_onRoomBackgroundEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.feedback.room.a get() {
        Companion.getClass();
        return a.a();
    }

    private final m<Boolean> get_isHideViewsOnClearScreen() {
        return (m) this._isHideViewsOnClearScreen$delegate.a(this, $$delegatedProperties[1]);
    }

    private final k<Long> get_onRoomBackgroundEvent() {
        return (k) this._onRoomBackgroundEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    private final k<Long> get_onRoomForegroundEvent() {
        return (k) this._onRoomForegroundEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    private final n<ILiveRoomPlayFragment.LiveRoomListener> get_roomListener() {
        return (n) this._roomListener$delegate.a(this, $$delegatedProperties[0]);
    }

    public RoomFeedbackContext() {
        this.isSlideUp = true;
        this._roomListener$delegate = q.c(this);
        this.roomListener = get_roomListener();
        this._isHideViewsOnClearScreen$delegate = q.d(this, Boolean.FALSE);
        this.isHideViewsOnClearScreen = get_isHideViewsOnClearScreen();
        this._onRoomForegroundEvent$delegate = e.b(this);
        this.onRoomForegroundEvent = get_onRoomForegroundEvent();
        this._onRoomBackgroundEvent$delegate = e.b(this);
        this.onRoomBackgroundEvent = get_onRoomBackgroundEvent();
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public k<Long> getOnRoomBackgroundEvent() {
        return this.onRoomBackgroundEvent;
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public k<Long> getOnRoomForegroundEvent() {
        return this.onRoomForegroundEvent;
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public n<? extends ILiveRoomPlayFragment.LiveRoomListener> getRoomListener() {
        return this.roomListener;
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public m<? extends Boolean> isHideViewsOnClearScreen() {
        return this.isHideViewsOnClearScreen;
    }

    public boolean isSlideUp() {
        return this.isSlideUp;
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public void notifyOnBackground(long r3) {
        ALogger.d(TAG, "notifyOnBackground,roomId：" + r3);
        get_onRoomBackgroundEvent().post(Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public void notifyOnForeground(long r3) {
        ALogger.d(TAG, "notifyOnForeground,roomId：" + r3);
        get_onRoomForegroundEvent().post(Long.valueOf(r3));
    }

    public void setSlideUp(boolean r1) {
        this.isSlideUp = r1;
    }

    @Override // com.bytedance.android.livesdk.feedback.room.a
    public void updateRoomListener(ILiveRoomPlayFragment.LiveRoomListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        get_roomListener().setValue(r2);
    }
}
