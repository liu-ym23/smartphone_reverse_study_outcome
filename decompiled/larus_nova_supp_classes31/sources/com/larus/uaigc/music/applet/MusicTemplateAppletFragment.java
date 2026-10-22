package com.larus.uaigc.music.applet;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.uaigc.applet.IMusicAppletHostService;
import com.larus.uaigc.impl.databinding.LarusFragmentMusicTemplateAppletBinding;
import com.larus.uaigc.music.template.MusicTemplateListFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0016\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u000fH\u0002J\f\u00102\u001a\u00020\u000f*\u00020 H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u000fH\u0002J\u0014\u00105\u001a\u00020\u00192\n\b\u0002\u00106\u001a\u0004\u0018\u00010\tH\u0002J\b\u00107\u001a\u00020\u0019H\u0002J\b\u00108\u001a\u00020\u0019H\u0002J\b\u00109\u001a\u00020\u0019H\u0002J\b\u0010:\u001a\u00020\u0019H\u0002J\u0012\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\b\u0010>\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u00020\u001eH\u0002J\u0012\u0010@\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010A\u001a\u00020\u0019H\u0002J\b\u0010B\u001a\u00020\u0019H\u0002J\n\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\u001c\u0010F\u001a\u00020\u00192\b\b\u0002\u0010G\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\u000fH\u0002J\u0012\u0010I\u001a\u00020\u00192\b\b\u0002\u0010G\u001a\u00020\u000fH\u0002J\"\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020=2\b\b\u0002\u0010M\u001a\u00020\u000fH\u0002J\u0018\u0010N\u001a\u00020\u00192\u0006\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020=H\u0002J\b\u0010O\u001a\u00020\u0019H\u0002J\b\u0010P\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\n\u0010R\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010T\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020=H\u0002J\b\u0010X\u001a\u00020=H\u0002J\b\u0010Y\u001a\u00020=H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006["}, d2 = {"Lcom/larus/uaigc/music/applet/MusicTemplateAppletFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentMusicTemplateAppletBinding;", "instructionArgumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "musicActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "editorAbility", "Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "instructionPanelAbility", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "hasAutoOpenedInputPanel", "", "hasReportedStartCreate", "templatePageEnterTime", "", "appletContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "appletLifecycleCallback", "com/larus/uaigc/music/applet/MusicTemplateAppletFragment$appletLifecycleCallback$1", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletFragment$appletLifecycleCallback$1;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onDestroyView", "onDestroy", "initBackIcon", "adaptHostBottomPadding", "root", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "adaptBottomPadding", "", "bottomPadding", "safeBottomPadding", "hasBottomNavigationBar", "updateBackIconVisibility", "canNavigateBackInMusicApplet", "bindAppletData", "actionBarItem", "attachComponents", "showMusicTemplateFragment", "observeUseTemplateEvent", "observeSendFinishedEvent", "openProfileSourceChatPage", "sendConversationId", "", "moveMusicAppletTaskToBackground", "buildTemplateArguments", "buildArgumentsWithMusicInstruction", "ensureMusicInstructionEditorOpened", "tryAutoOpenInputPanel", "resolveDoSameTemplate", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "initStartWriteEntry", "showMusicInputPanel", "clearInput", "requestFocus", "focusMusicInput", "useMusicTemplate", "template", "enterFrom", "reportEvent", "reportUseTemplate", "reportTemplatePageEnter", "reportTemplatePageExit", "reportMusicStartCreateIfNeeded", "resolveMusicActionBarItem", "resolveMusicInstructionEditorAbility", "resolveInstructionPanelAbility", "resolveChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "resolveBotId", "resolveChatType", "resolvePreviousPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateAppletFragment extends Fragment {
    public static final /* synthetic */ int m = 0;
    public LarusFragmentMusicTemplateAppletBinding d;
    public ny9.s e;
    public com.larus.bmhome.actionbar.model.z0 f;
    public f g;
    public u1 h;
    public boolean i;
    public boolean j;
    public long k;
    public final b l;

    public static final class a {
    }

    public static final class b implements ir8.c.a {
        public final /* synthetic */ MusicTemplateAppletFragment a;

        public final void a() {
            Intrinsics.checkNotNullParameter("db_2c90E66", "appId");
            if (Intrinsics.areEqual("db_2c90E66", "db_2c90E66") == true) goto L5;
            return;
        L5:
            if (ir8.c.a(this) == false) goto L9;
            MusicTemplateAppletFragment r0 = this.a;
            int r1 = MusicTemplateAppletFragment.m;
            r0.W90();
            return;
        }

        public b(MusicTemplateAppletFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void W90() {
        long r0 = this.k;
        if (r0 > 0) goto L5;
        return;
    L5:
        this.k = 0;
        kr8.n r2 = kr8.n.a;
        kr8.o r3 = kr8.n.a(getArguments(), null, null, null, null, null, 62);
        long r4 = SystemClock.elapsedRealtime() - r0;
        Intrinsics.checkNotNullParameter(r3, "context");
        JSONObject r1 = kr8.n.k(r3, "template_page");
        r1.put("duration", r4);
        Unit r5 = Unit.INSTANCE;
        kr8.n.g("music_app_page_exit", r1);
    }

    public final com.larus.bmhome.actionbar.model.z0 aa0() {
        com.larus.bmhome.actionbar.model.z0 r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ny9.s r1 = this.e;
        if (r1 == null) goto L11;
        com.larus.bmhome.actionbar.model.z0 r2 = r1.f();
        if (r2 == null) goto L11;
        this.f = r2;
        return r2;
    L11:
        Bundle r3 = getArguments();
        if (r3 == null) goto L17;
        com.larus.bmhome.actionbar.model.z0 r4 = new ny9.s(r3).f();
        if (r4 == null) goto L17;
        this.f = r4;
        return r4;
    L17:
        IActionBarService r5 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r5 == null) goto L22;
        com.larus.bmhome.actionbar.model.z0 r6 = r5.e(1);
        if (r6 == null) goto L22;
        this.f = r6;
        return r6;
    L22:
        return null;
    }

    public final f ba0() {
        f r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        f r1 = (f) s1a.a.g(this).getAbility(f.class);
        if (r1 == null) goto L8;
        this.g = r1;
        return r1;
    L8:
        return null;
    }

    public final void onDestroy() {
        CopyOnWriteArraySet r0 = ir8.c.a;
        ir8.c.c(this.l);
        super.onDestroy();
    }

    public MusicTemplateAppletFragment() {
        this.l = new b(this);
    }

    public final void U90() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L17;
        FLogger.a.e("MusicTemplateAppletFragment", "move music applet task to background failed, activity is null");
        return;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Boolean.valueOf(r0.moveTaskToBack(true)));     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r1) == false) goto L13;
        boolean r3 = ((Boolean) r1).booleanValue();
        FLogger.a.i("MusicTemplateAppletFragment", "move music applet task to background result=" + r3);
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L19;
        FLogger.a.e("MusicTemplateAppletFragment", "move music applet task to background failed", r4);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void V90() {
        this.k = SystemClock.elapsedRealtime();
        kr8.n r0 = kr8.n.a;
        kr8.o r1 = kr8.n.a(getArguments(), null, null, null, null, null, 62);
        Intrinsics.checkNotNullParameter(r1, "context");
        kr8.n.g("music_app_page_enter", kr8.n.k(r1, "template_page"));
    }

    public final String X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("argBotId");
        if (r1 == null) goto L6;
        return r1;
    L6:
        ChatParam r2 = Y90();
        if (r2 == null) goto L9;
        String r3 = r2.b;
    L10:
        if (r3 != null) goto L14;
        return "";
    L14:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final ChatParam Y90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        ChatParam r1 = (ChatParam) r0.getParcelable("chat_param");
    L7:
        if ((r1 instanceof ChatParam) == true) goto L9;
        return null;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final String Z90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("arg_chat_type");
        if (r1 == null) goto L6;
        return r1;
    L6:
        ChatParam r2 = Y90();
        if (r2 == null) goto L9;
        String r3 = r2.e;
    L10:
        if (r3 != null) goto L14;
        return "other_default";
    L14:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final String ca0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("argPreviousPage");
        if (r1 == null) goto L6;
        return r1;
    L6:
        ChatParam r2 = Y90();
        if (r2 == null) goto L9;
        String r3 = r2.c;
    L10:
        if (r3 != null) goto L14;
        return "";
    L14:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final void onDestroyView() {
        W90();
        super.onDestroyView();
        this.d = null;
        this.g = null;
        this.h = null;
    }

    public final void onResume() {
        super.onResume();
        if (this.k > 0) goto L6;
        V90();
        return;
    }

    public static boolean T90(ChatConstraintLayout r4) {
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom <= 0) goto L8;
        return true;
    L8:
        int r1 = r5.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r6 = r5.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures()).bottom;
        if (r1 <= 0) goto L13;
        if (r6 > r1) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    public final void S90(com.larus.bmhome.actionbar.model.z0 r4) {
        Bundle r0 = new Bundle(getArguments());
        if (r4 == null) goto L5;
        this.f = r4;
        r0.putString("custom_action_bar_item", xt7.d.b.a(com.larus.bmhome.actionbar.model.z0.Companion.serializer(), r4));
    L6:
        setArguments(r0);
        t1a.b r5 = s1a.a.g(this);
        de8.c r1 = de8.c.s;
        r5.n(de8.c.a.a(r0), de8.c.class);
        ny9.s r6 = new ny9.s(r0);
        s1a.a.g(this).n(r6, ny9.s.class);
        this.e = r6;
        ny9.u r2 = new ny9.u(r6);
        s1a.a.g(this).n(r2, ny9.u.class);
        return;
    L5:
        FLogger.a.e("MusicTemplateAppletFragment", "music action bar item is null when bind applet data");
        goto L6
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        S90(aa0());
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        CopyOnWriteArraySet r3 = ir8.c.a;
        b r4 = this.l;
        Intrinsics.checkNotNullParameter(r4, "callback");
        ir8.c.a.add(r4);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new i0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.larus.uaigc.music.applet.g0] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        CopyOnWriteArraySet r11 = ir8.c.a;
        ir8.c.b(this.l);
        LarusFragmentMusicTemplateAppletBinding r12 = this.d;
        if (r12 == null) goto L7;
        final ChatConstraintLayout r13 = r12.d;
        if (r13 == null) goto L7;
        final int r14 = c7.b(16);
        final Function2 r0 = r13.getInterruptBottomPaddingUpdate();
        r13.setInterruptBottomPaddingUpdate(new j0(this, r14, r13, r0));
        r13.post(new k0(this, r13, r14));
    L7:
        V90();
        boolean r1 = true;
        if (getChildFragmentManager().findFragmentById(2131388323) != null) goto L15;
        MusicTemplateListFragment r15 = new MusicTemplateListFragment();
        Bundle r2 = new Bundle(getArguments());
        r2.putString("argBotId", X90());
        r2.putString("arg_chat_type", Z90());
        r2.putString("argPreviousPage", ca0());
        r2.putBoolean("compatDoubleTabMargin", true);
        r2.putBoolean("argument_hide_title_bar", true);
        r2.putBoolean("argument_is_music_applet_template", true);
        r15.setArguments(r2);
        r15.d = new c0(this);
        FragmentTransaction r3 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r15, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131388323) == true) goto L14;
        r3 = r3.replace(2131388323, r15);
    L14:
        r3.commitAllowingStateLoss();
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MusicTemplateAppletFragment$observeUseTemplateEvent$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MusicTemplateAppletFragment$observeSendFinishedEvent$1(this, null), 3, null);
        if (this.i == true) goto L32;
        Bundle r16 = getArguments();
        if (r16 != null) goto L21;
    L23:
        r1 = false;
    L24:
        if (r1 == false) goto L33;
        t1 r17 = (t1) s1a.a.g(this).getAbility(t1.class);
        if (r17 != 0) goto L29;
        FLogger.a.e("MusicTemplateAppletFragment", "auto open music input failed, input ready ability is null");
        return;
    L29:
        r17.kK(new g0(this));
        return;
    L33:
        return;
    L21:
        if (r16.getBoolean("auto_open_input_panel") != true) goto L23;
    }

    public static void da0(MusicTemplateAppletFragment r10, boolean r11, int r12) {
        boolean r1 = false;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        if ((r12 & 2) == 0) goto L8;
        boolean r13 = true;
    L9:
        LarusFragmentMusicTemplateAppletBinding r2 = r10.d;
        if (r2 == null) goto L49;
        com.larus.utils.e1.o(r2.e);
        com.larus.utils.e1.x(r2.c);
        if (r10.j == true) goto L16;
        r10.j = true;
        kr8.n r3 = kr8.n.a;
        kr8.o r4 = kr8.n.a(r10.getArguments(), null, null, null, null, null, 62);
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("template_page", "currentPage");
        kr8.n.g("music_start_create", kr8.n.k(r4, "template_page"));
    L16:
        u1 r5 = r10.h;
        if (r5 != null) goto L23;
        r5 = (u1) s1a.a.g(r10).getAbility(u1.class);
        if (r5 == null) goto L22;
        r10.h = r5;
        goto L23
    L22:
        r5 = null;
    L23:
        if (r5 == null) goto L25;
        r5.yD();
    L25:
        f r6 = r10.ba0();
        if (r6 != null) goto L28;
    L30:
        if (r1 == true) goto L39;
        com.larus.bmhome.actionbar.model.z0 r0 = r10.aa0();
        if (r0 != null) goto L35;
        FLogger.a.e("MusicTemplateAppletFragment", "open music instruction editor failed, actionBarItem is null");
        goto L39
    L35:
        r10.S90(r0);
        f r7 = r10.ba0();
        if (r7 != null) goto L38;
        FLogger.a.e("MusicTemplateAppletFragment", "open music instruction editor failed, editorAbility is null");
        goto L39
    L38:
        r7.ov(r0);
    L39:
        if (r13 == false) goto L46;
        LarusFragmentMusicTemplateAppletBinding r14 = r10.d;
        if (r14 == null) goto L47;
        FrameLayout r15 = r14.c;
        if (r15 == null) goto L48;
        r15.post(new h0(r11, r10));
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L28:
        if (r6.Q1() != 1) goto L30;
        r1 = true;
        goto L30
    L49:
        return;
    L8:
        r13 = false;
        goto L9
    }

    public final void ea0(bq8.a r11, String r12, boolean r13) {
        FLogger.a.i("MusicTemplateAppletFragment", "use music template, templateId=" + r11.a + ", enterFrom=" + r12);
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        r0.putString("from_entrance", "similar");
    L5:
        boolean r1 = false;
        if (r13 == true) goto L8;
    L12:
        da0(this, false, 1);
        f r14 = ba0();
        if (r14 == null) goto L15;
        r14.mZ(r11);
    L15:
        LarusFragmentMusicTemplateAppletBinding r15 = this.d;
        if (r15 == null) goto L21;
        FrameLayout r16 = r15.c;
        if (r16 == null) goto L22;
        r16.post(new h0(r1, this));
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (Intrinsics.areEqual(r12, "template_detail_button") == false) goto L10;
        String r17 = "music_template_detail";
    L11:
        kr8.b0 r9 = new kr8.b0(r12, String.valueOf(r11.a), "music", X90(), Z90(), 1);
        kr8.n r18 = kr8.n.a;
        kr8.l.a.b(r9, kr8.n.c(kr8.n.a(getArguments(), null, r11, null, "similar", r17, 10), r17, false), 1);
        goto L12
    L10:
        r17 = "template_page";
        goto L11
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        int r0 = 0;
        ChatConstraintLayout r14 = r11.inflate(2131562416, r12, false);
        int r15 = 2131363779;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r14, 2131363779);
        if (r3 == null) goto L78;
        r15 = 2131365537;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131365537);
        if (r4 == null) goto L78;
        r15 = 2131375364;
        ViewStub r16 = (ViewStub) ViewBindings.findChildViewById(r14, 2131375364);
        if (r16 == null) goto L78;
        ChatConstraintLayout r6 = r14;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131387244);
        if (r7 == null) goto L76;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131388323);
        if (r8 != null) goto L13;
        r15 = 2131388323;
        goto L78
    L13:
        if (ViewBindings.findChildViewById(r14, 2131388772) == null) goto L74;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131388807);
        if (r9 == null) goto L73;
        this.d = new LarusFragmentMusicTemplateAppletBinding(r6, r3, r4, r16, r6, r7, r8, r9);
        InputViewCreatorDelegate.b.a(r16, 2131375364);
        LarusFragmentMusicTemplateAppletBinding r17 = this.d;
        if (r17 == null) goto L21;
        ChatConstraintLayout r18 = r17.d;
        if (r18 == null) goto L21;
        com.larus.uaigc.createpage.utils.p.a(r18);
    L21:
        LarusFragmentMusicTemplateAppletBinding r19 = this.d;
        if (r19 == null) goto L30;
        FrameLayout r110 = r19.g;
        if (r110 == null) goto L30;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L29;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        com.larus.utils.i0.a.getClass();
        r112.topMargin = com.larus.utils.i0.g() + i5.r0();
        r110.setLayoutParams(r112);
        goto L30
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L30:
        LarusFragmentMusicTemplateAppletBinding r113 = this.d;
        if (r113 == null) goto L35;
        AppCompatImageView r114 = r113.b;
        if (r114 == null) goto L35;
        com.larus.utils.e1.d(r114, new f0(this));
    L35:
        boolean r115 = IMusicAppletHostService.a.c();
        LarusFragmentMusicTemplateAppletBinding r116 = this.d;
        if (r116 == null) goto L43;
        AppCompatImageView r117 = r116.b;
        if (r117 == null) goto L43;
        if (r115 == true) goto L42;
        r0 = 8;
    L42:
        r117.setVisibility(r0);
    L43:
        if (r115 == false) goto L53;
        LarusFragmentMusicTemplateAppletBinding r118 = this.d;
        if (r118 == null) goto L53;
        AppCompatImageView r119 = r118.b;
        if (r119 == null) goto L53;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L52;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        com.larus.utils.i0.a.getClass();
        r121.topMargin = com.larus.utils.i0.g() + i5.Y();
        r119.setLayoutParams(r121);
        goto L53
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L53:
        LarusFragmentMusicTemplateAppletBinding r122 = this.d;
        if (r122 == null) goto L58;
        FrameLayout r123 = r122.c;
        if (r123 == null) goto L58;
        com.larus.utils.e1.o(r123);
    L58:
        LarusFragmentMusicTemplateAppletBinding r124 = this.d;
        if (r124 == null) goto L63;
        FrameLayout r125 = r124.e;
        if (r125 == null) goto L63;
        com.larus.utils.e1.x(r125);
    L63:
        LarusFragmentMusicTemplateAppletBinding r126 = this.d;
        if (r126 == null) goto L68;
        FrameLayout r127 = r126.e;
        if (r127 == null) goto L68;
        com.larus.utils.e1.d(r127, new l0(this));
    L68:
        LarusFragmentMusicTemplateAppletBinding r128 = this.d;
        if (r128 != null) goto L79;
        return null;
    L79:
        return r128.d;
    L73:
        r15 = 2131388807;
        goto L78
    L74:
        r15 = 2131388772;
        goto L78
    L76:
        r15 = 2131387244;
    L78:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
