package com.bytedance.android.live.liveinteract.digitavatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.videotalk.emoji.DynamicEmojiDiffCallback;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarEmojiDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/s;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DigitAvatarEmojiDialog extends LinkCommonBottomDialog implements com.bytedance.android.live.liveinteract.videotalk.emoji.s {
    public static long m;
    public static final /* synthetic */ int n = 0;
    public long a;
    public String b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public e0 i;
    public final CompositeDisposable j;
    public final DataCenter k;
    public final String l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DigitAvatarEmojiDialog a;

        public b(DigitAvatarEmojiDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            FragmentActivity r6 = ContextUtil.contextToFragmentActivity(this.a.getContext());
            if (r6 == null) goto L22;
            CommonBottomDialog r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r0);
        L19:
            int r2 = x.a;
            x.b(com.bytedance.android.live.core.utils.a0.d(this.a.k, false), "anchor_emoji_panel");
            int r3 = m.a;
            m.a(this.a.getContext(), r6.getSupportFragmentManager(), this.a.k, true, null);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r4 == null) goto L18;
            com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L7:
            if (Looper.myLooper() == r1.getLooper()) goto L9;
            r1.post(DialogLancet.createDismissRunnable(r0));
            goto L19
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DigitAvatarEmojiDialog a;

        public c(DigitAvatarEmojiDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r7);
        L17:
            int r8 = x.a;
            boolean r9 = com.bytedance.android.live.core.utils.a0.d(this.a.k, false);
            LinkedHashMap r1 = new LinkedHashMap();
            x.c(r1, r9);
            j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_model_close_click", r1, new Object[]{IRoom.class});
            DigitAvatarContext.a r10 = DigitAvatarContext.Companion;
            DigitAvatarContext r2 = r10.getContext();
            if (r2 == null) goto L20;
            r2.setSkipFrequencyCheck(true);
        L20:
            DigitAvatarContext r11 = r10.getContext();
            if (r11 == null) goto L29;
            DigitAvatarContext.setVideoShowMode$default(r11, VideoShowMode.VIDEO, null, 2, null);
            return;
        L29:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r3 == null) goto L16;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r7));
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void c0(TalkRoomBaseDynamicEmoji r2) {
        Intrinsics.checkNotNullParameter(r2, "emoji");
    }

    public final int getLayoutId() {
        return 2131565451;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        TalkRoomLogUtils.l(com.bytedance.android.live.core.utils.a0.d(this.k, false), this.l, true);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(DigitAvatarEmojiDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void O0(boolean r5) {
        if (r5 == false) goto L5;
        ((TextView) findViewById(2131371590)).setVisibility(0);
        findViewById(2131388181).setVisibility(4);
        findViewById(2131381814).setVisibility(8);
        return;
    L5:
        ((TextView) findViewById(2131371590)).setVisibility(8);
        findViewById(2131388181).setVisibility(0);
    }

    public final void P0(List<? extends com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r15) {
        e0 r0 = this.i;
        int r2 = 0;
        if (r0 == null) goto L24;
        Intrinsics.checkNotNullParameter(r15, "emojiList");
        List r3 = KotlinTypeUtilsKt.castElementType(r15);
        if (Lists.isEmpty(r3) == false) goto L7;
        int r4 = 0;
    L12:
        int r5 = r4 * r0.a;
        ArrayList r6 = new ArrayList(r5);
        int r7 = 0;
    L13:
        if (r7 >= r5) goto L15;
        r6.add(new com.bytedance.android.live.liveinteract.videotalk.emoji.model.q());
        r7 = r7 + 1;
        goto L13
    L15:
        Iterator r8 = r3.iterator();
        int r9 = 0;
    L17:
        if (r8.hasNext() == false) goto L23;
        TalkRoomBaseDynamicEmoji r10 = (TalkRoomBaseDynamicEmoji) r8.next();
        int r11 = r0.d;
        int r12 = r0.e;
        int r13 = r0.a;
        int r14 = r9 % r13;
        int r16 = r14 / r12;
        int r17 = ((r11 * (r14 - (r12 * r16))) + r16) + ((r9 / r13) * r13);
        if (r17 >= r5) goto L22;
        ListProtector.set(r6, r17, r10);
    L22:
        r9 = r9 + 1;
        goto L17
    L23:
        DiffUtil.DiffResult r18 = DiffUtil.calculateDiff(new DynamicEmojiDiffCallback(KotlinTypeUtilsKt.castElementType(CollectionsKt.toList(r15)), r6));
        r0.c = r6;
        r18.dispatchUpdatesTo(r0);
        goto L24
    L7:
        int r19 = r3.size() / r0.a;
        if ((r3.size() % r0.a) <= 0) goto L10;
        int r20 = 1;
    L11:
        r4 = r19 + r20;
        goto L12
    L10:
        r20 = 0;
    L24:
        int r1 = r15.size() / this.e;
        if ((r15.size() % this.e) <= 0) goto L27;
        int r110 = 1;
    L28:
        this.g = r1 + r110;
        findViewById(2131381814).a(this.g, this.h);
        RtlViewPagerShower r111 = findViewById(2131381814);
        if (this.g != 1) goto L31;
        r2 = 4;
    L31:
        r111.setVisibility(r2);
        return;
    L27:
        r110 = 0;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void j0(TalkRoomBaseDynamicEmoji r7) {
        Intrinsics.checkNotNullParameter(r7, "emoji");
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.j(r7, je0.d.D(), true, this.l);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r1 = r7.getEmojiPermission();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.schemaJumpUrl;
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        IBaseLiveActionHandler r4 = jc1.k.n(IBaseLiveActionHandler.class);
        Context r5 = getContext();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r8 = r7.getEmojiPermission();
        if (r8 == null) goto L11;
        r2 = r8.schemaJumpUrl;
    L11:
        r4.handle(r5, r2);
        M0(this);
        return;
    L13:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r6 = r7.getEmojiPermission();
        if (r6 != null) goto L16;
    L21:
        m = System.currentTimeMillis();
        DigitAvatarContext r9 = DigitAvatarContext.Companion.getContext();
        if (r9 == null) goto L26;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r10 = r9.getSendAvatarEmoji();
        if (r10 == null) goto L26;
        r10.post(r7);
    L26:
        TalkRoomLogUtils.n(com.bytedance.android.live.core.utils.a0.d(this.k, false), this.l, je0.d.f(), r7);
        M0(this);
        return;
    L16:
        if (r6.hasPermission != true) goto L21;
        if ((System.currentTimeMillis() - m) >= this.a) goto L21;
        f2.c(this.b, 0);
        return;
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        UtilityKotlinExtentionsKt.w(findViewById(2131378151));
        e0 r10 = new e0(this.d, this.c, com.bytedance.android.live.core.utils.a0.d(this.k, false), this.l);
        this.i = r10;
        Intrinsics.checkNotNullParameter(this, "listener");
        r10.b = this;
        findViewById(2131388181).setLayoutManager(new SSGridLayoutManager(getContext(), this.d, 0));
        findViewById(2131388181).setAdapter(this.i);
        findViewById(2131388181).setHasFixedSize(true);
        findViewById(2131388181).setItemViewCacheSize(this.e * 2);
        ViewGroup.LayoutParams r0 = findViewById(2131388181).getLayoutParams();
        r0.height = this.d * s1.j(2131168557);
        GridPagerSnapHelper r1 = new DigitAvatarEmojiDialog$attachSnapHelper$snapHelper$1(this);
        r1.h(this.d);
        r1.g(this.c);
        r1.attachToRecyclerView(findViewById(2131388181));
        findViewById(2131388181).addOnScrollListener(new DigitAvatarEmojiDialog$attachSnapHelper$1(this));
        findViewById(2131381814).setMargin(s1.j(2131168969));
        RtlViewPagerShower r11 = findViewById(2131381814);
        Drawable r2 = s1.m(2131250379);
        Drawable r3 = s1.m(2131250380);
        r11.c = r2;
        r11.d = r3;
        ((TextView) findViewById(2131383902)).setOnClickListener(new b(this));
        ((TextView) findViewById(2131387363)).setOnClickListener(new c(this));
        long r4 = System.currentTimeMillis();
        Disposable r12 = LinkApi.a.a((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class), com.bytedance.android.live.core.utils.a0.n(this.k).getRoomId(), je0.d.f(), 1, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this, r4), new k(this, r4));
        this.j.add(r12);
    }

    public DigitAvatarEmojiDialog(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter("virtual", "requestPage");
        super(r3);
        this.k = r4;
        this.l = "virtual";
        this.a = 1000;
        this.b = s1.B(2131922729);
        this.c = 4;
        this.d = 2;
        this.e = 8;
        this.j = new CompositeDisposable();
    }

    public static final void N0(DigitAvatarEmojiDialog r1, int r2) {
        int r3 = r2 / r1.e;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= r1.g) goto L10;
        r1.h = r3;
        r1.findViewById(2131381814).b(r1.h);
        return;
    }
}
