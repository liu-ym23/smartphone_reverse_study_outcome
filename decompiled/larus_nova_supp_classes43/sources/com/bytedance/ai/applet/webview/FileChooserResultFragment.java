package com.bytedance.ai.applet.webview;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002R\"\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\n0\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/applet/webview/FileChooserResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "resultCallback", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "", "pendingIntent", "Landroid/content/Intent;", "captureOutputUri", "launched", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "onResume", "parseCaptureOrPickerResult", "data", "parsePickerResult", "cleanupCaptureUriOnCancel", "resultCode", "", "detachSelf", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileChooserResultFragment extends Fragment {
    public static final /* synthetic */ int i = 0;
    public Function1<? super List<? extends Uri>, Unit> d;
    public Intent e;
    public Uri f;
    public boolean g;
    public final ActivityResultLauncher<Intent> h;

    public static final class a {
        public static void a(FragmentActivity r1, Intent r10, Uri r11, Function1 r12) {
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r10, "intent");
            Intrinsics.checkNotNullParameter(r12, "callback");
            FileChooserResultFragment r0 = new FileChooserResultFragment();
            r0.d = r12;
            r0.e = r10;
            r0.f = r11;
            FragmentTransaction r13 = r1.getSupportFragmentManager().beginTransaction();
            String r14 = "FileChooserResultFragment-" + System.identityHashCode(r0);
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r14, 0) == true) goto L6;
            r13 = r13.add(r0, r14);
        L6:
            r13.commitAllowingStateLoss();
        }
    }

    static {
    }

    public FileChooserResultFragment() {
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3.b(this));
    }

    public final void U90() {
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
        Intent r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.g == false) goto L8;
        return;
    L8:
        this.g = true;
        this.e = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L11
        this.h.launch(r0);     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r1) == null) goto L22;
        Function1<? super List<? extends Uri>, Unit> r11 = this.d;
        this.d = null;
        S90(0);
        if (r11 == null) goto L18;
        r11.invoke(CollectionsKt.emptyList());
    L18:
        U90();
        return;
    L22:
        return;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void S90(int r10) {
        Uri r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10 == (-1)) goto L20;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
        Context r12 = getContext();     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        ContentResolver r13 = r12.getContentResolver();     // Catch: Throwable -> L15
        if (r13 == null) goto L12;
        Integer r14 = Integer.valueOf(T90(r13, r0));     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r14);     // Catch: Throwable -> L15
        return;
    L12:
        r14 = null;
    L15:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public static int T90(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r10 = {r21, null, null};
        f06.b r13 = new f06.b();
        g06.a r11 = (g06.a) ApiHookConfig.b.get(240019);
        if (r11 == null) goto L5;
        f06.a[] r12 = r11.i;
    L6:
        f06.a[] r14 = r12;
        int r15 = r14.length;
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L15;
        f06.a r17 = r14[r16];
        int r18 = r16;
        int r19 = r15;
        f06.a[] r110 = r14;
        d r22 = r17.preInvoke(240019, "android/content/ContentResolver", "delete", r20, r10, "int", r13);     // Catch: Exception -> L22
        if (r22.a == true) goto L17;
        r1.add(r17);     // Catch: Exception -> L22
    L17:
        if (r22.a == false) goto L21;
        return ((Integer) r22.b).intValue();
    L21:
        return r20.delete(r21, null, null);
    L14:
        r16 = r18 + 1;
        r15 = r19;
        r14 = r110;
        goto L8
    L15:
        r22 = new d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
