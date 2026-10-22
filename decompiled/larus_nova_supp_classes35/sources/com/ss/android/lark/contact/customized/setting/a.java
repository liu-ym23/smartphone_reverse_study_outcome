package com.ss.android.lark.contact.customized.setting;

import com.bytedance.lark.pb.settings.v1.DoubaoAddFriendSetting;
import com.bytedance.lark.pb.settings.v1.GetDoubaoAddFriendSettingResponse;
import com.bytedance.lark.pb.settings.v1.WayToAddFriendItem;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import com.ss.android.lark.officesdk.contact.api.model.OfficeContactSettingsItemAction;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mtb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r18) {
        GetDoubaoAddFriendSettingResponse r0 = (GetDoubaoAddFriendSettingResponse) GetDoubaoAddFriendSettingResponse.ADAPTER.decode(r18);
        Lazy r1 = DoubaoAddFriendSettingRepository.a;
        DoubaoAddFriendSetting r2 = r0.setting;
        HashMap r3 = new HashMap();
        if (r2 == null) goto L25;
        Map r4 = r2.way_to_add_friend_items;
        if (r4 == null) goto L25;
        Iterator r5 = r4.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) r5.next();
        Integer r8 = (Integer) r7.getKey();
        Boolean r9 = (Boolean) r7.getValue();
        Intrinsics.checkNotNull(r8);
        WayToAddFriendItem r10 = WayToAddFriendItem.fromValue(r8.intValue());
        if (r10 != null) goto L12;
        int r11 = -1;
    L13:
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L20;
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L18;
        DoubaoAddFriendSettingType r12 = null;
    L22:
        if (r12 == null) goto L8;
        r3.put(r12, r9);
        goto L8
    L18:
        r12 = DoubaoAddFriendSettingType.DOCUMENT;
        goto L22
    L19:
        r12 = DoubaoAddFriendSettingType.NAME_CARD;
        goto L22
    L20:
        r12 = DoubaoAddFriendSettingType.QR_CODE_AND_LINK;
        goto L22
    L21:
        r12 = DoubaoAddFriendSettingType.GROUP_CHAT;
        goto L22
    L12:
        r11 = DoubaoAddFriendSettingRepository.a.a[r10.ordinal()];
    L25:
        Enum[] r6 = DoubaoAddFriendSettingType.values();
        ArrayList r13 = new ArrayList();
        int r14 = r6.length;
        int r15 = 0;
    L26:
        if (r15 >= r14) goto L56;
        Enum r16 = r6[r15];
        Boolean r17 = (Boolean) r3.get(r16);
        if (r17 == null) goto L52;
        boolean r19 = r17.booleanValue();
        int[] r110 = DoubaoAddFriendSettingRepository.a.b;
        int r111 = r110[r16.ordinal()];
        if (r111 == 1) goto L39;
        if (r111 == 2) goto L38;
        if (r111 == 3) goto L37;
        if (r111 != 4) goto L36;
        String r112 = UIHelper.getString(2131890194);
    L40:
        Intrinsics.checkNotNullParameter(r16, IPortraitService.TYPE);
        int r113 = r110[r16.ordinal()];
        if (r113 == 1) goto L50;
        if (r113 == 2) goto L49;
        if (r113 == 3) goto L48;
        if (r113 != 4) goto L47;
        int r114 = 2131233639;
    L51:
        f r115 = new f(r16, r112, r114, r19, OfficeContactSettingsItemAction.TOGGLE);
    L53:
        if (r115 == null) goto L55;
        r13.add(r115);
    L55:
        r15 = r15 + 1;
        goto L26
    L47:
        throw new NoWhenBranchMatchedException();
    L48:
        r114 = 2131233638;
        goto L51
    L49:
        r114 = 2131233641;
        goto L51
    L50:
        r114 = 2131233640;
        goto L51
    L36:
        throw new NoWhenBranchMatchedException();
    L37:
        r112 = UIHelper.getString(2131890193);
        goto L40
    L38:
        r112 = UIHelper.getString(2131890192);
        goto L40
    L39:
        r112 = UIHelper.getString(2131890195);
        goto L40
    L52:
        r115 = null;
        goto L53
    L56:
        Log.i("Contact_AddFriendSetting", "getSetting success size=" + r13.size());
        return r13;
    }
}
