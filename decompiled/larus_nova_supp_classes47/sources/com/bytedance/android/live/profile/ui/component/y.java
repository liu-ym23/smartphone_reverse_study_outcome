package com.bytedance.android.live.profile.ui.component;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.model.CompareOperation;
import com.bytedance.android.live.profile.ui.AudienceSeeSelfBehavior;
import com.bytedance.android.live.profile.ui.NoAuthorityAudienceBehavior;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.view.ProfileAnnounceView;
import com.bytedance.android.live.profile.ui.component.view.ProfilePushView;
import com.bytedance.android.live.profile.ui.component.view.ProfileTextView;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rs0.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y extends DataAssembler<st0.g> {
    public static final /* synthetic */ int g = 0;

    public static final class a {
        public static String a(NewProfileUser r4) {
            Intrinsics.checkNotNullParameter(r4, "user");
            com.bytedance.android.live.base.model.user.p r0 = r4.anchorLiveConfig;
            String r1 = null;
            if (r0 != null) goto L5;
        L20:
            return null;
        L5:
            if (r0.getScheduledMasterSwitch() != 1) goto L20;
            com.bytedance.android.live.base.model.user.p r2 = r4.anchorLiveConfig;
            if (r2 == null) goto L20;
            String r3 = r2.getScheduledTimeText();
            if (r3 == null) goto L20;
            if (r3.length() <= 0) goto L13;
            boolean r5 = true;
        L14:
            if (r5 != true) goto L20;
            Object[] r6 = new Object[1];
            com.bytedance.android.live.base.model.user.p r7 = r4.anchorLiveConfig;
            if (r7 == null) goto L18;
            r1 = r7.getScheduledTimeText();
        L18:
            r6[0] = r1;
            return s1.C(2131920692, r6);
        L13:
            r5 = false;
            goto L14
        }

        public static String b(NewProfileUser r6) {
            Intrinsics.checkNotNullParameter(r6, "user");
            String r0 = r6.baseProfileInfo.signature;
            if (TextUtils.isEmpty(r0) == false) goto L7;
            return null;
        L7:
            return StringsKt.replace$default(r0, "\n", " ", false, 4, null);
        }
    }

    public static final class b extends fm3.b {
        public final /* synthetic */ com.bytedance.android.live.profile.ui.component.base.c d;
        public final /* synthetic */ y e;
        public final /* synthetic */ NewProfileUser f;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            this.e.n(r4, this.f, (st0.g) this.d.c);
        }

        public b(com.bytedance.android.live.profile.ui.component.base.c r1, y r2, NewProfileUser r3) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            super(0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.TextDesc.INSTANCE;
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
        a(r2);
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
    public void update(NewProfileUser r12) {
        Intrinsics.checkNotNullParameter(r12, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileTextDescComponent update");
        StringBuilder r1 = new StringBuilder("TextDesc preload: ");
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
        if (r6.hasNext() == false) goto L65;
        com.bytedance.android.live.profile.ui.component.base.c r8 = (com.bytedance.android.live.profile.ui.component.base.c) r6.next();
        st0.g r9 = (st0.g) r8.c;
        int r10 = r8.getType();
        if (r10 == 2) goto L30;
        if (r10 != 3) goto L14;
    L26:
        String r13 = a.a(r12);
        if (r13 == null) goto L40;
    L41:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r9.b = r13;
        if (r8.d == null) goto L50;
        if (((st0.g) r8.c).b.length() != 0) goto L46;
        boolean r14 = true;
    L47:
        if (r14 == false) goto L50;
        r8.a(CompareOperation.Remove);
        goto L7
    L46:
        r14 = false;
    L50:
        if (r8.d == null) goto L58;
        if (((st0.g) r8.c).b.length() <= 0) goto L54;
        boolean r15 = true;
    L55:
        if (r15 == false) goto L58;
        r8.a(CompareOperation.Update);
        goto L7
    L54:
        r15 = false;
    L58:
        if (r8.d != null) goto L64;
        if (((st0.g) r8.c).b.length() <= 0) goto L62;
        r7 = true;
    L62:
        if (r7 == false) goto L64;
        r8.a(CompareOperation.Create);
    L64:
        r8.a(CompareOperation.Nothing);
    L40:
        r13 = "";
        goto L41
    L14:
        if (r10 != 4) goto L16;
        BaseProfileInfo r16 = r12.baseProfileInfo;
        if (r16 == null) goto L40;
        r13 = r16.signature;
        if (r13 != null) goto L41;
    L16:
        if (r10 == 6) goto L26;
        if (r10 != 7) goto L40;
        r13 = s1.B(2131919560);
        goto L41
    L30:
        if ((this.e instanceof NoAuthorityAudienceBehavior) == false) goto L32;
        r13 = s1.B(2131915014);
    L33:
        if (r13 != null) goto L41;
        com.bytedance.android.live.profile.ui.base.l r17 = this.e;
        if ((r17 instanceof AudienceSeeSelfBehavior) == false) goto L38;
        r13 = s1.B(2131920697);
        goto L41
    L38:
        if ((r17 instanceof NoAuthorityAudienceBehavior) == false) goto L40;
        r13 = s1.B(2131915014);
        goto L41
    L32:
        r13 = a.b(r12);
        goto L33
    L65:
        StringBuilder r18 = new StringBuilder("TextDesc update: ");
        Collection r19 = this.d;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r22 = ((ArrayList) r19).iterator();
    L67:
        if (r22.hasNext() == false) goto L69;
        com.bytedance.android.live.profile.ui.component.base.c r23 = (com.bytedance.android.live.profile.ui.component.base.c) r22.next();
        r20.add(TuplesKt.to(Integer.valueOf(r23.getType()), TuplesKt.to(((st0.g) r23.c).b, r23.e.getDesc())));
        goto L67
    L69:
        r18.append(r20);
        ALogger.e("NewUserProfile_ProfilePre", r18.toString());
        this.f.removeAllViews();
        Iterator r0 = ((ArrayList) this.d).iterator();
    L70:
        Object r24 = null;
        if (r0.hasNext() == false) goto L96;
        com.bytedance.android.live.profile.ui.component.base.c r25 = (com.bytedance.android.live.profile.ui.component.base.c) r0.next();
        CompareOperation r26 = r25.e;
        int r27 = z.a[r26.ordinal()];
        if (r27 != 1) goto L74;
        View r28 = j(r25.b, (com.bytedance.android.live.profile.ui.component.base.b) r25.c, r12);
        DataAssembler.m(r28, (com.bytedance.android.live.profile.ui.component.base.b) r25.c, r12);
        if ((r28 instanceof com.bytedance.android.live.profile.ui.component.base.e) == false) goto L95;
        r24 = r28;
    L95:
        r25.d = (com.bytedance.android.live.profile.ui.component.base.e) r24;
        goto L70
    L74:
        if (r27 != 2) goto L70;
        Object r29 = r25.d;
        if ((r29 instanceof View) == false) goto L80;
        r24 = r29;
    L80:
        View r30 = (View) r24;
        if (r30 == null) goto L83;
        this.f.addView(r30);
        r30.setOnClickListener(new b(r25, this, r12));
    L83:
        com.bytedance.android.live.profile.ui.component.base.e<T> r32 = r25.d;
        if (r32 == 0) goto L87;
        r32.update(r25.c, r12);
    L87:
        if (((Boolean) p0.a.getValue()).booleanValue() == false) goto L70;
        com.bytedance.android.live.profile.ui.component.base.e<T> r33 = r25.d;
        if (r33 == 0) goto L70;
        r33.e(r25.c);
        goto L70
    L96:
        Iterator r110 = ((ArrayList) this.d).iterator();
    L98:
        if (r110.hasNext() == false) goto L109;
        Object r34 = r110.next();
        CompareOperation r35 = ((com.bytedance.android.live.profile.ui.component.base.c) r34).e;
        if (r35 != CompareOperation.Create) goto L102;
    L105:
        boolean r36 = true;
    L106:
        if (r36 == false) goto L98;
        r24 = r34;
        goto L109
    L102:
        if (r35 == CompareOperation.Update) goto L105;
        r36 = false;
    L109:
        if (((com.bytedance.android.live.profile.ui.component.base.c) r24) == null) goto L111;
        this.f.setVisibility(0);
        return;
    L111:
        this.f.setVisibility(8);
    }

    public y(com.bytedance.android.live.profile.ui.base.l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        Intrinsics.checkNotNullParameter(r3, "container");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r7, NewProfileUser r8) {
        st0.g r9 = (st0.g) r7;
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r8, "user");
        if (r9.b.length() != 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == true) goto L30;
        int r12 = r9.getType();
        String r4 = "";
        if (r12 != 6) goto L12;
        ProfileAnnounceView r13 = new ProfileAnnounceView(this.f.getContext(), null, 6, 0);
        r13.setCanClick(false);
        DataCenter r14 = this.e.b().getRoomDataCenter();
        if (r14 == null) goto L27;
        String r15 = (String) r14.get("enter_from_merge");
        if (r15 == null) goto L27;
        r4 = r15;
    L27:
        r13.setEnterFromMerge(r4);
        r13.setProfileContext(this.e.b());
        View r16 = r13;
    L29:
        return r16;
    L12:
        if (r12 == 7) goto L14;
        ProfileTextView r17 = new ProfileTextView(this.f.getContext(), null, 6, 0);
        r17.setCanClick(false);
        r16 = r17;
        goto L29
    L14:
        ProfilePushView r18 = new ProfilePushView(this.f.getContext(), null, 6, 0);
        r18.setCanClick(true);
        DataCenter r19 = this.e.b().getRoomDataCenter();
        if (r19 == null) goto L20;
        String r20 = (String) r19.get("enter_from_merge");
        if (r20 == null) goto L20;
        r4 = r20;
    L20:
        r18.setEnterFromMerge(r4);
        r18.setProfileContext(this.e.b());
        r16 = r18;
        goto L29
    L30:
        return null;
    L5:
        r10 = false;
        goto L7
    }
}
