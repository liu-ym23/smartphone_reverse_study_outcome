package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u007f\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00069"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PreloadResourceList;", "", TabAppInfo.IMAGE_JSON_KEY, "", "name", "version", "level", "type", "uri", "cdn_prefix_list", "", "download_type", "block_file_type", "block_list", "Lcom/ss/ugc/effectplatform/model/net/Block_list;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBlock_file_type", "()Ljava/lang/String;", "setBlock_file_type", "(Ljava/lang/String;)V", "getBlock_list", "()Ljava/util/List;", "setBlock_list", "(Ljava/util/List;)V", "getCdn_prefix_list", "setCdn_prefix_list", "getDownload_type", "setDownload_type", "getKey", "setKey", "getLevel", "setLevel", "getName", "setName", "getType", "setType", "getUri", "setUri", "getVersion", "setVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PreloadResourceList {
    private String block_file_type;
    private List<Block_list> block_list;
    private List<String> cdn_prefix_list;
    private String download_type;
    private String key;
    private String level;
    private String name;
    private String type;
    private String uri;
    private String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreloadResourceList copy$default(PreloadResourceList r11, String r12, String r13, String r14, String r15, String r16, String r17, List r18, String r19, String r20, List r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.key;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.name;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.version;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.level;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.type;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.uri;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = r11.cdn_prefix_list;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.download_type;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.block_file_type;
    L39:
        if ((r22 & 512) == 0) goto L41;
        List r1 = r11.block_list;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final List<Block_list> component10() {
        return this.block_list;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.level;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.uri;
    }

    public final List<String> component7() {
        return this.cdn_prefix_list;
    }

    public final String component8() {
        return this.download_type;
    }

    public final String component9() {
        return this.block_file_type;
    }

    public final PreloadResourceList copy(String r13, String r14, String r15, String r16, String r17, String r18, List<String> r19, String r20, String r21, List<Block_list> r22) {
        return new PreloadResourceList(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PreloadResourceList) == false) goto L26;
        PreloadResourceList r4 = (PreloadResourceList) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.version, r4.version) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.level, r4.level) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cdn_prefix_list, r4.cdn_prefix_list) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.download_type, r4.download_type) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.block_file_type, r4.block_file_type) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.block_list, r4.block_list) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.version;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.level;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.type;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.uri;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.cdn_prefix_list;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.download_type;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.block_file_type;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<Block_list> r28 = this.block_list;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PreloadResourceList(key=" + this.key + ", name=" + this.name + ", version=" + this.version + ", level=" + this.level + ", type=" + this.type + ", uri=" + this.uri + ", cdn_prefix_list=" + this.cdn_prefix_list + ", download_type=" + this.download_type + ", block_file_type=" + this.block_file_type + ", block_list=" + this.block_list + ")";
    }

    public final String getBlock_file_type() {
        return this.block_file_type;
    }

    public final List<Block_list> getBlock_list() {
        return this.block_list;
    }

    public final List<String> getCdn_prefix_list() {
        return this.cdn_prefix_list;
    }

    public final String getDownload_type() {
        return this.download_type;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setBlock_file_type(String r1) {
        this.block_file_type = r1;
    }

    public final void setBlock_list(List<Block_list> r1) {
        this.block_list = r1;
    }

    public final void setCdn_prefix_list(List<String> r1) {
        this.cdn_prefix_list = r1;
    }

    public final void setDownload_type(String r1) {
        this.download_type = r1;
    }

    public final void setKey(String r1) {
        this.key = r1;
    }

    public final void setLevel(String r1) {
        this.level = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public PreloadResourceList(String r1, String r2, String r3, String r4, String r5, String r6, List<String> r7, String r8, String r9, List<Block_list> r10) {
        this.key = r1;
        this.name = r2;
        this.version = r3;
        this.level = r4;
        this.type = r5;
        this.uri = r6;
        this.cdn_prefix_list = r7;
        this.download_type = r8;
        this.block_file_type = r9;
        this.block_list = r10;
    }

    public /* synthetic */ PreloadResourceList(String r15, String r16, String r17, String r18, String r19, String r20, List r21, String r22, String r23, List r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r25 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r25 & 512) == 0) goto L13;
        List r13 = null;
    L14:
        this(r15, r16, r6, r7, r19, r20, r21, r22, r23, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }
}
