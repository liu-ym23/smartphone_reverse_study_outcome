package com.suite.lark.platform.feature.forward.doubao;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.forwardv3.ExternalForwardSendHelper;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoThreadAvatar;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Iterator;
import java.util.List;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\tH\u0002J$\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002J\u001e\u00106\u001a\u00020$2\f\u00107\u001a\b\u0012\u0004\u0012\u000204082\u0006\u00105\u001a\u00020\u0019H\u0002J\u0018\u00109\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002J \u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u00162\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020B2\u0006\u00103\u001a\u000204H\u0002J\b\u0010F\u001a\u00020$H\u0002J\u0010\u0010G\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0014H\u0002J\f\u0010H\u001a\u00020\u001e*\u00020IH\u0002J\u0018\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020\u0019H\u0002J\b\u0010M\u001a\u00020\u0019H\u0002J\u0018\u0010N\u001a\u00020$2\u0006\u0010L\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u001eH\u0002J\u0010\u0010P\u001a\u00020$2\u0006\u0010L\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\b\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020B08H\u0002J \u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\f\u00107\u001a\b\u0012\u0004\u0012\u00020408H\u0002J\n\u0010X\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020BH\u0002J\u0018\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u001eH\u0002J\b\u0010_\u001a\u00020$H\u0002J\u0010\u0010`\u001a\u00020$2\u0006\u0010a\u001a\u00020BH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardConfirmFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "forwardSendHelper", "Lcom/ss/android/lark/forwardv3/IForwardSendHelper;", "sendMode", "Lcom/ss/android/lark/forwardv3/ExternalForwardSendMode;", "singleAvatarRow", "Landroid/widget/LinearLayout;", "avatarScroll", "Landroid/widget/HorizontalScrollView;", "avatarRow", "previewContainer", "Landroid/widget/FrameLayout;", "noteEt", "Landroid/widget/EditText;", "sendBtn", "Landroid/view/View;", "backBtn", "Landroid/widget/ImageView;", "bottomContainer", "bottomOriginPadding", "", "lastAppliedExtraBottom", "sheetOriginBottomMargin", "lastAppliedSheetBottomExtra", "imeAnimationRunning", "", "sheetBottomMarginAnimator", "Landroid/animation/ValueAnimator;", "sending", "avatarScrollEnabled", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "resolveSendMode", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "bindViews", "root", "goBackToSelect", "renderAvatars", "renderSingleAvatar", "item", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "sizePx", "renderMultiAvatars", "items", "", "createAvatarContainer", "loadAvatar", "view", "setupAvatarScrollConflict", "createNameView", "Landroid/widget/TextView;", "ctx", "Landroid/content/Context;", "name", "", "createNameLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "readDisplayName", "renderPreview", "setupBottomInsets", "isImeAnimation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "applyBottomExtraPadding", "v", "extraBottom", "currentSheetBottomMargin", "applySheetBottomMargin", "animate", "setSheetBottomMargin", "currentSheetBottomExtra", "resetSheetBottomMargin", "startToSend", "resolveForwardMessageIds", "doSuccess", "result", "Lcom/ss/android/lark/forwardv3/data/ForwardResultV3;", "resolveSourceChatId", "openChat", "chatId", "doError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "showToast", "clearFocus", "errorToast", "errorMsg", "Companion", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoForwardConfirmFragment extends Fragment {
    public static final /* synthetic */ int v = 0;
    public ForwardV3ViewModel d;
    public ExternalForwardSendHelper e;
    public ExternalForwardSendMode f;
    public LinearLayout g;
    public HorizontalScrollView h;
    public LinearLayout i;
    public FrameLayout j;
    public EditText k;
    public View l;
    public ImageView m;
    public View n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public ValueAnimator t;
    public boolean u;

    public static final class a {
    }

    public static final class b extends SimpleTarget<Drawable> {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ Drawable b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r2) {
            this.a.setImageDrawable(this.b);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r2) {
            Drawable r3 = (Drawable) r2;
            ImageView r0 = this.a;
            if (r3 != null) goto L5;
            r3 = this.b;
        L5:
            r0.setImageDrawable(r3);
        }

        public b(ImageView r1, Drawable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.ss.android.lark.forwardv3.y.a {
        public final /* synthetic */ DoubaoForwardConfirmFragment a;

        public c(DoubaoForwardConfirmFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void a(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "err");
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void onError(ErrorResult r7) {
            Intrinsics.checkNotNullParameter(r7, "err");
            DoubaoForwardConfirmFragment r0 = this.a;
            int r1 = DoubaoForwardConfirmFragment.v;
            r0.getClass();
            UICallbackExecutor.post(com.suite.lark.platform.feature.forward.doubao.b.a);
            String r2 = y9c.d.h(2131891584);
            String r3 = null;
            if ((r7 instanceof ForwardErrorResultV3) == false) goto L5;
            ForwardErrorResultV3 r4 = (ForwardErrorResultV3) r7;
        L6:
            if (r4 != null) goto L8;
            UICallbackExecutor.execute(new com.suite.lark.platform.feature.forward.doubao.f(r0, r7.getDisplayMsg(r2)));
            return;
        L8:
            String r5 = r4.getMessage();
            if ((!TextUtils.isEmpty(r5)) == false) goto L11;
            r3 = r5;
        L11:
            if (r3 == null) goto L15;
            r2 = r3;
        L15:
            if (r4.isIsDialog() == false) goto L17;
            UICallbackExecutor.execute(new com.suite.lark.platform.feature.forward.doubao.c(r0, r4, r2));
            return;
        L17:
            UICallbackExecutor.execute(new com.suite.lark.platform.feature.forward.doubao.d(r0, r7, r2, r4));
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void b(final rib.d r2, List<? extends SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r3, "items");
            final DoubaoForwardConfirmFragment r4 = this.a;
            int r0 = DoubaoForwardConfirmFragment.v;
            r4.getClass();
            UICallbackExecutor.post(com.suite.lark.platform.feature.forward.doubao.e.a);
            UICallbackExecutor.execute(new DoubaoForwardConfirmFragment$doSuccess$2(r4, r2));
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ DoubaoForwardConfirmFragment a;

        public e(DoubaoForwardConfirmFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            DoubaoForwardConfirmFragment r3 = this.a;
            int r0 = DoubaoForwardConfirmFragment.v;
            KeyboardUtils.hideKeyboard(r3.requireActivity());
            r3.requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ DoubaoForwardConfirmFragment a;

        public f(DoubaoForwardConfirmFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            final DoubaoForwardConfirmFragment r1 = this.a;
            int r10 = DoubaoForwardConfirmFragment.v;
            final Context r2 = r1.getContext();
            if (r2 == null) goto L34;
            ForwardV3ViewModel r11 = r1.d;
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r11 = null;
        L8:
            final List<? extends SearchBaseInfo> r12 = r11.getSelectedItemList();
            if (r12.isEmpty() == false) goto L11;
            Log.w("DoubaoForwardConfirmFragment", "onSendClick skip: empty items");
            return;
        L11:
            View r4 = r1.l;
            if (r4 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            r4 = null;
        L14:
            r4.setEnabled(false);
            View r5 = r1.l;
            if (r5 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            r5 = null;
        L17:
            r5.setAlpha(0.6f);
            final BeforeForwardErrorHandle r6 = new BeforeForwardErrorHandle(r2);
            i08.a.b(r2, y9c.d.h(2131892207));
            EditText r7 = r1.k;
            if (r7 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("noteEt");
            r7 = null;
        L20:
            Editable r8 = r7.getText();
            if (r8 == null) goto L25;
            String r13 = r8.toString();
            if (r13 == null) goto L25;
            final String r14 = StringsKt.trim(r13).toString();
        L26:
            if (r14 != null) goto L28;
            r14 = "";
        L28:
            ForwardV3ViewModel r15 = r1.d;
            if (r15 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r15 = null;
        L31:
            r15.prepareChatBeforeForward(r12, new DoubaoForwardConfirmFragment$startToSend$1(r1, r2, r12, r14, r6));
            return;
        L25:
            r14 = null;
            goto L26
        }
    }

    static {
    }

    public final void onDestroyView() {
        ValueAnimator r0 = this.t;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        FrameLayout.LayoutParams r1 = null;
        this.t = null;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L18;
        View r3 = r2.findViewById(2131364514);
        if (r3 == null) goto L18;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof FrameLayout.LayoutParams) == false) goto L13;
        r1 = (FrameLayout.LayoutParams) r4;
    L13:
        if (r1 == null) goto L18;
        int r5 = r1.bottomMargin;
        int r6 = this.q;
        if (r5 == r6) goto L18;
        r1.bottomMargin = r6;
        r3.setLayoutParams(r1);
    L18:
        super.onDestroyView();
    }

    public DoubaoForwardConfirmFragment() {
        this.p = -1;
        this.r = -1;
    }

    public final int W90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L14;
        View r1 = r0.findViewById(2131364514);
        if (r1 == null) goto L16;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L10;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
    L11:
        if (r3 != null) goto L13;
        return 0;
    L13:
        return r3.bottomMargin;
    L10:
        r3 = null;
        goto L11
    L16:
        return 0;
    L14:
        return 0;
    }

    public final void Y90(int r4) {
        this.r = r4;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L17;
        View r1 = r0.findViewById(2131364514);
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L10;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        int r5 = this.q + r4;
        if (r3.bottomMargin == r5) goto L18;
        r3.bottomMargin = r5;
        r1.setLayoutParams(r3);
        return;
    L18:
        return;
    L10:
        r3 = null;
        goto L11
    L19:
        return;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Intent r6 = requireActivity().getIntent();
        ExternalForwardSendMode r0 = null;
        if (r6 == null) goto L7;
        Bundle r7 = r6.getExtras();
        if (r7 == null) goto L7;
        ForwardTemplateNew r8 = (ForwardTemplateNew) r7.getParcelable("key_intent_forward_template_new");
    L8:
        if (r8 != null) goto L11;
        Log.e("DoubaoForwardConfirmFragment", "ForwardTemplateNew is null, finish");
        requireActivity().finish();
        return;
    L11:
        this.d = (ForwardV3ViewModel) new ViewModelProvider(requireActivity(), new ForwardV3ViewModelFactory(r8)).get(ForwardV3ViewModel.class);
        Intent r9 = requireActivity().getIntent();
        if (r9 == null) goto L14;
        String r10 = r9.getStringExtra("extra_external_forward_send_mode");
    L34:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        Object r11 = Result.constructor-impl(ExternalForwardSendMode.valueOf(r10));     // Catch: Throwable -> L20
    L22:
        ExternalForwardSendMode r2 = ExternalForwardSendMode.DOUBAO_ENTRY;
        if (Result.isFailure-impl(r11) == false) goto L25;
        r11 = r2;
    L25:
        this.f = (ExternalForwardSendMode) r11;
        c r12 = new c(this);
        ForwardV3ViewModel r3 = this.d;
        if (r3 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L28:
        ExternalForwardSendMode r4 = this.f;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("sendMode");
    L32:
        this.e = new ExternalForwardSendHelper(r3, r12, r0);
        return;
    L31:
        r0 = r4;
    L20:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L14:
        r10 = null;
    L7:
        r8 = null;
        goto L8
    }

    public static final boolean U90(DoubaoForwardConfirmFragment r0, WindowInsetsAnimationCompat r1) {
        r0.getClass();
        if ((r1.getTypeMask() & WindowInsetsCompat.Type.ime()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final FrameLayout V90(SearchBaseInfo r8, int r9) {
        Context r0 = requireContext();
        FrameLayout r1 = new FrameLayout(r0);
        ImageView r2 = new ImageView(r0);
        r2.setBackground(r0.getDrawable(2131233980));
        r2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r2.setClipToOutline(true);
        r1.addView(r2, new FrameLayout.LayoutParams(r9, r9));
        DoubaoThreadAvatar r5 = DoubaoThreadAvatar.INSTANCE;
        Integer r6 = r5.mainIconRes(r8);
        Integer r7 = r5.badgeIconRes(r8);
        if (r6 == null) goto L5;
        r2.setImageResource(r6.intValue());
    L6:
        if (r6 != null) goto L8;
        if (r7 != null) goto L8;
    L14:
        return r1;
    L8:
        int r10 = r1.getResources().getDimensionPixelSize(2131165845);
        ImageView r3 = new ImageView(r0);
        r3.setBackground(r0.getDrawable(2131233980));
        r3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r3.setClipToOutline(true);
        if (r6 == null) goto L11;
        X90(r3, r8, r10);
    L13:
        r1.addView(r3, new FrameLayout.LayoutParams(r10, r10, 8388693));
        goto L14
    L11:
        if (r7 == null) goto L13;
        r3.setImageResource(r7.intValue());
        goto L13
    L5:
        X90(r2, r8, r9);
        goto L6
    }

    public static final void S90(DoubaoForwardConfirmFragment r2, View r3, int r4) {
        if (r4 == r2.p) goto L7;
        r2.p = r4;
        int r5 = r2.o + r4;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r5);
        return;
    }

    public static final void T90(DoubaoForwardConfirmFragment r4, int r5, boolean r6) {
        int r0 = r4.r;
        if (r5 == r0) goto L26;
        Integer r1 = null;
        if (r6 == true) goto L11;
        ValueAnimator r7 = r4.t;
        if (r7 == null) goto L10;
        r7.cancel();
    L10:
        r4.t = null;
        r4.Y90(r5);
        return;
    L11:
        Integer r8 = Integer.valueOf(r0);
        if (r8.intValue() < 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        r1 = r8;
    L17:
        if (r1 == null) goto L19;
        int r9 = r1.intValue();
    L20:
        ValueAnimator r3 = r4.t;
        if (r3 == null) goto L23;
        r3.cancel();
    L23:
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r9, r5});
        r10.setDuration(250);
        r10.addUpdateListener(new com.suite.lark.platform.feature.forward.doubao.a(r4));
        r10.start();
        r4.t = r10;
        return;
    L19:
        r9 = RangesKt.coerceAtLeast(r4.W90() - r4.q, 0);
        goto L20
    L14:
        r2 = false;
        goto L15
    }

    public final void X90(ImageView r5, SearchBaseInfo r6, int r7) {
        Context r0 = requireContext();
        String r2 = null;
        if (Intrinsics.areEqual(r6.getId(), "doubao_external_forward_target") == false) goto L9;
        mpc.e r1 = (mpc.e) OfficeSDKManager.getHostGlobalService(mpc.e.class);
        if (r1 == null) goto L9;
        mpc.a r3 = r1.K0();
        if (r3 == null) goto L9;
        Drawable r4 = r3.c;
    L10:
        if (r4 == null) goto L13;
        ImageLoader.with(r0).load(r4).override(r7, r7).asDrawable().transform(new CropCircleTransformation()).into(new b(r5, r4));
        return;
    L13:
        String r8 = r6.getAvatarKey();
        if (r8.length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        r2 = r8;
    L19:
        if (r2 != null) goto L21;
        return;
    L21:
        ImageLoader.with(r0).load(AvatarImage.Builder.obtain(r2, DoubaoThreadAvatar.INSTANCE.avatarEntityId(r6), r7, r7).build()).asDrawable().transform(new CropCircleTransformation()).into(r5);
        return;
    L16:
        r9 = false;
    L9:
        r4 = null;
        goto L10
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        int r0 = 0;
        final View r15 = r12.inflate(2131561204, r13, false);
        Intrinsics.checkNotNull(r15);
        this.g = (LinearLayout) r15.findViewById(2131373248);
        this.h = (HorizontalScrollView) r15.findViewById(2131373239);
        this.i = (LinearLayout) r15.findViewById(2131373238);
        this.j = (FrameLayout) r15.findViewById(2131373244);
        this.k = (EditText) r15.findViewById(2131373243);
        this.l = r15.findViewById(2131373247);
        this.m = (ImageView) r15.findViewById(2131373240);
        View r16 = r15.findViewById(2131373241);
        this.n = r16;
        View r1 = null;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        r16 = null;
    L5:
        r16.setOnClickListener(d.a);
        ImageView r17 = this.m;
        if (r17 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        r17 = null;
    L8:
        r17.setOnClickListener(new e(this));
        View r18 = this.l;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
        r18 = null;
    L11:
        r18.setOnClickListener(new f(this));
        int r19 = ViewConfiguration.get(requireContext()).getScaledTouchSlop();
        Ref.FloatRef r2 = new Ref.FloatRef();
        Ref.FloatRef r3 = new Ref.FloatRef();
        HorizontalScrollView r4 = this.h;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r4 = null;
    L14:
        r4.setOnTouchListener(new g(this, r2, r3, r19));
        ForwardV3ViewModel r110 = this.d;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r110 = null;
    L17:
        List<SearchBaseInfo> r111 = r110.getSelectedItemList();
        if (r111.isEmpty() == false) goto L26;
        LinearLayout r112 = this.g;
        if (r112 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r112 = null;
    L22:
        r112.setVisibility(8);
        HorizontalScrollView r113 = this.h;
        if (r113 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r113 = null;
    L25:
        r113.setVisibility(8);
    L77:
        Unit r114 = Unit.INSTANCE;
        ppc.f r115 = ppc.f.a;
        FragmentActivity r5 = requireActivity();
        FrameLayout r6 = this.j;
        if (r6 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
        r6 = null;
    L80:
        ForwardV3ViewModel r7 = this.d;
        if (r7 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L83:
        ppc.g r8 = new ppc.g(r5, this, r6, r7);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r8, "context");
        r8.c.removeAllViews();
        r8.c.setVisibility(8);
        Iterator<T> r116 = ppc.f.b.iterator();
    L85:
        if (r116.hasNext() == false) goto L89;
        Object r9 = r116.next();
        if (((ppc.e) r9).a(r8) == false) goto L85;
    L90:
        ppc.e r10 = (ppc.e) r9;
        if (r10 != null) goto L98;
        StringBuilder r117 = new StringBuilder("skip unsupported forwardContent=");
        IForwardContent r11 = r8.d.getForwardContent();
        if (r11 == null) goto L95;
        String r20 = r11.getClass().getSimpleName();
    L96:
        r117.append(r20);
        Log.i("DoubaoForwardPreviewBinder", r117.toString());
    L100:
        this.p = -1;
        this.r = -1;
        View r118 = this.n;
        if (r118 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
    L104:
        this.o = r1.getPaddingBottom();
        this.q = W90();
        ViewCompat.setOnApplyWindowInsetsListener(r15, new h(this));
        ViewCompat.setWindowInsetsAnimationCallback(r15, new DoubaoForwardConfirmFragment$setupBottomInsets$2(this, r15));
        ViewCompat.requestApplyInsets(r15);
        return r15;
    L103:
        r1 = r118;
        goto L104
    L95:
        r20 = null;
        goto L96
    L98:
        if (r10.b(r8) == true) goto L100;
        r8.c.removeAllViews();
        r8.c.setVisibility(8);
        goto L100
    L89:
        r9 = null;
        goto L90
    L26:
        int r21 = y9c.d.a(36);
        if (r111.size() != 1) goto L49;
        SearchBaseInfo r119 = (SearchBaseInfo) CollectionsKt.first(r111);
        this.u = false;
        HorizontalScrollView r22 = this.h;
        if (r22 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r22 = null;
    L31:
        r22.setVisibility(8);
        LinearLayout r23 = this.i;
        if (r23 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("avatarRow");
        r23 = null;
    L34:
        r23.removeAllViews();
        LinearLayout r24 = this.g;
        if (r24 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r24 = null;
    L37:
        r24.setVisibility(0);
        r24.removeAllViews();
        r24.addView(V90(r119, r21), new LinearLayout.LayoutParams(r21, r21));
        String r120 = r119.getTitle();
        if (r120 != null) goto L41;
        r120 = "";
    L41:
        if (r120.length() <= 0) goto L43;
        boolean r25 = true;
    L44:
        if (r25 == true) goto L47;
        r120 = null;
    L47:
        if (r120 == null) goto L77;
        Context r26 = requireContext();
        TextView r27 = new TextView(r26);
        r27.setText(r120);
        r27.setTextSize(17.0f);
        r27.setTextColor(ContextCompat.getColor(r26, 2131102072));
        r27.setMaxLines(1);
        r27.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(0, -2);
        r121.setMarginStart(y9c.d.a(12));
        r121.gravity = 16;
        r121.weight = 1.0f;
        r24.addView(r27, r121);
        goto L77
    L43:
        r25 = false;
        goto L44
    L49:
        LinearLayout r28 = this.g;
        if (r28 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r28 = null;
    L52:
        r28.setVisibility(8);
        LinearLayout r29 = this.g;
        if (r29 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r29 = null;
    L55:
        r29.removeAllViews();
        this.u = true;
        HorizontalScrollView r30 = this.h;
        if (r30 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r30 = null;
    L58:
        r30.setVisibility(0);
        HorizontalScrollView r31 = this.h;
        if (r31 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r31 = null;
    L61:
        r31.scrollTo(0, 0);
        int r32 = y9c.d.a(8);
        LinearLayout r33 = this.i;
        if (r33 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("avatarRow");
        r33 = null;
    L64:
        r33.removeAllViews();
        r33.setMinimumWidth(0);
        r33.getLayoutParams().width = -2;
        r33.setLayoutParams(r33.getLayoutParams());
        r33.setGravity(17);
        Iterator<T> r122 = r111.iterator();
    L66:
        if (r122.hasNext() == false) goto L77;
        Object r34 = r122.next();
        int r35 = r0 + 1;
        if (r0 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        SearchBaseInfo r36 = (SearchBaseInfo) r34;
        LinearLayout.LayoutParams r37 = new LinearLayout.LayoutParams(r21, r21);
        if (r0 <= 0) goto L73;
        r37.setMarginStart(r32);
    L73:
        LinearLayout r38 = this.i;
        if (r38 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("avatarRow");
        r38 = null;
    L76:
        r38.addView(V90(r36, r21), r37);
        r0 = r35;
        goto L66
    }
}
