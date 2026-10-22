package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.util;

import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\t*\u0004\u0018\u00010\u0003H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/InputModeLifecycleHelper;", "Landroidx/lifecycle/LifecycleObserver;", "window", "Landroid/view/Window;", "mode", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/InputModeLifecycleHelper$Mode;", "<init>", "(Landroid/view/Window;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/InputModeLifecycleHelper$Mode;)V", "originalMode", BuildConfig.FLAVOR, "skipSoftInputModeChange", BuildConfig.FLAVOR, "getSoftInputMode", "setNewSoftInputMode", BuildConfig.FLAVOR, "restoreOriginalSoftInputMode", "Companion", "Mode", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputModeLifecycleHelper implements LifecycleObserver {
    public final Window a;
    public final Mode b;
    public int c;
    public boolean d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/InputModeLifecycleHelper$Mode;", BuildConfig.FLAVOR, "desc", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "ADJUST_RESIZE", "ADJUST_PAN", "ADJUST_NOTHING", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode ADJUST_NOTHING = null;
        public static final Mode ADJUST_PAN = null;
        public static final Mode ADJUST_RESIZE = null;
        public static final /* synthetic */ Mode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String desc;

        public static EnumEntries<Mode> getEntries() {
            return b;
        }

        static {
            Mode r0 = new Mode("ADJUST_RESIZE", 0, "adjust_resize");
            ADJUST_RESIZE = r0;
            Mode r1 = new Mode("ADJUST_PAN", 1, "adjust_pan");
            ADJUST_PAN = r1;
            Mode r2 = new Mode("ADJUST_NOTHING", 2, "adjust_nothing");
            ADJUST_NOTHING = r2;
            Mode[] r4 = {r0, r1, r2};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public final String getDesc() {
            return this.desc;
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public Mode(String r1, int r2, String r3) {
            super(r1, r2);
            this.desc = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Mode.values().length];
            r0[Mode.ADJUST_RESIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Mode.ADJUST_PAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Mode.ADJUST_NOTHING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void restoreOriginalSoftInputMode() {
        if (this.d == false) goto L6;
        this.d = false;
        return;
    L6:
        int r0 = this.c;
        if (r0 == 0) goto L12;
        Window r1 = this.a;
        if (r1 == null) goto L13;
        r1.setSoftInputMode(r0);
        return;
    L13:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void setNewSoftInputMode() {
        Window r0 = this.a;
        if (r0 == null) goto L34;
        int r1 = b.a[this.b.ordinal()];
        boolean r3 = true;
        if (r1 != 1) goto L7;
        int r2 = 16;
    L15:
        int r4 = 0;
        if (r2 == 16) goto L22;
        int r5 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.soft_input_mode_fix") == false) goto L22;
        Lazy r6 = ForsetiConfig.a;
        if (ForsetiConfig.a(r0.getContext()) == false) goto L22;
    L23:
        this.d = r3;
        if (r3 == false) goto L26;
        Log.i("InputModeLifeCycle", "skip setting " + this.b.getDesc() + " on Forseti host");
        return;
    L26:
        WindowManager.LayoutParams r7 = r0.getAttributes();
        if (r7 == null) goto L29;
        r4 = r7.softInputMode;
    L29:
        this.c = r4;
        if (r4 == r2) goto L36;
        r0.setSoftInputMode(r2);
        Log.i("InputModeLifeCycle", "set window soft input mode to " + this.b.getDesc());
        return;
    L36:
        return;
    L22:
        r3 = false;
        goto L23
    L7:
        if (r1 != 2) goto L9;
        r2 = 32;
        goto L15
    L9:
        if (r1 != 3) goto L12;
        r2 = 48;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public InputModeLifecycleHelper(Window r3) {
        Mode r0 = Mode.ADJUST_RESIZE;
        Intrinsics.checkNotNullParameter(r0, "mode");
        this.a = r3;
        this.b = r0;
        this.c = 16;
    }
}
