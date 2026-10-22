package com.ss.android.lark.contact.base.service;

import android.app.Application;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.GetAddressBookContactListRequest;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.suite.lark.platform.component.dyres.DyResUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s {
    public static void a(final boolean r29, UIGetDataCallback r30) {
        String r3 = BuildConfig.FLAVOR;
        GetAddressBookContactListRequest.Builder r4 = new GetAddressBookContactListRequest.Builder();
        int r0 = l.a;
        if (UserSP.getInstance().contains("time_line_for_address_book_contacts") == false) goto L5;
        r4.timeline_mark(Long.valueOf(UserSP.getInstance().getLong("time_line_for_address_book_contacts", 0)));
    L5:
        boolean r1 = !((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
        Token r6 = ContactMobileUtils.a;
        ArrayList r8 = new ArrayList();
        Cursor r12 = sf7.a.a.query(LarkContext.getApplication().getContentResolver(), ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "data1", "display_name", "mimetype"}, null, null, null, ContactMobileUtils.a);     // Catch: Throwable -> L86 Exception -> L88
        if (r12 != null) goto L158;
        if (r12 == null) goto L10;
        r12.close();
    L10:
        r3 = BuildConfig.FLAVOR;
        r4 = r4;
        String r2 = null;
        int r7 = 0;
    L97:
        if (r8.isEmpty() == false) goto L100;
        r30.onSuccess(new a9b.b(new ArrayList(), new ArrayList()));
        return;
    L100:
        int r5 = l.a;
        int r9 = DyResUtils.a;
        Intrinsics.checkNotNullParameter("contact_config", "domainKey");
        Intrinsics.checkNotNullParameter("upload_contacts_max_num", "resKey");
        Application r10 = LarkContext.getApplication();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter("contact_config", "domainKey");
        Intrinsics.checkNotNullParameter("upload_contacts_max_num", "resKey");
        DyResUtils.b.a.getClass();
        if (DyResUtils.b.a.b == null) goto L103;
        String r13 = (String) ((HashMap) com.suite.lark.platform.component.dyres.a.b.b).get("contact_config");
    L104:
        if (r13 != null) goto L106;
    L109:
        boolean r11 = true;
    L110:
        if (r11 == false) goto L167;
    L135:
        String r14 = r2;
    L136:
        if (r14 != null) goto L138;
        String r15 = r3;
    L139:
        Log.i("ContactFeat", "upload_contacts_max_num: ".concat(r15));
        if (TextUtils.isEmpty(r15) == false) goto L172;
    L144:
        int r16 = 3000;
    L145:
        final List r17 = r8.subList(r7, Math.min(r8.size(), r16));
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L147:
        if (r19.hasNext() == false) goto L149;
        r18.add(((ContactMobileBean) r19.next()).getEmailOrPhoneE164());
        goto L147
    L149:
        GetAddressBookContactListRequest.Builder r20 = r4;
        r20.contact_points(r18);
        if (r29 == false) goto L152;
        r20.strategy(SyncDataStrategy.LOCAL);
    L152:
        SdkSender.asynSendRequestNonWrap(Command.GET_ADDRESS_BOOK_CONTACT_LIST, r20, r30, new r(r29, r17));
        return;
    L172:
        r16 = CastIntegerProtector.parseInt(r15);     // Catch: NumberFormatException -> L157
    L138:
        r15 = r14;
        goto L139
    L167:
        JSONObject r21 = new JSONObject(r13).optJSONObject(SRStrategy.MEDIAINFO_KEY_RESOLUTION);     // Catch: Exception -> L117
        if (r21 == null) goto L119;
        JSONObject r22 = r21.optJSONObject("upload_contacts_max_num");     // Catch: Exception -> L117
        if (r22 == null) goto L119;
        int r23 = DyResUtils.c.c;     // Catch: Exception -> L117
        String r110 = DyResUtils.c.a.a(r22);     // Catch: Exception -> L117
    L120:
        if (r110 == null) goto L135;
        int r24 = DyResUtils.a;
        if (Build.VERSION.SDK_INT < 24) goto L126;
        Locale r25 = r10.getResources().getConfiguration().getLocales().get(r7);
        if (r25 != null) goto L127;
        r25 = r10.getResources().getConfiguration().locale;
    L127:
        Intrinsics.checkNotNull(r25);
        String r26 = DyResUtils.a.a(r25);
        Intrinsics.checkNotNullParameter(r26, "i18nType");
        String r27 = (String) ((DyResUtils.c) r110).b.get(r26);
        if (r27 == null) goto L131;
        r14 = r27;
        goto L136
    L131:
        if (r110.getType() == 1) goto L135;
        String r28 = DyResUtils.a.a(Locale.US);
        Intrinsics.checkNotNullParameter(r28, "i18nType");
        r14 = (String) ((DyResUtils.c) r110).b.get(r28);
        if (r14 == null) goto L135;
    L126:
        r25 = r10.getResources().getConfiguration().locale;
    L119:
        r110 = r2;
    L117:
        e = move-exception;
        Log.e("DyResUtils", "parse json err", e);
        goto L119
    L106:
        if (r13.length() == 0) goto L109;
        r11 = false;
        goto L110
    L103:
        r13 = r2;
        goto L104
    L158:
        InvApmUtils.g("contact_opt_local_fetch_timing_ms");     // Catch: Throwable -> L81 Exception -> L84
        HashSet r111 = new HashSet();     // Catch: Throwable -> L81 Exception -> L84
        int r31 = r12.getColumnIndex("contact_id");     // Catch: Throwable -> L81 Exception -> L84
        int r112 = r12.getColumnIndex("data1");     // Catch: Throwable -> L81 Exception -> L84
        int r32 = r12.getColumnIndex("display_name");     // Catch: Throwable -> L81 Exception -> L84
        int r33 = r12.getColumnIndex("mimetype");     // Catch: Throwable -> L81 Exception -> L84
        String r113 = BuildConfig.FLAVOR;
        String r210 = r113;
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        Pair<Integer, String> r118 = null;
    L164:
        if (r12.moveToNext() == false) goto L76;
        r4 = r4;
        int r34 = r12.getInt(r31);     // Catch: Exception -> L74 Throwable -> L81
        int r211 = r31;
        String r35 = r12.getString(r33);     // Catch: Exception -> L74 Throwable -> L81
        int r212 = r33;
        String r36 = r12.getString(r112);     // Catch: Exception -> L74 Throwable -> L81
        if (TextUtils.isEmpty(r36) == false) goto L19;
    L72:
        r3 = r3;
        int r213 = r112;
    L69:
        Cursor r214 = r12;
    L73:
        r4 = r4;
        r31 = r211;
        r33 = r212;
        r112 = r213;
        r3 = r3;
        r1 = r1;
        r32 = r32;
        r12 = r214;
        goto L164
    L19:
        if (TextUtils.isEmpty(r36.replace(" ", r3)) == true) goto L72;
        r213 = r112;
        String r119 = r36.replace(" ", r3);     // Catch: Exception -> L74 Throwable -> L81
        if (r111.contains(r119) == false) goto L24;
        r3 = r3;
        goto L69
    L24:
        r3 = r3;
        if ("vnd.android.cursor.item/email_v2".equals(r35) == false) goto L36;
        r115 = r115 + 1;
    L33:
        th = th;
    L154:
        if (r12 == null) goto L156;
        r12.close();
    L156:
        throw th;
    L29:
        if (h9b.b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r119) == false) goto L69;
        r116 = r116 + 1;     // Catch: Throwable -> L33 Exception -> L70
        r111.add(r119);     // Catch: Throwable -> L33 Exception -> L70
        String r37 = r119;
        Pair<Integer, String> r38 = r118;
        r119 = r113;
        boolean r39 = true;
    L169:
        String r120 = r12.getString(r32);     // Catch: Exception -> L65 Throwable -> L81
        r32 = r32;
        if (TextUtils.isEmpty(r120) == true) goto L50;
        r36 = r120;
    L50:
        r214 = r12;
        int r121 = r114;
        Uri r40 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r34);     // Catch: Exception -> L61 Throwable -> L63
        if (r40 == null) goto L55;
        String r122 = Uri.withAppendedPath(r40, "photo").toString();     // Catch: Exception -> L61 Throwable -> L63
    L56:
        if (r39 == false) goto L58;
        ContactMobileBean r41 = new ContactMobileBean(r36, r122, r37);     // Catch: Exception -> L61 Throwable -> L63
    L59:
        r8.add(r41);     // Catch: Exception -> L61 Throwable -> L63
        r210 = r37;
        r113 = r119;
        r114 = r121;
        r118 = r38;
        goto L73
    L58:
        r41 = new ContactMobileBean(r36, r122, r119, r38);     // Catch: Exception -> L61 Throwable -> L63
        goto L59
    L55:
        r122 = null;
        goto L56
    L61:
        e = e;
    L67:
        int r123 = r121;
    L80:
        int r42 = r123;
        int r124 = r115;
        r12 = r214;
    L91:
        Log.e("ContactMobileUtils", e);     // Catch: Throwable -> L33
        if (r12 == null) goto L95;
        r114 = r42;
        r115 = r124;
    L94:
        r12.close();
        r42 = r114;
        r124 = r115;
    L95:
        int r43 = h9b.a.a;
        r7 = 0;
        InvApmUtils.e("contact_opt_cp_email_count", h9b.a.a(new Pair[]{Pair.create("count", Integer.valueOf(r124))}));
        InvApmUtils.e("contact_opt_cp_available_email_count", h9b.a.a(new Pair[]{Pair.create("count", Integer.valueOf(r116))}));
        InvApmUtils.e("contact_opt_cp_phone_count", h9b.a.a(new Pair[]{Pair.create("count", Integer.valueOf(r117))}));
        InvApmUtils.e("contact_opt_cp_available_phone_count", h9b.a.a(new Pair[]{Pair.create("count", Integer.valueOf(r42))}));
        InvApmUtils.e("contact_opt_cp_total_count", h9b.a.a(new Pair[]{Pair.create("count", Integer.valueOf(r124 + r117))}));
        InvApmUtils.e("contact_opt_cp_available_total_count", h9b.a.a(new Pair[]{Pair.create("count", Integer.valueOf(r116 + r42))}));
        Collections.sort(r8, new d9b.b());
        Intrinsics.checkNotNullParameter("contact_opt_local_fetch_timing_ms", "serviceName");
        r2 = null;
        InvApmUtils.b("contact_opt_local_fetch_timing_ms", null);
    L63:
        th = th;
    L83:
        r12 = r214;
    L65:
        e = e;
        r214 = r12;
        r121 = r114;
        goto L67
    L36:
        if ("vnd.android.cursor.item/phone_v2".equals(r35) == false) goto L69;
        r117 = r117 + 1;     // Catch: Exception -> L70 Throwable -> L81
        if (r1 == false) goto L40;
        int r44 = 1;
    L41:
        r118 = ContactMobileUtils.e(r44, r36);     // Catch: Exception -> L70 Throwable -> L81
        if (r118 == null) goto L69;
        r114 = r114 + 1;     // Catch: Exception -> L70 Throwable -> L81
        r111.add(r119);     // Catch: Exception -> L70 Throwable -> L81
        r38 = r118;
        r37 = r210;
        r39 = false;
        goto L169
    L40:
        r44 = 86;
    L70:
        e = e;
    L71:
        r214 = r12;
        r123 = r114;
    L74:
        e = e;
        r3 = r3;
        goto L71
    L76:
        r3 = r3;
        r4 = r4;
        goto L94
    L77:
        e = e;
        r3 = r3;
        r4 = r4;
    L81:
        th = th;
        r214 = r12;
    L84:
        e = e;
        r12 = r12;
    L90:
        r42 = 0;
        r124 = 0;
        r116 = 0;
        r117 = 0;
        goto L91
    L88:
        e = e;
        r12 = null;
    L86:
        th = th;
        r12 = null;
        goto L154
    }
}
