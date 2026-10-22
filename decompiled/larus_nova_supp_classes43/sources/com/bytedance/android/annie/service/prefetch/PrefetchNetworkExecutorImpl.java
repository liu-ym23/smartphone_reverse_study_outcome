package com.bytedance.android.annie.service.prefetch;

import android.util.Pair;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PrefetchNetworkExecutorImpl implements com.bytedance.ies.tools.prefetch.i {

    public static abstract class MultiFormatResponse extends com.bytedance.ies.tools.prefetch.i.b {
        public final JSONObject g;
        public final Lazy h;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/service/prefetch/PrefetchNetworkExecutorImpl$MultiFormatResponse$Format;", "", "JSON", "Protobuf", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final enum Format extends Enum<Format> {
            public static final Format JSON = null;
            public static final Format Protobuf = null;
            public static final /* synthetic */ Format[] a = null;

            public static Format valueOf(String r1) {
                return (Format) r27.a.a(Format.class, r1);
            }

            public static Format[] values() {
                return (Format[]) a.clone();
            }

            static {
                Format r0 = new Format("JSON", 0);
                JSON = r0;
                Format r1 = new Format("Protobuf", 1);
                Protobuf = r1;
                a = new Format[]{r0, r1};
            }

            public Format(String r1, int r10) {
                super(r1, r10);
            }
        }

        public static final class a extends MultiFormatResponse {
            public final Format i;

            @Override // com.bytedance.android.annie.service.prefetch.PrefetchNetworkExecutorImpl.MultiFormatResponse
            public final Format c() {
                return this.i;
            }

            public a(JSONObject r10) {
                Intrinsics.checkNotNullParameter(r10, "raw");
                super(r10);
                this.i = Format.JSON;
            }
        }

        public static final class b extends MultiFormatResponse {
            public final Format i;

            @Override // com.bytedance.android.annie.service.prefetch.PrefetchNetworkExecutorImpl.MultiFormatResponse
            public final Format c() {
                return this.i;
            }

            public b(JSONObject r10) {
                Intrinsics.checkNotNullParameter(r10, "raw");
                super(r10);
                this.i = Format.Protobuf;
            }
        }

        public abstract Format c();

        public final String toString() {
            return "PrefetchResponse: { format: " + c() + ", status_code: " + ((com.bytedance.ies.tools.prefetch.i.b) this).d + ", data: " + this.g + ", cached: " + ((com.bytedance.ies.tools.prefetch.i.b) this).f + " }";
        }

        public MultiFormatResponse(JSONObject r1) {
            this.g = r1;
            this.h = LazyKt.lazy(new PrefetchNetworkExecutorImpl$MultiFormatResponse$decoded$2(this));
        }
    }

    public PrefetchNetworkExecutorImpl() {
    }

    public static final List d(PrefetchNetworkExecutorImpl r10, Map r11) {
        r10.getClass();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r13.next();
        r12.add(new Pair(r0.getKey(), r0.getValue()));
        goto L4
    L6:
        return r12;
    }

    public static final Map c(PrefetchNetworkExecutorImpl r0, Map r1, Map r10, boolean r11) {
        r0.getClass();
        if (r11 == false) goto L5;
        return r1;
    L5:
        if (r10 == null) goto L7;
        String r12 = (String) r10.get("response-format");
    L9:
        if (Intrinsics.areEqual(r12, "protobuf") == true) goto L11;
        return r1;
    L11:
        if (AnnieConfigSettingKeys.ENABLE_PB_PREFETCH.a().booleanValue() == true) goto L13;
        return r1;
    L13:
        return MapsKt.plus(r1, TuplesKt.to("response-format", "protobuf"));
    L7:
        r12 = null;
        goto L9
    }

    public final void a(String r10, Map r11, Map r12, ProcessManager.b r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "headers");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r12 != null) goto L5;
        r12 = MapsKt.emptyMap();
    L5:
        Map r14 = r12;
        Observable.fromCallable(new u(this, r10, r11, r14, ((t9.c) Annie.getService$default(t9.c.class, null, 2, null)).w0((String) r14.get("channel")))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new v(r13), new w(r13));
    }

    public static final MultiFormatResponse e(PrefetchNetworkExecutorImpl r10, com.bytedance.android.annie.service.network.d r11, String r12, Map r13, t9.b r14) {
        r10.getClass();
        List<Pair<String, String>> r15 = r11.b;
        boolean r1 = false;
        if ((r15 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L26;
        Pair r0 = (Pair) r16.next();
        String r17 = (String) r0.first;
        Locale r18 = Locale.getDefault();
        if (r17 == null) goto L25;
        if (Intrinsics.areEqual(r17.toLowerCase(r18), "content-type") == false) goto L21;
        String r19 = (String) r0.second;
        Locale r20 = Locale.getDefault();
        if (r19 == null) goto L20;
        if (Intrinsics.areEqual(r19.toLowerCase(r20), "application/x-protobuf") == false) goto L21;
        boolean r21 = true;
    L22:
        if (r21 == false) goto L9;
        r1 = true;
        goto L26
    L20:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        r21 = false;
        goto L22
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L26:
        if (r1 == false) goto L43;
        Object r22 = r13.get("data_message_name");
        if (r22 == null) goto L42;
        String r23 = (String) r22;
        String r24 = (String) r13.get("extra_message_name");
        y9.i<Boolean> r25 = AnnieConfigSettingKeys.ENABLE_PB_PREFETCH_SHRINK;
        if (r25.a().booleanValue() == false) goto L32;
        String r26 = (String) r13.get("data_shrink_config");
    L34:
        if (r25.a().booleanValue() == false) goto L36;
        String r27 = (String) r13.get("extra_shrink_config");
    L37:
        if (r14 == null) goto L40;
        MultiFormatResponse r110 = new MultiFormatResponse.b(r14.c(r11.c, r23, r24, r26, r27, false, false, r12));
    L44:
        ((com.bytedance.ies.tools.prefetch.i.b) r110).a = r11.c;
        ((com.bytedance.ies.tools.prefetch.i.b) r110).d = r11.a;
        return r110;
    L40:
        throw new IllegalArgumentException("Decoder shouldn't be null".toString());
    L36:
        r27 = null;
        goto L37
    L32:
        r26 = null;
        goto L34
    L42:
        throw new IllegalArgumentException(("[data_message_name] is required for pb prefetch. please complete prefetch config. url: " + r12).toString());
    L43:
        r110 = new MultiFormatResponse.a(new JSONObject(new String(r11.c, Charsets.UTF_8)));
        goto L44
    L5:
        if (r15.isEmpty() == false) goto L7;
        goto L7
    }

    public final void b(String r10, Map r11, String r12, JSONObject r13, Map r14, ProcessManager.b r15) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "headers");
        Intrinsics.checkNotNullParameter(r12, "mimeType");
        Intrinsics.checkNotNullParameter(r13, "body");
        Intrinsics.checkNotNullParameter(r15, "callback");
        if (r14 != null) goto L5;
        r14 = MapsKt.emptyMap();
    L5:
        Map r16 = r14;
        Observable.fromCallable(new x(this, r10, r11, r16, ((t9.c) Annie.getService$default(t9.c.class, null, 2, null)).w0((String) r16.get("channel")), r13)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new y(r10, r15), new z(r10, r15));
    }
}
