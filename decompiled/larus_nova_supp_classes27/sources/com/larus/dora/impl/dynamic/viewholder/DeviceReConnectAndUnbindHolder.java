package com.larus.dora.impl.dynamic.viewholder;

import androidx.appcompat.widget.AppCompatTextView;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.databinding.LarusDoraDeviceReconnectAndUnbindLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceReconnectAndUnbindLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceReconnectAndUnbindLayoutBinding;)V", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraDeviceReconnectAndUnbindLayoutBinding;", "currentUIState", "Lcom/larus/dora/impl/dynamic/event/DeviceUIState;", "deviceMac", "", "shouldShowLoading", "", "rotateAnimation", "Landroid/view/animation/Animation;", "gson", "Lcom/google/gson/Gson;", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "updateUIByConnectionState", "state", "updateUIState", "newState", "startLoadingAnimation", "stopLoadingAnimation", "onViewDetached", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceReConnectAndUnbindHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int e = 0;
    public final LarusDoraDeviceReconnectAndUnbindLayoutBinding b;
    public e59.c c;
    public String d;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.DeviceReConnectAndUnbindHolder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslReconnectButtonConfig;", "", "reconnectButton", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "reconnectButtonText", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslAction;)V", "getReconnectButton", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getReconnectButtonText", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0070a {

            @SerializedName("reconnect_button")
            private final c59.t reconnectButton;

            @SerializedName("action")
            private final c59.b reconnectButtonText;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0070a) == true) goto L8;
                return false;
            L8:
                C0070a r6 = (C0070a) r5;
                if (Intrinsics.areEqual(this.reconnectButton, r6.reconnectButton) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.reconnectButtonText, r6.reconnectButtonText) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.reconnectButton;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.b r4 = this.reconnectButtonText;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslReconnectButtonConfig(reconnectButton=" + this.reconnectButton + ", reconnectButtonText=" + this.reconnectButtonText + ')';
            }

            public C0070a() {
                this.reconnectButton = null;
                this.reconnectButtonText = null;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslReconnectUnbindPanel;", "", "reconnectButton", "Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslReconnectButtonConfig;", "unbindButton", "Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslUnbindButtonConfig;", "<init>", "(Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslReconnectButtonConfig;Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslUnbindButtonConfig;)V", "getReconnectButton", "()Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslReconnectButtonConfig;", "getUnbindButton", "()Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslUnbindButtonConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b {

            @SerializedName("reconnect_button")
            private final C0070a reconnectButton;

            @SerializedName("unbind_button")
            private final c unbindButton;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.reconnectButton, r6.reconnectButton) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.unbindButton, r6.unbindButton) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                C0070a r0 = this.reconnectButton;
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
                return "DslReconnectUnbindPanel(reconnectButton=" + this.reconnectButton + ", unbindButton=" + this.unbindButton + ')';
            }

            public b() {
                this.reconnectButton = null;
                this.unbindButton = null;
            }

            public final c a() {
                return this.unbindButton;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceReConnectAndUnbindHolder$Companion$DslUnbindButtonConfig;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "dialog", "Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslDialog;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getDialog", "()Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
                return "DslUnbindButtonConfig(title=" + this.title + ", dialog=" + this.dialog + ')';
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
    }

    static {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void V3() {
    }

    public DeviceReConnectAndUnbindHolder(LarusDoraDeviceReconnectAndUnbindLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        new GsonBuilder().serializeNulls().create();
    }

    public final void X3(e59.c r4) {
        g49.d.d("DeviceReConnectAndUnbindHolder", "update ui state " + r4);
        if (Intrinsics.areEqual(this.c, r4) == false) goto L6;
        g49.d.d("DeviceReConnectAndUnbindHolder", "current ui state = new state, " + r4 + " , return");
        return;
    L6:
        this.c = r4;
        if (Intrinsics.areEqual(r4, e59.c.d.a) == false) goto L10;
        this.b.c.setText(2131902419);
        this.b.b.setEnabled(true);
        e1.o(this.b.e);
        return;
    L10:
        if (Intrinsics.areEqual(r4, e59.c.C0126c.a) == false) goto L13;
        e1.x(this.b.e);
        this.b.c.setText(2131902420);
        this.b.b.setEnabled(false);
        e1.x(this.b.e);
        return;
    L13:
        if (Intrinsics.areEqual(r4, e59.c.a.a) == false) goto L16;
        this.b.c.setText(2131902419);
        this.b.b.setEnabled(true);
        e1.o(this.b.e);
        return;
    L16:
        if (Intrinsics.areEqual(r4, e59.c.b.a) == false) goto L20;
        e1.o(this.b.e);
        return;
    L20:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r5, e59.b r6, final d59.b r7) {
        c59.i r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r6, "connectionState");
        LarusDoraDeviceReconnectAndUnbindLayoutBinding r0 = this.b;
        Lazy r1 = c59.s.a;
        final a.b r9 = (a.b) c59.s.c(r8.b, a.b.class);
        e1.d(r0.b, new g(this, r7));
        c59.t r2 = null;
        if (r7 == null) goto L7;
        z49.b r3 = r7.a;
        if (r3 == null) goto L7;
        String r4 = r3.c();
    L8:
        this.d = r4;
        AppCompatTextView r10 = r0.d;
        if (r9 == null) goto L13;
        a.c r11 = r9.a();
        if (r11 == null) goto L13;
        r2 = r11.b();
    L13:
        r10.setText(c59.p.b(r2));
        e1.d(r0.d, new h(this, r7, r9));
        Intrinsics.checkNotNullParameter(r6, "state");
        if ((r6 instanceof e59.b.d) == false) goto L17;
        X3(e59.c.d.a);
        return;
    L17:
        if ((r6 instanceof e59.b.C0125b) == false) goto L23;
        if (Intrinsics.areEqual(((e59.b.C0125b) r6).a, this.d) == false) goto L21;
        X3(e59.c.C0126c.a);
        return;
    L21:
        X3(e59.c.d.a);
        return;
    L23:
        if ((r6 instanceof e59.b.a) == false) goto L29;
        if (Intrinsics.areEqual(((e59.b.a) r6).a, this.d) == false) goto L27;
        X3(e59.c.b.a);
        return;
    L27:
        X3(e59.c.d.a);
        return;
    L29:
        if ((r6 instanceof e59.b.c) == false) goto L35;
        if (Intrinsics.areEqual(((e59.b.c) r6).a, this.d) == false) goto L41;
        X3(e59.c.d.a);
        return;
    L41:
        return;
    L35:
        throw new NoWhenBranchMatchedException();
    L7:
        r4 = null;
        goto L8
    }
}
