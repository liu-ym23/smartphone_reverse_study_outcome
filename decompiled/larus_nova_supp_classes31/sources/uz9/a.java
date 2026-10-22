package uz9;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.view.actionbar.edit.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.n;
import com.larus.platform.service.z2;
import com.larus.uaigc.instruction.MultiAttachmentSelectorWidget;
import com.larus.uaigc.instruction.y;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ry9.d;
import ry9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements b {
    public final ArrayList<b> a;
    public b b;
    public y c;
    public boolean d;

    public final void k() {
    }

    public final LiveData<Map<String, Object>> g() {
        return new MutableLiveData();
    }

    public final d n() {
        y r0 = this.c;
        if (r0 == null) goto L10;
        MultiAttachmentSelectorWidget r1 = r0.m;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r1 = null;
    L7:
        d r2 = r1.getCreationReferenceAttachmentSnapshot();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return new d(0);
    }

    public final boolean p() {
        if (this.a.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public a() {
        this.a = new ArrayList();
    }

    public final Pair<Boolean, Boolean> F7() {
        if (p() == false) goto L29;
        y r0 = this.c;
        boolean r1 = true;
        if (r0 == null) goto L14;
        Integer r2 = r0.h();
        if (r2 == null) goto L10;
        r2.intValue();
    L10:
        Integer r3 = r0.h();
        if (r3 == null) goto L14;
        r3.intValue();
    L14:
        b r4 = this.b;
        if (r4 == null) goto L18;
        Pair r5 = r4.F7();
        if (r5 == null) goto L18;
    L20:
        if (((Boolean) r5.getFirst()).booleanValue() == false) goto L22;
        boolean r6 = true;
    L23:
        Boolean r7 = Boolean.valueOf(r6);
        if (((Boolean) r5.getSecond()).booleanValue() == true) goto L28;
        r1 = false;
    L28:
        return new Pair(r7, Boolean.valueOf(r1));
    L22:
        r6 = false;
    L18:
        Boolean r8 = Boolean.FALSE;
        r5 = new Pair(r8, r8);
        goto L20
    L29:
        b r9 = (b) CollectionsKt.firstOrNull(this.a);
        if (r9 == null) goto L33;
        Pair<Boolean, Boolean> r10 = r9.F7();
        if (r10 == null) goto L33;
        return r10;
    L33:
        Boolean r11 = Boolean.FALSE;
        return new Pair(r11, r11);
    }

    public final void T1() {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 == null) goto L11;
        r0.T1();
        return;
    L11:
        return;
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 == null) goto L13;
        r1.T1();
        return;
    }

    public final boolean a() {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 != null) goto L12;
        return true;
    L12:
        return r0.a();
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 != null) goto L10;
        return true;
    L10:
        return r1.a();
    }

    public final List<u> b() {
        Integer r1 = null;
        if (p() == false) goto L24;
        ArrayList r0 = new ArrayList();
        y r2 = this.c;
        if (r2 == null) goto L7;
        String r7 = r2.g();
    L9:
        if (o0.d(r7) == false) goto L18;
        y r3 = this.c;
        if (r3 == null) goto L13;
        Integer r4 = r3.h();
    L14:
        y r5 = this.c;
        if (r5 == null) goto L17;
        r1 = Integer.valueOf(r5.getType());
    L17:
        r0.add(new u(r4, r1, null, r7, null, null, null, 244));
        goto L18
    L13:
        r4 = null;
    L18:
        b r6 = this.b;
        if (r6 == null) goto L23;
        List r8 = r6.b();
        if (r8 == null) goto L23;
        r0.addAll(r8);
    L23:
        return r0;
    L7:
        r7 = null;
        goto L9
    L24:
        b r9 = (b) CollectionsKt.firstOrNull(this.a);
        if (r9 != null) goto L27;
        return null;
    L27:
        return r9.b();
    }

    public final List<u> c() {
        if (p() == false) goto L15;
        ArrayList r0 = new ArrayList();
        y r1 = this.c;
        if (r1 != null) goto L7;
    L9:
        b r2 = this.b;
        if (r2 == null) goto L14;
        List r3 = r2.c();
        if (r3 == null) goto L14;
        r0.addAll(r3);
    L14:
        return r0;
    L7:
        if (o0.d(r1.g()) == false) goto L9;
        r0.add(new u(r1.h(), Integer.valueOf(r1.getType()), null, r1.g(), null, null, null, 244));
        goto L9
    L15:
        b r4 = (b) CollectionsKt.firstOrNull(this.a);
        if (r4 == null) goto L20;
        List<u> r5 = r4.c();
        if (r5 == null) goto L20;
        return r5;
    L20:
        return new ArrayList();
    }

    public final Long d() {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 != null) goto L12;
        return null;
    L12:
        return r0.d();
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.d();
    }

    public final List<u> e() {
        if (p() == false) goto L34;
        ArrayList r0 = new ArrayList();
        y r1 = this.c;
        if (r1 == null) goto L28;
        z2 r2 = z2.a;
        boolean r4 = false;
        if (r2.L() == false) goto L14;
        Integer r3 = r1.h();
        if (r3 == null) goto L14;
        if (r3.intValue() != 2) goto L14;
        boolean r5 = true;
    L16:
        if (r2.T() == false) goto L24;
        Integer r6 = r1.h();
        if (r6 == null) goto L24;
        if (r6.intValue() != 1) goto L24;
        r4 = true;
    L24:
        if (o0.d(r1.g()) == false) goto L28;
        if (r5 == true) goto L27;
        if (r4 == false) goto L28;
    L27:
        r0.add(new u(r1.h(), Integer.valueOf(r1.getType()), null, r1.g(), null, null, null, 244));
    L14:
        r5 = false;
    L28:
        b r7 = this.b;
        if (r7 == null) goto L33;
        List r8 = r7.e();
        if (r8 == null) goto L33;
        r0.addAll(r8);
    L33:
        return r0;
    L34:
        b r9 = (b) CollectionsKt.firstOrNull(this.a);
        if (r9 == null) goto L39;
        List<u> r10 = r9.e();
        if (r10 == null) goto L39;
        return r10;
    L39:
        return new ArrayList();
    }

    public final Integer j() {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 != null) goto L12;
        return null;
    L12:
        return r0.j();
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.j();
    }

    public final boolean l() {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 != null) goto L12;
        return false;
    L12:
        return r0.l();
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.l();
    }

    public final void m() {
        if (p() == false) goto L7;
        this.c = null;
        b r0 = this.b;
        if (r0 == null) goto L11;
        r0.m();
        return;
    L11:
        return;
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 == null) goto L13;
        r1.m();
        return;
    }

    public final LiveData<Map<String, k>> o() {
        MultiAttachmentSelectorWidget r1 = null;
        if (p() == false) goto L13;
        y r0 = this.c;
        if (r0 == null) goto L25;
        MultiAttachmentSelectorWidget r2 = r0.m;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        LiveData<Map<String, k>> r3 = r1.getAllAttachmentLiveDataStatus();
        if (r3 == null) goto L25;
        return r3;
    L9:
        r1 = r2;
    L25:
        return new MediatorLiveData(MapsKt.emptyMap());
    L13:
        b r4 = (b) CollectionsKt.firstOrNull(this.a);
        if (r4 == null) goto L16;
        MultiAttachmentSelectorWidget r5 = r4.g();
    L18:
        if ((r5 instanceof LiveData) == false) goto L20;
        r1 = r5;
    L20:
        if (r1 != null) goto L23;
        return new MediatorLiveData(MapsKt.emptyMap());
    L23:
        return r1;
    L16:
        r5 = null;
        goto L18
    }

    public final void onViewShow() {
        if (p() == false) goto L13;
        y r0 = this.c;
        if (r0 == null) goto L10;
        MultiAttachmentSelectorWidget r1 = r0.m;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r1 = null;
    L9:
        r1.getClass();
    L10:
        b r2 = this.b;
        if (r2 == null) goto L17;
        r2.onViewShow();
        return;
    L17:
        return;
    L13:
        b r3 = (b) CollectionsKt.firstOrNull(this.a);
        if (r3 == null) goto L19;
        r3.onViewShow();
        return;
    }

    public final void requestFocus() {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 == null) goto L11;
        r0.requestFocus();
        return;
    L11:
        return;
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 == null) goto L13;
        r1.requestFocus();
        return;
    }

    public final void h(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 == null) goto L11;
        r0.h(r2);
        return;
    L11:
        return;
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 == null) goto L13;
        r1.h(r2);
        return;
    }

    public final void i(int r2) {
        if (p() == false) goto L7;
        b r0 = this.b;
        if (r0 == null) goto L11;
        r0.i(r2);
        return;
    L11:
        return;
    L7:
        b r1 = (b) CollectionsKt.firstOrNull(this.a);
        if (r1 == null) goto L13;
        r1.i(r2);
        return;
    }

    public final void q(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= this.a.size()) goto L8;
        this.b = (b) ListProtector.get(this.a, r2);
        return;
    }

    public final void f(r r15, LinearLayout r16, c r17, ActivityResultLauncher<String> r18, ActivityResultLauncher<Intent> r19, n r20, com.larus.bmhome.view.actionbar.edit.d r21, List<Integer> r22, boolean r23, Function1<? super up8.b, Unit> r24) {
        Intrinsics.checkNotNullParameter(r15, "instructionConf");
        Intrinsics.checkNotNullParameter(r22, "ignoreInstructionTypes");
        if (p() == false) goto L7;
        b r2 = this.b;
        if (r2 == null) goto L11;
        b.a.a(r2, r15, r16, r17, r18, r19, r20, r21, r22, r23, null, 512);
        return;
    L11:
        return;
    L7:
        b r3 = (b) CollectionsKt.firstOrNull(this.a);
        if (r3 == null) goto L13;
        b.a.a(r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, null, 512);
        return;
    }
}
