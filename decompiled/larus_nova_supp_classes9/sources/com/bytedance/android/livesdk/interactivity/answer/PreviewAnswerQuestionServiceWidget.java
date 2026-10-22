package com.bytedance.android.livesdk.interactivity.answer;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.base.model.message.q;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.livesdk.preview.enter.EnterRoomManager;
import com.bytedance.livesdk.preview.merge.MergeDataContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/answer/PreviewAnswerQuestionServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lwlc/b;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAnswerQuestionServiceWidget extends MiddlewareRoomRecyclableWidget implements wlc.b {
    public AnswerQuestionCard a;
    public Disposable b;
    public final CompositeDisposable c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PreviewAnswerQuestionServiceWidget a;

        public b(PreviewAnswerQuestionServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.wq();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PreviewAnswerQuestionServiceWidget a;

        public c(PreviewAnswerQuestionServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            ALogger.d("PreviewAnswerQuestionServiceWidget", "enterLiveInnerEvent:" + r4);
            if (r4.booleanValue() == false) goto L13;
            this.a.wq();
            Disposable r5 = this.a.b;
            if (r5 != null) goto L7;
            return;
        L7:
            if (r5.isDisposed() == true) goto L15;
            Disposable r6 = this.a.b;
            if (r6 == null) goto L11;
            r6.dispose();
        L11:
            this.a.b = null;
            return;
        L15:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PreviewAnswerQuestionServiceWidget a;

        public d(PreviewAnswerQuestionServiceWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            MergeDataContext r3 = this.a.getMergeContext();
            if (r3 == null) goto L8;
            EnterRoomManager r4 = r3.getEnterManager();
            if (r4 == null) goto L9;
            new EnterRoomManager.ExecuteManager(r4).b.getClass();
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void wq() {
        ALogger.d("PreviewAnswerQuestionServiceWidget", "Dismiss Answer Card：" + this.a);
        MergeDataContext r0 = getMergeContext();
        if (r0 == null) goto L7;
        m r1 = r0.isAnswerStickerShow();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.FALSE);
    L7:
        AnswerQuestionCard r2 = this.a;
        if (r2 == null) goto L10;
        r2.dismissWindow();
    L10:
        Disposable r3 = this.b;
        if (r3 != null) goto L13;
    L17:
        this.b = null;
        this.a = null;
        return;
    L13:
        if (r3.isDisposed() == true) goto L17;
        Disposable r4 = this.b;
        if (r4 == null) goto L17;
        r4.dispose();
        goto L17
    }

    public PreviewAnswerQuestionServiceWidget() {
        this.c = new CompositeDisposable();
    }

    public final void onUnload() {
        wq();
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L15;
        j r2 = r1.getStreamMessageManager();
        if (r2 == null) goto L15;
        r2.c(new C03051(this));
    L15:
        this.c.dispose();
        return;
    L5:
        if (r0.isDisposed() == true) goto L10;
        Disposable r3 = this.b;
        if (r3 == null) goto L9;
        r3.dispose();
    L9:
        this.b = null;
        goto L10
    }

    public final void Rk(IStreamMessage r8) {
        if ((r8 instanceof q) == false) goto L53;
        StringBuilder r1 = new StringBuilder("Receive Answer Message BizData:");
        q r9 = (q) r8;
        r1.append(r9.getBizData());
        ALogger.d("PreviewAnswerQuestionServiceWidget", r1.toString());
        String r10 = r9.getBizData();
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.length() <= 0) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r10 = null;
    L14:
        if (r10 == null) goto L55;
        JsonObject r11 = new JsonParser().parse(r10).getAsJsonObject();     // Catch: Exception -> L51
        JsonElement r3 = r11.get("schema_url");     // Catch: Exception -> L51
        if (r3 == null) goto L56;
        String r4 = r3.getAsString();     // Catch: Exception -> L51
        if (r4 == null) goto L57;
        JsonElement r5 = r11.get("status");     // Catch: Exception -> L51
        if (r5 == null) goto L58;
        int r6 = r5.getAsInt();     // Catch: Exception -> L51
        if (r6 != 7) goto L25;
    L42:
        JsonElement r13 = r11.get("wait_destroyed_time");     // Catch: Exception -> L51
        if (r13 == null) goto L45;
        long r7 = r13.getAsLong();     // Catch: Exception -> L51
    L46:
        ALogger.d("PreviewAnswerQuestionServiceWidget", "Dismiss Answer Card Wait:" + r7);     // Catch: Exception -> L51
        if (r7 <= 0) goto L49;
        this.b = Observable.timer(r7, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));     // Catch: Exception -> L51
        return;
    L49:
        wq();     // Catch: Exception -> L51
        return;
    L45:
        r7 = 0;
        goto L46
    L25:
        if (r6 == 8) goto L42;
        if (this.a != null) goto L33;
        DataCenter r0 = ((Widget) this).dataCenter;     // Catch: Exception -> L51
        if (r0 == null) goto L32;
        r11.addProperty("unique_id_preview", z.d(r0, null));     // Catch: Exception -> L51
    L32:
        ALogger.d("PreviewAnswerQuestionServiceWidget", "Show Answer Card");     // Catch: Exception -> L51
        xq(r4, r11);     // Catch: Exception -> L51
        return;
    L33:
        if (r6 != 1) goto L60;
        Disposable r14 = this.b;     // Catch: Exception -> L51
        if (r14 != null) goto L37;
        return;
    L37:
        if (r14.isDisposed() == true) goto L62;
        ALogger.d("PreviewAnswerQuestionServiceWidget", "Start Answer Again");     // Catch: Exception -> L51
        Disposable r15 = this.b;     // Catch: Exception -> L51
        if (r15 == null) goto L41;
        r15.dispose();     // Catch: Exception -> L51
    L41:
        this.b = null;     // Catch: Exception -> L51
        return;
    L62:
        return;
    L60:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L65:
        return;
    L55:
        return;
    L9:
        r2 = false;
        goto L11
    }

    public final void onLoad(Object[] r5) {
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r6 == null) goto L7;
        j r7 = r6.getStreamMessageManager();
        if (r7 == null) goto L7;
        r7.c(new AnonymousClass1(this));
    L7:
        RxUtilKt.c(getMergeContext().getEnterLiveInnerEvent().onEvent().subscribe(new c(this)), this.c);
    }

    public final void xq(String r6, JsonObject r7) {
        Intrinsics.checkNotNullParameter(r6, "schema");
        Intrinsics.checkNotNullParameter(r7, "initData");
        wq();
        MergeDataContext r0 = getMergeContext();
        if (r0 == null) goto L11;
        m r1 = r0.isGiftStickerShow();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        ALogger.i("PreviewAnswerQuestionServiceWidget", "showAnswerQuestionContainer  show fail  isGiftStickerShow");
        return;
    L11:
        if (((Number) getMergeContext().getHighLightStatus().getValue()).intValue() != 2) goto L13;
    L36:
        ALogger.i("PreviewAnswerQuestionServiceWidget", "showAnswerQuestionContainer  show fail  highLightShow");
        return;
    L13:
        if (((Number) getMergeContext().getHighLightStatus().getValue()).intValue() == 1) goto L36;
        MergeDataContext r2 = getMergeContext();
        if (r2 == null) goto L20;
        m r3 = r2.isAnswerStickerShow();
        if (r3 == null) goto L20;
        r3.setValue(Boolean.TRUE);
    L20:
        Uri r4 = UriProtector.parse(r6);
        IBrowserService r5 = k.f(IBrowserService.class);
        if (r5 == null) goto L23;
        HybridCard r8 = r5.getHybridCard(((Widget) this).context, r4, null);
    L24:
        if (r8 != null) goto L26;
        return;
    L26:
        IHybridComponent r9 = r8.getMCurrentHybridComponent();
        if (r9 == null) goto L29;
        r9.load(null, UtilsKt.i(r7));
    L29:
        r8.show();
        IMiddlewareHostBusiness r10 = k.f(IMiddlewareHostBusiness.class);
        if (r10 != null) goto L32;
    L34:
        AnswerQuestionCard r11 = new AnswerQuestionCard(r8, ((Widget) this).dataCenter, r6);
        r11.show();
        Unit r13 = Unit.INSTANCE;
        this.a = r11;
        return;
    L32:
        if (r10.getPreviewAnswerClickEnable() != true) goto L34;
        r8.setOnClickListener(new d(this));
        goto L34
    L23:
        r8 = null;
        goto L24
    }
}
