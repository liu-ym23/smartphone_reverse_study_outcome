package com.ss.android.lark.chatwindow.launcher;

import android.app.Activity;
import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import f0c.h;
import h7b.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ChatLauncherV2 implements c, r {
    public final m a;
    public final Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>> b;
    public final Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>> c;
    public CoroutineScope d;
    public final List<d> e;

    public static final class a {
    }

    public static final class b {
        public final Context a;
        public final Fragment b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Fragment r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "LaunchContext(context=" + this.a + ", fragment=" + this.b + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public b(Context r2, Fragment r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final m getPassport() {
        return this.a;
    }

    public final void onUserOffline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        CoroutineScope r4 = this.d;
        if (r4 == null) goto L5;
        CoroutineScopeKt.cancel$default(r4, null, 1, null);
    L5:
        this.d = null;
    }

    @Inject
    public ChatLauncherV2(m r2, Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>> r3, Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>> r4) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "transformers");
        Intrinsics.checkNotNullParameter(r4, "starters");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        r2.d(this);
        this.e = new ArrayList();
    }

    @Override // com.ss.android.lark.chatwindow.launcher.c
    public final void U7(Context r16, Fragment r17, ChatBundleInput r18, final IGetDataCallback<Unit> r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r18, "chatBundleInput");
        if (r19 == null) goto L5;
        IGetDataCallback<c.a> r5 = new ChatLauncherV2$openChat$callbackActual$1$1(r19);
    L7:
        if (this.d != null) goto L10;
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    L10:
        if (r17 == null) goto L15;
        LifecycleCoroutineScope r0 = LifecycleOwnerKt.getLifecycleScope(r17);
        if (r0 == null) goto L15;
    L21:
        LifecycleCoroutineScope r9 = r0;
        if (r9 != null) goto L24;
    L25:
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "scope is null!, not start chat");
        Unit r1 = Unit.INSTANCE;
        return;
    L24:
        if (BuildersKt.launch$default(r9, null, null, new ChatLauncherV2$openChatActual$1(r18, this, r16, r17, r5, null), 3, null) == null) goto L25;
        return;
    L15:
        if ((r16 instanceof ComponentActivity) == true) goto L17;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "openChat: context is not ComponentActivity, use globalScope");
        r0 = this.d;
        goto L21
    L17:
        if (UIUtils.isActivityRunning((Activity) r16) == false) goto L19;
        r0 = LifecycleKt.getCoroutineScope(((ComponentActivity) r16).getLifecycle());
        goto L21
    L19:
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "openChat: activity is not running, use globalScope");
        r0 = this.d;
        goto L21
    L5:
        r5 = null;
        goto L7
    }

    public final Object a(Context r23, Fragment r24, ChatBundleInput r25, Continuation<? super c.b> r26) {
        Context r1 = r23;
        if ((r26 instanceof ChatLauncherV2$openChat$2) == false) goto L7;
        ChatLauncherV2$openChat$2 r4 = (ChatLauncherV2$openChat$2) r26;
        int r5 = r4.label;
        if ((r5 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r4.label = r5 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ChatBundleV2 r2 = (ChatBundleV2) r4.L$1;
        com.ss.android.lark.chatwindow.launcher.transform.d r8 = (com.ss.android.lark.chatwindow.launcher.transform.d) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L62:
        if (((Boolean) r3).booleanValue() == false) goto L65;
        return new c.b.C0118b(new c.a(r2.i.a, r8.b));
    L65:
        return new c.b.a("starter executeStart failed");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b r9 = (b) r4.L$1;
        Context r10 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r3);
        Object r0 = ((Result) r3).unbox-impl();
        b r11 = r9;
        r1 = r10;
    L42:
        if (Result.isSuccess-impl(r0) == true) goto L44;
        Throwable r12 = Result.exceptionOrNull-impl(r0);
        if (r12 == null) goto L69;
        String r13 = r12.getMessage();
    L70:
        ErrorResult r14 = Result.exceptionOrNull-impl(r0);
        if (r14 == null) goto L76;
        if ((r14 instanceof ErrorResult) == false) goto L76;
        i.c(r1, r14, null);
    L76:
        if (r13 != null) goto L79;
        r13 = "transform failed";
    L79:
        return new c.b.a(r13);
    L69:
        r13 = null;
        goto L70
    L44:
        if (Result.isFailure-impl(r0) == false) goto L46;
        r0 = null;
    L46:
        r8 = (com.ss.android.lark.chatwindow.launcher.transform.d) r0;
        if (r8 != null) goto L50;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "openChat failed, chatBundle is null");
        return new c.b.a("openChat failed, chatBundle is null");
    L50:
        ChatBundleV2 r15 = r8.a;
        Provider<com.ss.android.lark.chatwindow.launcher.starter.a> r16 = this.c.get(r15.i.c);
        if (r16 == null) goto L53;
        com.ss.android.lark.chatwindow.launcher.starter.a r17 = (com.ss.android.lark.chatwindow.launcher.starter.a) r16.get();
    L54:
        if (r17 != null) goto L57;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "openChat failed, starter is null");
        return new c.b.a("openChat failed, starter is null");
    L57:
        r4.L$0 = r8;
        r4.L$1 = r15;
        r4.label = 2;
        r3 = r17.a(r11, r8, r4);
        if (r3 != r6) goto L60;
        return r6;
    L60:
        r2 = r15;
        goto L62
    L53:
        r17 = null;
        goto L54
    L16:
        ResultKt.throwOnFailure(r3);
        r11 = new b(r1, r24);
        if (r25.i.isValid() == true) goto L20;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "openChat failed, chatId or chatterId is empty");
        return new c.b.a("launchData is invalid");
    L20:
        Iterator r18 = ((ArrayList) this.e).iterator();
    L22:
        if (r18.hasNext() == false) goto L24;
        ((d) r18.next()).load();
        goto L22
    L24:
        SourceType r19 = ((BaseBundle) r25).a.e;
        if (r19 != null) goto L27;
    L31:
        Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>> r20 = this.b.get(r25.i.type());
        if (r20 == null) goto L34;
        com.ss.android.lark.chatwindow.launcher.transform.a r21 = (com.ss.android.lark.chatwindow.launcher.transform.a) r20.get();
    L35:
        if (r21 == null) goto L37;
        ILaunchDataInput r110 = r25.i;
        BaseBundle r111 = new BaseBundle(((BaseBundle) r25).a, ((BaseBundle) r25).b, ((BaseBundle) r25).c, ((BaseBundle) r25).d, ((BaseBundle) r25).e, ((BaseBundle) r25).f, ((BaseBundle) r25).g, ((BaseBundle) r25).h);
        r4.L$0 = r1;
        r4.L$1 = r11;
        r4.label = 1;
        r0 = r21.a(r110, r111, r4);
        if (r0 != r6) goto L42;
        return r6;
    L37:
        return new c.b.a("launch data is invalid, transform is null");
    L34:
        r21 = null;
        goto L35
    L27:
        if (r19 == SourceType.FEED) goto L31;
        if (r19 == SourceType.SHORTCUT) goto L31;
        ChatCoreModule.a().getPerfEnterChatMonitor().a(r19.value);
        PerfLog.start("open_chat", BuildConfig.FLAVOR);
    L7:
        r4 = new ChatLauncherV2$openChat$2(this, r26);
        goto L8
    }
}
