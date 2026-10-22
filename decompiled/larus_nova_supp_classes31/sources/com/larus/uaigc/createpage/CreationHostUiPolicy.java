package com.larus.uaigc.createpage;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationHostUiPolicy {
    public static final /* synthetic */ int f = 0;
    public final boolean a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$ExitAction;", "", "<init>", "(Ljava/lang/String;I)V", "FINISH_NATIVE", "NAVIGATE_BACK_IN_HOST", "CLOSE_HOST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum ExitAction extends Enum<ExitAction> {
        public static final ExitAction CLOSE_HOST = null;
        public static final ExitAction FINISH_NATIVE = null;
        public static final ExitAction NAVIGATE_BACK_IN_HOST = null;
        public static final /* synthetic */ ExitAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ExitAction> getEntries() {
            return b;
        }

        static {
            ExitAction r0 = new ExitAction("FINISH_NATIVE", 0);
            FINISH_NATIVE = r0;
            ExitAction r1 = new ExitAction("NAVIGATE_BACK_IN_HOST", 1);
            NAVIGATE_BACK_IN_HOST = r1;
            ExitAction r3 = new ExitAction("CLOSE_HOST", 2);
            CLOSE_HOST = r3;
            ExitAction[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ExitAction[] values() {
            return (ExitAction[]) a.clone();
        }

        public static ExitAction valueOf(String r1) {
            return (ExitAction) r27.a.a(ExitAction.class, r1);
        }

        public ExitAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$KeyboardChromeMode;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "HOST_ROOT_SCRIM", "HOST_ROOT_CLEAR", "HOST_KEEP_CLEAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum KeyboardChromeMode extends Enum<KeyboardChromeMode> {
        public static final KeyboardChromeMode HOST_KEEP_CLEAR = null;
        public static final KeyboardChromeMode HOST_ROOT_CLEAR = null;
        public static final KeyboardChromeMode HOST_ROOT_SCRIM = null;
        public static final KeyboardChromeMode NATIVE = null;
        public static final /* synthetic */ KeyboardChromeMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<KeyboardChromeMode> getEntries() {
            return b;
        }

        static {
            KeyboardChromeMode r0 = new KeyboardChromeMode("NATIVE", 0);
            NATIVE = r0;
            KeyboardChromeMode r1 = new KeyboardChromeMode("HOST_ROOT_SCRIM", 1);
            HOST_ROOT_SCRIM = r1;
            KeyboardChromeMode r3 = new KeyboardChromeMode("HOST_ROOT_CLEAR", 2);
            HOST_ROOT_CLEAR = r3;
            KeyboardChromeMode r5 = new KeyboardChromeMode("HOST_KEEP_CLEAR", 3);
            HOST_KEEP_CLEAR = r5;
            KeyboardChromeMode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static KeyboardChromeMode[] values() {
            return (KeyboardChromeMode[]) a.clone();
        }

        public static KeyboardChromeMode valueOf(String r1) {
            return (KeyboardChromeMode) r27.a.a(KeyboardChromeMode.class, r1);
        }

        public KeyboardChromeMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$LeadingAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "BACK", "NONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum LeadingAction extends Enum<LeadingAction> {
        public static final LeadingAction BACK = null;
        public static final LeadingAction CLOSE = null;
        public static final LeadingAction NONE = null;
        public static final /* synthetic */ LeadingAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LeadingAction> getEntries() {
            return b;
        }

        static {
            LeadingAction r0 = new LeadingAction("CLOSE", 0);
            CLOSE = r0;
            LeadingAction r1 = new LeadingAction("BACK", 1);
            BACK = r1;
            LeadingAction r3 = new LeadingAction("NONE", 2);
            NONE = r3;
            LeadingAction[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static LeadingAction[] values() {
            return (LeadingAction[]) a.clone();
        }

        public static LeadingAction valueOf(String r1) {
            return (LeadingAction) r27.a.a(LeadingAction.class, r1);
        }

        public LeadingAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$TitleBarMode;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "HOST_HOME_ROOT", "HOST_ROOT", "HOST_SECONDARY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum TitleBarMode extends Enum<TitleBarMode> {
        public static final TitleBarMode HOST_HOME_ROOT = null;
        public static final TitleBarMode HOST_ROOT = null;
        public static final TitleBarMode HOST_SECONDARY = null;
        public static final TitleBarMode NATIVE = null;
        public static final /* synthetic */ TitleBarMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TitleBarMode> getEntries() {
            return b;
        }

        static {
            TitleBarMode r0 = new TitleBarMode("NATIVE", 0);
            NATIVE = r0;
            TitleBarMode r1 = new TitleBarMode("HOST_HOME_ROOT", 1);
            HOST_HOME_ROOT = r1;
            TitleBarMode r3 = new TitleBarMode("HOST_ROOT", 2);
            HOST_ROOT = r3;
            TitleBarMode r5 = new TitleBarMode("HOST_SECONDARY", 3);
            HOST_SECONDARY = r5;
            TitleBarMode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static TitleBarMode[] values() {
            return (TitleBarMode[]) a.clone();
        }

        public static TitleBarMode valueOf(String r1) {
            return (TitleBarMode) r27.a.a(TitleBarMode.class, r1);
        }

        public TitleBarMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static CreationHostUiPolicy a(Bundle r7) {
            cy9.a r0 = cy9.a.a;
            r0.getClass();
            boolean r1 = cy9.a.e(r7);
            String r2 = cy9.a.b(r7);
            boolean r3 = cy9.a.g(r7);
            Bundle r4 = r0.c(r7);
            if (r4 != null) goto L5;
            r4 = r7;
        L5:
            boolean r5 = cy9.a.i(r4, "route_result_to_chat_after_ai_creation_applet");
            Bundle r6 = r0.c(r7);
            if (r6 == null) goto L10;
            r7 = r6;
        L10:
            return new CreationHostUiPolicy(r1, r2, r3, r5, cy9.a.i(r7, "finish_native_host_below_ai_creation_applet_on_send"));
        }
    }

    public static final class b {
        public final TitleBarMode a;
        public final LeadingAction b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
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

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "TitleBarSpec(mode=" + this.a + ", leadingAction=" + this.b + ", showAvatarEntrance=" + this.c + ", useDefaultTitleWhenEmpty=" + this.d + ')';
        }

        public b(TitleBarMode r2, LeadingAction r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r3, "leadingAction");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleBarMode.values().length];
            r0[TitleBarMode.HOST_HOME_ROOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[TitleBarMode.HOST_ROOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[TitleBarMode.HOST_SECONDARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[TitleBarMode.NATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final TitleBarMode c() {
        if (this.a == true) goto L6;
        return TitleBarMode.NATIVE;
    L6:
        if (this.c == false) goto L11;
        cy9.a r0 = cy9.a.a;
        String r1 = this.b;
        r0.getClass();
        if (cy9.a.f(r1) == false) goto L11;
        return TitleBarMode.HOST_HOME_ROOT;
    L11:
        if (this.c == false) goto L14;
        return TitleBarMode.HOST_ROOT;
    L14:
        return TitleBarMode.HOST_SECONDARY;
    }

    public final ExitAction b() {
        TitleBarMode r0 = c();
        int r1 = c.a[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L12;
        return ExitAction.FINISH_NATIVE;
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return ExitAction.NAVIGATE_BACK_IN_HOST;
    L15:
        return ExitAction.CLOSE_HOST;
    }

    public final void a(ConstraintLayout.LayoutParams r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.topToBottom = -1;
        r2.topToTop = -1;
        if (this.a == false) goto L5;
        r2.topToBottom = 2131388772;
        return;
    L5:
        if (r3 == null) goto L7;
        r2.topToBottom = r3.intValue();
        return;
    L7:
        r2.topToTop = 0;
    }

    public CreationHostUiPolicy(boolean r1, String r2, boolean r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
