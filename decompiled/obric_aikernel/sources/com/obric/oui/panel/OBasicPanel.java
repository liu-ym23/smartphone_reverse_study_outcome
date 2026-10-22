package com.obric.oui.panel;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\"\u0010\u000f\u001a\u00020\f8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "", "onStart", "Lcom/obric/oui/panel/OBasicPanel$a;", "builder", "setPanelConfig", "config", "Lcom/obric/oui/panel/OBasicPanel$a;", "getConfig", "()Lcom/obric/oui/panel/OBasicPanel$a;", "setConfig", "(Lcom/obric/oui/panel/OBasicPanel$a;)V", "<init>", "()V", "Companion", "a", "b", "PadCompatConfig", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OBasicPanel extends OBasicPanelFragment {
    public static final b Companion = null;
    public static final int TOP_CORNER_RADIUS = 20;
    protected a config;

    public static final class PadCompatConfig {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BLACK_NO_BG", "WHITE_WITH_BG", "BLACK_WITH_BG", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
            private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
            public static final CloseIconStyle BLACK_NO_BG = null;
            public static final CloseIconStyle BLACK_WITH_BG = null;
            public static final CloseIconStyle WHITE_WITH_BG = null;

            static {
                CloseIconStyle r10 = new CloseIconStyle("BLACK_NO_BG", 0);
                BLACK_NO_BG = r10;
                CloseIconStyle r11 = new CloseIconStyle("WHITE_WITH_BG", 1);
                WHITE_WITH_BG = r11;
                CloseIconStyle r12 = new CloseIconStyle("BLACK_WITH_BG", 2);
                BLACK_WITH_BG = r12;
                $VALUES = new CloseIconStyle[]{r10, r11, r12};
            }

            private CloseIconStyle(String r10, int r11) {
                super(r10, r11);
            }

            public static CloseIconStyle valueOf(String r10) {
                return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r10);
            }

            public static CloseIconStyle[] values() {
                return (CloseIconStyle[]) $VALUES.clone();
            }
        }
    }

    public static final class a {
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.OBasicPanel$onCreateView$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        AnonymousClass1(OBasicPanel r10) {
            super(r10, OBasicPanel.class, "config", "getConfig()Lcom/obric/oui/panel/OBasicPanel$Builder;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((OBasicPanel) this.receiver).getConfig();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.OBasicPanel$onStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C03921 extends PropertyReference0Impl {
        C03921(OBasicPanel r10) {
            super(r10, OBasicPanel.class, "config", "getConfig()Lcom/obric/oui/panel/OBasicPanel$Builder;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((OBasicPanel) this.receiver).getConfig();
        }
    }

    static {
        Companion = new b(null);
    }

    public OBasicPanel() {
    }

    protected final a getConfig() {
        a r10 = this.config;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return r10;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog r10 = getDialog();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isShowing() != true) goto L11;
        Dialog r11 = getDialog();
        if (r11 == null) goto L12;
        r11.cancel();
        return;
    L12:
        return;
    }

    protected final void setConfig(a r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
    }

    public final void setPanelConfig(a r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
    }
}
