package com.obric.memorydata.personalcontext.external;

import android.content.ContentResolver;
import android.content.Context;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalCollectorEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "context", "Landroid/content/Context;", "supportTypes", "", "", "<init>", "(Landroid/content/Context;Ljava/util/Set;)V", "getContext", "()Landroid/content/Context;", "getSupportTypes", "()Ljava/util/Set;", "provideAllEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements EntitySupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12103b;
    private final Set<Integer> c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalCollectorEntitySupplier$Companion;", "", "<init>", "()V", "getAllEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "context", "Landroid/content/Context;", "supportTypes", "", "", "actionAfterGetContact", "Lkotlin/Function0;", "", "actionAfterGetMessage", "actionAfterGetCallHistory", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ List a(a r2, Context r3, Set r4, Function0 r5, Function0 r6, Function0 r7, int r8, Object r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Set<Integer> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Function0<Unit> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
            if ((r8 & 4) == 0) goto L5;
            r12 = $$Lambda$b$a$1dmqlgASTj_jEfERf88tB9nl0eg.INSTANCE;
        L5:
            Function0<Unit> r15 = r12;
            if ((r8 & 8) == 0) goto L8;
            Function0<Unit> r0 = $$Lambda$b$a$4B3H1Nyxhakjk1wsWK5n3bKtxDk.INSTANCE;
        L10:
            if ((r8 & 16) == 0) goto L12;
            Function0<Unit> r1 = $$Lambda$b$a$vTPTlFwyvNU8KEm2rqk6yTkgfY0.INSTANCE;
        L14:
            return r2.a(r10, r11, r15, r0, r1);
        L12:
            r1 = r14;
            goto L14
        L8:
            r0 = r13;
            goto L10
        }

        private static final Unit a() {
            return Unit.INSTANCE;
        }

        private static final Unit b() {
            return Unit.INSTANCE;
        }

        private static final Unit c() {
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$1dmqlgASTj_jEfERf88tB9nl0eg() {
            return a();
        }

        public static /* synthetic */ Unit lambda$4B3H1Nyxhakjk1wsWK5n3bKtxDk() {
            return b();
        }

        public static /* synthetic */ Unit lambda$vTPTlFwyvNU8KEm2rqk6yTkgfY0() {
            return c();
        }

        public final List<AppEntity> a(Context r4, Set<Integer> r5, Function0<Unit> r6, Function0<Unit> r7, Function0<Unit> r8) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
            Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r9, "supportTypes");
            Intrinsics.checkNotNullParameter(r10, "actionAfterGetContact");
            Intrinsics.checkNotNullParameter(r11, "actionAfterGetMessage");
            Intrinsics.checkNotNullParameter(r12, "actionAfterGetCallHistory");
            List<AppEntity> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            ContentResolver r14 = r3.getContentResolver();
            if (g.f12138a.d() == false) goto L8;
            if (r9.contains(202) == false) goto L8;
            com.obric.memorydata.personalcontext.external.b.a r1 = com.obric.memorydata.personalcontext.external.b.a.f12104a;
            Intrinsics.checkNotNull(r14);
            r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r1.a(r14), Collection.class, "com.obric.memorydata.plugin"));
            r12.invoke();
        L8:
            if (g.f12138a.e() == false) goto L13;
            if (r9.contains(201) == false) goto L13;
            com.obric.memorydata.personalcontext.external.c.a r15 = com.obric.memorydata.personalcontext.external.c.a.f12109a;
            Intrinsics.checkNotNull(r14);
            r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r15.a(r14), Collection.class, "com.obric.memorydata.plugin"));
            r10.invoke();
        L13:
            if (g.f12138a.c() == true) goto L15;
        L17:
            return r13;
        L15:
            if (r9.contains(101) == false) goto L17;
            com.obric.memorydata.personalcontext.external.message.b r16 = com.obric.memorydata.personalcontext.external.message.b.f12147a;
            Intrinsics.checkNotNull(r14);
            r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r16.a(r14), Collection.class, "com.obric.memorydata.plugin"));
            r11.invoke();
            goto L17
        }
    }

    static {
        f12102a = new a(null);
    }

    public b(Context r3, Set<Integer> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Set<Integer> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "supportTypes");
        this.f12103b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r6;
    }

    public final Context getContext() {
        return this.f12103b;
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        return a.a(f12102a, this.f12103b, this.c, null, null, null, 28, null);
    }
}
