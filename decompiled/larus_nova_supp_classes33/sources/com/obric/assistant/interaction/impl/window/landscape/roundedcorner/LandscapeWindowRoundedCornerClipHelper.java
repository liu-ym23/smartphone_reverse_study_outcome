package com.obric.assistant.interaction.impl.window.landscape.roundedcorner;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowInsets;
import com.larus.home.impl.utils.c;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import jba.d;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005+,-./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0010J'\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u001c\u0010\u0019\u001a\u00020\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003J\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010 \u001a\u00020\u000bH\u0003J\f\u0010!\u001a\u00020\u0017*\u00020\"H\u0002J\f\u0010#\u001a\u00020\u001f*\u00020\u0017H\u0002J0\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0015H\u0002J\u000e\u0010(\u001a\u00020\u0005*\u0004\u0018\u00010\u0017H\u0002J\f\u0010)\u001a\u00020\u0005*\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper;", "", "<init>", "()V", "TAG", "", "lastLoggedState", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$LogState;", "update", "", "orientation", "", "window", "Landroid/view/Window;", "windowInsets", "Landroid/view/WindowInsets;", "update$impl_mainlandRelease", "applyClipToDecorView", "decorView", "Landroid/view/View;", "enabled", "", "cornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "applyClipToDecorView$impl_mainlandRelease", "resolveCornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$ResolveResult;", "resolveResourceCornerRadii", "resolveSystemCornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemCornerRadiiResult;", "roundedCornerRadius", "", "position", "toLandscapeWindowCornerRadii", "Lcom/obric/assistant/activation/presentation/runtime/window/ObricLandscapeWindowCornerRadii;", "maxRadius", "logIfNeeded", WindowEvent.Params.RESULT, "hasWindow", "hasDecorView", "toLogTextOrNone", "toLogText", "NONE_LOG_VALUE", "CornerRadiiSource", "SystemInsetsCarrier", "ResolveResult", "SystemCornerRadiiResult", "LogState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeWindowRoundedCornerClipHelper {
    public static final LandscapeWindowRoundedCornerClipHelper INSTANCE = null;
    private static final String NONE_LOG_VALUE = "none";
    private static final String TAG = "LandscapeWindowRoundedCornerClipHelper";
    private static LogState lastLoggedState;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;", "", "logName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogName", "()Ljava/lang/String;", "SYSTEM_WINDOW_INSETS", "FALLBACK_BG_WINDOW_DIMEN", "DISABLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CornerRadiiSource extends Enum<CornerRadiiSource> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CornerRadiiSource[] $VALUES = null;
        public static final CornerRadiiSource DISABLED = null;
        public static final CornerRadiiSource FALLBACK_BG_WINDOW_DIMEN = null;
        public static final CornerRadiiSource SYSTEM_WINDOW_INSETS = null;
        private final String logName;

        private static final /* synthetic */ CornerRadiiSource[] $values() {
            return new CornerRadiiSource[]{SYSTEM_WINDOW_INSETS, FALLBACK_BG_WINDOW_DIMEN, DISABLED};
        }

        public static EnumEntries<CornerRadiiSource> getEntries() {
            return $ENTRIES;
        }

        static {
            SYSTEM_WINDOW_INSETS = new CornerRadiiSource("SYSTEM_WINDOW_INSETS", 0, "system_window_insets");
            FALLBACK_BG_WINDOW_DIMEN = new CornerRadiiSource("FALLBACK_BG_WINDOW_DIMEN", 1, "fallback_bg_window_dimen");
            DISABLED = new CornerRadiiSource("DISABLED", 2, "disabled");
            CornerRadiiSource[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static CornerRadiiSource[] values() {
            return (CornerRadiiSource[]) $VALUES.clone();
        }

        public final String getLogName() {
            return this.logName;
        }

        public static CornerRadiiSource valueOf(String r1) {
            return (CornerRadiiSource) a.a(CornerRadiiSource.class, r1);
        }

        private CornerRadiiSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.logName = r3;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003Jg\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u0006/"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$LogState;", "", "orientation", "", "enabled", "", "source", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;", "cornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "systemCornerRadii", "systemInsetsCarrier", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "resourceCornerRadii", "hasWindow", "hasDecorView", "<init>", "(IZLcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;ZZ)V", "getOrientation", "()I", "getEnabled", "()Z", "getSource", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;", "getCornerRadii", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "getSystemCornerRadii", "getSystemInsetsCarrier", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "getResourceCornerRadii", "getHasWindow", "getHasDecorView", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogState {
        private final LandscapeWindowCornerRadii cornerRadii;
        private final boolean enabled;
        private final boolean hasDecorView;
        private final boolean hasWindow;
        private final int orientation;
        private final LandscapeWindowCornerRadii resourceCornerRadii;
        private final CornerRadiiSource source;
        private final LandscapeWindowCornerRadii systemCornerRadii;
        private final SystemInsetsCarrier systemInsetsCarrier;

        public static /* synthetic */ LogState copy$default(LogState r10, int r11, boolean r12, CornerRadiiSource r13, LandscapeWindowCornerRadii r14, LandscapeWindowCornerRadii r15, SystemInsetsCarrier r16, LandscapeWindowCornerRadii r17, boolean r18, boolean r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            int r2 = r10.orientation;
        L7:
            if ((r20 & 2) == 0) goto L9;
            boolean r3 = r10.enabled;
        L11:
            if ((r20 & 4) == 0) goto L13;
            CornerRadiiSource r4 = r10.source;
        L15:
            if ((r20 & 8) == 0) goto L17;
            LandscapeWindowCornerRadii r5 = r10.cornerRadii;
        L19:
            if ((r20 & 16) == 0) goto L21;
            LandscapeWindowCornerRadii r6 = r10.systemCornerRadii;
        L23:
            if ((r20 & 32) == 0) goto L25;
            SystemInsetsCarrier r7 = r10.systemInsetsCarrier;
        L27:
            if ((r20 & 64) == 0) goto L29;
            LandscapeWindowCornerRadii r8 = r10.resourceCornerRadii;
        L31:
            if ((r20 & 128) == 0) goto L33;
            boolean r9 = r10.hasWindow;
        L35:
            if ((r20 & 256) == 0) goto L37;
            boolean r1 = r10.hasDecorView;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final int component1() {
            return this.orientation;
        }

        public final boolean component2() {
            return this.enabled;
        }

        public final CornerRadiiSource component3() {
            return this.source;
        }

        public final LandscapeWindowCornerRadii component4() {
            return this.cornerRadii;
        }

        public final LandscapeWindowCornerRadii component5() {
            return this.systemCornerRadii;
        }

        public final SystemInsetsCarrier component6() {
            return this.systemInsetsCarrier;
        }

        public final LandscapeWindowCornerRadii component7() {
            return this.resourceCornerRadii;
        }

        public final boolean component8() {
            return this.hasWindow;
        }

        public final boolean component9() {
            return this.hasDecorView;
        }

        public final LogState copy(int r12, boolean r13, CornerRadiiSource r14, LandscapeWindowCornerRadii r15, LandscapeWindowCornerRadii r16, SystemInsetsCarrier r17, LandscapeWindowCornerRadii r18, boolean r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r14, "source");
            Intrinsics.checkNotNullParameter(r15, "cornerRadii");
            Intrinsics.checkNotNullParameter(r18, "resourceCornerRadii");
            return new LogState(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof LogState) == true) goto L8;
            return false;
        L8:
            LogState r6 = (LogState) r5;
            if (this.orientation == r6.orientation) goto L12;
            return false;
        L12:
            if (this.enabled == r6.enabled) goto L15;
            return false;
        L15:
            if (this.source == r6.source) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.cornerRadii, r6.cornerRadii) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.systemCornerRadii, r6.systemCornerRadii) == true) goto L24;
            return false;
        L24:
            if (this.systemInsetsCarrier == r6.systemInsetsCarrier) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.resourceCornerRadii, r6.resourceCornerRadii) == true) goto L30;
            return false;
        L30:
            if (this.hasWindow == r6.hasWindow) goto L33;
            return false;
        L33:
            if (this.hasDecorView == r6.hasDecorView) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = this.orientation * 31;
            int r2 = 1231;
            if (this.enabled == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((r0 + r1) * 31) + this.source.hashCode()) * 31) + this.cornerRadii.hashCode()) * 31;
            LandscapeWindowCornerRadii r4 = this.systemCornerRadii;
            int r5 = 0;
            if (r4 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r3 + r6) * 31;
            SystemInsetsCarrier r8 = this.systemInsetsCarrier;
            if (r8 == null) goto L14;
            r5 = r8.hashCode();
        L14:
            int r9 = (((r7 + r5) * 31) + this.resourceCornerRadii.hashCode()) * 31;
            if (this.hasWindow == false) goto L17;
            int r10 = 1231;
        L18:
            int r11 = (r9 + r10) * 31;
            if (this.hasDecorView == true) goto L23;
            r2 = 1237;
        L23:
            return r11 + r2;
        L17:
            r10 = 1237;
            goto L18
        L9:
            r6 = r4.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            return "LogState(orientation=" + this.orientation + ", enabled=" + this.enabled + ", source=" + this.source + ", cornerRadii=" + this.cornerRadii + ", systemCornerRadii=" + this.systemCornerRadii + ", systemInsetsCarrier=" + this.systemInsetsCarrier + ", resourceCornerRadii=" + this.resourceCornerRadii + ", hasWindow=" + this.hasWindow + ", hasDecorView=" + this.hasDecorView + ')';
        }

        public final LandscapeWindowCornerRadii getCornerRadii() {
            return this.cornerRadii;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final boolean getHasDecorView() {
            return this.hasDecorView;
        }

        public final boolean getHasWindow() {
            return this.hasWindow;
        }

        public final int getOrientation() {
            return this.orientation;
        }

        public final LandscapeWindowCornerRadii getResourceCornerRadii() {
            return this.resourceCornerRadii;
        }

        public final CornerRadiiSource getSource() {
            return this.source;
        }

        public final LandscapeWindowCornerRadii getSystemCornerRadii() {
            return this.systemCornerRadii;
        }

        public final SystemInsetsCarrier getSystemInsetsCarrier() {
            return this.systemInsetsCarrier;
        }

        public LogState(int r2, boolean r3, CornerRadiiSource r4, LandscapeWindowCornerRadii r5, LandscapeWindowCornerRadii r6, SystemInsetsCarrier r7, LandscapeWindowCornerRadii r8, boolean r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r4, "source");
            Intrinsics.checkNotNullParameter(r5, "cornerRadii");
            Intrinsics.checkNotNullParameter(r8, "resourceCornerRadii");
            this.orientation = r2;
            this.enabled = r3;
            this.source = r4;
            this.cornerRadii = r5;
            this.systemCornerRadii = r6;
            this.systemInsetsCarrier = r7;
            this.resourceCornerRadii = r8;
            this.hasWindow = r9;
            this.hasDecorView = r10;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$ResolveResult;", "", "cornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "source", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;", "systemCornerRadii", "systemInsetsCarrier", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "resourceCornerRadii", "<init>", "(Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;)V", "getCornerRadii", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "getSource", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$CornerRadiiSource;", "getSystemCornerRadii", "getSystemInsetsCarrier", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "getResourceCornerRadii", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResolveResult {
        private final LandscapeWindowCornerRadii cornerRadii;
        private final LandscapeWindowCornerRadii resourceCornerRadii;
        private final CornerRadiiSource source;
        private final LandscapeWindowCornerRadii systemCornerRadii;
        private final SystemInsetsCarrier systemInsetsCarrier;

        public static /* synthetic */ ResolveResult copy$default(ResolveResult r3, LandscapeWindowCornerRadii r4, CornerRadiiSource r5, LandscapeWindowCornerRadii r6, SystemInsetsCarrier r7, LandscapeWindowCornerRadii r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.cornerRadii;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.source;
        L8:
            CornerRadiiSource r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.systemCornerRadii;
        L11:
            LandscapeWindowCornerRadii r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.systemInsetsCarrier;
        L14:
            SystemInsetsCarrier r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.resourceCornerRadii;
        L17:
            LandscapeWindowCornerRadii r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final LandscapeWindowCornerRadii component1() {
            return this.cornerRadii;
        }

        public final CornerRadiiSource component2() {
            return this.source;
        }

        public final LandscapeWindowCornerRadii component3() {
            return this.systemCornerRadii;
        }

        public final SystemInsetsCarrier component4() {
            return this.systemInsetsCarrier;
        }

        public final LandscapeWindowCornerRadii component5() {
            return this.resourceCornerRadii;
        }

        public final ResolveResult copy(LandscapeWindowCornerRadii r8, CornerRadiiSource r9, LandscapeWindowCornerRadii r10, SystemInsetsCarrier r11, LandscapeWindowCornerRadii r12) {
            Intrinsics.checkNotNullParameter(r8, "cornerRadii");
            Intrinsics.checkNotNullParameter(r9, "source");
            Intrinsics.checkNotNullParameter(r12, "resourceCornerRadii");
            return new ResolveResult(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ResolveResult) == true) goto L8;
            return false;
        L8:
            ResolveResult r6 = (ResolveResult) r5;
            if (Intrinsics.areEqual(this.cornerRadii, r6.cornerRadii) == true) goto L12;
            return false;
        L12:
            if (this.source == r6.source) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.systemCornerRadii, r6.systemCornerRadii) == true) goto L18;
            return false;
        L18:
            if (this.systemInsetsCarrier == r6.systemInsetsCarrier) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.resourceCornerRadii, r6.resourceCornerRadii) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.cornerRadii.hashCode() * 31) + this.source.hashCode()) * 31;
            LandscapeWindowCornerRadii r1 = this.systemCornerRadii;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            SystemInsetsCarrier r5 = this.systemInsetsCarrier;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.resourceCornerRadii.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ResolveResult(cornerRadii=" + this.cornerRadii + ", source=" + this.source + ", systemCornerRadii=" + this.systemCornerRadii + ", systemInsetsCarrier=" + this.systemInsetsCarrier + ", resourceCornerRadii=" + this.resourceCornerRadii + ')';
        }

        public final LandscapeWindowCornerRadii getCornerRadii() {
            return this.cornerRadii;
        }

        public final LandscapeWindowCornerRadii getResourceCornerRadii() {
            return this.resourceCornerRadii;
        }

        public final CornerRadiiSource getSource() {
            return this.source;
        }

        public final LandscapeWindowCornerRadii getSystemCornerRadii() {
            return this.systemCornerRadii;
        }

        public final SystemInsetsCarrier getSystemInsetsCarrier() {
            return this.systemInsetsCarrier;
        }

        public ResolveResult(LandscapeWindowCornerRadii r2, CornerRadiiSource r3, LandscapeWindowCornerRadii r4, SystemInsetsCarrier r5, LandscapeWindowCornerRadii r6) {
            Intrinsics.checkNotNullParameter(r2, "cornerRadii");
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r6, "resourceCornerRadii");
            this.cornerRadii = r2;
            this.source = r3;
            this.systemCornerRadii = r4;
            this.systemInsetsCarrier = r5;
            this.resourceCornerRadii = r6;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemCornerRadiiResult;", "", "cornerRadii", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "insetsCarrier", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "<init>", "(Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;)V", "getCornerRadii", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "getInsetsCarrier", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SystemCornerRadiiResult {
        private final LandscapeWindowCornerRadii cornerRadii;
        private final SystemInsetsCarrier insetsCarrier;

        public static /* synthetic */ SystemCornerRadiiResult copy$default(SystemCornerRadiiResult r0, LandscapeWindowCornerRadii r1, SystemInsetsCarrier r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.cornerRadii;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.insetsCarrier;
        L9:
            return r0.copy(r1, r2);
        }

        public final LandscapeWindowCornerRadii component1() {
            return this.cornerRadii;
        }

        public final SystemInsetsCarrier component2() {
            return this.insetsCarrier;
        }

        public final SystemCornerRadiiResult copy(LandscapeWindowCornerRadii r2, SystemInsetsCarrier r3) {
            Intrinsics.checkNotNullParameter(r2, "cornerRadii");
            Intrinsics.checkNotNullParameter(r3, "insetsCarrier");
            return new SystemCornerRadiiResult(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SystemCornerRadiiResult) == true) goto L8;
            return false;
        L8:
            SystemCornerRadiiResult r6 = (SystemCornerRadiiResult) r5;
            if (Intrinsics.areEqual(this.cornerRadii, r6.cornerRadii) == true) goto L12;
            return false;
        L12:
            if (this.insetsCarrier == r6.insetsCarrier) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.cornerRadii.hashCode() * 31) + this.insetsCarrier.hashCode();
        }

        public String toString() {
            return "SystemCornerRadiiResult(cornerRadii=" + this.cornerRadii + ", insetsCarrier=" + this.insetsCarrier + ')';
        }

        public final LandscapeWindowCornerRadii getCornerRadii() {
            return this.cornerRadii;
        }

        public final SystemInsetsCarrier getInsetsCarrier() {
            return this.insetsCarrier;
        }

        public SystemCornerRadiiResult(LandscapeWindowCornerRadii r2, SystemInsetsCarrier r3) {
            Intrinsics.checkNotNullParameter(r2, "cornerRadii");
            Intrinsics.checkNotNullParameter(r3, "insetsCarrier");
            this.cornerRadii = r2;
            this.insetsCarrier = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowRoundedCornerClipHelper$SystemInsetsCarrier;", "", "logName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogName", "()Ljava/lang/String;", "EXPLICIT_WINDOW_INSETS", "DECOR_ROOT_WINDOW_INSETS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SystemInsetsCarrier extends Enum<SystemInsetsCarrier> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SystemInsetsCarrier[] $VALUES = null;
        public static final SystemInsetsCarrier DECOR_ROOT_WINDOW_INSETS = null;
        public static final SystemInsetsCarrier EXPLICIT_WINDOW_INSETS = null;
        private final String logName;

        private static final /* synthetic */ SystemInsetsCarrier[] $values() {
            return new SystemInsetsCarrier[]{EXPLICIT_WINDOW_INSETS, DECOR_ROOT_WINDOW_INSETS};
        }

        public static EnumEntries<SystemInsetsCarrier> getEntries() {
            return $ENTRIES;
        }

        static {
            EXPLICIT_WINDOW_INSETS = new SystemInsetsCarrier("EXPLICIT_WINDOW_INSETS", 0, "explicit_window_insets");
            DECOR_ROOT_WINDOW_INSETS = new SystemInsetsCarrier("DECOR_ROOT_WINDOW_INSETS", 1, "decor_root_window_insets");
            SystemInsetsCarrier[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static SystemInsetsCarrier[] values() {
            return (SystemInsetsCarrier[]) $VALUES.clone();
        }

        public final String getLogName() {
            return this.logName;
        }

        public static SystemInsetsCarrier valueOf(String r1) {
            return (SystemInsetsCarrier) a.a(SystemInsetsCarrier.class, r1);
        }

        private SystemInsetsCarrier(String r1, int r2, String r3) {
            super(r1, r2);
            this.logName = r3;
        }
    }

    static {
        INSTANCE = new LandscapeWindowRoundedCornerClipHelper();
    }

    private LandscapeWindowRoundedCornerClipHelper() {
    }

    private final LandscapeWindowCornerRadii resolveResourceCornerRadii() {
        Resources r0 = FlowRuntime.a().getApplication().getResources();
        return LandscapeWindowCornerRadii.Companion.uniform$impl_mainlandRelease(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0).density * 36.0f);
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private final float maxRadius(LandscapeWindowCornerRadii r5) {
        return ComparisonsKt.maxOf(r5.getTopLeft(), new float[]{r5.getTopRight(), r5.getBottomRight(), r5.getBottomLeft(), 0.0f});
    }

    private final LandscapeWindowCornerRadii toLandscapeWindowCornerRadii(jba.c r5) {
        return new LandscapeWindowCornerRadii(r5.a, r5.b, r5.c, r5.d);
    }

    private final String toLogText(LandscapeWindowCornerRadii r3) {
        return "topLeft=" + r3.getTopLeft() + ", topRight=" + r3.getTopRight() + ", bottomRight=" + r3.getBottomRight() + ", bottomLeft=" + r3.getBottomLeft();
    }

    private final String toLogTextOrNone(LandscapeWindowCornerRadii r1) {
        if (r1 == null) goto L5;
        String r2 = toLogText(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return NONE_LOG_VALUE;
    }

    private final ResolveResult resolveCornerRadii(Window r13, WindowInsets r14) {
        LandscapeWindowCornerRadii r5 = resolveResourceCornerRadii();
        SystemCornerRadiiResult r15 = resolveSystemCornerRadii(r13, r14);
        if (r15 == null) goto L7;
        float r16 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(FlowRuntime.a().getApplication().getResources()).density * 8.0f;
        LandscapeWindowRoundedCornerClipHelper r0 = INSTANCE;
        int r1 = d.a;
        LandscapeWindowCornerRadii r2 = r0.toLandscapeWindowCornerRadii(d.b(r0.maxRadius(r5), r16, r15.getCornerRadii().getTopLeft(), r15.getCornerRadii().getTopRight(), r15.getCornerRadii().getBottomRight(), r15.getCornerRadii().getBottomLeft()));
        LandscapeWindowCornerRadii r3 = r0.toLandscapeWindowCornerRadii(d.b(0.0f, r16, r15.getCornerRadii().getTopLeft(), r15.getCornerRadii().getTopRight(), r15.getCornerRadii().getBottomRight(), r15.getCornerRadii().getBottomLeft()));
        return new ResolveResult(r2, CornerRadiiSource.SYSTEM_WINDOW_INSETS, r3, r15.getInsetsCarrier(), r5);
    L7:
        return new ResolveResult(r5, CornerRadiiSource.FALLBACK_BG_WINDOW_DIMEN, null, null, r5);
    }

    private final SystemCornerRadiiResult resolveSystemCornerRadii(Window r7, WindowInsets r8) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return null;
    L5:
        if (r8 == null) goto L7;
        SystemInsetsCarrier r0 = SystemInsetsCarrier.EXPLICIT_WINDOW_INSETS;
    L8:
        if (r8 != null) goto L16;
        if (r7 == null) goto L13;
        View r9 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r7);
        if (r9 == null) goto L13;
        r8 = r9.getRootWindowInsets();
    L14:
        if (r8 != null) goto L16;
        return null;
    L13:
        r8 = null;
    L16:
        LandscapeWindowCornerRadii r10 = new LandscapeWindowCornerRadii(roundedCornerRadius(r8, 0), roundedCornerRadius(r8, 1), roundedCornerRadius(r8, 2), roundedCornerRadius(r8, 3));
        if (r10.getHasRoundedCorner$impl_mainlandRelease() == true) goto L20;
        r10 = null;
    L20:
        if (r10 != null) goto L22;
        return null;
    L22:
        return new SystemCornerRadiiResult(r10, r0);
    L7:
        r0 = SystemInsetsCarrier.DECOR_ROOT_WINDOW_INSETS;
        goto L8
    }

    private final float roundedCornerRadius(WindowInsets r1, int r2) {
        RoundedCorner r3 = r1.getRoundedCorner(r2);
        if (r3 != null) goto L7;
        return 0.0f;
    L7:
        return r3.getRadius();
    }

    public final void applyClipToDecorView$impl_mainlandRelease(View r2, boolean r3, LandscapeWindowCornerRadii r4) {
        Intrinsics.checkNotNullParameter(r4, "cornerRadii");
        if (r2 != null) goto L5;
        return;
    L5:
        LandscapeWindowCornerRadii r5 = r4.sanitized$impl_mainlandRelease();
        if (r3 == true) goto L8;
    L12:
        r2.setClipToOutline(false);
        r2.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r2.invalidateOutline();
        return;
    L8:
        if (r5.getHasRoundedCorner$impl_mainlandRelease() == false) goto L12;
        r2.setElevation(0.0f);
        r2.setTranslationZ(0.0f);
        r2.setStateListAnimator(null);
        r2.setOutlineProvider(new LandscapeWindowRoundedCornerOutlineProvider(r5));
        r2.setClipToOutline(true);
        r2.invalidateOutline();
    }

    public final void update$impl_mainlandRelease(int r13, Window r14, WindowInsets r15) {
        if (r13 != 2) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        ResolveResult r6 = resolveCornerRadii(r14, r15);
    L9:
        View r16 = null;
        if (r14 == null) goto L12;
        View r0 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r14);
    L13:
        applyClipToDecorView$impl_mainlandRelease(r0, r5, r6.getCornerRadii());
        if (r14 == null) goto L16;
        boolean r7 = true;
    L17:
        if (r14 == null) goto L19;
        r16 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_roundedcorner_LandscapeWindowRoundedCornerClipHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r14);
    L19:
        if (r16 == null) goto L21;
        boolean r8 = true;
    L22:
        logIfNeeded(r13, r5, r6, r7, r8);
        return;
    L21:
        r8 = false;
        goto L22
    L16:
        r7 = false;
        goto L17
    L12:
        r0 = null;
        goto L13
    L8:
        LandscapeWindowCornerRadii.Companion r1 = LandscapeWindowCornerRadii.Companion;
        r6 = new ResolveResult(r1.getZERO$impl_mainlandRelease(), CornerRadiiSource.DISABLED, null, null, r1.getZERO$impl_mainlandRelease());
        goto L9
    L5:
        r5 = false;
        goto L6
    }

    private final void logIfNeeded(int r13, boolean r14, ResolveResult r15, boolean r16, boolean r17) {
        LogState r11 = new LogState(r13, r14, r15.getSource(), r15.getCornerRadii(), r15.getSystemCornerRadii(), r15.getSystemInsetsCarrier(), r15.getResourceCornerRadii(), r16, r17);
        if (Intrinsics.areEqual(lastLoggedState, r11) == false) goto L5;
        return;
    L5:
        lastLoggedState = r11;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("update: enabled=");
        r2.append(r14);
        r2.append(", orientation=");
        r2.append(r13);
        r2.append(", source=");
        r2.append(r15.getSource().getLogName());
        r2.append(", radii=");
        r2.append(toLogText(r15.getCornerRadii()));
        r2.append(", systemRadii=");
        r2.append(toLogTextOrNone(r15.getSystemCornerRadii()));
        r2.append(", resourceRadii=");
        r2.append(toLogText(r15.getResourceCornerRadii()));
        r2.append(", insetsCarrier=");
        SystemInsetsCarrier r3 = r15.getSystemInsetsCarrier();
        if (r3 == null) goto L9;
        String r4 = r3.getLogName();
        if (r4 == null) goto L9;
    L10:
        r2.append(r4);
        r2.append(", hasWindow=");
        r2.append(r16);
        r2.append(", hasDecorView=");
        r2.append(r17);
        r1.i(TAG, r2.toString());
        return;
    L9:
        r4 = NONE_LOG_VALUE;
        goto L10
    }

    public static /* synthetic */ void update$impl_mainlandRelease$default(LandscapeWindowRoundedCornerClipHelper r0, int r1, Window r2, WindowInsets r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.update$impl_mainlandRelease(r1, r2, r3);
    }
}
