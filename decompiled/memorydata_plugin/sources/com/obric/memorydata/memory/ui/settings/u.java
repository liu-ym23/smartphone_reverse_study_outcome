package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision;", "", "Drop", "Proceed", "Request", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision$Drop;", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision$Proceed;", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision$Request;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface u {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision$Drop;", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11508a = null;

        static {
            f11508a = new a();
        }

        private a() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision$Proceed;", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11509a = null;

        static {
            f11509a = new b();
        }

        private b() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision$Request;", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision;", "consentType", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "<init>", "(Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;)V", "getConsentType", "()Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ShortcutMemoryConsentType f11510a;

        public c(ShortcutMemoryConsentType r2) {
            Intrinsics.checkNotNullParameter(r2, "consentType");
            this.f11510a = r2;
        }

        public final ShortcutMemoryConsentType a() {
            return this.f11510a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f11510a == r6.f11510a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11510a.hashCode();
        }

        public String toString() {
            return "Request(consentType=" + this.f11510a + ')';
        }
    }
}
