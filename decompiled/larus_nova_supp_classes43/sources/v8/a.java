package v8;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.annie.scheme.helper.LiveSchemaUtil;
import com.bytedance.android.annie.util.l;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final List<v8.b> a;

    /* JADX INFO: renamed from: v8.a$a, reason: collision with other inner class name */
    public static final class C0206a implements v8.b {
        public final Bundle a;

        public C0206a(Bundle r1) {
            this.a = r1;
        }

        @Override // v8.b
        public final boolean a(String r10) {
            Bundle r0 = this.a;
            if (r0 == null) goto L5;
            Object r11 = r0.get(r10);
        L6:
            if (r11 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r11 = null;
            goto L6
        }

        @Override // v8.b
        public final boolean d(String r1) {
            return a(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O b(String r10, O r11) {
        L43:
            e = move-exception;
            x8.a.c("HybridParsing", e, false);
            x8.a.b("HybridParsing", "type is error " + r11, false);
            return r11;
        L4:
            if ((r11 instanceof Integer) == false) goto L22;
            Bundle r1 = this.a;     // Catch: Exception -> L43
            if (r1 == null) goto L8;
            Object r12 = r1.get(r10);     // Catch: Exception -> L43
        L10:
            if ((r12 instanceof Boolean) == true) goto L12;
            Bundle r13 = this.a;     // Catch: Exception -> L43
            if (r13 != null) goto L20;
            return null;
        L20:
            return (O) Integer.valueOf(r13.getInt(r10, ((Number) r11).intValue()));
        L12:
            if (this.a.getBoolean(r10) == false) goto L14;
            int r14 = 1;
        L16:
            return (O) Integer.valueOf(r14);
        L14:
            r14 = 0;
            goto L16
        L8:
            r12 = null;
            goto L10
        L22:
            if ((r11 instanceof Boolean) == false) goto L28;
            Bundle r15 = this.a;     // Catch: Exception -> L43
            if (r15 != null) goto L26;
            return null;
        L26:
            return (O) Boolean.valueOf(r15.getBoolean(r10, ((Boolean) r11).booleanValue()));
        L28:
            if ((r11 instanceof String) == false) goto L34;
            Bundle r16 = this.a;     // Catch: Exception -> L43
            if (r16 != null) goto L32;
            return null;
        L32:
            return (O) r16.getString(r10, (String) r11);
        L34:
            if ((r11 instanceof Float) == false) goto L39;
            Bundle r17 = this.a;     // Catch: Exception -> L43
            if (r17 != null) goto L38;
            return null;
        L38:
            return (O) Float.valueOf(r17.getFloat(r10, ((Number) r11).floatValue()));
        L39:
            Bundle r18 = this.a;     // Catch: Exception -> L43
            if (r18 != null) goto L42;
            return null;
        L42:
            return (O) r18.get(r10);
        }

        @Override // v8.b
        public final <O> O c(String r1, O r10) {
            return (O) b(r1, r10);
        }
    }

    public static final class b implements v8.b {
        public final Uri a;
        public final Map<String, String> b;

        public b(Uri r10) {
            this.a = r10;
            if (LiveSchemaUtil.a() == false) goto L6;
            this.b = com.bytedance.android.annie.scheme.helper.c.a(r10);
            return;
        }

        @Override // v8.b
        public final boolean a(String r10) {
            Uri r0 = this.a;
            if (r0 != null) goto L16;
            return false;
        L16:
        L11:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L10:
            boolean r11 = false;
        L13:
            if (r11 == false) goto L19;
            return true;
        L19:
            return false;
        L6:
            if (TextUtils.isEmpty(r10) == true) goto L10;
            if (UriProtector.getQueryParameter(r0, r10) == null) goto L10;
            r11 = true;
            goto L13
        }

        @Override // v8.b
        public final boolean d(String r10) {
            Map<String, String> r0 = this.b;
            if (r0 != null) goto L15;
            return false;
        L15:
        L9:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L11:
            boolean r11 = false;
        L12:
            if (r11 == false) goto L18;
            return true;
        L18:
            return false;
        L6:
            if (TextUtils.isEmpty(r10) == true) goto L11;
            r11 = ((HashMap) r0).containsKey(r10);     // Catch: Throwable -> L9
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O b(String r10, O r11) {
            if ((r11 instanceof Integer) == false) goto L11;
            String r12 = com.bytedance.android.annie.scheme.helper.b.a(this.a, r10);
            int r13 = ((Number) r11).intValue();
            if (r12 == null) goto L9;
            r13 = CastIntegerProtector.parseInt(r12);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r13);
        L11:
            if ((r11 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.a(this.a, r10), ((Boolean) r11).booleanValue());
        L15:
            if ((r11 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.a(this.a, r10);
        L19:
            if ((r11 instanceof Float) == false) goto L25;
            String r14 = com.bytedance.android.annie.scheme.helper.b.a(this.a, r10);
            float r15 = ((Number) r11).floatValue();
            r15 = CastFloatProtector.parseFloat(r14);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r15);
        L25:
            if ((r11 instanceof Long) == true) goto L38;
            int r16 = x8.a.a;
            x8.a.b("HybridParsing", "type is error " + r11, false);
            return r11;
        L38:
            long r17 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.a(this.a, r10));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r17);
        L29:
            r17 = 0;
            goto L31
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O c(String r10, O r11) {
            if ((r11 instanceof Integer) == false) goto L11;
            String r12 = com.bytedance.android.annie.scheme.helper.b.b(this.b, r10);
            int r13 = ((Number) r11).intValue();
            if (r12 == null) goto L9;
            r13 = CastIntegerProtector.parseInt(r12);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r13);
        L11:
            if ((r11 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.b(this.b, r10), ((Boolean) r11).booleanValue());
        L15:
            if ((r11 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.b(this.b, r10);
        L19:
            if ((r11 instanceof Float) == false) goto L25;
            String r14 = com.bytedance.android.annie.scheme.helper.b.b(this.b, r10);
            float r15 = ((Number) r11).floatValue();
            r15 = CastFloatProtector.parseFloat(r14);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r15);
        L25:
            if ((r11 instanceof Long) == true) goto L38;
            int r16 = x8.a.a;
            x8.a.b("HybridParsing", "type is error " + r11, false);
            return r11;
        L38:
            long r17 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.b(this.b, r10));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r17);
        L29:
            r17 = 0;
            goto L31
        }
    }

    public static final class c implements v8.b {
        public final Uri a;
        public final Map<String, String> b;

        public c(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L14;
        L9:
            Uri r11 = null;
        L10:
            this.a = r11;
            if (LiveSchemaUtil.a() == false) goto L16;
            this.b = com.bytedance.android.annie.scheme.helper.c.a(r11);
            return;
        L16:
            return;
        L14:
            r11 = UriProtector.parse(r10);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            int r0 = x8.a.a;
            x8.a.c("ParsingUriParamHelper", th, true);
            goto L9
        }

        @Override // v8.b
        public final boolean a(String r10) {
            Uri r0 = this.a;
            if (r0 != null) goto L16;
            return false;
        L16:
        L11:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L10:
            boolean r11 = false;
        L13:
            if (r11 == false) goto L19;
            return true;
        L19:
            return false;
        L6:
            if (TextUtils.isEmpty(r10) == true) goto L10;
            if (UriProtector.getQueryParameter(r0, r10) == null) goto L10;
            r11 = true;
            goto L13
        }

        @Override // v8.b
        public final boolean d(String r10) {
            Map<String, String> r0 = this.b;
            if (r0 != null) goto L15;
            return false;
        L15:
        L9:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L11:
            boolean r11 = false;
        L12:
            if (r11 == false) goto L18;
            return true;
        L18:
            return false;
        L6:
            if (TextUtils.isEmpty(r10) == true) goto L11;
            r11 = ((HashMap) r0).containsKey(r10);     // Catch: Throwable -> L9
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O b(String r10, O r11) {
            if ((r11 instanceof Integer) == false) goto L11;
            String r12 = com.bytedance.android.annie.scheme.helper.b.a(this.a, r10);
            int r13 = ((Number) r11).intValue();
            if (r12 == null) goto L9;
            r13 = CastIntegerProtector.parseInt(r12);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r13);
        L11:
            if ((r11 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.a(this.a, r10), ((Boolean) r11).booleanValue());
        L15:
            if ((r11 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.a(this.a, r10);
        L19:
            if ((r11 instanceof Float) == false) goto L25;
            String r14 = com.bytedance.android.annie.scheme.helper.b.a(this.a, r10);
            float r15 = ((Number) r11).floatValue();
            r15 = CastFloatProtector.parseFloat(r14);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r15);
        L25:
            if ((r11 instanceof Long) == true) goto L38;
            int r16 = x8.a.a;
            x8.a.b("HybridParsing", "type is error " + r11, false);
            return r11;
        L38:
            long r17 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.a(this.a, r10));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r17);
        L29:
            r17 = 0;
            goto L31
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O c(String r10, O r11) {
            if ((r11 instanceof Integer) == false) goto L11;
            String r12 = com.bytedance.android.annie.scheme.helper.b.b(this.b, r10);
            int r13 = ((Number) r11).intValue();
            if (r12 == null) goto L9;
            r13 = CastIntegerProtector.parseInt(r12);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r13);
        L11:
            if ((r11 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.b(this.b, r10), ((Boolean) r11).booleanValue());
        L15:
            if ((r11 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.b(this.b, r10);
        L19:
            if ((r11 instanceof Float) == false) goto L25;
            String r14 = com.bytedance.android.annie.scheme.helper.b.b(this.b, r10);
            float r15 = ((Number) r11).floatValue();
            r15 = CastFloatProtector.parseFloat(r14);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r15);
        L25:
            if ((r11 instanceof Long) == true) goto L38;
            int r16 = x8.a.a;
            x8.a.b("HybridParsing", "type is error " + r11, false);
            return r11;
        L38:
            long r17 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.b(this.b, r10));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r17);
        L29:
            r17 = 0;
            goto L31
        }
    }

    public static String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (StringsKt.startsWith$default(r10, "#", false, 2, null) == false) goto L6;
        return r10;
    L6:
        if (new Regex("^([a-fA-F\\d]{8}|[a-fA-F\\d]{6}|[a-fA-F\\d]{3})$").matches(r10) == true) goto L8;
        return r10;
    L8:
        return "#" + r10;
    }

    public final <O> O b(String r10, O r11) {
        List<v8.b> r0 = this.a;
        if (r0 != null) goto L5;
    L23:
        return r11;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L23;
        if (LiveSchemaUtil.a() == false) goto L16;
        Iterator r1 = ((ArrayList) this.a).iterator();
    L11:
        if (r1.hasNext() == false) goto L23;
        v8.b r12 = (v8.b) r1.next();
        if (r12.d(r10) == false) goto L11;
        return (O) r12.c(r10, r11);
    L16:
        Iterator r13 = ((ArrayList) this.a).iterator();
    L18:
        if (r13.hasNext() == false) goto L23;
        v8.b r14 = (v8.b) r13.next();
        if (r14.a(r10) == false) goto L18;
        return (O) r14.b(r10, r11);
    }

    public a(Uri r10, String r11, Bundle r12) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.add(new c(r11));
        r0.add(new b(r10));
        r0.add(new C0206a(r12));
    }
}
