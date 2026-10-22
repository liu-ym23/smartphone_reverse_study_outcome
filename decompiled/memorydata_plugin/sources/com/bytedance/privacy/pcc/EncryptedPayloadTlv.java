package com.bytedance.privacy.pcc;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EncryptedPayloadTlv {
    private static final Gson e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("meta_info")
    public e f3020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("key_envelope")
    public d f3021b;

    @SerializedName("content_info_meta")
    public b c;

    @SerializedName("sign_content_info")
    public g d;

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.EncryptedPayloadTlv$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ByteArrayBase64Adapter implements JsonDeserializer<byte[]>, JsonSerializer<byte[]> {
        private ByteArrayBase64Adapter() {
        }

        /* synthetic */ ByteArrayBase64Adapter(AnonymousClass1 r1) {
            this();
        }

        public JsonElement a(byte[] r2, Type r3, JsonSerializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            JsonSerializationContext r5 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonSerializationContext.class, "com.obric.memorydata.plugin");
            return new JsonPrimitive(Base64.encodeToString(r2, 2));
        }

        public byte[] a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
            return Base64.decode(r2.getAsString(), 0);
        }

        @Override // com.google.gson.JsonDeserializer
        public /* synthetic */ byte[] deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
            return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.gson.JsonSerializer
        public /* synthetic */ JsonElement serialize(byte[] r3, Type r4, JsonSerializationContext r5) {
            Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
            JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.memorydata.plugin");
            return a((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), r6, r7);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("app_id")
        public String f3022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("app_svc_id")
        public String f3023b;

        @SerializedName("biz_type")
        public int c;

        @SerializedName("session_key_id")
        public byte[] d;

        @SerializedName("access_token")
        public byte[] e;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("content_type")
        public int f3024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("content_encryption_algorithm")
        public int f3025b;

        @SerializedName("other_key_attribute")
        public f c;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("index")
        public int f3026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("key_identify")
        public byte[] f3027b;

        @SerializedName("key_version")
        public int c;

        @SerializedName("key_encryption_algorithm")
        public int d;

        @SerializedName("dh_pk")
        public byte[] e;

        @SerializedName("salt")
        public byte[] f;

        @SerializedName("encrypted_session_key")
        public byte[] g;

        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("version")
        public int f3028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("envelope_type")
        public int f3029b;

        @SerializedName("key_envelope_list_size")
        public int c;

        @SerializedName("key_envelope_list")
        public List<c> d;

        public d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("version")
        public int f3030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("content_type")
        public int f3031b;

        @SerializedName("biz_attribute")
        public a c;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("nonce")
        public byte[] f3032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("chunk_size")
        public int f3033b;

        public f() {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("signature_algorithm")
        public int f3034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("content_signature")
        public byte[] f3035b;

        public g() {
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f3036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3037b;

        h(byte[] r1) {
            this.f3036a = r1;
            this.f3037b = 0;
        }

        boolean a() {
            if (this.f3037b >= this.f3036a.length) goto L5;
            return true;
        L5:
            return false;
        }

        byte[] a(int r5) {
            int r0 = this.f3037b;
            int r1 = r0 + r5;
            byte[] r2 = this.f3036a;
            if (r1 > r2.length) goto L7;
            byte[] r3 = new byte[r5];
            System.arraycopy(r2, r0, r3, 0, r5);
            this.f3037b += r5;
            return r3;
        L7:
            throw new Exception("TLV underflow reading value: need " + r5 + " bytes at offset " + this.f3037b + " but only " + (this.f3036a.length - this.f3037b) + " remain");
        }

        int b() {
            return this.f3037b;
        }

        int c() {
            int r0 = this.f3037b;
            int r1 = r0 + 2;
            byte[] r2 = this.f3036a;
            if (r1 > r2.length) goto L7;
            int r3 = ((r2[r0] & 255) << 8) | (r2[r0 + 1] & 255);
            this.f3037b = r0 + 2;
            return r3;
        L7:
            throw new Exception("TLV underflow reading tag at offset " + this.f3037b);
        }

        int d() {
            int r0 = this.f3037b;
            int r1 = r0 + 4;
            byte[] r2 = this.f3036a;
            if (r1 > r2.length) goto L11;
            int r3 = ((((r2[r0] & 255) << 24) | ((r2[r0 + 1] & 255) << 16)) | ((r2[r0 + 2] & 255) << 8)) | (r2[r0 + 3] & 255);
            if (r3 < 0) goto L9;
            this.f3037b = r0 + 4;
            return r3;
        L9:
            throw new Exception("TLV length overflow at offset " + this.f3037b);
        L11:
            throw new Exception("TLV underflow reading length at offset " + this.f3037b);
        }
    }

    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteArrayOutputStream f3038a;

        private i() {
            this.f3038a = new ByteArrayOutputStream();
        }

        /* synthetic */ i(AnonymousClass1 r1) {
            this();
        }

        private void a(int r3) {
            this.f3038a.write((r3 >> 8) & 255);
            this.f3038a.write(r3 & 255);
        }

        private void b(int r3) {
            this.f3038a.write((r3 >> 24) & 255);
            this.f3038a.write((r3 >> 16) & 255);
            this.f3038a.write((r3 >> 8) & 255);
            this.f3038a.write(r3 & 255);
        }

        void a(int r2, int r3) {
            a(r2);
            b(2);
            this.f3038a.write((r3 >> 8) & 255);
            this.f3038a.write(r3 & 255);
        }

        void a(int r2, byte[] r3) {
            a(r2);
            b(r3.length);
            this.f3038a.write(r3, 0, r3.length);
        }

        byte[] a() {
            return this.f3038a.toByteArray();
        }

        void b(int r2, int r3) {
            a(r2);
            b(4);
            this.f3038a.write((r3 >> 24) & 255);
            this.f3038a.write((r3 >> 16) & 255);
            this.f3038a.write((r3 >> 8) & 255);
            this.f3038a.write(r3 & 255);
        }

        void b(int r2, byte[] r3) {
            a(r2);
            b(r3.length);
            this.f3038a.write(r3, 0, r3.length);
        }
    }

    static {
        e = new GsonBuilder().registerTypeHierarchyAdapter(byte[].class, new ByteArrayBase64Adapter(null)).setPrettyPrinting().create();
    }

    public EncryptedPayloadTlv() {
    }

    public static EncryptedPayloadTlv a(byte[] r4) {
        EncryptedPayloadTlv r0 = new EncryptedPayloadTlv();
        h r1 = new h(r4);
    L4:
        if (r1.a() == false) goto L18;
        int r5 = r1.c();
        byte[] r2 = r1.a(r1.d());
        r1.b();
        if (r5 != 256) goto L8;
        r0.f3020a = b(r2);
        goto L4
    L8:
        if (r5 != 512) goto L10;
        r0.f3021b = d(r2);
        goto L4
    L10:
        if (r5 != 768) goto L12;
        r0.c = f(r2);
        goto L4
    L12:
        if (r5 != 1024) goto L4;
        r0.d = h(r2);
        goto L4
    L18:
        return r0;
    }

    private static void a(byte[] r2, List<c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        h r0 = new h(r2);
    L4:
        if (r0.a() == false) goto L6;
        int r5 = r0.c();
        c r1 = e(r0.a(r0.d()));
        r1.f3026a = r5;
        r4.add(r1);
        goto L4
    }

    private static byte[] a(a r4) {
        i r0 = new i(null);
        if (r4.f3022a == null) goto L6;
        r0.a(1, r4.f3022a.getBytes(StandardCharsets.UTF_8));
    L6:
        if (r4.f3023b == null) goto L8;
        r0.a(2, r4.f3023b.getBytes(StandardCharsets.UTF_8));
    L8:
        r0.a(3, r4.c);
        if (r4.d == null) goto L12;
        r0.a(4, r4.d);
    L12:
        if (r4.e == null) goto L15;
        r0.a(5, r4.e);
    L15:
        return r0.a();
    }

    private static byte[] a(b r3) {
        i r0 = new i(null);
        r0.a(769, r3.f3024a);
        r0.a(770, r3.f3025b);
        if (r3.c == null) goto L6;
        r0.b(771, a(r3.c));
    L6:
        return r0.a();
    }

    private static byte[] a(c r3) {
        i r0 = new i(null);
        if (r3.f3027b == null) goto L5;
        r0.a(1, r3.f3027b);
    L5:
        r0.b(2, r3.c);
        r0.a(3, r3.d);
        if (r3.e == null) goto L9;
        r0.a(4, r3.e);
    L9:
        if (r3.f == null) goto L12;
        r0.a(5, r3.f);
    L12:
        if (r3.g == null) goto L15;
        r0.a(6, r3.g);
    L15:
        return r0.a();
    }

    private static byte[] a(d r5) {
        AnonymousClass1 r1 = null;
        i r0 = new i(r1);
        r0.a(InputDeviceCompat.SOURCE_DPAD, r5.f3028a);
        r0.a(514, r5.f3029b);
        r0.b(515, r5.c);
        if (r5.d == null) goto L12;
        if (r5.d.isEmpty() == true) goto L12;
        i r2 = new i(r1);
        Iterator<c> r6 = r5.d.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin");
        r2.b(r3.f3026a, a(r3));
        goto L8
    L10:
        r0.b(516, r2.a());
    L12:
        return r0.a();
    }

    private static byte[] a(e r3) {
        i r0 = new i(null);
        r0.a(257, r3.f3030a);
        r0.a(258, r3.f3031b);
        if (r3.c == null) goto L6;
        r0.b(259, a(r3.c));
    L6:
        return r0.a();
    }

    private static byte[] a(f r3) {
        i r0 = new i(null);
        if (r3.f3032a == null) goto L6;
        r0.a(1, r3.f3032a);
    L6:
        if (r3.f3033b <= 0) goto L9;
        r0.b(2, r3.f3033b);
    L9:
        return r0.a();
    }

    private static byte[] a(g r3) {
        i r0 = new i(null);
        r0.a(InputDeviceCompat.SOURCE_GAMEPAD, r3.f3034a);
        if (r3.f3035b == null) goto L6;
        r0.a(1026, r3.f3035b);
    L6:
        return r0.a();
    }

    private static e b(byte[] r3) {
        e r0 = new e();
        h r1 = new h(r3);
    L4:
        if (r1.a() == false) goto L11;
        int r4 = r1.c();
        byte[] r2 = r1.a(r1.d());
        switch(r4) {
            case 257: goto L10;
            case 258: goto L9;
            case 259: goto L8;
            default: goto L4;
        };
    L8:
        r0.c = c(r2);
        goto L4
    L9:
        r0.f3031b = i(r2);
        goto L4
    L10:
        r0.f3030a = i(r2);
        goto L4
    L11:
        return r0;
    }

    private static a c(byte[] r4) {
        a r0 = new a();
        h r1 = new h(r4);
    L4:
        if (r1.a() == false) goto L21;
        int r5 = r1.c();
        byte[] r2 = r1.a(r1.d());
        if (r5 != 1) goto L8;
        r0.f3022a = new String(r2, StandardCharsets.UTF_8);
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r0.f3023b = new String(r2, StandardCharsets.UTF_8);
        goto L4
    L10:
        if (r5 != 3) goto L12;
        r0.c = i(r2);
        goto L4
    L12:
        if (r5 != 4) goto L14;
        r0.d = r2;
        goto L4
    L14:
        if (r5 != 5) goto L4;
        r0.e = r2;
        goto L4
    L21:
        return r0;
    }

    private static d d(byte[] r3) {
        d r0 = new d();
        r0.d = new ArrayList();
        h r1 = new h(r3);
    L4:
        if (r1.a() == false) goto L12;
        int r4 = r1.c();
        byte[] r2 = r1.a(r1.d());
        switch(r4) {
            case 513: goto L11;
            case 514: goto L10;
            case 515: goto L9;
            case 516: goto L8;
            default: goto L4;
        };
    L8:
        a(r2, r0.d);
        goto L4
    L9:
        r0.c = j(r2);
        goto L4
    L10:
        r0.f3029b = i(r2);
        goto L4
    L11:
        r0.f3028a = i(r2);
        goto L4
    L12:
        return r0;
    }

    private static c e(byte[] r3) {
        c r0 = new c();
        h r1 = new h(r3);
    L4:
        if (r1.a() == false) goto L14;
        int r4 = r1.c();
        byte[] r2 = r1.a(r1.d());
        switch(r4) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        r0.g = r2;
        goto L4
    L9:
        r0.f = r2;
        goto L4
    L10:
        r0.e = r2;
        goto L4
    L11:
        r0.d = i(r2);
        goto L4
    L12:
        r0.c = j(r2);
        goto L4
    L13:
        r0.f3027b = r2;
        goto L4
    L14:
        return r0;
    }

    private static b f(byte[] r3) {
        b r0 = new b();
        h r1 = new h(r3);
    L4:
        if (r1.a() == false) goto L11;
        int r4 = r1.c();
        byte[] r2 = r1.a(r1.d());
        switch(r4) {
            case 769: goto L10;
            case 770: goto L9;
            case 771: goto L8;
            default: goto L4;
        };
    L8:
        r0.c = g(r2);
        goto L4
    L9:
        r0.f3025b = i(r2);
        goto L4
    L10:
        r0.f3024a = i(r2);
        goto L4
    L11:
        return r0;
    }

    private static f g(byte[] r4) {
        f r0 = new f();
        h r1 = new h(r4);
    L4:
        if (r1.a() == false) goto L12;
        int r5 = r1.c();
        byte[] r2 = r1.a(r1.d());
        if (r5 != 1) goto L8;
        r0.f3032a = r2;
        goto L4
    L8:
        if (r5 != 2) goto L4;
        r0.f3033b = j(r2);
        goto L4
    L12:
        return r0;
    }

    private static g h(byte[] r4) {
        g r0 = new g();
        h r1 = new h(r4);
    L4:
        if (r1.a() == false) goto L12;
        int r5 = r1.c();
        byte[] r2 = r1.a(r1.d());
        if (r5 != 1025) goto L8;
        r0.f3034a = i(r2);
        goto L4
    L8:
        if (r5 != 1026) goto L4;
        r0.f3035b = r2;
        goto L4
    L12:
        return r0;
    }

    private static int i(byte[] r2) {
        int r0 = (r2[0] & 255) << 8;
        return (r2[1] & 255) | r0;
    }

    private static int j(byte[] r2) {
        int r0 = (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)) | ((r2[2] & 255) << 8);
        return (r2[3] & 255) | r0;
    }

    public byte[] a() {
        i r0 = new i(null);
        e r1 = this.f3020a;
        if (r1 == null) goto L5;
        r0.b(256, a(r1));
    L5:
        d r2 = this.f3021b;
        if (r2 == null) goto L8;
        r0.b(512, a(r2));
    L8:
        b r3 = this.c;
        if (r3 == null) goto L11;
        r0.b(768, a(r3));
    L11:
        g r4 = this.d;
        if (r4 == null) goto L15;
        r0.b(1024, a(r4));
    L15:
        return r0.a();
    }

    public byte[] b() {
        i r0 = new i(null);
        e r1 = this.f3020a;
        if (r1 == null) goto L5;
        r0.b(256, a(r1));
    L5:
        d r2 = this.f3021b;
        if (r2 == null) goto L8;
        r0.b(512, a(r2));
    L8:
        b r3 = this.c;
        if (r3 == null) goto L12;
        r0.b(768, a(r3));
    L12:
        return r0.a();
    }
}
