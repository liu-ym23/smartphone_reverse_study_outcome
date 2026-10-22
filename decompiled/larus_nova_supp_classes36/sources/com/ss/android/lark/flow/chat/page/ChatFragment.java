package com.ss.android.lark.flow.chat.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import jdb.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import zsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0002J\u001a\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J \u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:J\u0012\u0010;\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\"\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010A\u001a\u00020\u001e2\b\u0010B\u001a\u0004\u0018\u00010CJ\n\u0010D\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006L"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/ChatFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "startTimeSec", "", "chatFragmentFactory", "Lcom/ss/android/lark/biz/im/api/page/ChatFragmentFactory;", "getChatFragmentFactory", "()Lcom/ss/android/lark/biz/im/api/page/ChatFragmentFactory;", "setChatFragmentFactory", "(Lcom/ss/android/lark/biz/im/api/page/ChatFragmentFactory;)V", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "setFgService", "(Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "dataPreLoaderV2", "Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/IDataPreloadManagerV2;", "getDataPreLoaderV2", "()Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/IDataPreloadManagerV2;", "setDataPreLoaderV2", "(Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/IDataPreloadManagerV2;)V", "fragment", "Landroidx/fragment/app/Fragment;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "onCreateView", "Landroid/widget/FrameLayout;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "sendDuration", "onViewCreated", "view", "Landroid/view/View;", "setupContentFragment", "args", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "launchContentFragmentImpl", "onActivityResult", "requestCode", "", "resultCode", "data", "onProvideAssistContent", "assistContent", "Landroid/app/assist/AssistContent;", "findContentFragment", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "shouldNotifyPush", "", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatFragment extends Hilt_ChatFragment implements d0c.c, d {
    public long f;

    @Inject
    public oya.a g;

    @Inject
    public g h;

    @Inject
    public com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d i;
    public Fragment j;
    public String k;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final void onStart() {
        Log.i("ChatFragment", "onStart invoke");
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStart();
        this.f = System.currentTimeMillis() / ((long) AudioViewModel.ASR_SESSION_IDLE);
    }

    public final void onStop() {
        Log.i("ChatFragment", "onStop invoke");
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStop();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getIO(), null, new ChatFragment$sendDuration$1(this, null), 2, null);
    }

    @Inject
    public ChatFragment() {
        this.k = "";
    }

    public final Fragment T90() {
        if (isAdded() == true) goto L5;
        Log.e("ChatFragment", "fragment not added");
        return null;
    L5:
        return getChildFragmentManager().findFragmentByTag("content_fragment");
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m114provideComponent() {
        return provideComponent();
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        return t0.a(r2, this.k);
    }

    public final void onCreate(Bundle r5) {
        if (r5 != null) goto L16;
    L6:
        super.onCreate(r5);     // Catch: Exception -> L4
    L12:
        v4b.a.a(requireContext());
        return;
    L4:
        e = move-exception;
        ImSdk r0 = ImSdk.a;
        boolean r1 = ImSdk.c;
        boolean r2 = OfficeSDKManager.isAvailable();
        if (r2 == false) goto L14;
        if (r1 == true) goto L12;
    L14:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r2 + ", im sdk ready: " + r1 + ", onCreateFail. fallback. " + e.getMessage());
        int r6 = gza.a.a;
        return;
    L16:
        r5.remove("android:support:fragments");     // Catch: Exception -> L4
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Bundle r10 = requireArguments();
        String r11 = fxa.a.a(r10).getChatId();
        if (r11 == null) goto L10;
        this.k = r11;
        if (T90() != null) goto L7;
        Log.i("ChatFragment", "onViewCreated setupContentFragment");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatFragment$setupContentFragment$1(this, r10, null), 3, null);
        return;
    L7:
        Log.w("ChatFragment", "onViewCreated fragment existed");
        return;
    L10:
        throw new IllegalStateException("chatId == null".toString());
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        Fragment r0 = T90();
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setId(2131365524);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
