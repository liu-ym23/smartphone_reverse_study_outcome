package com.larus.bmhome.chat.component.camera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import de8.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/component/camera/CameraInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "cameraContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "attachComponents", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CameraInputFragment extends Fragment {
    public static final /* synthetic */ int d = 0;

    public final void onDestroy() {
        super.onDestroy();
        z2.a.w3();
        AppCompatActivity r0 = getActivity();
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = r0;
    L6:
        if (r1 == null) goto L11;
        AppCompatDelegate r2 = r1.getDelegate();
        if (r2 == null) goto L12;
        r2.setLocalNightMode(AppCompatDelegate.getDefaultNightMode());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CameraInputFragment() {
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        z2.a.w3();
        AppCompatActivity r5 = getActivity();
        if ((r5 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r6 = r5;
    L6:
        if (r6 == null) goto L10;
        AppCompatDelegate r7 = r6.getDelegate();
        if (r7 == null) goto L10;
        r7.setLocalNightMode(2);
    L10:
        b r8 = a.g(this);
        c r0 = c.s;
        r8.n(c.a.a(getArguments()), c.class);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L13
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);     // Catch: Throwable -> L13
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L19;
        FLogger.a.e("CameraInputFragment", "build container error ,info is ", r11);
    L19:
        k1a.b.a(this, new od8.a(this));
        return;
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r6 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562769, r3, false);
        ViewStub r6 = (ViewStub) r5.findViewById(2131375364);
        InputViewCreatorDelegate r0 = InputViewCreatorDelegate.b;
        Intrinsics.checkNotNull(r6);
        r0.a(r6, 2131375364);
        z2.a.w3();
        return r5;
    }
}
