package com.cronutils.model.definition;

import com.cronutils.model.CronType;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.FieldDefinition;
import com.cronutils.model.field.definition.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<CronFieldName, FieldDefinition> f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<CronConstraint> f3413b;
    private final Set<CronNicknames> c;
    private boolean d;

    /* JADX INFO: renamed from: com.cronutils.model.definition.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3414a = null;

        static {
            int[] r0 = new int[CronType.values().length];
            f3414a = r0;
            r0[CronType.CRON4J.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f3414a[CronType.QUARTZ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f3414a[CronType.UNIX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f3414a[CronType.SPRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f3414a[CronType.SPRING53.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private b() {
        this.f3412a = new EnumMap(CronFieldName.class);
        this.f3413b = new HashSet();
        this.c = new HashSet();
    }

    public static CronDefinition a(CronType r3) {
        int r0 = AnonymousClass1.f3414a[r3.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L15;
        return u();
    L15:
        throw new IllegalArgumentException(String.format("No cron definition found for %s", new Object[]{r3}));
    L17:
        return t();
    L19:
        return v();
    L21:
        return s();
    L23:
        return r();
    }

    public static b a() {
        return new b();
    }

    private static CronDefinition r() {
        return a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(0, 31).f().b().a().f().e(1, 12).b().a().g().a(0, 6).a(1).b().a().i().q();
    }

    private static CronDefinition s() {
        return a().b().e(0, 59).a().c().e(0, 59).a().d().e(0, 23).a().e().c(1, 31).f().g().h().d().a().f().e(1, 12).a().g().a(1, 7).a(2).e().f().d().a().h().e(1970, 2099).b().c().a().a(a.a()).q();
    }

    private static CronDefinition t() {
        return a().b().e(0, 59).b().a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(1, 31).d().a().f().e(1, 12).a().g().a(0, 7).a(1).b(7, 0).e().d().a().q();
    }

    private static CronDefinition u() {
        return a().b().e(0, 59).b().a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(1, 31).f().g().h().d().a().f().e(1, 12).a().g().a(0, 7).a(1).b(7, 0).e().f().d().a().j().k().l().m().n().o().p().q();
    }

    private static CronDefinition v() {
        return a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(1, 31).b().a().f().e(1, 12).b().a().g().a(0, 7).a(1).b(7, 0).b().a().q();
    }

    public b a(CronConstraint r2) {
        this.f3413b.add(r2);
        return this;
    }

    public void a(FieldDefinition r5) {
        Iterator<FieldDefinition> r0 = this.f3412a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((FieldDefinition) ZeusTransformUtils.preCheckCast(r0.next(), FieldDefinition.class, "com.obric.memorydata.plugin")).isOptional() == false) goto L4;
        boolean r1 = true;
    L10:
        if (r5.isOptional() == true) goto L15;
        if (r1 == false) goto L15;
        throw new IllegalArgumentException("Can't register mandatory definition after a optional definition.");
    L15:
        this.f3412a.put(r5.getFieldName(), r5);
        return;
    L8:
        r1 = false;
        goto L10
    }

    public com.cronutils.model.field.definition.b b() {
        return new com.cronutils.model.field.definition.b(this, CronFieldName.SECOND);
    }

    public com.cronutils.model.field.definition.b c() {
        return new com.cronutils.model.field.definition.b(this, CronFieldName.MINUTE);
    }

    public com.cronutils.model.field.definition.b d() {
        return new com.cronutils.model.field.definition.b(this, CronFieldName.HOUR);
    }

    public d e() {
        return new d(this, CronFieldName.DAY_OF_MONTH);
    }

    public com.cronutils.model.field.definition.b f() {
        return new com.cronutils.model.field.definition.b(this, CronFieldName.MONTH);
    }

    public com.cronutils.model.field.definition.a g() {
        return new com.cronutils.model.field.definition.a(this, CronFieldName.DAY_OF_WEEK);
    }

    public com.cronutils.model.field.definition.b h() {
        return new com.cronutils.model.field.definition.b(this, CronFieldName.YEAR);
    }

    public b i() {
        this.d = true;
        return this;
    }

    public b j() {
        this.c.add(CronNicknames.YEARLY);
        return this;
    }

    public b k() {
        this.c.add(CronNicknames.ANNUALLY);
        return this;
    }

    public b l() {
        this.c.add(CronNicknames.MONTHLY);
        return this;
    }

    public b m() {
        this.c.add(CronNicknames.WEEKLY);
        return this;
    }

    public b n() {
        this.c.add(CronNicknames.DAILY);
        return this;
    }

    public b o() {
        this.c.add(CronNicknames.MIDNIGHT);
        return this;
    }

    public b p() {
        this.c.add(CronNicknames.HOURLY);
        return this;
    }

    public CronDefinition q() {
        HashSet r0 = new HashSet();
        r0.addAll(this.f3413b);
        ArrayList r1 = new ArrayList(this.f3412a.values());
        r1.sort(FieldDefinition.createFieldDefinitionComparator());
        return new CronDefinition(r1, r0, this.c, this.d);
    }
}
