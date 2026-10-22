package com.ss.android.lark.forwardv2.sharefile;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.forwardv2.impl.view.e;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001EB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J6\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u001b\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016JJ\u0010\u001c\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010#\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J6\u0010$\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010'\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J@\u0010(\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J&\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010\u0015H\u0016J>\u00101\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u00100\u001a\u0004\u0018\u00010\u00152\b\u00105\u001a\u0004\u0018\u000106H\u0016JJ\u00107\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\"\u0010<\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J6\u0010=\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010>\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\fH\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J \u0010D\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006F"}, d2 = {"Lcom/ss/android/lark/forwardv2/sharefile/FileShareEnhancedView;", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getUri", "()Landroid/net/Uri;", "writeToParcel", "", "flags", "", "onInterceptForwardDialog", "", "targetList", "", "Lcom/ss/android/lark/forwardv2/dto/ForwardTarget;", "extra", "Landroid/os/Bundle;", "showForwardDialog", "activity", "Landroid/app/Activity;", "handler", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardEnhancedView$ExecuteHandler;", "onInterceptBasicDialogDataRender", "interceptBasicDialogDataRender", "thumbnailIV", "Lpl/droidsonroids/gif/GifImageView;", "titleTV", "Landroid/widget/TextView;", "contentTV", "descTV", "onInterceptBasicDialogView", "interceptBasicDialogView", "contentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onInterceptForward", "interceptForward", "forwardTemplate", "Lcom/ss/android/lark/forwardv2/dto/ForwardTemplate;", "init", "controller", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$DialogController;", "dataDependency", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ForwardCustomDataDependency;", "extraParam", "onViewClicked", "sourceFragment", "Landroidx/fragment/app/Fragment;", "uncertainTargetList", "view", "Landroid/view/View;", "interceptBasicDialogViewWithContent", "viewContent", "Lcom/ss/android/lark/forwardv2/dto/template/BasicDialogContent;", "imageLoader", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ImageLoader;", "onInterceptBottomCustomView", "interceptBottomCustomView", "onAdditionNoteChanged", "afterAdditionNoteChange", "note", "Landroid/text/Editable;", "onDestroy", "describeContents", "bindPreviewFile", "CREATOR", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FileShareEnhancedView implements ForwardClickableEnhancedView {
    public static final a CREATOR = null;
    public final Uri a;

    public static final class a implements Parcelable.Creator<FileShareEnhancedView> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FileShareEnhancedView createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new FileShareEnhancedView(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final FileShareEnhancedView[] newArray(int r1) {
            return new FileShareEnhancedView[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final boolean A() {
        return true;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final boolean D1(List r1) {
        return false;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void V(GifImageView r1, TextView r2, TextView r3, Bundle r4) {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void d0(e r1) {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final boolean e0() {
        return false;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void k1(Editable r1) {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void l(ForwardClickableEnhancedView.a r1, ForwardClickableEnhancedView.b r2) {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final boolean n0() {
        return false;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void onDestroy() {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void q0() {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void t1(Activity r1, ConstraintLayout r2) {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final boolean y() {
        return false;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void y1() {
    }

    public FileShareEnhancedView(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this.a = (Uri) r2.readParcelable(FileShareEnhancedView.class.getClassLoader());
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void s0(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "sourceFragment");
        if (this.a != null) goto L6;
        Log.e("FileShareEnhancedView", "uri is null");
        return;
    L6:
        RxScheduledExecutor.execInIO(new com.ss.android.lark.forwardv2.sharefile.a(this), b.a, c.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.a, r3);
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void f(Activity r18, ConstraintLayout r19, BasicDialogContent r20) {
        if (r18 == null) goto L28;
        if (r19 == null) goto L28;
        if (r20 == null) goto L28;
        r18.getLayoutInflater().inflate(2131568157, r19);
        r19.setBackgroundResource(2131235492);
        GifImageView r2 = r19.findViewById(2131374718);
        TextView r3 = (TextView) r19.findViewById(2131367668);
        TextView r4 = (TextView) r19.findViewById(2131367666);
        TextView r0 = (TextView) r19.findViewById(2131367667);
        String r5 = r20.b;
        String r6 = "";
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        String r7 = r20.d;
        if (r7 == null) goto L14;
        r6 = r7;
    L14:
        int r1 = r20.e;
        if (r1 == (-1)) goto L17;
        r2.setImageResource(r1);
        r2.setVisibility(0);
    L17:
        r3.setText(r5);
        r3.setVisibility(0);
        r3.setMaxLines(2);
        r4.setVisibility(0);
        r0.setVisibility(0);
        r0.setText(r6);
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ((ViewGroup.MarginLayoutParams) r8).leftMargin = 0;
    L20:
        r0.setPadding(0, UIHelper.dp2px(4.0f), UIHelper.dp2px(0.0f), 0);
        ConstraintSet r9 = new ConstraintSet();
        ConstraintLayout r10 = r3.getParent();
        if ((r10 instanceof ConstraintLayout) == false) goto L23;
        ConstraintLayout r11 = r10;
    L24:
        if (r11 == null) goto L30;
        r9.clone(r11);
        r9.connect(r3.getId(), 4, r4.getId(), 3);
        r9.connect(r0.getId(), 3, r4.getId(), 4);
        r9.createVerticalChain(0, 3, 0, 4, new int[]{r3.getId(), r0.getId()}, new float[]{0.0f, 0.0f}, 2);
        r9.applyTo(r11);
        return;
    L30:
        return;
    L23:
        r11 = null;
    L28:
        Log.e("FileShareEnhancedView", "activity is null or contentParent is null or viewContent is null");
    }
}
