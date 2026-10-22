package com.bytedance.android.live.revlink.link.domain.service;

import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
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
public final class RevLinkBizScopeAudienceLaunchService implements o {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public n51.d b;
    public final h c;
    public final p51.b d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.service.RevLinkBizScopeAudienceLaunchService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(RevLinkBizScopeAudienceLaunchService r8) {
            super(1, r8, RevLinkBizScopeAudienceLaunchService.class, "handleBizEnd", "handleBizEnd(Ljava/lang/Integer;)V", 0);
        }

        public final void invoke(Integer r3) {
            RevLinkBizScopeAudienceLaunchService r0 = (RevLinkBizScopeAudienceLaunchService) ((CallableReference) this).receiver;
            int r1 = RevLinkBizScopeAudienceLaunchService.e;
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

    public final void onStart() {
        PublishSubject<Integer> r0 = this.c.d.f;
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        f.a(r0.subscribe(new b(r1)), this.a);
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", "onStart " + hashCode() + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
    }

    public final void onStop() {
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", "onStop " + hashCode() + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
        StringBuilder r0 = new StringBuilder("end biz scope with multiBizScope=");
        r0.append(this.b);
        r0.append(" isEntered=");
        n51.d r5 = this.b;
        if (r5 == null) goto L5;
        Boolean r6 = Boolean.valueOf(l.b(r5));
    L6:
        r0.append(r6);
        r0.append("  ");
        r0.append(hashCode());
        r0.append(' ');
        r0.append(ExceptionsKt.stackTraceToString(new Error()));
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", r0.toString(), null, 4);
        n51.d r1 = this.b;
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.link.utils.a.c(r1);
    L9:
        this.b = null;
        this.a.clear();
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void a(String r4) {
        String r2 = null;
        jy0.b.c("RevLinkBizScopeAnchorLaunchService", "refreshBizScope with source: " + r4 + "  " + hashCode() + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
        if (this.b != null) goto L29;
        p51.b r5 = this.d;
        Intrinsics.checkNotNullParameter(r5, "domainAudienceScope");
        n51.d r0 = new n51.d(r5);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r6 = k.a;
        if (r0.e != r6) goto L8;
        r2 = "context";
    L25:
        if (r2 != null) goto L28;
        this.b = r0;
        l.a(r0);
        return;
    L28:
        throw new UninitializedPropertyAccessException(r2);
    L8:
        if (r0.f != r6) goto L11;
        r2 = "linkInternalDataSet";
        goto L25
    L11:
        if (r0.g != r6) goto L14;
        r2 = "dynamicLayoutClient";
        goto L25
    L14:
        if (r0.h != r6) goto L17;
        r2 = "linkDataScope";
        goto L25
    L17:
        if (r0.i != r6) goto L20;
        r2 = "revenueInstance";
        goto L25
    L20:
        if (r0.j != r6) goto L23;
        r2 = "revenueInstanceExt";
        goto L25
    L23:
        if (r0.k != r6) goto L25;
        r2 = "roomInstance";
        goto L25
    }

    public RevLinkBizScopeAudienceLaunchService(h r2, p51.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "domainAudienceScope");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
    }
}
