package com.ss.android.lark.integrator.ccm.dependency.forward;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import com.ss.android.lark.forwardv3.forward.imageforward.a;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CCMForward {

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016¨\u0006 "}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/forward/CCMForward$CCMImageOnCustomForwardConfirmDialogContentView;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "writeToParcel", "", "flags", "", "setUpForwardMessage", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "interceptCustomForwardContent", "", "setupCustomForwardContentView", "activity", "Landroid/app/Activity;", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "imageLoader", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView$ImageLoader;", "onViewClick", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "describeContents", "CREATOR", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class CCMImageOnCustomForwardConfirmDialogContentView implements OnCustomForwardConfirmDialogContentView {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<CCMImageOnCustomForwardConfirmDialogContentView> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CCMImageOnCustomForwardConfirmDialogContentView createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new CCMImageOnCustomForwardConfirmDialogContentView();
            }

            @Override // android.os.Parcelable.Creator
            public final CCMImageOnCustomForwardConfirmDialogContentView[] newArray(int r1) {
                return new CCMImageOnCustomForwardConfirmDialogContentView[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public CCMImageOnCustomForwardConfirmDialogContentView() {
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

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J.\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/forward/CCMForward$CCMTextOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "TAG", "", "writeToParcel", "", "flags", "", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "errorTitle", "errorMessage", "describeContents", "CREATOR", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class CCMTextOnForwardContentListener implements OnForwardContentListener {
        public static final a CREATOR = null;
        public final String a;

        public static final class a implements Parcelable.Creator<CCMTextOnForwardContentListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CCMTextOnForwardContentListener createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new CCMTextOnForwardContentListener();
            }

            @Override // android.os.Parcelable.Creator
            public final CCMTextOnForwardContentListener[] newArray(int r1) {
                return new CCMTextOnForwardContentListener[r1];
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ Activity a;

            public b(Activity r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                UDToast.show(this.a, 2131887560, 2131256306);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
        }

        public CCMTextOnForwardContentListener() {
            this.a = "CCMTextOnForwardContentListener";
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r4) {
            tt5.a.d(this.a, "onFailed errorTitle: null, errorMessage: " + r4);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r4, Map<String, ? extends ForwardTargetBaseInfoNew> r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "result");
            if (r4 != null) goto L5;
            return true;
        L5:
            tt5.a.h(this.a, "onSuccess allowToast: " + r6);
            if (r6 == false) goto L8;
            UICallbackExecutor.execute(new b(r4));
        L8:
            return true;
        }
    }

    static {
    }

    public static void a(Context r5, DocImagesForwardData r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L6;
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
        r4.addAll(r6.getImages());
        Message r7 = new Message();
        r7.setType(Message.Type.IMAGE);
        r7.setMessageContent(r1);
        r7.setOnTimeDel(false);
        BasicDialogContentConfig r8 = r0.chatApi().b();
        r8.k = false;
        ForwardTemplateNew.a r9 = new ForwardTemplateNew.a();
        ImageForwardContent.a r10 = new ImageForwardContent.a();
        if (r6.getImages() == null) goto L12;
        Collection r11 = r6.getImages();
    L13:
        ArrayList<String> r12 = new ArrayList(r11);
        Intrinsics.checkNotNullParameter(r12, "imageList");
        r10.a = r12;
        r9.f = r10.a();
        ForwardAdditionNoteConfig.a r13 = new ForwardAdditionNoteConfig.a();
        r13.a = r6.isCanAddExtraInfo();
        ForwardAdditionNoteConfig r14 = r13.a();
        Intrinsics.checkNotNullParameter(r14, "forwardAdditionNoteConfig");
        r9.d = r14;
        ForwardConfirmDialogConfig.a r15 = new ForwardConfirmDialogConfig.a();
        r15.d = r8;
        CCMImageOnCustomForwardConfirmDialogContentView r16 = new CCMImageOnCustomForwardConfirmDialogContentView();
        Intrinsics.checkNotNullParameter(r16, "listener");
        r15.e = r16;
        ForwardConfirmDialogConfig r17 = r15.a();
        Intrinsics.checkNotNullParameter(r17, "forwardConfirmDialogConfig");
        r9.e = r17;
        a.a(r5, 3, -1, r9.a());
        return;
    L12:
        r11 = new ArrayList();
        goto L13
    }

    public static void b(Context r6, DocShareTextData r7, int r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r7 != null) goto L6;
        return;
    L6:
        ForwardTemplateNew.a r0 = new ForwardTemplateNew.a();
        TextForwardContent.a r1 = new TextForwardContent.a();
        String r2 = r7.getContent();
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        Intrinsics.checkNotNullParameter(r2, "content");
        r1.a = r2;
        r1.b = r7.isLocalShare();
        String r4 = r7.getSourceName();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        Intrinsics.checkNotNullParameter(r4, "sourceName");
        r1.c = r4;
        r0.f = r1.a();
        ForwardConfirmDialogConfig.a r5 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r9 = new BasicDialogContentConfig.a();
        String r10 = r7.getContent();
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        Intrinsics.checkNotNullParameter(r10, "content");
        r9.c = r10;
        String r11 = r7.getTitle();
        if (r11 == null) goto L19;
        r3 = r11;
    L19:
        Intrinsics.checkNotNullParameter(r3, "title");
        r9.b = r3;
        r5.d = r9.a();
        ForwardConfirmDialogConfig r12 = r5.a();
        Intrinsics.checkNotNullParameter(r12, "forwardConfirmDialogConfig");
        r0.e = r12;
        ForwardAdditionNoteConfig.a r13 = new ForwardAdditionNoteConfig.a();
        r13.a = r7.isCanAddExtraInfo();
        ForwardAdditionNoteConfig r14 = r13.a();
        Intrinsics.checkNotNullParameter(r14, "forwardAdditionNoteConfig");
        r0.d = r14;
        ForwardCommonConfig.a r15 = new ForwardCommonConfig.a();
        r15.f = new CCMTextOnForwardContentListener();
        ForwardCommonConfig r16 = r15.a();
        Intrinsics.checkNotNullParameter(r16, "forwardCommonConfig");
        r0.c = r16;
        com.ss.android.lark.forwardv3.forward.textforward.a.a(r6, 3, r8, r0.a());
    }
}
