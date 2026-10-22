package com.ss.android.lark.contact.customized.common.repository;

import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoResponse;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.externalcontact.repository.OfficeExternalContactRepository;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.contact.api.model.OfficeContactListScene;
import com.ss.android.lark.pb.department.ContactDisplayModule;
import com.ss.android.lark.pb.department.PullDepartmentStructureRequest;
import com.ss.android.lark.pb.department.PullDepartmentStructureResponse;
import com.ss.android.lark.pb.entities.Chatter;
import com.ss.android.lark.pb.entities.Image;
import com.ss.android.lark.pb.entities.ImageSet;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.picker.doubao.ExternalContactRecommendPageDataPuller;
import com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mtb.d;
import mtb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements ktb.b {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.common.repository.a$a, reason: collision with other inner class name */
    public static final class C0168a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeContactListScene.values().length];
            r0[OfficeContactListScene.FULL_COLD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[OfficeContactListScene.INCR_SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[ContactDisplayModule.values().length];
            r1[ContactDisplayModule.DISPLAY_MODULE_DEPARTMENT_LEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[ContactDisplayModule.DISPLAY_MODULE_DEPARTMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[ContactDisplayModule.DISPLAY_MODULE_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public a() {
    }

    public final void b(ExternalContactRecommendPageDataPuller.loadData.2 r11) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        Log.i("Contact_OpenRepository", "getContactList preferLocal=false scene=null");
        OfficeContactListScene r0 = OfficeContactListScene.INCR_SHORT;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        GetContactsScene r2 = GetContactsScene.GET_CONTACTS_SCENE_FULL_COLD;
    L10:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ContactOpenRepository$getContactList$1(false, this, r2, r11, null), 2, null);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = GetContactsScene.GET_CONTACTS_SCENE_INCR_SHORT;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final Pair c(a r5, boolean r6, GetContactsScene r7) {
        r5.getClass();
        SdkSender.d r8 = OfficeExternalContactRepository.a(r6, r7);
        if (r8.b == null) goto L9;
        StringBuilder r0 = new StringBuilder("getContactsDoubao error fromLocal=");
        r0.append(r6);
        r0.append(" scene=");
        r0.append(r7);
        r0.append(' ');
        ErrorResult r4 = r8.b;
        if (r4 == null) goto L7;
        String r9 = r4.getMessage();
    L8:
        r0.append(r9);
        Log.i("Contact_OpenRepository", r0.toString());
        goto L9
    L7:
        r9 = null;
    L9:
        GetContactsDoubaoResponse r1 = (GetContactsDoubaoResponse) r8.a;
        if (r1 == null) goto L12;
        List r2 = r1.contacts;
    L13:
        List r10 = r2;
        if (r10 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == false) goto L22;
        Log.i("Contact_OpenRepository", "getContactsDoubao empty fromLocal=" + r6 + " scene=" + r7);
        return new Pair(CollectionsKt.emptyList(), r8.b);
    L22:
        Log.i("Contact_OpenRepository", "getContactsDoubao success fromLocal=" + r6 + " scene=" + r7 + " count=" + r2.size());
        ArrayList r12 = new ArrayList();
        Iterator r13 = r2.iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        ContactProfile r14 = (ContactProfile) r13.next();
        int r3 = d.l;
        r12.add(d.a.a(r14));
        goto L24
    L26:
        Lazy r15 = OfficeContactUtils.a;
        Intrinsics.checkNotNullParameter(r12, "contactList");
        CollectionsKt.sortWith(r12, com.ss.android.lark.contact.customized.common.d.a);
        return new Pair(r12, null);
    L16:
        if (r10.isEmpty() == true) goto L19;
        r11 = false;
        goto L20
    L12:
        r2 = null;
        goto L13
    }

    public static j d(Chatter r9, Set r10, Set r11) {
        String r0 = r9.mid;
        if (r0 != null) goto L5;
        String r4 = BuildConfig.FLAVOR;
    L6:
        Image r1 = r9.mavatar_image;
        String r2 = null;
        if (r1 == null) goto L9;
        String r3 = r1.mkey;
    L10:
        if (r3 != null) goto L13;
        r3 = BuildConfig.FLAVOR;
    L13:
        if (r3.length() != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L23;
        ImageSet r6 = r9.mavatar;
        if (r6 == null) goto L20;
        r2 = r6.mkey;
    L20:
        if (r2 != null) goto L22;
        r2 = BuildConfig.FLAVOR;
    L22:
        String r7 = r2;
    L24:
        String r12 = r9.mname;
        if (r12 != null) goto L27;
        String r8 = BuildConfig.FLAVOR;
    L28:
        boolean r13 = r10.contains(r4);
        boolean r14 = r11.contains(r4);
        Intrinsics.checkNotNullParameter(r8, "displayName");
        Intrinsics.checkNotNullParameter(r4, "chatterId");
        Intrinsics.checkNotNullParameter(r7, "avatarKey");
        return new j(r8, r4, r7, r13, r14, CollectionsKt.emptyList());
    L27:
        r8 = r12;
        goto L28
    L23:
        r7 = r3;
        goto L24
    L15:
        r5 = false;
        goto L16
    L9:
        r3 = null;
        goto L10
    L5:
        r4 = r0;
        goto L6
    }

    public final void a(final String r10, final int r11, final DoubaoOrganizationPickerView.loadCurrentPage.1 r12) {
        Intrinsics.checkNotNullParameter(r10, "departmentId");
        Intrinsics.checkNotNullParameter(r12, "callback");
        PullDepartmentStructureRequest.Builder r0 = new PullDepartmentStructureRequest.Builder().department_id(r10).offset(Integer.valueOf(r11)).count(100);
        Boolean r1 = Boolean.TRUE;
        PullDepartmentStructureRequest.Builder r2 = r0.sub_department_paging(r1).use_display_order(r1);
        Command r3 = Command.PULL_DEPARTMENT_STRUCTURE;
        final int r7 = 100;
        IGetDataCallback<PullDepartmentStructureResponse> r8 = new ContactOpenRepository$getDepartmentPage$1(r11, r12, this, r10, r7);
        final ProtoAdapter r13 = PullDepartmentStructureResponse.ADAPTER;
        SdkSender.sendPassThroughRequest(r3, r2, r8, new com.ss.android.lark.contact.customized.common.repository.b(r13));
    }
}
