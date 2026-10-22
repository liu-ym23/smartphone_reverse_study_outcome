package com.larus.bmhome.view.actionbar.edit;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory;
import com.larus.platform.model.KmpInstructionCoreOptConfig;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements b {
    public final boolean a;
    public final KmpInstructionEditorViewFactory b;
    public final h c;
    public b d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Pair<Boolean, Boolean> F7() {
        return this.d.F7();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void T1() {
        this.d.T1();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final boolean a() {
        return this.d.a();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> b() {
        return this.d.b();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> c() {
        return this.d.c();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Long d() {
        return this.d.d();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> e() {
        return this.d.e();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final LiveData<Map<String, Object>> g() {
        return this.d.g();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Integer j() {
        return this.d.j();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void k() {
        this.d.k();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final boolean l() {
        return this.d.l();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void m() {
        this.d.m();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void onViewShow() {
        this.d.onViewShow();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void requestFocus() {
        this.d.requestFocus();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void h(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.d.h(r2);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void i(int r2) {
        this.d.i(r2);
    }

    public i(r r2, d r3, Fragment r4, AttachReceiver r5) {
        if (r5 == null) goto L5;
        boolean r0 = true;
    L6:
        this.a = r0;
        if (r5 == null) goto L9;
        KmpInstructionEditorViewFactory r1 = new KmpInstructionEditorViewFactory(r5, r2, r3);
    L10:
        this.b = r1;
        h r6 = new h(r2, r3, r4);
        this.c = r6;
        this.d = r6;
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void f(r r14, LinearLayout r15, c r16, ActivityResultLauncher<String> r17, ActivityResultLauncher<Intent> r18, n r19, d r20, List<Integer> r21, boolean r22, Function1<? super up8.b, Unit> r23) {
        Intrinsics.checkNotNullParameter(r14, "instructionConf");
        Intrinsics.checkNotNullParameter(r21, "ignoreInstructionTypes");
        Integer r1 = r14.a;
        boolean r3 = ((KmpInstructionCoreOptConfig) h38.b.a.getValue()).getEnable();
        boolean r4 = h38.b.a(r1);
        int r5 = 1;
        if (r3 == false) goto L8;
        if (r4 == false) goto L8;
        if (this.a == false) goto L8;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L14;
        b r8 = this.b;
        if (r8 != null) goto L16;
        FLogger.a.e("InstructionEditorViewFactoryDelegate", "[switchActiveFactory] kmpFactory is null, fallback to originFactory");
        r8 = this.c;
    L16:
        if (Intrinsics.areEqual(r8, this.d) == true) goto L21;
        FLogger.a.i("InstructionEditorViewFactoryDelegate", "[switchActiveFactory] type=" + r1 + ", kmpEnabled=" + r3 + ", typeEnabled=" + r4 + ", isKmpFactoryFunctional=" + this.a + ", from=" + Reflection.getOrCreateKotlinClass(this.d.getClass()).getSimpleName() + " to=" + Reflection.getOrCreateKotlinClass(r8.getClass()).getSimpleName());
        if (Intrinsics.areEqual(this.d, this.b) == false) goto L20;
        this.d.m();
    L20:
        this.d = r8;
    L21:
        if (r4 == true) goto L24;
        String r9 = "type_disabled";
    L27:
        if (r3 == true) goto L29;
    L31:
        r5 = 0;
    L32:
        com.larus.platform.service.o r6 = com.larus.platform.service.o.a;
        JSONObject r10 = new JSONObject();
        r10.putOpt("is_success", Integer.valueOf(r5));
        r10.putOpt("instruction_type", r1);
        r10.putOpt("type_enabled", Boolean.valueOf(r4));
        r10.putOpt("is_kmp_factory_functional", Boolean.valueOf(this.a));
        r10.putOpt("active_factory", Reflection.getOrCreateKotlinClass(this.d.getClass()).getSimpleName());
        r10.putOpt("reason", r9);
        Unit r2 = Unit.INSTANCE;
        r6.reportEvent("kmp_instruction_core_apply_status", r10);
        FLogger.a.i("InstructionEditorViewFactoryDelegate", "[buildViewToContainer] type=" + r14.a + ", activeFactory=" + Reflection.getOrCreateKotlinClass(this.d.getClass()).getSimpleName());
        this.d.f(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        return;
    L29:
        if (Intrinsics.areEqual(this.d, this.b) == false) goto L31;
    L24:
        if (this.a == true) goto L26;
        r9 = "attach_receiver_null";
        goto L27
    L26:
        r9 = "unknown";
        goto L27
    L14:
        r8 = this.c;
    L8:
        r7 = false;
        goto L10
    }
}
