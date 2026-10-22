package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.im.v1.ChatPageContext;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.contact.base.entity.Contact;
import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$Click;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsChangeAvatar;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsChangeName;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsCrypto;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsSycn;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$LeaveAMessage;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$Source;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupHitPointNew;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.v;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class CreateGroupService extends c38.a<i> implements h {
    public static final /* synthetic */ int c = 0;
    public final com.ss.android.lark.create.groupchat.impl.service.b b;

    public static final class a {
    }

    public static final class b {
        public final WeakReference<Context> a;
        public final Fragment b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Fragment r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CreateGroupContext(context=" + this.a + ", sourceFragment=" + this.b + ')';
        }

        public final WeakReference<Context> getContext() {
            return this.a;
        }

        public b(WeakReference<Context> r2, Fragment r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final boolean a;
        public final boolean b;
        public final List<Contact> c;
        public final IGetDataCallback<w5b.a> d;
        public final boolean e;
        public final boolean f;

        public static final class a {
            public boolean a;
            public List<? extends Contact> b;
            public IGetDataCallback<w5b.a> c;
            public boolean d;

            public a() {
                this.a = true;
            }
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            List<Contact> r5 = this.c;
            int r6 = 0;
            if (r5 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (r4 + r7) * 31;
            IGetDataCallback<w5b.a> r9 = this.d;
            if (r9 == null) goto L18;
            r6 = r9.hashCode();
        L18:
            int r10 = (r8 + r6) * 31;
            if (this.e == false) goto L21;
            int r11 = 1231;
        L22:
            int r12 = (r10 + r11) * 31;
            if (this.f == true) goto L27;
            r1 = 1237;
        L27:
            return r12 + r1;
        L21:
            r11 = 1237;
            goto L22
        L13:
            r7 = r5.hashCode();
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "CreateGroupLaunchParams(needOpenChat=" + this.a + ", needBadge=" + this.b + ", contactsToApply=" + this.c + ", extraCallback=" + this.d + ", openApplyGroupLimit=" + this.e + ", onlyBots=" + this.f + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(boolean r1, boolean r2, List<? extends Contact> r3, IGetDataCallback<w5b.a> r4, boolean r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreateGroupScene.values().length];
            r0[CreateGroupScene.PLUS_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CreateGroupScene.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CreateGroupScene.ADD_GROUP_MEMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CreateGroupScene.FORWARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    @Inject
    public CreateGroupService(b38.b r2, com.ss.android.lark.create.groupchat.impl.service.b r3) {
        Intrinsics.checkNotNullParameter(r2, "rucket");
        Intrinsics.checkNotNullParameter(r3, "createGroupErrorHandle");
        super(r2);
        this.b = r3;
    }

    public final void b(hab.b r19, b r20, CreateGroupScene r21, ErrorResult r22, c r23, Function0<Unit> r24, Function1<? super Boolean, Unit> r25) {
        String r0 = kab.a.a;
        int r7 = r22.getCode();
        String r1 = r22.getMessage();
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        String r10 = r1;
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
        kab.a.a = null;
        ErrorParams r15 = new ErrorParams(Biz.Messenger, Scene.Chat, Event.create_group_chat, ErrorType.SDK, ErrorLevel.Fatal, r7, null, null, r10, Boolean.TRUE, null, null, null, 7360, null);
        AppreciableKit.Companion.getInstance().error(r15);
        r19.a();
        if (r24 == null) goto L8;
        r24.invoke();
    L8:
        Context r2 = r20.getContext().get();
        if (r2 != null) goto L11;
        return;
    L11:
        com.ss.android.lark.create.groupchat.impl.service.b r3 = this.b;
        Fragment r9 = r20.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r21, "scene");
        Intrinsics.checkNotNullParameter(r22, "err");
        List<InterceptorType> r4 = r3.b;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Object r8 = r6.next();
        Map<InterceptorType, Provider<com.ss.android.lark.create.groupchat.impl.service.c>> r11 = r3.a;
        if (r11.containsKey((InterceptorType) r8) == false) goto L13;
        r5.add(r8);
        goto L13
    L17:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.iterator();
    L19:
        if (r13.hasNext() == false) goto L28;
        InterceptorType r14 = (InterceptorType) r13.next();
        Provider<com.ss.android.lark.create.groupchat.impl.service.c> r16 = r3.a.get(r14);
        if (r16 == null) goto L25;
        com.ss.android.lark.create.groupchat.impl.service.c r17 = (com.ss.android.lark.create.groupchat.impl.service.c) r16.get();
        if (r17 == null) goto L25;
        Pair r18 = TuplesKt.to(r14, r17);
    L26:
        if (r18 == null) goto L19;
        r12.add(r18);
    L25:
        r18 = null;
        goto L26
    L28:
        Iterator r110 = MapsKt.toMutableMap(MapsKt.toMap(r12, new LinkedHashMap())).values().iterator();
    L30:
        if (r110.hasNext() == false) goto L48;
        com.ss.android.lark.create.groupchat.impl.service.c r111 = (com.ss.android.lark.create.groupchat.impl.service.c) r110.next();
        if (r111.a(r2, r21, r22, r25, r9, r23) == false) goto L30;
        Log.i("CreateGroupErrorHandle", "intercept success by ".concat(r111.getClass().getSimpleName()));
        return;
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.h
    public final void Da(Context r19, GroupCreateInfo r20, List<? extends SearchBaseInfo> r21, IGetDataCallback<Chat> r22, CreateGroupScene r23, IGetDataCallback<w5b.a> r24, Fragment r25, hab.b r26) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "groupCreateInfo");
        Intrinsics.checkNotNullParameter(r21, "searchInfos");
        Intrinsics.checkNotNullParameter(r23, "source");
        Intrinsics.checkNotNullParameter(r26, "chatDependency");
        int r1 = com.ss.android.lark.create.groupchat.impl.service.a.a;
        Intrinsics.checkNotNullParameter(r21, "list");
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r21.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((r4 instanceof SearchChatterInfo) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        Object r7 = r6.next();
        if (((SearchChatterInfo) r7).isNotContact() == false) goto L10;
        r5.add(r7);
        goto L10
    L14:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        SearchBaseInfo r9 = (SearchBaseInfo) r8.next();
        r14.add(new Contact(r9.getId(), r9.getAvatarKey(), r9.getTitle()));
        goto L16
    L18:
        Set r0 = CollectionsKt.toMutableSet(r21);
        r0.removeAll(r5);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r0.iterator();
    L20:
        if (r11.hasNext() == false) goto L33;
        SearchBaseInfo r12 = (SearchBaseInfo) r11.next();
        Intrinsics.checkNotNullParameter(r12, "info");
        if ((r12 instanceof SearchChatInfo) == false) goto L25;
        PickChatEntity r13 = new PickChatEntity(2, r12.getId());
    L31:
        if (r13 == null) goto L20;
        r10.add(r13);
        goto L20
    L25:
        if ((r12 instanceof SearchChatterInfo) == false) goto L28;
        r13 = new PickChatEntity(1, r12.getId());
        goto L31
    L28:
        if ((r12 instanceof SearchDepartmentInfo) == false) goto L30;
        r13 = new PickChatEntity(3, r12.getId());
        goto L31
    L30:
        r13 = null;
        goto L31
    L33:
        com.ss.android.lark.create.groupchat.impl.service.d r15 = new com.ss.android.lark.create.groupchat.impl.service.d();
        String r16 = r20.getName();
        Intrinsics.checkNotNullParameter(r16, "groupName");
        r15.e = r16;
        String r17 = r20.getDescription();
        Intrinsics.checkNotNullParameter(r17, "groupDesc");
        r15.f = r17;
        r15.j = r20.isPublic();
        r15.h = r20.isCrossTenant();
        CreateGroupMode r18 = r20.getMode();
        Intrinsics.checkNotNullParameter(r18, "groupMode");
        int r27 = com.ss.android.lark.create.groupchat.impl.service.d.a.a[r18.ordinal()];
        if (r27 == 1) goto L41;
        if (r27 == 2) goto L40;
        if (r27 != 3) goto L39;
        r15.l = Chat.ChatMode.DEFAULT;
        r15.i = true;
    L42:
        String r28 = r20.getFromChatId();
        Intrinsics.checkNotNullParameter(r28, "fromChatId");
        r15.g = r28;
        r15.k = r20.getLinkedUrl();
        r15.b.clear();
        r15.b.addAll(r10);
        List r29 = CollectionsKt.toMutableList(r15.a);
        LinkedHashSet r30 = new LinkedHashSet(r15.b);
        int r31 = com.ss.android.lark.create.groupchat.impl.service.a.a;
        Intrinsics.checkNotNullParameter(r29, "chatterIds");
        Intrinsics.checkNotNullParameter(r30, "pickEntities");
        Intrinsics.checkNotNullParameter(r30, "sourcePickEntities");
        ArrayList r32 = new ArrayList();
        Iterator r110 = r30.iterator();
    L44:
        if (r110.hasNext() == false) goto L51;
        Object r111 = r110.next();
        if (((PickChatEntity) r111).a != 1) goto L48;
        boolean r112 = true;
    L49:
        if (r112 == false) goto L44;
        r32.add(r111);
        goto L44
    L48:
        r112 = false;
        goto L49
    L51:
        ArrayList r113 = new ArrayList();
        Iterator r33 = r32.iterator();
    L53:
        if (r33.hasNext() == false) goto L57;
        String r114 = ((PickChatEntity) r33.next()).b;
        if (r114 == null) goto L53;
        r113.add(r114);
        goto L53
    L57:
        LinkedHashSet r34 = new LinkedHashSet(Math.max(r29.size(), r113.size()));
        r34.addAll(r29);
        r34.addAll(r113);
        r29.clear();
        r29.addAll(r34);
        List r35 = r29;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r36 = r35.iterator();
    L59:
        if (r36.hasNext() == false) goto L61;
        r115.add(new PickChatEntity(1, (String) r36.next()));
        goto L59
    L61:
        r30.addAll(r115);
        CreateChatRequest.Builder r37 = new CreateChatRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Chat.Type.GROUP).chatter_ids(r29).group_name(r15.e).group_desc(r15.f).is_crypto(Boolean.valueOf(r15.i)).pick_entities(v.a(r30)).chat_mode(com.bytedance.lark.pb.basic.v1.Chat.ChatMode.fromValue(r15.l.getNumber())).is_public_v2(Boolean.valueOf(r15.j)).init_message_ids(r15.c).from_chat_id(r15.g).is_cross_tenant(Boolean.valueOf(r15.h));
        if ((!r15.d.isEmpty()) == false) goto L76;
        Map<String, Map<String, DocPermPair.PermType>> r38 = r15.d;
        ArrayList r39 = new ArrayList(r38.size());
        Iterator r40 = ((LinkedHashMap) r38).entrySet().iterator();
    L65:
        if (r40.hasNext() == false) goto L75;
        Map.Entry r41 = (Map.Entry) r40.next();
        String r42 = (String) r41.getKey();
        Map r43 = (Map) r41.getValue();
        ArrayList r116 = new ArrayList(r43.size());
        Iterator r44 = r43.entrySet().iterator();
    L68:
        if (r44.hasNext() == false) goto L74;
        Map.Entry r117 = (Map.Entry) r44.next();
        Object r118 = r117.getKey();
        if (((DocPermPair.PermType) r117.getValue()) != DocPermPair.PermType.EDIT) goto L72;
        CreateChatRequest.DocPermission r119 = CreateChatRequest.DocPermission.EDIT;
    L73:
        r116.add(TuplesKt.to(r118, r119));
        goto L68
    L72:
        r119 = CreateChatRequest.DocPermission.READ;
        goto L73
    L74:
        r39.add(TuplesKt.to(r42, new CreateChatRequest.DocPermissions.Builder().perms(MapsKt.toMap(r116)).build()));
        goto L65
    L75:
        r37.message_doc_permissions(MapsKt.toMap(r39));
    L76:
        String r45 = r15.k;
        if (r45 != null) goto L79;
    L84:
        boolean r46 = false;
    L85:
        if (r46 == false) goto L87;
        r37.source(CreateChatRequest.PutChatSource.TO_LINK_PAGE);
        r37.to_link_pages(CollectionsKt.mutableListOf(new ChatPageContext[]{new ChatPageContext.Builder().target_url(r15.k).build()}));
    L87:
        CreateChatRequest r47 = r37.build();
        c.a r48 = new c.a();
        r48.a = r20.isOpenChat();
        boolean r120 = r20.getNeedBadge();
        r48.c = r24;
        r48.b = r14;
        a("createGroupFromPicker", r47, r19, r23, r22, new c(r48.a, r120, r14, r24, false, r48.d), r25, r26);
        return;
    L79:
        if (r45.length() != 0) goto L81;
        boolean r49 = true;
    L82:
        if (r49 == true) goto L84;
        r46 = true;
        goto L85
    L81:
        r49 = false;
        goto L82
    L39:
        throw new NoWhenBranchMatchedException();
    L40:
        r15.l = Chat.ChatMode.THREAD_V2;
        goto L42
    L41:
        r15.l = Chat.ChatMode.DEFAULT;
        goto L42
    }

    public final void a(String r23, CreateChatRequest r24, Context r25, CreateGroupScene r26, IGetDataCallback<Chat> r27, c r28, Fragment r29, final hab.b r30) {
        String r0 = kab.a.a;
        int[] r1 = d.a;
        int r2 = r1[r26.ordinal()];
        if (r2 == 1) goto L7;
        if (r2 == 2) goto L6;
        String r3 = "other";
    L8:
        Intrinsics.checkNotNullParameter(r3, "scene");
        kab.a.a = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Chat, Event.create_group_chat, null, true, null, MapsKt.mapOf(TuplesKt.to("create_group_scene", r3)), null, null, 416, null);
        CreateGroupExtraParams$Click r4 = CreateGroupExtraParams$Click.CONFIRM;
        s5c.h r5 = s5c.h.a;
        int r6 = r1[r26.ordinal()];
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L12;
        CreateGroupExtraParams$Source r7 = CreateGroupExtraParams$Source.FROM_P2P;
    L21:
        if (r24.is_crypto.booleanValue() == false) goto L23;
        CreateGroupExtraParams$IsCrypto r8 = CreateGroupExtraParams$IsCrypto.TRUE;
    L24:
        CreateGroupExtraParams$IsChangeAvatar r9 = CreateGroupExtraParams$IsChangeAvatar.FALSE;
        CreateGroupExtraParams$IsChangeName r10 = CreateGroupExtraParams$IsChangeName.FALSE;
        if ((!r24.init_message_ids.isEmpty()) == false) goto L27;
        CreateGroupExtraParams$IsSycn r11 = CreateGroupExtraParams$IsSycn.TRUE;
    L28:
        CreateGroupExtraParams$LeaveAMessage r12 = CreateGroupExtraParams$LeaveAMessage.FALSE;
        int r13 = CreateGroupHitPointNew.a;
        s5c.d r14 = r4.plus(r5).plus(r7).plus(r8).plus(r9).plus(r10).plus(r11).plus(r12);
        Intrinsics.checkNotNullParameter(r14, "params");
        Statistics.sendEvent("im_group_create_click", s5c.b.a(ChatParamUtils.e(), r14).toJson());
        r30.a();
        jab.c r15 = new jab.c(r24);
        WeakReference r16 = new WeakReference(r25);
        final com.ss.android.lark.sdk.h r17 = new com.ss.android.lark.sdk.h();
        b r18 = new b(r16, r29);
        RucketJob.map$default(((i) ((c38.a) this).a.create(i.class)).createGroupChat(r24, new CreateGroupService$createGroupChatInner$1(r17)), null, new CreateGroupService$createGroupChatInner$2(r30), 1, null).then(Dispatchers.getMain(), new CreateGroupService$createGroupChatInner$3(r23, this, r18, r26, r28, r30, r27, r15, null)).error(Dispatchers.getMain(), new CreateGroupService$createGroupChatInner$4(r23, this, r30, r18, r26, r28, r27, r15, r24, r25, null));
        return;
    L27:
        r11 = CreateGroupExtraParams$IsSycn.FALSE;
        goto L28
    L23:
        r8 = CreateGroupExtraParams$IsCrypto.FALSE;
        goto L24
    L12:
        if (r6 != 3) goto L14;
        r7 = CreateGroupExtraParams$Source.FROM_INNER_GROUP;
        goto L21
    L14:
        if (r6 == 4) goto L16;
        r7 = CreateGroupExtraParams$Source.FROM_P2P;
        goto L21
    L16:
        r7 = CreateGroupExtraParams$Source.FROM_FORWARD;
        goto L21
    L19:
        r7 = CreateGroupExtraParams$Source.PLUS;
        goto L21
    L6:
        r3 = "individual_chat";
        goto L8
    L7:
        r3 = "main_menu";
        goto L8
    }
}
