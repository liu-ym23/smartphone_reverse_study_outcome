package com.larus.bmhome.chat.immerse;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.adapter.FragmentStateAdapterHelper;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.f4;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.chat.m4;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n*\u0001j\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u009f\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010F\u001a\u00020\u00192\b\u0010G\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010H\u001a\u00020\u0019H\u0016J\b\u0010M\u001a\u00020\u0019H\u0002J\b\u0010N\u001a\u0004\u0018\u00010OJ\u0010\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010Q\u001a\u00020#J\b\u0010R\u001a\u00020\u0019H\u0016J&\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010Z\u001a\u00020\u00192\b\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010[\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020#2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020)H\u0016J\u001a\u0010a\u001a\u00020\u00192\u0006\u0010b\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0017J\b\u0010c\u001a\u00020\u0019H\u0002J\b\u0010d\u001a\u00020\u0019H\u0002J\b\u0010e\u001a\u00020\u0019H\u0002J\b\u0010f\u001a\u00020\u0019H\u0002J\u0006\u0010g\u001a\u00020\u0019J\b\u0010h\u001a\u00020\u0019H\u0002J\r\u0010i\u001a\u00020jH\u0002¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020\u0019H\u0002J\b\u0010m\u001a\u00020\u0019H\u0002J\u0010\u0010n\u001a\u00020K2\u0006\u0010^\u001a\u00020oH\u0002J\u001f\u0010p\u001a\u00020\u00192\u0017\u0010q\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\brJ\b\u0010s\u001a\u00020\u0019H\u0002J\u0006\u0010t\u001a\u00020\u0019J\u000e\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020#J\u000e\u0010w\u001a\u00020\u00192\u0006\u0010x\u001a\u00020#J\u0010\u0010y\u001a\u00020#2\u0006\u0010z\u001a\u00020#H\u0002J\b\u0010{\u001a\u00020\u0019H\u0002J\b\u0010|\u001a\u00020\u0019H\u0002J\b\u0010}\u001a\u00020\u0019H\u0002J$\u0010~\u001a\b\u0012\u0004\u0012\u00020\u001f0\u007f2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020o0\u007fH\u0082@¢\u0006\u0003\u0010\u0081\u0001J\u0007\u0010\u0082\u0001\u001a\u00020#J\t\u0010\u0083\u0001\u001a\u00020KH\u0016J\t\u0010\u0084\u0001\u001a\u00020KH\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0019H\u0016J\u0007\u0010\u0086\u0001\u001a\u00020KJ\u0014\u0010\u0087\u0001\u001a\u0004\u0018\u00010o2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010KJ\f\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0002J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010KJ\t\u0010\u008c\u0001\u001a\u00020#H\u0016J\u0014\u0010\u008d\u0001\u001a\u00020\u00192\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010KH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0019H\u0016J\"\u0010\u0090\u0001\u001a\u00020\u00192\u0007\u0010\u0091\u0001\u001a\u00020)2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u000107H\u0016J:\u0010\u0092\u0001\u001a\u00020\u00192\u0007\u0010\u0093\u0001\u001a\u00020)2\u0017\u0010\u0094\u0001\u001a\u0012\u0012\u0004\u0012\u00020K\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u0095\u00012\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u001907H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\u00192\u0007\u0010\u0099\u0001\u001a\u00020KH\u0016J\u0014\u0010\u009a\u0001\u001a\u00020\u00192\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010\u009c\u0001\u001a\u00020\u00192\u0007\u0010\u009d\u0001\u001a\u00020)J\t\u0010\u009e\u0001\u001a\u00020KH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00190\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00103\"\u0004\b<\u00105R\u001a\u0010=\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001a\u0010?\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001b\u0010B\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000f\u001a\u0004\bB\u00103R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 \u0001"}, d2 = {"Lcom/larus/bmhome/chat/immerse/ChatImmersFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/chat/IChatLeave;", "Lcom/larus/bmhome/chat/share/IChatPageShareable;", "Lcom/larus/bmhome/chat/ITraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatImmersiveBinding;", "model", "Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "getModel", "()Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "model$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/bmhome/chat/immerse/ChatImmersViewPagerAdapter;", "animProcessor", "Lcom/larus/bmhome/chat/immerse/ChatImmersProcessor;", "onBackPressCallBack", "Landroidx/activity/OnBackPressedCallback;", "onBackFromChatTabInterceptor", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "getOnBackFromChatTabInterceptor", "()Lkotlin/jvm/functions/Function1;", "setOnBackFromChatTabInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "onImmerseRecreate", "Landroid/os/Bundle;", "getOnImmerseRecreate", "setOnImmerseRecreate", "bottomTabVIewHeight", "", "getBottomTabVIewHeight", "()I", "setBottomTabVIewHeight", "(I)V", "intercept", "", "curPosition", "maxScrollPosition", "lastOffset", "", "lastY", "lastX", "isLoading", "botDiscoveryNow", "getBotDiscoveryNow", "()Z", "setBotDiscoveryNow", "(Z)V", "callback", "Lkotlin/Function0;", "firstClick", "lastItemCount", "singleMode", "getSingleMode", "setSingleMode", "isShow", "setShow", "disableSetBackgroundColor", "getDisableSetBackgroundColor", "setDisableSetBackgroundColor", "isUnreadDotEnable", "isUnreadDotEnable$delegate", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "onNewIntent", "bundle", "onResume", "order", "lastBotId", "", "currentBotId", "handleStatusBarMode", "getCurrentFragment", "Lcom/larus/bmhome/chat/ChatFragment;", "getFragmentByPosition", "position", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "autoLogEnterPage", "onViewCreated", "view", "showRetryView", "hideRetryView", "showLoadingView", "hideLoadingView", "updateBotList", "showLoadingInvisibleAnim", "onPageChangeCallback", "com/larus/bmhome/chat/immerse/ChatImmersFragment$onPageChangeCallback$1", "()Lcom/larus/bmhome/chat/immerse/ChatImmersFragment$onPageChangeCallback$1;", "startScroll", "stopScroll", "getChatType", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "safeNotify", "action", "Lkotlin/ExtensionFunctionType;", "showTitle", "hideTitle", "setRedDotUnreadCount", "count", "setRedDotBGType", "type", "calcuDistance", "delta", "initAnimProcessor", "initViewModel", "slideLoading", "dataProcessor", "", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkLocalNightMode", "getCurrentPageName", "getEnterMethod", "onDestroy", "getPreviousPage", "getCurrentRecommendBot", "botId", "originRecommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "recommendFrom", "tabIndex", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "onMessageShareMode", "shareMode", "ext", "", "", "onCloseClick", "leaveChat", "methodName", "reportEnterPage", "pageName", "setUserInputEnabled", "enabled", "scene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatImmersFragment extends BaseHomeTabFragment implements s19.a, f4, xi8.a, m4 {
    public static final /* synthetic */ int I = 0;
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final Lazy E;
    public final et3.c F;
    public String G;
    public String H;
    public LarusPageChatImmersiveBinding j;
    public final Lazy k;
    public ChatImmersViewPagerAdapter l;
    public a0 m;
    public FragmentExtKt.addOnBackPressed.callback.1 n;
    public Function1<? super Fragment, Unit> o;
    public Function1<? super Bundle, Unit> p;
    public int q;
    public boolean r;
    public int s;
    public int t;
    public float u;
    public float v;
    public boolean w;
    public boolean x;
    public Function0<Unit> y;
    public boolean z;

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

    public ChatImmersFragment() {
        super(true);
        final Function0<Fragment> r1 = new ChatImmersFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatImmersViewModel.class), new ChatImmersFragment$special$$inlined$viewModels$default$2(r1), new ChatImmersFragment$special$$inlined$viewModels$default$3(r1, this));
        this.p = new k();
        this.z = true;
        this.E = LazyKt.lazy(new l(this));
        this.F = new et3.c("chat_immersive_feed", false, null);
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Bv(String r1) {
    }

    public final boolean S90() {
        return false;
    }

    public final void a2(Bundle r1) {
    }

    public final String k() {
        return "immersive";
    }

    @Override // com.larus.bmhome.chat.m4
    public final String scene() {
        return "CHAT_MESSAGE_LIST_IMMERSE";
    }

    public final void t1() {
    }

    public final void y2(String r1) {
    }

    public final ChatFragment Z90() {
        LarusPageChatImmersiveBinding r2 = this.j;     // Catch: Exception -> L16
        if (r2 == null) goto L21;
        ViewPager2 r3 = r2.c;     // Catch: Exception -> L16
        if (r3 == null) goto L22;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L16
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L16
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L16
        ChatImmersViewPagerAdapter r0 = this.l;     // Catch: Exception -> L16
        if (r0 == null) goto L10;
        Long r1 = Long.valueOf(r0.getItemId(r4));     // Catch: Exception -> L16
    L11:
        r6.append(r1);     // Catch: Exception -> L16
        ChatFragment r7 = r5.findFragmentByTag(r6.toString());     // Catch: Exception -> L16
        if ((r7 instanceof ChatFragment) == false) goto L23;
        return r7;
    L23:
        return null;
    L10:
        r1 = null;
        goto L11
    L22:
        return null;
    L21:
        return null;
    L16:
        e = move-exception;
        FLogger.a.e("ChatImmersFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final ChatImmersViewModel ba0() {
        return (ChatImmersViewModel) this.k.getValue();
    }

    public final String ca0() {
        int r0 = j1.a;
        boolean r1 = this.x;
        String r2 = b();
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        String r4 = r3.getString("enter_method", "");
        if (r4 == null) goto L6;
    L7:
        Bundle r5 = getArguments();
        String r6 = null;
        if (r5 == null) goto L10;
        RecommendFrom r7 = (RecommendFrom) r5.getParcelable("argBotRecommendFrom");
    L11:
        Intrinsics.checkNotNullParameter(r2, "previousPage");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        if (r7 == null) goto L15;
        return r7.a + "_immersive";
    L15:
        if (r1 == false) goto L18;
        return "bot_list_discover_immersive";
    L18:
        if (Intrinsics.areEqual(r2, "chat_list") == false) goto L23;
        if (Intrinsics.areEqual(r4, "chatlist_board") == false) goto L23;
        r6 = "chatlist_board_immersive";
    L51:
        return r6;
    L23:
        if (Intrinsics.areEqual(r2, "chat_list") == false) goto L28;
        if (Intrinsics.areEqual(r4, "click_chat") == false) goto L28;
        r6 = "chat_list_immersive";
    L28:
        if (Intrinsics.areEqual(r2, "bot_list_discovery") == false) goto L33;
        if (Intrinsics.areEqual(r4, "click_chat") == false) goto L33;
        r6 = "bot_list_discover_immersive";
    L33:
        if (Intrinsics.areEqual(r2, "bot_list_discover_search") == false) goto L38;
        if (Intrinsics.areEqual(r4, "click_chat") == false) goto L38;
        r6 = "bot_list_discover_search_immersive";
    L38:
        if (Intrinsics.areEqual(r2, "bot_list_others") == false) goto L43;
        if (Intrinsics.areEqual(r4, "click_chat") == false) goto L43;
        r6 = "bot_list_others_immersive";
    L43:
        if (Intrinsics.areEqual(r2, "bot_list_profile") == false) goto L48;
        if (Intrinsics.areEqual(r4, "click_chat") == false) goto L48;
        r6 = "bot_list_profile_immersive";
    L48:
        if (Intrinsics.areEqual(r2, "notify") == false) goto L51;
        r6 = "notify_immersive";
        goto L51
    L10:
        r7 = null;
    L6:
        r4 = "unknown";
        goto L7
    }

    public final void da0() {
        i0 r0 = i0.a;
        if (i0.b == true) goto L5;
        return;
    L5:
        LarusPageChatImmersiveBinding r1 = this.j;
        boolean r2 = false;
        if (r1 == null) goto L12;
        ViewPager2 r3 = r1.c;
        if (r3 == null) goto L12;
        if (r3.isFakeDragging() != true) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L18;
        LarusPageChatImmersiveBinding r4 = this.j;
        if (r4 == null) goto L18;
        ViewPager2 r5 = r4.c;
        if (r5 == null) goto L18;
        r5.endFakeDrag();
    L18:
        LarusPageChatImmersiveBinding r6 = this.j;
        if (r6 == null) goto L22;
        r6.c.setCurrentItem(this.s - 1);
        return;
    }

    public final void hideLoadingView() {
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setDuration(200);
        AnimationSet r1 = new AnimationSet(false);
        r1.addAnimation(r0);
        r1.setAnimationListener(new t(this));
        LarusPageChatImmersiveBinding r2 = this.j;
        if (r2 == null) goto L7;
        ConstraintLayout r3 = r2.f;
        if (r3 == null) goto L7;
        r3.startAnimation(r1);
    L7:
        this.w = false;
    }

    public final void onDestroy() {
        LarusPageChatImmersiveBinding r0 = this.j;
        if (r0 == null) goto L7;
        ViewPager2 r1 = r0.c;
        if (r1 == null) goto L7;
        r1.unregisterOnPageChangeCallback(new ChatImmersFragment$onPageChangeCallback$1(this));
    L7:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.DISCOVERY.getIndex();
    }

    public final String b() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("argPreviousPage");
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L19;
        Bundle r3 = getArguments();
        if (r3 == null) goto L26;
        String r4 = r3.getString("previous_page");
        if (r4 != null) goto L25;
        return "";
    L25:
        return r4;
    L26:
        return "";
    L19:
        Bundle r5 = getArguments();
        if (r5 == null) goto L27;
        r4 = r5.getString("argPreviousPage");
        if (r4 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        this.C = false;
        FragmentExtKt.addOnBackPressed.callback.1 r1 = this.n;
        if (r1 == null) goto L5;
        r1.remove();
    L5:
        int r2 = getResources().getConfiguration().uiMode & 48;
        if (r2 != 16) goto L8;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L23;
        com.larus.utils.u.e(r3, true, false);
    L23:
        if ((getActivity() instanceof j4) == true) goto L25;
    L31:
        ChatFragment r0 = Z90();
        if (r0 == null) goto L37;
        com.larus.bmhome.chat.component.trace.z r4 = (com.larus.bmhome.chat.component.trace.z) r0.v.getValue();
        if (r4 == null) goto L38;
        r4.qH();
        return;
    L38:
        return;
    L37:
        return;
    L25:
        if (z2.a.enableChatWithTab() == false) goto L31;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L31;
        View r6 = r5.findViewById(R.id.content);
        if (r6 == null) goto L31;
        com.larus.utils.i0.a.getClass();
        int r7 = com.larus.utils.i0.g();
        int r8 = r6.getPaddingStart();
        int r9 = r6.getPaddingEnd();
        int r10 = r6.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r6.getClass().getSimpleName() + ",source:,start:" + r8 + ",top:" + r7 + ",end:" + r9 + ",bottom:" + r10);
        r6.setPaddingRelative(r8, r7, r9, r10);
        goto L31
    L8:
        if (r2 != 32) goto L31;
        if ((getActivity() instanceof j4) == false) goto L31;
        if (z2.a.enableChatWithTab() == false) goto L31;
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L31;
        View r12 = r11.findViewById(R.id.content);
        if (r12 == null) goto L31;
        com.larus.utils.i0.a.getClass();
        int r13 = com.larus.utils.i0.g();
        int r14 = r12.getPaddingStart();
        int r15 = r12.getPaddingEnd();
        int r16 = r12.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r14 + ",top:" + r13 + ",end:" + r15 + ",bottom:" + r16);
        r12.setPaddingRelative(r14, r13, r15, r16);
        goto L31
    }

    @Override // com.larus.bmhome.BaseHomeTabFragment
    public final void onResume() {
        super.onResume();
        ChatFragment r0 = Z90();
        if (r0 == null) goto L9;
        Bundle r1 = r0.Z90();
        if (r1 == null) goto L9;
        r1.putString("argPreviousPage", b());
        if (this.x == false) goto L9;
        r1.putString("argCurrentTab", "bot_list_discover");
        r1.putString("enter_method", "click_tab");
    L9:
        ChatImmersViewModel r2 = ba0();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L19;
        ChatImmersViewModel r4 = ba0();
        if (r4 == null) goto L19;
        r4.setEnterTime(AppHost.a.getAppClock().currentTimeMillis());
    L19:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L23;
        com.larus.utils.u.e(r5, false, true);
    L23:
        if ((getActivity() instanceof j4) == false) goto L32;
        if (z2.a.enableChatWithTab() == false) goto L32;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L32;
        View r7 = r6.findViewById(R.id.content);
        if (r7 == null) goto L32;
        int r8 = r7.getPaddingStart();
        int r9 = r7.getPaddingEnd();
        int r10 = r7.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r7.getClass().getSimpleName() + ",source:,start:" + r8 + ",top:0,end:" + r9 + ",bottom:" + r10);
        r7.setPaddingRelative(r8, 0, r9, r10);
    L32:
        if (this.D == true) goto L39;
        FlowCommonAppCompatActivity r11 = requireActivity();
        if ((r11 instanceof FlowCommonAppCompatActivity) == false) goto L36;
        FlowCommonAppCompatActivity r12 = r11;
    L37:
        if (r12 == null) goto L39;
        r12.B1(ColorProtector.parseColor("#FF161616"));
        goto L39
    L36:
        r12 = null;
    L39:
        this.n = com.larus.utils.v.a(this, new com.larus.bmhome.chat.immerse.a(this));
        this.C = true;
        return;
    L12:
        if (r2.getEnterTime() != 0) goto L14;
        r3 = true;
        goto L15
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Sk(String r2) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        ChatFragment r0 = Z90();
        if (r0 == null) goto L6;
        r0.aa0(r2);
        return;
    }

    public final ChatFragment aa0(int r7) {
        ChatImmersViewPagerAdapter r2 = this.l;     // Catch: Exception -> L22
        if (r2 == null) goto L8;
        List<Bundle> r3 = r2.z2();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
        int r4 = r3.size();     // Catch: Exception -> L22
    L9:
        if (r7 >= 0) goto L11;
        return null;
    L11:
        if (r7 > (r4 - 1)) goto L28;
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L22
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L22
        ChatImmersViewPagerAdapter r0 = this.l;     // Catch: Exception -> L22
        if (r0 == null) goto L16;
        Long r8 = Long.valueOf(r0.getItemId(r7));     // Catch: Exception -> L22
    L17:
        r6.append(r8);     // Catch: Exception -> L22
        ChatFragment r9 = r5.findFragmentByTag(r6.toString());     // Catch: Exception -> L22
        if ((r9 instanceof ChatFragment) == false) goto L29;
        return r9;
    L29:
        return null;
    L16:
        r8 = null;
        goto L17
    L28:
        return null;
    L8:
        r4 = 0;
    L22:
        e = move-exception;
        FLogger.a.e("ChatImmersFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        ChatImmersActivity r5 = getActivity();
        if ((r5 instanceof ChatImmersActivity) == false) goto L5;
        ChatImmersActivity r6 = r5;
    L6:
        if (r6 == null) goto L8;
        Intrinsics.checkNotNullParameter(this, "chatImmersFragment");
        r6.h = this;
    L8:
        Bundle r7 = getArguments();
        boolean r0 = true;
        if (r7 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        this.x = r8;
        Bundle r9 = getArguments();
        if (r9 != null) goto L17;
    L19:
        r0 = false;
    L20:
        this.B = r0;
        return;
    L17:
        if (r9.getBoolean("is_single_mode") != true) goto L19;
    L11:
        if (r7.getBoolean("enter_from_discovery") != true) goto L13;
        r8 = true;
        goto L14
    L5:
        r6 = null;
        goto L6
    }

    public final void KC(boolean r3, Function0<Unit> r4) {
        this.y = r4;
        ChatImmersViewModel r5 = ba0();     // Catch: Exception -> L7
        if (r5 == null) goto L12;
        r5.refreshFeedData(ca0(), new f());     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        FLogger.a.e("ChatImmersFragment", "There have something wrong e=" + e.getMessage());
    }

    @Override // xi8.a
    public final void NK(boolean r3, com.larus.bmhome.chat.component.share.n0 r4) {
        Intrinsics.checkNotNullParameter(r4, "onCloseClick");
        LarusPageChatImmersiveBinding r5 = this.j;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r5.c.setUserInputEnabled(false);
        r5.h.setVisibility(8);
        return;
    L7:
        r5.c.setUserInputEnabled(true);
        r5.h.setVisibility(0);
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        z2 r14 = z2.a;
        RecyclerView r4 = null;
        if (r14.a0() == false) goto L5;
        FLogger.a.i("ChatImmersFragment", "view recreate skip");
    L38:
        if (this.x == false) goto L66;
        LarusPageChatImmersiveBinding r15 = this.j;
        if (r15 == null) goto L44;
        AppCompatImageView r16 = r15.b;
        if (r16 == null) goto L44;
        r16.setVisibility(8);
    L44:
        LarusPageChatImmersiveBinding r17 = this.j;
        if (r17 == null) goto L50;
        RedDotTextView r18 = r17.d;
        if (r18 == null) goto L50;
        r18.setVisibility(8);
    L50:
        if (r14.x3().getHideBottomTabDiscovery() == false) goto L56;
        LarusPageChatImmersiveBinding r19 = this.j;
        if (r19 == null) goto L116;
        ImageView r110 = r19.e;
        if (r110 == null) goto L116;
        r110.setVisibility(8);
    L116:
        LarusPageChatImmersiveBinding r111 = this.j;
        if (r111 == null) goto L119;
        this.m = new a0(r111);
    L119:
        ChatImmersViewModel r112 = ba0();
        if (r112 == null) goto L126;
        Bundle r0 = getArguments();
        if (r0 == null) goto L124;
        String r1 = r0.getString("argBotId", null);
    L125:
        r112.setFirstBotId(r1);
        goto L126
    L124:
        r1 = null;
    L126:
        ChatImmersViewModel r113 = ba0();
        if (r113 == null) goto L131;
        MutableLiveData<List<RecommendBot>> r114 = r113.getFeedData();
        if (r114 == null) goto L131;
        r114.observe(getViewLifecycleOwner(), new b(new d(this)));
    L131:
        ChatImmersViewModel r115 = ba0();
        if (r115 == null) goto L138;
        MutableLiveData<Boolean> r116 = r115.getAllowVpOffset();
        if (r116 == null) goto L138;
        LiveData r117 = Transformations.distinctUntilChanged(r116);
        if (r117 == null) goto L138;
        r117.observe(getViewLifecycleOwner(), new b(new e(this)));
    L138:
        final LarusPageChatImmersiveBinding r118 = this.j;
        if (r118 != null) goto L141;
    L178:
        LarusPageChatImmersiveBinding r119 = this.j;
        if (r119 == null) goto L183;
        ConstraintLayout r120 = r119.g;
        if (r120 == null) goto L183;
        com.larus.utils.e1.d(r120, new i(this));
    L183:
        ChatImmersViewModel r121 = ba0();
        if (r121 == null) goto L189;
        MutableLiveData<com.larus.network.http.a<Object>> r122 = r121.getGetData();
        if (r122 == null) goto L189;
        r122.observe(getViewLifecycleOwner(), new b(new j(this)));
    L189:
        if (this.B == true) goto L193;
        ChatImmersViewModel r123 = ba0();
        if (r123 == null) goto L199;
        r123.loadFeedData(ca0(), DowngradeSource.ENTER_CONVERSATION);
    L199:
        if (this.x == false) goto L201;
        return;
    L201:
        if (this.B == true) goto L209;
        ChatImmersViewPagerAdapter r124 = this.l;
        if (r124 != null) goto L205;
        return;
    L205:
        if (r124.b.get() == true) goto L211;
        r124.b.set(true);
        FLogger.a.i("immersAdapter", "showLoading: " + (r124.z2().size() - 1));
        r124.z2().add(com.larus.utils.f.c(new Pair[]{TuplesKt.to("loading", Boolean.TRUE)}));
        r124.d = r124.z2().size() - 1;
        r124.notifyItemInserted(r124.z2().size() - 1);
        return;
    L211:
        return;
    L209:
        return;
    L193:
        LarusPageChatImmersiveBinding r125 = this.j;
        if (r125 == null) goto L199;
        ViewPager2 r126 = r125.c;
        if (r126 == null) goto L199;
        r126.setUserInputEnabled(false);
        goto L199
    L141:
        if ((getActivity() instanceof ChatImmersActivity) == false) goto L143;
    L146:
        ConstraintLayout r127 = r118.h;
        Intrinsics.checkNotNull(r127);
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L149;
        int r3 = com.larus.utils.u.c(r2);
    L150:
        int r5 = r127.getPaddingStart();
        int r6 = r127.getPaddingEnd();
        int r7 = r127.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r127.getClass().getSimpleName() + ",source:immers onViewCreated,start:" + r5 + ",top:" + r3 + ",end:" + r6 + ",bottom:" + r7);
        r127.setPaddingRelative(r5, r3, r6, r7);
    L151:
        AppCompatImageView r128 = r118.b;
        if (com.larus.bmhome.b0.b(this) == false) goto L154;
        int r8 = 2131898806;
    L155:
        r128.setContentDescription(getString(r8));
        AppCompatImageView r129 = r118.b;
        Context r9 = getContext();
        if (r9 == null) goto L158;
        ColorStateList r10 = ContextCompat.getColorStateList(r9, 2131103298);
    L159:
        r129.setImageTintList(r10);
        ImageView r130 = r118.e;
        Context r11 = getContext();
        if (r11 == null) goto L162;
        ColorStateList r20 = ContextCompat.getColorStateList(r11, 2131103298);
    L163:
        r130.setImageTintList(r20);
        ChatImmersViewPagerAdapter r131 = new ChatImmersViewPagerAdapter(this);
        Function1<? super Bundle, Unit> r21 = this.p;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r131.f = r21;
        this.l = r131;
        ViewPager2 r132 = r118.c;
        i0 r22 = i0.a;
        r132.setOrientation(i0.c());
        ChatImmersViewPagerAdapter r133 = this.l;
        if (r133 == null) goto L166;
        ArrayList r23 = new ArrayList();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r133.e = r23;
    L166:
        r118.c.setOffscreenPageLimit(2);
        r118.c.setAdapter(this.l);
        RecyclerView r134 = r118.c.getChildAt(0);
        if ((r134 instanceof RecyclerView) == false) goto L169;
        RecyclerView r135 = r134;
    L170:
        if (r135 == null) goto L172;
        r135.addOnItemTouchListener(new ChatImmersFragment$onViewCreated$1$5(this, r118));
    L172:
        RecyclerView r136 = r118.c.getChildAt(0);
        if ((r136 instanceof RecyclerView) == false) goto L175;
        r4 = r136;
    L175:
        if (r4 == null) goto L177;
        r4.setOnTouchListener(new g(this, r118));
    L177:
        r118.c.post(new h(r118, this));
        goto L178
    L169:
        r135 = null;
        goto L170
    L162:
        r20 = null;
        goto L163
    L158:
        r10 = null;
        goto L159
    L154:
        r8 = 2131898805;
        goto L155
    L149:
        r3 = 0;
        goto L150
    L143:
        if ((getActivity() instanceof j4) == false) goto L151;
        if (r14.enableChatWithTab() == false) goto L151;
    L56:
        LarusPageChatImmersiveBinding r137 = this.j;
        if (r137 == null) goto L61;
        ImageView r138 = r137.e;
        if (r138 == null) goto L61;
        r138.setVisibility(0);
    L61:
        LarusPageChatImmersiveBinding r139 = this.j;
        if (r139 == null) goto L111;
        ImageView r140 = r139.e;
        if (r140 == null) goto L111;
        com.larus.utils.e1.d(r140, new m(this));
    L111:
        LarusPageChatImmersiveBinding r141 = this.j;
        if (r141 == null) goto L116;
        RedDotTextView r142 = r141.d;
        if (r142 == null) goto L116;
        r142.setDotInvisible(!((Boolean) this.E.getValue()).booleanValue());
        goto L116
    L66:
        LarusPageChatImmersiveBinding r143 = this.j;
        if (r143 == null) goto L72;
        AppCompatImageView r144 = r143.b;
        if (r144 == null) goto L72;
        r144.setVisibility(0);
    L72:
        if (com.larus.bmhome.b0.b(this) == false) goto L92;
        LarusPageChatImmersiveBinding r145 = this.j;
        if (r145 == null) goto L82;
        AppCompatImageView r146 = r145.b;
        if (r146 == null) goto L82;
        ViewGroup.LayoutParams r24 = r146.getLayoutParams();
        if (r24 == null) goto L81;
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        com.larus.utils.i0.a.getClass();
        r25.topMargin = com.larus.utils.i0.g() + i5.r0();
        r146.setLayoutParams(r25);
        goto L82
    L81:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L82:
        LarusPageChatImmersiveBinding r147 = this.j;
        if (r147 == null) goto L87;
        AppCompatImageView r148 = r147.b;
        if (r148 == null) goto L87;
        r148.setImageResource(v19.c.b(2130971852, r148.getContext(), 2131242079));
    L87:
        LarusPageChatImmersiveBinding r149 = this.j;
        if (r149 == null) goto L97;
        AppCompatImageView r150 = r149.b;
        if (r150 == null) goto L97;
        com.larus.utils.e1.d(r150, new n(this));
    L97:
        LarusPageChatImmersiveBinding r151 = this.j;
        if (r151 == null) goto L106;
        RedDotTextView r152 = r151.d;
        if (r152 == null) goto L106;
        if (r152.getRedDotCount() <= 0) goto L106;
        if (((Boolean) this.E.getValue()).booleanValue() == false) goto L106;
        r152.setVisibility(0);
    L106:
        LarusPageChatImmersiveBinding r153 = this.j;
        if (r153 == null) goto L111;
        RedDotTextView r154 = r153.d;
        if (r154 == null) goto L111;
        com.larus.utils.e1.d(r154, new com.larus.bmhome.chat.immerse.b(this));
        goto L111
    L92:
        LarusPageChatImmersiveBinding r155 = this.j;
        if (r155 == null) goto L97;
        AppCompatImageView r156 = r155.b;
        if (r156 == null) goto L97;
        com.larus.utils.e1.d(r156, new o(this));
        goto L97
    L5:
        AppCompatActivity r26 = requireActivity();
        if ((r26 instanceof AppCompatActivity) == false) goto L8;
        AppCompatActivity r27 = r26;
    L9:
        if (r27 == null) goto L13;
        AppCompatDelegate r28 = r27.getDelegate();
        if (r28 == null) goto L13;
        int r29 = r28.getLocalNightMode();
    L14:
        if (r29 != 2) goto L16;
    L18:
        if (r13 != null) goto L38;
        i0 r157 = i0.a;
        FragmentActivity r158 = getActivity();
        if (r158 == null) goto L22;
        Context r159 = r158.getApplicationContext();
    L23:
        if (r159 == null) goto L32;
        Lazy r30 = we8.j.a;
        int r31 = we8.j.c;
        if (r31 == (-1)) goto L28;
        if (r31 != 2) goto L32;
    L31:
        boolean r160 = true;
    L33:
        if (r160 == true) goto L38;
        if ((getActivity() instanceof ChatImmersActivity) == false) goto L38;
        return;
    L28:
        if ((r159.getResources().getConfiguration().uiMode & 48) == 32) goto L31;
    L32:
        r160 = false;
        goto L33
    L22:
        r159 = null;
        goto L23
    L16:
        if ((getActivity() instanceof ChatImmersActivity) == false) goto L18;
        return;
    L13:
        r29 = -100;
        goto L14
    L8:
        r27 = null;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00cb -> B:37:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ee -> B:36:0x00f0). Please report as a decompilation issue!!! */
    public static final Object Y90(ChatImmersFragment r11, List r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof ChatImmersFragment$dataProcessor$1) == false) goto L7;
        ChatImmersFragment$dataProcessor$1 r0 = (ChatImmersFragment$dataProcessor$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Collection r15 = (Collection) r0.L$3;
        RecommendBot r4 = (RecommendBot) r0.L$2;
        Iterator r5 = (Iterator) r0.L$1;
        Collection r6 = (Collection) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L36:
        String r16 = (String) r14;
    L37:
        r15.add(BundleKt.bundleOf(new Pair[]{TuplesKt.to("argBotRecommendFrom", r4.a), TuplesKt.to("argPreviousPage", r11.b()), TuplesKt.to("argConversationId", r16), TuplesKt.to("argCvsBgImgUrl", r4.e()), TuplesKt.to("argCvsBgImgColor", r4.a()), TuplesKt.to("argCvsBgImgOpen", Boxing.boxBoolean(r4.c())), TuplesKt.to("argBotId", r4.o()), TuplesKt.to("argCvsBgVideoModel", r4.g())}));
        Iterator r17 = r5;
        Collection r18 = r6;
    L18:
        if (r17.hasNext() == false) goto L39;
        r4 = (RecommendBot) r17.next();
        Map r7 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
        RepoDispatcher.a.getClass();
        ConversationRepo r8 = RepoDispatcher.f;
        String r9 = r4.o();
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r0.L$0 = r18;
        r0.L$1 = r17;
        r0.L$2 = r4;
        r0.L$3 = r7;
        r0.L$4 = r18;
        r0.label = 1;
        Object r10 = r8.a(r9, r0);
        if (r10 == r2) goto L40;
        Collection r19 = r18;
        r14 = r10;
        Iterator r20 = r17;
        r15 = r19;
    L26:
        wc9.e r110 = (wc9.e) r14;
        if (r4.M() == true) goto L29;
    L32:
        RepoDispatcher.a.getClass();
        ConversationRepo r111 = RepoDispatcher.f;
        r0.L$0 = r19;
        r0.L$1 = r20;
        r0.L$2 = r4;
        r0.L$3 = r15;
        r0.L$4 = null;
        r0.label = 2;
        r14 = r111.u(r4, r7, r0);
        if (r14 == r2) goto L41;
        r5 = r20;
        r6 = r19;
        goto L36
    L41:
        return r2;
    L29:
        if (com.larus.utils.o0.d(r4.E()) == false) goto L32;
        if (r110 == null) goto L32;
        r16 = r4.E();
        r5 = r20;
        r6 = r19;
        goto L37
    L40:
        return r2;
    L39:
        return (List) r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r15 = (Collection) r0.L$4;
        Map r21 = (Map) r0.L$3;
        RecommendBot r22 = (RecommendBot) r0.L$2;
        r20 = (Iterator) r0.L$1;
        r19 = (Collection) r0.L$0;
        ResultKt.throwOnFailure(r14);
        r7 = r21;
        r4 = r22;
        goto L26
    L16:
        ResultKt.throwOnFailure(r14);
        List r112 = r12;
        r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        r17 = r112.iterator();
    L7:
        r0 = new ChatImmersFragment$dataProcessor$1(r11, r13);
        goto L8
    }

    public final void onActivityResult(int r4, int r5, Intent r6) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r4, r5, r6);
        ChatImmersViewPagerAdapter r0 = this.l;
        if (r0 == null) goto L14;
        if (r6 == null) goto L15;
        Bundle r7 = r6.getExtras();
        if (r7 == null) goto L16;
        ChatFragment r1 = FragmentStateAdapterHelper.INSTANCE.getFragmentByIndex(r0, this.s);
        if ((r1 instanceof ChatFragment) == false) goto L10;
        ChatFragment r2 = r1;
    L11:
        if (r2 == null) goto L17;
        r2.Lc(r7, r4, r5);
        return;
    L17:
        return;
    L10:
        r2 = null;
        goto L11
    L16:
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.View, com.larus.bmhome.chat.immerse.ChatImmerseConstraintLayout] */
    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131563018, r11, false);
        int r14 = 2131363779;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r13, 2131363779);
        if (r2 == null) goto L25;
        r14 = 2131365524;
        ViewPager2 r3 = ViewBindings.findChildViewById(r13, 2131365524);
        if (r3 == null) goto L25;
        r14 = 2131365608;
        RedDotTextView r4 = ViewBindings.findChildViewById(r13, 2131365608);
        if (r4 == null) goto L25;
        r14 = 2131369141;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, 2131369141);
        if (r5 == null) goto L25;
        r14 = 2131379011;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r13, 2131379011);
        if (r6 == null) goto L25;
        r14 = 2131383297;
        if (((ProgressBar) ViewBindings.findChildViewById(r13, 2131383297)) == null) goto L25;
        r14 = 2131384467;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r13, 2131384467);
        if (r7 == null) goto L25;
        r14 = 2131384468;
        if (((ImageView) ViewBindings.findChildViewById(r13, 2131384468)) == null) goto L25;
        r14 = 2131384471;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131384471)) == null) goto L25;
        r14 = 2131388843;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r13, 2131388843);
        if (r8 == null) goto L25;
        ?? r15 = (ChatImmerseConstraintLayout) r13;
        this.j = new LarusPageChatImmersiveBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        this.e = true;
        return r15;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
