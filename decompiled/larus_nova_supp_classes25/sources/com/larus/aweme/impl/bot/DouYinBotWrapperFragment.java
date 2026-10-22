package com.larus.aweme.impl.bot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.aweme.api.video.service.AwemeVideoFeedDelegate;
import com.larus.aweme.impl.databinding.LarusFragmentDouyinBotBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.AccountService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.u;
import com.larus.utils.v;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import la8.a;
import la8.b;
import la8.c;
import or9.d;
import pr9.h;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u00066"}, d2 = {"Lcom/larus/aweme/impl/bot/DouYinBotWrapperFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "onBackPressCallBack", "Landroidx/activity/OnBackPressedCallback;", "binding", "Lcom/larus/aweme/impl/databinding/LarusFragmentDouyinBotBinding;", "getBinding", "()Lcom/larus/aweme/impl/databinding/LarusFragmentDouyinBotBinding;", "setBinding", "(Lcom/larus/aweme/impl/databinding/LarusFragmentDouyinBotBinding;)V", "hasBottomTab", "", "getHasBottomTab", "()Z", "setHasBottomTab", "(Z)V", "isVideoFirstLoading", "setVideoFirstLoading", "onBackFromChatTabInterceptor", "Lkotlin/Function0;", "", "getOnBackFromChatTabInterceptor", "()Lkotlin/jvm/functions/Function0;", "setOnBackFromChatTabInterceptor", "(Lkotlin/jvm/functions/Function0;)V", "onResumeAfterCall", "getOnResumeAfterCall", "setOnResumeAfterCall", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initStatusBarContentColor", "initUpSlideLayout", "onResume", "autoLogEnterPage", "onPause", "getCurrentPageName", "", "addDouyinFragment", "performBack", "initBackListener", "onDestroy", "createVideoFeedConfigure", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "reportEnterVideoPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DouYinBotWrapperFragment extends TraceFragment {
    public static final /* synthetic */ int j = 0;
    public FragmentExtKt.addOnBackPressed.callback.1 e;
    public LarusFragmentDouyinBotBinding f;
    public boolean g;
    public boolean h;
    public Function0<Unit> i;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "chat";
    }

    public DouYinBotWrapperFragment() {
        this.h = true;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.e;
        if (r0 == null) goto L6;
        r0.remove();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if ((getResources().getConfiguration().uiMode & 48) != 16) goto L8;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        u.e(r0, true, false);
        return;
    L9:
        return;
    }

    public final void onResume() {
        super.onResume();
        u.e(requireActivity(), false, false);
        FlowCommonAppCompatActivity r0 = requireActivity();
        if ((r0 instanceof FlowCommonAppCompatActivity) == false) goto L5;
        FlowCommonAppCompatActivity r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.B1(ColorProtector.parseColor("#FF161616"));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        LarusFragmentDouyinBotBinding r15 = this.f;
        if (r15 == null) goto L5;
        r15.b.setOnClickListener(new b(this));
    L5:
        LarusFragmentDouyinBotBinding r16 = this.f;
        if (r16 == null) goto L12;
        LinearLayout r17 = r16.e;
        if (this.g == false) goto L10;
        int r0 = 8;
    L11:
        r17.setVisibility(r0);
        goto L12
    L10:
        r0 = 0;
    L12:
        VideoFeedProviderDelegate r18 = VideoFeedProviderDelegate.b;
        Bundle r1 = getArguments();
        if (r1 == null) goto L15;
        String r2 = r1.getString("argument_video_enter_item_id");
    L16:
        Bundle r3 = getArguments();
        if (r3 == null) goto L19;
        String r4 = r3.getString("enter_method");
    L21:
        if (Intrinsics.areEqual(r4, "outer_push") == false) goto L23;
        EnterVideoMethod r5 = EnterVideoMethod.OUTER_PUSH;
    L24:
        if (r2 != null) goto L26;
    L29:
        boolean r6 = true;
    L30:
        long r7 = -1;
        String r9 = "";
        if (r6 == false) goto L40;
        d r8 = new d();
        String r10 = AwemeVideoFeedDelegate.b.getSceneId();
        if (r10 == null) goto L36;
        r9 = r10;
    L36:
        Intrinsics.checkNotNullParameter(r9, "sceneID");
        r8.p = r9;
        r8.g = false;
        Long r19 = StringsKt.toLongOrNull(AccountService.a.getUserId());
        if (r19 == null) goto L39;
        r7 = r19.longValue();
    L39:
        r8.q = r7;
        Intrinsics.checkNotNullParameter(r5, "enterVideoMethod");
        r8.a = r5;
        VideoFeedConfigure r110 = r8.a();
    L48:
        h r111 = r18.i(r110);
        r111.xQ(new c(this));
        Fragment r112 = r111.f();
        FragmentTransaction r113 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r113, r112, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L52;
        r113 = r113.replace(2131373275, r112);
    L52:
        r113.commitAllowingStateLoss();
        this.e = v.a(this, new a(this));
        Bundle r114 = getArguments();
        if (r114 == null) goto L55;
        String r115 = r114.getString("enter_method");
    L57:
        if (Intrinsics.areEqual(r115, "outer_push") == false) goto L59;
        a1.d(null, "outer_push", "landing", "douyin_bot_feeds", 49);
        return;
    L59:
        a1.d(null, "chat_list_landing", "chat_list", "douyin_bot_feeds", 49);
        return;
    L55:
        r115 = null;
        goto L57
    L40:
        d r11 = new d();
        String r12 = AwemeVideoFeedDelegate.b.getSceneId();
        if (r12 == null) goto L44;
        r9 = r12;
    L44:
        Intrinsics.checkNotNullParameter(r9, "sceneID");
        r11.p = r9;
        Long r20 = StringsKt.toLongOrNull(AccountService.a.getUserId());
        if (r20 == null) goto L47;
        r7 = r20.longValue();
    L47:
        r11.q = r7;
        r11.g = false;
        Intrinsics.checkNotNullParameter(r2, "enterItemID");
        r11.r = r2;
        Intrinsics.checkNotNullParameter(r5, "enterVideoMethod");
        r11.a = r5;
        r110 = r11.a();
        goto L48
    L26:
        if (r2.length() == 0) goto L29;
        r6 = false;
        goto L30
    L23:
        r5 = EnterVideoMethod.INDEPENDENT_DOU_YIN_BOT;
        goto L24
    L19:
        r4 = null;
        goto L21
    L15:
        r2 = null;
        goto L16
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562379, r10, false);
        int r13 = 2131363779;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r12, 2131363779);
        if (r2 == null) goto L17;
        r13 = 2131373275;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373275);
        if (r3 == null) goto L17;
        r13 = 2131374806;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, 2131374806);
        if (r4 == null) goto L17;
        r13 = 2131377668;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131377668);
        if (r5 == null) goto L17;
        r13 = 2131377671;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131377671);
        if (r6 == null) goto L17;
        r13 = 2131388523;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131388523);
        if (r7 == null) goto L17;
        LinearLayout r14 = (LinearLayout) r12;
        this.f = new LarusFragmentDouyinBotBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
