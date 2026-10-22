package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.popover.e;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J.\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020'2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0004J<\u00101\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00160\u0018H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00160\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0000@BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00062"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownRatio;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/oui/dropdown/ODropdown;", "options", "", "defaultOption", "", "(Ljava/util/List;I)V", "alignTriggerWidth", "", "getAlignTriggerWidth", "()Z", "setAlignTriggerWidth", "(Z)V", "autoDismissMs", "", "getAutoDismissMs", "()J", "setAutoDismissMs", "(J)V", "dismiss", "Lkotlin/Function0;", "", "onTextChanged", "Lkotlin/Function1;", "", BaseSwitches.V, EventBody.KEY_VALUE, "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "valueChangeObservers", "", "Ljava/util/function/Consumer;", "getValueChangeObservers", "()Ljava/util/List;", "generateMenu", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "activity", "Landroid/app/Activity;", "caller", "Lcom/obric/oui/dropdown/ODropdownTrigger;", "popMenu", "Lcom/obric/oui/popover/OPopover;", "dropdown", "menuView", "onDismiss", CommonConsts.APM_INNER_EVENT_COST_START, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class c<V> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<V> f13842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Consumer<V>> f13843b;
    private V c;
    private long d;
    private boolean e;
    private Function1<? super CharSequence, Unit> f;
    private Function0<Unit> g;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/dropdown/ODropdownRatio$popMenu$popover$1", "Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.oui.popover.b.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f13844a;

        a(Function0<Unit> r3) {
            this.f13844a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.popover.b.e
        public void a() {
            this.f13844a.invoke();
        }
    }

    public static final /* synthetic */ List a(c r0) {
        return r0.f13842a;
    }

    public static final /* synthetic */ void a(c r0, Object r1) {
        r0.a(r1);
    }

    private final void a(V r4) {
        if (Intrinsics.areEqual(this.c, r4) == false) goto L5;
        return;
    L5:
        this.c = r4;
        Iterator<Consumer<V>> r3 = this.f13843b.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.memorydata.plugin")).accept(r4);
        goto L7
    }

    public static final /* synthetic */ Function1 b(c r0) {
        return r0.f;
    }

    public static final /* synthetic */ Function0 c(c r0) {
        return r0.g;
    }

    public final com.obric.oui.popover.b a(ODropdownTrigger r16, Activity r17, OPopoverEntranceMenuView r18, Function0<Unit> r19) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r17, Activity.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "dropdown");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r18, "menuView");
        Intrinsics.checkNotNullParameter(r5, "onDismiss");
        final com.obric.oui.popover.b r2 = new com.obric.oui.popover.b.a(r3).a(false).a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin")).a(this.d).b(true).a((com.obric.oui.popover.b.e) ZeusTransformUtils.preCheckCast(new a(r5), com.obric.oui.popover.b.e.class, "com.obric.memorydata.plugin")).a(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_2_2_low_elevation, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_2_2_low_elevation"))).R();
        this.g = (Function0) ZeusTransformUtils.preCheckCast(new ODropdownRatio$popMenu$1(r2), Function0.class, "com.obric.memorydata.plugin");
        e.a(r2, (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"), 80, true, 0.0f, 0, 0, false, 120, null);
        return r2;
    }

    public final OPopoverEntranceMenuView a(Activity r19, final ODropdownTrigger r20) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r19, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r20, "caller");
        OPopoverEntranceMenuView.Builder r4 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        r4.b();
        if (this.e == false) goto L5;
        r4.a(r20.getMeasuredWidth() - h.a((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"), 12));
    L5:
        Iterator<V> r3 = this.f13842a.iterator();
    L7:
        if (r3.hasNext() == false) goto L19;
        V r5 = r3.next();
        int r7 = 0;
        if (r5 != null) goto L12;
    L10:
        boolean r13 = false;
    L14:
        String r6 = String.valueOf(r5);
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.dropdown.a.class) == false) goto L17;
        r7 = ((com.obric.oui.dropdown.a) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.dropdown.a.class, "com.obric.memorydata.plugin")).a();
    L17:
        OPopoverEntranceMenuView.Builder.a(r4, false, Integer.valueOf(r7), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), null, false, r13, (Function2) ZeusTransformUtils.preCheckCast(new ODropdownRatio$generateMenu$1(this, r20), Function2.class, "com.obric.memorydata.plugin"), 77, null);
        goto L7
    L12:
        if (r5.equals(this.c) != true) goto L10;
        r13 = true;
        goto L14
    L19:
        return r4.c();
    }

    @Override // com.obric.oui.dropdown.b
    public void a(ODropdownTrigger r3, Activity r4, Function0<Unit> r5, Function1<? super CharSequence, Unit> r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1<? super CharSequence, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "caller");
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "onDismiss");
        Intrinsics.checkNotNullParameter(r9, "onTextChanged");
        this.f = r9;
        a(r3, r7, a(r7, r3), r8);
    }
}
