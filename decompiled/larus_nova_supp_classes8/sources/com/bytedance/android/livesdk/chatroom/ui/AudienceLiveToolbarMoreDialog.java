package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/AudienceLiveToolbarMoreDialog;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LiveToolbarMoreDialog;", "Lcom/bytedance/android/livesdk/utils/c2;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLiveToolbarMoreDialog extends LiveToolbarMoreDialog implements com.bytedance.android.livesdk.utils.c2 {
    public static final /* synthetic */ int b1 = 0;
    public final PublishSubject<List<ExtendedToolbarButton>> H0;
    public Disposable L0;
    public final Stack<ExtendedToolbarButton> P0;
    public final List<ExtendedToolbarButton> V0;
    public long Z;
    public GridLayout k0;
    public View p0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AudienceLiveToolbarMoreDialog a;

        public a(AudienceLiveToolbarMoreDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.bytedance.android.livesdk.chatroom.ui.AudienceLiveToolbarMoreDialog, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarMoreDialog] */
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
        public final void accept(Object r5) {
            List r6 = (List) r5;
            ?? r0 = this.a;
            int r1 = AudienceLiveToolbarMoreDialog.b1;
            com.bytedance.android.livesdk.utils.e2.c(r6, r0.K);
            com.bytedance.android.livesdk.utils.e2.f(r6, r0.Z, r0.P0);
            Intrinsics.checkNotNullParameter(r6, "$this$sortBySpecificRule");
            Collections.sort(r6, com.bytedance.android.livesdk.utils.d2.a);
            r0.k1(r6, r0.a1(), LayoutInflater.from(r0.getContext()));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final void A() {
        List<ExtendedToolbarButton> r0 = this.V0;
        this.H0.onNext(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarMoreDialog
    public final List<ExtendedToolbarButton> g1() {
        return CollectionsKt.plus(this.V0, super.g1());
    }

    public final void onUnload() {
        Disposable r0 = this.L0;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarMoreDialog
    public final void c1() {
        int r0 = a1();
        LayoutInflater r1 = LayoutInflater.from(getContext());
        X0(g1());
        k1(this.V0, r0, r1);
        e1(r0, r1);
    }

    public final void K(ExtendedToolbarButton.c r3) {
        Intrinsics.checkNotNullParameter(r3, "tempAreaStateItem");
        if (com.bytedance.android.livesdk.utils.e2.d(this.V0, r3) == false) goto L5;
        return;
    L5:
        List<ExtendedToolbarButton> r0 = this.V0;
        com.bytedance.android.livesdk.utils.e2.b(r0, r3);
        ListProtector.add(r0, 0, r3);
        List<ExtendedToolbarButton> r4 = this.V0;
        this.H0.onNext(r4);
    }

    public final void f0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Iterator<ExtendedToolbarButton> r0 = this.V0.iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        ExtendedToolbarButton r1 = r0.next();
        if ((r1 instanceof ExtendedToolbarButton.c) == false) goto L4;
        if (Intrinsics.areEqual(((ExtendedToolbarButton.c) r1).s, r5) == false) goto L4;
        this.V0.remove(r1);
        if ((!this.P0.isEmpty()) == true) goto L12;
    L18:
        this.H0.onNext(this.V0);
        return;
    L12:
        if (this.P0.contains(r1) == false) goto L15;
        this.P0.remove(r1);
        goto L18
    L15:
        if (this.V0.size() > this.Z) goto L17;
        this.P0.clear();
        goto L18
    L17:
        this.P0.pop();
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarMoreDialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        View r4 = findViewById(2131388311);
        if ((r4 instanceof GridLayout) == true) goto L5;
        r4 = null;
    L5:
        this.k0 = (GridLayout) r4;
        this.p0 = findViewById(2131388310);
        this.L0 = RxUtilKt.h(this.H0).subscribe(new a(this), b.a);
    }

    public final void t(List<? extends ExtendedToolbarButton.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "tempAreaStateData");
        com.bytedance.android.livesdk.utils.e2.a(this.V0);
        this.P0.clear();
        this.V0.addAll(r2);
        this.H0.onNext(this.V0);
    }

    public final void z(long r1) {
        this.Z = r1;
    }

    public final void k1(List<ExtendedToolbarButton> r3, int r4, LayoutInflater r5) {
        if (((CommonStandardBottomDialog) this).A == true) goto L5;
    L28:
        GridLayout r6 = this.k0;
        if (r6 == null) goto L31;
        UtilityKotlinExtentionsKt.t(r6);
    L31:
        View r7 = this.p0;
        if (r7 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    L42:
        return;
    L5:
        if (r3.isEmpty() == true) goto L28;
        if (com.bytedance.android.livesdk.utils.e2.e(r3, this.K) == false) goto L28;
        GridLayout r0 = this.k0;
        if (r0 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r0);
    L12:
        View r1 = this.p0;
        if (r1 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r1);
    L15:
        GridLayout r2 = this.k0;
        if (r2 == null) goto L18;
        r2.removeAllViews();
    L18:
        Iterator<ExtendedToolbarButton> r8 = r3.iterator();
    L20:
        if (r8.hasNext() == false) goto L27;
        ExtendedToolbarButton r9 = r8.next();
        if (this.P0.contains(r9) == true) goto L20;
        GridLayout r10 = this.k0;
        if (r10 == null) goto L20;
        f1(r4, r5, r9, r10);
        goto L20
    }

    public AudienceLiveToolbarMoreDialog(Context r8, List<ExtendedToolbarButton> r9, List<? extends ToolbarButton> r10, List<? extends ToolbarButton> r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "mTempStateAreaConfigList");
        Intrinsics.checkNotNullParameter(r10, "stableAreaStateConfigList");
        Intrinsics.checkNotNullParameter(r11, "interactStateConfigList");
        super(r8, r10, r11, new ep1.e(), false);
        this.V0 = r9;
        this.Z = 16;
        this.H0 = PublishSubject.create();
        this.P0 = new Stack();
    }

    public final void N(long r2, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "iconUrl");
        Intrinsics.checkNotNullParameter(r5, "iconName");
        Intrinsics.checkNotNullParameter(r6, "iconDescription");
        com.bytedance.android.livesdk.utils.e2.g(this.V0, String.valueOf(r2), r4, r5, r6);
        List<ExtendedToolbarButton> r3 = this.V0;
        this.H0.onNext(r3);
    }
}
