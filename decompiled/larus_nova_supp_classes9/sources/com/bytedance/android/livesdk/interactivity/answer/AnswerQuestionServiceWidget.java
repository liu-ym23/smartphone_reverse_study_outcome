package com.bytedance.android.livesdk.interactivity.answer;

import cc2.e;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.event.z;
import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import o42.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/answer/AnswerQuestionServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lwlc/b;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnswerQuestionServiceWidget extends MiddlewareRoomRecyclableWidget implements wlc.b {
    public AnswerQuestionCard a;
    public int b;
    public Disposable c;
    public Disposable d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnswerQuestionServiceWidget a;

        public b(AnswerQuestionServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = ((z) r3).c;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.length() <= 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L11;
            r4 = null;
        L11:
            if (r4 == null) goto L19;
            AnswerQuestionCard r1 = this.a.a;
            if (r1 == null) goto L20;
            HybridCard r2 = r1.n;
            if (r2 == null) goto L21;
            r2.sendJsEvent("answer_container_send_comment_extra", r4);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    static {
    }

    public final void Rk(IStreamMessage r1) {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        IAnswerQuestionService r0 = (IAnswerQuestionService) k.f(IAnswerQuestionService.class);
        if (r0 == null) goto L5;
        r0.setAnswerWidget(null);
    L5:
        wq();
        Disposable r1 = this.d;
        if (r1 != null) goto L8;
    L12:
        this.d = null;
        return;
    L8:
        if (r1.isDisposed() == true) goto L12;
        Disposable r2 = this.d;
        if (r2 == null) goto L12;
        r2.dispose();
        goto L12
    }

    public final boolean wq() {
        AnswerQuestionCard r0 = this.a;
        if (r0 == null) goto L17;
        ALogger.d("AnswerQuestionServiceWidget", "Dismiss Answer Card：" + r0);
        r0.dismissWindow();
        Disposable r1 = this.c;
        if (r1 != null) goto L7;
    L11:
        InteractionWidgetsPosContext r2 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r2 == null) goto L16;
        m r3 = r2.getAnswerQuestionContainerHeight();
        if (r3 == null) goto L16;
        r3.setValue(0);
    L16:
        RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).post(new c(false, true, "AnswerQuestionCardShow"));
        goto L17
    L7:
        if (r1.isDisposed() == true) goto L11;
        Disposable r4 = this.c;
        if (r4 == null) goto L11;
        r4.dispose();
    L17:
        this.a = null;
        this.c = null;
        this.b = 0;
        h r5 = i.a(null, ((Widget) this).dataCenter);
        if (r5 == null) goto L24;
        m<Boolean> r6 = r5.getAnswerQuestionShow();
        if (r6 == null) goto L24;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L24;
        xq(false);
    L24:
        return true;
    }

    public AnswerQuestionServiceWidget() {
    }

    public final void onLoad(Object[] r2) {
        IAnswerQuestionService r3 = (IAnswerQuestionService) k.f(IAnswerQuestionService.class);
        if (r3 == null) goto L6;
        r3.setAnswerWidget(this);
    L6:
        if (((Boolean) ec2.h.a.getValue()).booleanValue() == false) goto L9;
        this.d = xs2.b.a().b(z.class).subscribe(new b(this));
        return;
    }

    public final void xq(boolean r4) {
        h r0 = i.a(null, ((Widget) this).dataCenter);
        if (r0 == null) goto L7;
        m<Boolean> r1 = r0.getAnswerQuestionShow();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.valueOf(r4));
    L7:
        e r2 = new e();
        r2.a(cc2.k.class, cc2.k.a.c, r4);
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L11;
        r5.put("cmd_change_interactivity_component_visibility", r2);
        return;
    }
}
