package com.larus.bmhome.notification.viewholder;

import android.view.View;
import android.widget.ImageView;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.NoticeButtonStyle;
import com.larus.notify.impl.databinding.LarusItemNotificationDefaultBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/RightArrowIconNotificationItemViewHolder;", "Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder;", "viewBinding", "Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;", "<init>", "(Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;)V", "getRightButton", "Landroid/view/View;", "createRightArrowView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RightArrowIconNotificationItemViewHolder extends AbstractNotificationItemViewHolder {
    public static final /* synthetic */ int l = 0;

    @Override // com.larus.bmhome.notification.viewholder.AbstractNotificationItemViewHolder
    public final View V3() {
        Notice r0 = this.f;
        if (r0 == null) goto L23;
        CommonNoticeData r1 = r0.getCommonNoticeData();
        if (r1 == null) goto L23;
        Button r2 = r1.getRightButton();
        if (r2 == null) goto L23;
        if (r2.getStyle() != NoticeButtonStyle.RIGHT_ARROW.getStyle()) goto L23;
        String r3 = r2.getSchema();
        boolean r4 = false;
        if (r3 != null) goto L14;
    L19:
        if (r4 == true) goto L23;
        ImageView r5 = new ImageView(getContext());
        r5.setImageResource(2131242746);
        e1.d(r5, new o(this));
        return r5;
    L14:
        if (r3.length() != 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 != true) goto L19;
        r4 = true;
        goto L19
    L16:
        r6 = false;
    L23:
        return null;
    }

    public RightArrowIconNotificationItemViewHolder(LarusItemNotificationDefaultBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
    }
}
