package com.ss.android.lark.forwardv3.configuration.listener;

import android.app.Activity;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "Landroid/os/Parcelable;", "setUpForwardMessage", "", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "interceptCustomForwardContent", "", "setupCustomForwardContentView", "activity", "Landroid/app/Activity;", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "imageLoader", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView$ImageLoader;", "onViewClick", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "ImageLoader", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface OnCustomForwardConfirmDialogContentView extends Parcelable {

    public interface a {
    }

    void E1(Activity r1, ConstraintLayout r2, BasicDialogContentConfig r3, a r4);

    void U0();

    boolean n1();

    void p(Activity r1, Fragment r2, View r3);
}
