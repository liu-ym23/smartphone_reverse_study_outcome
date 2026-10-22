package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusCreationOperateContainerLayoutBinding;
import com.larus.utils.logger.FLogger;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/view/CreationOperateContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/view/ICreationStatusChange;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isByPublisher", "", "setByPublisher", "", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusCreationOperateContainerLayoutBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusCreationOperateContainerLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "enableCreationOperator", "enable", "refreshCreationButtonStatus", "status", "ButtonStatus", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationOperateContainerView extends ConstraintLayout implements e2 {
    public static final /* synthetic */ int c = 0;
    public boolean a;
    public final Lazy b;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/view/CreationOperateContainerView$ButtonStatus;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStatus {
        public static final int AddedPrivate = 2;
        public static final int AddedPublic = 3;
        public static final a Companion = null;
        public static final int Disable = 0;
        public static final int UnAdd = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public CreationOperateContainerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationOperateContainerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final LarusCreationOperateContainerLayoutBinding getBinding() {
        return (LarusCreationOperateContainerLayoutBinding) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.e2
    public final void r1(int r4) {
        if (AppHost.a.isOversea() == false) goto L7;
        setVisibility(8);
        return;
    L7:
        if (r4 != 1) goto L9;
    L39:
        ConstraintLayout r5 = getBinding().c;
        if (r5 == null) goto L42;
        r5.setVisibility(4);
    L42:
        Button r6 = getBinding().b;
        if (r6 == null) goto L45;
        r6.setVisibility(4);
    L45:
        ConstraintLayout r7 = getBinding().e;
        if (r7 == null) goto L49;
        com.larus.utils.e1.x(r7);
    L49:
        if (this.a == false) goto L51;
        getBinding().g.setText(getContext().getText(2131906327));
        com.larus.utils.e1.o(getBinding().f);
        return;
    L51:
        getBinding().g.setText(2131901168);
        com.larus.utils.e1.x(getBinding().f);
        return;
    L9:
        if (r4 == 2) goto L39;
        if (r4 == 3) goto L21;
        ConstraintLayout r8 = getBinding().c;
        if (r8 == null) goto L15;
        r8.setVisibility(8);
    L15:
        Button r9 = getBinding().b;
        if (r9 == null) goto L18;
        r9.setVisibility(8);
    L18:
        ConstraintLayout r10 = getBinding().e;
        if (r10 == null) goto L53;
        r10.setVisibility(8);
        return;
    L53:
        return;
    L21:
        ConstraintLayout r11 = getBinding().c;
        if (r11 == null) goto L24;
        com.larus.utils.e1.x(r11);
    L24:
        AppCompatTextView r12 = getBinding().d;
        if (r12 == null) goto L33;
        Context r0 = getContext();
        if (r0 == null) goto L31;
        String r1 = r0.getString(2131900630);
        if (r1 == null) goto L31;
    L32:
        r12.setText(r1);
    L31:
        r1 = "";
    L33:
        Button r13 = getBinding().b;
        if (r13 == null) goto L36;
        r13.setVisibility(4);
    L36:
        ConstraintLayout r14 = getBinding().e;
        if (r14 == null) goto L55;
        r14.setVisibility(4);
        return;
    }

    @Override // com.larus.bmhome.view.e2
    public void setByPublisher(boolean r4) {
        this.a = r4;
        FLogger.a.d("CreationOperateContainerView", "isByPublisher: " + r4);
    }

    public CreationOperateContainerView(final Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.b = LazyKt.lazy(new y1(r5, this));
        com.larus.utils.w0.e(getBinding().b, j19.c.c(12));
        com.larus.utils.w0.e(getBinding().e, j19.c.c(12));
        getBinding().b.setBackground(com.larus.utils.w0.b(Integer.valueOf(r5.getResources().getColor(2131103298)), null, 0.2f, null, 8));
        getBinding().e.setBackground(com.larus.utils.w0.b(Integer.valueOf(r5.getResources().getColor(2131103298)), null, 0.2f, null, 8));
    }

    public /* synthetic */ CreationOperateContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
