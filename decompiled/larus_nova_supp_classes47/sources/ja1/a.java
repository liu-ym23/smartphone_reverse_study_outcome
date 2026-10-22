package ja1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.schema.helper.g;
import com.bytedance.android.live.schema.helper.h;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final List<ja1.b> a;

    /* JADX INFO: renamed from: ja1.a$a, reason: collision with other inner class name */
    public static final class C0257a implements ja1.b {
        public final Bundle a;

        public C0257a(Bundle r1) {
            this.a = r1;
        }

        @Override // ja1.b
        public final boolean a(String r2) {
            Bundle r0 = this.a;
            if (r0 == null) goto L5;
            Object r3 = r0.get(r2);
        L6:
            if (r3 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r3 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ja1.b
        public final <O> O b(String r4, O r5) {
        L43:
            e = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("HybridParsing", e);
            com.bytedance.android.live.schema.api.utils.a.b("HybridParsing", "type is error " + r5, null);
            return r5;
        L4:
            if ((r5 instanceof Integer) == false) goto L22;
            Bundle r1 = this.a;     // Catch: Exception -> L43
            if (r1 == null) goto L8;
            Object r2 = r1.get(r4);     // Catch: Exception -> L43
        L10:
            if ((r2 instanceof Boolean) == true) goto L12;
            Bundle r3 = this.a;     // Catch: Exception -> L43
            if (r3 != null) goto L20;
            return null;
        L20:
            return (O) Integer.valueOf(r3.getInt(r4, ((Number) r5).intValue()));
        L12:
            if (this.a.getBoolean(r4) == false) goto L14;
            int r6 = 1;
        L16:
            return (O) Integer.valueOf(r6);
        L14:
            r6 = 0;
            goto L16
        L8:
            r2 = null;
            goto L10
        L22:
            if ((r5 instanceof Boolean) == false) goto L28;
            Bundle r7 = this.a;     // Catch: Exception -> L43
            if (r7 != null) goto L26;
            return null;
        L26:
            return (O) Boolean.valueOf(r7.getBoolean(r4, ((Boolean) r5).booleanValue()));
        L28:
            if ((r5 instanceof String) == false) goto L34;
            Bundle r8 = this.a;     // Catch: Exception -> L43
            if (r8 != null) goto L32;
            return null;
        L32:
            return (O) r8.getString(r4, (String) r5);
        L34:
            if ((r5 instanceof Float) == false) goto L39;
            Bundle r9 = this.a;     // Catch: Exception -> L43
            if (r9 != null) goto L38;
            return null;
        L38:
            return (O) Float.valueOf(r9.getFloat(r4, ((Number) r5).floatValue()));
        L39:
            Bundle r10 = this.a;     // Catch: Exception -> L43
            if (r10 != null) goto L42;
            return null;
        L42:
            return (O) r10.get(r4);
        }
    }

    public static final class b implements ja1.b {
        public final Map<String, String> a;

        public b(Uri r1) {
            this.a = h.a(r1);
        }

        @Override // ja1.b
        public final boolean a(String r4) {
            Map<String, String> r0 = this.a;
            if (r0 == null) goto L16;
        L8:
            th = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        L10:
            boolean r5 = false;
        L11:
            if (r5 == false) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L10;
            r5 = ((HashMap) r0).containsKey(r4);     // Catch: Throwable -> L8
            goto L11
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ja1.b
        public final <O> O b(String r3, O r4) {
            if ((r4 instanceof Integer) == false) goto L11;
            String r5 = g.a(this.a, r3);
            int r6 = ((Number) r4).intValue();
            if (r5 == null) goto L9;
            r6 = CastIntegerProtector.parseInt(r5);     // Catch: Throwable -> L30
        L9:
            return (O) Integer.valueOf(r6);
        L11:
            if ((r4 instanceof Boolean) == false) goto L15;
            return (O) d5.a(g.a(this.a, r3), ((Boolean) r4).booleanValue());
        L15:
            if ((r4 instanceof String) == false) goto L19;
            return (O) g.a(this.a, r3);
        L19:
            if ((r4 instanceof Float) == false) goto L25;
            String r7 = g.a(this.a, r3);
            float r8 = ((Number) r4).floatValue();
            r8 = CastFloatProtector.parseFloat(r7);     // Catch: Throwable -> L31
        L23:
            return (O) Float.valueOf(r8);
        L25:
            if ((r4 instanceof Long) == true) goto L27;
            com.bytedance.android.live.schema.api.utils.a.b("HybridParsing", "type is error " + r4, null);
            return r4;
        L27:
            return (O) Long.valueOf(d5.c(g.a(this.a, r3)));
        }
    }

    public static final class c implements ja1.b {
        public final Map<String, String> a;

        public c(String r2) {
            if (TextUtils.isEmpty(r2) == false) goto L12;
        L9:
            Uri r3 = null;
        L10:
            this.a = h.a(r3);
            return;
        L12:
            r3 = UriProtector.parse(r2);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
            goto L9
        }

        @Override // ja1.b
        public final boolean a(String r4) {
            Map<String, String> r0 = this.a;
            if (r0 == null) goto L16;
        L8:
            th = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        L10:
            boolean r5 = false;
        L11:
            if (r5 == false) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L10;
            r5 = ((HashMap) r0).containsKey(r4);     // Catch: Throwable -> L8
            goto L11
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ja1.b
        public final <O> O b(String r3, O r4) {
            if ((r4 instanceof Integer) == false) goto L11;
            String r5 = g.a(this.a, r3);
            int r6 = ((Number) r4).intValue();
            if (r5 == null) goto L9;
            r6 = CastIntegerProtector.parseInt(r5);     // Catch: Throwable -> L20
        L9:
            return (O) Integer.valueOf(r6);
        L11:
            if ((r4 instanceof Boolean) == false) goto L15;
            return (O) d5.a(g.a(this.a, r3), ((Boolean) r4).booleanValue());
        L15:
            if ((r4 instanceof String) == true) goto L17;
            com.bytedance.android.live.schema.api.utils.a.b("HybridParsing", "type is error " + r4, null);
            return r4;
        L17:
            return (O) g.a(this.a, r3);
        }
    }

    public final <O> O a(String r4, O r5) {
        List<ja1.b> r0 = this.a;
        if (r0 != null) goto L5;
    L14:
        return r5;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L14;
        Iterator r1 = ((ArrayList) this.a).iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        ja1.b r2 = (ja1.b) r1.next();
        if (r2.a(r4) == false) goto L9;
        return (O) r2.b(r4, r5);
    }

    public a(Uri r3, String r4, Bundle r5) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.add(new c(r4));
        r0.add(new b(r3));
        r0.add(new C0257a(r5));
    }
}
