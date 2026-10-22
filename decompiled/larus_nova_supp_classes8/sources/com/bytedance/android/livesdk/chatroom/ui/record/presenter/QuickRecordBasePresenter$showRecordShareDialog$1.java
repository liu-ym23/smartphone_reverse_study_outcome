package com.bytedance.android.livesdk.chatroom.ui.record.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.PopupWindow;
import bytekn.foundation.utils.h;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.PublishParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vr1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 4, 3})
final class QuickRecordBasePresenter$showRecordShareDialog$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ long $clickTime;
    final /* synthetic */ String $path;
    final /* synthetic */ b this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ float b;
        public final /* synthetic */ int c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ VideoViewParams f;
        public final /* synthetic */ QuickRecordBasePresenter$showRecordShareDialog$1 g;
        public final /* synthetic */ Bitmap h;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordBasePresenter$showRecordShareDialog$1$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0026a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0026a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r24) {
                ViewOnClickListenerC0026a r0 = this;
                DataCenter r1 = r0.a.g.this$0.g;
                if (r1 == null) goto L11;
                IRoom r2 = (IRoom) r1.get("data_room");
                if (r2 == null) goto L11;
                IRoomAuthStatus r3 = r2.getRoomAuthStatus();
                if (r3 == null) goto L11;
                if (r3.isDisableShare() != true) goto L11;
            L17:
                r0.a.g.this$0.f(false);
                return;
            L11:
                if (PadConfigUtils.c() == true) goto L16;
                r.m().logQuickRecordShareDialogClick();
                HashMap<String, String> r4 = r.m().generateShareLogParams(r0.a.g.this$0.g, "screencat");
                if (r4 != null) goto L15;
                r4 = new HashMap();
            L15:
                r4.put("content_type", "screencat");
                r4.put("vs_screen_type", "landscape");
                q r5 = r.m();
                Context r6 = r0.a.g.this$0.getContext();
                CollectionItem r11 = new CollectionItem();
                r11.setLocalVideoPath(r0.a.g.$path);
                r11.setLocalPreviewTopTitle("已保存至本地");
                Unit r12 = Unit.INSTANCE;
                ArrayList r13 = CollectionsKt.arrayListOf(new CollectionItem[]{r11});
                a r7 = r0.a;
                VideoViewParams r14 = r7.f;
                IRoom r15 = (IRoom) r7.g.this$0.g.get("data_room");
                long r16 = r0.a.g.this$0.d;
                int r8 = h.a;
                r5.launchMatchShare(r6, true, new MatchShareParam("screencat", "", "", r13, r14, r15, r16, new PublishParam("3", UUID.randomUUID().toString(), 4, 0), "screencat", r4, false, 0, 50944));
            L16:
                r0 = this;
                goto L17
            }
        }

        public static final class b implements PopupWindow.OnDismissListener {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.a.g.this$0.j.Gm();
                this.a.g.this$0.j.onShareDialogDismiss();
            }
        }

        public a(Activity r1, float r2, int r3, float r4, float r5, VideoViewParams r6, QuickRecordBasePresenter$showRecordShareDialog$1 r7, Bitmap r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void a() {
            com.bytedance.android.livesdk.chatroom.ui.record.b r10 = new com.bytedance.android.livesdk.chatroom.ui.record.b(this.a, this.h, (int) this.b, this.c, this.d, this.e, this.f, new ViewOnClickListenerC0026a(this), this.g.this$0.i);
            View r6 = this.a.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            int r7 = this.f.c;
            if (PopupWindowLancet.hasSubWindowToken(r6) == false) goto L11;
        L17:
            r10.setOnDismissListener(new b(this));
            this.g.this$0.j.onShareDialogShow();
            return;
        L11:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r10) == false) goto L13;
            r10.showAtLocation(r6, 0, 0, r7);
            goto L17
        L13:
            OverlaySource r9 = PopupWindowLancet.resolveSource(r6);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r10, r6, r9, 0, 0, r7) == true) goto L17;
            r10.showAtLocation(r6, 0, 0, r7);
            PopupWindowLancet.trackAfterShow(r10, r9, r6);
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public QuickRecordBasePresenter$showRecordShareDialog$1(b r1, long r2, String r4) {
        this.this$0 = r1;
        this.$clickTime = r2;
        this.$path = r4;
        super(1);
    }

    public final void invoke(Bitmap r13) {
        if (r13 == null) goto L19;
        b r0 = this.this$0;
        if (r0.e == true) goto L20;
        Context r1 = r0.getContext();
        if ((r1 instanceof Activity) == true) goto L8;
        r1 = null;
    L8:
        Activity r4 = (Activity) r1;
        if (r4 == null) goto L21;
        r.m().logQuickRecordShareDialogShow(this.$clickTime, this.this$0.d);
        float r7 = s1.e(100.0f);
        int r2 = bs1.a.a;
        float r8 = s1.e(32.0f);
        DataCenter r3 = this.this$0.g;
        if (r3 == null) goto L14;
        VideoViewParams r5 = (VideoViewParams) r3.get("live_render_view_params", null);
        if (r5 == null) goto L14;
    L15:
        VideoViewParams r9 = r5;
        int r6 = r9.b;
        int r10 = (int) (((r6 / 2) + (((r7 / r9.a) * r6) / 2)) - s1.f(12.0f));
        int r11 = s1.t();
        int r12 = r9.a;
        float r14 = (((r12 + ((r11 - r12) / 2)) - s1.f(16.0f)) - r7) - s1.f(8.0f);
        View r15 = this.this$0.h;
        if (r15 == null) goto L22;
        r15.post(new a(r4, r14, r10, r7, r8, r9, this, r13));
        return;
    L22:
        return;
    L14:
        r5 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L15
    L21:
        return;
    L20:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Bitmap) r1);
        return Unit.INSTANCE;
    }
}
