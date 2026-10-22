package com.bytedance.ai.applet.webview;

import a3.c;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u000e\u001a.\u0012*\u0012(\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\n0\n \u0010*\u0014\u0012\u000e\b\u0001\u0012\n \u0010*\u0004\u0018\u00010\n0\n\u0018\u00010\t0\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/applet/webview/PermissionResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "resultCallback", "Lkotlin/Function1;", "", "", "pendingPermissions", "", "", "[Ljava/lang/String;", "launched", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "onResume", "detachSelf", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionResultFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public Function1<? super int[], Unit> d;
    public String[] e;
    public boolean f;
    public final ActivityResultLauncher<String[]> g;

    public static final class a {
    }

    static {
    }

    public PermissionResultFragment() {
        this.g = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new c(this));
    }

    public final void S90() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isFinishing() == false) goto L8;
        return;
    L8:
        if (r0.isDestroyed() == true) goto L18;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Result.constructor-impl(Integer.valueOf(r0.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss()));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public final void onResume() {
        super.onResume();
        String[] r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f == false) goto L8;
        return;
    L8:
        this.f = true;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        this.g.launch(r0);     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r10) == null) goto L22;
        Function1<? super int[], Unit> r11 = this.d;
        this.d = null;
        if (r11 == null) goto L18;
        r11.invoke(new int[0]);
    L18:
        S90();
        return;
    L22:
        return;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
