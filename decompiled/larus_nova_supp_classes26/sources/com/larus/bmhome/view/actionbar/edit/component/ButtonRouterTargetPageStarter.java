package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ$\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/ButtonRouterTargetPageStarter;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "_targetPageCallback", "Lcom/larus/bmhome/view/actionbar/edit/component/ButtonRouterTargetPageCallback;", "setTargetPageCallback", "", "callback", "startTargetPage", "targetPageRouter", "", "selectedId", "mobParam", "Lcom/larus/bmhome/view/actionbar/edit/component/MobParam;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonRouterTargetPageStarter extends Fragment {
    public static final a f = null;
    public final ActivityResultLauncher<Intent> d;
    public d e;

    public static final class a {
        public a() {
        }

        public static void a(FragmentActivity r5, final j2 r6, d r7) {
            Intrinsics.checkNotNullParameter(r5, "activity");
            Intrinsics.checkNotNullParameter(r6, "param");
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            FLogger.a.d("ButtonRouterTargetPageStarter", "start, param:" + r6);     // Catch: Throwable -> L15
            FragmentManager r8 = r5.getSupportFragmentManager();     // Catch: Throwable -> L15
            Fragment r2 = r8.findFragmentByTag("com.larus.ButtonRouterTargetPageStarter");     // Catch: Throwable -> L15
            if ((r2 instanceof ButtonRouterTargetPageStarter) == false) goto L6;
            ButtonRouterTargetPageStarter r4 = (ButtonRouterTargetPageStarter) r2;     // Catch: Throwable -> L15
        L7:
            if (r4 == null) goto L9;
            r8.beginTransaction().remove(r4).commitNow();     // Catch: Throwable -> L15
        L9:
            final ButtonRouterTargetPageStarter r9 = new ButtonRouterTargetPageStarter();     // Catch: Throwable -> L15
            r9.e = r7;     // Catch: Throwable -> L15
            FragmentTransaction r10 = r8.beginTransaction();     // Catch: Throwable -> L15
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "com.larus.ButtonRouterTargetPageStarter", 0) == true) goto L13;
            r10 = r10.add(r9, "com.larus.ButtonRouterTargetPageStarter");     // Catch: Throwable -> L15
        L13:
            r10.commitNow();     // Catch: Throwable -> L15
            com.larus.utils.t0.a.post(new f(r9, r6));     // Catch: Throwable -> L15
            Object r11 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L15
        L17:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L21;
            FLogger.a.e("ButtonRouterTargetPageStarter", "start failed:" + r12);
            r11 = Boolean.FALSE;
        L21:
            ((Boolean) r11).booleanValue();
            return;
        L6:
            r4 = null;
        L15:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }
    }

    static {
        f = new a();
    }

    public ButtonRouterTargetPageStarter() {
        this.d = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e(this));
    }
}
