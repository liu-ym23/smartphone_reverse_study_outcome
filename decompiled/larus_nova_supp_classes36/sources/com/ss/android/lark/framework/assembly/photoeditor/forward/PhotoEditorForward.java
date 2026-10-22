package com.ss.android.lark.framework.assembly.photoeditor.forward;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import com.ss.android.lark.forwardv3.forward.imageforward.a;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PhotoEditorForward {

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016¨\u0006 "}, d2 = {"Lcom/ss/android/lark/framework/assembly/photoeditor/forward/PhotoEditorForward$PhotoEditorImageOnCustomForwardConfirmDialogContentView;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "writeToParcel", "", "flags", "", "setUpForwardMessage", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "interceptCustomForwardContent", "", "setupCustomForwardContentView", "activity", "Landroid/app/Activity;", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "imageLoader", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView$ImageLoader;", "onViewClick", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "describeContents", "CREATOR", "photoeditor-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class PhotoEditorImageOnCustomForwardConfirmDialogContentView implements OnCustomForwardConfirmDialogContentView {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<PhotoEditorImageOnCustomForwardConfirmDialogContentView> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final PhotoEditorImageOnCustomForwardConfirmDialogContentView createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new PhotoEditorImageOnCustomForwardConfirmDialogContentView();
            }

            @Override // android.os.Parcelable.Creator
            public final PhotoEditorImageOnCustomForwardConfirmDialogContentView[] newArray(int r1) {
                return new PhotoEditorImageOnCustomForwardConfirmDialogContentView[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public PhotoEditorImageOnCustomForwardConfirmDialogContentView() {
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void U0() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final boolean n1() {
            return true;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void p(Activity r2, Fragment r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "fragment");
            Intrinsics.checkNotNullParameter(r4, "view");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void E1(Activity r1, ConstraintLayout r2, BasicDialogContentConfig r3, OnCustomForwardConfirmDialogContentView.a r4) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            Intrinsics.checkNotNullParameter(r2, "contentParent");
            Intrinsics.checkNotNullParameter(r3, "content");
            IIMApi r5 = (IIMApi) ApiUtils.getApi(IIMApi.class);
            if (r5 != null) goto L5;
            return;
        L5:
            r5.chatApi().e();
        }
    }

    static {
    }

    public static void a(Context r6, String r7, int r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r7 != null) goto L6;
        return;
    L6:
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L9;
        return;
    L9:
        ImageContent r1 = new ImageContent();
        ImageSet r2 = new ImageSet();
        r1.setImageSet(r2);
        Image r3 = new Image();
        r2.setOrigin(r3);
        ArrayList r4 = new ArrayList();
        r3.setUrls(r4);
        r4.add(r7);
        Message r5 = new Message();
        r5.setType(Message.Type.IMAGE);
        r5.setMessageContent(r1);
        r5.setOnTimeDel(false);
        BasicDialogContentConfig r9 = r0.chatApi().b();
        r9.k = false;
        ForwardTemplateNew.a r10 = new ForwardTemplateNew.a();
        ImageForwardContent.a r11 = new ImageForwardContent.a();
        ArrayList<String> r12 = CollectionsKt.arrayListOf(new String[]{r7});
        Intrinsics.checkNotNullParameter(r12, "imageList");
        r11.a = r12;
        r10.f = r11.a();
        ForwardSelectConfig.a r13 = new ForwardSelectConfig.a();
        r13.b = true;
        ForwardSelectConfig r14 = r13.a();
        Intrinsics.checkNotNullParameter(r14, "forwardSelectConfig");
        r10.b = r14;
        ForwardConfirmDialogConfig.a r15 = new ForwardConfirmDialogConfig.a();
        r15.d = r9;
        PhotoEditorImageOnCustomForwardConfirmDialogContentView r16 = new PhotoEditorImageOnCustomForwardConfirmDialogContentView();
        Intrinsics.checkNotNullParameter(r16, "listener");
        r15.e = r16;
        ForwardConfirmDialogConfig r17 = r15.a();
        Intrinsics.checkNotNullParameter(r17, "forwardConfirmDialogConfig");
        r10.e = r17;
        a.a(r6, 1, r8, r10.a());
    }
}
