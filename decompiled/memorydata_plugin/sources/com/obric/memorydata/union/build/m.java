package com.obric.memorydata.union.build;

import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J&\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J+\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/union/build/UnionRelevantSourceUtils;", "", "<init>", "()V", "TAG", "", "fromSourceInfo", "Lcom/obric/memorydata/union/build/UnionRelevantSourceUtils$SourceInfo;", "sourceInfo", "", "normalizeText", EventBody.KEY_VALUE, "hasInlineSourceInfo", "", "imagePathToFileEntityJson", "imagePath", "stringValue", "key", "intValue", "", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;", "SourceInfo", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13098a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0019\u001a\u00020\tJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/obric/memorydata/union/build/UnionRelevantSourceUtils$SourceInfo;", "", "sourceQuery", "", "sourceText", "imagePath", "sourcePackageName", "sourceAppName", "sourceProductType", "", "sourceLink", "sourceLinkType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getSourceQuery", "()Ljava/lang/String;", "getSourceText", "getImagePath", "getSourcePackageName", "getSourceAppName", "getSourceProductType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSourceLink", "getSourceLinkType", "resolveInlineProactiveProductType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/union/build/UnionRelevantSourceUtils$SourceInfo;", "equals", "", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13100b;
        private final String c;
        private final String d;
        private final String e;
        private final Integer f;
        private final String g;
        private final String h;

        public a(String r1, String r2, String r3, String r4, String r5, Integer r6, String r7, String r8) {
            this.f13099a = r1;
            this.f13100b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final String a() {
            return this.f13099a;
        }

        public final String b() {
            return this.f13100b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13099a, r6.f13099a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13100b, r6.f13100b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final String f() {
            return this.g;
        }

        public final String g() {
            return this.h;
        }

        public final int h() {
            Integer r0 = this.f;
            if (r0 != null) goto L7;
            return 3;
        L7:
            return r0.intValue();
        }

        public int hashCode() {
            String r0 = this.f13099a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f13100b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.g;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.h;
            if (r22 == null) goto L35;
            r1 = r22.hashCode();
        L35:
            return r21 + r1;
        L29:
            r20 = r19.hashCode();
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

        public String toString() {
            return "SourceInfo(sourceQuery=" + this.f13099a + ", sourceText=" + this.f13100b + ", imagePath=" + this.c + ", sourcePackageName=" + this.d + ", sourceAppName=" + this.e + ", sourceProductType=" + this.f + ", sourceLink=" + this.g + ", sourceLinkType=" + this.h + ')';
        }
    }

    static {
        f13098a = new m();
    }

    private m() {
    }

    private final String a(Map<String, ? extends Object> r2, String r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L12;
        Object r4 = r1.get(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L11:
        return r4.toString();
    L12:
        return null;
    }

    private final Integer b(Map<String, ? extends Object> r2, String r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        Object r4 = r1.get(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L11;
        return (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L14;
        return Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
    L14:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L16;
        return null;
    L16:
        return StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    L17:
        return null;
    }

    public final a a(Map<String, ? extends Object> r11) {
        Map<String, ? extends Object> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        return new a(a(a(r12, "sourceQuery")), a(a(r12, "sourceText")), a(a(r12, "imagePath")), a(a(r12, "sourcePackageName")), a(a(r12, "sourceAppName")), b(r12, "sourceProductType"), a(a(r12, "sourceLink")), a(a(r12, "sourceLinkType")));
    }

    public final String a(String r3) {
        if (r3 == null) goto L11;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r3;
    L7:
        r0 = false;
    L11:
        return null;
    }

    public final String b(String r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L27;
        File r1 = new File(r9);     // Catch: Exception -> L21
        if (r1.exists() == true) goto L16;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionRelevantSourceUtils", "imagePathToFileEntityJson skipped, file not found", null, 4, null);     // Catch: Exception -> L21
        return null;
    L16:
        if (r1.isFile() == false) goto L19;
        return EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(FileEntity.CREATOR.create(r1, x.f13267a.a(r1)), AppEntity.class, "com.obric.memorydata.plugin"));
    L21:
        e = move-exception;
        RunLog.INSTANCE.error("UnionRelevantSourceUtils", "imagePathToFileEntityJson failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L27:
        return null;
    L7:
        r0 = false;
        goto L8
    }

    public final boolean b(Map<String, ? extends Object> r5) {
        a r4 = a((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L59;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == false) goto L59;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L21;
    L24:
        boolean r11 = true;
    L25:
        if (r11 == false) goto L59;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L29;
    L32:
        boolean r13 = true;
    L33:
        if (r13 == false) goto L59;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L37;
    L40:
        boolean r15 = true;
    L41:
        if (r15 == false) goto L59;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.f(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L45;
    L48:
        boolean r17 = true;
    L49:
        if (r17 == false) goto L59;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.g(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L53;
    L56:
        boolean r19 = true;
    L57:
        if (r19 == false) goto L59;
        return false;
    L53:
        if (r18.length() == 0) goto L56;
        r19 = false;
        goto L57
    L45:
        if (r16.length() == 0) goto L48;
        r17 = false;
        goto L49
    L37:
        if (r14.length() == 0) goto L40;
        r15 = false;
        goto L41
    L29:
        if (r12.length() == 0) goto L32;
        r13 = false;
        goto L33
    L21:
        if (r10.length() == 0) goto L24;
        r11 = false;
        goto L25
    L13:
        if (r8.length() == 0) goto L16;
        r9 = false;
    L59:
        return true;
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }
}
