package com.obric.search.api.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000b\"\u00020\b¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/search/api/migration/MigrationBuilder;", "", "startVersion", "", "endVersion", "(II)V", "migrationActions", "", "Lcom/obric/search/api/migration/IMigrationAction;", "addActions", "actions", "", "([Lcom/obric/search/api/migration/IMigrationAction;)Lcom/obric/search/api/migration/MigrationBuilder;", "build", "Lcom/obric/search/api/migration/AbstractMigration;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14932b;
    private final List<c> c;

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/search/api/migration/MigrationBuilder$build$1", "Lcom/obric/search/api/migration/AbstractMigration;", "getMigrationActions", "", "Lcom/obric/search/api/migration/IMigrationAction;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends com.obric.search.api.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f14933a;

        a(d r1, int r2, int r3) {
            this.f14933a = r1;
            super(r2, r3);
        }

        @Override // com.obric.search.api.c.a
        public List<c> c() {
            return d.a(this.f14933a);
        }
    }

    public d(int r2, int r3) {
        this.f14931a = r2;
        this.f14932b = r3;
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ List a(d r0) {
        return r0.c;
    }

    public final com.obric.search.api.c.a a() {
        return (com.obric.search.api.c.a) ZeusTransformUtils.preCheckCast(new a(this, this.f14931a, this.f14932b), com.obric.search.api.c.a.class, "com.obric.memorydata.plugin");
    }

    public final d a(c... r5) {
        Intrinsics.checkNotNullParameter(r5, "actions");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        c r2 = r5[r1];
        this.c.add(r2);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }
}
