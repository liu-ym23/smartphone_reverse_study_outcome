package com.larus.bmhome;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\rH\u0002J\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0003J\u001a\u0010\u0019\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u001b\u001a\u00020\rJ\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\nJ\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\u0003J\b\u0010)\u001a\u0004\u0018\u00010\nJ\b\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "initDarkMode", "", "<init>", "(Z)V", "getInitDarkMode", "()Z", "isDarkModeFragment", "containerChatFragment", "Landroidx/fragment/app/Fragment;", "onResumed", "Lkotlin/Function1;", "", "homeServiceImpl", "getHomeServiceImpl", "()Lkotlin/Unit;", "homeServiceImpl$delegate", "Lkotlin/Lazy;", "removeContainerTask", "Ljava/lang/Runnable;", "execRemoveContainerTask", "cancelRemoveContainerTask", "setDarkModeFragment", "needDark", "setOnResumedCallBack", "callBack", "resetOnResumeCallBack", "onViewStateRestored", "savedInstanceState", "Landroid/os/Bundle;", "clearExtraWhenRestoredPage", "extra", "addChatContainer", "Landroid/view/View;", "fragment", "onSaveInstanceState", "outState", "supportChatPageSaveInstanceState", "removeChatContainer", "isExistChatContainer", "getChildChatFragment", "onResume", "onChatFragmentClose", "Companion", "MainTab", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class BaseHomeTabFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public boolean e;
    public Fragment f;
    public final Lazy g;
    public final q h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/BaseHomeTabFragment$MainTab;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "CONVERSATION", "DISCOVERY", "NOTIFY", SuggestActionType.VIDEO, "MINE", "ADDRESS_BOOK", "COMMUNITY_CREATE", "Drive", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum MainTab extends Enum<MainTab> {
        public static final MainTab ADDRESS_BOOK = null;
        public static final MainTab COMMUNITY_CREATE = null;
        public static final MainTab CONVERSATION = null;
        public static final MainTab DISCOVERY = null;
        public static final MainTab Drive = null;
        public static final MainTab MINE = null;
        public static final MainTab NOTIFY = null;
        public static final MainTab VIDEO = null;
        public static final /* synthetic */ MainTab[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int index;

        public static EnumEntries<MainTab> getEntries() {
            return b;
        }

        static {
            MainTab r0 = new MainTab("CONVERSATION", 0, 0);
            CONVERSATION = r0;
            IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r3 == null) goto L5;
            r3.i0();
            int r4 = com.larus.home.impl.sdk.y.a.d();
        L6:
            MainTab r1 = new MainTab("DISCOVERY", 1, r4);
            DISCOVERY = r1;
            IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r5 == null) goto L9;
            r5.i0();
            int r6 = com.larus.home.impl.sdk.y.a.g();
        L10:
            MainTab r7 = new MainTab("NOTIFY", 2, r6);
            NOTIFY = r7;
            MainTab r8 = new MainTab(SuggestActionType.VIDEO, 3, 3);
            VIDEO = r8;
            MainTab r9 = new MainTab("MINE", 4, 4);
            MINE = r9;
            IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r11 == null) goto L13;
            r11.i0();
            int r12 = com.larus.home.impl.sdk.y.a.a();
        L14:
            MainTab r10 = new MainTab("ADDRESS_BOOK", 5, r12);
            ADDRESS_BOOK = r10;
            IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r13 == null) goto L17;
            r13.i0();
            int r14 = com.larus.home.impl.sdk.y.a.c();
        L18:
            MainTab r15 = new MainTab("COMMUNITY_CREATE", 6, r14);
            COMMUNITY_CREATE = r15;
            IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r16 == null) goto L21;
            r16.i0();
            int r17 = com.larus.home.impl.sdk.y.a.e();
        L22:
            MainTab r18 = new MainTab("Drive", 7, r17);
            Drive = r18;
            MainTab[] r19 = {r0, r1, r7, r8, r9, r10, r15, r18};
            a = r19;
            b = EnumEntriesKt.enumEntries(r19);
            return;
        L21:
            r17 = 1;
            goto L22
        L17:
            r14 = 2;
            goto L18
        L13:
            r12 = 1;
            goto L14
        L9:
            r6 = 3;
            goto L10
        L5:
            r4 = 1;
            goto L6
        }

        public static MainTab[] values() {
            return (MainTab[]) a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public static MainTab valueOf(String r1) {
            return (MainTab) r27.a.a(MainTab.class, r1);
        }

        public MainTab(String r1, int r2, int r3) {
            super(r1, r2);
            this.index = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public BaseHomeTabFragment() {
        this(false);
    }

    public void W90() {
    }

    public final Fragment U90() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(getChildFragmentManager().findFragmentByTag("chat_fragment_tag"));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (Fragment) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void X90() {
        FLogger r0 = FLogger.a;
        r0.d("BaseHomeTabFragment", "step2 removeChatContainer before containerChatFragment " + this.f);
        ViewGroup r1 = null;
        this.f = null;
        View r3 = getView();
        if ((r3 instanceof ViewGroup) == false) goto L5;
        r1 = (ViewGroup) r3;
    L5:
        if (r1 == null) goto L9;
        View r4 = r1.findViewById(2131379463);
        if (r4 == null) goto L9;
        r1.removeView(r4);
        r0.d("BaseHomeTabFragment", "step3 removeChatContainer after");
    L9:
        W90();
    }

    public final boolean V90() {
        View r0 = getView();
        View r2 = null;
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.findViewById(2131379463);
    L8:
        if (r2 == null) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.q] */
    public BaseHomeTabFragment(boolean r1) {
        this.e = r1;
        this.g = LazyKt.lazy(new p());
        this.h = new q(this);
    }

    public void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r3);
        Fragment r0 = this.f;
        if (r0 == null) goto L5;
        Bundle r1 = r0.getArguments();
    L6:
        r3.putBundle("base_home_state_extra", r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void onViewStateRestored(Bundle r5) {
        super/*androidx.fragment.app.Fragment*/.onViewStateRestored(r5);
        if (r5 != null) goto L6;
    L26:
        boolean r1 = false;
    L27:
        if (r1 == false) goto L35;
        if (r5 == null) goto L36;
        Bundle r6 = r5.getBundle("base_home_state_extra");
        if (r6 == null) goto L37;
        String r0 = r6.getString("base_home_state_schema", "");
        r6.putString("auto_send_text", "");
        r6.putString("auto_send_uris", "");
        r6.putString("argAutoSearchText", "");
        r6.putString("push_question", "");
        if (com.larus.utils.o0.d(r0) == false) goto L38;
        com.bytedance.router.i r2 = SmartRouter.buildRoute(getContext(), r0);
        r2.c.putExtras(r6);
        r2.d();
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
        JSONObject r3 = new JSONObject();
        r3.put("url", r0);
        Unit r4 = Unit.INSTANCE;
        r7.reportEvent("rd_android_restored_page", r3);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if (z2.a.getShareConfig().r() == false) goto L26;
        Lazy r8 = com.larus.im.j.a;
        Bundle r9 = r5.getBundle("base_home_state_extra");
        ay9.a r10 = null;
        if (r9 == null) goto L11;
        String r11 = r9.getString("argConversationId");
    L13:
        if (com.larus.im.j.f(r11) == true) goto L26;
        if ((getParentFragment() instanceof ay9.a) == false) goto L26;
        if ((this instanceof s19.a) == false) goto L26;
        Fragment r12 = getParentFragment();
        if ((r12 instanceof ay9.a) == false) goto L22;
        r10 = (ay9.a) r12;
    L22:
        if (r10 == null) goto L26;
        if (((s19.a) this).sb() != r10.Fu()) goto L26;
        r1 = true;
        goto L27
    L11:
        r11 = null;
        goto L13
    }
}
