package com.bytedance.android.live.revlink.link.domain.service;

import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.f;
import e33.k;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkBizScopeAnchorLaunchService implements o {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public n51.c b;
    public final g c;
    public final p51.a d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkBizScopeAnchorLaunchService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(RevLinkBizScopeAnchorLaunchService r8) {
            super(1, r8, RevLinkBizScopeAnchorLaunchService.class, "handleBizEnd", "handleBizEnd(Ljava/lang/Integer;)V", 0);
        }

        public final void invoke(Integer r3) {
            RevLinkBizScopeAnchorLaunchService r0 = (RevLinkBizScopeAnchorLaunchService) ((CallableReference) this).receiver;
            int r1 = RevLinkBizScopeAnchorLaunchService.e;
            r0.getClass();
            if (r3 == null) goto L6;
            r3.intValue();
            r3.intValue();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Integer) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void a() {
        StringBuilder r0 = new StringBuilder("end biz scope with multiBizScope=");
        r0.append(this.b);
        r0.append(" isEntered=");
        n51.c r1 = this.b;
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(l.b(r1));
    L6:
        r0.append(r2);
        r0.append("  ");
        r0.append(hashCode());
        r0.append(' ');
        r0.append(ExceptionsKt.stackTraceToString(new Error()));
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", r0.toString(), null, 4);
        n51.c r3 = this.b;
        if (r3 == null) goto L9;
        com.bytedance.android.live.revlink.link.utils.a.c(r3);
    L9:
        this.b = null;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onStart() {
        PublishSubject<Integer> r0 = this.c.d.f;
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        f.a(r0.subscribe(new b(r1)), this.a);
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", "onStart " + hashCode() + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
    }

    public final void onStop() {
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", "onStop " + hashCode() + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
        a();
        this.a.clear();
    }

    public final void c(String r4) {
        String r2 = null;
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", "refreshBizScope with source: " + r4 + "  " + hashCode() + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
        if (this.b != null) goto L41;
        p51.a r5 = this.d;
        Intrinsics.checkNotNullParameter(r5, "domainAnchorScope");
        n51.c r0 = new n51.c(r5);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r6 = k.a;
        if (r0.e != r6) goto L8;
        r2 = "context";
    L37:
        if (r2 != null) goto L40;
        this.b = r0;
        l.a(r0);
        return;
    L40:
        throw new UninitializedPropertyAccessException(r2);
    L8:
        if (r0.f != r6) goto L11;
        r2 = "dynamicLayoutClient";
        goto L37
    L11:
        if (r0.g != r6) goto L14;
        r2 = "linkInternalDataSet";
        goto L37
    L14:
        if (r0.h != r6) goto L17;
        r2 = "linkInstanceService";
        goto L37
    L17:
        if (r0.i != r6) goto L20;
        r2 = "anchorRtcManager";
        goto L37
    L20:
        if (r0.j != r6) goto L23;
        r2 = "linkOutManager";
        goto L37
    L23:
        if (r0.k != r6) goto L26;
        r2 = "revLinkHostService";
        goto L37
    L26:
        if (r0.l != r6) goto L29;
        r2 = "linkDataScope";
        goto L37
    L29:
        if (r0.m != r6) goto L32;
        r2 = "revenueInstance";
        goto L37
    L32:
        if (r0.n != r6) goto L35;
        r2 = "revenueInstanceExt";
        goto L37
    L35:
        if (r0.o != r6) goto L37;
        r2 = "roomInstance";
        goto L37
    }

    public RevLinkBizScopeAnchorLaunchService(g r2, p51.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "domainAnchorScope");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
    }
}
