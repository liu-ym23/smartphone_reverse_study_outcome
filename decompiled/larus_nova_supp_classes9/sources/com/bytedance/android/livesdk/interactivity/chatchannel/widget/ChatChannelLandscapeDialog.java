package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.i2;
import com.bytedance.android.livesdk.interactivity.api.IRoomChannelService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelLandscapeDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelLandscapeDialog extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b, Observer<KVData> {
    public static final int h = 0;
    public CompositeDisposable d;
    public DataCenter e;
    public RoomContext f;
    public long g;

    public static final class a {
        public static void a(ChatChannelLandscapeDialog r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "ChatChannelLandscapeDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.showNow(r3, "ChatChannelLandscapeDialog");
        }
    }

    public static final class b extends s22.e.a {
        public final /* synthetic */ ChatChannelLandscapeDialog a;

        @Override // s22.e.a
        public final void a(s22.a r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "chatChannel");
        }

        public b(ChatChannelLandscapeDialog r1) {
            this.a = r1;
        }

        @Override // s22.e.a
        public final void b(long r5) {
            ChatChannelLandscapeDialog r0 = this.a;
            if (r0.g != r5) goto L13;
            r0.dismiss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L14;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L14:
            return;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ RoomContext a;
        public final /* synthetic */ b b;

        public c(RoomContext r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            s22.e r0 = ChatChannelUtils.b(this.a);
            if (r0 == null) goto L6;
            r0.removeListener(this.b);
            return;
        }
    }

    static {
        h = s1.f(345.0f);
    }

    public final void dismissAllowingStateLoss() {
        com.bytedance.live.datacontext.m<Boolean> r0 = ChatChannelUtils.e(this.f);
        if (r0 == null) goto L5;
        r0.setValue(Boolean.FALSE);
    L5:
        MatchRoomLandScapeAnimUtil.E.j("ChatChannelLandscapeDialog");
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L12:
        com.bytedance.android.livesdk.f.d().f();
        CompositeDisposable r1 = this.d;
        if (r1 == null) goto L15;
        r1.dispose();
    L15:
        DataCenter r2 = this.e;
        if (r2 == null) goto L21;
        r2.removeObserver(this);
        return;
    L21:
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public ChatChannelLandscapeDialog() {
    }

    public final int getActualContentWidth() {
        return h;
    }

    public final void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L12;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954576);
        setAnimationType("right");
        setVertical(false);
    }

    public final Dialog onCreateDialog(Bundle r8) {
        Context r1 = getContext();
        if (r1 == null) goto L6;
        return new LiveStandardSheetDialog(r1, e5.n(), false, false, false, 28);
    L6:
        return super.onCreateDialog(r8);
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        boolean r0 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y("ChatChannelLandscapeDialog", this, -1);
        com.bytedance.android.livesdk.f.d().a();
        super.onViewCreated(r6, r7);
        this.d = new CompositeDisposable();
        RoomContext r8 = this.f;
        DataCenter r9 = this.e;
        if (r8 == null) goto L17;
        if (r9 == null) goto L17;
        IRoomChannelService r1 = (IRoomChannelService) jc1.k.f(IRoomChannelService.class);
        if (r1 == null) goto L13;
        RecyclableWidgetManager r2 = RecyclableWidgetManager.ga0(this, getView());
        r2.setDataCenter(r9);
        r2.setWidgetConfigHandler(new i2(r8, r9));
        r2.load(2131389499, r1.createChatChannelLandscapeWidget(this.g), false);
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.i == false) goto L11;
        r2.load(2131389499, r1.getChatChannelAtmosphereWidget(), false);
    L11:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.f == false) goto L13;
        r2.ca0(2131389499, r1.getChatChannelIMEmojiAnimWidget());
    L13:
        r9.observe("cmd_chat_channel_close_landscape_dialog", this);
        b r10 = new b(this);
        s22.e r3 = ChatChannelUtils.b(r8);
        if (r3 == null) goto L16;
        r3.addListener(r10);
    L16:
        RxUtilKt.c(Disposables.fromAction(new c(r8, r10)), this.d);
    L17:
        com.bytedance.live.datacontext.m<Boolean> r11 = ChatChannelUtils.e(this.f);
        if (r11 == null) goto L21;
        r11.setValue(Boolean.TRUE);
    L21:
        if (PadConfigUtils.c() == true) goto L30;
        Dialog r13 = getDialog();
        if (r13 == null) goto L31;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L32;
        View r15 = r14.findViewById(2131389843);
        if (r15 == null) goto L33;
        a1.n(r15, h);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565298, r3, false);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(h, -1);
        r6.gravity = 8388613;
        Unit r7 = Unit.INSTANCE;
        r5.setLayoutParams(r6);
        return r5;
    }
}
