package com.bytedance.android.live.liveinteract.voicechat.interactacting;

import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.message.model.lf;
import com.bytedance.android.livesdk.message.model.pc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.b;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/interactacting/InteractActingWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractActingWidget extends MiddlewareRoomWidget implements l {
    public InteractActingContext a;
    public final CompositeDisposable b;
    public d c;

    public static final class a {
    }

    static {
    }

    public InteractActingWidget() {
        this.b = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(InteractActingWidget$initDataContext$pair$1.INSTANCE);
        InteractActingContext r1 = (InteractActingContext) r0.getFirst();
        b.a(r1, mf0.a.class);
        this.a = r1;
        this.b.add((Disposable) r0.getSecond());
        DataCenter r2 = ((Widget) this).dataCenter;
        xlc.a r3 = null;
        if (r2 == null) goto L5;
        d r4 = (d) r2.get("data_message_manager", null);
    L6:
        this.c = r4;
        if ((r4 instanceof xlc.a) == true) goto L9;
        r4 = null;
    L9:
        xlc.a r5 = (xlc.a) r4;
        if (r5 == null) goto L12;
        tlc.d r6 = r5.H(MessageType.LINK_MIC_PLAYMODE.getIntType(), "InteractActingSubSyncKey");
    L13:
        wq(r6);
        xlc.a r7 = this.c;
        if ((r7 instanceof xlc.a) == false) goto L17;
        r3 = r7;
    L17:
        xlc.a r8 = r3;
        if (r8 == null) goto L21;
        r8.D(MessageType.LINK_MIC_PLAYMODE.getIntType(), this, "InteractActingSubSyncKey");
        return;
    L21:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        d r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.b.clear();
    }

    public final void onMessage(tlc.d r1) {
        wq(r1);
    }

    public final void wq(tlc.d r6) {
        if ((r6 instanceof lf) == false) goto L32;
        lf r7 = (lf) r6;
        if (Intrinsics.areEqual(r7.getWRDSSubKey(), "InteractActingSubSyncKey") == false) goto L33;
        pc r0 = r7.getInteractActingMessage();
        if (r0 == null) goto L23;
        int r1 = r0.a();
        InteractActingStatus r2 = InteractActingStatus.START;
        if (r1 != r2.getValue()) goto L23;
        InteractActingContext r8 = this.a;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L14:
        if (((InteractActingStatus) r8.getStatus().getValue()) == r2) goto L19;
        System.currentTimeMillis();
        InteractActingContext r9 = this.a;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L18:
        r9.getStartTime().setValue(Long.valueOf(System.currentTimeMillis()));
    L19:
        InteractActingContext r10 = this.a;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L22:
        r10.getStatus().setValue(r2);
        return;
    L23:
        pc r11 = r7.getInteractActingMessage();
        if (r11 == null) goto L35;
        int r12 = r11.a();
        InteractActingStatus r3 = InteractActingStatus.END;
        if (r12 != r3.getValue()) goto L36;
        InteractActingContext r13 = this.a;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L30:
        r13.getStatus().setValue(r3);
        return;
    L36:
        return;
    L35:
        return;
    L33:
        return;
    }
}
