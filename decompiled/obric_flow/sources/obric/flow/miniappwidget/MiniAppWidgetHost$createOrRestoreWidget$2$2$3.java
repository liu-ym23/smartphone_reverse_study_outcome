package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class MiniAppWidgetHost$createOrRestoreWidget$2$2$3 extends FunctionReferenceImpl implements Function3<a, String, String, Unit> {
    public MiniAppWidgetHost$createOrRestoreWidget$2$2$3(Object r10) {
        super(3, r10, l.class, "invalidateWidgetRender", "invalidateWidgetRender(Lobric/flow/miniappwidget/MiniAppHostedWidget;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(a r5, String r10, String r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "p0");
        Intrinsics.checkNotNullParameter(r20, "p1");
        l r5 = (l) this.receiver;
        if (((a) r5.f.get(r19.f20457b)) == r19) goto L9;
        String r10 = r5.f20491a;
        String r11 = r19.f20457b;
        String r12 = r19.f20458c;
        String r13 = r19.d;
        String r14 = r19.e;
        StringBuilder r15 = androidx.constraintlayout.motion.widget.a.y("invalidateWidgetRender skipped: stale widget hostId=", r10, " instanceId=", r11, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r15, r12, " appletId=", r13, " widgetId=");
        String r16 = androidx.constraintlayout.motion.widget.a.t(r15, r14, " reason=", r20);
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L8;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r16);
        return;
    L8:
        throw new IllegalStateException("KoinApplication has not been started");
    L9:
        r5.f.remove(r19.f20457b, r19);
        if (r21 == null) goto L12;
        r5.f20495i.put(r19.f20457b, r21);
    L12:
        String r18 = r5.f20491a;
        String r22 = r19.f20457b;
        String r23 = r19.f20458c;
        String r24 = r19.d;
        String r25 = r19.e;
        StringBuilder r26 = androidx.constraintlayout.motion.widget.a.y("invalidateWidgetRender hostId=", r18, " instanceId=", r22, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r26, r23, " appletId=", r24, " widgetId=");
        String r27 = androidx.constraintlayout.motion.widget.a.t(r26, r25, " reason=", r20);
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r27, "msg");
        org.koin.core.a r28 = su.a.f22013b;
        if (r28 == null) goto L19;
        ((ju.b) r28.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r27);
        r19.a();
        Function2 r29 = r5.f20500n;
        if (r29 == null) goto L21;
        r29.mo2invoke(r19.f20457b, r20);
        return;
    L21:
        return;
    L19:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
