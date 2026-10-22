package androidx.core.view.inputmethod;

import ab.b;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.SpecialEffectsController;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.common.reflect.w;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.t0;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.x;
import com.obric.oui.calendar.s;
import dh.e;
import hn.c;
import hn.f;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rh.i;
import ug.d;
import ym.p;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements InputConnectionCompat.OnCommitContentListener, FragmentResultListener, CancellationSignal.OnCancelListener, AccessibilityViewCommand, CanvasCompat.CanvasOperation, ObjectConstructor, go.a, Callback, f, e, lk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f497b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f496a = r10;
        this.f497b = r5;
    }

    @Override // lk.a
    public void a(String r5) {
        ((com.bytedance.pia.core.utils.a) this.f497b).c(r5);
    }

    public void b(int r5, int r10) {
        d r11 = (d) this.f497b;
        Intrinsics.checkNotNullParameter(r11, "this$0");
        ((LinkedHashMap) r11.f).put(Integer.valueOf(r5), Integer.valueOf(r10));
        s r12 = (s) r11.f22357b;
        if (r12 == null) goto L7;
        r12.accept(new zr.a(MapsKt.toMap((LinkedHashMap) r11.f)));
        return;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        int r5 = this.f496a;
        Object r10 = this.f497b;
        switch(r5) {
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return ConstructorConstructor.a((Class) r10);
    L7:
        return ConstructorConstructor.e((Constructor) r10);
    }

    @Override // go.a
    public void f(w r5) {
        boolean r10 = LynxTemplateRender.f10015m0;
        int r11 = ((LynxResourceResponse$ResponseState) r5.f9377c).ordinal();
        d r12 = (d) this.f497b;
        if (r11 != 0) goto L5;
        r12.a(((Throwable) r5.d).getMessage());
        return;
    L5:
        if (r11 != 1) goto L41;
        TemplateBundle r13 = ((jo.a) r5.f9376b).f18401b;
        if (r13 != null) goto L10;
    L34:
        ((jo.a) r5.f9376b).getClass();
        int r14 = 25;
        boolean r15 = false;
        j.f(new b(r14, r12, r15, ((jo.a) r5.f9376b).f18400a));
        return;
    L10:
        if (r13.d() == false) goto L34;
        if (r13.d() == true) goto L14;
        r12.a("template bundle is invalid.");
        return;
    L14:
        LynxTemplateRender r16 = (LynxTemplateRender) r12.g;
        if (LynxTemplateRender.a(r16) == null) goto L18;
        LynxTemplateRender.a(r16).getClass();
    L18:
        if (LynxTemplateRender.a(r16) == null) goto L20;
        LynxTemplateRender.a(r16).getClass();
    L20:
        r16.Q.j("prepareTemplateEnd");
        x r17 = (x) r12.f;
        if (r17 != null) goto L33;
        TemplateData r18 = (TemplateData) r12.f22357b;
        if (r18 != null) goto L32;
        Map r19 = (Map) r12.e;
        if (r19 == null) goto L28;
        r18 = TemplateData.c(r19);
        goto L32
    L28:
        String r20 = (String) r12.f22358c;
        if (r20 != null) goto L31;
        r20 = "";
    L31:
        r18 = TemplateData.b(r20);
    L32:
        r16.r(r13, r18, (String) r12.d);
        return;
    L33:
        p r21 = p.i("loadBundle", "loadBundleStart");
        r17.f11193c = r13;
        r16.o(r17, r21);
        return;
    }

    @Override // dh.e
    public Uri getUrl() {
        switch(this.f496a) {
            case 13: goto L7;
            default: goto L5;
        };
    L5:
        return (Uri) this.f497b;
    L7:
        return ((i) this.f497b).f21764i;
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object[] r5) {
        t0 r10 = (t0) this.f497b;
        r10.getClass();
        j.f(new a2.b(12, r10, r5));
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        SpecialEffectsController.Operation.a((SpecialEffectsController.Operation) this.f497b);
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat r5, int r10, Bundle r11) {
        return InputConnectionCompat.a((View) this.f497b, r5, r10, r11);
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public void onFragmentResult(String r5, Bundle r10) {
        FragmentKt.a((Function2) this.f497b, r5, r10);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View r5, AccessibilityViewCommand.CommandArguments r10) {
        return BottomSheetDragHandleView.a((BottomSheetDragHandleView) this.f497b, r5, r10);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas r5) {
        int r10 = this.f496a;
        Object r11 = this.f497b;
        switch(r10) {
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        NavigationView.a((NavigationView) r11, r5);
        return;
    L6:
        MaskableFrameLayout.b((MaskableFrameLayout) r11, r5);
    }

    @Override // hn.f
    public void a(boolean r5) {
        com.lynx.animax.player.b r10 = (com.lynx.animax.player.b) this.f497b;
        if (r5 == false) goto L5;
        ((c) r10.f9658c).a(0);
        return;
    L5:
        r10.getClass();
    }
}
