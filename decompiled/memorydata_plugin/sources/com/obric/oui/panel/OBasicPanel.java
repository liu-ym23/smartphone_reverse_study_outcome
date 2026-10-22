package com.obric.oui.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0003\u0015\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "()V", "config", "Lcom/obric/oui/panel/OBasicPanel$Builder;", "getConfig", "()Lcom/obric/oui/panel/OBasicPanel$Builder;", "setConfig", "(Lcom/obric/oui/panel/OBasicPanel$Builder;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "setPanelConfig", "builder", "Builder", "Companion", "PadCompatConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanel extends OBasicPanelFragment {
    public static final b Companion = null;
    public static final int TOP_CORNER_RADIUS = 20;
    protected a config;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "", "isEnabled", "", "isMultiPanel", "closeIconStyle", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "forceEnable", "(ZZLcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;Z)V", "getCloseIconStyle", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "getForceEnable", "()Z", "setForceEnable", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "CloseIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PadCompatConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f14262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14263b;
        private final CloseIconStyle c;
        private boolean d;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "BLACK_NO_BG", "WHITE_WITH_BG", "BLACK_WITH_BG", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
            private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
            public static final CloseIconStyle BLACK_NO_BG = null;
            public static final CloseIconStyle BLACK_WITH_BG = null;
            public static final CloseIconStyle WHITE_WITH_BG = null;

            private static final /* synthetic */ CloseIconStyle[] $values() {
                return new CloseIconStyle[]{BLACK_NO_BG, WHITE_WITH_BG, BLACK_WITH_BG};
            }

            static {
                BLACK_NO_BG = new CloseIconStyle("BLACK_NO_BG", 0);
                WHITE_WITH_BG = new CloseIconStyle("WHITE_WITH_BG", 1);
                BLACK_WITH_BG = new CloseIconStyle("BLACK_WITH_BG", 2);
                $VALUES = $values();
            }

            private CloseIconStyle(String r1, int r2) {
                super(r1, r2);
            }

            public static CloseIconStyle valueOf(String r2) {
                return (CloseIconStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(CloseIconStyle.class, r2), CloseIconStyle.class, "com.obric.memorydata.plugin");
            }

            public static CloseIconStyle[] values() {
                return (CloseIconStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CloseIconStyle[].class, "com.obric.memorydata.plugin");
            }
        }

        public PadCompatConfig() {
            this(false, false, null, false, 15, null);
        }

        public PadCompatConfig(boolean r2, boolean r3, CloseIconStyle r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "closeIconStyle");
            this.f14262a = r2;
            this.f14263b = r3;
            this.c = r4;
            this.d = r5;
        }

        public /* synthetic */ PadCompatConfig(boolean r2, boolean r3, CloseIconStyle r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = CloseIconStyle.BLACK_WITH_BG;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, PadCompatConfig.class) == true) goto L8;
            return false;
        L8:
            PadCompatConfig r6 = (PadCompatConfig) ZeusTransformUtils.preCheckCast(r5, PadCompatConfig.class, "com.obric.memorydata.plugin");
            if (this.f14262a == r6.f14262a) goto L12;
            return false;
        L12:
            if (this.f14263b == r6.f14263b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            boolean r0 = this.f14262a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f14263b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
            boolean r7 = this.d;
            if (r7 == true) goto L13;
            r1 = r7;
        L13:
            return r6 + r1;
        }

        public String toString() {
            return "PadCompatConfig(isEnabled=" + this.f14262a + ", isMultiPanel=" + this.f14263b + ", closeIconStyle=" + this.c + ", forceEnable=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010oJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0005J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010q\u001a\u00020+J\u000e\u0010r\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0005J\u0006\u0010u\u001a\u00020vJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\u0005J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ°\u0001\u0010\u0087\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001¢\u0006\u0003\u0010\u0088\u0001J\u0015\u0010\u0089\u0001\u001a\u00020\u00052\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0005J(\u0010\u0006\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u0005J2\u0010\u0006\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0003J\u000f\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u0003J\u0018\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u00032\u0007\u0010\u008d\u0001\u001a\u00020\u0005J\u000f\u0010\u0014\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u0015J\u0010\u0010\u008f\u0001\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u0011J\u000f\u0010_\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020`J\u000f\u0010\u0016\u001a\u00020\u00002\u0007\u0010\u0091\u0001\u001a\u00020\u0005J\u000f\u0010\u0012\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020\u0005J\u000f\u0010#\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020 J\u000f\u0010>\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0005J\u0010\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020^J\u000f\u0010k\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u0003J\u000b\u0010\u0096\u0001\u001a\u00030\u0097\u0001HÖ\u0001J\u000f\u0010\u0004\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020\u0005R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\"\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001a\u0010F\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001a\u0010I\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0019\"\u0004\bM\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0019\"\u0004\bR\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bW\u00104\"\u0004\bX\u00106R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0019\"\u0004\bh\u0010\u001bR\u001a\u0010i\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010T\"\u0004\bk\u0010VR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0019\"\u0004\bm\u0010\u001b¨\u0006\u0099\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$Builder;", "", "maxPanelHeight", "", "useToneBg", "", "isExpandable", "header", "Lcom/obric/oui/panel/header/BasicPanelHeader;", Params.CONTENT, "Landroid/view/View;", "floatHeader", "backgroundDimEnable", "adaptNavBarColor", "navBarColor", "clipTopCorner", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "retainInstance", "autoSwitchDayNight", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "removeMinHeight", "(IZZLcom/obric/oui/panel/header/BasicPanelHeader;Landroid/view/View;ZZZLjava/lang/Integer;ZLandroid/content/DialogInterface$OnDismissListener;ZZLandroid/content/DialogInterface$OnCancelListener;Z)V", "getAdaptNavBarColor", "()Z", "setAdaptNavBarColor", "(Z)V", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "animConfig", "Lcom/obric/oui/panel/anim/AnimConfig;", "getAnimConfig", "()Lcom/obric/oui/panel/anim/AnimConfig;", "setAnimConfig", "(Lcom/obric/oui/panel/anim/AnimConfig;)V", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "getBackgroundDimEnable", "setBackgroundDimEnable", "bottomSheetCallbacks", "", "Lcom/obric/oui/panel/BottomSheetBehavior$BottomSheetCallback;", "getBottomSheetCallbacks", "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "getClipTopCorner", "setClipTopCorner", "collapsedHeight", "getCollapsedHeight", "()Ljava/lang/Integer;", "setCollapsedHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "expandedHeight", "getExpandedHeight", "setExpandedHeight", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "fixedPanelHeight", "getFixedPanelHeight", "setFixedPanelHeight", "getFloatHeader", "setFloatHeader", "getHeader", "()Lcom/obric/oui/panel/header/BasicPanelHeader;", "setHeader", "(Lcom/obric/oui/panel/header/BasicPanelHeader;)V", "setExpandable", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "getNavBarColor", "setNavBarColor", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "outsideClickListener", "Landroid/view/View$OnClickListener;", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "getRemoveMinHeight", "setRemoveMinHeight", "getRetainInstance", "setRetainInstance", "styleId", "getStyleId", "setStyleId", "getUseToneBg", "setUseToneBg", "enable", "(ZLjava/lang/Integer;)Lcom/obric/oui/panel/OBasicPanel$Builder;", "addBottomSheetCallback", "callback", "allowHeaderFloating", TypedValues.Custom.S_FLOAT, "autoSwitch", "build", "Lcom/obric/oui/panel/OBasicPanel;", "clip", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZZLcom/obric/oui/panel/header/BasicPanelHeader;Landroid/view/View;ZZZLjava/lang/Integer;ZLandroid/content/DialogInterface$OnDismissListener;ZZLandroid/content/DialogInterface$OnCancelListener;Z)Lcom/obric/oui/panel/OBasicPanel$Builder;", "equals", "other", "hashCode", "height", "fixedHeight", "listener", "onDismissListener", "config", "remove", "retain", "disable", "setOutsideClickListener", OaidModel.KEY_ID, "toString", "", "tongBg", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14265b;
        private boolean c;
        private com.obric.oui.panel.header.c d;
        private View e;
        private boolean f;
        private boolean g;
        private boolean h;
        private Integer i;
        private boolean j;
        private DialogInterface.OnDismissListener k;
        private boolean l;
        private boolean m;
        private DialogInterface.OnCancelListener n;
        private boolean o;
        private boolean p;
        private int q;

        public a() {
            this(0, false, false, null, null, false, false, false, null, false, null, false, false, null, false, 32767, null);
        }

        public a(int r6, boolean r7, boolean r8, com.obric.oui.panel.header.c r9, View r10, boolean r11, boolean r12, boolean r13, Integer r14, boolean r15, DialogInterface.OnDismissListener r16, boolean r17, boolean r18, DialogInterface.OnCancelListener r19, boolean r20) {
            DialogInterface.OnDismissListener r1 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r16, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
            DialogInterface.OnCancelListener r2 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r19, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
            this.f14264a = r6;
            this.f14265b = r7;
            this.c = r8;
            this.d = r9;
            this.e = r10;
            this.f = r11;
            this.g = r12;
            this.h = r13;
            this.i = r14;
            this.j = r15;
            this.k = r1;
            this.l = r17;
            this.m = r18;
            this.n = r2;
            this.o = r20;
            this.p = true;
            this.q = ZeusTransformUtils.mapRes(R.style.OBasicPanel, "style", "OBasicPanel");
        }

        public /* synthetic */ a(int r17, boolean r18, boolean r19, com.obric.oui.panel.header.c r20, View r21, boolean r22, boolean r23, boolean r24, Integer r25, boolean r26, DialogInterface.OnDismissListener r27, boolean r28, boolean r29, DialogInterface.OnCancelListener r30, boolean r31, int r32, DefaultConstructorMarker r33) {
            DialogInterface.OnDismissListener r1 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r27, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
            DialogInterface.OnCancelListener r2 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r30, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
            if ((r32 & 1) == 0) goto L5;
            int r3 = -1;
        L7:
            if ((r32 & 2) == 0) goto L9;
            boolean r4 = false;
        L11:
            if ((r32 & 4) == 0) goto L13;
            boolean r6 = false;
        L15:
            if ((r32 & 8) == 0) goto L17;
            com.obric.oui.panel.header.c r7 = null;
        L19:
            if ((r32 & 16) == 0) goto L21;
            View r9 = null;
        L23:
            if ((r32 & 32) == 0) goto L25;
            boolean r10 = false;
        L26:
            boolean r12 = true;
            if ((r32 & 64) == 0) goto L29;
            boolean r11 = true;
        L31:
            if ((r32 & 128) == 0) goto L33;
            boolean r13 = false;
        L35:
            if ((r32 & 256) == 0) goto L37;
            Integer r14 = null;
        L39:
            if ((r32 & 512) != 0) goto L43;
            r12 = r26;
        L43:
            if ((r32 & 1024) == 0) goto L46;
            r1 = null;
        L46:
            if ((r32 & 2048) == 0) goto L48;
            boolean r15 = false;
        L50:
            if ((r32 & 4096) == 0) goto L52;
            boolean r5 = false;
        L54:
            if ((r32 & 8192) == 0) goto L57;
            r2 = null;
        L57:
            if ((r32 & 16384) == 0) goto L59;
            boolean r0 = false;
        L60:
            this(r3, r4, r6, r7, r9, r10, r11, r13, r14, r12, r1, r15, r5, r2, r0);
            return;
        L59:
            r0 = r31;
            goto L60
        L52:
            r5 = r29;
            goto L54
        L48:
            r15 = r28;
            goto L50
        L37:
            r14 = r25;
            goto L39
        L33:
            r13 = r24;
            goto L35
        L29:
            r11 = r23;
            goto L31
        L25:
            r10 = r22;
            goto L26
        L21:
            r9 = r21;
            goto L23
        L17:
            r7 = r20;
            goto L19
        L13:
            r6 = r19;
            goto L15
        L9:
            r4 = r18;
            goto L11
        L5:
            r3 = r17;
            goto L7
        }

        public final View a() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f14264a == r6.f14264a) goto L12;
            return false;
        L12:
            if (this.f14265b == r6.f14265b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L53;
            return false;
        L53:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v29, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v25, types: [int] */
        /* JADX WARN: Type inference failed for: r1v27, types: [int] */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v47 */
        /* JADX WARN: Type inference failed for: r1v48 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r0 = Integer.hashCode(this.f14264a) * 31;
            boolean r1 = this.f14265b;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.c;
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (r4 + r6) * 31;
            com.obric.oui.panel.header.c r8 = this.d;
            int r9 = 0;
            if (r8 != null) goto L11;
            int r10 = 0;
        L12:
            int r11 = (r7 + r10) * 31;
            View r12 = this.e;
            if (r12 != null) goto L15;
            int r13 = 0;
        L16:
            int r14 = (r11 + r13) * 31;
            boolean r15 = this.f;
            ?? r16 = r15;
            if (r15 == false) goto L19;
            r16 = 1;
        L19:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.g;
            ?? r19 = r18;
            if (r18 == false) goto L22;
            r19 = 1;
        L22:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.h;
            ?? r22 = r21;
            if (r21 == false) goto L25;
            r22 = 1;
        L25:
            int r23 = (r20 + r22) * 31;
            Integer r24 = this.i;
            if (r24 != null) goto L28;
            int r25 = 0;
        L29:
            int r26 = (r23 + r25) * 31;
            boolean r27 = this.j;
            ?? r28 = r27;
            if (r27 == false) goto L32;
            r28 = 1;
        L32:
            int r29 = (r26 + r28) * 31;
            DialogInterface.OnDismissListener r30 = this.k;
            if (r30 != null) goto L35;
            int r31 = 0;
        L36:
            int r32 = (r29 + r31) * 31;
            boolean r33 = this.l;
            ?? r34 = r33;
            if (r33 == false) goto L39;
            r34 = 1;
        L39:
            int r35 = (r32 + r34) * 31;
            boolean r36 = this.m;
            ?? r37 = r36;
            if (r36 == false) goto L42;
            r37 = 1;
        L42:
            int r38 = (r35 + r37) * 31;
            DialogInterface.OnCancelListener r39 = this.n;
            if (r39 == null) goto L46;
            r9 = r39.hashCode();
        L46:
            int r40 = (r38 + r9) * 31;
            boolean r41 = this.o;
            if (r41 == true) goto L51;
            r2 = r41;
        L51:
            return r40 + r2;
        L35:
            r31 = r30.hashCode();
            goto L36
        L28:
            r25 = r24.hashCode();
            goto L29
        L15:
            r13 = r12.hashCode();
            goto L16
        L11:
            r10 = r8.hashCode();
            goto L12
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Builder(maxPanelHeight=").append(this.f14264a).append(", useToneBg=").append(this.f14265b).append(", isExpandable=").append(this.c).append(", header=").append(this.d).append(", content=").append(this.e).append(", floatHeader=").append(this.f).append(", backgroundDimEnable=").append(this.g).append(", adaptNavBarColor=").append(this.h).append(", navBarColor=").append(this.i).append(", clipTopCorner=").append(this.j).append(", dismissListener=").append(this.k).append(", retainInstance=");
            r0.append(this.l).append(", autoSwitchDayNight=").append(this.m).append(", onCancelListener=").append(this.n).append(", removeMinHeight=").append(this.o).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$Companion;", "", "()V", "TOP_CORNER_RADIUS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new b(null);
    }

    public OBasicPanel() {
    }

    public final a getConfig() {
        a r0 = this.config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.config != null) goto L7;
        return null;
    L7:
        if (getConfig().a() == null) goto L12;
        View r4 = getConfig().a();
        Intrinsics.checkNotNull(r4);
        if (r4.getParent() == null) goto L12;
        View r5 = getConfig().a();
        Intrinsics.checkNotNull(r5);
        ViewParent r6 = r5.getParent();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(getConfig().a());
    L12:
        return getConfig().a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.config != null) goto L16;
        Dialog r0 = getDialog();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L17;
        Dialog r3 = getDialog();
        if (r3 == null) goto L18;
        r3.cancel();
        return;
    L18:
        return;
    L17:
        return;
    L8:
        if (r0.isShowing() != true) goto L10;
        r1 = true;
        goto L10
    }

    public final void setConfig(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.config = r2;
    }

    public final void setPanelConfig(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        setConfig(r2);
    }
}
