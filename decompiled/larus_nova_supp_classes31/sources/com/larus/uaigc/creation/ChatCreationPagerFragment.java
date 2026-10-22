package com.larus.uaigc.creation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import com.larus.bmhome.bigimg.widget.j;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.uaigc.creation.detail.loading.LoadingFragment;
import com.larus.uaigc.impl.databinding.LarusBigImageDetailLayoutBinding;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import uo8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00017\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002VWB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u000e\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nJ\u001e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010-\u001a\u00020\rJ\b\u0010.\u001a\u00020\rH\u0016J\u000e\u0010/\u001a\u00020#2\u0006\u0010)\u001a\u00020\nJ\u001e\u00100\u001a\u00020#2\u0006\u0010)\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\rJ\u0018\u00101\u001a\u0004\u0018\u0001022\u0006\u0010)\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nJ\n\u00103\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\rJ\r\u00106\u001a\u000207H\u0002¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020#J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020#H\u0002J\u0006\u0010=\u001a\u00020#J\u0006\u0010>\u001a\u00020#J \u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0002J\u0012\u0010C\u001a\u00020#2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020H2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010I\u001a\u00020#2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u000e\u0010J\u001a\u00020K2\u0006\u0010@\u001a\u00020\rJ\u0010\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020#H\u0016J\b\u0010P\u001a\u00020#H\u0016J\u001c\u0010S\u001a\u00020#2\b\b\u0002\u0010T\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020RH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010Q\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/larus/uaigc/creation/ChatCreationPagerFragment;", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment;", "Lcom/larus/uaigc/impl/databinding/LarusBigImageDetailLayoutBinding;", "<init>", "()V", "binding", "pagerAdapter", "Lcom/larus/uaigc/creation/ChatCreationPagerFragment$BigImagePagerAdapter;", "creationStatus", "", "", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "currentPosition", "", "startTime", "", "fragmentMap", "Landroidx/fragment/app/Fragment;", "slideDirection", "property", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "getProperty", "()Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "setProperty", "(Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;)V", "isReadonlyForwardDetail", "", "()Z", "setReadonlyForwardDetail", "(Z)V", "isShowLeftCreationView", "isShowLeftCreationView$delegate", "Lkotlin/Lazy;", "dispatchContainerEvent", "", "event", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment$ContainerEvent;", "getCurrentFragment", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "getCurrentButtonStatus", "creationKey", "getCurrentCreationId", "updateCreationPrivacy", "creationId", "privacy", "getFeedDirection", "deleteCreation", "addCreation", "getPublisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "initViewBinding", "getCurrentStatus", "pagerPos", "onPageChangeCallback", "com/larus/uaigc/creation/ChatCreationPagerFragment$onPageChangeCallback$1", "()Lcom/larus/uaigc/creation/ChatCreationPagerFragment$onPageChangeCallback$1;", "dismissScreenView", "showOrDismissLeftEditView", "showLeftEditViewWithPinch", "dismissLeftEditViewWithPinch", "showScreenView", "showOrDismissExtraView", "reportEnterPicDetailEvent", "pos", "enterMethod", "slideStatus", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "initView", "getReportParams", "Lorg/json/JSONObject;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "clickBackCallback", "currentEditPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "bindEditPanel", "position", "defaultType", "Companion", "BigImagePagerAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ChatCreationPagerFragment extends CommonSlideDialogFragment<LarusBigImageDetailLayoutBinding> {
    public static final /* synthetic */ int t = 0;
    public LarusBigImageDetailLayoutBinding i;
    public BigImagePagerAdapter j;
    public Map<String, UserCreationFromIM> k;
    public int l;
    public final long m;
    public final Map<Integer, Fragment> n;
    public final int o;
    public iy9.a<? extends zo8.a> p;
    public boolean q;
    public final Lazy r;
    public EditPanelType s;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\fJ\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/creation/ChatCreationPagerFragment$BigImagePagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "mProperty", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;)V", "getMProperty", "()Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "realList", "", "getRealList", "()Ljava/util/List;", "setRealList", "(Ljava/util/List;)V", "getItemCount", "", "initData", "", "list", "createFragment", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class BigImagePagerAdapter extends FragmentStateAdapter {
        public final Fragment a;
        public final iy9.a<zo8.a> b;
        public List<zo8.a> c;

        public static final class a {
        }

        static {
        }

        public final int getItemCount() {
            return this.c.size();
        }

        public final Fragment createFragment(int r5) {
            zo8.a r0 = (zo8.a) ListProtector.get(this.c, r5);
            Fragment r1 = pz9.a.a.a(this.a, r0, this.b.b, r5);
            if (r1 != null) goto L5;
            r1 = new LoadingFragment();
        L5:
            ChatCreationPagerFragment r2 = this.a;
            if ((r2 instanceof ChatCreationPagerFragment) == false) goto L8;
            ChatCreationPagerFragment r3 = r2;
        L9:
            if (r3 == null) goto L13;
            Map<Integer, Fragment> r4 = r3.n;
            if (r4 == null) goto L13;
            Fragment r6 = r4.put(Integer.valueOf(r5), r1);
        L13:
            return r1;
        L8:
            r3 = null;
            goto L9
        }

        public BigImagePagerAdapter(Fragment r2, iy9.a<? extends zo8.a> r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "mProperty");
            super(r2);
            this.a = r2;
            this.b = r3;
            this.c = new ArrayList();
        }
    }

    public static final class a {
    }

    public static final class b implements j {
        public final /* synthetic */ ChatCreationPagerFragment a;

        public final void f() {
        }

        public final void h() {
        }

        public final void i() {
        }

        public final void a() {
            this.a.Y90(new CommonSlideDialogFragment.b.a(2));
        }

        public final void b() {
            this.a.Y90(new CommonSlideDialogFragment.b.a(1));
        }

        public final void c() {
            this.a.Y90(CommonSlideDialogFragment.b.e.a);
        }

        public final void d() {
            this.a.Y90(new CommonSlideDialogFragment.b.a(4));
        }

        public final void g() {
            this.a.Y90(new CommonSlideDialogFragment.b.a(6));
        }

        public final void j() {
            this.a.Y90(new CommonSlideDialogFragment.b.a(3));
        }

        public final void k() {
            this.a.Y90(new CommonSlideDialogFragment.b.a(5));
        }

        public b(ChatCreationPagerFragment r1) {
            this.a = r1;
        }

        public final void e(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.creation.ChatCreationPagerFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.ChatCreationPagerFragment$onCreate$1", f = "ChatCreationPagerFragment.kt", i = {}, l = {370, 373}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatCreationPagerFragment this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.creation.ChatCreationPagerFragment$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.uaigc.creation.ChatCreationPagerFragment$onCreate$1$1", f = "ChatCreationPagerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChatCreationPagerFragment this$0;

            public C00441(ChatCreationPagerFragment r1, Continuation<? super C00441> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00441(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L23;
                ResultKt.throwOnFailure(r6);
                ChatCreationPagerFragment r7 = this.this$0;
                Iterator r0 = ((LinkedHashMap) r7.n).entrySet().iterator();
            L6:
                if (r0.hasNext() == false) goto L21;
                Object r1 = ((Map.Entry) r0.next()).getValue();
                if ((r1 instanceof oz9.a) == false) goto L10;
                oz9.a r2 = (oz9.a) r1;
            L11:
                if (r2 == null) goto L6;
                int r3 = r7.oa0(r2.YE());
                String r4 = r2.YE();
                Intrinsics.checkNotNullParameter(r4, "creationKey");
                Map<String, UserCreationFromIM> r5 = r7.k;
                if (r5 == null) goto L18;
                UserCreationFromIM r8 = r5.get(r4);
                if (r8 == null) goto L18;
                String r9 = r8.getCreationId();
                if (r9 == null) goto L18;
            L19:
                r2.C80(r3, r9);
            L18:
                r9 = "";
                goto L19
            L10:
                r2 = null;
                goto L11
            L21:
                return Unit.INSTANCE;
            L23:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ChatCreationPagerFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L25:
            String r8 = (String) r7;
        L27:
            ChatCreationPagerFragment r2 = this.this$0;
            if (r8 != null) goto L30;
            r8 = "";
        L30:
            r2.k = DataConverterKt.d(r8);
            ChatCreationPagerFragment r9 = this.this$0;
            ChatCreationPagerFragment.ma0(r9, r9.p.b, "click", "");
            MainCoroutineDispatcher r10 = Dispatchers.getMain();
            C00441 r3 = new C00441(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r10, r3, this) != r0) goto L34;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            if (this.this$0.p.e.length() != 0) goto L13;
            boolean r11 = true;
        L14:
            if (r11 == true) goto L16;
            IChatRepoService r12 = RepoDispatcherDelegate.b.e();
            if (r12 == null) goto L26;
            String r4 = this.this$0.p.e;
            if (r4 != null) goto L22;
            r4 = "0";
        L22:
            this.label = 1;
            r7 = r12.w1(r4, this);
            if (r7 != r0) goto L25;
            return r0;
        L26:
            r8 = null;
            goto L27
        L16:
            return Unit.INSTANCE;
        L13:
            r11 = false;
            goto L14
        }
    }

    static {
    }

    public ChatCreationPagerFragment() {
        this.n = new LinkedHashMap();
        this.o = z2.a.x1();
        this.p = new iy9.a(null, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, false, 0, false, null, 134217727);
        this.r = LazyKt.lazy(new com.larus.uaigc.creation.a(this));
        this.m = System.currentTimeMillis();
        this.s = EditPanelType.NONE;
    }

    public final void T90() {
        Map<Integer, Fragment> r0 = this.n;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Object r2 = r1.get(Integer.valueOf(this.l));
        if ((r2 instanceof g19.a) == false) goto L5;
        g19.a r3 = (g19.a) r2;
    L6:
        if (r3 == null) goto L9;
        r3.Oh();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onDestroyView() {
        Function0<Unit> r0 = this.p.A;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        super.onDestroyView();
    }

    public final g19.a pa0() {
        LarusBigImageDetailLayoutBinding r2 = this.i;     // Catch: Exception -> L20
        if (r2 == null) goto L25;
        ViewPager2 r3 = r2.c;     // Catch: Exception -> L20
        if (r3 == null) goto L26;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L20
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L20
        if (r5 == null) goto L14;
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L20
        BigImagePagerAdapter r0 = this.j;     // Catch: Exception -> L20
        if (r0 == null) goto L12;
        Long r1 = Long.valueOf(r0.getItemId(r4));     // Catch: Exception -> L20
    L13:
        r6.append(r1);     // Catch: Exception -> L20
        Fragment r7 = r5.findFragmentByTag(r6.toString());     // Catch: Exception -> L20
    L16:
        if ((r7 instanceof g19.a) == false) goto L27;
        return (g19.a) r7;
    L27:
        return null;
    L12:
        r1 = null;
        goto L13
    L14:
        r7 = null;
        goto L16
    L26:
        return null;
    L25:
        return null;
    L20:
        e = move-exception;
        FLogger.a.e("ChatCreationPagerFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final boolean ra0() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    public final ViewBinding ea0() {
        ConstraintLayout r0 = getLayoutInflater().inflate(2131561821, null, false);
        int r1 = 2131368259;
        LeftCreationEditView r2 = ViewBindings.findChildViewById(r0, 2131368259);
        if (r2 == null) goto L11;
        r1 = 2131375040;
        ViewPager2 r3 = ViewBindings.findChildViewById(r0, 2131375040);
        if (r3 == null) goto L11;
        r1 = 2131381076;
        NumericIndicator r4 = ViewBindings.findChildViewById(r0, 2131381076);
        if (r4 == null) goto L11;
        LarusBigImageDetailLayoutBinding r5 = new LarusBigImageDetailLayoutBinding(r0, r2, r3, r4);
        this.i = r5;
        return r5;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final int aa0() {
        return this.o;
    }

    public final void Y90(CommonSlideDialogFragment.b r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof CommonSlideDialogFragment.b.d) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, CommonSlideDialogFragment.b.b.a) == true) goto L37;
        g19.a r1 = null;
        if ((r4 instanceof CommonSlideDialogFragment.b.e) == false) goto L15;
        g19.a r5 = pa0();
        if ((r5 instanceof g19.a) == false) goto L12;
        r1 = r5;
    L12:
        if (r1 == null) goto L32;
        r1.d70();
        return;
    L32:
        return;
    L15:
        if ((r4 instanceof CommonSlideDialogFragment.b.c) == false) goto L22;
        g19.a r6 = pa0();
        if ((r6 instanceof g19.a) == false) goto L19;
        r1 = r6;
    L19:
        if (r1 == null) goto L34;
        r1.VT();
        return;
    L34:
        return;
    L22:
        if ((r4 instanceof CommonSlideDialogFragment.b.a) == false) goto L30;
        g19.a r0 = pa0();
        if ((r0 instanceof g19.a) == false) goto L26;
        r1 = r0;
    L26:
        if (r1 == null) goto L36;
        r1.FU(((CommonSlideDialogFragment.b.a) r4).a);
        return;
    L36:
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    }

    public final void da0(Bundle r7) {
        super.da0(r7);
        LarusBigImageDetailLayoutBinding r8 = this.i;
        if (r8 == null) goto L30;
        ViewPager2 r9 = r8.c;
        if (r9 == null) goto L30;
        BigImagePagerAdapter r2 = new BigImagePagerAdapter(this, this.p);
        this.j = r2;
        Collection r3 = this.p.a;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        ArrayList r6 = new ArrayList();
        r6.addAll(r3);
        r2.c = r6;
    L16:
        r9.setAdapter(this.j);
        Dialog r4 = getDialog();
        if (r4 == null) goto L21;
        Window r10 = r4.getWindow();
        if (r10 == null) goto L21;
        r10.setBackgroundDrawable(new ColorDrawable(0));
    L21:
        Dialog r11 = getDialog();
        if (r11 == null) goto L26;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L26;
        WindowManager.LayoutParams r13 = r12.getAttributes();
    L27:
        if (r13 == null) goto L29;
        r13.gravity = 7;
    L29:
        r9.setOffscreenPageLimit(1);
        r9.setOrientation(this.o);
        r9.setVisibility(8);
        r9.post(new com.larus.uaigc.creation.b(this));
    L26:
        r13 = null;
        goto L27
    L9:
        if (r3.isEmpty() == true) goto L12;
        r5 = false;
    L30:
        LarusBigImageDetailLayoutBinding r14 = this.i;
        if (r14 == null) goto L35;
        NumericIndicator r15 = r14.d;
        if (r15 == null) goto L35;
        r15.setTotalCount(this.p.a.size());
    L35:
        LarusBigImageDetailLayoutBinding r16 = this.i;
        if (r16 == null) goto L40;
        NumericIndicator r17 = r16.d;
        if (r17 == null) goto L40;
        r17.x(this.p.b + 1);
    L40:
        W90();
        if (this.q == false) goto L43;
    L44:
        X90();
    L46:
        if (ra0() == false) goto L86;
        LarusBigImageDetailLayoutBinding r18 = this.i;
        if (r18 == null) goto L52;
        LeftCreationEditView r19 = r18.b;
        if (r19 == null) goto L52;
        e1.x(r19);
    L52:
        LarusBigImageDetailLayoutBinding r20 = this.i;
        if (r20 == null) goto L64;
        LeftCreationEditView r21 = r20.b;
        if (r21 == null) goto L64;
        iy9.a<? extends zo8.a> r22 = this.p;
        if ((CollectionsKt.getOrNull(r22.a, r22.b) instanceof zo8.b) == true) goto L62;
        iy9.a<? extends zo8.a> r23 = this.p;
        if ((CollectionsKt.getOrNull(r23.a, r23.b) instanceof zo8.e) == true) goto L62;
        float r24 = 0.0f;
    L63:
        int r25 = LeftCreationEditView.l;
        r21.f(r24, true);
    L62:
        r24 = 1.0f;
    L64:
        iy9.a<? extends zo8.a> r26 = this.p;
        int r0 = r26.b;
        if (r26.s.d == false) goto L67;
        EditPanelType r27 = EditPanelType.VIDEO;
    L68:
        na0(r0, r27);
        iy9.a<? extends zo8.a> r28 = this.p;
        ic8.d r1 = r28.s;
        if (r1.d == false) goto L71;
        r1.e.invoke();
        return;
    L71:
        ic8.d r29 = r28.r;
        if (r29.a == false) goto L74;
        r29.c.invoke(null);
    L74:
        ic8.d r30 = this.p.t;
        if (r30.a == false) goto L77;
        r30.c.invoke(null);
    L77:
        ic8.d r31 = this.p.u;
        if (r31.a == false) goto L80;
        r31.c.invoke(null);
    L80:
        ic8.d r32 = this.p.v;
        if (r32.a == false) goto L83;
        r32.c.invoke(null);
    L83:
        ic8.d r33 = this.p.s;
        if (r33.a == false) goto L93;
        r33.c.invoke(null);
        return;
    L93:
        return;
    L67:
        r27 = EditPanelType.IMAGE;
        goto L68
    L86:
        LarusBigImageDetailLayoutBinding r34 = this.i;
        if (r34 == null) goto L95;
        LeftCreationEditView r35 = r34.b;
        if (r35 == null) goto L96;
        e1.o(r35);
        return;
    L96:
        return;
    L95:
        return;
    L43:
        if (ra0() == false) goto L46;
        goto L44
    }

    public final int oa0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "creationKey");
        if (this.p.e.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0;
    L8:
        Map<String, UserCreationFromIM> r1 = this.k;
        if (r1 == null) goto L11;
        UserCreationFromIM r5 = r1.get(r4);
    L12:
        if (r5 != null) goto L14;
        return 1;
    L14:
        Integer r6 = r5.getPrivateStatus();
        if (r6 != null) goto L18;
    L20:
        if (r6 != null) goto L23;
        return 0;
    L23:
        if (r6.intValue() != 2) goto L27;
        return 2;
    L27:
        return 0;
    L18:
        if (r6.intValue() != 1) goto L20;
        return 3;
    L11:
        r5 = null;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onDismiss(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r6);     // Catch: Throwable -> L5
        o r7 = o.a;     // Catch: Throwable -> L5
        JSONObject r0 = qa0(this.l);     // Catch: Throwable -> L5
        r0.put("duration", System.currentTimeMillis() - this.m);     // Catch: Throwable -> L5
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r7.reportEvent("leave_picture_detail", r0);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final JSONObject qa0(int r7) {
        JSONObject r0 = new JSONObject();
        k r1 = this.p.c;
        if (r1 == null) goto L26;
        Map r2 = r1.a;
        if (r2 == null) goto L17;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (Intrinsics.areEqual(r4.getKey(), "current_page") == true) goto L11;
        r0.put((String) r4.getKey(), r4.getValue());
        goto L8
    L11:
        String r5 = (String) r4.getKey();
        if ((CollectionsKt.getOrNull(this.p.a, r7) instanceof zo8.b) == false) goto L14;
        String r6 = "picture_detail";
    L15:
        r0.put(r5, r6);
        goto L8
    L14:
        r6 = "video_detail";
    L17:
        List r8 = r1.b;
        if (r8 == null) goto L26;
        if (r7 < 0) goto L26;
        if (r7 >= r8.size()) goto L26;
        Iterator r9 = ((Map) ListProtector.get(r8, r7)).entrySet().iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        Map.Entry r10 = (Map.Entry) r9.next();
        r0.put((String) r10.getKey(), r10.getValue());
    L26:
        return r0;
    }

    public final void na0(int r13, EditPanelType r14) {
        Object r15 = ((LinkedHashMap) this.n).get(Integer.valueOf(r13));
        Message r1 = null;
        if ((r15 instanceof g19.a) == false) goto L5;
        g19.a r16 = (g19.a) r15;
    L6:
        if (r16 == null) goto L12;
        EditPanelType r17 = r16.SQ();
        if (r17 == null) goto L12;
        r14 = r17;
    L12:
        if (this.s != r14) goto L14;
        return;
    L14:
        this.s = r14;
        k r18 = this.p.c;
        if (r18 == null) goto L19;
        Map r19 = r18.a;
        if (r19 == null) goto L19;
        Object r110 = r19.get("message");
    L21:
        if ((r110 instanceof Message) == false) goto L23;
        r1 = (Message) r110;
    L23:
        boolean r111 = Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1");
        LarusBigImageDetailLayoutBinding r0 = this.i;
        if (r0 == null) goto L69;
        LeftCreationEditView r2 = r0.b;
        if (r2 == null) goto L70;
        b r3 = new b(this);
        if (r1 != null) goto L30;
    L32:
        boolean r5 = false;
    L33:
        if (r5 == false) goto L35;
    L38:
        boolean r7 = false;
    L39:
        if (r1 != null) goto L41;
    L43:
        boolean r6 = false;
    L44:
        if (r6 == false) goto L46;
    L49:
        boolean r8 = false;
    L50:
        if (r1 != null) goto L52;
    L54:
        boolean r4 = false;
    L55:
        if (r4 == false) goto L57;
    L62:
        boolean r9 = false;
    L64:
        if (this.q == true) goto L66;
        z2.a.w3();
        boolean r10 = true;
    L67:
        LeftCreationEditView.d(r2, r3, null, r8, false, r7, r9, r10, null, 138);
        return;
    L66:
        r10 = false;
        goto L67
    L57:
        if (r14 != EditPanelType.VIDEO) goto L62;
        if (z2.a.getCreationExtendVideoConfig().b() == false) goto L62;
        if (r111 == true) goto L62;
        r9 = true;
        goto L64
    L52:
        if (com.larus.im.bean.message.a.e0(r1) != true) goto L54;
        r4 = true;
        goto L55
    L46:
        if (this.p.r.a == false) goto L49;
        if (r111 == true) goto L49;
        r8 = true;
        goto L50
    L41:
        if (com.larus.im.bean.message.a.e0(r1) != true) goto L43;
        r6 = true;
        goto L44
    L35:
        if (this.p.s.a == false) goto L38;
        if (r111 == true) goto L38;
        r7 = true;
        goto L39
    L30:
        if (com.larus.im.bean.message.a.e0(r1) != true) goto L32;
        r5 = true;
        goto L33
    L70:
        return;
    L69:
        return;
    L19:
        r110 = null;
        goto L21
    L5:
        r16 = null;
        goto L6
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        LarusBigImageDetailLayoutBinding r5 = this.i;
        if (r5 == null) goto L11;
        NumericIndicator r6 = r5.d;
        if (r6 == null) goto L11;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L10;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        i0.a.getClass();
        r1.topMargin = i0.g();
        r6.setLayoutParams(r1);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        LarusBigImageDetailLayoutBinding r7 = this.i;
        if (r7 == null) goto L20;
        LeftCreationEditView r8 = r7.b;
        if (r8 == null) goto L21;
        ViewGroup.LayoutParams r2 = r8.getLayoutParams();
        if (r2 == null) goto L19;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r2;
        i0.a.getClass();
        r9.topMargin = i0.g();
        r8.setLayoutParams(r9);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        return;
    }

    public static final void ma0(ChatCreationPagerFragment r8, int r9, String r10, String r11) {
        if ((CollectionsKt.getOrNull(r8.p.a, r9) instanceof zo8.b) == false) goto L69;
        o r0 = o.a;
        JSONObject r1 = r8.qa0(r9);
        r1.put("enter_method", r10);
        if (o0.d(r11) == false) goto L8;
        r1.put("slide_status", r11);
    L8:
        zo8.a r12 = (zo8.a) CollectionsKt.getOrNull(r8.p.a, r9);
        if (r12 == null) goto L11;
        String r13 = qz9.a.a(r12);
    L12:
        Map<String, UserCreationFromIM> r14 = r8.k;
        String r2 = null;
        if (r14 == null) goto L15;
        UserCreationFromIM r15 = r14.get(r13);
    L16:
        String r3 = "1";
        if (r15 == null) goto L19;
        Object r16 = "1";
    L20:
        r1.put("is_template", r16);
        Map<String, UserCreationFromIM> r17 = r8.k;
        if (r17 == null) goto L23;
        UserCreationFromIM r18 = r17.get(r13);
    L24:
        if (r18 == null) goto L26;
        Object r19 = "1";
    L27:
        r1.put("is_creation", r19);
        Integer r110 = r8.p.q;
        int r111 = 0;
        if (r110 != null) goto L31;
    L33:
        int r112 = 0;
    L34:
        r1.put("is_replica_gen", r112);
        Integer r113 = r8.p.q;
        if (r113 != null) goto L38;
    L40:
        r1.put("is_image_edit", r111);
        zo8.a r20 = (zo8.a) CollectionsKt.getOrNull(r8.p.a, r9);
        if (r20 == null) goto L43;
        String r21 = qz9.a.a(r20);
    L45:
        if (r21 != null) goto L47;
        r21 = "";
    L47:
        int r22 = r8.oa0(r21);
        if (r22 != 1) goto L50;
        r3 = "-1";
    L55:
        r1.put("creation_public_status", r3);
        k r23 = r8.p.c;
        if (r23 == null) goto L60;
        Map r24 = r23.a;
        if (r24 == null) goto L60;
        Object r25 = r24.get("message");
    L62:
        if ((r25 instanceof Message) == false) goto L64;
        Message r26 = (Message) r25;
    L65:
        if (r26 == null) goto L67;
        r2 = r26.getReplyId();
    L67:
        r1.putOpt("reply_id", r2);
        Unit r27 = Unit.INSTANCE;
        r0.reportEvent("enter_picture_detail", r1);
        return;
    L64:
        r26 = null;
    L60:
        r25 = null;
        goto L62
    L50:
        if (r22 == 2) goto L53;
        if (r22 == 3) goto L55;
        r3 = "";
        goto L55
    L53:
        r3 = "0";
        goto L55
    L43:
        r21 = null;
        goto L45
    L38:
        if (r113.intValue() != 4) goto L40;
        r111 = 1;
        goto L40
    L31:
        if (r110.intValue() != 3) goto L33;
        r112 = 1;
        goto L34
    L26:
        r19 = "0";
        goto L27
    L23:
        r18 = null;
        goto L24
    L19:
        r16 = "0";
        goto L20
    L15:
        r15 = null;
        goto L16
    L11:
        r13 = String.valueOf(r9);
        goto L12
    }
}
