package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.search.dto.UserGroupScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J1\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010&\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010(\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010*\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010,\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010.\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u00100\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u00102\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J\u001f\u0010\f\u001a\u00020\u00132\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J(\u00104\u001a\u0004\u0018\u0001H5\"\u0016\b\u0000\u00105\u0018\u0001*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0086\b¢\u0006\u0002\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0006\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00067"}, d2 = {"Lcom/ss/android/lark/picker/config/SearcherConfig;", "", "permissions", "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/config/Permissions;)V", "entities", "", "Lkotlin/reflect/KClass;", "Lcom/ss/android/lark/picker/config/Entity;", "getEntities", "()Ljava/util/Map;", "extra", "Lcom/ss/android/lark/picker/config/TopExtra;", "getExtra", "()Lcom/ss/android/lark/picker/config/TopExtra;", "setExtra", "(Lcom/ss/android/lark/picker/config/TopExtra;)V", "chatter", "", "isFull", "", "init", "Lkotlin/Function1;", "Lcom/ss/android/lark/picker/config/Chatter;", "Lkotlin/ExtensionFunctionType;", "group", "Lcom/ss/android/lark/picker/config/Group;", "doc", "Lcom/ss/android/lark/picker/config/Doc;", "wiki", "Lcom/ss/android/lark/picker/config/Wiki;", "wikiSpace", "Lcom/ss/android/lark/picker/config/WikiSpace;", "userGroup", "scene", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "Lcom/ss/android/lark/picker/config/UserGroup;", "shieldP2P", "Lcom/ss/android/lark/picker/config/ShieldP2P;", "department", "Lcom/ss/android/lark/picker/config/Department;", "bot", "Lcom/ss/android/lark/picker/config/Bot;", "mailContact", "Lcom/ss/android/lark/picker/config/MailContact;", "mailUser", "Lcom/ss/android/lark/picker/config/MailUser;", "ai", "Lcom/ss/android/lark/picker/config/AI;", "thread", "Lcom/ss/android/lark/picker/config/Thread;", "getEntity", "E", "()Lcom/ss/android/lark/picker/config/Entity;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class SearcherConfig {
    private final Map<KClass<?>, Entity<?, ?, ?>> entities;
    private TopExtra extra;
    private final Permissions permissions;

    public final /* synthetic */ <E extends Entity<?, ?, ?>> E getEntity() {
        Map<KClass<?>, Entity<?, ?, ?>> r0 = getEntities();
        Intrinsics.reifiedOperationMarker(4, "E");
        E r1 = (E) r0.get(Reflection.getOrCreateKotlinClass(Entity.class));
        if (r1 == null) goto L5;
        Intrinsics.reifiedOperationMarker(3, "E");
        Intrinsics.reifiedOperationMarker(1, "E");
        return r1;
    L5:
        return null;
    }

    public final Map<KClass<?>, Entity<?, ?, ?>> getEntities() {
        return this.entities;
    }

    public final TopExtra getExtra() {
        return this.extra;
    }

    public SearcherConfig(Permissions r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.permissions = r2;
        this.entities = new LinkedHashMap();
        this.extra = new TopExtra();
    }

    public final void extra(Function1<? super TopExtra, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        r2.invoke(this.extra);
    }

    public final void setExtra(TopExtra r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.extra = r2;
    }

    public final void ai(boolean r3, Function1<? super AI, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "init");
        if (FG.INSTANCE.isCurrentEnable(FG.MY_AI) == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        AI r5 = new AI();
    L13:
        r4.invoke(r5);
        this.entities.put(Reflection.getOrCreateKotlinClass(AI.class), r5);
        return;
    L7:
        Entity<?, ?, ?> r6 = this.entities.get(Reflection.getOrCreateKotlinClass(AI.class));
        if ((r6 instanceof AI) == false) goto L10;
        r5 = (AI) r6;
    L11:
        if (r5 != null) goto L13;
        r5 = new AI();
        goto L13
    L10:
        r5 = null;
        goto L11
    }

    public final void bot(boolean r2, Function1<? super Bot, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Bot r4 = new Bot();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(Bot.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Bot.class));
        if ((r5 instanceof Bot) == false) goto L8;
        r4 = (Bot) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Bot();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void chatter(boolean r2, Function1<? super Chatter, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Chatter r4 = new Chatter();
    L11:
        r3.invoke(r4);
        r4.getExtra().setReturnPermissionsResult$picker_release(this.permissions.getChatterOUPermissions());
        this.entities.put(Reflection.getOrCreateKotlinClass(Chatter.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Chatter.class));
        if ((r5 instanceof Chatter) == false) goto L8;
        r4 = (Chatter) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Chatter();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void department(boolean r2, Function1<? super Department, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Department r4 = new Department();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(Department.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Department.class));
        if ((r5 instanceof Department) == false) goto L8;
        r4 = (Department) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Department();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void doc(boolean r2, Function1<? super Doc, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Doc r4 = new Doc();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(Doc.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Doc.class));
        if ((r5 instanceof Doc) == false) goto L8;
        r4 = (Doc) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Doc();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void group(boolean r2, Function1<? super Group, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Group r4 = new Group();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(Group.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Group.class));
        if ((r5 instanceof Group) == false) goto L8;
        r4 = (Group) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Group();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void mailContact(boolean r2, Function1<? super MailContact, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        MailContact r4 = new MailContact();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(MailContact.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(MailContact.class));
        if ((r5 instanceof MailContact) == false) goto L8;
        r4 = (MailContact) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new MailContact();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void mailUser(boolean r2, Function1<? super MailUser, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        MailUser r4 = new MailUser();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(MailUser.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(MailUser.class));
        if ((r5 instanceof MailUser) == false) goto L8;
        r4 = (MailUser) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new MailUser();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void shieldP2P(boolean r2, Function1<? super ShieldP2P, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        ShieldP2P r4 = new ShieldP2P();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(ShieldP2P.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(ShieldP2P.class));
        if ((r5 instanceof ShieldP2P) == false) goto L8;
        r4 = (ShieldP2P) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new ShieldP2P();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void thread(boolean r2, Function1<? super Thread, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Thread r4 = new Thread();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(Thread.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Thread.class));
        if ((r5 instanceof Thread) == false) goto L8;
        r4 = (Thread) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Thread();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void wiki(boolean r2, Function1<? super Wiki, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        Wiki r4 = new Wiki();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(Wiki.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(Wiki.class));
        if ((r5 instanceof Wiki) == false) goto L8;
        r4 = (Wiki) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new Wiki();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void wikiSpace(boolean r2, Function1<? super WikiSpace, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (r2 == false) goto L5;
        WikiSpace r4 = new WikiSpace();
    L11:
        r3.invoke(r4);
        this.entities.put(Reflection.getOrCreateKotlinClass(WikiSpace.class), r4);
        return;
    L5:
        Entity<?, ?, ?> r5 = this.entities.get(Reflection.getOrCreateKotlinClass(WikiSpace.class));
        if ((r5 instanceof WikiSpace) == false) goto L8;
        r4 = (WikiSpace) r5;
    L9:
        if (r4 != null) goto L11;
        r4 = new WikiSpace();
        goto L11
    L8:
        r4 = null;
        goto L9
    }

    public final void userGroup(UserGroupScene r2, boolean r3, Function1<? super UserGroup, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "init");
        if (r3 == false) goto L5;
        UserGroup r5 = new UserGroup(r2);
    L11:
        r4.invoke(r5);
        this.entities.put(Reflection.getOrCreateKotlinClass(UserGroup.class), r5);
        return;
    L5:
        Entity<?, ?, ?> r6 = this.entities.get(Reflection.getOrCreateKotlinClass(UserGroup.class));
        if ((r6 instanceof UserGroup) == false) goto L8;
        r5 = (UserGroup) r6;
    L9:
        if (r5 != null) goto L11;
        r5 = new UserGroup(r2);
        goto L11
    L8:
        r5 = null;
        goto L9
    }

    public static /* synthetic */ void ai$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.ai(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ai");
    }

    public static /* synthetic */ void bot$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.bot(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bot");
    }

    public static /* synthetic */ void chatter$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.chatter(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chatter");
    }

    public static /* synthetic */ void department$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.department(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: department");
    }

    public static /* synthetic */ void doc$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.doc(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doc");
    }

    public static /* synthetic */ void group$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.group(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: group");
    }

    public static /* synthetic */ void mailContact$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.mailContact(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mailContact");
    }

    public static /* synthetic */ void mailUser$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.mailUser(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mailUser");
    }

    public static /* synthetic */ void shieldP2P$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.shieldP2P(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shieldP2P");
    }

    public static /* synthetic */ void thread$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.thread(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: thread");
    }

    public static /* synthetic */ void wiki$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.wiki(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wiki");
    }

    public static /* synthetic */ void wikiSpace$default(SearcherConfig r0, boolean r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.wikiSpace(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wikiSpace");
    }

    public static /* synthetic */ void userGroup$default(SearcherConfig r0, UserGroupScene r1, boolean r2, Function1 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.userGroup(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userGroup");
    }
}
