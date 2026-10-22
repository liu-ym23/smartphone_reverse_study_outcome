package com.larus.dora.impl.device.manage.holder;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementDeviceBinding;
import com.larus.dora.impl.device.manage.DeviceMode;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.r0;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.view.DoraTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u000eJ\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u000202H\u0016J\u0014\u00103\u001a\u00020\u000e*\u0002042\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u00069"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/DeviceUIComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementDeviceBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementDeviceBinding;", "rotationAnimator", "Landroid/animation/ObjectAnimator;", "onDeviceSelectorClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnDeviceSelectorClick", "()Lkotlin/jvm/functions/Function1;", "setOnDeviceSelectorClick", "(Lkotlin/jvm/functions/Function1;)V", "onAddDeviceClick", "Lkotlin/Function0;", "getOnAddDeviceClick", "()Lkotlin/jvm/functions/Function0;", "setOnAddDeviceClick", "(Lkotlin/jvm/functions/Function0;)V", "onReconnectClick", "getOnReconnectClick", "setOnReconnectClick", "onCreateAndSetupView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "showConnectingState", "isConnecting", "", "resetConnectingState", "startRotationAnimation", "stopRotationAnimation", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "setMainContentVisibility", "visibility", "", "bindBatteryInfo", "item", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementDeviceItem;", "onDeviceSwitch", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", "setG1Drawable", "Landroid/widget/ImageView;", "resourceName", "", "onStop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceUIComponent extends LifecycleUIComponent {
    public static final /* synthetic */ int i = 0;
    public LarusItemDoraGDeviceManagementDeviceBinding d;
    public ObjectAnimator e;
    public Function1<? super View, Unit> f;
    public Function0<Unit> g;
    public Function0<Unit> h;

    public static final class a {
    }

    static {
    }

    public final LarusItemDoraGDeviceManagementDeviceBinding i() {
        LarusItemDoraGDeviceManagementDeviceBinding r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void l() {
        ObjectAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.e = null;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(i().h, "rotation", new float[]{i().h.getRotation(), i().h.getRotation() + 360.0f});
        r1.setDuration(1000);
        r1.setRepeatCount(-1);
        r1.setInterpolator(new LinearInterpolator());
        r1.start();
        this.e = r1;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStop() {
        super.onStop();
        g49.d.d("DeviceUIComponent", "onStop");
        ObjectAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.e = null;
    }

    public DeviceUIComponent() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        if ((r8 instanceof com.larus.dora.impl.device.manage.c) == false) goto L5;
        final com.larus.dora.impl.device.manage.c r9 = (com.larus.dora.impl.device.manage.c) r8;
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        g49.d.d("DeviceUIComponent", "onBind deviceName=" + r9.b + " isConnected=" + r9.f + " mode=" + r9.d);
        i().o.setVisibility(0);
        i().g.setVisibility(0);
        i().b.setVisibility(0);
        i().i.setVisibility(0);
        i().o.setText(r9.b);
        if (r9.f == false) goto L19;
        g49.d.d("DeviceUIComponent", "onBind: device " + r9.b + " is connected, show connected state");
        i().a.post(new c(r9));
        DeviceMode r0 = r9.d;
        if (r0 != DeviceMode.NORMAL) goto L13;
        i().p.setVisibility(0);
        AppCompatTextView r1 = i().p;
        int r2 = com.larus.utils.j0.a;
        r1.setText(com.larus.utils.j0.d(2131902454));
        i().p.setTextColor(ve8.d.a(2131103143, i().a.getContext()));
        i().k.setVisibility(8);
    L17:
        i().b.setVisibility(0);
        i().i.clearColorFilter();
        j(i().i, "larus_dora_g_device_management_widget_glass");
        h(r9);
        i().c.setVisibility(8);
        i().j.setVisibility(8);
        return;
    L13:
        i().p.setVisibility(8);
        i().k.setVisibility(0);
        i().r.setText(r0.getModeName());
        i().k.setBackgroundResource(2131240478);
        i().r.setTextColor(ve8.d.a(2131103146, i().a.getContext()));
        if (r0.isHighlight() == false) goto L16;
        i().s.setBackgroundResource(2131240472);
        goto L17
    L16:
        i().s.setBackgroundResource(2131240473);
        goto L17
    L19:
        if (r9.l == false) goto L21;
        g49.d.d("DeviceUIComponent", "onBind: device " + r9.b + " is connecting, show loading state");
        i().p.setVisibility(8);
        i().c.setVisibility(8);
        i().j.setVisibility(0);
        i().k.setVisibility(8);
        i().b.setVisibility(8);
        j(i().i, "larus_dora_g_device_management_widget_glass_unconnected");
        l();
        return;
    L21:
        g49.d.d("DeviceUIComponent", "onBind: device " + r9.b + " is unconnected, show unconnected state");
        AppCompatTextView r10 = i().p;
        int r3 = com.larus.utils.j0.a;
        r10.setText(com.larus.utils.j0.d(2131902644));
        i().p.setVisibility(0);
        i().p.setTextColor(ve8.d.a(2131103143, i().a.getContext()));
        i().k.setVisibility(8);
        i().b.setVisibility(8);
        j(i().i, "larus_dora_g_device_management_widget_glass_unconnected");
        i().c.setVisibility(0);
        i().j.setVisibility(8);
        return;
    L5:
        r9 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void e(com.larus.dora.impl.device.manage.a r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        com.larus.dora.impl.device.manage.c r8 = r7.a;
        if (r8 != null) goto L5;
        return;
    L5:
        g49.d.d("DeviceUIComponent", "onDeviceSwitch: newDevice=" + r8.b + ", connected=" + r8.f + ", mac= " + r8.c);
        i().o.setText(r8.b);
        if (r8.f == false) goto L15;
        j(i().i, "larus_dora_g_device_management_widget_glass");
        i().i.clearColorFilter();
        i().b.setVisibility(0);
        h(r8);
        i().c.setVisibility(8);
        i().j.setVisibility(8);
        DeviceMode r9 = r8.d;
        if (r9 != DeviceMode.NORMAL) goto L10;
        i().p.setVisibility(0);
        AppCompatTextView r10 = i().p;
        int r0 = com.larus.utils.j0.a;
        r10.setText(com.larus.utils.j0.d(2131902454));
        i().p.setTextColor(ve8.d.a(2131103143, i().a.getContext()));
        i().k.setVisibility(8);
        return;
    L10:
        i().p.setVisibility(8);
        i().k.setVisibility(0);
        i().r.setText(r9.getModeName());
        i().k.setBackgroundResource(2131240478);
        i().r.setTextColor(ve8.d.a(2131103146, i().a.getContext()));
        if (r9.isHighlight() == false) goto L13;
        i().s.setBackgroundResource(2131240472);
        return;
    L13:
        i().s.setBackgroundResource(2131240473);
        return;
    L15:
        if (r8.l == false) goto L17;
        g49.d.d("DeviceUIComponent", "onDeviceSwitch: device " + r8.b + " is connecting, show loading state");
        i().p.setVisibility(8);
        i().c.setVisibility(8);
        i().j.setVisibility(0);
        i().k.setVisibility(8);
        i().b.setVisibility(8);
        j(i().i, "larus_dora_g_device_management_widget_glass_unconnected");
        l();
        return;
    L17:
        AppCompatTextView r11 = i().p;
        int r1 = com.larus.utils.j0.a;
        r11.setText(com.larus.utils.j0.d(2131902644));
        i().p.setVisibility(0);
        i().p.setTextColor(ve8.d.a(2131103143, i().a.getContext()));
        i().k.setVisibility(8);
        i().b.setVisibility(8);
        j(i().i, "larus_dora_g_device_management_widget_glass_unconnected");
        i().c.setVisibility(0);
        i().j.setVisibility(8);
    }

    public final void h(com.larus.dora.impl.device.manage.c r14) {
        int r0 = r14.j;
        boolean r1 = r0.a(Integer.valueOf(r0));
        i().q.setText(r0.b(Integer.valueOf(r0)));
        i().m.setMax(100);
        ProgressBar r2 = i().m;
        Integer r4 = Integer.valueOf(r0);
        boolean r6 = false;
        if (r0.a(r4) == false) goto L6;
        if (r4 == null) goto L6;
        int r5 = r4.intValue();
    L7:
        r2.setProgress(r5);
        ProgressBar r3 = i().m;
        if (r1 == false) goto L10;
        int r7 = 0;
    L11:
        r3.setVisibility(r7);
        if (r0 > 10) goto L14;
        int r8 = com.larus.utils.j0.a;
        Drawable r9 = com.larus.utils.j0.c(2131240481);
    L21:
        i().m.setProgressDrawable(r9);
        boolean r10 = v19.h.a;
        if (v19.h.b(i().a.getContext()) == false) goto L24;
        int r11 = 2131240469;
    L26:
        if (r14.h == false) goto L32;
        ImageView r12 = i().f;
        if (r1 == false) goto L30;
        int r13 = 0;
    L31:
        r12.setVisibility(r13);
        i().f.setImageResource(r11);
    L33:
        int r15 = r14.k;
        boolean r16 = r0.a(Integer.valueOf(r15));
        if (r14.i == false) goto L37;
        if (r16 == false) goto L37;
        i().e.setVisibility(0);
        i().e.setImageResource(r11);
    L38:
        if (r16 == false) goto L54;
        i().d.setVisibility(0);
        i().n.setText(r0.b(Integer.valueOf(r15)));
        i().l.setMax(100);
        ProgressBar r17 = i().l;
        Integer r18 = Integer.valueOf(r15);
        if (r0.a(r18) == false) goto L43;
        if (r18 == null) goto L43;
        int r20 = r18.intValue();
    L44:
        r17.setProgress(r20);
        i().l.setVisibility(0);
        if (r15 > 10) goto L47;
        int r110 = com.larus.utils.j0.a;
        Drawable r111 = com.larus.utils.j0.c(2131240481);
    L53:
        i().l.setProgressDrawable(r111);
        return;
    L47:
        if (11 > r15) goto L50;
        if (r15 >= 21) goto L50;
        r6 = true;
    L50:
        if (r6 == false) goto L52;
        int r112 = com.larus.utils.j0.a;
        r111 = com.larus.utils.j0.c(2131240482);
        goto L53
    L52:
        int r113 = com.larus.utils.j0.a;
        r111 = com.larus.utils.j0.c(2131240480);
    L43:
        r20 = 0;
        goto L44
    L54:
        i().d.setVisibility(8);
        i().e.setVisibility(8);
        return;
    L37:
        i().e.setVisibility(8);
        goto L38
    L30:
        r13 = 8;
        goto L31
    L32:
        i().f.setVisibility(8);
        goto L33
    L24:
        r11 = 2131240470;
        goto L26
    L14:
        if (11 > r0) goto L17;
        if (r0 >= 21) goto L17;
        boolean r21 = true;
    L18:
        if (r21 == false) goto L20;
        int r22 = com.larus.utils.j0.a;
        r9 = com.larus.utils.j0.c(2131240482);
        goto L21
    L20:
        int r23 = com.larus.utils.j0.a;
        r9 = com.larus.utils.j0.c(2131240480);
    L17:
        r21 = false;
        goto L18
    L10:
        r7 = 4;
    L6:
        r5 = 0;
        goto L7
    }

    public final void k(boolean r3) {
        if (r3 == false) goto L5;
        i().p.setVisibility(8);
        i().c.setVisibility(8);
        i().j.setVisibility(0);
        l();
        return;
    L5:
        ObjectAnimator r4 = this.e;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        this.e = null;
        i().j.setVisibility(8);
        i().p.setVisibility(0);
        i().c.setVisibility(0);
    }

    public static void j(ImageView r6, String r7) {
        r6.setImageDrawable(com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r6.getContext(), DoraResourceDeviceType.G1, r7, DoraDrawableDensity.XXHDPI, 8));
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r210, ViewGroup r30) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        Intrinsics.checkNotNullParameter(r30, "container");
        g49.d.d("DeviceUIComponent", "onCreateAndSetupView");
        ConstraintLayout r1 = r210.inflate(2131562549, r30, false);
        int r2 = 2131363976;
        Barrier r3 = ViewBindings.findChildViewById(r1, 2131363976);
        if (r3 == null) goto L53;
        r2 = 2131366821;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r1, 2131366821);
        if (r7 == null) goto L53;
        r2 = 2131366891;
        ConstraintLayout r15 = ViewBindings.findChildViewById(r1, 2131366891);
        if (r15 == null) goto L53;
        r2 = 2131373933;
        Group r14 = ViewBindings.findChildViewById(r1, 2131373933);
        if (r14 == null) goto L53;
        r2 = 2131376078;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r1, 2131376078);
        if (r10 == null) goto L53;
        r2 = 2131376079;
        if (((ImageView) ViewBindings.findChildViewById(r1, 2131376079)) == null) goto L53;
        r2 = 2131376093;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r1, 2131376093);
        if (r11 == null) goto L53;
        r2 = 2131376098;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r1, 2131376098);
        if (r12 == null) goto L53;
        r2 = 2131376137;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r1, 2131376137);
        if (r13 == null) goto L53;
        r2 = 2131376176;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r1, 2131376176);
        if (r16 == null) goto L53;
        r2 = 2131376274;
        if (((ImageView) ViewBindings.findChildViewById(r1, 2131376274)) == null) goto L53;
        r2 = 2131378643;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131378643);
        if (r17 == null) goto L53;
        r2 = 2131378662;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131378662);
        if (r18 == null) goto L53;
        r2 = 2131378663;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131378663);
        if (r9 == null) goto L53;
        r2 = 2131382050;
        ProgressBar r110 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131382050);
        if (r110 == null) goto L53;
        r2 = 2131382054;
        ProgressBar r20 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131382054);
        if (r20 == null) goto L53;
        r2 = 2131390287;
        DoraTextView r21 = (DoraTextView) ViewBindings.findChildViewById(r1, 2131390287);
        if (r21 == null) goto L53;
        r2 = 2131390386;
        if (((DoraTextView) ViewBindings.findChildViewById(r1, 2131390386)) == null) goto L53;
        r2 = 2131390494;
        DoraTextView r22 = (DoraTextView) ViewBindings.findChildViewById(r1, 2131390494);
        if (r22 == null) goto L53;
        r2 = 2131390495;
        DoraTextView r23 = (DoraTextView) ViewBindings.findChildViewById(r1, 2131390495);
        if (r23 == null) goto L53;
        r2 = 2131390702;
        DoraTextView r24 = (DoraTextView) ViewBindings.findChildViewById(r1, 2131390702);
        if (r24 == null) goto L53;
        r2 = 2131390962;
        DoraTextView r25 = (DoraTextView) ViewBindings.findChildViewById(r1, 2131390962);
        if (r25 == null) goto L53;
        r2 = 2131391253;
        if (((DoraTextView) ViewBindings.findChildViewById(r1, 2131391253)) == null) goto L53;
        r2 = 2131392172;
        View r26 = ViewBindings.findChildViewById(r1, 2131392172);
        if (r26 == null) goto L53;
        ConstraintLayout r4 = r1;
        final LarusItemDoraGDeviceManagementDeviceBinding r5 = new LarusItemDoraGDeviceManagementDeviceBinding(r4, r3, r7, r15, r14, r10, r11, r12, r13, r16, r17, r18, r9, r110, r20, r21, r22, r23, r24, r25, r26);
        this.d = r5;
        r3.setReferencedIds(new int[]{2131390495, 2131378662});
        r14.setReferencedIds(new int[]{2131376079, 2131390287, 2131382050});
        r9.setOnClickListener(new com.larus.dora.impl.device.manage.holder.a(this, r5));
        r15.setOnClickListener(new b(this));
        return r4;
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
