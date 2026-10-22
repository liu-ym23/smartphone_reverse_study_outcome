package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001eB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService;", "", "repository", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository;", "cursorCodec", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursorCodec;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository;Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursorCodec;)V", "getChunk", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkResponse;", "protocolVersion", "", "recordId", "", "cursor", "decodeCursor", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation;", "encodedCursor", "validateCursor", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;", "snapshot", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSnapshot;", "missingSnapshotResponse", "staleCursor", "totalBytes", "buildChunk", "startOffset", "nextChunkEndOffset", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "invalidCursor", "CursorValidation", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f10441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f10442b;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation;", "", "Success", "Failure", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation$Failure;", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation$Success;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private interface a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.review.provider.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation$Failure;", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation;", ChatMessage.TYPE_RESPONSE, "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkResponse;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkResponse;)V", "getResponse", "()Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0512a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.memorydata.memory.review.provider.b f10443a;

            public C0512a(com.obric.memorydata.memory.review.provider.b r2) {
                Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_RESPONSE);
                this.f10443a = r2;
            }

            public final com.obric.memorydata.memory.review.provider.b a() {
                return this.f10443a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0512a.class) == true) goto L8;
                return false;
            L8:
                C0512a r6 = (C0512a) ZeusTransformUtils.preCheckCast(r5, C0512a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10443a, r6.f10443a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f10443a.hashCode();
            }

            public String toString() {
                return "Failure(response=" + this.f10443a + ')';
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation$Success;", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService$CursorValidation;", "cursor", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;)V", "getCursor", "()Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCursor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final d f10444a;

            public b(d r1) {
                this.f10444a = r1;
            }

            public final d a() {
                return this.f10444a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10444a, r6.f10444a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                d r0 = this.f10444a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Success(cursor=" + this.f10444a + ')';
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public c(h r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "cursorCodec");
        this.f10441a = r2;
        this.f10442b = r3;
    }

    public /* synthetic */ c(h r2, e r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = new h(null, 1, null);
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = new e();
    L8:
        this(r2, r3);
    }

    private final int a(String r3, int r4) {
        int r2 = 0;
    L4:
        if (r4 >= r3.length()) goto L8;
        int r0 = Character.codePointAt((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        r2 = r2 + i.a(r0);
        if (r2 > 65536) goto L8;
        r4 = r4 + Character.charCount(r0);
    L8:
        return r4;
    }

    private final b a() {
        return new b(AudioMemoryTranscriptCode.INVALID_CURSOR, null, null, false, 0, 30, null);
    }

    private final b a(int r9) {
        return new b(AudioMemoryTranscriptCode.STALE_CURSOR, null, null, false, r9, 14, null);
    }

    private final b a(d r9) {
        if (r9 != null) goto L5;
        return new b(AudioMemoryTranscriptCode.NOT_FOUND, null, null, false, 0, 30, null);
    L5:
        return a(r9.c());
    }

    private final b a(d r3, k r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.a(r4) == false) goto L8;
        b r2 = a();
        if (r3.b(r4) == false) goto L12;
        return null;
    L12:
        return r2;
    L8:
        return a(r4.f());
    }

    private final b a(k r9, int r10) {
        int r0 = a(r9.e(), r10);
        String r4 = r9.e().substring(r10, r0);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        if (r0 >= r9.e().length()) goto L5;
        boolean r11 = true;
    L6:
        boolean r6 = r11;
        if (r6 == false) goto L9;
        String r8 = this.f10442b.a(r9, r0);
    L10:
        AudioMemoryTranscriptCode r3 = AudioMemoryTranscriptCode.OK;
        return new b(r3, r4, r8, r6, r9.f());
    L9:
        r8 = null;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    private final a a(String r3, String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        a.b r2 = new a.b(null);
    L11:
        Object r5 = ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin");
    L13:
        return (a) r5;
    L14:
        d r6 = this.f10442b.a(r4);
        if (r6 != null) goto L19;
        a.C0512a r7 = new a.C0512a(a());
    L17:
        r5 = ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
        goto L13
    L19:
        if (Intrinsics.areEqual(r6.a(), r3) == true) goto L21;
        r7 = new a.C0512a(a());
        goto L17
    L21:
        r2 = new a.b(r6);
        goto L11
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final b a(int r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "recordId");
        boolean r2 = true;
        if (r18 != 1) goto L5;
        a r3 = a(r19, r20);
        if (ZeusTransformUtils.instanceOf(r3, a.C0512a.class) == true) goto L9;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.memorydata.memory.review.provider.AudioMemoryTranscriptChunkService.CursorValidation.Success");
        d r4 = ((a.b) ZeusTransformUtils.preCheckCast(r3, a.b.class, "com.obric.memorydata.plugin")).a();
        int r8 = 0;
        k r1 = h.a(this.f10441a, r19, false, 2, null);
        if (r1 == null) goto L13;
        b r5 = a(r4, r1);
        if (r5 == null) goto L18;
        return r5;
    L18:
        if (r1.f() <= 1048576) goto L22;
        return new b(AudioMemoryTranscriptCode.TOO_LARGE, null, null, false, r1.f(), 14, null);
    L22:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1.e(), CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L25;
        r2 = false;
    L25:
        if (r2 == true) goto L27;
        if (r4 == null) goto L31;
        r8 = r4.b();
    L31:
        return a(r1, r8);
    L27:
        return new b(AudioMemoryTranscriptCode.EMPTY, null, null, false, 0, 30, null);
    L13:
        return a(r4);
    L9:
        return ((a.C0512a) ZeusTransformUtils.preCheckCast(r3, a.C0512a.class, "com.obric.memorydata.plugin")).a();
    L5:
        return a();
    }
}
