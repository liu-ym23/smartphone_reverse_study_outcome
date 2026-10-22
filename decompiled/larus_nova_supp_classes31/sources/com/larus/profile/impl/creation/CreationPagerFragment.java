package com.larus.profile.impl.creation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.common_ui.fragment.CommonSlideFragment;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.community.api.ICommunityService;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.profile.impl.databinding.LarusCreationPagerLayoutBinding;
import com.larus.profile.impl.viewmodel.CreationPagerViewModel;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u009d\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u009d\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u0010\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020KH\u0016J4\u0010L\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u0015H\u0002J\u0018\u0010S\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u0015H\u0002J\u000f\u0010U\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010VJ*\u0010W\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010Y\u001a\u00020\u0015H\u0002J;\u0010Z\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010Y\u001a\u00020\u00152\n\b\u0001\u0010[\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u00020\u0006H\u0016J&\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0016\u0010]\u001a\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0018\u0010g\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010Y\u001a\u00020\u0015J\b\u0010j\u001a\u00020\u0006H\u0002J\u001a\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020_2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010m\u001a\u00020\u0006H\u0016J\b\u0010n\u001a\u00020\u0006H\u0016J\n\u0010o\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010p\u001a\u0004\u0018\u00010qH\u0016J\b\u0010r\u001a\u00020\u0017H\u0016J\b\u0010s\u001a\u0004\u0018\u00010tJ\u000e\u0010u\u001a\b\u0012\u0002\b\u0003\u0018\u00010HH\u0002J\b\u0010v\u001a\u00020\u0015H\u0016J\u0016\u0010w\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u0015J\u000e\u0010y\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0015J\b\u0010z\u001a\u0004\u0018\u00010{J\u0018\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u0016H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010\u0081\u0001\u001a\u00020\u00172\b\u0010O\u001a\u0004\u0018\u00010NH\u0002J\u0013\u0010\u0082\u0001\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010NH\u0002J\u0011\u0010\u009a\u0001\u001a\u00020\u00062\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R@\u0010\u0013\u001a(\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u001a\u00106\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010+\"\u0004\b8\u0010-R\u001a\u00109\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u001a\u0010<\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030H\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0083\u0001\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u0012\u001a\u0005\b\u0084\u0001\u00100R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010\u0012\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001e\u0010\u008b\u0001\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0012\u001a\u0005\b\u008c\u0001\u00100R\u001e\u0010\u008e\u0001\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0012\u001a\u0005\b\u008f\u0001\u00100R\u001e\u0010\u0091\u0001\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0093\u0001\u0010\u0012\u001a\u0005\b\u0092\u0001\u00100R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0087\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010\u0012\u001a\u0006\b\u0095\u0001\u0010\u0089\u0001R\"\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0087\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0099\u0001\u0010\u0012\u001a\u0006\b\u0098\u0001\u0010\u0089\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/larus/profile/impl/creation/CreationPagerFragment;", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment;", "Lcom/larus/profile/impl/databinding/LarusCreationPagerLayoutBinding;", "Lcom/larus/profile/api/model/ICreationPagerFragment;", "selfDismissed", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "()V", "binding", "pagerAdapter", "Lcom/larus/profile/impl/creation/CreationOutPagerAdapter;", "viewModel", "Lcom/larus/profile/impl/viewmodel/CreationPagerViewModel;", "getViewModel", "()Lcom/larus/profile/impl/viewmodel/CreationPagerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "callBack", "Lkotlin/Function4;", "", "", "", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "getCallBack", "()Lkotlin/jvm/functions/Function4;", "setCallBack", "(Lkotlin/jvm/functions/Function4;)V", "initList", "", "getInitList", "()Ljava/util/List;", "setInitList", "(Ljava/util/List;)V", "initPosition", "getInitPosition", "()I", "setInitPosition", "(I)V", "initCursor", "getInitCursor", "()Ljava/lang/String;", "setInitCursor", "(Ljava/lang/String;)V", "initHasMore", "getInitHasMore", "()Z", "setInitHasMore", "(Z)V", "lastItemCount", "getLastItemCount", "setLastItemCount", "visitId", "getVisitId", "setVisitId", "creationStyle", "getCreationStyle", "setCreationStyle", "disableSlide", "getDisableSlide", "setDisableSlide", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "preReportVid", "previousFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/larus/common_ui/fragment/CommonSlideFragment;", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment$ContainerEvent;", "sendMobEvent", "previousCreation", "Lcom/larus/platform/api/creation/UserCreation;", "creation", "status", "previousIndex", "index", "getEnterMethod", "currentIndex", "getQueryPrivateStatus", "()Ljava/lang/Integer;", "traceEnterMusicDetail", "slideStatus", "sessionIndex", "traceEnterPictureDetail", "creationType", "(Ljava/lang/String;ILcom/larus/platform/api/creation/UserCreation;ILjava/lang/Integer;)V", "initViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "list", "updateCreationContent", "content", "Lcom/larus/platform/api/ModifiedUserCreationMusic;", "checkLoading", "onViewCreated", "view", "onDestroyView", "onDetach", "initViewBinding", "getPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "needCommonSlide", "getCurrentFragment", "Lcom/larus/profile/impl/creation/CreationGroupFragment;", "getPreviousFragment", "getInitItemPosition", "setCreationPrivacy", "private", "deleteCreation", "getShareContainer", "Landroid/widget/FrameLayout;", "showFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "clickBackCallback", "isShowLeftCreationView", "reportLeftCreationData", "hasCreateImageAbility", "getHasCreateImageAbility", "hasCreateImageAbility$delegate", "detailEditInstructionItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "getDetailEditInstructionItem", "()Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "detailEditInstructionItem$delegate", "hasDetailImageEditAbility", "getHasDetailImageEditAbility", "hasDetailImageEditAbility$delegate", "hasCreateVideoAbility", "getHasCreateVideoAbility", "hasCreateVideoAbility$delegate", "hasExtendVideoAbility", "getHasExtendVideoAbility", "hasExtendVideoAbility$delegate", "genImgInstructionItem", "getGenImgInstructionItem", "genImgInstructionItem$delegate", "genVideoInstructionItem", "getGenVideoInstructionItem", "genVideoInstructionItem$delegate", "updateShareAlpha", "alpha", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationPagerFragment extends CommonSlideDialogFragment<LarusCreationPagerLayoutBinding> implements gs9.g {
    public static final /* synthetic */ int D = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Function0<Unit> i;
    public CreationOutPagerAdapter j;
    public final Lazy k;
    public Function4<? super Integer, ? super String, ? super Boolean, ? super List<UserCreationModel>, Unit> l;
    public int m;
    public String n;
    public boolean o;
    public int p;
    public String q;
    public int r;
    public boolean s;
    public gs9.d t;
    public String u;
    public WeakReference<CommonSlideFragment<?>> v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final /* bridge */ /* synthetic */ ViewBinding ea0() {
        return null;
    }

    public final boolean ga0() {
        return true;
    }

    public CreationPagerFragment() {
        this(new l1());
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L10
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L10
        if (r0 == null) goto L16;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L10
        return;
    L16:
        return;
    L10:
        FLogger.a.e("CreationPagerFragment", "fallback by dismiss failed");
    }

    public final FragmentStateAdapter ca0() {
        if (this.j != null) goto L6;
        this.j = new CreationOutPagerAdapter(this);
    L6:
        return this.j;
    }

    public final void fa0() {
        gs9.d r0 = this.t;
        if (r0 == null) goto L14;
        gs9.e r1 = r0.a;
        if (r1 == null) goto L14;
        LiveData<List<UserCreationModel>> r2 = r1.getFeedDataLiveData();
        if (r2 == null) goto L10;
        List<UserCreationModel> r3 = (List) r2.getValue();
        if (r3 == null) goto L10;
    L11:
        pa0(r3);
        LiveData<List<UserCreationModel>> r4 = r1.getFeedDataLiveData();
        if (r4 == null) goto L16;
        r4.observe(getViewLifecycleOwner(), new b(new t1(this)));
        return;
    L16:
        return;
    L10:
        r3 = new ArrayList();
    L14:
        pa0(new ArrayList());
    }

    public final CreationGroupFragment ma0() {
        LarusFragmentCommonSlideBinding r2 = ((CommonSlideDialogFragment) this).d;     // Catch: Exception -> L20
        if (r2 == null) goto L6;
        ViewPager2 r3 = r2.c;     // Catch: Exception -> L20
    L7:
        if (r3 == null) goto L22;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L20
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L20
        if (r5 == null) goto L15;
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L20
        CreationOutPagerAdapter r0 = this.j;     // Catch: Exception -> L20
        if (r0 == null) goto L13;
        Long r1 = Long.valueOf(r0.getItemId(r4));     // Catch: Exception -> L20
    L14:
        r6.append(r1);     // Catch: Exception -> L20
        Fragment r7 = r5.findFragmentByTag(r6.toString());     // Catch: Exception -> L20
    L17:
        if ((r7 instanceof CreationGroupFragment) == false) goto L27;
        return (CreationGroupFragment) r7;
    L27:
        return null;
    L13:
        r1 = null;
        goto L14
    L15:
        r7 = null;
        goto L17
    L22:
        return null;
    L6:
        r3 = null;
    L20:
        e = move-exception;
        FLogger.a.e("CreationPagerFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final com.larus.bmhome.actionbar.model.z0 na0() {
        return (com.larus.bmhome.actionbar.model.z0) this.B.getValue();
    }

    public final CreationPagerViewModel oa0() {
        return (CreationPagerViewModel) this.k.getValue();
    }

    public final void onDestroyView() {
        WeakReference<CommonSlideFragment<?>> r0 = this.v;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.v = null;
        this.j = null;
        super.onDestroyView();
    }

    public final void T90() {
        CreationPagerViewModel r0 = oa0();
        String r1 = null;
        if (r0 == null) goto L9;
        CreationGroupFragment r2 = ma0();
        if (r2 == null) goto L7;
        int r3 = ((CommonSlideFragment) r2).e;
    L8:
        UserCreation r4 = CreationPagerViewModel.getCurrentCreation$default(r0, r3, 0, 2, null);
    L10:
        if (r4 == null) goto L44;
        String r5 = r4.a;
        String r6 = zp9.d.d(r4);
        AuthorInfo r7 = r4.g;
        if (r7 == null) goto L14;
        String r8 = r7.b;
    L15:
        String r9 = zp9.d.b(r4);
        UserCreationTrackParams r10 = r4.n;
        if (r10 == null) goto L18;
        Integer r11 = r10.c;
    L19:
        if (r10 == null) goto L21;
        Integer r12 = r10.b;
    L22:
        if (r10 == null) goto L24;
        String r13 = r10.a;
    L25:
        gs9.d r14 = this.t;
        if (r14 == null) goto L30;
        gs9.b r15 = r14.f;
        if (r15 == null) goto L30;
        String r16 = r15.b;
    L31:
        if (r10 == null) goto L33;
        String r23 = r10.g;
    L34:
        if (r10 == null) goto L36;
        String r17 = r10.d;
    L37:
        if (r10 == null) goto L39;
        String r18 = r10.e;
    L40:
        if (r10 == null) goto L42;
        r1 = r10.f;
    L42:
        tx9.x2.a(r16, r5, r6, r9, r8, r11, r12, r13, r17, r1, r18, r23, null, "template_detail", null, null, null, null, null, null, 1036288);
        return;
    L39:
        r18 = null;
        goto L40
    L36:
        r17 = null;
        goto L37
    L33:
        r23 = null;
    L30:
        r16 = null;
        goto L31
    L24:
        r13 = null;
        goto L25
    L21:
        r12 = null;
        goto L22
    L18:
        r11 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L44:
        return;
    L7:
        r3 = 0;
        goto L8
    L9:
        r4 = null;
        goto L10
    }

    public final int ba0() {
        CreationPagerViewModel r0 = oa0();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentPagerIndex();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        this.i.invoke();
    }

    public CreationPagerFragment(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "selfDismissed");
        this.i = r4;
        final Function0<Fragment> r5 = new CreationPagerFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CreationPagerViewModel.class), new CreationPagerFragment$special$$inlined$viewModels$default$2(r5), new CreationPagerFragment$special$$inlined$viewModels$default$3(r5, this));
        this.n = "";
        this.q = "";
        this.u = "";
        this.w = LazyKt.lazy(new m1());
        this.x = LazyKt.lazy(new n1(this));
        this.y = LazyKt.lazy(new o1(this));
        this.z = LazyKt.lazy(new p1());
        this.A = LazyKt.lazy(new q1());
        this.B = LazyKt.lazy(new r1(this));
        this.C = LazyKt.lazy(new s1(this));
    }

    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    public final void Y90(CommonSlideDialogFragment.b r78) {
        Intrinsics.checkNotNullParameter(r78, "event");
        if ((r78 instanceof CommonSlideDialogFragment.b.d) == false) goto L645;
        CommonSlideDialogFragment.b.d r1 = (CommonSlideDialogFragment.b.d) r78;
        int r2 = r1.a;
        int r3 = r1.b;
        if (r2 != (-1)) goto L10;
        CreationPagerViewModel r4 = oa0();
        if (r4 == null) goto L9;
        r2 = r4.getCurrentPagerIndex();
        goto L10
    L9:
        r2 = 0;
    L10:
        CreationPagerViewModel r5 = oa0();
        if (r5 == null) goto L13;
        r5.updatePagerIndex(r2);
    L13:
        int r6 = this.p;
        CreationPagerViewModel r7 = oa0();
        if (r7 == null) goto L16;
        int r8 = r7.getItemCountWithoutLoading();
    L18:
        if (r6 == r8) goto L29;
        CreationPagerViewModel r9 = oa0();
        if (r9 == null) goto L22;
        int r10 = r9.getCurrentIndexInFeedData();
    L23:
        CreationPagerViewModel r11 = oa0();
        if (r11 == null) goto L26;
        int r12 = r11.getItemCountWithoutLoading() - 10;
    L27:
        if (r10 < r12) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == false) goto L53;
        CreationPagerViewModel r14 = oa0();
        if (r14 == null) goto L34;
        int r15 = r14.getItemCountWithoutLoading();
    L35:
        this.p = r15;
        CreationPagerViewModel r16 = oa0();
        if (r16 != null) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == false) goto L48;
        CreationPagerViewModel r18 = oa0();
        if (r18 == null) goto L45;
        r18.addLoading();
    L45:
        CreationPagerViewModel r19 = oa0();
        if (r19 == null) goto L48;
        r19.loadFeedData(this.q, Integer.valueOf(this.r));
    L48:
        gs9.d r20 = this.t;
        if (r20 == null) goto L53;
        gs9.e r21 = r20.a;
        if (r21 == null) goto L53;
        r21.checkLoadMore();
        goto L53
    L38:
        if (r16.getHasmore() != true) goto L40;
        r17 = true;
        goto L41
    L34:
        r15 = 0;
    L53:
        CreationPagerViewModel r22 = oa0();
        if (r22 == null) goto L60;
        CreationGroupFragment r23 = ma0();
        if (r23 == null) goto L58;
        int r24 = ((CommonSlideFragment) r23).e;
    L59:
        UserCreation r110 = CreationPagerViewModel.getCurrentCreation$default(r22, r24, 0, 2, null);
    L61:
        CreationPagerViewModel r25 = oa0();
        if (r25 == null) goto L71;
        WeakReference<CommonSlideFragment<?>> r26 = this.v;
        if (r26 == null) goto L66;
        CommonSlideFragment<?> r27 = r26.get();
    L67:
        if (r27 == null) goto L69;
        int r28 = r27.e;
    L70:
        UserCreation r29 = r25.getCurrentCreation(r28, r3);
    L72:
        if (r2 <= r3) goto L74;
        String r30 = "up";
    L75:
        String r111 = r30;
        if (r3 == r2) goto L541;
        String r112 = "creation_others";
        if (r3 == (-1)) goto L123;
        if (r29 == null) goto L86;
        Integer r31 = r29.d;
        if (r31 == null) goto L86;
        if (r31.intValue() != 2) goto L86;
        boolean r32 = true;
    L87:
        if (r32 == false) goto L89;
        String r33 = "0";
    L90:
        WeakReference<CommonSlideFragment<?>> r34 = this.v;
        if (r34 == null) goto L93;
        CommonSlideFragment<?> r35 = r34.get();
    L94:
        if (r35 == null) goto L96;
        int r36 = r35.e;
    L97:
        if (r29 != null) goto L99;
    L101:
        boolean r37 = false;
    L102:
        if (r37 == false) goto L104;
        String r38 = "music";
    L105:
        String r39 = r38;
        if (r29 == null) goto L108;
        String r113 = r29.a;
    L109:
        String r40 = this.q;
        if (r40 != null) goto L112;
    L115:
        boolean r41 = true;
    L116:
        if (r41 == true) goto L118;
        String r42 = "creation_others";
    L122:
        tx9.x2.b(r42, r111, r33, r3, r36, r39, r113);
        goto L123
    L118:
        if (this.r != 2) goto L120;
        r42 = "creation_private";
        goto L122
    L120:
        r42 = "creation_list";
        goto L122
    L112:
        if (r40.length() == 0) goto L115;
        r41 = false;
        goto L116
    L108:
        r113 = null;
        goto L109
    L104:
        r38 = "pic";
        goto L105
    L99:
        if (r29.b != 1) goto L101;
        r37 = true;
        goto L102
    L96:
        r36 = 0;
        goto L97
    L93:
        r35 = null;
        goto L94
    L89:
        r33 = "1";
    L86:
        r32 = false;
    L123:
        if (r110 == null) goto L191;
        gs9.d r43 = this.t;
        if (r43 == null) goto L131;
        zp9.m r44 = r43.g;
        if (r44 == null) goto L131;
        if (r44.g() != true) goto L131;
        boolean r45 = true;
    L133:
        if ((!r45) == false) goto L135;
        UserCreation r46 = r110;
    L136:
        if (r46 == null) goto L191;
        String r47 = r46.a;
        String r210 = zp9.d.d(r46);
        String r211 = zp9.d.c(r46);
        AuthorInfo r48 = r46.g;
        if (r48 == null) goto L140;
        String r212 = r48.b;
    L141:
        String r213 = zp9.d.b(r46);
        Long r49 = r46.f;
        UserCreationTrackParams r50 = r46.n;
        if (r50 == null) goto L144;
        Integer r310 = r50.c;
    L145:
        if (r50 == null) goto L147;
        Integer r311 = r50.b;
    L148:
        if (r3 != (-1)) goto L150;
        String r51 = "click_template_list";
    L154:
        String r312 = r51;
    L156:
        if (r50 == null) goto L158;
        String r313 = r50.a;
    L159:
        gs9.d r52 = this.t;
        if (r52 == null) goto L167;
        gs9.b r53 = r52.f;
        if (r53 == null) goto L167;
        String r54 = r53.g;
        if (r54 == null) goto L167;
        String r314 = r54;
    L172:
        if (r50 == null) goto L174;
        String r315 = r50.d;
    L175:
        if (r50 == null) goto L177;
        String r316 = r50.e;
    L178:
        if (r50 == null) goto L180;
        String r317 = r50.f;
    L181:
        if (r50 == null) goto L183;
        String r214 = r50.g;
    L184:
        String r55 = r46.i;
        String r410 = zp9.d.c(r46);
        boolean r56 = r46.D();
        UserCreationRefContent r57 = r46.o;
        if (r57 == null) goto L189;
        List<ImageInfo> r58 = r57.a();
        if (r58 == null) goto L189;
        Integer r411 = Integer.valueOf(r58.size());
    L190:
        boolean r59 = r46.z();
        tx9.u3.g(r214, r47, r210, r211, r212, r213, r49, r311, r313, r312, r314, r310, null, null, r315, r317, r316, null, null, null, null, r55, r410, Boolean.valueOf(r56), r411, Boolean.valueOf(r59), zp9.d.e(r46), null, null, null, null, null, -264476672, 7);
    L189:
        r411 = null;
        goto L190
    L183:
        r214 = null;
        goto L184
    L180:
        r317 = null;
        goto L181
    L177:
        r316 = null;
        goto L178
    L174:
        r315 = null;
    L167:
        if (r52 == null) goto L171;
        gs9.b r60 = r52.f;
        if (r60 == null) goto L171;
        r314 = r60.b;
    L171:
        r314 = null;
        goto L172
    L158:
        r313 = null;
        goto L159
    L150:
        if (r3 >= r2) goto L152;
        r51 = "next";
        goto L154
    L152:
        if (r3 <= r2) goto L155;
        r51 = "previous";
        goto L154
    L155:
        r312 = "";
        goto L156
    L147:
        r311 = null;
        goto L148
    L144:
        r310 = null;
        goto L145
    L140:
        r212 = null;
        goto L141
    L135:
        r46 = null;
    L131:
        r45 = false;
    L191:
        if (r110 != null) goto L193;
    L195:
        boolean r61 = false;
    L196:
        if (r61 == false) goto L279;
        if (r110 == null) goto L203;
        UserCreationContent r62 = r110.e;
        if (r62 == null) goto L203;
        UserCreationMusic r63 = r62.b;
        if (r63 == null) goto L203;
        String r64 = r63.h;
    L205:
        if (Intrinsics.areEqual(r64, this.u) == true) goto L535;
        CreationGroupFragment r65 = ma0();
        if (r65 == null) goto L209;
        int r114 = ((CommonSlideFragment) r65).e;
    L210:
        String r66 = this.q;
        if (r66 != null) goto L213;
    L216:
        boolean r67 = true;
    L217:
        if (r67 == true) goto L219;
        String r68 = "creation_others";
    L223:
        if (r110 == null) goto L229;
        UserCreationContent r69 = r110.e;
        if (r69 == null) goto L229;
        UserCreationMusic r70 = r69.b;
        if (r70 == null) goto L229;
        String r71 = r70.h;
    L230:
        if (r110 == null) goto L235;
        String r72 = r110.a;
        if (r72 == null) goto L235;
        String r73 = r72;
    L236:
        CreationPagerViewModel r74 = oa0();
        if (r74 == null) goto L239;
        int r75 = r74.getCurrentIndexInFeedData();
    L240:
        String r76 = this.q;
        if (r76 != null) goto L243;
    L246:
        boolean r77 = true;
    L247:
        if (r77 == true) goto L249;
    L252:
        if (r110 == null) goto L259;
        Integer r79 = r110.d;
        if (r79 == null) goto L259;
        if (r79.intValue() != 2) goto L259;
        boolean r80 = true;
    L260:
        if (r80 == false) goto L262;
        String r115 = "0";
    L263:
        gs9.d r81 = this.t;
        if (r81 == null) goto L268;
        gs9.b r82 = r81.f;
        if (r82 == null) goto L268;
        String r116 = r82.d;
    L269:
        UserCreation r83 = r110;
        tx9.x2.c(r111, r3, r68, r71, r73, r75, r114, r115, r112, r116);
        if (r83 == null) goto L277;
        UserCreationContent r84 = r83.e;
        if (r84 == null) goto L277;
        UserCreationMusic r85 = r84.b;
        if (r85 == null) goto L277;
        String r86 = r85.h;
        if (r86 == null) goto L277;
    L278:
        this.u = r86;
    L277:
        r86 = "";
    L268:
        r116 = null;
        goto L269
    L262:
        r115 = "1";
    L259:
        r80 = false;
        goto L260
    L249:
        if (this.r != 2) goto L251;
        r112 = "creation_private";
        goto L252
    L251:
        r112 = "creation_list";
        goto L252
    L243:
        if (r76.length() == 0) goto L246;
        r77 = false;
        goto L247
    L239:
        r75 = 0;
    L235:
        r73 = "";
    L229:
        r71 = null;
        goto L230
    L219:
        if (this.r != 2) goto L221;
        r68 = "creation_private";
        goto L223
    L221:
        r68 = "creation_list";
        goto L223
    L213:
        if (r66.length() == 0) goto L216;
        r67 = false;
        goto L217
    L209:
        r114 = 0;
    L535:
        int r117 = r3;
        int r87 = 1;
        int r88 = 2;
    L402:
        boolean r89 = false;
    L536:
        gs9.d r90 = this.t;
        ?? r91 = r89;
        if (r90 == null) goto L542;
        gs9.f r92 = r90.c;
        r91 = r89;
        if (r92 == null) goto L542;
        r92.a(r2);
        r91 = r89;
    L542:
        Function4<? super Integer, ? super String, ? super Boolean, ? super List<UserCreationModel>, Unit> r93 = this.l;
        if (r93 == null) goto L563;
        CreationPagerViewModel r94 = oa0();
        if (r94 == null) goto L547;
        int r118 = r94.getCurrentIndex();
    L548:
        Integer r95 = Integer.valueOf(r118);
        CreationPagerViewModel r96 = oa0();
        if (r96 == null) goto L552;
        String r97 = r96.getCursor();
        if (r97 == null) goto L552;
    L553:
        CreationPagerViewModel r98 = oa0();
        if (r98 == null) goto L556;
        boolean r119 = r98.getHasmore();
    L557:
        Boolean r99 = Boolean.valueOf(r119);
        CreationPagerViewModel r100 = oa0();
        if (r100 == null) goto L561;
        List<UserCreationModel> r101 = r100.getCurrentCreationList();
        if (r101 == null) goto L561;
    L562:
        r93.invoke(r95, r97, r99, r101);
    L561:
        r101 = new ArrayList();
        goto L562
    L556:
        r119 = false;
    L552:
        r97 = "";
        goto L553
    L547:
        r118 = 0;
    L563:
        CreationGroupFragment r102 = ma0();
        if (r102 == null) goto L566;
        WeakReference<CommonSlideFragment<?>> r103 = new WeakReference(r102);
    L567:
        this.v = r103;
        if (r117 == r2) goto L579;
        if (r103 == null) goto L571;
        CommonSlideFragment<?> r104 = r103.get();
    L572:
        if (r104 == null) goto L579;
        LarusFragmentCommonSlideBinding r105 = r104.d;
        if (r105 == null) goto L578;
        ViewPager2 r106 = r105.c;
        if (r106 == null) goto L578;
        r106.setCurrentItem(r104.V90(), r91);
    L578:
        int r107 = r104.V90();
        r104.e = r107;
        r104.f = r107;
        goto L579
    L571:
        r104 = null;
    L579:
        CreationOutPagerAdapter r108 = this.j;
        if (r108 == null) goto L588;
        List<UserCreationModel> r109 = r108.b;
        if (r109 == null) goto L588;
        UserCreationModel r120 = (UserCreationModel) CollectionsKt.getOrNull(r109, r2);
        if (r120 == null) goto L588;
        List<UserCreation> r121 = r120.b();
        if (r121 == null) goto L588;
        UserCreation r122 = (UserCreation) CollectionsKt.firstOrNull(r121);
    L589:
        if (r122 != null) goto L591;
    L593:
        boolean r123 = false;
    L594:
        if (r123 == true) goto L602;
        Integer[] r124 = new Integer[r88];
        r124[r91] = Integer.valueOf(r87);
        r124[r87] = Integer.valueOf(r91);
        List r125 = CollectionsKt.listOf(r124);
        if (r122 == null) goto L598;
        Integer r126 = Integer.valueOf(r122.b);
    L600:
        if (CollectionsKt.contains(r125, r126) == true) goto L602;
        boolean r127 = true;
    L603:
        if (r122 != null) goto L605;
    L607:
        boolean r128 = false;
    L608:
        if (r128 == true) goto L610;
    L614:
        boolean r129 = false;
    L615:
        sq9.r r130 = com.larus.platform.service.z2.a.getCreationEditControlConfig().a();
        if (r130 == null) goto L623;
        Integer r131 = r130.b();
        if (r131 == null) goto L623;
        if (r131.intValue() != r87) goto L623;
    L624:
        if (r87 == 0) goto L643;
        if (r127 == true) goto L627;
    L632:
        if (r129 == false) goto L643;
    L633:
        LarusFragmentCommonSlideBinding r132 = ((CommonSlideDialogFragment) this).d;
        if (r132 == null) goto L638;
        ImageView r133 = r132.g;
        if (r133 == null) goto L638;
        ViewExtKt.e(r133);
    L638:
        LarusFragmentCommonSlideBinding r134 = ((CommonSlideDialogFragment) this).d;
        if (r134 == null) goto L679;
        ImageView r135 = r134.f;
        if (r135 == null) goto L680;
        ViewExtKt.e(r135);
        return;
    L680:
        return;
    L679:
        return;
    L627:
        if (this.r != r88) goto L632;
        if (((Boolean) this.y.getValue()).booleanValue() == true) goto L633;
        if (((com.larus.bmhome.actionbar.model.z0) this.C.getValue()) != null) goto L633;
    L643:
        la0();
        ia0();
        return;
    L623:
        r87 = 0;
        goto L624
    L610:
        if (r122.b == 12) goto L614;
        if (com.larus.platform.service.z2.a.getCreationExtendVideoConfig().b() == false) goto L614;
        r129 = true;
        goto L615
    L605:
        if (zp9.d.f(r122) != r87) goto L607;
        r128 = true;
        goto L608
    L598:
        r126 = null;
    L602:
        r127 = false;
        goto L603
    L591:
        if (zp9.d.f(r122) != r87) goto L593;
        r123 = true;
    L588:
        r122 = null;
        goto L589
    L566:
        r103 = null;
    L203:
        r64 = null;
        goto L205
    L279:
        UserCreation r136 = r110;
        if (r3 == r2) goto L535;
        CreationGroupFragment r137 = ma0();
        if (r137 == null) goto L284;
        int r138 = ((CommonSlideFragment) r137).e;
    L285:
        if (r136 == null) goto L287;
        Integer r139 = Integer.valueOf(r136.b);
    L288:
        gs9.d r140 = this.t;
        if (r140 == null) goto L296;
        gs9.b r141 = r140.f;
        if (r141 == null) goto L296;
        String r142 = r141.e;
        if (r142 == null) goto L296;
        String r143 = r142;
    L309:
        if (r136 == null) goto L314;
        String r144 = r136.a;
        if (r144 == null) goto L314;
        String r145 = r144;
    L315:
        CreationPagerViewModel r146 = oa0();
        if (r146 == null) goto L318;
        int r147 = r146.getCurrentIndexInFeedData();
    L319:
        String r148 = this.q;
        if (r148 != null) goto L322;
    L325:
        boolean r149 = true;
    L326:
        if (r149 == true) goto L328;
        String r150 = "creation_others";
    L333:
        if (r139 != null) goto L336;
    L338:
        boolean r151 = false;
    L339:
        if (r136 == null) goto L346;
        Integer r152 = r136.d;
        if (r152 == null) goto L346;
        if (r152.intValue() != 2) goto L346;
        boolean r153 = true;
    L347:
        if (r153 == false) goto L349;
        String r154 = "0";
    L351:
        if (r139 != null) goto L354;
    L356:
        boolean r155 = false;
    L357:
        gs9.d r156 = this.t;
        if (r156 == null) goto L362;
        gs9.b r157 = r156.f;
        if (r157 == null) goto L362;
        String r215 = r157.d;
    L363:
        if (r156 == null) goto L367;
        gs9.b r158 = r156.f;
        if (r158 == null) goto L367;
        String r216 = r158.f;
    L368:
        boolean r159 = r155;
        r117 = r3;
        r87 = 1;
        tx9.x2.d(r111, r3, r143, r145, r147, r138, r150, r154, r151, r159, r215, r216);
        sq9.r r160 = com.larus.platform.service.z2.a.getCreationEditControlConfig().a();
        if (r160 == null) goto L376;
        Integer r161 = r160.b();
        if (r161 == null) goto L376;
        if (r161.intValue() != 1) goto L376;
        boolean r162 = true;
    L377:
        if (r162 == false) goto L399;
        if (r136 != null) goto L380;
    L382:
        boolean r163 = false;
    L383:
        if (r163 == true) goto L399;
        if (r136 != null) goto L386;
    L388:
        boolean r164 = false;
    L389:
        if (r164 == true) goto L399;
        if (ICommunityService.a.f1().c() == true) goto L399;
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L395;
    L396:
        r88 = 2;
        if (this.r != 2) goto L400;
        boolean r165 = true;
    L401:
        if (r165 == false) goto L402;
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L429;
        hy9.d r217 = IUgcAIGCService.a.j();
        Context r166 = getContext();
        if (r166 == null) goto L408;
        String r218 = r166.getString(2131906324);
    L409:
        com.larus.bmhome.actionbar.model.z0 r167 = (com.larus.bmhome.actionbar.model.z0) this.x.getValue();
        if (r167 == null) goto L416;
        com.larus.bmhome.actionbar.model.r r168 = r167.q;
        if (r168 == null) goto L416;
        Integer r169 = r168.a;
        if (r169 == null) goto L416;
        String r318 = r169.toString();
    L417:
        com.larus.bmhome.actionbar.model.z0 r170 = (com.larus.bmhome.actionbar.model.z0) this.x.getValue();
        if (r170 == null) goto L422;
        com.larus.bmhome.actionbar.model.r r171 = r170.q;
        if (r171 == null) goto L422;
        String r319 = r171.g;
    L424:
        if (this.r != r88) goto L426;
        String r320 = "creation_private";
    L427:
        hy9.d.a.b(r217, r218, null, null, "picture_detail", "edit_entrance", null, null, r318, r319, r320, null, null, null, null, null, null, null, null, 1047654);
        goto L429
    L426:
        r320 = "creation_list";
    L422:
        r319 = null;
    L416:
        r318 = null;
        goto L417
    L408:
        r218 = null;
    L429:
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L498;
        IUgcAIGCService.Companion r172 = IUgcAIGCService.a;
        hy9.d r219 = r172.j();
        Context r173 = getContext();
        if (r173 == null) goto L433;
        String r220 = r173.getString(2131906330);
    L434:
        com.larus.bmhome.actionbar.model.z0 r174 = na0();
        if (r174 == null) goto L441;
        com.larus.bmhome.actionbar.model.r r175 = r174.q;
        if (r175 == null) goto L441;
        Integer r176 = r175.a;
        if (r176 == null) goto L441;
        String r321 = r176.toString();
    L442:
        com.larus.bmhome.actionbar.model.z0 r177 = na0();
        if (r177 == null) goto L447;
        com.larus.bmhome.actionbar.model.r r178 = r177.q;
        if (r178 == null) goto L447;
        String r322 = r178.g;
    L449:
        if (this.r != r88) goto L451;
        String r323 = "creation_private";
    L452:
        hy9.d.a.b(r219, r220, null, null, "picture_detail", "single_function", null, null, r321, r322, r323, null, null, null, null, null, null, null, null, 1047654);
        hy9.d r510 = r172.j();
        Context r179 = getContext();
        if (r179 == null) goto L455;
        String r511 = r179.getString(2131906326);
    L456:
        com.larus.bmhome.actionbar.model.z0 r180 = na0();
        if (r180 == null) goto L463;
        com.larus.bmhome.actionbar.model.r r181 = r180.q;
        if (r181 == null) goto L463;
        Integer r182 = r181.a;
        if (r182 == null) goto L463;
        String r610 = r182.toString();
    L464:
        com.larus.bmhome.actionbar.model.z0 r183 = na0();
        if (r183 == null) goto L469;
        com.larus.bmhome.actionbar.model.r r184 = r183.q;
        if (r184 == null) goto L469;
        String r611 = r184.g;
    L471:
        if (this.r != r88) goto L473;
        String r612 = "creation_private";
    L474:
        hy9.d.a.b(r510, r511, null, null, "picture_detail", "single_function", null, null, r610, r611, r612, null, null, null, null, null, null, null, null, 1047654);
        hy9.d r221 = r172.j();
        Context r185 = getContext();
        if (r185 == null) goto L477;
        String r222 = r185.getString(2131906329);
    L478:
        com.larus.bmhome.actionbar.model.z0 r186 = na0();
        if (r186 == null) goto L485;
        com.larus.bmhome.actionbar.model.r r187 = r186.q;
        if (r187 == null) goto L485;
        Integer r188 = r187.a;
        if (r188 == null) goto L485;
        String r324 = r188.toString();
    L486:
        com.larus.bmhome.actionbar.model.z0 r189 = na0();
        if (r189 == null) goto L491;
        com.larus.bmhome.actionbar.model.r r190 = r189.q;
        if (r190 == null) goto L491;
        String r325 = r190.g;
    L493:
        if (this.r != r88) goto L495;
        String r326 = "creation_private";
    L496:
        hy9.d.a.b(r221, r222, null, null, "picture_detail", "single_function", null, null, r324, r325, r326, null, null, null, null, null, null, null, null, 1047654);
        goto L498
    L495:
        r326 = "creation_list";
    L491:
        r325 = null;
    L485:
        r324 = null;
        goto L486
    L477:
        r222 = null;
        goto L478
    L473:
        r612 = "creation_list";
    L469:
        r611 = null;
    L463:
        r610 = null;
        goto L464
    L455:
        r511 = null;
        goto L456
    L451:
        r323 = "creation_list";
    L447:
        r322 = null;
    L441:
        r321 = null;
        goto L442
    L433:
        r220 = null;
    L498:
        if (((Boolean) this.z.getValue()).booleanValue() == false) goto L523;
        hy9.d r223 = IUgcAIGCService.a.j();
        Context r191 = getContext();
        if (r191 == null) goto L502;
        String r224 = r191.getString(2131906331);
    L503:
        com.larus.bmhome.actionbar.model.z0 r192 = (com.larus.bmhome.actionbar.model.z0) this.C.getValue();
        if (r192 == null) goto L510;
        com.larus.bmhome.actionbar.model.r r193 = r192.q;
        if (r193 == null) goto L510;
        Integer r194 = r193.a;
        if (r194 == null) goto L510;
        String r327 = r194.toString();
    L511:
        com.larus.bmhome.actionbar.model.z0 r195 = (com.larus.bmhome.actionbar.model.z0) this.C.getValue();
        if (r195 == null) goto L516;
        com.larus.bmhome.actionbar.model.r r196 = r195.q;
        if (r196 == null) goto L516;
        String r328 = r196.g;
    L518:
        if (this.r != r88) goto L520;
        String r329 = "creation_private";
    L521:
        hy9.d.a.b(r223, r224, null, null, "picture_detail", "single_function", null, null, r327, r328, r329, null, null, null, null, null, null, null, null, 1047654);
        goto L523
    L520:
        r329 = "creation_list";
    L516:
        r328 = null;
    L510:
        r327 = null;
        goto L511
    L502:
        r224 = null;
    L523:
        if (((Boolean) this.A.getValue()).booleanValue() == false) goto L402;
        Integer[] r197 = new Integer[5];
        r89 = false;
        r89 = false;
        r197[0] = 6;
        r197[1] = 7;
        r197[r88] = 9;
        r197[3] = 8;
        r197[4] = 11;
        List r198 = CollectionsKt.listOf(r197);
        if (r136 == null) goto L527;
        Integer r199 = Integer.valueOf(r136.b);
    L529:
        if (CollectionsKt.contains(r198, r199) == false) goto L536;
        hy9.d r225 = IUgcAIGCService.a.j();
        Context r200 = getContext();
        if (r200 == null) goto L533;
        String r226 = r200.getString(2131905605);
    L534:
        ChatControlTrace r201 = ChatControlTrace.b;
        r201.getClass();
        hy9.d.a.b(r225, r226, null, null, "video_detail", "single_function", null, null, null, null, r201.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, 1048038);
        goto L536
    L533:
        r226 = null;
        goto L534
    L527:
        r199 = null;
    L400:
        r165 = false;
        goto L401
    L395:
        if (((Boolean) this.z.getValue()).booleanValue() == false) goto L399;
    L386:
        if (r136.b != 0) goto L388;
        r164 = true;
        goto L389
    L380:
        if (r136.b != 1) goto L382;
        r163 = true;
    L399:
        r88 = 2;
    L376:
        r162 = false;
    L367:
        r216 = null;
    L362:
        r215 = null;
        goto L363
    L354:
        if (r139.intValue() != 4) goto L356;
        r155 = true;
        goto L357
    L349:
        r154 = "1";
    L346:
        r153 = false;
        goto L347
    L336:
        if (r139.intValue() != 3) goto L338;
        r151 = true;
        goto L339
    L328:
        if (this.r != 2) goto L330;
        r150 = "creation_private";
        goto L333
    L330:
        r150 = "creation_list";
        goto L333
    L322:
        if (r148.length() == 0) goto L325;
        r149 = false;
        goto L326
    L318:
        r147 = 0;
    L314:
        r145 = "";
    L296:
        String r202 = this.q;
        if (r202 != null) goto L299;
    L302:
        boolean r203 = true;
    L303:
        if (r203 == true) goto L305;
        r143 = "creation_others";
        goto L309
    L305:
        if (this.r != 2) goto L307;
        r143 = "creation_private";
        goto L309
    L307:
        r143 = "creation_list";
        goto L309
    L299:
        if (r202.length() == 0) goto L302;
        r203 = false;
        goto L303
    L287:
        r139 = null;
        goto L288
    L284:
        r138 = 0;
        goto L285
    L193:
        if (r110.b != 1) goto L195;
        r61 = true;
        goto L196
    L541:
        r117 = r3;
        r87 = 1;
        r88 = 2;
        r91 = 0;
        goto L542
    L74:
        r30 = "down";
        goto L75
    L69:
        r28 = 0;
        goto L70
    L66:
        r27 = null;
        goto L67
    L71:
        r29 = null;
        goto L72
    L58:
        r24 = 0;
        goto L59
    L60:
        r110 = null;
        goto L61
    L26:
        r12 = 0;
        goto L27
    L22:
        r10 = 0;
    L29:
        r13 = false;
        goto L30
    L16:
        r8 = 0;
        goto L18
    L645:
        if ((r78 instanceof CommonSlideDialogFragment.b.b) == false) goto L653;
        CreationGroupFragment r204 = ma0();
        if ((r204 instanceof g19.a) == false) goto L649;
        CreationGroupFragment r205 = r204;
    L650:
        if (r205 == null) goto L683;
        r205.o1();
        return;
    L683:
        return;
    L649:
        r205 = null;
        goto L650
    L653:
        if ((r78 instanceof CommonSlideDialogFragment.b.e) == false) goto L661;
        CreationGroupFragment r206 = ma0();
        if ((r206 instanceof g19.a) == false) goto L657;
        CreationGroupFragment r207 = r206;
    L658:
        if (r207 == null) goto L685;
        r207.d70();
        return;
    L685:
        return;
    L657:
        r207 = null;
        goto L658
    L661:
        if ((r78 instanceof CommonSlideDialogFragment.b.c) == false) goto L669;
        CreationGroupFragment r208 = ma0();
        if ((r208 instanceof g19.a) == false) goto L665;
        CreationGroupFragment r209 = r208;
    L666:
        if (r209 == null) goto L687;
        r209.VT();
        return;
    L687:
        return;
    L665:
        r209 = null;
        goto L666
    L669:
        if ((r78 instanceof CommonSlideDialogFragment.b.a) == false) goto L678;
        CreationGroupFragment r227 = ma0();
        if ((r227 instanceof g19.a) == false) goto L673;
        CreationGroupFragment r228 = r227;
    L674:
        if (r228 == null) goto L689;
        r228.FU(((CommonSlideDialogFragment.b.a) r78).a);
        return;
    L689:
        return;
    L673:
        r228 = null;
        goto L674
    L678:
        throw new NoWhenBranchMatchedException();
    }

    public final void pa0(List<UserCreationModel> r9) {
        FLogger.a.i("CreationPagerFragment", "initViewModel visitId is " + this.q);
        CreationPagerViewModel r0 = oa0();
        if (r0 == null) goto L5;
        r0.initParams(this.t);
    L5:
        CreationPagerViewModel r1 = oa0();
        if (r1 == null) goto L8;
        r1.setCursor(this.n);
    L8:
        CreationPagerViewModel r2 = oa0();
        if (r2 == null) goto L11;
        r2.setHasmore(this.o);
    L11:
        CreationPagerViewModel r3 = oa0();
        if (r3 == null) goto L14;
        r3.setCreationMode(this.r);
    L14:
        CreationPagerViewModel r4 = oa0();
        if (r4 == null) goto L17;
        CreationPagerViewModel.updateFeedData$default(r4, r9, Integer.valueOf(this.m), null, 4, null);
    L17:
        CreationPagerViewModel r10 = oa0();
        if (r10 == null) goto L22;
        MutableLiveData<List<UserCreationModel>> r11 = r10.getFeedData();
        if (r11 == null) goto L22;
        r11.observe(getViewLifecycleOwner(), new b(new j1(this)));
    L22:
        CreationPagerViewModel r12 = oa0();
        if (r12 == null) goto L27;
        MutableLiveData<List<UserCreationModel>> r13 = r12.getRealCreationList();
        if (r13 == null) goto L27;
        r13.observe(getViewLifecycleOwner(), new b(new k1(this)));
    L27:
        LarusFragmentCommonSlideBinding r14 = ((CommonSlideDialogFragment) this).d;
        if (r14 == null) goto L33;
        ImageView r15 = r14.g;
        if (r15 == null) goto L34;
        r15.setVisibility(4);
        return;
    L34:
        return;
    }

    @Override // gs9.g
    public final void ax(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "tag");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super/*androidx.fragment.app.DialogFragment*/.show(r2, r3);
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LarusFragmentCommonSlideBinding r4 = ((CommonSlideDialogFragment) this).d;
        if (r4 == null) goto L5;
        ViewPager2 r5 = r4.c;
    L6:
        if (r5 == null) goto L9;
        r5.setUserInputEnabled(!this.s);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        LarusFragmentCommonSlideBinding r6 = ((CommonSlideDialogFragment) this).d;
        if (r6 == null) goto L5;
        ViewPager2 r7 = r6.c;
    L6:
        if (r7 == null) goto L8;
        r7.post(new i1(this));
    L8:
        return r5;
    L5:
        r7 = null;
        goto L6
    }
}
