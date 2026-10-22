package com.lark.kmp.rustclient.internal;

import com.bytedance.larksuite.wire.CommandScope;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.wire.ProtoAdapter;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z extends BaseRustClient implements com.lark.kmp.rustclient.api.d {
    public final String e;
    public final e0 f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommandScope.values().length];
            r0[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final Long d() {
        return this.b.a(this.e);
    }

    @Override // com.lark.kmp.rustclient.internal.BaseRustClient
    public final s c() {
        return this.f;
    }

    @Override // com.lark.kmp.rustclient.api.d
    public final w b(com.lark.kmp.rustclient.api.model.c r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        CommandScope r1 = c.a(r7.a());
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        com.lark.kmp.rustclient.api.model.j r3 = com.lark.kmp.rustclient.api.model.d.a;
    L10:
        Intrinsics.checkNotNullParameter(r7, "request");
        Intrinsics.checkNotNullParameter(r3, "scopePayload");
        return new w((List) this.d.getValue(), new com.lark.kmp.rustclient.api.a(r7, r3, this.e, d()));
    L5:
        if (r2 != 2) goto L8;
        r3 = new com.lark.kmp.rustclient.api.model.l(this.e, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.lark.kmp.rustclient.internal.UserRustClient$observeSinglePush$$inlined$map$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.lark.kmp.rustclient.internal.UserRustClient$observeSinglePush$$inlined$filter$1] */
    @Override // com.lark.kmp.rustclient.api.d
    public final UserRustClient$observeSinglePush$$inlined$map$1 a(final Command r3, final ProtoAdapter r4) {
        Intrinsics.checkNotNullParameter(r3, "command");
        Intrinsics.checkNotNullParameter(r4, "responseProtoAdapter");
        final a1 r0 = kotlinx.coroutines.flow.e.a(this.f.d);
        final ?? r1 = new UserRustClient$observeSinglePush$$inlined$filter$1(r0, r3);
        return new UserRustClient$observeSinglePush$$inlined$map$1(r1, r4, r3);
    }

    public z(String r3, r r4, com.lark.kmp.rustclient.api.f r5, com.lark.kmp.rustclient.api.e r6, List r7, t r8, gy7.i r9) {
        List r0 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "definition");
        Intrinsics.checkNotNullParameter(r5, "rustSDK");
        Intrinsics.checkNotNullParameter(r6, "containerHolder");
        Intrinsics.checkNotNullParameter(r7, "invokeInterceptors");
        Intrinsics.checkNotNullParameter(r0, "pushInterceptors");
        Intrinsics.checkNotNullParameter(r8, "receiverRegistry");
        Intrinsics.checkNotNullParameter(r9, "passport");
        super(r5, r6, CollectionsKt.plus(CollectionsKt.listOf(new AbsentInterceptor()), r7));
        this.e = r3;
        e0 r10 = new e0(r4, CollectionsKt.plus(CollectionsKt.listOf(new b(r3)), r0));
        this.f = r10;
        r9.d(r10);
        r8.a(r3, r10);
    }
}
