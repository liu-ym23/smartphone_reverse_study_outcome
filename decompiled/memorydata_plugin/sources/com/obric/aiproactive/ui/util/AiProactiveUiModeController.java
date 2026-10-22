package com.obric.aiproactive.ui.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0019J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010$\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\"\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006&"}, d2 = {"Lcom/obric/aiproactive/ui/util/AiProactiveUiModeController;", "", "<init>", "()V", "mode", "Lcom/obric/aiproactive/ui/util/AiProactiveUiModeController$Mode;", "getMode", "()Lcom/obric/aiproactive/ui/util/AiProactiveUiModeController$Mode;", "setMode", "(Lcom/obric/aiproactive/ui/util/AiProactiveUiModeController$Mode;)V", "activeActivityCount", "", "originalUiMode", "Ljava/lang/Integer;", "wrapBaseContext", "Landroid/content/Context;", "context", "applyToResources", "", "resources", "Landroid/content/res/Resources;", "onActivityStarted", "onActivityStopped", "onActivityDestroyed", "applyOverrideConfiguration", "Landroid/content/res/Configuration;", "configuration", "resolvedModeName", "", "isNightMode", "", "targetNightMode", "()Ljava/lang/Integer;", "updateResourcesNightMode", "nightMode", "restoreResources", "withNightMode", "Mode", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiProactiveUiModeController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AiProactiveUiModeController f6869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Mode f6870b;
    private static int c;
    private static Integer d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/util/AiProactiveUiModeController$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "FORCE_LIGHT", "FOLLOW_SYSTEM", "FORCE_DARK", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode FOLLOW_SYSTEM = null;
        public static final Mode FORCE_DARK = null;
        public static final Mode FORCE_LIGHT = null;

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{FORCE_LIGHT, FOLLOW_SYSTEM, FORCE_DARK};
        }

        static {
            FORCE_LIGHT = new Mode("FORCE_LIGHT", 0);
            FOLLOW_SYSTEM = new Mode("FOLLOW_SYSTEM", 1);
            FORCE_DARK = new Mode("FORCE_DARK", 2);
            Mode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6871a = null;

        static {
            int[] r0 = new int[Mode.values().length];
            r0[Mode.FORCE_LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Mode.FORCE_DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Mode.FOLLOW_SYSTEM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6871a = r0;
        }
    }

    static {
        f6869a = new AiProactiveUiModeController();
        f6870b = Mode.FOLLOW_SYSTEM;
    }

    private AiProactiveUiModeController() {
    }

    private final Configuration a(Configuration r1, int r2) {
        Configuration r0 = new Configuration(r1);
        r0.uiMode = (r0.uiMode & (-49)) | r2;
        return r0;
    }

    private final void a(Resources r3, int r4) {
        if ((r3.getConfiguration().uiMode & 48) != r4) goto L5;
        return;
    L5:
        Configuration r0 = r3.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r0, "getConfiguration(...)");
        r3.updateConfiguration(a(r0, r4), r3.getDisplayMetrics());
    }

    private final Integer b() {
        Mode r1 = f6870b;
        int r2 = a.f6871a[r1.ordinal()];
        if (r2 != 1) goto L5;
        int r3 = 16;
    L14:
        return Integer.valueOf(r3);
    L5:
        if (r2 != 2) goto L7;
        r3 = 32;
        goto L14
    L7:
        if (r2 != 3) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void e(Resources r3) {
        Integer r2 = d;
        if (r2 == null) goto L6;
        int r4 = r2.intValue();
        Configuration r0 = new Configuration(r3.getConfiguration());
        int r5 = r4 & 48;
        r0.uiMode = r5 | (r0.uiMode & (-49));
        r3.updateConfiguration(r0, r3.getDisplayMetrics());
        d = null;
        return;
    }

    public final Context a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Mode r0 = f6870b;
        int r1 = a.f6871a[r0.ordinal()];
        if (r1 != 1) goto L5;
        Configuration r2 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r2, "getConfiguration(...)");
        int r3 = 16;
    L13:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.createConfigurationContext(a(r2, r3)), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "createConfigurationContext(...)");
        return r8;
    L5:
        if (r1 != 2) goto L7;
        r2 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r2, "getConfiguration(...)");
        r3 = 32;
        goto L13
    L7:
        if (r1 != 3) goto L10;
        return r7;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final Configuration a(Configuration r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Mode r0 = f6870b;
        int r1 = a.f6871a[r0.ordinal()];
        if (r1 != 1) goto L8;
        int r2 = 16;
    L17:
        return a(r3, r2);
    L8:
        if (r1 != 2) goto L10;
        r2 = 32;
        goto L17
    L10:
        if (r1 != 3) goto L13;
        return r3;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final String a() {
        return f6870b.name();
    }

    public final void a(Resources r3) {
        Intrinsics.checkNotNullParameter(r3, "resources");
        Integer r0 = b();
        if (r0 == null) goto L9;
        int r1 = r0.intValue();
        if (d != null) goto L7;
        d = Integer.valueOf(r3.getConfiguration().uiMode);
    L7:
        a(r3, r1);
        return;
    }

    public final void b(Resources r2) {
        Intrinsics.checkNotNullParameter(r2, "resources");
        if (b() != null) goto L5;
        return;
    L5:
        c++;
        a(r2);
    }

    public final boolean b(Configuration r1) {
        Intrinsics.checkNotNullParameter(r1, "configuration");
        if ((r1.uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c(Resources r3) {
        Intrinsics.checkNotNullParameter(r3, "resources");
        if (b() != null) goto L5;
        return;
    L5:
        int r0 = RangesKt.coerceAtLeast(c - 1, 0);
        c = r0;
        if (r0 != 0) goto L9;
        e(r3);
        return;
    }

    public final void d(Resources r2) {
        Intrinsics.checkNotNullParameter(r2, "resources");
        if (b() != null) goto L5;
        return;
    L5:
        if (c != 0) goto L9;
        e(r2);
        return;
    }
}
