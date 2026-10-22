package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufMessageDefinitions;
import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.config.b4;
import com.bytedance.android.livesdk.config.c4;
import com.bytedance.android.livesdk.config.fj0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PrefetchNetworkExecutorImpl implements com.bytedance.ies.tools.prefetch.i {

    public static abstract class MultiFormatResponse extends com.bytedance.ies.tools.prefetch.i.b {
        public final Lazy g;
        public final JSONObject h;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/prefetch/PrefetchNetworkExecutorImpl$MultiFormatResponse$Format;", "", "JSON", "Protobuf", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Format extends Enum<Format> {
            public static final Format JSON = null;
            public static final Format Protobuf = null;
            public static final /* synthetic */ Format[] a = null;

            static {
                Format r1 = new Format("JSON", 0);
                JSON = r1;
                Format r2 = new Format("Protobuf", 1);
                Protobuf = r2;
                a = new Format[]{r1, r2};
            }

            public static Format valueOf(String r1) {
                return (Format) r27.a.a(Format.class, r1);
            }

            public static Format[] values() {
                return (Format[]) a.clone();
            }

            public Format(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final class a extends MultiFormatResponse {
            public final Format i;

            @Override // com.bytedance.android.live.browser.jsbridge.prefetch.PrefetchNetworkExecutorImpl.MultiFormatResponse
            public final Format c() {
                return this.i;
            }

            public a(JSONObject r2) {
                Intrinsics.checkNotNullParameter(r2, "raw");
                super(r2);
                this.i = Format.JSON;
            }
        }

        public static final class b extends MultiFormatResponse {
            public final Format i;

            @Override // com.bytedance.android.live.browser.jsbridge.prefetch.PrefetchNetworkExecutorImpl.MultiFormatResponse
            public final Format c() {
                return this.i;
            }

            public b(JSONObject r2) {
                Intrinsics.checkNotNullParameter(r2, "raw");
                super(r2);
                this.i = Format.Protobuf;
            }
        }

        public abstract Format c();

        public final String toString() {
            return "PrefetchResponse: { format: " + c() + ", status_code: " + ((com.bytedance.ies.tools.prefetch.i.b) this).d + ", data: " + this.h + ", cached: " + ((com.bytedance.ies.tools.prefetch.i.b) this).f + " }";
        }

        public MultiFormatResponse(JSONObject r1) {
            this.h = r1;
            this.g = LazyKt.lazy(new PrefetchNetworkExecutorImpl$MultiFormatResponse$decoded$2(this));
        }
    }

    public PrefetchNetworkExecutorImpl() {
    }

    public static final LinkedList d(PrefetchNetworkExecutorImpl r3, Map r4) {
        r3.getClass();
        LinkedList r5 = new LinkedList();
        Iterator r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r6.next();
        r5.add(new NameValuePair((String) r0.getKey(), (String) r0.getValue()));
        goto L4
    L6:
        return r5;
    }

    public static final Map c(PrefetchNetworkExecutorImpl r0, Map r1, Map r2, boolean r3) {
        r0.getClass();
        if (r3 == false) goto L5;
        return r1;
    L5:
        if (r2 == null) goto L7;
        String r4 = (String) r2.get("response-format");
    L9:
        if (Intrinsics.areEqual(r4, "protobuf") == true) goto L11;
        return r1;
    L11:
        if (((Boolean) b4.a.getValue()).booleanValue() == true) goto L13;
        return r1;
    L13:
        return MapsKt.plus(r1, TuplesKt.to("response-format", "protobuf"));
    L7:
        r4 = null;
        goto L9
    }

    public final void a(String r7, Map r8, Map r9, ProcessManager.b r11) {
        Intrinsics.checkNotNullParameter(r7, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r8, "headers");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (r9 != null) goto L5;
        r9 = MapsKt.emptyMap();
    L5:
        Map r4 = r9;
        int r12 = com.bytedance.android.live.browser.jsbridge.protobuf.a.c;
        String r13 = (String) r4.get("channel");
        ExternalProtobufMessageDefinitions.Companion r0 = ExternalProtobufMessageDefinitions.b;
        com.bytedance.android.live.browser.jsbridge.protobuf.a r1 = null;
        if (r13 == null) goto L8;
        Object r2 = r0.a.get(r13);
    L9:
        ExternalProtobufShrinkConfigs.Companion r3 = ExternalProtobufShrinkConfigs.b;
        if (r13 == null) goto L12;
        Object r14 = r3.a.get(r13);
    L13:
        if (r2 == null) goto L16;
        if (r14 == null) goto L16;
        r1 = new com.bytedance.android.live.browser.jsbridge.protobuf.a((ExternalProtobufMessageDefinitions) r2, (ExternalProtobufShrinkConfigs) r14);
    L16:
        Observable r15 = Observable.fromCallable(new k(this, r7, r8, r4, r1)).subscribeOn(Schedulers.io());
        if (((Boolean) fj0.a.getValue()).booleanValue() == true) goto L20;
        r15 = r15.observeOn(AndroidSchedulers.mainThread());
    L20:
        r15.subscribe(new l(r11), new m(r11));
        return;
    L12:
        r3.getClass();
        r14 = null;
        goto L13
    L8:
        r0.getClass();
        r2 = null;
        goto L9
    }

    public static final MultiFormatResponse e(PrefetchNetworkExecutorImpl r16, HttpResponse r17, String r18, Map r19, com.bytedance.android.live.browser.jsbridge.protobuf.a r21) {
        r16.getClass();
        List r2 = r17.getHeaders();
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L26;
        NameValuePair r4 = (NameValuePair) r3.next();
        String r6 = r4.getName();
        Locale r7 = Locale.getDefault();
        if (r6 == null) goto L25;
        if (Intrinsics.areEqual(r6.toLowerCase(r7), "content-type") == false) goto L21;
        String r5 = r4.getValue();
        Locale r8 = Locale.getDefault();
        if (r5 == null) goto L20;
        if (Intrinsics.areEqual(r5.toLowerCase(r8), "application/x-protobuf") == false) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L9;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L99;
        Object r12 = r19.get("data_message_name");
        if (r12 == null) goto L98;
        String r13 = (String) r12;
        String r14 = (String) r19.get("extra_message_name");
        c4 r15 = c4.a;
        if (((Boolean) r15.getValue()).booleanValue() == false) goto L33;
        String r22 = (String) r19.get("data_shrink_config");
    L35:
        if (((Boolean) r15.getValue()).booleanValue() == false) goto L37;
        String r0 = (String) r19.get("extra_shrink_config");
    L38:
        if (r21 == null) goto L96;
        byte[] r23 = r17.getBody();
        Intrinsics.checkNotNullParameter(r23, "body");
        Intrinsics.checkNotNullParameter(r13, "dataMessageName");
        JSONObject r24 = new JSONObject();
        am3.g r110 = new am3.g();
        r110.k(new am3.b(r23));
        ho0.b r25 = ho0.b.a(r110);
        r24.put("status_code", r25.header.a);
        if (r25.header.a != 0) goto L77;
        ExternalProtobufMessageDefinitions.Message r111 = r21.a.a(r13);
        if (r111 == null) goto L76;
        JSONObject r26 = new JSONObject();
        r26.put("now", r25.header.e);
        r24.put("extra", r26);
        byte[] r27 = r25.body;
        if (r27 == null) goto L94;
        r110.k(new am3.b(r27));
        long r28 = r110.c();
    L46:
        int r29 = r110.f();
        if (r29 == (-1)) goto L48;
        if (r29 != 1) goto L52;
        ExternalProtobufShrinkConfigs r31 = r21.b;
        if (r22 == null) goto L70;
        ExternalProtobufShrinkConfigs.Config r32 = (ExternalProtobufShrinkConfigs.Config) ((LinkedHashMap) r31.a).get(r22);
    L71:
        r24.put("data", r21.b(r111, r110, r32));
    L72:
        boolean r33 = true;
    L73:
        if (r33 == true) goto L46;
        am3.h.e(r110);
        goto L46
    L70:
        r31.getClass();
        r32 = null;
        goto L71
    L52:
        if (r29 != 2) goto L66;
        if (r14 == null) goto L56;
        ExternalProtobufMessageDefinitions.Message r34 = r21.a.a(r14);
    L57:
        if (r34 == null) goto L66;
        ExternalProtobufShrinkConfigs r112 = r21.b;
        if (r0 == null) goto L61;
        ExternalProtobufShrinkConfigs.Config r113 = (ExternalProtobufShrinkConfigs.Config) ((LinkedHashMap) r112.a).get(r0);
    L62:
        JSONObject r35 = r21.b(r34, r110, r113);
        Iterator<String> r114 = r35.keys();
    L64:
        if (r114.hasNext() == false) goto L72;
        String r115 = r114.next();
        r26.put(r115, r35.get(r115));
        goto L64
    L61:
        r112.getClass();
        r113 = null;
        goto L62
    L56:
        r34 = null;
    L66:
        r33 = false;
        goto L73
    L48:
        r110.d(r28);
    L94:
        MultiFormatResponse r1 = new MultiFormatResponse.b(r24);
    L100:
        ((com.bytedance.ies.tools.prefetch.i.b) r1).a = r17.getBody();
        ((com.bytedance.ies.tools.prefetch.i.b) r1).d = r17.getStatusCode();
        return r1;
    L76:
        throw new IllegalArgumentException(("data message [" + r13 + "] definition not found").toString());
    L77:
        JSONObject r36 = new JSONObject();
        r36.put("message", r25.header.b);
        r36.put("prompts", r25.header.c);
        r36.put("alert", r25.header.d);
        Unit r37 = Unit.INSTANCE;
        r24.put("data", r36);
        JSONObject r38 = new JSONObject();
        r38.put("now", r25.header.e);
        r24.put("extra", r38);
        if (r14 == null) goto L80;
        ExternalProtobufMessageDefinitions.Message r39 = r21.a.a(r14);
    L81:
        String r41 = r25.header.f;
        if (r39 == null) goto L94;
        if (r41 != null) goto L85;
    L88:
        boolean r42 = true;
    L89:
        if (r42 == true) goto L94;
        JSONObject r43 = new JSONObject(r41);
        Iterator<String> r44 = r43.keys();
    L92:
        if (r44.hasNext() == false) goto L94;
        String r45 = r44.next();
        r38.put(r45, r43.get(r45));
        goto L92
    L85:
        if (r41.length() == 0) goto L88;
        r42 = false;
        goto L89
    L80:
        r39 = null;
        goto L81
    L96:
        throw new IllegalArgumentException("Decoder shouldn't be null".toString());
    L37:
        r0 = null;
        goto L38
    L33:
        r22 = null;
        goto L35
    L98:
        throw new IllegalArgumentException(("[data_message_name] is required for pb prefetch. please complete prefetch config. url: " + r18).toString());
    L99:
        r1 = new MultiFormatResponse.a(new JSONObject(new String(r17.getBody(), Charsets.UTF_8)));
        goto L100
    L20:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        r9 = false;
        goto L22
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L26:
        r11 = false;
        goto L27
    L5:
        if (r2.isEmpty() == false) goto L7;
        goto L7
    }

    public final void b(String r8, Map r9, String r11, JSONObject r12, Map r13, ProcessManager.b r14) {
        Intrinsics.checkNotNullParameter(r8, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r9, "headers");
        Intrinsics.checkNotNullParameter(r11, "mimeType");
        Intrinsics.checkNotNullParameter(r12, "body");
        Intrinsics.checkNotNullParameter(r14, "callback");
        if (r13 != null) goto L5;
        r13 = MapsKt.emptyMap();
    L5:
        Map r4 = r13;
        int r15 = com.bytedance.android.live.browser.jsbridge.protobuf.a.c;
        String r16 = (String) r4.get("channel");
        ExternalProtobufMessageDefinitions.Companion r17 = ExternalProtobufMessageDefinitions.b;
        com.bytedance.android.live.browser.jsbridge.protobuf.a r0 = null;
        if (r16 == null) goto L8;
        Object r18 = r17.a.get(r16);
    L9:
        ExternalProtobufShrinkConfigs.Companion r1 = ExternalProtobufShrinkConfigs.b;
        if (r16 == null) goto L12;
        Object r19 = r1.a.get(r16);
    L13:
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        r0 = new com.bytedance.android.live.browser.jsbridge.protobuf.a((ExternalProtobufMessageDefinitions) r18, (ExternalProtobufShrinkConfigs) r19);
    L16:
        Observable r21 = Observable.fromCallable(new n(this, r8, r9, r4, r0, r12)).subscribeOn(Schedulers.io());
        if (((Boolean) fj0.a.getValue()).booleanValue() == true) goto L20;
        r21 = r21.observeOn(AndroidSchedulers.mainThread());
    L20:
        r21.subscribe(new o(r14), new p(r14));
        return;
    L12:
        r1.getClass();
        r19 = null;
        goto L13
    L8:
        r17.getClass();
        r18 = null;
        goto L9
    }
}
