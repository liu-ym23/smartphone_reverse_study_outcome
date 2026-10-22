package v29;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final Set<String> a = null;

    public static final class a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
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
            return "OptionalValue(value=" + this.a + ')';
        }

        public a(String r1) {
            this.a = r1;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"conversation_id", "message_id", "bot_id", DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM});
    }

    public static Uri a(ContextWindowEntryRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        if (b(r4.a) == true) goto L5;
        return null;
    L5:
        String r0 = r4.b;
        boolean r2 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        return null;
    L14:
        String r3 = r4.c;
        if (r3 != null) goto L17;
    L18:
        r2 = true;
    L19:
        if (r2 == true) goto L22;
        return null;
    L22:
        if (r4.d.getWireValue().length() <= 32) goto L24;
        return null;
    L24:
        Uri.Builder r5 = new Uri.Builder().scheme("sslocal").authority("flow").path("/context_window_usage").appendQueryParameter("conversation_id", r4.a);
        String r6 = r4.b;
        if (r6 == null) goto L27;
        r5.appendQueryParameter("message_id", r6);
    L27:
        String r7 = r4.c;
        if (r7 == null) goto L31;
        r5.appendQueryParameter("bot_id", r7);
    L31:
        return r5.appendQueryParameter(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r4.d.getWireValue()).build();
    L17:
        if (b(r3) == false) goto L19;
    L8:
        if (b(r0) == true) goto L11;
        r1 = false;
        goto L12
    }

    public static boolean b(String r2) {
        if ((!StringsKt.isBlank(r2)) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.length() > 128) goto L7;
        return true;
    }

    public static ContextWindowEntryRequest d(Uri r12) {
        Intrinsics.checkNotNullParameter(r12, "uri");
        if (r12.isHierarchical() == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r12.getScheme(), "sslocal") == true) goto L8;
    L80:
        return null;
    L8:
        if (Intrinsics.areEqual(r12.getHost(), "flow") == false) goto L80;
        if (Intrinsics.areEqual(r12.getPath(), "/context_window_usage") == false) goto L80;
        if (r12.getUserInfo() != null) goto L80;
        if (r12.getPort() != (-1)) goto L80;
        if (r12.getFragment() != null) goto L80;
        Set r0 = UriProtector.getQueryParameterNames(r12);
        Set<String> r2 = a;
        Intrinsics.checkNotNull(r0);
        if (r2.containsAll(r0) == true) goto L22;
        return null;
    L22:
        Set r3 = r0;
        boolean r4 = true;
        int r5 = 0;
        if ((r3 instanceof Collection) == true) goto L25;
    L27:
        Iterator r6 = r3.iterator();
    L29:
        if (r6.hasNext() == false) goto L36;
        if (UriProtector.getQueryParameters(r12, (String) r6.next()).size() == 1) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == false) goto L29;
        boolean r8 = true;
    L37:
        if (r8 == false) goto L39;
        return null;
    L39:
        String r9 = UriProtector.getQueryParameter(r12, "conversation_id");
        if (r9 == null) goto L80;
        if (b(r9) == false) goto L44;
        String r10 = r9;
    L45:
        if (r10 == null) goto L80;
        a r11 = c(r12, r0, "message_id");
        if (r11 != null) goto L49;
        return null;
    L49:
        a r13 = c(r12, r0, "bot_id");
        if (r13 != null) goto L53;
        return null;
    L53:
        if (r0.contains(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM) == false) goto L68;
        String r14 = UriProtector.getQueryParameter(r12, DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM);
        if (r14 != null) goto L57;
    L67:
        return null;
    L57:
        if ((!StringsKt.isBlank(r14)) == true) goto L59;
    L61:
        r4 = false;
    L62:
        if (r4 == true) goto L65;
        r14 = null;
    L65:
        if (r14 == null) goto L67;
    L69:
        ContextWindowEnterFrom[] r1 = ContextWindowEnterFrom.values();
        int r15 = r1.length;
    L70:
        if (r5 >= r15) goto L75;
        ContextWindowEnterFrom r16 = r1[r5];
        if (Intrinsics.areEqual(r16.getWireValue(), r14) == true) goto L73;
        r5 = r5 + 1;
        goto L70
    L73:
        ContextWindowEnterFrom r17 = r16;
    L76:
        if (r17 != null) goto L79;
        return null;
    L79:
        return new ContextWindowEntryRequest(r10, r11.a, r13.a, r17, ContextWindowContainer.NATIVE_ROUTE);
    L75:
        r17 = null;
        goto L76
    L59:
        if (r14.length() > 32) goto L61;
    L68:
        r14 = ContextWindowEnterFrom.UNKNOWN.getWireValue();
        goto L69
    L44:
        r10 = null;
        goto L45
    L33:
        r7 = false;
    L36:
        r8 = false;
        goto L37
    L25:
        if (r3.isEmpty() == false) goto L27;
        goto L27
    }

    public static a c(Uri r1, Set r2, String r3) {
        if (r2.contains(r3) == false) goto L5;
        String r4 = UriProtector.getQueryParameter(r1, r3);
        if (r4 != null) goto L9;
    L15:
        return null;
    L9:
        if (b(r4) == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L15;
        return new a(r4);
    L5:
        return new a(null);
    }
}
