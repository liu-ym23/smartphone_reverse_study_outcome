package com.ss.android.lark.passport.assemble;

import android.content.Context;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class UserListService implements IUserListService {
    public final Provider<com.ss.android.lark.storage.kv.storage.a> a;
    public final com.ss.android.lark.storage.a b;
    public final Gson c;
    public final Lazy d;
    public boolean e;
    public User f;

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final void q() {
    }

    public final User a() {
        if (this.e == true) goto L15;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((User) this.c.fromJson(((KVRepo) this.d.getValue()).getString("user", null), User.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == true) goto L13;
        r0 = r2;
    L13:
        this.f = (User) r0;
        this.e = true;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        return this.f;
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final List<User> getAllValidUserList() {
        return CollectionsKt.listOfNotNull(a());
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final User getForegroundUser() {
        return a();
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final List<String> r() {
        User r0 = a();
        List<String> r1 = null;
        String r2 = null;
        if (r0 == null) goto L26;
        ArrayList r3 = new ArrayList();
        String r4 = r0.getSession();
        if (r4 != null) goto L7;
    L11:
        Map<String, SessionInfo> r5 = r0.getSessionWithDomainMap();
        if (r5 == null) goto L25;
        Collection<SessionInfo> r6 = r5.values();
        if (r6 == null) goto L25;
        Sequence r7 = CollectionsKt.asSequence(r6);
        if (r7 == null) goto L25;
        Sequence r8 = SequencesKt.filter(r7, UserListService$allPassportSessions$3.INSTANCE);
        if (r8 == null) goto L25;
        Sequence r9 = SequencesKt.mapNotNull(r8, UserListService$allPassportSessions$4.INSTANCE);
        if (r9 == null) goto L25;
        Iterator r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L25;
        r3.add((String) r10.next());
    L25:
        r1 = CollectionsKt.distinct(r3);
        goto L26
    L7:
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
        r2 = r4;
    L9:
        if (r2 == null) goto L11;
        r3.add(r2);
    L26:
        if (r1 == null) goto L28;
        return r1;
    L28:
        return CollectionsKt.emptyList();
    }

    public final void b(User r9) {
        User r0 = a();
        String r1 = null;
        if (r9 == null) goto L82;
        if (r0 == null) goto L83;
        String r3 = r9.userId;
        boolean r4 = false;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L83;
        if (Intrinsics.areEqual(r9.userId, r0.userId) == false) goto L83;
        String r6 = r9.getSession();
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        r9.setSession(r0.getSession());
    L26:
        String r8 = r9.getSlSession();
        if (r8 != null) goto L29;
    L32:
        boolean r10 = true;
    L33:
        if (r10 == false) goto L35;
        r9.setSlSession(r0.getSlSession());
    L35:
        String r11 = r9.getSessionUuid();
        if (r11 != null) goto L38;
    L41:
        boolean r12 = true;
    L42:
        if (r12 == false) goto L44;
        r9.setSessionUuid(r0.getSessionUuid());
    L44:
        String r13 = r9.getLogoutToken();
        if (r13 != null) goto L47;
    L50:
        boolean r14 = true;
    L51:
        if (r14 == false) goto L53;
        r9.setLogoutToken(r0.getLogoutToken());
    L53:
        String r15 = r9.getCurrentEnv();
        if (r15 != null) goto L56;
    L59:
        boolean r16 = true;
    L60:
        if (r16 == false) goto L62;
        r9.setCurrentEnv(r0.getCurrentEnv());
    L62:
        String r17 = r9.getDeviceLoginId();
        if (r17 != null) goto L65;
    L68:
        boolean r18 = true;
    L69:
        if (r18 == false) goto L71;
        r9.setDeviceLoginId(r0.getDeviceLoginId());
    L71:
        Map<String, SessionInfo> r19 = r9.getSessionWithDomainMap();
        if (r19 != null) goto L74;
    L75:
        r4 = true;
    L76:
        if (r4 == false) goto L79;
        r9.setSessionWithDomainMap(r0.getSessionWithDomainMap());
    L79:
        if (r9.getLastUseTimestamp() != 0) goto L81;
        r9.setLastUseTimestamp(r0.getLastUseTimestamp());
    L81:
        r9.setAnonymous(r0.isAnonymous());
        r9.setSessionValid(r0.hasValidSession());
        r9.setSessionValidOrForeground(r0.hasValidSessionOrForeground());
        r9.leanModeInfo = r0.leanModeInfo;
        goto L83
    L74:
        if (r19.isEmpty() == false) goto L76;
    L65:
        if (StringsKt.isBlank(r17) == true) goto L68;
        r18 = false;
        goto L69
    L56:
        if (StringsKt.isBlank(r15) == true) goto L59;
        r16 = false;
        goto L60
    L47:
        if (StringsKt.isBlank(r13) == true) goto L50;
        r14 = false;
        goto L51
    L38:
        if (StringsKt.isBlank(r11) == true) goto L41;
        r12 = false;
        goto L42
    L29:
        if (StringsKt.isBlank(r8) == true) goto L32;
        r10 = false;
        goto L33
    L20:
        if (StringsKt.isBlank(r6) == true) goto L23;
        r7 = false;
        goto L24
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r5 = false;
    L83:
        if (r9 == null) goto L86;
        r1 = r9.userUnit;
    L86:
        if (Intrinsics.areEqual(r1, "eu_nc6") == false) goto L88;
        PassportLog.d("UserListService", "eu_nc6 2 eu_nc");
        r9.userUnit = "eu_nc";
    L88:
        this.f = r9;
        this.e = true;
        ((KVRepo) this.d.getValue()).putString("user", GsonProtectorUtils.toJson(this.c, r9));
        PassportUserApi.Companion.getClass();
        CoreThreadPool.getSerialTaskHandler().post(new h(r0, r9));
        return;
    L82:
        r9 = null;
        goto L83
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final l s(String r3) {
        User r0 = a();
        if (r0 == null) goto L5;
        String r1 = r0.userId;
    L7:
        if (Intrinsics.areEqual(r3, r1) == false) goto L13;
        User r4 = a();
        if (r4 != null) goto L12;
        return null;
    L12:
        return new l(r4);
    L13:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final void u(User r3) {
        if (r3 == null) goto L12;
        String r0 = r3.userId;
        User r1 = a();
        if (r1 == null) goto L6;
        String r2 = r1.userId;
    L8:
        if (Intrinsics.areEqual(r0, r2) == false) goto L13;
        b(r3);
        return;
    L13:
        return;
    L6:
        r2 = null;
        goto L8
    }

    @Inject
    public UserListService(@ApplicationContext Context r2, Provider<com.ss.android.lark.storage.kv.storage.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "kvStorage");
        this.a = r3;
        this.b = new com.ss.android.lark.storage.a("Passport");
        this.c = new GsonBuilder().registerTypeAdapter(User.class, new UserTypeAdapter()).create();
        this.d = LazyKt.lazy(new UserListService$kvRepo$2(this));
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final void t(List<? extends User> r2, String r3, IUserListService.UserLoginSource r4) {
        Intrinsics.checkNotNullParameter(r2, "loginUsers");
        Intrinsics.checkNotNullParameter(r4, "source");
        Iterator<T> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((User) r6).userId, r3) == false) goto L4;
    L9:
        b((User) r6);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
