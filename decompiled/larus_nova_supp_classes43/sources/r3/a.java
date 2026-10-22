package r3;

import com.bytedance.ai.applet.components.input.AppletChatActionBarCapability;
import com.bytedance.ai.bridge.doubao.chat.AbsSetChatActionBarMethodIDL;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Set<String> a;

    /* JADX INFO: renamed from: r3.a$a, reason: collision with other inner class name */
    public static final class C0189a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ParsedIcon(light=" + this.a + ", dark=" + this.b + ')';
        }

        public b(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "light");
            Intrinsics.checkNotNullParameter(r11, "dark");
            this.a = r10;
            this.b = r11;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[AbsSetChatActionBarMethodIDL.ChatActionBarItemKind.values().length];
            r0[AbsSetChatActionBarMethodIDL.ChatActionBarItemKind.ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[AbsSetChatActionBarMethodIDL.ChatActionBarItemKind.ACTION_GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            a = r0;
            int[] r1 = new int[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.values().length];
            r1[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.SEND_PROMPT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L39:
            r1[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.OPEN_SCHEMA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L33:
            r1[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.OPEN_CAPABILITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L11:
            b = r1;
            int[] r10 = new int[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.values().length];
            r10[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.OPEN_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r10[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.MUSIC_GENERATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r10[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.IMAGE_GENERATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            c = r10;
        }
    }

    static {
    }

    public a() {
        this.a = new LinkedHashSet();
    }

    public final void c(String r10) {
        if ((!StringsKt.isBlank(r10)) == false) goto L10;
        if (this.a.add(r10) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("item id " + r10 + " is duplicated").toString());
    L10:
        throw new IllegalArgumentException("item id is empty".toString());
    }

    public static r2.a a(AbsSetChatActionBarMethodIDL.ChatActionBarAction r10, String r11) {
        boolean r0 = false;
        if (r10 == null) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L74;
        int r13 = c.b[r10.getType().ordinal()];
        if (r13 == 1) goto L59;
        if (r13 == 2) goto L45;
        if (r13 != 3) goto L43;
        if (r10.getPrompt() != null) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L41;
        if (r10.getSchema() != null) goto L21;
        r0 = true;
    L21:
        if (r0 == false) goto L39;
        AbsSetChatActionBarMethodIDL.ChatActionBarCapability r15 = r10.getCapability();
        if (r15 != null) goto L25;
        int r16 = -1;
    L26:
        if (r16 == (-1)) goto L37;
        if (r16 == 1) goto L34;
        if (r16 == 2) goto L33;
        if (r16 != 3) goto L32;
        AppletChatActionBarCapability r17 = AppletChatActionBarCapability.IMAGE_GENERATION;
    L75:
        return new r2.a.C0187a(r17);
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r17 = AppletChatActionBarCapability.MUSIC_GENERATION;
        goto L75
    L34:
        r17 = AppletChatActionBarCapability.OPEN_CAMERA;
        goto L75
    L37:
        throw new IllegalArgumentException(r11 + " action.capability is empty");
    L25:
        r16 = c.c[r15.ordinal()];
        goto L26
    L39:
        throw new IllegalArgumentException((r11 + " action.schema must be empty").toString());
    L41:
        throw new IllegalArgumentException((r11 + " action.prompt must be empty").toString());
    L16:
        r14 = false;
        goto L17
    L43:
        throw new NoWhenBranchMatchedException();
    L45:
        if (r10.getPrompt() != null) goto L47;
        boolean r18 = true;
    L48:
        if (r18 == false) goto L57;
        if (r10.getCapability() != null) goto L52;
        r0 = true;
    L52:
        if (r0 == false) goto L55;
        return new r2.a.b(d(r10.getSchema(), r11 + " action.schema is empty"));
    L55:
        throw new IllegalArgumentException((r11 + " action.capability must be empty").toString());
    L57:
        throw new IllegalArgumentException((r11 + " action.prompt must be empty").toString());
    L47:
        r18 = false;
        goto L48
    L59:
        if (r10.getSchema() != null) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L72;
        if (r10.getCapability() != null) goto L66;
        r0 = true;
    L66:
        if (r0 == false) goto L70;
        return new r2.a.c(d(r10.getPrompt(), r11 + " action.prompt is empty"));
    L70:
        throw new IllegalArgumentException((r11 + " action.capability must be empty").toString());
    L72:
        throw new IllegalArgumentException((r11 + " action.schema must be empty").toString());
    L61:
        r19 = false;
        goto L62
    L74:
        throw new IllegalArgumentException((r11 + " action is empty").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static b b(AbsSetChatActionBarMethodIDL.ChatActionBarIcon r10, String r11) {
        return new b(d(r10.getLight(), r11 + " icon.light is empty"), d(r10.getDark(), r11 + " icon.dark is empty"));
    }

    public static String d(String r10, String r11) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((true ^ r1) == false) goto L15;
        if (r10 != null) goto L16;
        return "";
    L16:
        return r10;
    L15:
        throw new IllegalArgumentException(r11.toString());
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L10
    }
}
