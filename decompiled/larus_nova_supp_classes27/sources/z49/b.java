package z49;

import com.bytedance.dora.device.DoraDevice;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00069"}, d2 = {"Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "", "name", "", "mac", "productId", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "softVersion", "sn", "sku", "caseSoftVersion", "doraDevice", "Lcom/bytedance/dora/device/DoraDevice;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/dora/device/DoraDevice;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getMac", "setMac", "getProductId", "()Ljava/lang/Integer;", "setProductId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getModel", "setModel", "getSoftVersion", "setSoftVersion", "getSn", "setSn", "getSku", "setSku", "getCaseSoftVersion", "setCaseSoftVersion", "getDoraDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "setDoraDevice", "(Lcom/bytedance/dora/device/DoraDevice;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/dora/device/DoraDevice;)Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {
    public DoraDevice a;

    @SerializedName("caseSoftVersion")
    private String caseSoftVersion;

    @SerializedName("mac")
    private String mac;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private String model;

    @SerializedName("name")
    private String name;

    @SerializedName("productId")
    private Integer productId;

    @SerializedName("sku")
    private Integer sku;

    @SerializedName("sn")
    private String sn;

    @SerializedName("softVersion")
    private String softVersion;

    public b() {
        this(null, null, null, null, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mac, r6.mac) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productId, r6.productId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.softVersion, r6.softVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sn, r6.sn) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sku, r6.sku) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.caseSoftVersion, r6.caseSoftVersion) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.mac;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.productId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.model;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.softVersion;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.sn;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r20 = this.sku;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        String r23 = this.caseSoftVersion;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        DoraDevice r26 = this.a;
        if (r26 == null) goto L39;
        r1 = r26.hashCode();
    L39:
        return r25 + r1;
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraSimpleDeviceV2(name=" + this.name + ", mac=" + this.mac + ", productId=" + this.productId + ", model=" + this.model + ", softVersion=" + this.softVersion + ", sn=" + this.sn + ", sku=" + this.sku + ", caseSoftVersion=" + this.caseSoftVersion + ", doraDevice=" + this.a + ')';
    }

    public final String b() {
        return this.caseSoftVersion;
    }

    public final String c() {
        return this.mac;
    }

    public final String d() {
        return this.model;
    }

    public final String e() {
        return this.name;
    }

    public final Integer f() {
        return this.productId;
    }

    public final Integer g() {
        return this.sku;
    }

    public final String h() {
        return this.sn;
    }

    public final String i() {
        return this.softVersion;
    }

    public static b a(b r10, DoraDevice r11) {
        String r1 = r10.name;
        String r2 = r10.mac;
        Integer r3 = r10.productId;
        String r4 = r10.model;
        String r5 = r10.softVersion;
        String r6 = r10.sn;
        Integer r7 = r10.sku;
        String r8 = r10.caseSoftVersion;
        r10.getClass();
        return new b(r1, r2, r3, r4, r5, r6, r7, r8, r11);
    }

    public /* synthetic */ b(String r14, String r15, String r16, Integer r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r6 = 1;
    L15:
        if ((r18 & 16) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r18 & 32) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r18 & 64) == 0) goto L25;
        Integer r10 = 0;
    L27:
        if ((r18 & 128) == 0) goto L29;
        String r11 = "";
    L30:
        this(r4, r5, r6, null, r8, r9, r10, r11, null);
        return;
    L29:
        r11 = null;
        goto L30
    L25:
        r10 = r17;
        goto L27
    L21:
        r9 = r16;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public b(String r1, String r2, Integer r3, String r4, String r5, String r6, Integer r7, String r8, DoraDevice r9) {
        this.name = r1;
        this.mac = r2;
        this.productId = r3;
        this.model = r4;
        this.softVersion = r5;
        this.sn = r6;
        this.sku = r7;
        this.caseSoftVersion = r8;
        this.a = r9;
    }
}
