package com.bytedance.android.livesdk.interactivity.api;

import android.net.Uri;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.answer.AnswerQuestionCard;
import com.bytedance.android.livesdk.interactivity.answer.AnswerQuestionServiceWidget;
import com.bytedance.android.livesdk.interactivity.answer.PreviewAnswerQuestionServiceWidget;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\fH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/AnswerQuestionService;", "Lcom/bytedance/android/livesdk/interactivity/api/IAnswerQuestionService;", "()V", "answerWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAnswerWidget", "()Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "setAnswerWidget", "(Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;)V", "dismissAnswerQuestionContainer", BuildConfig.FLAVOR, "getAnswerQuestionServiceWidget", "Ljava/lang/Class;", "getPreviewAnswerQuestionServiceWidget", "showAnswerQuestionContainer", "schema", BuildConfig.FLAVOR, "initData", "Lcom/google/gson/JsonObject;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnswerQuestionService implements IAnswerQuestionService {
    private LiveRecyclableWidget answerWidget;

    public AnswerQuestionService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public boolean dismissAnswerQuestionContainer() {
        LiveRecyclableWidget r0 = getAnswerWidget();
        if ((r0 instanceof AnswerQuestionServiceWidget) == true) goto L5;
        r0 = null;
    L5:
        AnswerQuestionServiceWidget r1 = (AnswerQuestionServiceWidget) r0;
        if (r1 == null) goto L8;
        r1.wq();
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public Class<? extends LiveRecyclableWidget> getAnswerQuestionServiceWidget() {
        return AnswerQuestionServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public LiveRecyclableWidget getAnswerWidget() {
        return this.answerWidget;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public Class<? extends LiveRecyclableWidget> getPreviewAnswerQuestionServiceWidget() {
        return PreviewAnswerQuestionServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public void setAnswerWidget(LiveRecyclableWidget r1) {
        this.answerWidget = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService
    public boolean showAnswerQuestionContainer(String r7, JsonObject r8) {
        Intrinsics.checkNotNullParameter(r7, "schema");
        Intrinsics.checkNotNullParameter(r8, "initData");
        LiveRecyclableWidget r2 = getAnswerWidget();
        if ((r2 instanceof AnswerQuestionServiceWidget) == true) goto L5;
        r2 = null;
    L5:
        AnswerQuestionServiceWidget r3 = (AnswerQuestionServiceWidget) r2;
        if (r3 == null) goto L23;
        Intrinsics.checkNotNullParameter(r7, "schema");
        Intrinsics.checkNotNullParameter(r8, "initData");
        r3.wq();
        Uri r0 = UriProtector.parse(r7);
        IBrowserService r1 = jc1.k.f(IBrowserService.class);
        if (r1 == null) goto L10;
        HybridCard r4 = r1.getHybridCard(((Widget) r3).context, r0, null);
    L11:
        if (r4 == null) goto L24;
        IHybridComponent r5 = r4.getMCurrentHybridComponent();
        if (r5 == null) goto L16;
        r5.load(null, UtilsKt.i(r8));
    L16:
        r4.show();
        AnswerQuestionCard r9 = new AnswerQuestionCard(r4, ((Widget) r3).dataCenter, r7);
        r9.show();
        Unit r10 = Unit.INSTANCE;
        r3.a = r9;
        r3.xq(true);
        AnswerQuestionCard r11 = r3.a;
        if (r11 == null) goto L21;
        HybridCard r13 = r11.n;
        if (r13 == null) goto L21;
        r3.c = RxUtilKt.g(r13, false).subscribe(new com.bytedance.android.livesdk.interactivity.answer.a(r13, r3));
    L21:
        return true;
    L24:
        return false;
    L10:
        r4 = null;
        goto L11
    L23:
        return false;
    }
}
