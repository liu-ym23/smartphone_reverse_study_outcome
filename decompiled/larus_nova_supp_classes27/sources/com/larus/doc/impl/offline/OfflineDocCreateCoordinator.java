package com.larus.doc.impl.offline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class OfflineDocCreateCoordinator {
    public final a a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/doc/impl/offline/OfflineDocCreateCoordinator$CreateDocumentStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "WAITING_CALLBACK", "SUCCEEDED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CreateDocumentStatus extends Enum<CreateDocumentStatus> {
        public static final CreateDocumentStatus FAILED = null;
        public static final CreateDocumentStatus NOT_STARTED = null;
        public static final CreateDocumentStatus SUCCEEDED = null;
        public static final CreateDocumentStatus WAITING_CALLBACK = null;
        public static final /* synthetic */ CreateDocumentStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CreateDocumentStatus> getEntries() {
            return b;
        }

        static {
            CreateDocumentStatus r0 = new CreateDocumentStatus("NOT_STARTED", 0);
            NOT_STARTED = r0;
            CreateDocumentStatus r1 = new CreateDocumentStatus("WAITING_CALLBACK", 1);
            WAITING_CALLBACK = r1;
            CreateDocumentStatus r3 = new CreateDocumentStatus("SUCCEEDED", 2);
            SUCCEEDED = r3;
            CreateDocumentStatus r5 = new CreateDocumentStatus("FAILED", 3);
            FAILED = r5;
            CreateDocumentStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static CreateDocumentStatus[] values() {
            return (CreateDocumentStatus[]) a.clone();
        }

        public static CreateDocumentStatus valueOf(String r1) {
            return (CreateDocumentStatus) r27.a.a(CreateDocumentStatus.class, r1);
        }

        public CreateDocumentStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public CreateDocumentStatus a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public String g;
        public com.larus.doc.impl.offline.a h;
        public com.larus.doc.impl.offline.a i;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            if (this.d == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (r5 + r6) * 31;
            if (this.e == false) goto L17;
            int r8 = 1231;
        L18:
            int r9 = (r7 + r8) * 31;
            if (this.f == true) goto L22;
            r2 = 1237;
        L22:
            int r10 = (r9 + r2) * 31;
            String r11 = this.g;
            int r12 = 0;
            if (r11 != null) goto L25;
            int r13 = 0;
        L26:
            int r14 = (r10 + r13) * 31;
            com.larus.doc.impl.offline.a r15 = this.h;
            if (r15 != null) goto L29;
            int r16 = 0;
        L30:
            int r17 = (r14 + r16) * 31;
            com.larus.doc.impl.offline.a r18 = this.i;
            if (r18 == null) goto L35;
            r12 = r18.hashCode();
        L35:
            return r17 + r12;
        L29:
            r16 = r15.hashCode();
            goto L30
        L25:
            r13 = r11.hashCode();
            goto L26
        L17:
            r8 = 1237;
            goto L18
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(createDocumentStatus=" + this.a + ", hasFrontendLinked=" + this.b + ", hasUserChanges=" + this.c + ", hasAcceptCommit=" + this.d + ", hasHostDestroyed=" + this.e + ", hasDispatchedCreateDocByMessage=" + this.f + ", realToken=" + this.g + ", latestSnapshot=" + this.h + ", destroySnapshot=" + this.i + ')';
        }

        public a(int r2) {
            CreateDocumentStatus r3 = CreateDocumentStatus.NOT_STARTED;
            Intrinsics.checkNotNullParameter(r3, "createDocumentStatus");
            this.a = r3;
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = null;
            this.h = null;
            this.i = null;
        }
    }

    public final synchronized String d() {
        monitor-enter(this);
        String r0 = this.a.g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public OfflineDocCreateCoordinator() {
        this.a = new a(0);
    }

    public final e a(String r9) {
        a r0 = this.a;
        com.larus.doc.impl.offline.a r1 = r0.i;
        if (r1 != null) goto L5;
        r1 = r0.h;
    L5:
        com.larus.doc.impl.offline.a r3 = r1;
        String r2 = r0.g;
        if (r2 != null) goto L8;
    L10:
        String r4 = null;
    L11:
        if (r4 != null) goto L14;
        Boolean r5 = null;
    L18:
        if (r4 != null) goto L22;
        String r6 = "create_doc_by_message_not_started";
    L26:
        return e(r3, r4, r5, r6, r9);
    L22:
        if (this.a.b == false) goto L24;
        r6 = "no_accept_commit";
        goto L26
    L24:
        r6 = "offline_file_sync_started";
        goto L26
    L14:
        if (this.a.b == false) goto L16;
        Boolean r7 = Boolean.FALSE;
    L17:
        r5 = r7;
        goto L18
    L16:
        r7 = Boolean.TRUE;
        goto L17
    L8:
        if ((!StringsKt.isBlank(r2)) == false) goto L10;
        r4 = r2;
        goto L11
    }

    public final e b(String r8) {
        String r0 = this.a.g;
        if (r0 == null) goto L30;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L30;
        a r1 = this.a;
        if (r1.b == true) goto L15;
        return new e.c(r8.concat(":frontend_not_linked"));
    L15:
        if (r1.d == false) goto L17;
        com.larus.doc.impl.offline.a r3 = r1.h;
        if (r1.f == true) goto L31;
        if (r3 == null) goto L32;
        r1.f = true;
        com.larus.doc.impl.offline.a r4 = com.larus.doc.impl.offline.a.a(r3, r0, Boolean.FALSE);
        CreateDocByMessageActionType r5 = CreateDocByMessageActionType.FORMAL;
        if (StringsKt.isBlank(r0) == false) goto L26;
        boolean r2 = true;
    L27:
        a r6 = this.a;
        return new e.b(r4, r8, new b(r5, !r2, r6.c, r6.b));
    L26:
        r2 = false;
        goto L27
    L32:
        return new e.c(r8.concat(":missing_snapshot"));
    L31:
        return new e.c(r8.concat(":create_doc_by_message_started"));
    L17:
        return new e.c(r8.concat(":accept_commit_not_ready"));
    L30:
        return new e.c(r8.concat(":no_real_token"));
    }

    public final void c(com.larus.doc.impl.offline.a r4) {
        a r0 = this.a;
        r0.h = r4;
        String r1 = r0.g;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L19;
        String r5 = r4.f;
        if (r5 != null) goto L13;
    L16:
        if (r2 == true) goto L20;
        a r6 = this.a;
        r6.g = r4.f;
        return;
    L20:
        return;
    L13:
        if (StringsKt.isBlank(r5) == true) goto L16;
        r2 = false;
        goto L16
    L19:
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final synchronized e f(com.larus.doc.impl.offline.a r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "snapshot");     // Catch: Throwable -> L6
        c(r2);     // Catch: Throwable -> L6
        this.a.d = true;     // Catch: Throwable -> L6
        e r3 = b("accept_commit");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized e g(String r10) {
        monitor-enter(this);
        a r1 = this.a;     // Catch: Throwable -> L11
        CreateDocumentStatus r2 = CreateDocumentStatus.FAILED;     // Catch: Throwable -> L11
        r1.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r2, "<set-?>");     // Catch: Throwable -> L11
        r1.a = r2;     // Catch: Throwable -> L11
        a r3 = this.a;     // Catch: Throwable -> L11
        if (r3.e == false) goto L8;
        e r11 = e(r3.i, null, null, "create_doc_by_message_not_started", "create_document_failed_after_destroy:".concat(r10));     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r11;
    L8:
        r11 = new e.c("create_document_failed:".concat(r10));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final e e(com.larus.doc.impl.offline.a r5, String r6, Boolean r7, String r8, String r9) {
        a r0 = this.a;
        if (r0.f == true) goto L5;
        if (r5 == null) goto L8;
        r0.f = true;
        com.larus.doc.impl.offline.a r10 = com.larus.doc.impl.offline.a.a(r5, r6, r7);
        CreateDocByMessageActionType r11 = CreateDocByMessageActionType.COMPENSATE;
        if (r6 != null) goto L12;
    L15:
        boolean r12 = true;
    L16:
        a r1 = this.a;
        return new e.a(r10, r8, r9, new b(r11, !r12, r1.c, r1.b));
    L12:
        if (StringsKt.isBlank(r6) == true) goto L15;
        r12 = false;
        goto L16
    L8:
        return new e.c(r9 + ":missing_snapshot");
    L5:
        return new e.c(r9 + ":create_doc_by_message_started");
    }
}
