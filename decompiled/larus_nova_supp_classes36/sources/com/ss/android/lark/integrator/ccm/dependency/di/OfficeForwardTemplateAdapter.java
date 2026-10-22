package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$GroupChatTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$PublicTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ShieldTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$TenantCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ThreadTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$UserTypeCondition;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeForwardTemplateAdapter {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u000e\u0010(\u001a\u00020)*\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/OfficeForwardTemplateAdapter$OfficeV2CustomConfirmView;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "template", "Lcom/ss/android/lark/forwardv2/dto/ForwardTemplate;", "fallbackContent", "Lcom/ss/android/lark/forwardv2/dto/template/BasicDialogContent;", "<init>", "(Lcom/ss/android/lark/forwardv2/dto/ForwardTemplate;Lcom/ss/android/lark/forwardv2/dto/template/BasicDialogContent;)V", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "enhancedView", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView;", "setUpForwardMessage", "", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "interceptCustomForwardContent", "", "setupCustomForwardContentView", "activity", "Landroid/app/Activity;", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "imageLoader", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView$ImageLoader;", "onViewClick", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toV2ImageLoader", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ImageLoader;", "CREATOR", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OfficeV2CustomConfirmView implements OnCustomForwardConfirmDialogContentView {
        public static final a CREATOR = null;
        public final ForwardTemplate a;
        public final BasicDialogContent b;
        public final ForwardClickableEnhancedView c;

        public static final class a implements Parcelable.Creator<OfficeV2CustomConfirmView> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeV2CustomConfirmView createFromParcel(Parcel r4) {
                Intrinsics.checkNotNullParameter(r4, "parcel");
                Parcelable r1 = r4.readParcelable(OfficeV2CustomConfirmView.class.getClassLoader());
                if (r1 == null) goto L7;
                return new OfficeV2CustomConfirmView((ForwardTemplate) r1, (BasicDialogContent) r4.readParcelable(OfficeV2CustomConfirmView.class.getClassLoader()));
            L7:
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeV2CustomConfirmView[] newArray(int r1) {
                return new OfficeV2CustomConfirmView[r1];
            }
        }

        public static final class b implements ForwardClickableEnhancedView.a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView.a
            public final void a(boolean r1) {
            }
        }

        public static final class c implements ForwardClickableEnhancedView.b {
            public final /* synthetic */ OfficeV2CustomConfirmView a;

            public c(OfficeV2CustomConfirmView r1) {
                this.a = r1;
            }

            @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView.b
            public final void a(String r3) {
                OfficeV2CustomConfirmView r0 = this.a;
                a r1 = OfficeV2CustomConfirmView.CREATOR;
                r0.a().putString("COMMENT_CHECK", r3);
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void U0() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final Bundle a() {
            Bundle r0 = this.a.g;
            if (r0 != null) goto L6;
            Bundle r1 = new Bundle();
            this.a.g = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final boolean n1() {
            if (this.c == null) goto L5;
            return true;
        L5:
            return false;
        }

        public OfficeV2CustomConfirmView(ForwardTemplate r2, BasicDialogContent r3) {
            Intrinsics.checkNotNullParameter(r2, "template");
            this.a = r2;
            this.b = r3;
            ForwardViewDependency r4 = r2.e;
            ForwardClickableEnhancedView r5 = null;
            if (r4 == null) goto L5;
            ForwardEnhancedView r6 = r4.f;
        L7:
            if ((r6 instanceof ForwardClickableEnhancedView) == false) goto L9;
            r5 = (ForwardClickableEnhancedView) r6;
        L9:
            this.c = r5;
            return;
        L5:
            r6 = null;
            goto L7
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            r2.writeParcelable(this.a, r3);
            r2.writeParcelable(this.b, r3);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void p(Activity r2, Fragment r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "fragment");
            Intrinsics.checkNotNullParameter(r4, "view");
            ForwardClickableEnhancedView r5 = this.c;
            if (r5 == null) goto L6;
            CollectionsKt.emptyList();
            a();
            r5.s0(r3);
            return;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView
        public final void E1(Activity r3, ConstraintLayout r4, BasicDialogContentConfig r5, OnCustomForwardConfirmDialogContentView.a r6) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r4, "contentParent");
            Intrinsics.checkNotNullParameter(r5, "content");
            ForwardClickableEnhancedView r7 = this.c;
            if (r7 != null) goto L5;
            return;
        L5:
            b r8 = b.a;
            c r0 = new c(this);
            a();
            r7.l(r8, r0);
            CollectionsKt.emptyList();
            a();
            BasicDialogContent r9 = this.b;
            if (r9 != null) goto L8;
            r9 = new BasicDialogContent();
            r9.a = null;
            r9.b = null;
            r9.c = null;
            r9.d = null;
            r9.e = 0;
            r9.g = null;
            r9.f = null;
            r9.h = null;
            r9.i = 0;
            r9.j = false;
            r9.k = false;
        L8:
            r7.f(r3, r4, r9);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/OfficeForwardTemplateAdapter$OfficeV2ForwardContentAdapter;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "<init>", "()V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "CREATOR", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OfficeV2ForwardContentAdapter implements OnForwardContentListener {
        public static final a CREATOR = null;

        public static final class a implements Parcelable.Creator<OfficeV2ForwardContentAdapter> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeV2ForwardContentAdapter createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                return new OfficeV2ForwardContentAdapter();
            }

            @Override // android.os.Parcelable.Creator
            public final OfficeV2ForwardContentAdapter[] newArray(int r1) {
                return new OfficeV2ForwardContentAdapter[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public OfficeV2ForwardContentAdapter() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r1, Map<String, ? extends ForwardTargetBaseInfoNew> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r3) {
            tt5.a.d("LarkAppKoinModule", "Office V2 forward failed, title=null, message=" + r3);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;
        public static final /* synthetic */ int[] f = null;

        static {
            int[] r0 = new int[Condition$TenantCondition.values().length];
            r0[Condition$TenantCondition.NOT_CROSS_TENANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[Condition$TenantCondition.CROSS_TENANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L6:
            a = r0;
            int[] r1 = new int[Condition$UserTypeCondition.values().length];
            r1[Condition$UserTypeCondition.SELF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L55:
            r1[Condition$UserTypeCondition.OTHERS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L9:
            b = r1;
            int[] r2 = new int[Condition$GroupChatTypeCondition.values().length];
            r2[Condition$GroupChatTypeCondition.DEFAULT_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L45:
            r2[Condition$GroupChatTypeCondition.THREAD_CHAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L12:
            c = r2;
            int[] r3 = new int[Condition$PublicTypeCondition.values().length];
            r3[Condition$PublicTypeCondition.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L47:
            r3[Condition$PublicTypeCondition.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L15:
            d = r3;
            int[] r4 = new int[Condition$ShieldTypeCondition.values().length];
            r4[Condition$ShieldTypeCondition.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L37:
            r4[Condition$ShieldTypeCondition.SHIELD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L18:
            e = r4;
            int[] r5 = new int[Condition$ThreadTypeCondition.values().length];
            r5[Condition$ThreadTypeCondition.CHAT_THREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L51:
            r5[Condition$ThreadTypeCondition.MSG_THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L21:
            f = r5;
        }
    }

    static {
    }

    public static Condition$Tenant a(Condition$TenantCondition r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L6:
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L14;
        return Condition$Tenant.ALL;
    L14:
        return Condition$Tenant.CROSS_TENANT;
    L12:
        return Condition$Tenant.NOT_CROSS_TENANT;
    L4:
        r2 = a.a[r1.ordinal()];
        goto L6
    }
}
