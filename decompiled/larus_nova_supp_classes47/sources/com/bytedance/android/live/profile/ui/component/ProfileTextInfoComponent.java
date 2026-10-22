package com.bytedance.android.live.profile.ui.component;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.c1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.event.SpreadStateType;
import com.bytedance.android.live.profile.model.CompareOperation;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.view.ProfileSpreadIconView;
import com.bytedance.android.live.profile.ui.component.view.ProfileTextView;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileTextInfoComponent extends DataAssembler<st0.g> {
    public Disposable g;
    public final Lazy h;
    public final com.bytedance.android.live.profile.ui.base.l i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ProfileTextInfoComponent a;

        public a(ProfileTextInfoComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.profile.event.a r5 = (com.bytedance.android.live.profile.event.a) r4;
            if (r5 == null) goto L29;
            ProfileTextInfoComponent r0 = this.a;
            com.bytedance.android.live.profile.ui.base.m r1 = com.bytedance.android.live.profile.ui.base.i.n((com.bytedance.android.live.profile.ui.base.h) r0.h.getValue());
            if (r1 == null) goto L26;
            com.bytedance.android.live.profile.ui.base.n r2 = r1.findView(2131380831);
            if (r2 == null) goto L30;
            com.bytedance.android.live.profile.ui.base.m r3 = com.bytedance.android.live.profile.ui.base.i.n((com.bytedance.android.live.profile.ui.base.h) r0.h.getValue());
            if (r3 == null) goto L27;
            com.bytedance.android.live.profile.ui.base.n r6 = r3.findView(2131380568);
            if (r6 != null) goto L16;
            return;
        L16:
            if (r5.a != SpreadStateType.Open) goto L21;
            r6.a(180.0f);
            ViewGroup.LayoutParams r7 = r2.getLayoutParams();
            if (r7 == null) goto L20;
            r7.height = -2;
        L20:
            Unit r8 = Unit.INSTANCE;
            r2.setLayoutParams(r7);
            return;
        L21:
            r6.a(0.0f);
            ViewGroup.LayoutParams r9 = r2.getLayoutParams();
            if (r9 == null) goto L24;
            r9.height = 0;
        L24:
            Unit r10 = Unit.INSTANCE;
            r2.setLayoutParams(r9);
            return;
        L27:
            return;
        L30:
            return;
        L26:
            return;
        }
    }

    public static final class b extends fm3.b {
        public final /* synthetic */ com.bytedance.android.live.profile.ui.component.base.c d;
        public final /* synthetic */ ProfileTextInfoComponent e;
        public final /* synthetic */ NewProfileUser f;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            this.e.n(r4, this.f, (st0.g) this.d.c);
        }

        public b(com.bytedance.android.live.profile.ui.component.base.c r1, ProfileTextInfoComponent r2, NewProfileUser r3) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            super(0);
        }
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.g;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.TextInfo.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r5, "user");
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.android.live.profile.ui.component.base.c r1 = (com.bytedance.android.live.profile.ui.component.base.c) r0.next();
        com.bytedance.android.live.profile.ui.component.base.e<T> r2 = r1.d;
        if (r2 == 0) goto L4;
        r2.a(r1.c, r5, this.e.a().getLogUseCaseForUi());
        goto L4
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        a(r2);
        if (((com.bytedance.android.live.profile.ui.base.h) this.h.getValue()).isMyLive() == false) goto L9;
        Disposable r3 = this.g;
        if (r3 == null) goto L7;
        r3.dispose();
    L7:
        this.g = ((com.bytedance.android.live.profile.ui.base.h) this.h.getValue()).getEventHub().a.subscribe(new a(this));
        return;
    }

    public final String o(NewProfileUser r6) {
        if (r6.followInfo != null) goto L7;
        return "";
    L7:
        if (((Boolean) rs0.p.a.getValue()).booleanValue() == true) goto L9;
    L21:
        String r0 = c1.a(r6.followInfo.getFollowerCount());
        String r1 = c1.a(r6.followInfo.getFollowingCount());
    L22:
        String r2 = s1.B(2131919752);
        String r3 = s1.B(2131919751);
        c0 r7 = r6.followInfo;
        if (r7 == null) goto L28;
        if (r7.getFollowerCountEnable() == true) goto L28;
        return r1 + ' ' + r2;
    L28:
        return r1 + ' ' + r2 + " · " + r0 + ' ' + r3;
    L9:
        if (this.i.getTargetType() == 2) goto L21;
        c0 r4 = r6.followInfo;
        r1 = DataType.FALSE;
        if (r4 == null) goto L15;
        r0 = r4.getFollowerCountStr();
        if (r0 == null) goto L15;
    L16:
        c0 r5 = r6.followInfo;
        if (r5 == null) goto L22;
        String r8 = r5.getFollowingCountStr();
        if (r8 == null) goto L22;
        r1 = r8;
    L15:
        r0 = DataType.FALSE;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r10) {
        Intrinsics.checkNotNullParameter(r10, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileTextInfoComponent update");
        StringBuilder r1 = new StringBuilder("TextInfo preload: ");
        Collection r2 = this.d;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = ((ArrayList) r2).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        com.bytedance.android.live.profile.ui.component.base.c r5 = (com.bytedance.android.live.profile.ui.component.base.c) r4.next();
        r3.add(TuplesKt.to(Integer.valueOf(r5.getType()), ((st0.g) r5.c).b));
        goto L4
    L6:
        r1.append(r3);
        ALogger.e("NewUserProfile_ProfilePre", r1.toString());
        Iterator r6 = ((ArrayList) this.d).iterator();
    L7:
        boolean r7 = false;
        if (r6.hasNext() == false) goto L40;
        com.bytedance.android.live.profile.ui.component.base.c r8 = (com.bytedance.android.live.profile.ui.component.base.c) r6.next();
        st0.g r9 = (st0.g) r8.c;
        int r12 = r8.getType();
        if (r12 != 0) goto L12;
        String r13 = o(r10);
    L16:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r9.b = r13;
        if (r8.d == null) goto L25;
        if (((st0.g) r8.c).b.length() != 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L25;
        r8.a(CompareOperation.Remove);
        goto L7
    L21:
        r14 = false;
    L25:
        if (r8.d == null) goto L33;
        if (((st0.g) r8.c).b.length() <= 0) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == false) goto L33;
        r8.a(CompareOperation.Update);
        goto L7
    L29:
        r15 = false;
    L33:
        if (r8.d != null) goto L39;
        if (((st0.g) r8.c).b.length() <= 0) goto L37;
        r7 = true;
    L37:
        if (r7 == false) goto L39;
        r8.a(CompareOperation.Create);
    L39:
        r8.a(CompareOperation.Nothing);
        goto L7
    L12:
        if (r12 == 5) goto L14;
        r13 = "";
        goto L16
    L14:
        r13 = "SpreadIcon";
        goto L16
    L40:
        StringBuilder r16 = new StringBuilder("TextInfo update: ");
        Collection r17 = this.d;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = ((ArrayList) r17).iterator();
    L42:
        if (r19.hasNext() == false) goto L44;
        com.bytedance.android.live.profile.ui.component.base.c r20 = (com.bytedance.android.live.profile.ui.component.base.c) r19.next();
        r18.add(TuplesKt.to(Integer.valueOf(r20.getType()), TuplesKt.to(((st0.g) r20.c).b, r20.e.getDesc())));
        goto L42
    L44:
        r16.append(r18);
        ALogger.e("NewUserProfile_ProfilePre", r16.toString());
        this.f.removeAllViews();
        Iterator r0 = ((ArrayList) this.d).iterator();
    L45:
        Object r22 = null;
        if (r0.hasNext() == false) goto L67;
        com.bytedance.android.live.profile.ui.component.base.c r23 = (com.bytedance.android.live.profile.ui.component.base.c) r0.next();
        CompareOperation r24 = r23.e;
        int r25 = a0.a[r24.ordinal()];
        if (r25 != 1) goto L50;
        View r26 = j(r23.b, (com.bytedance.android.live.profile.ui.component.base.b) r23.c, r10);
        DataAssembler.m(r26, (com.bytedance.android.live.profile.ui.component.base.b) r23.c, r10);
        if ((r26 instanceof com.bytedance.android.live.profile.ui.component.base.e) == false) goto L66;
        r22 = r26;
    L66:
        r23.d = (com.bytedance.android.live.profile.ui.component.base.e) r22;
        goto L45
    L50:
        if (r25 != 2) goto L45;
        Object r27 = r23.d;
        if ((r27 instanceof View) == false) goto L56;
        r22 = r27;
    L56:
        View r28 = (View) r22;
        if (r28 == null) goto L59;
        this.f.addView(r28);
        r28.setOnClickListener(new b(r23, this, r10));
    L59:
        com.bytedance.android.live.profile.ui.component.base.e<T> r29 = r23.d;
        if (r29 == 0) goto L45;
        r29.update(r23.c, r10);
        goto L45
    L67:
        Iterator r110 = ((ArrayList) this.d).iterator();
    L69:
        if (r110.hasNext() == false) goto L80;
        Object r30 = r110.next();
        CompareOperation r32 = ((com.bytedance.android.live.profile.ui.component.base.c) r30).e;
        if (r32 != CompareOperation.Create) goto L73;
    L76:
        boolean r33 = true;
    L77:
        if (r33 == false) goto L69;
        r22 = r30;
        goto L80
    L73:
        if (r32 == CompareOperation.Update) goto L76;
        r33 = false;
    L80:
        if (((com.bytedance.android.live.profile.ui.component.base.c) r22) == null) goto L82;
        this.f.setVisibility(0);
        return;
    L82:
        this.f.setVisibility(8);
    }

    public ProfileTextInfoComponent(com.bytedance.android.live.profile.ui.base.l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        Intrinsics.checkNotNullParameter(r3, "container");
        super(r2, r3);
        this.i = r2;
        this.h = LazyKt.lazy(new ProfileTextInfoComponent$profileContext$2(this));
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r12, NewProfileUser r13) {
        st0.g r14 = (st0.g) r12;
        Intrinsics.checkNotNullParameter(r14, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r13, "user");
        int r0 = r14.getType();
        boolean r3 = false;
        if (r0 != 0) goto L5;
        ProfileTextView r1 = new ProfileTextView(this.f.getContext(), null, 6, 0);
        r1.setCanClick(false);
        String r15 = o(r13);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.b = r15;
        View r16 = r1;
    L15:
        if (r14.b.length() != 0) goto L17;
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return null;
    L20:
        return r16;
    L5:
        if (r0 != 2) goto L7;
        r16 = new ProfileTextView(this.f.getContext(), null, 6, 0);
        if (TextUtils.isEmpty(r14.b) == true) goto L15;
        String r2 = StringsKt.replace$default(r14.b, "\n", " ", false, 4, null);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r14.b = r2;
        goto L15
    L7:
        if (r0 == 5) goto L9;
        r16 = null;
        goto L15
    L9:
        r16 = new ProfileSpreadIconView(this.f.getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter("SpreadIcon", "<set-?>");
        r14.b = "SpreadIcon";
        goto L15
    }
}
