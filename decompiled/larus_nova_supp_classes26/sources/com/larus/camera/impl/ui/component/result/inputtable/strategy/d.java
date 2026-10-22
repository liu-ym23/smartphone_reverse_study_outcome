package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class d implements vx8.a {
    public final vx8.b a;
    public Fragment b;
    public ViewGroup c;

    @Override // vx8.a
    public void a() {
    }

    @Override // vx8.a
    public void b(int r1, long r2) {
    }

    @Override // vx8.a
    public void e() {
    }

    public abstract void k();

    public final CoroutineScope h() {
        return this.a.scope();
    }

    public final void i() {
        final Fragment r0 = this.b;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "it");
        j(new c(r0));
        Unit r1 = Unit.INSTANCE;
        return;
    }

    @Override // vx8.a
    public void onViewCreated() {
        k();
    }

    public d(ResultInputControlBinder.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inputComponentAbility");
        this.a = r2;
    }

    @Override // vx8.a
    public void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
    }

    public final void g(final ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "containerView");
        CameraResultViewModel r0 = this.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        HashMap r1 = new HashMap();
        InputParam r2 = r0.getInputParam();
        if (r2 == null) goto L9;
        String r3 = r2.getBotId();
        if (r3 == null) goto L9;
    L10:
        r1.put("bot_id", r3);
        CameraData r4 = r0.getCameraData();
        String r5 = r4.getAlbumInputSnapshotId();
        if (r5 != null) goto L13;
    L18:
        String r7 = r4.getAlbumInputText();
        if ((!StringsKt.isBlank(r7)) == true) goto L22;
        r7 = null;
    L22:
        if (r7 == null) goto L24;
        String r8 = (String) r1.put("inject_input_initial_text", r7);
    L24:
        List<String> r9 = r4.getAlbumAttachmentUris();
        if ((!r9.isEmpty()) == true) goto L28;
        r9 = null;
    L28:
        if (r9 == null) goto L30;
        r1.put("inject_input_initial_attachment_uris", new JSONArray(r9).toString());
    L30:
        op8.i r10 = this.a.b();
        if (r10 == null) goto L36;
        final Fragment r11 = r10.b(Boolean.FALSE, null, r1);
        if (r11 == null) goto L37;
        j(new a(r6, r11));
        this.c = r6;
        this.b = r11;
        return;
    L37:
        return;
    L36:
        return;
    L13:
        if ((!StringsKt.isBlank(r5)) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        String r12 = (String) r1.put("inject_input_initial_attachment_snapshot_id", r5);
    L9:
        r3 = "";
        goto L10
    }

    public final void j(Function1<? super FragmentTransaction, ? extends FragmentTransaction> r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        CameraResultViewModel r1 = this.a.a();     // Catch: Throwable -> L13
        if (r1 != null) goto L5;
        return;
    L5:
        FragmentActivity r2 = r1.requireFragment().getActivity();     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        FragmentManager r3 = r2.getSupportFragmentManager();     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        ((FragmentTransaction) r4.invoke(r3.beginTransaction())).commitAllowingStateLoss();     // Catch: Throwable -> L13
    L11:
        Object r5 = Result.constructor-impl(r3);     // Catch: Throwable -> L13
    L15:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.e("ResultInputtableControlComponent", "[inTransaction] " + r6);
        return;
    L21:
        return;
    L10:
        r3 = null;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
