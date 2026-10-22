package com.larus.drive.sdk.impl.view.chat.fileselect;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveFileSelectBinding;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveFileSelectDialog$pickerCallback$2$1 implements w79.c {
    public List<DriveFileItem> a;
    public final /* synthetic */ DriveFileSelectDialog b;

    @Override // w79.c
    public final void onCanceled() {
    }

    @Override // w79.c
    public final void onSelectMoreClick() {
        DriveFileSelectDialog r0 = this.b;
        LarusDialogDriveFileSelectBinding r1 = r0.f;
        if (r1 == null) goto L11;
        TextView r2 = r1.h;
        if (r2 == null) goto L11;
        Context r3 = r0.getContext();
        if (r3 == null) goto L9;
        String r4 = r3.getString(2131900749);
    L10:
        r2.setText(r4);
        goto L11
    L9:
        r4 = null;
    L11:
        LarusDialogDriveFileSelectBinding r5 = this.b.f;
        if (r5 == null) goto L16;
        ImageView r6 = r5.b;
        if (r6 == null) goto L16;
        e1.x(r6);
    L16:
        LarusDialogDriveFileSelectBinding r7 = this.b.f;
        if (r7 == null) goto L22;
        ImageView r8 = r7.c;
        if (r8 == null) goto L23;
        e1.q(r8);
        return;
    L23:
        return;
    }

    public DriveFileSelectDialog$pickerCallback$2$1(DriveFileSelectDialog r1) {
        this.b = r1;
        this.a = CollectionsKt.emptyList();
    }

    @Override // w79.c
    public final void a(DriveFileItem r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        this.b.n.a(r3.b, IChatFileSelectionStore.Source.DRIVE);
    }

    @Override // w79.c
    public final void b(DriveFileItem r4) {
        Intrinsics.checkNotNullParameter(r4, "file");
        DriveFileSelectDialog r0 = this.b;
        int r1 = DriveFileSelectDialog.t;
        DriveFileSelectDialog.b r2 = r0.ca0(r4, true);
        com.larus.platform.api.u r3 = r2.a;
        IChatFileSelectionStore.b r5 = r2.b;
        if ((r5 instanceof IChatFileSelectionStore.b.b) == true) goto L9;
        if ((r5 instanceof IChatFileSelectionStore.b.a) == false) goto L30;
        r5 = this.b.n.c(r3, IChatFileSelectionStore.Source.DRIVE);
        goto L9
    L30:
        throw new NoWhenBranchMatchedException();
    L9:
        if ((r5 instanceof IChatFileSelectionStore.b.b) == false) goto L15;
        w79.b r6 = this.b.r;
        if (r6 == null) goto L13;
        r6.deselectItem(CollectionsKt.listOf(r4));
    L13:
        this.b.ba0(((IChatFileSelectionStore.b.b) r5).a, r3.f);
        return;
    L15:
        DriveFileSelectDialog r7 = this.b;
        LarusDialogDriveFileSelectBinding r8 = r7.f;
        if (r8 == null) goto L31;
        ConstraintLayout r9 = r8.a;
        if (r9 == null) goto L34;
        Dialog r10 = r7.getDialog();
        if (r10 == null) goto L32;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L35;
        new WindowInsetsControllerCompat(r11, r9).hide(WindowInsetsCompat.Type.ime());
        View r12 = r9.findFocus();
        if (r12 == null) goto L33;
        r12.clearFocus();
        return;
    L33:
        return;
    L35:
        return;
    L32:
        return;
    L34:
        return;
    }

    @Override // w79.c
    public final boolean c(DriveFileItem r13) {
        Intrinsics.checkNotNullParameter(r13, "file");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((DriveFileItem) r1).b, r13.b) == false) goto L4;
    L10:
        if (r1 == null) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        return false;
    L15:
        DriveFileSelectDialog r3 = this.b;
        int r4 = DriveFileSelectDialog.t;
        if (r3.W90(r13, true) == true) goto L18;
        return true;
    L18:
        DriveFileSelectDialog r5 = this.b;
        r5.getClass();
        if (DriveFileSelectDialog.X90(r13) == false) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L30;
        DriveFileSelectDialog r7 = this.b;
        ConcurrentHashMap<String, Boolean> r8 = r7.p;
        String r9 = r13.b;
        Boolean r10 = Boolean.TRUE;
        if (r8.putIfAbsent(r9, r10) == null) goto L28;
        r7.p.put(r13.b, r10);
    L29:
        return true;
    L28:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), Dispatchers.getIO(), null, new DriveFileSelectDialog$selectAfterResolvingSize$1(r7, r13, null), 2, null);
        goto L29
    L30:
        DriveFileSelectDialog.b r14 = this.b.ca0(r13, true);
        IChatFileSelectionStore.b.b r11 = r14.b;
        if ((r11 instanceof IChatFileSelectionStore.b.b) == false) goto L34;
        this.b.ba0(r11.a, r14.a.f);
        return true;
    L34:
        return false;
    L21:
        if (r5.V90(r13) > 0) goto L23;
        r6 = true;
        goto L24
    L12:
        r2 = false;
        goto L13
    L8:
        r1 = null;
        goto L10
    }

    @Override // w79.c
    public final void d(List<DriveFileItem> r9) {
        Intrinsics.checkNotNullParameter(r9, "fileList");
        DriveFileSelectDialog r0 = this.b;
        int r1 = DriveFileSelectDialog.t;
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L5;
        CoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
    L6:
        if (r3 != null) goto L8;
    L9:
        Function1<? super List<DriveFileItem>, Unit> r4 = this.b.s;
        if (r4 == null) goto L12;
        r4.invoke(r9);
        Unit r5 = Unit.INSTANCE;
    L12:
        IDriveSdkService r6 = (IDriveSdkService) ServiceManager.get().getService(IDriveSdkService.class);
        Iterator<T> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L26;
        DriveFileItem r7 = (DriveFileItem) r10.next();
        if (r6 == null) goto L14;
        r6.z(r7);
        goto L14
    L26:
        this.b.dismiss();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L33;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L33:
        return;
    L8:
        if (BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1(r9, this.b, null), 2, null) != null) goto L12;
    L5:
        r3 = null;
        goto L6
    }

    @Override // w79.c
    public final w79.a e(DriveFileItem r14) {
        Intrinsics.checkNotNullParameter(r14, "file");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((DriveFileItem) r1).b, r14.b) == false) goto L4;
    L10:
        if (r1 == null) goto L12;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
        DriveFileSelectDialog r3 = this.b;
        int r5 = DriveFileSelectDialog.t;
        if (r3.W90(r14, false) == false) goto L20;
        DriveFileSelectDialog r4 = this.b;
        r4.getClass();
        if (DriveFileSelectDialog.X90(r14) == false) goto L24;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L32;
        DriveFileSelectDialog r7 = this.b;
        if (r7.p.putIfAbsent(r14.b, Boolean.FALSE) != null) goto L32;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), Dispatchers.getIO(), null, new DriveFileSelectDialog$warmUpDriveFileSize$1(r7, r14, null), 2, null);
    L32:
        IChatFileSelectionStore.b r15 = this.b.ca0(r14, false).b;
        if ((r15 instanceof IChatFileSelectionStore.b.a) == false) goto L36;
        return new w79.a(false, false, 7);
    L36:
        if ((r15 instanceof IChatFileSelectionStore.b.b) == false) goto L40;
        return new w79.a(true, false, 2);
    L40:
        throw new NoWhenBranchMatchedException();
    L24:
        if (r4.V90(r14) > 0) goto L26;
        r6 = true;
        goto L27
    L20:
        return new w79.a(true, false, 2);
    L16:
        return new w79.a(false, false, 7);
    L12:
        r2 = false;
        goto L14
    L8:
        r1 = null;
        goto L10
    }

    @Override // w79.c
    public final void onChanged(List<DriveFileItem> r11) {
        Intrinsics.checkNotNullParameter(r11, "fileList");
        this.a = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r1 = r11.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(((DriveFileItem) r1.next()).b);
        goto L4
    L6:
        Set r7 = CollectionsKt.toSet(r0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getIO(), null, new DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1(r11, this.b, this, r7, null), 2, null);
    }
}
