package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/InteractGroupDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractGroupDialog extends CommonBottomDialog {
    public static final /* synthetic */ int i = 0;
    public final CompositeDisposable a;
    public final Context b;
    public final boolean c;
    public final String d;
    public final String e;
    public final List<py.k> f;
    public final String g;
    public final String h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractGroupDialog a;

        public b(InteractGroupDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            if (this.a.isShowing() == false) goto L21;
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565479;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        ((TextView) findViewById(2131388747)).setText(this.d);
        ((TextView) findViewById(2131388746)).setText(this.e);
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        py.k r1 = null;
        if (r0 == null) goto L5;
        final IRoom r2 = (IRoom) r0.getValue();
    L6:
        final int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (this.c == false) goto L9;
        UtilityKotlinExtentionsKt.z(findViewById(2131362561), true);
        ImageLoader.load(qy.a.a("https://p6.douyinpic.com/aweme-client-static-resource/ttlive_bg_anchor_group.png~tplv-obj.image")).a(findViewById(2131362561));
        M0("create", "show");
        UtilityKotlinExtentionsKt.z(findViewById(2131362560), false);
        UtilityKotlinExtentionsKt.z(findViewById(2131374051), false);
        ((Button) findViewById(2131364615)).setText(s1.B(2131919481));
        ((Button) findViewById(2131364615)).setOnClickListener(new AnonymousClass1(this, r2, r3));
    L21:
        this.a.add(Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
        return;
    L9:
        M0("join", "show");
        HSImageView r4 = findViewById(2131362560);
        UtilityKotlinExtentionsKt.z(r4, true);
        List<py.k> r5 = this.f;
        if (r5 == null) goto L12;
        py.k r6 = (py.k) ListProtector.get(r5, 0);
    L13:
        if (r6 == null) goto L15;
        ImageLoader.bindImage(r4, r6);
    L15:
        HSImageView r7 = findViewById(2131374051);
        UtilityKotlinExtentionsKt.z(r7, true);
        List<py.k> r8 = this.f;
        if (r8 == null) goto L18;
        r1 = (py.k) ListProtector.get(r8, 1);
    L18:
        if (r1 == null) goto L20;
        ImageLoader.bindImage(r7, r1);
    L20:
        UtilityKotlinExtentionsKt.z(findViewById(2131362561), false);
        ((Button) findViewById(2131364615)).setText(s1.B(2131919488));
        ((Button) findViewById(2131364615)).setOnClickListener(new AnonymousClass4(this, r2, r3));
        goto L21
    L12:
        r6 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void M0(String r8, String r9) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isLiveTypeAudio() == false) goto L11;
        String r2 = "voice_live";
    L12:
        int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r3 != 9) goto L15;
        String r4 = "ktv";
    L22:
        String r5 = r1.getOwnerUserIdString();
        String r6 = String.valueOf(r1.getId());
        if (this.c == false) goto L26;
        String r7 = "anchor";
    L29:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_group_chat_invite_toast", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("live_type", r2), TuplesKt.to("function_type", r4), TuplesKt.to("anchor_id", r5), TuplesKt.to("room_id", r6), TuplesKt.to("user_type", r7), TuplesKt.to("invite_type", r8), TuplesKt.to("action_type", r9)}), new Object[0]);
        return;
    L26:
        if (hd0.c.f().h() == false) goto L28;
        r7 = "guest";
        goto L29
    L28:
        r7 = "user";
        goto L29
    L15:
        if (r3 != 12) goto L17;
    L20:
        r4 = "party";
        goto L22
    L17:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r1) == true) goto L20;
        r4 = "radio";
        goto L22
    L11:
        r2 = "video_live";
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public InteractGroupDialog(Context r2, boolean r3, String r4, String r5, List<? extends py.k> r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "mCtx");
        Intrinsics.checkNotNullParameter(r4, "mHeaderText");
        Intrinsics.checkNotNullParameter(r5, "mBodyText");
        Intrinsics.checkNotNullParameter(r7, "mConversationID");
        Intrinsics.checkNotNullParameter(r8, "mConversationShortID");
        super(r2);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.a = new CompositeDisposable();
    }
}
