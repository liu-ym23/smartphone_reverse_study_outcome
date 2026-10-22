package com.obric.memorydata.database.util.file_utils;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0003/01B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jh\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocNode;", "", OaidModel.KEY_ID, "", "type", "Lcom/obric/memorydata/database/util/file_utils/NodeType;", "level", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "parentId", "childrenIds", "", "tokenLength", "positions", "Lcom/obric/memorydata/database/util/file_utils/DocNode$NodePositions;", "<init>", "(ILcom/obric/memorydata/database/util/file_utils/NodeType;ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;ILcom/obric/memorydata/database/util/file_utils/DocNode$NodePositions;)V", "getId", "()I", "getType", "()Lcom/obric/memorydata/database/util/file_utils/NodeType;", "getLevel", "getText", "()Ljava/lang/String;", "getParentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChildrenIds", "()Ljava/util/List;", "getTokenLength", "getPositions", "()Lcom/obric/memorydata/database/util/file_utils/DocNode$NodePositions;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILcom/obric/memorydata/database/util/file_utils/NodeType;ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;ILcom/obric/memorydata/database/util/file_utils/DocNode$NodePositions;)Lcom/obric/memorydata/database/util/file_utils/DocNode;", "equals", "", "other", "hashCode", "toString", "Companion", "NodePositions", "Coordinate", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9650b;
    private final NodeType c;
    private final int d;
    private final String e;
    private final Integer f;
    private final List<Integer> g;
    private final int h;
    private final b i;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocNode$Companion;", "", "<init>", "()V", "MAX_DOC_NODE_CONTENT_LENGTH", "", "tokenCost", "", "char", "", "calculateTokenLength", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final double a(char r5) {
            if (Character.isLetter(r5) == false) goto L8;
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r5), CharSequence.class, "com.obric.memorydata.plugin");
            if (new Regex("[a-zA-Z]").matches(r4) == false) goto L8;
            return 0.3d;
        L8:
            if (Character.isLetter(r5) == false) goto L11;
            return 0.6d;
        L11:
            return 0.3d;
        }

        public final int a(String r7) {
            Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            int r0 = r7.length();
            double r1 = 0.0d;
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L6;
            r1 = r1 + a(r7.charAt(r3));
            r3 = r3 + 1;
            goto L3
        L6:
            return (int) r1;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocNode$NodePositions;", "", "pageNumbers", "", "", "bbox", "Lcom/obric/memorydata/database/util/file_utils/DocNode$Coordinate;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getPageNumbers", "()Ljava/util/List;", "getBbox", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Integer> f9651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Object> f9652b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public b(List<Integer> r3, List<Object> r4) {
            List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f9651a = r5;
            this.f9652b = r6;
        }

        public /* synthetic */ b(List r2, List r3, int r4, DefaultConstructorMarker r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r7 = null;
        L8:
            this(r6, r7);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9651a, r6.f9651a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9652b, r6.f9652b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<Integer> r0 = this.f9651a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<Object> r4 = this.f9652b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "NodePositions(pageNumbers=" + this.f9651a + ", bbox=" + this.f9652b + ')';
        }
    }

    static {
        f9649a = new a(null);
    }

    public h(int r3, NodeType r4, int r5, String r6, Integer r7, List<Integer> r8, int r9, b r10) {
        List<Integer> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "childrenIds");
        this.f9650b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r11;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ h(int r14, NodeType r15, int r16, String r17, Integer r18, List r19, int r20, b r21, int r22, DefaultConstructorMarker r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        if ((r22 & 4) == 0) goto L5;
        int r7 = -1;
    L7:
        if ((r22 & 16) == 0) goto L9;
        Integer r9 = null;
    L11:
        if ((r22 & 32) == 0) goto L13;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L13:
        List r10 = r1;
        if ((r22 & 64) == 0) goto L16;
        int r11 = f9649a.a(r17);
    L18:
        if ((r22 & 128) == 0) goto L20;
        b r12 = null;
    L21:
        this(r14, r15, r7, r17, r9, r10, r11, r12);
        return;
    L20:
        r12 = r21;
        goto L21
    L16:
        r11 = r20;
        goto L18
    L9:
        r9 = r18;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public static /* synthetic */ h a(h r9, int r10, NodeType r11, int r12, String r13, Integer r14, List r15, int r16, b r17, int r18, Object r19) {
        List<Integer> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 1) == 0) goto L5;
        int r3 = r9.f9650b;
    L7:
        if ((r18 & 2) == 0) goto L9;
        NodeType r4 = r9.c;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r5 = r9.d;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r6 = r9.e;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r7 = r9.f;
    L23:
        if ((r18 & 32) == 0) goto L26;
        r2 = r9.g;
    L26:
        if ((r18 & 64) == 0) goto L28;
        int r8 = r9.h;
    L30:
        if ((r18 & 128) == 0) goto L32;
        b r1 = r9.i;
    L34:
        return r9.a(r3, r4, r5, r6, r7, r2, r8, r1);
    L32:
        r1 = r17;
        goto L34
    L28:
        r8 = r16;
        goto L30
    L21:
        r7 = r14;
        goto L23
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public final int a() {
        return this.f9650b;
    }

    public final h a(int r11, NodeType r12, int r13, String r14, Integer r15, List<Integer> r16, int r17, b r18) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r14, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r7, "childrenIds");
        return new h(r11, r12, r13, r14, r15, r7, r17, r18);
    }

    public final int b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final Integer d() {
        return this.f;
    }

    public final List<Integer> e() {
        return this.g;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.f9650b == r6.f9650b) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (this.h == r6.h) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int f() {
        return this.h;
    }

    public final NodeType getType() {
        return this.c;
    }

    public int hashCode() {
        int r0 = ((((((Integer.hashCode(this.f9650b) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
        Integer r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        b r5 = this.i;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DocNode(id=" + this.f9650b + ", type=" + this.c + ", level=" + this.d + ", text=" + this.e + ", parentId=" + this.f + ", childrenIds=" + this.g + ", tokenLength=" + this.h + ", positions=" + this.i + ')';
    }
}
