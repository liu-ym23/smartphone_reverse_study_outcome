package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.o;
import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.GetUserGroupEntitiesRequest;
import com.bytedance.lark.pb.im.v1.GetUserGroupEntitiesResponse;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.thread.n;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.s;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class UserGroupService implements o {
    public final l a;
    public final g b;
    public final ExecutorService c;
    public final ConcurrentHashMap<Long, UserGroupEntity> d;
    public final ConcurrentHashMap<com.ss.android.lark.biz.im.api.usergroup.a, Object> e;
    public final ReentrantReadWriteLock f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    @Override // a2b.o
    public final boolean isEnabled() {
        return a();
    }

    @Override // a2b.o
    public final void La(Message r3) {
        if (a() == true) goto L5;
        return;
    L5:
        int r0 = c.a;
        c.b("UserGroupService", "injectUserGroups, message id: " + r3.getId());
        Content r1 = r3.getContent();
        if ((r1 instanceof BaseTextContent) == true) goto L8;
        return;
    L8:
        RichText r2 = ((BaseTextContent) r1).getRichText();
        if (r2 != null) goto L11;
        return;
    L11:
        c6(r2, r3.getId());
    }

    @Override // a2b.o
    public final void pe(Map<Long, UserGroupEntity> r21) {
        Intrinsics.checkNotNullParameter(r21, "userGroups");
        if (a() == true) goto L6;
        return;
    L6:
        if (r21.isEmpty() == false) goto L8;
        return;
    L8:
        int r0 = c.a;
        c.b("UserGroupService", "updateUserGroup: " + r21.keySet());
        LinkedHashMap r1 = new LinkedHashMap();
        ReentrantReadWriteLock r4 = this.f;
        ReentrantReadWriteLock.ReadLock r5 = r4.readLock();
        if (r4.getWriteHoldCount() != 0) goto L11;
        int r6 = r4.getReadHoldCount();
    L12:
        int r8 = 0;
    L13:
        if (r8 >= r6) goto L15;
        r5.unlock();
        r8 = r8 + 1;
        goto L13
    L15:
        ReentrantReadWriteLock.WriteLock r7 = r4.writeLock();
        r7.lock();
        Iterator<Map.Entry<Long, UserGroupEntity>> r2 = r21.entrySet().iterator();     // Catch: Throwable -> L40
    L18:
        if (r2.hasNext() == false) goto L34;
        Map.Entry<Long, UserGroupEntity> r9 = r2.next();     // Catch: Throwable -> L40
        long r10 = r9.getKey().longValue();     // Catch: Throwable -> L40
        UserGroupEntity r11 = r9.getValue();     // Catch: Throwable -> L40
        if (r11.id.longValue() > 0) goto L22;
    L24:
        boolean r12 = false;
    L25:
        if (r12 == false) goto L18;
        UserGroupEntity r13 = this.d.get(Long.valueOf(r10));     // Catch: Throwable -> L40
        if (r13 == null) goto L30;
        if (r13.server_time.longValue() > r11.server_time.longValue()) goto L18;
        Iterator<Map.Entry<Long, UserGroupEntity>> r22 = r2;
        this.d.put(Long.valueOf(r10), r11);     // Catch: Throwable -> L40
        r1.put(Long.valueOf(r10), r11);     // Catch: Throwable -> L40
        int r3 = c.a;     // Catch: Throwable -> L40
        String r14 = "replace user group cache " + r10 + ", permission: " + r11.status + ", server time from " + r13.server_time + " to " + r11.server_time;     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter("UserGroupService", "tag");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r14, "msg");     // Catch: Throwable -> L40
        Log.d("UserGroupService", "[UserGroup] " + r14);     // Catch: Throwable -> L40
        r2 = r22;
        goto L18
    L30:
        this.d.put(Long.valueOf(r10), r11);     // Catch: Throwable -> L40
        r1.put(Long.valueOf(r10), r11);     // Catch: Throwable -> L40
        int r15 = c.a;     // Catch: Throwable -> L40
        String r16 = "new user group cache " + r10 + ", permission: " + r11.status + ", server time " + r11.server_time;     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter("UserGroupService", "tag");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r16, "msg");     // Catch: Throwable -> L40
        Log.d("UserGroupService", "[UserGroup] " + r16);     // Catch: Throwable -> L40
        goto L18
    L22:
        if (r11.server_time.longValue() <= 0) goto L24;
        r12 = true;
        goto L25
    L34:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L40
        int r18 = 0;
    L36:
        if (r18 >= r6) goto L38;
        r5.lock();
        r18 = r18 + 1;
        goto L36
    L38:
        r7.unlock();
        this.c.execute(new e(this, r1));
        return;
    L40:
        th = move-exception;
        int r19 = 0;
    L42:
        if (r19 >= r6) goto L44;
        r5.lock();
        r19 = r19 + 1;
        goto L42
    L44:
        r7.unlock();
        throw th;
    L11:
        r6 = 0;
        goto L12
    }

    @Override // a2b.o
    public final void w9(s.c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (a() == true) goto L6;
        return;
    L6:
        if (this.e.contains(r3) == true) goto L9;
        this.e.put(r3, new Object());
        return;
    }

    @Override // a2b.o
    public final void z1(s.c r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (a() == true) goto L5;
        return;
    L5:
        this.e.remove(r2);
    }

    @Inject
    public UserGroupService(l r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        this.a = r2;
        this.b = r3;
        this.c = PThreadExecutorsUtils.newSingleThreadExecutor(new n("thread-pool-user-group"));
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ReentrantReadWriteLock();
        this.g = LazyKt.lazy(new UserGroupService$isFgEnabled$2(this));
    }

    @Override // a2b.o
    public final void H8(Context r4, AtUserGroupInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "info");
        if (a() == true) goto L6;
        return;
    L6:
        if (r5.getPermissionStatus() != 2) goto L9;
        UDToast.show(r4, 2131891243);
        return;
    L9:
        if (r5.getPermissionStatus() != 1) goto L13;
        ChatCoreModule.a().getProfileDependency().a(r4, String.valueOf(r5.getUserGroupId()), r5.getUserGroupName());
        return;
    }

    @Override // a2b.o
    public final void c6(RichText r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "richText");
        if (a() == true) goto L6;
        return;
    L6:
        if (r24.getElements() != null) goto L8;
        return;
    L8:
        int r0 = c.a;
        c.b("UserGroupService", "injectUserGroups to rich text, message id: " + r25);
        Iterator r1 = r24.getElements().getDictionary().entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L83;
        Map.Entry r2 = (Map.Entry) r1.next();
        if (((RichTextElement) r2.getValue()).getTag() != RichTextElement.RichTextTag.AT_USER_GROUP) goto L10;
        RichTextElement.AtUserGroupProperty r3 = ((RichTextElement) r2.getValue()).getProperty();
        long r4 = r3.getUserGroupId();
        if (r4 == 0) goto L16;
        int r8 = c.a;
        c.b("UserGroupService", "injectUserGroups, user group id: " + r4);
        if (a() == true) goto L20;
        UserGroupEntity r9 = null;
    L77:
        if (r9 == null) goto L78;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r3, "property");
        r3.setDisplayName(r9.display_name);
        r3.setPermissionStatus(r9.status.intValue());
        goto L10
    L78:
        int r5 = c.a;
        c.b("UserGroupService", "user group cache not found, id: " + r4);
        goto L10
    L20:
        List r10 = CollectionsKt.listOf(Long.valueOf(r4));
        Intrinsics.checkNotNullParameter(r10, "ids");
        if (a() == true) goto L23;
        Map r6 = MapsKt.emptyMap();
    L76:
        r9 = (UserGroupEntity) r6.get(Long.valueOf(r4));
        goto L77
    L23:
        c.b("UserGroupService", "getUserGroups: " + r10);
        ArrayList r11 = new ArrayList();
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        ReentrantReadWriteLock.ReadLock r13 = this.f.readLock();
        r13.lock();
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L80
        Iterator r15 = r10.iterator();     // Catch: Throwable -> L80
    L25:
        boolean r16 = true;
        if (r15.hasNext() == false) goto L64;
        long r17 = ((Number) r15.next()).longValue();     // Catch: Throwable -> L80
        UserGroupEntity r18 = this.d.get(Long.valueOf(r17));     // Catch: Throwable -> L80
        if (r18 != null) goto L31;
        r11.add(Long.valueOf(r17));     // Catch: Throwable -> L80
    L48:
        r18 = null;
        long r19 = 0;
    L61:
        if (r18 == null) goto L25;
        r14.add(r18);     // Catch: Throwable -> L80
        goto L25
    L31:
        if ((System.currentTimeMillis() - r18.cache_time.longValue()) <= 86400000) goto L33;
        boolean r110 = true;
    L34:
        if (r110 == false) goto L55;
        r11.add(Long.valueOf(r17));     // Catch: Throwable -> L80
        ReentrantReadWriteLock r20 = this.f;     // Catch: Throwable -> L80
        ReentrantReadWriteLock.ReadLock r111 = r20.readLock();     // Catch: Throwable -> L80
        if (r20.getWriteHoldCount() != 0) goto L38;
        int r112 = r20.getReadHoldCount();     // Catch: Throwable -> L80
    L39:
        int r7 = 0;
    L40:
        if (r7 >= r112) goto L42;
        r111.unlock();     // Catch: Throwable -> L80
        r7 = r7 + 1;     // Catch: Throwable -> L80
        goto L40
    L42:
        ReentrantReadWriteLock.WriteLock r21 = r20.writeLock();     // Catch: Throwable -> L80
        r21.lock();     // Catch: Throwable -> L80
        UserGroupEntity r22 = this.d.remove(Long.valueOf(r17));     // Catch: Throwable -> L49
        int r23 = 0;
    L45:
        if (r23 >= r112) goto L47;
        r111.lock();     // Catch: Throwable -> L80
        r23 = r23 + 1;     // Catch: Throwable -> L80
        goto L45
    L47:
        r21.unlock();     // Catch: Throwable -> L80
        goto L48
    L49:
        th = move-exception;
        int r26 = 0;
    L51:
        if (r26 >= r112) goto L53;
        r111.lock();     // Catch: Throwable -> L80
        r26 = r26 + 1;     // Catch: Throwable -> L80
        goto L51
    L53:
        r21.unlock();     // Catch: Throwable -> L80
        throw th;     // Catch: Throwable -> L80
    L38:
        r112 = 0;
        goto L39
    L55:
        r19 = 0;
        if (r18.server_time.longValue() > 0) goto L59;
        r16 = false;
    L59:
        if (r16 == true) goto L61;
        r11.add(Long.valueOf(r17));     // Catch: Throwable -> L80
        goto L61
    L33:
        r110 = false;
        goto L34
    L64:
        LinkedHashMap r27 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));     // Catch: Throwable -> L80
        Iterator r28 = r14.iterator();     // Catch: Throwable -> L80
    L66:
        if (r28.hasNext() == false) goto L68;
        Object r29 = r28.next();     // Catch: Throwable -> L80
        r27.put(Long.valueOf(((UserGroupEntity) r29).id.longValue()), r29);     // Catch: Throwable -> L80
        goto L66
    L68:
        r12.element = r27;     // Catch: Throwable -> L80
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L80
        r13.unlock();
        if ((!r11.isEmpty()) == true) goto L72;
    L75:
        r6 = (Map) r12.element;
        goto L76
    L72:
        if (r11.isEmpty() == true) goto L75;
        int r31 = c.a;
        c.b("UserGroupService", "asyncPullMissedUserGroups, ids: " + r11);
        GetUserGroupEntitiesRequest.Builder r113 = new GetUserGroupEntitiesRequest.Builder();
        r113.user_group_ids(r11);
        r113.sync_data_strategy(SyncDataStrategy.TRY_LOCAL);
        t.g(this.a.h(new com.bytedance.lark.rustclient.api.d(r113, GetUserGroupEntitiesResponse.ADAPTER, Command.GET_USER_GROUP_ENTITY_BY_IDS, null, null, null, null, 248)).a(), new UserGroupService$asyncPullMissedUserGroups$1(this), UserGroupService$asyncPullMissedUserGroups$2.INSTANCE);
    L80:
        th = move-exception;
        r13.unlock();
        throw th;
    L16:
        int r32 = c.a;
        Intrinsics.checkNotNullParameter("UserGroupService", "tag");
        Intrinsics.checkNotNullParameter("invalid user group id", "msg");
        Log.e("UserGroupService", "[UserGroup] invalid user group id");
        goto L10
    }
}
