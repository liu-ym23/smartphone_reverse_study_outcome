package com.ss.ugc.effectplatform.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J \u0010%\u001a\u00020&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010(\u001a\u00020\u0003H\u0002Jc\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\u0016\u0010/\u001a\u0002002\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bJ\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u00062"}, d2 = {"Lcom/ss/ugc/effectplatform/model/PlatformEffect;", "", "name", "", "hint", "file_uri", "icon_uri", "types", "", "hint_uri", "requirements", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getFile_uri", "()Ljava/lang/String;", "setFile_uri", "(Ljava/lang/String;)V", "getHint", "setHint", "getHint_uri", "setHint_uri", "getIcon_uri", "setIcon_uri", "getName", "setName", "getRequirements", "()Ljava/util/List;", "setRequirements", "(Ljava/util/List;)V", "getTypes", "setTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "concatPrefixWithUri", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "url_prefix", "uri", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toEffect", "Lcom/ss/ugc/effectplatform/model/Effect;", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class PlatformEffect {
    private String file_uri;
    private String hint;
    private String hint_uri;
    private String icon_uri;
    private String name;
    private List<String> requirements;
    private List<String> types;

    public PlatformEffect() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformEffect copy$default(PlatformEffect r5, String r6, String r7, String r8, String r9, List r10, String r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.name;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.hint;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.file_uri;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.icon_uri;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.types;
    L17:
        List r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.hint_uri;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.requirements;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.hint;
    }

    public final String component3() {
        return this.file_uri;
    }

    public final String component4() {
        return this.icon_uri;
    }

    public final List<String> component5() {
        return this.types;
    }

    public final String component6() {
        return this.hint_uri;
    }

    public final List<String> component7() {
        return this.requirements;
    }

    public final PlatformEffect copy(String r10, String r11, String r12, String r13, List<String> r14, String r15, List<String> r16) {
        return new PlatformEffect(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PlatformEffect) == false) goto L20;
        PlatformEffect r4 = (PlatformEffect) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hint, r4.hint) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.file_uri, r4.file_uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon_uri, r4.icon_uri) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.types, r4.types) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hint_uri, r4.hint_uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requirements, r4.requirements) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.hint;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.file_uri;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.icon_uri;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.types;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.hint_uri;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.requirements;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
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
        return "PlatformEffect(name=" + this.name + ", hint=" + this.hint + ", file_uri=" + this.file_uri + ", icon_uri=" + this.icon_uri + ", types=" + this.types + ", hint_uri=" + this.hint_uri + ", requirements=" + this.requirements + ")";
    }

    public final String getFile_uri() {
        return this.file_uri;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getHint_uri() {
        return this.hint_uri;
    }

    public final String getIcon_uri() {
        return this.icon_uri;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getRequirements() {
        return this.requirements;
    }

    public final List<String> getTypes() {
        return this.types;
    }

    public final void setFile_uri(String r1) {
        this.file_uri = r1;
    }

    public final void setHint(String r1) {
        this.hint = r1;
    }

    public final void setHint_uri(String r1) {
        this.hint_uri = r1;
    }

    public final void setIcon_uri(String r1) {
        this.icon_uri = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setRequirements(List<String> r1) {
        this.requirements = r1;
    }

    public final void setTypes(List<String> r1) {
        this.types = r1;
    }

    public final Effect toEffect(List<String> r84) {
        Effect r15 = new Effect(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
        String r2 = this.name;
        String r3 = "";
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r15.setName(r2);
        String r4 = this.hint;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r15.setHint(r4);
        r15.setFile_url(concatPrefixWithUri(r84, this.file_uri));
        List r5 = this.types;
        if (r5 != null) goto L14;
        r5 = new ArrayList();
    L14:
        r15.setTypes(r5);
        r15.setHint_icon(concatPrefixWithUri(r84, this.hint_uri));
        r15.setIcon_url(concatPrefixWithUri(r84, this.icon_uri));
        List r1 = this.requirements;
        if (r1 != null) goto L18;
        r1 = new ArrayList();
    L18:
        r15.setRequirements(r1);
        String r6 = this.file_uri;
        if (r6 == null) goto L21;
        r3 = r6;
    L21:
        r15.setId(r3);
        return r15;
    }

    private final UrlModel concatPrefixWithUri(List<String> r9, String r10) {
        UrlModel r7 = new UrlModel(null, null, null, null, 15, null);
        r7.setUri(r10);
        if (r9 == null) goto L8;
        ArrayList r0 = new ArrayList();
        int r1 = r9.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0.add(((String) ListProtector.get(r9, r2)) + r10);
        r2 = r2 + 1;
        goto L5
    L7:
        r7.setUrl_list(r0);
    L8:
        return r7;
    }

    public PlatformEffect(String r1, String r2, String r3, String r4, List<String> r5, String r6, List<String> r7) {
        this.name = r1;
        this.hint = r2;
        this.file_uri = r3;
        this.icon_uri = r4;
        this.types = r5;
        this.hint_uri = r6;
        this.requirements = r7;
    }

    public /* synthetic */ PlatformEffect(String r7, String r8, String r9, String r10, List r11, String r12, List r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = "";
    L19:
        if ((r14 & 16) == 0) goto L21;
        List r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = "";
    L27:
        if ((r14 & 64) == 0) goto L29;
        List r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
