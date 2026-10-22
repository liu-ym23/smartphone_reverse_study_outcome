package com.ss.android.lark.contact.customized.department;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Department;
import com.bytedance.lark.pb.contact.v1.DepartmentLeader;
import com.bytedance.lark.pb.contact.v1.DepartmentStructure;
import com.bytedance.lark.pb.contact.v1.ExtendFields;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatResponse;
import com.bytedance.lark.pb.contact.v1.ProfileFields;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.ss.android.lark.pb.department.ContactDisplayModule;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;
import mtb.i;
import mtb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$fetchCurrent$2$1", f = "DepartmentStructureViewModel.kt", i = {0, 0}, l = {149}, m = "invokeSuspend", n = {"newState", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class DepartmentStructureViewModel$fetchCurrent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetDepartmentCombineChatResponse $resp;
    final /* synthetic */ DepartmentStructureViewModel.b $state;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DepartmentStructureViewModel this$0;

    public DepartmentStructureViewModel$fetchCurrent$2$1(DepartmentStructureViewModel.b r1, GetDepartmentCombineChatResponse r2, DepartmentStructureViewModel r3, Continuation<? super DepartmentStructureViewModel$fetchCurrent$2$1> r4) {
        this.$state = r1;
        this.$resp = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DepartmentStructureViewModel$fetchCurrent$2$1(this.$state, this.$resp, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.List] */
    public final Object invokeSuspend(Object r26) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        DepartmentStructureViewModel.b r1 = (DepartmentStructureViewModel.b) this.L$3;
        DepartmentStructureViewModel r3 = (DepartmentStructureViewModel) this.L$2;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$1;
        DepartmentStructureViewModel.b r6 = (DepartmentStructureViewModel.b) this.L$0;
        ResultKt.throwOnFailure(r26);
    L157:
        z0 r4 = DepartmentStructureViewModel.access$get_stack$p(r3);     // Catch: Throwable -> L154
        Iterable r7 = (Iterable) DepartmentStructureViewModel.access$get_stack$p(r3).getValue();     // Catch: Throwable -> L154
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L154
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L154
    L146:
        if (r9.hasNext() == false) goto L151;
        DepartmentStructureViewModel.b r10 = (DepartmentStructureViewModel.b) r9.next();     // Catch: Throwable -> L154
        if (Intrinsics.areEqual(r10, r1) == false) goto L150;
        r10 = r6;
    L150:
        r8.add(r10);     // Catch: Throwable -> L154
        goto L146
    L151:
        r4.setValue(r8);     // Catch: Throwable -> L154
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L154
        r5.unlock(null);
        return Unit.INSTANCE;
    L154:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        List<mtb.c> r12 = this.$state.b;
        int r13 = d.a;
        GetDepartmentCombineChatResponse r14 = this.$resp;
        GetAnotherNameFormatResponse.FormatRule r15 = DepartmentStructureViewModel.access$getNameDisplayRule$p(this.this$0);
        boolean r16 = this.$state.b.isEmpty();
        Intrinsics.checkNotNullParameter(r14, "response");
        Intrinsics.checkNotNullParameter(r15, "nameRule");
        List r17 = r14.display_order;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L10:
        if (r19.hasNext() == false) goto L115;
        Integer r110 = (Integer) r19.next();
        Intrinsics.checkNotNull(r110);
        int r111 = r110.intValue();
        ?? r112 = new ArrayList();
        DepartmentStructure r113 = r14.department_structure;
        if (r113 != null) goto L14;
        r112 = CollectionsKt.emptyList();
        Iterator r114 = r19;
    L114:
        r18.add(r112);
        r19 = r114;
        goto L10
    L14:
        List r115 = r113.sub_departments;
        List r116 = r113.chatters;
        if (r116 != null) goto L17;
        r116 = CollectionsKt.emptyList();
    L17:
        List r20 = r113.deptLeaders;
        if (r20 == null) goto L25;
        Sequence r21 = CollectionsKt.asSequence(r20);
        if (r21 == null) goto L25;
        Sequence r22 = SequencesKt.filterNotNull(r21);
        if (r22 == null) goto L25;
        Set r23 = SequencesKt.toSet(r22);
        if (r23 == null) goto L25;
    L26:
        Intrinsics.checkNotNullParameter(r23, "departmentLeaders");
        ArrayList r24 = new ArrayList();
        List r117 = r116;
        if (r117 != null) goto L29;
    L32:
        boolean r118 = true;
    L33:
        if (r118 == false) goto L35;
    L55:
        r114 = r19;
        if (r116 != null) goto L58;
        r116 = new ArrayList();
    L58:
        List r25 = r116;
    L59:
        List r27 = r113.administrator;
        if (r27 == null) goto L63;
        List r28 = CollectionsKt.filterNotNull(r27);
        if (r28 == null) goto L63;
    L64:
        List r29 = r113.super_administrator;
        if (r29 == null) goto L68;
        List r30 = CollectionsKt.filterNotNull(r29);
        if (r30 == null) goto L68;
    L69:
        List r31 = r113.deptLeaders;
        if (r111 != ContactDisplayModule.DISPLAY_MODULE_DEPARTMENT_LEADER.getValue()) goto L91;
        if (r16 == false) goto L114;
        Intrinsics.checkNotNull(r31);
        if ((!r31.isEmpty()) == false) goto L114;
        Iterator r32 = r31.iterator();
    L76:
        if (r32.hasNext() == false) goto L114;
        Chatter r33 = ((DepartmentLeader) r32.next()).leader;
        if (r33 == null) goto L76;
        if (TextUtils.isEmpty(r33.id) == true) goto L76;
        DepartmentUserDisplayFormatter r119 = DepartmentUserDisplayFormatter.a;
        r119.getClass();
        String r120 = DepartmentUserDisplayFormatter.a(r33, r15);
        String r121 = r33.id;
        String r122 = r33.avatar_key;
        boolean r210 = r28.contains(r121);
        Iterator r211 = r32;
        boolean r212 = r30.contains(r33.id);
        ExtendFields r34 = r14.extend_fields;
        if (r34 == null) goto L88;
        Map r35 = r34.user_profile_fields;
        if (r35 == null) goto L88;
        ProfileFields r36 = (ProfileFields) r35.get(r33.id);
        if (r36 == null) goto L88;
        List<GetUserProfileResponse.Field> r37 = r36.profile_fields;
    L89:
        r112.add(new j(r120, r121, r122, r210, r212, r119.b(r37)));
        r32 = r211;
    L88:
        r37 = null;
        goto L89
    L91:
        if (r111 != ContactDisplayModule.DISPLAY_MODULE_DEPARTMENT.getValue()) goto L99;
        if ((!r115.isEmpty()) == false) goto L114;
        Iterator r38 = r115.iterator();
    L96:
        if (r38.hasNext() == false) goto L114;
        Department r39 = (Department) r38.next();
        r112.add(new i(r39.name, r39.id));
        goto L96
    L99:
        if (r111 != ContactDisplayModule.DISPLAY_MODULE_USER.getValue()) goto L114;
        if (r25.size() <= 0) goto L114;
        Iterator r40 = r25.iterator();
    L104:
        if (r40.hasNext() == false) goto L114;
        Chatter r41 = (Chatter) r40.next();
        DepartmentUserDisplayFormatter r123 = DepartmentUserDisplayFormatter.a;
        r123.getClass();
        String r124 = DepartmentUserDisplayFormatter.a(r41, r15);
        String r125 = r41.id;
        String r126 = r41.avatar_key;
        boolean r213 = r28.contains(r125);
        Iterator r214 = r40;
        boolean r215 = r30.contains(r41.id);
        ExtendFields r42 = r14.extend_fields;
        if (r42 == null) goto L112;
        Map r43 = r42.user_profile_fields;
        if (r43 == null) goto L112;
        ProfileFields r44 = (ProfileFields) r43.get(r41.id);
        if (r44 == null) goto L112;
        List<GetUserProfileResponse.Field> r45 = r44.profile_fields;
    L113:
        r112.add(new j(r124, r125, r126, r213, r215, r123.b(r45)));
        r40 = r214;
    L112:
        r45 = null;
    L68:
        r30 = CollectionsKt.emptyList();
    L63:
        r28 = CollectionsKt.emptyList();
        goto L64
    L35:
        if (r23.isEmpty() == true) goto L55;
        Iterator r127 = r116.iterator();
    L39:
        if (r127.hasNext() == false) goto L54;
        Chatter r46 = (Chatter) r127.next();
        Iterator r128 = r23.iterator();
    L42:
        if (r128.hasNext() == false) goto L50;
        Set r129 = r23;
        Chatter r47 = ((DepartmentLeader) r128.next()).leader;
        if (r47 == null) goto L48;
        Iterator r130 = r19;
        if (Intrinsics.areEqual(r47.id, r46.id) == false) goto L49;
        boolean r48 = true;
    L51:
        if (r48 == true) goto L53;
        r24.add(r46);
    L53:
        r19 = r130;
        r23 = r129;
    L49:
        r19 = r130;
        r23 = r129;
        goto L42
    L48:
        r130 = r19;
        goto L49
    L50:
        r129 = r23;
        r130 = r19;
        r48 = false;
        goto L51
    L54:
        r114 = r19;
        r25 = r24;
        goto L59
    L29:
        if (r117.isEmpty() == true) goto L32;
        r118 = false;
    L25:
        r23 = SetsKt.emptySet();
        goto L26
    L115:
        List r49 = CollectionsKt.plus(r12, CollectionsKt.flatten(r18));
        DepartmentStructure r50 = this.$resp.department_structure;
        if (r50 == null) goto L118;
        boolean r51 = true;
        boolean r52 = Intrinsics.areEqual(r50.has_more, Boxing.boxBoolean(true));
    L119:
        if (r52 == true) goto L127;
        DepartmentStructure r53 = this.$resp.department_structure;
        if (r53 == null) goto L123;
        boolean r54 = Intrinsics.areEqual(r53.has_more_department, Boxing.boxBoolean(r51));
    L124:
        if (r54 == true) goto L127;
        boolean r131 = false;
    L128:
        int r55 = this.$state.c;
        DepartmentStructure r56 = this.$resp.department_structure;
        if (r56 == null) goto L133;
        List r57 = r56.chatters;
        if (r57 == null) goto L133;
        int r58 = r57.size();
    L134:
        int r59 = r55 + r58;
        DepartmentStructure r60 = this.$resp.department_structure;
        if (r60 == null) goto L139;
        List r61 = r60.sub_departments;
        if (r61 == null) goto L139;
        int r132 = r61.size();
    L140:
        i r62 = this.$state.a;
        Intrinsics.checkNotNullParameter(r62, "item");
        Intrinsics.checkNotNullParameter(r49, "items");
        r6 = new DepartmentStructureViewModel.b(r62, r49, r59 + r132, r131);
        r5 = DepartmentStructureViewModel.access$getModifyMutex$p(this.this$0);
        r3 = this.this$0;
        DepartmentStructureViewModel.b r63 = this.$state;
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r3;
        this.L$3 = r63;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L143;
        return r0;
    L143:
        r1 = r63;
    L139:
        r132 = 0;
    L133:
        r58 = 0;
        goto L134
    L123:
        r54 = false;
    L127:
        r131 = true;
        goto L128
    L118:
        r51 = true;
        r52 = false;
        goto L119
    }
}
