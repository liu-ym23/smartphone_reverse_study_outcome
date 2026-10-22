package com.larus.dora.obric.device_management.setting.earbuds;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/LinearLayout;", "reconnectItem", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$ButtonItem;", "unbindItem", "deviceMac", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "unbindDialog", "Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "uiState", "Lcom/larus/dora/impl/dynamic/event/DeviceUIState;", "reconnectTitle", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "updateConnectionState", "state", "createButtonItem", "textColor", "", "ButtonItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsReconnectUnbindHolder extends BaseViewHolder<c59.i> {
    public static final int j = 0;
    public static final int k = 0;
    public final LinearLayout b;
    public final a c;
    public final a d;
    public String e;
    public d59.b f;
    public c59.o g;
    public e59.c h;
    public String i;

    public static final class a {
        public final View a;
        public final TextView b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ButtonItem(view=" + this.a + ", titleView=" + this.b + ')';
        }

        public a(View r2, TextView r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "titleView");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$ReconnectButton;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a {

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.title, ((a) r4).title) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "ReconnectButton(title=" + this.title + ')';
            }

            public a() {
                this.title = null;
            }

            public final c59.t a() {
                return this.title;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsReconnectUnbindHolder$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$ReconnectUnbindPanel;", "", "reconnectButton", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$ReconnectButton;", "unbindButton", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$UnbindButton;", "<init>", "(Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$ReconnectButton;Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$UnbindButton;)V", "getReconnectButton", "()Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$ReconnectButton;", "getUnbindButton", "()Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$UnbindButton;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0103b {

            @SerializedName("reconnect_button")
            private final a reconnectButton;

            @SerializedName("unbind_button")
            private final c unbindButton;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0103b) == true) goto L8;
                return false;
            L8:
                C0103b r6 = (C0103b) r5;
                if (Intrinsics.areEqual(this.reconnectButton, r6.reconnectButton) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.unbindButton, r6.unbindButton) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                a r0 = this.reconnectButton;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c r4 = this.unbindButton;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "ReconnectUnbindPanel(reconnectButton=" + this.reconnectButton + ", unbindButton=" + this.unbindButton + ')';
            }

            public C0103b() {
                this.reconnectButton = null;
                this.unbindButton = null;
            }

            public final a a() {
                return this.reconnectButton;
            }

            public final c b() {
                return this.unbindButton;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsReconnectUnbindHolder$Companion$UnbindButton;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "dialog", "Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslDialog;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getDialog", "()Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class c {

            @SerializedName("dialog")
            private final c59.o dialog;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.dialog, r6.dialog) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.o r4 = this.dialog;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "UnbindButton(title=" + this.title + ", dialog=" + this.dialog + ')';
            }

            public c() {
                this.title = null;
                this.dialog = null;
            }

            public final c59.o a() {
                return this.dialog;
            }

            public final c59.t b() {
                return this.title;
            }
        }

        public static int a(int r1, View r2) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            Resources r3 = r2.getResources();
            return (int) ((r1 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
        }
    }

    static {
        j = ColorProtector.parseColor("#0D72FF");
        k = ColorProtector.parseColor("#FF3333");
    }

    public DoraObricEarbudsReconnectUnbindHolder(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        LinearLayout r0 = new LinearLayout(r6.getContext());
        r0.setOrientation(1);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r0.setPadding(b.a(12, r6), b.a(8, r6), b.a(12, r6), b.a(8, r6));
        super(r0);
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r8 = (LinearLayout) r7;
        this.b = r8;
        a r1 = X3(j);
        this.c = r1;
        a r2 = X3(k);
        this.d = r2;
        this.h = e59.c.d.a;
        r8.addView(r1.a);
        r8.addView(r2.a);
    }

    public final a X3(int r6) {
        View r0 = LayoutInflater.from(this.b.getContext()).inflate(2131563735, this.b, false);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.bottomMargin = b.a(16, this.b);
        r0.setLayoutParams(r1);
        TextView r2 = (TextView) r0.findViewById(2131390398);
        r2.setGravity(17);
        r2.setTextColor(r6);
        r2.setTextSize(2, 16.0f);
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r2);
        return new a(r0, r2);
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r6, e59.b r7, d59.b r8) {
        c59.i r9 = r6;
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r7, "connectionState");
        Lazy r0 = c59.s.a;
        b.C0103b r10 = (b.C0103b) c59.s.c(r9.b, b.C0103b.class);
        c59.t r1 = null;
        if (r8 == null) goto L7;
        z49.b r2 = r8.a;
        if (r2 == null) goto L7;
        String r3 = r2.c();
    L8:
        this.e = r3;
        this.f = r8;
        if (r10 == null) goto L13;
        b.c r11 = r10.b();
        if (r11 == null) goto L13;
        c59.o r12 = r11.a();
    L14:
        this.g = r12;
        if (r10 == null) goto L19;
        b.a r13 = r10.a();
        if (r13 == null) goto L19;
        c59.t r14 = r13.a();
    L20:
        String r15 = c59.p.b(r14);
        String r4 = "";
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        int r5 = 0;
        if (r15.length() != 0) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == false) goto L29;
        r15 = this.b.getContext().getString(2131902419);
    L29:
        this.i = r15;
        a r17 = this.c;
        if (r15 != null) goto L32;
        r15 = "";
    L32:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r15, "title");
        r17.b.setText(r15);
        a r18 = this.d;
        if (r10 == null) goto L37;
        b.c r20 = r10.b();
        if (r20 == null) goto L37;
        r1 = r20.b();
    L37:
        String r21 = c59.p.b(r1);
        if (r21 != null) goto L40;
        r21 = "";
    L40:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r21, "title");
        r18.b.setText(r21);
        a r22 = this.c;
        final Function0 r23 = new p(this);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "listener");
        r22.a.setOnClickListener(new r(r23));
        a r24 = this.d;
        final Function0 r25 = new q(this);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "listener");
        r24.a.setOnClickListener(new r(r25));
        if ((r7 instanceof e59.b.C0125b) == false) goto L47;
        if (Intrinsics.areEqual(((e59.b.C0125b) r7).a, this.e) == false) goto L45;
        e59.c r26 = e59.c.C0126c.a;
    L53:
        this.h = r26;
        LinearLayout r27 = this.b;
        if (Intrinsics.areEqual(r26, e59.c.b.a) == false) goto L56;
        r5 = 8;
    L56:
        r27.setVisibility(r5);
        this.c.a.setEnabled(Intrinsics.areEqual(this.h, e59.c.d.a));
        a r28 = this.c;
        if (Intrinsics.areEqual(this.h, e59.c.C0126c.a) == false) goto L59;
        r4 = this.b.getContext().getString(2131902420);
    L63:
        Intrinsics.checkNotNull(r4);
        r28.getClass();
        Intrinsics.checkNotNullParameter(r4, "title");
        r28.b.setText(r4);
        return;
    L59:
        String r30 = this.i;
        if (r30 == null) goto L63;
        r4 = r30;
        goto L63
    L45:
        r26 = e59.c.d.a;
        goto L53
    L47:
        if ((r7 instanceof e59.b.a) == true) goto L49;
        r26 = e59.c.d.a;
        goto L53
    L49:
        if (Intrinsics.areEqual(((e59.b.a) r7).a, this.e) == false) goto L51;
        r26 = e59.c.b.a;
        goto L53
    L51:
        r26 = e59.c.d.a;
        goto L53
    L26:
        r16 = false;
    L19:
        r14 = null;
    L13:
        r12 = null;
    L7:
        r3 = null;
        goto L8
    }
}
