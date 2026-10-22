package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 @2\u00020\u0001:\u0001@B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0005H\u0002J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014Jf\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0005HÖ\u0001J\t\u0010>\u001a\u00020?HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014¨\u0006A"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;", "", "heightMode", "Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;", "heightPercent", "", "heightDp", "adaptiveHeight", "", "maxHeightPercent", "minHeightDp", "transNavigationBar", "navigationBarColor", "<init>", "(Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;ILjava/lang/Integer;ZIILjava/lang/Boolean;Ljava/lang/Integer;)V", "getHeightMode", "()Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;", "getHeightPercent", "()I", "getHeightDp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdaptiveHeight", "()Z", "getMaxHeightPercent", "getMinHeightDp", "getTransNavigationBar", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNavigationBarColor", "initialBodyHeight", "context", "Landroid/content/Context;", "contentLayoutHeight", "shouldTrackContentHeight", "maxHeightPx", "minHeightPx", "applyTo", "", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "bodyContainer", "Landroid/view/ViewGroup;", "applyWindowTo", "activity", "Landroid/app/Activity;", "availableSheetHeightPx", "resolveLightNavigationBarAppearance", "color", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;ILjava/lang/Integer;ZIILjava/lang/Boolean;Ljava/lang/Integer;)Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetHostConfig {
    public static final Companion Companion = null;
    private static final int FULL_HEIGHT_PERCENT = 93;
    private final boolean adaptiveHeight;
    private final Integer heightDp;
    private final MiniAppSheetHeightMode heightMode;
    private final int heightPercent;
    private final int maxHeightPercent;
    private final int minHeightDp;
    private final Integer navigationBarColor;
    private final Boolean transNavigationBar;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0019\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig$Companion;", "", "<init>", "()V", "FULL_HEIGHT_PERCENT", "", "from", "Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;", "pageSettings", "Lcom/google/gson/JsonObject;", "sheetSettings", "resolveHeightMode", "Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;", "resolveTransNavigationBar", "", "(Lcom/google/gson/JsonObject;)Ljava/lang/Boolean;", "resolveNavigationBarColor", "(Lcom/google/gson/JsonObject;)Ljava/lang/Integer;", "applySheetHeightMode", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "heightMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final MiniAppSheetHeightMode resolveHeightMode(JsonObject r4) {
            if (r4 == null) goto L5;
            String r0 = MiniAppSheetHostKt.access$stringValue(r4, "heightMode");
            if (r0 == null) goto L5;
        L13:
            MiniAppSheetHeightMode r5 = MiniAppSheetHeightMode.Companion.from(r0);
            if (r0 == null) goto L17;
            if (r5 != null) goto L17;
            FLogger.a.w("MiniAppSheetHost", "unsupported sheet heightMode=".concat(r0));
        L17:
            return r5;
        L5:
            r0 = null;
            if (r4 == null) goto L8;
            String r1 = MiniAppSheetHostKt.access$stringValue(r4, "sheetHeightMode");
        L9:
            if (r1 != null) goto L12;
            if (r4 == null) goto L13;
            r0 = MiniAppSheetHostKt.access$stringValue(r4, "containerHeightMode");
            goto L13
        L12:
            r0 = r1;
            goto L13
        L8:
            r1 = null;
            goto L9
        }

        private final Integer resolveNavigationBarColor(JsonObject r4) {
            if (r4 == null) goto L4;
            boolean r0 = Intrinsics.areEqual(MiniAppSheetHostKt.access$booleanValue(r4, "transNavigationBar"), Boolean.FALSE);
        L5:
            Object r1 = null;
            if (r0 == true) goto L8;
            return null;
        L8:
            String r5 = MiniAppSheetHostKt.access$stringValue(r4, "navigationBarColor");
            if (r5 != null) goto L21;
            return null;
        L21:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
            Object r3 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r5)));     // Catch: Throwable -> L13
        L16:
            if (Result.exceptionOrNull-impl(r3) != null) goto L18;
            r1 = r3;
        L20:
            return (Integer) r1;
        L18:
            FLogger.a.w("MiniAppSheetHost", "invalid navigationBarColor=".concat(r5));
        L13:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L4:
            r0 = false;
            goto L5
        }

        private final Boolean resolveTransNavigationBar(JsonObject r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return MiniAppSheetHostKt.access$booleanValue(r2, "transNavigationBar");
        }

        private final boolean applySheetHeightMode(OSheet r11, MiniAppSheetHeightMode r12) {
            Method[] r0 = r11.getClass().getMethods();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            Object r4 = null;
            if (r3 >= r1) goto L14;
            Method r6 = r0[r3];
            if (Intrinsics.areEqual(r6.getName(), "setHeightMode") == true) goto L8;
        L10:
            boolean r7 = false;
        L11:
            if (r7 == true) goto L15;
            r3 = r3 + 1;
        L15:
            if (r6 != null) goto L17;
            return false;
        L17:
            Class r2 = (Class) ArraysKt.firstOrNull(r6.getParameterTypes());
            if (r2 != null) goto L20;
            return false;
        L20:
            Object[] r5 = r2.getEnumConstants();
            if (r5 == null) goto L47;
            int r8 = r5.length;
            int r9 = 0;
        L23:
            if (r9 >= r8) goto L35;
            Object r10 = r5[r9];
            if ((r10 instanceof Enum) == false) goto L27;
            Enum r13 = (Enum) r10;
        L28:
            if (r13 == null) goto L30;
            String r14 = r13.name();
        L32:
            if (Intrinsics.areEqual(r14, r12.name()) == true) goto L33;
            r9 = r9 + 1;
            goto L23
        L33:
            r4 = r10;
            goto L35
        L30:
            r14 = null;
            goto L32
        L27:
            r13 = null;
        L35:
            if (r4 == null) goto L47;
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L39
            r6.invoke(r11, new Object[]{r4});     // Catch: Throwable -> L39
            Object r16 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L39
        L41:
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L46;
            FLogger.a.w("MiniAppSheetHost", "applySheetHeightMode failed: " + r17.getMessage());
            r16 = Boolean.FALSE;
        L46:
            return ((Boolean) r16).booleanValue();
        L39:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
        L47:
            return false;
        L8:
            if (r6.getParameterTypes().length != 1) goto L10;
            r7 = true;
            goto L11
        L14:
            r6 = null;
            goto L15
        }

        public final MiniAppSheetHostConfig from(JsonObject r11, JsonObject r12) {
            MiniAppSheetHeightMode r1 = resolveHeightMode(r11);
            if (r12 == null) goto L7;
            Integer r3 = MiniAppSheetHostKt.access$intValue(r12, "heightPercent");
            if (r3 == null) goto L7;
            int r4 = RangesKt.coerceIn(r3.intValue(), 40, 100);
        L8:
            if (r12 == null) goto L10;
            Integer r5 = MiniAppSheetHostKt.access$intValue(r12, "heightDp");
        L11:
            if (r12 == null) goto L15;
            Boolean r6 = MiniAppSheetHostKt.access$booleanValue(r12, "adaptiveHeight");
            if (r6 == null) goto L15;
            boolean r7 = r6.booleanValue();
        L16:
            if (r12 == null) goto L20;
            Integer r8 = MiniAppSheetHostKt.access$intValue(r12, "maxHeightPercent");
            if (r8 == null) goto L20;
            int r9 = RangesKt.coerceIn(r8.intValue(), 40, 100);
        L21:
            if (r12 == null) goto L25;
            Integer r13 = MiniAppSheetHostKt.access$intValue(r12, "minHeightDp");
            if (r13 == null) goto L25;
            int r14 = RangesKt.coerceAtLeast(r13.intValue(), ApWakeEvent.WALKING_START);
        L26:
            int r2 = r4;
            Integer r10 = r5;
            boolean r15 = r7;
            int r16 = r9;
            int r17 = r14;
            return new MiniAppSheetHostConfig(r1, r2, r10, r15, r16, r17, resolveTransNavigationBar(r11), resolveNavigationBarColor(r11));
        L25:
            r14 = 240;
        L20:
            r9 = 90;
        L15:
            r7 = false;
            goto L16
        L10:
            r5 = null;
        L7:
            r4 = 86;
            goto L8
        }

        public static final /* synthetic */ boolean access$applySheetHeightMode(Companion r0, OSheet r1, MiniAppSheetHeightMode r2) {
            return r0.applySheetHeightMode(r1, r2);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[MiniAppSheetHeightMode.values().length];
            r0[MiniAppSheetHeightMode.FULL_HEIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MiniAppSheetHeightMode.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MiniAppSheetHostConfig() {
        this(null, 0, null, false, 0, 0, null, null, 255, null);
    }

    public static /* synthetic */ MiniAppSheetHostConfig copy$default(MiniAppSheetHostConfig r9, MiniAppSheetHeightMode r10, int r11, Integer r12, boolean r13, int r14, int r15, Boolean r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        MiniAppSheetHeightMode r2 = r9.heightMode;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.heightPercent;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = r9.heightDp;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.adaptiveHeight;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = r9.maxHeightPercent;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.minHeightDp;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Boolean r8 = r9.transNavigationBar;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.navigationBarColor;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final MiniAppSheetHeightMode component1() {
        return this.heightMode;
    }

    public final int component2() {
        return this.heightPercent;
    }

    public final Integer component3() {
        return this.heightDp;
    }

    public final boolean component4() {
        return this.adaptiveHeight;
    }

    public final int component5() {
        return this.maxHeightPercent;
    }

    public final int component6() {
        return this.minHeightDp;
    }

    public final Boolean component7() {
        return this.transNavigationBar;
    }

    public final Integer component8() {
        return this.navigationBarColor;
    }

    public final MiniAppSheetHostConfig copy(MiniAppSheetHeightMode r11, int r12, Integer r13, boolean r14, int r15, int r16, Boolean r17, Integer r18) {
        return new MiniAppSheetHostConfig(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiniAppSheetHostConfig) == true) goto L8;
        return false;
    L8:
        MiniAppSheetHostConfig r6 = (MiniAppSheetHostConfig) r5;
        if (this.heightMode == r6.heightMode) goto L12;
        return false;
    L12:
        if (this.heightPercent == r6.heightPercent) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.heightDp, r6.heightDp) == true) goto L18;
        return false;
    L18:
        if (this.adaptiveHeight == r6.adaptiveHeight) goto L21;
        return false;
    L21:
        if (this.maxHeightPercent == r6.maxHeightPercent) goto L24;
        return false;
    L24:
        if (this.minHeightDp == r6.minHeightDp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.transNavigationBar, r6.transNavigationBar) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.navigationBarColor, r6.navigationBarColor) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        MiniAppSheetHeightMode r0 = this.heightMode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.heightPercent) * 31;
        Integer r4 = this.heightDp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.adaptiveHeight == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((((r6 + r7) * 31) + this.maxHeightPercent) * 31) + this.minHeightDp) * 31;
        Boolean r9 = this.transNavigationBar;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Integer r12 = this.navigationBarColor;
        if (r12 == null) goto L23;
        r1 = r12.hashCode();
    L23:
        return r11 + r1;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MiniAppSheetHostConfig(heightMode=" + this.heightMode + ", heightPercent=" + this.heightPercent + ", heightDp=" + this.heightDp + ", adaptiveHeight=" + this.adaptiveHeight + ", maxHeightPercent=" + this.maxHeightPercent + ", minHeightDp=" + this.minHeightDp + ", transNavigationBar=" + this.transNavigationBar + ", navigationBarColor=" + this.navigationBarColor + ')';
    }

    public final int contentLayoutHeight() {
        MiniAppSheetHeightMode r0 = this.heightMode;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 2) goto L10;
        return -2;
    L10:
        return -1;
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L7
    }

    public final boolean shouldTrackContentHeight() {
        MiniAppSheetHeightMode r0 = this.heightMode;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 == (-1)) goto L16;
        if (r1 != 1) goto L10;
        return false;
    L10:
        if (r1 != 2) goto L13;
        return true;
    L13:
        throw new NoWhenBranchMatchedException();
    L16:
        return this.adaptiveHeight;
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L6
    }

    public final boolean getAdaptiveHeight() {
        return this.adaptiveHeight;
    }

    public final Integer getHeightDp() {
        return this.heightDp;
    }

    public final MiniAppSheetHeightMode getHeightMode() {
        return this.heightMode;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final int getMaxHeightPercent() {
        return this.maxHeightPercent;
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final Integer getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final Boolean getTransNavigationBar() {
        return this.transNavigationBar;
    }

    public static View INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostConfig_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private final int availableSheetHeightPx(Context r4) {
        int r0 = MiniAppSheetHostKt.access$screenHeightPx(r4);
        if (Intrinsics.areEqual(this.transNavigationBar, Boolean.FALSE) == true) goto L6;
        return r0;
    L6:
        return RangesKt.coerceAtLeast(r0 - MiniAppSheetHostKt.access$navigationBarHeightPx(r4), 0);
    }

    private final boolean resolveLightNavigationBarAppearance(int r7) {
        if (Color.alpha(r7) != 0) goto L6;
        return true;
    L6:
        if (ColorUtils.calculateLuminance(r7) > 0.5d) goto L10;
        return false;
    L10:
        return true;
    }

    public final int initialBodyHeight(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r0 = availableSheetHeightPx(r5);
        MiniAppSheetHeightMode r1 = this.heightMode;
        if (r1 != null) goto L5;
        int r2 = -1;
    L6:
        if (r2 != (-1)) goto L8;
        Integer r3 = this.heightDp;
        if (r3 == null) goto L22;
        return MiniAppSheetHostKt.access$dpToPx(r5, r3.intValue());
    L22:
        return (r0 * this.heightPercent) / 100;
    L8:
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L13;
        return -2;
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        if (Intrinsics.areEqual(this.transNavigationBar, Boolean.FALSE) == true) goto L26;
        return -1;
    L26:
        return r0;
    L5:
        r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        goto L6
    }

    public final int maxHeightPx(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r5 = availableSheetHeightPx(r4);
        MiniAppSheetHeightMode r0 = this.heightMode;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 == (-1)) goto L16;
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L17;
        throw new NoWhenBranchMatchedException();
    L17:
        return (r5 * FULL_HEIGHT_PERCENT) / 100;
    L16:
        return (r5 * this.maxHeightPercent) / 100;
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L6
    }

    public final int minHeightPx(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.heightMode != MiniAppSheetHeightMode.WRAP_CONTENT) goto L7;
        return 0;
    L7:
        return MiniAppSheetHostKt.access$dpToPx(r3, this.minHeightDp);
    }

    public final void applyWindowTo(OSheet r6, Activity r7) {
        Intrinsics.checkNotNullParameter(r6, "sheet");
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (this.transNavigationBar == null) goto L5;
    L7:
        Window r8 = r6.getWindow();
        if (r8 != null) goto L10;
        return;
    L10:
        View r0 = INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHostConfig_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r8);
        if (r0 != null) goto L13;
        return;
    L13:
        WindowManager.LayoutParams r1 = r8.getAttributes();
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 30) goto L16;
    L20:
        r8.clearFlags(134217728);
        r8.addFlags(Integer.MIN_VALUE);
        if (r2 < 29) goto L24;
        r8.setNavigationBarContrastEnforced(false);
    L24:
        if (Intrinsics.areEqual(this.transNavigationBar, Boolean.TRUE) == false) goto L33;
        WindowCompat.setDecorFitsSystemWindows(r8, false);
        r0.setSystemUiVisibility(r0.getSystemUiVisibility() | 512);
        r0.setFitsSystemWindows(false);
        r8.setNavigationBarColor(0);
        if (r2 < 28) goto L28;
        r8.setNavigationBarDividerColor(0);
    L28:
        WindowInsetsControllerCompat r9 = WindowCompat.getInsetsController(r8, r0);
        if (r9 == null) goto L45;
        r9.setAppearanceLightNavigationBars(resolveLightNavigationBarAppearance(0));
        return;
    L45:
        return;
    L33:
        if (Intrinsics.areEqual(this.transNavigationBar, Boolean.FALSE) == false) goto L46;
        Integer r3 = this.navigationBarColor;
        if (r3 == null) goto L37;
        int r10 = r3.intValue();
    L38:
        WindowCompat.setDecorFitsSystemWindows(r8, true);
        r0.setSystemUiVisibility(r0.getSystemUiVisibility() & (-513));
        r0.setFitsSystemWindows(true);
        r8.setNavigationBarColor(r10);
        if (r2 < 28) goto L41;
        r8.setNavigationBarDividerColor(r10);
    L41:
        WindowInsetsControllerCompat r11 = WindowCompat.getInsetsController(r8, r0);
        if (r11 == null) goto L47;
        r11.setAppearanceLightNavigationBars(resolveLightNavigationBarAppearance(r10));
        return;
    L47:
        return;
    L37:
        r10 = r7.getWindow().getNavigationBarColor();
        goto L38
    L46:
        return;
    L16:
        if (Intrinsics.areEqual(this.transNavigationBar, Boolean.TRUE) == false) goto L18;
        int r4 = WindowInsets.Side.all() ^ 8;
    L19:
        r1.setFitInsetsSides(r4);
        r8.setAttributes(r1);
        goto L20
    L18:
        r4 = WindowInsets.Side.all();
        goto L19
    L5:
        if (this.navigationBarColor != null) goto L7;
    }

    public final void applyTo(OSheet r4, ViewGroup r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "sheet");
        Intrinsics.checkNotNullParameter(r5, "bodyContainer");
        Intrinsics.checkNotNullParameter(r6, "context");
        MiniAppSheetHeightMode r0 = this.heightMode;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 != (-1)) goto L8;
        return;
    L8:
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L15;
        if (Companion.access$applySheetHeightMode(Companion, r4, MiniAppSheetHeightMode.WRAP_CONTENT) == true) goto L24;
        MiniAppSheetHostKt.access$updateLayoutHeight(r5, -2);
        return;
    L24:
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    L17:
        if (Intrinsics.areEqual(this.transNavigationBar, Boolean.FALSE) == false) goto L20;
        MiniAppSheetHostKt.access$updateLayoutHeight(r5, availableSheetHeightPx(r6));
        return;
    L20:
        if (Companion.access$applySheetHeightMode(Companion, r4, MiniAppSheetHeightMode.FULL_HEIGHT) == true) goto L27;
        MiniAppSheetHostKt.access$updateLayoutHeight(r5, maxHeightPx(r6));
        return;
    L27:
        return;
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L6
    }

    public MiniAppSheetHostConfig(MiniAppSheetHeightMode r1, int r2, Integer r3, boolean r4, int r5, int r6, Boolean r7, Integer r8) {
        this.heightMode = r1;
        this.heightPercent = r2;
        this.heightDp = r3;
        this.adaptiveHeight = r4;
        this.maxHeightPercent = r5;
        this.minHeightDp = r6;
        this.transNavigationBar = r7;
        this.navigationBarColor = r8;
    }

    public /* synthetic */ MiniAppSheetHostConfig(MiniAppSheetHeightMode r10, int r11, Integer r12, boolean r13, int r14, int r15, Boolean r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        Integer r2 = null;
        if ((r18 & 1) == 0) goto L5;
        MiniAppSheetHeightMode r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = 86;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = 90;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = 240;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Boolean r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
