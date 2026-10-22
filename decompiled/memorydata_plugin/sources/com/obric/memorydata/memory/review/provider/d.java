package com.obric.memorydata.memory.review.provider;

import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0080\b\u0018\u0000 52\u00020\u0001:\u00015BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001dJ\b\u0010%\u001a\u00020\u0003H\u0002J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003Jm\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\bHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u000e\u0010$\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;", "", "recordId", "", "entityRevision", "refsDigest", "transcriptDigest", "evidenceIndex", "", "segmentIndex", "characterOffset", "absoluteOffset", "emittedBytes", "totalBytes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)V", "getRecordId", "()Ljava/lang/String;", "getEntityRevision", "getRefsDigest", "getTranscriptDigest", "getEvidenceIndex", "()I", "getSegmentIndex", "getCharacterOffset", "getAbsoluteOffset", "getEmittedBytes", "getTotalBytes", "matchesRevision", "", "snapshot", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSnapshot;", "hasValidPosition", "toJson", "Lorg/json/JSONObject;", "hasValidSignature", "storedSignature", "signature", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10448b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private String l;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor$Companion;", "", "<init>", "()V", "CURSOR_SIGNATURE_SALT", "", "fromJson", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;", "json", "Lorg/json/JSONObject;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final d a(JSONObject r13) {
            Intrinsics.checkNotNullParameter(r13, "json");
            if (r13.optInt(BaseSwitches.V, -1) == 1) goto L6;
            return null;
        L6:
            String r1 = r13.getString("r");
            Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
            String r2 = r13.getString("e");
            Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
            String r3 = r13.getString("d");
            Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
            String r4 = r13.getString("t");
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
            d r12 = new d(r1, r2, r3, r4, r13.getInt("i"), r13.getInt("s"), r13.getInt("o"), r13.getInt("a"), r13.getInt("b"), r13.getInt("n"));
            String r14 = r13.getString(com.loc.o.g);
            Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
            d.a(r12, r14);
            return r12;
        }
    }

    static {
        f10447a = new a(null);
    }

    public d(String r2, String r3, String r4, String r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r3, "entityRevision");
        Intrinsics.checkNotNullParameter(r4, "refsDigest");
        Intrinsics.checkNotNullParameter(r5, "transcriptDigest");
        this.f10448b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = f();
    }

    public static final /* synthetic */ void a(d r0, String r1) {
        r0.l = r1;
    }

    private final String f() {
        return i.a(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Object[]{1, this.f10448b, this.c, this.d, this.e, Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), "memory-review-audio-transcript-v1"}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u001f", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    }

    public final String a() {
        return this.f10448b;
    }

    public final boolean a(k r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        if (Intrinsics.areEqual(this.c, r3.b()) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(this.d, r3.c()) == false) goto L9;
        if (Intrinsics.areEqual(this.e, r3.d()) == false) goto L9;
        return true;
    }

    public final int b() {
        return this.i;
    }

    public final boolean b(k r6) {
        Intrinsics.checkNotNullParameter(r6, "snapshot");
        int r0 = r6.e().length();
        int r1 = this.i;
        if (1 > r1) goto L6;
        if (r1 >= r0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
    L28:
        return false;
    L9:
        if (this.k != r6.f()) goto L28;
        if (Character.isLowSurrogate(r6.e().charAt(this.i)) == true) goto L14;
    L16:
        int r3 = this.j;
        String r4 = r6.e().substring(0, this.i);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        if (r3 == i.c(r4)) goto L19;
        return false;
    L19:
        g r7 = r6.a(this.i);
        if (this.f != r7.a()) goto L27;
        if (this.g != r7.b()) goto L27;
        if (this.h != r7.c()) goto L27;
        return true;
    L27:
        return false;
    L14:
        if (Character.isHighSurrogate(r6.e().charAt(this.i - 1)) == false) goto L16;
        return false;
    L6:
        r2 = false;
        goto L7
    }

    public final int c() {
        return this.k;
    }

    public final JSONObject d() {
        JSONObject r3 = new JSONObject().put(BaseSwitches.V, 1).put("r", this.f10448b).put("e", this.c).put("d", this.d).put("t", this.e).put("i", this.f).put("s", this.g).put("o", this.h).put("a", this.i).put("b", this.j).put("n", this.k).put(com.loc.o.g, f());
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return r3;
    }

    public final boolean e() {
        return Intrinsics.areEqual(f(), this.l);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10448b, r6.f10448b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L27;
        return false;
    L27:
        if (this.h == r6.h) goto L30;
        return false;
    L30:
        if (this.i == r6.i) goto L33;
        return false;
    L33:
        if (this.j == r6.j) goto L36;
        return false;
    L36:
        if (this.k == r6.k) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((this.f10448b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k);
    }

    public String toString() {
        return "AudioMemoryTranscriptCursor(recordId=" + this.f10448b + ", entityRevision=" + this.c + ", refsDigest=" + this.d + ", transcriptDigest=" + this.e + ", evidenceIndex=" + this.f + ", segmentIndex=" + this.g + ", characterOffset=" + this.h + ", absoluteOffset=" + this.i + ", emittedBytes=" + this.j + ", totalBytes=" + this.k + ')';
    }
}
