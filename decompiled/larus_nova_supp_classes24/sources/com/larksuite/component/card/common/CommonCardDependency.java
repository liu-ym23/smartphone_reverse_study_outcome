package com.larksuite.component.card.common;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.runtime.common.Logger;
import com.larksuite.component.card.plugin.CardUpdateLocalDataPlugin;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.context.StreamingState;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.protocol.context.action.CardOpenUrlService;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photo.preview.utils.d;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener;
import com.ss.android.lark.widget.richtext.Image;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/common/CommonCardDependency;", "Lcom/larksuite/component/card/protocol/context/ICardDependency;", "actionService", "Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "openUrlService", "Lcom/larksuite/component/card/protocol/context/action/CardOpenUrlService;", "<init>", "(Lcom/larksuite/component/card/protocol/context/action/CardActionService;Lcom/larksuite/component/card/protocol/context/action/CardOpenUrlService;)V", "getCardActionService", "getOpenUrlService", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CommonCardDependency implements ICardDependency {
    private final CardActionService actionService;
    private final CardOpenUrlService openUrlService;

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public boolean canCopy() {
        return true;
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void reRender() {
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void setMsgCardSummary(String r1, String r2) {
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public CardActionService getCardActionService() {
        return this.actionService;
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public CardOpenUrlService getOpenUrlService() {
        return this.openUrlService;
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public boolean onLongClicked(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return false;
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void updateStreamingState(StreamingState.StreamingPhase r2) {
        Intrinsics.checkNotNullParameter(r2, "streamingPhase");
    }

    public CommonCardDependency(CardActionService r2, CardOpenUrlService r3) {
        Intrinsics.checkNotNullParameter(r2, "actionService");
        this.actionService = r2;
        this.openUrlService = r3;
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void onCopySelectText(CharSequence r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "copyText");
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void openProfilePage(Context r1, String r2, String r3) {
        ICardDependency.b.a(r1, r2, r3);
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void previewImage(View r2, List<? extends Image> r3, Image r4) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "cardImages");
        Intrinsics.checkNotNullParameter(r4, "clickedImageItem");
        CardDataUtils.a.getClass();
        List r5 = d.c(CardDataUtils.h(r3), "");
        List r6 = d.c(CollectionsKt.listOf(CardDataUtils.c(r4)), "");
        PhotoUtilsNew r0 = PhotoUtilsNew.a;
        int r7 = PhotoUtilsNew.g(r5, (PhotoItem) ListProtector.get(r6, 0));
        int r1 = k.a;
        k.c r8 = k.a.a(new ArrayList(r5), r7, r2);
        r8.c(194);
        r8.i(true);
        r8.u(Contexts.requireActivity(r2.getContext()));
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public Object previewVideo(CardContext r1, List<? extends PhotoItem> r2, boolean r3, VideoOperateListener r4, OnImageSelectListener r5, Continuation<? super Unit> r6) {
        Activity r7 = UIUtils.getActivityFromContext(r1.getContext());
        if (r7 != null) goto L5;
        Logger.b("ICardDependency", "previewVideo error, context is not activity");
        return Unit.INSTANCE;
    L5:
        int r8 = k.a;
        k.c r9 = k.a.a(r2, 0, null);
        r9.c(0);
        r9.f(r4);
        if (r5 == null) goto L8;
        r9.a.putParcelable("image_select_listener", r5);
    L8:
        r9.l(true);
        r9.e(false);
        r9.a.putBoolean("extra_auto_play", true);
        r9.q(Biz.Messenger, Scene.Chat, 7);
        r9.b(EnterSource.Message);
        r9.u(r7);
        return Unit.INSTANCE;
    }

    @Override // com.larksuite.component.card.protocol.context.ICardDependency
    public void updateCardLocalCache(String r1, String r2, String r3, Boolean r4, String r5, IGetDataCallback<CardUpdateLocalDataPlugin.CardUpdateLocalDataResponse> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
    }
}
