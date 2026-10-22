package com.larus.camera.impl.ui.arch;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.component.video.CaptureRecorderComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx8.d;
import tx8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ?\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0016¢\u0006\u0002\u0010\u001cJ?\u0010\u001d\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0016¢\u0006\u0002\u0010\u001cJ?\u0010\u001e\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\"H\u0016J9\u0010#\u001a\u00020\u0012\"\b\b\u0000\u0010$*\u00020\u0016\"\b\b\u0001\u0010\u0013*\u00020\u00142\u0006\u0010%\u001a\u0002H$2\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010&J9\u0010'\u001a\u00020\u0012\"\b\b\u0000\u0010$*\u00020\u0016\"\b\b\u0001\u0010\u0013*\u00020\u00142\u0006\u0010%\u001a\u0002H$2\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010&J \u0010(\u001a\u00020)\"\b\b\u0000\u0010$*\u00020\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0*H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006-"}, d2 = {"Lcom/larus/camera/impl/ui/arch/CameraContainer;", "Landroid/widget/FrameLayout;", "Lcom/larus/camera/impl/ui/arch/Container;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "group", "Lcom/larus/camera/impl/ui/arch/ComponentGroup;", "getGroup", "()Lcom/larus/camera/impl/ui/arch/ComponentGroup;", "group$delegate", "Lkotlin/Lazy;", "initComponents", "", "VM", "Landroidx/lifecycle/ViewModel;", "C", "Lcom/larus/camera/impl/ui/arch/Component;", "viewModel", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "components", "", "(Landroidx/lifecycle/ViewModel;Landroidx/lifecycle/LifecycleOwner;Ljava/util/List;)V", "replaceComponents", "replaceComponentsByDiff", "newComponents", "releaseComponents", "asView", "Landroid/view/ViewGroup;", "addComponent", "T", "component", "(Lcom/larus/camera/impl/ui/arch/Component;Landroidx/lifecycle/ViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "addComponentIfNotExists", "removeComponent", "", "Ljava/lang/Class;", "Companion", "LayoutParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraContainer extends FrameLayout implements e {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    public static final class b extends FrameLayout.LayoutParams {
        public b(int r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public CameraContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CameraContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // tx8.e
    public final CameraContainer asView() {
        return this;
    }

    private final com.larus.camera.impl.ui.arch.a getGroup() {
        return (com.larus.camera.impl.ui.arch.a) this.a.getValue();
    }

    public final void c() {
        Iterator<T> r0 = getGroup().c().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).c(this);
        goto L4
    L6:
        getGroup().a();
    }

    public final void d(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "component");
        FLogger.a.i("CameraContainer" + hashCode(), "removeComponent " + getGroup().c());
        Iterator<T> r0 = getGroup().c().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((d) r1).getClass(), r5) == false) goto L4;
    L9:
        d r2 = (d) r1;
        if (r2 == null) goto L16;
        r2.c(this);
        List<? extends d> r6 = CollectionsKt.toMutableList(getGroup().c());
        r6.remove(r2);
        getGroup().b(r6);
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public static final void f(d r3, List<d> r4) {
        if (r4.isEmpty() == true) goto L11;
        Iterator<T> r0 = r4.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        d r1 = (d) r0.next();
        if (Intrinsics.areEqual(r3.getClass(), r1.getClass()) == false) goto L7;
        boolean r2 = false;
    L12:
        if (r2 == false) goto L18;
        ((ArrayList) r4).add(r3);
        return;
    L18:
        return;
    L11:
        r2 = true;
        goto L12
    }

    public CameraContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new tx8.a());
    }

    public final void a(CaptureRecorderComponent r5, CameraCaptureViewModel r6, LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r5, "component");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        FLogger.a.i("CameraContainer" + hashCode(), "addComponentIfNotExists " + getGroup().c());
        Iterator<T> r0 = getGroup().c().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((d) r1).getClass(), CaptureRecorderComponent.class) == false) goto L4;
    L10:
        if (((d) r1) != null) goto L16;
        r5.b(r6, this, r7);
        List<? extends d> r8 = CollectionsKt.toMutableList(getGroup().c());
        r8.add(r5);
        getGroup().b(r8);
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L10
    }

    public final void b(BaseCameraViewModel r2, LifecycleOwner r3, List r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "components");
        getGroup().a();
        Iterator r5 = CollectionsKt.asReversed(getGroup().b(r4)).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((d) r5.next()).b(r2, this, r3);
        goto L4
    }

    public final void e(CameraResultViewModel r11, LifecycleOwner r12, List r13) {
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        Intrinsics.checkNotNullParameter(r12, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r13, "newComponents");
        List<d> r0 = getGroup().c();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        final List r3 = CollectionsKt.toMutableList(r0);
        List<d> r4 = r0;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(((d) r6.next()).getClass());
        goto L4
    L6:
        Set r7 = CollectionsKt.toSet(r5);
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L23;
        final d r8 = (d) r14.next();
        if (r7.contains(r8.getClass()) == true) goto L11;
        f(r8, r2);
        goto L8
    L11:
        Iterator<T> r9 = r4.iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(r8.getClass(), ((d) r10).getClass()) == false) goto L13;
    L18:
        d r15 = (d) r10;
        if (r15 == null) goto L21;
        f(r15, r1);
    L21:
        CollectionsKt.removeAll(r3, new tx8.b(r8));
        goto L8
    L17:
        r10 = null;
        goto L18
    L23:
        getGroup().a();
        Iterator r16 = CollectionsKt.asReversed(getGroup().b(CollectionsKt.plus(r1, r2))).iterator();
    L25:
        if (r16.hasNext() == false) goto L32;
        d r17 = (d) r16.next();
        if (r1.contains(r17) == true) goto L28;
        if (r2.contains(r17) == false) goto L25;
        r17.b(r11, this, r12);
        goto L25
    L28:
        r17.a(this);
        goto L25
    L32:
        FLogger.a.i("CameraContainer", "[replaceComponentsByDiff] componentsToKeep:" + r1 + ", componentsToAdd:" + r2 + ", componentsToRemove:" + r3);
        postDelayed(new tx8.c(r3, this), 100);
    }

    public /* synthetic */ CameraContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
