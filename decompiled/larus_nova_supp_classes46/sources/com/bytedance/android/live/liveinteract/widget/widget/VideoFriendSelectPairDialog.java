package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.live.liveinteract.plantform.model.l0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/VideoFriendSelectPairDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/widget/widget/SelectPairRankAdapter$SelectPairRankItemViewHolder$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoFriendSelectPairDialog extends CommonBottomDialog implements SelectPairRankAdapter.SelectPairRankItemViewHolder.a {
    public final CompositeDisposable a;
    public final SelectPairRankAdapter b;
    public String c;
    public final h0 d;
    public final a e;

    public interface a {
        void A0(List<? extends h0> r1);
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VideoFriendSelectPairDialog a;
        public final /* synthetic */ IRoom b;

        public b(VideoFriendSelectPairDialog r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            if (r4 == null) goto L13;
            com.bytedance.android.livesdk.rank.model.c r5 = (com.bytedance.android.livesdk.rank.model.c) r4.data;
            if (r5 == null) goto L14;
            List r6 = r5.ranks;
            if (r6 != null) goto L9;
            return;
        L9:
            if (r6.size() < 100) goto L11;
            r6.removeAll(r6.subList(99, r6.size()));
        L11:
            SelectPairRankAdapter r0 = this.a.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "data");
            r0.a.clear();
            r0.a.addAll(r6);
            this.a.b.notifyDataSetChanged();
            return;
        L14:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VideoFriendSelectPairDialog a;

        public c(VideoFriendSelectPairDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VideoFriendSelectPairDialog a;
        public final /* synthetic */ IBaseUser b;

        public e(VideoFriendSelectPairDialog r1, IBaseUser r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            this.a.e.A0(((l0) ((com.bytedance.android.live.network.response.e) r4).data).getUsers());
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VideoFriendSelectPairDialog a;
        public final /* synthetic */ IBaseUser b;

        public f(VideoFriendSelectPairDialog r1, IBaseUser r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            ExceptionUtils.handleException(this.a.getContext(), r3);
        }
    }

    public final int getLayoutId() {
        return 2131565790;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    @Override // com.bytedance.android.live.liveinteract.widget.widget.SelectPairRankAdapter.SelectPairRankItemViewHolder.a
    public final void a0(IBaseUser r13) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.getValue();
    L6:
        if (r2 == null) goto L17;
        LinkAnchorApi r3 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r4 = r2.getId();
        long r6 = d5.c(this.c);
        String r8 = this.c;
        if (r13 == null) goto L10;
        r1 = r13.getIdString();
    L10:
        long r9 = d5.c(r1);
        if (r13 == null) goto L14;
        String r5 = r13.getIdString();
        if (r5 == null) goto L14;
    L15:
        this.a.add(r3.updatePairUser(r4, r6, r8, r9, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r13), new f(this, r13)));
        return;
    L14:
        r5 = "";
        goto L15
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        setCanceledOnTouchOutside(true);
        ((FrameLayout) findViewById(2131376031)).setOnClickListener(new c(this));
        h0 r0 = this.d;
        if (r0 == null) goto L10;
        ILinkPlayerInfoBridge r1 = r0.getGuest();
        if (r1 == null) goto L10;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
        if (r3 == null) goto L10;
    L11:
        this.c = r3;
        TextView r4 = (TextView) findViewById(2131391377);
        Object[] r5 = new Object[1];
        ILinkPlayerInfoBridge r6 = this.d.getGuest();
        if (r6 == null) goto L17;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L17;
        String r8 = r7.getNickName();
        if (r8 == null) goto L17;
    L18:
        r5[0] = r8;
        r4.setText(s1.C(2131920067, r5));
        findViewById(2131384981).setAdapter(this.b);
        findViewById(2131384981).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        com.bytedance.live.datacontext.m r14 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r9 = null;
        if (r14 == null) goto L21;
        IRoom r15 = (IRoom) r14.getValue();
    L22:
        if (r15 == null) goto L49;
        LinkApi r10 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        long r11 = r15.getId();
        IBaseUser r12 = r15.getOwner();
        if (r12 == null) goto L26;
        Intrinsics.checkNotNullParameter(r12, "$this$secUidExt");
        String r16 = r12.getCastSecUid();
    L27:
        ILinkPlayerInfoBridge r17 = this.d.getGuest();
        if (r17 == null) goto L35;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L35;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        String r19 = r18.getCastSecUid();
        if (r19 == null) goto L35;
        String r20 = r19;
    L36:
        IBaseUser r21 = r15.getOwner();
        if (r21 == null) goto L39;
        String r22 = r21.getIdString();
    L40:
        ILinkPlayerInfoBridge r23 = this.d.getGuest();
        if (r23 == null) goto L45;
        IBaseUser r24 = r23.getUser();
        if (r24 == null) goto L45;
        r9 = r24.getIdString();
    L45:
        Disposable r110 = r10.getLinkerRankList(r11, r16, r20, r22, r9, 8).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r15), d.a);
        if (r110 == null) goto L50;
        this.a.add(r110);
        return;
    L50:
        return;
    L39:
        r22 = null;
    L35:
        r20 = "";
        goto L36
    L26:
        r16 = null;
        goto L27
    L49:
        return;
    L21:
        r15 = null;
    L17:
        r8 = "";
    L10:
        r3 = "";
        goto L11
    }

    public VideoFriendSelectPairDialog(Context r3, h0 r4, VideoFriendPairDialog r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(null, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "pairUser");
        Intrinsics.checkNotNullParameter(r5, "mCallBack");
        super(r3);
        this.d = r4;
        this.e = r5;
        this.a = new CompositeDisposable();
        this.b = new SelectPairRankAdapter(r3, this);
        this.c = "";
    }
}
