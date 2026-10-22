package com.bytedance.ai.applet.components.input;

import androidx.fragment.app.Fragment;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface AppletChatInputController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/components/input/AppletChatInputController$ActionBarItemLocation;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_BAR", "DETAIL_PANEL", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionBarItemLocation extends Enum<ActionBarItemLocation> {
        public static final ActionBarItemLocation DETAIL_PANEL = null;
        public static final ActionBarItemLocation PRIMARY_BAR = null;
        public static final /* synthetic */ ActionBarItemLocation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ActionBarItemLocation> getEntries() {
            return b;
        }

        static {
            ActionBarItemLocation r0 = new ActionBarItemLocation("PRIMARY_BAR", 0);
            PRIMARY_BAR = r0;
            ActionBarItemLocation r1 = new ActionBarItemLocation("DETAIL_PANEL", 1);
            DETAIL_PANEL = r1;
            ActionBarItemLocation[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static ActionBarItemLocation[] values() {
            return (ActionBarItemLocation[]) a.clone();
        }

        public static ActionBarItemLocation valueOf(String r1) {
            return (ActionBarItemLocation) r27.a.a(ActionBarItemLocation.class, r1);
        }

        public ActionBarItemLocation(String r1, int r10) {
            super(r1, r10);
        }
    }

    public interface a {
        void a(ActionBarItemLocation r1, String r10, int r11);

        void b(ActionBarItemLocation r1, String r10, int r11);
    }

    public interface b {
        String b();

        e c();

        Map<String, String> getExtra();

        Integer getSource();
    }

    public interface c {
        void P0(r2.f r1);
    }

    public static final class d {
        public final boolean a;
        public final boolean b;
        public final String c;
        public final String d;

        public d() {
            this(true, true, null, null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L8;
            return false;
        L8:
            d r11 = (d) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r10 = r0 * 31;
            if (this.b == true) goto L10;
            r1 = 1237;
        L10:
            int r11 = (r10 + r1) * 31;
            String r12 = this.c;
            int r13 = 0;
            if (r12 != null) goto L13;
            int r14 = 0;
        L14:
            int r15 = (r11 + r14) * 31;
            String r16 = this.d;
            if (r16 == null) goto L19;
            r13 = r16.hashCode();
        L19:
            return r15 + r13;
        L13:
            r14 = r12.hashCode();
            goto L14
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(cameraEnabled=" + this.a + ", extraActionsEnabled=" + this.b + ", inputHint=" + this.c + ", speakHint=" + this.d + ')';
        }

        public d(boolean r1, boolean r10, String r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public static final class e {
        public final String a;
        public final String b;
        public final f c;

        public e() {
            this(null, null, null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L8;
            return false;
        L8:
            e r11 = (e) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.b;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            f r15 = this.c;
            if (r15 == null) goto L15;
            r1 = r15.hashCode();
        L15:
            return r14 + r1;
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "GuiContext(artifactType=" + this.a + ", uri=" + this.b + ", view=" + this.c + ')';
        }

        public e(String r1, String r10, f r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public static final class f {
        public final String a;

        public f() {
            this(null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r10).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "GuiView(bizPayload=" + this.a + ')';
        }

        public f(String r1) {
            this.a = r1;
        }
    }

    public interface g {
        void A0(String r1, String r10);

        void L(String r1);

        void M0(String r1);

        void t();

        void y();
    }

    void A7(AppletFullScreenActivity.b r1);

    void I1(boolean r1, boolean r10);

    Fragment getFragment();

    boolean getVisibility();

    void q7(String r1);

    void r7(AppletModelContextProvider r1);

    void s7(c r1);

    void setVisibility(boolean r1);

    void t7();

    r2.f u6();

    void u7(g r1);

    void v7(r2.c r1);

    void w7(c r1);

    void x7(String r1, String r10);

    void y7(d r1);

    void z7(g r1);
}
