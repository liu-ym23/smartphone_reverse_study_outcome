package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import androidx.collection.SparseArrayCompat;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.ChatWindowFields;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsRequest;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsResponse;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class UserFieldsService implements b {
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a a;
    public final g b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final boolean O8() {
        boolean r0 = this.b.isEnable("pc.show.user.admin.info");
        Log.i("UserFieldsService", "isUserFieldsFGEnabled=" + r0);
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final c Eb(String r8) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        return new c(r8, false, false, null, null);
    }

    @Inject
    public UserFieldsService(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final void X7(final String r4, IGetDataCallback<c> r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        GetUserChatWindowFieldsRequest.Builder r0 = new GetUserChatWindowFieldsRequest.Builder().user_id(CollectionsKt.listOf(r4)).sync_data_strategy(SyncDataStrategy.FORCE_SERVER);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a r1 = this.a;
        Intrinsics.checkNotNull(r0);
        r1.a(r0, r5, new UserFieldsService$forceGetServerFields$1(this, r4));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final void w3(final String r4, IGetDataCallback<c> r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        GetUserChatWindowFieldsRequest.Builder r0 = new GetUserChatWindowFieldsRequest.Builder().user_id(CollectionsKt.listOf(r4)).sync_data_strategy(SyncDataStrategy.TRY_LOCAL);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a r1 = this.a;
        Intrinsics.checkNotNull(r0);
        r1.a(r0, r5, new UserFieldsService$tryGetLocalFields$1(this, r4));
    }

    public static final c a(UserFieldsService r9, String r10, GetUserChatWindowFieldsResponse r11, boolean r12) {
        r9.getClass();
        ChatWindowFields r13 = (ChatWindowFields) r11.chat_window_fields.get(r10);
        if (r13 == null) goto L6;
        List<GetUserProfileResponse.Field> r14 = r13.field_orders;
        if (r14 == null) goto L6;
    L7:
        List r15 = r11.old_data_user_ids;
        if ((r15 instanceof Collection) == true) goto L10;
    L12:
        Iterator r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r10, (String) r16.next()) == false) goto L14;
        boolean r6 = true;
    L19:
        ArrayList<BaseField> r17 = ChatCoreModule.a().getProfileDependency().parseFields(r14);
        if (r17 == null) goto L29;
        List r18 = CollectionsKt.filterNotNull(r17);
        if (r18 == null) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator r19 = r18.iterator();
    L25:
        if (r19.hasNext() == false) goto L30;
        Object r3 = r19.next();
        BaseField r4 = (BaseField) r3;
        Lazy r5 = BaseFieldHandlers.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (((SparseArrayCompat) BaseFieldHandlers.a.getValue()).containsKey(r4.getFieldType()) == false) goto L25;
        r0.add(r3);
    L30:
        if (r0 == null) goto L34;
        BaseField r20 = (BaseField) CollectionsKt.firstOrNull(r0);
        if (r20 == null) goto L34;
        String r7 = BaseFieldHandlers.a(r20);
    L35:
        if (r0 == null) goto L39;
        BaseField r21 = (BaseField) CollectionsKt.getOrNull(r0, 1);
        if (r21 == null) goto L39;
        String r8 = BaseFieldHandlers.a(r21);
    L40:
        if (r12 == true) goto L43;
        if (r6 == false) goto L43;
        boolean r22 = true;
    L45:
        return new c(r10, r22, r6, r7, r8);
    L43:
        r22 = false;
    L39:
        r8 = null;
    L34:
        r7 = null;
    L29:
        r0 = null;
    L18:
        r6 = false;
        goto L19
    L10:
        if (r15.isEmpty() == false) goto L12;
    L6:
        r14 = CollectionsKt.emptyList();
        goto L7
    }
}
