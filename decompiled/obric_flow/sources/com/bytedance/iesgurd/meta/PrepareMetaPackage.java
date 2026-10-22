package com.bytedance.iesgurd.meta;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tBM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010 \u001a\u00020!J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\fHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003Ja\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "", "()V", "id", "", "md5", "", "length", "url", "(JLjava/lang/String;JLjava/lang/String;)V", "schema", "domains", "", LynxResourceModule.URI_KEY, "decompressMd5", "ultraUpdateResource", "Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "(JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/bytedance/iesgurd/meta/UltraUpdateResource;)V", "getDecompressMd5", "()Ljava/lang/String;", "getDomains", "()Ljava/util/List;", "getId", "()J", "getLength", "getMd5", "getSchema", "getUltraUpdateResource", "()Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "getUri", "urlList", "", "checkValid", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getUrlList", "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class PrepareMetaPackage {

    @SerializedName("decompress_md5")
    private final String decompressMd5;

    @SerializedName("domains")
    private final List<String> domains;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f6645id;

    @SerializedName("size")
    private final long length;

    @SerializedName("md5")
    private final String md5;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("ultra_update_resource")
    private final UltraUpdateResource ultraUpdateResource;

    @SerializedName(LynxResourceModule.URI_KEY)
    private final String uri;
    private List<String> urlList;

    public PrepareMetaPackage(long r5, String r10, List<String> r11, String r12, String r13, String r14, long r15, UltraUpdateResource r16) {
        this.f6645id = r5;
        this.schema = r10;
        this.domains = r11;
        this.uri = r12;
        this.md5 = r13;
        this.decompressMd5 = r14;
        this.length = r15;
        this.ultraUpdateResource = r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrepareMetaPackage copy$default(PrepareMetaPackage r11, long r12, String r14, List r15, String r16, String r17, String r18, long r19, UltraUpdateResource r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r5 = r11.f6645id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r10 = r11.schema;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r13 = r11.domains;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r20 = r11.uri;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r24 = r11.md5;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r25 = r11.decompressMd5;
    L27:
        if ((r22 & 64) == 0) goto L29;
        long r26 = r11.length;
    L31:
        if ((r22 & 128) == 0) goto L33;
        UltraUpdateResource r27 = r11.ultraUpdateResource;
    L35:
        return r11.copy(r5, r10, r13, r20, r24, r25, r26, r27);
    L33:
        r27 = r21;
        goto L35
    L29:
        r26 = r19;
        goto L31
    L25:
        r25 = r18;
        goto L27
    L21:
        r24 = r17;
        goto L23
    L17:
        r20 = r16;
        goto L19
    L13:
        r13 = r15;
        goto L15
    L9:
        r10 = r14;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public final boolean checkValid() {
        if (this.f6645id < 0) goto L28;
        String r5 = this.schema;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.length() == 0) goto L35;
        List<String> r10 = this.domains;
        if (r10 != null) goto L12;
        return false;
    L12:
        if (r10.isEmpty() == true) goto L36;
        String r11 = this.uri;
        if (r11 != null) goto L17;
        return false;
    L17:
        if (r11.length() == 0) goto L37;
        String r12 = this.md5;
        if (r12 != null) goto L22;
        return false;
    L22:
        if (r12.length() != 0) goto L25;
        return false;
    L25:
        if (this.length <= 0) goto L34;
        return true;
    L34:
        return false;
    L37:
        return false;
    L36:
        return false;
    L35:
        return false;
    L28:
        return false;
    }

    public final long component1() {
        return this.f6645id;
    }

    public final String component2() {
        return this.schema;
    }

    public final List<String> component3() {
        return this.domains;
    }

    public final String component4() {
        return this.uri;
    }

    public final String component5() {
        return this.md5;
    }

    public final String component6() {
        return this.decompressMd5;
    }

    public final long component7() {
        return this.length;
    }

    public final UltraUpdateResource component8() {
        return this.ultraUpdateResource;
    }

    public final PrepareMetaPackage copy(long r13, String r15, List<String> r16, String r17, String r18, String r19, long r20, UltraUpdateResource r22) {
        return new PrepareMetaPackage(r13, r15, r16, r17, r18, r19, r20, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof PrepareMetaPackage) == false) goto L22;
        PrepareMetaPackage r10 = (PrepareMetaPackage) r5;
        if (this.f6645id == r10.f6645id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r10.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.domains, r10.domains) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r10.uri) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.md5, r10.md5) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.decompressMd5, r10.decompressMd5) == true) goto L18;
        return false;
    L18:
        if (this.length == r10.length) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ultraUpdateResource, r10.ultraUpdateResource) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final String getDecompressMd5() {
        return this.decompressMd5;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final long getId() {
        return this.f6645id;
    }

    public final long getLength() {
        return this.length;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final UltraUpdateResource getUltraUpdateResource() {
        return this.ultraUpdateResource;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrlList() {
        if (this.urlList != null) goto L11;
        this.urlList = new ArrayList();
        Iterator<T> r5 = this.domains.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        String r10 = (String) r5.next();
        List<String> r11 = this.urlList;
        if (r11 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r11.add(this.schema + "://" + r10 + this.uri);
    L11:
        List<String> r12 = this.urlList;
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        return r12;
    }

    public int hashCode() {
        long r5 = this.f6645id;
        int r10 = ((int) (r5 ^ (r5 >>> 32))) * 31;
        String r11 = this.schema;
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.hashCode();
    L6:
        int r14 = (r10 + r13) * 31;
        List<String> r15 = this.domains;
        if (r15 == null) goto L9;
        int r16 = r15.hashCode();
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.uri;
        if (r18 == null) goto L13;
        int r19 = r18.hashCode();
    L14:
        int r20 = (r17 + r19) * 31;
        String r21 = this.md5;
        if (r21 == null) goto L17;
        int r22 = r21.hashCode();
    L18:
        int r23 = (r20 + r22) * 31;
        String r24 = this.decompressMd5;
        if (r24 == null) goto L21;
        int r25 = r24.hashCode();
    L22:
        long r26 = this.length;
        int r27 = (((r23 + r25) * 31) + ((int) ((r26 >>> 32) ^ r26))) * 31;
        UltraUpdateResource r28 = this.ultraUpdateResource;
        if (r28 == null) goto L26;
        r12 = r28.hashCode();
    L26:
        return r27 + r12;
    L21:
        r25 = 0;
        goto L22
    L17:
        r22 = 0;
        goto L18
    L13:
        r19 = 0;
        goto L14
    L9:
        r16 = 0;
        goto L10
    L5:
        r13 = 0;
        goto L6
    }

    public String toString() {
        return "PrepareMetaPackage(id=" + this.f6645id + ", schema=" + this.schema + ", domains=" + this.domains + ", uri=" + this.uri + ", md5=" + this.md5 + ", decompressMd5=" + this.decompressMd5 + ", length=" + this.length + ", ultraUpdateResource=" + this.ultraUpdateResource + ")";
    }

    public PrepareMetaPackage() {
        this(0, "", CollectionsKt.emptyList(), "", "", "", 0, null);
    }

    public PrepareMetaPackage(long r12, String r14, long r15, String r17) {
        this(r12, "", CollectionsKt.emptyList(), "", r14, "", r15, null);
        ArrayList r5 = new ArrayList();
        this.urlList = r5;
        r5.add(r17);
    }
}
