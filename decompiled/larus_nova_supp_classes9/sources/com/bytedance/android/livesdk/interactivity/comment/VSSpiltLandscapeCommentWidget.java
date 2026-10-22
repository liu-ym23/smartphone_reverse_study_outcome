package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/VSSpiltLandscapeCommentWidget;", "Lcom/bytedance/android/livesdk/interactivity/comment/CommentWidget;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSSpiltLandscapeCommentWidget extends CommentWidget {
    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final int getLayoutId() {
        return 2131567639;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final String getSpm() {
        return "a100.a100.a285";
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final int Kq() {
        return UtilityKotlinExtentionsKt.i(170);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void tr() {
        this.b.setBackground(new e1());
    }

    public VSSpiltLandscapeCommentWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void Sq() {
        super.Sq();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void onUnload() {
        super.onUnload();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void onInit(Object[] r1) {
        super.onInit(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void onLoad(Object[] r6) {
        super.onLoad(r6);
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L6;
        Boolean r8 = (Boolean) r7.get("data_is_anchor");
        if (r8 == null) goto L6;
    L7:
        boolean r9 = r8.booleanValue();
        IRoomContextService r0 = getRoomContextService();
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L14;
        IRoom r3 = (IRoom) r2.getValue();
    L16:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(r9, r3) == false) goto L22;
        int r10 = UtilityKotlinExtentionsKt.i(170);
        if ((r10 % 2) == 0) goto L20;
        r10 = r10 - 1;
    L20:
        UIUtils.updateLayout(((Widget) this).contentView, r10, -3);
        UIUtils.updateLayoutMargin(((Widget) this).contentView, 0, 0, 0, 0);
        UIUtils.updateLayoutMargin(((Widget) this).containerView, 0, UtilityKotlinExtentionsKt.i(8), 0, 0);
        UIUtils.updateLayout(this.b, -3, UtilityKotlinExtentionsKt.i(38));
        return;
    L22:
        return;
    L14:
        r3 = null;
    L6:
        r8 = Boolean.FALSE;
        goto L7
    }
}
