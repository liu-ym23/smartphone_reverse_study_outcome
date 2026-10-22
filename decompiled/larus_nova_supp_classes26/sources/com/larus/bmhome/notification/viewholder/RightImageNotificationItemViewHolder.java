package com.larus.bmhome.notification.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.NoticeButtonStyle;
import com.larus.bmhome.chat.resp.NoticeType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.notify.impl.databinding.LarusItemNotificationDefaultBinding;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import or8.p;
import or8.q;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/RightImageNotificationItemViewHolder;", "Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder;", "viewBinding", "Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;", "<init>", "(Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;)V", "getRightButton", "Landroid/view/View;", "createRightImage", "buttonData", "Lcom/larus/bmhome/chat/resp/Button;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RightImageNotificationItemViewHolder extends AbstractNotificationItemViewHolder {
    public static final /* synthetic */ int l = 0;

    @Override // com.larus.bmhome.notification.viewholder.AbstractNotificationItemViewHolder
    public final View V3() {
        Notice r0 = this.f;
        Integer r1 = null;
        if (r0 == null) goto L33;
        CommonNoticeData r2 = r0.getCommonNoticeData();
        if (r2 == null) goto L33;
        Button r3 = r2.getRightButton();
        if (r3 == null) goto L33;
        if (r3.getStyle() == NoticeButtonStyle.IMAGE.getStyle()) goto L12;
        return null;
    L12:
        SimpleDraweeView r4 = new SimpleDraweeView(getContext());
        String r5 = r3.getContent();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L20;
        Uri r7 = new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build();
    L21:
        List r8 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(NoticeType.LikeCreation.getType()), Integer.valueOf(NoticeType.CommentCreation.getType()), Integer.valueOf(NoticeType.ReplyCreationComment.getType()), Integer.valueOf(NoticeType.LikeCreationComment.getType())});
        Notice r9 = this.f;
        if (r9 == null) goto L25;
        r1 = Integer.valueOf(r9.getNoticeType());
    L25:
        if (CollectionsKt.contains(r8, r1) == false) goto L27;
        float r10 = i5.r0();
        RoundingParams r11 = RoundingParams.fromCornersRadii(r10, r10, r10, r10);
    L28:
        GenericDraweeHierarchy r12 = r4.getHierarchy();
        if (r12 == null) goto L31;
        r12.setRoundingParams(r11);
    L31:
        ImageLoaderKt.x(r4, r7, null, null, new p(), 6);
        e1.d(r4, new q(this));
        r4.setLayoutParams(new FrameLayout.LayoutParams(i5.d0(), i5.d0()));
        return r4;
    L27:
        r11 = RoundingParams.asCircle();
        goto L28
    L20:
        r7 = b0.a(r3.getContent(), "notice.right_avatar", false, false, 6);
        goto L21
    L15:
        if (StringsKt.isBlank(r5) != true) goto L17;
        r6 = true;
    L33:
        return null;
    }

    public RightImageNotificationItemViewHolder(LarusItemNotificationDefaultBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
    }
}
