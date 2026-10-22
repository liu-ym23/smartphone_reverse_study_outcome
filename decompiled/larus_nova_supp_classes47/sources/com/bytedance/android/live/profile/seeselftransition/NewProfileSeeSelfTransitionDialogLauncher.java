package com.bytedance.android.live.profile.seeselftransition;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileDialogLauncher;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NewProfileSeeSelfTransitionDialogLauncher {
    public static final /* synthetic */ int d = 0;
    public NewProfileDialogLauncher a;
    public NewProfileDialogLauncher b;
    public NewProfileTransitionDialogManager c;

    public static final class a {
        @JvmStatic
        public static boolean a(UserProfileEvent r1) {
            if (r1 == null) goto L4;
            String r2 = r1.mSource;
        L6:
            return TextUtils.equals(r2, "50");
        L4:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public NewProfileSeeSelfTransitionDialogLauncher() {
    }

    public final void c() {
        if (this.c != null) goto L6;
        NewProfileTransitionDialogManager r0 = new NewProfileTransitionDialogManager();
        NewProfileSeeSelfTransitionDialogLauncher$ensureTransitionDialogHolder$1$1 r1 = new NewProfileSeeSelfTransitionDialogLauncher$ensureTransitionDialogHolder$1$1(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        r0.a = r1;
        Unit r2 = Unit.INSTANCE;
        this.c = r0;
        return;
    }

    public static final void b(NewProfileSeeSelfTransitionDialogLauncher r2, ProfileMode r3) {
        r2.getClass();
        ALogger.e("TransitionDialogLauncher", "request error: " + r3);
        r2.c();
        NewProfileTransitionDialogManager r4 = r2.c;
        if (r4 == null) goto L6;
        r4.f();
        return;
    }

    public static final void a(NewProfileSeeSelfTransitionDialogLauncher r2, ProfileMode r3, b r4, FragmentManager r5) {
        r2.getClass();
        StringBuilder r0 = new StringBuilder("dialog created: ");
        if (r4 == null) goto L5;
        String r1 = r4.toString();
    L6:
        r0.append(r1);
        r0.append(", mode: ");
        r0.append(r3);
        ALogger.i("TransitionDialogLauncher", r0.toString());
        r2.c();
        if (r4 == null) goto L23;
        if (r5 == null) goto L23;
        int r6 = c.a[r3.ordinal()];
        if (r6 != 1) goto L13;
        NewProfileTransitionDialogManager r7 = r2.c;
        if (r7 == null) goto L31;
        r7.d(r4, r5);
        return;
    L31:
        return;
    L13:
        if (r6 == 2) goto L17;
        NewProfileTransitionDialogManager r8 = r2.c;
        if (r8 == null) goto L27;
        r8.f();
        return;
    L27:
        return;
    L17:
        NewProfileTransitionDialogManager r9 = r2.c;
        if (r9 == null) goto L29;
        r9.e(r4, r5);
        return;
    L29:
        return;
    L23:
        NewProfileTransitionDialogManager r10 = r2.c;
        if (r10 == null) goto L33;
        r10.f();
        return;
    L33:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Disposable d(ProfileMonitor r20, FragmentActivity r22, IRoom r23, DataCenter r24, boolean r25, IBaseUser r26, String r27, UserProfileEvent r28) {
        Intrinsics.checkNotNullParameter(r20, "profileMonitor");
        Intrinsics.checkNotNullParameter(r23, "room");
        Intrinsics.checkNotNullParameter(r28, "event");
        ALogger.i("TransitionDialogLauncher", "prepareTransitionDialogRequest");
        if (this.a != null) goto L6;
        this.a = new NewProfileDialogLauncher();
    L6:
        if (this.b != null) goto L8;
        this.b = new NewProfileDialogLauncher();
    L8:
        NewProfileDialogLauncher r1 = this.a;
        if (r1 == null) goto L23;
        Disposable r2 = NewProfileDialogLauncher.g(r1, r20, r22, r23, r24, r25, r26, r27, r28, ProfileMode.USER_BEFORE, 1, new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$showToHideDisposable$1(this), new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$showToHideDisposable$2(this), 8192);
        if (r2 == null) goto L24;
        NewProfileDialogLauncher r3 = this.b;
        if (r3 == null) goto L20;
        ProfileMonitor r4 = new ProfileMonitor(r20.f);
        r4.b.putAll(r20.b);
        Disposable r5 = NewProfileDialogLauncher.g(r3, r4, r22, r23, r24, r25, r26, r27, r28, ProfileMode.USER_CURRENT, 2, new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$1(this), new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$2(this), 8192);
        if (r5 == null) goto L20;
        c();
        return Disposables.fromAction(new d(r2, r5));
    L20:
        r2.dispose();
        return null;
    L24:
        return null;
    L23:
        return null;
    }
}
