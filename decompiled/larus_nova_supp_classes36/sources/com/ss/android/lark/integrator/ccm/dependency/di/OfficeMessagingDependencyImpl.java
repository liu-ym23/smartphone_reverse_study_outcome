package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$GroupChatTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$PublicTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ShieldTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ThreadTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$UserTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$GroupType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Shield;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Status;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$UserType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.integrator.ccm.dependency.forward.CCMForward;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class OfficeMessagingDependencyImpl extends i0 {

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016¨\u0006 "}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/OfficeMessagingDependencyImpl$OfficeCcmImageConfirmView;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "setUpForwardMessage", "", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "interceptCustomForwardContent", "", "setupCustomForwardContentView", "activity", "Landroid/app/Activity;", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "imageLoader", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView$ImageLoader;", "onViewClick", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "writeToParcel", "flags", "", "describeContents", "CREATOR", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OfficeCcmImageConfirmView implements OnCustomForwardConfirmDialogContentView {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<OfficeCcmImageConfirmView> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmImageConfirmView createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new OfficeCcmImageConfirmView();
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmImageConfirmView[] newArray(int r1) {
                return new OfficeCcmImageConfirmView[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public OfficeCcmImageConfirmView() {
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
            if (r5 == null) goto L8;
            com.ss.android.lark.biz.im.api.d r6 = r5.chatApi();
            if (r6 == null) goto L9;
            r6.e();
            return;
        L9:
            return;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/OfficeMessagingDependencyImpl$OfficeCcmOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OfficeCcmOnForwardContentListener implements OnForwardContentListener {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<OfficeCcmOnForwardContentListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmOnForwardContentListener createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new OfficeCcmOnForwardContentListener();
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeCcmOnForwardContentListener[] newArray(int r1) {
                return new OfficeCcmOnForwardContentListener[r1];
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

        public OfficeCcmOnForwardContentListener() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r3) {
            tt5.a.d("OfficeMessagingDependencyImpl", "forward failed, errorTitle=null, errorMessage=" + r3);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r2, Map<String, ? extends ForwardTargetBaseInfoNew> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "result");
            if (r2 != null) goto L5;
            return true;
        L5:
            if (r4 == false) goto L7;
            UICallbackExecutor.execute(new b(r2));
        L7:
            return true;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0
    public final boolean Qc() {
        IOfficeSDKBizConfigProvider r0 = OfficeSDKManager.getBizConfigProvider();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r3 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile.share_words_preview_forward_container_enable");
        if (r2 == false) goto L12;
        if (r3 == false) goto L12;
        r1 = true;
    L12:
        tt5.a.h("OfficeMessagingDependencyImpl", "isForwardToImEnabled=" + r1 + ", imEnabled=" + r2 + ", fgEnabled=" + r3);
        return r1;
    L5:
        if (r0.isEnabled(IOfficeSDKBizConfigProvider.Biz.IM) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Inject
    public OfficeMessagingDependencyImpl() {
    }

    public static void a(ForwardTemplateNew r2) {
        if (r2.getForwardTargetConfig().d != null) goto L5;
        ForwardTargetConfig r0 = r2.getForwardTargetConfig();
        IncludeConfig.CREATOR.getClass();
        r0.d = IncludeConfig.b.a();
    L5:
        IncludeConfig r3 = r2.getForwardTargetConfig().d;
        if (r3 == null) goto L9;
        EntityItem.a r1 = new EntityItem.a();
        r1.a(new AIConfig());
        r3.a(r1.c());
        return;
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0
    public final void V0(Context r2, DocShareTextData r3) {
        bd(r2, r3, -1);
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0
    public final void aa(Context r9, DocImagesForwardData r10) {
        if (Qc() == true) goto L6;
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardImage fallback to online behavior, im experiment disabled");
        CCMForward.a(r9, r10);
        return;
    L6:
        if (r9 == null) goto L32;
        if (r10 == null) goto L32;
        List r2 = r10.getImages();
        if (r2 != null) goto L12;
        r2 = CollectionsKt.emptyList();
    L12:
        ArrayList<String> r0 = new ArrayList(r2);
        if (r0.isEmpty() == false) goto L16;
        tt5.a.k("OfficeMessagingDependencyImpl", "forwardImage ignored, image list is empty");
        return;
    L16:
        IIMApi r3 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r3 == null) goto L22;
        ImageContent r4 = new ImageContent();
        ImageSet r5 = new ImageSet();
        r4.setImageSet(r5);
        Image r6 = new Image();
        r5.setOrigin(r6);
        List r7 = r10.getImages();
        if (r7 != null) goto L21;
        r7 = CollectionsKt.emptyList();
    L21:
        r6.setUrls(new ArrayList(r7));
        Message r8 = new Message();
        r8.setType(Message.Type.IMAGE);
        r8.setMessageContent(r4);
        r8.setOnTimeDel(false);
        BasicDialogContentConfig r11 = r3.chatApi().b();
        r11.k = false;
    L30:
        ForwardTemplateNew.a r12 = new ForwardTemplateNew.a();
        r12.g = 5;
        ImageForwardContent.a r13 = new ImageForwardContent.a();
        Intrinsics.checkNotNullParameter(r0, "imageList");
        r13.a = r0;
        r12.f = r13.a();
        ForwardAdditionNoteConfig.a r14 = new ForwardAdditionNoteConfig.a();
        r14.a = r10.isCanAddExtraInfo();
        ForwardAdditionNoteConfig r15 = r14.a();
        Intrinsics.checkNotNullParameter(r15, "forwardAdditionNoteConfig");
        r12.d = r15;
        ForwardConfirmDialogConfig.a r16 = new ForwardConfirmDialogConfig.a();
        r16.d = r11;
        OfficeCcmImageConfirmView r17 = new OfficeCcmImageConfirmView();
        Intrinsics.checkNotNullParameter(r17, "listener");
        r16.e = r17;
        ForwardConfirmDialogConfig r18 = r16.a();
        Intrinsics.checkNotNullParameter(r18, "forwardConfirmDialogConfig");
        r12.e = r18;
        ForwardCommonConfig.a r19 = new ForwardCommonConfig.a();
        r19.f = new OfficeCcmOnForwardContentListener();
        ForwardCommonConfig r110 = r19.a();
        Intrinsics.checkNotNullParameter(r110, "forwardCommonConfig");
        r12.c = r110;
        ForwardTemplateNew r111 = r12.a();
        a(r111);
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardImage by DoubaoForwardLauncher, imageSize=" + r0.size());
        com.suite.lark.platform.feature.forward.doubao.u.a(r9, r111, 0, null, 12);
        return;
    L22:
        BasicDialogContentConfig.a r20 = new BasicDialogContentConfig.a();
        String r21 = r10.getTitle();
        String r22 = "";
        if (r21 != null) goto L25;
        r21 = "";
    L25:
        Intrinsics.checkNotNullParameter(r21, "title");
        r20.b = r21;
        String r23 = r10.getContent();
        if (r23 == null) goto L29;
        r22 = r23;
    L29:
        Intrinsics.checkNotNullParameter(r22, "content");
        r20.c = r22;
        r11 = r20.a();
    L32:
        tt5.a.k("OfficeMessagingDependencyImpl", "forwardImage ignored, context or data is null");
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0
    public final void n3(FragmentActivity r20, ForwardTemplate r21) {
        if (Qc() == true) goto L6;
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardWithTemplate fallback to online behavior, im experiment disabled");
        super.n3(r20, r21);
        return;
    L6:
        int r1 = OfficeForwardTemplateAdapter.a;
        Intrinsics.checkNotNullParameter(r21, "template");
        ForwardFeature r2 = r21.c;
        ForwardTemplateNew.a r3 = new ForwardTemplateNew.a();
        r3.g = 3;
        TextForwardContent.a r4 = new TextForwardContent.a();
        Bundle r5 = r21.g;
        if (r5 == null) goto L9;
        String r6 = r5.getString("share_url");
    L10:
        String r7 = "";
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        Intrinsics.checkNotNullParameter(r6, "content");
        r4.a = r6;
        r3.f = r4.a();
        ForwardSelectConfig.a r8 = new ForwardSelectConfig.a();
        boolean r9 = r2.d;
        r8.b = !r9;
        r8.a = r9;
        r8.c = r2.e;
        ForwardSelectConfig r10 = r8.a();
        Intrinsics.checkNotNullParameter(r10, "forwardSelectConfig");
        r3.b = r10;
        ForwardTargetConfig.a r11 = new ForwardTargetConfig.a();
        r11.a = r21.c.k;
        IncludeConfig r12 = new IncludeConfig();
        BusinessRecentVisitIncludeConfig r13 = r21.a;
        if (r13 == null) goto L16;
        List r14 = r13.a;
    L17:
        if (r14 != null) goto L20;
        r14 = CollectionsKt.emptyList();
    L20:
        if (r14.isEmpty() == false) goto L22;
        IncludeConfig.CREATOR.getClass();
        r12 = IncludeConfig.b.a();
        String r18 = "";
    L116:
        Intrinsics.checkNotNullParameter(r12, "includeConfig");
        r11.d = r12;
        ForwardTargetConfig r15 = r11.a();
        Intrinsics.checkNotNullParameter(r15, "forwardTargetConfig");
        r3.a = r15;
        ForwardAdditionNoteConfig.a r16 = new ForwardAdditionNoteConfig.a();
        r16.a = r2.f;
        r16.b = false;
        ForwardAdditionNoteConfig r17 = r16.a();
        Intrinsics.checkNotNullParameter(r17, "forwardAdditionNoteConfig");
        r3.d = r17;
        ForwardViewDependency r19 = r21.e;
        ForwardConfirmDialogConfig.a r22 = new ForwardConfirmDialogConfig.a();
        String r23 = r19.d;
        if (r23 != null) goto L119;
        r23 = r18;
    L119:
        Intrinsics.checkNotNullParameter(r23, "titleBarText");
        r22.a = r23;
        String r24 = r19.g;
        if (r24 != null) goto L122;
        r24 = r18;
    L122:
        Intrinsics.checkNotNullParameter(r24, "confirmButtonText");
        r22.b = r24;
        String r25 = r19.h;
        if (r25 != null) goto L125;
        r25 = r18;
    L125:
        Intrinsics.checkNotNullParameter(r25, "cancelButtonText");
        r22.c = r25;
        BasicDialogContent r26 = r19.e;
        BasicDialogContentConfig.a r110 = new BasicDialogContentConfig.a();
        if (r26 == null) goto L128;
        String r111 = r26.a;
    L129:
        if (r111 != null) goto L131;
        r111 = r18;
    L131:
        Intrinsics.checkNotNullParameter(r111, "label");
        r110.a = r111;
        if (r26 == null) goto L134;
        String r112 = r26.b;
    L135:
        if (r112 != null) goto L137;
        r112 = r18;
    L137:
        Intrinsics.checkNotNullParameter(r112, "title");
        r110.b = r112;
        if (r26 == null) goto L140;
        String r113 = r26.c;
    L141:
        if (r113 != null) goto L143;
        r113 = r18;
    L143:
        Intrinsics.checkNotNullParameter(r113, "content");
        r110.c = r113;
        if (r26 == null) goto L146;
        String r27 = r26.d;
    L147:
        if (r27 != null) goto L149;
        r27 = r18;
    L149:
        Intrinsics.checkNotNullParameter(r27, "description");
        r110.d = r27;
        if (r26 == null) goto L152;
        int r28 = r26.i;
    L153:
        r110.e = r28;
        if (r26 == null) goto L156;
        boolean r29 = r26.j;
    L157:
        r110.j = r29;
        if (r26 == null) goto L160;
        boolean r30 = r26.k;
    L161:
        r110.k = r30;
        if (r26 == null) goto L164;
        Image r31 = r26.f;
    L165:
        if (r31 == null) goto L168;
        Image r32 = r26.f;
        r110.f = 0;
        r110.g = r32;
        r110.h = null;
        r110.i = null;
    L193:
        r22.d = r110.a();
        OfficeForwardTemplateAdapter.OfficeV2CustomConfirmView r33 = new OfficeForwardTemplateAdapter.OfficeV2CustomConfirmView(r21, r19.e);
        Intrinsics.checkNotNullParameter(r33, "listener");
        r22.e = r33;
        ForwardConfirmDialogConfig r34 = r22.a();
        Intrinsics.checkNotNullParameter(r34, "forwardConfirmDialogConfig");
        r3.e = r34;
        ForwardCommonConfig.a r35 = new ForwardCommonConfig.a();
        String r0 = r21.e.b;
        if (r0 != null) goto L196;
        String r36 = r18;
    L197:
        Intrinsics.checkNotNullParameter(r36, "titleBarText");
        r35.d = r36;
        r2.a();
        r35.c = false;
        r35.b = r2.c;
        r35.f = new OfficeForwardTemplateAdapter.OfficeV2ForwardContentAdapter();
        ForwardCommonConfig r37 = r35.a();
        Intrinsics.checkNotNullParameter(r37, "forwardCommonConfig");
        r3.c = r37;
        ForwardTemplateNew r38 = r3.a();
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardWithTemplate by DoubaoForwardLauncher");
        com.suite.lark.platform.feature.forward.doubao.u.a(r20, r38, 0, null, 12);
        return;
    L196:
        r36 = r0;
        goto L197
    L168:
        if (r26 == null) goto L170;
        Image r114 = r26.g;
    L171:
        if (r114 == null) goto L173;
        Image r39 = r26.g;
        r110.f = 0;
        r110.g = null;
        r110.h = r39;
        r110.i = null;
        goto L193
    L173:
        if (r26 == null) goto L175;
        StickImage r40 = r26.h;
    L176:
        if (r40 == null) goto L185;
        StickImage r41 = r26.h;
        if (r41 == null) goto L183;
        com.ss.android.lark.forwardv3.configuration.dto.StickImage r42 = new com.ss.android.lark.forwardv3.configuration.dto.StickImage();
        String r115 = r41.getKey();
        if (r115 != null) goto L182;
        r115 = r18;
    L182:
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r42.a = r115;
        r42.b = r41.getWidth();
        r42.c = r41.getHeight();
    L184:
        r110.f = 0;
        r110.g = null;
        r110.h = null;
        r110.i = r42;
        goto L193
    L183:
        r42 = null;
        goto L184
    L185:
        if (r26 == null) goto L187;
        int r43 = r26.e;
    L188:
        if (r43 == 0) goto L193;
        if (r26 == null) goto L191;
        int r44 = r26.e;
    L192:
        r110.f = r44;
        r110.g = null;
        r110.h = null;
        r110.i = null;
        goto L193
    L191:
        r44 = 0;
        goto L192
    L187:
        r43 = 0;
        goto L188
    L175:
        r40 = null;
        goto L176
    L170:
        r114 = null;
        goto L171
    L164:
        r31 = null;
        goto L165
    L160:
        r30 = false;
        goto L161
    L156:
        r29 = false;
        goto L157
    L152:
        r28 = 0;
        goto L153
    L146:
        r27 = null;
        goto L147
    L140:
        r113 = null;
        goto L141
    L134:
        r112 = null;
        goto L135
    L128:
        r111 = null;
        goto L129
    L22:
        Iterator r45 = r14.iterator();
    L24:
        if (r45.hasNext() == false) goto L113;
        com.ss.android.lark.forwardv2.dto.template.config.EntityItem r116 = (com.ss.android.lark.forwardv2.dto.template.config.EntityItem) r45.next();
        UserConfig r117 = r116.a;
        int r118 = OfficeForwardTemplateAdapter.a;
        if (r117 == null) goto L49;
        EntityItem.a r119 = new EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r46 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r46.b(OfficeForwardTemplateAdapter.a(r117.getTenantCondition()));
        Condition$UserTypeCondition r120 = r117.getUserTypeCondition();
        if (r120 != null) goto L30;
        int r121 = -1;
    L31:
        if (r121 != 1) goto L33;
        Condition$UserType r122 = Condition$UserType.SELF;
    L37:
        Intrinsics.checkNotNullParameter(r122, "userType");
        r46.b = r122;
        Condition$ShieldTypeCondition r123 = r117.getShieldTypeCondition();
        if (r123 != null) goto L40;
        int r124 = -1;
    L42:
        if (r124 != 1) goto L44;
        Condition$Shield r125 = Condition$Shield.NORMAL;
    L48:
        Intrinsics.checkNotNullParameter(r125, "shield");
        r46.c = r125;
        r119.f(r46.a());
        r12.a(r119.c());
        goto L49
    L44:
        if (r124 == 2) goto L46;
        r125 = Condition$Shield.ALL;
        goto L48
    L46:
        r125 = Condition$Shield.SHIELD;
        goto L48
    L40:
        r124 = OfficeForwardTemplateAdapter.a.e[r123.ordinal()];
        goto L42
    L33:
        if (r121 == 2) goto L35;
        r122 = Condition$UserType.ALL;
        goto L37
    L35:
        r122 = Condition$UserType.OTHERS;
        goto L37
    L30:
        r121 = OfficeForwardTemplateAdapter.a.b[r120.ordinal()];
    L49:
        GroupChatConfig r47 = r116.b;
        if (r47 == null) goto L84;
        EntityItem.a r126 = new EntityItem.a();
        GroupConfig.a r127 = new GroupConfig.a();
        r127.b(OfficeForwardTemplateAdapter.a(r47.getTenantCondition()));
        Condition$GroupChatTypeCondition r128 = r47.getGroupChatTypeCondition();
        if (r128 != null) goto L54;
        int r48 = 1;
        int r129 = -1;
    L55:
        if (r129 != r48) goto L57;
        Condition$GroupType r49 = Condition$GroupType.NORMAL;
    L61:
        Intrinsics.checkNotNullParameter(r49, "groupType");
        r127.b = r49;
        Condition$PublicTypeCondition r50 = r47.getPublicTypeCondition();
        if (r50 != null) goto L64;
        int r51 = -1;
    L66:
        if (r51 != 1) goto L68;
        Condition$Status r52 = Condition$Status.PUBLIC;
    L72:
        Intrinsics.checkNotNullParameter(r52, "status");
        r127.c = r52;
        Condition$ShieldTypeCondition r53 = r47.getShieldTypeCondition();
        if (r53 != null) goto L75;
        int r54 = -1;
    L77:
        if (r54 != 1) goto L79;
        Condition$Shield r55 = Condition$Shield.NORMAL;
    L83:
        Intrinsics.checkNotNullParameter(r55, "shield");
        r127.d = r55;
        r126.d(r127.a());
        r12.a(r126.c());
    L85:
        ThreadConfig r56 = r116.d;
        if (r56 == null) goto L110;
        EntityItem.a r57 = new EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a r130 = new com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a();
        Condition$Tenant r131 = OfficeForwardTemplateAdapter.a(r56.getTenantCondition());
        Intrinsics.checkNotNullParameter(r131, "tenant");
        r130.a = r131;
        Condition$ThreadTypeCondition r132 = r56.getThreadTypeCondition();
        if (r132 != null) goto L90;
        int r133 = -1;
    L92:
        if (r133 != 1) goto L94;
        Condition$ThreadType r134 = Condition$ThreadType.NORMAL_THREAD;
    L98:
        r130.b(r134);
        Condition$PublicTypeCondition r58 = r56.getPublicTypeCondition();
        if (r58 != null) goto L101;
        int r59 = 1;
        int r135 = -1;
    L102:
        if (r135 != r59) goto L104;
        Condition$Status r60 = Condition$Status.PUBLIC;
    L108:
        Intrinsics.checkNotNullParameter(r60, "status");
        r130.c = r60;
        r57.e(r130.a());
        r12.a(r57.c());
        goto L110
    L104:
        if (r135 == 2) goto L106;
        r60 = Condition$Status.ALL;
        goto L108
    L106:
        r60 = Condition$Status.PRIVATE;
        goto L108
    L101:
        r135 = OfficeForwardTemplateAdapter.a.d[r58.ordinal()];
        r59 = 1;
        goto L102
    L94:
        if (r133 == 2) goto L96;
        r134 = Condition$ThreadType.ALL;
        goto L98
    L96:
        r134 = Condition$ThreadType.MSG_THREAD;
        goto L98
    L90:
        r133 = OfficeForwardTemplateAdapter.a.f[r132.ordinal()];
    L110:
        if (r116.c == null) goto L112;
        EntityItem.a r61 = new EntityItem.a();
        r61.b(new BotConfig());
        r12.a(r61.c());
    L112:
        r7 = r7;
        goto L24
    L79:
        if (r54 == 2) goto L81;
        r55 = Condition$Shield.ALL;
        goto L83
    L81:
        r55 = Condition$Shield.SHIELD;
        goto L83
    L75:
        r54 = OfficeForwardTemplateAdapter.a.e[r53.ordinal()];
        goto L77
    L68:
        if (r51 == 2) goto L70;
        r52 = Condition$Status.ALL;
        goto L72
    L70:
        r52 = Condition$Status.PRIVATE;
        goto L72
    L64:
        r51 = OfficeForwardTemplateAdapter.a.d[r50.ordinal()];
        goto L66
    L57:
        if (r129 == 2) goto L59;
        r49 = Condition$GroupType.ALL;
        goto L61
    L59:
        r49 = Condition$GroupType.THREAD;
        goto L61
    L54:
        r129 = OfficeForwardTemplateAdapter.a.c[r128.ordinal()];
        r48 = 1;
        goto L55
    L84:
        r7 = r7;
        goto L85
    L113:
        r18 = r7;
        if (((ArrayList) r12.a).isEmpty() == false) goto L116;
        IncludeConfig.CREATOR.getClass();
        r12 = IncludeConfig.b.a();
        goto L116
    L16:
        r14 = null;
        goto L17
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.ss.android.lark.integrator.ccm.dependency.di.i0
    public final void bd(Context r8, DocShareTextData r9, int r10) {
        if (Qc() == true) goto L6;
        tt5.a.h("OfficeMessagingDependencyImpl", "forwardText fallback to online behavior, im experiment disabled");
        CCMForward.b(r8, r9, r10);
        return;
    L6:
        if (r8 == null) goto L27;
        if (r9 == null) goto L27;
        ForwardTemplateNew.a r0 = new ForwardTemplateNew.a();
        r0.g = 3;
        TextForwardContent.a r2 = new TextForwardContent.a();
        String r3 = r9.getContent();
        String r4 = "";
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        Intrinsics.checkNotNullParameter(r3, "content");
        r2.a = r3;
        r2.b = r9.isLocalShare();
        String r5 = r9.getSourceName();
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        Intrinsics.checkNotNullParameter(r5, "sourceName");
        r2.c = r5;
        r0.f = r2.a();
        ForwardConfirmDialogConfig.a r6 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r7 = new BasicDialogContentConfig.a();
        String r11 = r9.getContent();
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        Intrinsics.checkNotNullParameter(r11, "content");
        r7.c = r11;
        String r12 = r9.getTitle();
        if (r12 == null) goto L22;
        r4 = r12;
    L22:
        Intrinsics.checkNotNullParameter(r4, "title");
        r7.b = r4;
        r6.d = r7.a();
        ForwardConfirmDialogConfig r13 = r6.a();
        Intrinsics.checkNotNullParameter(r13, "forwardConfirmDialogConfig");
        r0.e = r13;
        ForwardAdditionNoteConfig.a r14 = new ForwardAdditionNoteConfig.a();
        r14.a = r9.isCanAddExtraInfo();
        ForwardAdditionNoteConfig r15 = r14.a();
        Intrinsics.checkNotNullParameter(r15, "forwardAdditionNoteConfig");
        r0.d = r15;
        ForwardCommonConfig.a r16 = new ForwardCommonConfig.a();
        r16.f = new OfficeCcmOnForwardContentListener();
        ForwardCommonConfig r17 = r16.a();
        Intrinsics.checkNotNullParameter(r17, "forwardCommonConfig");
        r0.c = r17;
        ForwardTemplateNew r1 = r0.a();
        a(r1);
        StringBuilder r18 = new StringBuilder("forwardText by DoubaoForwardLauncher, contentLen=");
        String r19 = r9.getContent();
        if (r19 == null) goto L25;
        int r20 = r19.length();
    L26:
        r18.append(r20);
        tt5.a.h("OfficeMessagingDependencyImpl", r18.toString());
        com.suite.lark.platform.feature.forward.doubao.u.a(r8, r1, r10, null, 8);
        return;
    L25:
        r20 = 0;
    L27:
        tt5.a.k("OfficeMessagingDependencyImpl", "forwardText ignored, context or data is null");
    }
}
