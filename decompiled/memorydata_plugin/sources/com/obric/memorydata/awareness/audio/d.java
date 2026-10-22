package com.obric.memorydata.awareness.audio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache;", "", "<init>", "()V", "snapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache$Snapshot;", "kotlin.jvm.PlatformType", "replace", "", "accountScope", "", "hotwords", "get", "clear", "Snapshot", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f8524a = null;
    private static final b c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<b> f8525b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache$Companion;", "", "<init>", "()V", "EMPTY_JSON_ARRAY", "", "EMPTY_SNAPSHOT", "Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache$Snapshot;", "getEMPTY_SNAPSHOT", "()Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache$Snapshot;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache$Snapshot;", "", "accountScope", "", "hotwords", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccountScope", "()Ljava/lang/String;", "getHotwords", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8527b;

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "accountScope");
            Intrinsics.checkNotNullParameter(r3, "hotwords");
            this.f8526a = r2;
            this.f8527b = r3;
        }

        public final String a() {
            return this.f8526a;
        }

        public final String b() {
            return this.f8527b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8526a, r6.f8526a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8527b, r6.f8527b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8526a.hashCode() * 31) + this.f8527b.hashCode();
        }

        public String toString() {
            return "Snapshot(accountScope=" + this.f8526a + ", hotwords=" + this.f8527b + ')';
        }
    }

    static {
        f8524a = new a(null);
        c = new b("", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public d() {
        this.f8525b = new AtomicReference(c);
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "accountScope");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L5:
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f8525b.get(), b.class, "com.obric.memorydata.plugin");
        String r0 = r3.b();
        if (Intrinsics.areEqual(r3.a(), r4) == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L12;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L12:
        return r0;
    }

    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "accountScope");
        Intrinsics.checkNotNullParameter(r4, "hotwords");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        this.f8525b.set(new b(r3, r4));
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "accountScope");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f8525b.get(), b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r0.a(), r5) == false) goto L9;
        if (this.f8525b.compareAndSet(r0, c) == false) goto L5;
        return;
    }
}
