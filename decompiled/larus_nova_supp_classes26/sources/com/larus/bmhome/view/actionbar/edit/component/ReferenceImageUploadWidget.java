package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.instruction.impl.databinding.LarusItemActionbarMultiReferenceImageBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0014J\b\u0010)\u001a\u00020\u001cH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001e\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u001cH\u0002J \u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u0001032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c05H\u0002J\u0006\u0010@\u001a\u00020\u001cJ\u0006\u0010A\u001a\u00020\u001cJ\u000e\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020!J\b\u0010D\u001a\u000207H\u0002J\b\u0010E\u001a\u000209H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u0001078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/ReferenceImageUploadWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusItemActionbarMultiReferenceImageBinding;", "referenceImageCallback", "Lcom/larus/bmhome/view/actionbar/edit/component/ReferenceImageCallback;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/ReferenceImageUploadController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/ReferenceImageUploadController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarImageUploadButton;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarImageUploadButton;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "getPickLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "pickSDKLauncher", "Landroid/content/Intent;", "getPickSDKLauncher", "currentUploadFileIdentifier", "bindPickPictureResult", "", "uri", "Landroid/net/Uri;", "reportUploadImageEvent", "duration", "", "isSuccess", "", "init", "attrs", "Landroid/util/AttributeSet;", "onBindView", "onDetachedFromWindow", "refreshUi", "tryReferenceImageUpload", "Lkotlinx/coroutines/Job;", "uploadAttachment", "uploaderIdentifier", "localPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSystemAlbum", "checkRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "doNext", "Lkotlin/Function0;", "imageMaskView", "Landroid/view/View;", "imageProgressView", "Lcom/larus/common_ui/widget/CircleProgressBarView;", "progressView", "getProgressView", "()Lcom/larus/common_ui/widget/CircleProgressBarView;", "maskView", "getMaskView", "()Landroid/view/View;", "hideLoading", "showLoading", "setProgress", "progress", "provideMaskView", "provideProgressView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceImageUploadWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int k = 0;
    public LarusItemActionbarMultiReferenceImageBinding f;
    public volatile v1 g;
    public String h;
    public View i;
    public CircleProgressBarView j;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        LarusItemActionbarMultiReferenceImageBinding r1 = this.f;
        LarusItemActionbarMultiReferenceImageBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        com.larus.utils.e1.d(r1.g, new a2(this));
        LarusItemActionbarMultiReferenceImageBinding r3 = this.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        com.larus.utils.e1.d(r3.d, new b2(this));
        LarusItemActionbarMultiReferenceImageBinding r4 = this.f;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        com.larus.utils.e1.d(r4.b, new c2(this));
        LarusItemActionbarMultiReferenceImageBinding r5 = this.f;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        CardView r6 = r5.f;
        FrameLayout r7 = new FrameLayout(getContext());
        r7.setLayoutParams(new FrameLayout.LayoutParams(i5.E(), i5.E()));
        r7.setBackgroundColor(ContextCompat.getColor(r7.getContext(), 2131103293));
        com.larus.utils.e1.o(r7);
        this.i = r7;
        r6.addView(r7);
        View r8 = new CircleProgressBarView(getContext(), null, 6, 0);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        r8.setLayoutParams(r9);
        r8.a(6.0f, 1.5f);
        com.larus.utils.e1.o(r8);
        this.j = r8;
        r6.addView(r8);
        LarusItemActionbarMultiReferenceImageBinding r10 = this.f;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L17:
        TextView r11 = r10.e;
        wa8.u r12 = getCurrentBindData();
        if (r12 == null) goto L22;
        wa8.b r13 = r12.a;
        if (r13 == null) goto L22;
        String r14 = r13.b;
    L23:
        r11.setText(r14);
        LarusItemActionbarMultiReferenceImageBinding r15 = this.f;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L26:
        AppCompatTextView r16 = r15.i;
        wa8.u r17 = getCurrentBindData();
        if (r17 == null) goto L31;
        wa8.b r18 = r17.a;
        if (r18 == null) goto L31;
        String r19 = r18.a;
    L32:
        r16.setText(r19);
        wa8.u r20 = getCurrentBindData();
        if (r20 == null) goto L37;
        wa8.p r21 = r20.b;
        if (r21 == null) goto L37;
        String r22 = r21.b;
    L39:
        if (com.larus.utils.o0.d(r22) == false) goto L90;
        LarusItemActionbarMultiReferenceImageBinding r23 = this.f;
        if (r23 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L43:
        com.larus.utils.e1.o(r23.d);
        LarusItemActionbarMultiReferenceImageBinding r24 = this.f;
        if (r24 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L46:
        com.larus.utils.e1.x(r24.c);
        wa8.u r25 = getCurrentBindData();
        if (r25 == null) goto L64;
        wa8.p r26 = r25.b;
        if (r26 == null) goto L64;
        String r27 = r26.b;
        if (r27 == null) goto L64;
        if (com.larus.utils.y0.e(r27) == false) goto L55;
        Uri r28 = com.larus.image.loader.b0.a(r27, "instruction_reference_image", false, false, 6);
    L65:
        LarusItemActionbarMultiReferenceImageBinding r29 = this.f;
        if (r29 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L68:
        ImageLoaderKt.s(r29.h, r28, null);
        com.larus.bmhome.view.actionbar.edit.c r30 = getViewModel();
        if (r30 == null) goto L99;
        wa8.u r31 = getCurrentBindData();
        if (r31 == null) goto L78;
        wa8.p r32 = r31.b;
        if (r32 == null) goto L78;
        String r33 = r32.a;
        if (r33 == null) goto L78;
        String r34 = r33;
    L79:
        wa8.u r35 = getCurrentBindData();
        if (r35 == null) goto L87;
        wa8.p r36 = r35.b;
        if (r36 == null) goto L87;
        String r37 = r36.b;
        if (r37 == null) goto L87;
        String r210 = r37;
    L88:
        r30.onInstructionReferenceImageChanged(new AttachmentInfo(true, r34, null, null, r210, "", "album", null, null, null, null, null, null, null, null, null, null, 130956, null));
    L87:
        r210 = "";
    L78:
        r34 = "";
    L99:
        return;
    L55:
        wa8.u r38 = getCurrentBindData();
        if (r38 == null) goto L62;
        wa8.p r39 = r38.b;
        if (r39 == null) goto L62;
        String r40 = r39.b;
        if (r40 == null) goto L62;
        PolarisFileWrapper r41 = new PolarisFileWrapper(r40);
    L63:
        r28 = Uri.fromFile(r41);
    L62:
        r41 = null;
    L64:
        r28 = null;
        goto L65
    L90:
        LarusItemActionbarMultiReferenceImageBinding r42 = this.f;
        if (r42 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r42 = null;
    L93:
        com.larus.utils.e1.x(r42.d);
        LarusItemActionbarMultiReferenceImageBinding r43 = this.f;
        if (r43 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L97:
        com.larus.utils.e1.o(r2.c);
        return;
    L96:
        r2 = r43;
    L37:
        r22 = null;
    L31:
        r19 = null;
    L22:
        r14 = null;
        goto L23
    }

    private final xs8.k getController() {
        return (xs8.k) getController();
    }

    private final wa8.u getCurrentBindData() {
        xs8.k r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    private final ActivityResultLauncher<String> getPickLauncher() {
        xs8.k r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h;
    }

    private final ActivityResultLauncher<Intent> getPickSDKLauncher() {
        xs8.k r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i;
    }

    public final void H6() {
        CircleProgressBarView r0 = getProgressView();
        if (r0 == null) goto L5;
        r0.setProgress(0);
    L5:
        CircleProgressBarView r1 = getProgressView();
        if (r1 == null) goto L8;
        com.larus.utils.e1.o(r1);
    L8:
        View r2 = getMaskView();
        if (r2 == null) goto L12;
        com.larus.utils.e1.o(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N6() {
        boolean r0 = ViewExtKt.h(this);
        com.larus.bmhome.view.actionbar.edit.c r1 = getViewModel();
        if (r1 == null) goto L8;
        CoroutineScope r2 = r1.getCurrentViewModelScope();
        if (r2 == null) goto L9;
        BuildersKt.launch$default(r2, null, null, new ReferenceImageUploadWidget$openSystemAlbum$1(this, r0, null), 3, null);
        return;
    L9:
        return;
    }

    public final void V6() {
        CircleProgressBarView r0 = getProgressView();
        if (r0 == null) goto L5;
        r0.setProgress(0);
    L5:
        CircleProgressBarView r1 = getProgressView();
        if (r1 == null) goto L8;
        com.larus.utils.e1.x(r1);
    L8:
        View r2 = getMaskView();
        if (r2 == null) goto L12;
        com.larus.utils.e1.x(r2);
        return;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.i("ReferenceImageUploadWidget", "onDetachedFromWindow  referenceImageCallback is null");
        this.g = null;
    }

    private final View getMaskView() {
        return this.i;
    }

    private final CircleProgressBarView getProgressView() {
        return this.j;
    }

    public ReferenceImageUploadWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    public static final /* synthetic */ wa8.u o6(ReferenceImageUploadWidget r0) {
        return r0.getCurrentBindData();
    }

    public static final /* synthetic */ ActivityResultLauncher s6(ReferenceImageUploadWidget r0) {
        return r0.getPickLauncher();
    }

    public static final /* synthetic */ ActivityResultLauncher u6(ReferenceImageUploadWidget r0) {
        return r0.getPickSDKLauncher();
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void S5(Uri r8) {
        Intrinsics.checkNotNullParameter(r8, "uri");
        Fragment r0 = getFragment();
        if (r0 == null) goto L8;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L9;
        BuildersKt.launch$default(r1, Dispatchers.getMain(), null, new ReferenceImageUploadWidget$bindPickPictureResult$1(this, r8, null), 2, null);
        return;
    L9:
        return;
    }

    public final void setProgress(long r2) {
        CircleProgressBarView r0 = getProgressView();
        if (r0 == null) goto L6;
        r0.setProgress(r2);
        return;
    }

    public static Unit i6(ReferenceImageUploadWidget r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.H6();
        LarusItemActionbarMultiReferenceImageBinding r4 = r2.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        com.larus.utils.e1.x(r4.d);
        LarusItemActionbarMultiReferenceImageBinding r5 = r2.f;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L8:
        com.larus.utils.e1.o(r5.c);
        wa8.u r6 = r2.getCurrentBindData();
        if (r6 == null) goto L13;
        wa8.p r7 = r6.b;
        if (r7 == null) goto L13;
        r7.a = null;
    L13:
        wa8.u r8 = r2.getCurrentBindData();
        if (r8 == null) goto L18;
        wa8.p r9 = r8.b;
        if (r9 == null) goto L18;
        r9.b = null;
    L18:
        com.larus.bmhome.view.actionbar.edit.c r10 = r2.getViewModel();
        if (r10 == null) goto L21;
        r10.onInstructionReferenceImageUploadStatus(0);
    L21:
        com.larus.bmhome.view.actionbar.edit.c r11 = r2.getViewModel();
        if (r11 == null) goto L24;
        r11.onInstructionReferenceImageChanged(null);
    L24:
        com.larus.bmhome.view.actionbar.edit.c r12 = r2.getViewModel();
        if (r12 == null) goto L27;
        r12.onInstructionReferenceImageUploadStatus(0);
    L27:
        String r13 = r2.h;
        if (r13 == null) goto L31;
        ResourceUploader.c(r13);
    L31:
        return Unit.INSTANCE;
    }

    public static Unit k6(ReferenceImageUploadWidget r1, LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        CircleProgressBarView r3 = r1.getProgressView();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L12;
        r1.N6();
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L5:
        if (r3.getVisibility() != 0) goto L7;
        r4 = true;
        goto L8
    }

    public static Unit n6(ReferenceImageUploadWidget r1, LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        CircleProgressBarView r3 = r1.getProgressView();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        return Unit.INSTANCE;
    L11:
        if (r1.getFragment() == null) goto L14;
        r1.N6();
    L14:
        return Unit.INSTANCE;
    L5:
        if (r3.getVisibility() != 0) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        View r14 = LayoutInflater.from(r12).inflate(2131562485, this, false);
        addView(r14);
        int r15 = 2131384123;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131384123);
        if (r3 == null) goto L21;
        r15 = 2131384124;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131384124);
        if (r4 == null) goto L21;
        r15 = 2131384126;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131384126);
        if (r5 == null) goto L21;
        r15 = 2131384128;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r14, 2131384128);
        if (r6 == null) goto L21;
        r15 = 2131384129;
        CardView r7 = ViewBindings.findChildViewById(r14, 2131384129);
        if (r7 == null) goto L21;
        r15 = 2131384130;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131384130);
        if (r8 == null) goto L21;
        r15 = 2131384131;
        SimpleDraweeView r9 = ViewBindings.findChildViewById(r14, 2131384131);
        if (r9 == null) goto L21;
        r15 = 2131391264;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r14, 2131391264);
        if (r10 == null) goto L21;
        this.f = new LarusItemActionbarMultiReferenceImageBinding((LinearLayout) r14, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public static final void C6(ReferenceImageUploadWidget r3, long r4, boolean r6) {
        r3.getClass();
        com.larus.platform.service.o r5 = com.larus.platform.service.o.a;
        JSONObject r0 = new JSONObject();
        r0.put("type", "image");
        r0.put("duration", r4);
        r0.put("success", r6);
        r0.put("click_from", "chat_action_bar");
        Unit r7 = Unit.INSTANCE;
        r5.reportEvent("upload_duration", r0);
    }
}
