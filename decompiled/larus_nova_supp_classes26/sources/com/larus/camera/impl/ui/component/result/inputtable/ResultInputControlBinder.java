package com.larus.camera.impl.ui.component.result.inputtable;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.component.result.inputtable.strategy.d;
import com.larus.camera.impl.ui.component.result.inputtable.strategy.n;
import com.larus.camera.impl.ui.component.result.inputtable.strategy.x;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.ui.viewmodel.o;
import com.larus.camera.impl.ui.viewmodel.t;
import com.larus.camera.impl.utils.eventbus.e;
import com.larus.camera.impl.utils.eventbus.g;
import com.larus.camera.impl.utils.eventbus.h;
import com.larus.camera.impl.utils.eventbus.i;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import op8.c;
import op8.f;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultInputControlBinder {
    public final Context a;
    public final CoroutineScope b;
    public final Function0<CameraResultViewModel> c;
    public View d;
    public d e;
    public f.b f;
    public boolean g;
    public final Lazy h;
    public final b i;

    public final class a extends c {
        public final /* synthetic */ ResultInputControlBinder a;

        @Override // op8.c, op8.f
        public final boolean g() {
            CameraResultViewModel r0 = (CameraResultViewModel) this.a.c.invoke();
            if (r0 != null) goto L6;
            return false;
        L6:
            if (r0.supportsEduIntentOnResultPage() == true) goto L8;
        L10:
            Lazy r1 = o.a;
            return o.a(r0.isSupportMultiImages(), r0.getCameraData());
        L8:
            if (((px8.b) r0.getEduResultTabState().getValue()).b == EduResultMode.PHOTO) goto L10;
            return false;
        }

        @Override // op8.c, op8.f
        public final Map<String, String> getEventInfo() {
            CameraResultViewModel r0 = (CameraResultViewModel) this.a.c.invoke();
            if (r0 == null) goto L5;
            ICameraEventExt r1 = r0.getCameraData().getEventExt();
            if (r1 == null) goto L9;
            Long r2 = Long.valueOf(r1.chatKey());
        L10:
            LinkedHashMap r3 = new LinkedHashMap();
            if (r2 == null) goto L13;
            String r4 = (String) r3.put("camera_mob_key_chat_key", String.valueOf(r2.longValue()));
        L13:
            r3.put("camera_mob_key_current_page", "camera_confirm");
            return r3;
        L9:
            r2 = null;
            goto L10
        L5:
            return MapsKt.emptyMap();
        }

        public a(ResultInputControlBinder r1) {
            this.a = r1;
        }

        @Override // op8.c, op8.f
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "content");
            FLogger.a.i("ResultInputtableControlComponent", "[onInputTextChanged] content:" + r4);
        }

        @Override // op8.f
        public final boolean c(String r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            FLogger.a.i("ResultInputtableControlComponent", "[onSend] content:" + r5);
            ResultInputControlBinder.a(this.a, new Pair(r5, 1));
            return true;
        }

        @Override // op8.c, op8.f
        public final void d(int r8) {
            t r0 = t.a;
            if (t.e() < r8) goto L6;
            s.j(s.a, AppHost.a.getApplication(), this.a.a.getString(2131900556), null, false, 28);
            return;
        L6:
            CameraResultViewModel r9 = (CameraResultViewModel) this.a.c.invoke();
            if (r9 != null) goto L10;
            return;
        L10:
            if (((Boolean) r9.getEnableUndo().getValue()).booleanValue() == true) goto L12;
        L17:
            r9.onMultiCameraCapture();
            return;
        L12:
            if (CameraResultViewModel.shouldUseOriginalImageDeferredEdit$default(r9, null, 1, null) == false) goto L14;
            r9.setImageHasBeenMarked(true);
            goto L17
        L14:
            Bitmap r1 = r9.getMarkedImageBitmap();
            if (r1 == null) goto L17;
            r9.updateCurrentBitmap(r1, "onMultiCameraCapture");
            r9.setImageHasBeenMarked(true);
            goto L17
        }

        @Override // op8.c, op8.f
        public final void e(f.a r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            FLogger.a.i("ResultInputtableControlComponent", "[onAsrStateChanged] state:" + r4);
            if (Intrinsics.areEqual(r4, f.a.C0125a.a) == false) goto L6;
            MutableSharedFlow<g> r5 = com.larus.camera.impl.utils.eventbus.c.a;
            com.larus.camera.impl.utils.eventbus.c.a(this.a.b, new i(op8.i.a.C0127a.a));
            this.a.d().a();
            return;
        L6:
            if (Intrinsics.areEqual(r4, f.a.b.a) == false) goto L9;
            MutableSharedFlow<g> r6 = com.larus.camera.impl.utils.eventbus.c.a;
            com.larus.camera.impl.utils.eventbus.c.a(this.a.b, new i(op8.i.a.C0127a.a));
            this.a.d().a();
            return;
        L9:
            if (Intrinsics.areEqual(r4, f.a.c.a) == false) goto L12;
            MutableSharedFlow<g> r7 = com.larus.camera.impl.utils.eventbus.c.a;
            com.larus.camera.impl.utils.eventbus.c.a(this.a.b, new h(op8.i.a.C0127a.a));
            this.a.d().e();
            return;
        L12:
            if ((r4 instanceof f.a.e) == false) goto L15;
            ResultInputControlBinder.a(this.a, new Pair(((f.a.e) r4).a, 2));
            this.a.d().a();
            return;
        L15:
            if ((r4 instanceof f.a.d) == false) goto L18;
            return;
        L18:
            throw new NoWhenBranchMatchedException();
        }

        @Override // op8.c, op8.f
        public final void f(f.b r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            FLogger.a.i("ResultInputtableControlComponent", "[onInputStateChanged] state:" + r5);
            if (Intrinsics.areEqual(r5, f.b.a.a) == false) goto L5;
        L12:
            f.b r0 = this.a.f;
            boolean r1 = false;
            if (r0 == null) goto L19;
            boolean r2 = !Intrinsics.areEqual(r0, f.b.C0126b.a);
            boolean r3 = !Intrinsics.areEqual(this.a.f, r5);
            if (r2 == false) goto L19;
            if (r3 == false) goto L19;
            r1 = true;
        L19:
            if (r1 == false) goto L23;
            CameraResultViewModel r4 = (CameraResultViewModel) this.a.c.invoke();
            if (r4 == null) goto L23;
            r4.clickInputFunctionSwitchOnResultPage();
        L23:
            this.a.f = r5;
            return;
        L5:
            if (Intrinsics.areEqual(r5, f.b.c.a) == true) goto L12;
            if (Intrinsics.areEqual(r5, f.b.C0126b.a) == false) goto L11;
            return;
        L11:
            throw new NoWhenBranchMatchedException();
        }

        @Override // op8.c, op8.f
        public final void h(boolean r3) {
            MutableSharedFlow<g> r0 = com.larus.camera.impl.utils.eventbus.c.a;
            com.larus.camera.impl.utils.eventbus.c.a(this.a.b, new e(r3));
        }

        @Override // op8.c, op8.f
        public final void b(int r2, long r3) {
            this.a.d().b(r2, r3);
        }
    }

    public static final class b implements vx8.b {
        public final /* synthetic */ ResultInputControlBinder a;

        @Override // vx8.b
        public final CameraResultViewModel a() {
            return (CameraResultViewModel) this.a.c.invoke();
        }

        @Override // vx8.b
        public final op8.i b() {
            return (op8.i) this.a.h.getValue();
        }

        @Override // vx8.b
        public final CoroutineScope scope() {
            return this.a.b;
        }

        @Override // vx8.b
        public final void submit() {
            ResultInputControlBinder.a(this.a, new Pair("", 0));
        }

        public b(ResultInputControlBinder r1) {
            this.a = r1;
        }
    }

    public final vx8.a d() {
        d r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new com.larus.camera.impl.ui.component.result.inputtable.strategy.e(this.i);
    }

    public final void b(Flow<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "showInputFlow");
        d().onViewCreated();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.n(r3), new ResultInputControlBinder$bind$1(this, null)), this.b);
    }

    public static final void a(ResultInputControlBinder r2, Pair r3) {
        CameraResultViewModel r4 = (CameraResultViewModel) r2.c.invoke();
        if (r4 != null) goto L6;
        return;
    L6:
        if (((CharSequence) r3.getFirst()).length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        String r1 = "input";
    L12:
        r4.clickSubmitOnResultPage();
        r4.leaveResultPageOnSubmit(r1);
        r4.prepareFreeInputImagePolicy(r3);
        r4.onComplete(r3, "input_control_".concat(r1));
        return;
    L11:
        r1 = "next";
        goto L12
    L8:
        r0 = false;
        goto L9
    }

    public ResultInputControlBinder(Context r2, CoroutineScope r3, Function0<CameraResultViewModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "viewModelProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.h = LazyKt.lazy(new com.larus.camera.impl.ui.component.result.inputtable.a(this));
        this.i = new b(this);
    }

    public final View c(LayoutInflater r4, ViewGroup r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "outsideClickParent");
        yx8.a r0 = yx8.c.a;
        yx8.a r1 = yx8.c.a;
        if (Intrinsics.areEqual(r1, yx8.a.b.b) == false) goto L6;
        d r2 = new n(this.i);
    L11:
        this.e = r2;
        View r7 = d().f(r4, r5);
        this.d = r7;
        d().c(r6);
        return r7;
    L6:
        if (Intrinsics.areEqual(r1, yx8.a.c.b) == false) goto L9;
        r2 = new x(this.i);
        goto L11
    L9:
        if (Intrinsics.areEqual(r1, yx8.a.d.b) == false) goto L14;
        FLogger.a.e("ResultInputtableControlComponent", "[createView] unexpected CameraInputStyle.None");
        r2 = new com.larus.camera.impl.ui.component.result.inputtable.strategy.e(this.i);
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
