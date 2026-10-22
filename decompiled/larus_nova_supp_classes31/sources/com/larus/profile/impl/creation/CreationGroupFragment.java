package com.larus.profile.impl.creation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.common_ui.fragment.CommonSlideFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.profile.impl.databinding.LarusCreationPagerLayoutBinding;
import com.larus.profile.impl.viewmodel.CreationPagerViewModel;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0083\u0001\u0018\u0000 \u008a\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u008a\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010D\u001a\u00020\fH\u0016J\u0010\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000206H\u0016J\u0018\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u0013H\u0002J\u001a\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u000e\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u000206J\n\u0010S\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010\u00162\u0006\u0010U\u001a\u00020\fH\u0002J\b\u0010V\u001a\u00020\u0013H\u0002J\u001a\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020\u00132\b\b\u0002\u0010Y\u001a\u00020\fH\u0002J+\u0010Z\u001a\u00020*2\u0006\u0010X\u001a\u00020\u00132\n\b\u0001\u0010[\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010Y\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\\J\u0012\u0010]\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J&\u0010^\u001a\u0004\u0018\u00010N2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010c\u001a\u00020*2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020*H\u0016J\b\u0010g\u001a\u00020*H\u0016J\n\u0010h\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH\u0016J\b\u0010k\u001a\u000206H\u0016J\n\u0010l\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010m\u001a\u00020\fH\u0016J\u0010\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u000206H\u0016J\u001a\u0010p\u001a\u00020*2\u0006\u0010q\u001a\u00020\f2\b\b\u0002\u0010r\u001a\u000206H\u0002J\b\u0010s\u001a\u00020*H\u0016J\b\u0010t\u001a\u0004\u0018\u00010uJ\u0006\u0010v\u001a\u00020*J\u0006\u0010w\u001a\u00020*J\u0006\u0010x\u001a\u00020*J\b\u0010y\u001a\u00020*H\u0002J\b\u0010z\u001a\u00020*H\u0002J\b\u0010{\u001a\u00020*H\u0002J\b\u0010|\u001a\u00020*H\u0016J\b\u0010}\u001a\u00020*H\u0016J\b\u0010~\u001a\u00020*H\u0016J\u0011\u0010\u007f\u001a\u00020*2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0016J \u0010\u0087\u0001\u001a\u00020*2\t\b\u0002\u0010\u0088\u0001\u001a\u00020\f2\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0086\u0001H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\"\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00107\"\u0004\b8\u00109R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b;\u00107R\u001b\u0010>\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\b?\u00107R\u001b\u0010A\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010=\u001a\u0004\bB\u00107R\u000f\u0010\u0081\u0001\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0084\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/profile/impl/creation/CreationGroupFragment;", "Lcom/larus/common_ui/fragment/CommonSlideFragment;", "Lcom/larus/profile/impl/databinding/LarusCreationPagerLayoutBinding;", "Lcom/larus/profile/impl/creation/ICreationDelegateInterface;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "<init>", "()V", "binding", "pagerAdapter", "Lcom/larus/profile/impl/creation/CreationInnerPagerAdapter;", "fragmentMap", "", "", "Landroidx/fragment/app/Fragment;", "getFragmentMap", "()Ljava/util/Map;", "setFragmentMap", "(Ljava/util/Map;)V", "preReportVid", "", "initList", "", "Lcom/larus/platform/api/creation/UserCreation;", "getInitList", "()Ljava/util/List;", "setInitList", "(Ljava/util/List;)V", "initPosition", "getInitPosition", "()I", "setInitPosition", "(I)V", "visitId", "getVisitId", "()Ljava/lang/String;", "setVisitId", "(Ljava/lang/String;)V", "creationStyle", "getCreationStyle", "setCreationStyle", "selfDismissed", "Lkotlin/Function0;", "", "getSelfDismissed", "()Lkotlin/jvm/functions/Function0;", "setSelfDismissed", "(Lkotlin/jvm/functions/Function0;)V", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "isShowLeftCreationView", "", "()Z", "setShowLeftCreationView", "(Z)V", "hasCreateImageAbility", "getHasCreateImageAbility", "hasCreateImageAbility$delegate", "Lkotlin/Lazy;", "hasDetailImageEditAbility", "getHasDetailImageEditAbility", "hasDetailImageEditAbility$delegate", "hasCreateVideoAbility", "getHasCreateVideoAbility", "hasCreateVideoAbility$delegate", "getDirection", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideFragment$ContainerEvent;", "showEditPanel", "sendMobCreationSlide", "previous", "status", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "enableShareAction", "enable", "getCurrentCreation", "getCreationByIndex", "index", "getCurrentCreationId", "traceEnterMusicDetail", "slideStatus", "prePos", "traceEnterPictureDetail", "creationType", "(Ljava/lang/String;Ljava/lang/Integer;I)V", "initView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateCreationContent", "content", "Lcom/larus/platform/api/ModifiedUserCreationMusic;", "onDetach", "onDestroyView", "initViewBinding", "getPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "needCommonSlide", "getCurrentFragment", "getInitItemPosition", "setCreationPrivacy", "private", "updateCreationModelPrivacy", "privacy", "splitMode", "deleteCreation", "getShareContainer", "Landroid/widget/FrameLayout;", "dismissScreenView", "showScreenView", "showOrDismissExtraView", "showOrDismissLeftEditView", "showLeftEditViewWithPinch", "dismissLeftEditViewWithPinch", "onMoreClick", "onShareClick", "onScroll", "onDoCreationAction", "action", "isFirstOnPageChangeCalled", "onPageChangeCallback", "com/larus/profile/impl/creation/CreationGroupFragment$onPageChangeCallback$1", "Lcom/larus/profile/impl/creation/CreationGroupFragment$onPageChangeCallback$1;", "currentEditPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "bindEditPanel", "position", "defaultType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationGroupFragment extends CommonSlideFragment<LarusCreationPagerLayoutBinding> implements j2, g19.a {
    public static final /* synthetic */ int y = 0;
    public LarusCreationPagerLayoutBinding i;
    public CreationInnerPagerAdapter j;
    public final Map<Integer, Fragment> k;
    public String l;
    public List<UserCreation> m;
    public String n;
    public int o;
    public final t p;
    public gs9.d q;
    public boolean r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public boolean v;
    public final CreationGroupFragment$onPageChangeCallback$1 w;
    public EditPanelType x;

    public static final class a {
    }

    static {
    }

    public final void Oh() {
    }

    public final int U90() {
        return 0;
    }

    public final int V90() {
        return 0;
    }

    public final void u() {
    }

    public final FragmentStateAdapter W90() {
        if (this.j != null) goto L6;
        this.j = new CreationInnerPagerAdapter(this);
    L6:
        return this.j;
    }

    public final UserCreation aa0() {
        int r0 = ((CommonSlideFragment) this).e;
        if (r0 < 0) goto L13;
        List<UserCreation> r1 = this.m;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r0 >= r2) goto L13;
        List<UserCreation> r3 = this.m;
        if (r3 == null) goto L13;
        return (UserCreation) ListProtector.get(r3, r0);
    L7:
        r2 = 0;
    L13:
        return null;
    }

    public final g19.a ba0() {
        LarusFragmentCommonSlideBinding r2 = ((CommonSlideFragment) this).d;     // Catch: Exception -> L20
        if (r2 == null) goto L6;
        ViewPager2 r3 = r2.c;     // Catch: Exception -> L20
    L7:
        if (r3 == null) goto L22;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L20
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L20
        if (r5 == null) goto L15;
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L20
        CreationInnerPagerAdapter r0 = this.j;     // Catch: Exception -> L20
        if (r0 == null) goto L13;
        Long r1 = Long.valueOf(r0.getItemId(r4));     // Catch: Exception -> L20
    L14:
        r6.append(r1);     // Catch: Exception -> L20
        Fragment r7 = r5.findFragmentByTag(r6.toString());     // Catch: Exception -> L20
    L17:
        if ((r7 instanceof g19.a) == false) goto L27;
        return (g19.a) r7;
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
        FLogger.a.e("CreationGroupFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final void ca0() {
        LarusCreationPagerLayoutBinding r0 = this.i;
        boolean r1 = false;
        if (r0 == null) goto L9;
        NumericIndicator r2 = r0.c;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 4) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L15;
        LarusCreationPagerLayoutBinding r3 = this.i;
        if (r3 == null) goto L15;
        NumericIndicator r4 = r3.c;
        if (r4 == null) goto L15;
        ViewExtKt.d(r4);
    L15:
        CreationPagerFragment r5 = getParentFragment();
        CreationPagerFragment r6 = null;
        if ((r5 instanceof CreationPagerFragment) == false) goto L18;
        CreationPagerFragment r7 = r5;
    L19:
        if (r7 == null) goto L22;
        r7.ha0();
    L22:
        if (this.r == false) goto L28;
        LarusCreationPagerLayoutBinding r8 = this.i;
        if (r8 == null) goto L40;
        LeftCreationEditView r9 = r8.b;
        if (r9 == null) goto L41;
        ViewExtKt.d(r9);
        return;
    L41:
        return;
    L40:
        return;
    L28:
        CreationPagerFragment r10 = getParentFragment();
        if ((r10 instanceof CreationPagerFragment) == false) goto L31;
        CreationPagerFragment r11 = r10;
    L32:
        if (r11 == null) goto L34;
        r11.la0();
    L34:
        Fragment r12 = getParentFragment();
        if ((r12 instanceof CreationPagerFragment) == false) goto L37;
        r6 = (CreationPagerFragment) r12;
    L37:
        if (r6 == null) goto L43;
        r6.ia0();
        return;
    L43:
        return;
    L31:
        r11 = null;
        goto L32
    L18:
        r7 = null;
        goto L19
    }

    public final void onDestroyView() {
        ((LinkedHashMap) this.k).clear();
        this.j = null;
        this.i = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.profile.impl.creation.t] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.profile.impl.creation.CreationGroupFragment$onPageChangeCallback$1] */
    public CreationGroupFragment() {
        this.k = new LinkedHashMap();
        this.l = "";
        this.n = "";
        this.p = new t();
        this.s = LazyKt.lazy(new u());
        this.t = LazyKt.lazy(new v());
        this.u = LazyKt.lazy(new w());
        this.w = new CreationGroupFragment$onPageChangeCallback$1(this);
        this.x = EditPanelType.NONE;
    }

    public final void VT() {
        g19.a r0 = ba0();
        if (r0 == null) goto L6;
        r0.VT();
        return;
    }

    public final ViewBinding Y90() {
        ConstraintLayout r0 = getLayoutInflater().inflate(2131562004, null, false);
        int r1 = 2131368259;
        LeftCreationEditView r2 = ViewBindings.findChildViewById(r0, 2131368259);
        if (r2 == null) goto L11;
        r1 = 2131381076;
        NumericIndicator r3 = ViewBindings.findChildViewById(r0, 2131381076);
        if (r3 == null) goto L11;
        r1 = 2131386121;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386121);
        if (r4 == null) goto L11;
        LarusCreationPagerLayoutBinding r5 = new LarusCreationPagerLayoutBinding(r0, r2, r3, r4);
        this.i = r5;
        return r5;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void d70() {
        g19.a r0 = ba0();
        if (r0 == null) goto L6;
        r0.d70();
        return;
    }

    @Override // com.larus.profile.impl.creation.j2
    public final void fB() {
        UserCreation r0 = aa0();
        List<UserCreation> r1 = this.m;
        if (r1 == null) goto L5;
        TypeIntrinsics.asMutableCollection(r1).remove(r0);
    L5:
        CreationInnerPagerAdapter r2 = this.j;
        if (r2 == null) goto L11;
        List<UserCreation> r3 = this.m;
        if (r3 != null) goto L10;
        r3 = new ArrayList();
    L10:
        r2.y2(r3);
    L11:
        LarusCreationPagerLayoutBinding r4 = this.i;
        if (r4 == null) goto L20;
        NumericIndicator r5 = r4.c;
        if (r5 == null) goto L20;
        List<UserCreation> r6 = this.m;
        if (r6 == null) goto L18;
        int r7 = r6.size();
    L19:
        r5.setTotalCount(r7);
        r5.x(((CommonSlideFragment) this).e + 1);
        goto L20
    L18:
        r7 = 1;
    L20:
        CreationPagerFragment r8 = getParentFragment();
        if ((r8 instanceof CreationPagerFragment) == false) goto L23;
        CreationPagerFragment r9 = r8;
    L24:
        if (r9 == null) goto L29;
        int r10 = ((CommonSlideFragment) this).e;
        CreationPagerViewModel r11 = r9.oa0();
        if (r11 == null) goto L30;
        r11.deleteCreation(r10);
        return;
    L30:
        return;
    L29:
        return;
    L23:
        r9 = null;
        goto L24
    }

    public final void o1() {
        g19.a r0 = ba0();
        if (r0 == null) goto L6;
        r0.o1();
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        if (this.p == null) goto L6;
        Unit r0 = Unit.INSTANCE;
        return;
    }

    public final EditPanelType SQ() {
        return EditPanelType.NONE;
    }

    public final boolean dc() {
        return this.r;
    }

    public final void FU(int r2) {
        g19.a r0 = ba0();
        if (r0 == null) goto L6;
        r0.FU(r2);
        return;
    }

    @Override // com.larus.profile.impl.creation.j2
    public final void J50(ModifiedUserCreationMusic r14) {
        FLogger.a.i("CreationGroupFragment", "updateCreationContent content is " + r14);
        CreationPagerFragment r0 = null;
        if (r14 == null) goto L5;
        String r1 = r14.a;
    L6:
        if (r14 == null) goto L8;
        ImageInfo r2 = r14.b;
    L9:
        if (r14 == null) goto L11;
        String r3 = r14.c;
    L72:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        List<UserCreation> r5 = this.m;     // Catch: Throwable -> L19
        if (r5 == null) goto L16;
        UserCreation r6 = (UserCreation) ListProtector.get(r5, ((CommonSlideFragment) this).e);     // Catch: Throwable -> L19
        if (r6 == null) goto L16;
    L17:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L19
    L22:
        if (Result.exceptionOrNull-impl(r7) == null) goto L25;
        r7 = null;
    L25:
        UserCreation r8 = (UserCreation) r7;
        if (r8 != null) goto L28;
        return;
    L28:
        UserCreationContent r9 = r8.e;
        if (r9 == null) goto L31;
        UserCreationContent r10 = UserCreationContent.a(r9, null, null, null, null, 63);
    L32:
        UserCreation r11 = UserCreation.c(r8, null, r10, null, null, null, null, 131055);
        UserCreationContent r12 = r11.e;
        if (r12 == null) goto L41;
        UserCreationContent r13 = r8.e;
        if (r13 == null) goto L39;
        UserCreationMusic r15 = r13.b;
        if (r15 == null) goto L39;
        UserCreationMusic r16 = UserCreationMusic.a(r15);
    L40:
        r12.b = r16;
    L39:
        r16 = null;
    L41:
        if (r2 == null) goto L48;
        UserCreationContent r17 = r11.e;
        if (r17 == null) goto L48;
        UserCreationMusic r18 = r17.b;
        if (r18 == null) goto L48;
        r18.d = r2;
    L48:
        if (com.larus.utils.o0.d(r1) == false) goto L55;
        UserCreationContent r19 = r11.e;
        if (r19 == null) goto L55;
        UserCreationMusic r20 = r19.b;
        if (r20 == null) goto L55;
        r20.b = r1;
    L55:
        if (com.larus.utils.o0.d(r3) == false) goto L61;
        UserCreationContent r21 = r11.e;
        if (r21 == null) goto L61;
        UserCreationMusic r22 = r21.b;
        if (r22 == null) goto L61;
        r22.f = r3;
    L61:
        List<UserCreation> r23 = this.m;
        if (r23 == null) goto L64;
        UserCreation r24 = (UserCreation) ListProtector.set(r23, ((CommonSlideFragment) this).e, r11);
    L64:
        Fragment r25 = getParentFragment();
        if ((r25 instanceof CreationPagerFragment) == false) goto L67;
        r0 = (CreationPagerFragment) r25;
    L67:
        if (r0 == null) goto L74;
        int r26 = ((CommonSlideFragment) this).e;
        CreationPagerViewModel r27 = r0.oa0();
        if (r27 == null) goto L75;
        r27.updateCreationContent(r14, r26);
        return;
    L75:
        return;
    L74:
        return;
    L31:
        r10 = null;
    L16:
        r6 = null;
    L19:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L11:
        r3 = null;
        goto L72
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void T90(CommonSlideFragment.b r22) {
        Intrinsics.checkNotNullParameter(r22, "event");
        String r3 = null;
        if ((r22 instanceof CommonSlideFragment.b.c) == false) goto L276;
        CommonSlideFragment.b.c r1 = (CommonSlideFragment.b.c) r22;
        int r2 = r1.a;
        int r4 = r1.b;
        if (r2 < 0) goto L11;
        if (r4 < 0) goto L11;
        if (r2 == r4) goto L11;
        g19.a r5 = ba0();
        if (r5 == null) goto L11;
        r5.u();
    L11:
        boolean r11 = false;
        if (r2 != 0) goto L14;
        r2 = 0;
    L14:
        CreationPagerFragment r6 = getParentFragment();
        if ((r6 instanceof CreationPagerFragment) == false) goto L17;
        CreationPagerFragment r7 = r6;
    L18:
        if (r7 == null) goto L20;
        CreationGroupFragment r8 = r7.ma0();
    L22:
        if (Intrinsics.areEqual(r8, this) == true) goto L24;
        return;
    L24:
        LarusCreationPagerLayoutBinding r9 = this.i;
        if (r9 == null) goto L30;
        NumericIndicator r10 = r9.c;
        if (r10 == null) goto L30;
        r10.x(r2 + 1);
    L30:
        if (r4 == (-1)) goto L274;
        if (r2 == r4) goto L292;
        if (r2 <= r4) goto L35;
        String r12 = "left";
    L36:
        String r13 = r12;
        if (r4 < 0) goto L47;
        List<UserCreation> r14 = this.m;
        if (r14 == null) goto L41;
        int r15 = r14.size();
    L42:
        if (r4 >= r15) goto L47;
        List<UserCreation> r16 = this.m;
        if (r16 == null) goto L47;
        UserCreation r17 = (UserCreation) ListProtector.get(r16, r4);
    L48:
        boolean r18 = true;
        if (r17 == null) goto L56;
        Integer r19 = r17.d;
        if (r19 == null) goto L56;
        if (r19.intValue() != 2) goto L56;
        boolean r20 = true;
    L57:
        String r110 = "0";
        if (r20 == false) goto L60;
        String r21 = "0";
    L61:
        CommonSlideDialogFragment r23 = getParentFragment();
        if ((r23 instanceof CommonSlideDialogFragment) == false) goto L64;
        CommonSlideDialogFragment r24 = r23;
    L65:
        if (r24 == null) goto L67;
        int r25 = r24.e;
    L68:
        if (r17 != null) goto L70;
    L72:
        boolean r26 = false;
    L73:
        if (r26 == false) goto L75;
        String r27 = "music";
    L76:
        String r28 = r27;
        if (r17 == null) goto L79;
        String r111 = r17.a;
    L80:
        String r29 = this.n;
        if (r29 != null) goto L83;
    L86:
        boolean r30 = true;
    L87:
        String r112 = "creation_private";
        if (r30 == true) goto L90;
        String r31 = "creation_others";
    L94:
        tx9.x2.b(r31, r13, r21, r25, r4, r28, r111);
        UserCreation r32 = aa0();
        if (r32 != null) goto L97;
    L99:
        boolean r33 = false;
    L101:
        if (r33 == false) goto L186;
        UserCreation r34 = aa0();
        if (r34 == null) goto L109;
        UserCreationContent r35 = r34.e;
        if (r35 == null) goto L109;
        UserCreationMusic r36 = r35.b;
        if (r36 == null) goto L109;
        String r37 = r36.h;
    L111:
        if (Intrinsics.areEqual(r37, this.l) == true) goto L293;
        String r38 = this.n;
        if (r38 != null) goto L115;
    L118:
        boolean r39 = true;
    L119:
        if (r39 == true) goto L121;
        String r40 = "creation_others";
    L125:
        UserCreation r41 = aa0();
        if (r41 == null) goto L132;
        UserCreationContent r42 = r41.e;
        if (r42 == null) goto L132;
        UserCreationMusic r43 = r42.b;
        if (r43 == null) goto L132;
        String r44 = r43.h;
    L133:
        UserCreation r45 = aa0();
        if (r45 == null) goto L139;
        String r46 = r45.a;
        if (r46 == null) goto L139;
        String r47 = r46;
    L140:
        CommonSlideDialogFragment r48 = getParentFragment();
        if ((r48 instanceof CommonSlideDialogFragment) == false) goto L143;
        CommonSlideDialogFragment r49 = r48;
    L144:
        if (r49 == null) goto L146;
        int r50 = r49.e;
    L147:
        int r113 = ((CommonSlideFragment) this).e;
        String r51 = this.n;
        if (r51 != null) goto L150;
    L153:
        boolean r52 = true;
    L154:
        if (r52 == true) goto L156;
        r112 = "creation_others";
    L160:
        UserCreation r53 = aa0();
        if (r53 == null) goto L168;
        Integer r54 = r53.d;
        if (r54 == null) goto L168;
        if (r54.intValue() != 2) goto L168;
        r11 = true;
    L168:
        if (r11 == false) goto L170;
        String r114 = "0";
    L171:
        gs9.d r55 = this.q;
        if (r55 == null) goto L176;
        gs9.b r56 = r55.f;
        if (r56 == null) goto L176;
        r3 = r56.d;
    L176:
        tx9.x2.c(r13, r4, r40, r44, r47, r50, r113, r114, r112, r3);
        UserCreation r57 = aa0();
        if (r57 == null) goto L184;
        UserCreationContent r58 = r57.e;
        if (r58 == null) goto L184;
        UserCreationMusic r59 = r58.b;
        if (r59 == null) goto L184;
        String r60 = r59.h;
        if (r60 == null) goto L184;
    L185:
        this.l = r60;
        return;
    L184:
        r60 = "";
        goto L185
    L170:
        r114 = "1";
        goto L171
    L156:
        if (this.o == 2) goto L160;
        r112 = "creation_list";
        goto L160
    L150:
        if (r51.length() == 0) goto L153;
        r52 = false;
        goto L154
    L146:
        r50 = 0;
        goto L147
    L143:
        r49 = null;
    L139:
        r47 = "";
    L132:
        r44 = null;
        goto L133
    L121:
        if (this.o != 2) goto L123;
        r40 = "creation_private";
        goto L125
    L123:
        r40 = "creation_list";
        goto L125
    L115:
        if (r38.length() == 0) goto L118;
        r39 = false;
        goto L119
    L293:
        return;
    L109:
        r37 = null;
        goto L111
    L186:
        if (r4 == r2) goto L295;
        UserCreation r61 = aa0();
        if (r61 == null) goto L190;
        Integer r62 = Integer.valueOf(r61.b);
    L191:
        gs9.d r63 = this.q;
        if (r63 == null) goto L199;
        gs9.b r64 = r63.f;
        if (r64 == null) goto L199;
        String r65 = r64.e;
        if (r65 == null) goto L199;
        String r66 = r65;
    L212:
        UserCreation r67 = aa0();
        if (r67 == null) goto L218;
        String r68 = r67.a;
        if (r68 == null) goto L218;
        String r69 = r68;
    L219:
        CommonSlideDialogFragment r70 = getParentFragment();
        if ((r70 instanceof CommonSlideDialogFragment) == false) goto L222;
        CommonSlideDialogFragment r71 = r70;
    L223:
        if (r71 == null) goto L225;
        int r72 = r71.e;
    L226:
        int r73 = ((CommonSlideFragment) this).e;
        String r74 = this.n;
        if (r74 != null) goto L229;
    L232:
        boolean r75 = true;
    L233:
        if (r75 == true) goto L235;
        String r115 = "creation_others";
    L239:
        if (r62 != null) goto L242;
    L244:
        boolean r116 = false;
    L245:
        UserCreation r76 = aa0();
        if (r76 == null) goto L253;
        Integer r77 = r76.d;
        if (r77 == null) goto L253;
        if (r77.intValue() != 2) goto L253;
        boolean r78 = true;
    L254:
        if (r78 == true) goto L257;
        r110 = "1";
    L257:
        if (r62 != null) goto L260;
    L262:
        r18 = false;
    L263:
        gs9.d r79 = this.q;
        if (r79 == null) goto L268;
        gs9.b r80 = r79.f;
        if (r80 == null) goto L268;
        String r117 = r80.d;
    L269:
        if (r79 == null) goto L273;
        gs9.b r81 = r79.f;
        if (r81 == null) goto L273;
        r3 = r81.f;
    L273:
        tx9.x2.d(r13, r4, r66, r69, r72, r73, r115, r110, r116, r18, r117, r3);
        return;
    L268:
        r117 = null;
        goto L269
    L260:
        if (r62.intValue() != 4) goto L262;
    L253:
        r78 = false;
        goto L254
    L242:
        if (r62.intValue() != 3) goto L244;
        r116 = true;
        goto L245
    L235:
        if (this.o != 2) goto L237;
        r115 = "creation_private";
        goto L239
    L237:
        r115 = "creation_list";
        goto L239
    L229:
        if (r74.length() == 0) goto L232;
        r75 = false;
        goto L233
    L225:
        r72 = 0;
        goto L226
    L222:
        r71 = null;
    L218:
        r69 = "";
    L199:
        String r82 = this.n;
        if (r82 != null) goto L202;
    L205:
        boolean r83 = true;
    L206:
        if (r83 == true) goto L208;
        r66 = "creation_others";
        goto L212
    L208:
        if (this.o != 2) goto L210;
        r66 = "creation_private";
        goto L212
    L210:
        r66 = "creation_list";
        goto L212
    L202:
        if (r82.length() == 0) goto L205;
        r83 = false;
        goto L206
    L190:
        r62 = null;
        goto L191
    L295:
        return;
    L97:
        if (r32.b != 1) goto L99;
        r33 = true;
        goto L101
    L90:
        if (this.o != 2) goto L92;
        r31 = "creation_private";
        goto L94
    L92:
        r31 = "creation_list";
        goto L94
    L83:
        if (r29.length() == 0) goto L86;
        r30 = false;
        goto L87
    L79:
        r111 = null;
        goto L80
    L75:
        r27 = "pic";
        goto L76
    L70:
        if (r17.b != 1) goto L72;
        r26 = true;
        goto L73
    L67:
        r25 = 0;
        goto L68
    L64:
        r24 = null;
        goto L65
    L60:
        r21 = "1";
    L56:
        r20 = false;
        goto L57
    L41:
        r15 = 0;
    L47:
        r17 = null;
        goto L48
    L35:
        r12 = "right";
        goto L36
    L292:
        return;
    L274:
        return;
    L20:
        r8 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L276:
        if ((r22 instanceof CommonSlideFragment.b.a) == false) goto L283;
        String r84 = ba0();
        if ((r84 instanceof g19.a) == false) goto L280;
        r3 = r84;
    L280:
        if (r3 == null) goto L297;
        r3.o1();
        return;
    L297:
        return;
    L283:
        if ((r22 instanceof CommonSlideFragment.b.b) == false) goto L291;
        String r85 = ba0();
        if ((r85 instanceof g19.a) == false) goto L287;
        r3 = r85;
    L287:
        if (r3 == null) goto L299;
        r3.VT();
        return;
    L299:
        return;
    L291:
        throw new NoWhenBranchMatchedException();
    }

    public final void X90(Bundle r6) {
        super.X90(r6);
        CreationInnerPagerAdapter r7 = this.j;
        if (r7 == null) goto L8;
        List<UserCreation> r0 = this.m;
        if (r0 != null) goto L7;
        r0 = new ArrayList();
    L7:
        r7.y2(r0);
    L8:
        LarusCreationPagerLayoutBinding r8 = this.i;
        if (r8 == null) goto L17;
        NumericIndicator r9 = r8.c;
        if (r9 == null) goto L17;
        List<UserCreation> r1 = this.m;
        if (r1 == null) goto L15;
        int r2 = r1.size();
    L16:
        r9.setTotalCount(r2);
        goto L17
    L15:
        r2 = 1;
    L17:
        LarusCreationPagerLayoutBinding r10 = this.i;
        if (r10 == null) goto L23;
        NumericIndicator r11 = r10.c;
        if (r11 == null) goto L23;
        r11.x(1);
    L23:
        if (this.r == false) goto L49;
        LarusCreationPagerLayoutBinding r12 = this.i;
        if (r12 == null) goto L29;
        LeftCreationEditView r13 = r12.b;
        if (r13 == null) goto L29;
        com.larus.utils.e1.x(r13);
    L29:
        LarusCreationPagerLayoutBinding r14 = this.i;
        if (r14 == null) goto L38;
        LeftCreationEditView r15 = r14.b;
        if (r15 == null) goto L38;
        ViewGroup.LayoutParams r3 = r15.getLayoutParams();
        if (r3 == null) goto L37;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        com.larus.utils.i0.a.getClass();
        r4.topMargin = com.larus.utils.i0.g();
        r15.setLayoutParams(r4);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        List r16 = CollectionsKt.listOf(new Integer[]{6, 7, 9, 8, 10, 11, 12});
        List<UserCreation> r5 = this.m;
        if (r5 == null) goto L43;
        UserCreation r17 = (UserCreation) CollectionsKt.getOrNull(r5, 0);
        if (r17 == null) goto L43;
        Integer r18 = Integer.valueOf(r17.b);
    L45:
        if (CollectionsKt.contains(r16, r18) == false) goto L47;
        EditPanelType r19 = EditPanelType.VIDEO;
    L48:
        Z90(this, 0, r19, 1);
        return;
    L47:
        r19 = EditPanelType.IMAGE;
    L43:
        r18 = null;
        goto L45
    L49:
        LarusCreationPagerLayoutBinding r20 = this.i;
        if (r20 == null) goto L56;
        LeftCreationEditView r21 = r20.b;
        if (r21 == null) goto L57;
        com.larus.utils.e1.o(r21);
        return;
    L57:
        return;
    }

    @Override // com.larus.profile.impl.creation.j2
    public final void fy(boolean r18) {
        boolean r4 = true;
        if (r18 == false) goto L5;
        int r5 = 2;
    L7:
        if (this.o == 0) goto L9;
        boolean r7 = true;
    L10:
        Integer r8 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        List<UserCreation> r1 = this.m;     // Catch: Throwable -> L18
        if (r1 == null) goto L15;
        UserCreation r2 = (UserCreation) ListProtector.get(r1, ((CommonSlideFragment) this).e);     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
    L16:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L18
    L21:
        if (Result.exceptionOrNull-impl(r3) == null) goto L24;
        r3 = null;
    L24:
        UserCreation r9 = (UserCreation) r3;
        if (r9 == null) goto L53;
        if (r7 == false) goto L44;
        List<UserCreation> r6 = this.m;
        if (r6 == null) goto L31;
        r6.remove(r9);
    L31:
        LarusCreationPagerLayoutBinding r10 = this.i;
        if (r10 == null) goto L47;
        NumericIndicator r11 = r10.c;
        if (r11 == null) goto L47;
        List<UserCreation> r12 = this.m;
        if (r12 == null) goto L38;
        int r13 = r12.size();
    L39:
        r11.setTotalCount(r13);
        LarusCreationPagerLayoutBinding r14 = this.i;
        if (r14 == null) goto L47;
        NumericIndicator r15 = r14.c;
        if (r15 == null) goto L47;
        r15.x(((CommonSlideFragment) this).e + 1);
        goto L47
    L38:
        r13 = 1;
    L47:
        CreationInnerPagerAdapter r16 = this.j;
        if (r16 == null) goto L53;
        List<UserCreation> r17 = this.m;
        if (r17 != null) goto L52;
        r17 = new ArrayList();
    L52:
        r16.y2(r17);
        goto L53
    L44:
        UserCreation r19 = UserCreation.c(r9, Integer.valueOf(r5), null, null, null, null, null, 131063);
        List<UserCreation> r20 = this.m;
        if (r20 == null) goto L47;
        UserCreation r21 = (UserCreation) ListProtector.set(r20, ((CommonSlideFragment) this).e, r19);
    L53:
        CreationPagerFragment r22 = getParentFragment();
        if ((r22 instanceof CreationPagerFragment) == false) goto L56;
        CreationPagerFragment r23 = r22;
    L57:
        if (r23 == null) goto L73;
        int r24 = ((CommonSlideFragment) this).e;
        CreationPagerViewModel r25 = r23.oa0();
        if (r25 == null) goto L74;
        int r26 = r23.r;
        if (r26 == 1) goto L65;
        if (r26 != 2) goto L66;
        r8 = 2;
    L66:
        if (r8 != null) goto L69;
        r4 = false;
    L69:
        r25.setCreationPrivacy(r18, r4, r24);
        return;
    L65:
        r8 = 1;
        goto L66
    L74:
        return;
    L73:
        return;
    L56:
        r23 = null;
    L15:
        r2 = null;
    L18:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = 1;
        goto L7
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LarusCreationPagerLayoutBinding r4 = this.i;
        if (r4 == null) goto L11;
        NumericIndicator r5 = r4.c;
        if (r5 == null) goto L11;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L10;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        com.larus.utils.i0.a.getClass();
        r7.topMargin = com.larus.utils.i0.g();
        r5.setLayoutParams(r7);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        LarusFragmentCommonSlideBinding r8 = ((CommonSlideFragment) this).d;
        if (r8 == null) goto L14;
        ViewPager2 r9 = r8.c;
    L15:
        if (r9 == null) goto L18;
        r9.post(new x(this));
        return;
    L18:
        return;
    L14:
        r9 = null;
        goto L15
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        LarusFragmentCommonSlideBinding r6 = ((CommonSlideFragment) this).d;
        if (r6 == null) goto L7;
        ImageView r7 = r6.f;
        if (r7 == null) goto L7;
        r7.setVisibility(8);
    L7:
        LarusFragmentCommonSlideBinding r8 = ((CommonSlideFragment) this).d;
        if (r8 == null) goto L12;
        ImageView r9 = r8.b;
        if (r9 == null) goto L12;
        r9.setVisibility(8);
    L12:
        LarusFragmentCommonSlideBinding r10 = ((CommonSlideFragment) this).d;
        if (r10 == null) goto L17;
        ImageView r11 = r10.g;
        if (r11 == null) goto L17;
        r11.setVisibility(8);
    L17:
        return r5;
    }

    public static void Z90(CreationGroupFragment r12, int r13, EditPanelType r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r13 = 0;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r14 = EditPanelType.NONE;
    L8:
        Map<Integer, Fragment> r16 = r12.k;
        LinkedHashMap r17 = (LinkedHashMap) r16;
        Object r18 = r17.get(Integer.valueOf(r13));
        if ((r18 instanceof g19.a) == false) goto L11;
        g19.a r19 = (g19.a) r18;
    L12:
        if (r19 == null) goto L17;
        EditPanelType r110 = r19.SQ();
        if (r110 == null) goto L17;
        r14 = r110;
    L17:
        boolean r111 = Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1");
        if (r12.x == r14) goto L49;
        r12.x = r14;
        LarusCreationPagerLayoutBinding r112 = r12.i;
        if (r112 == null) goto L47;
        LeftCreationEditView r2 = r112.b;
        if (r2 == null) goto L48;
        y r3 = new y(r12);
        if (((Boolean) r12.s.getValue()).booleanValue() == false) goto L28;
        if (r111 == true) goto L28;
        boolean r5 = true;
    L30:
        if (((Boolean) r12.t.getValue()).booleanValue() == false) goto L33;
        if (r111 == true) goto L33;
        boolean r6 = true;
    L35:
        if (((Boolean) r12.u.getValue()).booleanValue() == false) goto L38;
        if (r111 == true) goto L38;
        boolean r7 = true;
    L40:
        if (r14 == EditPanelType.VIDEO) goto L42;
    L44:
        boolean r8 = false;
    L45:
        com.larus.platform.service.z2.a.w3();
        LeftCreationEditView.d(r2, r3, Boolean.TRUE, r5, r6, r7, r8, true, null, 128);
        return;
    L42:
        if (com.larus.platform.service.z2.a.getCreationExtendVideoConfig().b() == false) goto L44;
        r8 = true;
    L38:
        r7 = false;
    L33:
        r6 = false;
    L28:
        r5 = false;
        goto L30
    L48:
        return;
    L47:
        return;
    L49:
        return;
    L11:
        r19 = null;
        goto L12
    }
}
